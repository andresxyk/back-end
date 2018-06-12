package mx.com.web2lab.backend.hbm.om.catalogos;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CTipoMotivo implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipomotivo;

    /** persistent field */
    private java.lang.String stipomotivo;

    /** persistent field */
    private Set cmotivos;

    /** full constructor */
    public CTipoMotivo(java.lang.Integer ctipomotivo, java.lang.String stipomotivo, Set cmotivos) {
        this.ctipomotivo = ctipomotivo;
        this.stipomotivo = stipomotivo;
        this.cmotivos = cmotivos;
    }

    /** default constructor */
    public CTipoMotivo() {
    }

    public java.lang.Integer getCtipomotivo() {
        return this.ctipomotivo;
    }

    public void setCtipomotivo(java.lang.Integer ctipomotivo) {
        this.ctipomotivo = ctipomotivo;
    }

    public java.lang.String getStipomotivo() {
        return this.stipomotivo;
    }

    public void setStipomotivo(java.lang.String stipomotivo) {
        this.stipomotivo = stipomotivo;
    }

    public java.util.Set getCmotivos() {
        return this.cmotivos;
    }

    public void setCmotivos(java.util.Set cmotivos) {
        this.cmotivos = cmotivos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipomotivo", getCtipomotivo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CTipoMotivo) ) return false;
        CTipoMotivo castOther = (CTipoMotivo) other;
        return new EqualsBuilder()
            .append(this.getCtipomotivo(), castOther.getCtipomotivo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipomotivo())
            .toHashCode();
    }

}
