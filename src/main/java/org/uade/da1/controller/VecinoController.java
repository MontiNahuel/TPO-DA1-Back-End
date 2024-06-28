package org.uade.da1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uade.da1.controller.response.Response;
import org.uade.da1.model.entity.Vecino;
import org.uade.da1.service.vecino.IVecinoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vecinos")
public class VecinoController {
    @Autowired
    private IVecinoService vecinoService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Vecino> findAll() {
        return vecinoService.findAll();
    }

    @RequestMapping(value = "/findOne")
    public Vecino findOne(@RequestParam String id) {
        System.out.println(id);
        return vecinoService.buscarPorDni(id);
    }

    @RequestMapping("/coincidencias")
    public ResponseEntity<?> getVecinosPorNombre(@RequestParam String name) {
        List<Vecino> vecinos = vecinoService.buscarCoincidencias(name);
        if (vecinos.isEmpty()) {
            return new ResponseEntity<>(
                    vecinos,
                    HttpStatus.NO_CONTENT
            );
        } else {
            return new ResponseEntity<>(
                    vecinos,
                    HttpStatus.OK
            );
        }
    }
}
