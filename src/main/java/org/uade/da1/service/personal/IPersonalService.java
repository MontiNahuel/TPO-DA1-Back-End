package org.uade.da1.service.personal;

import org.uade.da1.model.entity.Personal;

public interface IPersonalService {
    public Personal  obtenerEspecifico(int legajo, String password);
}
