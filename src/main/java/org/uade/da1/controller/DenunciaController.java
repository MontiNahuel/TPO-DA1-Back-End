package org.uade.da1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uade.da1.controller.response.Response;
import org.uade.da1.model.entity.Denuncia;
import org.uade.da1.service.denuncia.DenunciaService;

import java.util.List;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @GetMapping("/obtenerPorDoc")
    public ResponseEntity<?> obtenerPorDocumento(@RequestParam String doc) {
        List<Denuncia> denuncias;

        try {
            denuncias = denunciaService.obtenerPorDocumento(doc);
            System.out.println(denuncias);
            if (denuncias.isEmpty()) {
                return new ResponseEntity<>(
                        new Response(
                                "No hay contenido para mostrar",
                                null,
                                HttpStatus.NO_CONTENT.value()),
                        HttpStatus.OK
                );
            }
            return new ResponseEntity<>(denuncias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(
                            "No se pudo obtener el contenido indicado",
                            e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
