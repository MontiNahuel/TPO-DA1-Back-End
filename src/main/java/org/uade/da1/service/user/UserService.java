package org.uade.da1.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uade.da1.model.dao.user.IUserDAO;
import org.uade.da1.model.dto.UserForProfile;
import org.uade.da1.model.entity.User;
import org.uade.da1.repository.UserRepository;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO usuarioDAO;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUser(String username, String password) {
        //System.out.println("Chequeando si existe");
        User user = usuarioDAO.findUser(username, password);
        System.out.println(user);
        return user;
    }

    @Override
    public boolean existeUsuario(String user) {
        return usuarioDAO.existeUsuario(user);
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        usuarioDAO.save(user);
    }

    public UserForProfile obtenerDatosParaPerfil(String id) {
        return userRepository.findUserProfileByUsername(id);
    }

}
