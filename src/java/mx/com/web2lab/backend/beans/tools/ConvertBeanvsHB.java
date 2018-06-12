package mx.com.web2lab.backend.beans.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.InstantiationException;
import net.sf.hibernate.LazyInitializationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.ap.OrdenExamenBean;
import mx.com.web2lab.backend.beans.ap.PacienteBean;
import mx.com.web2lab.backend.beans.comer.ConvenioBean;
import mx.com.web2lab.backend.dao.comer.ClientesNewDao;

import mx.com.web2lab.backend.hbm.om.ap.CConvenio;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CPerfil;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursalCotizacion;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursalFac;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalCotizacion;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac;
import mx.com.web2lab.backend.hbm.om.ap.TPagoPaciente;
import mx.com.web2lab.backend.hbm.om.lis.CExamen;
import mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento;

import mx.com.web2lab.backend.util.formatos.Formatos;

public class ConvertBeanvsHB {

	private static Log iObjLog = LogFactory.getLog(ConvertBeanvsHB.class);
	
	public OrdenBean convertOrdenHBBean(TOrdenSucursal objOrden,TPagoPaciente objPagoPaciente,String strMetodo,boolean bolFacturacionCredito,boolean bolSearchExamenes) throws Exception {
		iObjLog.debug("Entrando ConvertBeanvsHB.convertOrdenHBBean:" + strMetodo + "Resultado...  " + objOrden.toString());
		OrdenBean objReturn = new OrdenBean();
		try {
			PacienteBean objPacienteBean = new PacienteBean();
			    objPacienteBean.setKpacientefundacion(new Integer(objOrden.getTpaciente().getKpaciente().intValue()));
			    objPacienteBean.setCsexo(objOrden.getTpaciente().isBsexo());
			    objPacienteBean.setDnacimiento(objOrden.getTpaciente().getDnacimiento());
			    objPacienteBean.setSnombre(objOrden.getTpaciente().getSnombre());
			    objPacienteBean.setSappaterno(objOrden.getTpaciente().getSapellidopaterno());
			    objPacienteBean.setSapmaterno(objOrden.getTpaciente().getSapellidomaterno());				   				    
			    objPacienteBean.setSpasswordexpedienteenvio(objOrden.getTpaciente().getSpasswordenvio());
			objReturn.setBpacientebean(objPacienteBean);
		    objReturn.setBregistroactivo(objOrden.isBregistroactivo());
			objReturn.setCestado(objOrden.getCestadoregistro().getCestadoregistro().intValue());
			objReturn.setCordenfundacion(objOrden.getUorden());
			objReturn.setCusuario(objOrden.getUserid().intValue());
			objReturn.setDentregaresultado(objOrden.getDresultadoentrega());
			objReturn.setDpromesa(objOrden.getDresultadoentrega());
			objReturn.setDregistro(objOrden.getDregistro());
			objReturn.setSentregaresultadosa(objOrden.getSentregaresultadosa());
			objReturn.setKadmision(objOrden.getKordensucursal().intValue());				
			if (objPagoPaciente != null) {
				objReturn.setMacuenta((objPagoPaciente.getManticipo().doubleValue() + objPagoPaciente.getMpagopacienteparcial().doubleValue()));
				objReturn.setMadeuda(objPagoPaciente.getMsaldo().doubleValue());							
			} else {
				objReturn.setMacuenta(0.0);
				objReturn.setMadeuda(objOrden.getMpagopaciente().doubleValue());							
			}
			objReturn.setMdescuento((objOrden.getMdescuentomedico().doubleValue()));
			objReturn.setMdescuentoempresa(objOrden.getMdescuentoempresa().doubleValue());
			objReturn.setMdescuentopaciente(objOrden.getMdescuentopromocion().doubleValue());
			objReturn.setMfacturaempresa(objOrden.getMfacturaempresa().doubleValue());
			objReturn.setMiva(objOrden.getMiva().doubleValue());
			objReturn.setMsubtotal(objOrden.getMsubtotal().doubleValue());
			objReturn.setMtotal(objOrden.getMtotal().doubleValue());
			objReturn.setMpagapaciente(objOrden.getMpagopaciente().doubleValue());
			objReturn.setNfactura(objOrden.getUorden());
			objReturn.setSobservacion(objOrden.getSobservacion());
			objReturn.setCmedico(objOrden.getCmedico().getCclave());
			objReturn.setKmedico(objOrden.getCmedico().getCmedico().intValue());
			objReturn.setSnombre(objOrden.getCmedico().getSnombre());
			objReturn.setSappaterno(objOrden.getCmedico().getSapellidopaterno());
			objReturn.setSapmaterno(objOrden.getCmedico().getSapellidomaterno());			
			ClientesNewDao objClienteDao = new ClientesNewDao();			
			objReturn.setCconvenio(objOrden.getCconvenio());
			objReturn.setSconvenio(objClienteDao.getNombreConvenio(new ConvenioBean(new Integer(objOrden.getCconvenio()))));
			objClienteDao = null;
			objReturn.setSordenfundacion(objOrden.getSsucursal());
			objReturn.setCsucursal(objOrden.getCsucursalbycsucursal().getCsucursal().intValue());
			objReturn.setSsucursal(objOrden.getCsucursalbycsucursal().getSnombresucursal());
			objReturn.setCmarca(objOrden.getCmarca().getCmarca().intValue());
			objReturn.setSordencompleta(this.llenaIdFactura(objReturn.getSordenfundacion(),String.valueOf(objReturn.getCordenfundacion()) , 8));
			objReturn.setSdentregaresultado(new Formatos().getFechaNumeros(objOrden.getDresultadoentrega()));
			objReturn.setCordensolicitada(objOrden.getCordensolicitada());
			objReturn.setBautorizacionverresultadosmedico(objOrden.getBautorizacionverresultadosmedico());
			if (bolSearchExamenes) {
				if (objOrden.getTordenexamensucursals() != null) {
					if (!objOrden.getTordenexamensucursals().isEmpty()) {
						Set setExamenes = objOrden.getTordenexamensucursals();
						Iterator objIterator =  setExamenes.iterator();
						while (objIterator.hasNext()) {
							TOrdenExamenSucursal objOrdenExamenSucursal = (TOrdenExamenSucursal)objIterator.next();
							if (bolFacturacionCredito){
								if (objOrdenExamenSucursal.getCestadoregistro().getSestadoregistro().trim() != "CANCELADO" && objOrdenExamenSucursal.getCestadoregistro().getSestadoregistro().trim() != "NOFACTURABLE") {
									objReturn.getLstExamenes().add(this.convertExamenHBBean(objOrdenExamenSucursal, "ConvertBeanvsHB.convertOrdenHBBean"));					
								}
							} else {
								objReturn.getLstExamenes().add(this.convertExamenHBBean(objOrdenExamenSucursal, "ConvertBeanvsHB.convertOrdenHBBean"));					
							}
						}
					} else {
						objReturn.setLstExamenes(new ArrayList());
					}
				} else {
					objReturn.setLstExamenes(new ArrayList());
				}
			} else {
				objReturn.setLstExamenes(new ArrayList());
			}
			iObjLog.debug("Saliendo ConvertBeanvsHB.convertOrdenHBBean:" + strMetodo + "Saliendo...  " + objReturn.toString());			
			
		} catch (LazyInitializationException hbmLazyExcepcion) { 
			iObjLog.error("ERROR LazyInitializationException ConvertBeanvsHB.convertOrdenHBBean: ", hbmLazyExcepcion);
			objReturn.setLstExamenes(new ArrayList());
			return objReturn;
		} catch (Exception exp) {
			iObjLog.error("Error ConvertBeanvsHB.convertOrdenHBBean:" + strMetodo + "Error...  ",exp);			
			throw exp;
		}
		return objReturn;
	}	

	
	public OrdenBean convertOrdenCotizacionHBBean(TOrdenSucursalCotizacion objOrden,String strMetodo,boolean bolFacturacionCredito,boolean bolSearchExamenes) throws Exception {
		iObjLog.debug("Entrando ConvertBeanvsHB.convertOrdenHBBean:" + strMetodo + "Resultado...  " + objOrden.toString());
		OrdenBean objReturn = new OrdenBean();
		try {
			PacienteBean objPacienteBean = new PacienteBean();
			    objPacienteBean.setKpacientefundacion(new Integer(objOrden.getTpaciente().getKpaciente().intValue()));
			    objPacienteBean.setCsexo(objOrden.getTpaciente().isBsexo());
			    objPacienteBean.setDnacimiento(objOrden.getTpaciente().getDnacimiento());
			    objPacienteBean.setSnombre(objOrden.getTpaciente().getSnombre());
			    objPacienteBean.setSappaterno(objOrden.getTpaciente().getSapellidopaterno());
			    objPacienteBean.setSapmaterno(objOrden.getTpaciente().getSapellidomaterno());				   				    
			objReturn.setBpacientebean(objPacienteBean);
		    objReturn.setBregistroactivo(false);
			objReturn.setCestado(objOrden.getCestadoregistro().getCestadoregistro().intValue());
			objReturn.setCordenfundacion(0);			
			objReturn.setCusuario(objOrden.getUserId().intValue());
			objReturn.setDentregaresultado(objOrden.getDregistro());
			objReturn.setDpromesa(objOrden.getDregistro());
			objReturn.setDregistro(objOrden.getDregistro());
			objReturn.setKadmision(objOrden.getKordensucursalcotizacion().longValue());				
			objReturn.setMacuenta(0.0);
			objReturn.setMadeuda(objOrden.getMpagopaciente().doubleValue());							
			objReturn.setMdescuento((objOrden.getMdescuentomedico().doubleValue()));
			objReturn.setMdescuentoempresa(objOrden.getMdescuentoempresa().doubleValue());
			objReturn.setMdescuentopaciente(objOrden.getMdescuentopromocion().doubleValue());
			objReturn.setMfacturaempresa(objOrden.getMfacturaempresa().doubleValue());
			objReturn.setMiva(objOrden.getMiva().doubleValue());
			objReturn.setMsubtotal(objOrden.getMsubtotal().doubleValue());
			objReturn.setMtotal(objOrden.getMtotal().doubleValue());
			objReturn.setMpagapaciente(objOrden.getMpagopaciente().doubleValue());
			objReturn.setNfactura(0);
			objReturn.setSobservacion(objOrden.getSobservacion());
			objReturn.setCmedico(objOrden.getCmedico().getCmedico().intValue());
			objReturn.setKmedico(objOrden.getCmedico().getCmedico().intValue());
			objReturn.setSnombre(objOrden.getCmedico().getSnombre());
			objReturn.setSappaterno(objOrden.getCmedico().getSapellidopaterno());
			objReturn.setSapmaterno(objOrden.getCmedico().getSapellidomaterno());			
			ClientesNewDao objClienteDao = new ClientesNewDao();			
			objReturn.setCconvenio(objOrden.getCconvenio());
			objReturn.setSconvenio(objClienteDao.getNombreConvenio(new ConvenioBean(new Integer(objOrden.getCconvenio()))));
			objClienteDao = null;
			objReturn.setSordenfundacion(objOrden.getCsucursal().getSsucursal());
			objReturn.setCsucursal(objOrden.getCsucursal().getCsucursal().intValue());
//			objReturn.setSordencompleta(this.llenaIdFactura(objReturn.getSordenfundacion(),String.valueOf(objReturn.getCordenfundacion()) , 8));
//			objReturn.setSdentregaresultado(new Formatos().getFechaNumeros(objOrden.getDresultadoentrega()));
//			if (bolSearchExamenes) {
//				if (objOrden.getTordenexamensucursals() != null) {
//					if (!objOrden.getTordenexamensucursals().isEmpty()) {
//						Set setExamenes = objOrden.getTordenexamensucursals();
//						Iterator objIterator =  setExamenes.iterator();
//						while (objIterator.hasNext()) {
//							TOrdenExamenSucursal objOrdenExamenSucursal = (TOrdenExamenSucursal)objIterator.next();
//							if (bolFacturacionCredito){
//								if (objOrdenExamenSucursal.getCestadoregistro().getSestadoregistro().trim() != "CANCELADO" && objOrdenExamenSucursal.getCestadoregistro().getSestadoregistro().trim() != "NOFACTURABLE") {
//									objReturn.getLstExamenes().add(this.convertExamenHBBean(objOrdenExamenSucursal, "ConvertBeanvsHB.convertOrdenHBBean"));					
//								}
//							} else {
//								objReturn.getLstExamenes().add(this.convertExamenHBBean(objOrdenExamenSucursal, "ConvertBeanvsHB.convertOrdenHBBean"));					
//							}
//						}
//					} else {
//						objReturn.setLstExamenes(new ArrayList());
//					}
//				} else {
//					objReturn.setLstExamenes(new ArrayList());
//				}
//			} else {
				objReturn.setLstExamenes(new ArrayList());
//			}
			iObjLog.debug("Saliendo ConvertBeanvsHB.convertOrdenHBBean:" + strMetodo + "Saliendo...  " + objReturn.toString());						
		} catch (LazyInitializationException hbmLazyExcepcion) { 
			iObjLog.error("ERROR LazyInitializationException ConvertBeanvsHB.convertOrdenHBBean: ", hbmLazyExcepcion);
			objReturn.setLstExamenes(new ArrayList());
			return objReturn;
		} catch (Exception exp) {
			iObjLog.error("Error ConvertBeanvsHB.convertOrdenHBBean:" + strMetodo + "Error...  ",exp);			
			throw exp;
		}
		return objReturn;
	}	
		
	public OrdenBean convertOrdenFacHBBean(TOrdenSucursal objOrden,TOrdenSucursalFac objOrdenFac,TPagoPaciente objPagoPaciente,String strMetodo,boolean bolIncluyeExamenes) throws Exception {
		iObjLog.debug("Entrando ConvertBeanvsHB.convertOrdenFacHBBean:" + strMetodo + "Resultado...  " + objOrdenFac.toString());
		OrdenBean objReturn = new OrdenBean();
		try {
			PacienteBean objPacienteBean = new PacienteBean();
			    objPacienteBean.setKpacientefundacion(new Integer(objOrden.getTpaciente().getKpaciente().intValue()));
			    objPacienteBean.setCsexo(objOrden.getTpaciente().isBsexo());
			    objPacienteBean.setDnacimiento(objOrden.getTpaciente().getDnacimiento());
			    objPacienteBean.setSnombre(objOrden.getTpaciente().getSnombre());
			    objPacienteBean.setSappaterno(objOrden.getTpaciente().getSapellidopaterno());
			    objPacienteBean.setSapmaterno(objOrden.getTpaciente().getSapellidomaterno());				   				    
			objReturn.setBpacientebean(objPacienteBean);
		    objReturn.setBregistroactivo(objOrden.isBregistroactivo());
			objReturn.setCestado(objOrdenFac.getCestadoregistro().getCestadoregistro().intValue());
			objReturn.setCordenfundacion(objOrdenFac.getUorden());
			objReturn.setCusuario(objOrdenFac.getUserId().intValue());
			objReturn.setDentregaresultado(objOrden.getDresultadoentrega());
			objReturn.setDpromesa(objOrden.getDresultadoentrega());
			objReturn.setDregistro(objOrdenFac.getDregistro());
			objReturn.setSentregaresultadosa(objOrden.getSentregaresultadosa());
			objReturn.setKadmision(objOrden.getKordensucursal().intValue());				
			objReturn.setKadmision(objOrdenFac.getKordensucursal());				
			if (objPagoPaciente != null) {
				objReturn.setMacuenta((objPagoPaciente.getManticipo().doubleValue() + objPagoPaciente.getMpagopacienteparcial().doubleValue()));
				objReturn.setMadeuda(objPagoPaciente.getMsaldo().doubleValue());							
				objReturn.setcUltimoTipoPago(objPagoPaciente.getCtipopago().getCtipopago().intValue());
				objReturn.setsUltimosTipoPago(objPagoPaciente.getCtipopago().getUtipopagofactura());					
				objReturn.setsUltimosDigitosPago(objPagoPaciente.getSdigitostarjeta());
			} else {
				objReturn.setMacuenta(0.0);
				objReturn.setMadeuda(objOrdenFac.getMpagopaciente().doubleValue());							
				objReturn.setcUltimoTipoPago(0);
				objReturn.setsUltimosTipoPago("99 - Otros");					
				objReturn.setsUltimosDigitosPago("");
			}
			objReturn.setMdescuento((objOrdenFac.getMdescuentomedico().doubleValue()));
			objReturn.setMdescuentoempresa(objOrdenFac.getMdescuentoempresa().doubleValue());
			objReturn.setMdescuentopaciente(objOrdenFac.getMdescuentopromocion().doubleValue());
			objReturn.setMfacturaempresa(objOrdenFac.getMfacturaempresa().doubleValue());
			objReturn.setMiva(objOrdenFac.getMiva().doubleValue());
			objReturn.setMsubtotal(objOrdenFac.getMsubtotal().doubleValue());
			if (objOrdenFac.getMfacturaempresa().doubleValue() > 0.0) {
				objReturn.setMtotal(objOrdenFac.getMfacturaempresa().doubleValue());
			} else {
				objReturn.setMtotal(objOrdenFac.getMpagopaciente().doubleValue());
			}
			objReturn.setMpagapaciente(objOrdenFac.getMpagopaciente().doubleValue());
			objReturn.setNfactura(objOrdenFac.getUorden());
			objReturn.setSobservacion(objOrden.getSobservacion());
			objReturn.setCmedico(objOrden.getCmedico().getCclave());
			objReturn.setKmedico(objOrden.getCmedico().getCmedico().intValue());
			objReturn.setSnombre(objOrden.getCmedico().getSnombre());
			objReturn.setSappaterno(objOrden.getCmedico().getSapellidopaterno());
			objReturn.setSapmaterno(objOrden.getCmedico().getSapellidomaterno());			
			ClientesNewDao objClienteDao = new ClientesNewDao();			
			objReturn.setCconvenio(objOrdenFac.getCconvenio().getCconvenio().intValue());
			objReturn.setSconvenio(objClienteDao.getNombreConvenio(new ConvenioBean(new Integer(objOrdenFac.getCconvenio().getCconvenio().intValue()))));
			objClienteDao = null;
			objReturn.setSordenfundacion(objOrdenFac.getSsucursal());
			objReturn.setCsucursal(objOrdenFac.getCsucursal().getCsucursal().intValue());
			objReturn.setSordencompleta(this.llenaIdFactura(objReturn.getSordenfundacion(),String.valueOf(objReturn.getCordenfundacion()) , 8));
			objReturn.setSdentregaresultado(new Formatos().getFechaNumeros(objOrden.getDresultadoentrega()));
			if (objOrdenFac.getTordenexamensucursalfacs() != null && bolIncluyeExamenes) {
				if (!objOrdenFac.getTordenexamensucursalfacs().isEmpty()) {
					Set setExamenes = objOrdenFac.getTordenexamensucursalfacs();
					Iterator objIterator =  setExamenes.iterator();
					while (objIterator.hasNext()) {
						TOrdenExamenSucursalFac objOrdenExamenSucursal = (TOrdenExamenSucursalFac)objIterator.next();
						if (objOrdenExamenSucursal.getCestadoregistro().getSestadoregistro().trim() != "CANCELADO" && objOrdenExamenSucursal.getCestadoregistro().getSestadoregistro().trim() != "NOFACTURABLE") {
							objReturn.getLstExamenes().add(this.convertExamenFacHBBean(objOrdenExamenSucursal, "ConvertBeanvsHB.convertOrdenHBBean"));					
						}
					}
				} else {
					objReturn.setLstExamenes(new ArrayList());
				}
			} else {
				objReturn.setLstExamenes(new ArrayList());
			}
			iObjLog.debug("Saliendo ConvertBeanvsHB.convertOrdenFacHBBean:" + strMetodo + "Saliendo...  " + objReturn.toString());			
			
		} catch (LazyInitializationException hbmLazyExcepcion) { 
			iObjLog.error("ERROR LazyInitializationException ConvertBeanvsHB.convertOrdenFacHBBean: ", hbmLazyExcepcion);
			objReturn.setLstExamenes(new ArrayList());
			return objReturn;
		} catch (Exception exp) {
			iObjLog.error("Error ConvertBeanvsHB.convertOrdenFacHBBean:" + strMetodo + "Error...  ",exp);			
			throw exp;
		}
		return objReturn;
	}	
	
	public OrdenExamenBean convertExamenHBBean(TOrdenExamenSucursal objOrdenExamen,String strMetodo) throws Exception {
		iObjLog.debug("Entrando ConvertBeanvsHB.convertExamenHBBean:" + strMetodo + "Resultado...  " + objOrdenExamen.toString());
		OrdenExamenBean objReturn = new OrdenExamenBean();
		try {
			objReturn.setCconvenio(objOrdenExamen.getCconvenio().getCconvenio().intValue());
			objReturn.setCestadoregistro(objOrdenExamen.getCestadoregistro().getCestadoregistro().intValue());
			objReturn.setCexamen(objOrdenExamen.getCexamen().getCexamen().intValue());
			objReturn.setClugarprocesamiento(objOrdenExamen.getClugarprocesamiento().getClugarprocesamiento().intValue());
			objReturn.setDregistro(objOrdenExamen.getDregistro());
			objReturn.setDresultadoentrega(objOrdenExamen.getDresultadoentrega());
			objReturn.setKordenexamensucursal(objOrdenExamen.getKordenexamensucursal());
			objReturn.setKpromocion(objOrdenExamen.getKpromocion());
			objReturn.setMdescuentoempresa(objOrdenExamen.getMdescuentoempresa().doubleValue());
			objReturn.setMdescuentomedico(objOrdenExamen.getMdescuentomedico().doubleValue());
			objReturn.setMdescuentopromocion(objOrdenExamen.getMdescuentopromocion().doubleValue());
			objReturn.setMfacturaempresa(objOrdenExamen.getMfacturaempresa().doubleValue());
			objReturn.setMiva(objOrdenExamen.getMiva().doubleValue());
			objReturn.setMpagopaciente(objOrdenExamen.getMpagopaciente().doubleValue());
			objReturn.setMsubtotal(objOrdenExamen.getMsubtotal().doubleValue());
			objReturn.setMtotal(objOrdenExamen.getMtotal().doubleValue());
			objReturn.setSexamen(objOrdenExamen.getCexamen().getSexamen());
			objReturn.setSmotivocancelacion(objOrdenExamen.getSmotivocancelacion());
			objReturn.setCperfil(objOrdenExamen.getCperfil().getCperfil().intValue());
			objReturn.setSperfil(objOrdenExamen.getCperfil().getSperfil());
			objReturn.setUmuestra(objOrdenExamen.getUmuestra());
			objReturn.setUserid(objOrdenExamen.getUserid().intValue());
			objReturn.setUvolumenexamen(objOrdenExamen.getUvolumenexamen());
			objReturn.setDtomamuestrainicio(objOrdenExamen.getDtomamuestrainicio());
			objReturn.setDtomamuestratermino(objOrdenExamen.getDtomamuestratermino());
			objReturn.setSlogin_name(objOrdenExamen.getSlogin_name());
			iObjLog.debug("Saliendo ConvertBeanvsHB.convertExamenHBBean:" + strMetodo + "Saliendo...  " + objReturn.toString());
		} catch (Exception exp) {
			iObjLog.error("Error ConvertBeanvsHB.convertExamenHBBean:" + strMetodo + "Error...  ",exp);			
			throw exp;
		}
		return objReturn;
	}	

	public OrdenExamenBean convertExamenFacHBBean(TOrdenExamenSucursalFac objOrdenExamen,String strMetodo) throws Exception {
		iObjLog.debug("Entrando ConvertBeanvsHB.convertExamenFacHBBean:" + strMetodo + "Resultado...  " + objOrdenExamen.toString());
		OrdenExamenBean objReturn = new OrdenExamenBean();
		try {
			objReturn.setCconvenio(0);
			objReturn.setCestadoregistro(objOrdenExamen.getCestadoregistro().getCestadoregistro().intValue());
			objReturn.setCexamen(objOrdenExamen.getCexamen().getCexamen().intValue());
			objReturn.setClugarprocesamiento(0);
			objReturn.setDregistro(objOrdenExamen.getDregistro());
			objReturn.setDresultadoentrega(objOrdenExamen.getDregistro());
			objReturn.setKordenexamensucursal(objOrdenExamen.getKordenexamenfac());
			objReturn.setKpromocion(0);
			objReturn.setMdescuentoempresa(this.redodedoDouble2(objOrdenExamen.getMdescuentoempresa().doubleValue()));
			objReturn.setMdescuentomedico(this.redodedoDouble2(objOrdenExamen.getMdescuentomedico().doubleValue()));
			objReturn.setMdescuentopromocion(this.redodedoDouble2(objOrdenExamen.getMdescuentopromocion().doubleValue()));
			objReturn.setMfacturaempresa(this.redodedoDouble2(objOrdenExamen.getMfacturaempresa().doubleValue()));
			objReturn.setMiva(this.redodedoDouble2(objOrdenExamen.getMiva().doubleValue()));
			objReturn.setMpagopaciente(this.redodedoDouble2(objOrdenExamen.getMpagopaciente().doubleValue()));
			objReturn.setMsubtotal(this.redodedoDouble2(objOrdenExamen.getMsubtotal().doubleValue()));
			objReturn.setMtotal(0.0);
			objReturn.setSexamen(objOrdenExamen.getSexamen());
			objReturn.setSmotivocancelacion("");
			objReturn.setCperfil(objOrdenExamen.getCperfil());
			objReturn.setSperfil(objOrdenExamen.getSperfil());
			objReturn.setUmuestra(0);
			objReturn.setUserid(objOrdenExamen.getUserId());
			objReturn.setUvolumenexamen(objOrdenExamen.getUvolumenexamen());
			iObjLog.debug("Saliendo ConvertBeanvsHB.convertExamenFacHBBean:" + strMetodo + "Saliendo...  " + objReturn.toString());
		} catch (Exception exp) {
			iObjLog.error("Error ConvertBeanvsHB.convertExamenFacHBBean:" + strMetodo + "Error...  ",exp);			
			throw exp;
		}
		return objReturn;
	}	
	
	
	public TOrdenExamenSucursal convertOrdenExamenBeanHB(OrdenExamenBean objOrdenExamenBean,SucursalBean objSucursalBean,String strMetodo) throws Exception {
		iObjLog.debug("Entrando ConvertBeanvsHB.convertnewExamenBeanHB:" + strMetodo + "Resultado...  " + objOrdenExamenBean.toString());
		TOrdenExamenSucursal objReturn = new TOrdenExamenSucursal();
		try {
			
				CConvenio objConvenio = new CConvenio();
				objConvenio.setCconvenio(new Integer(objOrdenExamenBean.getCconvenio()));
			objReturn.setCconvenio(objConvenio);
				CEstadoRegistro objCERExamen = new CEstadoRegistro();					
				objCERExamen.setCestadoregistro(new Integer(objOrdenExamenBean.getCestadoregistro()));			
			objReturn.setCestadoregistro(objCERExamen);
				CExamen objExamen = new CExamen();
				objExamen.setCexamen(new Integer(objOrdenExamenBean.getCexamen()));
			objReturn.setCexamen(objExamen);
				CPerfil objPerfil = new CPerfil();
				objPerfil.setCperfil(new Integer(objOrdenExamenBean.getCperfil()));
			objReturn.setCperfil(objPerfil);
			objReturn.setClugarprocesamiento(this.getLugarProcesamiento(objOrdenExamenBean, objSucursalBean));
			objReturn.setDregistro(new Date());
			objReturn.setKpromocion(objOrdenExamenBean.getKpromocion());
			objReturn.setMsubtotal(new BigDecimal(objOrdenExamenBean.getMsubtotal()));
			objReturn.setMdescuentoempresa(new BigDecimal(objOrdenExamenBean.getMdescuentoempresa()));
			objReturn.setMdescuentomedico(new BigDecimal(objOrdenExamenBean.getMdescuentomedico()));
			objReturn.setMdescuentopromocion(new BigDecimal(objOrdenExamenBean.getMdescuentopromocion()));					
			objReturn.setMfacturaempresa(new BigDecimal(objOrdenExamenBean.getMfacturaempresa()));					
			objReturn.setMiva(new BigDecimal(objOrdenExamenBean.getMiva()));					
			objReturn.setMpagopaciente(new BigDecimal(objOrdenExamenBean.getMpagopaciente()));					
			objReturn.setMtotal(new BigDecimal(objOrdenExamenBean.getMtotal()));
			objReturn.setSexamen(objOrdenExamenBean.getSexamen());
			objReturn.setSmotivocancelacion("");
			objReturn.setDresultadoentrega(objOrdenExamenBean.getDresultadoentrega());
			objReturn.setUmuestra(objOrdenExamenBean.getUmuestra());
			objReturn.setUserid(new BigDecimal(objOrdenExamenBean.getUserid()));			
			objReturn.setKordenexamensucursal(objOrdenExamenBean.getKordenexamensucursal());
			objReturn.setUvolumenexamen(objOrdenExamenBean.getUvolumenexamen());
			objReturn.setDtomamuestrainicio(objOrdenExamenBean.getDtomamuestrainicio());
			objReturn.setDtomamuestratermino(objOrdenExamenBean.getDtomamuestratermino());
			objReturn.setSlogin_name(objOrdenExamenBean.getSlogin_name());
			iObjLog.debug("Saliendo ConvertBeanvsHB.convertnewExamenBeanHB:" + strMetodo + "Saliendo...  " + objReturn.toString());
		} catch (Exception exp) {
			iObjLog.error("Error ConvertBeanvsHB.convertnewExamenBeanHB:" + strMetodo + "Error...  ",exp);			
			throw exp;
		}
		return objReturn;
	}	

	public TOrdenExamenSucursalCotizacion convertOrdenExamenBeanHBOrdenExamenCotizacion(OrdenExamenBean objOrdenExamenBean,SucursalBean objSucursalBean,String strMetodo) throws Exception {
		iObjLog.debug("Entrando ConvertBeanvsHB.convertOrdenExamenBeanHBOrdenExamenCotizacion:" + strMetodo + "Resultado...  " + objOrdenExamenBean.toString());
		TOrdenExamenSucursalCotizacion objReturn = new TOrdenExamenSucursalCotizacion();
		try {			
//				CConvenio objConvenio = new CConvenio();
//				objConvenio.setCconvenio(new Integer(objOrdenExamenBean.getCconvenio()));
			objReturn.setCconvenio(objOrdenExamenBean.getCconvenio());
//				CEstadoRegistro objCERExamen = new CEstadoRegistro();					
//				objCERExamen.setCestadoregistro(new Integer(objOrdenExamenBean.getCestadoregistro()));			
			objReturn.setCestadoregistro(objOrdenExamenBean.getCestadoregistro());
//				CExamen objExamen = new CExamen();
//				objExamen.setCexamen(new Integer(objOrdenExamenBean.getCexamen()));
			objReturn.setCexamen(objOrdenExamenBean.getCexamen());
//				CPerfil objPerfil = new CPerfil();
//				objPerfil.setCperfil(new Integer(objOrdenExamenBean.getCperfil()));
			objReturn.setCperfil(objOrdenExamenBean.getCperfil());
//			objReturn.setClugarprocesamiento(this.getLugarProcesamiento(objOrdenExamenBean, objSucursalBean));
			objReturn.setDregistro(new Date());
//			objReturn.setKpromocion(objOrdenExamenBean.getKpromocion());
			objReturn.setMsubtotal(new BigDecimal((objOrdenExamenBean.getMsubtotal() * objOrdenExamenBean.getUvolumenexamen())));
			objReturn.setMdescuentoempresa(new BigDecimal((objOrdenExamenBean.getMdescuentoempresa()* objOrdenExamenBean.getUvolumenexamen())));
			objReturn.setMdescuentomedico(new BigDecimal((objOrdenExamenBean.getMdescuentomedico()* objOrdenExamenBean.getUvolumenexamen())));
			objReturn.setMdescuentopromocion(new BigDecimal((objOrdenExamenBean.getMdescuentopromocion()* objOrdenExamenBean.getUvolumenexamen())));					
			objReturn.setMfacturaempresa(new BigDecimal((objOrdenExamenBean.getMfacturaempresa() * objOrdenExamenBean.getUvolumenexamen())));					
			objReturn.setMiva(new BigDecimal((objOrdenExamenBean.getMiva()* objOrdenExamenBean.getUvolumenexamen())));					
			objReturn.setMpagopaciente(new BigDecimal((objOrdenExamenBean.getMpagopaciente()* objOrdenExamenBean.getUvolumenexamen())));					
			objReturn.setMtotal(new BigDecimal((objOrdenExamenBean.getMtotal()* objOrdenExamenBean.getUvolumenexamen())));
			objReturn.setSexamen(objOrdenExamenBean.getSexamen());
			objReturn.setSmotivocancelacion("");
//			objReturn.setDresultadoentrega(objOrdenExamenBean.getDresultadoentrega());
//			objReturn.setUmuestra(objOrdenExamenBean.getUmuestra());				
			objReturn.setUserId(new BigDecimal(objOrdenExamenBean.getUserid()));			
			objReturn.setKordenexamensucursalcotizacion(objOrdenExamenBean.getKordenexamensucursal());
			objReturn.setUvolumenexamen(objOrdenExamenBean.getUvolumenexamen());
			iObjLog.debug("Saliendo ConvertBeanvsHB.convertOrdenExamenBeanHBOrdenExamenCotizacion:" + strMetodo + "Saliendo...  " + objReturn.toString());
		} catch (Exception exp) {
			iObjLog.error("Error ConvertBeanvsHB.convertOrdenExamenBeanHBOrdenExamenCotizacion:" + strMetodo + "Error...  ",exp);			
			throw exp;
		}
		return objReturn;
	}	
		
	public static String llenaIdFactura(String strNemonico,String intFactura,int MaxLength) {
		String strReturn = "";
		int intTotal = (strNemonico.length() + intFactura.length());
		for(int i = intTotal;i <= MaxLength;i++) {
			strReturn += "0";
		}		
		return strNemonico + strReturn + intFactura;
	}
		
	public CLugarProcesamiento getLugarProcesamiento(OrdenExamenBean objExamenBean, SucursalBean objSucursal) {
		/*
		 * 1;"LABORATORIO NEZA"
		 * 2;"LABORATORIO ECATEPEC"
		 * 3;"SUCURSAL ROMA"
         * 4;"GABINETES"
		 */
		CLugarProcesamiento objLugarProceamiento = new CLugarProcesamiento();
		if (objExamenBean.getStipocomercial().toUpperCase() == "RUTINA") {
			objLugarProceamiento.setClugarprocesamiento(new Integer(1));			
		} else if (objExamenBean.getStipocomercial().toUpperCase() == "ESPECIAL") {
			objLugarProceamiento.setClugarprocesamiento(new Integer(2));			
		} else if (objExamenBean.getStipocomercial().toUpperCase() == "MAQUILA") {
			objLugarProceamiento.setClugarprocesamiento(new Integer(3));
		} else if (objExamenBean.getStipocomercial().toUpperCase() == "GABINETE") {
			objLugarProceamiento.setClugarprocesamiento(new Integer(4));
		} else {
			objLugarProceamiento.setClugarprocesamiento(new Integer(1));						
		}
		if ((objLugarProceamiento.getClugarprocesamiento().intValue() < 4) && (objSucursal.getCsucursal().intValue() == 7 || objSucursal.getCsucursal().intValue() == 11 || objSucursal.getCsucursal().intValue() == 12)){
			objLugarProceamiento.setClugarprocesamiento(new Integer(2));			
		}
		return objLugarProceamiento;
	}		
	
    private double redodedoDouble2(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }

}
