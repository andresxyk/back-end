package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurbineSistema implements Serializable {

    /** identifier field */
    private java.lang.Integer csistema;

    /** nullable persistent field */
    private java.lang.String ssistema;

    /** persistent field */
    private Set turbineGrupoDepartamentos;

    /** full constructor */
    public TurbineSistema(java.lang.Integer csistema, java.lang.String ssistema, Set turbineGrupoDepartamentos) {
        this.csistema = csistema;
        this.ssistema = ssistema;
        this.turbineGrupoDepartamentos = turbineGrupoDepartamentos;
    }

    /** default constructor */
    public TurbineSistema() {
    }

    /** minimal constructor */
    public TurbineSistema(java.lang.Integer csistema, Set turbineGrupoDepartamentos) {
        this.csistema = csistema;
        this.turbineGrupoDepartamentos = turbineGrupoDepartamentos;
    }

    public java.lang.Integer getCsistema() {
        return this.csistema;
    }

    public void setCsistema(java.lang.Integer csistema) {
        this.csistema = csistema;
    }

    public java.lang.String getSsistema() {
        return this.ssistema;
    }

    public void setSsistema(java.lang.String ssistema) {
        this.ssistema = ssistema;
    }

    public java.util.Set getTurbineGrupoDepartamentos() {
        return this.turbineGrupoDepartamentos;
    }

    public void setTurbineGrupoDepartamentos(java.util.Set turbineGrupoDepartamentos) {
        this.turbineGrupoDepartamentos = turbineGrupoDepartamentos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("csistema", getCsistema())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurbineSistema) ) return false;
        TurbineSistema castOther = (TurbineSistema) other;
        return new EqualsBuilder()
            .append(this.getCsistema(), castOther.getCsistema())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCsistema())
            .toHashCode();
    }

}
