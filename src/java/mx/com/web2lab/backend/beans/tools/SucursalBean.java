package mx.com.web2lab.backend.beans.tools;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SucursalBean implements Serializable {

    /** identifier field */
    private java.lang.Integer csucursal;

    /** nullable persistent field */
    private java.lang.String ssucursal;

    /** nullable persistent field */
    private java.lang.String snombresucursal;

    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** persistent field */
    private int ccodigopostal;

    /** persistent field */
    private int cmarca;
        
    /** nullable persistent field */
    private java.lang.String scolonia;
    
    /** nullable persistent field */
    private java.lang.String sciudad;
    
    /** nullable persistent field */
    private java.lang.String smunicipio;
    
    /** nullable persistent field */
    private java.lang.String sestado;
    
    /** nullable persistent field */
    private java.lang.String scodigopostal;
    
    /** nullable persistent field */
    private java.lang.String spais;
    
    private int ufolioactual;
    
    private int naprobacion;
    
    private int nanoprobacion;
    
    private java.lang.String sserie;
    
	public java.lang.Integer getCsucursal() {
		return csucursal;
	}

	public void setCsucursal(java.lang.Integer csucursal) {
		this.csucursal = csucursal;
	}

	public java.lang.String getSsucursal() {
		return ssucursal;
	}

	public void setSsucursal(java.lang.String ssucursal) {
		this.ssucursal = ssucursal;
	}

	public java.lang.String getSnombresucursal() {
		return snombresucursal;
	}

	public void setSnombresucursal(java.lang.String snombresucursal) {
		this.snombresucursal = snombresucursal;
	}

	public java.lang.String getSdireccion() {
		return sdireccion;
	}

	public void setSdireccion(java.lang.String sdireccion) {
		this.sdireccion = sdireccion;
	}

	public int getCcodigopostal() {
		return ccodigopostal;
	}

	public void setCcodigopostal(int ccodigopostal) {
		this.ccodigopostal = ccodigopostal;
	}

	public int getCmarca() {
		return cmarca;
	}

	public void setCmarca(int cmarca) {
		this.cmarca = cmarca;
	}

	public java.lang.String getScolonia() {
		return scolonia;
	}

	public void setScolonia(java.lang.String scolonia) {
		this.scolonia = scolonia;
	}

	public java.lang.String getSciudad() {
		return sciudad;
	}

	public void setSciudad(java.lang.String sciudad) {
		this.sciudad = sciudad;
	}

	public java.lang.String getSmunicipio() {
		return smunicipio;
	}

	public void setSmunicipio(java.lang.String smunicipio) {
		this.smunicipio = smunicipio;
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

	public java.lang.String getSpais() {
		return spais;
	}

	public void setSpais(java.lang.String spais) {
		this.spais = spais;
	}

	public void setUfolioactual(int ufolioactual) {
		this.ufolioactual = ufolioactual;
	}

	public int getUfolioactual() {
		return ufolioactual;
	}

	public void setNaprobacion(int naprobacion) {
		this.naprobacion = naprobacion;
	}

	public int getNaprobacion() {
		return naprobacion;
	}

	public void setNanoprobacion(int nanoprobacion) {
		this.nanoprobacion = nanoprobacion;
	}

	public int getNanoprobacion() {
		return nanoprobacion;
	}

	public void setSserie(java.lang.String sserie) {
		this.sserie = sserie;
	}

	public java.lang.String getSserie() {
		return sserie;
	}
}
