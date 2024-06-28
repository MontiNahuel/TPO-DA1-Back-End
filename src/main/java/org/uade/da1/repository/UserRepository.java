package org.uade.da1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.uade.da1.model.entity.User;
import org.uade.da1.model.dto.UserForProfile;
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT new org.uade.da1.model.dto.UserForProfile(u.username, v.apellido, v.nombre, i.email, u.imagen) " +
            "FROM User u " +
            "JOIN Vecino v ON u.username = v.dni " +
            "JOIN Registro i ON u.username = i.dni " +
            "WHERE u.username = :username")
    UserForProfile findUserProfileByUsername(@Param("username") String username);

}
