package org.uade.da1.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class User {
    @Id
    @Column(name = "dni")
    private String username;
    private String password;
    private byte[] imagen;

    public User() {
        super();
    }

    public User(String user, String password, byte[] imagen) {
        super();
        this.username = user;
        this.password = password;
        this.imagen = imagen;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "User [user=" + username + ", password=" + password + "]";
    }
}
