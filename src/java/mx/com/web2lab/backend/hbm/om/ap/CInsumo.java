package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CInsumo implements Serializable {

    /** identifier field */
    private java.lang.Integer cinsumo;

    /** nullable persistent field */
    private java.lang.String sinsumo;

    /** full constructor */
    public CInsumo(java.lang.Integer cinsumo, java.lang.String sinsumo) {
        this.cinsumo = cinsumo;
        this.sinsumo = sinsumo;
    }

    /** default constructor */
    public CInsumo() {
    }

    /** minimal constructor */
    public CInsumo(java.lang.Integer cinsumo) {
        this.cinsumo = cinsumo;
    }

    public java.lang.Integer getCinsumo() {
        return this.cinsumo;
    }

    public void setCinsumo(java.lang.Integer cinsumo) {
        this.cinsumo = cinsumo;
    }

    public java.lang.String getSinsumo() {
        return this.sinsumo;
    }

    public void setSinsumo(java.lang.String sinsumo) {
        this.sinsumo = sinsumo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cinsumo", getCinsumo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CInsumo) ) return false;
        CInsumo castOther = (CInsumo) other;
        return new EqualsBuilder()
            .append(this.getCinsumo(), castOther.getCinsumo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCinsumo())
            .toHashCode();
    }

}
