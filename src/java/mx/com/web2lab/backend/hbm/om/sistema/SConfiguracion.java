package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SConfiguracion implements Serializable {

    /** identifier field */
    private java.lang.Integer cconfiguracion;

    /** nullable persistent field */
    private java.lang.String sconfiguracion;

    /** nullable persistent field */
    private int uconfiguracion;

    /** full constructor */
    public SConfiguracion(java.lang.Integer cconfiguracion, java.lang.String sconfiguracion, int uconfiguracion) {
        this.cconfiguracion = cconfiguracion;
        this.sconfiguracion = sconfiguracion;
        this.uconfiguracion = uconfiguracion;
    }

    /** default constructor */
    public SConfiguracion() {
    }

    /** minimal constructor */
    public SConfiguracion(java.lang.Integer cconfiguracion) {
        this.cconfiguracion = cconfiguracion;
    }

    public java.lang.Integer getCconfiguracion() {
        return this.cconfiguracion;
    }

    public void setCconfiguracion(java.lang.Integer cconfiguracion) {
        this.cconfiguracion = cconfiguracion;
    }

    public java.lang.String getSconfiguracion() {
        return this.sconfiguracion;
    }

    public void setSconfiguracion(java.lang.String sconfiguracion) {
        this.sconfiguracion = sconfiguracion;
    }

    public int getUconfiguracion() {
        return this.uconfiguracion;
    }

    public void setUconfiguracion(int uconfiguracion) {
        this.uconfiguracion = uconfiguracion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cconfiguracion", getCconfiguracion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SConfiguracion) ) return false;
        SConfiguracion castOther = (SConfiguracion) other;
        return new EqualsBuilder()
            .append(this.getCconfiguracion(), castOther.getCconfiguracion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCconfiguracion())
            .toHashCode();
    }

}
