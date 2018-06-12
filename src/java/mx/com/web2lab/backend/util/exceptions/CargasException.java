
package mx.com.web2lab.backend.util.exceptions;


public class CargasException extends Exception {

	/**
	 * Constructor default.	 
	 */
	public CargasException() {
		super();
	}
	
	/**
	 * Constructor con un parametro.
	 * @param aStrMensaje. Mensaje de la excepcion.
	 */
	public CargasException(String aStrMensaje) {
		super(aStrMensaje);
	}
	
	/**
	 * Constructor con dos parametros.
	 * @param aStrMensaje. Mensaje de la excepcion.
	 * @param aObjCausa. Excepcion que genero el error. 
	 */
	public CargasException(String aStrMensaje, Throwable aObjCausa) {
		super(aStrMensaje + "/n" + aObjCausa.getMessage());
	}
	
}
