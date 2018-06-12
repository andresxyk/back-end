package mx.com.web2lab.backend.dao.puebla;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.ap.PacienteBean;
import mx.com.web2lab.backend.beans.puebla.CuestionarioPantallaInterpretacionBean;
import mx.com.web2lab.backend.dao.ap.DatosOrdenDao;
import mx.com.web2lab.backend.dao.ap.PacientesDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.puebla.TCuestionarioPacienteInterpretacionPuebla;
import mx.com.web2lab.backend.hbm.om.ap.puebla.TCuestionarioPacientePuebla;
import mx.com.web2lab.backend.util.Formatos;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import net.sf.hibernate.JDBCException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PueblaInterpretacionDao {

	private static Log iObjLog = LogFactory.getLog(PueblaInterpretacionDao.class);
	    
	private Session iObjSesion = null;
	
	public PueblaInterpretacionDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public CuestionarioPantallaInterpretacionBean persistirInterpretacion(CuestionarioPantallaInterpretacionBean objCuestionarioPantallaInterpretacionBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		TCuestionarioPacienteInterpretacionPuebla objTCuestionarioPacienteInterpretacionPuebla = new TCuestionarioPacienteInterpretacionPuebla();
		List objListaInterpretacion = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta PueblaInterpretacionDao.persistirCuestionarioInterpretacion:..." + objCuestionarioPantallaInterpretacionBean.getKordensucursal());
			iObjLog.debug("Consulta PueblaInterpretacionDao.persistirCuestionarioInterpretacion:...mastoadecuada" +objCuestionarioPantallaInterpretacionBean.getUmastografiaadecuada());
			if (objCuestionarioPantallaInterpretacionBean.getKordensucursal() > 0) {			
        		strQuery =  "select bPF " +					
							" from TCuestionarioPacienteInterpretacionPuebla bPF " +					
							" where bPF.kordensucursal = :kordensucursal";
    			iObjLog.debug("Consulta PueblaInterpretacionDao.persistirCuestionarioInterpretacion:..." + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objQuery.setParameter("kordensucursal", new Integer(objCuestionarioPantallaInterpretacionBean.getKordensucursal()));
				objListaInterpretacion = objQuery.list();
				if(objListaInterpretacion != null) {
					if (objListaInterpretacion.size() > 0) {
						objTCuestionarioPacienteInterpretacionPuebla = (TCuestionarioPacienteInterpretacionPuebla)objListaInterpretacion.get(0);
					}
				}			
        	}
        	objTCuestionarioPacienteInterpretacionPuebla.setKordensucursal(new Integer (objCuestionarioPantallaInterpretacionBean.getKordensucursal()));
        	objTCuestionarioPacienteInterpretacionPuebla.setSinstitucion(objCuestionarioPantallaInterpretacionBean.getSinstitucion());
        	objTCuestionarioPacienteInterpretacionPuebla.setSentidad(objCuestionarioPantallaInterpretacionBean.getSentidad());
        	objTCuestionarioPacienteInterpretacionPuebla.setSclues(objCuestionarioPantallaInterpretacionBean.getSclues());
        	objTCuestionarioPacienteInterpretacionPuebla.setUjurisdiccion(objCuestionarioPantallaInterpretacionBean.getUjurisdiccion());
        	objTCuestionarioPacienteInterpretacionPuebla.setSmunicipio(objCuestionarioPantallaInterpretacionBean.getSmunicipio());
        	objTCuestionarioPacienteInterpretacionPuebla.setSunidadmedica(objCuestionarioPantallaInterpretacionBean.getSunidadmedica());
        	objTCuestionarioPacienteInterpretacionPuebla.setSclaveinstitucional(objCuestionarioPantallaInterpretacionBean.getSclaveinstitucional());
        	objTCuestionarioPacienteInterpretacionPuebla.setScurp(objCuestionarioPantallaInterpretacionBean.getScurp());
        	
        	objTCuestionarioPacienteInterpretacionPuebla.setUderechohabiencia(objCuestionarioPantallaInterpretacionBean.getUderechohabiencia());
        	objTCuestionarioPacienteInterpretacionPuebla.setUantescedentedemastografia(objCuestionarioPantallaInterpretacionBean.getUantescedentedemastografia());
        	objTCuestionarioPacienteInterpretacionPuebla.setDfechaultimamastografia(objCuestionarioPantallaInterpretacionBean.getDfechaultimamastografia());
        	objTCuestionarioPacienteInterpretacionPuebla.setUresultadobiradsmastografia(objCuestionarioPantallaInterpretacionBean.getUresultadobiradsmastografia());
        	objTCuestionarioPacienteInterpretacionPuebla.setUmodalidadmastografiatamizaje(objCuestionarioPantallaInterpretacionBean.getUmodalidadmastografiatamizaje());
        	objTCuestionarioPacienteInterpretacionPuebla.setUmodalidadmastografiadiagnostica(objCuestionarioPantallaInterpretacionBean.getUmodalidadmastografiadiagnostica());
        	objTCuestionarioPacienteInterpretacionPuebla.setDfechatomamastografia(objCuestionarioPantallaInterpretacionBean.getDfechatomamastografia());
        	objTCuestionarioPacienteInterpretacionPuebla.setSlugarnacimiento(objCuestionarioPantallaInterpretacionBean.getSlugarnacimiento());
        	iObjLog.debug("Consulta PueblaInterpretacionDao.persistirCuestionarioInterpretacion:...mastoadecuada insertada"+objCuestionarioPantallaInterpretacionBean.getUmastografiaadecuada());
        	objTCuestionarioPacienteInterpretacionPuebla.setUmastografiaadecuada(objCuestionarioPantallaInterpretacionBean.getUmastografiaadecuada());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolimagenincompleta(objCuestionarioPantallaInterpretacionBean.isBolimagenincompleta());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolbajocontraste(objCuestionarioPantallaInterpretacionBean.isBolbajocontraste());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolbajaresolucion(objCuestionarioPantallaInterpretacionBean.isBolbajaresolucion());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolartefactos(objCuestionarioPantallaInterpretacionBean.isBolartefactos());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolmalposicionamiento(objCuestionarioPantallaInterpretacionBean.isBolmalposcicionamiento());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolotros(objCuestionarioPantallaInterpretacionBean.isBolotros());
        	objTCuestionarioPacienteInterpretacionPuebla.setDfechainterpretacionmastografia(objCuestionarioPantallaInterpretacionBean.getDfechainterpretacionmastografia());
        	objTCuestionarioPacienteInterpretacionPuebla.setBoltumorderecho(objCuestionarioPantallaInterpretacionBean.isBoltumorderecho());
        	objTCuestionarioPacienteInterpretacionPuebla.setBoltumorizquierdo(objCuestionarioPantallaInterpretacionBean.isBoltumorizquierdo());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolasimetriaderecho(objCuestionarioPantallaInterpretacionBean.isBolasimetriaderecho());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolasimetriaizquierdo(objCuestionarioPantallaInterpretacionBean.isBolasimetriaizquierdo());
        	objTCuestionarioPacienteInterpretacionPuebla.setBoldeformidadderecho(objCuestionarioPantallaInterpretacionBean.isBoldeformidadderecho());
        	objTCuestionarioPacienteInterpretacionPuebla.setBoldeformidadizquierdo(objCuestionarioPantallaInterpretacionBean.isBoldeformidadizquierdo());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolcalcificacionderecho(objCuestionarioPantallaInterpretacionBean.isBolcalcificacionderecho());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolcalcificacionizquierdo(objCuestionarioPantallaInterpretacionBean.isBolcalcificacionizquierdo());
        	objTCuestionarioPacienteInterpretacionPuebla.setBoldensidadasimetricaderecho(objCuestionarioPantallaInterpretacionBean.isBoldensidadasimetricaderecho());
        	objTCuestionarioPacienteInterpretacionPuebla.setBoldensidadasimetricaizquierdo(objCuestionarioPantallaInterpretacionBean.isBoldensidadasimetricaizquierdo());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolotrosderecho(objCuestionarioPantallaInterpretacionBean.isBolotrosderecho());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolotrosizquierdo(objCuestionarioPantallaInterpretacionBean.isBolotrosizquierdo());
        	objTCuestionarioPacienteInterpretacionPuebla.setUresultadobiradsuno(objCuestionarioPantallaInterpretacionBean.getUresultadobiradsuno());
        	objTCuestionarioPacienteInterpretacionPuebla.setUresultadobiradsdos(objCuestionarioPantallaInterpretacionBean.getUresultadobiradsdos());
        	objTCuestionarioPacienteInterpretacionPuebla.setUresultadobiradstres(objCuestionarioPantallaInterpretacionBean.getUresultadobiradstres());
        	objTCuestionarioPacienteInterpretacionPuebla.setSrfcresultadobiradsuno(objCuestionarioPantallaInterpretacionBean.getSrfcresultadobiradsuno());
        	objTCuestionarioPacienteInterpretacionPuebla.setSrfcresultadobiradsdos(objCuestionarioPantallaInterpretacionBean.getSrfcresultadobiradsdos());
        	objTCuestionarioPacienteInterpretacionPuebla.setSrfcresultadobiradstres(objCuestionarioPantallaInterpretacionBean.getSrfcresultadobiradstres());
        	objTCuestionarioPacienteInterpretacionPuebla.setSobservaciones(objCuestionarioPantallaInterpretacionBean.getSobservaciones());
        	objTCuestionarioPacienteInterpretacionPuebla.setDfechainformeresultado(objCuestionarioPantallaInterpretacionBean.getDfechainformeresultado());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolrepeticionestudio(objCuestionarioPantallaInterpretacionBean.isBolrepeticionestudio());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolproximadeteccion(objCuestionarioPantallaInterpretacionBean.isBolproximadeteccion());
        	objTCuestionarioPacienteInterpretacionPuebla.setBolreferenciaginecologia(objCuestionarioPantallaInterpretacionBean.isBolreferenciaginecologia());
        	objTCuestionarioPacienteInterpretacionPuebla.setSreferenciaevaluacion(objCuestionarioPantallaInterpretacionBean.getSreferenciaevaluacion());
        	objTCuestionarioPacienteInterpretacionPuebla.setDfechareferencia(objCuestionarioPantallaInterpretacionBean.getDfechareferencia());
        	objTCuestionarioPacienteInterpretacionPuebla.setSnombreradiologo(objCuestionarioPantallaInterpretacionBean.getSnombreradiologo());
        	objTCuestionarioPacienteInterpretacionPuebla.setSrfcradiologo(objCuestionarioPantallaInterpretacionBean.getSrfcradiologo());
        	
			if (objTCuestionarioPacienteInterpretacionPuebla.getKcuestionariopacienteinterpretacionpuebla() != null) {
				iObjLog.debug("Consulta PueblaInterpretacionDao.persistirCuestionarioInterpretacion:... Modificando");
	     		iObjSesion.update(objTCuestionarioPacienteInterpretacionPuebla);
			} else {
				iObjLog.debug("Consulta PueblaInterpretacionDao.persistirCuestionarioInterpretacion:... Salvando NUEVO");
	     		iObjSesion.save(objTCuestionarioPacienteInterpretacionPuebla);
			}
			objCuestionarioPantallaInterpretacionBean.setKcuestionariopacienteinterpretacionpuebla(objTCuestionarioPacienteInterpretacionPuebla.getKcuestionariopacienteinterpretacionpuebla().intValue());
			iObjLog.debug("Consulta PueblaInterpretacionDao.persistirCuestionarioInterpretacion:...mastoadecuada insertada"+objTCuestionarioPacienteInterpretacionPuebla.getUmastografiaadecuada());
			objCuestionarioPantallaInterpretacionBean.setSmensajeoperacion("Exito en el guardado de la base de datos");
    		iObjSesion.flush(); 
    		iObjLog.error("Saliendo del PueblaInterpretacionDao.persistirCuestionarioInterpretacion:... "+objCuestionarioPantallaInterpretacionBean.getSmensajeoperacion());
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PueblaInterpretacionDao.persistirCuestionarioInterpretacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objListaInterpretacion.clear();
        	objListaInterpretacion = null;
        	objQuery = null;
        	objTCuestionarioPacienteInterpretacionPuebla = null;
        	HibernateUtil.closeSession();
		}		
		return objCuestionarioPantallaInterpretacionBean;
	}

	public CuestionarioPantallaInterpretacionBean buscarInterpretacion(CuestionarioPantallaInterpretacionBean objCuestionarioPantallaInterpretacionBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		TCuestionarioPacienteInterpretacionPuebla objTCuestionarioPacienteInterpretacionPuebla = null;
		List objListaInterpretacion = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta PueblaInterpretacionDao.buscarInterpretacion:..." + objCuestionarioPantallaInterpretacionBean.getKordensucursal());
        	if (objCuestionarioPantallaInterpretacionBean.getKordensucursal() > 0) {			
        		strQuery =  "select bPF " +					
							" from TCuestionarioPacienteInterpretacionPuebla bPF " +					
							" where bPF.kordensucursal = :kordensucursal";
    			iObjLog.debug("Consulta PueblaInterpretacionDao.buscarInterpretacion:..." + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objQuery.setParameter("kordensucursal", new Integer(objCuestionarioPantallaInterpretacionBean.getKordensucursal()));
				objListaInterpretacion = objQuery.list();
				if(objListaInterpretacion != null) {
					if (objListaInterpretacion.size() > 0) {
						iObjLog.debug("Hay Datos ");
						objTCuestionarioPacienteInterpretacionPuebla = (TCuestionarioPacienteInterpretacionPuebla)objListaInterpretacion.get(0);
					}
				}			
        	}
        	if (objTCuestionarioPacienteInterpretacionPuebla != null) {
        		iObjLog.debug("LLenando bean"); 
        		objCuestionarioPantallaInterpretacionBean.setKordensucursal(objTCuestionarioPacienteInterpretacionPuebla.getKordensucursal().intValue());
        		objCuestionarioPantallaInterpretacionBean.setKcuestionariopacienteinterpretacionpuebla(objTCuestionarioPacienteInterpretacionPuebla.getKcuestionariopacienteinterpretacionpuebla().intValue());
        		objCuestionarioPantallaInterpretacionBean.setSinstitucion(objTCuestionarioPacienteInterpretacionPuebla.getSinstitucion());
        		objCuestionarioPantallaInterpretacionBean.setSentidad(objTCuestionarioPacienteInterpretacionPuebla.getSentidad());
        		objCuestionarioPantallaInterpretacionBean.setSclues(objTCuestionarioPacienteInterpretacionPuebla.getSclues());
        		objCuestionarioPantallaInterpretacionBean.setUjurisdiccion(objTCuestionarioPacienteInterpretacionPuebla.getUjurisdiccion());
        		objCuestionarioPantallaInterpretacionBean.setSmunicipio(objTCuestionarioPacienteInterpretacionPuebla.getSmunicipio());
        		objCuestionarioPantallaInterpretacionBean.setSunidadmedica(objTCuestionarioPacienteInterpretacionPuebla.getSunidadmedica());
        		objCuestionarioPantallaInterpretacionBean.setSclaveinstitucional(objTCuestionarioPacienteInterpretacionPuebla.getSclaveinstitucional());
        		objCuestionarioPantallaInterpretacionBean.setScurp(objTCuestionarioPacienteInterpretacionPuebla.getScurp());
        		objCuestionarioPantallaInterpretacionBean.setSlugarnacimiento(objTCuestionarioPacienteInterpretacionPuebla.getSlugarnacimiento());
        		objCuestionarioPantallaInterpretacionBean.setUderechohabiencia(objTCuestionarioPacienteInterpretacionPuebla.getUderechohabiencia());
        		objCuestionarioPantallaInterpretacionBean.setUantescedentedemastografia(objTCuestionarioPacienteInterpretacionPuebla.getUantescedentedemastografia());
        		objCuestionarioPantallaInterpretacionBean.setDfechaultimamastografia(objTCuestionarioPacienteInterpretacionPuebla.getDfechaultimamastografia());
        		objCuestionarioPantallaInterpretacionBean.setUresultadobiradsmastografia(objTCuestionarioPacienteInterpretacionPuebla.getUresultadobiradsmastografia());
        		objCuestionarioPantallaInterpretacionBean.setUmodalidadmastografiatamizaje(objTCuestionarioPacienteInterpretacionPuebla.getUmodalidadmastografiatamizaje());
        		objCuestionarioPantallaInterpretacionBean.setUmodalidadmastografiadiagnostica(objTCuestionarioPacienteInterpretacionPuebla.getUmodalidadmastografiadiagnostica());
        		objCuestionarioPantallaInterpretacionBean.setDfechatomamastografia(objTCuestionarioPacienteInterpretacionPuebla.getDfechatomamastografia());
        		objCuestionarioPantallaInterpretacionBean.setUmastografiaadecuada(objTCuestionarioPacienteInterpretacionPuebla.getUmastografiaadecuada());
        		objCuestionarioPantallaInterpretacionBean.setBolimagenincompleta(objTCuestionarioPacienteInterpretacionPuebla.isBolimagenincompleta());
        		objCuestionarioPantallaInterpretacionBean.setBolbajocontraste(objTCuestionarioPacienteInterpretacionPuebla.isBolbajocontraste());
        		objCuestionarioPantallaInterpretacionBean.setBolbajaresolucion(objTCuestionarioPacienteInterpretacionPuebla.isBolbajaresolucion());
        		objCuestionarioPantallaInterpretacionBean.setBolartefactos(objTCuestionarioPacienteInterpretacionPuebla.isBolartefactos());
        		objCuestionarioPantallaInterpretacionBean.setBolmalposcicionamiento(objTCuestionarioPacienteInterpretacionPuebla.isBolmalposicionamiento());
        		objCuestionarioPantallaInterpretacionBean.setBolotros(objTCuestionarioPacienteInterpretacionPuebla.isBolotros());
        		objCuestionarioPantallaInterpretacionBean.setDfechainterpretacionmastografia(objTCuestionarioPacienteInterpretacionPuebla.getDfechainterpretacionmastografia());
        		objCuestionarioPantallaInterpretacionBean.setBoltumorderecho(objTCuestionarioPacienteInterpretacionPuebla.isBoltumorderecho());
        		objCuestionarioPantallaInterpretacionBean.setBoltumorizquierdo(objTCuestionarioPacienteInterpretacionPuebla.isBoltumorizquierdo());
        		objCuestionarioPantallaInterpretacionBean.setBolasimetriaderecho(objTCuestionarioPacienteInterpretacionPuebla.isBolasimetriaderecho());
        		objCuestionarioPantallaInterpretacionBean.setBolasimetriaizquierdo(objTCuestionarioPacienteInterpretacionPuebla.isBolasimetriaizquierdo());
        		objCuestionarioPantallaInterpretacionBean.setBoldeformidadderecho(objTCuestionarioPacienteInterpretacionPuebla.isBoldeformidadderecho());
        		objCuestionarioPantallaInterpretacionBean.setBoldeformidadizquierdo(objTCuestionarioPacienteInterpretacionPuebla.isBoldeformidadizquierdo());
        		objCuestionarioPantallaInterpretacionBean.setBolcalcificacionderecho(objTCuestionarioPacienteInterpretacionPuebla.isBolcalcificacionderecho());
        		objCuestionarioPantallaInterpretacionBean.setBolcalcificacionizquierdo(objTCuestionarioPacienteInterpretacionPuebla.isBolcalcificacionizquierdo());
        		objCuestionarioPantallaInterpretacionBean.setBoldensidadasimetricaderecho(objTCuestionarioPacienteInterpretacionPuebla.isBoldensidadasimetricaderecho());
        		objCuestionarioPantallaInterpretacionBean.setBoldensidadasimetricaizquierdo(objTCuestionarioPacienteInterpretacionPuebla.isBoldensidadasimetricaizquierdo());
        		objCuestionarioPantallaInterpretacionBean.setBolotrosderecho(objTCuestionarioPacienteInterpretacionPuebla.isBolotrosderecho());
        		objCuestionarioPantallaInterpretacionBean.setBolotrosizquierdo(objTCuestionarioPacienteInterpretacionPuebla.isBolotrosizquierdo());
        		objCuestionarioPantallaInterpretacionBean.setUresultadobiradsuno(objTCuestionarioPacienteInterpretacionPuebla.getUresultadobiradsuno());
        		objCuestionarioPantallaInterpretacionBean.setUresultadobiradsdos(objTCuestionarioPacienteInterpretacionPuebla.getUresultadobiradsdos());
        		objCuestionarioPantallaInterpretacionBean.setUresultadobiradstres(objTCuestionarioPacienteInterpretacionPuebla.getUresultadobiradstres());
        		objCuestionarioPantallaInterpretacionBean.setSrfcresultadobiradsuno(objTCuestionarioPacienteInterpretacionPuebla.getSrfcresultadobiradsuno());
        		objCuestionarioPantallaInterpretacionBean.setSrfcresultadobiradsdos(objTCuestionarioPacienteInterpretacionPuebla.getSrfcresultadobiradsdos());
        		objCuestionarioPantallaInterpretacionBean.setSrfcresultadobiradstres(objTCuestionarioPacienteInterpretacionPuebla.getSrfcresultadobiradstres());
        		objCuestionarioPantallaInterpretacionBean.setSobservaciones(objTCuestionarioPacienteInterpretacionPuebla.getSobservaciones());
        		objCuestionarioPantallaInterpretacionBean.setDfechainformeresultado(objTCuestionarioPacienteInterpretacionPuebla.getDfechainformeresultado());
        		objCuestionarioPantallaInterpretacionBean.setBolrepeticionestudio(objTCuestionarioPacienteInterpretacionPuebla.isBolrepeticionestudio());
        		objCuestionarioPantallaInterpretacionBean.setBolproximadeteccion(objTCuestionarioPacienteInterpretacionPuebla.isBolproximadeteccion());
        		objCuestionarioPantallaInterpretacionBean.setBolreferenciaginecologia(objTCuestionarioPacienteInterpretacionPuebla.isBolreferenciaginecologia());
        		objCuestionarioPantallaInterpretacionBean.setSreferenciaevaluacion(objTCuestionarioPacienteInterpretacionPuebla.getSreferenciaevaluacion());
        		objCuestionarioPantallaInterpretacionBean.setDfechareferencia(objTCuestionarioPacienteInterpretacionPuebla.getDfechareferencia());
        		objCuestionarioPantallaInterpretacionBean.setSnombreradiologo(objTCuestionarioPacienteInterpretacionPuebla.getSnombreradiologo());
        		objCuestionarioPantallaInterpretacionBean.setSrfcradiologo(objTCuestionarioPacienteInterpretacionPuebla.getSrfcradiologo());
        		if(objTCuestionarioPacienteInterpretacionPuebla.getDfechainformeresultado().getYear()==81) {
        			objCuestionarioPantallaInterpretacionBean.setSfechainformeresultado("");
        		} else {
        			objCuestionarioPantallaInterpretacionBean.setSfechainformeresultado(new Formatos().formateaFechaDB(objTCuestionarioPacienteInterpretacionPuebla.getDfechainformeresultado().toString()));
        		}
        		if(objTCuestionarioPacienteInterpretacionPuebla.getDfechainterpretacionmastografia().getYear()==81) {
        			objCuestionarioPantallaInterpretacionBean.setSfechainterpretacionmastografia("");
        		} else {
        			objCuestionarioPantallaInterpretacionBean.setSfechainterpretacionmastografia(new Formatos().formateaFechaDB(objTCuestionarioPacienteInterpretacionPuebla.getDfechainterpretacionmastografia().toString()));
        		}
        		if(objTCuestionarioPacienteInterpretacionPuebla.getDfechareferencia().getYear()==81) {
        			objCuestionarioPantallaInterpretacionBean.setSfechareferencia("");
        		} else {
        			objCuestionarioPantallaInterpretacionBean.setSfechareferencia(new Formatos().formateaFechaDB(objTCuestionarioPacienteInterpretacionPuebla.getDfechareferencia().toString()));
        		}
        		if(objTCuestionarioPacienteInterpretacionPuebla.getDfechatomamastografia().getYear()==81) {
        			objCuestionarioPantallaInterpretacionBean.setSfechatomamastografia("");
        		} else {
        			objCuestionarioPantallaInterpretacionBean.setSfechatomamastografia(new Formatos().formateaFechaDB(objTCuestionarioPacienteInterpretacionPuebla.getDfechatomamastografia().toString()));
        		}
        		if(objTCuestionarioPacienteInterpretacionPuebla.getDfechaultimamastografia().getYear()==81) {
        			objCuestionarioPantallaInterpretacionBean.setSfechaultimamastografia("");
        		} else {
        			objCuestionarioPantallaInterpretacionBean.setSfechaultimamastografia(new Formatos().formateaFechaDB(objTCuestionarioPacienteInterpretacionPuebla.getDfechaultimamastografia().toString()));
        		}
        		objCuestionarioPantallaInterpretacionBean.setSmensajeoperacion("");
        		//objCuestionarioPantallaInterpretacionBean.setSfechainformeresultado("");
        		//objCuestionarioPantallaInterpretacionBean.setSfechainterpretacionmastografia("");
        		//objCuestionarioPantallaInterpretacionBean.setSfechareferencia("");
        		//objCuestionarioPantallaInterpretacionBean.setSfechatomamastografia("");
        		//objCuestionarioPantallaInterpretacionBean.setSfechaultimamastografia("");
        		iObjLog.debug("DATOS------------------------");
        		iObjLog.debug("getKordensucursal "+objCuestionarioPantallaInterpretacionBean.getKordensucursal());
        		iObjLog.debug("getKcuestionariopaciente "+objCuestionarioPantallaInterpretacionBean.getKcuestionariopacienteinterpretacionpuebla());
        		iObjLog.debug("getSentidad "+objCuestionarioPantallaInterpretacionBean.getSentidad());
        		iObjLog.debug("getSclues "+objTCuestionarioPacienteInterpretacionPuebla.getSclues());
        		iObjLog.debug("getUjurisdiccion "+objTCuestionarioPacienteInterpretacionPuebla.getUjurisdiccion());
        		iObjLog.debug("getSmunicipio "+objTCuestionarioPacienteInterpretacionPuebla.getSmunicipio());
        		iObjLog.debug("getSunidadmedica "+objTCuestionarioPacienteInterpretacionPuebla.getSunidadmedica());
        		iObjLog.debug("getSclaveinstitucional "+objTCuestionarioPacienteInterpretacionPuebla.getSclaveinstitucional());
        		iObjLog.debug("getScurp "+objTCuestionarioPacienteInterpretacionPuebla.getScurp());
        		iObjLog.debug("getUderechohabiencia "+objTCuestionarioPacienteInterpretacionPuebla.getUderechohabiencia());
        		iObjLog.debug("getUderechohabiencia "+objTCuestionarioPacienteInterpretacionPuebla.getUantescedentedemastografia());
        		iObjLog.debug("getDfechaultimamastografia "+objTCuestionarioPacienteInterpretacionPuebla.getDfechaultimamastografia());
        		iObjLog.debug("getUresultadobiradsmastografia "+objTCuestionarioPacienteInterpretacionPuebla.getUresultadobiradsmastografia());
        		iObjLog.debug("getUmodalidadmastografiatamizaje "+objTCuestionarioPacienteInterpretacionPuebla.getUmodalidadmastografiatamizaje());
        		iObjLog.debug("getUmodalidadmastografiadiagnostica "+objTCuestionarioPacienteInterpretacionPuebla.getUmodalidadmastografiadiagnostica());
        		iObjLog.debug("getDfechatomamastografia "+objTCuestionarioPacienteInterpretacionPuebla.getDfechatomamastografia());
        		iObjLog.debug("getUmastografiaadecuada "+objTCuestionarioPacienteInterpretacionPuebla.getUmastografiaadecuada());
        		iObjLog.debug("isBolimagenincompleta "+objTCuestionarioPacienteInterpretacionPuebla.isBolimagenincompleta());
        		iObjLog.debug("isBolbajocontraste "+objTCuestionarioPacienteInterpretacionPuebla.isBolbajocontraste());
        		iObjLog.debug("isBolbajaresolucion "+objTCuestionarioPacienteInterpretacionPuebla.isBolbajaresolucion());
        		iObjLog.debug("isBolmalposicionamiento "+objTCuestionarioPacienteInterpretacionPuebla.isBolmalposicionamiento());
        		iObjLog.debug("isBolbajocontraste "+objTCuestionarioPacienteInterpretacionPuebla.isBolbajocontraste());
        		iObjLog.debug("isBolotros "+objTCuestionarioPacienteInterpretacionPuebla.isBolotros());
        		iObjLog.debug("getDfechainterpretacionmastografia "+objTCuestionarioPacienteInterpretacionPuebla.getDfechainterpretacionmastografia());
        		iObjLog.debug("isBoltumorderecho "+objTCuestionarioPacienteInterpretacionPuebla.isBoltumorderecho());
        		iObjLog.debug("isBoltumorizquierdo "+objTCuestionarioPacienteInterpretacionPuebla.isBoltumorizquierdo());
        		iObjLog.debug("isBolasimetriaderecho "+objTCuestionarioPacienteInterpretacionPuebla.isBolasimetriaderecho());
        		iObjLog.debug("isBolasimetriaizquierdo "+objTCuestionarioPacienteInterpretacionPuebla.isBolasimetriaizquierdo());
        		iObjLog.debug("isBoldeformidadderecho "+objTCuestionarioPacienteInterpretacionPuebla.isBoldeformidadderecho());
        		iObjLog.debug("isBoldeformidadizquierdo "+objTCuestionarioPacienteInterpretacionPuebla.isBoldeformidadizquierdo());
        		iObjLog.debug("isBolcalcificacionderecho "+objTCuestionarioPacienteInterpretacionPuebla.isBolcalcificacionderecho());
        		iObjLog.debug("isBolcalcificacionizquierdo "+objTCuestionarioPacienteInterpretacionPuebla.isBolcalcificacionizquierdo());
        		iObjLog.debug("isBoldensidadasimetricaderecho "+objTCuestionarioPacienteInterpretacionPuebla.isBoldensidadasimetricaderecho());
        		iObjLog.debug("isBoldensidadasimetricaizquierdo "+objTCuestionarioPacienteInterpretacionPuebla.isBoldensidadasimetricaizquierdo());
        		iObjLog.debug("isBolotrosderecho "+objTCuestionarioPacienteInterpretacionPuebla.isBolotrosderecho());
        		iObjLog.debug("isBolotrosizquierdo "+objTCuestionarioPacienteInterpretacionPuebla.isBolotrosizquierdo());
        		iObjLog.debug("getUresultadobiradsuno "+objTCuestionarioPacienteInterpretacionPuebla.getUresultadobiradsuno());
        		iObjLog.debug("getUresultadobiradsdos "+objTCuestionarioPacienteInterpretacionPuebla.getUresultadobiradsdos());
        		iObjLog.debug("getUresultadobiradstres "+objTCuestionarioPacienteInterpretacionPuebla.getUresultadobiradstres());
        		iObjLog.debug("getSrfcresultadobiradsuno "+objTCuestionarioPacienteInterpretacionPuebla.getSrfcresultadobiradsuno());
        		iObjLog.debug("getSrfcresultadobiradsdos "+objTCuestionarioPacienteInterpretacionPuebla.getSrfcresultadobiradsdos());
        		iObjLog.debug("getSrfcresultadobiradstres "+objTCuestionarioPacienteInterpretacionPuebla.getSrfcresultadobiradstres());
        		iObjLog.debug("getSobservaciones "+objTCuestionarioPacienteInterpretacionPuebla.getSobservaciones());
        		iObjLog.debug("getDfechainformeresultado "+objTCuestionarioPacienteInterpretacionPuebla.getDfechainformeresultado());
        		iObjLog.debug("isBolrepeticionestudio "+objTCuestionarioPacienteInterpretacionPuebla.isBolrepeticionestudio());
        		iObjLog.debug("isBolproximadeteccion "+objTCuestionarioPacienteInterpretacionPuebla.isBolproximadeteccion());
        		iObjLog.debug("isBolreferenciaginecologia "+objTCuestionarioPacienteInterpretacionPuebla.isBolreferenciaginecologia());
        		iObjLog.debug("getSreferenciaevaluacion "+objTCuestionarioPacienteInterpretacionPuebla.getSreferenciaevaluacion());
        		iObjLog.debug("getDfechareferencia "+objTCuestionarioPacienteInterpretacionPuebla.getDfechareferencia());
        		iObjLog.debug("getSnombreradiologo "+objTCuestionarioPacienteInterpretacionPuebla.getSnombreradiologo());
        		iObjLog.debug("getSrfcradiologo "+objTCuestionarioPacienteInterpretacionPuebla.getSrfcradiologo());
            				
        	}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PueblaInterpretacionDao.buscarInterpretacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objListaInterpretacion.clear();
        	objListaInterpretacion = null;
        	objQuery = null;
        	//objCuestionarioPantallaInterpretacionBean = null;
        	HibernateUtil.closeSession();
		}		
		return objCuestionarioPantallaInterpretacionBean;
	}

	public CuestionarioPantallaInterpretacionBean imprimirInterpretacion(CuestionarioPantallaInterpretacionBean objCuestionarioPantallaBean) throws Exception {		
		iObjLog.debug("Consulta PueblaInterpretacionDao.imprimirInterpretacion:..." + objCuestionarioPantallaBean.getKordensucursal());
		DatosOrdenDao objDatosOrdenDao = new DatosOrdenDao();
		PacientesDao objPacienteDao = new PacientesDao();
		CuestionarioPantallaInterpretacionBean objCuestionarioPantallaInterpretacion=null;
		
		OrdenBean objOrdenBean =  new OrdenBean();
		PacienteBean objPacientebean = new PacienteBean();
	
	try {	
			
			objCuestionarioPantallaInterpretacion=this.buscarInterpretacion(objCuestionarioPantallaBean);
			objOrdenBean = objDatosOrdenDao.buscarOrdenOnly(objCuestionarioPantallaBean.getKordensucursal());
			iObjLog.debug("Consulta PueblaInterpretacionDao.imprimirInterpretacion:...objCuestionarioPantallaInterpretacion.kordensucursal"+objCuestionarioPantallaInterpretacion.getKcuestionariopacienteinterpretacionpuebla());
			if(objOrdenBean.getSordenfundacion().trim().length()>0 ) {
				iObjLog.debug("Consulta PueblaInterpretacionDao.imprimirInterpretacion:...kordensucursal"+objOrdenBean.getKadmision());
				iObjLog.debug("Consulta PueblaInterpretacionDao.imprimirInterpretacion:...kpaciente"+objOrdenBean.getBpacientebean().getKpacientefundacion());
				objPacientebean=objPacienteDao.buscarPaciente(objOrdenBean.getBpacientebean());
				objOrdenBean.setBpacientebean(objPacientebean);
				iObjLog.debug("Consulta PueblaInterpretacionDao.imprimirInterpretacion:...kdireccion"+objOrdenBean.getBpacientebean().getSdireccion());
				objCuestionarioPantallaInterpretacion.setObjOrdenBean(objOrdenBean);
				iObjLog.debug("Saliendo.....");	
			} else {
				
				iObjLog.debug("Estoy en null.....");	
			}
			return objCuestionarioPantallaInterpretacion;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PueblaInterpretacionDao.imprimirInterpretacion:", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	
        }
	}

}
