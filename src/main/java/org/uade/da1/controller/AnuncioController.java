package org.uade.da1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uade.da1.model.entity.Anuncio;
import org.uade.da1.repository.AnuncioRepository;
import org.uade.da1.service.anuncio.AnuncioService;

import java.util.List;

@RestController
@RequestMapping("/anuncios")
public class AnuncioController {
    @Autowired
    private AnuncioService anuncioService;

    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodos() {
        List<Anuncio> anuncios = anuncioService.obtenerTodos();
        System.out.println(anuncios);
        return new ResponseEntity<>(anuncios, HttpStatus.OK);
    }
}
