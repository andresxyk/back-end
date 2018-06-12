package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CDiu implements Serializable {

    /** identifier field */
    private java.lang.Integer cdiu;

    /** nullable persistent field */
    private java.lang.String sdiu;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CDiu(java.lang.Integer cdiu, java.lang.String sdiu, Set bpacientecuestionarios) {
        this.cdiu = cdiu;
        this.sdiu = sdiu;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CDiu() {
    }

    /** minimal constructor */
    public CDiu(java.lang.Integer cdiu, Set bpacientecuestionarios) {
        this.cdiu = cdiu;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCdiu() {
        return this.cdiu;
    }

    public void setCdiu(java.lang.Integer cdiu) {
        this.cdiu = cdiu;
    }

    public java.lang.String getSdiu() {
        return this.sdiu;
    }

    public void setSdiu(java.lang.String sdiu) {
        this.sdiu = sdiu;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdiu", getCdiu())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CDiu) ) return false;
        CDiu castOther = (CDiu) other;
        return new EqualsBuilder()
            .append(this.getCdiu(), castOther.getCdiu())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdiu())
            .toHashCode();
    }

}
