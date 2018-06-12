package mx.com.web2lab.backend.dao.puebla;

import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.ap.PacienteBean;
import mx.com.web2lab.backend.beans.puebla.CuestionarioPantallaBean;
import mx.com.web2lab.backend.dao.ap.DatosOrdenDao;
import mx.com.web2lab.backend.dao.ap.PacientesDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.puebla.TCuestionarioPacientePuebla;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import net.sf.hibernate.JDBCException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PueblaDao {

	private static Log iObjLog = LogFactory.getLog(PueblaDao.class);
	    
	private Session iObjSesion = null;
	
	public PueblaDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public CuestionarioPantallaBean persistirCuestionario(CuestionarioPantallaBean objCuestionarioPantallaBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		TCuestionarioPacientePuebla objTCuestionarioPacientePuebla = new TCuestionarioPacientePuebla();
		List objListaPacientes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta PueblaDao.persistirCuestionario:..." + objCuestionarioPantallaBean.getkPaciente());
        	if (objCuestionarioPantallaBean.getkPaciente() > 0) {			
        		strQuery =  "select bPF " +					
							" from TCuestionarioPacientePuebla bPF " +					
							" where bPF.kpaciente = :kpaciente";
    			iObjLog.debug("Consulta PueblaDao.persistirCuestionario:..." + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objQuery.setParameter("kpaciente", new Integer(objCuestionarioPantallaBean.getkPaciente()));
				objListaPacientes = objQuery.list();
				if(objListaPacientes != null) {
					if (objListaPacientes.size() > 0) {
						objTCuestionarioPacientePuebla = (TCuestionarioPacientePuebla)objListaPacientes.get(0);
					}
				}			
        	}
			objTCuestionarioPacientePuebla.setBolanticonceptivo(objCuestionarioPantallaBean.isBolanticonceptivo());
			objTCuestionarioPacientePuebla.setBolatenidocancer(objCuestionarioPantallaBean.isBolatenidocancer());
			objTCuestionarioPacientePuebla.setBolcirugia(objCuestionarioPantallaBean.isBolcirugia());
			objTCuestionarioPacientePuebla.setBolembarazada(objCuestionarioPantallaBean.isBolembarazada());
			objTCuestionarioPacientePuebla.setBolfuma(objCuestionarioPantallaBean.isBolfuma());
			objTCuestionarioPacientePuebla.setBollesion(objCuestionarioPantallaBean.isBollesion());
			objTCuestionarioPacientePuebla.setBolmastografiaanterior(objCuestionarioPantallaBean.isBolmastografiaanterior());
			objTCuestionarioPacientePuebla.setBolsenamama(objCuestionarioPantallaBean.isBolsenamama());
//			objTCuestionarioPacientePuebla.setKcuestionariopacientepuebla(kcuestionariopacientepuebla);
			objTCuestionarioPacientePuebla.setKpaciente(objCuestionarioPantallaBean.getkPaciente());
			objTCuestionarioPacientePuebla.setSabuelas(objCuestionarioPantallaBean.getSabuelas() + " ");
			objTCuestionarioPacientePuebla.setScancercuando(objCuestionarioPantallaBean.getScancercuando() + " ");
			objTCuestionarioPacientePuebla.setScirugiacuando(objCuestionarioPantallaBean.getScirugiacuando() + " ");
			objTCuestionarioPacientePuebla.setScirugiadonde(objCuestionarioPantallaBean.getScirugiadonde() + " ");
			objTCuestionarioPacientePuebla.setScirugiatipo(objCuestionarioPantallaBean.getScirugiatipo() + " ");
			objTCuestionarioPacientePuebla.setScualesanticonceptivo(objCuestionarioPantallaBean.getScualesanticonceptivo() + " ");
			objTCuestionarioPacientePuebla.setSedadabuelas(objCuestionarioPantallaBean.getSedadabuelas() + " ");
			objTCuestionarioPacientePuebla.setSedadmadre(objCuestionarioPantallaBean.getSedadmadre() + " ");
			objTCuestionarioPacientePuebla.setSedadtias(objCuestionarioPantallaBean.getSedadtias() + " ");
			objTCuestionarioPacientePuebla.setSembarazada(objCuestionarioPantallaBean.getSembarazada() + " ");
			objTCuestionarioPacientePuebla.setSfumadesde(objCuestionarioPantallaBean.getSfumadesde() + " ");
			objTCuestionarioPacientePuebla.setSlesionubicacion(objCuestionarioPantallaBean.getSlesionubicacion() + " ");
			objTCuestionarioPacientePuebla.setSmadre(objCuestionarioPantallaBean.getSmadre() + " ");
			objTCuestionarioPacientePuebla.setSmastografiacuando(objCuestionarioPantallaBean.getSmastografiacuando() + " ");
			objTCuestionarioPacientePuebla.setSmotivoestudio(objCuestionarioPantallaBean.getSmotivoestudio() + " ");
			objTCuestionarioPacientePuebla.setSpadecimiento(objCuestionarioPantallaBean.getSpadecimiento() + " ");
			objTCuestionarioPacientePuebla.setSsenadonde(objCuestionarioPantallaBean.getSsenadonde() + " ");
			objTCuestionarioPacientePuebla.setSsenatipo(objCuestionarioPantallaBean.getSsenatipo() + " ");
			objTCuestionarioPacientePuebla.setStias(objCuestionarioPantallaBean.getStias() + " ");
			objTCuestionarioPacientePuebla.setStiempoanticonceptivo(objCuestionarioPantallaBean.getStiempoanticonceptivo() + " ");
			objTCuestionarioPacientePuebla.setSultimamestruacion(objCuestionarioPantallaBean.getSultimamestruacion() + " ");
			objTCuestionarioPacientePuebla.setUabortos(objCuestionarioPantallaBean.getUabortos());
			objTCuestionarioPacientePuebla.setUedadprimeramestruacion(objCuestionarioPantallaBean.getUedadprimeramestruacion());
			objTCuestionarioPacientePuebla.setUhijos(objCuestionarioPantallaBean.getUhijos());
			if (objTCuestionarioPacientePuebla.getKcuestionariopacientepuebla() != null) {
	     		iObjSesion.update(objTCuestionarioPacientePuebla);
			} else {
	     		iObjSesion.save(objTCuestionarioPacientePuebla);
			}
			objCuestionarioPantallaBean.setKcuestionariopacientepuebla(objTCuestionarioPacientePuebla.getKcuestionariopacientepuebla().intValue());
			objCuestionarioPantallaBean.setSmensajeoperacion("Exito en el guardado de la base de datos");
    		iObjSesion.flush();            	
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PueblaDao.persistirCuestionario: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objListaPacientes.clear();
        	objListaPacientes = null;
        	objQuery = null;
        	objTCuestionarioPacientePuebla = null;
        	HibernateUtil.closeSession();
		}		
		return objCuestionarioPantallaBean;
	}

	public CuestionarioPantallaBean buscarCuestionario(CuestionarioPantallaBean objCuestionarioPantallaBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		TCuestionarioPacientePuebla objTCuestionarioPacientePuebla = null;
		List objListaPacientes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta PueblaDao.buscarCuestionario:..." + objCuestionarioPantallaBean.getkPaciente());
        	if (objCuestionarioPantallaBean.getkPaciente() > 0) {			
        		strQuery =  "select bPF " +					
							" from TCuestionarioPacientePuebla bPF " +					
							" where bPF.kpaciente = :kpaciente";
    			iObjLog.debug("Consulta PueblaDao.buscarCuestionario:..." + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objQuery.setParameter("kpaciente", new Integer(objCuestionarioPantallaBean.getkPaciente()));
				objListaPacientes = objQuery.list();
				if(objListaPacientes != null) {
					if (objListaPacientes.size() > 0) {
						objTCuestionarioPacientePuebla = (TCuestionarioPacientePuebla)objListaPacientes.get(0);
					}
				}			
        	}
        	if (objTCuestionarioPacientePuebla != null) {
				objCuestionarioPantallaBean.setBolanticonceptivo(objTCuestionarioPacientePuebla.isBolanticonceptivo());
				objCuestionarioPantallaBean.setBolatenidocancer(objTCuestionarioPacientePuebla.isBolatenidocancer());
				objCuestionarioPantallaBean.setBolcirugia(objTCuestionarioPacientePuebla.isBolcirugia());
				objCuestionarioPantallaBean.setBolembarazada(objTCuestionarioPacientePuebla.isBolembarazada());
				objCuestionarioPantallaBean.setBolfuma(objTCuestionarioPacientePuebla.isBolfuma());
				objCuestionarioPantallaBean.setBollesion(objTCuestionarioPacientePuebla.isBollesion());
				objCuestionarioPantallaBean.setBolmastografiaanterior(objTCuestionarioPacientePuebla.isBolmastografiaanterior());
				objCuestionarioPantallaBean.setBolsenamama(objTCuestionarioPacientePuebla.isBolsenamama());
				objCuestionarioPantallaBean.setKcuestionariopacientepuebla(objTCuestionarioPacientePuebla.getKcuestionariopacientepuebla().intValue());
				objCuestionarioPantallaBean.setkPaciente(objTCuestionarioPacientePuebla.getKpaciente());
				objCuestionarioPantallaBean.setSabuelas(objTCuestionarioPacientePuebla.getSabuelas() + " ");
				objCuestionarioPantallaBean.setScancercuando(objTCuestionarioPacientePuebla.getScancercuando() + " ");
				objCuestionarioPantallaBean.setScirugiacuando(objTCuestionarioPacientePuebla.getScirugiacuando() + " ");
				objCuestionarioPantallaBean.setScirugiadonde(objTCuestionarioPacientePuebla.getScirugiadonde() + " ");
				objCuestionarioPantallaBean.setScirugiatipo(objTCuestionarioPacientePuebla.getScirugiatipo() + " ");
				objCuestionarioPantallaBean.setScualesanticonceptivo(objTCuestionarioPacientePuebla.getScualesanticonceptivo() + " ");
				objCuestionarioPantallaBean.setSedadabuelas(objTCuestionarioPacientePuebla.getSedadabuelas() + " ");
				objCuestionarioPantallaBean.setSedadmadre(objTCuestionarioPacientePuebla.getSedadmadre() + " ");
				objCuestionarioPantallaBean.setSedadtias(objTCuestionarioPacientePuebla.getSedadtias() + " ");
				objCuestionarioPantallaBean.setSembarazada(objTCuestionarioPacientePuebla.getSembarazada() + " ");
				objCuestionarioPantallaBean.setSfumadesde(objTCuestionarioPacientePuebla.getSfumadesde() + " ");
				objCuestionarioPantallaBean.setSlesionubicacion(objTCuestionarioPacientePuebla.getSlesionubicacion() + " ");
				objCuestionarioPantallaBean.setSmadre(objTCuestionarioPacientePuebla.getSmadre() + " ");
				objCuestionarioPantallaBean.setSmastografiacuando(objTCuestionarioPacientePuebla.getSmastografiacuando() + " ");
				objCuestionarioPantallaBean.setSmotivoestudio(objTCuestionarioPacientePuebla.getSmotivoestudio() + " ");
				objCuestionarioPantallaBean.setSpadecimiento(objTCuestionarioPacientePuebla.getSpadecimiento() + " ");
				objCuestionarioPantallaBean.setSsenadonde(objTCuestionarioPacientePuebla.getSsenadonde() + " ");
				objCuestionarioPantallaBean.setSsenatipo(objTCuestionarioPacientePuebla.getSsenatipo() + " ");
				objCuestionarioPantallaBean.setStias(objTCuestionarioPacientePuebla.getStias() + " ");
				objCuestionarioPantallaBean.setStiempoanticonceptivo(objTCuestionarioPacientePuebla.getStiempoanticonceptivo() + " ");
				objCuestionarioPantallaBean.setSultimamestruacion(objTCuestionarioPacientePuebla.getSultimamestruacion() + " ");
				objCuestionarioPantallaBean.setUabortos(objTCuestionarioPacientePuebla.getUabortos());
				objCuestionarioPantallaBean.setUedadprimeramestruacion(objTCuestionarioPacientePuebla.getUedadprimeramestruacion());
				objCuestionarioPantallaBean.setUhijos(objTCuestionarioPacientePuebla.getUhijos());			
        	}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosPuntosDao.altaRegalosMedicos: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objListaPacientes.clear();
        	objListaPacientes = null;
        	objQuery = null;
        	objTCuestionarioPacientePuebla = null;
        	HibernateUtil.closeSession();
		}		
		return objCuestionarioPantallaBean;
	}

	public CuestionarioPantallaBean imprimirCuestionario(CuestionarioPantallaBean objCuestionarioPantallaBean) throws Exception {
		PacientesDao objPacientesDao = new PacientesDao();
		PacienteBean objPacienteBean = new PacienteBean();
		DatosOrdenDao objDatosOrdenDao = new DatosOrdenDao();
		OrdenBean objOrdenBean = new OrdenBean();		
		objPacienteBean.setKpacientefundacion(new Integer(objCuestionarioPantallaBean.getkPaciente()));
		objPacienteBean = objPacientesDao.buscarPaciente(objPacienteBean);				
		List lstOrdenes =  objDatosOrdenDao.buscarOrdenesVSPaciente(objCuestionarioPantallaBean.getkPaciente(),(new Integer("1068")).intValue(), false);
		for(int inti=0;inti<lstOrdenes.size();inti++) {
			if (((OrdenBean)lstOrdenes.get(inti)).getCestado() != 17) {
				objOrdenBean = (OrdenBean)lstOrdenes.get(inti);
			}
		}		
		objCuestionarioPantallaBean = this.buscarCuestionario(objCuestionarioPantallaBean);		
		objCuestionarioPantallaBean.setObjOrdenBean(objOrdenBean);
		objCuestionarioPantallaBean.setObjPacienteBean(objPacienteBean);		
		return objCuestionarioPantallaBean;
	}

}
