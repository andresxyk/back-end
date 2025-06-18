package mx.com.web2lab.backend.util.beans.codigos;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Clase Bean, creada para enviar la informaci&oacute;n al frontend encapsulada
 * en un solo objeto, el cual sera utilizado en el caso de uso 
 * Consulta Limites del Codigo.
 */
public class RangosNorCriValBean implements Serializable {
	
	/** el inicio del rango de edad*/
	private String  iStrEdadRangoIni;
	
	/** el fin del rango de edad*/
	private String  iStrEdadRangoFin;
    
    /** Limite Normal Bajo */
    private BigDecimal iObjNormalBajo;
    
    /** Limite Normal Alto */
    private BigDecimal iObjNormalAlto;
    
    /** Limite Critico Bajo */
    private BigDecimal iObjCriticoBajo;
    
    /** Limite Critico Alto */
    private BigDecimal iObjCriticoAlto;
    
    /** Limite Valido Bajo */
    private BigDecimal iObjValidoBajo;
    
    /** Limite Valido Alto */
    private BigDecimal iObjValidoAlto;
    
    /** Id de los Limites del Codigo */
    private int iIntIdLimiteLab;
    
    /** Id de los rangos del limite */
    private int iIntIdRango;
    	
    /** genero para los rangos*/
    private String iStrSGenero;

    
	

	/**
	 * @return Returns the iObjCriticoAlto.
	 */
	public BigDecimal getIObjCriticoAlto() {
		return iObjCriticoAlto;
	}
	/**
	 * @param objCriticoAlto The iObjCriticoAlto to set.
	 */
	public void setIObjCriticoAlto(BigDecimal objCriticoAlto) {
		iObjCriticoAlto = objCriticoAlto;
	}
	/**
	 * @return Returns the iObjCriticoBajo.
	 */
	public BigDecimal getIObjCriticoBajo() {
		return iObjCriticoBajo;
	}
	/**
	 * @param objCriticoBajo The iObjCriticoBajo to set.
	 */
	public void setIObjCriticoBajo(BigDecimal objCriticoBajo) {
		iObjCriticoBajo = objCriticoBajo;
	}
	/**
	 * @return Returns the iObjNormalAlto.
	 */
	public BigDecimal getIObjNormalAlto() {
		return iObjNormalAlto;
	}
	/**
	 * @param objNormalAlto The iObjNormalAlto to set.
	 */
	public void setIObjNormalAlto(BigDecimal objNormalAlto) {
		iObjNormalAlto = objNormalAlto;
	}
	/**
	 * @return Returns the iObjNormalBajo.
	 */
	public BigDecimal getIObjNormalBajo() {
		return iObjNormalBajo;
	}
	/**
	 * @param objNormalBajo The iObjNormalBajo to set.
	 */
	public void setIObjNormalBajo(BigDecimal objNormalBajo) {
		iObjNormalBajo = objNormalBajo;
	}
	/**
	 * @return Returns the iObjValidoAlto.
	 */
	public BigDecimal getIObjValidoAlto() {
		return iObjValidoAlto;
	}
	/**
	 * @param objValidoAlto The iObjValidoAlto to set.
	 */
	public void setIObjValidoAlto(BigDecimal objValidoAlto) {
		iObjValidoAlto = objValidoAlto;
	}
	/**
	 * @return Returns the iObjValidoBajo.
	 */
	public BigDecimal getIObjValidoBajo() {
		return iObjValidoBajo;
	}
	/**
	 * @param objValidoBajo The iObjValidoBajo to set.
	 */
	public void setIObjValidoBajo(BigDecimal objValidoBajo) {
		iObjValidoBajo = objValidoBajo;
	}
	/**
	 * @return Returns the iStrEdadRangoFin.
	 */
	public String getIStrEdadRangoFin() {
		return iStrEdadRangoFin;
	}
	/**
	 * @param strEdadRangoFin The iStrEdadRangoFin to set.
	 */
	public void setIStrEdadRangoFin(String strEdadRangoFin) {
		iStrEdadRangoFin = strEdadRangoFin;
	}
	/**
	 * @return Returns the iStrEdadRangoIni.
	 */
	public String getIStrEdadRangoIni() {
		return iStrEdadRangoIni;
	}
	/**
	 * @param strEdadRangoIni The iStrEdadRangoIni to set.
	 */
	public void setIStrEdadRangoIni(String strEdadRangoIni) {
		iStrEdadRangoIni = strEdadRangoIni;
	}
	/** control de los datos que se actualizan*/
    private boolean iBolActualiza;
   
	/**
	 * Constructor vacio.
	 */
	public RangosNorCriValBean(){
	}

	/**
	 * @return Returns the iBolActualiza.
	 */
	public boolean isIBolActualiza() {
		return iBolActualiza;
	}
	/**
	 * @param bolActualiza The iBolActualiza to set.
	 */
	public void setIBolActualiza(boolean bolActualiza) {
		iBolActualiza = bolActualiza;
	}
	/**
	 * @return Returns the iIntIdLimite.
	 */
	public int getIIntIdLimiteLab() {
		return iIntIdLimiteLab;
	}
	/**
	 * @param intIdLimite The iIntIdLimite to set.
	 */
	public void setIIntIdLimiteLab(int intIdLimiteLab) {
		iIntIdLimiteLab = intIdLimiteLab;
	}
	/**
	 * @return Returns the iIntIdRango.
	 */
	public int getIIntIdRango() {
		return iIntIdRango;
	}
	/**
	 * @param intIdLimite The iIntIdLimite to set.
	 */
	public void setIIntIdRango(int intIdRango) {
		iIntIdRango = intIdRango;
	}
	/**
	 * @return Returns the iStrSGenero.
	 */
	public String getIStrSGenero() {
		return iStrSGenero;
	}
	/**
	 * @param strSGenero The iStrSGenero to set.
	 */
	public void setIStrSGenero(String strSGenero) {
		iStrSGenero = strSGenero;
	}
}