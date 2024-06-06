package org.uade.da1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uade.da1.model.dao.registro.IDAORegistro;
import org.uade.da1.model.dto.UserDTO;
import org.uade.da1.model.entity.Registro;
import org.uade.da1.service.registro.IRegistroService;
import org.uade.da1.service.user.IUserService;
import org.uade.da1.service.vecino.IVecinoService;

@RestController
@RequestMapping("/registro")
public class RegisterController {
    //Validar que el email sea correcto -> Front end
    //Validar que el vecino que se quiera registrar no esté registrado ya

    @Autowired
    private IRegistroService registroService;

    @Autowired
    private IVecinoService vecinoService;

    @Autowired
    private IUserService usuarioService;

    @PostMapping("/verificacion") //Modificar retorno
    public ResponseEntity<String> verificarSiEsVecino(@RequestParam String dni) {
        System.out.println("DNI:" + dni);
        // Verifica si es vecino del municipio
        // Si lo es, se fija si ya esta inscripto
        if (!usuarioService.existeUsuario(dni)) {
            return new ResponseEntity<>("El vecino ya tiene una cuenta", HttpStatus.UNAUTHORIZED);
        }
        if (vecinoService.buscarPorDni(dni) == null) {
            return new ResponseEntity<>("El vecino no forma parte del municipio", HttpStatus.UNAUTHORIZED);
        } else {
            if (registroService.estaRegistrado(dni)) {
                return new ResponseEntity<>("El vecino ya tiene un registro en curso", HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>("El vecino se puede registrar", HttpStatus.OK);
            }
        }
    }

    @PostMapping("/completarRegistro") //Modificar endpoint
    public ResponseEntity<String> inscripcionVecino(@RequestBody Registro r) {
        try {
            if (!registroService.registrar(r)) {
                return new ResponseEntity<>("El email proporcionado ya esta en uso", HttpStatus.OK);
            }
            return new ResponseEntity<>("Vecino inscripto para registro correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error en el registro del vecino", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
