package mx.com.web2lab.backend.beans.comer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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

}
