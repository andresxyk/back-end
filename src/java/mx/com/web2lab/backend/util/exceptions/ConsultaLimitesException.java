package mx.com.web2lab.backend.util.exceptions;

public class ConsultaLimitesException extends Exception {

    /**
     * Constructor default
     */
	public ConsultaLimitesException(){
		super();
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 */
	public ConsultaLimitesException(String aStrMensaje){
		super(aStrMensaje);
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 * @param aObjCausa Ecepcion que genero el error
	 */
	public ConsultaLimitesException(String aStrMensaje, Throwable aObjCausa){
		super(aStrMensaje+" \n "+aObjCausa.getMessage());
	}

	/*
	 * Metodo valido solo para jdk 1.4.1 y posteriores
	 * 
	 * Constructor
	 * @param aObjCausa Ecepcion que genero el error
	 *
	public ConsultaLimitesException(Throwable aObjCausa){
		super(aObjCausa);
	}*/


}
