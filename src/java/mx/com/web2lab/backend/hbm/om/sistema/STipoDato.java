package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoDato implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipodato;

    /** nullable persistent field */
    private java.lang.String stipodato;

    /** persistent field */
    private Set ccodigoingresos;

    /** persistent field */
    private Set bordeningresos;

    /** full constructor */
    public STipoDato(java.lang.Integer ctipodato, java.lang.String stipodato, Set ccodigoingresos, Set bordeningresos) {
        this.ctipodato = ctipodato;
        this.stipodato = stipodato;
        this.ccodigoingresos = ccodigoingresos;
        this.bordeningresos = bordeningresos;
    }

    /** default constructor */
    public STipoDato() {
    }

    /** minimal constructor */
    public STipoDato(java.lang.Integer ctipodato, Set ccodigoingresos, Set bordeningresos) {
        this.ctipodato = ctipodato;
        this.ccodigoingresos = ccodigoingresos;
        this.bordeningresos = bordeningresos;
    }

    public java.lang.Integer getCtipodato() {
        return this.ctipodato;
    }

    public void setCtipodato(java.lang.Integer ctipodato) {
        this.ctipodato = ctipodato;
    }

    public java.lang.String getStipodato() {
        return this.stipodato;
    }

    public void setStipodato(java.lang.String stipodato) {
        this.stipodato = stipodato;
    }

    public java.util.Set getCcodigoingresos() {
        return this.ccodigoingresos;
    }

    public void setCcodigoingresos(java.util.Set ccodigoingresos) {
        this.ccodigoingresos = ccodigoingresos;
    }

    public java.util.Set getBordeningresos() {
        return this.bordeningresos;
    }

    public void setBordeningresos(java.util.Set bordeningresos) {
        this.bordeningresos = bordeningresos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipodato", getCtipodato())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoDato) ) return false;
        STipoDato castOther = (STipoDato) other;
        return new EqualsBuilder()
            .append(this.getCtipodato(), castOther.getCtipodato())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipodato())
            .toHashCode();
    }

}
