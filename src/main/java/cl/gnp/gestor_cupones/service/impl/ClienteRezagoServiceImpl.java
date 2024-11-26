package cl.gnp.gestor_cupones.service.impl;

import cl.gnp.gestor_cupones.model.entity.ClienteRezago;
import cl.gnp.gestor_cupones.repository.ClienteRezagoRepository;
import cl.gnp.gestor_cupones.service.ClienteRezagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClienteRezagoServiceImpl implements ClienteRezagoService {
    @Autowired
    ClienteRezagoRepository clienteRezagoRepository;
    @Override
    public ClienteRezago getDataClienteRezago(Integer rut) {
        return clienteRezagoRepository.findById(rut).orElse(null);
    }
}
