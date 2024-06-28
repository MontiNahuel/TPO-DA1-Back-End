package org.uade.da1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uade.da1.model.entity.Personal;
import org.uade.da1.service.personal.PersonalService;

@RestController
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    PersonalService personalService;

    @GetMapping("/obtenerUno")
    public ResponseEntity<?> obtenerDatosPersonal(@RequestParam String legajo) {
        Personal personal = personalService.obtenerPersonalEspecifico(Integer.parseInt(legajo));
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }
}
