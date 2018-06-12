package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TDatoFiscal implements Serializable {

    /** identifier field */
    private java.lang.Integer kdatofiscal;

    /** nullable persistent field */
    private java.lang.String srazonsocial;

    /** nullable persistent field */
    private java.lang.String srfc;

    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** nullable persistent field */
    private int ccodigopostal;

    /** nullable persistent field */
    private java.lang.String spais;

    /** nullable persistent field */
    private int userId;

    /** nullable persistent field */
    private int userIdChange;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.util.Date dregistromodificacion;

    /** full constructor */
    public TDatoFiscal(java.lang.Integer kdatofiscal, java.lang.String srazonsocial, java.lang.String srfc, java.lang.String sdireccion, int ccodigopostal, java.lang.String spais, int userId, int userIdChange, java.util.Date dregistro, java.util.Date dregistromodificacion) {
        this.kdatofiscal = kdatofiscal;
        this.srazonsocial = srazonsocial;
        this.srfc = srfc;
        this.sdireccion = sdireccion;
        this.ccodigopostal = ccodigopostal;
        this.spais = spais;
        this.userId = userId;
        this.userIdChange = userIdChange;
        this.dregistro = dregistro;
        this.dregistromodificacion = dregistromodificacion;
    }

    /** default constructor */
    public TDatoFiscal() {
    }

    /** minimal constructor */
    public TDatoFiscal(java.lang.Integer kdatofiscal) {
        this.kdatofiscal = kdatofiscal;
    }

    public java.lang.Integer getKdatofiscal() {
        return this.kdatofiscal;
    }

    public void setKdatofiscal(java.lang.Integer kdatofiscal) {
        this.kdatofiscal = kdatofiscal;
    }

    public java.lang.String getSrazonsocial() {
        return this.srazonsocial;
    }

    public void setSrazonsocial(java.lang.String srazonsocial) {
        this.srazonsocial = srazonsocial;
    }

    public java.lang.String getSrfc() {
        return this.srfc;
    }

    public void setSrfc(java.lang.String srfc) {
        this.srfc = srfc;
    }

    public java.lang.String getSdireccion() {
        return this.sdireccion;
    }

    public void setSdireccion(java.lang.String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public int getCcodigopostal() {
        return this.ccodigopostal;
    }

    public void setCcodigopostal(int ccodigopostal) {
        this.ccodigopostal = ccodigopostal;
    }

    public java.lang.String getSpais() {
        return this.spais;
    }

    public void setSpais(java.lang.String spais) {
        this.spais = spais;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserIdChange() {
        return this.userIdChange;
    }

    public void setUserIdChange(int userIdChange) {
        this.userIdChange = userIdChange;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.util.Date getDregistromodificacion() {
        return this.dregistromodificacion;
    }

    public void setDregistromodificacion(java.util.Date dregistromodificacion) {
        this.dregistromodificacion = dregistromodificacion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kdatofiscal", getKdatofiscal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TDatoFiscal) ) return false;
        TDatoFiscal castOther = (TDatoFiscal) other;
        return new EqualsBuilder()
            .append(this.getKdatofiscal(), castOther.getKdatofiscal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKdatofiscal())
            .toHashCode();
    }

}
