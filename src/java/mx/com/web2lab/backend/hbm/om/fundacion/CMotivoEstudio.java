package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMotivoEstudio implements Serializable {

    /** identifier field */
    private java.lang.Integer cmotivoestudio;

    /** nullable persistent field */
    private java.lang.String smotivoestudio;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CMotivoEstudio(java.lang.Integer cmotivoestudio, java.lang.String smotivoestudio, Set bpacientecuestionarios) {
        this.cmotivoestudio = cmotivoestudio;
        this.smotivoestudio = smotivoestudio;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CMotivoEstudio() {
    }

    /** minimal constructor */
    public CMotivoEstudio(java.lang.Integer cmotivoestudio, Set bpacientecuestionarios) {
        this.cmotivoestudio = cmotivoestudio;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCmotivoestudio() {
        return this.cmotivoestudio;
    }

    public void setCmotivoestudio(java.lang.Integer cmotivoestudio) {
        this.cmotivoestudio = cmotivoestudio;
    }

    public java.lang.String getSmotivoestudio() {
        return this.smotivoestudio;
    }

    public void setSmotivoestudio(java.lang.String smotivoestudio) {
        this.smotivoestudio = smotivoestudio;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmotivoestudio", getCmotivoestudio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMotivoEstudio) ) return false;
        CMotivoEstudio castOther = (CMotivoEstudio) other;
        return new EqualsBuilder()
            .append(this.getCmotivoestudio(), castOther.getCmotivoestudio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmotivoestudio())
            .toHashCode();
    }

}
