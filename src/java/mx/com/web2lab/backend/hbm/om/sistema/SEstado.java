package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SEstado implements Serializable {

    /** identifier field */
    private java.lang.Integer cestado;

    /** persistent field */
    private java.lang.String sestado;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.sistema.SEntidad sentidad;

    /** full constructor */
    public SEstado(java.lang.Integer cestado, java.lang.String sestado, mx.com.web2lab.backend.hbm.om.sistema.SEntidad sentidad) {
        this.cestado = cestado;
        this.sestado = sestado;
        this.sentidad = sentidad;
    }

    /** default constructor */
    public SEstado() {
    }

    public java.lang.Integer getCestado() {
        return this.cestado;
    }

    public void setCestado(java.lang.Integer cestado) {
        this.cestado = cestado;
    }

    public java.lang.String getSestado() {
        return this.sestado;
    }

    public void setSestado(java.lang.String sestado) {
        this.sestado = sestado;
    }

    public mx.com.web2lab.backend.hbm.om.sistema.SEntidad getSentidad() {
        return this.sentidad;
    }

    public void setSentidad(mx.com.web2lab.backend.hbm.om.sistema.SEntidad sentidad) {
        this.sentidad = sentidad;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cestado", getCestado())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SEstado) ) return false;
        SEstado castOther = (SEstado) other;
        return new EqualsBuilder()
            .append(this.getCestado(), castOther.getCestado())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCestado())
            .toHashCode();
    }

}
