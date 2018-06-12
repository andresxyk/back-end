package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CSecrecion implements Serializable {

    /** identifier field */
    private java.lang.Integer csecrecion;

    /** nullable persistent field */
    private java.lang.String ssecrecion;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CSecrecion(java.lang.Integer csecrecion, java.lang.String ssecrecion, Set bpacientecuestionarios) {
        this.csecrecion = csecrecion;
        this.ssecrecion = ssecrecion;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CSecrecion() {
    }

    /** minimal constructor */
    public CSecrecion(java.lang.Integer csecrecion, Set bpacientecuestionarios) {
        this.csecrecion = csecrecion;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCsecrecion() {
        return this.csecrecion;
    }

    public void setCsecrecion(java.lang.Integer csecrecion) {
        this.csecrecion = csecrecion;
    }

    public java.lang.String getSsecrecion() {
        return this.ssecrecion;
    }

    public void setSsecrecion(java.lang.String ssecrecion) {
        this.ssecrecion = ssecrecion;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("csecrecion", getCsecrecion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CSecrecion) ) return false;
        CSecrecion castOther = (CSecrecion) other;
        return new EqualsBuilder()
            .append(this.getCsecrecion(), castOther.getCsecrecion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCsecrecion())
            .toHashCode();
    }

}
