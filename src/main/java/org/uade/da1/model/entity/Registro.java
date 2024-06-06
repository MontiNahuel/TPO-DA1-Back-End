package org.uade.da1.model.entity;

import jakarta.persistence.*;


@Entity
@Table (name = "inscriptos")
public class Registro {
    @Id
    private String dni;
    private String email;

    private int estadoid = 1;

    public Registro(String dni, String email, int estadoid) {
        this.dni = dni;
        this.email = email;
        this.estadoid = estadoid;
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

    public int getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(int estadoid) {
        this.estadoid = estadoid;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", estadoid=" + estadoid +
                '}';
    }

}
