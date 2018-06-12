package mx.com.web2lab.backend.dao.ap.mayoreo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.com.web2lab.backend.beans.ap.PacienteBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PacientesMayoreoDao {

	private static Log iObjLog = LogFactory.getLog(PacientesMayoreoDao.class);
	    
	private Session iObjSesion = null;
	
	public PacientesMayoreoDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public PacienteBean buscarPacienteMetro(PacienteBean objPacienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		String strSQL = "";		
    	try{
			iObjLog.debug("Entrando PacientesMayoreoDao.buscarPacienteMetro:Entrando...  " + objPacienteBean.getSvalorexpediente());
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			if (objPacienteBean.getKpacientefundacion().intValue() > 0) {
				strSQL = "SELECT kpaciente,svalor																				\n" +
						 "FROM t_dato_adicional 																				\n" +
						 "WHERE cdatoadicional in (5,6,7,8) and 																\n" +
						 "		(kpaciente = " + objPacienteBean.getKpacientefundacion().intValue() + " )						\n" +
						 "ORDER BY  1																							\n";				
				objPacienteBean.setSvalorexpediente("");
			} else if (objPacienteBean.getSvalorexpediente().trim().length() > 2){
				strSQL = "SELECT kpaciente,svalor																				 \n" +
						 "FROM t_dato_adicional 																				 \n" +
						 "WHERE cdatoadicional in (5,6,7,8) and (trim(svalor) = '" + objPacienteBean.getSvalorexpediente() + "') \n" +
						 "ORDER BY  1																							 \n";				
				objPacienteBean.setKpacientefundacion(new Integer(0));
			} else {
				strSQL = "";
			}
			if (strSQL != "") {
				iObjLog.debug("Entrando PacientesMayoreoDao.buscarPacienteMetro:Consulta...  " + strSQL);
				rst = objStatement.executeQuery(strSQL);
				strSQL = "";
				if(rst != null) {
					while(rst.next()) {
						objPacienteBean.setKpacientefundacion(new Integer(rst.getInt("kpaciente")));
						objPacienteBean.setSvalorexpediente(rst.getString("svalor").trim());
						break;
					}				
					rst.close();
				}					
			}
			iObjLog.debug("Resultado PacientesMayoreoDao.buscarPacienteMetro:Consulta...  " + objPacienteBean.getKpacientefundacion());		
			return objPacienteBean;				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesMayoreoDao.buscarPacienteMetro: ", aObjExcepcion);
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
	}	
	
	public void guardarPacienteMetro(PacienteBean objPacienteBean, Session iObjSesion) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strSQL = "";		
    	try{
			iObjLog.debug("Entrando PacientesMayoreoDao.guardarPacienteMetro:Entrando...  " + objPacienteBean.getSvalorexpediente());
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();	
			strSQL = "DELETE FROM t_dato_adicional where cdatoadicional in (5,6,7,8) and kpaciente=" + objPacienteBean.getKpacientefundacion();
			iObjLog.debug("Entrando PacientesMayoreoDao.guardarPacienteMetro:Consulta...  " + strSQL);
			objStatement.execute(strSQL);
			strSQL = "INSERT INTO t_dato_adicional									\n" +
					 "VALUES (t_dato_adicional_sequence.NEXTVAL,0,0,5,'" + 
					 			objPacienteBean.getSvalorexpediente().trim() + "',	\n" + 
					 			objPacienteBean.getKpacientefundacion() + ")		\n";
			iObjLog.debug("Entrando PacientesMayoreoDao.guardarPacienteMetro:Consulta...  " + strSQL);
			objStatement.execute(strSQL);
			strSQL = "";
			iObjLog.debug("Resultado PacientesMayoreoDao.guardarPacienteMetro:Consulta...  " + objPacienteBean.getKpacientefundacion());		
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesMayoreoDao.guardarPacienteMetro: ", aObjExcepcion);
			throw aObjExcepcion;
		} finally{
			if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
		}		
	}	
}
