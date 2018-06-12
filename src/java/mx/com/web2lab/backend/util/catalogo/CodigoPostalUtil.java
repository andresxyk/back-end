package mx.com.web2lab.backend.util.catalogo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.josql.Query;
import org.josql.QueryResults;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;

import mx.com.web2lab.backend.beans.tools.CatalogosBean;
import mx.com.web2lab.backend.beans.tools.CodigoPostalBean;
import mx.com.web2lab.backend.dao.tools.CodigoPostalDao;

public class CodigoPostalUtil {

	private static Log iObjLog = LogFactory.getLog(CodigoPostalUtil.class);
	
	
	public void addCodigoPostal(CodigoPostalBean objCPBean) {
		CatalogosBean.lstCodigosPostales.add(objCPBean);
	}
	
	public int size() {
		return CatalogosBean.lstCodigosPostales.size();
	}
	
	public void LoadCodigoPostal() throws Exception {
		iObjLog.debug("Entrando CodigoPostalStatic.LoadCodigoPostal");
		try {
			if (CatalogosBean.lstCodigosPostales.size() < 1) {
				CodigoPostalDao objCPDao = new CodigoPostalDao();
				CatalogosBean.lstCodigosPostales = objCPDao.getCodigosPostales();
				iObjLog.debug("Cargando CodigoPostalStatic.LoadCodigoPostal " + CatalogosBean.lstCodigosPostales.size());
			}		
			iObjLog.debug("Saliendo CodigoPostalStatic.LoadCodigoPostal...." + CatalogosBean.lstCodigosPostales.size());
		} catch (Exception exp) {
			iObjLog.error("Consulta CodigoPostalStatic.getCodigoPostal(int kCodigoPostal).....Exception ",exp);				
			throw exp;			
		}
	}
	
	public  CodigoPostalBean getCodigoPostal(int kCodigoPostal) throws QueryParseException,QueryExecutionException,Exception {
		iObjLog.debug("Entrando CodigoPostalStatic.getCodigoPostal(int kCodigoPostal)");
		CodigoPostalBean objCPBean = new CodigoPostalBean();		
		try {
			this.LoadCodigoPostal();
			Query objQuery = new Query ();
			objQuery.parse("SELECT * FROM mx.com.web2lab.backend.beans.tools.CodigoPostalBean WHERE kCodigo = " + kCodigoPostal);
			List lstCodigosPostales = CatalogosBean.lstCodigosPostales;
			QueryResults objQueryResult = objQuery.execute(lstCodigosPostales);
			lstCodigosPostales = null;
			List lstResult = objQueryResult.getResults();
			if (lstResult != null) {
				iObjLog.debug("Consulta CodigoPostalStatic.getCodigoPostal(int kCodigoPostal)....." + lstResult.size());
				objCPBean = (CodigoPostalBean)lstResult.get(0);
			} else {
				iObjLog.debug("Consulta CodigoPostalStatic.getCodigoPostal(int kCodigoPostal).....VACIO");				
			}				
			iObjLog.debug("Saliendo CodigoPostalStatic.getCodigoPostal(int kCodigoPostal)");
		} catch (QueryParseException qpe) {
			iObjLog.error("Consulta CodigoPostalStatic.getCodigoPostal(int kCodigoPostal).....QueryParseException ",qpe);				
			throw qpe;
		} catch (QueryExecutionException qee) {
			iObjLog.error("Consulta CodigoPostalStatic.getCodigoPostal(int kCodigoPostal).....QueryExecutionException ",qee);				
			throw qee;
		} catch (Exception exp) {
			iObjLog.error("Consulta CodigoPostalStatic.getCodigoPostal(int kCodigoPostal).....Exception ",exp);				
			throw exp;
		}	
		return objCPBean;
	}
	
	public  List getCodigosPostales(CodigoPostalBean objCPBean) throws Exception {
		iObjLog.debug("Entrando CodigoPostalStatic.getCodigosPostales");
		try {
			this.LoadCodigoPostal();
			Query objQuery = new Query ();
			String strSQL;
			strSQL = "SELECT * FROM mx.com.web2lab.backend.beans.tools.CodigoPostalBean WHERE kCodigo > 1 ";
			if (objCPBean.getScolonia().trim() != "" && objCPBean.getScolonia().trim().length() > 1) {
				strSQL += " AND scolonia like '" + objCPBean.getScolonia() + "%'";
			}
			if (objCPBean.getSdelegacionmunicipio().trim() != "" && objCPBean.getSdelegacionmunicipio().trim().length() > 1) {
				strSQL += " AND sdelegacionmunicipio like '" + objCPBean.getSdelegacionmunicipio() + "%'";
			}
			if (objCPBean.getSciudad().trim() != "" && objCPBean.getSciudad().trim().length() > 1) {
				strSQL += " AND sciudad like '" + objCPBean.getSciudad() + "%'";
			}
			if (objCPBean.getSestado().trim() != "" && objCPBean.getSestado().trim().length() > 1) {
				strSQL += " AND sestado like '" + objCPBean.getSestado() + "%'";
			}			
			if (objCPBean.getScodigopostal().trim() != "" && objCPBean.getScodigopostal().trim().length() > 1) {
				strSQL += " AND scodigopostal like '" + objCPBean.getScodigopostal() + "%'";
			}			
			iObjLog.debug("Consulta CodigoPostalStatic.getCodigosPostales...." + strSQL);
			objQuery.parse(strSQL);			
			QueryResults objQueryResult = objQuery.execute(CatalogosBean.lstCodigosPostales);
			List lstResult = objQueryResult.getResults();
			if (lstResult != null) {
				iObjLog.debug("Consulta CodigoPostalStatic.getCodigosPostales....." + lstResult.size());
			} else {
				iObjLog.debug("Consulta CodigoPostalStatic.getCodigosPostales.....VACIO");				
			}				
			iObjLog.debug("Saliendo CodigoPostalStatic.getCodigosPostales");
			return lstResult;
		} catch (QueryParseException qpe) {
			iObjLog.error("Consulta CodigoPostalStatic.getCodigosPostales.....QueryParseException ",qpe);				
			throw qpe;
		} catch (QueryExecutionException qee) {
			iObjLog.error("Consulta CodigoPostalStatic.getCodigosPostales.....QueryExecutionException ",qee);				
			throw qee;
		} catch (Exception exp) {
			iObjLog.error("Consulta CodigoPostalStatic.getCodigosPostales.....Exception ",exp);				
			throw exp;
		}	
	}	
}
