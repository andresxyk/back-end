package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CEstadoCivil implements Serializable {

    /** identifier field */
    private java.lang.Integer cestadocivil;

    /** nullable persistent field */
    private java.lang.String sestadocivil;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CEstadoCivil(java.lang.Integer cestadocivil, java.lang.String sestadocivil, Set bpacientecuestionarios) {
        this.cestadocivil = cestadocivil;
        this.sestadocivil = sestadocivil;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CEstadoCivil() {
    }

    /** minimal constructor */
    public CEstadoCivil(java.lang.Integer cestadocivil, Set bpacientecuestionarios) {
        this.cestadocivil = cestadocivil;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCestadocivil() {
        return this.cestadocivil;
    }

    public void setCestadocivil(java.lang.Integer cestadocivil) {
        this.cestadocivil = cestadocivil;
    }

    public java.lang.String getSestadocivil() {
        return this.sestadocivil;
    }

    public void setSestadocivil(java.lang.String sestadocivil) {
        this.sestadocivil = sestadocivil;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cestadocivil", getCestadocivil())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CEstadoCivil) ) return false;
        CEstadoCivil castOther = (CEstadoCivil) other;
        return new EqualsBuilder()
            .append(this.getCestadocivil(), castOther.getCestadocivil())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCestadocivil())
            .toHashCode();
    }

}
