package org.uade.da1.model.dao.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.uade.da1.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO {

    @PersistenceContext
    private EntityManager entity;

    @Override
    @Transactional(readOnly = true)
    public User findUser(String user, String password) {
        System.out.println("Imprimiendo credenciales: " + user + password);
        Session currentSesion = entity.unwrap(Session.class);
        Query<User> query = currentSesion.createQuery("FROM User WHERE username=:username", User.class);
        query.setParameter("username", user);

        User usuario = query.uniqueResult();
        System.out.println("1" + usuario);
        if (usuario != null && checkPasswordV2(password, usuario.getPassword())) {
            System.out.println("Chequeo pass");
            return usuario;
        } else {
            return null;
        }
    }

    private boolean checkPassword(String password, String passwordDB) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        boolean esIgual = passwordEncoder.matches(passwordDB, hashedPassword);
        System.out.println("Password ingresada: " + hashedPassword + " | PasswordDB: " + passwordDB);
        System.out.println(esIgual);
        return esIgual;
    }

    private boolean checkPasswordV2(String password, String passwordDB) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println("Password: " + password);
        System.out.println("hashedPassword: " + hashedPassword);
        System.out.println("passwordDB: " + passwordDB);
        boolean isPasswordMatch = passwordEncoder.matches(password, passwordDB);

        return isPasswordMatch;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuario(String user) {
        System.out.println(user);
        // Mejorar cambiando el regreso con un boolean en vez de un User
        Session currentSesion = entity.unwrap(Session.class);
        Query<User> query = currentSesion.createQuery("FROM User WHERE username=:username", User.class);
        query.setParameter("username", user);
        User usuario = query.uniqueResult();
        System.out.println(usuario);
        if (usuario != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    @Transactional
    public void save(User user) {
        // TODO Auto-generated method stub
        Session session = entity.unwrap(Session.class);
        session.persist(user);
    }

}
