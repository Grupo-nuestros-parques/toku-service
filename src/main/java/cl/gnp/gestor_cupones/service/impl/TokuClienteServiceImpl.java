package cl.gnp.gestor_cupones.service.impl;

import cl.gnp.gestor_cupones.model.entity.TokuCliente;
import cl.gnp.gestor_cupones.repository.TokuClienteRepository;
import cl.gnp.gestor_cupones.service.TokuClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokuClienteServiceImpl implements TokuClienteService {
    @Autowired
    TokuClienteRepository tokuClienteRepository;
    @Override
    public void insertNewTokuCliente(TokuCliente tokuCliente) {
        tokuClienteRepository.save(tokuCliente);
    }
}
