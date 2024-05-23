package org.uade.da1.model.dao.vecino;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.uade.da1.model.entity.User;
import org.uade.da1.model.entity.Vecino;

import java.util.List;

@Repository
public class VecinoDAO implements IVecinoDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true) //Posible eliminacion
    public List<Vecino> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Vecino> getQuery = currentSession.createQuery("from Vecino", Vecino.class);
        List<Vecino> vecinos = getQuery.getResultList();

        return vecinos;
    }

    @Override
    @Transactional(readOnly = true)
    public Vecino findByDni(String dni) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Vecino> query = currentSession.createQuery("FROM Vecino WHERE dni=:documento", Vecino.class);
        query.setParameter("documento", dni);
        Vecino v = query.uniqueResult();
        //Vecino vecino = currentSession.get(Vecino.class, dni);
        System.out.println(v);
        return v;
    }

    @Override
    public void save(Vecino v) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(v);
    }
}
