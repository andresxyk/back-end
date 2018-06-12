package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class STipoIncidencia implements Serializable {

    /** identifier field */
    private java.lang.Integer ctipoincidencia;

    /** persistent field */
    private java.lang.String stipoincidencia;

    /** persistent field */
    private Set sincidencias;

    /** full constructor */
    public STipoIncidencia(java.lang.Integer ctipoincidencia, java.lang.String stipoincidencia, Set sincidencias) {
        this.ctipoincidencia = ctipoincidencia;
        this.stipoincidencia = stipoincidencia;
        this.sincidencias = sincidencias;
    }

    /** default constructor */
    public STipoIncidencia() {
    }

    public java.lang.Integer getCtipoincidencia() {
        return this.ctipoincidencia;
    }

    public void setCtipoincidencia(java.lang.Integer ctipoincidencia) {
        this.ctipoincidencia = ctipoincidencia;
    }

    public java.lang.String getStipoincidencia() {
        return this.stipoincidencia;
    }

    public void setStipoincidencia(java.lang.String stipoincidencia) {
        this.stipoincidencia = stipoincidencia;
    }

    public java.util.Set getSincidencias() {
        return this.sincidencias;
    }

    public void setSincidencias(java.util.Set sincidencias) {
        this.sincidencias = sincidencias;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ctipoincidencia", getCtipoincidencia())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof STipoIncidencia) ) return false;
        STipoIncidencia castOther = (STipoIncidencia) other;
        return new EqualsBuilder()
            .append(this.getCtipoincidencia(), castOther.getCtipoincidencia())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCtipoincidencia())
            .toHashCode();
    }

}
