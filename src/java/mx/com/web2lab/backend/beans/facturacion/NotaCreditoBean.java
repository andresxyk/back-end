package mx.com.web2lab.backend.beans.facturacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.tools.SucursalBean;
import mx.com.web2lab.backend.util.formatos.Formatos;

public class NotaCreditoBean implements Serializable {
	
	/** nullable persistent field */
	private DatosFiscalesBean objDatosFiscalesBean;
	
	/** nullable persistent field */
    private java.lang.String ssucursal;
    
    /** nullable persistent field */
	private Integer ufoliofactura;
	
	/** nullable persistent field */
	private Integer ccliente;
	    
	/** nullable persistent field */
	private Integer csucursal;
	
	/** nullable persistent field */
	private int cformapago;
	
    /** nullable persistent field */
    private double  msubtotal;
    
	/** nullable persistent field */
    private double  mdescuento;
    
	/** nullable persistent field */
    private double  mcopago;
    
    /** nullable persistent field */
    private double  miva;
    
    /** nullable persistent field */
    private double  mtotal;
    
    /** nullable persistent field */
	private int ctipoimpuesto;
	
	/** nullable persistent field */
    private int  cconvenio;
    
    /** nullable persistent field */
    private Date dregistro;
    
    /** nullable persistent field */
    private java.lang.String scadenaoriginal;
    
    /** nullable persistent field */
    private java.lang.String ssellodigital;
    
    /** nullable persistent field */
    private int  centidadlegal;
   
    /** nullable persistent field */
    private java.lang.String sserie;
    
    /** nullable persistent field */
    private java.lang.String sfacturas;
    
    /** nullable persistent field */
    private int iuserId;
    
    /** nullable persistent field */
    private java.lang.String sdescripcionnota;
    
    /** nullable persistent field */
    private java.lang.String strbloque;
    

	public java.lang.String getSsucursal() {
		return ssucursal;
	}

	public void setSsucursal(java.lang.String ssucursal) {
		this.ssucursal = ssucursal;
	}

	public Integer getUfoliofactura() {
		return ufoliofactura;
	}

	public void setUfoliofactura(Integer ufoliofactura) {
		this.ufoliofactura = ufoliofactura;
	}

	public Integer getCcliente() {
		return ccliente;
	}

	public void setCcliente(Integer ccliente) {
		this.ccliente = ccliente;
	}

	public Integer getCsucursal() {
		return csucursal;
	}

	public void setCsucursal(Integer csucursal) {
		this.csucursal = csucursal;
	}

	public int getCformapago() {
		return cformapago;
	}

	public void setCformapago(int cformapago) {
		this.cformapago = cformapago;
	}

	public double getMsubtotal() {
		return msubtotal;
	}

	public void setMsubtotal(double msubtotal) {
		this.msubtotal = msubtotal;
	}

	public double getMdescuento() {
		return mdescuento;
	}

	public void setMdescuento(double mdescuento) {
		this.mdescuento = mdescuento;
	}

	public double getMcopago() {
		return mcopago;
	}

	public void setMcopago(double mcopago) {
		this.mcopago = mcopago;
	}

	public double getMiva() {
		return miva;
	}

	public void setMiva(double miva) {
		this.miva = miva;
	}

	public double getMtotal() {
		return mtotal;
	}

	public void setMtotal(double mtotal) {
		this.mtotal = mtotal;
	}

	public int getCtipoimpuesto() {
		return ctipoimpuesto;
	}

	public void setCtipoimpuesto(int ctipoimpuesto) {
		this.ctipoimpuesto = ctipoimpuesto;
	}

	public int getCconvenio() {
		return cconvenio;
	}

	public void setCconvenio(int cconvenio) {
		this.cconvenio = cconvenio;
	}

	public Date getDregistro() {
		return dregistro;
	}

	public void setDregistro(Date dregistro) {
		this.dregistro = dregistro;
	}

	public java.lang.String getScadenaoriginal() {
		return scadenaoriginal;
	}

	public void setScadenaoriginal(java.lang.String scadenaoriginal) {
		this.scadenaoriginal = scadenaoriginal;
	}

	public java.lang.String getSsellodigital() {
		return ssellodigital;
	}

	public void setSsellodigital(java.lang.String ssellodigital) {
		this.ssellodigital = ssellodigital;
	}

	public int getCentidadlegal() {
		return centidadlegal;
	}

	public void setCentidadlegal(int centidadlegal) {
		this.centidadlegal = centidadlegal;
	}

	public java.lang.String getSserie() {
		return sserie;
	}

	public void setSserie(java.lang.String sserie) {
		this.sserie = sserie;
	}

	public java.lang.String getSfacturas() {
		return sfacturas;
	}

	public void setSfacturas(java.lang.String sfacturas) {
		this.sfacturas = sfacturas;
	}

	public DatosFiscalesBean getObjDatosFiscalesBean() {
		return objDatosFiscalesBean;
	}

	public void setObjDatosFiscalesBean(DatosFiscalesBean objDatosFiscalesBean) {
		this.objDatosFiscalesBean = objDatosFiscalesBean;
	}

	public int getIuserId() {
		return iuserId;
	}

	public void setIuserId(int iuserId) {
		this.iuserId = iuserId;
	}

	public java.lang.String getSdescripcionnota() {
		return sdescripcionnota;
	}

	public void setSdescripcionnota(java.lang.String sdescripcionnota) {
		this.sdescripcionnota = sdescripcionnota;
	}
  
	public java.lang.String getStrbloque() {
		return strbloque;
	}

	public void setStrbloque(java.lang.String strbloque) {
		this.strbloque = strbloque;
	}	
    

		
}
