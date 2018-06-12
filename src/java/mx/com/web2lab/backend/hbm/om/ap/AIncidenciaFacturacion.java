package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AIncidenciaFacturacion implements Serializable {

    /** identifier field */
    private java.lang.Integer kincidenciafacturacion;

    /** persistent field */
    private int kllaveincidencia;

    /** nullable persistent field */
    private java.lang.String stabla;

    /** nullable persistent field */
    private java.lang.String scampo;

    /** persistent field */
    private int userid;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.lang.String sobservacion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CIncidenciaFacturacion cincidenciafacturacion;

    /** full constructor */
    public AIncidenciaFacturacion(java.lang.Integer kincidenciafacturacion, int kllaveincidencia, java.lang.String stabla, java.lang.String scampo, int userid, java.util.Date dregistro, java.lang.String sobservacion, mx.com.web2lab.backend.hbm.om.ap.CIncidenciaFacturacion cincidenciafacturacion) {
        this.kincidenciafacturacion = kincidenciafacturacion;
        this.kllaveincidencia = kllaveincidencia;
        this.stabla = stabla;
        this.scampo = scampo;
        this.userid = userid;
        this.dregistro = dregistro;
        this.sobservacion = sobservacion;
        this.cincidenciafacturacion = cincidenciafacturacion;
    }

    /** default constructor */
    public AIncidenciaFacturacion() {
    }

    /** minimal constructor */
    public AIncidenciaFacturacion(java.lang.Integer kincidenciafacturacion, int kllaveincidencia, int userid, mx.com.web2lab.backend.hbm.om.ap.CIncidenciaFacturacion cincidenciafacturacion) {
        this.kincidenciafacturacion = kincidenciafacturacion;
        this.kllaveincidencia = kllaveincidencia;
        this.userid = userid;
        this.cincidenciafacturacion = cincidenciafacturacion;
    }

    public java.lang.Integer getKincidenciafacturacion() {
        return this.kincidenciafacturacion;
    }

    public void setKincidenciafacturacion(java.lang.Integer kincidenciafacturacion) {
        this.kincidenciafacturacion = kincidenciafacturacion;
    }

    public int getKllaveincidencia() {
        return this.kllaveincidencia;
    }

    public void setKllaveincidencia(int kllaveincidencia) {
        this.kllaveincidencia = kllaveincidencia;
    }

    public java.lang.String getStabla() {
        return this.stabla;
    }

    public void setStabla(java.lang.String stabla) {
        this.stabla = stabla;
    }

    public java.lang.String getScampo() {
        return this.scampo;
    }

    public void setScampo(java.lang.String scampo) {
        this.scampo = scampo;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.lang.String getSobservacion() {
        return this.sobservacion;
    }

    public void setSobservacion(java.lang.String sobservacion) {
        this.sobservacion = sobservacion;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CIncidenciaFacturacion getCincidenciafacturacion() {
        return this.cincidenciafacturacion;
    }

    public void setCincidenciafacturacion(mx.com.web2lab.backend.hbm.om.ap.CIncidenciaFacturacion cincidenciafacturacion) {
        this.cincidenciafacturacion = cincidenciafacturacion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kincidenciafacturacion", getKincidenciafacturacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AIncidenciaFacturacion) ) return false;
        AIncidenciaFacturacion castOther = (AIncidenciaFacturacion) other;
        return new EqualsBuilder()
            .append(this.getKincidenciafacturacion(), castOther.getKincidenciafacturacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKincidenciafacturacion())
            .toHashCode();
    }

}
