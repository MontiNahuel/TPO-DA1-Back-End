package org.uade.da1.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @Column(name = "dni")
    private String username;
    private String password;

    public User() {
        super();
    }

    public User(String user, String password) {
        super();
        this.username = user;
        this.password = password;
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

    @Override
    public String toString() {
        return "User [user=" + username + ", password=" + password + "]";
    }
}
