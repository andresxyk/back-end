package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class COcupacionFamiliar implements Serializable {

    /** identifier field */
    private java.lang.Integer cocupacionfamiliar;

    /** nullable persistent field */
    private java.lang.String socupacionfamiliar;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public COcupacionFamiliar(java.lang.Integer cocupacionfamiliar, java.lang.String socupacionfamiliar, Set bpacientecuestionarios) {
        this.cocupacionfamiliar = cocupacionfamiliar;
        this.socupacionfamiliar = socupacionfamiliar;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public COcupacionFamiliar() {
    }

    /** minimal constructor */
    public COcupacionFamiliar(java.lang.Integer cocupacionfamiliar, Set bpacientecuestionarios) {
        this.cocupacionfamiliar = cocupacionfamiliar;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCocupacionfamiliar() {
        return this.cocupacionfamiliar;
    }

    public void setCocupacionfamiliar(java.lang.Integer cocupacionfamiliar) {
        this.cocupacionfamiliar = cocupacionfamiliar;
    }

    public java.lang.String getSocupacionfamiliar() {
        return this.socupacionfamiliar;
    }

    public void setSocupacionfamiliar(java.lang.String socupacionfamiliar) {
        this.socupacionfamiliar = socupacionfamiliar;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cocupacionfamiliar", getCocupacionfamiliar())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof COcupacionFamiliar) ) return false;
        COcupacionFamiliar castOther = (COcupacionFamiliar) other;
        return new EqualsBuilder()
            .append(this.getCocupacionfamiliar(), castOther.getCocupacionfamiliar())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCocupacionfamiliar())
            .toHashCode();
    }

}

