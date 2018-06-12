package mx.com.web2lab.backend.beans.comer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import mx.com.web2lab.backend.hbm.ConfiguracionProperties;
import mx.com.web2lab.backend.hbm.om.reportes.TAntiguedadCxc;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import mx.com.web2lab.backend.util.formatos.Formatos;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ConvenioBean implements Comparable,Serializable {
    /** identifier field */
    private java.lang.Integer kconvenio;
	
    /** identifier field */
    private java.lang.Integer cconvenio;
    
    /** identifier field */
    private int cmarca = 1;

    /** nullable persistent field */
    private java.lang.String sconvenio;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** nullable persistent field */
    private String siniciovigencia;

    /** nullable persistent field */
    private String sterminovigencia;
    
    /** persistent field */
    private int ctipoconvenio;

    private String stipoconvenio;

    /** persistent field */
    private int ctipodescuento;    
    
    /** persistent field */
    private int ccliente;

    private String scliente;

    private String srfc;

    private String sdireccion;
    
    private int cvigencia;

    /** persistent field */
    private int clistacorporativa;
    
    private String sestadoconvenio;
    
    private Integer uestadoconvenio = new Integer(0);
    
    private List lstExamenes = new ArrayList();
    
    private String strDetalleExamenes = "";

    /** nullable persistent field */
    private java.util.Date dinicio;

    /** nullable persistent field */
    private java.util.Date dtermino;
    
    /** nullable persistent field */
    private String strvencimiento;

    private List lstFacturas = new ArrayList();
    
    private String strFacturasGrid = "";
    
    private int cuser;
    
    private int intDiasCredito = 30;
    
    private String scorreoelectronico;
    
    private String spassword;
    
    private String spasswordconsulta;
    
    private String sreportecxc;
        
    
    public ConvenioBean () {

    }
    
    public ConvenioBean (Integer cConvenio) {
    	this.cconvenio = cConvenio;
    	this.sconvenio = "";
    }
    
	public java.lang.Integer getCconvenio() {
		return cconvenio;
	}

	public void setCconvenio(java.lang.Integer cconvenio) {
		this.cconvenio = cconvenio;
	}

	public java.lang.String getSconvenio() {
		return sconvenio;
	}

	public void setSconvenio(java.lang.String sconvenio) {
		this.sconvenio = sconvenio;
	}

	public java.util.Date getDregistro() {
		return dregistro;
	}

	public void setDregistro(java.util.Date dregistro) {
		this.dregistro = dregistro;
	}

	public String getSiniciovigencia() {
		return siniciovigencia;
	}

	public void setSiniciovigencia(String siniciovigencia) {
		this.siniciovigencia = siniciovigencia;
	}

	public String getSterminovigencia() {
		return sterminovigencia;
	}

	public void setSterminovigencia(String sterminovigencia) {
		this.sterminovigencia = sterminovigencia;
	}

	public int getCtipoconvenio() {
		return ctipoconvenio;
	}

	public void setCtipoconvenio(int ctipoconvenio) {
		this.ctipoconvenio = ctipoconvenio;
	}

	public int getCcliente() {
		return ccliente;
	}

	public void setCcliente(int ccliente) {
		this.ccliente = ccliente;
	}

	public int getCvigencia() {
		return cvigencia;
	}

	public void setCvigencia(int cvigencia) {
		this.cvigencia = cvigencia;
	}

	public int getClistacorporativa() {
		return clistacorporativa;
	}

	public void setClistacorporativa(int clistacorporativa) {
		this.clistacorporativa = clistacorporativa;
	}

	public String getScliente() {
		return scliente;
	}

	public void setScliente(String scliente) {
		this.scliente = scliente;
	}

	public List getLstExamenes() {
		return lstExamenes;
	}

	public void setLstExamenes(List lstExamenes) {
		this.lstExamenes = lstExamenes;
	}

	public java.lang.Integer getKconvenio() {
		return kconvenio;
	}

	public void setKconvenio(java.lang.Integer kconvenio) {
		this.kconvenio = kconvenio;
	}

	public String getStipoconvenio() {
		return stipoconvenio;
	}

	public void setStipoconvenio(String stipoconvenio) {
		this.stipoconvenio = stipoconvenio;
	}

	public String getStrDetalleExamenes() {
		return strDetalleExamenes;
	}

	public void setStrDetalleExamenes(String strDetalleExamenes) {
		this.strDetalleExamenes = strDetalleExamenes;
	}

	public int getCtipodescuento() {
		return ctipodescuento;
	}

	public void setCtipodescuento(int ctipodescuento) {
		this.ctipodescuento = ctipodescuento;
	}

	public String getSestadoconvenio() {
		return sestadoconvenio;
	}

	public void setSestadoconvenio(String sestadoconvenio) {
		this.sestadoconvenio = sestadoconvenio;
	}

	public Integer getUestadoconvenio() {
		return uestadoconvenio;
	}

	public void setUestadoconvenio(Integer uestadoconvenio) {
		this.uestadoconvenio = uestadoconvenio;
	}

	public java.util.Date getDinicio() {
		return dinicio;
	}

	public void setDinicio(java.util.Date dinicio) {
		this.dinicio = dinicio;
	}

	public java.util.Date getDtermino() {
		return dtermino;
	}

	public void setDtermino(java.util.Date dtermino) {
		this.dtermino = dtermino;
	}

	public void setStrvencimiento(String strvencimiento) {
		this.strvencimiento = strvencimiento;
	}

	public String getStrvencimiento() {
		return strvencimiento;
	}

	public void setCuser(int cuser) {
		this.cuser = cuser;
	}

	public int getCuser() {
		return cuser;
	}    
	
	 public int compareTo(Object o) {
		 ConvenioBean otroConvenio = (ConvenioBean) o;
		 return this.uestadoconvenio.compareTo(otroConvenio.getUestadoconvenio());
	}

	public void setLstFacturas(List lstFacturas) {
		this.lstFacturas = lstFacturas;
	}

	public List getLstFacturas() {
		return lstFacturas;
	}

	public void setStrFacturasGrid(String strFacturasGrid) {
		this.strFacturasGrid = strFacturasGrid;
	}

	public String getStrFacturasGrid() {
		return strFacturasGrid;
	}

	public void setIntDiasCreditoNew(int intDiasCredito) {
		this.intDiasCredito = intDiasCredito;
	}

	public int getIntDiasCreditoNew() {
		return intDiasCredito;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setScorreoelectronico(String scorreoelectronico) {
		this.scorreoelectronico = scorreoelectronico;
	}

	public String getScorreoelectronico() {
		return scorreoelectronico;
	}

	public void setSpasswordconsulta(String spasswordconsulta) {
		this.spasswordconsulta = spasswordconsulta;
	}

	public String getSpasswordconsulta() {
		return spasswordconsulta;
	}

	public String getSreportecxc() {
		return sreportecxc;
	}

	public void setSreportecxc(String sreportecxc) {
		this.sreportecxc = sreportecxc;
	}

	public String getSrfc() {
		return srfc;
	}

	public void setSrfc(String srfc) {
		this.srfc = srfc;
	}

	public String getSdireccion() {
		return sdireccion;
	}

	public void setSdireccion(String sdireccion) {
		this.sdireccion = sdireccion;
	}

	public int getCmarca() {
		return cmarca;
	}

	public void setCmarca(int cmarca) {
		this.cmarca = cmarca;
	}	

}
