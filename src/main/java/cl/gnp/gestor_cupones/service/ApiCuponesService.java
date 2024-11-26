package cl.gnp.gestor_cupones.service;

import cl.gnp.gestor_cupones.model.entity.ApiCupones;
import cl.gnp.gestor_cupones.model.response.CuotasOtrosResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ApiCuponesService {
    List<ApiCupones> getCuponesParaToku(String rut, String contrato);
}
