package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTipoPersona implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipopersona;

    /** nullable persistent field */
    private java.lang.String stipopersona;

    /** persistent field */
    private Set cclientes;

    /** full constructor */
    public CTipoPersona(java.lang.Integer ctipopersona, java.lang.String stipopersona, Set cclientes) {
        this.ctipopersona = ctipopersona;
        this.stipopersona = stipopersona;
        this.cclientes = cclientes;
    }

    /** default constructor */
    public CTipoPersona() {
    }

    /** minimal constructor */
    public CTipoPersona(java.lang.Integer ctipopersona, Set cclientes) {
        this.ctipopersona = ctipopersona;
        this.cclientes = cclientes;
    }

    public java.lang.Integer getCtipopersona() {
        return this.ctipopersona;
    }

    public void setCtipopersona(java.lang.Integer ctipopersona) {
        this.ctipopersona = ctipopersona;
    }

    public java.lang.String getStipopersona() {
        return this.stipopersona;
    }

    public void setStipopersona(java.lang.String stipopersona) {
        this.stipopersona = stipopersona;
    }

    public java.util.Set getCclientes() {
        return this.cclientes;
    }

    public void setCclientes(java.util.Set cclientes) {
        this.cclientes = cclientes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipopersona", getCtipopersona())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoPersona) ) return false;
        CTipoPersona castOther = (CTipoPersona) other;
        return new EqualsBuilder()
            .append(this.getCtipopersona(), castOther.getCtipopersona())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipopersona())
            .toHashCode();
    }

}
