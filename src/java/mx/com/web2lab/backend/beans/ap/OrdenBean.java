package mx.com.web2lab.backend.beans.ap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.facturacion.DatosFiscalesBean;


public class OrdenBean implements Serializable {

    /** persistent field */
    private long kadmision = 0;

    /** persistent field */
    private int cordenfundacion = 0;

    /** persistent field */
    private int csucursal = 0;

    /** persistent field */
    private int cmarca = 0;
    
    private String ssucursal = "";
    
    /** nullable persistent field */
    private java.lang.String sordenfundacion = "";

    /** nullable persistent field */
    private java.lang.String sordencompleta = "";
    
    /** nullable persistent field */
    private double msubtotal = 0;

    /** nullable persistent field */
    private double mdescuento = 0;

    private double mdescuentopaciente = 0;
    
    private double mdescuentoempresa = 0;

    private double mfacturaempresa = 0;

    private double mpagapaciente = 0;

    /** nullable persistent field */
    private double miva = 0;

    /** nullable persistent field */
    private double mtotal = 0;

    /** nullable persistent field */
    private double macuenta = 0;

    /** nullable persistent field */
    private double madeuda = 0;

    /** nullable persistent field */
    private long nfactura = 0;

    /** nullable persistent field */
    private java.lang.String sobservacion = "";

    private int kmedico = 0;
    
    private int cmedico = 0;
    
    private String snombre = "";

    private String sappaterno = "";

    private String sapmaterno = "";

    /** nullable persistent field */
    private java.util.Date dpromesa = new Date();

    private String sdpromesa = "";
    
    /** nullable persistent field */
    private java.util.Date dentregaresultado = new Date();

    private String sdentregaresultado = "";
    
    /** nullable persistent field */
    private int cestado;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro = new Date();

    /** persistent field */
    private int cconvenio;

    /** persistent field */
    private int cordensolicitada;

	/** persistent field */
    private int bautorizacionverresultadosmedico;

    private String sconvenio = "";
    
    private boolean bmuestraspendientes;
    
    /** persistent field */
    private mx.com.web2lab.backend.beans.ap.PacienteBean bpacientebean;

    private List lstExamenes = new ArrayList();
    
    private List lstPagos = new ArrayList();

    private String strFactura = ""; 
    
    private boolean bolcotizacionexameneslaboratorio = false;
    
    private int cUltimoTipoPago = 0;

    private String sUltimosTipoPago = "";
    
    private String sUltimosDigitosPago = "";
    
    private String sentregaresultadosa = "";
    
    /* Create 21/03/2013 Author OMRR */
    private String smensajeerror = "";
    
    /* Create 21/03/2013 Author OMRR */
    private DatosFiscalesBean objdatosfiscalesbean;
        
    private int nofacturas = 0;
    
    private int uanoactual = 0;
    
    private int uanoorden = 0;
    
    /** default constructor */
    public OrdenBean() {
    }
    
    public void loadExamen(OrdenExamenBean objExamenBean) {
    	if (this.lstExamenes.size() ==  0) {
        	this.msubtotal = 0.0;
        	this.mdescuento = 0.0;
        	this.mdescuentoempresa = 0.0;
        	this.mfacturaempresa = 0.0;
        	this.mpagapaciente = 0.0;
        	this.miva = 0.0;
        	this.mtotal = 0.0;    		
    	}
    	this.lstExamenes.add(objExamenBean);
    	this.msubtotal = (this.msubtotal + objExamenBean.getMsubtotal());
    	this.mdescuento = (this.mdescuento + objExamenBean.getMdescuentopromocion());
    	this.mdescuentoempresa = (this.mdescuentoempresa + objExamenBean.getMdescuentoempresa());
    	this.mfacturaempresa = (this.mfacturaempresa + objExamenBean.getMfacturaempresa());
    	this.mpagapaciente = (this.mpagapaciente + objExamenBean.getMpagopaciente());
    	this.miva = (this.miva + objExamenBean.getMiva());
    	this.mtotal = (this.mtotal + objExamenBean.getMtotal());
    }

    public void loadPago(PagoPacienteBean objPagoBean) {
    	this.macuenta = (objPagoBean.getManticipo() + objPagoBean.getMpagopacienteparcial());
    	this.madeuda = this.mpagapaciente - this.macuenta;
    }
    
    public long getKadmision() {
        return this.kadmision;
    }

    public void setKadmision(long kadmision) {
        this.kadmision = kadmision;
    }

    public int getCordenfundacion() {
        return this.cordenfundacion;
    }

    public void setCordenfundacion(int cordenfundacion) {
        this.cordenfundacion = cordenfundacion;
    }

    public java.lang.String getSordenfundacion() {
        return this.sordenfundacion;
    }

    public void setSordenfundacion(java.lang.String sordenfundacion) {
        this.sordenfundacion = sordenfundacion;
    }

    public double getMsubtotal() {
        return this.msubtotal;
    }

    public void setMsubtotal(double msubtotal) {
        this.msubtotal = msubtotal;
    }

    public double getMdescuento() {
        return this.mdescuento;
    }

    public void setMdescuento(double mdescuento) {
        this.mdescuento = mdescuento;
    }

    public double getMiva() {
        return this.miva;
    }

    public void setMiva(double miva) {
        this.miva = miva;
    }

    public double getMtotal() {
        return this.mtotal;
    }

    public void setMtotal(double mtotal) {
        this.mtotal = mtotal;
    }

    public double getMacuenta() {
        return this.macuenta;
    }

    public void setMacuenta(double macuenta) {
        this.macuenta = macuenta;
    }

    public double getMadeuda() {
        return this.madeuda;
    }

    public void setMadeuda(double madeuda) {
        this.madeuda = madeuda;
    }

    public long getNfactura() {
        return this.nfactura;
    }

    public void setNfactura(long nfactura) {
        this.nfactura = nfactura;
    }

    public java.lang.String getSobservacion() {
        return this.sobservacion;
    }

    public void setSobservacion(java.lang.String sobservacion) {
        this.sobservacion = sobservacion;
    }

    public java.util.Date getDpromesa() {
        return this.dpromesa;
    }

    public void setDpromesa(java.util.Date dpromesa) {
        this.dpromesa = dpromesa;
    }

    public java.util.Date getDentregaresultado() {
        return this.dentregaresultado;
    }

    public void setDentregaresultado(java.util.Date dentregaresultado) {
        this.dentregaresultado = dentregaresultado;
    }

    public int getCestado() {
        return this.cestado;
    }

    public void setCestado(int cestado) {
        this.cestado = cestado;
    }

    public boolean isBregistroactivo() {
        return this.bregistroactivo;
    }

    public void setBregistroactivo(boolean bregistroactivo) {
        this.bregistroactivo = bregistroactivo;
    }

    public int getCusuario() {
        return this.cusuario;
    }

    public void setCusuario(int cusuario) {
        this.cusuario = cusuario;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

	public String getSdpromesa() {
		return sdpromesa;
	}

	public void setSdpromesa(String sdpromesa) {
		this.sdpromesa = sdpromesa;
	}

	public String getSdentregaresultado() {
		return sdentregaresultado;
	}

	public void setSdentregaresultado(String sdentregaresultado) {
		this.sdentregaresultado = sdentregaresultado;
	}

	public mx.com.web2lab.backend.beans.ap.PacienteBean getBpacientebean() {
		return bpacientebean;
	}

	public void setBpacientebean(mx.com.web2lab.backend.beans.ap.PacienteBean bpacientebean) {
		this.bpacientebean = bpacientebean;
	}

	public java.lang.String getSordencompleta() {
		return sordencompleta;
	}

	public void setSordencompleta(java.lang.String sordencompleta) {
		this.sordencompleta = sordencompleta;
	}

	public double getMdescuentopaciente() {
		return mdescuentopaciente;
	}

	public void setMdescuentopaciente(double mdescuentopaciente) {
		this.mdescuentopaciente = mdescuentopaciente;
	}

	public double getMdescuentoempresa() {
		return mdescuentoempresa;
	}

	public void setMdescuentoempresa(double mdescuentoempresa) {
		this.mdescuentoempresa = mdescuentoempresa;
	}

	public double getMfacturaempresa() {
		return mfacturaempresa;
	}

	public void setMfacturaempresa(double mfacturaempresa) {
		this.mfacturaempresa = mfacturaempresa;
	}

	public double getMpagapaciente() {
		return mpagapaciente;
	}

	public void setMpagapaciente(double mpagapaciente) {
		this.mpagapaciente = mpagapaciente;
	}

	public List getLstExamenes() {
		return lstExamenes;
	}

	public void setLstExamenes(List lstExamenes) {
		this.lstExamenes = lstExamenes;
	}

	public List getLstPagos() {
		return lstPagos;
	}

	public void setLstPagos(List lstPagos) {
		this.lstPagos = lstPagos;
	}

	public int getCmedico() {
		return cmedico;
	}

	public void setCmedico(int cmedico) {
		this.cmedico = cmedico;
	}

	public int getKmedico() {
		return kmedico;
	}

	public void setKmedico(int kmedico) {
		this.kmedico = kmedico;
	}

	public String getSnombre() {
		return snombre;
	}

	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}

	public String getSappaterno() {
		return sappaterno;
	}

	public void setSappaterno(String sappaterno) {
		this.sappaterno = sappaterno;
	}

	public String getSapmaterno() {
		return sapmaterno;
	}

	public void setSapmaterno(String sapmaterno) {
		this.sapmaterno = sapmaterno;
	}

	public int getCconvenio() {
		return cconvenio;
	}

	public void setCconvenio(int cconvenio) {
		this.cconvenio = cconvenio;
	}

	public void setSconvenio(String sconvenio) {
		this.sconvenio = sconvenio;
	}

	public String getSconvenio() {
		return sconvenio;
	}
	
	public int sizeExamenes() {
		if (this.lstExamenes == null) {
			return 0;
		} else {
			return this.lstExamenes.size();
		}
	}

	public OrdenExamenBean getOrdenExamen(int inti) {
		if (this.lstExamenes == null) {
			return null;
		} else {
			return (OrdenExamenBean)this.lstExamenes.get(inti);			
		}
	}
	
	public void setOrdenExamen(OrdenExamenBean objExamen) {
		if (this.lstExamenes == null) {
			lstExamenes = new ArrayList();
		}
		this.lstExamenes.add(objExamen);
	}

	public void setStrFactura(String strFactura) {
		this.strFactura = strFactura;
	}

	public String getStrFactura() {
		return strFactura;
	}

	public void setCsucursal(int csucursal) {
		this.csucursal = csucursal;
	}

	public int getCsucursal() {
		return csucursal;
	}
	
    public int getCordensolicitada() {
		return cordensolicitada;
	}

	public void setCordensolicitada(int cordensolicitada) {
		this.cordensolicitada = cordensolicitada;
	}

	public int getBautorizacionverresultadosmedico() {
		return bautorizacionverresultadosmedico;
	}

	public void setBautorizacionverresultadosmedico(
			int bautorizacionverresultadosmedico) {
		this.bautorizacionverresultadosmedico = bautorizacionverresultadosmedico;
	}

	public void setBolcotizacionexameneslaboratorio(
			boolean bolcotizacionexameneslaboratorio) {
		this.bolcotizacionexameneslaboratorio = bolcotizacionexameneslaboratorio;
	}

	public boolean isBolcotizacionexameneslaboratorio() {
		return this.bolcotizacionexameneslaboratorio;
	}

	public int getcUltimoTipoPago() {
		return cUltimoTipoPago;
	}

	public void setcUltimoTipoPago(int cUltimoTipoPago) {
		this.cUltimoTipoPago = cUltimoTipoPago;
	}

	public String getsUltimosDigitosPago() {
		return sUltimosDigitosPago;
	}

	public void setsUltimosDigitosPago(String sUltimosDigitosPago) {
		this.sUltimosDigitosPago = sUltimosDigitosPago;
	}

	public String getsUltimosTipoPago() {
		return sUltimosTipoPago;
	}

	public void setsUltimosTipoPago(String sUltimosTipoPago) {
		this.sUltimosTipoPago = sUltimosTipoPago;
	}

	public String getSentregaresultadosa() {
		return sentregaresultadosa;
	}

	public void setSentregaresultadosa(String sentregaresultadosa) {
		this.sentregaresultadosa = sentregaresultadosa;
	}

    /* Create 21/03/2013 Author OMRR */
	public String getSmensajeerror() {
		return smensajeerror;
	}

    /* Create 21/03/2013 Author OMRR */
	public void setSmensajeerror(String smensajeerror) {
		this.smensajeerror = smensajeerror;
	}

	public String getSsucursal() {
		return ssucursal;
	}

	public void setSsucursal(String ssucursal) {
		this.ssucursal = ssucursal;
	}

	public DatosFiscalesBean getObjdatosfiscalesbean() {
		return objdatosfiscalesbean;
	}

	public void setObjdatosfiscalesbean(DatosFiscalesBean objdatosfiscalesbean) {
		this.objdatosfiscalesbean = objdatosfiscalesbean;
	}
	
	
	public String[] getDatosDemograficosFacturacionElectronica(String sEmail, String strMensaje1 ,String strMensaje2) {
		String[] strReturn = {"",""};
		if ((this.getObjdatosfiscalesbean().getkDatosFiscales() > 0) && (strMensaje1.trim().length() == 0) && (this.getSmensajeerror().trim().length() == 0) && (this.getStrFactura().trim().length() == 0)) {
			strReturn[0] =	"<p class=\"subcab\">								\n " +
				            "	Confirme sus datos fiscales						\n " +
				            "</p>												\n " +
				            "<div id=\"datos_fiscales\">						\n " +
				            "        <p class=\"txt_fisc1\">					\n " +
				            "        RFC:										\n " +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " 
				                    + this.getObjdatosfiscalesbean().getStrRFC() +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc1\">					\n " +
				            "        Raz&oacute;n Social:								\n " +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " 
				                    + this.getObjdatosfiscalesbean().getStrRazonSocial() +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc1\">					\n " +
				            "        Direcci&oacute;n:									\n " +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " 
				                    + this.getObjdatosfiscalesbean().getStrDireccion() +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " +
				            " 			COLONIA " + this.getObjdatosfiscalesbean().getStrColonia() + "<br/>DELEGACION " + this.getObjdatosfiscalesbean().getStrDelegacionMunicipio() +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " +
				            "        	ESTADO " + this.getObjdatosfiscalesbean().getStrCiudad() + "<br/>CP " + this.getObjdatosfiscalesbean().getcPostal() +
				            "        </p>										\n " +
				            "</div>												\n " +
							"<div id=\"b_continuar\">							\n " +
							"		<a href='javascript:guardarFactura();' class=\"xyz\">Continuar</a>	\n " +
							"</div>												\n " +
				            "<div id=\"b_modificar\">							\n " +
							"		<a href='javascript:editarrfc();' class=\"xyz2\">Modificar datos fiscales</a>	\n " +
							"</div>	\n ";
			strReturn[1] = 	"";			
		} else {
			String strTituloFacturacion = "";
			if (this.getStrFactura().trim().length() > 0) {
				strTituloFacturacion = "ORDEN FACTURADA";
				strMensaje1 = "Esta Orden ya esta facturada, Comun&iacute;quese a la Sucursal por favor";
				strMensaje2 = "Con la factura numero " + "<a href='http://192.237.150.66:9085/FacturasElectronicas_Olab/XMLTMP/PDF/FacturacionElectronica_" + this.getStrFactura() + ".pdf'><div class='clearfix grpelem' id='u7917-4-OMRR'><p>" + this.getStrFactura() + "</a>" ;
			} else if (this.getSmensajeerror().trim().length() > 0) {
				strTituloFacturacion = "MENSAJE DE ERROR";
				strMensaje1 = this.getSmensajeerror();
			} else {
				strTituloFacturacion = "MENSAJE DE ERROR";				
			}
			
			strReturn[0] =	"<p class=\"subcab\">								\n " +
				            "	" + strTituloFacturacion + "					\n " +
				            "</p>												\n " +
				            "<div id=\"datos_fiscales\">						\n " +
				            "        <p class=\"txt_fisc1\">					\n " +
				            "        .											\n " +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " 
				                    + strMensaje1 +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc1\">					\n " +
				            "        .											\n " +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " 
				                    + strMensaje2 +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc1\">					\n " +
				            "        .											\n " +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc1\">					\n " +
				            "        </p>										\n " +
				            "        <p class=\"txt_fisc2\">					\n " +
				            "        </p>										\n " +
				            "</div>												\n " +
							"<div id=\"b_continuar\">							\n " +
							"</div>												\n " +
				            "<div id=\"b_modificar\">							\n " +
							"</div>	\n ";
			strReturn[1] = "";
		}
		return strReturn;
	}

	public boolean isBmuestraspendientes() {
		return bmuestraspendientes;
	}

	public void setBmuestraspendientes(boolean bmuestraspendientes) {
		this.bmuestraspendientes = bmuestraspendientes;
	}

	public int getNofacturas() {
		return nofacturas;
	}

	public void setNofacturas(int nofacturas) {
		this.nofacturas = nofacturas;
	}

	public int getCmarca() {
		return cmarca;
	}

	public void setCmarca(int cmarca) {
		this.cmarca = cmarca;
	}

	public int getUanoactual() {
		return uanoactual;
	}

	public void setUanoactual(int uanoactual) {
		this.uanoactual = uanoactual;
	}

	public int getUanoorden() {
		return uanoorden;
	}

	public void setUanoorden(int uanoorden) {
		this.uanoorden = uanoorden;
	}
}
