package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CEscolaridad implements Serializable {

    /** identifier field */
    private java.lang.Integer cescolaridad;

    /** nullable persistent field */
    private java.lang.String sescolaridad;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CEscolaridad(java.lang.Integer cescolaridad, java.lang.String sescolaridad, Set bpacientecuestionarios) {
        this.cescolaridad = cescolaridad;
        this.sescolaridad = sescolaridad;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CEscolaridad() {
    }

    /** minimal constructor */
    public CEscolaridad(java.lang.Integer cescolaridad, Set bpacientecuestionarios) {
        this.cescolaridad = cescolaridad;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCescolaridad() {
        return this.cescolaridad;
    }

    public void setCescolaridad(java.lang.Integer cescolaridad) {
        this.cescolaridad = cescolaridad;
    }

    public java.lang.String getSescolaridad() {
        return this.sescolaridad;
    }

    public void setSescolaridad(java.lang.String sescolaridad) {
        this.sescolaridad = sescolaridad;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cescolaridad", getCescolaridad())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CEscolaridad) ) return false;
        CEscolaridad castOther = (CEscolaridad) other;
        return new EqualsBuilder()
            .append(this.getCescolaridad(), castOther.getCescolaridad())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCescolaridad())
            .toHashCode();
    }

}
