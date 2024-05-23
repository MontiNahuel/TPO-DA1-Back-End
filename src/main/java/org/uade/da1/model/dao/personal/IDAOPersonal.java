package org.uade.da1.model.dao.personal;

import org.uade.da1.model.entity.Personal;

public interface IDAOPersonal {
    public Personal getOne(int legajo, String password);
}
