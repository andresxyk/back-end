package mx.com.web2lab.backend.util.exceptions;

public class IngresaResultadosException extends Exception {

    /**
     * Constructor default
     */
	public IngresaResultadosException(){
		super();
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 */
	public IngresaResultadosException(String aStrMensaje){
		super(aStrMensaje);
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 * @param aObjCausa Excepcion que genero el error
	 */
	public IngresaResultadosException(String aStrMensaje, Throwable aObjCausa){
		super(aStrMensaje, aObjCausa);
	}

	/*
	 * Metodo valido solo para jdk 1.4.1 y posteriores
	 * Constructor
	 * @param aObjCausa Excepcion que genero el error
	 *
	public IngresaResultadosException(Throwable aObjCausa){
		super(aObjCausa);
	}*/


}

