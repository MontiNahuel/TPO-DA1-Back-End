package org.uade.da1.model.dao.registro;

import org.uade.da1.model.entity.Registro;

public interface IDAORegistro {
    public boolean getByDNI(String dni);
    public void save(Registro r);
}
