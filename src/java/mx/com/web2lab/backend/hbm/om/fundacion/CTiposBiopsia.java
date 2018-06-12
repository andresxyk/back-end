package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTiposBiopsia implements Serializable {

    /** identifier field */
    private java.lang.Integer ctiposBiopsia;

    /** nullable persistent field */
    private java.lang.String stiposBiopsia;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CTiposBiopsia(java.lang.Integer ctiposBiopsia, java.lang.String stiposBiopsia, Set bpacientecuestionarios) {
        this.ctiposBiopsia = ctiposBiopsia;
        this.stiposBiopsia = stiposBiopsia;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CTiposBiopsia() {
    }

    /** minimal constructor */
    public CTiposBiopsia(java.lang.Integer ctiposBiopsia, Set bpacientecuestionarios) {
        this.ctiposBiopsia = ctiposBiopsia;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCtiposBiopsia() {
        return this.ctiposBiopsia;
    }

    public void setCtiposBiopsia(java.lang.Integer ctiposBiopsia) {
        this.ctiposBiopsia = ctiposBiopsia;
    }

    public java.lang.String getStiposBiopsia() {
        return this.stiposBiopsia;
    }

    public void setStiposBiopsia(java.lang.String stiposBiopsia) {
        this.stiposBiopsia = stiposBiopsia;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctiposBiopsia", getCtiposBiopsia())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTiposBiopsia) ) return false;
        CTiposBiopsia castOther = (CTiposBiopsia) other;
        return new EqualsBuilder()
            .append(this.getCtiposBiopsia(), castOther.getCtiposBiopsia())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtiposBiopsia())
            .toHashCode();
    }

}
