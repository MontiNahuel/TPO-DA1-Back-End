package org.uade.da1.service.registro;

import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uade.da1.model.dao.registro.IDAORegistro;
import org.uade.da1.model.entity.Registro;

@Service
public class RegistroService implements IRegistroService {

    @Autowired
    private IDAORegistro daoRegistro;

    @Override
    public boolean estaRegistrado(String dni) {
        return daoRegistro.getByDNI(dni);
    }

    @Override
    public boolean registrar(Registro r) throws Exception {
        try {
            if (daoRegistro.getByEmail(r.getEmail())) {
                return false;
            } else {
                daoRegistro.save(r);
                return true;
            }
        } catch (Exception e) {
            throw new Exception("Error en el sistema", e);
        }
    }
}
