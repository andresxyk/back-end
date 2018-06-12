package mx.com.web2lab.backend.hbm.om.lis;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CContenedor implements Serializable {

    /** identifier field */
    private java.lang.Integer ccontenedor;

    /** nullable persistent field */
    private java.lang.String scontenedor;

    /** full constructor */
    public CContenedor(java.lang.Integer ccontenedor, java.lang.String scontenedor) {
        this.ccontenedor = ccontenedor;
        this.scontenedor = scontenedor;
    }

    /** default constructor */
    public CContenedor() {
    }

    /** minimal constructor */
    public CContenedor(java.lang.Integer ccontenedor) {
        this.ccontenedor = ccontenedor;
    }

    public java.lang.Integer getCcontenedor() {
        return this.ccontenedor;
    }

    public void setCcontenedor(java.lang.Integer ccontenedor) {
        this.ccontenedor = ccontenedor;
    }

    public java.lang.String getScontenedor() {
        return this.scontenedor;
    }

    public void setScontenedor(java.lang.String scontenedor) {
        this.scontenedor = scontenedor;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccontenedor", getCcontenedor())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CContenedor) ) return false;
        CContenedor castOther = (CContenedor) other;
        return new EqualsBuilder()
            .append(this.getCcontenedor(), castOther.getCcontenedor())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcontenedor())
            .toHashCode();
    }

}
