package mx.com.web2lab.backend.dao.comer.medicos.puntos;

import java.util.Date;

import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.medico.puntos.CRegalo;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import net.sf.hibernate.JDBCException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MedicosPuntosDao {

	private static Log iObjLog = LogFactory.getLog(MedicosPuntosDao.class);
	    
	private Session iObjSesion = null;
	
	public MedicosPuntosDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public CRegalo altaRegalosMedicos(CRegalo objRegalo) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta MedicosPuntosDao.altaRegalosMedicos:..." + objRegalo.getSregalo());
			objRegalo.setCestadoregistro(0);
			objRegalo.setDregistro(new Date());
     		iObjSesion.save(objRegalo);
    		iObjSesion.flush();            	
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosPuntosDao.altaRegalosMedicos: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
		return objRegalo;
	}
}
