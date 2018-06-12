package mx.com.web2lab.backend.dao.ap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.PagoPacienteBean;
import mx.com.web2lab.backend.dao.ap.DatosOrdenDao;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CSucursal;
import mx.com.web2lab.backend.hbm.om.ap.CTipoPago;
import mx.com.web2lab.backend.hbm.om.ap.TCorteCaja;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TPagoPaciente;
import mx.com.web2lab.backend.hbm.om.tiemposmovimientos.TTicketCaja;
import mx.com.web2lab.backend.util.Formatos;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PagosDao {

	private static Log iObjLog = LogFactory.getLog(PagosDao.class);
	    
	private Session iObjSesion = null;
	
	public PagosDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public PagoPacienteBean setPago(PagoPacienteBean objPagoBean) throws Exception {
		List lstOrdenes = new ArrayList();
		TOrdenSucursal objOrdenFundacion = null;
		TPagoPaciente objPago = new TPagoPaciente();
		String strDigitos = new String(); 
		try {						
			iObjLog.debug("Entrando PagosDao.setPago:...  " + objPagoBean.toString());
			objPagoBean.setMsaldo(objPagoBean.getMpagopacientetotal() - (objPagoBean.getManticipo() + objPagoBean.getMpagopacienteparcial()));
			DatosOrdenDao objDAOOrden = new DatosOrdenDao();
			lstOrdenes = objDAOOrden.buscarOrden(objPagoBean.getTordensucursal());
			iObjSesion = HibernateUtil.getSession();
            HibernateUtil.beginTrans();
            	objOrdenFundacion = (TOrdenSucursal)lstOrdenes.get(0); 
            		CEstadoRegistro objER = new CEstadoRegistro();
            		objER.setCestadoregistro(new Integer(15));
            	objPago.setCestadoregistro(objER);
            		CTipoPago objTP = new CTipoPago();
            		objTP.setCtipopago(new Integer(objPagoBean.getCtipopago()));
            	objPago.setSdigitostarjeta(objPagoBean.getSdigitos());	
            	objPago.setCtipopago(objTP);
            	objPago.setDregistro(new Date());
//            	objPago.setKpagopaciente(kpagopaciente)
            	objPago.setManticipo(new BigDecimal(objPagoBean.getManticipo()));
            	objPago.setMdevolucionpaciente(new BigDecimal(objPagoBean.getMdevolucionpaciente()));
            	objPago.setMpagopacienteparcial(new BigDecimal(objPagoBean.getMpagopacienteparcial()));
            	objPago.setMpagopacientetotal(new BigDecimal(objPagoBean.getMpagopacientetotal()));
            	objPago.setMsaldo(new BigDecimal(objPagoBean.getMsaldo()));
	        		TCorteCaja objCorteCaja = new TCorteCaja();
	        		objCorteCaja.setKcortecaja(new Integer(0));
            	objPago.setTcortecaja(objCorteCaja);
            	objPago.setTordensucursal(objOrdenFundacion);
            	objPago.setUserid(objPagoBean.getUserid());            
            iObjSesion.save(objPago);
            iObjSesion.flush();            	
//            HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo PagosDao.setPago:Saliendo...  " + objPagoBean.toString());
			return objPagoBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.setPago:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	public TPagoPaciente getPagoLast(int kOrdenSucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List lstPagos = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		TPagoPaciente objPagoPaciente = null;
		try {			
    			iObjLog.debug("Consulta PacientesDao.getPagoLast():...kOrdenSucursal  " + kOrdenSucursal);
        		strQuery =  "select bPF " +					
							" from TPagoPaciente bPF " +					
							" where bPF.tordensucursal.kordensucursal = " + kOrdenSucursal + " order by bPF.kpagopaciente ";        		
				objQuery = iObjSesion.createQuery(strQuery);
				lstPagos = objQuery.list();
				if(lstPagos != null) {
	    			iObjLog.debug("Consulta PacientesDao.getPagoLast():...Elementos en la lista  " + lstPagos.size());
					for (int inti=0;inti<lstPagos.size();inti++ ) {
						objPagoPaciente = (TPagoPaciente)lstPagos.get(inti);								
					}
				}			
			return objPagoPaciente;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.getPagoLast:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	

	public List getPagosHB20(int kOrdenSucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List lstPagos = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
			iObjLog.debug("Consulta PacientesDao.getPagoLast():...kOrdenSucursal  " + kOrdenSucursal);
    		strQuery =  "select bPF " +					
						" from TPagoPaciente bPF " +					
						" where bPF.tordensucursal.kordensucursal = " + kOrdenSucursal + " order by bPF.mpagopacienteparcial desc ";        		
			objQuery = iObjSesion.createQuery(strQuery);
			lstPagos = objQuery.list();
			if(lstPagos != null) {
				return lstPagos;
			} else {
				return null;
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.getPagoLast:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	public List getPagos(int kOrdenSucursal) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List lstPagos = new ArrayList();
		List lstPagosReturn = new ArrayList();
		
		Query objQuery = null;
		String strQuery = "";
		TPagoPaciente objPagoPaciente = null;
		PagoPacienteBean objPagoBean = null;
		try {			
    			iObjLog.debug("Consulta PacientesDao.getPagoLast():...kOrdenSucursal  " + kOrdenSucursal);
        		strQuery =  "select bPF " +					
							" from TPagoPaciente bPF " +					
							" where bPF.tordensucursal.kordensucursal = " + kOrdenSucursal + " order by bPF.kpagopaciente ";        		
				objQuery = iObjSesion.createQuery(strQuery);
				lstPagos = objQuery.list();
				if(lstPagos != null) {
					if (lstPagos.size() > 0) {
		    			iObjLog.debug("Consulta PacientesDao.getPagoLast():...Elementos en la lista  " + lstPagos.size());
						for (int inti=0;inti<lstPagos.size();inti++ ) {
							objPagoPaciente = (TPagoPaciente)lstPagos.get(inti);
							objPagoBean = new PagoPacienteBean();
							objPagoBean.setCestadoregistro(objPagoPaciente.getCestadoregistro().getCestadoregistro().intValue());
							objPagoBean.setCtipopago(objPagoPaciente.getCtipopago().getCtipopago().intValue());
							objPagoBean.setDregistro(objPagoPaciente.getDregistro());
							objPagoBean.setKpagopaciente(objPagoPaciente.getKpagopaciente().intValue());
							objPagoBean.setManticipo(objPagoPaciente.getManticipo().doubleValue());
							objPagoBean.setMdevolucionpaciente(objPagoPaciente.getMdevolucionpaciente().doubleValue());
							objPagoBean.setMpagopacienteparcial(objPagoPaciente.getMpagopacienteparcial().doubleValue());
							objPagoBean.setMpagopacientetotal(objPagoPaciente.getMpagopacientetotal().doubleValue());
							objPagoBean.setMsaldo(objPagoPaciente.getMsaldo().doubleValue());
							objPagoBean.setTcortecaja(objPagoPaciente.getTcortecaja().getKcortecaja().intValue());
							objPagoBean.setTordensucursal(objPagoPaciente.getTordensucursal().getKordensucursal().intValue());
							objPagoBean.setUserid(objPagoPaciente.getUserid());
							lstPagosReturn.add(objPagoBean);
						}
					}
				}			
			return lstPagosReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.getPagoLast:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	public TCorteCaja actualizaCorteCaja(int intUsuario,int intSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		List objListaPagos = new ArrayList();
		ToolsDao objToolDao = new ToolsDao();
		TCorteCaja objCorteCaja = new TCorteCaja();				
		Query objQuery = null;
		String strQuery = "";
		iObjLog.debug("Entrando PagosDao.actualizaCorteCaja:Saliendo...  ");
    	try{
            HibernateUtil.beginTrans();
				strQuery = "select bPF " +					
						   " from TPagoPaciente bPF " +					
						   " where bPF.tcortecaja.kcortecaja = 0 and bPF.tordensucursal.csucursalbycsucursal.csucursal = " + intSucursal;
				objQuery = iObjSesion.createQuery(strQuery);
				objListaPagos = objQuery.list();
			Connection objConexion = iObjSesion.connection();				
			if(objListaPagos != null) {
				if (objListaPagos.size() > 0) {
						CSucursal objSucursal = new CSucursal();
						objSucursal.setCsucursal(new Integer(intSucursal));
					objCorteCaja.setCsucursal(objSucursal);
					objCorteCaja.setDregistro(new Date());
//					objCorteCaja.setKcortecaja(kcortecaja)
//					objCorteCaja.setTcortecajaarqueos(tcortecajaarqueos)
//					objCorteCaja.setTgastosucursals(tgastosucursals)
//					objCorteCaja.setTpagopacientes(tpagopacientes)
					objCorteCaja.setUcortecajasucursal(objToolDao.getSequenceNextId("tcortecaja" + intSucursal + "_sequence" ,objConexion).intValue());					
				    iObjSesion.save(objCorteCaja);
					for(int inti=0;inti<objListaPagos.size();inti++) {
						TPagoPaciente objPago = (TPagoPaciente)objListaPagos.get(inti);	
							objPago.setTcortecaja(objCorteCaja);
			            iObjSesion.update(objPago);
			            iObjSesion.flush(); 
			            objPago = null;
					}
		            //HibernateUtil.commitTrans();	 				
//					ToolsDao objGastos =  new ToolsDao();
//					objGastos.actualizarGasto(objCorteCaja.getKcortecajafundacion().intValue(),iObjSesion);
//					objGastos = null;
//					intCorteCaja = objCorteCaja.getKcortecajafundacion().intValue();
				}
			}	
			iObjLog.debug("Saliendo PagosDao.actualizaCorteCaja:Saliendo...  ");
			return objCorteCaja;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.actualizaCorteCaja: ", aObjExcepcion);
			throw aObjExcepcion;
	    } finally{
	    	HibernateUtil.closeSession();
		}		
	}	
		
	public String getOrdenesSinPago(int intSucursal) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Formatos objFormatos = new Formatos();
		List lstOrdenesSinPago = new ArrayList();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objResultSet = null;
		String strQuery = "";
		iObjLog.debug("Entrando PagosDao.getOrdenesSinPago:...  " + intSucursal);
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
						"LEFT JOIN  t_pago_paciente tpp ON tos.kordensucursal = tpp.kordensucursal												\n"+
						"INNER JOIN t_paciente tp       ON tp.kpaciente       = tos.kpaciente													\n"+
						"INNER JOIN c_sucursal cs       ON tos.csucursal      = cs.csucursal													\n"+
						"INNER JOIN c_convenio cc       ON tos.cconvenio      = cc.cconvenio													\n"+
						"INNER JOIN turbine_user tu     ON tos.user_id        = tu.user_id														\n"+
						"where (tos.dregistro between to_date('" + objFormatos.getFechaActual() + " 00:00:00', 'dd-mm-yyyy hh24:mi:ss') 		\n"+
						"				and to_date('" + objFormatos.getFechaActual() + " 23:59:59', 'dd-mm-yyyy hh24:mi:ss')) 					\n"+
						"				and tos.cestadoregistro<>17 																			\n"+
						"				and tpp.kordensucursal is null																			\n"+
						"				and cc.ctipoconvenio <> 22																				\n"+
						"				and tos.mpagopaciente > 0																				\n"+
						"				and tos.csucursal = " + intSucursal + "																	\n"+
						"order by admision";
				iObjLog.debug("Consulta PagosDao.getOrdenesSinPago:...  " + strQuery);
				objResultSet = objSta.executeQuery(strQuery);
				strQuery = this.getEncabezadoOrdenesSinPago();
				if (objResultSet != null) {					
					iObjLog.debug("Consulta PagosDao.getOrdenesSinPago:...  1");
					while(objResultSet.next()) {
						iObjLog.debug("Consulta PagosDao.getOrdenesSinPago:...  2");
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
				iObjLog.debug("Saliendo PagosDao.getOrdenesSinPago:...  " + lstOrdenesSinPago.size());
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.getOrdenesSinPago: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objResultSet = null;
        }
	}		
	
	private String getEncabezadoOrdenesSinPago() {
		return ("<table border='0' align='center' style='width: 883px' class='tabla'>" + 
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
				"</tr>");	}	
	
	public int setInicioTicket(int cSucursal,int kOrdenSucursal,int user_id, String smodulo, String snemonicoconsecutivo) throws Exception	{
		TTicketCaja objTTicketCaja = new TTicketCaja();
		try {						
			iObjLog.debug("Entrando PagosDao.setInicioTicket:...  " + kOrdenSucursal);
			iObjSesion = HibernateUtil.getSession();
            HibernateUtil.beginTrans();
            objTTicketCaja.setCestadoregistro(0);
            objTTicketCaja.setCsucursal(cSucursal);
            objTTicketCaja.setDinicio(new Date());
            objTTicketCaja.setDtermino(new Date());
            objTTicketCaja.setKordensucursal(kOrdenSucursal);
            objTTicketCaja.setSmodulo(smodulo);
            objTTicketCaja.setSnemonicoconsecutivo(snemonicoconsecutivo);
            objTTicketCaja.setUconsecutivoticketsucursal(0);
            objTTicketCaja.setUserId(user_id);
            iObjSesion.save(objTTicketCaja);
            iObjSesion.flush();            	
			iObjLog.debug("Saliendo PagosDao.setInicioTicket:...  " + objTTicketCaja.getKticketcaja().intValue());
			return objTTicketCaja.getKticketcaja().intValue();
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.setInicioTicket:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	
	public void setTerminoAtencionTicket(int kTicketCaja) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		List objTickets = new ArrayList();
		TTicketCaja objTTicketCaja = null;
		Query objQuery = null;
		String strQuery = "";
		iObjLog.debug("Entrando PagosDao.setTerminoAtencionTicket:Saliendo...  ");
    	try{
            HibernateUtil.beginTrans();
			strQuery = "select bPF " +					
					   " from TTicketCaja bPF " +					
					   " where bPF.kticketcaja = " + kTicketCaja;
			objQuery = iObjSesion.createQuery(strQuery);
			objTickets = objQuery.list();
			if(objTickets != null) {
				if (objTickets.size() > 0) {
					objTTicketCaja = (TTicketCaja)objTickets.get(0);	
					objTTicketCaja.setDtermino(new Date());
		            iObjSesion.update(objTTicketCaja);
		            iObjSesion.flush(); 
				}
			}	
			iObjLog.debug("Saliendo PagosDao.setTerminoAtencionTicket:Saliendo...  ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.setTerminoAtencionTicket: ", aObjExcepcion);
			throw aObjExcepcion;
	    } finally{
			objTickets = null;
			objTTicketCaja = null;
			objQuery = null;	    	
	    	HibernateUtil.closeSession();
		}		
	}	
}
