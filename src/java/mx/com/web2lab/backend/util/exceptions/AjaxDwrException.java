/*
 * Created on Mar 28, 2010
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.web2lab.backend.util.exceptions;

public class AjaxDwrException extends Exception{
	/**
     * Constructor default
     */
	public AjaxDwrException()
	{
		super();
	}

	/**
	 * Constructor
	 * @param sMensaje indica alguna pista
	 */
	public AjaxDwrException(String sMensaje)
	{
		super(sMensaje);
	}

	/**
	 * Constructor
	 * @param oCausa Excepcion que genero el error
	 */
	public AjaxDwrException(Throwable oCausa){
		super(oCausa.getMessage());
	}
	
	/**
	 * Constructor
	 * @param sMensaje indica alguna pista
	 * @param oCausa Excepcion que genero el error
	 */
	public AjaxDwrException(String sMensaje, Throwable oCausa){
		super(sMensaje + "/n" + oCausa.getMessage());
	}
	
	
	/**
	 * Este constructor genera una excepcion 
	 * que tiene un id y una descripcion
	 * separados por un guion.
	 * @param idError
	 * @param sMensaje
	 */
	public AjaxDwrException(int iderror, String smensaje){
		super(iderror + "|" + smensaje);
	}

}
