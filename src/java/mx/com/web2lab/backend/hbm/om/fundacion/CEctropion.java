package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CEctropion implements Serializable {

    /** identifier field */
    private java.lang.Integer cectropion;

    /** nullable persistent field */
    private java.lang.String sectropion;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CEctropion(java.lang.Integer cectropion, java.lang.String sectropion, Set bpacientecuestionarios) {
        this.cectropion = cectropion;
        this.sectropion = sectropion;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CEctropion() {
    }

    /** minimal constructor */
    public CEctropion(java.lang.Integer cectropion, Set bpacientecuestionarios) {
        this.cectropion = cectropion;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCectropion() {
        return this.cectropion;
    }

    public void setCectropion(java.lang.Integer cectropion) {
        this.cectropion = cectropion;
    }

    public java.lang.String getSectropion() {
        return this.sectropion;
    }

    public void setSectropion(java.lang.String sectropion) {
        this.sectropion = sectropion;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cectropion", getCectropion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CEctropion) ) return false;
        CEctropion castOther = (CEctropion) other;
        return new EqualsBuilder()
            .append(this.getCectropion(), castOther.getCectropion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCectropion())
            .toHashCode();
    }

}
