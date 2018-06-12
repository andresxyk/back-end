package mx.com.web2lab.backend.beans.facturacion;

import mx.com.web2lab.backend.util.Formatos;

public class BuscarOrdenesViajeBean {
	private int kviaje = 0;
	private int kadmision = 0;	
	private int ufoliofacturaempresas = 0;
	private int cconvenio = 0;
	private int csucursal = 0;
	private int intcestadoregistro = 0;
	private int intbloque = 0;
	private String strorderby = "";;
	private String sordeneshtml = "";;
	private String strfechainicial = "";;
	private String strfechafinal = "";;
	private int cestadoregistroconsulta = 0;
	
	public int getCestadoregistroconsulta() {
		return cestadoregistroconsulta;
	}
	public void setCestadoregistroconsulta(int cestadoregistroconsulta) {
		this.cestadoregistroconsulta = cestadoregistroconsulta;
	}
	private Formatos formatos = new Formatos();                                    

	public String getSordeneshtml() {
		return sordeneshtml;
	}
	public void setSordeneshtml(String sordeneshtml) {
		this.sordeneshtml = sordeneshtml;
	}
	public int getKviaje() {
		return kviaje;
	}
	public void setKviaje(int kviaje) {
		this.kviaje = kviaje;
	}
	public int getKadmision() {
		return kadmision;
	}
	public void setKadmision(int kadmision) {
		this.kadmision = kadmision;
	}
	public int getUfoliofacturaempresas() {
		return ufoliofacturaempresas;
	}
	public void setUfoliofacturaempresas(int ufoliofacturaempresas) {
		this.ufoliofacturaempresas = ufoliofacturaempresas;
	}
	public int getCconvenio() {
		return cconvenio;
	}
	public void setCconvenio(int cconvenio) {
		this.cconvenio = cconvenio;
	}
	public int getCsucursal() {
		return csucursal;
	}
	public void setCsucursal(int csucursal) {
		this.csucursal = csucursal;
	}
	public int getIntcestadoregistro() {
		return intcestadoregistro;
	}
	public void setIntcestadoregistro(int intcestadoregistro) {
		this.intcestadoregistro = intcestadoregistro;
	}
	public int getIntbloque() {
		return intbloque;
	}
	public void setIntbloque(int intbloque) {
		this.intbloque = intbloque;
	}
	public String getStrorderby() {
		return strorderby;
	}
	public void setStrorderby(String strorderby) {
		this.strorderby = strorderby;
	}
	public String getStrfechainicial() {
		return strfechainicial;
	}
	public void setStrfechainicial(String strfechainicial) throws Exception {
		this.strfechainicial = formatos.getFechaBD(strfechainicial,"i"); ;
	}
	public String getStrfechafinal() {
		return strfechafinal;
	}
	public void setStrfechafinal(String strfechafinal) throws Exception {
		this.strfechafinal = formatos.getFechaBD(strfechafinal,"f");
	}	
}
