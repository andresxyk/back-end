package mx.com.web2lab.backend.util.exceptions;

public class CatalogosException extends Exception {

    /**
     * Constructor default
     */
	public CatalogosException(){
		super();
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 */
	public CatalogosException(String aStrMensaje){
		super(aStrMensaje);
	}

	/**
	 * Constructor
	 * @param aStrMensaje indica alguna pista
	 * @param aObjCausa Ecepcion que genero el error
	 */
	public CatalogosException(String aStrMensaje, Throwable aObjCausa){
		super(aStrMensaje +" \n "+ aObjCausa.getMessage());
	}

	/*
	 * Metodo valido solo para jdk 1.4.1 y posteriores
	 * 
	 * @param aObjCausa Ecepcion que genero el error
	 *
	public CatalogosException(Throwable aObjCausa){
		super(aObjCausa);
	}*/



}
