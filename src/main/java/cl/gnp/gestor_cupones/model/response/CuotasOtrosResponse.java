package cl.gnp.gestor_cupones.model.response;

import org.springframework.stereotype.Component;

import java.util.Date;

public class CuotasOtrosResponse {
    private String contrato;
    private Integer numeroDocumento;
    private Date fechaVencimiento;
    private String tipoDocumento;
    private String rut;
    private String parque;
    private Integer cuota;
    private Double uf;
    private Integer seguro;
    private Double montoTotal;
    private Double montoDescuento;
    private Double neto;
    private Double montoInicial;
    private Double tasaIva;
    private Double iva;
    private String tipoMovimiento;

    public CuotasOtrosResponse() {
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getParque() {
        return parque;
    }

    public void setParque(String parque) {
        this.parque = parque;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public Double getUf() {
        return uf;
    }

    public void setUf(Double uf) {
        this.uf = uf;
    }

    public Integer getSeguro() {
        return seguro;
    }

    public void setSeguro(Integer seguro) {
        this.seguro = seguro;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public Double getNeto() {
        return neto;
    }

    public void setNeto(Double neto) {
        this.neto = neto;
    }

    public Double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(Double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public Double getTasaIva() {
        return tasaIva;
    }

    public void setTasaIva(Double tasaIva) {
        this.tasaIva = tasaIva;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
}
