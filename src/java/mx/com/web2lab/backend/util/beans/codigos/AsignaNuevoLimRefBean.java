package mx.com.web2lab.backend.util.beans.codigos;

import java.io.Serializable;
import java.util.List;

public class AsignaNuevoLimRefBean implements Serializable {
	
	/** Codigo de resultado*/
	private String iStrCodResultado;
	/** Lista de Beans que contienen los datos existentes y nuevos de
	 * Limites de referencia*/
	private List iObjListaBeansLimRef;
	
	/** Lista de Beans que contienen los clientes asocidos */
	private List iObjListaBeansClentes;
	
	/** Lista de Beans que contienen los Rangos Normal
	 * critico y valido de los limites de referencia*/
	private List iObjListaBeansRangos;
	
	/** El gener&oacute; para el limite de referencia*/
	private String iStrGenero;
	
	
	/**
	 * Constructor vacio.
	 */
	public AsignaNuevoLimRefBean(){
	}

	/**
	 * @return Returns the iObjListaBeansClentes.
	 */
	public List getIObjListaBeansClentes() {
		return iObjListaBeansClentes;
	}
	/**
	 * @param objListaBeansClentes The iObjListaBeansClentes to set.
	 */
	public void setIObjListaBeansClentes(List objListaBeansClentes) {
		iObjListaBeansClentes = objListaBeansClentes;
	}
	/**
	 * @return Returns the iObjListaBeansLimRef.
	 */
	public List getIObjListaBeansLimRef() {
		return iObjListaBeansLimRef;
	}
	/**
	 * @param objListaBeansLimRef The iObjListaBeansLimRef to set.
	 */
	public void setIObjListaBeansLimRef(List objListaBeansLimRef) {
		iObjListaBeansLimRef = objListaBeansLimRef;
	}
	/**
	 * @return Returns the iObjListaBeansRangos.
	 */
	public List getIObjListaBeansRangos() {
		return iObjListaBeansRangos;
	}
	/**
	 * @param objListaBeansRangos The iObjListaBeansRangos to set.
	 */
	public void setIObjListaBeansRangos(List objListaBeansRangos) {
		iObjListaBeansRangos = objListaBeansRangos;
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
	 * @return Returns the iStrCodResultado.
	 */
	public String getIStrCodResultado() {
		return iStrCodResultado;
	}
	/**
	 * @param strCodResultado The iStrCodResultado to set.
	 */
	public void setIStrCodResultado(String strCodResultado) {
		iStrCodResultado = strCodResultado;
	}
}