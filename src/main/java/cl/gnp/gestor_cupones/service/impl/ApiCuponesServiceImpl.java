package cl.gnp.gestor_cupones.service.impl;

import cl.gnp.gestor_cupones.model.dto.*;
import cl.gnp.gestor_cupones.model.entity.ApiCupones;
import cl.gnp.gestor_cupones.model.entity.ClienteRezago;
import cl.gnp.gestor_cupones.model.entity.TokuCliente;
import cl.gnp.gestor_cupones.model.entity.TokuSuscripcion;
import cl.gnp.gestor_cupones.model.response.CuotasOtrosResponse;
import cl.gnp.gestor_cupones.repository.ApiCuponesRepository;
import cl.gnp.gestor_cupones.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class ApiCuponesServiceImpl implements ApiCuponesService {
    @Autowired
    ApiCuponesRepository apiCuponesRepository;
    @Autowired
    WebClient.Builder webClientBuilder;
    @Autowired
    ClienteService clienteService;
    @Value("${IMLF_API_KEY}")
    String IMLF_API_KEY;
    @Value("${IMLF_PESO_ACC}")
    String IMLF_PESO_ACC;

    @Autowired
    TokuClienteService tokuClienteService;
    @Autowired
    TokuSuscripcionService tokuSuscripcionService;
    @Autowired
    TokuCobrosService tokuCobrosService;
    @Autowired
    ClienteRezagoService clienteRezagoService;

    @Override
    public List<ApiCupones> getCuponesParaToku(String rut, String contrato) {
        String rutNormalized = "";
        if (rut != null && !rut.isEmpty()) {
            rutNormalized = rut.substring(0, rut.length() - 1);
        }
        String url = "https://pagosqa.nuestrosparques.cl/cuotas_otros.php?rut=" + rutNormalized;
        List<CuotasOtrosResponse> cuotasResponse = getCuotasOtrosData(url).collectList().onErrorResume(e -> Mono.just(Collections.emptyList())).block();
        List<Integer> tipoDocumentoList = Arrays.asList(3, 7);
        List<ApiCupones> apiCuponesResponse = apiCuponesRepository.findCuponesByRutAndTipoDocumentoInAndNumeroCliente(rut, tipoDocumentoList, contrato);
        ClienteRezago clienteRezago = clienteRezagoService.getDataClienteRezago(Integer.parseInt(rutNormalized));

        TokuCustomerRequestDTO tokuCustomerRequestDTO = new TokuCustomerRequestDTO();
        tokuCustomerRequestDTO.setName(clienteRezago.getNombre());
        tokuCustomerRequestDTO.setMail("");
        tokuCustomerRequestDTO.setSend_mail(false);
        tokuCustomerRequestDTO.setExternalId(contrato);
        tokuCustomerRequestDTO.setGovernmentId(rut);
        tokuCustomerRequestDTO.setPhoneNumber("+" + clienteRezago.getTelefonoPart());

        TokuCustomerResponseDTO responseCustomer = sendPostRequestToCustomer(tokuCustomerRequestDTO).onErrorResume(e -> {
            System.out.println("Error en la llamada a la API: " + e.getMessage());
            return Mono.empty();
        }).block();

        if (responseCustomer != null) {
            TokuCliente clienteToku = new TokuCliente();
            clienteToku.setIdToku(responseCustomer.getId());
            clienteToku.setaPaterno(clienteRezago.getApPaterno());
            clienteToku.setaMaterno(clienteRezago.getApMaterno());
            clienteToku.setNombres(clienteRezago.getNombre());
            clienteToku.setIdCliente(responseCustomer.getExternalId());
            clienteToku.setIdExterno(responseCustomer.getGovernmentId());
            clienteToku.setMandatoPac(responseCustomer.getPacMandateId());
            clienteToku.setAgente(responseCustomer.getDefaultAgent());
            clienteToku.setCelular(clienteRezago.getTelefonoPart());
            clienteToku.setCodParque(clienteRezago.getCodParque());
            //clienteToku.setMovimientosInscritos();
            clienteToku.setNumeroAgente(responseCustomer.getAgentPhoneNumber());
            tokuClienteService.insertNewTokuCliente(clienteToku);

            if(clienteToku.getIdToku() != null && !Objects.equals(clienteToku.getIdToku(), "")){
                TokuSubscriberRequestDTO tokuSubscriberRequestDTO = new TokuSubscriberRequestDTO();
                tokuSubscriberRequestDTO.setCustomer(clienteToku.getIdToku());
                tokuSubscriberRequestDTO.setProductId(contrato);
                tokuSubscriberRequestDTO.setPacMandateId(contrato);
                TokuSubscriberResponseDTO tokuSubscriberResponseDTO = sendPostRequestToSubscribe(tokuSubscriberRequestDTO).onErrorResume(e->{
                    System.out.println("Error al solicitar suscripción");
                    return Mono.empty();
                }).block();

                if(tokuSubscriberResponseDTO != null){
                    TokuSuscripcion tokuSuscripcion = new TokuSuscripcion();
                    tokuSuscripcion.setCliente(tokuSubscriberResponseDTO.getCustomer());
                    tokuSuscripcion.setIdProducto(tokuSubscriberResponseDTO.getProductId());
                    tokuSuscripcion.setMandatoPac(tokuSubscriberResponseDTO.getPacMandateId());
                    tokuSuscripcionService.insertTokuSubscription(tokuSuscripcion);

                    if(tokuSuscripcion.getCliente()!=null && !apiCuponesResponse.isEmpty()){
                        TokuInvoiceDTO tokuInvoiceDTORequest = new TokuInvoiceDTO();
                        StringBuilder stringBuilder = new StringBuilder();
                        for (ApiCupones e : apiCuponesResponse) {
                            tokuInvoiceDTORequest.setCostumer(clienteToku.getIdToku());
                            tokuInvoiceDTORequest.setProductId(e.getNumeroCliente());
                            tokuInvoiceDTORequest.setPaid(false);
                            tokuInvoiceDTORequest.setVoid(false);
                            tokuInvoiceDTORequest.setAmount(e.getMontoTotal());
                            String annio = e.getFechaVencimiento().substring(0, 4);
                            String mes = e.getFechaVencimiento().substring(4, 6);
                            String dia = e.getFechaVencimiento().substring(6, 8);

                            LocalDate fechaVenc = LocalDate.of(Integer.parseInt(annio), Integer.parseInt(mes),Integer.parseInt(dia));
                            tokuInvoiceDTORequest.setDueDate(fechaVenc);
                            tokuInvoiceDTORequest.setInvoiceExternalId(String.valueOf(e.getNumeroDocumento()));

                        }

                    }
                }

            }
        }

        //        if (customer != null) {
//            try {
//                TokuCliente clienteToku = new TokuCliente();
//                customer.subscribe(data -> {
//                    clienteToku.setIdToku(data.getId());
//                    clienteToku.setaPaterno(clienteRezago.getApPaterno());
//                    clienteToku.setaMaterno(clienteRezago.getApMaterno());
//                    clienteToku.setNombres(clienteRezago.getNombre());
//                    clienteToku.setIdCliente(data.getExternalId());
//                    clienteToku.setIdExterno(data.getGovernmentId());
//                    clienteToku.setMandatoPac(data.getPacMandateId());
//                    clienteToku.setAgente(data.getDefaultAgent());
//                    clienteToku.setCelular(clienteRezago.getTelefonoPart());
//                    clienteToku.setCodParque(clienteRezago.getCodParque());
//                    //clienteToku.setMovimientosInscritos();
//                    clienteToku.setNumeroAgente(data.getAgentPhoneNumber());
//                    tokuClienteService.insertNewTokuCliente(clienteToku);
//                });
        //System.out.println("Insert realizado");
//                if (clienteToku.getIdToku() != null) {
//                    TokuSubscriberResponseDTO subscriberDTO = new TokuSubscriberResponseDTO();
//                    subscriberDTO.setCustomer(clienteToku.getIdToku());
//                    subscriberDTO.setProductId(cuponesPie.getFirst().getNumeroCliente());
//                    subscriberDTO.setPacMandateId(cuponesPie.getFirst().getNumeroCliente());
//                    Mono<TokuSubscriberResponseDTO> suscriber = sendPostRequestToSubscribe(subscriberDTO);
//                    if (suscriber != null) {
//                        TokuSuscripcion suscripcionToku = new TokuSuscripcion();
//                        suscriber.subscribe(data -> {
//                            suscripcionToku.setCliente(data.getCustomer());
//                            suscripcionToku.setMandatoPac(data.getPacMandateId());
//                            suscripcionToku.setIdProducto(data.getProductId());
//                            tokuSuscripcionService.insertTokuSubscription(suscripcionToku);
//                        });
//                    }
//                    System.out.println("suscriber complete");
//                    if (suscriber != null) {
//                        cuponesPie.forEach(item -> {
//                            TokuInvoiceDTO tokuInvoiceDTO = new TokuInvoiceDTO();
//                            tokuInvoiceDTO.setProductId(item.getNumeroCliente());
//                            tokuInvoiceDTO.setCostumer(clienteToku.getIdToku());
//                            tokuInvoiceDTO.setAmount(item.getMontoTotal());
//                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                            ParsePosition position = new ParsePosition(0);
//                            tokuInvoiceDTO.setDueDate(sdf.parse(item.getFechaVencimiento(), position));
//                            TokuMetadataDTO tokuMetadataDTO = new TokuMetadataDTO();
//                            tokuMetadataDTO.setRut(item.getRut());
//                            tokuMetadataDTO.setInteres(item.getInteres());
//                            tokuMetadataDTO.setCobranza(item.getCobranzaExterna());
//                            tokuInvoiceDTO.setMetadata(tokuMetadataDTO);
//
//                            Mono<TokuInvoiceDTO> invoice = sendPostRequestToInvoice(tokuInvoiceDTO);
//                            invoice.subscribe(data -> {
//                                TokuCobros tokuCobros = new TokuCobros();
//                                tokuCobros.setCliente(data.getCostumer());
//                                tokuCobros.setIdProducto(item.getNumeroCliente());
//                                tokuCobros.setCupon(item.getNumeroDocumento());
//                                tokuCobros.setFechaVencimiento(data.getDueDate());
//                                tokuCobros.setMonto(data.getAmount());
//                                tokuCobros.setIdCobroToku(data.getId());
//                                tokuCobros.setTipoMov(item.getTipoDocumento());
//                                tokuCobrosService.insertToTokuCobros(tokuCobros);
//                            });
//                        });
//                    }
//                    System.out.println("Proceso completado... Revisar las tablas para comprobar insert");
//                }
//            } catch (Exception e) {
//                System.out.println("error al insertar = " + e);
//            }
        return apiCuponesResponse;
//        } else {
//            return Collections.emptyList();
//        }
    }

    private static TokuCustomerRequestDTO getTokuCustomerDTO(List<ApiCupones> cuponesPie, ClienteRezago cliente, String rut) {
        TokuCustomerRequestDTO tokuCustomerRequestDTO = new TokuCustomerRequestDTO();
        tokuCustomerRequestDTO.setExternalId(cuponesPie.getFirst().getNumeroCliente());
        tokuCustomerRequestDTO.setName(cliente.getNombre() + " " + cliente.getApPaterno() + " " + cliente.getApMaterno());
        tokuCustomerRequestDTO.setSend_mail(false);
        String fono = cliente.getTelefonoPart().replaceAll("[^0-9]", "");
        tokuCustomerRequestDTO.setPhoneNumber(fono);
        tokuCustomerRequestDTO.setGovernmentId(rut);
        return tokuCustomerRequestDTO;
    }

    public Flux<CuotasOtrosResponse> getCuotasOtrosData(String url) {
        return webClientBuilder.baseUrl(url)
                .build()
                .get()
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> {
                    return Mono.error(new RuntimeException("Error en la respuesta del servidor"));
                })
                .bodyToMono(String.class)
                .flatMapMany(response -> {

                    if (response.startsWith("<")) {
                        return Flux.just();
                    } else {
                        try {
                            CuotasOtrosResponse[] responseArray = new ObjectMapper().readValue(response, CuotasOtrosResponse[].class);
                            return Flux.fromArray(responseArray);
                        } catch (JsonProcessingException e) {
                            return Mono.error(new RuntimeException("Error al deserializar el JSON"));
                        }
                    }
                });
    }

    public Mono<TokuCustomerResponseDTO> sendPostRequestToCustomer(TokuCustomerRequestDTO tokuCustomerRequestDTO) {

        return webClientBuilder.baseUrl("https://api.trytoku.com/customers")
                .build()
                .post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("x-api-key", IMLF_API_KEY)
                .bodyValue(tokuCustomerRequestDTO)
                .retrieve()
                .bodyToMono(TokuCustomerResponseDTO.class);
    }

    public Mono<TokuSubscriberResponseDTO> sendPostRequestToSubscribe(TokuSubscriberRequestDTO tokuSubscriberRequestDTO) {
        return webClientBuilder.baseUrl("https://api.trytoku.com/subscriptions")
                .build()
                .post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("x-api-key", IMLF_API_KEY)
                .header("x-account-key", IMLF_PESO_ACC)
                .bodyValue(tokuSubscriberRequestDTO)
                .retrieve()
                .bodyToMono(TokuSubscriberResponseDTO.class);
    }

    public Mono<TokuInvoiceDTO> sendPostRequestToInvoice(TokuInvoiceDTO tokuInvoiceDTO) {
        return webClientBuilder.baseUrl("https://api.trytoku.com/invoices")
                .build()
                .post()
                .bodyValue(tokuInvoiceDTO)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("x-api-key", IMLF_API_KEY)
                .header("x-account-key", IMLF_PESO_ACC)
                .retrieve()
                .bodyToMono(TokuInvoiceDTO.class);
    }
}
