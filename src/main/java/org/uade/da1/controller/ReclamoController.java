package org.uade.da1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uade.da1.controller.response.Response;
import org.uade.da1.model.entity.Reclamo;
import org.uade.da1.service.reclamo.ReclamoService;

import java.util.List;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodos() {
        List<Reclamo> reclamos;
        try {
            reclamos = reclamoService.obtenerTodos();
            if (reclamos.isEmpty()) {
                return new ResponseEntity<>(
                        new Response(
                                "No hay contenido para mostrar",
                                null,
                                HttpStatus.OK.value()
                        ),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(reclamos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(
                    new Response(
                            "Error al obtener los datos",
                            e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/especifico")
    public ResponseEntity<?> obtenerPorDocumento(@RequestParam String documento) {
        List<Reclamo> reclamos;
        try {
            reclamos = reclamoService.obtenerDeVecinoEspecifico(documento);
            //System.out.println(reclamos);
            if (reclamos.isEmpty()) {
                return new ResponseEntity<>(
                        new Response(
                                "No hay elementos para mostrar",
                                null,
                                HttpStatus.NO_CONTENT.value()
                        ),
                        HttpStatus.NO_CONTENT
                );
            }
            return new ResponseEntity<>(reclamos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(
                            "Error al obtener los reclamos",
                            e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}


