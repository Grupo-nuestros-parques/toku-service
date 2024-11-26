package cl.gnp.gestor_cupones.service.impl;

import cl.gnp.gestor_cupones.model.entity.TokuSuscripcion;
import cl.gnp.gestor_cupones.repository.TokuSuscripcionRepository;
import cl.gnp.gestor_cupones.service.TokuSuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokuSuscripcionServiceImpl implements TokuSuscripcionService {
    @Autowired
    TokuSuscripcionRepository tokuSuscripcionRepository;
    @Override
    public void insertTokuSubscription(TokuSuscripcion tokuSuscripcion) {
        tokuSuscripcionRepository.save(tokuSuscripcion);
    }
}
