package mx.com.web2lab.backend.util.exceptions;

public class ConsultaViajesException extends Exception {

    /**
     * Constructor default
     */
	public ConsultaViajesException(){
		super();
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 */
	public ConsultaViajesException(String aStrMensaje){
		super(aStrMensaje);
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 * @param aObjCausa Ecepcion que genero el error
	 */
	public ConsultaViajesException(String aStrMensaje, Throwable aObjCausa){
		super(aStrMensaje+" /n "+ aObjCausa.getMessage());
	}

	/*
	 * Metodo valido solo para jdk 1.4.1 y posteriores
	 * @param aObjCausa Ecepcion que genero el error
	 *
	public ConsultaViajesException(Throwable aObjCausa){
		super(aObjCausa);
	}*/



}
