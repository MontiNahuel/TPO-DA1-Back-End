package org.uade.da1.model.dto;

public class DTOPersonal {
    private int legajo;
    private String nombre;
    private String apellido;
    private String sector;
    private String documento;
    private String password;

    public DTOPersonal() {
    }

    public DTOPersonal(int legajo, String password) {
        this.legajo = legajo;
        this.password = password;
    }

    public DTOPersonal(int legajo, String nombre, String apellido, String sector, String documento) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sector = sector;
        this.documento = documento;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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

    @Override
    public String toString() {
        return "DTOPersonal{" +
                "legajo=" + legajo +
                ", nombre=" + nombre +
                ", apellido=" + apellido +
                ", sector=" + sector +
                ", documento=" + documento +
                '}';
    }

}
