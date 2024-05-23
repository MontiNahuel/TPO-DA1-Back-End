package org.uade.da1.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vecinos")
public class Vecino {
    @Id
    @Column(name = "documento")
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private int codigobarrio;

    public Vecino() {
    }

    public Vecino(String dni, String nombre, String apellido, String direccion, int codigoBarrio) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.codigobarrio = codigoBarrio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String id) {
        this.dni = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoBarrio() {
        return codigobarrio;
    }

    public void setCodigoBarrio(int codigoBarrio) {
        this.codigobarrio = codigoBarrio;
    }

    @Override
    public String toString() {
        return "Vecino{" +
                "id=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigoBarrio=" + codigobarrio +
                '}';
    }
}
