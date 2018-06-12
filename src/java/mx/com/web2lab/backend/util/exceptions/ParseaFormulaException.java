/*
 * Created on Jan 18, 2010
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.web2lab.backend.util.exceptions;

public class ParseaFormulaException extends Exception {
	
	/**
	 * Constructor default.	 
	 */
	public ParseaFormulaException() {
		super();
	}
	
	/**
	 * Constructor con un parametro.
	 * @param aStrMensaje. Mensaje de la excepcion.
	 */
	public ParseaFormulaException(String aStrMensaje) {
		super(aStrMensaje);
	}
	
	/**
	 * Constructor con dos parametros.
	 * @param aStrMensaje. Mensaje de la excepcion.
	 * @param aObjCausa. Excepcion que genero el error. 
	 */
	public ParseaFormulaException(String aStrMensaje, Throwable aObjCausa) {
		super(aStrMensaje + "/n" + aObjCausa.getMessage());
	}

}
