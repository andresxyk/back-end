package mx.com.web2lab.backend.hbm.om.lis;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMuestra implements Serializable {

    /** identifier field */
    private java.lang.Integer cmuestra;

    /** nullable persistent field */
    private java.lang.String smuestra;

    /** full constructor */
    public CMuestra(java.lang.Integer cmuestra, java.lang.String smuestra) {
        this.cmuestra = cmuestra;
        this.smuestra = smuestra;
    }

    /** default constructor */
    public CMuestra() {
    }

    /** minimal constructor */
    public CMuestra(java.lang.Integer cmuestra) {
        this.cmuestra = cmuestra;
    }

    public java.lang.Integer getCmuestra() {
        return this.cmuestra;
    }

    public void setCmuestra(java.lang.Integer cmuestra) {
        this.cmuestra = cmuestra;
    }

    public java.lang.String getSmuestra() {
        return this.smuestra;
    }

    public void setSmuestra(java.lang.String smuestra) {
        this.smuestra = smuestra;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmuestra", getCmuestra())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMuestra) ) return false;
        CMuestra castOther = (CMuestra) other;
        return new EqualsBuilder()
            .append(this.getCmuestra(), castOther.getCmuestra())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmuestra())
            .toHashCode();
    }

}
