package mx.com.web2lab.backend.dao.facturacion.mayoreo;

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
import mx.com.web2lab.backend.beans.comer.PagoFacturaBean;
import mx.com.web2lab.backend.dao.comer.PagoFacturaDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura;
import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenExamenSucursalFac;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac;
import mx.com.web2lab.backend.hbm.om.ap.TPagoFactura;
import mx.com.web2lab.backend.hbm.om.lis.CExamen;
import mx.com.web2lab.backend.util.exceptions.AjaxDwrException;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import mx.com.web2lab.backend.util.formatos.Formatos;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FacturacionMayoreoDaoBackup {

	private static Log iObjLog = LogFactory.getLog(FacturacionMayoreoDaoBackup.class);
	    
	private Session iObjSesion = null;
	
	public FacturacionMayoreoDaoBackup(){
		iObjSesion = HibernateUtil.getSession();
	}
		
	public List getOrdenListaFacturarConvenio(int cConvenio) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		ResultSet objRst = null;
		String strQuery = "";
		List lstOrdenes =  new ArrayList();
		iObjLog.debug("Entrando FacturacionMayoreoDao.getOrdenListaFacturarConvenio:...  " + cConvenio);
    	try{            
    		objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	        strQuery = "SELECT kOrdenSucursal 					\n"+
	        		   "FROM T_ORDEN_SUCURSAL_FAC				\n"+
	        		   "WHERE CESTADOREGISTRO IN (37) AND 		\n"+
	        		   "	  CCONVENIO IN (" + cConvenio + ")	\n";  
	        iObjLog.debug("Consulta FacturacionMayoreoDao.getOrdenListaFacturarConvenio:...  " + strQuery);
			objRst = objSta.executeQuery(strQuery);
			while(objRst.next()) {
				lstOrdenes.add(new Integer(objRst.getInt("kOrdenSucursal")));
			}
			iObjLog.debug("Consulta FacturacionMayoreoDao.getOrdenListaFacturarConvenio:...  Ordenes \n " + lstOrdenes.size() + "\n");
			return lstOrdenes;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getOrdenListaFacturarConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
    		objSta = null;
    		objRst = null;
    		strQuery = null;
        }
	}		

	public String agregarExamenOrdenFacturacion(int kOrdenSucursal,List lstExamenes, int User_id, int cConvenio) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		Connection objCon = null;
		Statement objSta = null;
		Statement objStaRecalculo = null;
		ResultSet objRst = null;
		String strQuery = "";
		int kOrdenSucursalFac = 0;
		iObjLog.debug("Entrando FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...  " + kOrdenSucursal);
    	try{            
    		objCon = iObjSesion.connection();
            objSta = null;
	        objSta = objCon.createStatement();
	        objStaRecalculo = objCon.createStatement();
	        strQuery = "SELECT KORDENSUCURSALFAC												\n" +
					   "FROM T_ORDEN_SUCURSAL_FAC												\n" +
					   "WHERE CESTADOREGISTRO IN (38) AND KORDENSUCURSALFAC IN (				\n" +
					   "						SELECT max(KORDENSUCURSALFAC) 					\n" +
					   "						FROM T_ORDEN_SUCURSAL_FAC 						\n" +
					   "						WHERE KORDENSUCURSAL IN ("+ kOrdenSucursal + ")	\n" +
					   "						) 												\n" +
					   "ORDER BY KORDENSUCURSALFAC												\n";  
	        iObjLog.debug("Consulta FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...  " + strQuery);
			objRst = objSta.executeQuery(strQuery);
			while(objRst.next()) {
				kOrdenSucursalFac = objRst.getInt("KORDENSUCURSALFAC");
			}
			if (kOrdenSucursalFac > 0) {			
				this.persistirExamenOrdenFacturacion(kOrdenSucursalFac, kOrdenSucursal,lstExamenes, User_id, cConvenio);
				objStaRecalculo.execute("begin olab_proc_recalculo_ord_fac.proc_recalcula_orden (" + kOrdenSucursalFac + "); end;");
				iObjLog.debug("Consulta FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...Saliendo");
				return "Existo en la Modificacion";
			} else {
				iObjLog.debug("Consulta FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...Saliendo");
				return "La Orden NO esta RETENIDA";
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.agregarExamenOrdenFacturacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
    		objSta = null;
    		objStaRecalculo = null;
    		objRst = null;
    		strQuery = null;
        	HibernateUtil.closeSession();
        }
	}
	
	private void persistirExamenOrdenFacturacion(int kOrdenSucursalFac,int kOrdenSucursal,List lstExamenes,int User_id,int cConvenio) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		short sorVolumen = 1;
		OrdenExamenBean objExamenBean = null;
		TOrdenExamenSucursalFac objOrdenExamenSucursalFac = null;
		iObjLog.debug("Entrando FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...  " + kOrdenSucursal + " Examenes " + lstExamenes.size());
    	try{            
            HibernateUtil.beginTrans();
			CEstadoRegistro objCER = new CEstadoRegistro();
				objCER.setCestadoregistro(new Integer(13));
			TFactura objTFactura = new TFactura();
			objTFactura.setKfactura(new Integer(0));
			TOrdenSucursalFac objTOrdenSucursalFac = new TOrdenSucursalFac();
				objTOrdenSucursalFac.setKordensucursalfac(new Integer(kOrdenSucursalFac));
			for (int i = 0; i < lstExamenes.size() ; i++)
			{
				objOrdenExamenSucursalFac = new TOrdenExamenSucursalFac();
				objExamenBean = ((OrdenExamenBean)lstExamenes.get(i));						
				CExamen objCExamen = new CExamen();
					objCExamen.setCexamen(new Integer(objExamenBean.getCexamen()));
				objOrdenExamenSucursalFac.setTordensucursalfac(objTOrdenSucursalFac);
				objOrdenExamenSucursalFac.setKordenexamensucursal(0);
				objOrdenExamenSucursalFac.setKordensucursal(kOrdenSucursal);
				objOrdenExamenSucursalFac.setCestadoregistro(objCER);
				objOrdenExamenSucursalFac.setCexamen(objCExamen);
				objOrdenExamenSucursalFac.setCperfil(objExamenBean.getCperfil());
				objOrdenExamenSucursalFac.setDcancelacionfactura(new Date());
				objOrdenExamenSucursalFac.setDregistro(new Date());
				objOrdenExamenSucursalFac.setMsubtotal(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMdescuentoempresa(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMdescuentomedico(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMdescuentopromocion(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMfacturaempresa(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMpagopaciente(new BigDecimal(0));
				objOrdenExamenSucursalFac.setMiva(new BigDecimal(0));
				objOrdenExamenSucursalFac.setSexamen(objExamenBean.getSexamen());
				objOrdenExamenSucursalFac.setSperfil(objExamenBean.getSperfil());
				objOrdenExamenSucursalFac.setTfactura(objTFactura);
				objOrdenExamenSucursalFac.setUserId(User_id);
				objOrdenExamenSucursalFac.setUserIdChange(User_id);
				objOrdenExamenSucursalFac.setUvolumenexamen(sorVolumen);
				iObjSesion.save(objOrdenExamenSucursalFac);
				iObjSesion.flush();            					
		 	}
			objCER = null;
		    objTFactura = null;
			objTOrdenSucursalFac = null;
    		iObjLog.debug("Entrando FacturacionMayoreoDao.agregarExamenOrdenFacturacion:...Salir  " + kOrdenSucursal);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.agregarExamenOrdenFacturacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
    		objOrdenExamenSucursalFac = null;
        }
	}		

	public List buscarFacturasAllConveniosHB(String strConvenios) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strConvenios);
			HibernateUtil.beginTrans();
			strQuery = "select bOF 										\n" +					
			   		   "from TFactura bOF 								\n" +	
			           "where bOF.cconvenio in  (" + strConvenios + ") order by kfactura desc";
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
//        	HibernateUtil.closeSession();
    	}		
    	return objListaFactura;
	}		

	
	public List buscarFacturasEmitidasConveniosHB(String strConvenios) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strConvenios);
			HibernateUtil.beginTrans();
			strQuery = "select bOF 											\n" +					
			   		   "from TFactura bOF 									\n" +	
			           "where bOF.cconvenio in  (" + strConvenios + ") and 	\n" +
			           "	  bOF.cestadoregistro = 33 						\n" +
			           "order by kfactura desc";
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
//        	HibernateUtil.closeSession();
    	}		
    	return objListaFactura;
	}		
	

	public List buscarFacturasEmitidasConveniosHBCxC(String strConvenios) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strConvenios);
			HibernateUtil.beginTrans();
			strQuery = "select bOF 											\n" +					
			   		   "from TFactura bOF 									\n" +	
			           "where bOF.cconvenio in  (" + strConvenios + ") and 	\n" +
			   		   "      bOF.csucursal = 1003 and						\n" +
			           "	  bOF.cestadoregistro = 33 						\n" +
			           "order by kfactura desc";
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
//        	HibernateUtil.closeSession();
    	}		
    	return objListaFactura;
	}		
	
	
	public List buscarFacturasCanceladasConveniosHB(String strConvenios) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strConvenios);
			HibernateUtil.beginTrans();
			strQuery = "select bOF 										\n" +					
			   		   "from TFactura bOF 								\n" +	
			           "where bOF.cconvenio in  (" + strConvenios + ") and bOF.cestadoregistro = 34 order by kfactura desc";
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			iObjLog.debug("Entrando FacturacionMayoreoDao.buscarFacturaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.buscarFacturaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
//        	HibernateUtil.closeSession();
    	}		
    	return objListaFactura;
	}		
	
	public static String llenaIdFactura(String strNemonico,String intFactura,int MaxLength) {
		String strReturn = "";
		int intTotal = (strNemonico.length() + intFactura.length());
		for(int i = intTotal;i <= MaxLength;i++) {
			strReturn += "0";
		}		
		return strNemonico + strReturn + intFactura;
	}
	
	public ConvenioBean getFacturasConvenio(ConvenioBean objConvenioBean) throws Exception {
		FacturacionMayoreoDaoBackup objFacturacionMayoreoDao = new FacturacionMayoreoDaoBackup();
		try {
			List lstFacturas = objFacturacionMayoreoDao.buscarFacturasEmitidasConveniosHB(objConvenioBean.getCconvenio().intValue() + "");
			objConvenioBean.setLstFacturas(lstFacturas);
			objConvenioBean.setStrFacturasGrid(this.showBodyConvenioFacturas(objConvenioBean));
		} catch (Exception aObjException) {
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		}
		objFacturacionMayoreoDao = null;
		return objConvenioBean;
	}

	public ConvenioBean getFacturasConvenioCxC(ConvenioBean objConvenioBean) throws Exception {
		FacturacionMayoreoDaoBackup objFacturacionMayoreoDao = new FacturacionMayoreoDaoBackup();
		try {
			List lstFacturas = objFacturacionMayoreoDao.buscarFacturasEmitidasConveniosHBCxC(objConvenioBean.getCconvenio().intValue() + "");
			objConvenioBean.setLstFacturas(lstFacturas);
			objConvenioBean.setStrFacturasGrid(this.showBodyConvenioFacturas(objConvenioBean));
		} catch (Exception aObjException) {
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		}
		objFacturacionMayoreoDao = null;
		return objConvenioBean;
	}
	
	private String showBodyConvenioFacturas(ConvenioBean objConvenioBean) throws Exception
	{		
		TFactura objTFacturaHB = new TFactura();
		FormateaFecha objFormatearDate = new FormateaFecha();
		Formatos objFormatos = new Formatos();
		PagoFacturaDao objPagoFacturaDao = null;
		PagoFacturaBean objPagoFacturaBean = null;
		String strReturn = "";		

		double dblTotalFactura = 0.0;
		double dblSaldoActual = 0.0;
		
		double dblTotalPagado = 0.0;
		double dblTotalSaldo = 0.0;
		double dblTotalDentroPlazo= 0.0;
		double dblTotal30= 0.0;
		double dblTotal60= 0.0;
		double dblTotal90= 0.0;
		double dblTotalMas90= 0.0;
		
		String strColor = "black";
		String strNombreConvenio = objConvenioBean.getCconvenio() + " " + objConvenioBean.getSconvenio();		
		String strMonto1 = "";
		String strMonto2 = "";
		String strMonto3 = "";
		String strMonto4 = "";
		String strMonto5 = "";
		String strTotalFactura = "";
		String strPagoFactura = "";
		String strSaldoFactura = "";
		iObjLog.debug("Entrando a CuentasxCobrarMayoreoAjax.getFacturasConvenio:Entrando... ");
		try {
			 if (objConvenioBean.getLstFacturas() != null) {
				int y = 0; 
				String strEstado = "";
				for (int i = 0; i < objConvenioBean.getLstFacturas().size() ; i++)
				{
					objTFacturaHB = (TFactura)objConvenioBean.getLstFacturas().get(i);						
					y = i + 1;
					if (objTFacturaHB.getCestadoregistro() == 33) {
						if (objTFacturaHB.getSserie().trim() == "NC") {
							strEstado = "EMITIDA";
							strColor = "green";
							
							dblTotalFactura = dblTotalFactura - objTFacturaHB.getMtotal().doubleValue();
							
							dblSaldoActual = (dblSaldoActual - objTFacturaHB.getMtotal().doubleValue());							
							strSaldoFactura = "0";
							strPagoFactura = "0";														
						} else {
							strEstado = "EMITIDA";
							strColor = "black";
							

							objPagoFacturaDao = new PagoFacturaDao();
							objPagoFacturaBean = new PagoFacturaBean();
							objPagoFacturaBean = objPagoFacturaDao.getDatosPagoFacturaCxC(objTFacturaHB.getKfactura().intValue());

							dblTotalFactura = dblTotalFactura + objPagoFacturaBean.getMtotalfactura().doubleValue();
							
							dblTotalPagado = (dblTotalPagado + (objPagoFacturaBean.getMtotalfactura().doubleValue() - objPagoFacturaBean.getMsaldo().doubleValue()));
							dblTotalSaldo = (dblTotalSaldo + objPagoFacturaBean.getMsaldo().doubleValue());
							
							dblSaldoActual = (dblSaldoActual + objPagoFacturaBean.getMsaldo().doubleValue());
							
							strSaldoFactura = objPagoFacturaBean.getMsaldo() + "";
							strPagoFactura = (objPagoFacturaBean.getMtotalfactura().doubleValue() - objPagoFacturaBean.getMsaldo().doubleValue()) + "";														
							strTotalFactura = objPagoFacturaBean.getMtotalfactura().doubleValue() + "";
							
							objPagoFacturaDao = null;
							objPagoFacturaBean = null;
						}
					} else {
						strEstado = "CANCELADA";
						strColor = "red";
					}
					long lngDiferencia = this.diferenciaDates(objTFacturaHB.getDregistro());
					if (lngDiferencia < objConvenioBean.getIntDiasCreditoNew()) {
						dblTotalDentroPlazo = dblTotalDentroPlazo + Double.parseDouble(strSaldoFactura);
						strMonto1 = Double.parseDouble(strSaldoFactura)  + "";
						strMonto2 = "";
						strMonto3 = "";
						strMonto4 = "";
						strMonto5 = "";
					} else if ((lngDiferencia > objConvenioBean.getIntDiasCreditoNew()) && (lngDiferencia < 30)) {
						dblTotal30 = dblTotal30 + Double.parseDouble(strSaldoFactura);
						strMonto1 = "";
						strMonto2 = Double.parseDouble(strSaldoFactura) + "";
						strMonto3 = "";
						strMonto4 = "";
						strMonto5 = "";
					} else if ((lngDiferencia > objConvenioBean.getIntDiasCreditoNew()) && (lngDiferencia < 60)) {
						dblTotal60 = dblTotal60 + Double.parseDouble(strSaldoFactura);
						strMonto1 = "";
						strMonto2 = "";
						strMonto3 = Double.parseDouble(strSaldoFactura) + "";
						strMonto4 = "";
						strMonto5 = "";
					} else if ((lngDiferencia > objConvenioBean.getIntDiasCreditoNew()) && (lngDiferencia < 90)) {
						dblTotal90 = dblTotal90 + Double.parseDouble(strSaldoFactura);
						strMonto1 = "";
						strMonto2 = "";
						strMonto3 = "";
						strMonto4 = Double.parseDouble(strSaldoFactura) + "";
						strMonto5 = "";
					} else {
						dblTotalMas90 = dblTotalMas90 + Double.parseDouble(strSaldoFactura);
						strMonto1 = "";
						strMonto2 = "";
						strMonto3 = "";
						strMonto4 = "";
						strMonto5 = Double.parseDouble(strSaldoFactura) + "";
					}
					strReturn += ("<tr>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											y + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick=\"javascript:showSubModalPago(" + objTFacturaHB.getKfactura() + ",'" + FacturacionMayoreoDaoBackup.llenaIdFactura(objTFacturaHB.getSserie(), objTFacturaHB.getUfoliofactura() + "", 8) +"');\" align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											FacturacionMayoreoDaoBackup.llenaIdFactura(objTFacturaHB.getSserie(), objTFacturaHB.getUfoliofactura() + "", 8)  +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											objFormatearDate.getFecha(objTFacturaHB.getDregistro()) +
										"</a></td>" + 
										"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											"$" + objFormatos.formateaNumero(strTotalFactura) +
										"</a></td>" + 
										"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											"$" + objFormatos.formateaNumero(strPagoFactura) +
										"</a></td>" + 
										"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
											"$" + objFormatos.formateaNumero(strSaldoFactura) +
										"</a></td>" + 
										"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(strMonto1) +
										"</a></td>" + 
										"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(strMonto2) +
										"</a></td>" + 
										"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(strMonto3) +
										"</a></td>" + 
										"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(strMonto4) +
										"</a></td>" + 
										"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
											"$" + objFormatos.formateaNumero(strMonto5) +
										"</a></td>" + 
									 "</tr>");
				}
			}
			strColor = "black"; 			
			double dblNOFacturado = 0.0;
			if (objConvenioBean.getCconvenio().intValue() >= 309 && objConvenioBean.getCconvenio().intValue() <= 312) {
				dblNOFacturado = this.getMontoNOFacturado("309,310,311,312");
			} else {
				dblNOFacturado = this.getMontoNOFacturado(objConvenioBean.getCconvenio() + "");
			}
			strReturn = "<tr>" +
					 		"<table border='0' align='center' style='width: 883px' class='tabla'>" + 
							  "<tr>" + 
								"<td align='left' onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "');\" align='bottom' style='font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;'>Convenio "  +  strNombreConvenio  +
									"</a>" + 
								"</td>" + 
							  "</tr>"	+					 
						    "</table>" +	
						"</tr>" +						
						"<tr>" + 
						"<div id='gridGridFacturasConvenios" + objConvenioBean.getCconvenio() + "' style='visibility:hidden;display:none;'>" +                
			 			"<table border='0' align='center' style='width: 100%' class='tabla'>" +						
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"SALDO FACTURADO" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblSaldoActual))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"VENDIDO NO FACTURADO" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblNOFacturado))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "<tr>" + 
							"<td align='left' style='width: 30%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"SALDO TOTAL" +
							"</td>" + 
							"<td align='right' style='width: 25%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
								"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblSaldoActual + dblNOFacturado))) +
							"</td>" + 
							"<td align='right' style='width: 45%; font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
							"</td>" + 
						  "</tr>"	+					 
						  "</table>" +
						  "<table border='0' align='center' style='width: 883px' class='tabla'>" +						
							this.getTotalesConvenioFacturas(strColor, dblTotalFactura, dblTotalPagado, dblTotalSaldo, dblTotalDentroPlazo, dblTotal30, dblTotal60, dblTotal90, dblTotalMas90, objFormatos) +
							this.getHeaderConvenioFacturas() +
							strReturn + 
							this.getHeaderConvenioFacturas() +
							this.getTotalesConvenioFacturas(strColor, dblTotalFactura, dblTotalPagado, dblTotalSaldo, dblTotalDentroPlazo, dblTotal30, dblTotal60, dblTotal90, dblTotalMas90, objFormatos) +
						"</table>" +	
						"</div>" +
						"</tr>" + 
						"<tr></tr>"; 
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("CuentasxCobrarMayoreoAjax.getFacturasConvenio:Exception....", aObjException);
    	    throw aObjException;
		} finally {
			objPagoFacturaDao = null;
			objPagoFacturaBean = null;
			objTFacturaHB = null;
			objFormatearDate = null;
		}
	}	

	private String getHeaderConvenioFacturas() {
		return ("<tr>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>#" + 
					"	</font></b>" +
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Folio Factura" + 
					"	</font></b>" +
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha Emision" + 
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Total Factura" + 
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Pagado" + 
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Saldo" + 
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Dentro de plazo" + 
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>De 01 a 30" + 
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>De 31 a 60" + 
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>De 61 a 90" + 
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>M&aacute;s de 90" + 
					"</th>" +
				"</tr>");
	}
	
	private String getTotalesConvenioFacturas(String strColor,
											  double dblTotalFactura,
											  double dblTotalPagado,
											  double dblTotalSaldo,
											  double dblTotalDentroPlazo,
											  double dblTotal30,
											  double dblTotal60,
											  double dblTotal90,
											  double dblTotalMas90,
											  Formatos objFormatos) {
		return	("<tr>" + 
					"<td align='center' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
					"</td>" + 
					"<td align='center' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
					"</td>" + 
					"<td align='center' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
					"	<b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>TOTALES</b>" +
					"</td>" + 
					"<td align='center' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalFactura))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalPagado))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'> " + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalSaldo))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalDentroPlazo))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal30))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal60))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotal90))) +
					"</td>" + 
					"<td align='right' style='font-weight: normal; font-size: x-small; color: " + strColor +"; font-style: normal; font-variant: normal;'>" + 
						"$" + objFormatos.formateaNumero(String.valueOf(this.redodedoDouble(dblTotalMas90))) +
					"</td>" + 
				"</tr>");		
	}
	
	private double getMontoNOFacturado(String cConvenios) throws Exception {
		iObjLog.debug("Entrando PagoFacturaDao.getMontoNOFacturado:  " + cConvenios);
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		double dblReturn = 0.0;
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		strQuery =  "SELECT sum(tosf.mfacturaempresa) as mNOFacturado												\n" +																								
			    		"FROM t_orden_sucursal_fac tosf      															\n" +
			    		"WHERE kordensucursalfac = (SELECT get_max_t_orden_suc_fac (kordensucursal)) and 				\n" +
			    		"      tosf.cestadoregistro not in (35,48,39)    					and 						\n" +                                												
			    		"      kordensucursal in (SELECT tos.kordensucursal                     						\n" +              																
			    		"			 FROM t_orden_sucursal tos INNER JOIN t_orden_sucursal_fac tosf 					\n" +
			    		"					ON tos.kordensucursal=tosf.kordensucursal 		and							\n" +			
			    		"				tosf.cconvenio IN (" +  cConvenios + ")			    and 						\n" +
			    		"				tosf.cestadoregistro not in (35,48,39)   										\n" +
			    		"			 WHERE tos.cestadoregistro not in (17) and 											\n" +
			    		"				(tos.dregistro between (sysdate)-60											 	\n" +
			    		"				 and sysdate))		  															\n";
				iObjLog.debug("Consulta PagoFacturaDao.getMontoNOFacturado...  " + strQuery);
				objRst = objStmt.executeQuery(strQuery);
				while (objRst.next()) {
					dblReturn = objRst.getDouble("mNOFacturado");
				}
				objRst.close();
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagoFacturaDao.getMontoNOFacturado: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
//        	HibernateUtil.closeSession();
		}		
		return dblReturn;
	}			
		
    private double redodedoDouble(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }		
    
    private long diferenciaDates(Date dblFechaComparar) {
    	java.util.Date hoy = new Date();  
        GregorianCalendar date1 = new GregorianCalendar();
        date1.setTime(dblFechaComparar); 
        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime(hoy); 
        long dias = 0;       
        if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
            dias =  date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR);
        } else {
            int diasAnyo = date1.isLeapYear(date1.get(Calendar.YEAR)) ? 366 : 365;
            int rangoAnyos = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
            dias = (rangoAnyos * diasAnyo) + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR));
        }
    	return dias;
    }
}
