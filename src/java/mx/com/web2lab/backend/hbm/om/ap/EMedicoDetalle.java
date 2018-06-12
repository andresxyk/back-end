package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EMedicoDetalle implements Serializable {

    /** identifier field */
    private java.lang.Integer kmedicodetalle;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.EMedicoPaquete emedicopaquete;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen;

    /** full constructor */
    public EMedicoDetalle(java.lang.Integer kmedicodetalle, mx.com.web2lab.backend.hbm.om.ap.EMedicoPaquete emedicopaquete, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.kmedicodetalle = kmedicodetalle;
        this.emedicopaquete = emedicopaquete;
        this.cexamen = cexamen;
    }

    /** default constructor */
    public EMedicoDetalle() {
    }

    public java.lang.Integer getKmedicodetalle() {
        return this.kmedicodetalle;
    }

    public void setKmedicodetalle(java.lang.Integer kmedicodetalle) {
        this.kmedicodetalle = kmedicodetalle;
    }

    public mx.com.web2lab.backend.hbm.om.ap.EMedicoPaquete getEmedicopaquete() {
        return this.emedicopaquete;
    }

    public void setEmedicopaquete(mx.com.web2lab.backend.hbm.om.ap.EMedicoPaquete emedicopaquete) {
        this.emedicopaquete = emedicopaquete;
    }

    public mx.com.web2lab.backend.hbm.om.lis.CExamen getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.cexamen = cexamen;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kmedicodetalle", getKmedicodetalle())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EMedicoDetalle) ) return false;
        EMedicoDetalle castOther = (EMedicoDetalle) other;
        return new EqualsBuilder()
            .append(this.getKmedicodetalle(), castOther.getKmedicodetalle())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKmedicodetalle())
            .toHashCode();
    }

}
