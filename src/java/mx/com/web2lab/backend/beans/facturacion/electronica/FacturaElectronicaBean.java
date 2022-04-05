package mx.com.web2lab.backend.beans.facturacion.electronica;

import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.tools.SucursalBean;

public class FacturaElectronicaBean {
	
	private int kfactura;
	
	private String kOrdenSucursal = "";
	
	private int cSucursal = 0;

	private int cmarca = 1;
	
	private int Turbine_User = 0;
	
	private String uuid = "";
	
	private String notaDescuento = "";
	private String descuentos = "";
	private boolean bandDescuento = false;
	
	private boolean bandRetencion = false;
	

	/** nullable persistent field */
    private java.lang.String sserie;

    /** nullable persistent field */
    private java.lang.String sfolio;

    /** nullable persistent field */
    private java.lang.String sseriofoliocompleto;
    
    /** nullable persistent field */
    private java.lang.String fecha;
    
    /** nullable persistent field */
    private java.lang.String fechaxml;
    
    /** nullable persistent field */
    private long cconvenio;
    
    /** nullable persistent field */
    private java.lang.String nnumeroaprobacion;
    
    /** nullable persistent field */
    private java.lang.String sanoaprobacion;
    
    /** nullable persistent field */
    private java.lang.String sformapago;

    /** nullable persistent field */
    private double  msubtotalsuma;
    
    /** nullable persistent field */
    private double  msubtotal;
    
    /** nullable persistent field */
    private double  msubtotaluniemp;
    
    /** nullable persistent field */
    private double  mdescuento;
    
    /** nullable persistent field */
    private double  mtotal;
    
    /** nullable persistent field */
    private java.lang.String stipocomprobante;
    
    /** nullable persistent field */
    private java.lang.String sncertificado = "";
    
    /** nullable persistent field */
    private java.lang.String cert = "";
    
    //variables del emisorOlab
    /** nullable persistent field */
    private java.lang.String srazonsocialemisor;
    
    /** nullable persistent field */
    private java.lang.String srfcemisor = "";

    /** nullable persistent field */
    private java.lang.String scalleemisor;
    
    /** nullable persistent field */
    private java.lang.String snexterioremisor;
    
    /** nullable persistent field */
    private java.lang.String sninterioremisor;
    
    /** nullable persistent field */
    private java.lang.String scoloniaemisor;
    
    /** nullable persistent field */
    private java.lang.String sciudademisor;
    
    /** nullable persistent field */
    private java.lang.String smunicipioemisor;
    
    /** nullable persistent field */
    private java.lang.String sestadoemisor;
    
    /** nullable persistent field */
    private java.lang.String scodigopostalemisor;
    
    /** nullable persistent field */
    private java.lang.String spaisemisor;
    
  //variables del emisorSucursal
    
    /** nullable persistent field */
    private java.lang.String scallesuc;
    
    /** nullable persistent field */
    private java.lang.String snexteriorsuc;
    
    /** nullable persistent field */
    private java.lang.String sninteriorsuc;
    
    /** nullable persistent field */
    private java.lang.String scoloniasuc;
    
    /** nullable persistent field */
    private java.lang.String sciudadsuc;
    
    /** nullable persistent field */
    private java.lang.String smunicipiosuc;
    
    /** nullable persistent field */
    private java.lang.String sestadosuc;
    
    /** nullable persistent field */
    private java.lang.String scodigopostalsuc;
    
    /** nullable persistent field */
    private java.lang.String spaissuc;

    //Datos del receptor
    
    private int hDatosFiscal;

	/** nullable persistent field */
    private java.lang.String srazonsocialreceptor;
    
    /** nullable persistent field */
    private java.lang.String srfcreceptor;

    /** nullable persistent field */
    private java.lang.String scallereceptor;
    
    /** nullable persistent field */
    private java.lang.String snexteriorreceptor;
    
    /** nullable persistent field */
    private java.lang.String sninteriorreceptor;
    
    /** nullable persistent field */
    private java.lang.String scoloniareceptor;
    
    /** nullable persistent field */
    private java.lang.String sciudadreceptor;
    
    /** nullable persistent field */
    private java.lang.String smunicipioreceptor;
    
    /** nullable persistent field */
    private java.lang.String sestadoreceptor;
    
    /** nullable persistent field */
    private java.lang.String scodigopostalreceptor;
    
    /** nullable persistent field */
    private java.lang.String spaisreceptor;
    
    //impuesto
    /** nullable persistent field */
    private double  miva;
    
    /** nullable persistent field */
    private java.lang.String  sdescripcion;
    
    /** nullable persistent field */
    private java.lang.String  ssellodigital = "";
    
    /** nullable persistent field */
    private List lstbodys;
    
    private java.lang.String scadenaoriginal;
    
    private java.lang.String ccliente; 

    private java.lang.String sclientecompleto; 
    
    private java.lang.String sobservaciones; 
    
    private boolean bolredondear;
    
    /** nullable persistent field */
    private java.lang.String  scadenaoriginaldigest = "";

    /** nullable persistent field */
    private java.lang.String  sfop = "";

    /** nullable persistent field */
    private java.lang.String  sxml = "";

    private int cFormato = 0;
    
    private SucursalBean objSucursalBean = null;
    
    private String sURL = "";
    
    private String sFacturaOld = "";
    
    private int cTipoPago = 0;
    
    private String sTipoPago = "";

    private String sUltimosDigitos = "";
    
    private Integer iOrdenCompra;
    
    private java.sql.ResultSet rstfacturaempresas = null;
    
    /*Agregados para addenda COSBEL*/
    private boolean isAddenda = false;
    private String folioOrdenCompra;
    private String cargoTipo;
    private String partida;
    
    
    
    
    public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getCargoTipo() {
		return cargoTipo;
	}

	public void setCargoTipo(String cargoTipo) {
		this.cargoTipo = cargoTipo;
	}

	public String getFolioOrdenCompra() {
		return folioOrdenCompra;
	}

	public void setFolioOrdenCompra(String folioOrdenCompra) {
		this.folioOrdenCompra = folioOrdenCompra;
	}

	/***************************CFDI*********************************************/
    private String CFDIFechaTimbrado=""; 

    private String CFDIUUID=""; 
	
    private String CFDInoCertificadoSAT=""; 
	
    private String CFDIselloCFD=""; 
	
    private String CFDIselloSAT="";     
    
    public void setSserie(java.lang.String sserie) {
		this.sserie = sserie;
	}

	public java.lang.String getSserie() {
		return sserie;
	}

	public void setSfolio(java.lang.String sfolio) {
		this.sfolio = sfolio;
	}

	public java.lang.String getSfolio() {
		return sfolio;
	}

	public void setFecha(java.lang.String fecha) {
		this.fecha = fecha;
	}

	public java.lang.String getFecha() {
		return fecha;
	}

	public void setNnumeroaprobacion(java.lang.String nnumeroaprobacion) {
		this.nnumeroaprobacion = nnumeroaprobacion;
	}

	public java.lang.String getNnumeroaprobacion() {
		return nnumeroaprobacion;
	}

	public void setSanoaprobacion(java.lang.String sanoaprobacion) {
		this.sanoaprobacion = sanoaprobacion;
	}

	public java.lang.String getSanoaprobacion() {
		return sanoaprobacion;
	}

	public void setSformapago(java.lang.String sformapago) {
		this.sformapago = sformapago;
	}

	public java.lang.String getSformapago() {
		return sformapago;
	}

	public void setMsubtotal(double  msubtotal) {
		this.msubtotal = msubtotal;
	}

	public double getMsubtotal() {
		if (this.isBolredondear()) {
			return this.redodedoDouble(msubtotal);
		} else {
			return msubtotal;			
		}
	}

	public String getStrMsubtotal() {
		if (this.isBolredondear()) {
			return String.valueOf(this.redodedoDouble(msubtotaluniemp));
		} else {
			return String.valueOf(msubtotaluniemp);			
		}
	}
	
	public void setMdescuento(double  mdescuento) {
		this.mdescuento = mdescuento;
	}

	public double getMdescuento() {
		if (this.isBolredondear()) {
			return this.redodedoDouble(mdescuento);
		} else {
			return mdescuento;			
		}
	}

	public String getStrMdescuento() {
		if (this.isBolredondear()) {
			return String.valueOf(this.redodedoDouble(mdescuento));
		} else {
			return String.valueOf(mdescuento);			
		}
	}

	public void setMtotal(double  mtotal) {
		this.mtotal = mtotal;
	}

	public double getMtotal() {
		if (this.isBolredondear()) {
			return this.redodedoDouble(mtotal);
		} else {
			return mtotal;			
		}
	}

	public String getStrMtotal() {
		if (this.isBolredondear()) {
			return String.valueOf(this.redodedoDouble(mtotal));
		} else {
			return String.valueOf(mtotal);			
		}
	}
	
	public void setStipocomprobante(java.lang.String stipocomprobante) {
		this.stipocomprobante = stipocomprobante;
	}

	public java.lang.String getStipocomprobante() {
		return stipocomprobante;
	}

	public void setSncertificado(java.lang.String sncertificado) {
		this.sncertificado = sncertificado;
	}

	public java.lang.String getSncertificado() {
		return sncertificado;
	}

	public void setCert(java.lang.String cert) {
		this.cert = cert;
	}

	public java.lang.String getCert() {
		return cert;
	}

	public void setSrazonsocialemisor(java.lang.String srazonsocialemisor) {
		this.srazonsocialemisor = srazonsocialemisor;
	}

	public java.lang.String getSrazonsocialemisor() {
		return srazonsocialemisor;
	}

	public void setSrfcemisor(java.lang.String srfcemisor) {
		this.srfcemisor = srfcemisor;
	}

	public java.lang.String getSrfcemisor() {
		return srfcemisor;
	}

	public void setScalleemisor(java.lang.String scalleemisor) {
		this.scalleemisor = scalleemisor;
	}

	public java.lang.String getScalleemisor() {
		return scalleemisor;
	}

	public void setSnexterioremisor(java.lang.String snexterioremisor) {
		this.snexterioremisor = snexterioremisor;
	}

	public java.lang.String getSnexterioremisor() {
		return snexterioremisor;
	}

	public void setSninterioremisor(java.lang.String sninterioremisor) {
		this.sninterioremisor = sninterioremisor;
	}

	public java.lang.String getSninterioremisor() {
		return sninterioremisor;
	}

	public void setScoloniaemisor(java.lang.String scoloniaemisor) {
		this.scoloniaemisor = scoloniaemisor;
	}

	public java.lang.String getScoloniaemisor() {
		return scoloniaemisor;
	}

	public void setSciudademisor(java.lang.String sciudademisor) {
		this.sciudademisor = sciudademisor;
	}

	public java.lang.String getSciudademisor() {
		return sciudademisor;
	}

	public void setSmunicipioemisor(java.lang.String smunicipioemisor) {
		this.smunicipioemisor = smunicipioemisor;
	}

	public java.lang.String getSmunicipioemisor() {
		return smunicipioemisor;
	}

	public void setSestadoemisor(java.lang.String sestadoemisor) {
		this.sestadoemisor = sestadoemisor;
	}

	public java.lang.String getSestadoemisor() {
		return sestadoemisor;
	}

	public void setScodigopostalemisor(java.lang.String scodigopostalemisor) {
		this.scodigopostalemisor = scodigopostalemisor;
	}

	public java.lang.String getScodigopostalemisor() {
		return scodigopostalemisor;
	}

	public void setSpaisemisor(java.lang.String spaisemisor) {
		this.spaisemisor = spaisemisor;
	}

	public java.lang.String getSpaisemisor() {
		return spaisemisor;
	}

	public void setSrazonsocialreceptor(java.lang.String srazonsocialreceptor) {
		this.srazonsocialreceptor = srazonsocialreceptor;
	}

	public java.lang.String getSrazonsocialreceptor() {
		return srazonsocialreceptor;
	}

	public void setSrfcreceptor(java.lang.String srfcreceptor) {
		this.srfcreceptor = srfcreceptor;
	}

	public java.lang.String getSrfcreceptor() {
		return srfcreceptor;
	}

	public void setScallereceptor(java.lang.String scallereceptor) {
		this.scallereceptor = scallereceptor;
	}

	public java.lang.String getScallereceptor() {
		return scallereceptor;
	}

	public void setSnexteriorreceptor(java.lang.String snexteriorreceptor) {
		this.snexteriorreceptor = snexteriorreceptor;
	}

	public java.lang.String getSnexteriorreceptor() {
		return snexteriorreceptor;
	}

	public void setSninteriorreceptor(java.lang.String sninteriorreceptor) {
		this.sninteriorreceptor = sninteriorreceptor;
	}

	public java.lang.String getSninteriorreceptor() {
		return sninteriorreceptor;
	}

	public void setScoloniareceptor(java.lang.String scoloniareceptor) {
		this.scoloniareceptor = scoloniareceptor;
	}

	public java.lang.String getScoloniareceptor() {
		return scoloniareceptor;
	}

	public void setSciudadreceptor(java.lang.String sciudadreceptor) {
		this.sciudadreceptor = sciudadreceptor;
	}

	public java.lang.String getSciudadreceptor() {
		return sciudadreceptor;
	}

	public void setSmunicipioreceptor(java.lang.String smunicipioreceptor) {
		this.smunicipioreceptor = smunicipioreceptor;
	}

	public java.lang.String getSmunicipioreceptor() {
		return smunicipioreceptor;
	}

	public void setSestadoreceptor(java.lang.String sestadoreceptor) {
		this.sestadoreceptor = sestadoreceptor;
	}

	public java.lang.String getSestadoreceptor() {
		return sestadoreceptor;
	}

	public void setScallesuc(java.lang.String scallesuc) {
		this.scallesuc = scallesuc;
	}

	public java.lang.String getScallesuc() {
		return scallesuc;
	}

	public void setScodigopostalreceptor(java.lang.String scodigopostalreceptor) {
		this.scodigopostalreceptor = scodigopostalreceptor;
	}

	public java.lang.String getScodigopostalreceptor() {
		return scodigopostalreceptor;
	}

	public void setSpaisreceptor(java.lang.String spaisreceptor) {
		this.spaisreceptor = spaisreceptor;
	}

	public java.lang.String getSpaisreceptor() {
		return spaisreceptor;
	}

	public void setMiva(double miva) {
		this.miva = miva;
	}

	public double getMiva() {
		if (this.isBolredondear()) {
			return this.redodedoDouble(miva);
		} else {
			return miva;			
		}
	}

	public String getStrMiva() {
		if (this.isBolredondear()) {
			return String.valueOf(this.redodedoDouble(miva));
		} else {
			return String.valueOf(miva);			
		}
	}
	
	public void setSnexteriorsuc(java.lang.String snexteriorsuc) {
		this.snexteriorsuc = snexteriorsuc;
	}

	public java.lang.String getSnexteriorsuc() {
		return snexteriorsuc;
	}

	public void setSninteriorsuc(java.lang.String sninteriorsuc) {
		this.sninteriorsuc = sninteriorsuc;
	}

	public java.lang.String getSninteriorsuc() {
		return sninteriorsuc;
	}

	public void setScoloniasuc(java.lang.String scoloniasuc) {
		this.scoloniasuc = scoloniasuc;
	}

	public java.lang.String getScoloniasuc() {
		return scoloniasuc;
	}

	public void setSciudadsuc(java.lang.String sciudadsuc) {
		this.sciudadsuc = sciudadsuc;
	}

	public java.lang.String getSciudadsuc() {
		return sciudadsuc;
	}

	public void setSmunicipiosuc(java.lang.String smunicipiosuc) {
		this.smunicipiosuc = smunicipiosuc;
	}

	public java.lang.String getSmunicipiosuc() {
		return smunicipiosuc;
	}

	public void setSestadosuc(java.lang.String sestadosuc) {
		this.sestadosuc = sestadosuc;
	}

	public java.lang.String getSestadosuc() {
		return sestadosuc;
	}

	public void setScodigopostalsuc(java.lang.String scodigopostalsuc) {
		this.scodigopostalsuc = scodigopostalsuc;
	}

	public java.lang.String getScodigopostalsuc() {
		return scodigopostalsuc;
	}

	public void setSpaissuc(java.lang.String spaissuc) {
		this.spaissuc = spaissuc;
	}

	public java.lang.String getSpaissuc() {
		return spaissuc;
	}

	public void setSdescripcion(java.lang.String sdescripcion) {
		this.sdescripcion = sdescripcion;
	}

	public java.lang.String getSdescripcion() {
		return sdescripcion;
	}

	public void setSsellodigital(java.lang.String ssellodigital) {
		this.ssellodigital = ssellodigital.replaceAll("[\n\r]","");
//		this.ssellodigital = ssellodigital;
	}

	public java.lang.String getSsellodigital() {
		return ssellodigital;
	}

	public void setCconvenio(long cconvenio) {
		this.cconvenio = cconvenio;
	}

	public long getCconvenio() {
		return cconvenio;
	}

	public void setMsubtotaluniemp(double msubtotaluniemp) {
		this.msubtotaluniemp = msubtotaluniemp;
	}

	public double getMsubtotaluniemp() {
		if (this.isBolredondear()) {
			return this.redodedoDouble(msubtotaluniemp);
		} else {
			return msubtotaluniemp;			
		}
	}

	public String getStrMsubtotaluniemp() {
		if (this.isBolredondear()) {
			return String.valueOf(this.redodedoDouble(msubtotaluniemp));
		} else {
			return String.valueOf(msubtotaluniemp);			
		}
	}
		
	public int sizeBodys() {
		if (this.lstbodys == null) {
			return 0;
		} else {
			return this.lstbodys.size();
		}
	}

	public BodyFacturaElectronicaBean getBody(int inti) {
		if (this.lstbodys == null) {
			return null;
		} else {
			return (BodyFacturaElectronicaBean)this.lstbodys.get(inti);			
		}
	}
	
	public void setBody(BodyFacturaElectronicaBean objBody) {
		if (this.lstbodys == null) {
			lstbodys = new ArrayList();
		}
		this.lstbodys.add(objBody);
	}
	
	public void setScadenaoriginal(java.lang.String scadenaoriginal) {
		this.scadenaoriginal = scadenaoriginal;
	}

	public java.lang.String getScadenaoriginal() {
		return scadenaoriginal;
	}

	public void setCcliente(java.lang.String ccliente) {
		this.ccliente = ccliente;
	}

	public java.lang.String getCcliente() {
		return ccliente;
	}

    public int gethDatosFiscal() {
		return hDatosFiscal;
	}

	public void sethDatosFiscal(int hDatosFiscal) {
		this.hDatosFiscal = hDatosFiscal;
	}
		
    private double redodedoDouble(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }

	public void setBolredondear(boolean bolredondear) {
		this.bolredondear = bolredondear;
	}

	public boolean isBolredondear() {
		return bolredondear;
	}

	public void setSobservaciones(java.lang.String sobservaciones) {
		this.sobservaciones = sobservaciones;
	}

	public java.lang.String getSobservaciones() {
		if (this.sobservaciones == null) {
			this.sobservaciones = "";
		}
		return sobservaciones;
	}

	public void setSseriofoliocompleto(java.lang.String sseriofoliocompleto) {
		this.sseriofoliocompleto = sseriofoliocompleto;
	}

	public java.lang.String getSseriofoliocompleto() {
		return sseriofoliocompleto;
	}

	public void setKfactura(int kfactura) {
		this.kfactura = kfactura;
	}

	public int getKfactura() {
		return kfactura;
	}

	public void setScadenaoriginaldigest(java.lang.String scadenaoriginaldigest) {
		this.scadenaoriginaldigest = scadenaoriginaldigest;
	}

	public java.lang.String getScadenaoriginaldigest() {
		return scadenaoriginaldigest;
	}

	public void setSfop(java.lang.String sfop) {
		this.sfop = sfop;
	}

	public java.lang.String getSfop() {
		return sfop;
	}

	public void setSxml(java.lang.String sxml) {
		this.sxml = sxml;
	}

	public java.lang.String getSxml() {
		return sxml;
	}

	public void setMsubtotalsuma(double msubtotalsuma) {
		this.msubtotalsuma = msubtotalsuma;
	}

	public double getMsubtotalsuma() {
		if (this.isBolredondear()) {
			return this.redodedoDouble(msubtotalsuma);
		} else {
			return msubtotalsuma;			
		}
	}

	public void addMsubtotalsuma(double dblMontoAdd) {
		this.msubtotalsuma += dblMontoAdd; 
	}

	public void subMsubtotalsuma(double dblMontoAdd) {
		this.msubtotalsuma -= dblMontoAdd; 
	}
	
	public String getStrMsubtotalsuma() {
		if (this.isBolredondear()) {
			return String.valueOf(this.redodedoDouble(msubtotalsuma));
		} else {
			return String.valueOf(msubtotalsuma);			
		}
	}

	public void setSclientecompleto(java.lang.String sclientecompleto) {
		this.sclientecompleto = sclientecompleto;
	}

	public java.lang.String getSclientecompleto() {
		return sclientecompleto;
	}

	public void setFechaxml(java.lang.String fechaxml) {
		this.fechaxml = fechaxml;
	}

	public java.lang.String getFechaxml() {
		return fechaxml;
	}

	public void setcFormato(int cFormato) {
		this.cFormato = cFormato;
	}

	public int getcFormato() {
		return cFormato;
	}

	public void setObjSucursalBean(SucursalBean objSucursalBean) {
		this.objSucursalBean = objSucursalBean;
	}

	public SucursalBean getObjSucursalBean() {
		return objSucursalBean;
	}

	public void setkOrdenSucursal(String kOrdenSucursal) {
		this.kOrdenSucursal = kOrdenSucursal;
	}

	public String getkOrdenSucursal() {
		return kOrdenSucursal;
	}

	public void setcSucursal(int cSucursal) {
		this.cSucursal = cSucursal;
	}

	public int getcSucursal() {
		return cSucursal;
	}

	public void setTurbine_User(int turbine_User) {
		Turbine_User = turbine_User;
	}

	public int getTurbine_User() {
		return Turbine_User;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

	public void setsURL(String sURL) {
		this.sURL = sURL;
	}

	public String getsURL() {
		return sURL;
	}

	public void setSFacturaOld(String sFacturaOld) {
		this.sFacturaOld = sFacturaOld;
	}

	public String getSFacturaOld() {
		return sFacturaOld;
	}

	public int getcTipoPago() {
		return cTipoPago;
	}

	public void setcTipoPago(int cTipoPago) {
		this.cTipoPago = cTipoPago;
	}

	public String getsTipoPago() {
		return sTipoPago;
	}

	public void setsTipoPago(String sTipoPago) {
		this.sTipoPago = sTipoPago;
	}

	public String getsUltimosDigitos() {
		return sUltimosDigitos;
	}

	public void setsUltimosDigitos(String sUltimosDigitos) {
		this.sUltimosDigitos = sUltimosDigitos;
	}

	public java.sql.ResultSet getRstfacturaempresas() {
		return rstfacturaempresas;
	}

	public void setRstfacturaempresas(java.sql.ResultSet rstfacturaempresas) {
		this.rstfacturaempresas = rstfacturaempresas;
	}

	public Integer getiOrdenCompra() {
		return iOrdenCompra;
	}

	public void setiOrdenCompra(Integer iOrdenCompra) {
		this.iOrdenCompra = iOrdenCompra;
	}

	public String getCFDIFechaTimbrado() {
		return CFDIFechaTimbrado;
	}

	public void setCFDIFechaTimbrado(String cFDIFechaTimbrado) {
		CFDIFechaTimbrado = cFDIFechaTimbrado;
	}

	public String getCFDIUUID() {
		return CFDIUUID;
	}

	public void setCFDIUUID(String cFDIUUID) {
		CFDIUUID = cFDIUUID;
	}

	public String getCFDInoCertificadoSAT() {
		return CFDInoCertificadoSAT;
	}

	public void setCFDInoCertificadoSAT(String cFDInoCertificadoSAT) {
		CFDInoCertificadoSAT = cFDInoCertificadoSAT;
	}

	public String getCFDIselloCFD() {
		return CFDIselloCFD;
	}

	public void setCFDIselloCFD(String cFDIselloCFD) {
		CFDIselloCFD = cFDIselloCFD;
	}

	public String getCFDIselloSAT() {
		return CFDIselloSAT;
	}

	public void setCFDIselloSAT(String cFDIselloSAT) {
		CFDIselloSAT = cFDIselloSAT;
	}

	public boolean getisAddenda() {
		return isAddenda;
	}

	public void setAddenda(boolean isAddenda) {
		this.isAddenda = isAddenda;
	}
	public int getCmarca() {
		return cmarca;
	}

	public void setCmarca(int cmarca) {
		if (cmarca == 3) {
			this.cmarca = 1;
		} else {
			this.cmarca = cmarca;
		}
	}

	public String getNotaDescuento() {
		return notaDescuento;
	}

	public void setNotaDescuento(String notaDescuento) {
		this.notaDescuento = notaDescuento;
	}

	public String getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(String descuentos) {
		this.descuentos = descuentos;
	}

	public boolean isBandDescuento() {
		return bandDescuento;
	}

	public void setBandDescuento(boolean bandDescuento) {
		this.bandDescuento = bandDescuento;
	}

	public boolean isBandRetencion() {
		return bandRetencion;
	}

	public void setBandRetencion(boolean bandRetencion) {
		this.bandRetencion = bandRetencion;
	}

	
	
	
}
