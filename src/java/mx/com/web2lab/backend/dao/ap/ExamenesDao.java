package mx.com.web2lab.backend.dao.ap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenExamenBean;
import mx.com.web2lab.backend.beans.tools.ConvertBeanvsHB;
import mx.com.web2lab.backend.hbm.ConfiguracionProperties;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.EListaCorporativaDetalle;
import mx.com.web2lab.backend.hbm.om.ap.EPerfilExamen;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursalFac;
import mx.com.web2lab.backend.hbm.om.fundacion.BOrdenExamenFundacion;
import mx.com.web2lab.backend.util.formatos.Formatos;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExamenesDao {

	private static Log iObjLog = LogFactory.getLog(ExamenesDao.class);
	    
	private Session iObjSesion = null;
	
	public ExamenesDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public List getExamenesPerfilesCorporativa() throws Exception {
		    List objListaProductosHibernate = new ArrayList();
			List objListaProductos = new ArrayList();
			List objListaProductosAll = new ArrayList();
			List objListaExamenes = new ArrayList();
			List objListaPerfiles = new ArrayList();		
			List objListaExamenesBusqueda = new ArrayList();
			int intListaCorporativaVigente = Integer.parseInt(ConfiguracionProperties.getPropiedad("configuracion.listaprecio.vigente"));
			int intListaCorporativaMayoreo = Integer.parseInt(ConfiguracionProperties.getPropiedad("configuracion.listaprecio.mayoreo"));
			iObjLog.debug("Entrando ExamenesDao.getExamenesPerfilesCorporativa");
			Query objQuery = null;
			String strQuery = "";
			OrdenExamenBean objExamenSearchBean = null;
			Formatos objFormatear = new Formatos();
	    	try{
	            HibernateUtil.beginTrans();
					strQuery = "select dEF " +					
							   " from EListaCorporativaDetalle dEF " +
							   " order by dEF.cexamen.sexamen "; 
					objQuery = iObjSesion.createQuery(strQuery);
					objListaProductosHibernate = objQuery.list();
					if (!objListaProductosHibernate.isEmpty()) {
						for (int inti=0;inti<objListaProductosHibernate.size();inti++) {
							EListaCorporativaDetalle objDExamen = (EListaCorporativaDetalle)objListaProductosHibernate.get(inti);
							OrdenExamenBean objExamenBean = new OrdenExamenBean();
							objExamenBean.setCestadoregistro(13);
							objExamenBean.setCexamen(objDExamen.getCexamen().getCexamen().intValue());
							objExamenBean.setCsucursal(1);
							objExamenBean.setUserid(1);
							objExamenBean.setDregistro(objDExamen.getDregistro());
							objExamenBean.setMsubtotal(objDExamen.getMprecio().doubleValue());
							objExamenBean.setMdescuentoempresa(0.0);
							objExamenBean.setMdescuentomedico(0.0);
							objExamenBean.setMdescuentopromocion(0.0);
							objExamenBean.setMfacturaempresa(0.0);
							objExamenBean.setMiva((objDExamen.getMprecio().doubleValue() - (objDExamen.getMprecio().doubleValue() / 1.16)));
							objExamenBean.setMpagopaciente(objDExamen.getMprecio().doubleValue());
							objExamenBean.setMtotal(objDExamen.getMprecio().doubleValue());
							objExamenBean.setSexamen(objDExamen.getCexamen().getSexamen());
							objExamenBean.setCtipocomercial(objDExamen.getCexamen().getCtipocomercial().getCtipocomercial().intValue());
							objExamenBean.setStipocomercial(objDExamen.getCexamen().getCtipocomercial().getSdescripcioncomercial());
							objExamenBean.setCclasificacioncomercial(objDExamen.getCexamen().getCclasificacioncomercial().getCclasificacioncomercial().intValue());
							objExamenBean.setSclasificacioncomercial(objDExamen.getCexamen().getCclasificacioncomercial().getSclasificacioncomercial());
							objExamenBean.setUdiasproceso(1);
							objExamenBean.setCperfil(-1);
							objExamenBean.setSperfil("");
							objExamenBean.setClistapublico(objDExamen.getClistacorporativa().getClistacorporativa().intValue());
							objExamenBean.setUvolumenexamen(objDExamen.getCexamen().getUvolumenmaximo());
							iObjLog.debug("Entrando ExamenesDao.getExamenesPerfilesCorporativa Examen " + objDExamen.getCexamen().getCexamen() + " Volumen Examen " + objExamenBean.getUvolumenexamen());
							objExamenBean.setBolListaPublico(objDExamen.getCexamen().isBlistapublico());
							iObjLog.debug("Entrando ExamenesDao.getExamenesPerfilesCorporativa Examen II " + objDExamen.getCexamen().getCexamen() + " Boolean " + objExamenBean.isBolListaPublico());
							objListaExamenes.add(objExamenBean);
							objListaProductosAll.add(objExamenBean);
							objListaExamenesBusqueda.add(objExamenBean);
						}
					}
					objListaProductosHibernate.clear();
					strQuery = "select ePE " +					
							   " from EPerfilExamen ePE " +
							   " order by ePE.cperfil.sperfil "; 
					objQuery = iObjSesion.createQuery(strQuery);
					objListaProductosHibernate = objQuery.list();
					double dblPrecio = 0.0;
					double dblDescuentoPerfil = 0.0;
					double dblPrecioPerfil = 0.0;
					double dblIVAPerfil = 0.0;
					int intListaVerificar = 0;
					if (!objListaProductosHibernate.isEmpty()) {
						for (int inti=0;inti<objListaProductosHibernate.size();inti++) {
							EPerfilExamen objePerilExamen = (EPerfilExamen)objListaProductosHibernate.get(inti);
							OrdenExamenBean objExamenPerfilBean = new OrdenExamenBean();
							objExamenPerfilBean.setCestadoregistro(13);
							objExamenPerfilBean.setCexamen(objePerilExamen.getCexamen().getCexamen().intValue());
							objExamenPerfilBean.setCsucursal(1);
							objExamenPerfilBean.setUserid(1);
							objExamenPerfilBean.setDregistro(objePerilExamen.getDregistro());
							dblPrecio = 999999;
							if (objePerilExamen.getCperfil().getSperfil().toUpperCase().indexOf("PAQUETE") > -1) {
								intListaVerificar = intListaCorporativaMayoreo;
							} else {
								/* Cambio de Lista de Precios*/																
								if (objePerilExamen.getCperfil().isBlistapublico()) {
									intListaVerificar = intListaCorporativaVigente; // 5;									
								} else {
									intListaVerificar = intListaCorporativaMayoreo; //3;									
								}
//								intListaVerificar = intListaCorporativaVigente;
							}							
							for (int inty = 0;inty<objListaExamenesBusqueda.size();inty++) {
								objExamenSearchBean = (OrdenExamenBean)objListaExamenesBusqueda.get(inty);																
								if (objExamenSearchBean.getCexamen() == objePerilExamen.getCexamen().getCexamen().intValue() && objExamenSearchBean.getCperfil() == -1 && objExamenSearchBean.getClistapublico() == intListaVerificar) {
									dblPrecio = objExamenSearchBean.getMtotal(); 																	
									break;
								}
								objExamenSearchBean = null;								
							}	
							/*************** Limpieza *****************************/
								dblDescuentoPerfil = 0.0;
								dblPrecioPerfil = 0.0;
								dblIVAPerfil = 0.0;
							objExamenPerfilBean.setCperfil(objePerilExamen.getCperfil().getCperfil().intValue());
							/*************** Precio del SubTotal Redonde a 1 23062011******************/
							objExamenPerfilBean.setMsubtotal(this.redodedoDouble2(dblPrecio));
							/************* Calculo del monto de Descuento *********/
							dblDescuentoPerfil = ((dblPrecio * objePerilExamen.getPdescuento().doubleValue()) / 100.0);							
							dblDescuentoPerfil = this.redodedoDouble2(dblDescuentoPerfil); 										
							objExamenPerfilBean.setMdescuentopromocion(0.0);																						
							/************* Calculo del monto que pagara el Paciente *********/
							dblPrecioPerfil = (dblPrecio - dblDescuentoPerfil);
							objExamenPerfilBean.setMsubtotal(this.redodedoDouble2(dblPrecioPerfil));
							objExamenPerfilBean.setMpagopaciente(this.redodedoDouble2(dblPrecioPerfil));
							objExamenPerfilBean.setMtotal(this.redodedoDouble2(dblPrecioPerfil));
							/************* Calculo del IVA *********/
							dblIVAPerfil = (dblPrecioPerfil - (dblPrecioPerfil / 1.16));
							objExamenPerfilBean.setMiva(this.redodedoDouble2(dblIVAPerfil));								
							objExamenPerfilBean.setMdescuentoempresa(0.0);
							objExamenPerfilBean.setMdescuentomedico(0.0);
							objExamenPerfilBean.setMfacturaempresa(0.0);
							objExamenPerfilBean.setSexamen(objePerilExamen.getCexamen().getSexamen());
							objExamenPerfilBean.setCtipocomercial(objePerilExamen.getCexamen().getCtipocomercial().getCtipocomercial().intValue());
							objExamenPerfilBean.setStipocomercial(objePerilExamen.getCexamen().getCtipocomercial().getSdescripcioncomercial());
							objExamenPerfilBean.setCclasificacioncomercial(objePerilExamen.getCexamen().getCclasificacioncomercial().getCclasificacioncomercial().intValue());
							objExamenPerfilBean.setSclasificacioncomercial(objePerilExamen.getCexamen().getCclasificacioncomercial().getSclasificacioncomercial());
							objExamenPerfilBean.setUdiasproceso(1);
							objExamenPerfilBean.setUvolumenexamen((short)1);							
							objExamenPerfilBean.setCperfil(objePerilExamen.getCperfil().getCperfil().intValue());
							objExamenPerfilBean.setBolListaPublico(objePerilExamen.getCperfil().isBlistapublico());							
							if (objePerilExamen.getCperfil().getSperfil().toUpperCase().indexOf("PAQUETE") > -1) {
								objExamenPerfilBean.setClistapublico(intListaCorporativaMayoreo);
							} else {
								objExamenPerfilBean.setClistapublico(intListaCorporativaVigente);
								/* Cambio de Lista de Precios*/								
								if (objePerilExamen.getCperfil().isBlistapublico()) {
									objExamenPerfilBean.setClistapublico(intListaCorporativaVigente); // 5);
								} else {
									objExamenPerfilBean.setClistapublico(intListaCorporativaMayoreo); //3);
								}
								
							}
							objExamenPerfilBean.setSperfil(objePerilExamen.getCperfil().getSperfil());
							objListaPerfiles.add(objExamenPerfilBean);
							objListaProductosAll.add(objExamenPerfilBean);
						}
					}					
					
			iObjLog.debug("Saliendo ExamenesDao.getExamenesPerfilesCorporativa:Saliendo... Examenes " + objListaExamenes.size() + " Perfiles " + objListaPerfiles.size() + " Producto All " + objListaProductosAll.size());
			objListaProductos.add(objListaExamenes);
			objListaProductos.add(objListaPerfiles);
			objListaProductos.add(objListaProductosAll);
			return objListaProductos;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ExamenesDao.getExamenesPerfilesCorporativa: ", aObjExcepcion);
			objListaExamenes = null;
			throw aObjExcepcion;
        } finally{	
			objExamenSearchBean = null;
        	objListaExamenesBusqueda.clear();
        	objListaExamenesBusqueda = null;
        	objFormatear = null;
        	objListaProductosHibernate.clear();
        	objListaProductosHibernate = null;
        	objQuery = null;
        	HibernateUtil.closeSession();
		}		
	}			
	
	
	public List buscarpersistemExamenes(int intKAdmision) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaExamenes = null;
		List objListaExamenesReturn = new ArrayList();
		ConvertBeanvsHB objConvert = new ConvertBeanvsHB();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando ExamenesDao.buscarpersistemExamenes:Entrando...  " + intKAdmision);
			HibernateUtil.beginTrans();
			strQuery = "select bOEF " +					
			   		   "from TOrdenSucursal bOF " +	
			           "	join bOF.tordenexamensucursals bOEF " +
			           "where bOF.kordensucursal =  " + intKAdmision;
			iObjLog.debug("Entrando DatosOrdenDao.buscarpersistemExamenes:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaExamenes = objQuery.list();
			if (objListaExamenes != null){
				if (objListaExamenes.size() > 0 ){
					for (int inti=0;inti<objListaExamenes.size();inti++) {
						objListaExamenesReturn.add(objConvert.convertExamenHBBean((TOrdenExamenSucursal)objListaExamenes.get(inti), "DatosOrdenDao.buscarpersistemExamenes"));
					}
				}
			}
			iObjLog.debug("Entrando ExamenesDao.buscarpersistemExamenes:Resultado...  " + objListaExamenes.size());
			//HibernateUtil.commitTrans();	 				
			iObjLog.debug("Saliendo ExamenesDao.buscarpersistemExamenes:Saliendo...  " + objListaExamenes.toString());
			return objListaExamenesReturn;
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ExamenesDao.buscarpersistemExamenes: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objListaExamenes.clear();
    		objListaExamenes = null;
    		objQuery = null;
    		HibernateUtil.closeSession();
    	}		
	}	

	public List buscarpersistemExamenesFac(int intKAdmision) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaExamenes = null;
		List objListaExamenesReturn = new ArrayList();
		ConvertBeanvsHB objConvert = new ConvertBeanvsHB();
		Connection objConn = null;
		Statement objStam = null;
		ResultSet objRst = null;
		Query objQuery = null;
		String strQuery = "";
		int kOrdenSucursalFac = 0;
    	try{
			iObjLog.debug("Entrando ExamenesDao.buscarpersistemExamenesFac:Entrando...  " + intKAdmision);
			HibernateUtil.beginTrans();
			objConn = iObjSesion.connection();
			objStam = objConn.createStatement();
			objRst = objStam.executeQuery("SELECT max(kordensucursalfac) as kordensucursalfac FROM T_ORDEN_SUCURSAL_FAC WHERE kordensucursal in (" + intKAdmision + ")");
			while (objRst.next()) {
				kOrdenSucursalFac = objRst.getInt("kordensucursalfac");
			}
			if (kOrdenSucursalFac > 0) {
				strQuery = "select tOESF " +					
				   		   "from TOrdenExamenSucursalFac tOESF " +	
				           "where tOESF.tordensucursalfac.kordensucursalfac =  " + kOrdenSucursalFac;
				iObjLog.debug("Entrando DatosOrdenDao.buscarpersistemExamenesFac:Consulta...  " + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objListaExamenes = objQuery.list();
				if (objListaExamenes != null){
					if (objListaExamenes.size() > 0 ){
						for (int inti=0;inti<objListaExamenes.size();inti++) {
							objListaExamenesReturn.add(objConvert.convertExamenFacHBBean((TOrdenExamenSucursalFac)objListaExamenes.get(inti), "DatosOrdenDao.buscarpersistemExamenesFac"));
						}
					}
				}
				iObjLog.debug("Entrando ExamenesDao.buscarpersistemExamenesFac:Resultado...  " + objListaExamenes.size());
				//HibernateUtil.commitTrans();	 				
				iObjLog.debug("Saliendo ExamenesDao.buscarpersistemExamenesFac:Saliendo...  " + objListaExamenes.toString());
			}
			return objListaExamenesReturn;
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ExamenesDao.buscarpersistemExamenesFac: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		if (objListaExamenes != null) {
    			objListaExamenes.clear();
    		}
    		objListaExamenes = null;
    		objQuery = null;
    		objStam = null;
    		objRst = null;
    		strQuery = "";
    		HibernateUtil.closeSession();
    	}		
	}	
	
	
	public void setActualizaExamenes(BOrdenExamenFundacion objExamen) throws Exception {
		iObjSesion = HibernateUtil.getSession();		
		try {			
			iObjLog.debug("Entrando ExamenesDao.setActualizaExamenes:Entrando...  " + objExamen.toString());
            HibernateUtil.beginTrans();
        	iObjSesion.update(objExamen);
    		iObjSesion.flush();            	
			//HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo ExamenesDao.setActualizaExamenes:Saliendo...  " + objExamen.toString());
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate ExamenesDao.setActualizaExamenes: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ExamenesDao.setActualizaExamenes: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	

	public void setActualizaExamenes(TOrdenExamenSucursal objExamen) throws Exception {
		iObjSesion = HibernateUtil.getSession();		
		try {			
			iObjLog.debug("Entrando ExamenesDao.setActualizaExamenes:Entrando...  " + objExamen.toString());
            HibernateUtil.beginTrans();
        	iObjSesion.update(objExamen);
    		iObjSesion.flush();            	
			//HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo ExamenesDao.setActualizaExamenes:Saliendo...  " + objExamen.toString());
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate ExamenesDao.setActualizaExamenes: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ExamenesDao.setActualizaExamenes: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	public void setGuardaExamenes(TOrdenExamenSucursal objExamen) throws Exception {
		iObjSesion = HibernateUtil.getSession();		
		try {			
			iObjLog.debug("Entrando ExamenesDao.setGuardaExamenes:Entrando...  " + objExamen.toString());
            HibernateUtil.beginTrans();
        	iObjSesion.save(objExamen);
    		iObjSesion.flush();            	
			//HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo ExamenesDao.setGuardaExamenes:Saliendo...  " + objExamen.toString());
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate ExamenesDao.setGuardaExamenes: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ExamenesDao.setGuardaExamenes: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	public List buscarExamenSinonimoConvenio(int cConvenio,String strSinonimo) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaExamenes = null;
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando ExamenesDao.buscarExamenSinonimoConvenio:Entrando... Convenio " + cConvenio + " Sinonimo " + strSinonimo);
			HibernateUtil.beginTrans();
			strQuery = "select cECS " +					
			   		   "from CExamenConvenioSinonimo cECS " +	
			           "where cECS.cconvenio in (" + cConvenio + ") and sclavesinonimo in ('" + strSinonimo + "')";
			iObjLog.debug("Entrando DatosOrdenDao.buscarExamenSinonimoConvenio:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaExamenes = objQuery.list();
			iObjLog.debug("Saliendo ExamenesDao.buscarExamenSinonimoConvenio:Saliendo...  " + objListaExamenes.toString());
			return objListaExamenes;
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ExamenesDao.buscarExamenSinonimoConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objQuery = null;
    		HibernateUtil.closeSession();
    	}		
	}	
	
	public String[] imprimeEtiquetasZPL(String strAdmision,int uMuestra, String strClasificacioExamenes) throws Exception {
		Statement objStatement = null;
		ResultSet objResultSet = null;
		String strNombreP = null;
		String strOrden = null;
		String strkmuestra=null;
		String strFecha=null;
		String strSexo=null;
		String strEdadDias=null;
		String strEdadAnios=null;
		String strEdadMeses=null;
		String strSMuestra=null;
		String strSInsumo=null;
		String strExamenes=null;
		String strUrgencia=null;
		String strReferencia=null;
		String strHielo=null;
		String strEtiquetas="";
		String strSQL = "";
		String strInsumoContenedor="";
		String[] strReturnArray = new String[2];		
		String strWhereExamen = "";
		iObjSesion = HibernateUtil.getSession();
    	try{
    		strReturnArray[0] = "";
    		strReturnArray[1] = "";
			Connection objConn = iObjSesion.connection();				
			if (uMuestra > 0) {
				strWhereExamen = " and TOES.umuestra in (" + uMuestra + ")";
			} else {
				strWhereExamen = "";
			}
			strSQL =    
			"\nselect nvl(trim(TP.sapellidopaterno),'') || ' ' || nvl(trim(TP.sapellidomaterno),'')  || ' ' || nvl(trim(TP.snombre),'') nombrepac,		" +
			"\n        TOS.kOrdenSucursal kAdmision, 																									" +
			"\n        'S/U' snemonico, 																												" +			
			"\n        to_char(nvl(TOS.uOrden,0)) korden, 																								" +
			"\n        UPPER(nvl(trim(TOS.sSucursal),'') || trim(to_char(nvl(TOS.uOrden,0),'0000000'))) ordenfmt,										" +
			"\n        UPPER(nvl(trim(TOS.sSucursal),'') || substr(trim(to_char(nvl(TOS.uOrden,0),'0000000')),											" +
			"\n	 	 length(trim(nvl(TOS.kOrdenSucursal,0))) +1 )) ordenfmtv1, 																			" +
			"\n        ' ' urgente,																														" +
			"\n        0 hielo,																															" +
			"\n        nvl(TOES.uMuestra,0) kmuestra, 																									" +
			"\n        to_char(nvl(TOS.kOrdenSucursal,0)) kadmision, 																					" +
			"\n        to_char(TOS.dRegistro,'ddmmyy hh24:mi') dcaptura,  																				" +
			"\n        'M' sgenero, 																													" +
			"\n        to_char(floor(months_between(TOS.dRegistro,TP.dnacimiento)/12)) anios,															" +
			"\n        to_char(floor(((months_between(TOS.dRegistro,TP.dnacimiento)/12) - (floor(months_between(TOS.dRegistro,TP.dnacimiento)/12))) *12)) meses, " +
			"\n        date_part('days', TOS.dRegistro -  TP.dnacimiento ) dias,																							" +
			"\n        ' ' smuestra, 																													" +
			"\n        ' ' sinsumo, 																													" +
			"\n        CE.cExamen examenes, 																											" +
			"\n        CE.sExamen sexamenes, 																											" +
			"\n        CE.cTipoComercial ctipocomercial, 																								" +
			"\n        TOS.sMedico smedico,				 																								" +
			"\n        CEB.bbioquimica,																													" +
			"\n        CLP.sLugarProcesamiento labref																 									" +
			"\nFROM T_Orden_Sucursal TOS INNER JOIN T_Orden_Examen_Sucursal TOES ON TOS.kOrdenSucursal=TOES.kOrdenSucursal								" +			 
			"\n                          INNER JOIN T_Paciente TP ON TP.kPaciente=TOS.kPaciente	 														" +
			"\n                          INNER JOIN C_Examen CE ON CE.cExamen=TOES.cExamen AND " + strClasificacioExamenes + "							" +
			"\n						   TOS.kOrdenSucursal in (" + strAdmision + ") AND TP.bsexo=1 " + strWhereExamen + "								" +
			"\n                          INNER JOIN C_Examen_Bioquimica CEB ON CE.cExamen=CEB.cExamen 	 												" +
			"\n                          INNER JOIN C_LUGAR_PROCESAMIENTO CLP ON CLP.cLugarProcesamiento=TOES.cLugarProcesamiento						" +
			"\nUNION ALL																																" +
			"\nselect nvl(trim(TP.sapellidopaterno),'') || ' ' || nvl(trim(TP.sapellidomaterno),'')  || ' ' || nvl(trim(TP.snombre),'') nombrepac,		" +
			"\n        TOS.kOrdenSucursal kAdmision, 																									" +
			"\n        'S/U' snemonico, 																												" +
			"\n        to_char(nvl(TOS.uOrden,0)) korden, 																								" +
			"\n        UPPER(nvl(trim(TOS.sSucursal),'') || trim(to_char(nvl(TOS.uOrden,0),'0000000'))) ordenfmt,										" +
			"\n        UPPER(nvl(trim(TOS.sSucursal),'') || substr(trim(to_char(nvl(TOS.uOrden,0),'0000000')),											" +
			"\n	     length(trim(nvl(TOS.kOrdenSucursal,0))) +1 )) ordenfmtv1, 																			" +
			"\n        ' ' urgente,																														" +
			"\n        0 hielo,																															" +
			"\n        nvl(TOES.uMuestra,0) kmuestra, 																									" +
			"\n        to_char(nvl(TOS.kOrdenSucursal,0)) kadmision, 																					" +
			"\n        to_char(TOS.dRegistro,'ddmmyy hh24:mi') dcaptura,  																				" +
			"\n        'F' sgenero, 																													" +
			"\n        to_char(floor(months_between(TOS.dRegistro,TP.dnacimiento)/12)) anios,															" +
			"\n        to_char(floor(((months_between(TOS.dRegistro,TP.dnacimiento)/12) - (floor(months_between(TOS.dRegistro,TP.dnacimiento)/12))) *12)) meses, " +
			"\n        date_part('days', TOS.dRegistro -  TP.dnacimiento ) dias,																							" +
			"\n        ' ' smuestra, 																													" +
			"\n        ' ' sinsumo, 																													" +
			"\n        CE.cExamen examenes, 																											" +
			"\n        CE.sExamen sexamenes, 																											" +
			"\n        CE.cTipoComercial ctipocomercial, 																								" +
			"\n        TOS.sMedico smedico,				 																								" +
			"\n        CEB.bbioquimica,																													" +
			"\n        CLP.sLugarProcesamiento labref																 									" +
			"\nFROM T_Orden_Sucursal TOS INNER JOIN T_Orden_Examen_Sucursal TOES ON TOS.kOrdenSucursal=TOES.kOrdenSucursal								" +			 
			"\n                          INNER JOIN T_Paciente TP ON TP.kPaciente=TOS.kPaciente	 														" +
			"\n                          INNER JOIN C_Examen CE ON CE.cExamen=TOES.cExamen AND " + strClasificacioExamenes + "							" +
			"\n						   TOS.kOrdenSucursal in (" + strAdmision + ") AND TP.bsexo=0 " + strWhereExamen + "								" +
			"\n                          INNER JOIN C_Examen_Bioquimica CEB ON CE.cExamen=CEB.cExamen 	 												" +
			"\n                          INNER JOIN C_LUGAR_PROCESAMIENTO CLP ON CLP.cLugarProcesamiento=TOES.cLugarProcesamiento						";
			objStatement = objConn.createStatement();
			iObjLog.debug("MReporteFacturaOrdenAction.doEtiquetasZPL:Consulta......." + strSQL );
			objResultSet = objStatement.executeQuery(strSQL);
			iObjLog.debug("Query de etiquetas"+strSQL);
			if(objResultSet != null) {
				String strUrgente = "";
				String strCodigoBarras = "";
				boolean envioBioquimica = false;
				int kAdmision = 0;
				int uExamenes = 0;
				int cTipoComercial = 0;
				String strMedico = "";
				while(objResultSet.next()) {
					uExamenes++;
					strNombreP = objResultSet.getString("nombrepac");
					strOrden =objResultSet.getString("ordenfmt"); 
					strkmuestra=objResultSet.getString("kmuestra");
					strFecha=objResultSet.getString("dcaptura");
					strSexo=objResultSet.getString("sgenero");
					strEdadDias=objResultSet.getString("dias");
					strEdadAnios=objResultSet.getString("anios");
					strEdadMeses=objResultSet.getString("meses");					
					strSMuestra=objResultSet.getString("smuestra");
					strSInsumo=objResultSet.getString("sinsumo");
					strExamenes=objResultSet.getString("examenes") + " " + objResultSet.getString("sexamenes");
					strUrgencia=objResultSet.getString("urgente");
					strReferencia=objResultSet.getString("labref");
					strHielo=objResultSet.getString("hielo");
					cTipoComercial=objResultSet.getInt("ctipocomercial");
					strMedico=objResultSet.getString("smedico");
					envioBioquimica=objResultSet.getBoolean("bbioquimica"); 
					kAdmision=objResultSet.getInt("kAdmision");
					
					if (strExamenes.length()>29) {
						strExamenes = "^FO24,160^AD^FD"+strExamenes.substring(0,29)+"^FS " + 
									  "^FO24,180^AD^FD"+strExamenes.substring(30)+"^FS ";
					} else {
						strExamenes = "^FO24,160^AD^FD"+strExamenes+"^FS ";
					}
//					if (strImpOrden.equals("1")) {
//						strCodigoBarras = strOrden;	
//					} else {
//						strCodigoBarras = strkmuestra;								
						strCodigoBarras = "" + kAdmision;														
//					}
					if (envioBioquimica == true) {
						strCodigoBarras = ("1" + strCodigoBarras);
					}
					String strEdadCodigo = "";
					if (Integer.parseInt(strEdadAnios)>0) {
						strEdadCodigo = strEdadAnios + "A";
					} else if (Integer.parseInt(strEdadMeses)>0) {
						strEdadCodigo = strEdadMeses + "M";						
					} else {
						strEdadCodigo = strEdadDias + "D";						
					}
					if (cTipoComercial == 2) {
						//GABINETES
						strInsumoContenedor = (strSexo+" "+strEdadCodigo+" Dr "+strMedico);						
					} else {
						strInsumoContenedor = (strSexo+" "+strEdadCodigo+" "+strSMuestra+":"+strSInsumo);
					}
					strEtiquetas += "^XA " +
									"^LH5,10 " +
									"^FO24,10^AD^FD"+strNombreP+"^FS " + strUrgente + strReferencia +strHielo+
									"^FO40,30^BY2,2.0:1^B3N,N,80,N^FD"+strCodigoBarras+"^FS " +
									"^FO24,120^AD^FD"+strOrden+" "+strCodigoBarras+" " + strFecha + "^FS " +
									"^FO24,140^AD^FD"+strInsumoContenedor+"^FS " +
									strExamenes +
									"^XZ";				
					if (uExamenes <= 7) {
						strReturnArray[0] = strEtiquetas;
						if (uExamenes == 7) {
							strEtiquetas = "";							
						}
					} else {					
						strReturnArray[1] = strEtiquetas;						
					}
				}
				objResultSet.close();
			}		
		} catch (Exception aObjExcepcion) { 
    	    iObjLog.error("ExamenesDao.imprimeEtiquetasZPL:Exception....", aObjExcepcion);
    	    throw aObjExcepcion;
		} finally{
	    	HibernateUtil.closeSession();
		}		
	    iObjLog.debug("ExamenesDao.imprimeEtiquetasZPL:Exception....0   " + strReturnArray[0]);
	    iObjLog.debug("ExamenesDao.imprimeEtiquetasZPL:Exception....1   " + strReturnArray[1]);
		return strReturnArray;
	}		

	
	public List informacionExamen(String strExamenenes) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		OrdenExamenBean objExamen = null;
		String strSQL = "";
		List lstExamenes = new ArrayList();
		iObjSesion = HibernateUtil.getSession();
    	try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			strSQL = "SELECT ce.cexamen,    			\n" +
					 "		 ce.sexamen,				\n" +
					 "		 eec.sindicacionpaciente,	\n" +
					 "		 eec.stipomuestra,			\n" +
					 "		 eec.sinsumo,				\n" +
					 "		 eec.sindicaciontomador,	\n" +
					 "		 eec.stemperaturamuestra,	\n" +
					 "		 eec.smotivorechazo			\n" +
					 "FROM E_EXAMEN_CONFIGURACION eec 	\n" +
					 "	INNER JOIN C_EXAMEN ce 			\n" +
					 "	ON eec.cexamen=ce.cexamen 		\n" +
					 "WHERE ce.cexamen IN (" + strExamenenes + ")";
 			iObjLog.debug("ExamenesDao.informacionExamen:Consulta......." + strSQL);
			rst = objStatement.executeQuery(strSQL);
			if(rst != null) {
				while(rst.next()) {
					objExamen = new OrdenExamenBean();
					objExamen.setCexamen(rst.getInt("cexamen"));
					objExamen.setSexamen(rst.getString("sexamen"));
					objExamen.setSindicacionpaciente(rst.getString("sindicacionpaciente"));
					objExamen.setSindicaciontomador(rst.getString("sindicaciontomador"));
					objExamen.setSinsumo(rst.getString("sinsumo"));
					objExamen.setSmotivorechazo(rst.getString("smotivorechazo"));
					objExamen.setStemperaturamuestra(rst.getString("stemperaturamuestra"));
					objExamen.setStipomuestra(rst.getString("stipomuestra"));
					lstExamenes.add(objExamen);
				}				
				rst.close();
			}		
		} catch (Exception aObjExcepcion) { 
    	    iObjLog.error("ExamenesDao.informacionExamen:Exception....", aObjExcepcion);
    	    throw aObjExcepcion;
		} finally{
			objStatement = null;
			rst = null;
	    	HibernateUtil.closeSession();
		}		
	    iObjLog.debug("ExamenesDao.informacionExamen:....   " + lstExamenes.size());
		return lstExamenes;
	}			

	public String getSinonimoExamenConvenio(int cConvenio, int cExamen) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		String strSQL = "";		
		iObjSesion = HibernateUtil.getSession();
	    iObjLog.debug("Entrando ExamenesDao.getSinonimoExamenConvenio:....   " + strSQL);
    	try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			strSQL = "SELECT SCLAVESINONIMO,SNOMBRESINONIMO			\n" +
					 "FROM C_EXAMEN_CONVENIO_SINONIMO CEXS			\n" +
					 "WHERE CEXS.CEXAMEN IN (" + cExamen + ") AND	\n" +
					 "		CEXS.CCONVENIO IN (" + cConvenio + ")";
 			iObjLog.debug("ExamenesDao.getSinonimoExamenConvenio:Consulta......." + strSQL);
			rst = objStatement.executeQuery(strSQL);
			strSQL = "";
			if(rst != null) {
				while(rst.next()) {
					strSQL = rst.getString("SCLAVESINONIMO").trim();
				}				
				rst.close();
			}		
		} catch (Exception aObjExcepcion) { 
    	    iObjLog.error("ExamenesDao.getSinonimoExamenConvenio:Exception....", aObjExcepcion);
    	    throw aObjExcepcion;
		} finally{
			if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
			if (rst != null) {
				rst.close();
				rst = null;
			}
	    	HibernateUtil.closeSession();
		}		
	    iObjLog.debug("Saliendo ExamenesDao.getSinonimoExamenConvenio:....   " + strSQL);
		return strSQL;
	}
	
    private double redodedoDouble0(double nD) {
		return Math.round(nD*Math.pow(10,0))/Math.pow(10,0);      	    
	}
    
    private double redodedoDouble2(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }
    
    private double redodedoDouble6(double nD) {
		return Math.round(nD*Math.pow(10,6))/Math.pow(10,6);      	
    }

    
}
