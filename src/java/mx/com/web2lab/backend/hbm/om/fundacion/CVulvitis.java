package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CVulvitis implements Serializable {

    /** identifier field */
    private java.lang.Integer cvulvitis;

    /** nullable persistent field */
    private java.lang.String svulvitis;

    /** full constructor */
    public CVulvitis(java.lang.Integer cvulvitis, java.lang.String svulvitis) {
        this.cvulvitis = cvulvitis;
        this.svulvitis = svulvitis;
    }

    /** default constructor */
    public CVulvitis() {
    }

    /** minimal constructor */
    public CVulvitis(java.lang.Integer cvulvitis) {
        this.cvulvitis = cvulvitis;
    }

    public java.lang.Integer getCvulvitis() {
        return this.cvulvitis;
    }

    public void setCvulvitis(java.lang.Integer cvulvitis) {
        this.cvulvitis = cvulvitis;
    }

    public java.lang.String getSvulvitis() {
        return this.svulvitis;
    }

    public void setSvulvitis(java.lang.String svulvitis) {
        this.svulvitis = svulvitis;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cvulvitis", getCvulvitis())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CVulvitis) ) return false;
        CVulvitis castOther = (CVulvitis) other;
        return new EqualsBuilder()
            .append(this.getCvulvitis(), castOther.getCvulvitis())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCvulvitis())
            .toHashCode();
    }

}
