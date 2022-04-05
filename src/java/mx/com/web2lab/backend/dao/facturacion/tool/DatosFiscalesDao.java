package mx.com.web2lab.backend.dao.facturacion.tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.facturacion.DatosFiscalesBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal;
import mx.com.web2lab.backend.hbm.om.ap.TPaciente;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DatosFiscalesDao {

	private static Log iObjLog = LogFactory.getLog(DatosFiscalesDao.class);
	    
	private Session iObjSesion = null;
	
	public DatosFiscalesDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	

	public String showGridDatoFiscal(DatosFiscalesBean objDatosFiscalesBean) throws Exception {
		String strReturn = "";
		List lstDatosFiscales = this.buscarDatosFiscales(objDatosFiscalesBean);
		strReturn = this.getEncabezadoDatosFiscales("Son " + lstDatosFiscales.size() + " datos fiscales encontrados");
		for (int inti=0;inti<lstDatosFiscales.size();inti++) {
			strReturn += this.getBodyDatosFiscales((DatosFiscalesBean)lstDatosFiscales.get(inti));
		}
		return strReturn + "</table>";
	}

	public DatosFiscalesBean getOneDatoFiscal(DatosFiscalesBean objDatosFiscalesBean) throws Exception {
		List lstDatosFiscales = this.buscarDatosFiscales(objDatosFiscalesBean);
		if (lstDatosFiscales.size() > 0) {
			return (DatosFiscalesBean)lstDatosFiscales.get(0);
		} else {
			return null;
		}		
	}
	
	private List buscarDatosFiscales(DatosFiscalesBean objDatosFiscalesBean) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		DatosFiscalesBean objDatosFiscalesNewBean = null;
		List lstDatosFiscales = new ArrayList();
		iObjLog.debug("Entrando DatosFiscalesDao.buscarDatosFiscales:... RFC " + objDatosFiscalesBean.getStrRFC() + " Razon Social " + objDatosFiscalesBean.getStrRazonSocial());
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
	        if (objDatosFiscalesBean.getStrRFC().trim().length() > 0) {
	        	if (objDatosFiscalesBean.isBlike()) {
		        	strQuery = " TDF.srfc like ('%" + objDatosFiscalesBean.getStrRFC() + "%')"; 
	        	} else {
		        	strQuery = " TDF.srfc in ('" + objDatosFiscalesBean.getStrRFC() + "')"; 
	        	}
	        } else if (objDatosFiscalesBean.getStrRazonSocial().trim().length() > 0) {
	        	if (objDatosFiscalesBean.isBlike()) {
		        	strQuery = " TDF.srazonsocial like ('%" + objDatosFiscalesBean.getStrRazonSocial() + "%')"; 
	        	} else {
		        	strQuery = " TDF.srazonsocial in ('" + objDatosFiscalesBean.getStrRazonSocial() + "')"; 
	        	}
	        } else if (objDatosFiscalesBean.getkDatosFiscales() > 0) {
	        	strQuery = " TDF.kdatofiscal = " + objDatosFiscalesBean.getkDatosFiscales(); 
	        } else {
	        	strQuery = " 1 = 1 " ; 
	        }
            strQuery = "SELECT distinct(TDF.kdatofiscal) as kdatofiscalonly,	\n" +
            		   "       TDF.kdatofiscal,									\n" +
            		   " 	   TDF.srazonsocial,								\n" +
            		   "	   TDF.srfc,										\n" +
            		   "	   TDF.sdireccion,									\n" +
            		   "       TDF.ccodigopostal,    							\n" +
            		   "       TDF.spais,		    							\n" +
            		   "       CCP.cpostal,										\n" +
            		   "       CCP.sestado,										\n" +
            		   "       CCP.sciudad,										\n" +
            		   "       CCP.sdelegacionmunicipio,						\n" +
            		   "       CCP.scolonia             						\n" +
          			   "FROM T_DATO_FISCAL TDF INNER JOIN C_CODIGO_POSTAL CCP 	\n" + 
          			   "			ON TDF.CCODIGOPOSTAL=CCP.CCODIGOPOSTAL  	\n" +
          			   " 	 INNER JOIN T_FACTURA TF ON 						\n" +
          			   "			TF.KDATOFISCAL=TDF.KDATOFISCAL and 			\n" +
          			   "			TF.cestadoregistro <> 34					\n" + 
          			   "WHERE " + strQuery + 								   "\n" +
          			   "UNION ALL											    \n" +					
          	           "SELECT distinct(TDF.kdatofiscal) as kdatofiscalonly,	\n" +
             		   "       TDF.kdatofiscal,									\n" +
             		   " 	   TDF.srazonsocial,								\n" +
             		   "	   TDF.srfc,										\n" +
             		   "	   TDF.sdireccion,									\n" +
             		   "       TDF.ccodigopostal,    							\n" +
             		   "       TDF.spais,		    							\n" +
             		   "       CCP.cpostal,										\n" +
             		   "       CCP.sestado,										\n" +
             		   "       CCP.sciudad,										\n" +
             		   "       CCP.sdelegacionmunicipio,						\n" +
             		   "       CCP.scolonia             						\n" +
           			   "FROM T_DATO_FISCAL TDF INNER JOIN C_CODIGO_POSTAL CCP 	\n" + 
           			   "			ON TDF.CCODIGOPOSTAL=CCP.CCODIGOPOSTAL  	\n" +
           			   " 	 LEFT JOIN T_FACTURA TF ON 							\n" +
           			   "			TDF.KDATOFISCAL=TF.KDATOFISCAL  			\n" +
           			   "WHERE TF.KDATOFISCAL IS NULL AND " + strQuery + 	   "\n" +
          			   " ORDER BY srazonsocial ";          			   
			if (objDatosFiscalesBean.getcConvenio() > 0) {
				strQuery = "SELECT distinct(TDF.kdatofiscal) as kdatofiscalonly,	\n" +
			     		   "       TDF.kdatofiscal,									\n" +
			     		   " 	   TDF.srazonsocial,								\n" +
			     		   "	   TDF.srfc,										\n" +
			     		   "	   TDF.sdireccion,									\n" +
			     		   "       TDF.ccodigopostal,    							\n" +
			     		   "       TDF.spais,		    							\n" +
			     		   "       CCP.cpostal,										\n" +
			     		   "       CCP.sestado,										\n" +
			     		   "       CCP.sciudad,										\n" +
			     		   "       CCP.sdelegacionmunicipio,						\n" +
			     		   "       CCP.scolonia             						\n" +
			   			   "FROM T_DATO_FISCAL TDF INNER JOIN C_CODIGO_POSTAL CCP 	\n" + 
			   			   "			ON TDF.CCODIGOPOSTAL=CCP.CCODIGOPOSTAL  	\n" +
			   			   " 	 INNER JOIN C_CONVENIO_DATO_FISCAL CCDF ON 			\n" +
			   			   "			CCDF.KDATOFISCAL=TDF.KDATOFISCAL  			\n" +
			   			   "WHERE CCDF.CCONVENIO IN (" + objDatosFiscalesBean.getcConvenio() + ") 	   \n" +
			  			   " ORDER BY srazonsocial ";          			   
			}
			iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:...");
				while(objResultSet.next()) {
					objDatosFiscalesNewBean = new DatosFiscalesBean();
					objDatosFiscalesNewBean.setkDatosFiscales(objResultSet.getInt("kdatofiscal"));
					objDatosFiscalesNewBean.setStrRFC(objResultSet.getString("srfc"));
					objDatosFiscalesNewBean.setStrRazonSocial(objResultSet.getString("srazonsocial"));
					objDatosFiscalesNewBean.setStrDireccion(objResultSet.getString("sdireccion"));
					objDatosFiscalesNewBean.setsPais(objResultSet.getString("spais"));
					objDatosFiscalesNewBean.setStrCiudad(objResultSet.getString("sciudad"));
					objDatosFiscalesNewBean.setStrColonia(objResultSet.getString("scolonia"));
					objDatosFiscalesNewBean.setStrDelegacionMunicipio(objResultSet.getString("sdelegacionmunicipio"));
					objDatosFiscalesNewBean.setStrEstado(objResultSet.getString("sestado"));
					objDatosFiscalesNewBean.setcCodigoPostal(objResultSet.getInt("ccodigopostal"));
					if (objResultSet.getString("cpostal").trim().length() == 3) {
						objDatosFiscalesNewBean.setcPostal("00" + objResultSet.getString("cpostal"));
					} else if (objResultSet.getString("cpostal").trim().length() == 4) {
						objDatosFiscalesNewBean.setcPostal("0" +objResultSet.getString("cpostal"));
					} else {
						objDatosFiscalesNewBean.setcPostal(objResultSet.getString("cpostal"));
					}
					lstDatosFiscales.add(objDatosFiscalesNewBean);
				}					
			}
			iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:..." + lstDatosFiscales.size());
			return lstDatosFiscales;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFiscalesDao.buscarDatosFiscales: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objResultSet.close();
        	objSta.close();
    		objSta = null;
    		objResultSet = null;
        }
	}		

	public List buscarDatosFiscalesCliente(DatosFiscalesBean objDatosFiscalesBean) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		DatosFiscalesBean objDatosFiscalesNewBean = null;
		List lstDatosFiscales = new ArrayList();
		iObjLog.debug("Entrando DatosFiscalesDao.buscarDatosFiscales:... RFC " + objDatosFiscalesBean.getStrRFC() + " Razon Social " + objDatosFiscalesBean.getStrRazonSocial());
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
	        if (objDatosFiscalesBean.getStrRFC().trim().length() > 0) {
	        	strQuery = " TDF.srfc like ('%" + objDatosFiscalesBean.getStrRFC() + "%')"; 
	        } else if (objDatosFiscalesBean.getStrRazonSocial().trim().length() > 0) {
	        	strQuery = " TDF.srazonsocial like ('%" + objDatosFiscalesBean.getStrRazonSocial() + "%')"; 
	        } else if (objDatosFiscalesBean.getkDatosFiscales() > 0) {
	        	strQuery = " TDF.kdatofiscal = " + objDatosFiscalesBean.getkDatosFiscales(); 
	        }
            strQuery = "SELECT distinct(TDF.kdatofiscal) as kdatofiscalonly,	\n" +
            		   "       TDF.kdatofiscal,									\n" +
            		   " 	   TDF.srazonsocial,								\n" +
            		   "	   TDF.srfc,										\n" +
            		   "	   TDF.sdireccion,									\n" +
            		   "       TDF.ccodigopostal,    							\n" +
            		   "       TDF.spais,		    							\n" +
            		   "       CCP.cpostal,										\n" +
            		   "       CCP.sestado,										\n" +
            		   "       CCP.sciudad,										\n" +
            		   "       CCP.sdelegacionmunicipio,						\n" +
            		   "       CCP.scolonia             						\n" +
          			   "FROM T_DATO_FISCAL TDF INNER JOIN C_CODIGO_POSTAL CCP 	\n" + 
          			   "			ON TDF.CCODIGOPOSTAL=CCP.CCODIGOPOSTAL  	\n" +
          			   " 	 INNER JOIN T_FACTURA TF ON 						\n" +
          			   "			TF.KDATOFISCAL=TDF.KDATOFISCAL and 			\n" +
          			   "			TF.cestadoregistro in (33)					\n" + 
          			   "WHERE " + strQuery + " ORDER BY TDF.srazonsocial ";          			   
				iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:...");
				while(objResultSet.next()) {
					objDatosFiscalesNewBean = new DatosFiscalesBean();
					objDatosFiscalesNewBean.setkDatosFiscales(objResultSet.getInt("kdatofiscal"));
					objDatosFiscalesNewBean.setStrRFC(objResultSet.getString("srfc"));
					objDatosFiscalesNewBean.setStrRazonSocial(objResultSet.getString("srazonsocial"));
					objDatosFiscalesNewBean.setStrDireccion(objResultSet.getString("sdireccion"));
					objDatosFiscalesNewBean.setsPais(objResultSet.getString("spais"));
					objDatosFiscalesNewBean.setStrCiudad(objResultSet.getString("sciudad"));
					objDatosFiscalesNewBean.setStrColonia(objResultSet.getString("scolonia"));
					objDatosFiscalesNewBean.setStrDelegacionMunicipio(objResultSet.getString("sdelegacionmunicipio"));
					objDatosFiscalesNewBean.setStrEstado(objResultSet.getString("sestado"));
					objDatosFiscalesNewBean.setcCodigoPostal(objResultSet.getInt("ccodigopostal"));
					objDatosFiscalesNewBean.setcPostal(objResultSet.getString("cpostal"));
					lstDatosFiscales.add(objDatosFiscalesNewBean);
				}					
			}
			return lstDatosFiscales;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFiscalesDao.buscarDatosFiscales: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objResultSet.close();
        	objSta.close();
    		objSta = null;
    		objResultSet = null;
        }
	}		

	public DatosFiscalesBean buscarDatosFiscalesConvenio(long cConvenio) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		DatosFiscalesBean objDatosFiscalesNewBean = null;
		iObjLog.debug("Entrando DatosFiscalesDao.buscarDatosFiscales:... cConvenio " + cConvenio);
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
        	strQuery = " CCDF.cconvenio = " + cConvenio + " AND CC.CTIPOCONVENIO IN (21,22) ";
            strQuery = "SELECT distinct(TDF.kdatofiscal) as kdatofiscalonly,	\n" +
            		   "       TDF.kdatofiscal,									\n" +
            		   " 	   TDF.srazonsocial,								\n" +
            		   "	   TDF.srfc,										\n" +
            		   "	   TDF.sdireccion,									\n" +
            		   "       TDF.ccodigopostal,    							\n" +
            		   "       TDF.spais,		    							\n" +
            		   "       CCDF.sdigitoscuenta,		    					\n" +
            		   "       CCDF.utipopagofactura as stipopago,		    	\n" +
            		   "       CCP.cpostal,										\n" +
            		   "       CCP.sestado,										\n" +
            		   "       CCP.sciudad,										\n" +
            		   "       CCP.sdelegacionmunicipio,						\n" +
            		   "       CCP.scolonia             						\n" +
          			   "FROM T_DATO_FISCAL TDF INNER JOIN C_CODIGO_POSTAL CCP 	\n" + 
          			   "			ON TDF.CCODIGOPOSTAL=CCP.CCODIGOPOSTAL  	\n" +
          			   "     INNER JOIN C_CONVENIO_DATO_FISCAL CCDF  			\n" +
          			   "			ON CCDF.kdatofiscal=TDF.kdatofiscal 		\n" +
          			   "     INNER JOIN C_CONVENIO CC  							\n" +
          			   "			ON CC.CCONVENIO=CCDF.CCONVENIO 				\n" +
          			   "WHERE " + strQuery + " ORDER BY TDF.srazonsocial ";          			   
				iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscales:...");
				while(objResultSet.next()) {
					objDatosFiscalesNewBean = new DatosFiscalesBean();
					objDatosFiscalesNewBean.setkDatosFiscales(objResultSet.getInt("kdatofiscal"));
					objDatosFiscalesNewBean.setStrRFC(objResultSet.getString("srfc"));
					objDatosFiscalesNewBean.setStrRazonSocial(objResultSet.getString("srazonsocial"));
					objDatosFiscalesNewBean.setStrDireccion(objResultSet.getString("sdireccion"));
					objDatosFiscalesNewBean.setsPais(objResultSet.getString("spais"));
					objDatosFiscalesNewBean.setStrCiudad(objResultSet.getString("sciudad"));
					objDatosFiscalesNewBean.setStrColonia(objResultSet.getString("scolonia"));
					objDatosFiscalesNewBean.setStrDelegacionMunicipio(objResultSet.getString("sdelegacionmunicipio"));
					objDatosFiscalesNewBean.setStrEstado(objResultSet.getString("sestado"));
					objDatosFiscalesNewBean.setcCodigoPostal(objResultSet.getInt("ccodigopostal"));
					objDatosFiscalesNewBean.setcPostal(objResultSet.getString("cpostal"));
					objDatosFiscalesNewBean.setSdigitoscuenta(objResultSet.getString("sdigitoscuenta"));
					objDatosFiscalesNewBean.setStipopago(objResultSet.getString("stipopago"));
					break;
				}					
			}
			return objDatosFiscalesNewBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFiscalesDao.buscarDatosFiscales: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objResultSet.close();
        	objSta.close();
    		objSta = null;
    		objResultSet = null;
        }
	}	
	
	public int obtenerEntidadLegal(int kfactura) throws Exception {	
		
		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		int centidadlegal = 1;
		iObjLog.debug("Entrando DatosFiscalesDao.obtenerEntidadLegal:... kfactura " + kfactura);
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
        	strQuery = "SELECT centidadlegal from t_factura where kfactura = "+kfactura;
            			   
				iObjLog.debug("Consulta DatosFiscalesDao.obtenerEntidadLegal:...  " + strQuery);
			objResultSet = objSta.executeQuery(strQuery);
			if (objResultSet != null) {					
				iObjLog.debug("Consulta DatosFiscalesDao.obtenerEntidadLegal:...");
				while(objResultSet.next()) {
					centidadlegal = objResultSet.getInt("centidadlegal");
					
				}					
			}
			return centidadlegal;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFiscalesDao.obtenerEntidadLegal: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objResultSet.close();
        	objSta.close();
    		objSta = null;
    		objResultSet = null;
        }
	}
	
	public void updateNCKfactura(int knotaCredito, int kfactura) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		ResultSet objResultSet = null;
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando DatosFiscalesDao.updateNCKfactura:... knotaCredito " + knotaCredito + " kfactura " + kfactura);
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();	        
	        strQuery = "update t_nota_credito set kfactura = "+kfactura+" where knotacredito ="+knotaCredito;			
			iObjLog.debug("Consulta DatosFiscalesDao.updateNCKfactura:...  " + strQuery);
			objSta.execute(strQuery);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFiscalesDao.updateNCKfactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objSta.close();
    		objSta = null;
        }
	}

	
	public DatosFiscalesBean buscarDatosFiscalesOrden(long kOrdenSucursal, int kDatoFiscal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		DatosFiscalesBean objDatosFiscalesNewBean = new DatosFiscalesBean();;
		iObjLog.debug("Entrando DatosFiscalesDao.buscarDatosFiscalesOrden:... Consecutivo " + kOrdenSucursal);
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
			iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscalesOrden:...  " + this.getConsultabuscarDatosFiscalesOrden(kOrdenSucursal,kDatoFiscal));
			objResultSet = objSta.executeQuery(this.getConsultabuscarDatosFiscalesOrden(kOrdenSucursal,kDatoFiscal));
			if (objResultSet != null) {					
				iObjLog.debug("Consulta DatosFiscalesDao.buscarDatosFiscalesOrden:...");
				while(objResultSet.next()) {
					objDatosFiscalesNewBean.setkDatosFiscales(objResultSet.getInt("kdatofiscal"));
					objDatosFiscalesNewBean.setStrRFC(objResultSet.getString("srfc"));
					objDatosFiscalesNewBean.setStrRazonSocial(objResultSet.getString("srazonsocial"));
					objDatosFiscalesNewBean.setStrDireccion(objResultSet.getString("sdireccion"));
					objDatosFiscalesNewBean.setsPais(objResultSet.getString("spais"));
					objDatosFiscalesNewBean.setStrCiudad(objResultSet.getString("sciudad"));
					objDatosFiscalesNewBean.setStrColonia(objResultSet.getString("scolonia"));
					objDatosFiscalesNewBean.setStrDelegacionMunicipio(objResultSet.getString("sdelegacionmunicipio"));
					objDatosFiscalesNewBean.setStrEstado(objResultSet.getString("sestado"));
					objDatosFiscalesNewBean.setcCodigoPostal(objResultSet.getInt("ccodigopostal"));
					if (objResultSet.getString("cpostal").trim().length() == 3) {
						objDatosFiscalesNewBean.setcPostal("00" + objResultSet.getString("cpostal"));
					} else if (objResultSet.getString("cpostal").trim().length() == 4) {
						objDatosFiscalesNewBean.setcPostal("0" + objResultSet.getString("cpostal"));
					} else {
						objDatosFiscalesNewBean.setcPostal(objResultSet.getString("cpostal"));
					}
//					objDatosFiscalesNewBean.setSdigitoscuenta(objResultSet.getString("sdigitoscuenta"));
//					objDatosFiscalesNewBean.setStipopago(objResultSet.getString("stipopago"));
					break;
				}					
			}
			return objDatosFiscalesNewBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFiscalesDao.buscarDatosFiscalesOrden: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objResultSet.close();
        	objSta.close();
    		objSta = null;
    		objResultSet = null;
        }
	}		
	
	
	private String getConsultabuscarDatosFiscalesOrden(long kordensucursal, int kDatosFiscal) {
		return "SELECT TDF.kdatofiscal,																					\n" +
     		   " 	   TDF.srazonsocial,																				\n" +
     		   "	   TDF.srfc,																						\n" +
     		   "	   TDF.sdireccion,																					\n" +
     		   "       TDF.ccodigopostal,    																			\n" +
     		   "       TDF.spais,		    																			\n" +
//     		   "       CCDF.sdigitoscuenta,		    																	\n" +
//     		   "       CCDF.stipopago,		    																		\n" +
     		   "       CCP.cpostal,																						\n" +
     		   "       CCP.sestado,																						\n" +
     		   "       CCP.sciudad,																						\n" +
     		   "       CCP.sdelegacionmunicipio,																		\n" +
     		   "       CCP.scolonia             																		\n" +
   			   "FROM t_dato_fiscal tdf INNER JOIN c_codigo_postal ccp 			ON tdf.ccodigopostal=ccp.ccodigopostal	\n" +
//		       "					   INNER JOIN c_convenio_dato_fiscal ccdf  	ON ccdf.kdatofiscal=tdf.kdatofiscal 	\n" +	
		       "WHERE tdf.kdatofiscal in (																				\n" +
		       "				SELECT kdatofiscal																		\n" +
		       "				FROM t_factura																			\n" +
		       "				WHERE cestadoregistro not in (34) and kfactura in (										\n" +
		       "						SELECT kfactura																	\n" +
		       "						FROM t_orden_sucursal_fac tosf													\n" +
		       "						WHERE kordensucursal in (														\n" +
		       "									SELECT kordensucursal												\n" +
		       "									FROM t_orden_sucursal tos											\n" +
//		       "									WHERE csucursal not in (100) and kpaciente in (						\n" +
		       "									WHERE kpaciente in (												\n" +
		       "										SELECT tos.kpaciente											\n" +
		       "										FROM t_orden_sucursal tos 										\n" +
		       "										WHERE tos.kordensucursal in (" + kordensucursal + "))) 	AND		\n" +
		       "											  tosf.kfactura > 0)) 								AND 	\n" +
		       "	   tdf.srazonsocial not like ('%PUBLICO EN GENERAL%')		AND										\n" +
		       "	   trim(tdf.srazonsocial) != ''																		\n" +
		       "UNION ALL																								\n" +
		       "SELECT TDF.kdatofiscal,																					\n" +
     		   " 	   TDF.srazonsocial,																				\n" +
     		   "	   TDF.srfc,																						\n" +
     		   "	   TDF.sdireccion,																					\n" +
     		   "       TDF.ccodigopostal,    																			\n" +
     		   "       TDF.spais,		    																			\n" +
//     		   "       CCDF.sdigitoscuenta,		    																	\n" +
//     		   "       CCDF.stipopago,		    																		\n" +
     		   "       CCP.cpostal,																						\n" +
     		   "       CCP.sestado,																						\n" +
     		   "       CCP.sciudad,																						\n" +
     		   "       CCP.sdelegacionmunicipio,																		\n" +
     		   "       CCP.scolonia             																		\n" +
   			   "FROM t_dato_fiscal tdf INNER JOIN c_codigo_postal ccp 			ON tdf.ccodigopostal=ccp.ccodigopostal	\n" +
//		       "					   INNER JOIN c_convenio_dato_fiscal ccdf  	ON ccdf.kdatofiscal=tdf.kdatofiscal 	\n" +	
		       "WHERE tdf.kdatofiscal in (" + kDatosFiscal + ") AND 													\n" +
		       "	  tdf.kdatofiscal > 0						AND 													\n" +
		       "      tdf.srazonsocial not like ('%PUBLICO EN GENERAL%')												\n" +
		       "ORDER BY 1 DESC																							";		       
	}
	
	public DatosFiscalesBean newDatosFiscales(DatosFiscalesBean objDatosFiscalesBean, int intUser) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		ResultSet objResultSet = null;
		Statement objSta = null;
		String strQuery = "";
		iObjLog.debug("Entrando DatosFiscalesDao.newDatosFiscales:... RFC " + objDatosFiscalesBean.getStrRFC() + " Razon Social " + objDatosFiscalesBean.getStrRazonSocial());
    	try{            
        	objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();	        
	        strQuery = "INSERT INTO T_DATO_FISCAL (srazonsocial,srfc,sdireccion,ccodigopostal,spais,user_id,user_id_change,dregistro,dregistromodificacion)	\n" +
	        		   "VALUES('" + objDatosFiscalesBean.getStrRazonSocial() + "',	\n" +
	        		   "'" + objDatosFiscalesBean.getStrRFC() + "',					\n" + 
	        		   "'" + objDatosFiscalesBean.getStrDireccion() + "',			\n" + 
	        		   objDatosFiscalesBean.getcCodigoPostal() + ",					\n" +
	        		   "'" + objDatosFiscalesBean.getsPais() + "',					\n" +
	        		   intUser + "," + intUser + ",sysdate,sysdate)";			
			iObjLog.debug("Consulta DatosFiscalesDao.newDatosFiscales:...  " + strQuery);
			objSta.execute(strQuery);
	        strQuery = "SELECT MAX(kDatoFiscal) kDatoFiscal FROM T_DATO_FISCAL";
//	        objSta.close();
			objResultSet = objSta.executeQuery(strQuery);
			while (objResultSet.next()) {
				objDatosFiscalesBean.setkDatosFiscales(objResultSet.getInt("kDatoFiscal"));
			}
			return objDatosFiscalesBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFiscalesDao.newDatosFiscales: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        	objSta.close();
    		objSta = null;
        }
	}		

	public int newDatosSepomex(DatosFiscalesBean objDatosFiscalesBean) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		CCodigoPostal objCodigoPostal = null;
		List objListaCodigoPostales = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		iObjLog.debug("Entrando DatosFiscalesDao.newDatosFiscales:... RFC " + objDatosFiscalesBean.getStrRFC() + " Razon Social " + objDatosFiscalesBean.getStrRazonSocial());
    	try{            
			HibernateUtil.beginTrans();
    		strQuery =  "select cCP " +					
						" from CCodigoPostal cCP " +					
						" where cCP.bregistrosepo = false " +
						"   AND cCP.sasentamiento = 'NINGUNO' " +
						"   AND cCP.casentamiento = 1 " +
						"   AND cCP.cpostal = " + objDatosFiscalesBean.getcPostal() +
						"   AND cCP.sciudad = '" + objDatosFiscalesBean.getStrCiudad() + "'" +
						"   AND cCP.scolonia = '" + objDatosFiscalesBean.getStrColonia() + "'" +
						"   AND cCP.sdelegacionmunicipio = '" + objDatosFiscalesBean.getStrDelegacionMunicipio() + "'" +
						"   AND cCP.sestado = '" + objDatosFiscalesBean.getStrEstado() + "'";						
			objQuery = iObjSesion.createQuery(strQuery);
    		objListaCodigoPostales = objQuery.list();
			if(objListaCodigoPostales != null) {
				if (objListaCodigoPostales.size() > 0) {
					objCodigoPostal = (CCodigoPostal)objListaCodigoPostales.get(0);
				} 
			}
			if (objCodigoPostal == null) {
				objCodigoPostal = new CCodigoPostal();
	    		objCodigoPostal.setBregistrosepo(false);
	    		objCodigoPostal.setCasentamiento("1");
	    		objCodigoPostal.setCpostal(objDatosFiscalesBean.getcPostal());
	    		objCodigoPostal.setSasentamiento("NINGUNO");
	    		objCodigoPostal.setSciudad(objDatosFiscalesBean.getStrCiudad());
	    		objCodigoPostal.setScolonia(objDatosFiscalesBean.getStrColonia());
	    		objCodigoPostal.setSdelegacionmunicipio(objDatosFiscalesBean.getStrDelegacionMunicipio());
	    		objCodigoPostal.setSestado(objDatosFiscalesBean.getStrEstado());
				iObjSesion.save(objCodigoPostal);
	            iObjSesion.flush();
			}
            return objCodigoPostal.getCcodigopostal().intValue();
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFiscalesDao.newDatosFiscales: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
    		objListaCodigoPostales.clear();
    		objListaCodigoPostales = null;
    		objQuery = null;
    		objCodigoPostal = null;
        	HibernateUtil.closeSession();
        }
	}		
		
	private String getBodyDatosFiscales(DatosFiscalesBean objDatosFiscalesBean) {
		String strQuery = ("<tr>" + 
						"   <td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:asignarDatoFiscal(" + objDatosFiscalesBean.getkDatosFiscales() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
								objDatosFiscalesBean.getStrRFC() + 
						"	</td>" + 
						"	<td align='center'>" + 
								objDatosFiscalesBean.getStrRazonSocial() + 
						"	</td>" +
						"	<td align='center'>" + 
								objDatosFiscalesBean.getStrDireccion() + 
						"	</td>" +
					 	"</tr>");
		return strQuery;
	}
	
	private String getEncabezadoDatosFiscales(String strTitulo) {
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
				"	<b><font color='black'>RFC" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Razon Social" + 
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Direccion" + 
				"	</font></b>" +
				"</th>" + 
				"</tr>");	
	}		
}
