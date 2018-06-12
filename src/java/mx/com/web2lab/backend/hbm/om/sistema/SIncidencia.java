package mx.com.web2lab.backend.hbm.om.sistema;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SIncidencia implements Serializable {

    /** identifier field */
    private java.lang.Integer cincidencia;

    /** persistent field */
    private java.lang.String sincidencia;

    /** nullable persistent field */
    private boolean bgeneral;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.sistema.STipoIncidencia stipoincidencia;

    /** persistent field */
    private Set cmotivos;

    /** full constructor */
    public SIncidencia(java.lang.Integer cincidencia, java.lang.String sincidencia, boolean bgeneral, mx.com.web2lab.backend.hbm.om.sistema.STipoIncidencia stipoincidencia, Set cmotivos) {
        this.cincidencia = cincidencia;
        this.sincidencia = sincidencia;
        this.bgeneral = bgeneral;
        this.stipoincidencia = stipoincidencia;
        this.cmotivos = cmotivos;
    }

    /** default constructor */
    public SIncidencia() {
    }

    /** minimal constructor */
    public SIncidencia(java.lang.Integer cincidencia, java.lang.String sincidencia, mx.com.web2lab.backend.hbm.om.sistema.STipoIncidencia stipoincidencia, Set cmotivos) {
        this.cincidencia = cincidencia;
        this.sincidencia = sincidencia;
        this.stipoincidencia = stipoincidencia;
        this.cmotivos = cmotivos;
    }

    public java.lang.Integer getCincidencia() {
        return this.cincidencia;
    }

    public void setCincidencia(java.lang.Integer cincidencia) {
        this.cincidencia = cincidencia;
    }

    public java.lang.String getSincidencia() {
        return this.sincidencia;
    }

    public void setSincidencia(java.lang.String sincidencia) {
        this.sincidencia = sincidencia;
    }

    public boolean isBgeneral() {
        return this.bgeneral;
    }

    public void setBgeneral(boolean bgeneral) {
        this.bgeneral = bgeneral;
    }

    public mx.com.web2lab.backend.hbm.om.sistema.STipoIncidencia getStipoincidencia() {
        return this.stipoincidencia;
    }

    public void setStipoincidencia(mx.com.web2lab.backend.hbm.om.sistema.STipoIncidencia stipoincidencia) {
        this.stipoincidencia = stipoincidencia;
    }

    public java.util.Set getCmotivos() {
        return this.cmotivos;
    }

    public void setCmotivos(java.util.Set cmotivos) {
        this.cmotivos = cmotivos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cincidencia", getCincidencia())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SIncidencia) ) return false;
        SIncidencia castOther = (SIncidencia) other;
        return new EqualsBuilder()
            .append(this.getCincidencia(), castOther.getCincidencia())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCincidencia())
            .toHashCode();
    }

}
