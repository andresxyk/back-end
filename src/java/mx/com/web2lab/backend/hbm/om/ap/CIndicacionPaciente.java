package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CIndicacionPaciente implements Serializable {

    /** identifier field */
    private java.lang.Integer cindicacionpaciente;

    /** nullable persistent field */
    private java.lang.String sindicacionpaciente;

    /** full constructor */
    public CIndicacionPaciente(java.lang.Integer cindicacionpaciente, java.lang.String sindicacionpaciente) {
        this.cindicacionpaciente = cindicacionpaciente;
        this.sindicacionpaciente = sindicacionpaciente;
    }

    /** default constructor */
    public CIndicacionPaciente() {
    }

    /** minimal constructor */
    public CIndicacionPaciente(java.lang.Integer cindicacionpaciente) {
        this.cindicacionpaciente = cindicacionpaciente;
    }

    public java.lang.Integer getCindicacionpaciente() {
        return this.cindicacionpaciente;
    }

    public void setCindicacionpaciente(java.lang.Integer cindicacionpaciente) {
        this.cindicacionpaciente = cindicacionpaciente;
    }

    public java.lang.String getSindicacionpaciente() {
        return this.sindicacionpaciente;
    }

    public void setSindicacionpaciente(java.lang.String sindicacionpaciente) {
        this.sindicacionpaciente = sindicacionpaciente;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cindicacionpaciente", getCindicacionpaciente())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CIndicacionPaciente) ) return false;
        CIndicacionPaciente castOther = (CIndicacionPaciente) other;
        return new EqualsBuilder()
            .append(this.getCindicacionpaciente(), castOther.getCindicacionpaciente())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCindicacionpaciente())
            .toHashCode();
    }

}
