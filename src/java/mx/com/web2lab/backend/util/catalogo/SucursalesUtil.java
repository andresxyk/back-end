package mx.com.web2lab.backend.util.catalogo;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.josql.Query;
import org.josql.QueryResults;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

import mx.com.web2lab.backend.beans.tools.CatalogosBean;
import mx.com.web2lab.backend.beans.tools.SucursalBean;
import mx.com.web2lab.backend.dao.tools.SucursalDao;

public class SucursalesUtil {

	private static Log iObjLog = LogFactory.getLog(SucursalesUtil.class);
		
	public int size() {
		return CatalogosBean.lstSucursales.size();
	}
	
	public void LoadSucursales() throws Exception {
		iObjLog.debug("Entrando SucursalesUtil.LoadSucursales");
		try {
			if (CatalogosBean.lstSucursales.size() < 1) {
				SucursalDao objSucursalDao = new SucursalDao();
				CatalogosBean.lstSucursales = objSucursalDao.getSucursales();
				iObjLog.debug("Cargando SucursalesUtil.LoadSucursales " + CatalogosBean.lstSucursales.size());
			}		
			iObjLog.debug("Saliendo SucursalesUtil.LoadSucursales...." + CatalogosBean.lstSucursales.size());
		} catch (Exception exp) {
			iObjLog.error("Consulta SucursalesUtil.LoadSucursales().....Exception ",exp);				
			throw exp;			
		}
	}
	
	public  SucursalBean getSucursal(int kSucursal) throws Exception {
		iObjLog.debug("Entrando SucursalesUtil.getSucursal(int kSucursal)");
		SucursalBean objSucursalBean = new SucursalBean();		
		try {
			this.LoadSucursales();
			Query objQuery = new Query ();
			objQuery.parse("SELECT * FROM mx.com.web2lab.backend.beans.tools.SucursalBean WHERE csucursal = " + kSucursal);
			List lstSucursales = CatalogosBean.lstSucursales;
			QueryResults objQueryResult = objQuery.execute(lstSucursales);
			lstSucursales = null;
			List lstResult = objQueryResult.getResults();
			if (lstResult != null) {
				iObjLog.debug("Consulta SucursalesUtil.getSucursal(int kSucursal)....." + lstResult.size());
				objSucursalBean = (SucursalBean)lstResult.get(0);
			} else {
				iObjLog.debug("Consulta SucursalesUtil.getSucursal(int kSucursal).....VACIO");				
			}				
			iObjLog.debug("Saliendo SucursalesUtil.getSucursal(int kSucursal)");
		} catch (QueryParseException qpe) {
			iObjLog.error("Consulta SucursalesUtil.getSucursal(int kSucursal).....QueryParseException ",qpe);				
			throw qpe;
		} catch (QueryExecutionException qee) {
			iObjLog.error("Consulta SucursalesUtil.getSucursal(int kSucursal).....QueryExecutionException ",qee);				
			throw qee;
		} catch (Exception exp) {
			iObjLog.error("Consulta SucursalesUtil.getSucursal(int kSucursal).....Exception ",exp);				
			throw exp;
		}	
		return objSucursalBean;
	}	
}
