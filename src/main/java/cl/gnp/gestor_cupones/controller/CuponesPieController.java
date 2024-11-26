package cl.gnp.gestor_cupones.controller;

import cl.gnp.gestor_cupones.model.entity.ApiCupones;
import cl.gnp.gestor_cupones.model.response.CuotasOtrosResponse;
import cl.gnp.gestor_cupones.model.response.TokuResponse;
import cl.gnp.gestor_cupones.service.ApiCuponesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CuponesPieController {

    @PostMapping("/pie")
    public ResponseEntity<?> sendCuponesPieToToku(@RequestParam("rut") String rut, @RequestParam("contrato") String contrato){
        apiCuponesService.getCuponesParaToku(rut, contrato);
        return ResponseEntity.ok("Llega al controller");
    }

    @Autowired
    ApiCuponesService apiCuponesService;

    @PostMapping("/pago-pie")
    public ResponseEntity<?> getCuponesOtros(@RequestParam("rut") String rut, @RequestParam("contrato") String contrato){
        List<ApiCupones> cuponesRes = apiCuponesService.getCuponesParaToku(rut, contrato);
        if(!cuponesRes.isEmpty()){
            return ResponseEntity.status(200).body(cuponesRes);
        }
        return ResponseEntity.status(500).body("Error en la solicitud");
    }

}
