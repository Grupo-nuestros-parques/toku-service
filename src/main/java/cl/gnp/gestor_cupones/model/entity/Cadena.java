package cl.gnp.gestor_cupones.model.entity;

import jakarta.persistence.*;

@Entity
public class Cadena {
    @Id
    private String rut;
    private String codigo;//base
    private String serie;
    private String numero;
    private String estado;
    private String barra;
    private String codParque;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public String getCodParque() {
        return codParque;
    }

    public void setCodParque(String codParque) {
        this.codParque = codParque;
    }

}