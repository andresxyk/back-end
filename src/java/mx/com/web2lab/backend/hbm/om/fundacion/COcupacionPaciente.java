package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class COcupacionPaciente implements Serializable {

    /** identifier field */
    private java.lang.Integer cocupacionpaciente;

    /** nullable persistent field */
    private java.lang.String socupacionpaciente;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public COcupacionPaciente(java.lang.Integer cocupacionpaciente, java.lang.String socupacionpaciente, Set bpacientecuestionarios) {
        this.cocupacionpaciente = cocupacionpaciente;
        this.socupacionpaciente = socupacionpaciente;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public COcupacionPaciente() {
    }

    /** minimal constructor */
    public COcupacionPaciente(java.lang.Integer cocupacionpaciente, Set bpacientecuestionarios) {
        this.cocupacionpaciente = cocupacionpaciente;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCocupacionpaciente() {
        return this.cocupacionpaciente;
    }

    public void setCocupacionpaciente(java.lang.Integer cocupacionpaciente) {
        this.cocupacionpaciente = cocupacionpaciente;
    }

    public java.lang.String getSocupacionpaciente() {
        return this.socupacionpaciente;
    }

    public void setSocupacionpaciente(java.lang.String socupacionpaciente) {
        this.socupacionpaciente = socupacionpaciente;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cocupacionpaciente", getCocupacionpaciente())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof COcupacionPaciente) ) return false;
        COcupacionPaciente castOther = (COcupacionPaciente) other;
        return new EqualsBuilder()
            .append(this.getCocupacionpaciente(), castOther.getCocupacionpaciente())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCocupacionpaciente())
            .toHashCode();
    }

}
