package mx.com.web2lab.backend.dao.laboratorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import mx.com.web2lab.backend.beans.tiemposmovimientos.OrdenExamenTomaMuestraBean;
import mx.com.web2lab.backend.beans.tiemposmovimientos.OrdenTomaMuestraBean;
import mx.com.web2lab.backend.beans.tiemposmovimientos.PacienteTomaMuestraBean;
import mx.com.web2lab.backend.beans.tools.ConvertBeanvsHB;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursalFac;
import mx.com.web2lab.backend.util.Formatos;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TomaMuestrasDao {

	private static Log iObjLog = LogFactory.getLog(TomaMuestrasDao.class);
	    
	private Session iObjSesion = null;
	
	public TomaMuestrasDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public String inicioTomaMuestra(String kOrdenSucursal,String strUsuario, String strExamen,int uestaciontoma) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		String strReturn = "";
		String strLaboratorio = "";
		iObjLog.debug("Entrando TomaMuestrasDao.inicioTomaMuestra:...  " + kOrdenSucursal + " " + strUsuario);
    	try{            
//    		if (bolLaboratorio) {
//    			strLaboratorio = " ce.ctipocomercial <> 2 ";
//    		} else {
//    			strLaboratorio = " ce.ctipocomercial = 2 ";
//    		}
			strLaboratorio = " ce.uestaciontomatlalpan = " + uestaciontoma + " \n";
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();	        
			strQuery =	"SELECT tos.kordensucursal admision,																					\n"+
						"       nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente		\n"+
						"FROM T_ORDEN_SUCURSAL tos INNER JOIN T_ORDEN_EXAMEN_SUCURSAL toes ON tos.kordensucursal=toes.kordensucursal			\n"+
						"     INNER JOIN C_EXAMEN ce ON toes.cexamen=ce.cexamen																	\n"+
						"     INNER JOIN T_PACIENTE tp ON tos.kpaciente=tp.kpaciente 															\n"+
						"WHERE extract(epoch from toes.dtomamuestratermino-toes.dtomamuestrainicio)/60 < 1 	and 								\n"+
						"	   toes.slogin_name in ('" + strUsuario + "') 									and									\n"+
						"	   toes.kordensucursal not in (" + kOrdenSucursal + ")							and									\n"+
						"	   " + strLaboratorio + " 																							\n"+
						"UNION ALL																												\n"+
						"SELECT 0 admision,																										\n"+
						"       last_name || ' ' || first_name																					\n"+
						"FROM TURBINE_USER 																										\n"+
						"WHERE login_name = ('" + strUsuario + "') 																				\n"+
						"ORDER BY admision desc																									 ";							
			iObjLog.debug("Consulta TomaMuestrasDao.inicioTomaMuestra:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				iObjLog.debug("Consulta TomaMuestrasDao.inicioTomaMuestra:...  1");
				strReturn = "No existe el usuario indicado";
				while(objResultSet.next()) {
					if (objResultSet.getInt("admision") == 0) {
						strReturn = "";
						break;
					} else {
						strReturn = "Debe cerrar la atencion al Paciente " + objResultSet.getString("spaciente") + " de la orden " + objResultSet.getString("admision");
						break;
					}
				}
			}
			objResultSet.close();	
			if (strReturn.trim().length() < 1) {
//	    		if (bolLaboratorio) {
	    			strLaboratorio = " AND CEXAMEN IN (SELECT CEXAMEN FROM C_EXAMEN WHERE uestaciontomatlalpan = " + uestaciontoma + ") ";
//	    		} else {
//	    			strLaboratorio = " AND CEXAMEN IN (SELECT CEXAMEN FROM C_EXAMEN WHERE uestaciontomatlalpan = " + uestaciontoma + ")";
//	    		}				
				strQuery =	"UPDATE T_ORDEN_EXAMEN_SUCURSAL													\n" +
							"SET dtomamuestrainicio=sysdate,slogin_name='" + strUsuario  + "' 				\n" +
							"WHERE kordensucursal in (" + kOrdenSucursal +") 													AND \n" +
							"	   extract(epoch from dtomamuestratermino-dtomamuestrainicio)/60 < 1 							AND	\n" +	
							"	   (dtomamuestratermino not between (sysdate)-60											 		\n" +
						"										and (sysdate)-60											 	AND	\n" +
							"	   length(trim(slogin_name)) < 2 " + strExamen + strLaboratorio;
				iObjLog.debug("Consulta TomaMuestrasDao.inicioTomaMuestra:...  " + strQuery);				
				objSta.execute(strQuery);
				objSta.execute("COMMIT;");
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TomaMuestrasDao.inicioTomaMuestra: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
    	return strReturn;
	}		

	
	public void cambioFechaTomaMuestra(int kOrdenSucursal,String strUsuario, String strExamen, String strNuevaFecha) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		List objListaExamenes = null;
		TOrdenExamenSucursal objTOrdenExamenSucursal = null;
		String strQuery = "";
		iObjLog.debug("Entrando TomaMuestrasDao.cambioFechaTomaMuestra:...  " + kOrdenSucursal + " " + strUsuario);
    	try{            
			strQuery = "select tOES " +					
			   		   "from TOrdenExamenSucursal tOES " +	
			           "where tOES.tordensucursal.kordensucursal = " + kOrdenSucursal + " and tOES.cexamen.cexamen = " + strExamen;
			iObjLog.debug("Entrando TomaMuestrasDao.cambioFechaTomaMuestra:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaExamenes = objQuery.list();			
			if (objListaExamenes != null){
				if (objListaExamenes.size() > 0 ){
					objTOrdenExamenSucursal = (TOrdenExamenSucursal)objListaExamenes.get(0);
					objTOrdenExamenSucursal.setDtomamuestrainicio(new Formatos().getFecha(strNuevaFecha));
					objTOrdenExamenSucursal.setDtomamuestratermino(new Formatos().getFecha(strNuevaFecha));
					iObjSesion.update(objTOrdenExamenSucursal);
		    		iObjSesion.flush();            	
				}
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TomaMuestrasDao.cambioFechaTomaMuestra: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	objQuery = null;
        	objListaExamenes = null;
        	objTOrdenExamenSucursal = null;
        	HibernateUtil.closeSession();
        }
	}		
	

	public String tomaMuestraPendiente(int kOrdenExamenSucursal, String sUsuario, boolean bolTomaPendiente) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		List objListaExamenes = null;
		TOrdenExamenSucursal objTOrdenExamenSucursal = null;
		String strQuery = "";
		String strReturn = "";
		iObjLog.debug("Entrando TomaMuestrasDao.tomaMuestraPendiente:...  " + kOrdenExamenSucursal + " " + sUsuario);
    	try{            
			strQuery = "select tOES " +					
			   		   "from TOrdenExamenSucursal tOES " +	
			           "where tOES.kordenexamensucursal = " + kOrdenExamenSucursal;
			iObjLog.debug("Entrando TomaMuestrasDao.tomaMuestraPendiente:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaExamenes = objQuery.list();			
			if (objListaExamenes != null){
				if (objListaExamenes.size() > 0) {
					objTOrdenExamenSucursal = (TOrdenExamenSucursal)objListaExamenes.get(0);
					iObjLog.debug("Entrando TomaMuestrasDao.tomaMuestraPendiente:...Consulta  after: " + objTOrdenExamenSucursal.getDtomamuestratermino().after(objTOrdenExamenSucursal.getDtomamuestrainicio()) + " before: " + objTOrdenExamenSucursal.getDtomamuestratermino().before(objTOrdenExamenSucursal.getDtomamuestrainicio()));
					if ((objTOrdenExamenSucursal.getSlogin_name().trim().length() < 1) || objTOrdenExamenSucursal.getDtomamuestratermino().before(objTOrdenExamenSucursal.getDtomamuestrainicio())) {
						if (bolTomaPendiente) {
							objTOrdenExamenSucursal.setDtomamuestrainicio(new Formatos().getFecha("01-01-2012"));
							objTOrdenExamenSucursal.setDtomamuestratermino(new Formatos().getFecha("01-01-2012"));
							objTOrdenExamenSucursal.setSlogin_name("");
						} else {
							objTOrdenExamenSucursal.setDtomamuestrainicio(new Date());
							objTOrdenExamenSucursal.setDtomamuestratermino(new Date());
							objTOrdenExamenSucursal.setSlogin_name("");
						}
						iObjSesion.update(objTOrdenExamenSucursal);
			    		iObjSesion.flush();  
			    		strReturn = "Actualizacion Realizada";
					} else {
			    		strReturn = "No es posible realizar la Actualizacion";						
					}
				} else {
		    		strReturn = "No es posible realizar la Actualizacion";
				}
			} else {
	    		strReturn = "No es posible realizar la Actualizacion";
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TomaMuestrasDao.tomaMuestraPendiente: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	objQuery = null;
        	objListaExamenes = null;
        	objTOrdenExamenSucursal = null;
        	HibernateUtil.closeSession();
        } 
    	return strReturn;
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
	
	
	public void terminoTomaMuestra(int kOrdenSucursal,String strUsuario,int uSalaToma) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		String strQuery = "";
		String strLaboratorio = "";
		iObjLog.debug("Entrando TomaMuestrasDao.terminoTomaMuestra:...  " + kOrdenSucursal + " " + strUsuario);
    	try{            
//    		if (bolLaboratorio) {
    			strLaboratorio = " AND CEXAMEN IN (SELECT CEXAMEN FROM C_EXAMEN WHERE uestaciontomatlalpan = " + uSalaToma + ") ";
//    		} else {
//    			strLaboratorio = " AND CEXAMEN IN (SELECT CEXAMEN FROM C_EXAMEN WHERE uestaciontomatlalpan = " + uSalaToma + ")";
//    		}
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();	        	        
			strQuery =	"UPDATE T_ORDEN_EXAMEN_SUCURSAL																			\n" +
						"SET dtomamuestratermino=sysdate,slogin_name='" + strUsuario  + "'										\n" +
						"WHERE kordensucursal in (" + kOrdenSucursal +")	AND													\n" +
						"	   length(trim(slogin_name)) > 0				AND													\n" +
						"	   (dtomamuestratermino not between (sysdate)-60											 		\n" +
						"									and (sysdate)-60											 	AND	\n" +
						"	   extract(epoch from dtomamuestratermino-dtomamuestrainicio)/60 < 1 	\n" + strLaboratorio;	
			iObjLog.debug("Consulta TomaMuestrasDao.terminoTomaMuestra:...  " + strQuery);
			objSta.execute(strQuery);
			objSta.execute("COMMIT;");
//    		if (bolLaboratorio) {
    			strLaboratorio = " CEXAMEN IN (SELECT CEXAMEN FROM C_EXAMEN WHERE uestaciontomatlalpan <> " + uSalaToma + ") ";
//    		} else {
//    			strLaboratorio = " AND CEXAMEN IN (SELECT CEXAMEN FROM C_EXAMEN WHERE ctipocomercial <> 2)";
//    		}
			strQuery =	"UPDATE T_ORDEN_EXAMEN_SUCURSAL																			\n" +
						"SET dtomamuestrainicio=sysdate,dtomamuestratermino=sysdate												\n" +
						"WHERE kordensucursal in (" + kOrdenSucursal +")													AND	\n" +
						"	   (dtomamuestratermino not between (sysdate)-60											 		\n" +
						"									and (sysdate)-60											 	AND	\n" +
						"	   length(trim(slogin_name)) = 0				AND						\n" + strLaboratorio;
//						"	   extract(epoch from dtomamuestratermino-dtomamuestrainicio)/60 < 1 	\n" + strLaboratorio;	
			iObjLog.debug("Consulta TomaMuestrasDao.terminoTomaMuestra:...  " + strQuery);
			objSta.execute(strQuery);
			objSta.execute("COMMIT;");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TomaMuestrasDao.terminoTomaMuestra: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
        }
	}		
	
	
	public String getOrdenesTomaMuestra(int intSucursal,int uestaciontoma, int kOrdenSucursalORuConsecutivo) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		PacienteTomaMuestraBean objPacienteTomaMuestraBean = null;
		OrdenTomaMuestraBean objOrdenTomaMuestraBean = null;
		OrdenExamenTomaMuestraBean objOrdenExamenTomaMuestraBean = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		String strPrint[] = {" "," "," "};
		iObjLog.debug("Entrando TomaMuestrasDao.getOrdenesTomaMuestra:...  " + intSucursal);
		List lstPacientes = new ArrayList(); 
		try{            
				objCon = iObjSesion.connection();
			    objSta = objCon.createStatement();	        
				strQuery = this.getConsultaOrdenTomaMuestra(intSucursal,uestaciontoma, kOrdenSucursalORuConsecutivo);
				iObjLog.debug("Consulta TomaMuestrasDao.getOrdenesTomaMuestra:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				strPrint[0] = this.getEncabezadoOrdenesSinPago();
				if (objResultSet != null) {					
					iObjLog.debug("Consulta TomaMuestrasDao.getOrdenesTomaMuestra:...  1");
					while(objResultSet.next()) {
						iObjLog.debug("Consulta TomaMuestrasDao.getOrdenesTomaMuestra:...  2");
						for(int inti = 0;inti<lstPacientes.size();inti++) {
							objPacienteTomaMuestraBean = (PacienteTomaMuestraBean)lstPacientes.get(inti);
							if (objPacienteTomaMuestraBean.getKpaciente() == objResultSet.getInt("kpaciente")) {
								for (int inty = 0;inty<objPacienteTomaMuestraBean.getLstOrdenes().size();inty++) {
									objOrdenTomaMuestraBean = (OrdenTomaMuestraBean)objPacienteTomaMuestraBean.getLstOrdenes().get(inty);
									if (objOrdenTomaMuestraBean.getKadmision() == objResultSet.getInt("admision")) {
										objOrdenTomaMuestraBean.addExamen(objResultSet);
										break;
									} else {
										objOrdenTomaMuestraBean = null;
									}
								}
								if (objOrdenTomaMuestraBean == null) {
									objPacienteTomaMuestraBean.addOrden(objResultSet,uestaciontoma);
								}
								break;
							} else {
								objPacienteTomaMuestraBean = null;
							}			
						}
						if (objPacienteTomaMuestraBean == null) {
							objPacienteTomaMuestraBean = new PacienteTomaMuestraBean();
							objPacienteTomaMuestraBean.addPaciente(objResultSet,uestaciontoma);
							lstPacientes.add(objPacienteTomaMuestraBean);
						}
					}					
				}
				String[] strClass = {"tr1","tr2"};
				int uClass = 0;
				for(int inti = 0;inti<lstPacientes.size();inti++) {
					objPacienteTomaMuestraBean = (PacienteTomaMuestraBean)lstPacientes.get(inti);
					strPrint[objPacienteTomaMuestraBean.getPrintPosicion()] = strPrint[objPacienteTomaMuestraBean.getPrintPosicion()] + objPacienteTomaMuestraBean.getRowPaciente(strClass[uClass]);								
					for (int inty = 0;inty<objPacienteTomaMuestraBean.getLstOrdenes().size();inty++) {
						objOrdenTomaMuestraBean = (OrdenTomaMuestraBean)objPacienteTomaMuestraBean.getLstOrdenes().get(inty);
						strPrint[objPacienteTomaMuestraBean.getPrintPosicion()] = strPrint[objPacienteTomaMuestraBean.getPrintPosicion()] + objOrdenTomaMuestraBean.getRowOrden(strClass[uClass]);							
						for (int intz = 0;intz<objOrdenTomaMuestraBean.getLstExamenes().size();intz++) {
							objOrdenExamenTomaMuestraBean = (OrdenExamenTomaMuestraBean)objOrdenTomaMuestraBean.getLstExamenes().get(intz);
							strPrint[objPacienteTomaMuestraBean.getPrintPosicion()] = strPrint[objPacienteTomaMuestraBean.getPrintPosicion()] + objOrdenExamenTomaMuestraBean.getRowExamenes(objOrdenTomaMuestraBean,strClass[uClass]);							
						}
					}
					if (uClass > 0){
						uClass = 0;
					} else {
						uClass = 1;						
					}
				}
				strQuery = strPrint[0]+ strPrint[1] + strPrint[2]+ "</table>";								
				iObjLog.debug("Saliendo TomaMuestrasDao.getOrdenesTomaMuestra:...  ");
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TomaMuestrasDao.getOrdenesTomaMuestra: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
//    		strQuery = null;
    		objPacienteTomaMuestraBean = null;
    		objOrdenTomaMuestraBean = null;
    		objOrdenExamenTomaMuestraBean = null;
        }
	}		


	private String getConsultaOrdenTomaMuestra(int intSucursal,int uestaciontoma, int kOrdenSucursalORuConsecutivo) {
		String strLaboratorio = " ce.uestaciontomatlalpan = " + uestaciontoma + " and \n";
		String strOrdenConsecutivo = "";
		String strQuery = "";
		Formatos objFormatos = new Formatos();
		try {
				if (kOrdenSucursalORuConsecutivo > 0) {
					strOrdenConsecutivo =	"UNION ALL																													\n"+
											"SELECT  tos.uorden orden,tos.kordensucursal admision,																		\n"+
											"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 								\n"+
											"       to_char(tos.dregistro,'dd-mm-yyyy hh24:mi') captura,																\n"+		
											"       to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,																\n"+
											"       to_char(toes.dtomamuestrainicio,'dd-mm-yyyy hh24:mi') fechatomamuestra,												\n"+		
											"       nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,		\n"+
											"       0 burgente,																											\n"+
											"       cs.snombresucursal  sunidad,																						\n"+
											"       cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,													\n"+
											"       tu.first_name||' '||tu.last_name capturo,																			\n"+
											"       ce.cexamen,																											\n"+
											"		ce.sexamen,																											\n"+
											"       toes.umuestra,																										\n"+	
											"       (extract(epoch from sysdate-tos.dregistro)/60)  minutos,                             								\n"+
											"		to_char(age(sysdate ,toes.dtomamuestrainicio),'hh24:mi:ss') tiempoespera,											\n"+
											"		toes.slogin_name, 																									\n"+		
											"		turu.first_name || ' ' || turu.last_name as tomador, 																\n"+
											"		tos.kpaciente kpaciente, 																							\n"+											
											"       ((((extract(epoch from sysdate-dnacimiento)/60)/60)/24)/365)  anos,                            						\n"+
											"		tp.utipopaciente,		 																							\n"+											
											"		toes.kordenexamensucursal		 																					\n"+											
											"FROM T_ORDEN_SUCURSAL tos INNER JOIN T_ORDEN_EXAMEN_SUCURSAL toes ON tos.kordensucursal=toes.kordensucursal				\n"+
											"     INNER JOIN C_EXAMEN ce ON toes.cexamen=ce.cexamen																		\n"+
											"     INNER JOIN C_SUCURSAL cs ON tos.csucursal=cs.csucursal																\n"+
											"     INNER JOIN TURBINE_USER tu ON tos.user_id=tu.user_id																	\n"+
											"     INNER JOIN T_PACIENTE tp ON tos.kpaciente=tp.kpaciente 																\n"+
											"     INNER JOIN C_CONVENIO cc ON tos.cconvenio=cc.cconvenio																\n"+
											"     LEFT JOIN TURBINE_USER turu ON toes.slogin_name=turu.login_name														\n"+						
											"WHERE tos.csucursal in (" + intSucursal + ") 										and 									\n"+
											"	   tos.cestadoregistro not in (16,17)											and										\n"+	
											"	   extract(epoch from toes.dtomamuestratermino-toes.dtomamuestrainicio)/60 < 1 	and 									\n"+
												   strLaboratorio +
											"      (tos.kordensucursal = " + kOrdenSucursalORuConsecutivo + " or tos.uorden = " + kOrdenSucursalORuConsecutivo + ") ";
				} else {
					strOrdenConsecutivo = "";
				}	
//    OMRR 22 de Mayo del 2013 Activacion de Satelite con Tikets				
//			    if (intSucursal == 12) {
//					strQuery =	"SELECT  tos.uorden orden,tos.kordensucursal admision,																		\n"+
//								"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 								\n"+
//								"       to_char(tos.dregistro,'dd-mm-yyyy hh24:mi') captura,																\n"+		
//								"       to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,																\n"+
//								"       to_char(toes.dtomamuestrainicio,'dd-mm-yyyy hh24:mi') fechatomamuestra,  											\n"+		
//								"       nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,		\n"+
//								"       0 burgente,																											\n"+
//								"       cs.snombresucursal  sunidad,																						\n"+
//								"       cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,													\n"+
//								"       tu.first_name||' '||tu.last_name capturo,																			\n"+
//								"       ce.cexamen,																											\n"+
//								"		ce.sexamen,																											\n"+
//								"       toes.umuestra,																										\n"+	
//			//						"       (extract(epoch from sysdate-tos.dregistro)/60)  minutos,                             								\n"+
//								"       (extract(epoch from sysdate-toes.dtomamuestrainicio)/60)  minutos,                             						\n"+
//								"		to_char(age(sysdate ,toes.dtomamuestrainicio),'hh24:mi:ss') tiempoespera,											\n"+
//								"		toes.slogin_name, 																									\n"+		
//								"		turu.first_name || ' ' || turu.last_name as tomador, 																\n"+
//								"		tos.kpaciente kpaciente, 																							\n"+											
//								"       ((((extract(epoch from sysdate-dnacimiento)/60)/60)/24)/365)  anos,                            						\n"+
//								"		tp.utipopaciente,		 																							\n"+											
//								"		toes.kordenexamensucursal		 																					\n"+											
//								"FROM T_ORDEN_SUCURSAL tos INNER JOIN T_ORDEN_EXAMEN_SUCURSAL toes ON tos.kordensucursal=toes.kordensucursal				\n"+
//								"     INNER JOIN C_EXAMEN ce ON toes.cexamen=ce.cexamen																		\n"+
//								"     INNER JOIN C_SUCURSAL cs ON tos.csucursal=cs.csucursal																\n"+
//								"     INNER JOIN TURBINE_USER tu ON tos.user_id=tu.user_id																	\n"+
//								"     INNER JOIN T_PACIENTE tp ON tos.kpaciente=tp.kpaciente 																\n"+
//								"     INNER JOIN C_CONVENIO cc ON tos.cconvenio=cc.cconvenio																\n"+
//								"     LEFT JOIN TURBINE_USER turu ON toes.slogin_name=turu.login_name														\n"+						
//								"WHERE tos.csucursal in (" + intSucursal + ") 										and 									\n"+
//								"	   tos.cestadoregistro not in (16,17)											and										\n"+	
//								"	   extract(epoch from toes.dtomamuestratermino-toes.dtomamuestrainicio)/60 < 1 	and 									\n"+
//								"      extract(epoch from sysdate-toes.dtomamuestrainicio)/60 > 0	 				and										\n"+
//									   strLaboratorio +
//								"      (toes.dtomamuestrainicio between to_date('" + objFormatos.getFechaActual() + " 00:00:00', 'dd-mm-yyyy hh24:mi:ss')	\n"+
//								"			                        and to_date('" + objFormatos.getFechaActual() + " 23:59:59', 'dd-mm-yyyy hh24:mi:ss')) 	\n"+
//								"		" + strOrdenConsecutivo + "																							\n"+		
//								"order by minutos desc,admision,slogin_name desc																							  ";
//			    } else {	        	
					strQuery =	"SELECT  tos.uorden orden,tos.kordensucursal admision,																		\n"+
								"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 								\n"+
								"       to_char(tos.dregistro,'dd-mm-yyyy hh24:mi') captura,																\n"+		
								"       to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,																\n"+
								"       to_char(toes.dtomamuestrainicio,'dd-mm-yyyy hh24:mi') fechatomamuestra,  											\n"+		
								"       nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,		\n"+
								"       0 burgente,																											\n"+
								"       cs.snombresucursal  sunidad,																						\n"+
								"       cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,													\n"+
								"       tu.first_name||' '||tu.last_name capturo,																			\n"+
								"       ce.cexamen,																											\n"+
								"		ce.sexamen,																											\n"+
								"       toes.umuestra,																										\n"+	
			//						"       (extract(epoch from sysdate-tos.dregistro)/60)  minutos,                             								\n"+
								"       (extract(epoch from sysdate-toes.dtomamuestrainicio)/60)  minutos,                             						\n"+
								"		to_char(age(sysdate ,toes.dtomamuestrainicio),'hh24:mi:ss') tiempoespera,											\n"+
								"		toes.slogin_name, 																									\n"+		
								"		turu.first_name || ' ' || turu.last_name as tomador, 																\n"+
								"		tos.kpaciente kpaciente, 																							\n"+											
								"       ((((extract(epoch from sysdate-dnacimiento)/60)/60)/24)/365)  anos,                            						\n"+
								"		tp.utipopaciente,		 																							\n"+											
								"		toes.kordenexamensucursal		 																					\n"+											
								"FROM T_ORDEN_SUCURSAL tos INNER JOIN T_ORDEN_EXAMEN_SUCURSAL toes ON tos.kordensucursal=toes.kordensucursal				\n"+
								"     INNER JOIN C_EXAMEN ce ON toes.cexamen=ce.cexamen																		\n"+
								"     INNER JOIN C_SUCURSAL cs ON tos.csucursal=cs.csucursal																\n"+
								"     INNER JOIN TURBINE_USER tu ON tos.user_id=tu.user_id																	\n"+
								"     INNER JOIN T_PACIENTE tp ON tos.kpaciente=tp.kpaciente 																\n"+
								"     INNER JOIN C_CONVENIO cc ON tos.cconvenio=cc.cconvenio																\n"+
								"     INNER JOIN T_TICKET_SUCURSAL tts ON tts.kordensucursal=tos.kordensucursal												\n"+
								"     LEFT JOIN TURBINE_USER turu ON toes.slogin_name=turu.login_name														\n"+						
								"WHERE tos.csucursal in (" + intSucursal + ") 										and 									\n"+
								"	   tos.cestadoregistro not in (16,17)											and										\n"+	
								"	   extract(epoch from toes.dtomamuestratermino-toes.dtomamuestrainicio)/60 < 1 	and 									\n"+
								"      extract(epoch from sysdate-toes.dtomamuestrainicio)/60 > 0	 				and										\n"+
								"		(get_saldo(tos.kordensucursal)< tos.mpagopaciente or tos.mpagopaciente=0)   and 									\n"+
								"		tts.cestadoregistro in (65)   												and 									\n"+
									   strLaboratorio +
								"      (toes.dtomamuestrainicio between to_date('" + objFormatos.getFechaActual() + " 00:00:00', 'dd-mm-yyyy hh24:mi:ss')	\n"+
								"			                        and to_date('" + objFormatos.getFechaActual() + " 23:59:59', 'dd-mm-yyyy hh24:mi:ss')) 	\n"+
								"		" + strOrdenConsecutivo + "																							\n"+		
								"order by minutos desc,admision,slogin_name desc																							  ";
//			    }
		} catch (Exception exp) {
			
		} finally {
			strLaboratorio = null;
			strOrdenConsecutivo = null;
			objFormatos = null;
		}
	    return strQuery;
	}
	
	public String validaAtencionPacienteOtraArea(int kOrdenSucursal,int uLaboratorio) throws Exception {		
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		iObjLog.debug("Entrando TomaMuestrasDao.validaAtencionPaciente:...  " + kOrdenSucursal);
		String strLaboratorio = "";
    	try{            
			iObjSesion = HibernateUtil.getSession();
			strLaboratorio = " ce.uestaciontomatlalpan not in (" + uLaboratorio + ")  \n";
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();	        
			strQuery =	"SELECT tos.uorden orden,																								\n"+
					    "		tos.kordensucursal admision,																					\n"+
						"		toes.slogin_name, 																								\n"+		
						"		turu.first_name || ' ' || turu.last_name as tomador 															\n"+
						"FROM T_ORDEN_SUCURSAL tos INNER JOIN T_ORDEN_EXAMEN_SUCURSAL toes ON tos.kordensucursal=toes.kordensucursal			\n"+
						"     INNER JOIN C_EXAMEN ce ON toes.cexamen=ce.cexamen																	\n"+
						"     LEFT JOIN TURBINE_USER turu ON toes.slogin_name=turu.login_name													\n"+
						"WHERE tos.kordensucursal in (" + kOrdenSucursal + ") 								and 								\n"+
						"	   extract(epoch from toes.dtomamuestratermino-toes.dtomamuestrainicio)/60 < 1 	and 								\n"+
							   strLaboratorio +
						"order by toes.kordenexamensucursal																						";
				iObjLog.debug("Consulta TomaMuestrasDao.validaAtencionPaciente:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				strQuery = "";
				if (objResultSet != null) {					
					while(objResultSet.next()) {
						if (objResultSet.getString("slogin_name").trim().length() > 2) {
							strQuery = objResultSet.getString("tomador").trim();
						}
					}
				}
				iObjLog.debug("Saliendo TomaMuestrasDao.validaAtencionPaciente:...  ");
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TomaMuestrasDao.validaAtencionPaciente: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
    		objSta = null;
    		objResultSet = null;
        }
	}		
	
	private String getEncabezadoOrdenesSinPago() {
		return ("<table align='center' style='width: 883px' class='tabla'>" + 
				"<tr>" + 
				"<th nowrap style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Orden" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Fecha Captura" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Toma Muestra" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Paciente" + 
				"	</font></b>" +
				"</th>" + 
//				"<th nowrap style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
//				"	<b><font color='black'>Capturo" + 
//				"	</font></b>" +
//				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Tiempo Espera / Tomador" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Humor Paciente" + 
				"	</font></b>" +
				"</th>" + 
				"</tr>");	}	
}



//public String getOrdenesTomaMuestra(int intSucursal,int uestaciontoma, int kOrdenSucursalORuConsecutivo) throws Exception {		
//	iObjSesion = HibernateUtil.getSession();
//	Connection objCon = null;
////	String strSize = "22";
//	Statement objSta = null;
//	ResultSet objResultSet = null;
//	String strQuery = "";
//	iObjLog.debug("Entrando TomaMuestrasDao.getOrdenesTomaMuestra:...  " + intSucursal);
//	List lstPacientes = new ArrayList(); 
//	try{            
//			objCon = iObjSesion.connection();
//		    objSta = objCon.createStatement();	        
//			strQuery = this.getConsultaOrdenTomaMuestra(intSucursal,uestaciontoma, kOrdenSucursalORuConsecutivo);
//			iObjLog.debug("Consulta TomaMuestrasDao.getOrdenesTomaMuestra:...  " + strQuery);
//			objResultSet = objSta.executeQuery(strQuery);
//			strQuery = this.getEncabezadoOrdenesSinPago();
//			String strEspera = "";
//			String strTiempoEspera = "";
////			String strkOrdenSucursal = "";
//			String strFechaCaptura = "";
//			double dblMinutos = 0.0;
//			if (objResultSet != null) {					
//				iObjLog.debug("Consulta TomaMuestrasDao.getOrdenesTomaMuestra:...  1");
//				int kOrdenSucursal = 0;
//				String strvalidaAtencionPacienteOtraArea = "";
//				while(objResultSet.next()) {
//					iObjLog.debug("Consulta TomaMuestrasDao.getOrdenesTomaMuestra:...  2");
//					this.getPacienteTomaMuestraBean(objResultSet,lstPacientes,uestaciontoma);						
//					
////					if ((kOrdenSucursal == 0) || (kOrdenSucursal != objResultSet.getInt("admision"))) {
////						strvalidaAtencionPacienteOtraArea = this.validaAtencionPacienteOtraArea(objResultSet.getInt("admision"),uestaciontoma);
////						kOrdenSucursal = objResultSet.getInt("admision");
////						strTiempoEspera = objResultSet.getString("tiempoespera");
////						dblMinutos = objResultSet.getDouble("minutos");							
////						if (dblMinutos < 9.0) {								
////							strEspera = "<img alt='HumorPaciente' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/happy.png' />";
////						} else if (dblMinutos < 20.0) {
////							strEspera = "<img alt='HumorPaciente' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/serious.png' />";
////						} else {
////							strEspera = "<img alt='HumorPaciente' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/sad.png' />";
////						}							
////						if (objResultSet.getString("slogin_name").trim().length() > 2) {
////							strEspera = "	<a href=\"javascript:terminoToma(" + objResultSet.getString("admision") + ");\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
////										"		<img alt='Atendida' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/atendida.png' />" +
////										"	</a>"; 													
////						   strEspera += "	<a href=\"javascript:imprimeEtiquetas(" + objResultSet.getString("admision") + ");\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
////										"		<img alt='Codigo Barras' id=\"imgPDF\" width=\"27\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/icoCodigoBarras.png' />" +
////										"	</a>"; 													
////							strTiempoEspera = objResultSet.getString("tomador");
////							strkOrdenSucursal = "   <td align='center'> " + 
////														objResultSet.getString("korden") + 
////												"	</td>"; 
////						} else {
////							if (strvalidaAtencionPacienteOtraArea.trim().length() > 1) {
//////								strEspera = "	<a href=\"javascript:null;\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
//////											"		<img alt='El paciente esta con: " + strvalidaAtencionPacienteOtraArea + "' id=\"imgPDF\" width=\"" + strSize + "\" height=\"" + strSize + "\" border='0' src='/web2labportal/images/gabinetes.png' />" +
//////											"	</a>"; 													
//////								strkOrdenSucursal = "   <td align='center'> " + 
//////															objResultSet.getString("korden") + 
//////													"	</td>"; 
////							} else {
//////								strkOrdenSucursal = "   <td align='center'> <a href='javascript:doNothing()' onClick='javascript:confirmarToma(" + objResultSet.getString("admision") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//////															objResultSet.getString("korden") + 
//////													"	</td>"; 
////							}
////						}
////						strQuery = strQuery + ("<tr>" + 
////													strkOrdenSucursal +
////												"	<td align='center'>" + 
////														objResultSet.getString("captura") + 
////												"	</td>" +
////												"	<td align='center'>" + 
////////														objResultSet.getString("promesa") + 
////												"	</td>" +
////												"	<td align='center' style='color: blue;'>" + 
////														objResultSet.getString("spaciente") + 
////												"	</td>" +
////////												"	<td align='center'>" + 
////////														objResultSet.getString("capturo") + 
////////												"	</td>" +
////												"	<td align='center'>" + 
////														strTiempoEspera + 
////												"	</td>" +
////												"	<td align='center'>" + 
////														strEspera +
////												"	</td>" +
////											 	"</tr>");
////					}
//					strFechaCaptura = "";						
//					if (objResultSet.getString("slogin_name").trim().length() > 2) {
//						strEspera = "	<a href=\"javascript:imprimirEtiquetaMuestra(" + objResultSet.getString("admision") + "," + objResultSet.getString("umuestra") + ");\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
//									"		<img alt='Codigo Barras' id=\"imgPDF\" width=\"23\" height=\"18\" border='0' src='/web2labportal/images/icoCodigoBarras.png' />" +
//									"	</a>"; 							
//						strkOrdenSucursal = "" + objResultSet.getString("cexamen");
//					} else {
//						if (strvalidaAtencionPacienteOtraArea.trim().length() > 1) {
//							strEspera = "	<a href=\"javascript:null;\"  align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>"  +  
//										"		<img alt='El paciente esta con: " + strvalidaAtencionPacienteOtraArea + "' id=\"imgPDF\" width=\"20\" height=\"20\" border='0' src='/web2labportal/images/gabinetes.png' />" +
//										"	</a>"; 							
//							strkOrdenSucursal = "" + objResultSet.getString("cexamen");
//						} else {
//							strEspera = "";
//							strkOrdenSucursal = "<a href='javascript:doNothing()' onClick='javascript:confirmarTomaExamen(" + objResultSet.getString("admision") + "," + objResultSet.getString("cexamen") +");' align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'> " +
//													objResultSet.getString("cexamen") + 
//												"</a>";				
//							strFechaCaptura   = "<a href='javascript:doNothing()' onClick='javascript:nuevaFechaTomaExamen(" + objResultSet.getString("admision") + "," + objResultSet.getString("cexamen") +");' align='bottom' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'> " +
//												"		<img alt='Indicar nueva fecha de toma' id=\"imgPDF\" width=\"23\" height=\"23\" border='0' src='/web2labportal/images/icoCalendario.png' />" +
//												"</a>";				
//						}							
//					}						
//					strQuery = strQuery + ("<tr>" + 
//							"	<td align='center'>" + 										
//							"	</td>" + 
//							"	<td align='center'>" + 
//									strFechaCaptura  +
//							"	</td>" +
//							"	<td align='center' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" + 
//									objResultSet.getString("fechatomamuestra") +
//							"	</td>" +
//							"	<td align='left' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>" + 
//									strkOrdenSucursal + "&#09;" + objResultSet.getString("sexamen") + 
//							"	</td>" +
//							"	<td align='center'>" + 
//									strEspera +								
//							"	</td>" +
//////							"	<td align='center'>" + 
//////							"	</td>" +
//							"	<td align='center'>" + 
//							"	</td>" +
//						 	"</tr>");						
//				}					
//			}
//			strQuery = strQuery + "</table>";								
//			iObjLog.debug("Saliendo TomaMuestrasDao.getOrdenesTomaMuestra:...  ");
//		return strQuery;
//	} catch (Exception aObjExcepcion) { 
//		iObjLog.error("ERROR TomaMuestrasDao.getOrdenesTomaMuestra: ", aObjExcepcion);
//		throw aObjExcepcion;
//    } finally {
//    	HibernateUtil.closeSession();
//		objSta = null;
//		objResultSet = null;
//    }
//}		
