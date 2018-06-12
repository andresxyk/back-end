package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SProceso implements Serializable {

    /** identifier field */
    private java.lang.Integer cproceso;

    /** nullable persistent field */
    private java.lang.String sproceso;

    /** persistent field */
    private Set srolejecucion;

    /** full constructor */
    public SProceso(java.lang.Integer cproceso, java.lang.String sproceso, Set srolejecucion) {
        this.cproceso = cproceso;
        this.sproceso = sproceso;
        this.srolejecucion = srolejecucion;
    }

    /** default constructor */
    public SProceso() {
    }

    /** minimal constructor */
    public SProceso(java.lang.Integer cproceso, Set srolejecucion) {
        this.cproceso = cproceso;
        this.srolejecucion = srolejecucion;
    }

    public java.lang.Integer getCproceso() {
        return this.cproceso;
    }

    public void setCproceso(java.lang.Integer cproceso) {
        this.cproceso = cproceso;
    }

    public java.lang.String getSproceso() {
        return this.sproceso;
    }

    public void setSproceso(java.lang.String sproceso) {
        this.sproceso = sproceso;
    }

    public java.util.Set getSrolejecucion() {
        return this.srolejecucion;
    }

    public void setSrolejecucion(java.util.Set srolejecucion) {
        this.srolejecucion = srolejecucion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cproceso", getCproceso())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SProceso) ) return false;
        SProceso castOther = (SProceso) other;
        return new EqualsBuilder()
            .append(this.getCproceso(), castOther.getCproceso())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCproceso())
            .toHashCode();
    }

}
