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
import mx.com.web2lab.backend.hbm.om.sistema.SProceso;
import mx.com.web2lab.backend.hbm.om.sistema.SRolEjecucion;
import mx.com.web2lab.backend.util.exceptions.CachesEstatusException;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * Proveera los caches con los estatus por entidad
 */
public class CachesUsuarios {

    /** log de la aplicacion */
    private static Log iObjLog = LogFactory.getLog(CachesUsuarios.class);

    /** Almacena los caches de los estatus */
    private static Map iObjCaches = Collections.synchronizedMap(new HashMap(20));

    /** indica si los caches estan inicializados */
    private static boolean iBolEstaInicializadoCacheUsr = false;

    /**
     * Constructor
     */
    private CachesUsuarios() {
    }
    /**
     * Inicializa el administrador de caches de estatus
     */
    private static void initCachesRoles(Session aObjSesion)
    throws CachesEstatusException {
        iObjLog.info("GenerandoCachesDeRoles.....");
        //se crean los caches
        List objSProcesos = null;
        try {
            //generando caches
        	objSProcesos = new CatalogosPKGSistemaDao(aObjSesion)
                    .getSProcesosConSRoles();
            Iterator objIterator = objSProcesos.iterator();
            //se ejecuta para cada uno de los procesos
            while (objIterator.hasNext()) {
                //se obtiene cada proceso
                SProceso objProceso = (SProceso) objIterator.next();
                Set objRoles = objProceso.getSrolejecucion();
                //almacenara el mapa de los roles de un proceso
                Iterator objItRoles = objRoles.iterator();
                HashMap objCacheRoles = new HashMap();
                while (objItRoles.hasNext()) {
                	SRolEjecucion objRolejecucion = (SRolEjecucion) objItRoles.next();
                	objCacheRoles.put(objRolejecucion.getSrolejecucion(), objRolejecucion.getCrolejecucion());
                }
                iObjLog.debug("CacheEstatusGeneradoParaElproceso:"
                        + objProceso.getSproceso() + "::"
                        + objCacheRoles.toString());
                iObjCaches.put(objProceso.getSproceso().trim(), objCacheRoles);
            }
            iObjLog.info("CachesDeProcesosGenerados.....");
        } catch (Exception objExepcion) {
            iObjLog.error("ErrorAlIniciarLosCachesDeProcesos:", objExepcion);
            throw new CachesEstatusException(objExepcion.getMessage());
        }
    }
    /**
     * regresa la instancia de los caches de estatus
     * 
     * @param aStrNombreCache
     *            del cache de roles solicitado
     * @return Instancia del cache de estatus solicitado
     */
    public static Map getCacheRoles(String aStrNombreCache, Session aObjSesion)
            throws Exception {
        iObjLog.debug("CacheSolicitado=" + aStrNombreCache);
        if (!iBolEstaInicializadoCacheUsr) {
            initCachesRoles(aObjSesion);
            iBolEstaInicializadoCacheUsr = true;
        }
        return (Map) iObjCaches.get(aStrNombreCache.trim());
    }
}