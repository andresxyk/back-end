package mx.com.web2lab.backend.dao.ap;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac;
import mx.com.web2lab.backend.hbm.om.ap.TPagoPaciente;
import mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion;
import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.ap.PacienteBean;
import mx.com.web2lab.backend.beans.facturacion.DatosFiscalesBean;
import mx.com.web2lab.backend.beans.tools.ConvertBeanvsHB;
import mx.com.web2lab.backend.dao.facturacion.menudeo.FacturacionMenudeoDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.HibernateException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DatosOrdenDao {

	private static Log iObjLog = LogFactory.getLog(DatosOrdenDao.class);
	    
	private Session iObjSesion = null;
	
	
	public DatosOrdenDao(){
	}

	public List buscarOrdenesVSPaciente(int intKPaciente, int cConvenio,boolean bolExamenesLaboratorio) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaOrdenes = new ArrayList();
		List objListaOrdenesReturn = new ArrayList();
		List objListaReturn = new ArrayList();
		OrdenBean objReturn = null;
		ConvertBeanvsHB objConvert = new ConvertBeanvsHB();
		PagosDao objPagoDAO = new PagosDao();
		FacturacionMenudeoDao objFacturacionMenudeoDao = new FacturacionMenudeoDao();
		TOrdenSucursal objOrdenSucursal = null;
		Query objQuery = null;
		String strQuery = "";
		String strWhere = "";
		String strKOrdenSucursales = "0";
    	try{
    		if (intKPaciente > 0) {
				iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenesVSPaciente:Entrando...  " + intKPaciente);
				if (cConvenio > 0) {
					strWhere = " and bOF.cconvenio = " + cConvenio; 
				}
				HibernateUtil.beginTrans();
				strQuery = "select bOF " +					
				   		   "from TOrdenSucursal bOF " +	
				           "where bOF.tpaciente.kpaciente =  " + intKPaciente + strWhere +
				           " order by bOF.dregistro,bOF.kordensucursal ";
				iObjLog.debug("Entrando DatosOrdenDao.buscarpersistemOrdenes:Consulta...  " + strQuery);
				objQuery = iObjSesion.createQuery(strQuery);
				objListaOrdenes = objQuery.list();
				if (objListaOrdenes.isEmpty() == false) {
					for (int inti=0;inti<objListaOrdenes.size();inti++){
						objReturn = new OrdenBean();    
						objOrdenSucursal = (TOrdenSucursal)objListaOrdenes.get(inti);
						objReturn = objConvert.convertOrdenHBBean(objOrdenSucursal, objPagoDAO.getPagoLast(objOrdenSucursal.getKordensucursal().intValue()), "DatosOrdenDao.buscarOrdenesVSPaciente(int intKPaciente)",false,false);		
						strKOrdenSucursales += ("," + objOrdenSucursal.getKordensucursal().intValue()); 
						objReturn.setStrFactura(objFacturacionMenudeoDao.getFolioFacturaOrden((objReturn.getKadmision())));
						objReturn.setBolcotizacionexameneslaboratorio(false);
						objListaOrdenesReturn.add(objReturn);
					}
					if (bolExamenesLaboratorio) {
						objListaReturn = this.sizeExamenesLaboratorio(strKOrdenSucursales,objListaOrdenesReturn);
					} else {
						objListaReturn = objListaOrdenesReturn;
					}
				}			
				iObjLog.debug("Entrando DatosOrdenDao.buscarpersistemOrdenes:Resultado...  " + objListaReturn.size());
    		}
//			HibernateUtil.commitTrans();	 				
			iObjLog.debug("Saliendo DatosOrdenDao.buscarpersistemOrdenes:Saliendo...  " + objListaReturn.toString());
			return objListaReturn;
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarpersistemOrdenes: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
			objListaOrdenes.clear();
			objListaOrdenes = null;
    		objQuery = null;
    		objConvert = null;
    		objPagoDAO = null;
    		objOrdenSucursal = null;
    		HibernateUtil.closeSession();
    	}		
	}	

	private List sizeExamenesLaboratorio(String strOrdenes, List lstOrdenes)  throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Statement objStatement = null;
		ResultSet rst = null;
		String strSQL = "";		
		List lstReturn = new ArrayList();
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.sizeExamenesLaboratorio:Entrando...  " + strOrdenes);
			java.sql.Connection objConn = iObjSesion.connection();
			objStatement = objConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			strSQL = "SELECT toes.kordensucursal,									\n" +
					 "		 ce.cexamen,											\n" +
					 "		 ce.sexamen,											\n" +
					 "       ce.ctipocomercial,										\n" +						
					 "		 toes.slogin_name,										\n" +
					 "		 toes.dtomamuestrainicio,								\n" +
					 "		 toes.dtomamuestratermino								\n" +
					 "FROM t_orden_examen_sucursal toes inner join c_examen ce 		\n" +
					 "									on toes.cexamen=ce.cexamen 	\n" +
					 "WHERE toes.kordensucursal in (" + strOrdenes + ") 	 		\n" +
					 "ORDER BY toes.kordensucursal,ce.ctipocomercial 				\n";
			iObjLog.debug("Entrando DatosOrdenDao.sizeExamenesLaboratorio:Consulta...  " + strSQL);
			rst = objStatement.executeQuery(strSQL);
			strSQL = "";
			int intctipocomercial = 0;
			int intmuestrapendiente = 0;
			if(rst != null) {
				for (int inti=0;inti<lstOrdenes.size();inti++) {
					OrdenBean objOrdenBean  = (OrdenBean)lstOrdenes.get(inti);
					rst.beforeFirst();
					while(rst.next()) {					
						if (objOrdenBean.getKadmision() == rst.getLong("kordensucursal")) {							
							if (rst.getInt("ctipocomercial") == 2) {
								intctipocomercial = 2;
							} else {
								intctipocomercial = 1;
								break;
							}
						}
					}
					if (intctipocomercial == 1) {
						objOrdenBean.setBolcotizacionexameneslaboratorio(true);
					} else {
						objOrdenBean.setBolcotizacionexameneslaboratorio(false);
					}							
					rst.beforeFirst();
					while(rst.next()) {					
						if (objOrdenBean.getKadmision() == rst.getLong("kordensucursal")) {							
							if (rst.getString("slogin_name").trim().toString().length() < 2){
								intmuestrapendiente = 2;
								break;
							} else {
								intmuestrapendiente = 1;
							}
						}
					}
					if (intmuestrapendiente == 2) {
						objOrdenBean.setBmuestraspendientes(true);
					} else {
						objOrdenBean.setBmuestraspendientes(false);
					}							
					lstReturn.add(objOrdenBean);					
				}				
				rst.close();
			}					
			iObjLog.debug("Resultado DatosOrdenDao.sizeExamenesLaboratorio:Consulta...  " + lstReturn.size());		
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.getOrdenesFacConvenio:: ", aObjExcepcion);
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
		}				
		return lstReturn;
	}
		
	public List buscarOrden(int kOrdenSucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaOrdenes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarpersistenteOrden:Entrando...  " + kOrdenSucursal);
			HibernateUtil.beginTrans();
			strQuery = "select bOF " +					
			   		   "from TOrdenSucursal bOF " +	
			           "where bOF.kordensucursal =  " + kOrdenSucursal;
			iObjLog.debug("Entrando DatosOrdenDao.buscarpersistenteOrden:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaOrdenes = objQuery.list();
			iObjLog.debug("Entrando DatosOrdenDao.buscarpersistenteOrden:Resultado...  " + objListaOrdenes.size());
			//HibernateUtil.commitTrans();	 				
			iObjLog.debug("Saliendo DatosOrdenDao.buscarpersistenteOrden:Saliendo...  " + objListaOrdenes.toString());
			return objListaOrdenes;
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarpersistenteOrden:: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		HibernateUtil.closeSession();
    	}		
	}	

	public String actualizarFechaCompromiso(int intKAdmision,int uTurbine_user,Date dCompromisoNew) throws Exception {
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnly:Entrando...  " + intKAdmision);
			TOrdenSucursal objOrdenSucursal = this.getOrdenSucursal(intKAdmision,false);			
			objOrdenSucursal.setDresultadoentrega(dCompromisoNew);
			objOrdenSucursal.setUseridchange(new BigDecimal(uTurbine_user));
			this.updateOrdenSucursal(objOrdenSucursal);
			return "Existo en la Actualizacion";
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnly(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    	}		
	}	

	public OrdenBean buscarOrdenOnly(int intKAdmision) throws Exception {
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		PagosDao objPagoDAO = new PagosDao();
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnly:Entrando...  " + intKAdmision);
			TOrdenSucursal objOrdenSucursal = this.getOrdenSucursal(intKAdmision,false);
			if (objOrdenSucursal != null) {
				return objConvertBeans.convertOrdenHBBean(objOrdenSucursal,objPagoDAO.getPagoLast(objOrdenSucursal.getKordensucursal().intValue()),"DatosOrdenDao.buscarOrdenOnly(int intKAdmision)",false,false);
			} else {
				return new OrdenBean();
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnly(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objConvertBeans = null;
    		objPagoDAO = null;
    	}		
	}	
	
	private OrdenBean createObjectError(String strError) {
		OrdenBean objOrdenBean = new OrdenBean();
		PacienteBean objPacienteBean = new PacienteBean();
		DatosFiscalesBean objDatosFiscales = new DatosFiscalesBean();
		objOrdenBean.setBpacientebean(objPacienteBean);
		objOrdenBean.setSmensajeerror(strError);
		objOrdenBean.setObjdatosfiscalesbean(objDatosFiscales);
		return objOrdenBean;
	}

    /* Create 21/03/2013 Author OMRR */
	public OrdenBean buscarOrdenFacturacionElectronicaInternet(int intKAdmision, String strPassword) throws Exception {
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		PagosDao objPagoDAO = new PagosDao();
		OrdenBean objOrdenBean = null;
		TPagoPaciente objTPagoPaciente = null;
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnly:Entrando...  " + intKAdmision);
			TOrdenSucursal objOrdenSucursal = this.getOrdenSucursal(intKAdmision,false);
			if (objOrdenSucursal != null) {
				if ((objOrdenSucursal.getSpassword().trim().equals(strPassword) || (objOrdenSucursal.getSpassword().trim() == strPassword))) {	
					if (objOrdenSucursal.getCestadoregistro().getCestadoregistro().intValue() == 17) {
						objOrdenBean = createObjectError("La orden se encuentra cancelada, no se puede facturar");
					} else {
//						String formato="yyyy";
//						SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
//						int uAno = Integer.parseInt(dateFormat.format(objOrdenSucursal.getDregistro()));										
//						int uAnoActual = Integer.parseInt(dateFormat.format((new Date())));	
						
//						objOrdenBean.setUanoactual(Integer.parseInt(dateFormat.format((new Date()))));
//						objOrdenBean.setUanoorden(Integer.parseInt(dateFormat.format(objOrdenSucursal.getDregistro())));
//						iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnly:Entrando...  " + uAno);
//						if (uAnoActual == uAno) {
							objTPagoPaciente = objPagoDAO.getPagoLast(objOrdenSucursal.getKordensucursal().intValue());				
							if (objTPagoPaciente != null) {
								if (objTPagoPaciente.getMsaldo().doubleValue() > 0.0) {
									objOrdenBean = createObjectError("La orden debe estar 100% pagada para realizar la factura..");
								} else {
									objOrdenBean =  objConvertBeans.convertOrdenHBBean(objOrdenSucursal,objTPagoPaciente,"DatosOrdenDao.buscarOrdenOnly(int intKAdmision)",false,false);
									String formato="yyyy";
									SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
									int uAno = Integer.parseInt(dateFormat.format(objOrdenSucursal.getDregistro()));										
									int uAnoActual = Integer.parseInt(dateFormat.format((new Date())));	
									objOrdenBean.setUanoactual(Integer.parseInt(dateFormat.format((new Date()))));
									objOrdenBean.setUanoorden(Integer.parseInt(dateFormat.format(objOrdenSucursal.getDregistro())));
									objOrdenBean.setSmensajeerror("");
								}
							} else {
								objOrdenBean = createObjectError("La orden debe estar 100% pagada para realizar la factura..");
							}					
//						} else {
//							objOrdenBean = createObjectError("Solo contaba con el año corriente y lo excedi&oacute;, ya no es posible facturar.");
//						}
					}
				} else {
					objOrdenBean = createObjectError("La contrase&ntilde;a es incorrecta.");
				}
			} else {
				objOrdenBean = createObjectError("No existe la orden que est&aacute;s buscando.");
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnly(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objConvertBeans = null;
    		objPagoDAO = null;
    	}		
    	return objOrdenBean;
	}	
	
	public OrdenBean buscarOrdenExamen(int intKAdmision, boolean bolFacturacionCredito) throws Exception {
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		PagosDao objPagoDAO = new PagosDao();
		OrdenBean objOrdenReturn;
		TOrdenSucursal objOrdenSucursal;
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnly:Entrando...  " + intKAdmision);
			objOrdenSucursal = this.getOrdenSucursal(intKAdmision,bolFacturacionCredito);
			if (objOrdenSucursal != null) {
				objOrdenReturn = objConvertBeans.convertOrdenHBBean(objOrdenSucursal,objPagoDAO.getPagoLast(objOrdenSucursal.getKordensucursal().intValue()),"DatosOrdenDao.buscarOrdenOnly(int intKAdmision)",bolFacturacionCredito,bolFacturacionCredito);
				return objOrdenReturn;
			} else {
				return new OrdenBean();
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnly(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objConvertBeans = null;
    		objPagoDAO = null;
    		objOrdenSucursal = null;
    	}		
	}		

	public OrdenBean buscarOrdenExamenFac(int intKAdmision) throws Exception {
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		OrdenBean objOrdenReturn;
		TOrdenSucursalFac objOrdenSucursalFac;
		TOrdenSucursal objOrdenSucursal;		
		PagosDao objPagoDAO = new PagosDao();
		
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnly:Entrando...  " + intKAdmision);
			objOrdenSucursal = this.getOrdenSucursal(intKAdmision,false);
			objOrdenSucursalFac = this.getOrdenSucursalFac(intKAdmision,true);
			if (objOrdenSucursal != null && objOrdenSucursalFac != null) {
				objOrdenReturn = objConvertBeans.convertOrdenFacHBBean(objOrdenSucursal,objOrdenSucursalFac,objPagoDAO.getPagoLast(intKAdmision),"DatosOrdenDao.buscarOrdenExamenFac(int intKAdmision, boolean bolFacturacionCredito)",true);
				return objOrdenReturn;
			} else {
				return new OrdenBean();
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnly(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objConvertBeans = null;
    		objOrdenSucursal = null;
    		objOrdenSucursalFac = null;
    		objPagoDAO = null;
    	}		
	}		

	public OrdenBean buscarOrdenExamenFac20(int intKAdmision) throws Exception {
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		OrdenBean objOrdenReturn;
		TOrdenSucursalFac objOrdenSucursalFac;
		TOrdenSucursal objOrdenSucursal;		
		PagosDao objPagoDAO = new PagosDao();
		List lstPagos = null;
		TPagoPaciente objPagoPaciente = null;
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnly:Entrando...  " + intKAdmision);
			objOrdenSucursal = this.getOrdenSucursal(intKAdmision,false);
			objOrdenSucursalFac = this.getOrdenSucursalFac(intKAdmision,true);
			if (objOrdenSucursal != null && objOrdenSucursalFac != null) {
				objOrdenReturn = objConvertBeans.convertOrdenFacHBBean(objOrdenSucursal,objOrdenSucursalFac,null,"DatosOrdenDao.buscarOrdenExamenFac(int intKAdmision, boolean bolFacturacionCredito)",true);
				objOrdenReturn.setcUltimoTipoPago(0);
				objOrdenReturn.setsUltimosTipoPago("");
				objOrdenReturn.setsUltimosDigitosPago("");
				lstPagos = objPagoDAO.getPagosHB20(intKAdmision);
				if (lstPagos != null) {
					for(int inty=0;inty<lstPagos.size();inty++) {
						objPagoPaciente = (TPagoPaciente)lstPagos.get(inty);
						objOrdenReturn.setcUltimoTipoPago(objPagoPaciente.getCtipopago().getCtipopago().intValue());
						if (objOrdenReturn.getsUltimosTipoPago().trim().length() > 0) {
							objOrdenReturn.setsUltimosTipoPago(objOrdenReturn.getsUltimosTipoPago().trim() + "," +  objPagoPaciente.getCtipopago().getUtipopagofactura().trim());
							if (objPagoPaciente.getSdigitostarjeta().trim().length() > 3) {
								objOrdenReturn.setsUltimosDigitosPago(objOrdenReturn.getsUltimosDigitosPago().trim()  + "," +  objPagoPaciente.getSdigitostarjeta().trim());
							}
						} else {
							objOrdenReturn.setsUltimosTipoPago(objPagoPaciente.getCtipopago().getUtipopagofactura().trim());
							if (objPagoPaciente.getSdigitostarjeta().trim().length() > 3) {
								objOrdenReturn.setsUltimosDigitosPago(objPagoPaciente.getSdigitostarjeta().trim());
							}
						}
					}
				}
				return objOrdenReturn;
			} else {
				return new OrdenBean();
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnly(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objConvertBeans = null;
    		objOrdenSucursal = null;
    		objOrdenSucursalFac = null;
    		objPagoDAO = null;
    	}		
	}		
	
	
	public List buscarOrdenExamenFactura(int intKAdmision) throws Exception {
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		List lstReturn = new ArrayList();
		TOrdenSucursal objOrdenSucursal 		= null;				
		TOrdenSucursalFac objOrdenSucursalFac 	= null;
		TFactura objFactura						= null;
		OrdenBean objOrdenReturn 				= null;
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenExamenFactura:Entrando...  " + intKAdmision);
			objOrdenSucursal = this.getOrdenSucursal(intKAdmision,false);
			lstReturn.add(objOrdenSucursal);
			objOrdenSucursalFac = this.getOrdenSucursalFac(intKAdmision,true);
			lstReturn.add(objOrdenSucursalFac);
			if (objOrdenSucursalFac != null) {
				if (objOrdenSucursalFac.getTfactura().getKfactura().intValue() > 0) {
					objFactura = objOrdenSucursalFac.getTfactura();
				}
			}
			lstReturn.add(objFactura);
			if (objOrdenSucursal != null && objOrdenSucursalFac != null) {
				objOrdenReturn = objConvertBeans.convertOrdenFacHBBean(objOrdenSucursal,objOrdenSucursalFac,null,"DatosOrdenDao.buscarOrdenExamenFactura(int intKAdmision, boolean bolFacturacionCredito)",true);
			}				
			lstReturn.add(objOrdenReturn);
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenExamenFactura(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objConvertBeans = null;
    		objOrdenSucursal = null;
    		objOrdenSucursalFac = null;
    	}		
		return lstReturn;
	}		
	
	
	public OrdenBean buscarOrdenFacOnly(int intKAdmision) throws Exception {
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		PagosDao objPagoDAO = new PagosDao();
		TOrdenSucursal objOrdenSucursal; 
		TOrdenSucursalFac objOrdenSucursalFac; 
		try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnlyFac:Entrando...  " + intKAdmision);
			objOrdenSucursal = this.getOrdenSucursal(intKAdmision,false);
			objOrdenSucursalFac = this.getOrdenSucursalFac(intKAdmision,false);
			if (objOrdenSucursalFac != null) {
				return objConvertBeans.convertOrdenFacHBBean(objOrdenSucursal,objOrdenSucursalFac,objPagoDAO.getPagoLast(objOrdenSucursalFac.getKordensucursal()),"DatosOrdenDao.buscarOrdenOnlyFac(int intKAdmision)",false);
			} else {
				return new OrdenBean();
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnlyFac(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objConvertBeans = null;
    		objPagoDAO = null;
    	}		
	}		

	
	public TOrdenSucursalFac getOrdenSucursalFac(int intKAdmision,boolean bolConExamenes) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaOrdenes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		TOrdenSucursalFac objOrdenSucursalFac = new TOrdenSucursalFac();
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.getOrdenSucursalFac:Entrando...  " + intKAdmision);
			HibernateUtil.beginTrans();
			if (bolConExamenes) {
				strQuery = "select bOF " +					
				   		   "from TOrdenSucursalFac bOF " +	
				           "	left fetch join bOF.tordenexamensucursalfacs bOEF " +
				           "where bOF.kordensucursal =  " + intKAdmision + " and bOEF.cestadoregistro.cestadoregistro not in (43) " +
						   "order by bOF.kordensucursalfac ";
			} else {
				strQuery = "select bOF " +					
				   		   "from TOrdenSucursalFac bOF " +	
				           "where bOF.kordensucursal =  " + intKAdmision + " " +
				           "order by kordensucursalfac ";
			}
			iObjLog.debug("Entrando DatosOrdenDao.getOrdenSucursalFac:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaOrdenes = objQuery.list();
			iObjLog.debug("Resultado DatosOrdenDao.getOrdenSucursalFac:Consulta...  " + objListaOrdenes.size());			
			if (objListaOrdenes.isEmpty() == false) {
				for (int inti=0;inti<objListaOrdenes.size();inti++) {
					objOrdenSucursalFac = null;
					objOrdenSucursalFac = (TOrdenSucursalFac)objListaOrdenes.get(inti);									
				}
				return objOrdenSucursalFac;
			} else {
				return null;
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnlyLocal(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		HibernateUtil.closeSession();
    		objOrdenSucursalFac = null;
    	}		
	}	
	
	
	private TOrdenSucursal getOrdenSucursal(int intKAdmision,boolean bolConExamenes) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaOrdenes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		TOrdenSucursal objOrdenSucursal = null;
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnlyLocal:Entrando...  " + intKAdmision);
			HibernateUtil.beginTrans();
			if (bolConExamenes) {
				strQuery = "select bOF " +					
				   		   "from TOrdenSucursal bOF " +	
				           "	left fetch join bOF.tordenexamensucursals bOEF " +
				           "where bOF.kordensucursal =  " + intKAdmision;
			} else {
				strQuery = "select bOF " +					
				   		   "from TOrdenSucursal bOF " +	
				           "where bOF.kordensucursal =  " + intKAdmision;
			}
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrdenOnlyLocal:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaOrdenes = objQuery.list();
			iObjLog.debug("Resultado DatosOrdenDao.buscarOrdenOnlyLocal:Consulta...  " + objListaOrdenes.size());			
			if (objListaOrdenes.isEmpty() == false) {
				objOrdenSucursal = (TOrdenSucursal)objListaOrdenes.get(0);				
				return objOrdenSucursal;
			} else {
				return null;
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnlyLocal(int intKAdmision):: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		HibernateUtil.closeSession();
    		objOrdenSucursal = null;
    	}		
	}	

	public List getOrdenesFacConvenio(long cConvenio) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		String strSQL = "";		
		List lstReturn = new ArrayList();
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.getOrdenesFacConvenio:Entrando...  " + cConvenio);
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			strSQL = "SELECT tosf.kordensucursal																\n" +
					 "FROM T_ORDEN_SUCURSAL_FAC TOSF INNER JOIN C_ESTADO_REGISTRO CER ON 						\n" +
					 "	   TOSF.CESTADOREGISTRO=CER.CESTADOREGISTRO 											\n" +
					 "WHERE TOSF.cconvenio IN (" + cConvenio + ") and CER.sestadoregistro in ('LISTAFACTURAR')\n";
			iObjLog.debug("Entrando DatosOrdenDao.getOrdenesFacConvenio:Consulta...  " + strSQL);
			rst = objStatement.executeQuery(strSQL);
			strSQL = "";
			if(rst != null) {
				while(rst.next()) {
					lstReturn.add(new Integer(rst.getInt("kordensucursal")));
				}				
				rst.close();
			}					
			iObjLog.debug("Resultado DatosOrdenDao.getOrdenesFacConvenio:Consulta...  " + lstReturn.size());		
			return lstReturn;				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.getOrdenesFacConvenio:: ", aObjExcepcion);
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
	
	private void updateOrdenSucursal(TOrdenSucursal objOrdenSucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.updateOrdenSucursal:Entrando...  " + objOrdenSucursal.getKordensucursal().intValue());
			HibernateUtil.beginTrans();
			iObjSesion.update(objOrdenSucursal);
            iObjSesion.flush(); 			
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.updateOrdenSucursal(): ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		HibernateUtil.closeSession();
    	}		
	}	
	
	public OrdenBean buscarOrdenOnly(String strSucursal,int intCOrden) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaOrdenes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		PagosDao objPagoDAO = new PagosDao();
		TOrdenSucursal objOrdenSucursal = null;		
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrden:Entrando...  " + intCOrden);
			HibernateUtil.beginTrans();
			strQuery = "select bOF " +					
			   		   "from TOrdenSucursal bOF " +	
			           "where bOF.uorden =  " + intCOrden + " and bOF.csucursalbycsucursal.csucursal = " + strSucursal + " ";
			iObjLog.debug("Entrando DatosOrdenDao.buscarOrden:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaOrdenes = objQuery.list();
			if (objListaOrdenes.isEmpty() == false) {
				objOrdenSucursal = (TOrdenSucursal)objListaOrdenes.get(0);				
				return objConvertBeans.convertOrdenHBBean(objOrdenSucursal,objPagoDAO.getPagoLast(objOrdenSucursal.getKordensucursal().intValue()),"DatosOrdenDao.buscarOrdenOnly(String strSucursal,int intCOrden)",false,false);
			} else {
				return new OrdenBean();
			}				
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.buscarOrdenOnly(String strSucursal,int intCOrden): ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		HibernateUtil.closeSession();
    		objConvertBeans = null;
    	}		
	}	

	
	public void actualizaEntregaResultados(int intKAdmision,int intUsuario) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaOrdenes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		BOrdenFundacion objOrdenFundacion;
    	try{
			iObjLog.debug("Entrando DatosOrdenDao.actualizaEntregaResultados:Entrando...  " + intKAdmision + " " + intUsuario);
			HibernateUtil.beginTrans();
			strQuery = "select bOF " +					
			   		   "from BOrdenFundacion bOF " +	
			           "where bOF.kordenfundacion =  " + intKAdmision;
			iObjLog.debug("Entrando DatosOrdenDao.actualizaEntregaResultados:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaOrdenes = objQuery.list();
			if (objListaOrdenes != null) {
				objOrdenFundacion = (BOrdenFundacion)objListaOrdenes.get(0);
				objOrdenFundacion.setDentregaresultado(new Date());
				objOrdenFundacion.setCestado(3);
				iObjSesion.update(objOrdenFundacion);
				iObjSesion.flush();
			}
			iObjLog.debug("Entrando DatosOrdenDao.actualizaEntregaResultados:Resultado...  " + objListaOrdenes.size());
			//HibernateUtil.commitTrans();	 				
			iObjLog.debug("Saliendo DatosOrdenDao.actualizaEntregaResultados:Saliendo...  " + objListaOrdenes.toString());
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.actualizaEntregaResultados:: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		HibernateUtil.closeSession();
    	}		
	}	
	
	public List setActualizaOrdenExamenes(List lstOrdenExamenes) throws Exception {
		iObjSesion = HibernateUtil.getSession();		
		TOrdenExamenSucursal objExamen = null;
		TOrdenSucursal objOrdenSucursal = null;
		List lstReturn = new ArrayList();
		List lstExamenesReturn = new ArrayList();
		List lstExamenes = new ArrayList();
		ConvertBeanvsHB objConvertBeans = new ConvertBeanvsHB();
		OrdenBean objOrdenBean = new OrdenBean();
		try {			
			iObjLog.debug("Entrando DatosOrdenDao.setActualizaOrdenExamenes:Entrando...  ");
			objOrdenSucursal = (TOrdenSucursal)lstOrdenExamenes.get(0);
			lstExamenes = (List)lstOrdenExamenes.get(1);
            HibernateUtil.beginTrans();
			iObjLog.debug("Entrando DatosOrdenDao.setActualizaOrdenExamenes:Entrando...  " + objOrdenSucursal.toString());
            	iObjSesion.save(objOrdenSucursal);
	    		iObjSesion.flush();            	
				for (int i = 0; i < lstExamenes.size() ; i++)
				{
					objExamen = (TOrdenExamenSucursal)lstExamenes.get(i);						
					objExamen.setTordensucursal(objOrdenSucursal);
					objExamen.setDtomamuestrainicio(new Date());
					objExamen.setDtomamuestratermino(new Date());
					objExamen.setSlogin_name(" ");
	            	iObjSesion.save(objExamen);
		    		iObjSesion.flush();            	
		    		lstExamenesReturn.add(objExamen);
				}
				objOrdenBean = objConvertBeans.convertOrdenHBBean(objOrdenSucursal,null,"DatosOrdenDao.setActualizaOrdenExamenes(List lstOrdenExamenes)",false,false);
				lstReturn.add(objOrdenBean);
				lstReturn.add(lstExamenesReturn);
			iObjLog.debug("Saliendo DatosOrdenDao.setActualizaOrdenExamenes:Saliendo...  ");
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate DatosOrdenDao.setActualizaOrdenExamenes:: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.setActualizaOrdenExamenes:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
    		objOrdenSucursal = null;
    		objConvertBeans = null;
    		if (lstExamenes != null) {
        		lstExamenes.clear();    			
    		}
    		lstExamenes = null;
		}		
        return lstReturn;
	}	

	public TOrdenSucursal setActualizaOrden(TOrdenSucursal objOrden) throws Exception {
		iObjSesion = HibernateUtil.getSession();		
		try {			
			iObjLog.debug("Entrando DatosOrdenDao.setActualizaOrden:Entrando...  ");
            HibernateUtil.beginTrans();
            	iObjSesion.update(objOrden);
	    		iObjSesion.flush();            	
			//HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo DatosOrdenDao.setActualizaOrden:Saliendo...  ");
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate DatosOrdenDao.setActualizaOrden: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.setActualizaOrden: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
        return objOrden;
	}	
	
	public BOrdenFundacion setGuardaOrden(BOrdenFundacion objOrden) throws Exception {
		iObjSesion = HibernateUtil.getSession();		
		try {			
			iObjLog.debug("Entrando DatosOrdenDao.setGuardaOrden:Entrando...  ");
            HibernateUtil.beginTrans();
            	iObjSesion.save(objOrden);
	    		iObjSesion.flush();            	
			//HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo DatosOrdenDao.setGuardaOrden:Saliendo...  ");
		} catch (HibernateException hbmExcepcion) { 
			iObjLog.error("ERROR Hibernate DatosOrdenDao.setGuardaOrden: ", hbmExcepcion);
			throw hbmExcepcion;			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosOrdenDao.setGuardaOrden: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
        return objOrden;
	}		
	
	public String getDatosAdicionales(int kOrdenSucursal) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		String strSQL = "";		
		iObjSesion = HibernateUtil.getSession();
	    iObjLog.debug("Entrando DatosOrdenDao.getDatosAdicionales:....   " + strSQL);
    	try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			strSQL = "SELECT (CDA.SDATOADICIONAL || '  ' || TDA.SVALOR) SDATOADICIONAL	\n" +
					 "FROM T_DATO_ADICIONAL TDA INNER JOIN C_DATO_ADICIONAL CDA ON 		\n" +
					 "	   TDA.CDATOADICIONAL=CDA.CDATOADICIONAL 						\n" +
					 "WHERE TDA.KORDENSUCURSAL IN (" + kOrdenSucursal + ") \n";
 			iObjLog.debug("DatosOrdenDao.getDatosAdicionales:Consulta......." + strSQL);
			rst = objStatement.executeQuery(strSQL);
			strSQL = "";
			if(rst != null) {
				while(rst.next()) {
					strSQL = rst.getString("SDATOADICIONAL").trim();
				}				
				rst.close();
			}		
		} catch (Exception aObjExcepcion) { 
    	    iObjLog.error("DatosOrdenDao.getDatosAdicionales:Exception....", aObjExcepcion);
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
	    iObjLog.debug("Saliendo DatosOrdenDao.getDatosAdicionales:....   " + strSQL);
		return strSQL;
	}				

	public void guardarDatosAdicionales(int kOrdenSucursal,int cdatoadicional,String svalor) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;
		String strSQL = "";		
		iObjSesion = HibernateUtil.getSession();
	    iObjLog.debug("Entrando DatosOrdenDao.guardarDatosAdicionales:....   " + strSQL);
    	try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			strSQL = "INSERT INTO T_DATO_ADICIONAL VALUES (t_dato_adicional_sequence.NEXTVAL," + kOrdenSucursal + ",0," + cdatoadicional + ",'" + svalor + "')";
 			iObjLog.debug("DatosOrdenDao.guardarDatosAdicionales:Consulta......." + strSQL);
			objStatement.execute(strSQL);
			objStatement.execute("COMMIT;");
		} catch (Exception aObjExcepcion) { 
    	    iObjLog.error("DatosOrdenDao.guardarDatosAdicionales:Exception....", aObjExcepcion);
    	    throw aObjExcepcion;
		} finally{
			if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
	    	HibernateUtil.closeSession();
		}		
	    iObjLog.debug("Saliendo DatosOrdenDao.guardarDatosAdicionales:....   " + strSQL);
	}				

}
