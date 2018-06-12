package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoSecuencia implements Serializable {

    /** identifier field */
    private java.lang.Integer ctiposecuencia;

    /** nullable persistent field */
    private java.lang.String stiposecuencia;

    /** persistent field */
    private Set ssecuencias;

    /** full constructor */
    public STipoSecuencia(java.lang.Integer ctiposecuencia, java.lang.String stiposecuencia, Set ssecuencias) {
        this.ctiposecuencia = ctiposecuencia;
        this.stiposecuencia = stiposecuencia;
        this.ssecuencias = ssecuencias;
    }

    /** default constructor */
    public STipoSecuencia() {
    }

    /** minimal constructor */
    public STipoSecuencia(java.lang.Integer ctiposecuencia, Set ssecuencias) {
        this.ctiposecuencia = ctiposecuencia;
        this.ssecuencias = ssecuencias;
    }

    public java.lang.Integer getCtiposecuencia() {
        return this.ctiposecuencia;
    }

    public void setCtiposecuencia(java.lang.Integer ctiposecuencia) {
        this.ctiposecuencia = ctiposecuencia;
    }

    public java.lang.String getStiposecuencia() {
        return this.stiposecuencia;
    }

    public void setStiposecuencia(java.lang.String stiposecuencia) {
        this.stiposecuencia = stiposecuencia;
    }

    public java.util.Set getSsecuencias() {
        return this.ssecuencias;
    }

    public void setSsecuencias(java.util.Set ssecuencias) {
        this.ssecuencias = ssecuencias;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctiposecuencia", getCtiposecuencia())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoSecuencia) ) return false;
        STipoSecuencia castOther = (STipoSecuencia) other;
        return new EqualsBuilder()
            .append(this.getCtiposecuencia(), castOther.getCtiposecuencia())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtiposecuencia())
            .toHashCode();
    }

}
