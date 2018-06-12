package mx.com.web2lab.backend.hbm.om.catalogos;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CTipoTexto implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipotexto;

    /** persistent field */
    private java.lang.String stipotexto;

    /** persistent field */
    private Set ctextointerpretacions;

    /** full constructor */
    public CTipoTexto(java.lang.Integer ctipotexto, java.lang.String stipotexto, Set ctextointerpretacions) {
        this.ctipotexto = ctipotexto;
        this.stipotexto = stipotexto;
        this.ctextointerpretacions = ctextointerpretacions;
    }

    /** default constructor */
    public CTipoTexto() {
    }

    public java.lang.Integer getCtipotexto() {
        return this.ctipotexto;
    }

    public void setCtipotexto(java.lang.Integer ctipotexto) {
        this.ctipotexto = ctipotexto;
    }

    public java.lang.String getStipotexto() {
        return this.stipotexto;
    }

    public void setStipotexto(java.lang.String stipotexto) {
        this.stipotexto = stipotexto;
    }

    public java.util.Set getCtextointerpretacions() {
        return this.ctextointerpretacions;
    }

    public void setCtextointerpretacions(java.util.Set ctextointerpretacions) {
        this.ctextointerpretacions = ctextointerpretacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipotexto", getCtipotexto())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoTexto) ) return false;
        CTipoTexto castOther = (CTipoTexto) other;
        return new EqualsBuilder()
            .append(this.getCtipotexto(), castOther.getCtipotexto())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipotexto())
            .toHashCode();
    }

}
