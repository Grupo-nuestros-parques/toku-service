package cl.gnp.gestor_cupones.repository;

import cl.gnp.gestor_cupones.model.entity.TokuCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokuClienteRepository extends JpaRepository<TokuCliente, String> {
}
