package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TPagoFactura implements Serializable {

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
    private int ugrupopago;
    
    /** identifier field */
    private java.lang.Integer knotacredito;
    
    /** identifier field */
    private java.lang.Integer kpagocomplemento;
   

	/** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura ctipopago;

    /** full constructor */
    public TPagoFactura(java.lang.Integer kpagofactura, java.math.BigDecimal mtotalfactura, java.math.BigDecimal mpago, java.math.BigDecimal manticipo, java.math.BigDecimal msaldo, java.util.Date dfechapago, int userId, int cestadoregistro, java.util.Date dregistro,int ugrupopago, mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura, mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura ctipopago) {
    	this.kpagofactura = kpagofactura;
    	this.mtotalfactura = mtotalfactura;
        this.manticipo = manticipo;
        this.mpago = mpago;
        this.msaldo = msaldo;
        this.dfechapago = dfechapago;
        this.userId = userId;
        this.cestadoregistro = cestadoregistro;
        this.dregistro = dregistro;
        this.ugrupopago = ugrupopago;
        this.tfactura = tfactura;
        this.ctipopago = ctipopago;
    }

    /** default constructor */
    public TPagoFactura() {
    }

    /** minimal constructor */
    public TPagoFactura(java.lang.Integer kpagofactura, int cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura, mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura ctipopago) {
        this.kpagofactura = kpagofactura;
        this.cestadoregistro = cestadoregistro;
        this.tfactura = tfactura;
        this.ctipopago = ctipopago;
    }

    public java.lang.Integer getKpagofactura() {
        return this.kpagofactura;
    }

    public void setKpagofactura(java.lang.Integer kpagofactura) {
        this.kpagofactura = kpagofactura;
    }

    public java.math.BigDecimal getMtotalfactura() {
        return this.mtotalfactura;
    }

    public void setMtotalfactura(java.math.BigDecimal mtotalfactura) {
        this.mtotalfactura = mtotalfactura;
    }
        
    public java.math.BigDecimal getMpago() {
        return this.mpago;
    }

    public void setMpago(java.math.BigDecimal mpago) {
        this.mpago = mpago;
    }

    public java.math.BigDecimal getManticipo() {
        return this.manticipo;
    }

    public void setManticipo(java.math.BigDecimal manticipo) {
        this.manticipo = manticipo;
    }

    public java.math.BigDecimal getMsaldo() {
        return this.msaldo;
    }

    public void setMsaldo(java.math.BigDecimal msaldo) {
        this.msaldo = msaldo;
    }

    public java.util.Date getDfechapago() {
        return this.dfechapago;
    }

    public void setDfechapago(java.util.Date dfechapago) {
        this.dfechapago = dfechapago;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(int cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getUgrupopago() {
        return this.ugrupopago;
    }

    public void setUgrupopago(int ugrupopago) {
        this.ugrupopago = ugrupopago;
    }
    
    public mx.com.web2lab.backend.hbm.om.ap.TFactura getTfactura() {
        return this.tfactura;
    }

    public void setTfactura(mx.com.web2lab.backend.hbm.om.ap.TFactura tfactura) {
        this.tfactura = tfactura;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura getCtipopago() {
        return this.ctipopago;
    }

    public void setCtipopago(mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura ctipopago) {
        this.ctipopago = ctipopago;
    }

    public java.lang.Integer getKnotacredito() {
        return knotacredito;
    }

  public void setKnotacredito(java.lang.Integer knotacredito) {
        this.knotacredito = knotacredito;
    }
  
  
  public java.lang.Integer getKpagocomplemento() {
		return kpagocomplemento;
	}

	public void setKpagocomplemento(java.lang.Integer kpagocomplemento) {
		this.kpagocomplemento = kpagocomplemento;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("kpagofactura", getKpagofactura())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TPagoFactura) ) return false;
        TPagoFactura castOther = (TPagoFactura) other;
        return new EqualsBuilder()
            .append(this.getKpagofactura(), castOther.getKpagofactura())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKpagofactura())
            .toHashCode();
    }

}
