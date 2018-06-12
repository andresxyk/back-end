package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CAtrofia implements Serializable {

    /** identifier field */
    private java.lang.Integer catrofia;

    /** nullable persistent field */
    private java.lang.String satrofia;

    /** full constructor */
    public CAtrofia(java.lang.Integer catrofia, java.lang.String satrofia) {
        this.catrofia = catrofia;
        this.satrofia = satrofia;
    }

    /** default constructor */
    public CAtrofia() {
    }

    /** minimal constructor */
    public CAtrofia(java.lang.Integer catrofia) {
        this.catrofia = catrofia;
    }

    public java.lang.Integer getCatrofia() {
        return this.catrofia;
    }

    public void setCatrofia(java.lang.Integer catrofia) {
        this.catrofia = catrofia;
    }

    public java.lang.String getSatrofia() {
        return this.satrofia;
    }

    public void setSatrofia(java.lang.String satrofia) {
        this.satrofia = satrofia;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("catrofia", getCatrofia())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CAtrofia) ) return false;
        CAtrofia castOther = (CAtrofia) other;
        return new EqualsBuilder()
            .append(this.getCatrofia(), castOther.getCatrofia())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCatrofia())
            .toHashCode();
    }
}
