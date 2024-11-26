package cl.gnp.gestor_cupones.model.dto;

public class TokuMetadataDTO {
    private String rut;
    private double interes;
    private double cobranza;
    private double montoDescuento;
    private String cupon;
    private String tipoMov;
    private String parque;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getCobranza() {
        return cobranza;
    }

    public void setCobranza(double cobranza) {
        this.cobranza = cobranza;
    }

    public double getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public String getCupon() {
        return cupon;
    }

    public void setCupon(String cupon) {
        this.cupon = cupon;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getParque() {
        return parque;
    }

    public void setParque(String parque) {
        this.parque = parque;
    }
}
