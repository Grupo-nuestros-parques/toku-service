package cl.gnp.gestor_cupones.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="API_CUPONES")
public class ApiCupones implements Serializable {
    @Column(name="NUMERO_CLIENTE")
    private String numeroCliente;
    @Id
    @Column(name="RUT")
    private String rut;
    @Column(name="REFERENCIA")
    private String referencia;
    @Column(name="TIPO_DOCUMENTO")
    private Integer tipoDocumento;
    @Column(name="NUMERO_DOCUMENTO")
    private Integer numeroDocumento;
    @Column(name="FECHA_EMISION")
    private String fechaEmision;
    @Column(name="MONTO_TOTAL")
    private Double montoTotal;
    @Column(name="SALDO_ANTERIOR")
    private Double saldoAnterior;
    @Column(name="FECHA_VENCIMIENTO")
    private String fechaVencimiento;
    @Column(name="CUOTA")
    private Double cuota;

    @Column(name="INTERES")
    private double interes;
    @Column(name="COBRANZA_EXTERNA")
    private double cobranzaExterna;
    @Column(name="CODIGO_TRAMO")
    private double codigoTramo;


    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getCobranzaExterna() {
        return cobranzaExterna;
    }

    public void setCobranzaExterna(double cobranzaExterna) {
        this.cobranzaExterna = cobranzaExterna;
    }

    public double getCodigoTramo() {
        return codigoTramo;
    }

    public void setCodigoTramo(double codigoTramo) {
        this.codigoTramo = codigoTramo;
    }
}
