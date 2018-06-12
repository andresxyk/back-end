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

public class MonitoreoBitacoraDao {

	private static Log iObjLog = LogFactory.getLog(MonitoreoBitacoraDao.class);
	    
	private Session iObjSesion = null;
	
	public MonitoreoBitacoraDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public String mostrarBitacora(int cSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		String strReturn="";
		String strRows="";
		iObjLog.debug("Entrando MonitoreoBitacoraDao.mostrarBitacora:...  " + cSucursal);
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();	        
			strQuery =	"SELECT uconsecutivoticketsucursal,fecha,entrada,recepcion,t1,dterminorecepcion,t2,dcierreticket,    		\n"+
						" snemonicoconsecutivo,smodulo,recepc,sestadoregistro "+
						"FROM T_TIEMPO_MOVIMIENTO_V												\n"+
						"WHERE csucursal in (" + cSucursal + ") 				\n"+
						"order by uconsecutivoticketsucursal";
			
				iObjLog.debug("Consulta MonitoreoBitacoraDao.mostrarBitacora:...  " + strQuery);
				strReturn="<table border='0'  align='center' style='width: 100%' class='tabla'> "+
						  "	<th colspan='12'> "+ 																														  																														 
					  	  "		<center>"		+																													 
						  "				<b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>Bitacora Movimientos</b> " + 
		        	      "		</center>"+																															 
		        	      "</th> "+																																	 
						  "<tr>"+																																	  
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>"+				 
						  "			<b><font color='black'>NúmeroTicket																					" +			  
						  "			</font></b>																														 " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Fecha Ticket																									  " +
						  "			</font></b>																														 " +
						  "		</th>																																  " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				" + 
						  "			<b><font color='black'>Entrada Paciente																							  " +
						  "		</th>																																  " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Comienza Recepción																						  " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Total Llegada-Recepción																					  " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Termina Recepción																						  " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Total Atención-Recepción																					  " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Termina Ticket																							  " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Servicio																									  " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Módulo																									  " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>Recepcionista																							  " +
						  "		</th>																																 " +
						  "		<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>				 " +
						  "			<b><font color='black'>EstadoTicket																								  " +
						  "		</th>																																 " +
						  "</tr>																																		" ; 
					
				objResultSet = objSta.executeQuery(strQuery);
				if (objResultSet != null) {					
					while(objResultSet.next()) {
						strRows +="	<tr>																															" + 
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("uconsecutivoticketsucursal") 											  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("fecha") 											  						  + 
								 "	         </font>																												" +
								 "     </td>																														" + 
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("entrada") 											  					  + 
								 "	         </font>																												" +
								 "     </td>																														" + 
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("recepcion") 											  					  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("t1") 											  						  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("dterminorecepcion") 											  			  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("t2") 											  						  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("dcierreticket") 											  				  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("snemonicoconsecutivo") 											  		  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("smodulo") 											  					  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("recepc") 											  					  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "     <td align=\"center\">" +
								 "	         <font color='black'>"+objResultSet.getString("sestadoregistro") 											  			  + 
								 "	         </font>																												" +
								 "     </td>																														" +
								 "</tr>";
								
						iObjLog.debug("Consulta MonitoreoBitacoraDao.mostrarBitacora:..." + strRows);
					}
				}
				iObjLog.debug("Saliendo MonitoreoBitacoraDao.mostrarBitacora:...  ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR TicketDao.getEspera: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
		return strReturn=strReturn+strRows+"</table>";
	}		

	
			
}
