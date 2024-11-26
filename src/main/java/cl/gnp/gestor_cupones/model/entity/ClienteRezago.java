package cl.gnp.gestor_cupones.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="CLIENTE_REZAGO")
public class ClienteRezago {
    @Id
    @Column(name="RUT")
    private Integer rut;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="AP_PATERNO")
    private String apPaterno;
    @Column(name="AP_MATERNO")
    private String apMaterno;
    @Column(name="FECHA_CREA")
    private Date fechaCrea;
    @Column(name="COD_PAGO")
    private String codPago;
    @Column(name="FOLIO")
    private Integer folio;
    @Column(name="TELEFONO_PART")
    private String telefonoPart;
    @Column(name="COD_PARQUE")
    private Integer codParque;
    @Column(name="MONEDA")
    private String moneda;

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getCodPago() {
        return codPago;
    }

    public void setCodPago(String codPago) {
        this.codPago = codPago;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getTelefonoPart() {
        return telefonoPart;
    }

    public void setTelefonoPart(String telefonoPart) {
        this.telefonoPart = telefonoPart;
    }

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
