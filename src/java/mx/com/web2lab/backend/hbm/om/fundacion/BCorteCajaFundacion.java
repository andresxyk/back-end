package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BCorteCajaFundacion implements Serializable {

    /** identifier field */
    private java.lang.Integer kcortecajafundacion;

    /** nullable persistent field */
    private java.util.Date dcortecaja;

    /** nullable persistent field */
    private int cestado;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private Set bpagofundacions;

    /** full constructor */
    public BCorteCajaFundacion(java.lang.Integer kcortecajafundacion, java.util.Date dcortecaja, int cestado, boolean bregistroactivo, int cusuario, java.util.Date dregistro, Set bpagofundacions) {
        this.kcortecajafundacion = kcortecajafundacion;
        this.dcortecaja = dcortecaja;
        this.cestado = cestado;
        this.bregistroactivo = bregistroactivo;
        this.cusuario = cusuario;
        this.dregistro = dregistro;
        this.bpagofundacions = bpagofundacions;
    }

    /** default constructor */
    public BCorteCajaFundacion() {
    }

    /** minimal constructor */
    public BCorteCajaFundacion(java.lang.Integer kcortecajafundacion, int cusuario, Set bpagofundacions) {
        this.kcortecajafundacion = kcortecajafundacion;
        this.cusuario = cusuario;
        this.bpagofundacions = bpagofundacions;
    }

    public java.lang.Integer getKcortecajafundacion() {
        return this.kcortecajafundacion;
    }

    public void setKcortecajafundacion(java.lang.Integer kcortecajafundacion) {
        this.kcortecajafundacion = kcortecajafundacion;
    }

    public java.util.Date getDcortecaja() {
        return this.dcortecaja;
    }

    public void setDcortecaja(java.util.Date dcortecaja) {
        this.dcortecaja = dcortecaja;
    }

    public int getCestado() {
        return this.cestado;
    }

    public void setCestado(int cestado) {
        this.cestado = cestado;
    }

    public boolean isBregistroactivo() {
        return this.bregistroactivo;
    }

    public void setBregistroactivo(boolean bregistroactivo) {
        this.bregistroactivo = bregistroactivo;
    }

    public int getCusuario() {
        return this.cusuario;
    }

    public void setCusuario(int cusuario) {
        this.cusuario = cusuario;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.util.Set getBpagofundacions() {
        return this.bpagofundacions;
    }

    public void setBpagofundacions(java.util.Set bpagofundacions) {
        this.bpagofundacions = bpagofundacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kcortecajafundacion", getKcortecajafundacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BCorteCajaFundacion) ) return false;
        BCorteCajaFundacion castOther = (BCorteCajaFundacion) other;
        return new EqualsBuilder()
            .append(this.getKcortecajafundacion(), castOther.getKcortecajafundacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKcortecajafundacion())
            .toHashCode();
    }

}
