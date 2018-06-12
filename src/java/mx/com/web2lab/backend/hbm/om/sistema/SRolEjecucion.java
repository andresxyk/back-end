package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SRolEjecucion implements Serializable {

    /** identifier field */
    private java.lang.Integer crolejecucion;

    /** persistent field */
    private java.lang.String srolejecucion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.sistema.SProceso sproceso;

    /** full constructor */
    public SRolEjecucion(java.lang.Integer crolejecucion, java.lang.String srolejecucion, mx.com.web2lab.backend.hbm.om.sistema.SProceso sproceso) {
        this.crolejecucion = crolejecucion;
        this.srolejecucion = srolejecucion;
        this.sproceso = sproceso;
    }

    /** default constructor */
    public SRolEjecucion() {
    }

    public java.lang.Integer getCrolejecucion() {
        return this.crolejecucion;
    }

    public void setCrolejecucion(java.lang.Integer crolejecucion) {
        this.crolejecucion = crolejecucion;
    }

    public java.lang.String getSrolejecucion() {
        return this.srolejecucion;
    }

    public void setSrolejecucion(java.lang.String srolejecucion) {
        this.srolejecucion = srolejecucion;
    }

    public mx.com.web2lab.backend.hbm.om.sistema.SProceso getSproceso() {
        return this.sproceso;
    }

    public void setSproceso(mx.com.web2lab.backend.hbm.om.sistema.SProceso sproceso) {
        this.sproceso = sproceso;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("crolejecucion", getCrolejecucion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SRolEjecucion) ) return false;
        SRolEjecucion castOther = (SRolEjecucion) other;
        return new EqualsBuilder()
            .append(this.getCrolejecucion(), castOther.getCrolejecucion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCrolejecucion())
            .toHashCode();
    }

}
