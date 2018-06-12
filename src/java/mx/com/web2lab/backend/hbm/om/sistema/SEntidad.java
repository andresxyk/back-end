package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SEntidad implements Serializable {

    /** identifier field */
    private java.lang.Integer centidad;

    /** nullable persistent field */
    private java.lang.String sentidad;

    /** persistent field */
    private Set sestados;

    /** full constructor */
    public SEntidad(java.lang.Integer centidad, java.lang.String sentidad, Set sestados) {
        this.centidad = centidad;
        this.sentidad = sentidad;
        this.sestados = sestados;
    }

    /** default constructor */
    public SEntidad() {
    }

    /** minimal constructor */
    public SEntidad(java.lang.Integer centidad, Set sestados) {
        this.centidad = centidad;
        this.sestados = sestados;
    }

    public java.lang.Integer getCentidad() {
        return this.centidad;
    }

    public void setCentidad(java.lang.Integer centidad) {
        this.centidad = centidad;
    }

    public java.lang.String getSentidad() {
        return this.sentidad;
    }

    public void setSentidad(java.lang.String sentidad) {
        this.sentidad = sentidad;
    }

    public java.util.Set getSestados() {
        return this.sestados;
    }

    public void setSestados(java.util.Set sestados) {
        this.sestados = sestados;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("centidad", getCentidad())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SEntidad) ) return false;
        SEntidad castOther = (SEntidad) other;
        return new EqualsBuilder()
            .append(this.getCentidad(), castOther.getCentidad())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCentidad())
            .toHashCode();
    }

}
