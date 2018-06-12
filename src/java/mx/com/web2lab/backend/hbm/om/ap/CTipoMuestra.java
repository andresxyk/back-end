package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTipoMuestra implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipomuestra;

    /** nullable persistent field */
    private java.lang.String stipomuestra;

    /** full constructor */
    public CTipoMuestra(java.lang.Integer ctipomuestra, java.lang.String stipomuestra) {
        this.ctipomuestra = ctipomuestra;
        this.stipomuestra = stipomuestra;
    }

    /** default constructor */
    public CTipoMuestra() {
    }

    /** minimal constructor */
    public CTipoMuestra(java.lang.Integer ctipomuestra) {
        this.ctipomuestra = ctipomuestra;
    }

    public java.lang.Integer getCtipomuestra() {
        return this.ctipomuestra;
    }

    public void setCtipomuestra(java.lang.Integer ctipomuestra) {
        this.ctipomuestra = ctipomuestra;
    }

    public java.lang.String getStipomuestra() {
        return this.stipomuestra;
    }

    public void setStipomuestra(java.lang.String stipomuestra) {
        this.stipomuestra = stipomuestra;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipomuestra", getCtipomuestra())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoMuestra) ) return false;
        CTipoMuestra castOther = (CTipoMuestra) other;
        return new EqualsBuilder()
            .append(this.getCtipomuestra(), castOther.getCtipomuestra())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipomuestra())
            .toHashCode();
    }

}
