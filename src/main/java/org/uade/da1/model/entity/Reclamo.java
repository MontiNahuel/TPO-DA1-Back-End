package org.uade.da1.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "reclamos")
public class Reclamo {
    @Id
    private Integer idreclamo;
    private String documento;
    private Integer idsitio;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer iddesperfecto;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descripcion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idreclamounificado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer legajo;

    public Reclamo() {
    }

    public Reclamo(Integer idreclamo, String documento, Integer idsitio, Integer iddesperfecto, String descripcion, String estado, Integer idreclamounificado, Integer legajo) {
        this.idreclamo = idreclamo;
        this.documento = documento;
        this.idsitio = idsitio;
        this.iddesperfecto = iddesperfecto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idreclamounificado = idreclamounificado;
        this.legajo = legajo;
    }

    public Integer getIdreclamo() {
        return idreclamo;
    }

    public void setIdreclamo(Integer idreclamo) {
        this.idreclamo = idreclamo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getIdsitio() {
        return idsitio;
    }

    public void setIdsitio(Integer idsitio) {
        this.idsitio = idsitio;
    }

    public Integer getIddesperfecto() {
        return iddesperfecto;
    }

    public void setIddesperfecto(Integer iddesperfecto) {
        this.iddesperfecto = iddesperfecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdreclamounificado() {
        return idreclamounificado;
    }

    public void setIdreclamounificado(Integer idreclamounificado) {
        this.idreclamounificado = idreclamounificado;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Reclamo{" +
                "idreclamo=" + idreclamo +
                ", documento='" + documento + '\'' +
                ", idsitio=" + idsitio +
                ", iddesperfecto=" + iddesperfecto +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", idreclamounificado=" + idreclamounificado +
                ", legajo=" + legajo +
                '}';
    }
}