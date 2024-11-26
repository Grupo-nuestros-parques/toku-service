package cl.gnp.gestor_cupones.service.impl;

import cl.gnp.gestor_cupones.model.entity.Cliente;
import cl.gnp.gestor_cupones.repository.ClienteRepository;
import cl.gnp.gestor_cupones.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente getClienteByRut(Integer rut) {
        return clienteRepository.findById(rut).orElse(null);
    }
}
