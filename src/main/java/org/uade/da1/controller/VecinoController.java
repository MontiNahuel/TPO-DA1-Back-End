package org.uade.da1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.uade.da1.model.entity.Vecino;
import org.uade.da1.service.vecino.IVecinoService;

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
}
