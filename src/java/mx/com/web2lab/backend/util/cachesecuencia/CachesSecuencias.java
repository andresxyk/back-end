package mx.com.web2lab.backend.util.cachesecuencia;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.com.web2lab.backend.dao.sistema.CatalogosPKGSistemaDao;
import mx.com.web2lab.backend.hbm.om.sistema.SSecuencia;
import mx.com.web2lab.backend.hbm.om.sistema.STipoSecuencia;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * Proveera los caches con los estatus por entidad
 */
public class CachesSecuencias {

    /** log de la aplicacion */
    private static Log iObjLog = LogFactory.getLog(CachesSecuencias.class);

    /** Almacena los caches de las secuencias */
    private static Map iObjCaches = Collections.synchronizedMap(new HashMap(20));

    /** indica si los caches estan inicializados */
    private static boolean iBolSecuenciaInicializadoCache = false;

    /**
     * Constructor
     */
    private CachesSecuencias() {
    }

    /**
     * Inicializa el administrador de caches de estatus
     */
    private static void initCaches(Session aObjSesion) 
    throws Exception {
        iObjLog.info("GenerandoCachesDeSecuencias.....");
        //se crean los caches
        List objSTipoSecuencias = null;
        try {
            //generando caches
        	objSTipoSecuencias = new CatalogosPKGSistemaDao(aObjSesion).getSecuencias();
            Iterator objIterTipoSec = objSTipoSecuencias.iterator();
            //se ejecuta para cada una de las entidades
            while (objIterTipoSec.hasNext()) {
                //se obtiene cada tipo de secuencia
            	STipoSecuencia objTipoSecuencia  = (STipoSecuencia)objIterTipoSec.next();
                Set objEstatus = objTipoSecuencia.getSsecuencias();
                //almacenara el mapa de las secuencias de un tipo de secuencia
                Iterator objIterSec = objEstatus.iterator();
                HashMap objCacheSecuencias = new HashMap();
                while (objIterSec.hasNext()) {
                	SSecuencia objSec = (SSecuencia)objIterSec.next();
                    objCacheSecuencias.put(new Integer(objSec.getCunidad()), objSec.getSsecuencia());
                }
                iObjLog.debug("CacheSecuenciasGeneradoParaEltipoSecuencia: "
                        + objTipoSecuencia.getStiposecuencia() + "::" 
						+ objCacheSecuencias.toString());
                iObjCaches.put(objTipoSecuencia.getStiposecuencia().trim(), objCacheSecuencias);
            }
            iObjLog.info("CachesDeSecuenciasGenerados.....");
            
        } catch (Exception aError) {
            iObjLog.error("ErrorAlIniciarLosCachesDeSecuencias: " + aError.toString());
            throw aError;
        }
    }

    /**
     * regresa la instancia de los caches de estatus
     * 
     * @param aStrNombreCache
     *            del cache de estatus solicitado
     * @return Instancia del cache de estatus solicitado
     */
    public static Map getCacheSecuencias(String aStrNombreCache, Session aObjSesion) 
    throws Exception {
        iObjLog.debug("CacheSolicitado=" + aStrNombreCache);
        if (!iBolSecuenciaInicializadoCache) {
            initCaches(aObjSesion);
            iBolSecuenciaInicializadoCache = true;
        }
        return (Map)iObjCaches.get(aStrNombreCache.trim());
    }

    /**
     * obtiene el cache que contiene los caches de los estatus este sera usado
     * por el front end el cual lo pedira una sola vez por las noches este
     * debera ser refrescado
     * 
     * @return cache de caches de estatus
     */
    public static Map getCacheDeSecuenciasMaestro(Session aObjSesion)
            throws Exception {
        iObjLog.debug("CargandoCacheMaestroParaFrontEnd.......");
        if (!iBolSecuenciaInicializadoCache) {
            initCaches(aObjSesion);
            iBolSecuenciaInicializadoCache = true;
        }
        return iObjCaches;
    }
    
}