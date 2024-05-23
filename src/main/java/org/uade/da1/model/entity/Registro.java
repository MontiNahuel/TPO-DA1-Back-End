package org.uade.da1.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "inscripcion")
public class Registro {
    @Id
    private String dni;
    private String email;

    public Registro(String dni, String email) {
        this.dni = dni;
        this.email = email;
    }

    public Registro() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
