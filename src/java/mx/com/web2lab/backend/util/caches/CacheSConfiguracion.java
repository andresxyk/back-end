package mx.com.web2lab.backend.util.caches;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.sistema.SConfiguracion;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * Clase encargada de subir en Cache los registros de configuracion
 * del sistema, su utilizacion es la siguiente.
 * Si se desea recuperar un registro de configuracion definido como
 * <code>
 * SConfiguracion objConf = 
 * 	CacheSConfiguracion.getSConfiguracion("LABGABINETE");
 * </code>
 * Y desde el objeto objConf se puede acceder a cualquiera  
 * de los atributos, por ejemplo: 
 * <code>
 * iObjLog.debug("Id el registro de la configuracion: "
 * 		+ objConf.getCconfiguracion());
 *  iObjLog.debug("Valor que define el registro buscado de la configuracion: "
 * 		+ objConf.getSconfiguracion());
 *  iObjLog.debug("Valor de la configuracion: " + objConf.getUconfiguracion());
 * </code>
 */
public class CacheSConfiguracion {

    /** log de la aplicacion */
    private static Log iObjLog = LogFactory.getLog(CacheSConfiguracion.class);
    /** Mapa con los registros de SConfiguracion*/
    private static Map objConfigs = new HashMap();
    
    /** Constructor default */
    private CacheSConfiguracion(){
    }
    
    /**
     * Metodo para recuperar los diferentes registros 
     * de configuracion del sistema y los guarda en un 
     * HashMap
     * @return
     * @throws Exception
     */
    private static Map getMapConfigs() throws Exception{
    	iObjLog.debug("CacheSConfiguracion:getMapConfigs:Entrando");
    	Iterator objItera = null;
    	SConfiguracion objConfig = null;
        Session objSesion = null;
    	try{
        	if(objConfigs==null || objConfigs.isEmpty()){ 
        		objSesion = HibernateUtil.getSession();
        		String strQuery = "from SConfiguracion";
        		iObjLog.debug("CacheSConfiguracion:getMapConfigs:Query"+strQuery);
        		HibernateUtil.beginTrans();
        		objItera = objSesion.createQuery(strQuery).iterate();
        		if(objItera!=null){
        			while(objItera.hasNext()){
        				objConfig = (SConfiguracion)objItera.next();
        				objConfigs.put(objConfig.getSconfiguracion(),objConfig);
        				iObjLog.debug("CacheSConfiguracion:getMapConfigs:SConfig:"+
        						objConfig.getSconfiguracion()+"|"+
								objConfig.getCconfiguracion()+"|"+
								objConfig.getUconfiguracion());
        			}
        		}
        		HibernateUtil.commitTrans();
        	}
    	}
    	catch(Exception aError){
    		HibernateUtil.rollbackTrans();
	 		iObjLog.error("getMapConfigs:ERROR",aError);
	 		throw aError;
    	}finally{
            HibernateUtil.closeSession();
        }
    	iObjLog.debug("CacheSConfiguracion:getMapConfigs:Regresando:"+objConfigs);
    	return objConfigs;
    }
    
    /**
     * Metodo que recupera un objeto de tipo SConfiguracion 
     * dado el string que lo define 
     * @param configKey
     * @return
     * @throws Exception
     * @deprecated
     */
    public static SConfiguracion getSConfiguracion(String configKey) throws Exception{
    	SConfiguracion objConfig = null;
    	iObjLog.debug("CacheSConfiguracion:getMapConfigs:BuscandoConf:"+configKey);
    	try{
    		if(objConfigs==null || objConfigs.isEmpty())objConfigs = getMapConfigs();
    		objConfig = (SConfiguracion)objConfigs.get(configKey);
    	}
    	catch(Exception aError){
	 		iObjLog.error("CacheSConfiguracion:getSConfiguracion:Error:",aError);
	 		throw aError;
    	}
    	iObjLog.debug("CacheSConfiguracion:getMapConfigs:Regresando:"+objConfig);
    	return objConfig;
    }
    
    /**
     * Metodo para recuperar los diferentes registros 
     * de configuracion del sistema y los guarda en un 
     * HashMap
     * @return
     * @throws Exception
     */
    private static Map getMapConfigs(Session aObjSesion) throws Exception{
    	iObjLog.debug("CacheSConfiguracion:getMapConfigs:Entrando");
    	Iterator objItera = null;
    	SConfiguracion objConfig = null;
    	try{
        	if(objConfigs==null || objConfigs.isEmpty()){
        		String strQuery = "from SConfiguracion";
        		iObjLog.debug("CacheSConfiguracion:getMapConfigs:Query"+strQuery);
        		objItera = aObjSesion.createQuery(strQuery).iterate();
        		if(objItera!=null){
        			while(objItera.hasNext()){
        				objConfig = (SConfiguracion)objItera.next();
        				objConfigs.put(objConfig.getSconfiguracion(),objConfig);
        				iObjLog.debug("CacheSConfiguracion:getMapConfigs:SConfig:"+
        						objConfig.getSconfiguracion()+"|"+
								objConfig.getCconfiguracion()+"|"+
								objConfig.getUconfiguracion());
        			}
        		}
        	}
    	}
    	catch(Exception aError){
	 		iObjLog.error("CacheSConfiguracion:getMapConfigs:Error:"+aError.toString());
	 		throw aError;
    	}
    	iObjLog.debug("CacheSConfiguracion:getMapConfigs:Regresando:"+objConfigs);
    	return objConfigs;
    }
    
    /**
     * Metodo que recupera un objeto de tipo SConfiguracion 
     * dado el string que lo define 
     * @param configKey
     * @return
     * @throws Exception
     */
    public static SConfiguracion getSConfiguracion(String configKey, Session aObjSesion) throws Exception{
    	SConfiguracion objConfig = null;
    	iObjLog.debug("CacheSConfiguracion:getMapConfigs:BuscandoConf:"+configKey);
    	try{
    		if(objConfigs==null || objConfigs.isEmpty())objConfigs = getMapConfigs(aObjSesion);
    		objConfig = (SConfiguracion)objConfigs.get(configKey);
    	}
    	catch(Exception aError){
	 		iObjLog.error("CacheSConfiguracion:getSConfiguracion:Error:",aError);
	 		throw aError;
    	}
    	iObjLog.debug("CacheSConfiguracion:getMapConfigs:Regresando:"+objConfig);
    	return objConfig;
    }
    
}
