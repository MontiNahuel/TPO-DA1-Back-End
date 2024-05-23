package org.uade.da1.service.registro;

import org.uade.da1.model.entity.Registro;

public interface IRegistroService {
    public boolean estaRegistrado(String dni);

    public void registrar(Registro r);
}
