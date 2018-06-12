package mx.com.web2lab.backend.dao.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.tools.SucursalBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.CControlFolio;
import mx.com.web2lab.backend.hbm.om.ap.CSucursal;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SucursalDao {

	private static Log iObjLog = LogFactory.getLog(SucursalDao.class);
	    
	private Session iObjSesion = null;
	
	public SucursalDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public List getSucursales() throws Exception {
		iObjLog.debug("Entrando SucursalDao.getSucursales");		
		iObjSesion = HibernateUtil.getSession();
		SucursalBean objSucursalBean = null;
		CSucursal objSucursal = null;
		List objSucursales = new ArrayList();
		List objSucursalesReturn = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
            HibernateUtil.beginTrans();
        		strQuery =  "select cS " +					
							" from CSucursal cS order by csucursal";
    			iObjLog.debug("Consulta SucursalDao.getSucursales....." + strQuery);		
				objQuery = iObjSesion.createQuery(strQuery);
				objSucursales = objQuery.list();
				if(objSucursales != null) {
					iObjLog.debug("Consulta SucursalDao.getSucursales...." + objSucursales.size());		
					if (objSucursales.size() > 0) {
						for(int inti=0;inti<objSucursales.size();inti++) {
							objSucursal = (CSucursal)objSucursales.get(inti);
							objSucursalBean = new SucursalBean();
							objSucursalBean.setCsucursal(objSucursal.getCsucursal());
							objSucursalBean.setCcodigopostal(objSucursal.getCcodigopostal().getCcodigopostal().intValue());
							objSucursalBean.setCmarca(objSucursal.getCmarca().getCmarca().intValue());
							objSucursalBean.setSdireccion(objSucursal.getSdireccion());
							objSucursalBean.setSnombresucursal(objSucursal.getSnombresucursal());
							objSucursalBean.setSsucursal(objSucursal.getSsucursal());
							objSucursalesReturn.add(objSucursalBean);
						}
					}
				}
			iObjLog.debug("Saliendo SucursalDao.getSucursales");		
			return objSucursalesReturn;	
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR SucursalDao.getSucursales: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objSucursales.clear();
        	objSucursales = null;
        	objQuery = null;
        	HibernateUtil.closeSession();
		}		
	}		

	public SucursalBean getSucursal(int intSucursal) throws Exception {
		iObjLog.debug("Entrando SucursalDao.getSucursal");		
		iObjSesion = HibernateUtil.getSession();
		SucursalBean objSucursalBean = null;
		CSucursal objSucursal = null;
		List objSucursales = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		objSucursalBean = new SucursalBean();
		try {			
            HibernateUtil.beginTrans();
        		strQuery =  "select cS " +					
							" from CSucursal cS " + 
							" where cS.csucursal = " + intSucursal;
    			iObjLog.debug("Consulta SucursalDao.getSucursal....." + strQuery);		
				objQuery = iObjSesion.createQuery(strQuery);
				objSucursales = objQuery.list();
				if(objSucursales != null) {
					iObjLog.debug("Consulta SucursalDao.getSucursal...." + objSucursales.size());		
					if (objSucursales.size() > 0) {
						for(int inti=0;inti<objSucursales.size();inti++) {
							objSucursal = (CSucursal)objSucursales.get(inti);
							objSucursalBean.setCsucursal(objSucursal.getCsucursal());
							objSucursalBean.setCcodigopostal(objSucursal.getCcodigopostal().getCcodigopostal().intValue());
							objSucursalBean.setCmarca(objSucursal.getCmarca().getCmarca().intValue());
							objSucursalBean.setSdireccion(objSucursal.getSdireccion());
							objSucursalBean.setScolonia(objSucursal.getCcodigopostal().getScolonia());
							objSucursalBean.setSestado(objSucursal.getCcodigopostal().getSestado());
							if (objSucursal.getCcodigopostal().getSciudad().toString() == "") {
								objSucursalBean.setSciudad(objSucursal.getCcodigopostal().getSestado());
							} else {
								objSucursalBean.setSciudad(objSucursal.getCcodigopostal().getSciudad());
							}
							objSucursalBean.setScodigopostal(objSucursal.getCcodigopostal().getCpostal());
							objSucursalBean.setSmunicipio(objSucursal.getCcodigopostal().getSdelegacionmunicipio());
							objSucursalBean.setSpais("MEXICO");							
							objSucursalBean.setSnombresucursal(objSucursal.getSnombresucursal());
							objSucursalBean.setSsucursal(objSucursal.getSsucursal());
						}
					}
				}
			iObjLog.debug("Saliendo SucursalDao.getSucursal " + objSucursalBean.getCsucursal().intValue() + " " + objSucursalBean.getSnombresucursal());		
			return objSucursalBean;	
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR SucursalDao.getSucursales: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objSucursales.clear();
        	objSucursales = null;
        	objQuery = null;
        	HibernateUtil.closeSession();
		}		
	}		

	public SucursalBean getDatosFacturarSucursal(SucursalBean objSucursalBean, int cMarca) throws Exception {
		iObjLog.debug("Entrando SucursalDao.getDatosFacturarSucursal");		
		iObjSesion = HibernateUtil.getSession();
		CControlFolio objCControlFolio = new CControlFolio();
		String strQuery = "";
		List objSucursales = new ArrayList();
		Query objQuery = null;
		try {			
            HibernateUtil.beginTrans();
            	if (objSucursalBean.getCsucursal().intValue() == 1003 && cMarca == 4) {
            		strQuery =  "select cS " +					
    							" from CControlFolio cS " + 
    							" where cS.csucursal = 1012"  +
    							" and cS.cestadoregistro = 31 ";
            	} else {
            		strQuery =  "select cS " +					
    							" from CControlFolio cS " + 
    							" where cS.csucursal = " + objSucursalBean.getCsucursal().intValue() +
    							" and cS.cestadoregistro = 31 ";
            	}
        		iObjLog.debug("Consulta SucursalDao.getDatosFacturarSucursal....." + strQuery);		
        		objQuery = iObjSesion.createQuery(strQuery);
        		objSucursales = objQuery.list();
        		if(objSucursales != null) {
        			iObjLog.debug("Consulta SucursalDao.getDatosFacturarSucursal...." + objSucursales.size());		
        			if (objSucursales.size() > 0) {
						for(int inti=0;inti<objSucursales.size();inti++) {
							objCControlFolio = (CControlFolio)objSucursales.get(inti);
							objSucursalBean.setUfolioactual(objCControlFolio.getUfolioactual().intValue() + 1);
							objSucursalBean.setNaprobacion(objCControlFolio.getNaprobacion().intValue());
							objSucursalBean.setNanoprobacion(objCControlFolio.getNanoprobacion().intValue());
							objSucursalBean.setSserie(objCControlFolio.getSserie());							
							objCControlFolio.setUfolioactual(new Integer(objCControlFolio.getUfolioactual().intValue() + 1));
							iObjSesion.update(objCControlFolio);
							iObjSesion.flush();
						}      				
        			}
        		}
			iObjLog.debug("Saliendo SucursalDao.getDatosFacturarSucursal");		
			return objSucursalBean;	
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR SucursalDao.getDatosFacturarSucursal: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objSucursales.clear();
        	objSucursales = null;
        	objQuery = null;
        	HibernateUtil.closeSession();
		}		
	}			
}
