/*
 * Created on Mar 28, 2010
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.web2lab.backend.util.exceptions;

public class ServiceLocatorException extends Exception
{
	/**
     * Constructor default
     */
	public ServiceLocatorException()
	{
		super();
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 */
	public ServiceLocatorException(String aStrMensaje)
	{
		super(aStrMensaje);
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 * @param aObjCausa Excepcion que genero el error
	 */
	public ServiceLocatorException(String aStrMensaje, Throwable aObjCausa)
	{
		super(aStrMensaje + "/n" + aObjCausa.getMessage());
	}
}
