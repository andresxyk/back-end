package mx.com.web2lab.backend.util.exceptions;


public class CachesEscalasException extends Exception {

    /**
     * Constructor
     */
    public CachesEscalasException() {
        super();
    }

    /**
     * Constructor
     * @param aStrMensaje
     */
    public CachesEscalasException(String aStrMensaje) {
        super(aStrMensaje);
    }

    /*
     * Metodo solo valido para la version de JDK 1.4 y posteriores 
    /**
     * Constructor
     * @param aObjCausa
     *
    public CachesEstatusException(Throwable aObjCausa) {
        super(aObjCausa);
    }*/

    /**
     * Constructor
     * @param aStrMensaje
     * @param aObjCausa
     */
    public CachesEscalasException(String aStrMensaje, Throwable aObjCausa) {
        super(aStrMensaje+" \n "+ aObjCausa);
    }

}
