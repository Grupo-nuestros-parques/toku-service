package cl.gnp.gestor_cupones.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name="TOKU_COBROS")
public class TokuCobros {
    @Id
    @Column(name="CLIENTE")
    private String cliente;

    @Column(name="ID_PRODUCTO")
    private String idProducto;
    @Column(name="VACIO")
    private String vacio;
    @Column(name="PAGADO")
    private String pagado;
    @Column(name="FECHA_VENCIMIENTO")
    private Date fechaVencimiento;
    @Column(name="MONTO")
    private double monto;
    @Column(name="LINK_PAGO")
    private String linkPago;
    @Column(name="ID_COBRO_TOKU")
    private String idCobroToku;
    @Column(name="CUPON")
    private Integer cupon;
    @Column(name="BUY_ORDER")
    private String buyOrder;
    @Column(name="TIPO_MOV")
    private Integer tipoMov;
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getVacio() {
        return vacio;
    }

    public void setVacio(String vacio) {
        this.vacio = vacio;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getLinkPago() {
        return linkPago;
    }

    public void setLinkPago(String linkPago) {
        this.linkPago = linkPago;
    }

    public String getIdCobroToku() {
        return idCobroToku;
    }

    public void setIdCobroToku(String idCobroToku) {
        this.idCobroToku = idCobroToku;
    }

    public Integer getCupon() {
        return cupon;
    }

    public void setCupon(Integer cupon) {
        this.cupon = cupon;
    }

    public String getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(String buyOrder) {
        this.buyOrder = buyOrder;
    }

    public Integer getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(Integer tipoMov) {
        this.tipoMov = tipoMov;
    }
}
