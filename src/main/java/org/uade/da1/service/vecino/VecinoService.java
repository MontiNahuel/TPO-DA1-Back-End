package org.uade.da1.service.vecino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uade.da1.model.entity.Vecino;
import org.uade.da1.model.dao.vecino.IVecinoDAO;

import java.util.List;

@Service
public class VecinoService implements IVecinoService{

    @Autowired
    private IVecinoDAO vecinoDAO;
    @Override
    public List<Vecino> findAll() {
        List<Vecino> vecinos = vecinoDAO.findAll();
        return vecinos;
    }

    @Override
    public Vecino buscarPorDni(String dni) {
        Vecino vecino = vecinoDAO.findByDni(dni);
        return vecino;
    }

    @Override
    public void save(Vecino v) {
        vecinoDAO.save(v);
    }
}
