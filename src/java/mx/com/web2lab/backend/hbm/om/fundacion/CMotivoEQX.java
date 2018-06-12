package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMotivoEQX implements Serializable {

    /** identifier field */
    private java.lang.Integer cmotivoeqx;

    /** nullable persistent field */
    private java.lang.String smotivoeqx;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CMotivoEQX(java.lang.Integer cmotivoeqx, java.lang.String smotivoeqx, Set bpacientecuestionarios) {
        this.cmotivoeqx = cmotivoeqx;
        this.smotivoeqx = smotivoeqx;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CMotivoEQX() {
    }

    /** minimal constructor */
    public CMotivoEQX(java.lang.Integer cmotivoeqx, Set bpacientecuestionarios) {
        this.cmotivoeqx = cmotivoeqx;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCmotivoeqx() {
        return this.cmotivoeqx;
    }

    public void setCmotivoeqx(java.lang.Integer cmotivoeqx) {
        this.cmotivoeqx = cmotivoeqx;
    }

    public java.lang.String getSmotivoeqx() {
        return this.smotivoeqx;
    }

    public void setSmotivoeqx(java.lang.String smotivoeqx) {
        this.smotivoeqx = smotivoeqx;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmotivoeqx", getCmotivoeqx())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMotivoEQX) ) return false;
        CMotivoEQX castOther = (CMotivoEQX) other;
        return new EqualsBuilder()
            .append(this.getCmotivoeqx(), castOther.getCmotivoeqx())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmotivoeqx())
            .toHashCode();
    }

}
