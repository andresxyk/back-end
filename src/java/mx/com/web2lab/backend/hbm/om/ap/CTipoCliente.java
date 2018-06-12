package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTipoCliente implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipocliente;

    /** nullable persistent field */
    private java.lang.String stipocliente;

    /** persistent field */
    private Set cclientes;

    /** full constructor */
    public CTipoCliente(java.lang.Integer ctipocliente, java.lang.String stipocliente, Set cclientes) {
        this.ctipocliente = ctipocliente;
        this.stipocliente = stipocliente;
        this.cclientes = cclientes;
    }

    /** default constructor */
    public CTipoCliente() {
    }

    /** minimal constructor */
    public CTipoCliente(java.lang.Integer ctipocliente, Set cclientes) {
        this.ctipocliente = ctipocliente;
        this.cclientes = cclientes;
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

    public java.util.Set getCclientes() {
        return this.cclientes;
    }

    public void setCclientes(java.util.Set cclientes) {
        this.cclientes = cclientes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipocliente", getCtipocliente())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoCliente) ) return false;
        CTipoCliente castOther = (CTipoCliente) other;
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
