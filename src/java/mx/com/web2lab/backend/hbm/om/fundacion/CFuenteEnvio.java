package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CFuenteEnvio implements Serializable {

    /** identifier field */
    private java.lang.Integer cfuenteenvio;

    /** nullable persistent field */
    private java.lang.String sfuenteenvio;

    /** persistent field */
    private Set bpacientefundacions;

    /** full constructor */
    public CFuenteEnvio(java.lang.Integer cfuenteenvio, java.lang.String sfuenteenvio, Set bpacientefundacions) {
        this.cfuenteenvio = cfuenteenvio;
        this.sfuenteenvio = sfuenteenvio;
        this.bpacientefundacions = bpacientefundacions;
    }

    /** default constructor */
    public CFuenteEnvio() {
    }

    /** minimal constructor */
    public CFuenteEnvio(java.lang.Integer cfuenteenvio, Set bpacientefundacions) {
        this.cfuenteenvio = cfuenteenvio;
        this.bpacientefundacions = bpacientefundacions;
    }

    public java.lang.Integer getCfuenteenvio() {
        return this.cfuenteenvio;
    }

    public void setCfuenteenvio(java.lang.Integer cfuenteenvio) {
        this.cfuenteenvio = cfuenteenvio;
    }

    public java.lang.String getSfuenteenvio() {
        return this.sfuenteenvio;
    }

    public void setSfuenteenvio(java.lang.String sfuenteenvio) {
        this.sfuenteenvio = sfuenteenvio;
    }

    public java.util.Set getBpacientefundacions() {
        return this.bpacientefundacions;
    }

    public void setBpacientefundacions(java.util.Set bpacientefundacions) {
        this.bpacientefundacions = bpacientefundacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cfuenteenvio", getCfuenteenvio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CFuenteEnvio) ) return false;
        CFuenteEnvio castOther = (CFuenteEnvio) other;
        return new EqualsBuilder()
            .append(this.getCfuenteenvio(), castOther.getCfuenteenvio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCfuenteenvio())
            .toHashCode();
    }

}
