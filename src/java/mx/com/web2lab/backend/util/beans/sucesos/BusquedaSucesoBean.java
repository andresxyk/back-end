package mx.com.web2lab.backend.util.beans.sucesos;

import java.io.Serializable;

public class BusquedaSucesoBean implements Serializable {
	
	private Integer iIntCLabDep;
	private Integer iIntCUnidad;
	/** KAdmision de la orden*/
	private Long iLngAdmision;
	/** KOrden*/
	private Long iLngKOrden;
	/** Nemonico de la orden*/
	private String iStrNemonico;
	/** llave de Kmuestra*/
	private Long iLngKMuestra;
	/** Fecha inicial del rango*/
	private String iStrDeFecha;
	/** Fecha final del rango*/
	private String iStrAFecha;
	/** Nombre del paciente*/
	private String iStrNomPaciente;
	/** Apellido paterno del paciente*/
	private String iStrApPatPac;
	/** Apellido materno paciente*/
	private String iStrApMatPac;
	/** Nombre o id del cliete*/
	private String iStrCliente;
	/** Id del examen*/
	private String iStrExamen;
	/** id del analito*/
	private String iStrAnalito;
	/** llave del estado del incidente*/
	private Integer iIntEstado;
	/** llave de la severidad del incidente*/
	private Integer iIntSeveridad;
	/** indica si el incidente o suceso es debido a una orden 
	 * o es una incidencia en general*/
	private String iStrClaseIncidente; 
	/** Codigo de resultado*/
	private String iStrCcodigo;
	
	

	/**
	 * @return Returns the iIntCLabDep.
	 */
	public Integer getIIntCLabDep() {
		return iIntCLabDep;
	}
	/**
	 * @param intCLabDep The iIntCLabDep to set.
	 */
	public void setIIntCLabDep(Integer intCLabDep) {
		iIntCLabDep = intCLabDep;
	}
	/**
	 * @return Returns the iIntCUnidad.
	 */
	public Integer getIIntCUnidad() {
		return iIntCUnidad;
	}
	/**
	 * @param intCUnidad The iIntCUnidad to set.
	 */
	public void setIIntCUnidad(Integer intCUnidad) {
		iIntCUnidad = intCUnidad;
	}
	/**
	 * @return Returns the iIntEstado.
	 */
	public Integer getIIntEstado() {
		return iIntEstado;
	}
	/**
	 * @param intEstado The iIntEstado to set.
	 */
	public void setIIntEstado(Integer intEstado) {
		iIntEstado = intEstado;
	}
	/**
	 * @return Returns the iIntSeveridad.
	 */
	public Integer getIIntSeveridad() {
		return iIntSeveridad;
	}
	/**
	 * @param intSeveridad The iIntSeveridad to set.
	 */
	public void setIIntSeveridad(Integer intSeveridad) {
		iIntSeveridad = intSeveridad;
	}
	/**
	 * @return Returns the iLngAdmision.
	 */
	public Long getILngAdmision() {
		return iLngAdmision;
	}
	/**
	 * @param lngAdmision The iLngAdmision to set.
	 */
	public void setILngAdmision(Long lngAdmision) {
		iLngAdmision = lngAdmision;
	}
	/**
	 * @return Returns the iStrAFecha.
	 */
	public String getIStrAFecha() {
		return iStrAFecha;
	}
	/**
	 * @param strAFecha The iStrAFecha to set.
	 */
	public void setIStrAFecha(String strAFecha) {
		iStrAFecha = strAFecha;
	}
	/**
	 * @return Returns the iStrAnalito.
	 */
	public String getIStrAnalito() {
		return iStrAnalito;
	}
	/**
	 * @param strAnalito The iStrAnalito to set.
	 */
	public void setIStrAnalito(String strAnalito) {
		iStrAnalito = strAnalito;
	}
	/**
	 * @return Returns the iStrClaseIncidente.
	 */
	public String getIStrClaseIncidente() {
		return iStrClaseIncidente;
	}
	/**
	 * @param strClaseIncidente The iStrClaseIncidente to set.
	 */
	public void setIStrClaseIncidente(String strClaseIncidente) {
		iStrClaseIncidente = strClaseIncidente;
	}
	/**
	 * @return Returns the iStrCliente.
	 */
	public String getIStrCliente() {
		return iStrCliente;
	}
	/**
	 * @param strCliente The iStrCliente to set.
	 */
	public void setIStrCliente(String strCliente) {
		iStrCliente = strCliente;
	}
	/**
	 * @return Returns the iStrDeFecha.
	 */
	public String getIStrDeFecha() {
		return iStrDeFecha;
	}
	/**
	 * @param strDeFecha The iStrDeFecha to set.
	 */
	public void setIStrDeFecha(String strDeFecha) {
		iStrDeFecha = strDeFecha;
	}
	/**
	 * @return Returns the iStrExamen.
	 */
	public String getIStrExamen() {
		return iStrExamen;
	}
	/**
	 * @param strExamen The iStrExamen to set.
	 */
	public void setIStrExamen(String strExamen) {
		iStrExamen = strExamen;
	}
	/**
	 * @return Returns the iStrApMatPac.
	 */
	public String getIStrApMatPac() {
		return iStrApMatPac;
	}
	/**
	 * @param strApMatPac The iStrApMatPac to set.
	 */
	public void setIStrApMatPac(String strApMatPac) {
		iStrApMatPac = strApMatPac;
	}
	/**
	 * @return Returns the iStrApPatPac.
	 */
	public String getIStrApPatPac() {
		return iStrApPatPac;
	}
	/**
	 * @param strApPatPac The iStrApPatPac to set.
	 */
	public void setIStrApPatPac(String strApPatPac) {
		iStrApPatPac = strApPatPac;
	}
	/**
	 * @return Returns the iStrNomPaciente.
	 */
	public String getIStrNomPaciente() {
		return iStrNomPaciente;
	}
	/**
	 * @param strNomPaciente The iStrNomPaciente to set.
	 */
	public void setIStrNomPaciente(String strNomPaciente) {
		iStrNomPaciente = strNomPaciente;
	}
	/**
	 * @return Returns the iLngKMuestra.
	 */
	public Long getILngKMuestra() {
		return iLngKMuestra;
	}
	/**
	 * @param lngKMuestra The iLngKMuestra to set.
	 */
	public void setILngKMuestra(Long lngKMuestra) {
		iLngKMuestra = lngKMuestra;
	}
	/**
	 * @return Returns the iLngKOrden.
	 */
	public Long getILngKOrden() {
		return iLngKOrden;
	}
	/**
	 * @param lngKOrden The iLngKOrden to set.
	 */
	public void setILngKOrden(Long lngKOrden) {
		iLngKOrden = lngKOrden;
	}
	/**
	 * @return Returns the iStrNemonico.
	 */
	public String getIStrNemonico() {
		return iStrNemonico;
	}
	/**
	 * @param strNemonico The iStrNemonico to set.
	 */
	public void setIStrNemonico(String strNemonico) {
		iStrNemonico = strNemonico;
	}
	public String getIStrCcodigo() {
		return iStrCcodigo;
	}
	public void setIStrCcodigo(String strCcodigo) {
		iStrCcodigo = strCcodigo;
	}
}