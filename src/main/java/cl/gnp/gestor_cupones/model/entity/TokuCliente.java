package cl.gnp.gestor_cupones.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="TOKU_CLIENTE")
public class TokuCliente {
    @Id
    @Column(name="ID_CLIENTE")
    private String idCliente;//external_id

    @Column(name="A_PATERNO")
    private String aPaterno;
    @Column(name="A_MATERNO")
    private String aMaterno;
    @Column(name="ID_EXTERNO")//goverment_id
    private String idExterno;
    @Column(name="NUMERO_AGENTE")
    private String numeroAgente;
    @Column(name="NOMBRES")
    private String nombres;
    @Column(name="ID_TOKU")//id
    private String idToku;
    @Column(name="MANDATO_PAC")//pac_mandate_id
    private String mandatoPac;
    @Column(name="AGENTE")
    private String agente;
    @Column(name="EMAIL")
    private String email;
    @Column(name="CELULAR")
    private String celular;
    @Column(name="COD_PARQUE")
    private Integer codParque;
    @Column(name="MOVIMIENTOS_INSCRITOS")
    private String movimientosInscritos;
    @Column(name="FECHA")
    private Date fecha;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public String getNumeroAgente() {
        return numeroAgente;
    }

    public void setNumeroAgente(String numeroAgente) {
        this.numeroAgente = numeroAgente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdToku() {
        return idToku;
    }

    public void setIdToku(String idToku) {
        this.idToku = idToku;
    }

    public String getMandatoPac() {
        return mandatoPac;
    }

    public void setMandatoPac(String mandatoPac) {
        this.mandatoPac = mandatoPac;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getCodParque() {
        return codParque;
    }

    public void setCodParque(Integer codParque) {
        this.codParque = codParque;
    }

    public String getMovimientosInscritos() {
        return movimientosInscritos;
    }

    public void setMovimientosInscritos(String movimientosInscritos) {
        this.movimientosInscritos = movimientosInscritos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
