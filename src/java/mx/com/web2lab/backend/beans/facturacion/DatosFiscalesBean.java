package mx.com.web2lab.backend.beans.facturacion;

public class DatosFiscalesBean {

	private int kDatosFiscales = 0;
	
	private String strRFC;
	
	private String strRazonSocial;
	
	private String strDireccion;
	
	private int cCodigoPostal;
	
	private int cConvenio;

	private String sPais;
	
	private String cPostal;
	
	private String strEstado;
	
	private String strCiudad;
	
	private String strDelegacionMunicipio;

	private String strColonia;
	
	private String sdigitoscuenta;
	
	private String stipopago;
	
	private boolean blike = true;

	private int unuevodatofiscal = 0;
	
	public int getkDatosFiscales() {
		return kDatosFiscales;
	}

	public void setkDatosFiscales(int kDatosFiscales) {
		this.kDatosFiscales = kDatosFiscales;
	}

	public String getStrRFC() {
		return strRFC;
	}

	public void setStrRFC(String strRFC) {
		if (strRFC != null) {
			this.strRFC = strRFC.trim().toUpperCase();
		} else {
			this.strRFC = strRFC;
		}
	}

	public String getStrRazonSocial() {
		return strRazonSocial;
	}

	public void setStrRazonSocial(String strRazonSocial) {
		if (strRazonSocial != null) {
			this.strRazonSocial = strRazonSocial.trim().toUpperCase();
		} else {
			this.strRazonSocial = strRazonSocial;
		}
	}

	public String getStrDireccion() {
		return strDireccion;
	}

	public void setStrDireccion(String strDireccion) {
		if (strDireccion != null) {
			this.strDireccion = strDireccion.trim().toUpperCase();
		} else {
			this.strDireccion = strDireccion;
		}
	}

	public int getcCodigoPostal() {
		return cCodigoPostal;
	}

	public void setcCodigoPostal(int cCodigoPostal) {
		this.cCodigoPostal = cCodigoPostal;
	}

	public String getsPais() {
		return sPais;
	}

	public void setsPais(String sPais) {
		if (sPais != null) {
			this.sPais = sPais.trim().toUpperCase();
		} else {
			this.sPais = sPais;
		}
	}

	public String getcPostal() {
		return cPostal;
	}

	public void setcPostal(String cPostal) {
		this.cPostal = cPostal;
	}

	public String getStrEstado() {
		return strEstado;
	}

	public void setStrEstado(String strEstado) {
		if (strEstado != null) {
			this.strEstado = strEstado.trim().toUpperCase();
		} else {
			this.strEstado = strEstado;
		}
	}

	public String getStrCiudad() {
		return strCiudad;
	}

	public void setStrCiudad(String strCiudad) {
		if (strCiudad != null) {
			this.strCiudad = strCiudad.trim().toUpperCase();
		} else {
			this.strCiudad = strCiudad;
		}
	}

	public String getStrDelegacionMunicipio() {
		return strDelegacionMunicipio;
	}

	public void setStrDelegacionMunicipio(String strDelegacionMunicipio) {
		if (strDelegacionMunicipio != null) {
			this.strDelegacionMunicipio = strDelegacionMunicipio.trim().toUpperCase();
		} else {
			this.strDelegacionMunicipio = strDelegacionMunicipio;
		}
	}

	public String getStrColonia() {
		return strColonia;
	}

	public void setStrColonia(String strColonia) {
		if (strColonia != null) {
			this.strColonia = strColonia.trim().toUpperCase();
		} else {
			this.strColonia = strColonia;
		}
	}

	public void setcConvenio(int cConvenio) {
		this.cConvenio = cConvenio;
	}

	public int getcConvenio() {
		return cConvenio;
	}

	public String getSdigitoscuenta() {
		return sdigitoscuenta;
	}

	public void setSdigitoscuenta(String sdigitoscuenta) {
		this.sdigitoscuenta = sdigitoscuenta;
	}

	public String getStipopago() {
		return stipopago;
	}

	public void setStipopago(String stipopago) {
		this.stipopago = stipopago;
	}

	public boolean isBlike() {
		return blike;
	}

	public void setBlike(boolean blike) {
		this.blike = blike;
	}

	public int getUnuevodatofiscal() {
		return unuevodatofiscal;
	}

	public void setUnuevodatofiscal(int unuevodatofiscal) {
		this.unuevodatofiscal = unuevodatofiscal;
	}
}
