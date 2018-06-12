package mx.com.web2lab.backend.dao.tools;

import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.tools.CodigoPostalBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CodigoPostalDao {

	private static Log iObjLog = LogFactory.getLog(CodigoPostalDao.class);
	    
	private Session iObjSesion = null;
	
	public CodigoPostalDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public List getCodigosPostales() throws Exception {
		iObjLog.debug("Entrando CodigoPostalDao.getCodigosPostales");		
		iObjSesion = HibernateUtil.getSession();
		CodigoPostalBean objCodigoPostalBean = null;
		CCodigoPostal objCodigoPostal = null;
		List objCodigosPostales = new ArrayList();
		List objCodigosPostalesReturn = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
            HibernateUtil.beginTrans();
        		strQuery =  "select cCP " +					
							" from CCodigoPostal cCP where cCP.bregistrosepo = true order by sestado,sdelegacionmunicipio,scolonia";
    			iObjLog.debug("Consulta CodigoPostalDao.getCodigosPostales....." + strQuery);		
				objQuery = iObjSesion.createQuery(strQuery);
				objCodigosPostales = objQuery.list();
				if(objCodigosPostales != null) {
					iObjLog.debug("Consulta CodigoPostalDao.getCodigosPostales...." + objCodigosPostales.size());		
					if (objCodigosPostales.size() > 0) {
						for(int inti=0;inti<objCodigosPostales.size();inti++) {
							objCodigoPostal = (CCodigoPostal)objCodigosPostales.get(inti);
							objCodigoPostalBean = new CodigoPostalBean();
							objCodigoPostalBean.setKCodigo(objCodigoPostal.getCcodigopostal().intValue());
							if (objCodigoPostal.getCpostal().trim().length() == 3) {
								objCodigoPostalBean.setScodigopostal("00" + objCodigoPostal.getCpostal().trim());								
							} else if (objCodigoPostal.getCpostal().trim().length() == 4) {
								objCodigoPostalBean.setScodigopostal("0" + objCodigoPostal.getCpostal().trim());																
							} else if (objCodigoPostal.getCpostal().trim().length() == 5) {
								objCodigoPostalBean.setScodigopostal(objCodigoPostal.getCpostal().trim());																
							}
							objCodigoPostalBean.setScolonia(objCodigoPostal.getScolonia());
							objCodigoPostalBean.setSdelegacionmunicipio(objCodigoPostal.getSdelegacionmunicipio());
							objCodigoPostalBean.setSciudad(objCodigoPostal.getSciudad());
							objCodigoPostalBean.setSestado(objCodigoPostal.getSestado());
							objCodigoPostalBean.setCasentamiento(Integer.parseInt(objCodigoPostal.getCasentamiento()));
							objCodigosPostalesReturn.add(objCodigoPostalBean);
						}
					}
				}
			iObjLog.debug("Saliendo CodigoPostalDao.getCodigosPostales");		
			return objCodigosPostalesReturn;	
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR CodigoPostalDao.getCodigosPostales: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		
}
