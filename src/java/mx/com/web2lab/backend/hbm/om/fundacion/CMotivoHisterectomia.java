package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMotivoHisterectomia implements Serializable {

    /** identifier field */
    private java.lang.Integer cmotivohisterectomia;

    /** nullable persistent field */
    private java.lang.String smotivohisterectomia;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CMotivoHisterectomia(java.lang.Integer cmotivohisterectomia, java.lang.String smotivohisterectomia, Set bpacientecuestionarios) {
        this.cmotivohisterectomia = cmotivohisterectomia;
        this.smotivohisterectomia = smotivohisterectomia;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CMotivoHisterectomia() {
    }

    /** minimal constructor */
    public CMotivoHisterectomia(java.lang.Integer cmotivohisterectomia, Set bpacientecuestionarios) {
        this.cmotivohisterectomia = cmotivohisterectomia;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCmotivohisterectomia() {
        return this.cmotivohisterectomia;
    }

    public void setCmotivohisterectomia(java.lang.Integer cmotivohisterectomia) {
        this.cmotivohisterectomia = cmotivohisterectomia;
    }

    public java.lang.String getSmotivohisterectomia() {
        return this.smotivohisterectomia;
    }

    public void setSmotivohisterectomia(java.lang.String smotivohisterectomia) {
        this.smotivohisterectomia = smotivohisterectomia;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmotivohisterectomia", getCmotivohisterectomia())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMotivoHisterectomia) ) return false;
        CMotivoHisterectomia castOther = (CMotivoHisterectomia) other;
        return new EqualsBuilder()
            .append(this.getCmotivohisterectomia(), castOther.getCmotivohisterectomia())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmotivohisterectomia())
            .toHashCode();
    }

}
