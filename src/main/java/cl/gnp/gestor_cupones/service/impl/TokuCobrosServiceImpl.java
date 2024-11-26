package cl.gnp.gestor_cupones.service.impl;

import cl.gnp.gestor_cupones.model.entity.TokuCobros;
import cl.gnp.gestor_cupones.repository.TokuCobrosRepository;
import cl.gnp.gestor_cupones.service.TokuCobrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokuCobrosServiceImpl implements TokuCobrosService {
    @Autowired
    TokuCobrosRepository tokuCobrosRepository;
    @Override
    public void insertToTokuCobros(TokuCobros tokuCobros) {
        tokuCobrosRepository.save(tokuCobros);
    }
}
