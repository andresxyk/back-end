package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TPacienteDatosComplemento implements Serializable {

    /** identifier field */
    private java.lang.Integer kpacientedatocomplemento;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente;

    /** full constructor */
    public TPacienteDatosComplemento(java.lang.Integer kpacientedatocomplemento, mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente) {
        this.kpacientedatocomplemento = kpacientedatocomplemento;
        this.tpaciente = tpaciente;
    }

    /** default constructor */
    public TPacienteDatosComplemento() {
    }

    public java.lang.Integer getKpacientedatocomplemento() {
        return this.kpacientedatocomplemento;
    }

    public void setKpacientedatocomplemento(java.lang.Integer kpacientedatocomplemento) {
        this.kpacientedatocomplemento = kpacientedatocomplemento;
    }

    public mx.com.web2lab.backend.hbm.om.ap.TPaciente getTpaciente() {
        return this.tpaciente;
    }

    public void setTpaciente(mx.com.web2lab.backend.hbm.om.ap.TPaciente tpaciente) {
        this.tpaciente = tpaciente;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kpacientedatocomplemento", getKpacientedatocomplemento())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TPacienteDatosComplemento) ) return false;
        TPacienteDatosComplemento castOther = (TPacienteDatosComplemento) other;
        return new EqualsBuilder()
            .append(this.getKpacientedatocomplemento(), castOther.getKpacientedatocomplemento())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKpacientedatocomplemento())
            .toHashCode();
    }

}
