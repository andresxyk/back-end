package mx.com.web2lab.backend.dao.facturacion.empresas.viaje;

import java.util.Date;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.AIncidenciaFacturacion;
import mx.com.web2lab.backend.hbm.om.ap.CIncidenciaFacturacion;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IncidenciasFacturacionDao {

	private static Log iObjLog = LogFactory.getLog(IncidenciasFacturacionDao.class);
	    
	private Session iObjSesion = null;
	
	public IncidenciasFacturacionDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public AIncidenciaFacturacion guardarIncidencia(int cIncidencia,int kValor,int User_id,String strTabla, String strCampo,String strObservaciones) throws Exception {
		iObjSesion = HibernateUtil.getSession();		
		AIncidenciaFacturacion objIncidenciaT = new AIncidenciaFacturacion();
		CIncidenciaFacturacion objIncidencia = new CIncidenciaFacturacion();
		try {			
			iObjLog.debug("Entrando IncidenciasFacturacionDao.guardarIncidencia:Entrando...  ");
            HibernateUtil.beginTrans();
	            objIncidencia.setCincidenciafacturacion(cIncidencia);
            objIncidenciaT.setCincidenciafacturacion(objIncidencia);
            objIncidenciaT.setDregistro(new Date());
            objIncidenciaT.setKllaveincidencia(kValor);
            objIncidenciaT.setStabla(strTabla);
            objIncidenciaT.setScampo(strCampo);
            objIncidenciaT.setSobservacion(strObservaciones);
            objIncidenciaT.setUserid(User_id);
        	iObjSesion.save(objIncidenciaT);
    		iObjSesion.flush();            	
			iObjLog.debug("Saliendo IncidenciasFacturacionDao.guardarIncidencia:Saliendo...  ");
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate IncidenciasFacturacionDao.guardarIncidencia: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR IncidenciasFacturacionDao.guardarIncidencia: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
        return objIncidenciaT;
	}		
}
