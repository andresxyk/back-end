package mx.com.web2lab.backend.dao.facturacion.menudeo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenExamenBean;
import mx.com.web2lab.backend.beans.comer.ConvenioBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursalFac;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac;
import mx.com.web2lab.backend.hbm.om.lis.CExamen;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FacturacionMenudeoDao {

	private static Log iObjLog = LogFactory.getLog(FacturacionMenudeoDao.class);
	    
	private Session iObjSesion = null;
	
	public FacturacionMenudeoDao(){
		iObjSesion = HibernateUtil.getSession();
	}
		
	public String getFolioFacturaOrden(long kOrdenSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objRst = null;
		String strQuery = "";
		String strReturn = "";
		iObjLog.debug("Entrando FacturacionMenudeoDao.getFolioFacturaOrden:...  " + kOrdenSucursal);
    	try{            
    		objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	        strQuery = "SELECT (nvl(trim(SSERIE),'') || trim(to_char(nvl(UFOLIOFACTURA,0),'0000000'))) factura	\n"+
	        		   "FROM t_factura																			\n"+		
     		           "WHERE CSUCURSAL <>1003 AND USER_ID >1 AND kfactura in (SELECT max(kfactura)				\n"+
     		           "FROM t_orden_sucursal_fac																\n"+
     		           "WHERE kordensucursal in (" + kOrdenSucursal + "))										\n";
	        iObjLog.debug("Consulta FacturacionMenudeoDao.getFolioFacturaOrden:...  " + strQuery);
			objRst = objSta.executeQuery(strQuery);
			while(objRst.next()) {
				strReturn = objRst.getString("factura");
			}
			iObjLog.debug("Consulta FacturacionMenudeoDao.getFolioFacturaOrden:...  Folio Factura \n " + strReturn + "\n");
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMenudeoDao.getFolioFacturaOrden: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objRst = null;
    		strQuery = null;
        }
	}		
}
