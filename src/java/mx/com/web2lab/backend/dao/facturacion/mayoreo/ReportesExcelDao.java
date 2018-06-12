package mx.com.web2lab.backend.dao.facturacion.mayoreo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

//import mx.com.ha.reportexcel.mainExcel;
import mx.com.web2lab.backend.hbm.ConfiguracionProperties;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CReporteExcelFac;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReportesExcelDao {

	private static Log iObjLog = LogFactory.getLog(ReportesExcelDao.class);
	    
	private Session iObjSesion = null;
	
	public ReportesExcelDao(){
		iObjSesion = HibernateUtil.getSession();
	}
		
	public String generarReporte(int cConvenio,int cReporte) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		String strQuery = "";
//		mainExcel objReportExcel = new mainExcel();
		String strReturn = "";
		iObjLog.debug("Entrando ReportesExcelDao.generarReporte:...  " + cConvenio + " " + cReporte);
    	try{            
    		CReporteExcelFac objReporte = this.buscarConsulta(cReporte);
    		if (objReporte != null) {
        		strReturn = ConfiguracionProperties.getPropiedad("reporte.ruta.excelwrite");
	    		objCon = iObjSesion.connection();
				String[] strColumnas = objReporte.getSvariables().split(",");
	    		iObjLog.debug("Consulta ReportesExcelDao.generarReporte:...\n " + strQuery + "\n");
//	    		objReportExcel.createExecl(objCon, objReporte.getSreporteexcelfac(), strColumnas, strReturn + "PrevioExcelInfoDiaMex.xls");
    		} else {
    			strReturn = "";
    		}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ReportesExcelDao.generarReporte: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		strQuery = null;
        }
        return strReturn;
	}		
	
	private CReporteExcelFac buscarConsulta(int creport) throws Exception {
//		iObjSesion = HibernateUtil.getSession();
		List objListaReportes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		CReporteExcelFac objReporte = null;
    	try{
            HibernateUtil.beginTrans();
				strQuery = "select cREF " +					
						" from CReporteExcelFac cREF " +					
						" where cREF.creporteexcelfac = :creporteexcelfac ";
				objQuery = iObjSesion.createQuery(strQuery);
				objQuery.setParameter("creporteexcelfac", new Integer(creport));
				objListaReportes = objQuery.list();
			if(objListaReportes != null) {
				objReporte =  (CReporteExcelFac)objListaReportes.get(0);
			}			
		iObjLog.debug("Saliendo ReportesExcelDao.buscarConsulta:Saliendo...  " + objListaReportes.toString());
		return objReporte;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ReportesExcelDao.buscarConsulta: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
 //       	HibernateUtil.closeSession();
		}		
	}			
}
