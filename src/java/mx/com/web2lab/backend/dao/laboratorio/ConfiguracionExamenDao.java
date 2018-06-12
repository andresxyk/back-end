package mx.com.web2lab.backend.dao.laboratorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.configuracion.ExamenConfiguracionBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfiguracionExamenDao {

	private static Log iObjLog = LogFactory.getLog(ConfiguracionExamenDao.class);
	    
	private Session iObjSesion = null;
	
	public ConfiguracionExamenDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public String showGrid(ExamenConfiguracionBean objExamenConfiguracionBean) throws Exception {
		String strReturn = "";
		List lstExamenes = this.buscarExamenes(objExamenConfiguracionBean);
		strReturn = this.getEncabezadoDatosExamenes("Son " + lstExamenes.size() + " examenes encontrados");
		for (int inti=0;inti<lstExamenes.size();inti++) {
			strReturn += this.getBodyDatosExamenes((ExamenConfiguracionBean)lstExamenes.get(inti));
		}
		return strReturn + "</table>";
	}

	public ExamenConfiguracionBean getExamen(ExamenConfiguracionBean objExamenConfiguracionBean) throws Exception {
		List lstExamenes = this.buscarExamenes(objExamenConfiguracionBean);
		if (lstExamenes.size() > 0) {
			return (ExamenConfiguracionBean)lstExamenes.get(0);
		} else {
			return null;
		}		
	}
	
	private List buscarExamenes(ExamenConfiguracionBean objExamenBean) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		ExamenConfiguracionBean objExamenConfiguracionReturnBean = null;
		List lstExamenes = new ArrayList();
		iObjLog.debug("Entrando ConfiguracionExamenDao.buscarExamenes:... Codigo " + objExamenBean.getcExamen() + " Nombre " + objExamenBean.getsExamen() + " Departamento " + objExamenBean.getcDepartamento());
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
	        if (objExamenBean.getcExamen() > 0) {
	        	strQuery = " CE.cExamen in (" + objExamenBean.getcExamen() + ")"; 
	        } else if (objExamenBean.getsExamen().trim().length() > 0) {
	        	strQuery = " CE.sExamen like ('%" + objExamenBean.getsExamen() + "%')"; 
	        } else if (objExamenBean.getcDepartamento() > 0) {
	        	strQuery = " CD.cDepartamento = " + objExamenBean.getcDepartamento(); 
	        } else {
	        	strQuery = " 1 = 1 " ; 
	        }
            strQuery =  "SELECT       CE.CEXAMEN,												\n"+
						"             CE.SEXAMEN,												\n"+
						"       CD.CDEPARTAMENTO,												\n"+
						"       CD.SDEPARTAMENTO,												\n"+
						"           CE.SNEMONICO,												\n"+
						"EEC.CINDICACIONPACIENTE,												\n"+	
						"CIP.SINDICACIONPACIENTE,												\n"+
						"       EEC.CTIPOMUESTRA,												\n"+
						"       CTM.STIPOMUESTRA,												\n"+
						"            EEC.CINSUMO,												\n"+
						"             CI.SINSUMO,												\n"+
						" CIT.CINDICACIONTOMADOR,												\n"+
						" CIT.SINDICACIONTOMADOR,												\n"+
						"CTEM.CTEMPERATURAMUESTRA,												\n"+
						"CTEM.STEMPERATURAMUESTRA,												\n"+
						"     CMR.CMOTIVORECHAZO,												\n"+
						"     CMR.SMOTIVORECHAZO,												\n"+
						"     CTP.CTIEMPOPROCESO,												\n"+
						"     CTP.STIEMPOPROCESO												\n"+
						"FROM C_EXAMEN CE INNER JOIN C_DEPARTAMENTO 		CD 					\n"+
						"			 	 ON CE.CDEPARTAMENTO=CD.CDEPARTAMENTO					\n"+
						"		 INNER JOIN E_EXAMEN_CONFIGURACION 			EEC 				\n"+
						"		         ON EEC.CEXAMEN=CE.CEXAMEN								\n"+
						"		 INNER JOIN C_INDICACION_PACIENTE 			CIP 				\n"+
						"			 ON EEC.CINDICACIONPACIENTE=CIP.CINDICACIONPACIENTE			\n"+
						"		 INNER JOIN C_TIPO_MUESTRA 					CTM 				\n"+
						"		         ON CTM.CTIPOMUESTRA=EEC.CTIPOMUESTRA					\n"+
						"		 INNER JOIN C_INSUMO 						CI 					\n"+	
						"		         ON CI.CINSUMO=EEC.CINSUMO		         				\n"+
						"		 INNER JOIN C_INDICACION_TOMADOR 			CIT					\n"+
						"			 	 ON CIT.CINDICACIONTOMADOR=EEC.CINDICACIONTOMADOR		\n"+
						"		 INNER JOIN C_TEMPERATURA_MUESTRA 			CTEM				\n"+
						"		         ON CTEM.CTEMPERATURAMUESTRA=EEC.CTEMPERATURAMUESTRA	\n"+ 
						"		 INNER JOIN C_MOTIVO_RECHAZO 				CMR					\n"+
						"			 	 ON CMR.CMOTIVORECHAZO=EEC.CMOTIVORECHAZO				\n"+	
						"		 INNER JOIN C_TIEMPO_PROCESO 				CTP					\n"+
						"			 	 ON CTP.CTIEMPOPROCESO=EEC.CTIEMPOPROCESO				\n"+
						"WHERE " + strQuery;          			   
			iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:...");
				while(objResultSet.next()) {
					objExamenConfiguracionReturnBean = new ExamenConfiguracionBean();
					objExamenConfiguracionReturnBean.setsNemonico(objResultSet.getString("SNEMONICO") + "");
					objExamenConfiguracionReturnBean.setcExamen(objResultSet.getInt("CEXAMEN"));
					objExamenConfiguracionReturnBean.setsExamen(objResultSet.getString("SEXAMEN") + "");
					objExamenConfiguracionReturnBean.setcDepartamento(objResultSet.getInt("CDEPARTAMENTO"));
					objExamenConfiguracionReturnBean.setsDepartamento(objResultSet.getString("SDEPARTAMENTO") + "");
					objExamenConfiguracionReturnBean.setcIndicacionesPaciente(objResultSet.getInt("CINDICACIONPACIENTE"));
					objExamenConfiguracionReturnBean.setsIndicacionesPaciente(objResultSet.getString("SINDICACIONPACIENTE") + "");
					objExamenConfiguracionReturnBean.setcGenero(1);
					objExamenConfiguracionReturnBean.setsGenero("AMBOS");
					objExamenConfiguracionReturnBean.setCtiempoproceso(objResultSet.getInt("CTIEMPOPROCESO"));
					objExamenConfiguracionReturnBean.setStiempoproceso(objResultSet.getString("STIEMPOPROCESO") + "");
					objExamenConfiguracionReturnBean.setCinsumo(objResultSet.getInt("CINSUMO"));
					objExamenConfiguracionReturnBean.setSinsumo(objResultSet.getString("SINSUMO") + "");
					objExamenConfiguracionReturnBean.setCindicaciontomador(objResultSet.getInt("CINDICACIONTOMADOR"));
					objExamenConfiguracionReturnBean.setSindicaciontomador(objResultSet.getString("SINDICACIONTOMADOR") + "");
					objExamenConfiguracionReturnBean.setCtemperaturamuestra(objResultSet.getInt("CTEMPERATURAMUESTRA"));
					objExamenConfiguracionReturnBean.setStemperaturamuestra(objResultSet.getString("STEMPERATURAMUESTRA") + "");
					objExamenConfiguracionReturnBean.setCmotivorechazo(objResultSet.getInt("CMOTIVORECHAZO"));
					objExamenConfiguracionReturnBean.setSmotivorechazo(objResultSet.getString("SMOTIVORECHAZO") + "");
					objExamenConfiguracionReturnBean.setCtipomuestra(objResultSet.getInt("CTIPOMUESTRA"));
					objExamenConfiguracionReturnBean.setStipomuestra(objResultSet.getString("STIPOMUESTRA") + "");
					lstExamenes.add(objExamenConfiguracionReturnBean);
				}					
			}
			iObjLog.debug("Consulta ConfiguracionExamenDao.buscarExamenes:..." + lstExamenes.size());
			return lstExamenes;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConfiguracionExamenDao.buscarExamenes: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objResultSet.close();
        	objSta.close();
    		objSta = null;
    		objResultSet = null;
        }
	}		

	private String getBodyDatosExamenes(ExamenConfiguracionBean objExamenConfiguracionBean) {
		String strQuery = ("<tr>" + 
						"   <td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:seleccionaExamen(" + objExamenConfiguracionBean.getcExamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
								objExamenConfiguracionBean.getcExamen() + 
						"	</td>" + 
						"	<td align='center'>" + 
								objExamenConfiguracionBean.getsExamen() + 
						"	</td>" +
						"	<td align='center'>" + 
								objExamenConfiguracionBean.getsDepartamento() + 
						"	</td>" +
					 	"</tr>");
		return strQuery;
	}
	
	private String getEncabezadoDatosExamenes(String strTitulo) {
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
				"	<b><font color='black'>Examen" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Nombre" + 
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Departamento" + 
				"	</font></b>" +
				"</th>" + 
				"</tr>");	
	}		
}
