package org.uade.da1.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity(name = "anuncios")
public class Anuncio {
    @Id
    private int idanuncio;
    private String tipoanuncio;
    private String descripcion;
    private String titulo;
    private String contacto;
    private String telefono;
    private String dnivecino;
    private Date fechacreacion;
    @ManyToOne
    @JoinColumn(name = "dnivecino", referencedColumnName = "documento", insertable = false, updatable = false)
    private Vecino vecino;
    @ManyToOne
    @JoinColumn(name = "dnivecino", referencedColumnName = "dni", insertable = false, updatable = false)
    private User user;

    public Anuncio(int idAnuncio, String tipoAnuncio, String descripcion, String titulo, String contacto, String telefono, String dniVecino) {
        this.idanuncio = idAnuncio;
        this.tipoanuncio = tipoAnuncio;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.contacto = contacto;
        this.telefono = telefono;
        this.dnivecino = dniVecino;
        this.fechacreacion = new Date();
    }

    public Anuncio() {

    }

    public int getIdAnuncio() {
        return idanuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idanuncio = idAnuncio;
    }

    public String getTipoAnuncio() {
        return tipoanuncio;
    }

    public void setTipoAnuncio(String tipoAnuncio) {
        this.tipoanuncio = tipoAnuncio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDniVecino() {
        return dnivecino;
    }

    public void setDniVecino(String dniVecino) {
        this.dnivecino = dniVecino;
    }

    public Date getFecha() {
        return fechacreacion;
    }

    public void setFecha(Date fecha) {
        this.fechacreacion = fecha;
    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "idanuncio=" + idanuncio +
                ", tipoanuncio='" + tipoanuncio + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", contacto='" + contacto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dnivecino='" + dnivecino + '\'' +
                '}';
    }
}
