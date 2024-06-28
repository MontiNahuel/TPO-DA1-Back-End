package org.uade.da1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uade.da1.model.entity.Anuncio;

import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
    List<Anuncio> findByDnivecino(String dni);
    List<Anuncio> findAllByOrderByFechacreacionDesc();
    Anuncio findByIdanuncio(int id);
}
