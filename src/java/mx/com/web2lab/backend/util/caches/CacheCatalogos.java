package mx.com.web2lab.backend.util.caches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.util.cacheestatus.CachesEstatus;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *
 * Se encarga de proveer la lista de los catalogos indicados
 * en la clase
 */
public class CacheCatalogos {

    /** log de la aplicacion */
    private static Log iObjLog = LogFactory.getLog(CachesEstatus.class);
    /**Almacena el mapa de los catalogos del cache*/
    private static Map iObjCaches = new HashMap();
    
    
    /**
     * Constructor
     *
     */
    private CacheCatalogos(){
    }
    
    /**
     * Carga al cache el catalogo solicitado
     * @param aObjStrNombreCat nombre del catalogo
     */
    private static void cargaCatalogo(String aObjStrNombreCat) throws Exception {
        Session objSesion = null;
        try{
        	//TODO:QUITAR LA LLMADA A LA SESION 
        	objSesion = HibernateUtil.getSession();
        	//se arma la sentencia a ejecutar
        	String query = "from " + aObjStrNombreCat;
        	Query objQuery = objSesion.createQuery(query);
            List objAux = objQuery.list();
            if(objAux == null || objAux.size() == 0){
                //no se encontraron registros
                throw new Exception("NoSeEncontraronRegistrosParaElCatalogoSolicitado:"+aObjStrNombreCat);
            }
            //se agrega catalogo a cache
            iObjCaches.put(aObjStrNombreCat, objAux);
        }catch (HibernateException aObjException) {
            iObjLog.error("ErrorEn:cargaCatalogo()", aObjException);
            throw aObjException;
        }finally{
            HibernateUtil.closeSession();
        }
    }
    
    /**
     * regresa el catalogo solicitado
     * @param aObjCatalogo
     * @return List catalogo solicitado
     * @deprecated
     */
    public static List getCatalogo(Class aObjCatalogo) throws Exception {
        List objCatSol = (List)iObjCaches.get(aObjCatalogo.getName());
        if(objCatSol == null || objCatSol.size() == 0){
            //se carga el catalogo solicitado
            cargaCatalogo(aObjCatalogo.getName());
        }
        //se obtiene el cache cargado
        return (List)iObjCaches.get(aObjCatalogo.getName());        
    }
    
    /**
     * regresa el catalogo solicitado
     * @param aObjCatalogo
     * @return List catalogo solicitado
     */
    public static List getCatalogo(Class aObjCatalogo, Session aObjSesion) throws Exception {
        List objCatSol = (List)iObjCaches.get(aObjCatalogo.getName());
        if(objCatSol == null || objCatSol.size() == 0){
            //se carga el catalogo solicitado
            cargaCatalogo(aObjCatalogo.getName(),aObjSesion);
        }
        //se obtiene el cache cargado
        return (List)iObjCaches.get(aObjCatalogo.getName());        
    }
    
    /**
     * Carga al cache el catalogo solicitado
     * @param aObjStrNombreCat nombre del catalogo
     */
    private static void cargaCatalogo(String aObjStrNombreCat, Session aObjSesion) throws Exception {
//        Session objSesion = null;
        try{
//        	objSesion = aObjSesion;
        	//se arma la sentencia a ejecutar
        	String query = "from " + aObjStrNombreCat;
        	Query objQuery = aObjSesion.createQuery(query);
            List objAux = objQuery.list();
            if(objAux == null || objAux.size() == 0){
                //no se encontraron registros
                throw new Exception("NoSeEncontraronRegistrosParaElCatalogoSolicitado:"+aObjStrNombreCat);
            }
            //se agrega catalogo a cache
            iObjCaches.put(aObjStrNombreCat, objAux);
        }catch (HibernateException aObjException) {
            iObjLog.error("ErrorEn:cargaCatalogo()", aObjException);
            throw aObjException;
        }
    }
    
    
}
