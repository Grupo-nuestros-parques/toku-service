package cl.gnp.gestor_cupones.repository;

import cl.gnp.gestor_cupones.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
