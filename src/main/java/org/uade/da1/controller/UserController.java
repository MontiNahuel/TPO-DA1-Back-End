package org.uade.da1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uade.da1.model.dto.UserForProfile;
import org.uade.da1.service.user.IUserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/obtenerDatos")
    public ResponseEntity<?> obtenerDatosParaElPerfil(@RequestParam String id) {
        System.out.println(id);
        UserForProfile userForProfile = userService.obtenerDatosParaPerfil(id);
        System.out.println(userForProfile);
        return new ResponseEntity<>(userForProfile, HttpStatus.OK);
    }
}
