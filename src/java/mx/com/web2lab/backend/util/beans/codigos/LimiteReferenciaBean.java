package mx.com.web2lab.backend.util.beans.codigos;

import java.io.Serializable;
import java.util.List;


/**
 * Bean para actualizar e insertar nuevos limites de referencia
 */
public class LimiteReferenciaBean implements Serializable {
	
	/** Nombre del l&iacute;mite*/
	private String iStrNomLimite;
	/** Unidad de medida*/
	private String iStrUnidadLim;
	/** contiene el genero*/
	private String iStrGenero;
	/** Default*/ 
	private String iStrDefault;
	/** control de los datos que se actualizan*/
    private boolean iBolActualiza;
    /** Id de los Limites del Codigo */
	private int iIntIdLimite;
	/** Contiene la lista de beans con los rangos de ese limite*/ 
	private List iObjListaRangos;
	/** Contiene la clave de unidad de Medida */ 
	private Integer iIntMedida;
	
	
	/**
     * Constructor
     *
     */
    public LimiteReferenciaBean(){
        
    }
	
	/**
	 * @return Returns the iStrDefault.
	 */
	public String getIStrDefault() {
		return iStrDefault;
	}
	/**
	 * @param strDefault The iStrDefault to set.
	 */
	public void setIStrDefault(String strDefault) {
		iStrDefault = strDefault;
	}
	/**
	 * @return Returns the iStrNomLimite.
	 */
	public String getIStrNomLimite() {
		return iStrNomLimite;
	}
	/**
	 * @param strNomLimite The iStrNomLimite to set.
	 */
	public void setIStrNomLimite(String strNomLimite) {
		iStrNomLimite = strNomLimite;
	}
	/**
	 * @return Returns the iStrUnidadLim.
	 */
	public String getIStrUnidadLim() {
		return iStrUnidadLim;
	}
	/**
	 * @param strUnidadLim The iStrUnidadLim to set.
	 */
	public void setIStrUnidadLim(String strUnidadLim) {
		iStrUnidadLim = strUnidadLim;
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
	public int getIIntIdLimite() {
		return iIntIdLimite;
	}
	/**
	 * @param intIdLimite The iIntIdLimite to set.
	 */
	public void setIIntIdLimite(int intIdLimite) {
		iIntIdLimite = intIdLimite;
	}
	/**
	 * @return Returns the iObjListaRangos.
	 */
	public List getIObjListaRangos() {
		return iObjListaRangos;
	}
	/**
	 * @param objListaRangos The iObjListaRangos to set.
	 */
	public void setIObjListaRangos(List objListaRangos) {
		iObjListaRangos = objListaRangos;
	}
	/**
	 * @return Returns the iStrGenero.
	 */
	public String getIStrGenero() {
		return iStrGenero;
	}
	/**
	 * @param strGenero The iStrGenero to set.
	 */
	public void setIStrGenero(String strGenero) {
		iStrGenero = strGenero;
	}
	/**
	 * @return Returns the iIntMedida.
	 */
	public Integer getIIntMedida() {
		return iIntMedida;
	}
	/**
	 * @param intMedida The iIntMedida to set.
	 */
	public void setIIntMedida(Integer intMedida) {
		iIntMedida = intMedida;
	}
}