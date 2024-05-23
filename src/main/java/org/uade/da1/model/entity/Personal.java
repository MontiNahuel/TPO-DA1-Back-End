package org.uade.da1.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "Personal")
public class Personal {
    @Id
    private int legajo;
    private String nombre;
    private String apellido;
    private String documento;
    private String password;
    private String sector;
    private int categoria;
    @Column(name = "fechaingreso")
    private LocalDateTime fecha;

    public Personal() {
    }

    public Personal(int legajo, String nombre, String apellido, String documento, String password, String sector, int categoria, LocalDateTime fechaIngreso) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.password = password;
        this.sector = sector;
        this.categoria = categoria;
        this.fecha = fechaIngreso;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaIngreso() {
        return fecha;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fecha = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "legajo=" + legajo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", password='" + password + '\'' +
                ", sector='" + sector + '\'' +
                ", categoria=" + categoria +
                ", fechaIngreso=" + fecha +
                '}';
    }

}
