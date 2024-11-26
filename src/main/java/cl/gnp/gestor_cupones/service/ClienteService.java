package cl.gnp.gestor_cupones.service;

import cl.gnp.gestor_cupones.model.entity.Cliente;
import cl.gnp.gestor_cupones.repository.ClienteRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente getClienteByRut(Integer rut);
}
