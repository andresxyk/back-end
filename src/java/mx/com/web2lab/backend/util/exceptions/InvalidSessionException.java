/*
 * Created on Mar 28, 2010
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.web2lab.backend.util.exceptions;

public class InvalidSessionException extends Exception
{
	/**
     * Constructor default
     */
	public InvalidSessionException()
	{
		super();
	}

	/**
	 * Constructor
	 * @param sMensaje indica alguna pista
	 */
	public InvalidSessionException(String sMensaje)
	{
		super(sMensaje);
	}

	/**
	 * Constructor
	 * @param sMensaje indica alguna pista
	 * @param oCausa Excepcion que genero el error
	 */
	public InvalidSessionException(String sMensaje, Throwable oCausa)
	{
		super(sMensaje + "/n" + oCausa.getMessage());
	}
}
