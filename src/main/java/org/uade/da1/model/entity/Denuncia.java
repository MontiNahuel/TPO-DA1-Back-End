package org.uade.da1.model.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "denuncias")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddenuncias;
    private String documento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idsitio;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descripcion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estado;
    private Integer aceptaresponsabilidad;

    public Denuncia() {
    }

    public Denuncia(Integer iddenuncias, String documento, Integer idsitio, String descripcion, String estado, Integer aceptaresponsabilidad) {
        this.iddenuncias = iddenuncias;
        this.documento = documento;
        this.idsitio = idsitio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.aceptaresponsabilidad = aceptaresponsabilidad;
    }

    public Integer getIddenuncias() {
        return iddenuncias;
    }

    public void setIddenuncias(Integer iddenuncia) {
        this.iddenuncias = iddenuncia;
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

    public Integer getAceptaresponsabilidad() {
        return aceptaresponsabilidad;
    }

    public void setAceptaresponsabilidad(Integer aceptaresponsabilidad) {
        this.aceptaresponsabilidad = aceptaresponsabilidad;
    }

    @Override
    public String toString() {
        return "Denuncia{" +
                "iddenuncia=" + iddenuncias +
                ", documento='" + documento + '\'' +
                ", idsitio=" + idsitio +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", aceptaresponsabilidad=" + aceptaresponsabilidad +
                '}';
    }
}
