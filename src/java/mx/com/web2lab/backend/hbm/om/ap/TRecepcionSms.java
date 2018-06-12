package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TRecepcionSms implements Serializable {

    /** identifier field */
    private java.lang.Integer ktrecepcionsms;

    /** persistent field */
    private long utelefono;

    /** nullable persistent field */
    private java.lang.String smensaje;

    /** full constructor */
    public TRecepcionSms(java.lang.Integer ktrecepcionsms, long utelefono, java.lang.String smensaje) {
        this.ktrecepcionsms = ktrecepcionsms;
        this.utelefono = utelefono;
        this.smensaje = smensaje;
    }

    /** default constructor */
    public TRecepcionSms() {
    }

    /** minimal constructor */
    public TRecepcionSms(java.lang.Integer ktrecepcionsms, long utelefono) {
        this.ktrecepcionsms = ktrecepcionsms;
        this.utelefono = utelefono;
    }

    public java.lang.Integer getKtrecepcionsms() {
        return this.ktrecepcionsms;
    }

    public void setKtrecepcionsms(java.lang.Integer ktrecepcionsms) {
        this.ktrecepcionsms = ktrecepcionsms;
    }

    public long getUtelefono() {
        return this.utelefono;
    }

    public void setUtelefono(long utelefono) {
        this.utelefono = utelefono;
    }

    public java.lang.String getSmensaje() {
        return this.smensaje;
    }

    public void setSmensaje(java.lang.String smensaje) {
        this.smensaje = smensaje;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ktrecepcionsms", getKtrecepcionsms())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TRecepcionSms) ) return false;
        TRecepcionSms castOther = (TRecepcionSms) other;
        return new EqualsBuilder()
            .append(this.getKtrecepcionsms(), castOther.getKtrecepcionsms())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKtrecepcionsms())
            .toHashCode();
    }

}
