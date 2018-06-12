package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CClaveEnvio implements Serializable {

    /** identifier field */
    private java.lang.Integer cclaveenvio;

    /** nullable persistent field */
    private java.lang.String sclaveenvio;

    /** persistent field */
    private Set bpacientefundacions;

    /** full constructor */
    public CClaveEnvio(java.lang.Integer cclaveenvio, java.lang.String sclaveenvio, Set bpacientefundacions) {
        this.cclaveenvio = cclaveenvio;
        this.sclaveenvio = sclaveenvio;
        this.bpacientefundacions = bpacientefundacions;
    }

    /** default constructor */
    public CClaveEnvio() {
    }

    /** minimal constructor */
    public CClaveEnvio(java.lang.Integer cclaveenvio, Set bpacientefundacions) {
        this.cclaveenvio = cclaveenvio;
        this.bpacientefundacions = bpacientefundacions;
    }

    public java.lang.Integer getCclaveenvio() {
        return this.cclaveenvio;
    }

    public void setCclaveenvio(java.lang.Integer cclaveenvio) {
        this.cclaveenvio = cclaveenvio;
    }

    public java.lang.String getSclaveenvio() {
        return this.sclaveenvio;
    }

    public void setSclaveenvio(java.lang.String sclaveenvio) {
        this.sclaveenvio = sclaveenvio;
    }

    public java.util.Set getBpacientefundacions() {
        return this.bpacientefundacions;
    }

    public void setBpacientefundacions(java.util.Set bpacientefundacions) {
        this.bpacientefundacions = bpacientefundacions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cclaveenvio", getCclaveenvio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CClaveEnvio) ) return false;
        CClaveEnvio castOther = (CClaveEnvio) other;
        return new EqualsBuilder()
            .append(this.getCclaveenvio(), castOther.getCclaveenvio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCclaveenvio())
            .toHashCode();
    }

}

