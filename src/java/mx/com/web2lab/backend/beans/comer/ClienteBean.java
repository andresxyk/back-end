package mx.com.web2lab.backend.beans.comer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/** @author Hibernate CodeGenerator */
public class ClienteBean implements Serializable {

    /** identifier field */
    private int ccliente;

    /** identifier field */
    private int cmarca = 1;
    
    private String smarca = "";
    
    private String smarcauser = "";
    
    /** nullable persistent field */
    private java.lang.String srazonsocial;

    /** nullable persistent field */
    private java.lang.String srfc;

    /** nullable persistent field */
    private java.lang.String smnemonico;
    
    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** nullable persistent field */
    private java.lang.String sobservaciones;

    /** persistent field */
    int ccodigopostal;
    
    /** nullable persistent field */
    private java.lang.String scolonia;
    
    /** nullable persistent field */
    private java.lang.String sdelegacionmunicipio;

    /** nullable persistent field */
    private java.lang.String sestado;
    
    /** nullable persistent field */
    private java.lang.String scodigopostal;
    
    /** persistent field */
    private int ctipocliente;

    /** persistent field */
    private int cgirocliente;
    
    /** persistent field */
    private int ctipopersona;

    /** persistent field */
    private int cestadoregistro;

    /** persistent field */
    private String sestadoregistro;

    private List lstConvenios = new ArrayList();

    private List lstFacturas = new ArrayList();
    
    private String strConvenioGrid = "";

    private String strFacturasGrid = "";

    private List lstFacturasCxC = new ArrayList();
    
    private double dblOrdenesNoFacturadas = 0.0;
    
    private String sreport_pages_cxc;
    
    private boolean breadonly = true;
    
    private int czonaventa = 0;

    /** persistent field */
    private int cregimenfiscal;
    
    /** persistent field */
    private int cusocfdi;
    
    private int udiascredito;
    
    private String ssector;
    private String sejecutivocobranza;
    private String scorreoejecutivocobranza;
    private String snombreejecutivocomercial;
    private String scorreoejecutivocomercial;
    private String snombrecontacto;
    private String stelefonocontacto;
    private String scorreocontacto;
    private boolean bcuentapromesapago;
    private String sindicacionesadicionalescobro;
    private String scanalenvio;
    private String shorariodiaentrega;
    private String sdomicilioentrega;
    private String sligaportal;
    private String susuarioportal;
    private String scontrasenaportal; 
    
    private String sdeptoejecomer;
    private String sdirejecomer;
    private String stelejecomer;

    private String sdeptocontacto;
    private String sdircontacto;
    private String sdiashrscontacto;
    private String dfeccierrecontacto;

    private String sdeptoejecob;
    private String sdirejecob;
    private String stelejecob;

    // Getters y Setters

    public String getSdeptoejecomer() {
        return sdeptoejecomer;
    }
    public void setSdeptoejecomer(String sdeptoejecomer) {
        this.sdeptoejecomer = sdeptoejecomer;
    }

    public String getSdirejecomer() {
        return sdirejecomer;
    }
    public void setSdirejecomer(String sdirejecomer) {
        this.sdirejecomer = sdirejecomer;
    }

    public String getStelejecomer() {
        return stelejecomer;
    }
    public void setStelejecomer(String stelejecomer) {
        this.stelejecomer = stelejecomer;
    }

    public String getSdeptocontacto() {
        return sdeptocontacto;
    }
    public void setSdeptocontacto(String sdeptocontacto) {
        this.sdeptocontacto = sdeptocontacto;
    }

    public String getSdircontacto() {
        return sdircontacto;
    }
    public void setSdircontacto(String sdircontacto) {
        this.sdircontacto = sdircontacto;
    }

    public String getSdiashrscontacto() {
        return sdiashrscontacto;
    }
    public void setSdiashrscontacto(String sdiashrscontacto) {
        this.sdiashrscontacto = sdiashrscontacto;
    }

    public String getDfeccierrecontacto() {
        return dfeccierrecontacto;
    }
    public void setDfeccierrecontacto(String dfeccierrecontacto) {
        this.dfeccierrecontacto = dfeccierrecontacto;
    }

    public String getSdeptoejecob() {
        return sdeptoejecob;
    }
    public void setSdeptoejecob(String sdeptoejecob) {
        this.sdeptoejecob = sdeptoejecob;
    }

    public String getSdirejecob() {
        return sdirejecob;
    }
    public void setSdirejecob(String sdirejecob) {
        this.sdirejecob = sdirejecob;
    }

    public String getStelejecob() {
        return stelejecob;
    }
    public void setStelejecob(String stelejecob) {
        this.stelejecob = stelejecob;
    }

	public int getUdiascredito() {
		return udiascredito;
	}


	public void setUdiascredito(int udiascredito) {
		this.udiascredito = udiascredito;
	}


	public int getCregimenfiscal() {
		return cregimenfiscal;
	}


	public void setCregimenfiscal(int cregimenfiscal) {
		this.cregimenfiscal = cregimenfiscal;
	}


	public int getCusocfdi() {
		return cusocfdi;
	}


	public void setCusocfdi(int cusocfdi) {
		this.cusocfdi = cusocfdi;
	}
    
	public String getSmarcauser() {
		return smarcauser;
	}

	public void setSmarcauser(String smarcauser) {
		this.smarcauser = smarcauser;
	}

	public int getCcliente() {
		return ccliente;
	}

	public void setCcliente(int ccliente) {
		this.ccliente = ccliente;
	}

	public java.lang.String getSrazonsocial() {
		return srazonsocial;
	}

	public void setSrazonsocial(java.lang.String srazonsocial) {
		this.srazonsocial = srazonsocial;
	}

	public java.lang.String getSrfc() {
		return srfc;
	}

	public void setSrfc(java.lang.String srfc) {
		this.srfc = srfc;
	}

	public java.lang.String getSdireccion() {
		return sdireccion;
	}

	public void setSdireccion(java.lang.String sdireccion) {
		this.sdireccion = sdireccion;
	}

	public java.lang.String getSobservaciones() {
		return sobservaciones;
	}

	public void setSobservaciones(java.lang.String sobservaciones) {
		this.sobservaciones = sobservaciones;
	}

	public int getCcodigopostal() {
		return ccodigopostal;
	}

	public void setCcodigopostal(int ccodigopostal) {
		this.ccodigopostal = ccodigopostal;
	}

	public java.lang.String getScolonia() {
		return scolonia;
	}

	public void setScolonia(java.lang.String scolonia) {
		this.scolonia = scolonia;
	}

	public java.lang.String getSdelegacionmunicipio() {
		return sdelegacionmunicipio;
	}

	public void setSdelegacionmunicipio(java.lang.String sdelegacionmunicipio) {
		this.sdelegacionmunicipio = sdelegacionmunicipio;
	}

	public java.lang.String getSestado() {
		return sestado;
	}

	public void setSestado(java.lang.String sestado) {
		this.sestado = sestado;
	}

	public java.lang.String getScodigopostal() {
		return scodigopostal;
	}

	public void setScodigopostal(java.lang.String scodigopostal) {
		this.scodigopostal = scodigopostal;
	}

	public int getCtipocliente() {
		return ctipocliente;
	}

	public void setCtipocliente(int ctipocliente) {
		this.ctipocliente = ctipocliente;
	}

	public int getCtipopersona() {
		return ctipopersona;
	}

	public void setCtipopersona(int ctipopersona) {
		this.ctipopersona = ctipopersona;
	}

	public int getCestadoregistro() {
		return cestadoregistro;
	}

	public void setCestadoregistro(int cestadoregistro) {
		this.cestadoregistro = cestadoregistro;
	}

	public List getLstConvenios() {
		return lstConvenios;
	}

	public List getLstFacturasCxC() {
		return this.lstFacturasCxC;
	}
	
	public void add(ConvenioBean objConvenioBean) {
		this.lstConvenios.add(objConvenioBean);
		for(int inti=0;inti<objConvenioBean.getLstFacturas().size();inti++){
			this.lstFacturasCxC.add(objConvenioBean.getLstFacturas().get(inti));
		}
	}

	public void setLstConvenios(List lstConvenios) {
		this.lstConvenios = lstConvenios;
	}

	public void sortLstConvenios() {
		Collections.sort(this.lstConvenios);
	}
	
	public String getStrConvenioGrid() {
		return strConvenioGrid;
	}

	public void setStrConvenioGrid(String strConvenioGrid) {
		this.strConvenioGrid = strConvenioGrid;
	}

	public java.lang.String getSmnemonico() {
		return smnemonico;
	}

	public void setSmnemonico(java.lang.String smnemonico) {
		this.smnemonico = smnemonico;
	}

	public String getSestadoregistro() {
		return sestadoregistro;
	}

	public void setSestadoregistro(String sestadoregistro) {
		this.sestadoregistro = sestadoregistro;
	}

	public int getCgirocliente() {
		return cgirocliente;
	}

	public void setCgirocliente(int cgirocliente) {
		this.cgirocliente = cgirocliente;
	}

	public void setStrFacturasGrid(String strFacturasGrid) {
		this.strFacturasGrid = strFacturasGrid;
	}

	public String getStrFacturasGrid() {
		return strFacturasGrid;
	}

	public void setLstFacturas(List lstFacturas) {
		this.lstFacturas = lstFacturas;
	}

	public List getLstFacturas() {
		return lstFacturas;
	}

	public double getDblOrdenesNoFacturadas() {
		return dblOrdenesNoFacturadas;
	}

	public void setDblOrdenesNoFacturadas(double dblOrdenesNoFacturadas) {
		this.dblOrdenesNoFacturadas = dblOrdenesNoFacturadas;
	}

	public String getSreport_pages_cxc() {
		return sreport_pages_cxc;
	}

	public void setSreport_pages_cxc(String sreport_pages_cxc) {
		this.sreport_pages_cxc = sreport_pages_cxc;
	}

	public boolean isBreadonly() {
		return breadonly;
	}

	public void setBreadonly(boolean breadonly) {
		this.breadonly = breadonly;
	}

	public int getCmarca() {
		return cmarca;
	}

	public void setCmarca(int cmarca) {
		this.cmarca = cmarca;
	}

	public String getSmarca() {
		if (this.cmarca == 1) {
			this.smarca = "OLAB";
		} else if (this.cmarca == 4) {
			this.smarca = "AZTECA";
		} else if (this.cmarca == 5) {
			this.smarca = "SWISSLAB";
		} else if (this.cmarca == 7) {
			this.smarca = "JENNER";
		} else if (this.cmarca == 15) {
			this.smarca = "LIACSA";
		} else if (this.cmarca == 17) {
			this.smarca = "DIAGNOSTIX";
		} else if (this.cmarca == 19) {
			this.smarca = "FAMILY LABS NORTE";
		} else if (this.cmarca == 20) {
			this.smarca = "EXAKTA";
		} else if (this.cmarca == 21) {
			this.smarca = "ASESORES DEL SUR";
		} else if (this.cmarca == 16) {
			this.smarca = "MOREIRA";
		} else if (this.cmarca == 22) {
			this.smarca = "POLAB";
		} else if (this.cmarca == 25) {
			this.smarca = "BIOMEDICA DE REFERENCIA";
		} else if (this.cmarca == 26) {
			this.smarca = "PROMEDIC";
		} else if (this.cmarca == 9) {
			this.smarca = "SWISS HOSPITAL";
		}
		return smarca;
	}

	public void setSmarca(String smarca) {
		this.smarca = smarca;
	}

	public int getCzonaventa() {
		return czonaventa;
	}

	public void setCzonaventa(int czonaventa) {
		this.czonaventa = czonaventa;
	}


	public String getSnombrecontacto() {
		return snombrecontacto;
	}


	public void setSnombrecontacto(String snombrecontacto) {
		this.snombrecontacto = snombrecontacto;
	}


	public String getSsector() {
		return ssector;
	}


	public void setSsector(String ssector) {
		this.ssector = ssector;
	}


	public String getSejecutivocobranza() {
		return sejecutivocobranza;
	}


	public void setSejecutivocobranza(String sejecutivocobranza) {
		this.sejecutivocobranza = sejecutivocobranza;
	}


	public String getScorreoejecutivocobranza() {
		return scorreoejecutivocobranza;
	}


	public void setScorreoejecutivocobranza(String scorreoejecutivocobranza) {
		this.scorreoejecutivocobranza = scorreoejecutivocobranza;
	}


	public String getSnombreejecutivocomercial() {
		return snombreejecutivocomercial;
	}


	public void setSnombreejecutivocomercial(String snombreejecutivocomercial) {
		this.snombreejecutivocomercial = snombreejecutivocomercial;
	}


	public String getScorreoejecutivocomercial() {
		return scorreoejecutivocomercial;
	}


	public void setScorreoejecutivocomercial(String scorreoejecutivocomercial) {
		this.scorreoejecutivocomercial = scorreoejecutivocomercial;
	}


	public String getStelefonocontacto() {
		return stelefonocontacto;
	}


	public void setStelefonocontacto(String stelefonocontacto) {
		this.stelefonocontacto = stelefonocontacto;
	}


	public String getScorreocontacto() {
		return scorreocontacto;
	}


	public void setScorreocontacto(String scorreocontacto) {
		this.scorreocontacto = scorreocontacto;
	}


	public boolean isBcuentapromesapago() {
		return bcuentapromesapago;
	}


	public void setBcuentapromesapago(boolean bcuentapromesapago) {
		this.bcuentapromesapago = bcuentapromesapago;
	}


	public String getSindicacionesadicionalescobro() {
		return sindicacionesadicionalescobro;
	}


	public void setSindicacionesadicionalescobro(String sindicacionesadicionalescobro) {
		this.sindicacionesadicionalescobro = sindicacionesadicionalescobro;
	}


	public String getScanalenvio() {
		return scanalenvio;
	}


	public void setScanalenvio(String scanalenvio) {
		this.scanalenvio = scanalenvio;
	}


	public String getShorariodiaentrega() {
		return shorariodiaentrega;
	}


	public void setShorariodiaentrega(String shorariodiaentrega) {
		this.shorariodiaentrega = shorariodiaentrega;
	}


	public String getSdomicilioentrega() {
		return sdomicilioentrega;
	}


	public void setSdomicilioentrega(String sdomicilioentrega) {
		this.sdomicilioentrega = sdomicilioentrega;
	}


	public String getSligaportal() {
		return sligaportal;
	}


	public void setSligaportal(String sligaportal) {
		this.sligaportal = sligaportal;
	}


	public String getSusuarioportal() {
		return susuarioportal;
	}


	public void setSusuarioportal(String susuarioportal) {
		this.susuarioportal = susuarioportal;
	}


	public String getScontrasenaportal() {
		return scontrasenaportal;
	}


	public void setScontrasenaportal(String scontrasenaportal) {
		this.scontrasenaportal = scontrasenaportal;
	}


	public void setLstFacturasCxC(List lstFacturasCxC) {
		this.lstFacturasCxC = lstFacturasCxC;
	}

}
