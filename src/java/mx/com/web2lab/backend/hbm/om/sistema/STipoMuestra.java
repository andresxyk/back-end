package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoMuestra implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipomuestra;

    /** persistent field */
    private java.lang.String stipomuestra;

    /** persistent field */
    private Set dexamenmuestras;

    /** full constructor */
    public STipoMuestra(java.lang.Integer ctipomuestra, java.lang.String stipomuestra, Set dexamenmuestras) {
        this.ctipomuestra = ctipomuestra;
        this.stipomuestra = stipomuestra;
        this.dexamenmuestras = dexamenmuestras;
    }

    /** default constructor */
    public STipoMuestra() {
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

    public java.util.Set getDexamenmuestras() {
        return this.dexamenmuestras;
    }

    public void setDexamenmuestras(java.util.Set dexamenmuestras) {
        this.dexamenmuestras = dexamenmuestras;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipomuestra", getCtipomuestra())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoMuestra) ) return false;
        STipoMuestra castOther = (STipoMuestra) other;
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
