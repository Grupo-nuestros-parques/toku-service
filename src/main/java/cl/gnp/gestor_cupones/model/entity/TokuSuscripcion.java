package cl.gnp.gestor_cupones.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TOKU_SUSCRIPCION")
public class TokuSuscripcion {

    @Id
    @Column(name="CLIENTE")
    private String cliente;
    @Column(name="ID_PRODUCTO")
    private String idProducto;
    @Column(name="MANDATO_PAC")
    private String mandatoPac;

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

    public String getMandatoPac() {
        return mandatoPac;
    }

    public void setMandatoPac(String mandatoPac) {
        this.mandatoPac = mandatoPac;
    }
}
