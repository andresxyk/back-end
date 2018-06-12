package mx.com.web2lab.backend.util.cacheestatus;

//Java
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.com.web2lab.backend.dao.sistema.CatalogosPKGSistemaDao;
import mx.com.web2lab.backend.hbm.om.catalogos.CMotivo;
import mx.com.web2lab.backend.hbm.om.catalogos.CTipoMotivo;
import mx.com.web2lab.backend.util.exceptions.CachesEstatusCancelacionException;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class CachesEstatusCancelacion {

  /** log de la aplicacion */
  private static Log iObjLog = LogFactory.getLog(CachesEstatusCancelacion.class);

  /** Almacena los caches de los estatus */
  private static Map iObjCaches = Collections
          .synchronizedMap(new HashMap(20));

  /** indica si los caches estan inicializados */
  private static boolean iBolEstaInicializadoCache = false;

  /**
   * Constructor
   */
  private CachesEstatusCancelacion() {
  }

  /**
   * Inicializa el administrador de caches de estatus
   */
  private static void initCaches(Session aObjSesion)
          throws CachesEstatusCancelacionException {
      iObjLog.info("GenerandoCachesDeEstausCancelacion.....");
      //se crean los caches
      List objSMotivos = null;
      try {
          //generando caches
      	objSMotivos = new CatalogosPKGSistemaDao(aObjSesion)
                  .getSMotivosConSEstados();
          Iterator objIterator = objSMotivos.iterator();
          //se ejecuta para cada una de las entidades
          while (objIterator.hasNext()) {
              //se obtiene cada entidad
              CTipoMotivo objCancelacion = (CTipoMotivo) objIterator.next();
              Set objMotivos = objCancelacion.getCmotivos();
              //almacenara el mapa de los estatus de cancelacion de una entidad
              Iterator objItMotivos = objMotivos.iterator();
              HashMap objCacheMotivos = new HashMap();
              while (objItMotivos.hasNext()) {
                  CMotivo objMotivo = (CMotivo) objItMotivos.next();
                  objCacheMotivos.put(objMotivo.getSmotivo(), objMotivo
                          .getCmotivo());
              }
              iObjLog.debug("CacheEstatusCanceladoGeneradoParaLaEntidad:"
                      + objCancelacion.getStipomotivo() + "::"
                      + objCacheMotivos.toString());
              iObjCaches
                      .put(objCancelacion.getStipomotivo().trim(), objCacheMotivos);
          }
          iObjLog.info("CachesDeEstausCancelacionGenerados.....");
      } catch (Exception objExepcion) {
          iObjLog.error("ErrorAlIniciarLosCachesDeEstatusCancelacion:", objExepcion);
          throw new CachesEstatusCancelacionException(objExepcion.getMessage());
      }
  }

  /**
   * regresa la instancia de los caches de estatus de cancelacion
   * 
   * @param aStrNombreCache
   *            del cache de estatus solicitado
   * @return Instancia del cache de estatus de cancelacion solicitado
   */
  public static Map getCacheEstatusCancelacion(String aStrNombreCache, Session aObjSesion)
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
   * por el front end el cual lo pedira una sola vez por las noches este
   * debera ser refrescado
   * 
   * @return cache de caches de estatus
   */
  public static Map getCacheDeEstatusCancelacionMaestro(Session aObjSesion)
          throws Exception {
      iObjLog.debug("CargandoCacheCancelacionMaestroParaFrontEnd.......");
      if (!iBolEstaInicializadoCache) {
          initCaches(aObjSesion);
          iBolEstaInicializadoCache = true;
      }
      return iObjCaches;
  }

}