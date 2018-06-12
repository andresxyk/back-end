package mx.com.web2lab.backend.util.beans.sucesos;

import java.io.Serializable;

public class SucesoBean implements Serializable {
	
	/** Número de la incidencia*/
	private Long iLngKIncidencia;
	
	/** llave del tipo de incidencia*/
	private Integer iIntCIncidencia;
	/** Descripción del tipo de incidencia*/
	private String iStrCIncidencia;
	
	/** Descripcion del origen del suceso*/
	private String iStrOrigen;
	
	/** llave del estado del suceso*/
	private Integer iIntCEstado;
	/** Descripción del estado del suceso*/
	private String iStrCEstado;

	/** Id de la severidad del suceso*/
	private Integer iIntSeveridad;
	/** Semaforo del suceso*/
	private String iStrSemaforo;
	
	/** id y nombre de cliente*/
	private String iStrCliente;
	
	/** Motivo del suceso*/
	private String iStrMotivo;
	
	/** Especifica si el suceso se generó de una muestra un a orden o generico*/
	private String iStrOriginadoPor;
	
	/** Observacion del suceso*/
	private String iStrObservacion;	
	
	/** Solucion para este suceso suceso*/
	private String iStrSolucion;
	
	
	
	
	
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
	 * @return Returns the iStrMotivo.
	 */
	public String getIStrMotivo() {
		return iStrMotivo;
	}
	/**
	 * @param strMotivo The iStrMotivo to set.
	 */
	public void setIStrMotivo(String strMotivo) {
		iStrMotivo = strMotivo;
	}
	/**
	 * @return Returns the iStrObservacion.
	 */
	public String getIStrObservacion() {
		return iStrObservacion;
	}
	/**
	 * @param strObservacion The iStrObservacion to set.
	 */
	public void setIStrObservacion(String strObservacion) {
		iStrObservacion = strObservacion;
	}
	/**
	 * @return Returns the iStrOrigen.
	 */
	public String getIStrOrigen() {
		return iStrOrigen;
	}
	/**
	 * @param strOrigen The iStrOrigen to set.
	 */
	public void setIStrOrigen(String strOrigen) {
		iStrOrigen = strOrigen;
	}
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
	 * @return Returns the iStrSolucion.
	 */
	public String getIStrSolucion() {
		return iStrSolucion;
	}
	/**
	 * @param strSolucion The iStrSolucion to set.
	 */
	public void setIStrSolucion(String strSolucion) {
		iStrSolucion = strSolucion;
	}
	/**
	 * @return Returns the iStrOriginadoPor.
	 */
	public String getIStrOriginadoPor() {
		return iStrOriginadoPor;
	}
	/**
	 * @param strOriginadoPor The iStrOriginadoPor to set.
	 */
	public void setIStrOriginadoPor(String strOriginadoPor) {
		iStrOriginadoPor = strOriginadoPor;
	}
}