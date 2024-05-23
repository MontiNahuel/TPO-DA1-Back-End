package org.uade.da1.model.dao.personal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.uade.da1.model.entity.Personal;
import org.uade.da1.model.entity.User;

import java.util.Objects;

@Repository
public class DAOPersonal implements IDAOPersonal{

    @PersistenceContext
    private EntityManager entity;

    @Override
    @Transactional (readOnly = true)
    public Personal getOne(int legajo, String password) {
        Session currentSesion = entity.unwrap(Session.class);
        Query<Personal> query = currentSesion.createQuery("FROM Personal WHERE legajo=:legajo", Personal.class);
        query.setParameter("legajo", legajo);
        Personal personal = query.uniqueResult();

        if (personal != null && checkPassword(password, personal.getPassword())) {
            return personal;
        } else {
            return null;
        }
    }

    private boolean checkPassword(String password, String passwordDB) {
        return Objects.equals(password, passwordDB);
    }

}
