package cl.gnp.gestor_cupones.repository;

import cl.gnp.gestor_cupones.model.embeddable.ICuponerasDetalleWeb;
import cl.gnp.gestor_cupones.model.entity.CuponerasDetalleWeb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuponerasDetalleWebRepository extends JpaRepository<CuponerasDetalleWeb, ICuponerasDetalleWeb> {
}
