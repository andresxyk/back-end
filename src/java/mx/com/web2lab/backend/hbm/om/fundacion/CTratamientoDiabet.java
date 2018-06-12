package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTratamientoDiabet implements Serializable {

    /** identifier field */
    private java.lang.Integer ctratamientodiabetes;

    /** nullable persistent field */
    private java.lang.String stratamientodiabetes;

    /** persistent field */
    private Set bpacientecuestionarios;

    /** full constructor */
    public CTratamientoDiabet(java.lang.Integer ctratamientodiabetes, java.lang.String stratamientodiabetes, Set bpacientecuestionarios) {
        this.ctratamientodiabetes = ctratamientodiabetes;
        this.stratamientodiabetes = stratamientodiabetes;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    /** default constructor */
    public CTratamientoDiabet() {
    }

    /** minimal constructor */
    public CTratamientoDiabet(java.lang.Integer ctratamientodiabetes, Set bpacientecuestionarios) {
        this.ctratamientodiabetes = ctratamientodiabetes;
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public java.lang.Integer getCtratamientodiabetes() {
        return this.ctratamientodiabetes;
    }

    public void setCtratamientodiabetes(java.lang.Integer ctratamientodiabetes) {
        this.ctratamientodiabetes = ctratamientodiabetes;
    }

    public java.lang.String getStratamientodiabetes() {
        return this.stratamientodiabetes;
    }

    public void setStratamientodiabetes(java.lang.String stratamientodiabetes) {
        this.stratamientodiabetes = stratamientodiabetes;
    }

    public java.util.Set getBpacientecuestionarios() {
        return this.bpacientecuestionarios;
    }

    public void setBpacientecuestionarios(java.util.Set bpacientecuestionarios) {
        this.bpacientecuestionarios = bpacientecuestionarios;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctratamientodiabetes", getCtratamientodiabetes())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTratamientoDiabet) ) return false;
        CTratamientoDiabet castOther = (CTratamientoDiabet) other;
        return new EqualsBuilder()
            .append(this.getCtratamientodiabetes(), castOther.getCtratamientodiabetes())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtratamientodiabetes())
            .toHashCode();
    }

}
