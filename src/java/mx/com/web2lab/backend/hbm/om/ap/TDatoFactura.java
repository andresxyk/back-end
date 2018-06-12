package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TDatoFactura implements Serializable {

    /** identifier field */
    private java.lang.Integer kdatofactura;

    /** persistent field */
    private int cmarca;

    /** nullable persistent field */
    private java.lang.String srazonsocial;

    /** nullable persistent field */
    private java.lang.String srfc;

    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** persistent field */
    private int ccodigopostal;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private java.math.BigDecimal userId;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private Set tordenfacturasucursals;

    /** full constructor */
    public TDatoFactura(java.lang.Integer kdatofactura, int cmarca, java.lang.String srazonsocial, java.lang.String srfc, java.lang.String sdireccion, int ccodigopostal, int cestadoregistro, java.math.BigDecimal userId, java.util.Date dregistro, Set tordenfacturasucursals) {
        this.kdatofactura = kdatofactura;
        this.cmarca = cmarca;
        this.srazonsocial = srazonsocial;
        this.srfc = srfc;
        this.sdireccion = sdireccion;
        this.ccodigopostal = ccodigopostal;
        this.cestadoregistro = cestadoregistro;
        this.userId = userId;
        this.dregistro = dregistro;
        this.tordenfacturasucursals = tordenfacturasucursals;
    }

    /** default constructor */
    public TDatoFactura() {
    }

    /** minimal constructor */
    public TDatoFactura(java.lang.Integer kdatofactura, int cmarca, int ccodigopostal, int cestadoregistro, java.math.BigDecimal userId, Set tordenfacturasucursals) {
        this.kdatofactura = kdatofactura;
        this.cmarca = cmarca;
        this.ccodigopostal = ccodigopostal;
        this.cestadoregistro = cestadoregistro;
        this.userId = userId;
        this.tordenfacturasucursals = tordenfacturasucursals;
    }

    public java.lang.Integer getKdatofactura() {
        return this.kdatofactura;
    }

    public void setKdatofactura(java.lang.Integer kdatofactura) {
        this.kdatofactura = kdatofactura;
    }

    public int getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(int cmarca) {
        this.cmarca = cmarca;
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

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.math.BigDecimal getUserid() {
        return this.userId;
    }

    public void setUserid(java.math.BigDecimal userId) {
        this.userId = userId;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.util.Set getTordenfacturasucursals() {
        return this.tordenfacturasucursals;
    }

    public void setTordenfacturasucursals(java.util.Set tordenfacturasucursals) {
        this.tordenfacturasucursals = tordenfacturasucursals;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kdatofactura", getKdatofactura())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TDatoFactura) ) return false;
        TDatoFactura castOther = (TDatoFactura) other;
        return new EqualsBuilder()
            .append(this.getKdatofactura(), castOther.getKdatofactura())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKdatofactura())
            .toHashCode();
    }

}
