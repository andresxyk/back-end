package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CGiroCliente implements Serializable {

    /** identifier field */
    private java.lang.Integer cgirocliente;

    /** nullable persistent field */
    private java.lang.String sgirocliente;


    /** full constructor */
    public CGiroCliente(java.lang.Integer cgirocliente, java.lang.String sgirocliente) {
        this.cgirocliente = cgirocliente;
        this.sgirocliente = sgirocliente;
    }

    /** default constructor */
    public CGiroCliente() {
    }

    /** minimal constructor */
    public CGiroCliente(java.lang.Integer cgirocliente) {
        this.cgirocliente = cgirocliente;
    }

    public java.lang.Integer getCgirocliente() {
        return this.cgirocliente;
    }

    public void setCgirocliente(java.lang.Integer cgirocliente) {
        this.cgirocliente = cgirocliente;
    }

    public java.lang.String getSgirocliente() {
        return this.sgirocliente;
    }

    public void setSgirocliente(java.lang.String sgirocliente) {
        this.sgirocliente = sgirocliente;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cgirocliente", getCgirocliente())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CGiroCliente) ) return false;
        CGiroCliente castOther = (CGiroCliente) other;
        return new EqualsBuilder()
            .append(this.getCgirocliente(), castOther.getCgirocliente())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCgirocliente())
            .toHashCode();
    }

}
