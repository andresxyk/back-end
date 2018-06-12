package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SFormula implements Serializable {

    /** identifier field */
    private java.lang.Boolean cformula;

    /** full constructor */
    public SFormula(java.lang.Boolean cformula) {
        this.cformula = cformula;
    }

    /** default constructor */
    public SFormula() {
    }

    public java.lang.Boolean getCformula() {
        return this.cformula;
    }

    public void setCformula(java.lang.Boolean cformula) {
        this.cformula = cformula;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cformula", getCformula())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SFormula) ) return false;
        SFormula castOther = (SFormula) other;
        return new EqualsBuilder()
            .append(this.getCformula(), castOther.getCformula())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCformula())
            .toHashCode();
    }

}
