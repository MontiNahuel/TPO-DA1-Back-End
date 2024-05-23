package org.uade.da1.service.user;

import org.uade.da1.model.entity.User;

public interface IUserService {
    public User findUser(String username, String password);
    public boolean existeUsuario(String user, String password);
    public void save(User user);
}
