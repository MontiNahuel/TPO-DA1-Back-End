package org.uade.da1.service.vecino;

import org.uade.da1.model.entity.Vecino;

import java.util.List;

public interface IVecinoService {
    public List<Vecino> findAll();
    public Vecino buscarPorDni(String dni);
    public void save(Vecino v); // Posible eliminacion tambien
}
