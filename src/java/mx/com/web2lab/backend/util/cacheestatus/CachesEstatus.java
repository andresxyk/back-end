package mx.com.web2lab.backend.util.cacheestatus;

//Java
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.com.web2lab.backend.dao.sistema.CatalogosPKGSistemaDao;
import mx.com.web2lab.backend.hbm.om.sistema.SEntidad;
import mx.com.web2lab.backend.hbm.om.sistema.SEstado;
import mx.com.web2lab.backend.util.exceptions.CachesEstatusException;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * Proveera los caches con los estatus por entidad
 */
public class CachesEstatus {

    /** log de la aplicacion */
    private static Log iObjLog = LogFactory.getLog(CachesEstatus.class);

    /** Almacena los caches de los estatus */
    private static Map iObjCaches = Collections.synchronizedMap(new HashMap(20));

    /** indica si los caches estan inicializados */
    private static boolean iBolEstaInicializadoCache = false;

    /**
     * Constructor
     */
    private CachesEstatus() {
    }

    /**
     * Inicializa el administrador de caches de estatus
     */
    private static void initCaches(Session aObjSesion)
            throws CachesEstatusException {
        iObjLog.info("GenerandoCachesDeEstaus.....");
        //se crean los caches
        List objSEntidades = null;
        try {
            //generando caches
            objSEntidades = new CatalogosPKGSistemaDao(aObjSesion)
                    .getSEntidadesConSEstados();
            Iterator objIterator = objSEntidades.iterator();
            //se ejecuta para cada una de las entidades
            while (objIterator.hasNext()) {
                //se obtiene cada entidad
                SEntidad objEntidad = (SEntidad) objIterator.next();
                Set objEstatus = objEntidad.getSestados();
                //almacenara el mapa de los estatus de una entidad
                Iterator objItEstatus = objEstatus.iterator();
                HashMap objCacheEstados = new HashMap();
                while (objItEstatus.hasNext()) {
                    SEstado objEstado = (SEstado) objItEstatus.next();
                    objCacheEstados.put(objEstado.getSestado(), objEstado.getCestado());
                }
                iObjLog.debug("CacheEstatusGeneradoParaLaEntidad:"
                        + objEntidad.getSentidad() + "::"
                        + objCacheEstados.toString());
                iObjCaches.put(objEntidad.getSentidad().trim(), objCacheEstados);
            }
            iObjLog.info("CachesDeEstausGenerados.....");
        } catch (Exception objExepcion) {
            iObjLog.error("ErrorAlIniciarLosCachesDeEstatus:", objExepcion);
            throw new CachesEstatusException(objExepcion.getMessage());
        }
    }

    /**
     * regresa la instancia de los caches de estatus
     * 
     * @param aStrNombreCache
     *            del cache de estatus solicitado
     * @return Instancia del cache de estatus solicitado
     */
    public static Map getCacheEstatus(String aStrNombreCache, Session aObjSesion)
            throws Exception {
        iObjLog.debug("CacheSolicitado=" + aStrNombreCache);
        if (!iBolEstaInicializadoCache) {
            initCaches(aObjSesion);
            iBolEstaInicializadoCache = true;
        }
        return (Map) iObjCaches.get(aStrNombreCache.trim());
    }

    /**
     * obtiene el cache que contiene los caches de los estatus este sera usado
     * por el front end el cual lo pedira una sola vez por las nochez este
     * debera ser refrescado
     * 
     * @return cache de caches de estatus
     */
    public static Map getCacheDeEstatusMaestro(Session aObjSesion)
            throws Exception {
        iObjLog.debug("CargandoCacheMaestroParaFrontEnd.......");
        if (!iBolEstaInicializadoCache) {
            initCaches(aObjSesion);
            iBolEstaInicializadoCache = true;
        }
        return iObjCaches;
    }
}