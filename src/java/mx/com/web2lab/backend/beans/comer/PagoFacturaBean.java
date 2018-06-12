package mx.com.web2lab.backend.beans.comer;

import java.io.Serializable;

public class PagoFacturaBean implements Serializable {
    /** identifier field */
    private java.lang.Integer kpagofactura;

    /** nullable persistent field */
    private java.math.BigDecimal mtotalfactura;

    /** nullable persistent field */
    private java.math.BigDecimal manticipo;
    
    /** nullable persistent field */
    private java.math.BigDecimal mpago;

    /** nullable persistent field */
    private java.math.BigDecimal msaldo;

    /** nullable persistent field */
    private java.util.Date dfechapago;

    /** nullable persistent field */
    private int userId;

    /** persistent field */
    private int cestadoregistro;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private int kfactura;
    
    private String sformatofactura = "";

    /** persistent field */
    private int ctipopago;
    
    private String smensaje;
    
    private String sgridpagos;

    private int ugrupopago;
    
	public java.lang.Integer getKpagofactura() {
		return kpagofactura;
	}

	public void setKpagofactura(java.lang.Integer kpagofactura) {
		this.kpagofactura = kpagofactura;
	}

	public java.math.BigDecimal getMtotalfactura() {
		return mtotalfactura;
	}

	public void setMtotalfactura(java.math.BigDecimal mtotalfactura) {
		this.mtotalfactura = mtotalfactura;
	}

	public java.math.BigDecimal getManticipo() {
		return manticipo;
	}

	public void setManticipo(java.math.BigDecimal manticipo) {
		this.manticipo = manticipo;
	}

	public java.math.BigDecimal getMpago() {
		return mpago;
	}

	public void setMpago(java.math.BigDecimal mpago) {
		this.mpago = mpago;
	}

	public java.math.BigDecimal getMsaldo() {
		return msaldo;
	}

	public void setMsaldo(java.math.BigDecimal msaldo) {
		this.msaldo = msaldo;
	}

	public java.util.Date getDfechapago() {
		return dfechapago;
	}

	public void setDfechapago(java.util.Date dfechapago) {
		this.dfechapago = dfechapago;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCestadoregistro() {
		return cestadoregistro;
	}

	public void setCestadoregistro(int cestadoregistro) {
		this.cestadoregistro = cestadoregistro;
	}

	public java.util.Date getDregistro() {
		return dregistro;
	}

	public void setDregistro(java.util.Date dregistro) {
		this.dregistro = dregistro;
	}

	public int getKfactura() {
		return kfactura;
	}

	public void setKfactura(int kfactura) {
		this.kfactura = kfactura;
	}

	public int getCtipopago() {
		return ctipopago;
	}

	public void setCtipopago(int ctipopago) {
		this.ctipopago = ctipopago;
	}


	public String getSgridpagos() {
		return sgridpagos;
	}

	public void setSgridpagos(String sgridpagos) {
		this.sgridpagos = sgridpagos;
	}

	public String getSmensaje() {
		return smensaje;
	}

	public void setSmensaje(String smensaje) {
		this.smensaje = smensaje;
	}

	public String getSformatofactura() {
		return sformatofactura;
	}

	public void setSformatofactura(String sformatofactura) {
		this.sformatofactura = sformatofactura;
	}

	public int getUgrupopago() {
		return ugrupopago;
	}

	public void setUgrupopago(int ugrupopago) {
		this.ugrupopago = ugrupopago;
	}
}
