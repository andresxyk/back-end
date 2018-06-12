package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoUsuario implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipousuario;

    /** nullable persistent field */
    private java.lang.String stipousuario;

    /** full constructor */
    public STipoUsuario(java.lang.Integer ctipousuario, java.lang.String stipousuario) {
        this.ctipousuario = ctipousuario;
        this.stipousuario = stipousuario;
    }

    /** default constructor */
    public STipoUsuario() {
    }

    /** minimal constructor */
    public STipoUsuario(java.lang.Integer ctipousuario) {
        this.ctipousuario = ctipousuario;
    }

    public java.lang.Integer getCtipousuario() {
        return this.ctipousuario;
    }

    public void setCtipousuario(java.lang.Integer ctipousuario) {
        this.ctipousuario = ctipousuario;
    }

    public java.lang.String getStipousuario() {
        return this.stipousuario;
    }

    public void setStipousuario(java.lang.String stipousuario) {
        this.stipousuario = stipousuario;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipousuario", getCtipousuario())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoUsuario) ) return false;
        STipoUsuario castOther = (STipoUsuario) other;
        return new EqualsBuilder()
            .append(this.getCtipousuario(), castOther.getCtipousuario())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipousuario())
            .toHashCode();
    }

}
