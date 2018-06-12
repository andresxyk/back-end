package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CComunidad implements Serializable {

    /** identifier field */
    private java.lang.Integer ccomunidad;

    /** nullable persistent field */
    private java.lang.String scomunidad;

    /** nullable persistent field */
    private java.lang.String sclave;

    /** nullable persistent field */
    private short uclave;

    /** persistent field */
    private Set bpacientefundacions;

    /** full constructor */
    public CComunidad(java.lang.Integer ccomunidad, java.lang.String scomunidad, java.lang.String sclave, short uclave, Set bpacientefundacions) {
        this.ccomunidad = ccomunidad;
        this.scomunidad = scomunidad;
        this.sclave = sclave;
        this.uclave = uclave;
        this.bpacientefundacions = bpacientefundacions;
    }

    /** default constructor */
    public CComunidad() {
    }

    /** minimal constructor */
    public CComunidad(java.lang.Integer ccomunidad, Set bpacientefundacions) {
        this.ccomunidad = ccomunidad;
        this.bpacientefundacions = bpacientefundacions;
    }

    public java.lang.Integer getCcomunidad() {
        return this.ccomunidad;
    }

    public void setCcomunidad(java.lang.Integer ccomunidad) {
        this.ccomunidad = ccomunidad;
    }

    public java.lang.String getScomunidad() {
        return this.scomunidad;
    }

    public void setScomunidad(java.lang.String scomunidad) {
        this.scomunidad = scomunidad;
    }

    public java.lang.String getSclave() {
        return this.sclave;
    }

    public void setSclave(java.lang.String sclave) {
        this.sclave = sclave;
    }

    public short getUclave() {
        return this.uclave;
    }

    public void setUclave(short uclave) {
        this.uclave = uclave;
    }

    public java.util.Set getBpacientefundacions() {
        return this.bpacientefundacions;
    }

    public void setBpacientefundacions(java.util.Set bpacientefundacions) {
        this.bpacientefundacions = bpacientefundacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccomunidad", getCcomunidad())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CComunidad) ) return false;
        CComunidad castOther = (CComunidad) other;
        return new EqualsBuilder()
            .append(this.getCcomunidad(), castOther.getCcomunidad())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcomunidad())
            .toHashCode();
    }

}

