package mx.com.web2lab.backend.hbm.om.lis;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMotivoRechazo implements Serializable {

    /** identifier field */
    private java.lang.Integer cmotivorechazo;

    /** nullable persistent field */
    private java.lang.String smotivorechazo;

    /** full constructor */
    public CMotivoRechazo(java.lang.Integer cmotivorechazo, java.lang.String smotivorechazo) {
        this.cmotivorechazo = cmotivorechazo;
        this.smotivorechazo = smotivorechazo;
    }

    /** default constructor */
    public CMotivoRechazo() {
    }

    /** minimal constructor */
    public CMotivoRechazo(java.lang.Integer cmotivorechazo) {
        this.cmotivorechazo = cmotivorechazo;
    }

    public java.lang.Integer getCmotivorechazo() {
        return this.cmotivorechazo;
    }

    public void setCmotivorechazo(java.lang.Integer cmotivorechazo) {
        this.cmotivorechazo = cmotivorechazo;
    }

    public java.lang.String getSmotivorechazo() {
        return this.smotivorechazo;
    }

    public void setSmotivorechazo(java.lang.String smotivorechazo) {
        this.smotivorechazo = smotivorechazo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmotivorechazo", getCmotivorechazo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMotivoRechazo) ) return false;
        CMotivoRechazo castOther = (CMotivoRechazo) other;
        return new EqualsBuilder()
            .append(this.getCmotivorechazo(), castOther.getCmotivorechazo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmotivorechazo())
            .toHashCode();
    }

}
