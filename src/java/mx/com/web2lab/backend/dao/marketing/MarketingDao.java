package mx.com.web2lab.backend.dao.marketing;

import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.CPromocionMarketing;
import mx.com.web2lab.backend.hbm.om.ap.TPacienteMarketing;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MarketingDao {

	private static Log iObjLog = LogFactory.getLog(MarketingDao.class);
	    
	private Session iObjSesion = null;
	
	public MarketingDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public CPromocionMarketing buscarPromocionMarketing(CPromocionMarketing objPromocionMarketingBuscar) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List objListaPromociones = new ArrayList();
			Query objQuery = null;
			String strQuery = "";
			CPromocionMarketing objPromocionMarketing = null;
			iObjLog.debug("Entrando MarketingDao.buscarPromocionMarketing:Entrando...  " + objPromocionMarketingBuscar.getCpromocionenviomarketing().intValue() + " Convenio " + objPromocionMarketingBuscar.getCconvenio().getCconvenio().intValue());
	    	try{
	            HibernateUtil.beginTrans();
	            	if (objPromocionMarketingBuscar.getCpromocionenviomarketing().intValue() > 0) {
						strQuery = "select cPM " +					
								" from CPromocionMarketing cPM " +					
								" where cPM.cpromocionenviomarketing = :cpromocionenviomarketing ";
						objQuery = iObjSesion.createQuery(strQuery);
						objQuery.setParameter("cpromocionenviomarketing",objPromocionMarketingBuscar.getCpromocionenviomarketing());
	            	} else {
						strQuery = "select cPM " +					
								" from CPromocionMarketing cPM " +					
								" where cPM.cconvenio = :cconvenio ";
								objQuery = iObjSesion.createQuery(strQuery);
						objQuery.setParameter("cconvenio",objPromocionMarketingBuscar.getCconvenio().getCconvenio());	            		
	            	}
	            	objPromocionMarketingBuscar = null;
					objListaPromociones = objQuery.list();
				if(objListaPromociones != null) {
					objPromocionMarketing = (CPromocionMarketing)objListaPromociones.get(0);
				} else {
					objPromocionMarketing = null;
				}
			iObjLog.debug("Saliendo MarketingDao.buscarPromocionMarketing:Saliendo...  " + objPromocionMarketing.toString());
			return objPromocionMarketing;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MarketingDao.buscarPromocionMarketing:Error: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		

	public TPacienteMarketing guardarPacienteMarketing(TPacienteMarketing objPacienteMarketing) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			iObjLog.debug("Entrando MarketingDao.guardarPacienteMarketing:Entrando...  " + objPacienteMarketing.getCpromocionmarketing().getCpromocionenviomarketing().intValue());
	    	try{
	            HibernateUtil.beginTrans();
	            iObjSesion.save(objPacienteMarketing);
	    		iObjSesion.flush();            	
			iObjLog.debug("Saliendo MarketingDao.guardarPacienteMarketing:Saliendo...  " + objPacienteMarketing.toString());
			return objPacienteMarketing;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MarketingDao.guardarPacienteMarketing:Error: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		
	
	public TPacienteMarketing actualizarPacienteMarketing(TPacienteMarketing objPacienteMarketing) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			iObjLog.debug("Entrando MarketingDao.actualizarPacienteMarketing:Entrando...  " + objPacienteMarketing.getCpromocionmarketing().getCpromocionenviomarketing().intValue());
	    	try{
	            HibernateUtil.beginTrans();
	            iObjSesion.update(objPacienteMarketing);
	    		iObjSesion.flush();            	
			iObjLog.debug("Saliendo MarketingDao.actualizarPacienteMarketing:Saliendo...  " + objPacienteMarketing.toString());
			return objPacienteMarketing;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MarketingDao.actualizarPacienteMarketing:Error: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		

}