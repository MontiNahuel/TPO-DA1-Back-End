package org.uade.da1.model.dao.user;

import org.uade.da1.model.entity.User;

public interface IUserDAO {
    public User findUser(String user, String password);
    public boolean existeUsuario(String user, String password);
    public void save(User user);
}

