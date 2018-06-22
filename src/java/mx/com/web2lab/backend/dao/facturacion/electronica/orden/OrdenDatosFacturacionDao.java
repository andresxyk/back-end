package mx.com.web2lab.backend.dao.facturacion.electronica.orden;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.facturacion.electronica.FacturaElectronicaBean;
import mx.com.web2lab.backend.dao.ap.DatosOrdenDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac;
import mx.com.web2lab.backend.util.Formatos;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrdenDatosFacturacionDao {

	private static Log iObjLog = LogFactory.getLog(OrdenDatosFacturacionDao.class);
	    
	private Session iObjSesion = null;
	
	public OrdenDatosFacturacionDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	private void initConnectionDB() {
		iObjSesion = HibernateUtil.getSession();
		HibernateUtil.beginTrans();
	}
	
	public TFactura buscarFacturaHB(FacturaElectronicaBean objfilexmlbean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		TFactura objFactura = null;
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.buscarFacturaHB:Entrando...  " + objfilexmlbean.getKfactura());
			HibernateUtil.beginTrans();
			strQuery = "select bOF 							\n" +					
			   		   "from TFactura bOF 					\n" +	
			           "where ";
			if (objfilexmlbean.getKfactura() > 0) {
				strQuery = strQuery  + " bOF.kfactura =  " + objfilexmlbean.getKfactura();
			} else {
				strQuery = strQuery  + " bOF.ufoliofactura =  " + objfilexmlbean.getSfolio() + " and bOF.ssucursal = 'EMPRESAS' " ;
			}			
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			if (objListaFactura.isEmpty() == false) {
				for (int inti=0;inti<objListaFactura.size();inti++){
					objFactura = (TFactura)objListaFactura.get(inti);
				}
			}			
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objListaFactura.clear();
    		objListaFactura = null;
        	HibernateUtil.closeSession();
    	}		
    	return objFactura;
	}		
	
	public String crearOrdenFacturar(String kAdmision, int intUser) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		String strQuery = "";
		String strReturn = "";
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.crearOrdenFacturar:...  " + kAdmision + " Usuario " + intUser);
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	        strQuery = "begin										\n" + 
					   "	fact_detalle (" + kAdmision + ",0,0,35);	\n" +
					   " end;										\n";
			iObjLog.debug("Consulta OrdenDatosFacturacionDao.crearOrdenFacturar:...  " + strQuery);
			objSta.execute(strQuery);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.crearOrdenFacturar: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
        }
	}		
	
/***************************No se utilizara por cuestiones de CFDI **********************/
	public FacturaElectronicaBean generaSelloCadenaDigital(FacturaElectronicaBean objFacturaBean) throws Exception {		
//		iObjSesion = HibernateUtil.getSession();
//		Connection objCon = null;
//		Statement objSta = null;
//		ResultSet objRst = null;
//		String strQuery = "";
//		String strQueryError = "";
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.generaSelloCadenaDigital:...  " + objFacturaBean.getkOrdenSucursal() + " Usuario " + objFacturaBean.getTurbine_User());
    	try{            
//    		objCon = iObjSesion.connection();
//            objSta = null;
//	        objSta = objCon.createStatement();
//	        strQuery = "SELECT encode(digest(f_getxml_cadena(" + objFacturaBean.getKfactura() + "), 'sha1'), 'hex') cadenasha1 ,\n" +
//	        		   "	   f_getxml_cadena(" + objFacturaBean.getKfactura() + ") cadenaoriginal \n";  
////	        strQueryError = "SELECT encode(digest(f_getxml_cadena(" + objFacturaBean.getKfactura() + "), 'sha1'), 'hex') cadenasha1 ,\n" +
////	        		   "	   f_getxml_cadena1(" + objFacturaBean.getKfactura() + ") cadenaoriginal \n";  
//	        iObjLog.debug("Consulta OrdenDatosFacturacionDao.generaSelloCadenaDigital:...  " + strQuery);
//	        /*******************No existe conexion con el SAT ************************************ OMRR-27082013 15:02*************/
//	        try {
//		        iObjLog.debug("Consulta OrdenDatosFacturacionDao.generaSelloCadenaDigital:Intento1...." + strQuery);
//				objRst = objSta.executeQuery(strQuery);
//				while(objRst.next()) {
//					objFacturaBean.setScadenaoriginal(objRst.getString("cadenaoriginal"));
//					objFacturaBean.setScadenaoriginaldigest(objRst.getString("cadenasha1"));
//				}
//	        } catch (SQLException SQLexp) {
//				iObjLog.error("ERROR OrdenDatosFacturacionDao.crearOrdenFacturar:Intento2....Error1...", SQLexp);
//	        	try {
//					objRst = objSta.executeQuery(strQuery);
//					while(objRst.next()) {
//						objFacturaBean.setScadenaoriginal(objRst.getString("cadenaoriginal"));
//						objFacturaBean.setScadenaoriginaldigest(objRst.getString("cadenasha1"));
//					}
//		        } catch (SQLException SQL2exp) {
//					iObjLog.error("ERROR OrdenDatosFacturacionDao.crearOrdenFacturar:Intento3....Error2...", SQL2exp);
//		        	try {
//						objRst = objSta.executeQuery(strQuery);
//						while(objRst.next()) {
//							objFacturaBean.setScadenaoriginal(objRst.getString("cadenaoriginal"));
//							objFacturaBean.setScadenaoriginaldigest(objRst.getString("cadenasha1"));
//						}
//		        	} catch (SQLException SQL3exp) {
//						iObjLog.error("ERROR OrdenDatosFacturacionDao.crearOrdenFacturar:Intento4....Error3...", SQL3exp);
//						objRst = objSta.executeQuery(strQuery);
//						while(objRst.next()) {
//							objFacturaBean.setScadenaoriginal(objRst.getString("cadenaoriginal"));
//							objFacturaBean.setScadenaoriginaldigest(objRst.getString("cadenasha1"));
//						}
//		        	}
//		        }
//	        }
	        /*******************No existe conexion con el SAT ************************************/
	        iObjLog.debug("Consulta OrdenDatosFacturacionDao.generaSelloCadenaDigital:...  CadenaOriginal \n " + objFacturaBean.getScadenaoriginal() + "\n");
			return objFacturaBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.generaSelloCadenaDigital: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
//        	HibernateUtil.closeSession();
//    		objSta = null;
//    		objRst = null;
        }
	}		

	public FacturaElectronicaBean generaUpdateOrdenFac(FacturaElectronicaBean objFacturaBean) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.generaCopyOrdenFac:...  " + objFacturaBean.getkOrdenSucursal() + " Usuario " + objFacturaBean.getTurbine_User());
    	try{            
    		objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
//	        if (objFacturaBean.getcSucursal() != 1003) {
//		        strQuery = "begin																		\n" + 
//						   "	fact_detalle (" + objFacturaBean.getkOrdenSucursal() + "," + objFacturaBean.getKfactura() + ",0,35);	\n" +
//						   " end;																		\n";
//	        } else {
	        	strQuery = "UPDATE T_ORDEN_SUCURSAL_FAC														\n" +
						   "SET KFACTURA=" + objFacturaBean.getKfactura() + ", 								\n"+
						   "    CESTADOREGISTRO=35															\n" +
						   "WHERE CESTADOREGISTRO NOT IN (27,35,38,39,48) AND 								\n" +
						   "	  KORDENSUCURSALFAC IN (													\n" +
						   "	  	SELECT MAX(KORDENSUCURSALFAC)											\n" +
						   "	 	FROM T_ORDEN_SUCURSAL_FAC												\n" +
						   "     	WHERE KORDENSUCURSAL IN (" + objFacturaBean.getkOrdenSucursal() + "))	\n";
//	        }
			iObjLog.debug("Consulta OrdenDatosFacturacionDao.generaCopyOrdenFac:...  " + strQuery);
			objSta.execute(strQuery);
	        iObjLog.debug("Consulta OrdenDatosFacturacionDao.generaCopyOrdenFac:...  CadenaOriginal \n " + objFacturaBean.getScadenaoriginal() + "\n");
			return objFacturaBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.generaCopyOrdenFac: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
        }
	}		

	public FacturaElectronicaBean generaCopyOrdenFacOnlySucursal(FacturaElectronicaBean objFacturaBean,String kAdmision) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.generaCopyOrdenFacOnlySucursal:...  " + objFacturaBean.getkOrdenSucursal() + " Usuario " + objFacturaBean.getTurbine_User());
    	try{            
    		objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	        if (objFacturaBean.getcSucursal() != 1003 || objFacturaBean.getcSucursal() != 1012 || objFacturaBean.getcSucursal() != 1013) {
		        strQuery = "begin																			\n" + 
						   "	fact_detalle (" + kAdmision + "," + objFacturaBean.getKfactura() + ",0,37);	\n" +
						   " end;																			\n";
	        }
			iObjLog.debug("Consulta OrdenDatosFacturacionDaogeneraCopyOrdenFacOnlySucursal:...  " + strQuery);
			objSta.execute(strQuery);
	        iObjLog.debug("Consulta OrdenDatosFacturacionDao.generaCopyOrdenFacOnlySucursal:...  CadenaOriginal \n " + objFacturaBean.getScadenaoriginal() + "\n");
			return objFacturaBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.generaCopyOrdenFacOnlySucursal: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
        }
	}		
		
	public String cancelarOrdenesFactura(FacturaElectronicaBean objfilexmlbean,int intCopiarInformacion) throws Exception {
		TFactura objFactura = null;
		String strQuery = "";
		Connection objCon = null;
		Statement objSta = null;
		String strReturn = "";
    	try{
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.cancelarOrdenesFactura:Entrando...  " + objfilexmlbean.getKfactura());
				objFactura = this.buscarFacturaHB(objfilexmlbean);
				if (objFactura.getCestadoregistro() != 34) {
					this.initConnectionDB();
					objFactura.setCestadoregistro(34);
					objFactura.setDcancelacionfactura(new Date());
					objFactura.setUserIdChange(objfilexmlbean.getTurbine_User());
					iObjSesion.update(objFactura);
					iObjSesion.flush();
		    		objCon = iObjSesion.connection();
			        objSta = objCon.createStatement();
			        if (intCopiarInformacion == 0) {
				        strQuery = "begin																			\n" + 
								   "	olab_inserta_orden_refacturacion_suc (" + objFactura.getKfactura() + " );	\n" +
								   " end;																			\n";
			        } else {
				        strQuery = "begin																			\n" + 
						   			"	olab_inserta_orden_refacturacion_fac (" + objFactura.getKfactura() + " );	\n" +
						   			" end;																			\n";		        	
			        }
					iObjLog.debug("Consulta OrdenDatosFacturacionDao.cancelarOrdenesFactura:...  " + strQuery);
					objSta.execute(strQuery);
		        	strQuery = "UPDATE T_ORDEN_SUCURSAL_FAC								\n" +
			   		   		   "SET CESTADOREGISTRO=39									\n" +
			   		   		   "WHERE KFACTURA IN (" + objFactura.getKfactura() + ")	\n";
					iObjLog.debug("Consulta OrdenDatosFacturacionDao.cancelarOrdenesFactura:...  " + strQuery);
					objSta.execute(strQuery);
					strReturn = ("Exito en la Cancelacion de la Factura " + objfilexmlbean.getSfolio());
				} else {
					strReturn = ("La factura " + objFactura.getUfoliofactura() + " ya esta cancelada");
				}
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.cancelarOrdenesFactura:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.cancelarOrdenesFactura: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objFactura = null;
    		objSta = null;
    		HibernateUtil.closeSession();
    	}	
    	return strReturn;
	}		
	
	public void actualizarFacturaXML(FacturaElectronicaBean objfilexmlbean) throws Exception {
		TFactura objFactura = null;
    	try{
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.actualizarFacturaXML:Entrando...  " + objfilexmlbean.getKfactura());
				objFactura = this.buscarFacturaHB(objfilexmlbean);
				this.initConnectionDB();
				objFactura.setSxmlsello(objfilexmlbean.getSxml());
				objFactura.setSsellodigital(objfilexmlbean.getSsellodigital());
				iObjSesion.update(objFactura);
				iObjSesion.flush();
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.actualizarFacturaXML:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.actualizarFacturaXML: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objFactura = null;
    		HibernateUtil.closeSession();
    	}		
	}		
	
	public FacturaElectronicaBean persistirFactura(FacturaElectronicaBean objFacturaBean) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.persistirFactura:...  " + objFacturaBean.getkOrdenSucursal() + " Usuario " + objFacturaBean.getTurbine_User());
    	try{            
    		TFactura objFacturaH = new TFactura();
	    		objFacturaH.setCcliente(Integer.parseInt(objFacturaBean.getCcliente()));
	    		objFacturaH.setCconvenio(Integer.parseInt(Long.toString(objFacturaBean.getCconvenio())));
	    		if (objFacturaBean.getCmarca() == 1) {
	    			objFacturaH.setCentidadlegal(1);
	    		} else if (objFacturaBean.getCmarca() == 4) {
	    			objFacturaH.setCentidadlegal(5);
	    		}
	    		objFacturaH.setCestadoregistro(33);
	    		objFacturaH.setCformapago(1);
	    		objFacturaH.setCsucursal(objFacturaBean.getObjSucursalBean().getCsucursal().intValue());
	    		objFacturaH.setCtipoimpuesto(1);
	    		objFacturaH.setDcancelacionfactura(new Date());
	    		objFacturaH.setDregistro(new Date());
	    		iObjLog.debug("Entrando OrdenDatosFacturacionDao.persistirFactura:... kDatoFiscal  " + objFacturaBean.gethDatosFiscal() + " Usuario " + objFacturaBean.getTurbine_User());
	    		objFacturaH.setKdatofiscal(objFacturaBean.gethDatosFiscal());
	    		objFacturaH.setMsubtotal(new BigDecimal(objFacturaBean.getMsubtotal()));
	    		objFacturaH.setMcopago(new BigDecimal(0));
	    		objFacturaH.setMdescuento(new BigDecimal(objFacturaBean.getMdescuento()));
	    		objFacturaH.setMiva(new BigDecimal(objFacturaBean.getMiva()));
	    		objFacturaH.setMtotal(new BigDecimal(objFacturaBean.getMtotal()));
	    		objFacturaH.setScadenaoriginal("");
	    		objFacturaH.setSobservacion("");
	    		objFacturaH.setSsellodigital("");
	    		objFacturaH.setSserie(objFacturaBean.getSserie() + "");
	    		objFacturaH.setSsucursal(objFacturaBean.getObjSucursalBean().getSnombresucursal() + "");
	    		objFacturaH.setSxml(objFacturaBean.getSxml() + "");
	    		objFacturaH.setSxmlsello("");
	    		objFacturaH.setUfoliofactura(Integer.parseInt(objFacturaBean.getSfolio()));
	    		objFacturaH.setUserId(objFacturaBean.getTurbine_User());
	    		objFacturaH.setUserIdChange(objFacturaBean.getTurbine_User());
	    	iObjSesion.save(objFacturaH);	
	    	iObjSesion.flush();
	    	objFacturaBean.setKfactura(objFacturaH.getKfactura().intValue());
			return objFacturaBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.persistirFactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        }
	}		
	
	public FacturaElectronicaBean searchOrdenFacturacion(FacturaElectronicaBean objFacturaBean,String kAdmision,boolean bolRefacturacion) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		Statement objStaUpdate = null;
		Statement objStaSinFactura = null;
		Statement objSta2 = null;
		ResultSet objResultSet = null;
		ResultSet objResultSetSinFactura = null;
		ResultSet objResultSet2 = null;
		String strQuery = "";
		Date objDateNow = new Date();
		Date objRegistro = null;
		int intFactura = 0;
		int intFolio = 0;
		int kOrdenSucursalFac = 0;
		String strSerie = "";
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.SearchOrdenNuevaViaje:...  " + kAdmision);
    	try{            
//    		this.initConnectionDB();
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
                    						 ResultSet.CONCUR_READ_ONLY);
	        objFacturaBean.setcFormato(-1);
	        objFacturaBean.setSFacturaOld("");
	          strQuery = "SELECT TF.UFOLIOFACTURA,TF.SSERIE,TF.KFACTURA,CC.CFORMATOFACTURA,TOSF.DREGISTRO,TOSF.KORDENSUCURSALFAC,CC.CCONVENIO,TOSF.CMARCA  \n"+
						 "FROM T_ORDEN_SUCURSAL_FAC TOSF INNER JOIN T_FACTURA TF ON TOSF.KFACTURA=TF.KFACTURA									\n"+
						 "INNER JOIN C_CONVENIO_DATO_FISCAL CC ON TOSF.CCONVENIO=CC.CCONVENIO													\n"+
						 "INNER JOIN C_CONVENIO CCON ON CCON.CCONVENIO=CC.CCONVENIO AND CCON.CTIPOCONVENIO IN (22)								\n"+
						 "WHERE  TOSF.KORDENSUCURSAL IN (" + kAdmision + ") AND TOSF.CESTADOREGISTRO=35											\n"+
						 "UNION ALL																												\n"+					
				         "SELECT TF.UFOLIOFACTURA,TF.SSERIE,TF.KFACTURA,0,TOSF.DREGISTRO,TOSF.KORDENSUCURSALFAC,CC.CCONVENIO,TOSF.CMARCA		\n"+
							 "FROM T_ORDEN_SUCURSAL_FAC TOSF INNER JOIN T_FACTURA TF ON TOSF.KFACTURA=TF.KFACTURA								\n"+
							 "INNER JOIN C_CONVENIO CC ON TOSF.CCONVENIO=CC.CCONVENIO AND CC.CTIPOCONVENIO NOT IN (22)							\n"+
							 "WHERE  TOSF.KORDENSUCURSAL IN (" + kAdmision + ") AND TOSF.CESTADOREGISTRO=35										\n"+
						 "ORDER BY KORDENSUCURSALFAC																							";
				iObjLog.debug("Consulta OrdenDatosFacturacionDao.SearchOrdenNuevaViaje:...  " + strQuery);
			  objResultSet = objSta.executeQuery(strQuery);
			  try {
				  if (objResultSet != null) {					
					  iObjLog.debug("Consulta OrdenDatosFacturacionDao.SearchOrdenNuevaViaje:...  1");
					  while(objResultSet.next()) {						  
						  intFolio = objResultSet.getInt("UFOLIOFACTURA");
						  intFactura = objResultSet.getInt("KFACTURA");
						  strSerie = objResultSet.getString("SSERIE");
						  objRegistro = objResultSet.getDate("DREGISTRO");
						  kOrdenSucursalFac = objResultSet.getInt("KORDENSUCURSALFAC");
						  objFacturaBean.setcFormato(objResultSet.getInt("CFORMATOFACTURA"));
						  objFacturaBean.setCconvenio(objResultSet.getLong("CCONVENIO"));
						  objFacturaBean.setCmarca(objResultSet.getInt("CMARCA"));
						  if (intFolio > 0) {
						      objFacturaBean.setSFacturaOld(this.llenaIdFactura(strSerie,intFolio + "", 8));						  
						  } else {
						      objFacturaBean.setSFacturaOld("");						  
						  }
						  if (bolRefacturacion) {
							  objStaUpdate = objCon.createStatement();
							  strQuery = "UPDATE T_ORDEN_SUCURSAL_FAC SET CESTADOREGISTRO=39 WHERE KORDENSUCURSALFAC IN (" + kOrdenSucursalFac + ")";
							  objStaUpdate.execute(strQuery);
							  strQuery = "UPDATE T_FACTURA SET CESTADOREGISTRO=34 WHERE KFACTURA IN (" + intFactura  + ")";
							  objStaUpdate.execute(strQuery);
						      objFacturaBean.setSFacturaOld("");
							  this.generaCopyOrdenFacOnlySucursal(objFacturaBean,kAdmision);
						  }
					  }					
				  }
			} catch (Exception aObjExcepcion2) {
//				iObjLog.error("ERROR OrdenDatosFacturacionDao.SearchOrdenNuevaViaje: ", aObjExcepcion2);
//				throw aObjExcepcion2;					  
			}
			  if (objFacturaBean.getcFormato() == -1) {
		          strQuery = "SELECT CC.CFORMATOFACTURA,TOS.DREGISTRO,CC.CCONVENIO  										\n"+
							 "FROM T_ORDEN_SUCURSAL TOS INNER JOIN C_CONVENIO_DATO_FISCAL CC ON TOS.CCONVENIO=CC.CCONVENIO	\n"+
							 "WHERE  TOS.KORDENSUCURSAL IN (" + kAdmision + ") ";
		          objStaSinFactura = objCon.createStatement();
				  objResultSetSinFactura = objStaSinFactura.executeQuery(strQuery);
				  while(objResultSetSinFactura.next()) {						  
					  objFacturaBean.setcFormato(objResultSetSinFactura.getInt("CFORMATOFACTURA"));
					  objRegistro = objResultSetSinFactura.getDate("DREGISTRO");
					  objFacturaBean.setCconvenio(objResultSetSinFactura.getInt("CCONVENIO"));
				  }
		          objSta2 = objCon.createStatement();
				  boolean bolSinRegistroFac = true;
		          strQuery = "SELECT TOSF.KORDENSUCURSALFAC						\n"+
							 "FROM T_ORDEN_SUCURSAL_FAC TOSF 					\n"+
							 "WHERE  TOSF.KORDENSUCURSAL IN (" + kAdmision + ") \n";
		          objResultSet2 = objSta2.executeQuery(strQuery);
				  while(objResultSet2.next()) {
					  bolSinRegistroFac = false;
				  }
				  if (bolSinRegistroFac) {
					  this.generaCopyOrdenFacOnlySucursal(objFacturaBean,kAdmision);
				  }
			  }
			return objFacturaBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.SearchOrdenNuevaViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	if (objSta != null) {
	        	objSta.close();
	    		objSta = null;
        	}
        	if (objSta2 != null) {
	        	objSta2.close();
	    		objSta2 = null;
        	}
        	if (objStaSinFactura != null) {
        		objStaSinFactura.close();
        		objStaSinFactura = null;
        	}
    		if (objStaUpdate != null){
	    		objStaUpdate.close();
	    		objStaUpdate = null;
    		}
    		if (objResultSet != null) {
	    		objResultSet.close();
	    		objResultSet = null;
    		}
    		if (objResultSet2 != null) {
	    		objResultSet2.close();
	    		objResultSet2 = null;
    		}
    		if (objResultSetSinFactura != null) {
    			objResultSetSinFactura.close();
    			objResultSetSinFactura = null;
    		}
        	HibernateUtil.closeSession();
        }
	}		

	public int numeroFacturas(int kAdmision) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		int intFolio = 0;
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.numeroFacturas:...  " + kAdmision);
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
	        strQuery = "SELECT distinct kordensucursal, count(*) as nofacturas	\n" +
	        		  	 "FROM t_orden_sucursal_fac									\n" +
	        		  	 "WHERE kordensucursal in (" + kAdmision + ")				\n" +
	        		  	 "GROUP BY  kordensucursal									\n" +
	        		  	 "ORDER BY 2												\n";											
			iObjLog.debug("Consulta OrdenDatosFacturacionDao.numeroFacturas:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				  iObjLog.debug("Consulta OrdenDatosFacturacionDao.numeroFacturas:...  1");
				  while(objResultSet.next()) {						  
					  intFolio = objResultSet.getInt("nofacturas");
				  }					
			}
			return intFolio;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.numeroFacturas: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	if (objSta != null) {
	        	objSta.close();
	    		objSta = null;
        	}
    		if (objResultSet != null) {
	    		objResultSet.close();
	    		objResultSet = null;
    		}
        	HibernateUtil.closeSession();
        }
	}		
	
	

	public FacturaElectronicaBean searchOrdenFacturacionIntegral(FacturaElectronicaBean objFacturaBean,int kAdmision,boolean bolRefacturacion) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		Statement objStaUpdate = null;
		Statement objStaSinFactura = null;
		Statement objSta2 = null;
		ResultSet objResultSet = null;
		ResultSet objResultSetSinFactura = null;
		ResultSet objResultSet2 = null;
		String strQuery = "";
		Date objDateNow = new Date();
		int intFactura = 0;
		int intFolio = 0;
		int kOrdenSucursalFac = 0;
		String strSerie = "";
		TOrdenSucursal objOrdenSucursal 		= null;				
		TOrdenSucursalFac objOrdenSucursalFac 	= null;
		TFactura objFactura						= null;
		OrdenBean objOrdenReturn 				= null;
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.SearchOrdenNuevaViaje:...  " + kAdmision);
    	try{            
	        objFacturaBean.setcFormato(-1);
	        objFacturaBean.setSFacturaOld("");
    		DatosOrdenDao objDatosDao = new DatosOrdenDao();
       		List lstOrdenFactura = objDatosDao.buscarOrdenExamenFactura(kAdmision);
    		objOrdenSucursal 		= (TOrdenSucursal)lstOrdenFactura.get(0);				
    		objOrdenSucursalFac 	= (TOrdenSucursalFac)lstOrdenFactura.get(1);
    		objFactura				= (TFactura)lstOrdenFactura.get(2);
    		objOrdenReturn 			= (OrdenBean)lstOrdenFactura.get(3);
			if (objFactura != null) {						  
				intFolio 			= objFactura.getUfoliofactura();
				intFactura 			= objFactura.getKfactura().intValue();
				strSerie 			= objFactura.getSserie();
				kOrdenSucursalFac 	= objOrdenSucursalFac.getKordensucursalfac().intValue();
				if (objOrdenSucursalFac.getCconvenio().getCtipoconvenio().getCtipoconvenio().intValue() == 22){
					objFacturaBean.setcFormato(1);
				} else {
					objFacturaBean.setcFormato(0);
				}					
				objFacturaBean.setCconvenio(objOrdenReturn.getCconvenio());
				if (intFolio > 0) {
					objFacturaBean.setSFacturaOld(this.llenaIdFactura(strSerie,intFolio + "", 8));						  
				} else {
					objFacturaBean.setSFacturaOld("");						  
				}
				if (bolRefacturacion) {
		        	objCon = iObjSesion.connection();
					objStaUpdate = objCon.createStatement();
					strQuery = "UPDATE T_ORDEN_SUCURSAL_FAC SET CESTADOREGISTRO=39 WHERE KORDENSUCURSALFAC IN (" + kOrdenSucursalFac + ")";
					objStaUpdate.execute(strQuery);
					strQuery = "UPDATE T_FACTURA SET CESTADOREGISTRO=34 WHERE KFACTURA IN (" + intFactura  + ")";
					objStaUpdate.execute(strQuery);
					objFacturaBean.setSFacturaOld("");
					this.generaCopyOrdenFacOnlySucursal(objFacturaBean,kAdmision+"");
				}
			}					
			  if (objFacturaBean.getcFormato() == -1) {
		          strQuery = "SELECT CC.CFORMATOFACTURA,TOS.DREGISTRO,CC.CCONVENIO  										\n"+
							 "FROM T_ORDEN_SUCURSAL TOS INNER JOIN C_CONVENIO_DATO_FISCAL CC ON TOS.CCONVENIO=CC.CCONVENIO	\n"+
							 "WHERE  TOS.KORDENSUCURSAL IN (" + kAdmision + ") ";
		          objStaSinFactura = objCon.createStatement();
				  objResultSetSinFactura = objStaSinFactura.executeQuery(strQuery);
				  while(objResultSetSinFactura.next()) {						  
					  objFacturaBean.setcFormato(objResultSetSinFactura.getInt("CFORMATOFACTURA"));
					  objFacturaBean.setCconvenio(objResultSetSinFactura.getInt("CCONVENIO"));
				  }
		          objSta2 = objCon.createStatement();
				  boolean bolSinRegistroFac = true;
		          strQuery = "SELECT TOSF.KORDENSUCURSALFAC						\n"+
							 "FROM T_ORDEN_SUCURSAL_FAC TOSF 					\n"+
							 "WHERE  TOSF.KORDENSUCURSAL IN (" + kAdmision + ") \n";
		          objResultSet2 = objSta2.executeQuery(strQuery);
				  while(objResultSet2.next()) {
					  bolSinRegistroFac = false;
				  }
				  if (bolSinRegistroFac) {
					  this.generaCopyOrdenFacOnlySucursal(objFacturaBean,kAdmision + "");
				  }
			  }
			return objFacturaBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.SearchOrdenNuevaViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	if (objSta != null) {
	        	objSta.close();
	    		objSta = null;
        	}
        	if (objSta2 != null) {
	        	objSta2.close();
	    		objSta2 = null;
        	}
        	if (objStaSinFactura != null) {
        		objStaSinFactura.close();
        		objStaSinFactura = null;
        	}
    		if (objStaUpdate != null){
	    		objStaUpdate.close();
	    		objStaUpdate = null;
    		}
    		if (objResultSet != null) {
	    		objResultSet.close();
	    		objResultSet = null;
    		}
    		if (objResultSet2 != null) {
	    		objResultSet2.close();
	    		objResultSet2 = null;
    		}
    		if (objResultSetSinFactura != null) {
    			objResultSetSinFactura.close();
    			objResultSetSinFactura = null;
    		}
        	HibernateUtil.closeSession();
        }
	}			
	
	public String getOrdenesNewViaje(int intSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.getOrdenesSinViaje:...  " + intSucursal);
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
			strQuery =	"select  tos.uorden orden,tos.kordensucursal admision,																	\n"+
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 							\n"+
						"        to_char(tos.dregistro,'dd-mm-yyyy') captura,																	\n"+
						"        to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,															\n"+
						"        nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,	\n"+
						"        0 burgente,																									\n"+
						"        tos.mpagopaciente pagopaciente,																				\n"+
						"        cs.snombresucursal  sunidad,																					\n"+
						"        cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,												\n"+
						"        tu.first_name||' '||tu.last_name capturo																		\n"+
						"from  t_orden_sucursal tos 																							\n"+
						"INNER JOIN t_orden_sucursal_fac tpp ON tos.kordensucursal = tpp.kordensucursal AND tpp.cestadoregistro = 27			\n"+
						"INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente													\n"+
						"INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal													\n"+
						"INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio													\n"+
						"INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id														\n"+
						"where tos.mpagopaciente = 0																							\n"+
						"		and tos.csucursal = " + intSucursal + "																			\n"+
						"order by admision";
				iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				strQuery = this.getEncabezadoOrdenesSinPago("Ordenes Viaje Actual");
				strQuery = strQuery + this.getBodyOrdenes(objResultSet);
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		

	private void actualizaOrdenes(int intSucursal,int User,Connection objCon) throws Exception {		
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.cerrarViaje:...  " + intSucursal);
    	try{            
	        objSta = objCon.createStatement();
			strQuery =	"UPDATE t_orden_sucursal_fac 																							\n"+
						"SET cestadoregistro=28,user_id=" + User + ",dcierre=sysdate															\n"+
						"WHERE kordensucursalfac in 																							\n"+
						"	  ( select  tpp.kordensucursalfac																					\n"+
						"		from  t_orden_sucursal tos 																						\n"+
						"			INNER JOIN t_orden_sucursal_fac tpp ON tos.kordensucursal = tpp.kordensucursal AND tpp.cestadoregistro = 27	\n"+
						"			INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente										\n"+
						"			INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal											\n"+
						"			INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio											\n"+
						"			INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id											\n"+
						"		where tos.mpagopaciente = 0																						\n"+
						"			and tos.csucursal = " + intSucursal + ")";
				iObjLog.debug("Consulta ViajeFacturacionDao.cerrarViaje:...  " + strQuery);
				objSta.execute(strQuery);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.cerrarViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
    		objSta = null;
        }
	}		
	
	public String cerrarViaje(int intSucursal,int User) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet rst = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.cerrarViaje:...  " + intSucursal);
    	try{            
        	objCon = iObjSesion.connection();
    		this.actualizaOrdenes(intSucursal, User, objCon);
	        objSta = objCon.createStatement();	        
			strQuery =	"SELECT trim(to_char(nvl(tosf.kviajefac,0),'00000000')) CodigoBarras,					\n" +
						"      	to_char(tosf.csucursal) || '-' || 												\n" +	
			    		"		cs.snombresucursal || ' Viaje ' || 												\n" +
			    		"		to_char(tosf.kviajefac) || ' ' || to_char(tosf.dcierre) Encabezado,				\n" +
			    		"		'Ordenes: ' || count(tosf.*) Elementos											\n" +
						"FROM t_orden_sucursal_fac tosf INNER JOIN c_sucursal cs ON tosf.csucursal=cs.csucursal	\n" +
						"WHERE tosf.kviajefac in (																\n" +
						"		    	SELECT max(kviajefac)													\n" +
						"		    	FROM t_orden_sucursal_fac												\n" +
						"		    	WHERE csucursal = " + intSucursal 	+ " AND CESTADOREGISTRO = 28)		\n" +
						"GROUP BY CodigoBarras,Encabezado";
			iObjLog.debug("Consulta ViajeFacturacionDao.cerrarViaje:...  " + strQuery);
			rst = objSta.executeQuery(strQuery);
			strQuery = this.imprimeEtiquetasZPL(rst);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.cerrarViaje: ", aObjExcepcion);
			strQuery = "";
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		rst = null;
        }
        return strQuery;
	}		
		
	public String getOrdenesSinViaje(int intSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Formatos objFormatos = new Formatos();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.getOrdenesSinViaje:...  " + intSucursal);
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
			strQuery =	"select  tos.uorden orden,tos.kordensucursal admision,																	\n"+
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 							\n"+
						"        to_char(tos.dregistro,'dd-mm-yyyy') captura,																	\n"+
						"        to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,															\n"+
						"        nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,	\n"+
						"        0 burgente,																									\n"+
						"        tos.mpagopaciente pagopaciente,																				\n"+
						"        cs.snombresucursal  sunidad,																					\n"+
						"        cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,												\n"+
						"        tu.first_name||' '||tu.last_name capturo																		\n"+
						"from  t_orden_sucursal tos 																							\n"+
						"LEFT JOIN  t_orden_sucursal_fac tpp ON tos.kordensucursal = tpp.kordensucursal											\n"+
						"INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente													\n"+
						"INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal													\n"+
						"INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio and cc.ctipoconvenio = 24							\n"+
						"INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id														\n"+
						"where (tos.dregistro between to_date('01-01-2015 00:00:00', 'dd-mm-yyyy hh24:mi:ss') 									\n"+
						"				and to_date('" + objFormatos.getFechaActual() + " 23:59:59', 'dd-mm-yyyy hh24:mi:ss')) 					\n"+
						"				and tos.cestadoregistro<>17 																			\n"+
						"				and tpp.kordensucursal is null																			\n"+
						"				and tos.mpagopaciente = 0 																				\n"+
						"				and tos.csucursal = " + intSucursal + "																	\n"+
						"order by admision";
				iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				strQuery = this.getEncabezadoOrdenesSinPago("Ordenes Sin Viaje");
				strQuery = strQuery + this.getBodyOrdenes(objResultSet);
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		

	public String buscarViaje(int intSucursal,int Viaje) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		iObjLog.debug("Entrando ViajeFacturacionDao.getOrdenesSinViaje:...  " + intSucursal);
    	try{            
        	objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
			strQuery =	"select  tos.uorden orden,tos.kordensucursal admision,																	\n"+
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 							\n"+
						"        to_char(tos.dregistro,'dd-mm-yyyy') captura,																	\n"+
						"        to_char(tos.dresultadoentrega,'dd-mm-yyyy') promesa,															\n"+
						"        nvl(tp.sapellidopaterno,' ') || ' ' || nvl(tp.sapellidomaterno,' ') || ' ' || nvl(tp.snombre,' ') spaciente,	\n"+
						"        0 burgente,																									\n"+
						"        tos.mpagopaciente pagopaciente,																				\n"+
						"        cs.snombresucursal  sunidad,																					\n"+
						"        cc.cconvenio||' '||cc.sconvenio||' '||cc.ctipoconvenio convenio,												\n"+
						"        tu.first_name||' '||tu.last_name capturo																		\n"+
						"from  t_orden_sucursal tos 																							\n"+
						"INNER JOIN  t_orden_sucursal_fac tpp ON tos.kordensucursal = tpp.kordensucursal AND tpp.KVIAJEFAC = " + Viaje + "		\n"+
						"INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente													\n"+
						"INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal													\n"+
						"INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio													\n"+
						"INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id														\n"+
						"where tos.cestadoregistro<>17 																							\n"+
						"				and tos.mpagopaciente = 0																				\n"+
						"				and tos.csucursal = " + intSucursal + "																	\n"+
						"order by admision";
				iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				strQuery = this.getEncabezadoOrdenesSinPago("Ordenes en el Viaje " + Viaje);
				strQuery = strQuery + this.getBodyOrdenes(objResultSet);
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		
	
	private String getBodyOrdenes(ResultSet objResultSet) throws Exception {
		String strQuery = "";
		try {
			if (objResultSet != null) {					
				iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  1");
				while(objResultSet.next()) {
					iObjLog.debug("Consulta ViajeFacturacionDao.getOrdenesSinViaje:...  2");
					strQuery = strQuery + ("<tr>" + 
											"   <td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:registrarPago(" + objResultSet.getString("admision") + "," + objResultSet.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
													objResultSet.getString("admision") + 
											"	</td>" + 
											"	<td align='center'>" + 
													objResultSet.getString("korden") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("captura") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("promesa") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("spaciente") + 
											"	</td>" +
											"	<td align='center'>" + 
													"$" + objResultSet.getString("pagopaciente") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("convenio") + 
											"	</td>" +
											"	<td align='center'>" + 
													objResultSet.getString("capturo") + 
											"	</td>" +
										 	"</tr>");
				}					
			}
			strQuery = strQuery + "</table>";										
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ViajeFacturacionDao.getOrdenesSinViaje: ", aObjExcepcion);
			throw aObjExcepcion;
		}
		return strQuery;
	}
	
	private String getEncabezadoOrdenesSinPago(String strTitulo) {
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
				"	<b><font color='black'>Admision" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Orden" + 
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Fecha Captura" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Fecha Promesa" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Paciente" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Pago Paciente" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Convenio" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Capturo" + 
				"	</font></b>" +
				"</th>" + 
				"</tr>");	
		}	
	
	
	private String imprimeEtiquetasZPL(ResultSet objResultSet) throws Exception {
		String strEtiquetas = "";
    	try{
			if(objResultSet != null) {
				while(objResultSet.next()) {
					strEtiquetas = "";
					strEtiquetas += "^XA " +
									"^LH5,10 " +
									"^FO24,10^AD^FD"+objResultSet.getString("Encabezado")+"^FS "+
									"^FO40,30^BY2,2.0:1^B3N,N,80,N^FD"+objResultSet.getString("CodigoBarras")+"^FS " +
									"^FO24,120^AD^FD"+objResultSet.getString("Elementos")+ "^FS " +
									"^XZ";			
					
					break;
				}
				objResultSet.close();
			}		
		} catch (Exception aObjExcepcion) { 
    	    iObjLog.error("ExamenesDao.imprimeEtiquetasZPL:Exception....", aObjExcepcion);
    	    throw aObjExcepcion;
		} 
		iObjLog.debug("ExamenesDao.imprimeEtiquetasZPL:Exception....   " + strEtiquetas);
		return strEtiquetas;
	}				
	
	public static String llenaIdFactura(String strNemonico,String intFactura,int MaxLength) {
		String strReturn = "";
		int intTotal = (strNemonico.length() + intFactura.length());
		for(int i = intTotal;i <= MaxLength;i++) {
			strReturn += "0";
		}		
		return strNemonico + strReturn + intFactura;
	}
}
