package mx.com.web2lab.backend.dao.sms;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.TRecepcionSms;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AdministracionSmsDao {

	private static Log iObjLog = LogFactory.getLog(AdministracionSmsDao.class);
	    
	private Session iObjSesion = null;
	
	public AdministracionSmsDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public void recepcionSms(int uTelefono ,String sMensaje) throws Exception {		
		TRecepcionSms objSMS = new TRecepcionSms();
    	try{
			iObjLog.debug("Entrando AdministracionSmsDao.recepcionSms:Entrando...  " + uTelefono + " " + sMensaje);
			iObjSesion = HibernateUtil.getSession();
			objSMS.setSmensaje(sMensaje + "");
			objSMS.setUtelefono(uTelefono);
			iObjSesion.save(objSMS);
			iObjSesion.flush();
			iObjLog.debug("Entrando AdministracionSmsDao.recepcionSms:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR AdministracionSmsDao.recepcionSms: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objSMS = null;
    		HibernateUtil.closeSession();
    	}		
	}			
}
