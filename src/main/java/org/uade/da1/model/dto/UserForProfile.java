package org.uade.da1.model.dto;

import java.util.Arrays;

public class UserForProfile {
    private String username;
    private String nombre;
    private String apellido;
    private String email;
    private byte[] imagen;

    public UserForProfile() {
    }

    public UserForProfile(String username, String apellido, String nombre, String email, byte[] imagen) {
        this.username = username;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.imagen = imagen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "UserForProfile{" +
                "username='" + username + '\'' +
                ", password='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", imagen=" + Arrays.toString(imagen) +
                '}';
    }
}
