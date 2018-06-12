package mx.com.web2lab.backend.dao.cotizaciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursalCotizacion;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalCotizacion;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.cotizaciones.CotizacionBean;
import mx.com.web2lab.backend.beans.tools.ConvertBeanvsHB;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.HibernateException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CotizacionOrdenesDao {

	private static Log iObjLog = LogFactory.getLog(CotizacionOrdenesDao.class);
	    
	private Session iObjSesion = null;
		
	public CotizacionOrdenesDao(){
		iObjSesion = HibernateUtil.getSession();
	}
		
	public CotizacionBean guardarNuevaCotizacion(CotizacionBean objCotizacionBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();		
		TOrdenExamenSucursalCotizacion objExamen = null;
		TOrdenSucursalCotizacion objOrdenSucursal = null;
		List lstExamenesReturn = new ArrayList();
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		OrdenBean objOrdenBean = new OrdenBean();
		try {			
			iObjLog.debug("Entrando CotizacionOrdenesDao.guardarNuevaCotizacion:Entrando...  ");
			objOrdenSucursal = (TOrdenSucursalCotizacion)objCotizacionBean.getObjtordensucursalcotizacion();
            HibernateUtil.beginTrans();
			iObjLog.debug("Entrando CotizacionOrdenesDao.guardarNuevaCotizacion:Entrando...  " + objOrdenSucursal.toString());
            	iObjSesion.save(objOrdenSucursal);
	    		iObjSesion.flush();            	
				for (int i = 0; i < objCotizacionBean.getLstexamenesOrdenexamensucursalcotizacion().size() ; i++)
				{
					objExamen = (TOrdenExamenSucursalCotizacion)objCotizacionBean.getLstexamenesOrdenexamensucursalcotizacion().get(i);						
					objExamen.setTordensucursalcotizacion(objOrdenSucursal);
	            	iObjSesion.save(objExamen);
		    		iObjSesion.flush();            	
		    		lstExamenesReturn.add(objExamen);
				}
				objOrdenBean = objConvertBeans.convertOrdenCotizacionHBBean(objOrdenSucursal,"CotizacionOrdenesDao.guardarNuevaCotizacion",false,false);
				objCotizacionBean.setObjordenbean(objOrdenBean);
				objCotizacionBean.setLstexamenesOrdenexamensucursalcotizacion(lstExamenesReturn);
			iObjLog.debug("Saliendo CotizacionOrdenesDao.guardarNuevaCotizacion:Saliendo...  ");
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate CotizacionOrdenesDao.guardarNuevaCotizacion: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR CotizacionOrdenesDao.guardarNuevaCotizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
    		objOrdenSucursal = null;
    		objConvertBeans = null;
		}		
        return objCotizacionBean;
	}	

	public String actualizarCotizacion(TOrdenSucursalCotizacion objOrdenSucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		String strReturn = "";
		try {			
			iObjLog.debug("Entrando CotizacionOrdenesDao.actualizarCotizacion:Entrando...  ");
            HibernateUtil.beginTrans();
        	iObjSesion.update(objOrdenSucursal);
    		iObjSesion.flush();            	
    		strReturn = "Actualizacion Exitosa";
			iObjLog.debug("Saliendo CotizacionOrdenesDao.actualizarCotizacion:Saliendo...  ");
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate CotizacionOrdenesDao.actualizarCotizacion: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR CotizacionOrdenesDao.actualizarCotizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
        return strReturn;
	}	
		
	public List buscarCotizacionesVSPaciente(int intKPaciente,boolean bolExamenesLaboratorio) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaCotizaciones = new ArrayList();
		List objListaExamenesCotizaciones = null;
		List objListaReturn = new ArrayList();
		CotizacionBean objCotizacionBean = null;
		Query objQuery = null;
		String strQuery = "";
    	try{
    		if (intKPaciente > 0) {
				iObjLog.debug("Entrando CotizacionOrdenesDao.buscarCotizacionesVSPaciente:Entrando...  " + intKPaciente);
				HibernateUtil.beginTrans();
				strQuery = "select bOF " +					
				   		   "from TOrdenSucursalCotizacion bOF " +	
				           "where bOF.tpaciente.kpaciente =  " + intKPaciente + 
				           " order by bOF.dregistro,bOF.kordensucursal ";
				iObjLog.debug("Entrando DatosOrdenDao.buscarpersistemOrdenes:Consulta...  " + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objListaCotizaciones = objQuery.list();
				if (objListaCotizaciones.isEmpty() == false) {
					for (int inti=0;inti<objListaCotizaciones.size();inti++){
						objCotizacionBean = new CotizacionBean(); 
						objListaExamenesCotizaciones = new ArrayList();
						TOrdenSucursalCotizacion objCotizacionHB = (TOrdenSucursalCotizacion)objListaCotizaciones.get(inti);
						Iterator objIteratorExamenCotizar = objCotizacionHB.getTordenexamensucursalcotizacions().iterator();
						while (objIteratorExamenCotizar.hasNext()) {
							TOrdenExamenSucursalCotizacion objCotizacionExamenHB = (TOrdenExamenSucursalCotizacion)objIteratorExamenCotizar.next();
							objListaExamenesCotizaciones.add(objCotizacionExamenHB);
						}
						objCotizacionBean.setLstexamenesOrdenexamensucursalcotizacion(objListaExamenesCotizaciones);
						objCotizacionBean.setObjtordensucursalcotizacion(objCotizacionHB);
						iObjLog.debug("Cotizar CotizacionOrdenesDao.buscarCotizacionesVSPaciente:Entrando...  " + objCotizacionBean.getObjtordensucursalcotizacion().getKordensucursalcotizacion());
						objListaReturn.add(objCotizacionBean);
					}
				}			
    		}
			iObjLog.debug("Saliendo CotizacionOrdenesDao.buscarCotizacionesVSPaciente:Saliendo...Numero de Cotizaciones  " +  objListaReturn.size());
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR CotizacionOrdenesDao.buscarCotizacionesVSPaciente: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objListaCotizaciones.clear();
    		objListaCotizaciones = null;
    		objQuery = null;
    		HibernateUtil.closeSession();
    	}		
		return objListaReturn;
	}	

	
	public CotizacionBean buscarCotizaciones(int kCotizacion) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaCotizaciones = new ArrayList();
		List objListaExamenesCotizaciones = null;
		CotizacionBean objCotizacionBean = null;
		Query objQuery = null;
		String strQuery = "";
    	try{
				iObjLog.debug("Entrando CotizacionOrdenesDao.buscarCotizaciones:Entrando...  " + kCotizacion);
				HibernateUtil.beginTrans();
				strQuery = "select bOF " +					
				   		   "from TOrdenSucursalCotizacion bOF " +	
				           "where bOF.kordensucursalcotizacion =  " + kCotizacion + 
				           " order by bOF.dregistro,bOF.kordensucursal ";
				iObjLog.debug("Entrando CotizacionOrdenesDao.buscarCotizaciones:Consulta...  " + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objListaCotizaciones = objQuery.list();
				if (objListaCotizaciones.isEmpty() == false) {
					for (int inti=0;inti<objListaCotizaciones.size();inti++){
						objCotizacionBean = new CotizacionBean(); 
						objListaExamenesCotizaciones = new ArrayList();
						TOrdenSucursalCotizacion objCotizacionHB = (TOrdenSucursalCotizacion)objListaCotizaciones.get(inti);
						Iterator objIteratorExamenCotizar = objCotizacionHB.getTordenexamensucursalcotizacions().iterator();
						while (objIteratorExamenCotizar.hasNext()) {
							TOrdenExamenSucursalCotizacion objCotizacionExamenHB = (TOrdenExamenSucursalCotizacion)objIteratorExamenCotizar.next();
							objListaExamenesCotizaciones.add(objCotizacionExamenHB);
						}
						objCotizacionBean.setLstexamenesOrdenexamensucursalcotizacion(objListaExamenesCotizaciones);
						objCotizacionBean.setObjtordensucursalcotizacion(objCotizacionHB);
						iObjLog.debug("Cotizar CotizacionOrdenesDao.buscarCotizaciones:Entrando...  " + objCotizacionBean.getObjtordensucursalcotizacion().getKordensucursalcotizacion());
					}
				}			
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR CotizacionOrdenesDao.buscarCotizaciones: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objListaCotizaciones.clear();
    		objListaCotizaciones = null;
    		objQuery = null;
    		HibernateUtil.closeSession();
    	}		
		return objCotizacionBean;
	}	
	
}
