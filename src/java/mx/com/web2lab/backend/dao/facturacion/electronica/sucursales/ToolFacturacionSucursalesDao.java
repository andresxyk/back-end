package mx.com.web2lab.backend.dao.facturacion.electronica.sucursales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.com.web2lab.backend.dao.facturacion.electronica.orden.OrdenDatosFacturacionDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ToolFacturacionSucursalesDao {

	private static Log iObjLog = LogFactory.getLog(ToolFacturacionSucursalesDao.class);
	    
	private Session iObjSesion = null;
	
	public ToolFacturacionSucursalesDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public void generarFacturaGlobalSucursal(int cSucursal,int intUser) throws Exception {
		/*Registra todas las ordenes que fueron Saldadas y no estan en una factura */
		String strOrdenSucursales = this.searchOrdenesSinFacturacion(cSucursal, intUser);
		/*Enviar a Facturar */		
	}
	
	private String searchOrdenesSinFacturacion(int cSucursal,int intUser) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		String strReturn = "";
		iObjLog.debug("Entrando ToolFacturacionSucursalesDao.searchOrdenesSinFacturacion:...  " + cSucursal);
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	          strQuery ="SELECT tos.kordensucursal as kordensucursal													\n" +
				        "FROM  t_orden_sucursal tos inner join t_pago_paciente tpp										\n" +
				        "	   on tos.kordensucursal = tpp.kordensucursal												\n" +
				        "	  left join t_orden_sucursal_fac tosf on tos.kordensucursal = tosf.kordensucursal			\n" +
				        "WHERE  to_char ( tpp.dregistro, 'dd-mm-yyyy')=to_char (sysdate, 'dd-mm-yyyy') and 				\n" +
				        "		msaldo =0 and tos.csucursal in (" + cSucursal + ")										\n" +
				        "ORDER BY tos.kordensucursal																	\n";	        
				iObjLog.debug("Consulta ToolFacturacionSucursalesDao.searchOrdenesSinFacturacion:...  " + strQuery);
			  objResultSet = objSta.executeQuery(strQuery);
			  if (objResultSet != null) {					
				  OrdenDatosFacturacionDao objDatosOrden = new OrdenDatosFacturacionDao();
				  while(objResultSet.next()) {					  
					  objDatosOrden.crearOrdenFacturar(objResultSet.getString("kordensucursal"), intUser);
					  strReturn = (strReturn + "," + objResultSet.getString("kordensucursal"));
				  }					
				  objDatosOrden = null;
			  }
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.SearchOrdenNuevaViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
        return strReturn;
	}		

	public String getEstatusOrdenes(int kAdmision) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		String strReturn = "";
		iObjLog.debug("Entrando ToolFacturacionSucursalesDao.getEstatusOrdenes:...  " + kAdmision);
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	          strQuery ="SELECT cer.sestadoregistro											\n" +
				        "FROM  t_orden_sucursal_fac tosf inner join c_estado_registro cer	\n" +
				        "	   on tosf.cestadoregistro = cer.cestadoregistro				\n" +
				        "WHERE tosf.kordensucursal in (" + kAdmision + ")					\n" +
				        "ORDER BY 1															\n"; 
				iObjLog.debug("Consulta ToolFacturacionSucursalesDao.getEstatusOrdenes:...  " + strQuery);
			  objResultSet = objSta.executeQuery(strQuery);
			  if (objResultSet != null) {					
				  while(objResultSet.next()) {					  
					  strReturn = (objResultSet.getString("sestadoregistro"));
				  }					
			  }
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ToolFacturacionSucursalesDao.getEstatusOrdenes: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
        return strReturn;
	}		
	
	public void changeEstatusOrdenes(int kAdmision,int intEstatus,int uGrupo) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando ToolFacturacionSucursalesDao.changeEstatusOrdenes:...  " + kAdmision + " " + intEstatus);
    	try{            
			objCon = iObjSesion.connection();
			objSta = objCon.createStatement();			
			strQuery ="UPDATE T_ORDEN_SUCURSAL_FAC 					\n" +
					  "SET CESTADOREGISTRO=" + intEstatus + ", 		\n" +
					  "	   UCONSECUTIVO=" + uGrupo + "		 		\n" +
					  "WHERE kordensucursal = " + kAdmision + " and \n" +
					  "		 kfactura in (0,-1)						\n";	        
			iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeEstatusOrdenes:...  " + strQuery);
			objSta.execute(strQuery);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ToolFacturacionSucursalesDao.changeEstatusOrdenes: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
        }
	}		

	public void changeConvenioOrdenesFac(int kAdmision,int cConvenio) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		ResultSet objResultSet = null;
		Statement objSta = null;
		String strQuery = "";
		int kOrdenSucursalFac = 0;
		iObjLog.debug("Entrando ToolFacturacionSucursalesDao.changeConvenioOrdenesFac:...  " + kAdmision + " " + cConvenio);
    	try{            
			objCon = iObjSesion.connection();
			objSta = objCon.createStatement();
			strQuery = "SELECT max(kordensucursalfac) kordensucursalfac			\n" +
					   "		FROM T_ORDEN_SUCURSAL_FAC						\n" +
					   "		WHERE kOrdenSucursal in (" + kAdmision + ")	and	\n" +
					   "			  cestadoregistro not in (35)				  ";											    
			iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeConvenioOrdenesFac:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				  while(objResultSet.next()) {					  
					  kOrdenSucursalFac = objResultSet.getInt("kordensucursalfac");
				  }					
			}
			if (kOrdenSucursalFac > 0) {
				strQuery ="UPDATE T_ORDEN_SUCURSAL_FAC								\n" +
						  "SET CCONVENIO=" + cConvenio + "							\n" +
						  "WHERE kordensucursalfac in (" + kOrdenSucursalFac + ")	\n";
				iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeConvenioOrdenesFac:...  " + strQuery);
				objSta.execute(strQuery);
				strQuery ="begin 																			\n" +   
						  "olab_proc_recalculo_ord_fac.proc_recalcula_orden (" + kOrdenSucursalFac + ");	\n" +
						  "end;																				\n";
				iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeConvenioOrdenesFac:...  " + strQuery);
				objSta.execute(strQuery);
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ToolFacturacionSucursalesDao.changeConvenioOrdenesFac: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		

	public void changeEstatusExamenOrdenesFac(int kAdmision,int cExamen,int cPerfil) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		ResultSet objResultSet = null;
		Statement objSta = null;
		String strQuery = "";
		int kOrdenSucursalFac = 0;
		iObjLog.debug("Entrando ToolFacturacionSucursalesDao.changeEstatusExamenOrdenesFac:...  " + kAdmision + " " + cExamen);
    	try{            
			objCon = iObjSesion.connection();
			objSta = objCon.createStatement();
			strQuery = "SELECT max(kordensucursalfac) kordensucursalfac			\n" +
					   "		FROM T_ORDEN_SUCURSAL_FAC						\n" +
					   "		WHERE kOrdenSucursal in (" + kAdmision + ")	and	\n" +
					   "			  cestadoregistro not in (35)				  ";											    
			iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeEstatusExamenOrdenesFac:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				  while(objResultSet.next()) {					  
					  kOrdenSucursalFac = objResultSet.getInt("kordensucursalfac");
				  }					
			}
			if (kOrdenSucursalFac > 0) {
				if (cExamen > 0) {
					strQuery ="UPDATE T_ORDEN_EXAMEN_SUCURSAL_FAC							\n" +
							  "SET CESTADOREGISTRO=43										\n" +
							  "WHERE kordensucursalfac in (" + kOrdenSucursalFac + ") and	\n" +
							  "      cExamen in (" + cExamen + ") and cPerfil = -1     		  ";
					iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeEstatusExamenOrdenesFac:...  " + strQuery);
					objSta.execute(strQuery);
//					strQuery ="UPDATE T_ORDEN_EXAMEN_SUCURSAL						\n" +
//							  "SET CESTADOREGISTRO=42								\n" +
//							  "WHERE kordensucursal in (" + kAdmision + ") and		\n" +
//							  "      cExamen in (" + cExamen + ") and cPerfil = -1    ";
//					iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeEstatusExamenOrdenesFac:...  " + strQuery);
//					objSta.execute(strQuery);
					strQuery ="begin 																			\n" +   
							  "olab_proc_recalculo_ord_fac.proc_recalcula_orden (" + kOrdenSucursalFac + ");	\n" +
							  "end;																				\n";
					iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeEstatusExamenOrdenesFac:...  " + strQuery);
					objSta.execute(strQuery);
				} else if (cPerfil > 0) {
					strQuery ="UPDATE T_ORDEN_EXAMEN_SUCURSAL_FAC					\n" +
					  "SET CESTADOREGISTRO=43										\n" +
					  "WHERE kordensucursalfac in (" + kOrdenSucursalFac + ") and	\n" +
					  "      cPerfil in (" + cPerfil + ")     		  				  ";
					iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeEstatusExamenOrdenesFac:...  " + strQuery);
					objSta.execute(strQuery);
					strQuery ="begin 																			\n" +   
							  "olab_proc_recalculo_ord_fac.proc_recalcula_orden (" + kOrdenSucursalFac + ");	\n" +
							  "end;																				\n";
					iObjLog.debug("Consulta ToolFacturacionSucursalesDao.changeEstatusExamenOrdenesFac:...  " + strQuery);
					objSta.execute(strQuery);
				}
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ToolFacturacionSucursalesDao.changeEstatusExamenOrdenesFac: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		
	
	public void cancelacionFactura(int kAdmision) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando ToolFacturacionSucursalesDao.cancelacionFactura:...  " + kAdmision);
    	try{            
			objCon = iObjSesion.connection();
			objSta = objCon.createStatement();
			strQuery ="UPDATE T_ORDEN_SUCURSAL_FAC 					\n" +
					  "SET CESTADOREGISTRO=39 						\n" +
					  "WHERE kordensucursal = " + kAdmision + " 	\n";
			iObjLog.debug("Consulta ToolFacturacionSucursalesDao.cancelacionFactura:...  " + strQuery);
			objSta.execute(strQuery);
			strQuery ="UPDATE T_FACTURA									\n" +
					  "SET CESTADOREGISTRO=34							\n" +
					  "WHERE KFACTURA IN (								\n" +
					  "		SELECT KFACTURA								\n" +
					  "		FROM T_ORDEN_SUCURSAL_FAC					\n" +
					  "		WHERE KFACTURA NOT IN (-1,0) AND 			\n" +
					  "			  KORDENSUCURSAL = " + kAdmision + ") 	\n";
			iObjLog.debug("Consulta ToolFacturacionSucursalesDao.cancelacionFactura:...  " + strQuery);
			objSta.execute(strQuery);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ToolFacturacionSucursalesDao.cancelacionFactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
        }
	}			
}
