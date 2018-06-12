package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CMucosaAtrofica implements Serializable {

    /** identifier field */
    private java.lang.Integer cmucosaAtrofica;

    /** nullable persistent field */
    private java.lang.String smucosaAtrofica;


    /** full constructor */
    public CMucosaAtrofica(java.lang.Integer cmucosaAtrofica, java.lang.String smucosaAtrofica) {
        this.cmucosaAtrofica = cmucosaAtrofica;
        this.smucosaAtrofica = smucosaAtrofica;
    }

    /** default constructor */
    public CMucosaAtrofica() {
    }

    /** minimal constructor */
    public CMucosaAtrofica(java.lang.Integer cmucosaAtrofica) {
        this.cmucosaAtrofica = cmucosaAtrofica;
    }

    public java.lang.Integer getCmucosaAtrofica() {
        return this.cmucosaAtrofica;
    }

    public void setCmucosaAtrofica(java.lang.Integer cmucosaAtrofica) {
        this.cmucosaAtrofica = cmucosaAtrofica;
    }

    public java.lang.String getSmucosaAtrofica() {
        return this.smucosaAtrofica;
    }

    public void setSmucosaAtrofica(java.lang.String smucosaAtrofica) {
        this.smucosaAtrofica = smucosaAtrofica;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmucosaAtrofica", getCmucosaAtrofica())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMucosaAtrofica) ) return false;
        CMucosaAtrofica castOther = (CMucosaAtrofica) other;
        return new EqualsBuilder()
            .append(this.getCmucosaAtrofica(), castOther.getCmucosaAtrofica())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmucosaAtrofica())
            .toHashCode();
    }

}
