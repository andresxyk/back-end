package mx.com.web2lab.backend.util.beans.sucesos;

import java.io.Serializable;

public class AccionSeguimientoBean implements Serializable {
	/** contiene el Nombre del usuario que captura*/
	private String iStrUsuario;
	/** contiene el id del usuario que captura*/
	private Integer iIntUsuario;
	/** Seguimiento del suceso*/
	private String iStrAccionSeguimiento;
	/** llave de la incidencia*/
	private Integer iIntKIncidencia;
	
	/**
	 * @return Returns the iStrAccionSeguimiento.
	 */
	public String getIStrAccionSeguimiento() {
		return iStrAccionSeguimiento;
	}
	/**
	 * @param strAccionSeguimiento The iStrAccionSeguimiento to set.
	 */
	public void setIStrAccionSeguimiento(String strAccionSeguimiento) {
		iStrAccionSeguimiento = strAccionSeguimiento;
	}
	/**
	 * @return Returns the iStrUsuario.
	 */
	public String getIStrUsuario() {
		return iStrUsuario;
	}
	/**
	 * @param strUsuario The iStrUsuario to set.
	 */
	public void setIStrUsuario(String strUsuario) {
		iStrUsuario = strUsuario;
	}
	/**
	 * @return Returns the iIntKIncidencia.
	 */
	public Integer getIIntKIncidencia() {
		return iIntKIncidencia;
	}
	/**
	 * @param intKIncidencia The iIntKIncidencia to set.
	 */
	public void setIIntKIncidencia(Integer intKIncidencia) {
		iIntKIncidencia = intKIncidencia;
	}
	/**
	 * @return Returns the iIntUsuario.
	 */
	public Integer getIIntUsuario() {
		return iIntUsuario;
	}
	/**
	 * @param intUsuario The iIntUsuario to set.
	 */
	public void setIIntUsuario(Integer intUsuario) {
		iIntUsuario = intUsuario;
	}
}