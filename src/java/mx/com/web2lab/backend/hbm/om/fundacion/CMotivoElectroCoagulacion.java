package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMotivoElectroCoagulacion implements Serializable {

    /** identifier field */
    private java.lang.Integer cmotivoelectrocoagulacion;

    /** nullable persistent field */
    private java.lang.String smotivoelectrocoagulacion;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CMotivoElectroCoagulacion(java.lang.Integer cmotivoelectrocoagulacion, java.lang.String smotivoelectrocoagulacion, Set bpacientecuestionarios) {
        this.cmotivoelectrocoagulacion = cmotivoelectrocoagulacion;
        this.smotivoelectrocoagulacion = smotivoelectrocoagulacion;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CMotivoElectroCoagulacion() {
    }

    /** minimal constructor */
    public CMotivoElectroCoagulacion(java.lang.Integer cmotivoelectrocoagulacion, Set bpacientecuestionarios) {
        this.cmotivoelectrocoagulacion = cmotivoelectrocoagulacion;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCmotivoelectrocoagulacion() {
        return this.cmotivoelectrocoagulacion;
    }

    public void setCmotivoelectrocoagulacion(java.lang.Integer cmotivoelectrocoagulacion) {
        this.cmotivoelectrocoagulacion = cmotivoelectrocoagulacion;
    }

    public java.lang.String getSmotivoelectrocoagulacion() {
        return this.smotivoelectrocoagulacion;
    }

    public void setSmotivoelectrocoagulacion(java.lang.String smotivoelectrocoagulacion) {
        this.smotivoelectrocoagulacion = smotivoelectrocoagulacion;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmotivoelectrocoagulacion", getCmotivoelectrocoagulacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMotivoElectroCoagulacion) ) return false;
        CMotivoElectroCoagulacion castOther = (CMotivoElectroCoagulacion) other;
        return new EqualsBuilder()
            .append(this.getCmotivoelectrocoagulacion(), castOther.getCmotivoelectrocoagulacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmotivoelectrocoagulacion())
            .toHashCode();
    }

}
