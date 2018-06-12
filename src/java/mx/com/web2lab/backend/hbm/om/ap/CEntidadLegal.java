package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CEntidadLegal implements Serializable {

    /** identifier field */
    private java.lang.Integer centidadlegal;

    /** persistent field */
    private java.lang.String srazonsocial;

    /** persistent field */
    private java.lang.String srfc;

    /** persistent field */
    private int ccodigopostal;

    /** nullable persistent field */
    private java.lang.String nexterior;

    /** nullable persistent field */
    private java.lang.String ninterior;

    /** nullable persistent field */
    private java.lang.String spais;

    /** persistent field */
    private int cmarca;

    /** persistent field */
    private int catributofiscal;

    /** persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private java.lang.String sdireccionfiscal;

    /** full constructor */
    public CEntidadLegal(java.lang.Integer centidadlegal, java.lang.String srazonsocial, java.lang.String srfc, int ccodigopostal, java.lang.String nexterior, java.lang.String ninterior, java.lang.String spais, int cmarca, int catributofiscal, java.util.Date dregistro, java.lang.String sdireccionfiscal) {
        this.centidadlegal = centidadlegal;
        this.srazonsocial = srazonsocial;
        this.srfc = srfc;
        this.ccodigopostal = ccodigopostal;
        this.nexterior = nexterior;
        this.ninterior = ninterior;
        this.spais = spais;
        this.cmarca = cmarca;
        this.catributofiscal = catributofiscal;
        this.dregistro = dregistro;
        this.sdireccionfiscal = sdireccionfiscal;
    }

    /** default constructor */
    public CEntidadLegal() {
    }

    /** minimal constructor */
    public CEntidadLegal(java.lang.Integer centidadlegal, java.lang.String srazonsocial, java.lang.String srfc, int ccodigopostal, int cmarca, int catributofiscal, java.util.Date dregistro) {
        this.centidadlegal = centidadlegal;
        this.srazonsocial = srazonsocial;
        this.srfc = srfc;
        this.ccodigopostal = ccodigopostal;
        this.cmarca = cmarca;
        this.catributofiscal = catributofiscal;
        this.dregistro = dregistro;
    }

    public java.lang.Integer getCentidadlegal() {
        return this.centidadlegal;
    }

    public void setCentidadlegal(java.lang.Integer centidadlegal) {
        this.centidadlegal = centidadlegal;
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

    public int getCcodigopostal() {
        return this.ccodigopostal;
    }

    public void setCcodigopostal(int ccodigopostal) {
        this.ccodigopostal = ccodigopostal;
    }

    public java.lang.String getNexterior() {
        return this.nexterior;
    }

    public void setNexterior(java.lang.String nexterior) {
        this.nexterior = nexterior;
    }

    public java.lang.String getNinterior() {
        return this.ninterior;
    }

    public void setNinterior(java.lang.String ninterior) {
        this.ninterior = ninterior;
    }

    public java.lang.String getSpais() {
        return this.spais;
    }

    public void setSpais(java.lang.String spais) {
        this.spais = spais;
    }

    public int getCmarca() {
        return this.cmarca;
    }

    public void setCmarca(int cmarca) {
        this.cmarca = cmarca;
    }

    public int getCatributofiscal() {
        return this.catributofiscal;
    }

    public void setCatributofiscal(int catributofiscal) {
        this.catributofiscal = catributofiscal;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public java.lang.String getSdireccionfiscal() {
        return this.sdireccionfiscal;
    }

    public void setSdireccionfiscal(java.lang.String sdireccionfiscal) {
        this.sdireccionfiscal = sdireccionfiscal;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("centidadlegal", getCentidadlegal())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CEntidadLegal) ) return false;
        CEntidadLegal castOther = (CEntidadLegal) other;
        return new EqualsBuilder()
            .append(this.getCentidadlegal(), castOther.getCentidadlegal())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCentidadlegal())
            .toHashCode();
    }

}
