package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CClasificacionComercial implements Serializable {

    /** identifier field */
    private java.lang.Integer cclasificacioncomercial;

    /** nullable persistent field */
    private java.lang.String sclasificacioncomercial;

    /** persistent field */
    private Set cexamens;

    /** persistent field */
    private Set econvenioclasificacions;

    /** full constructor */
    public CClasificacionComercial(java.lang.Integer cclasificacioncomercial, java.lang.String sclasificacioncomercial, Set cexamens, Set econvenioclasificacions) {
        this.cclasificacioncomercial = cclasificacioncomercial;
        this.sclasificacioncomercial = sclasificacioncomercial;
        this.cexamens = cexamens;
        this.econvenioclasificacions = econvenioclasificacions;
    }

    /** default constructor */
    public CClasificacionComercial() {
    }

    /** minimal constructor */
    public CClasificacionComercial(java.lang.Integer cclasificacioncomercial, Set cexamens, Set econvenioclasificacions) {
        this.cclasificacioncomercial = cclasificacioncomercial;
        this.cexamens = cexamens;
        this.econvenioclasificacions = econvenioclasificacions;
    }

    public java.lang.Integer getCclasificacioncomercial() {
        return this.cclasificacioncomercial;
    }

    public void setCclasificacioncomercial(java.lang.Integer cclasificacioncomercial) {
        this.cclasificacioncomercial = cclasificacioncomercial;
    }

    public java.lang.String getSclasificacioncomercial() {
        return this.sclasificacioncomercial;
    }

    public void setSclasificacioncomercial(java.lang.String sclasificacioncomercial) {
        this.sclasificacioncomercial = sclasificacioncomercial;
    }

    public java.util.Set getCexamens() {
        return this.cexamens;
    }

    public void setCexamens(java.util.Set cexamens) {
        this.cexamens = cexamens;
    }

    public java.util.Set getEconvenioclasificacions() {
        return this.econvenioclasificacions;
    }

    public void setEconvenioclasificacions(java.util.Set econvenioclasificacions) {
        this.econvenioclasificacions = econvenioclasificacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cclasificacioncomercial", getCclasificacioncomercial())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CClasificacionComercial) ) return false;
        CClasificacionComercial castOther = (CClasificacionComercial) other;
        return new EqualsBuilder()
            .append(this.getCclasificacioncomercial(), castOther.getCclasificacioncomercial())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCclasificacioncomercial())
            .toHashCode();
    }

}
