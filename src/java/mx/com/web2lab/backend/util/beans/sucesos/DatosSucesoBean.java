package mx.com.web2lab.backend.util.beans.sucesos;

import java.io.Serializable;

public class DatosSucesoBean implements Serializable {
	
	/** N&uacute;mero de la incidencia*/
	private Long iLngKIncidencia;
	
	/** Fecha de registro*/
	private String iStrDRegistro;	
	
	/** KAdmision para ese suceso*/
	private Long iLngKAdmision;
	
	/** KOrden*/
	private Long iLngKOrden;
	
	/** Nemonico*/
	private String iStrNemonico;
	
	/** llave del tipo de incidencia*/
	private Integer iIntCIncidencia;
	/** Descripci&oacute;n del tipo de incidencia*/
	private String iStrCIncidencia;
	
	/** llave del estado del suceso*/
	private Integer iIntCEstado;
	/** Descripci&oacute;n del estado del suceso*/
	private String iStrCEstado;
	
	/** Semaforo del suceso*/
	private String iStrSemaforo;
	
	/**
	 * @return Returns the iStrSemaforo.
	 */
	public String getIStrSemaforo() {
		return iStrSemaforo;
	}
	/**
	 * @param strSemaforo The iStrSemaforo to set.
	 */
	public void setIStrSemaforo(String strSemaforo) {
		iStrSemaforo = strSemaforo;
	}
	/**
	 * @return Returns the iIntCEstado.
	 */
	public Integer getIIntCEstado() {
		return iIntCEstado;
	}
	/**
	 * @param intCEstado The iIntCEstado to set.
	 */
	public void setIIntCEstado(Integer intCEstado) {
		iIntCEstado = intCEstado;
	}
	/**
	 * @return Returns the iIntCIncidencia.
	 */
	public Integer getIIntCIncidencia() {
		return iIntCIncidencia;
	}
	/**
	 * @param intCIncidencia The iIntCIncidencia to set.
	 */
	public void setIIntCIncidencia(Integer intCIncidencia) {
		iIntCIncidencia = intCIncidencia;
	}
	/**
	 * @return Returns the iLngKAdmision.
	 */
	public Long getILngKAdmision() {
		return iLngKAdmision;
	}
	/**
	 * @param lngKAdmision The iLngKAdmision to set.
	 */
	public void setILngKAdmision(Long lngKAdmision) {
		iLngKAdmision = lngKAdmision;
	}
	/**
	 * @return Returns the iLngKIncidencia.
	 */
	public Long getILngKIncidencia() {
		return iLngKIncidencia;
	}
	/**
	 * @param lngKIncidencia The iLngKIncidencia to set.
	 */
	public void setILngKIncidencia(Long lngKIncidencia) {
		iLngKIncidencia = lngKIncidencia;
	}
	/**
	 * @return Returns the iStrCEstado.
	 */
	public String getIStrCEstado() {
		return iStrCEstado;
	}
	/**
	 * @param strCEstado The iStrCEstado to set.
	 */
	public void setIStrCEstado(String strCEstado) {
		iStrCEstado = strCEstado;
	}
	/**
	 * @return Returns the iStrCIncidencia.
	 */
	public String getIStrCIncidencia() {
		return iStrCIncidencia;
	}
	/**
	 * @param strCIncidencia The iStrCIncidencia to set.
	 */
	public void setIStrCIncidencia(String strCIncidencia) {
		iStrCIncidencia = strCIncidencia;
	}
	/**
	 * @return Returns the iStrDRegistro.
	 */
	public String getIStrDRegistro() {
		return iStrDRegistro;
	}
	/**
	 * @param strDRegistro The iStrDRegistro to set.
	 */
	public void setIStrDRegistro(String strDRegistro) {
		iStrDRegistro = strDRegistro;
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
}