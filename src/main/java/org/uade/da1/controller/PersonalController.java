package org.uade.da1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uade.da1.service.personal.IPersonalService;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private IPersonalService personalService;

}
