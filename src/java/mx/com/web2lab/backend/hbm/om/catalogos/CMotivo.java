package mx.com.web2lab.backend.hbm.om.catalogos;

import java.io.Serializable;
import java.util.Set;

import mx.com.web2lab.backend.hbm.om.sistema.SIncidencia;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CMotivo implements Serializable {

    /** identifier field */
    private java.lang.Integer cmotivo;

    /** persistent field */
    private java.lang.String smotivo;

    /** nullable persistent field */
    private mx.com.web2lab.backend.hbm.om.catalogos.CTipoMotivo ctipomotivo;

    /** nullable persistent field */
    private SIncidencia sincidencia;

    /** persistent field */
    private Set bincidencias;

    /** persistent field */
    private Set bmotivoordens;

    /** persistent field */
    private Set bincidenciaunidads;

    /** full constructor */
    public CMotivo(java.lang.Integer cmotivo, java.lang.String smotivo, mx.com.web2lab.backend.hbm.om.catalogos.CTipoMotivo ctipomotivo, SIncidencia sincidencia, Set bincidencias, Set bmotivoordens, Set bincidenciaunidads) {
        this.cmotivo = cmotivo;
        this.smotivo = smotivo;
        this.ctipomotivo = ctipomotivo;
        this.sincidencia = sincidencia;
        this.bincidencias = bincidencias;
        this.bmotivoordens = bmotivoordens;
        this.bincidenciaunidads = bincidenciaunidads;
    }

    /** default constructor */
    public CMotivo() {
    }

    /** minimal constructor */
    public CMotivo(java.lang.Integer cmotivo, java.lang.String smotivo, Set bincidencias, Set bmotivoordens, Set bincidenciaunidads) {
        this.cmotivo = cmotivo;
        this.smotivo = smotivo;
        this.bincidencias = bincidencias;
        this.bmotivoordens = bmotivoordens;
        this.bincidenciaunidads = bincidenciaunidads;
    }

    public java.lang.Integer getCmotivo() {
        return this.cmotivo;
    }

    public void setCmotivo(java.lang.Integer cmotivo) {
        this.cmotivo = cmotivo;
    }

    public java.lang.String getSmotivo() {
        return this.smotivo;
    }

    public void setSmotivo(java.lang.String smotivo) {
        this.smotivo = smotivo;
    }

    public mx.com.web2lab.backend.hbm.om.catalogos.CTipoMotivo getCtipomotivo() {
        return this.ctipomotivo;
    }

    public void setCtipomotivo(mx.com.web2lab.backend.hbm.om.catalogos.CTipoMotivo ctipomotivo) {
        this.ctipomotivo = ctipomotivo;
    }

    public mx.com.web2lab.backend.hbm.om.sistema.SIncidencia getSincidencia() {
        return this.sincidencia;
    }

    public void setSincidencia(mx.com.web2lab.backend.hbm.om.sistema.SIncidencia sincidencia) {
        this.sincidencia = sincidencia;
    }

    public java.util.Set getBincidencias() {
        return this.bincidencias;
    }

    public void setBincidencias(java.util.Set bincidencias) {
        this.bincidencias = bincidencias;
    }

    public java.util.Set getBmotivoordens() {
        return this.bmotivoordens;
    }

    public void setBmotivoordens(java.util.Set bmotivoordens) {
        this.bmotivoordens = bmotivoordens;
    }

    public java.util.Set getBincidenciaunidads() {
        return this.bincidenciaunidads;
    }

    public void setBincidenciaunidads(java.util.Set bincidenciaunidads) {
        this.bincidenciaunidads = bincidenciaunidads;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cmotivo", getCmotivo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CMotivo) ) return false;
        CMotivo castOther = (CMotivo) other;
        return new EqualsBuilder()
            .append(this.getCmotivo(), castOther.getCmotivo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCmotivo())
            .toHashCode();
    }

}
