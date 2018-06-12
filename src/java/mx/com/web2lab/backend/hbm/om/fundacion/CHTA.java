package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CHTA implements Serializable {

    /** identifier field */
    private java.lang.Integer chta;

    /** nullable persistent field */
    private java.lang.String shta;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CHTA(java.lang.Integer chta, java.lang.String shta, Set bpacientecuestionarios) {
        this.chta = chta;
        this.shta = shta;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CHTA() {
    }

    /** minimal constructor */
    public CHTA(java.lang.Integer chta, Set bpacientecuestionarios) {
        this.chta = chta;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getChta() {
        return this.chta;
    }

    public void setChta(java.lang.Integer chta) {
        this.chta = chta;
    }

    public java.lang.String getShta() {
        return this.shta;
    }

    public void setShta(java.lang.String shta) {
        this.shta = shta;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("chta", getChta())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CHTA) ) return false;
        CHTA castOther = (CHTA) other;
        return new EqualsBuilder()
            .append(this.getChta(), castOther.getChta())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getChta())
            .toHashCode();
    }

}
