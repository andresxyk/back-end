package mx.com.web2lab.backend.dao.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CEstadoRegistroDao {

	private static Log iObjLog = LogFactory.getLog(CEstadoRegistroDao.class);
	    
	private Session iObjSesion = null;                                  

	public CEstadoRegistroDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public String getSEstadoRegistro(int cEstadoRegistro) throws Exception {
		List objCestadoRegistro = null;
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		CEstadoRegistro objCEstadoRegistro = null;
		String strFolioFactura = "";
		String strReturn=null;
    	try{
			
			HibernateUtil.beginTrans();			
			iObjLog.debug("Entrando CEstadoRegistroDao.getSEstadoRegistro...  " + cEstadoRegistro);
				strQuery = "select cEr 															\n" +					
				   		   "from CEstadoRegistro cEr 													\n" +	
				           "where cEr.cestadoregistro = (" + cEstadoRegistro + ") 	\n" +
				           "order by cestadoregistro";
				iObjLog.debug("Entrando CEstadoRegistroDao.getSEstadoRegistro:Entrando...  " + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objCestadoRegistro = objQuery.list();
				if (objCestadoRegistro != null) {
					if (objCestadoRegistro.size()>0) {
						objCEstadoRegistro = (CEstadoRegistro)objCestadoRegistro.get(0);
						iObjLog.debug("Consulta CEstadoRegistroDao.getSEstadoRegistro:Consulta...  " + objCEstadoRegistro.getSestadoregistro());
						strReturn= objCEstadoRegistro.getSestadoregistro();
					}
				}
			
			iObjLog.debug("Entrando CEstadoRegistroDao.getSEstadoRegistro:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR CEstadoRegistroDao.getSEstadoRegistro: ", aObjExcepcion);
			throw aObjExcepcion;			
    	} finally{
    		objQuery = null;
    		objCestadoRegistro = null;
    		HibernateUtil.closeSession();
    	}		
    	return strReturn;
	}


	
}
