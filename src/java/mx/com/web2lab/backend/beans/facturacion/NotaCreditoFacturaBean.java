package mx.com.web2lab.backend.beans.facturacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.tools.SucursalBean;
import mx.com.web2lab.backend.util.formatos.Formatos;

public class NotaCreditoFacturaBean implements Serializable {
	
	/** nullable persistent field */
	private Integer kfactura;
	
	/** nullable persistent field */
    private java.lang.String sserie;
    
    /** nullable persistent field */
    private BigDecimal  mtotalfactura;
    
	/** nullable persistent field */
    private BigDecimal  mpagado;
    
	/** nullable persistent field */
    private BigDecimal  msaldo;
    
	/** nullable persistent field */
    private int  cconvenio;
    
    /** nullable persistent field */
    private Date dregistro;
    
	/** nullable persistent field */
    private java.lang.String sbloque;
    

	public Integer getKfactura() {
		return kfactura;
	}

	public void setKfactura(Integer kfactura) {
		this.kfactura = kfactura;
	}

	public java.lang.String getSserie() {
		return sserie;
	}

	public void setSserie(java.lang.String sserie) {
		this.sserie = sserie;
	}

	public BigDecimal getMtotalfactura() {
		return mtotalfactura;
	}

	public void setMtotalfactura(BigDecimal bigDecimal) {
		this.mtotalfactura = bigDecimal;
	}

	public BigDecimal getMpagado() {
		return mpagado;
	}

	public void setMpagado(BigDecimal mpagado) {
		this.mpagado = mpagado;
	}

	public BigDecimal getMsaldo() {
		return msaldo;
	}

	public void setMsaldo(BigDecimal bigDecimal) {
		this.msaldo = bigDecimal;
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

	public java.lang.String getSBloque() {
		return sbloque;
	}

	public void setSBloque(java.lang.String sbloque) {
		this.sbloque = sbloque;
	}
  
	
}
