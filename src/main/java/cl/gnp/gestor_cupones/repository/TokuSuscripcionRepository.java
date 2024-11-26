package cl.gnp.gestor_cupones.repository;

import cl.gnp.gestor_cupones.model.entity.TokuSuscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokuSuscripcionRepository extends JpaRepository<TokuSuscripcion, String> {
}
