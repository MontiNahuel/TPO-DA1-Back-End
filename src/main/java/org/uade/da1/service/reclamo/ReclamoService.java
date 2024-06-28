package org.uade.da1.service.reclamo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uade.da1.model.entity.Reclamo;
import org.uade.da1.repository.ReclamoRepository;

import java.util.List;

@Service
public class ReclamoService {

    @Autowired
    private ReclamoRepository reclamoRepository;

    public List<Reclamo> obtenerTodos() {
        return reclamoRepository.findAll();
    }

    public List<Reclamo> obtenerDeVecinoEspecifico(String id) {
        return reclamoRepository.findByDocumento(id);
    }
}
