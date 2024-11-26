package cl.gnp.gestor_cupones.repository;

import cl.gnp.gestor_cupones.model.entity.ApiCupones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiCuponesRepository extends JpaRepository<ApiCupones, String> {
    List<ApiCupones> findCuponesByRutAndTipoDocumentoInAndNumeroCliente(String rut, List<Integer> tipoDocumento, String numeroCliente);
}
