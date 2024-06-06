package org.uade.da1.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uade.da1.model.dto.DTOPersonal;
import org.uade.da1.model.dto.UserDTO;
import org.uade.da1.model.entity.User;
import org.uade.da1.service.user.IUserService;
import org.uade.da1.service.personal.IPersonalService;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final int EXPIRATION_TIME_IN_MIN = 300;

    @Autowired
    private IUserService usuarioService;

    @Autowired
    private IPersonalService personalService;

    @Autowired
    private SecretKey secretKey; // Inyecta la clave secreta

    @PostMapping("/login/vecino")
    public ResponseEntity<String> loginVecino(@RequestBody UserDTO credentials) {
        System.out.println(credentials);
        // Validar las credenciales aquí (puedes usar Spring Security u otros
        // mecanismos)
        if (usuarioService.findUser(credentials.getUserName(), credentials.getPassword()) != null) {
            // Crear el token JWT
            String token = Jwts.builder().setSubject(credentials.getUserName()).setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MIN * 60 * 1000))
                    .signWith(secretKey, SignatureAlgorithm.HS256).compact();
            System.out.println(token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenciales inválidas.", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register") //Eliminar al final
    public ResponseEntity<String> register(@RequestBody UserDTO credenciales) {
        System.out.println(credenciales);
        if (usuarioService.existeUsuario(credenciales.getUserName())) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User usuario = new User();
            System.out.println(credenciales.getUserName());
            System.out.println(credenciales.getPassword());
            usuario.setUser(credenciales.getUserName());
            System.out.println(usuario.getUser());
            String hashedPassword = passwordEncoder.encode(credenciales.getPassword());
            usuario.setPassword(hashedPassword);
            usuarioService.save(usuario);
            return new ResponseEntity<>("Usuario registrado correctamente.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Usuario ya registrado.", HttpStatus.CONFLICT);
    }

    @PostMapping("/verificacion")
    public ResponseEntity<String> verificacionDeSesion() {
        return new ResponseEntity<>("Estas con sesion iniciada", HttpStatus.OK);
    }

    @PostMapping("login/personal")
    public ResponseEntity<String> loginPersonal(@RequestBody DTOPersonal credencialesPersonal) {
        if(Objects.isNull(personalService.obtenerEspecifico(credencialesPersonal.getLegajo(), credencialesPersonal.getPassword()))) {
            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
        } else {
            String legajo = Integer.toString(credencialesPersonal.getLegajo());
            String token = Jwts.builder().setSubject(legajo).setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MIN * 60 * 1000))
                    .signWith(secretKey, SignatureAlgorithm.HS256).compact();
            System.out.println(token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
    }

}

