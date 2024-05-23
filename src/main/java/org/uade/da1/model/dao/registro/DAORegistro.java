package org.uade.da1.model.dao.registro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.uade.da1.model.entity.Personal;
import org.uade.da1.model.entity.Registro;

import java.util.Objects;

@Repository
public class DAORegistro implements IDAORegistro {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional (readOnly = true)
    public boolean getByDNI(String dni) {
        Session currentSesion = entityManager.unwrap(Session.class);
        Query<Registro> query = currentSesion.createQuery("FROM Registro WHERE dni=:dni", Registro.class);
        query.setParameter("dni", dni);
        Registro registro = query.uniqueResult();

        return !Objects.isNull(registro);
    }

    @Override
    @Transactional
    public void save(Registro r) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(r);
    }

}
