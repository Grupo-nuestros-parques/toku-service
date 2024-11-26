package cl.gnp.gestor_cupones.model.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ICuponerasDetalleWeb implements Serializable {
    @Column(name="BASE")
    private String base;

    @Column(name="SERIE")
    private String serie;

    @Column(name="NUMERO")
    private Integer numero;

    public ICuponerasDetalleWeb(String base, String serie, Integer numero) {
        this.base = base;
        this.serie = serie;
        this.numero = numero;
    }

    public ICuponerasDetalleWeb() {
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || getClass() != o.getClass()) return false;

        ICuponerasDetalleWeb that = (ICuponerasDetalleWeb) o;

        if(!base.equals(that.base))return false;
        if(!serie.equals(that.serie)) return false;
        return numero.equals(that.numero);
    }

    @Override
    public int hashCode(){
        int result = base.hashCode();
        result = 31 * result + serie.hashCode();
        result = 31 * result + numero.hashCode();
        return result;
    }
}
