package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SPredefinido implements Serializable {

    /** identifier field */
    private java.lang.Integer cpredefinido;

    /** nullable persistent field */
    private java.lang.String spredefinido;

    /** nullable persistent field */
    private java.lang.String squery;

    /** full constructor */
    public SPredefinido(java.lang.Integer cpredefinido, java.lang.String spredefinido, java.lang.String squery) {
        this.cpredefinido = cpredefinido;
        this.spredefinido = spredefinido;
        this.squery = squery;
    }

    /** default constructor */
    public SPredefinido() {
    }

    /** minimal constructor */
    public SPredefinido(java.lang.Integer cpredefinido) {
        this.cpredefinido = cpredefinido;
    }

    public java.lang.Integer getCpredefinido() {
        return this.cpredefinido;
    }

    public void setCpredefinido(java.lang.Integer cpredefinido) {
        this.cpredefinido = cpredefinido;
    }

    public java.lang.String getSpredefinido() {
        return this.spredefinido;
    }

    public void setSpredefinido(java.lang.String spredefinido) {
        this.spredefinido = spredefinido;
    }

    public java.lang.String getSquery() {
        return this.squery;
    }

    public void setSquery(java.lang.String squery) {
        this.squery = squery;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpredefinido", getCpredefinido())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SPredefinido) ) return false;
        SPredefinido castOther = (SPredefinido) other;
        return new EqualsBuilder()
            .append(this.getCpredefinido(), castOther.getCpredefinido())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCpredefinido())
            .toHashCode();
    }

}
