package mx.com.web2lab.backend.dao.facturacion.mayoreo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.facturacion.electronica.DesgloceFacturaExamenBean;
import mx.com.web2lab.backend.beans.facturacion.electronica.FacturaElectronicaBean;
import mx.com.web2lab.backend.beans.facturacion.electronica.FacturaSustitucionBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal;
import mx.com.web2lab.backend.hbm.om.ap.CControlFolio;
import mx.com.web2lab.backend.hbm.om.ap.CEntidadLegal;
import mx.com.web2lab.backend.hbm.om.ap.TDatoFiscal;
import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FacturacionElectronicaMayoreoDao {

	private static Log iObjLog = LogFactory.getLog(FacturacionElectronicaMayoreoDao.class);
	    
	private Session iObjSesion = null;
	
	public FacturacionElectronicaMayoreoDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public TFactura buscarFactura(int kFactura) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		TFactura objTfactura = new TFactura();
		Query objQuery = null;
		String strQuery = "";
		List objListaFacturas = new ArrayList();
		
    	try{
			iObjLog.debug("Entrando FacturacionElectronicaMayoreoDao.buscarFactura:Entrando...  " + kFactura);
			HibernateUtil.beginTrans();
			strQuery = "select tF 										\n" +					
			   		   "from TFactura tF 								\n" +	
			           "where tF.kfactura="+kFactura+" order by kfactura desc";
			
			
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFacturas = objQuery.list();
			if (objListaFacturas.isEmpty() == false) {
				objTfactura = (TFactura)objListaFacturas.get(0);
			}
			
			
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscarFactura:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturaElectronicaMayoreoDao.buscarFactura: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
        	HibernateUtil.closeSession();
    	}		
    	return objTfactura;
	}		

	public TFactura buscarFacturaFolio(String strfolioFactura, int marca, String serie) throws Exception {
		Query objQuery = null;
		String strQuery = "";
		List objListaFacturas = new ArrayList();
		TFactura objTFactura= new TFactura();
		String csucursal="";
		
		if(marca==1){
			 csucursal="1003";
		}else if (marca==4){
			csucursal="1012";
		}else if (marca==5){
			csucursal="1013";
		}else if (marca==15){
			csucursal="1017";
		}else if (marca==7){
			if(serie.equals("AJP")){
				csucursal="1014";				
			}else if(serie.equals("AJL")){
				csucursal="1015";
			}
		}
		
    	try{
			iObjLog.debug("Entrando FacturacionElectronicaMayoreoDao.buscarFacturaFolio:Entrando...  " + strfolioFactura);
			HibernateUtil.beginTrans();
			strQuery =  " select Tf"+
					" from TFactura Tf " +					
					" where Tf.ufoliofactura="+strfolioFactura+" and Tf.csucursal="+csucursal;
		
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFacturas = objQuery.list();
			if (objListaFacturas.isEmpty() == false) {
				objTFactura = (TFactura)objListaFacturas.get(0);
			}
			
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscarFacturaFolio:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturaElectronicaMayoreoDao.buscarFacturaFolio: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
        	HibernateUtil.closeSession();
    	}		
    	return objTFactura;
	}		

	public TDatoFiscal buscaDatoFiscal(int kdatoFiscal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		TDatoFiscal objTDatoFiscal = new TDatoFiscal();
		List objListaDatosFiscales = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionElectronicaMayoreoDao.buscaDatoFiscal:Entrando...  " + kdatoFiscal);
			HibernateUtil.beginTrans();
			strQuery = "select tDf 										\n" +					
			   		   "from TDatoFiscal tDf 								\n" +	
			           "where tDf.kdatofiscal="+kdatoFiscal;
			
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscaDatoFiscala:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaDatosFiscales = objQuery.list();
			if (objListaDatosFiscales.isEmpty() == false) {
				objTDatoFiscal = (TDatoFiscal)objListaDatosFiscales.get(0);
			}
			
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscaDatoFiscala:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturaElectronicaMayoreoDao.buscaDatoFiscal: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
        	HibernateUtil.closeSession();
    	}		
    	return objTDatoFiscal;
	}	
	
	public CEntidadLegal buscaEntidadLegal(int centidadLegal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		CEntidadLegal objCentidadLegal = new CEntidadLegal();
		List objListaEntidadLegal = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionElectronicaMayoreoDao.buscaEntidadLegal:Entrando...  " + centidadLegal);
			HibernateUtil.beginTrans();
			strQuery = "select cEl 										\n" +					
			   		   "from CEntidadLegal cEl 								\n" +	
			           "where cEl.centidadlegal="+centidadLegal;
			
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscaEntidadLegal:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaEntidadLegal = objQuery.list();
			if (objListaEntidadLegal.isEmpty() == false) {
				objCentidadLegal = (CEntidadLegal)objListaEntidadLegal.get(0);
			}
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscaEntidadLegal:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturaElectronicaMayoreoDao.buscaEntidadLegal: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
        	HibernateUtil.closeSession();
    	}		
    	return objCentidadLegal;
	}
	
	public CCodigoPostal buscaCodigoPostal(long icCodigoPostal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		CCodigoPostal objCcodigoPostal = new CCodigoPostal();
		List objListaCodigoPostal = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionElectronicaMayoreoDao.buscaCodigoPostal:Entrando...  " + icCodigoPostal);
			HibernateUtil.beginTrans();
			strQuery = "select cPp 										\n" +					
			   		   "from CCodigoPostal cPp 								\n" +	
			           "where cPp.ccodigopostal="+icCodigoPostal;
			
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscaEntidadLegal:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaCodigoPostal = objQuery.list();
			if (objListaCodigoPostal.isEmpty() == false) {
				objCcodigoPostal = (CCodigoPostal)objListaCodigoPostal.get(0);
			}
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscaCodigoPostal:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturaElectronicaMayoreoDao.buscaCodigoPostal: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
        	HibernateUtil.closeSession();
    	}		
    	return objCcodigoPostal;
	}
	
	
	
	public CControlFolio buscaControlFoliol(int csucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		CControlFolio objCcontrolFolio = new CControlFolio();
		List objListaControlFolio = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionElectronicaMayoreoDao.buscaControlFoliol:Entrando...  " + csucursal);
			HibernateUtil.beginTrans();
			strQuery = "select cCf 										\n" +					
			   		   "from CControlFolio cCf 								\n" +	
			           "where cCf.csucursal="+csucursal+" and cCf.cestadoregistro = 31";
			
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscaControlFoliol:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaControlFolio = objQuery.list();
			if (objListaControlFolio.isEmpty() == false) {
				objCcontrolFolio = (CControlFolio)objListaControlFolio.get(0);
			}
			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.buscaControlFoliol:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturaElectronicaMayoreoDao.buscaControlFoliol: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
        	HibernateUtil.closeSession();
    	}		
    	return objCcontrolFolio;
	}
		
	public FacturaElectronicaBean persistirFactura(FacturaElectronicaBean objFacturaBean) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		List objFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		TFactura objFacturaH = new TFactura();
		
		iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.persistirFactura:...  " + objFacturaBean.getKfactura() + " Usuario " + objFacturaBean.getTurbine_User());
    	try{            
    			
    			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.persistirFactura:Entrando...  " );
    			HibernateUtil.beginTrans();
    			strQuery = "select tF " +					
    			   		   "from TFactura tF " +	
    			           "where tF.kfactura =  " + objFacturaBean.getKfactura();
    			
    			iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.persistirFactura:Consulta...  " + strQuery);
    			objQuery = iObjSesion.createQuery(strQuery);
    			objFactura = objQuery.list();
    			if (objFactura != null) {
    				objFacturaH = (TFactura)objFactura.get(0);
    				iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.persistirFactura:... kDatoFiscal  " );
    	    		objFacturaH.setSxml(objFacturaBean.getSxml() + "");
    				iObjSesion.update(objFacturaH);
    				iObjSesion.flush();
    			}
    	
			return objFacturaBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.persistirFactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        }
	}
	
	public List getDesgloceExamenesFactura(Integer kFactura){	
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		List  lstExamen=new ArrayList();
		try {
			objConn = iObjSesion.connection();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement objStatement = null;
		ResultSet rst = null;
		String strSQL = "";	
		try {			    
			
				objStatement = objConn.createStatement();		
				strSQL="select count(toesf.kordensucursal) cantidad, toesf.cexamen as cexamen, to_char('NO APLICA') unidad, toesf.sexamen as sexamen, "+
						"round (sum((toesf.mfacturaempresa/1.16))/ count(toesf.kordensucursal),2)costo_unitario, "+
						"(round (sum((toesf.mfacturaempresa/1.16)),2) )importe, tosf.kfactura as kfactura "+
						"from	t_orden_sucursal tos,t_orden_sucursal_fac tosf, t_orden_examen_sucursal_fac toesf, "+
						"c_examen ce, c_convenio cc where toesf.kordensucursal = tosf.kordensucursal "+
						"and tos.kordensucursal = tosf.kordensucursal and toesf.cexamen = ce.cexamen and cc.cconvenio  = tosf.cconvenio "+
						"AND tosf.csucursal <> 100 and tosf.kfactura in ("+kFactura+") and toesf.cperfil = -1 and toesf.cestadoregistro <> 43 "+
						"and toesf.kordensucursalfac = tosf.kordensucursalfac group by  toesf.cexamen,toesf.sexamen, tosf.kfactura "+
						"UNION ALL select count(distinct(toesf.kordensucursal)), toesf.cperfil as cexamen,to_char('NO APLICA') unidad, toesf.sperfil as sexamen, "+
						"round (sum((toesf.mfacturaempresa/1.16))/ count(distinct(toesf.kordensucursal)),2)costo_unitario, "+
						"(round (sum((toesf.mfacturaempresa/1.16)),2) )importe, tosf.kfactura from t_orden_sucursal_fac tosf, "+
						"t_orden_examen_sucursal_fac toesf, c_convenio cc, c_perfil cp where toesf.kordensucursal = tosf.kordensucursal "+
						"and toesf.cperfil = cp.cperfil and cc.cconvenio  = tosf.cconvenio and tosf.csucursal <> 100 "+
						"and toesf.cperfil <> -1 and toesf.cestadoregistro <> 43 and tosf.kfactura in ("+kFactura+") and toesf.kordensucursalfac = tosf.kordensucursalfac "+
						"group by tosf.kfactura , toesf.cperfil ,toesf.sperfil order by sexamen";
				iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.createListExamenes:Consulta...  "+strSQL);
				rst = objStatement.executeQuery(strSQL);
				while(rst.next()) {	
					DesgloceFacturaExamenBean objDesgloceFacturaBean = new DesgloceFacturaExamenBean();
					objDesgloceFacturaBean.setCantidad(rst.getString("cantidad"));
					objDesgloceFacturaBean.setCodigo(rst.getString("cexamen"));
					objDesgloceFacturaBean.setConcepto(rst.getString("sexamen").trim());
					objDesgloceFacturaBean.setImporte(rst.getString("importe"));
					objDesgloceFacturaBean.setPreciounitario(rst.getString("costo_unitario"));
					objDesgloceFacturaBean.setUnidad(rst.getString("unidad"));
					lstExamen.add(objDesgloceFacturaBean);
				}
				iObjLog.debug("FacturaElectronicaMayoreoDao.createListExamenes:Saliendo...  "+lstExamen.size());
				return lstExamen;
		} catch (Exception exp) {
			  System.err.print(exp);			
				return null;
		} finally {
			if (rst != null){
				rst = null;
			}			
			if (objStatement != null){
				objStatement = null;
			}
			
		}
	}	
	
	public FacturaSustitucionBean getUUIDTfactura(String ufoliosustitucion,int marca, String serie ) {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		FacturaSustitucionBean facturaSustitucionBean = new FacturaSustitucionBean();
		
		String csucursal="";
		
		if(marca==1){
			 csucursal="1003";
		}else if (marca==4){
			csucursal="1012";
		}else if (marca==5){
			csucursal="1013";
		}else if (marca==7){
			if(serie.equals("AJP")){
				csucursal="1014";				
			}else if(serie.equals("AJL")){
				csucursal="1015";
			}
		}
		
		
		try {
			objConn = iObjSesion.connection();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement objStatement = null;
		ResultSet rst = null;
		String strSQL = "";	
		try {			    
			
				objStatement = objConn.createStatement();		
				strSQL="select suddi,cestadoregistro from t_factura where ufoliofactura = "+ufoliosustitucion+" and csucursal = "+csucursal;
				iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.getUUIDTfactura:Consulta...  "+strSQL);
				rst = objStatement.executeQuery(strSQL);
				while(rst.next()) {	
					facturaSustitucionBean.setSuuid(rst.getString("suddi"));
					facturaSustitucionBean.setCestadoregistro(rst.getInt("cestadoregistro"));			
				}
				iObjLog.debug("FacturaElectronicaMayoreoDao.getUUIDTfactura:Saliendo...  ");
				return facturaSustitucionBean;
		} catch (Exception exp) {
			  System.err.print(exp);			
				return null;
		} finally {
			if (rst != null){
				rst = null;
			}			
			if (objStatement != null){
				objStatement = null;
			}
		}
	}
	

	public void persistirAjusteFactura(Integer kfactura,int user_id_change,double msubtotal,double miva,double mtotal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		String strSQL = "";
		Connection objConnection = iObjSesion.connection();
		Statement stmt = objConnection.createStatement();
		iObjLog.debug("Entrando FacturaElectronicaMayoreoDao.persistirAjusteFactura:...  " + kfactura + " user_id_change "+ user_id_change );
    	try{            
			strSQL="UPDATE T_FACTURA SET MSUBTOTAL="+ msubtotal +",MIVA=" + miva +",MTOTAL="+ mtotal +",USER_ID_CHANGE=" + user_id_change + " WHERE KFACTURA=" + kfactura +";";		
			iObjLog.debug("Consulta FacturacionElectronicaMayoreoDao.persistirAjusteFactura " + strSQL);
			stmt.execute(strSQL);			
			iObjLog.debug("Saliendo FacturacionElectronicaMayoreoDao.persistirAjusteFactura ");  
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.persistirAjusteFactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objConnection.close();
			stmt.close();
        }
	}
	
	public void persistirMetodoPago(String strNoCuenta,String strMetodoPago,int cconvenio) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		String strSQL = "";
		Connection objConnection = iObjSesion.connection();
		Statement stmt = objConnection.createStatement();
		try {			
			
			if(!strMetodoPago.equals("99")){
				 strSQL="UPDATE C_CONVENIO_DATO_FISCAL SET SDIGITOSCUENTA='" + strNoCuenta+ "',STIPOPAGO='" + strMetodoPago +"' WHERE CCONVENIO=" + cconvenio +";";
			} else {
				strSQL="UPDATE C_CONVENIO_DATO_FISCAL SET SDIGITOSCUENTA='',STIPOPAGO='' WHERE CCONVENIO=" + cconvenio +";";
			}
			iObjLog.debug("Consulta FacturacionElectronicaMayoreoDao.persistirMetodoPago " + strSQL);
			stmt.execute(strSQL);
			iObjLog.debug("Saliendo FacturacionElectronicaMayoreoDao.persistirMetodoPago ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionElectronicaMayoreoDao.persistirMetodoPago: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
        	objConnection.close();
			stmt.close();	
        }		
		
	}
}
