package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoCliente implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipocliente;

    /** nullable persistent field */
    private java.lang.String stipocliente;

    /** persistent field */
    private Set bpacientes;

    /** full constructor */
    public STipoCliente(java.lang.Integer ctipocliente, java.lang.String stipocliente, Set bpacientes) {
        this.ctipocliente = ctipocliente;
        this.stipocliente = stipocliente;
        this.bpacientes = bpacientes;
    }

    /** default constructor */
    public STipoCliente() {
    }

    /** minimal constructor */
    public STipoCliente(java.lang.Integer ctipocliente, Set bpacientes) {
        this.ctipocliente = ctipocliente;
        this.bpacientes = bpacientes;
    }

    public java.lang.Integer getCtipocliente() {
        return this.ctipocliente;
    }

    public void setCtipocliente(java.lang.Integer ctipocliente) {
        this.ctipocliente = ctipocliente;
    }

    public java.lang.String getStipocliente() {
        return this.stipocliente;
    }

    public void setStipocliente(java.lang.String stipocliente) {
        this.stipocliente = stipocliente;
    }

    public java.util.Set getBpacientes() {
        return this.bpacientes;
    }

    public void setBpacientes(java.util.Set bpacientes) {
        this.bpacientes = bpacientes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipocliente", getCtipocliente())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoCliente) ) return false;
        STipoCliente castOther = (STipoCliente) other;
        return new EqualsBuilder()
            .append(this.getCtipocliente(), castOther.getCtipocliente())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipocliente())
            .toHashCode();
    }

}
