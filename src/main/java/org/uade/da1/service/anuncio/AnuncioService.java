package org.uade.da1.service.anuncio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uade.da1.model.entity.Anuncio;
import org.uade.da1.repository.AnuncioRepository;

import java.util.List;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    public List<Anuncio> obtenerTodos() {
        return anuncioRepository.findAllByOrderByFechacreacionDesc();
    }

    public List<Anuncio> obtenerAnunciosPorVecino(String id) {
        return anuncioRepository.findByDnivecino(id);
    }

    public Anuncio obtenerPorId(int id) {
        return anuncioRepository.findByIdanuncio(id);
    }

}
