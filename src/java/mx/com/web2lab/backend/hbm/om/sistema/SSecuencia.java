package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SSecuencia implements Serializable {

    /** identifier field */
    private java.lang.Integer csecuencia;

    /** persistent field */
    private int cunidad;

    /** persistent field */
    private java.lang.String snombreunidad;

    /** persistent field */
    private java.lang.String ssecuencia;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.sistema.STipoSecuencia stiposecuencia;

    /** full constructor */
    public SSecuencia(java.lang.Integer csecuencia, int cunidad, java.lang.String snombreunidad, java.lang.String ssecuencia, mx.com.web2lab.backend.hbm.om.sistema.STipoSecuencia stiposecuencia) {
        this.csecuencia = csecuencia;
        this.cunidad = cunidad;
        this.snombreunidad = snombreunidad;
        this.ssecuencia = ssecuencia;
        this.stiposecuencia = stiposecuencia;
    }

    /** default constructor */
    public SSecuencia() {
    }

    public java.lang.Integer getCsecuencia() {
        return this.csecuencia;
    }

    public void setCsecuencia(java.lang.Integer csecuencia) {
        this.csecuencia = csecuencia;
    }

    public int getCunidad() {
        return this.cunidad;
    }

    public void setCunidad(int cunidad) {
        this.cunidad = cunidad;
    }

    public java.lang.String getSnombreunidad() {
        return this.snombreunidad;
    }

    public void setSnombreunidad(java.lang.String snombreunidad) {
        this.snombreunidad = snombreunidad;
    }

    public java.lang.String getSsecuencia() {
        return this.ssecuencia;
    }

    public void setSsecuencia(java.lang.String ssecuencia) {
        this.ssecuencia = ssecuencia;
    }

    public mx.com.web2lab.backend.hbm.om.sistema.STipoSecuencia getStiposecuencia() {
        return this.stiposecuencia;
    }

    public void setStiposecuencia(mx.com.web2lab.backend.hbm.om.sistema.STipoSecuencia stiposecuencia) {
        this.stiposecuencia = stiposecuencia;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("csecuencia", getCsecuencia())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SSecuencia) ) return false;
        SSecuencia castOther = (SSecuencia) other;
        return new EqualsBuilder()
            .append(this.getCsecuencia(), castOther.getCsecuencia())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCsecuencia())
            .toHashCode();
    }

}
