package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoViaje implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipoviaje;

    /** persistent field */
    private java.lang.String stipoviaje;

    /** persistent field */
    private Set bviajes;

    /** full constructor */
    public STipoViaje(java.lang.Integer ctipoviaje, java.lang.String stipoviaje, Set bviajes) {
        this.ctipoviaje = ctipoviaje;
        this.stipoviaje = stipoviaje;
        this.bviajes = bviajes;
    }

    /** default constructor */
    public STipoViaje() {
    }

    public java.lang.Integer getCtipoviaje() {
        return this.ctipoviaje;
    }

    public void setCtipoviaje(java.lang.Integer ctipoviaje) {
        this.ctipoviaje = ctipoviaje;
    }

    public java.lang.String getStipoviaje() {
        return this.stipoviaje;
    }

    public void setStipoviaje(java.lang.String stipoviaje) {
        this.stipoviaje = stipoviaje;
    }

    public java.util.Set getBviajes() {
        return this.bviajes;
    }

    public void setBviajes(java.util.Set bviajes) {
        this.bviajes = bviajes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipoviaje", getCtipoviaje())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoViaje) ) return false;
        STipoViaje castOther = (STipoViaje) other;
        return new EqualsBuilder()
            .append(this.getCtipoviaje(), castOther.getCtipoviaje())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipoviaje())
            .toHashCode();
    }

}
