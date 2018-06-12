package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TNotaCredito implements Serializable {

    /** identifier field */
    private java.lang.Integer knotacredito;

    /** persistent field */
    private int kdatofiscal;

    /** persistent field */
    private java.lang.String ssucursal;

    /** persistent field */
    private int ufoliofactura;

    /** persistent field */
    private int ccliente;

    /** persistent field */
    private int csucursal;

    /** persistent field */
    private int cformapago;

    /** persistent field */
    private java.math.BigDecimal msubtotal;

    /** persistent field */
    private java.math.BigDecimal mdescuento;

    /** nullable persistent field */
    private java.math.BigDecimal mcopago;

    /** persistent field */
    private java.math.BigDecimal miva;

    /** persistent field */
    private java.math.BigDecimal mtotal;

    /** persistent field */
    private int ctipoimpuesto;

    /** nullable persistent field */
    private int cconvenio;

    /** nullable persistent field */
    private java.lang.String scadenaoriginal;

    /** persistent field */
    private java.lang.String ssellodigital;

    /** persistent field */
    private int centidadlegal;

    /** persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int cestadoregistro;

    /** nullable persistent field */
    private java.util.Date dcancelacionfactura;

    /** nullable persistent field */
    private int userIdChange;

    /** persistent field */
    private int userId;

    /** nullable persistent field */
    private java.lang.String sobservacion;

    /** nullable persistent field */
    private java.lang.String sxml;

    /** nullable persistent field */
    private java.lang.String sxmlsello;

    /** nullable persistent field */
    private java.lang.String sserie;

    /** full constructor */
    public TNotaCredito(java.lang.Integer knotacredito, int kdatofiscal, java.lang.String ssucursal, int ufoliofactura, int ccliente, int csucursal, int cformapago, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuento, java.math.BigDecimal mcopago, java.math.BigDecimal miva, java.math.BigDecimal mtotal, int ctipoimpuesto, int cconvenio, java.lang.String scadenaoriginal, java.lang.String ssellodigital, int centidadlegal, java.util.Date dregistro, int cestadoregistro, java.util.Date dcancelacionfactura, int userIdChange, int userId, java.lang.String sobservacion, java.lang.String sxml, java.lang.String sxmlsello, java.lang.String sserie) {
        this.knotacredito = knotacredito;
        this.kdatofiscal = kdatofiscal;
        this.ssucursal = ssucursal;
        this.ufoliofactura = ufoliofactura;
        this.ccliente = ccliente;
        this.csucursal = csucursal;
        this.cformapago = cformapago;
        this.msubtotal = msubtotal;
        this.mdescuento = mdescuento;
        this.mcopago = mcopago;
        this.miva = miva;
        this.mtotal = mtotal;
        this.ctipoimpuesto = ctipoimpuesto;
        this.cconvenio = cconvenio;
        this.scadenaoriginal = scadenaoriginal;
        this.ssellodigital = ssellodigital;
        this.centidadlegal = centidadlegal;
        this.dregistro = dregistro;
        this.cestadoregistro = cestadoregistro;
        this.dcancelacionfactura = dcancelacionfactura;
        this.userIdChange = userIdChange;
        this.userId = userId;
        this.sobservacion = sobservacion;
        this.sxml = sxml;
        this.sxmlsello = sxmlsello;
        this.sserie = sserie;
    }

    /** default constructor */
    public TNotaCredito() {
    }

    /** minimal constructor */
    public TNotaCredito(java.lang.Integer knotacredito, int kdatofiscal, java.lang.String ssucursal, int ufoliofactura, int ccliente, int csucursal, int cformapago, java.math.BigDecimal msubtotal, java.math.BigDecimal mdescuento, java.math.BigDecimal miva, java.math.BigDecimal mtotal, int ctipoimpuesto, java.lang.String ssellodigital, int centidadlegal, java.util.Date dregistro, int cestadoregistro, int userId) {
        this.knotacredito = knotacredito;
        this.kdatofiscal = kdatofiscal;
        this.ssucursal = ssucursal;
        this.ufoliofactura = ufoliofactura;
        this.ccliente = ccliente;
        this.csucursal = csucursal;
        this.cformapago = cformapago;
        this.msubtotal = msubtotal;
        this.mdescuento = mdescuento;
        this.miva = miva;
        this.mtotal = mtotal;
        this.ctipoimpuesto = ctipoimpuesto;
        this.ssellodigital = ssellodigital;
        this.centidadlegal = centidadlegal;
        this.dregistro = dregistro;
        this.cestadoregistro = cestadoregistro;
        this.userId = userId;
    }

    public java.lang.Integer getKnotacredito() {
        return this.knotacredito;
    }

    public void setKnotacredito(java.lang.Integer knotacredito) {
        this.knotacredito = knotacredito;
    }

    public int getKdatofiscal() {
        return this.kdatofiscal;
    }

    public void setKdatofiscal(int kdatofiscal) {
        this.kdatofiscal = kdatofiscal;
    }

    public java.lang.String getSsucursal() {
        return this.ssucursal;
    }

    public void setSsucursal(java.lang.String ssucursal) {
        this.ssucursal = ssucursal;
    }

    public int getUfoliofactura() {
        return this.ufoliofactura;
    }

    public void setUfoliofactura(int ufoliofactura) {
        this.ufoliofactura = ufoliofactura;
    }

    public int getCcliente() {
        return this.ccliente;
    }

    public void setCcliente(int ccliente) {
        this.ccliente = ccliente;
    }

    public int getCsucursal() {
        return this.csucursal;
    }

    public void setCsucursal(int csucursal) {
        this.csucursal = csucursal;
    }

    public int getCformapago() {
        return this.cformapago;
    }

    public void setCformapago(int cformapago) {
        this.cformapago = cformapago;
    }

    public java.math.BigDecimal getMsubtotal() {
        return this.msubtotal;
    }

    public void setMsubtotal(java.math.BigDecimal msubtotal) {
        this.msubtotal = msubtotal;
    }

    public java.math.BigDecimal getMdescuento() {
        return this.mdescuento;
    }

    public void setMdescuento(java.math.BigDecimal mdescuento) {
        this.mdescuento = mdescuento;
    }

    public java.math.BigDecimal getMcopago() {
        return this.mcopago;
    }

    public void setMcopago(java.math.BigDecimal mcopago) {
        this.mcopago = mcopago;
    }

    public java.math.BigDecimal getMiva() {
        return this.miva;
    }

    public void setMiva(java.math.BigDecimal miva) {
        this.miva = miva;
    }

    public java.math.BigDecimal getMtotal() {
        return this.mtotal;
    }

    public void setMtotal(java.math.BigDecimal mtotal) {
        this.mtotal = mtotal;
    }

    public int getCtipoimpuesto() {
        return this.ctipoimpuesto;
    }

    public void setCtipoimpuesto(int ctipoimpuesto) {
        this.ctipoimpuesto = ctipoimpuesto;
    }

    public int getCconvenio() {
        return this.cconvenio;
    }

    public void setCconvenio(int cconvenio) {
        this.cconvenio = cconvenio;
    }

    public java.lang.String getScadenaoriginal() {
        return this.scadenaoriginal;
    }

    public void setScadenaoriginal(java.lang.String scadenaoriginal) {
        this.scadenaoriginal = scadenaoriginal;
    }

    public java.lang.String getSsellodigital() {
        return this.ssellodigital;
    }

    public void setSsellodigital(java.lang.String ssellodigital) {
        this.ssellodigital = ssellodigital;
    }

    public int getCentidadlegal() {
        return this.centidadlegal;
    }

    public void setCentidadlegal(int centidadlegal) {
        this.centidadlegal = centidadlegal;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Date getDcancelacionfactura() {
        return this.dcancelacionfactura;
    }

    public void setDcancelacionfactura(java.util.Date dcancelacionfactura) {
        this.dcancelacionfactura = dcancelacionfactura;
    }

    public int getUserIdChange() {
        return this.userIdChange;
    }

    public void setUserIdChange(int userIdChange) {
        this.userIdChange = userIdChange;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public java.lang.String getSobservacion() {
        return this.sobservacion;
    }

    public void setSobservacion(java.lang.String sobservacion) {
        this.sobservacion = sobservacion;
    }

    public java.lang.String getSxml() {
        return this.sxml;
    }

    public void setSxml(java.lang.String sxml) {
        this.sxml = sxml;
    }

    public java.lang.String getSxmlsello() {
        return this.sxmlsello;
    }

    public void setSxmlsello(java.lang.String sxmlsello) {
        this.sxmlsello = sxmlsello;
    }

    public java.lang.String getSserie() {
        return this.sserie;
    }

    public void setSserie(java.lang.String sserie) {
        this.sserie = sserie;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("knotacredito", getKnotacredito())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TNotaCredito) ) return false;
        TNotaCredito castOther = (TNotaCredito) other;
        return new EqualsBuilder()
            .append(this.getKnotacredito(), castOther.getKnotacredito())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKnotacredito())
            .toHashCode();
    }

}
