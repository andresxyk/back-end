package mx.com.web2lab.backend.dao.facturacion.empresas.viaje;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.com.web2lab.backend.dao.ap.ToolsDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal;
import mx.com.web2lab.backend.util.Formatos;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ViajeFacturacionDao {

	private static Log iObjLog = LogFactory.getLog(ViajeFacturacionDao.class);
	    
	private Session iObjSesion = null;
	
	public ViajeFacturacionDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public String OrdenNuevaViaje(TOrdenSucursal objOrdenSucursal, int intUser) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		int intViaje = -1;
		ToolsDao objToolSequence = new ToolsDao();
		iObjLog.debug("Entrando ViajeFacturacionDao.OrdenNuevaViaje:...  " + objOrdenSucursal.getKordensucursal().intValue());
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	          strQuery = "SELECT kviajefac 																										\n"+
	          			 "FROM T_ORDEN_SUCURSAL_FAC 																							\n"+
	          			 "WHERE cestadoregistro = 27 																							\n"+
	          			 "      AND csucursal = " + objOrdenSucursal.getCsucursalbycsucursal().getCsucursal().intValue() +  " ORDER BY kviajefac ";
				iObjLog.debug("Consulta ViajeFacturacionDao.OrdenNuevaViaje:...  " + strQuery);
			  objResultSet = objSta.executeQuery(strQuery);
			  if (objResultSet != null) {					
				  iObjLog.debug("Consulta ViajeFacturacionDao.OrdenNuevaViaje:...  1");
				  while(objResultSet.next()) {
					  intViaje = objResultSet.getInt("kviajefac"); 
				  }					
			  }
			  if (intViaje == -1) {
				  intViaje = objToolSequence.getSequenceNextId("tordensucursalfacvi_sequence", objCon).intValue(); 
   			  }			  
			  strQuery = "begin																							\n" + 
						 "	fact_detalle (" + objOrdenSucursal.getKordensucursal().intValue() + ",0," + 
						 					  intViaje + ",27);	\n" +
						 " end;																							\n";			  
				iObjLog.debug("Consulta ViajeFacturacionDao.OrdenNuevaViaje:...  " + strQuery);
			  objSta.execute(strQuery);
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.OrdenNuevaViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
    		objToolSequence = null;
        }
	}		

	public void LimpiarErroViaje(Integer objKOrdenSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.LimpiarErroViaje:...  ");
    	try{            
			objCon = iObjSesion.connection();
			objSta = null;
			objSta = objCon.createStatement();
			strQuery = "DELETE FROM T_ORDEN_EXAMEN_SUCURSAL_FAC WHERE KORDENSUCURSALFAC IN (	"+
						"SELECT KORDENSUCURSALFAC												"+ 
						"FROM T_ORDEN_SUCURSAL_FAC												"+
						"WHERE KVIAJEFAC=0 AND KFACTURA=0 AND KORDENSUCURSAL IN (				"+
						"SELECT KORDENSUCURSAL													"+
						"FROM T_ORDEN_SUCURSAL_FAC												"+
						"WHERE MFACTURAEMPRESA>0 and KORDENSUCURSAL IN (" + objKOrdenSucursal + ")"+
						"GROUP BY KORDENSUCURSAL												"+
						"HAVING COUNT(KORDENSUCURSAL)=1))										";
			iObjLog.debug("Consulta ViajeFacturacionDao.LimpiarErroViaje:...  " + strQuery);
			objSta.execute(strQuery);
			strQuery = "DELETE FROM T_ORDEN_SUCURSAL_FAC WHERE KORDENSUCURSALFAC IN (			"+
						"SELECT KORDENSUCURSALFAC												"+ 
						"FROM T_ORDEN_SUCURSAL_FAC												"+
						"WHERE KVIAJEFAC=0 AND KFACTURA=0 AND KORDENSUCURSAL IN (				"+
						"SELECT KORDENSUCURSAL													"+
						"FROM T_ORDEN_SUCURSAL_FAC												"+
						"WHERE MFACTURAEMPRESA>0 and KORDENSUCURSAL IN (" + objKOrdenSucursal + ")"+
						"GROUP BY KORDENSUCURSAL												"+
						"HAVING COUNT(KORDENSUCURSAL)=1))										";
			iObjLog.debug("Consulta ViajeFacturacionDao.LimpiarErroViaje:...  " + strQuery);
			objSta.execute(strQuery);			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.LimpiarErroViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
        }
	}		
	
	public boolean SearchOrdenNuevaViaje(TOrdenSucursal objOrdenSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		boolean bolOrden = false;
		iObjLog.debug("Entrando ViajeFacturacionDao.SearchOrdenNuevaViaje:...  " + objOrdenSucursal.getKordensucursal().intValue());
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	          strQuery = "SELECT kviajefac 																			\n"+
	          			 "FROM T_ORDEN_SUCURSAL_FAC 																\n"+
	          			 "WHERE kordensucursal = " + objOrdenSucursal.getKordensucursal().intValue();	          
				iObjLog.debug("Consulta ViajeFacturacionDao.SearchOrdenNuevaViaje:...  " + strQuery);
			  objResultSet = objSta.executeQuery(strQuery);
			  if (objResultSet != null) {					
				  iObjLog.debug("Consulta ViajeFacturacionDao.SearchOrdenNuevaViaje:...  1");
				  while(objResultSet.next()) {					  
					  bolOrden =  true;
				  }					
			  }
			return bolOrden;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.SearchOrdenNuevaViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		

	public int SearchOrdenViaje(TOrdenSucursal objOrdenSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		int kViaje = -1;
		iObjLog.debug("Entrando ViajeFacturacionDao.SearchOrdenViaje:...  " + objOrdenSucursal.getKordensucursal().intValue());
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	          strQuery = "SELECT kviajefac 																			\n"+
	          			 "FROM T_ORDEN_SUCURSAL_FAC 																\n"+
	          			 "WHERE kordensucursal = " + objOrdenSucursal.getKordensucursal().intValue() + "            \n"+
	          			 "ORDER BY kordensucursalfac 																\n";	          
				iObjLog.debug("Consulta ViajeFacturacionDao.SearchOrdenViaje:...  " + strQuery);
			  objResultSet = objSta.executeQuery(strQuery);
			  if (objResultSet != null) {					
				  iObjLog.debug("Consulta ViajeFacturacionDao.SearchOrdenViaje:...  1");
				  while(objResultSet.next()) {					  
					  kViaje =  objResultSet.getInt("kviajefac");
				  }					
			  }
			return kViaje;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.SearchOrdenViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		
	
	public String getOrdenesNewViaje(int intSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.getOrdenesSinViaje:...  " + intSucursal);
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
			strQuery =	"select  tos.uorden orden,tos.kordensucursal admision,																	\n"+
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 							\n"+
						"        to_char(tos.dregistro,'dd-mm-yyyy') captura,																	\n"+
						"        to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,															\n"+
						"        nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,	\n"+
						"        0 burgente,																									\n"+
						"        tos.mpagopaciente pagopaciente,																				\n"+
						"        cs.snombresucursal  sunidad,																					\n"+
						"        cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,												\n"+
						"        tu.first_name||' '||tu.last_name capturo,																		\n"+
						"		 tpp.kviajefac kviajefac																						\n"+
						"from  t_orden_sucursal tos 																							\n"+
						"INNER JOIN t_orden_sucursal_fac tpp ON tos.kordensucursal = tpp.kordensucursal AND tpp.cestadoregistro = 27			\n"+
						"INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente													\n"+
						"INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal													\n"+
						"INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio													\n"+
						"INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id														\n"+
						"where tos.mpagopaciente = 0																							\n"+
						"		and tos.csucursal = " + intSucursal + "																			\n"+
						"order by admision";
				iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				strQuery = this.getEncabezadoOrdenesSinPago("Ordenes Viaje Actual");
				strQuery = strQuery + this.getBodyOrdenes(objResultSet);
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		

	public String cerrarViaje(int intSucursal,int User) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		String strReturn = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.cerrarViaje:...  " + intSucursal);
    	try{            
        	objCon = iObjSesion.connection();
    		this.updateEstadoViajeCerrado(intSucursal, User, objCon);
    		strReturn = this.generaEtiquetaViajeFacturacion(intSucursal,0,objCon);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.cerrarViaje: ", aObjExcepcion);
			strReturn = "";
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        }
        return strReturn;
	}		
	
	
	public String reimprimirEtiquetasViaje(int intSucursal,int kViajeFacturacion) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		String strReturn = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.reimprimirEtiquetasViaje:...  " + intSucursal);
    	try{            
        	objCon = iObjSesion.connection();
    		strReturn = this.generaEtiquetaViajeFacturacion(intSucursal,kViajeFacturacion,objCon);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.reimprimirEtiquetasViaje: ", aObjExcepcion);
			strReturn = "";
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        }
        return strReturn;
	}		
		
	public String getOrdenesSinViaje(int intSucursal,int intOrdenar) throws Exception {		
		Formatos objFormatos = new Formatos();
		String strQuery = "";
		String strOrderBy = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.getOrdenesSinViaje:...  " + intSucursal);
    	try{            
    		switch (intOrdenar) {
	    		case 1:
	    			strOrderBy = "admision";
	    			break;
	    		case 2:
	    			strOrderBy = "spaciente";
	    			break;
	    		case 3:
	    			strOrderBy = "cc.cconvenio";
	    			break;
	    		case 4:
	    			strOrderBy = "kviajefac";
	    			break;
    		}
			strQuery =	"select  tos.uorden orden,tos.kordensucursal admision,																	\n"+
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 							\n"+
						"        to_char(tos.dregistro,'dd-mm-yyyy') captura,																	\n"+
						"        to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,															\n"+
						"        nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,	\n"+
						"        0 burgente,																									\n"+
						"        tos.mfacturaempresa pagopaciente,																				\n"+
						"        cs.snombresucursal  sunidad,																					\n"+
						"        cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,												\n"+
						"        tu.first_name||' '||tu.last_name capturo,																		\n"+
						"		 0 kviajefac																									\n"+
						"from  t_orden_sucursal tos 																							\n"+
						"LEFT JOIN  t_orden_sucursal_fac tpp ON tos.kordensucursal = tpp.kordensucursal											\n"+
						"INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente													\n"+
						"INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal													\n"+
						"INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio and cc.ctipoconvenio = 22							\n"+
						"INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id														\n"+
						"where (tos.dregistro between (sysdate)-60											 									\n"+
						"				and to_date('" + objFormatos.getFechaActual() + " 23:59:59', 'dd-mm-yyyy hh24:mi:ss')) 					\n"+
						"				and tos.cestadoregistro<>17 																			\n"+
						"				and tpp.kordensucursal is null																			\n"+
						"				and tos.mpagopaciente = 0 																				\n"+
						"				and tos.csucursal = " + intSucursal + "																	\n"+
						"order by " + strOrderBy;
			strQuery = this.executeReporteOrdenes(strQuery,"Ordenes Sin Viaje");
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        }
	}		

	public String enViajeOrdenNoFac(int intSucursal,int intOrdenar) throws Exception {		
		Formatos objFormatos = new Formatos();
		String strQuery = "";
		String strOrderBy = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.getOrdenesSinViaje:...  " + intSucursal);
    	try{            
    		switch (intOrdenar) {
	    		case 1:
	    			strOrderBy = "admision";
	    			break;
	    		case 2:
	    			strOrderBy = "spaciente";
	    			break;
	    		case 3:
	    			strOrderBy = "cc.cconvenio";
	    			break;
	    		case 4:
	    			strOrderBy = "kviajefac";
	    			break;
    		}
			strQuery =	"select  tos.uorden orden,tos.kordensucursal admision,																	\n"+
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 							\n"+
						"        to_char(tos.dregistro,'dd-mm-yyyy') captura,																	\n"+
						"        to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,															\n"+
						"        nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,	\n"+
						"        0 burgente,																									\n"+
						"        tpp.mfacturaempresa pagopaciente,																				\n"+
						"        cs.snombresucursal  sunidad,																					\n"+
						"        cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,												\n"+
						"        tu.first_name||' '||tu.last_name capturo,																		\n"+
						"		 tpp.kviajefac kviajefac																						\n"+
						"from  t_orden_sucursal tos 																							\n"+
						"INNER JOIN  t_orden_sucursal_fac tpp ON tos.kordensucursal = tpp.kordensucursal										\n"+
						"INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente													\n"+
						"INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal													\n"+
						"INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio and cc.ctipoconvenio = 22							\n"+
						"INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id														\n"+
						"where (tos.dregistro between (sysdate)-60											 									\n"+
						"				and to_date('" + objFormatos.getFechaActual() + " 23:59:59', 'dd-mm-yyyy hh24:mi:ss')) 					\n"+
						"				and tos.cestadoregistro<>17 																			\n"+
						"				and tos.mpagopaciente = 0 																				\n"+
						"				and tos.csucursal = " + intSucursal + "																	\n"+
						"               and tos.kordensucursal in ( SELECT tosf.kordensucursal																															\n"+				
						"											FROM t_orden_sucursal_fac tosf INNER JOIN  c_estado_registro cer ON cer.cestadoregistro = tosf.cestadoregistro     									\n"+
						"															and tosf.cestadoregistro IN (28)																									\n"+
						"											WHERE kordensucursalfac= (SELECT get_max_t_orden_suc_fac (kordensucursal)) and                                 												\n"+
						"											      kordensucursal in (SELECT tos.kordensucursal                                   																\n"+
						"											                                FROM t_orden_sucursal tos INNER JOIN t_orden_sucursal_fac tosf ON tos.kordensucursal=tosf.kordensucursal and tosf.cestadoregistro IN (28)     \n"+    	                           
						"											                                WHERE (tos.DREGISTRO                                   																\n"+
						"											                                                 between (sysdate)-60											                                    \n"+	
						"											                                                 and to_date('" + objFormatos.getFechaActual() + " 23:59:59', 'dd-mm-yyyy hh24:mi:ss'))             \n"+
						"											                                                               AND tos.CESTADOREGISTRO NOT IN (17) 							  						\n"+
						"											                          )    																														\n"+
						"											)																																					\n"+
						"order by " + strOrderBy;
			strQuery = this.executeReporteOrdenes(strQuery,"Ordenes Enviadas Viaje, NO Recibidas Facturacion");
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        }
	}		

	public String buscarViaje(int intSucursal,int Viaje) throws Exception {		
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.getOrdenesSinViaje:...  " + intSucursal);
    	try{            
			strQuery =	"select  tos.uorden orden,tos.kordensucursal admision,																	\n"+
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 							\n"+
						"        to_char(tos.dregistro,'dd-mm-yyyy') captura,																	\n"+
						"        to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,															\n"+
						"        nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,	\n"+
						"        0 burgente,																									\n"+
						"        tpp.mpagopaciente pagopaciente,																				\n"+
						"        cs.snombresucursal  sunidad,																					\n"+
						"        cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,												\n"+
						"        tu.first_name||' '||tu.last_name capturo,																		\n"+
						"		 tpp.kviajefac kviajefac																						\n"+
						"from  t_orden_sucursal tos 																							\n"+
						"INNER JOIN  t_orden_sucursal_fac tpp ON tos.kordensucursal = tpp.kordensucursal AND tpp.KVIAJEFAC = " + Viaje + "		\n"+
						"INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente													\n"+
						"INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal													\n"+
						"INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio													\n"+
						"INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id														\n"+
						"where tos.cestadoregistro<>17 																							\n"+
						"				and tos.mpagopaciente = 0																				\n"+
						"				and tos.csucursal = " + intSucursal + "																	\n"+
						"               and tos.kordensucursal in ( SELECT tosf.kordensucursal																															\n"+				
						"											FROM t_orden_sucursal_fac tosf INNER JOIN  c_estado_registro cer ON cer.cestadoregistro = tosf.cestadoregistro     									\n"+
						"											WHERE kordensucursalfac= (SELECT get_max_t_orden_suc_fac (kordensucursal)) and                                 												\n"+
						"											      kordensucursal in (SELECT tos.kordensucursal                                   																\n"+
						"											                         FROM t_orden_sucursal tos INNER JOIN t_orden_sucursal_fac tosf ON tos.kordensucursal=tosf.kordensucursal 					\n"+
						"																										and tosf.kviajefac IN (" + Viaje + ")													\n"+    	                           
						"											                                WHERE tos.CESTADOREGISTRO NOT IN (17)  																				\n"+
						"											                          )    																														\n"+
						"											)																																					\n"+
						"order by admision";
			strQuery = this.executeReporteOrdenes(strQuery,"Ordenes en el Viaje " + Viaje);
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        }
	}		

	private String executeReporteOrdenes(String strQuery, String strTitulo) throws Exception  {
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		iObjLog.debug("Entrando ViajeFacturacionDao.executeReporteOrdenes:...  " + strQuery);
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
			objResultSet = objSta.executeQuery(strQuery);
			strQuery = "";
			strQuery = this.getEncabezadoOrdenesSinPago(strTitulo);
			strQuery = strQuery + this.getBodyOrdenes(objResultSet);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
		return strQuery;
	}
			
	private String getBodyOrdenes(ResultSet objResultSet) throws Exception {
		String strQuery = "";
		try {
			if (objResultSet != null) {					
				iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  1");
				int inti = 1;
				while(objResultSet.next()) {
					iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  2");
					strQuery = strQuery + ("<tr>" + 
											"   <td align='center'>" + 
													inti + 
											"	</td>" + 
											"   <td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:registrarPago(" + objResultSet.getString("admision") + "," + objResultSet.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
													objResultSet.getString("admision") + 
											"	</td>" + 
											"	<td align='center'>" + 
													objResultSet.getString("korden") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("captura") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("kviajefac") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("spaciente") + 
											"	</td>" +
											"	<td align='center'>" + 
													"$" + objResultSet.getString("pagopaciente") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("convenio") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("capturo") + 
											"	</td>" +
										 	"</tr>");
					inti++;
				}					
			}
			strQuery = strQuery + "</table>";										
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
		}
		return strQuery;
	}
	
	private String getEncabezadoOrdenesSinPago(String strTitulo) {
		return ("<table border='0' align='center' style='width: 883px' class='tabla'>" + 
				"<tr>" + 
				"<th colspan='8'>" +
				"   <center>" +
				"       <b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>" + strTitulo + "</b>" +
				"    </center>" +
				"</th>     " +
				"</tr>" +					
				"<tr>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>#" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Admision" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Orden" + 
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Fecha Captura" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Viaje Fac" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Paciente" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>$ Facturar" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Convenio" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Capturo" + 
				"	</font></b>" +
				"</th>" + 
				"</tr>");	
		}	
	
	
	private String generaTramaEtiquetasZPL(ResultSet objResultSet) throws Exception {
		String strEtiquetas = "";
    	try{
			if(objResultSet != null) {
				while(objResultSet.next()) {
					strEtiquetas = "";
					strEtiquetas += "^XA " +
									"^LH5,10 " +
									"^FO24,10^AD^FD"+objResultSet.getString("Encabezado")+"^FS "+
									"^FO40,30^BY2,2.0:1^B3N,N,80,N^FD"+objResultSet.getString("CodigoBarras")+"^FS " +
									"^FO24,120^AD^FD"+objResultSet.getString("Elementos")+ "^FS " +
									"^XZ";			
					
					break;
				}
				objResultSet.close();
			}		
			iObjLog.debug("ViajeFacturacionDao.generaTramaEtiquetasZPL:Exception....   " + strEtiquetas);
		} catch (Exception aObjExcepcion) { 
    	    iObjLog.error("ViajeFacturacionDao.generaTramaEtiquetasZPL:Exception....", aObjExcepcion);
    	    throw aObjExcepcion;
		} finally {
			objResultSet = null;
		}		
		return strEtiquetas;
	}				
		
	private String generaEtiquetaViajeFacturacion(int intSucursal,int intViajeFacturacion,Connection objCon) throws Exception {		
		Statement objSta = null;
		ResultSet rst = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.generaEtiquetaViajeFacturacion:...  " + intViajeFacturacion);
    	try{            
	        objSta = objCon.createStatement();	        
	        if (intViajeFacturacion > 0) {
				strQuery =	"SELECT trim(to_char(nvl(tosf.kviajefac,0),'00000000')) CodigoBarras,					\n" +
							"      	to_char(tosf.csucursal) || '-' || 												\n" +	
				    		"		cs.snombresucursal || ' Viaje ' || 												\n" +
				    		"		to_char(tosf.kviajefac) || ' ' || to_char(tosf.dcierre) Encabezado,				\n" +
				    		"		'Ordenes: ' || count(tosf.*) Elementos											\n" +
							"FROM t_orden_sucursal_fac tosf INNER JOIN c_sucursal cs ON tosf.csucursal=cs.csucursal	\n" +
							"WHERE tosf.kviajefac in (" + intViajeFacturacion + ")									\n" +
							"GROUP BY CodigoBarras,Encabezado";
	        } else {
				strQuery =	"SELECT trim(to_char(nvl(tosf.kviajefac,0),'00000000')) CodigoBarras,					\n" +
							"      	to_char(tosf.csucursal) || '-' || 												\n" +	
				    		"		cs.snombresucursal || ' Viaje ' || 												\n" +
				    		"		to_char(tosf.kviajefac) || ' ' || to_char(tosf.dcierre) Encabezado,				\n" +
				    		"		'Ordenes: ' || count(tosf.*) Elementos											\n" +
							"FROM t_orden_sucursal_fac tosf INNER JOIN c_sucursal cs ON tosf.csucursal=cs.csucursal	\n" +
							"WHERE tosf.kviajefac in (																\n" +
							"		    	SELECT max(kviajefac)													\n" +
							"		    	FROM t_orden_sucursal_fac												\n" +
							"		    	WHERE csucursal = " + intSucursal 	+ " AND CESTADOREGISTRO = 28)		\n" +
							"GROUP BY CodigoBarras,Encabezado";
	        }
			iObjLog.debug("Consulta ViajeFacturacionDao.generaEtiquetaViajeFacturacion:...  " + strQuery);
			rst = objSta.executeQuery(strQuery);
			strQuery = this.generaTramaEtiquetasZPL(rst);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.generaEtiquetaViajeFacturacion: ", aObjExcepcion);
			strQuery = "";
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
        }
        return strQuery;
	}			

	private void updateEstadoViajeCerrado(int intSucursal,int User,Connection objCon) throws Exception {		
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.updateEstadoViajeCerrado:...  " + intSucursal);
    	try{            
	        objSta = objCon.createStatement();
			strQuery =	"UPDATE t_orden_sucursal_fac 									\n"+
						"SET cestadoregistro=28,user_id=" + User + ",dcierre=sysdate	\n"+
						"WHERE cestadoregistro = 27	and csucursal = " + intSucursal + "  ";
				iObjLog.debug("Consulta ViajeFacturacionDao.updateEstadoViajeCerrado:...  " + strQuery);
				objSta.execute(strQuery);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.updateEstadoViajeCerrado: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
    		objSta = null;
        }
	}		
}
