package cl.gnp.gestor_cupones.model.entity;

import cl.gnp.gestor_cupones.model.embeddable.ICuponerasDetalleWeb;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="CUPONERAS_DETALLE_WEB")
public class CuponerasDetalleWeb {

    @EmbeddedId
    private ICuponerasDetalleWeb id;
    @Column(name="NRO_CUPON")
    private Number nroCupon;
    @Column(name="RUT")
    private Integer rut;
    @Column(name="NRO_CUOTA")
    private Integer nroCuota;
    @Column(name="TIPO_MOV")
    private String tipoMov;
    @Column(name="TIPO_MONEDA")
    private String tipoMoneda;
    @Column(name="PIE_PACTADO")
    private String piePactado;

    public ICuponerasDetalleWeb getId() {
        return id;
    }

    public void setId(ICuponerasDetalleWeb id) {
        this.id = id;
    }

    public Number getNroCupon() {
        return nroCupon;
    }

    public void setNroCupon(Number nroCupon) {
        this.nroCupon = nroCupon;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public Integer getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(Integer nroCuota) {
        this.nroCuota = nroCuota;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getPiePactado() {
        return piePactado;
    }

    public void setPiePactado(String piePactado) {
        this.piePactado = piePactado;
    }
}
