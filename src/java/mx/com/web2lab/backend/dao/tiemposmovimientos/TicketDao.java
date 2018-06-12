package mx.com.web2lab.backend.dao.tiemposmovimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.dao.ap.ToolsDao;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.tiemposmovimientos.TTicketSucursal;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TicketDao {

	private static Log iObjLog = LogFactory.getLog(TicketDao.class);
	    
	private Session iObjSesion = null;
	
	public TicketDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public TTicketSucursal setTicket(TTicketSucursal objTTicketSucursal) throws Exception {
		ToolsDao objToolDao = new ToolsDao();
		Connection objConexion = null;
		try {						
			iObjLog.debug("Entrando TicketDao.setTicket:...  " + objTTicketSucursal.toString());
			objConexion = iObjSesion.connection();				
			objTTicketSucursal.setUconsecutivoticketsucursal(objToolDao.getSequenceNextId("t_ticket_" + objTTicketSucursal.getCsucursal() + "_" + objTTicketSucursal.getSnemonicoconsecutivo().trim().toLowerCase() + "_sequence" ,objConexion).intValue());
			objTTicketSucursal.setDcierreticket(new Date());
			objTTicketSucursal.setKticketsucursalinicial(0);
            iObjSesion.save(objTTicketSucursal);
            iObjSesion.flush();            	
			iObjLog.debug("Saliendo TicketDao.setTicket:Saliendo...  " + objTTicketSucursal.toString());
			return objTTicketSucursal;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.setTicket:....", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objToolDao = null;
        	HibernateUtil.closeSession();
		}		
	}	

	
	public TTicketSucursal updateTicket(TTicketSucursal objTTicketSucursal) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strSQL = "";
		try {						
			iObjSesion = HibernateUtil.getSession();
			iObjLog.debug("Entrando TicketDao.updateTicket:...  " + objTTicketSucursal.toString());
            iObjSesion.update(objTTicketSucursal);
            iObjSesion.flush();            	
            if (objTTicketSucursal.getKordensucursal() > 0) {
				objConn = iObjSesion.connection();				
				objStatement = objConn.createStatement();
				strSQL = "UPDATE T_ORDEN_EXAMEN_SUCURSAL											\n"+					
						 "SET dtomamuestrainicio=sysdate,											\n"+
						 "	  dtomamuestratermino=sysdate,											\n"+
						 "	  slogin_name=' '														\n"+
						 "WHERE trim(slogin_name) = ''  and kordensucursal in (" + objTTicketSucursal.getKordensucursal() +")	\n";
				objStatement.execute(strSQL);
            }            
			iObjLog.debug("Saliendo TicketDao.updateTicket:Saliendo...  " + objTTicketSucursal.toString());
			return objTTicketSucursal;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.updateTicket:....", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objStatement = null;
        	HibernateUtil.closeSession();
		}		
	}	

	public TTicketSucursal duplicarTicket(TTicketSucursal objTTicketSucursal) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strSQL = "";
		try {						
			iObjSesion = HibernateUtil.getSession();
			iObjLog.debug("Entrando TicketDao.duplicarTicket:...  " + objTTicketSucursal.toString());
			objTTicketSucursal.setKticketsucursal(null);
            iObjSesion.save(objTTicketSucursal);
            iObjSesion.flush();            	
            if (objTTicketSucursal.getKordensucursal() > 0) {
				objConn = iObjSesion.connection();				
				objStatement = objConn.createStatement();
				strSQL = "UPDATE T_ORDEN_EXAMEN_SUCURSAL											\n"+					
						 "SET dtomamuestrainicio=sysdate,											\n"+
						 "	  dtomamuestratermino=sysdate,											\n"+
						 "	  slogin_name=' '														\n"+
						 "WHERE trim(slogin_name) = ''  and kordensucursal in (" + objTTicketSucursal.getKordensucursal() +")	\n";
				objStatement.execute(strSQL);
            }                        
			iObjLog.debug("Saliendo TicketDao.duplicarTicket:Saliendo...  " + objTTicketSucursal.toString());
			return objTTicketSucursal;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.duplicarTicket:....", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objStatement = null;
        	HibernateUtil.closeSession();
		}		
	}	

	public void cerrarTicket(TTicketSucursal objTTicketSucursal) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strSQL = "";
		try {						
			iObjSesion = HibernateUtil.getSession();
			iObjLog.debug("Entrando TicketDao.cerrarTicket:...  " + objTTicketSucursal.toString());
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			strSQL = "UPDATE T_TICKET_SUCURSAL													\n"+					
					 "SET    cestadoregistro=65,												\n"+
					 "    dcierreticket=sysdate													\n"+
					 "WHERE kticketsucursalinicial in (" + objTTicketSucursal.getKticketsucursal() +")	\n" + 
					 "		and (kordensucursal >0 or  kordensucursalcotizacion >0) 			\n"+
					 "		and cestadoregistro = 65											\n";
			iObjLog.debug("Consulta TicketDao.cerrarTicket:Consulta2...  " + strSQL);
			objStatement.execute(strSQL);
			
			strSQL = "UPDATE T_ORDEN_EXAMEN_SUCURSAL											\n"+					
					 "SET dtomamuestrainicio=sysdate+((1/24)/60),								\n"+
					 "	  dtomamuestratermino=sysdate+((1/24)/60),								\n"+
					 "	  slogin_name=' '														\n"+
					 "WHERE trim(slogin_name) = '' and kordensucursal in (SELECT kordensucursal		\n"+
					 "						   							   FROM T_TICKET_SUCURSAL	\n"+
					 "						   							   WHERE kticketsucursalinicial IN (" + objTTicketSucursal.getKticketsucursal() +")) \n";
			iObjLog.debug("Consulta TicketDao.cerrarTicket:Consulta3...  " + strSQL);
			objStatement.execute(strSQL);
			iObjLog.debug("Saliendo TicketDao.cerrarTicket:Saliendo...  " + objTTicketSucursal.toString());
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.cerrarTicket:....", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objStatement = null;
        	HibernateUtil.closeSession();
		}		
	}	
	

	public void cerrarTicketAnteriores(TTicketSucursal objTTicketSucursal) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strSQL = "";
		try {						
			iObjSesion = HibernateUtil.getSession();
			iObjLog.debug("Entrando TicketDao.cerrarTicket:...  " + objTTicketSucursal.toString());
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			strSQL = "UPDATE T_TICKET_SUCURSAL													\n"+					
					 "SET    cestadoregistro=65,												\n"+
					 "    dcierreticket=sysdate													\n"+
					 "WHERE kticketsucursal in (" + objTTicketSucursal.getKticketsucursal() +")	\n"; 
			iObjLog.debug("Consulta TicketDao.cerrarTicket:Consulta2...  " + strSQL);
			objStatement.execute(strSQL);
			
			strSQL = "UPDATE T_ORDEN_EXAMEN_SUCURSAL											\n"+					
					 "SET dtomamuestrainicio=sysdate+((1/24)/60),								\n"+
					 "	  dtomamuestratermino=sysdate+((1/24)/60),								\n"+
					 "	  slogin_name=' '														\n"+
					 "WHERE trim(slogin_name) = '' and kordensucursal in (SELECT kordensucursal		\n"+
					 "						   							   FROM T_TICKET_SUCURSAL	\n"+
					 "						   							   WHERE kticketsucursal IN (" + objTTicketSucursal.getKticketsucursal() +")) \n";
			iObjLog.debug("Consulta TicketDao.cerrarTicket:Consulta3...  " + strSQL);
			objStatement.execute(strSQL);
			iObjLog.debug("Saliendo TicketDao.cerrarTicket:Saliendo...  " + objTTicketSucursal.toString());
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.cerrarTicket:....", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objStatement = null;
        	HibernateUtil.closeSession();
		}		
	}	
	
	public TTicketSucursal getTicket(int kticketsucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List lstTicket = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		TTicketSucursal objTTicketSucursal = null;
		try {			
    			iObjLog.debug("Consulta TicketDao.getTicket():...kOrdenSucursal  " + kticketsucursal);
        		strQuery =  "select bPF 											" +					
							"from TTicketSucursal bPF 								" +					
							"where bPF.kticketsucursal = " + kticketsucursal + " 	" + 
							"order by bPF.kticketsucursal ";        		
				objQuery = iObjSesion.createQuery(strQuery);
				lstTicket = objQuery.list();
				if(lstTicket != null) {
					if (lstTicket.size() > 0) {
		    			iObjLog.debug("Consulta TicketDao.getTicket():...Elementos en la lista  " + lstTicket.size());
						for (int inti=0;inti<lstTicket.size();inti++ ) {
			    			objTTicketSucursal = (TTicketSucursal)lstTicket.get(inti);								
						}
					}
				}			
			return objTTicketSucursal;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.getTicket: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	lstTicket = null;
        	HibernateUtil.closeSession();
		}		
	}	
	
	
	public double getEspera(int kticketsucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		double dblMinutos = 0.0;
		iObjLog.debug("Entrando TicketDao.getEspera:...  " + kticketsucursal);
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();	        
			strQuery =	"SELECT  (extract(epoch from sysdate-dinicio)/60)  minutos    		\n"+
						"FROM T_TICKET_SUCURSAL												\n"+
						"WHERE kticketsucursal in (" + kticketsucursal + ") 				\n";
				iObjLog.debug("Consulta TicketDao.getEspera:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				if (objResultSet != null) {					
					while(objResultSet.next()) {
						dblMinutos = objResultSet.getDouble("minutos");							
						iObjLog.debug("Consulta TicketDao.getEspera:..." + dblMinutos);
					}
				}
				iObjLog.debug("Saliendo TicketDao.getEspera:...  ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.getEspera: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
		return dblMinutos;
	}		

	public double getFueLllamado(int kticketsucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		double dblMinutos = 0.0;
		iObjLog.debug("Entrando TicketDao.getFueLllamado:...  " + kticketsucursal);
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();	        
			strQuery =	"SELECT  (extract(epoch from sysdate-dtermino)/60)  minutos    		\n"+
						"FROM T_TICKET_SUCURSAL												\n"+
						"WHERE kticketsucursal in (" + kticketsucursal + ") 				\n";
				iObjLog.debug("Consulta TicketDao.getEspera:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				if (objResultSet != null) {					
					while(objResultSet.next()) {
						dblMinutos = objResultSet.getDouble("minutos");							
						iObjLog.debug("Consulta TicketDao.getFueLllamado:..." + dblMinutos);
					}
				}
				iObjLog.debug("Saliendo TicketDao.getFueLllamado:...  ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.getEspera: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
		return dblMinutos;
	}		
	

	public List getTicketsSucursalEstado(int csucursal, int cestadoregistro, String strNemonicos, int cUsuario) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List lstTicket = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
			iObjLog.debug("Consulta TicketDao.getTicketsSucursal():...csucursal  " + csucursal + " cestadoregistro " + cestadoregistro);
			if (strNemonicos.trim().length() == 0) {
	    		strQuery =  "select bPF " +					
							" from TTicketSucursal bPF " +					
							" where bPF.csucursal = " + csucursal + " and bPF.cestadoregistro = " + cestadoregistro + 
							" order by bPF.snemonicoconsecutivo, bPF.kticketsucursal ";        		
			} else if (cUsuario > 0) {
	    		strQuery =  "select bPF " +					
							" from TTicketSucursal bPF " +					
							" where bPF.csucursal = " + csucursal + " and bPF.cestadoregistro <> 65  and bPF.snemonicoconsecutivo in (" + strNemonicos + ") and bPF.userId = " + cUsuario + " " +
							" order by bPF.snemonicoconsecutivo, bPF.kticketsucursal ";        						
			} else {
	    		strQuery =  "select bPF " +					
							" from TTicketSucursal bPF " +					
							" where bPF.csucursal = " + csucursal + " and bPF.cestadoregistro = " + cestadoregistro + " and bPF.snemonicoconsecutivo in (" + strNemonicos + ") " +
							" order by bPF.snemonicoconsecutivo, bPF.kticketsucursal ";        		
			}
			objQuery = iObjSesion.createQuery(strQuery);
			lstTicket = objQuery.list();
			
			iObjLog.debug("lista"+lstTicket.size());
			
			return lstTicket;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.getTicketsSucursal: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	lstTicket = null;
        	HibernateUtil.closeSession();
		}		
	}		
}
