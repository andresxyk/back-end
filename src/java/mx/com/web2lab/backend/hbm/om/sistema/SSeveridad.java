package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SSeveridad implements Serializable {

    /** identifier field */
    private java.lang.Integer cseveridad;

    /** persistent field */
    private java.lang.String sseveridad;

    /** persistent field */
    private Set bincidencias;

    /** persistent field */
    private Set bincidenciaunidads;

    /** full constructor */
    public SSeveridad(java.lang.Integer cseveridad, java.lang.String sseveridad, Set bincidencias, Set bincidenciaunidads) {
        this.cseveridad = cseveridad;
        this.sseveridad = sseveridad;
        this.bincidencias = bincidencias;
        this.bincidenciaunidads = bincidenciaunidads;
    }

    /** default constructor */
    public SSeveridad() {
    }

    public java.lang.Integer getCseveridad() {
        return this.cseveridad;
    }

    public void setCseveridad(java.lang.Integer cseveridad) {
        this.cseveridad = cseveridad;
    }

    public java.lang.String getSseveridad() {
        return this.sseveridad;
    }

    public void setSseveridad(java.lang.String sseveridad) {
        this.sseveridad = sseveridad;
    }

    public java.util.Set getBincidencias() {
        return this.bincidencias;
    }

    public void setBincidencias(java.util.Set bincidencias) {
        this.bincidencias = bincidencias;
    }

    public java.util.Set getBincidenciaunidads() {
        return this.bincidenciaunidads;
    }

    public void setBincidenciaunidads(java.util.Set bincidenciaunidads) {
        this.bincidenciaunidads = bincidenciaunidads;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cseveridad", getCseveridad())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SSeveridad) ) return false;
        SSeveridad castOther = (SSeveridad) other;
        return new EqualsBuilder()
            .append(this.getCseveridad(), castOther.getCseveridad())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCseveridad())
            .toHashCode();
    }

}
