package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CTiempoProceso implements Serializable {

    /** identifier field */
    private java.lang.Integer ctiempoproceso;

    /** nullable persistent field */
    private java.lang.String stiempoproceso;

    /** full constructor */
    public CTiempoProceso(java.lang.Integer ctiempoproceso, java.lang.String stiempoproceso) {
        this.ctiempoproceso = ctiempoproceso;
        this.stiempoproceso = stiempoproceso;
    }

    /** default constructor */
    public CTiempoProceso() {
    }

    /** minimal constructor */
    public CTiempoProceso(java.lang.Integer ctiempoproceso) {
        this.ctiempoproceso = ctiempoproceso;
    }

    public java.lang.Integer getCtiempoproceso() {
        return this.ctiempoproceso;
    }

    public void setCtiempoproceso(java.lang.Integer ctiempoproceso) {
        this.ctiempoproceso = ctiempoproceso;
    }

    public java.lang.String getStiempoproceso() {
        return this.stiempoproceso;
    }

    public void setStiempoproceso(java.lang.String stiempoproceso) {
        this.stiempoproceso = stiempoproceso;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctiempoproceso", getCtiempoproceso())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTiempoProceso) ) return false;
        CTiempoProceso castOther = (CTiempoProceso) other;
        return new EqualsBuilder()
            .append(this.getCtiempoproceso(), castOther.getCtiempoproceso())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtiempoproceso())
            .toHashCode();
    }

}
