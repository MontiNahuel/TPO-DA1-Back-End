package org.uade.da1.service.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.uade.da1.model.dao.personal.IDAOPersonal;
import org.uade.da1.model.dto.DTOPersonal;
import org.uade.da1.model.entity.Personal;
import org.uade.da1.repository.PersonalRepository;

import java.util.Objects;

@Service
public class PersonalService implements IPersonalService{

    @Autowired
    private IDAOPersonal daoPersonal;
    @Autowired
    private PersonalRepository personalRepository;

    @Override
    public Personal obtenerEspecifico(int legajo, String password) {
        return daoPersonal.getOne(legajo, password);
    }

    private DTOPersonal personalToDto(Personal p) {
        return new DTOPersonal(
                p.getLegajo(),
                p.getNombre(),
                p.getApellido(),
                p.getSector(),
                p.getDocumento()
        );
    }

    public Personal obtenerPersonalEspecifico(Integer legajo) {
        return personalRepository.findByLegajo(legajo);
    }
}
