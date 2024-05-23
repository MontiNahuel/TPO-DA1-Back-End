package org.uade.da1.model.dao.vecino;

import org.uade.da1.model.entity.Vecino;

import java.util.List;

public interface IVecinoDAO {
    public List<Vecino> findAll();
    public Vecino findByDni(String dni);
    public void save(Vecino v); // Posible eliminacion tambien
    //public void deleteById(Vecino v); // Posible eliminacion
}
