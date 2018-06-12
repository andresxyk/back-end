package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTipoComercial implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipocomercial;

    /** nullable persistent field */
    private java.lang.String sdescripcioncomercial;

    /** persistent field */
    private Set cexamens;


    /** full constructor */
    public CTipoComercial(java.lang.Integer ctipocomercial, java.lang.String sdescripcioncomercial, Set cexamens) {
        this.ctipocomercial = ctipocomercial;
        this.sdescripcioncomercial = sdescripcioncomercial;
        this.cexamens = cexamens;
    }

    /** default constructor */
    public CTipoComercial() {
    }

    /** minimal constructor */
    public CTipoComercial(java.lang.Integer ctipocomercial, Set cexamens) {
        this.ctipocomercial = ctipocomercial;
        this.cexamens = cexamens;
    }

    public java.lang.Integer getCtipocomercial() {
        return this.ctipocomercial;
    }

    public void setCtipocomercial(java.lang.Integer ctipocomercial) {
        this.ctipocomercial = ctipocomercial;
    }

    public java.lang.String getSdescripcioncomercial() {
        return this.sdescripcioncomercial;
    }

    public void setSdescripcioncomercial(java.lang.String sdescripcioncomercial) {
        this.sdescripcioncomercial = sdescripcioncomercial;
    }

    public java.util.Set getCexamens() {
        return this.cexamens;
    }

    public void setCexamens(java.util.Set cexamens) {
        this.cexamens = cexamens;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipocomercial", getCtipocomercial())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoComercial) ) return false;
        CTipoComercial castOther = (CTipoComercial) other;
        return new EqualsBuilder()
            .append(this.getCtipocomercial(), castOther.getCtipocomercial())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipocomercial())
            .toHashCode();
    }

}
