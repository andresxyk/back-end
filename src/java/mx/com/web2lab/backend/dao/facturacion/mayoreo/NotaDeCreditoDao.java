package mx.com.web2lab.backend.dao.facturacion.mayoreo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.ap.OrdenExamenBean;
import mx.com.web2lab.backend.beans.ap.PagoPacienteBean;
import mx.com.web2lab.backend.beans.facturacion.NotaCreditoBean;
import mx.com.web2lab.backend.beans.facturacion.NotaCreditoFacturaBean;
import mx.com.web2lab.backend.beans.facturacion.DatosAdicionalesBean;
import mx.com.web2lab.backend.beans.facturacion.TdatoAdicionalBean;
import mx.com.web2lab.backend.beans.facturacion.electronica.BodyFacturaElectronicaBean;
import mx.com.web2lab.backend.beans.facturacion.electronica.FacturaElectronicaBean;
import mx.com.web2lab.backend.beans.facturacion.electronica.FacturaElectronicaEmpresaBean;
import mx.com.web2lab.backend.beans.tools.SucursalBean;
import mx.com.web2lab.backend.dao.ap.DatosOrdenDao;
import mx.com.web2lab.backend.dao.ap.ToolsDao;
import mx.com.web2lab.backend.dao.comer.ClientesNewDao;
import mx.com.web2lab.backend.dao.facturacion.electronica.fop.FacturaElectronicaFOPDao;
import mx.com.web2lab.backend.dao.facturacion.electronica.orden.OrdenDatosFacturacionDao;
import mx.com.web2lab.backend.dao.facturacion.electronica.security.SelloDigitalDao;
import mx.com.web2lab.backend.dao.facturacion.tool.DatosFiscalesDao;
import mx.com.web2lab.backend.dao.tools.SucursalDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.CConvenio;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CTipoPago;
import mx.com.web2lab.backend.hbm.om.ap.TCorteCaja;
import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import mx.com.web2lab.backend.hbm.om.ap.TNotaCredito;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursal;
import mx.com.web2lab.backend.hbm.om.ap.TOrdenSucursalFac;
import mx.com.web2lab.backend.hbm.om.ap.TPagoFactura;
import mx.com.web2lab.backend.hbm.om.ap.TPagoPaciente;
import mx.com.web2lab.backend.hbm.om.reportes.TAntiguedadCxc;
import mx.com.web2lab.backend.util.Formatos;



import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import net.sf.hibernate.JDBCException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class NotaDeCreditoDao {

	private static Log iObjLog = LogFactory.getLog(NotaDeCreditoDao.class);
	    
	private Session iObjSesion = null;
	
	private Formatos objFormatos = new Formatos();
	
	public NotaDeCreditoDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	
	public String getFacturasConvenio(int iCconvenio) throws Exception {
		iObjLog.debug("Entrando DatosAdicionalesDao.getFacturasConvenio:" + iCconvenio);
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		String strReturn="";
		NotaCreditoFacturaBean objNotaCreditoFacturaBean=null;
		List objListaFacturas = new ArrayList();
		List objListaFacturasConvenio = new ArrayList();
		TAntiguedadCxc objTFactura= new TAntiguedadCxc();
		
		
    	try{
            if (iCconvenio > 0) {
        		strQuery =  " select Tf"+
        					" from TAntiguedadCxc Tf " +					
							" where Tf.cconvenio="+  iCconvenio;
        		
        		HibernateUtil.beginTrans();
                objQuery = iObjSesion.createQuery(strQuery);
                objListaFacturas = objQuery.list();
        		if (objListaFacturas.isEmpty() == false) {
        			for (int inti=0;inti<objListaFacturas.size();inti++){
        				objNotaCreditoFacturaBean = new NotaCreditoFacturaBean();
        				objTFactura = (TAntiguedadCxc)objListaFacturas.get(inti);
        				objNotaCreditoFacturaBean.setKfactura(new Integer(objTFactura.getKfactura()));
        				objNotaCreditoFacturaBean.setSserie(objTFactura.getSserie());
        				objNotaCreditoFacturaBean.setMpagado(objTFactura.getMpagado());
        				objNotaCreditoFacturaBean.setMsaldo(objTFactura.getMsaldo());
        				objNotaCreditoFacturaBean.setMtotalfactura(objTFactura.getMtotalfactura());
        				objNotaCreditoFacturaBean.setCconvenio(objTFactura.getCconvenio());
        				objNotaCreditoFacturaBean.setDregistro(objTFactura.getDregistro());
        				objListaFacturasConvenio.add(objNotaCreditoFacturaBean);	
        			}
        			strReturn=this.pintarGridFacturas(objListaFacturasConvenio);
        			
        		}else{
        			strReturn="";
        		}
            }  
            iObjLog.debug("Saliendo DatosAdicionalesDao.getNombreConvenio...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosAdicionalesDao.getNombreConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    			HibernateUtil.closeSession();
    			objListaFacturas=null;
    			objTFactura=null;
    			
		}		
	}
	
	
	public String getFacturasConvenioAsignacion(int iCconvenio, String strbloques) throws Exception {
		iObjLog.debug("Entrando DatosAdicionalesDao.getFacturasConvenioAsignacion:" + iCconvenio +"--strbloques--"+strbloques);
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		String strReturn="";
		NotaCreditoFacturaBean objNotaCreditoFacturaBean=null;
		List objListaFacturas = new ArrayList();
		List objListaFacturasConvenio = new ArrayList();
		TAntiguedadCxc objTFactura= new TAntiguedadCxc();
		
		
    	try{
            if (iCconvenio > 0) {


        		strQuery =  " select Tf"+
    						" from TAntiguedadCxc Tf " +					
    						" where Tf.cconvenio="+  iCconvenio;

        		HibernateUtil.beginTrans();             
        		objQuery = iObjSesion.createQuery(strQuery);
                objListaFacturas = objQuery.list();
        		if (objListaFacturas.isEmpty() == false) {
        			for (int inti=0;inti<objListaFacturas.size();inti++){
        				objNotaCreditoFacturaBean = new NotaCreditoFacturaBean();
        				objTFactura = (TAntiguedadCxc)objListaFacturas.get(inti);
        				objNotaCreditoFacturaBean.setKfactura(new Integer(objTFactura.getKfactura()));
        				objNotaCreditoFacturaBean.setSserie(objTFactura.getSserie());
        				objNotaCreditoFacturaBean.setMpagado(objTFactura.getMpagado());
        				objNotaCreditoFacturaBean.setMsaldo(objTFactura.getMsaldo());
        				objNotaCreditoFacturaBean.setMtotalfactura(objTFactura.getMtotalfactura());
        				objNotaCreditoFacturaBean.setCconvenio(objTFactura.getCconvenio());
        				objNotaCreditoFacturaBean.setDregistro(objTFactura.getDregistro());
        				objNotaCreditoFacturaBean.setSBloque(strbloques);
        				objListaFacturasConvenio.add(objNotaCreditoFacturaBean);	
        			}
        			strReturn=this.pintarGridFacturasAsignacionBloque(objListaFacturasConvenio);
        			
        		}else{
        			strReturn="";
        		}
            }  
            iObjLog.debug("Saliendo DatosAdicionalesDao.getNombreConvenioAsiganacion...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosAdicionalesDao.getNombreConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    			HibernateUtil.closeSession();
    			objListaFacturas=null;
    			objTFactura=null;
    			
		}		
	}
	
	 public String getNombreConvenio(int iCconvenio) throws Exception {
			iObjLog.debug("Entrando DatosAdicionalesDao.getNombreConvenio:" + iCconvenio);
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			String strReturn = "";
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
	    	try{
	            HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
	            if (iCconvenio > 0) {
	        		strQuery =  "select cc.* " +					
								" from  C_Convenio cc " +					
								" where cc.cconvenio = " +  iCconvenio;
	            } 
	            if (strQuery != "") {
	            	objRst = objStmt.executeQuery(strQuery);
	            	while (objRst.next()) {
						strReturn = objRst.getString("cconvenio")+"-"+ objRst.getString("sconvenio");            		
	            	}
	            }
				iObjLog.debug("Saliendo DatosAdicionalesDao.getNombreConvenio...  " + strReturn);
				return strReturn;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR DatosAdicionalesDao.getNombreConvenio: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	HibernateUtil.closeSession();
			}		
		}
	 
	 
	 public int getbloqueAsignar(int cConvenio,String srtbloque, int nuevoBloque) throws Exception {
			iObjLog.debug("Entrando DatosAdicionalesDao.getbloqueAsignar:" + cConvenio+"  srtbloque"+srtbloque+"  nuevoBloque"+nuevoBloque);
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			int strReturn = 0;
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
	    	try{
	            HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
	            if (cConvenio > 0) {
	            	strQuery =  "select tosf.* from T_ORDEN_SUCURSAL_FAC tosf  WHERE tosf.CCONVENIO =  "+ cConvenio +" AND   tosf.UCONSECUTIVO IN ( 21"+srtbloque+"22) and tosf.kfactura=0 and tosf.cestadoregistro=37;";
	            } 
	            if (strQuery != "") {
	            	objRst = objStmt.executeQuery(strQuery);
	            	while (objRst.next()) {
						strReturn = 1;            		
	            	}
	            }
				iObjLog.debug("Saliendo DatosAdicionalesDao.getbloqueAsignar...  " + strReturn);
				return strReturn;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR DatosAdicionalesDao.getbloqueAsignar: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	//HibernateUtil.closeSession();
			}		
		}
	 
	 
	 
	 public String getCambioBloque(int cConvenio,String srtbloque, int nuevoBloque) throws Exception {
			iObjLog.debug("Entrando DatosAdicionalesDao.getCambioBloque:" + cConvenio+"  srtbloque"+srtbloque+"  nuevoBloque"+nuevoBloque);
			iObjSesion = HibernateUtil.getSession();
			String strSQL = "";
			String strReturn = "";
			Query objQuery = null;
			String strQuery = "";
			List objListaPagosFactura = new ArrayList();
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
	    	try{
	    		
	    		int valida=this.getbloqueAsignar(cConvenio, srtbloque, nuevoBloque);
	    		
				if (valida==1) {
	    		
		            HibernateUtil.beginTrans();
		            objConn = iObjSesion.connection();
		            objStmt = objConn.createStatement();
		            if (cConvenio > 0) {
		            	strSQL ="UPDATE   T_ORDEN_SUCURSAL_FAC SET UCONSECUTIVO ="+nuevoBloque+"  WHERE CCONVENIO =  "+ cConvenio +" AND   UCONSECUTIVO IN ( 21"+srtbloque+"22) and kfactura=0 and cestadoregistro=37;";
		        		
		            } 
		            
		            if(!strSQL.equals("")){
						   iObjLog.debug("Consulta NotasdeCreditoDao.para UPDATE:..." + strSQL);
						   this.ejecutarConsulta(strSQL);
						   strReturn="Se realizo la asignacion de bloques";
					   }
		            
		            
					iObjLog.debug("Saliendo DatosAdicionalesDao.getCambioBloque...  " + strReturn);
					
				}else{
					strReturn="No existen los bloques a asignar";
				}
				return strReturn;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR DatosAdicionalesDao.getCambioBloque: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	HibernateUtil.closeSession();
			}		
		}
	 
	 
	 public String getTotalBloque(int iCconvenio, String strbloque  ) throws Exception {
			iObjLog.debug("Entrando DatosAdicionalesDao.getTotalBloque:" + iCconvenio  + "--Strbloque--"+ strbloque );
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			String strReturn = "";
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
	
	    	try{
	            HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
	            if (iCconvenio > 0) {
	        		strQuery =  "select sum(mfacturaempresa) as sum " +					
								" from  T_orden_sucursal_Fac tf " +					
								//" where tf.csucursal = 1003 and tf.cestadoregistro = 37 and tf.uconsecutivo in  ( 21"+strbloque +" 22)  and  tf.cconvenio = " +  iCconvenio;
								" where   tf.cestadoregistro = 37 and tf.uconsecutivo in  ( 21"+strbloque +" 22)  and  tf.cconvenio = " +  iCconvenio;
	            } 
	            if (strQuery != "") {
	            	objRst = objStmt.executeQuery(strQuery);
	            	while (objRst.next()) {
						strReturn =   objRst.getString("sum");     // objRst.getString("cconvenio")+"-"+ objRst.getString("sconvenio");            		
	            	}
	            }
				iObjLog.debug("Saliendo DatosAdicionalesDao.getTotalBloque...  " + strReturn);
				return strReturn;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR DatosAdicionalesDao.getTotalBloque: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	HibernateUtil.closeSession();
			}		
		}
	 
	 public int getIdCliente(int iCconvenio) throws Exception {
			iObjLog.debug("Entrando DatosAdicionalesDao.getNombreConvenio:" + iCconvenio);
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			String strReturn = "";
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
			int ccliente = 0;
	    	try{
	            HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
	            if (iCconvenio > 0) {
	        		strQuery =  "select cc.* " +					
								" from  C_Convenio cc " +					
								" where cc.cconvenio = " +  iCconvenio;
	            } 
	            if (strQuery != "") {
	            	objRst = objStmt.executeQuery(strQuery);
	            	while (objRst.next()) {
	            		ccliente = new Integer(objRst.getString("ccliente")).intValue();            		
	            	}
	            }
				iObjLog.debug("Saliendo DatosAdicionalesDao.getNombreConvenio...  " + strReturn);
				return ccliente;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR DatosAdicionalesDao.getNombreConvenio: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	HibernateUtil.closeSession();
			}		
		}
	 
	public String pintarGridFacturas(List objListaFacturaConvenio){
		String strReturn="";
		String strscript="";
		NotaCreditoFacturaBean objNotaCreditoFacturaBean = null;
		
		
		strReturn="<table border='0' align='center' style='width: 883px' class='tabla'>" + 
				  "	<tr colspan='2'>"+
					"		<td>" + 
				  	"			<input type='button' id='idGenerarNota' name='idGenerarNota' value='Generar Nota' onClick='javascript:generarNota();' class='boton'>"+
				  	"		</td>" +
				  	"		<td>" + 
				  	"			<input type='button' id='idNoSeleccionarFacturas' name='idNoSeleccionarFacturas' value='No seleccionar Facturas' onClick='javascript:noseleccionarfacturas();' class='boton'>"+
				  	"		</td>" +
				  "	</tr>"+
				  "<tr>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Factura" + 
					"	</font></b>" +
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Monto Factura con IVA" + 
					"	</font></b>" +
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha Factura" + 
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Monto/Porcentaje Asignado a Nota (IVA)" + 
					"</th>" +
				" </tr>" ;
		for(int i = 0; i < objListaFacturaConvenio.size() ; i++) {
			objNotaCreditoFacturaBean = new NotaCreditoFacturaBean();
			objNotaCreditoFacturaBean  = (NotaCreditoFacturaBean) objListaFacturaConvenio.get(i);
			
			try {
				strReturn+=	"<tr>"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + objNotaCreditoFacturaBean.getSserie() +
								"	</font>" +
								"</td>";
								if(objNotaCreditoFacturaBean.getMpagado().intValue()>0){
									strReturn+=	"<td align=\"right\">" + 
												"	<font color='black'>$" + objFormatos.formateaNumero(objNotaCreditoFacturaBean.getMsaldo())+
												"	</font>" +
												"</td >";
								}else{
									strReturn+=	"<td align=\"right\">" + 
											"	<font color='black'>$" + objFormatos.formateaNumero(objNotaCreditoFacturaBean.getMtotalfactura())+
											"	</font>" +
											"</td >";
								}
					strReturn+=	"<td align=\"center\">" + 
								"	<font color='black'>" + objFormatos.getFechaCompleta(objNotaCreditoFacturaBean.getDregistro())+
								"	</font>" +
								"</td>";
								if(objNotaCreditoFacturaBean.getMpagado().intValue()>0){
									strReturn+=	"<td align=\"center\">"+
												" <input type=\"checkbox\" name='check"+objNotaCreditoFacturaBean.getKfactura()+"' onClick='javascript:elegirfactura(this.checked);'><input type=\"text\" name=\"txt"+objNotaCreditoFacturaBean.getKfactura()+"\" onKeyPress=\"montos();dameporcentaje(this.name);\" onfocus=\"porcentaje(this.name);\" onblur=\"validamonto("+objNotaCreditoFacturaBean.getMsaldo()+",this.name)\"value='"+objNotaCreditoFacturaBean.getMsaldo()+"' size=\"12\" >"+
												"	</font>" +
												"</td>"+
											"</tr>";
								}else{
									strReturn+=	"<td align=\"center\">"+
											" <input type=\"checkbox\" name='check"+objNotaCreditoFacturaBean.getKfactura()+"' onClick='javascript:elegirfactura(this.checked);'><input type=\"text\" name=\"txt"+objNotaCreditoFacturaBean.getKfactura()+"\" onKeyPress=\"montos();dameporcentaje(this.name);\" onfocus=\"porcentaje(this.name);\" onblur=\"validamonto("+objNotaCreditoFacturaBean.getMtotalfactura()+",this.name)\" value='"+objNotaCreditoFacturaBean.getMtotalfactura()+"' size=\"12\" >"+
											"	</font>" +
											"</td>"+
										"</tr>";
								}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
			strReturn+=	"	<tr>"+
						"		<td>"+
						"		</td>"+
						"		<td>"+
						"		</td>"+
						"		<td>"+
						"		</td>"+
						"		<td align=\"center\">"+
						" 			<input type=\"text\" style=\"text-align:right\" name=\"txtTotalNota\" value='0' readOnly='True' size=\"12\" >"+
						"		</td>"+
						"	</tr>"+
						"</table>";
		return strReturn;
	}
	
	
	
	public String pintarGridFacturasAsignacionBloque(List objListaFacturaConvenio){
		String strReturn="";
		String strscript="";
		NotaCreditoFacturaBean objNotaCreditoFacturaBean = null;
		
		iObjLog.debug("Entrando pintarGridFacturasAsignacionBloque...  " + objListaFacturaConvenio.size());
		strReturn="<table border='0' align='center' style='width: 883px' class='tabla'>" + 
				  "	<tr colspan='2'>"+
					"		<td>" + 
				  	"			<input type='button' id='idGenerarNota' name='idGenerarNota' value='Asignar Bloque' onClick='javascript:asignarBloqueFactura();' class='boton'>"+
				  	"		</td>" +
				  	"		<td>" + 
				  	"			<input type='button' id='idNoSeleccionarFacturas' name='idNoSeleccionarFacturas' value='No seleccionar' onClick='javascript:noseleccionarfacturasAsignar();' class='boton'>"+
				  	"		</td>" +
				  	"		<td>" + 
				  	"			<input type='button' id='idGenerarNota' name='idGenerarNota' value='Asiganar Bloque' onClick='javascript:asignarBloqueFactura();' class='boton'>"+
				  	"		</td>" +
				  "	</tr>"+
				  "<tr>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Factura" + 
					"	</font></b>" +
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Monto Factura con IVA" + 
					"	</font></b>" +
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha Factura" + 
					"</th>" + 
//					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
//					"	<b><font color='black'>Bloque(s) a asignar" + 
//					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Seleccione la Factura" + 
					"</th>" +
				" </tr>" ;
		for(int i = 0; i < objListaFacturaConvenio.size() ; i++) {
			objNotaCreditoFacturaBean = new NotaCreditoFacturaBean();
			objNotaCreditoFacturaBean  = (NotaCreditoFacturaBean) objListaFacturaConvenio.get(i);
		//	objNotaCreditoFacturaBean.getCconvenio();
			try {
				strReturn+=	"<tr>"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + objNotaCreditoFacturaBean.getSserie() +
								"	</font>" +
								"</td>";
								if(objNotaCreditoFacturaBean.getMpagado().intValue()>0){
									strReturn+=	"<td align=\"right\">" + 
												"	<font color='black'>$" + objFormatos.formateaNumero(objNotaCreditoFacturaBean.getMsaldo())+
												"	</font>" +
												"</td >";
								}else{
									strReturn+=	"<td align=\"right\">" + 
											"	<font color='black'>$" + objFormatos.formateaNumero(objNotaCreditoFacturaBean.getMtotalfactura())+
											"	</font>" +
											"</td >";
								}
					strReturn+=	"<td align=\"center\">" + 
								"	<font color='black'>" + objFormatos.getFechaCompleta(objNotaCreditoFacturaBean.getDregistro())+
								"	</font>" +
								"</td>";
//					strReturn+=	"<td align=\"center\">" + 
//							"	<font color='black'>" +"<input type=\"text\" name=\"txtBlooques\" size=\"12\"  >" +  
//							"	</font>" +
//							"</td>";
								if(objNotaCreditoFacturaBean.getMpagado().intValue()>0){
									strReturn+=	"<td align=\"center\">"+
												" <input type=\"checkbox\" name='check"+objNotaCreditoFacturaBean.getKfactura()+"' onClick='javascript:elegirfacturaAsignarBloque(this.checked);'> <input readonly style=visibility:hidden  type=\"text\" name=\"txt"+objNotaCreditoFacturaBean.getKfactura()+"\" onKeyPress=\"montos();dameporcentaje(this.name);\" onfocus=\"porcentaje(this.name);\" onblur=\"validamonto("+objNotaCreditoFacturaBean.getMsaldo()+",this.name)\"value='"+objNotaCreditoFacturaBean.getMsaldo()+"' size=\"12\" >"+  //style=visibility:hidden
												"	</font>" +
												"</td>"+
											"</tr>";
								}else{
									strReturn+=	"<td align=\"center\">"+
											" <input type=\"checkbox\" name='check"+objNotaCreditoFacturaBean.getKfactura()+"' onClick='javascript:elegirfacturaAsignarBloque(this.checked);'> <input readonly style=visibility:hidden type=\"text\" name=\"txt"+objNotaCreditoFacturaBean.getKfactura()+"\" onKeyPress=\"montos();dameporcentaje(this.name);\" onfocus=\"porcentaje(this.name);\" onblur=\"validamonto("+objNotaCreditoFacturaBean.getMtotalfactura()+",this.name)\" value='"+objNotaCreditoFacturaBean.getMtotalfactura()+"' size=\"12\" >"+  //style=visibility:hidden 
											"	</font>" +
											"</td>"+
										"</tr>";
								}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
			strReturn+=	"	<tr>"+
						"		<td>"+
						"		</td>"+
						"		<td>"+
						"		</td>"+
						"		<td>"+
						"		</td>"+
						"		<td align=\"center\">"+
						" 			<input type=\"text\"  style=visibility:hidden style=\"text-align:right\" name=\"txtTotalNota\" value='0' readOnly='True'   size=\"12\" >"+
						"		</td>"+
						"	</tr>"+
						"</table>";
		return strReturn;
	}
	
	
	
	
	
	
	
	
	static String llenaIdFactura(String strNemonico,String intFactura,int MaxLength) {
		String strReturn = "";
		int intTotal = (strNemonico.length() + intFactura.length());
		for(int i = intTotal;i <= MaxLength;i++) {
			strReturn += "0";
		}		
		return strNemonico + strReturn+intFactura;
	}
	
	
	public String getFacturasConvenioElegidas(String strfacturasElegidas) throws Exception {
		iObjLog.debug("Entrando NotaDeCreditoDao.getFacturasConvenioElegidas:" + strfacturasElegidas);
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		String strReturn="";
		NotaCreditoFacturaBean objNotaCreditoFacturaBean=null;
		List objListaFacturas = new ArrayList();
		List objListaFacturasConvenio = new ArrayList();
		TAntiguedadCxc objTFactura= new TAntiguedadCxc();
		String[] arrayFacturasElegidas = strfacturasElegidas.split(";");
		String strFacturaElegida="";
		String[] arrayFactura;
		String kfactura;
		String intvalorfactura;
		  
		
		
    	try{
            if (strfacturasElegidas.length()>0) {
            	 for (int i = 0; i < arrayFacturasElegidas.length; i++) {
					   if(!arrayFacturasElegidas[i].equals("")) {
						   strFacturaElegida =arrayFacturasElegidas[i];
						   arrayFactura=strFacturaElegida.split(",");
						   kfactura=arrayFactura[0];
						   intvalorfactura=arrayFactura[1];
						   
						   iObjLog.debug("Entrando NotaDeCreditoDao.getFacturasConvenioElegidas: kfactura " + kfactura+" intvalorfactura"+intvalorfactura);
			        		strQuery =" select Tf"+
		        					  " from TAntiguedadCxc Tf " +					
									  " where Tf.kfactura="+  kfactura;

			        		HibernateUtil.beginTrans();
			                objQuery = iObjSesion.createQuery(strQuery);
			                objListaFacturas = objQuery.list();
			        		if (objListaFacturas.isEmpty() == false) {
			        			for (int inti=0;inti<objListaFacturas.size();inti++){
			        				 iObjLog.debug("Entrando NotaDeCreditoDao.getFacturasConvenioElegidas: kfactura " + kfactura+" intvalorfactura"+intvalorfactura);
			        				objNotaCreditoFacturaBean = new NotaCreditoFacturaBean();
			        				objTFactura = (TAntiguedadCxc)objListaFacturas.get(inti);
			        				objNotaCreditoFacturaBean.setKfactura(new Integer(objTFactura.getKfactura()));
			        				objNotaCreditoFacturaBean.setSserie(objTFactura.getSserie());
			        				objNotaCreditoFacturaBean.setMtotalfactura(objTFactura.getMtotalfactura());
			        				objNotaCreditoFacturaBean.setMpagado(new BigDecimal(intvalorfactura));
			        				objNotaCreditoFacturaBean.setMsaldo(objTFactura.getMsaldo());
			        				objNotaCreditoFacturaBean.setCconvenio(objTFactura.getCconvenio());
			        				objNotaCreditoFacturaBean.setDregistro(objTFactura.getDregistro());
			        				objListaFacturasConvenio.add(objNotaCreditoFacturaBean);	
			        			}
			        			strReturn=this.pintarGridFacturasElegidas(objListaFacturasConvenio,kfactura);
        			
			        		}else{
			        			strReturn="";
			        		}
					   }
            	  }
            }  
            iObjLog.debug("Saliendo NotaDeCreditoDao.getFacturasConvenioElegidas...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR NotaDeCreditoDao.getFacturasConvenioElegidas: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    			HibernateUtil.closeSession();
    			objListaFacturas=null;
    			objTFactura=null;
    			
		}		
	}
				  
	public String getFacturasConvenioElegidasAsignacionBloque(String strfacturasElegidas, String sbloque) throws Exception {
		iObjLog.debug("Entrando NotaDeCreditoDao.getFacturasConvenioElegidasAsignacionBloque:" + strfacturasElegidas+"--SS"+sbloque);
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		String strReturn="";
		NotaCreditoFacturaBean objNotaCreditoFacturaBean=null;
		List objListaFacturas = new ArrayList();
		List objListaFacturasConvenio = new ArrayList();
		TAntiguedadCxc objTFactura= new TAntiguedadCxc();
		String[] arrayFacturasElegidas = strfacturasElegidas.split(";");
		String strFacturaElegida="";
		String[] arrayFactura;
		String kfactura;
		String intvalorfactura;
		  
		
		
    	try{
            if (strfacturasElegidas.length()>0) {
            	 for (int i = 0; i < arrayFacturasElegidas.length; i++) {
					   if(!arrayFacturasElegidas[i].equals("")) {
						   strFacturaElegida =arrayFacturasElegidas[i];
						   arrayFactura=strFacturaElegida.split(",");
						   kfactura=arrayFactura[0];
						   intvalorfactura=arrayFactura[1];
						   
						   iObjLog.debug("Entrando NotaDeCreditoDao.getFacturasConvenioElegidasAsignacionBloque: kfactura " + kfactura+" intvalorfactura"+intvalorfactura);
			        		strQuery =" select Tf"+
		        					  " from TAntiguedadCxc Tf " +					
									  " where Tf.kfactura="+  kfactura;

			        					
			        		HibernateUtil.beginTrans();
			                objQuery = iObjSesion.createQuery(strQuery);
			                objListaFacturas = objQuery.list();
			        		if (objListaFacturas.isEmpty() == false) {
			        			for (int inti=0;inti<objListaFacturas.size();inti++){
			        				 iObjLog.debug("Entrando NotaDeCreditoDao.getFacturasConvenioElegidas: kfactura " + kfactura+" intvalorfactura"+intvalorfactura+"-Sbloque--"+sbloque);
			        				objNotaCreditoFacturaBean = new NotaCreditoFacturaBean();
			        				objTFactura = (TAntiguedadCxc)objListaFacturas.get(inti);
			        				objNotaCreditoFacturaBean.setKfactura(new Integer(objTFactura.getKfactura()));
			        				objNotaCreditoFacturaBean.setSserie(objTFactura.getSserie());
			        				objNotaCreditoFacturaBean.setMtotalfactura(objTFactura.getMtotalfactura());
			        				objNotaCreditoFacturaBean.setMpagado(new BigDecimal(intvalorfactura));
			        				objNotaCreditoFacturaBean.setMsaldo(objTFactura.getMsaldo());
			        				objNotaCreditoFacturaBean.setCconvenio(objTFactura.getCconvenio());
			        				objNotaCreditoFacturaBean.setDregistro(objTFactura.getDregistro());
			        				objNotaCreditoFacturaBean.setSBloque(sbloque);
			        				objListaFacturasConvenio.add(objNotaCreditoFacturaBean);	
			        			}
			        			strReturn=this.pintarGridFacturasElegidasAsignacionBloque(objListaFacturasConvenio);
        			
			        		}else{
			        			strReturn="";
			        		}
					   }
            	  }
            }  
            iObjLog.debug("Saliendo NotaDeCreditoDao.getFacturasConvenioElegidas...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR NotaDeCreditoDao.getFacturasConvenioElegidas: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    			HibernateUtil.closeSession();
    			objListaFacturas=null;
    			objTFactura=null;
    			
		}		
	}
	
	
	
	public String pintarGridFacturasElegidas(List objListaFacturaConvenio,String kfactura){
		String strReturn="";
		String strFacturasElegidas="";
		double totalNota = 0.0;
		NotaCreditoFacturaBean objNotaCreditoFacturaBean = null;
		
		iObjLog.debug("Entrando NotaDeCreditoDao.pintarGridFacturasElegidas...  " + objListaFacturaConvenio.size());
		
		strReturn="<table border='0' align='center' style='width: 883px' class='tabla'>" + 
				  "	<tr colspan='2' align='center'>"+
				  "		<td>" + 
				  "		</td>" +
				  "		<td>" + 
				  "			<input type='button' id='idGenerarNota' name='idGenerarNota' value='Crear Nota.-' onClick='javascript:crearNota();' class='boton'>"+
				  "		</td>" +
				  "		<td>" + 
				  "		</td>" +
				  "	</tr>"+
				  "<tr>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Factura" + 
					"	</font></b>" +
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Monto para la Nota" + 
					"	</font></b>" +
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha Factura" + 
					"</th>" + 
				" </tr>" ;
		for(int i = 0; i < objListaFacturaConvenio.size() ; i++) {
			objNotaCreditoFacturaBean = new NotaCreditoFacturaBean();
			objNotaCreditoFacturaBean  = (NotaCreditoFacturaBean) objListaFacturaConvenio.get(i);
			totalNota=totalNota+objNotaCreditoFacturaBean.getMpagado().doubleValue();
			strFacturasElegidas+=objNotaCreditoFacturaBean.getSserie()+",";
			
			try {
				strReturn+=	"<tr>"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + objNotaCreditoFacturaBean.getSserie()+
								"	</font>" +
								"</td>"+
								"<td align=\"right\">" + 
								"	<font color='black'>$" + objFormatos.formateaNumero(objNotaCreditoFacturaBean.getMpagado())+
								"	</font>" +
								"</td >"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + objFormatos.getFechaCompleta(objNotaCreditoFacturaBean.getDregistro())+
								"	</font>" +
								"</td>"+
							"</tr>";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
			try {
				strReturn+=	"</table>"+
							" <table border='0' align='center' style='width: 883px' class='tabla'>"+
							"	<tr>"+
						  	"		<td align=\"center\">"+
							" 			<font color='black' size='4' >Monto total de la Nota de Credito  $"+objFormatos.formateaNumero(String.valueOf(totalNota))+
							"			</font>"+
							"		</td>"+
							"   </tr>"+
							"	<tr>"+
							"		<td align=\"center\">"+
							" 			<font color='black' size='4' >Convenio "+this.getNombreConvenio(objNotaCreditoFacturaBean.getCconvenio())+
							"			</font>"+
							"		</td>"+
							"   </tr>"+
							"   <tr>"+
							"		<td align=\"center\">"+
							"			Descripción que llevará la Nota de crédito:"+
							"		</td>"+
							"	</tr>"+
							"   <tr>"+
							"  		<td  align=\"center\">"+
							"			"+
							" 			 <textarea id=\"txtdescripcionNota\" rows=\"4\" cols=\"80\" >APLICA A LA FACTURA "+strFacturasElegidas.substring(0,strFacturasElegidas.length()-1)+
							"		 	 </textarea>"+
							"	    </td>"+
							"   </tr>"+
							"	<tr>"+
							"		<td><br><br>"+
							"		</td>"+
							"	</tr>"+
							"	<tr>"+
							"		<td>"+
							"		<hr color=\"black\" size='2' ><br>"+
							"		<div id='divFormFacturaNC' style='display:none'>"+
							" 			<table border='0' align='center' style='width: 883px' class='tabla'>"+
							"				<tr>"+
							"					<td>"+
							"						<b>Numero de Nota:</b>"+
							"					</td>"+
							"					<td>"+
							"						<input type='text' id='txtNumNota' size='20' disabled>"+
							"					</td>"+
							"					<td>"+
							"						<b>Numero de Factura:</b>"+
							"					</td>"+
							"					<td>"+
							"						<input type='text' id='txtNumFactura' size='20' value='"+this.getufoliofactura(Integer.parseInt(kfactura))+"' disabled>"+
							"					</td>"+
							"				</tr>"+
							"				<tr>"+
							"					<td>"+
							"						<b>Forma de Pago:</b>"+
							"					</td>"+
							"					<td>"+
							"						<select id=\"selFormaPago\" style=\"width: 120px\" align=\"up\">"+
						    "						<option value='01'>01 - EFECTIVO</option>"+
						    "						<option value='02'>02 - CHEQUE NOMINATIVO</option>"+
						   	"						<option value='03'>03 - TRANSFERENCIA ELECTRONICA DE FONDOS</option>"+
						   	"						<option value='04'>04 - TARJETA DE CREDITO</option>"+ 
						   	"						<option value='05'>05 - MONEDERO ELECTRONICO</option>"+
						   	"						<option value='06'>06 - DINERO ELECTRONICO</option>"+
						   	"						<option value='08'>08 - VALES DE DESPENSA</option>"+
						   	"						<option value='12'>12 - DACION EN PAGO</option>"+
						   	"						<option value='13'>13 - PAGO POR SUBROGACION</option>"+
						   	"						<option value='14'>14 - PAGO POR CONSIGNACION</option>"+
						   	"						<option value='15'>15 - CONDONACION</option>"+
						   	"						<option value='17'>17 - COMPENSACION</option>"+
						   	"						<option value='23'>23 - NOVACION</option>"+
						   	"						<option value='24'>24 - CONFUSION</option>"+
						   	"						<option value='25'>25 - REMISION DE DEUDA</option>"+
						   	"						<option value='26'>26 - PRESCRIPCION O CADUCIDAD</option>"+
						   	"						<option value='27'>27 - A SATISFACCION DEL ACREEDOR</option>"+
						   	"						<option value='28'>28 - TARJETA DE DEBITO</option>"+
						   	"						<option value='29'>29 - TARJETA DE SERVICIOS</option>"+
						   	"						<option value='30'>30 - APLICACION DE ANTICIPOS</option>"+
						   	"						<option value='99'>99 - POR DEFINIR</option>"+
						   	"						</select>"+
							"					</td>"+
							"					<td>"+
							"						<b>Método de Pago:</b>"+
							"					</td>"+
							"					<td>"+
							"						<select id=\"selMetodoPago\" style=\"width: 120px\" align=\"up\">"+
						    "						<option value='PUE'>PUE - PAGO EN UNA SOLA EXHIBICION</option>"+
						   	"						</select>"+
							"					</td>"+
							"				</tr>"+
							"				<tr>"+
							"					<td>"+
							"						<div id='divuuidFacturaLabel'>"+
							"							<b>UUID Factura:</b>"+
							"						</div>"+
							"					</td>"+
							"					<td>"+
							"						<div id='divuuidFacturaText'>"+
							"							<input type='text' id='txtUuidFactura' size='50' value='"+this.getUuidFactura(Integer.parseInt(kfactura))+"' disabled>"+
							"						</div>"+
							"					</td>"+
							"					<td>"+
							"					</td>"+
							"					<td>"+
							"					</td>"+
							"				</tr>"+
							"				<tr>"+
							"					<td>"+
							"						<input type='checkbox' id='chkAgregarSustitucion' onClick='showCamposSustitucion();'>Sustitucion"+
							"					</td>"+
							"				</tr>"+
							"				<tr>"+
							"					<td>"+
							"						<div id='divuuidSustitucionLabel' style='display:none'>"+
							"							<b>UUID Sustitucion:</b>"+
							"						</div>"+
							"					</td>"+
							"					<td>"+
							"						<div id='divuuidSustitucionText'  style='display:none'>"+
							"							<input type='text' id='txtUuidSustitucion' size='50' disabled>"+
							"							<a id='popupBuscar' href='javascript:doNothing()' onclick=\"javascript:showSubModalSustitucion();\">"+
							"								<img alt='Buscar Sustitucion' id='imgBuscar' border='0' src=\"/web2labportal/images/icoBuscar.png\" width=\"25\" height=\"23\" />"+
							"							</a>"+
							"						</div>"+
							"					</td>"+
							"					<td>"+
							"					</td>"+
							"					<td>"+
							"					</td>"+
							"				</tr>"+
							"				<tr>"+
							"					<th colspan='2' nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
							"						<b><font color='black'>Concepto" + 
							"						</font></b>" +
							"					</th>" + 
							"					<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
							"						<b><font color='black'>Cantidad" + 
							"						</font></b>" +
							"					</th>" + 
							"					<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
							"						<b><font color='black'>IVA" + 
							"						</font></b>" +
							"					</th>" +
							"				</tr>"+
							"				<tr>"+
							"					<td colspan='2'>"+
							"						<input type='text' id='txtConcepto' style=\"WIDTH: 100%\">"+
							"					</td>"+
							"					<td>"+
							"						<input type='text' id='txtCantidad' style=\"WIDTH: 100%\">"+
							"					</td>"+
							"					<td>"+
							"						<select id=\"selIva\" align=\"up\" style=\"WIDTH: 100%\" >"+
						    "						<option value='0'>0</option>"+
						    "						<option value='16'>0.16</option>"+
						   	"						</select>"+
							"					</td>"+							
							"				</tr>"+
							"				<tr>"+
							"					<td align=\"right\">" + 
							"						<br><input type='button' id='idEmitirNota' name='idEmitirNota' value='Emitir Nota de Credito' onClick='javascript:emitirNota();' class='boton'>"+
							"					</td>" +
							"				</tr>"+
							"			</table>"+
							"		</div>"+
							"		</td>"+
							"	</tr>"+
							"</table>";
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return strReturn;
	}
	
	public String getUuidFactura(int kfactura) throws Exception {
		iObjLog.debug("Entrando DatosAdicionalesDao.getNombreConvenio:" + kfactura);
		iObjSesion = HibernateUtil.getSession();
		String strQuery = "";
		String strReturn = "";
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String suuid = "";
    	try{
            HibernateUtil.beginTrans();
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            if (kfactura > 0) {
        		strQuery =  "select tf.* " +					
							" from  t_factura tf " +					
							" where tf.kfactura = " +  kfactura;
            } 
            if (strQuery != "") {
            	objRst = objStmt.executeQuery(strQuery);
            	while (objRst.next()) {
            		suuid = objRst.getString("suddi");            		
            	}
            }
			iObjLog.debug("Saliendo DatosAdicionalesDao.getNombreConvenio...  " + strReturn);
			return suuid;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosAdicionalesDao.getNombreConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}
	
	public String getufoliofactura(int kfactura) throws Exception {
		iObjLog.debug("Entrando DatosAdicionalesDao.getNombreConvenio:" + kfactura);
		iObjSesion = HibernateUtil.getSession();
		String strQuery = "";
		String strReturn = "";
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String folio = "";
    	try{
            HibernateUtil.beginTrans();
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            if (kfactura > 0) {
        		strQuery =  "select tf.* " +					
							" from  t_factura tf " +					
							" where tf.kfactura = " +  kfactura;
            } 
            if (strQuery != "") {
            	objRst = objStmt.executeQuery(strQuery);
            	while (objRst.next()) {
            		folio = objRst.getString("ufoliofactura");            		
            	}
            }
			iObjLog.debug("Saliendo DatosAdicionalesDao.getNombreConvenio...  " + strReturn);
			return folio;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosAdicionalesDao.getNombreConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}

	public String pintarGridFacturasElegidasAsignacionBloque(List objListaFacturaConvenio){
		String strReturn="";
		String strFacturasElegidas="";
		double totalNota = 0.0;
		NotaCreditoFacturaBean objNotaCreditoFacturaBean = null;
		
		iObjLog.debug("Entrando NotaDeCreditoDao.pintarGridFacturasElegidasAsignacionBloque...  " + objListaFacturaConvenio.size());
		
		strReturn="<table border='0' align='center' style='width: 883px' class='tabla'>" + 
				  "	<tr colspan='2' align='center'>"+
				  "		<td>" + 
				  "		</td>" +
				  "		<td>" + 
				  "			<input type='button' id='idGenerarNota' name='idGenerarNota' value='Asiganar Bloque a Factura' onClick='javascript:asignarBloquesFactura();' class='boton'>"+
				  "		</td>" +
				  "		<td>" + 
				  "		</td>" +
				  "	</tr>"+
				  "<tr>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Factura" + 
					"	</font></b>" +
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Monto de la Factura" + 
					"	</font></b>" +
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha Factura" + 
					"</th>" +  
				" </tr>" ;
		for(int i = 0; i < objListaFacturaConvenio.size() ; i++) {
			objNotaCreditoFacturaBean = new NotaCreditoFacturaBean();
			objNotaCreditoFacturaBean  = (NotaCreditoFacturaBean) objListaFacturaConvenio.get(i);
			totalNota=totalNota+objNotaCreditoFacturaBean.getMpagado().doubleValue();
			strFacturasElegidas+=objNotaCreditoFacturaBean.getSserie()+","; 
			 iObjLog.debug("Saliendo NotaDeCreditoDao.getFacturasConvenioElegidas...  " + objNotaCreditoFacturaBean.getSBloque());
			
			try {
				strReturn+=	"<tr>"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + objNotaCreditoFacturaBean.getSserie()+
								"	</font>" +
								"</td>"+
								"<td align=\"right\">" + 
								"	<font color='black'>$" + objFormatos.formateaNumero(objNotaCreditoFacturaBean.getMpagado())+
								"	</font>" +
								"</td >"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + objFormatos.getFechaCompleta(objNotaCreditoFacturaBean.getDregistro())+
								"	</font>" +
								"</td>"+
							"</tr>";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
			try {
				strReturn+=	"</table>"+
							" <table border='0' align='center' style='width: 883px' class='tabla'>"+
							"	<tr>"+
						  	"		<td align=\"center\">"+
							" 			<font color='black' size='4' >Monto total del bloque asignado  $"+objFormatos.formateaNumero(String.valueOf(totalNota))+
							"			</font>"+
							"		</td>"+
							"   </tr>"+
							"		<td align=\"center\">"+
							" 			<font color='black' size='4' >Convenio "+this.getNombreConvenio(objNotaCreditoFacturaBean.getCconvenio())+
							"			</font>"+
							"		</td>"+
							"   </tr>"+
							"		<td align=\"center\">"+
							" 			<font color='black' size='4' >Monto del Bloque "+this.getTotalBloque(objNotaCreditoFacturaBean.getCconvenio(),objNotaCreditoFacturaBean.getSBloque())+   
							"			</font>"+
							"		</td>"+
							"	<tr>"+
							"   </tr>"+
							"   <tr>"+
//							"   <tr>"+
//							"		<td align=\"center\">"+
//							"			Detalle de la modificacion del bloque:"+
//							"		</td>"+
//							"	</tr>"+
//							"   <td  align=\"center\">"+
//							"		"+
//							" 		 <textarea id=\"txtdescripcionNota\" rows=\"4\" cols=\"80\" >APLICA A LA FACTURA "+strFacturasElegidas.substring(0,strFacturasElegidas.length()-1)+
//							"		 </textarea>"+
//							"	    </td>"+
							"   </tr>"+
							"</table>";
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return strReturn;
	}
	
		
	public TNotaCredito buscarNotaHB(FacturaElectronicaBean objfilexmlbean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaFactura = new ArrayList();
		TNotaCredito objTNotaCredito = null;
		Query objQuery = null;
		String strQuery = "";
    	try{
			iObjLog.debug("Entrando NotaDeCreditoDao.buscarNotaHB:Entrando...  " + objfilexmlbean.getKfactura());
			HibernateUtil.beginTrans();
			strQuery = "select bOF 							\n" +					
			   		   "from TNotaCredito bOF 					\n" +	
			           "where ";
			if (objfilexmlbean.getKfactura() > 0) {
				strQuery = strQuery  + " bOF.knotacredito =  " + objfilexmlbean.getKfactura();
			} else {
				strQuery = strQuery  + " bOF.ufoliofactura =  " + objfilexmlbean.getSfolio() + " and bOF.ssucursal = 'EMPRESAS' " ;
			}			
			iObjLog.debug("Entrando NotaDeCreditoDao.buscarNotaHB:Entrando...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaFactura = objQuery.list();
			if (objListaFactura.isEmpty() == false) {
				for (int inti=0;inti<objListaFactura.size();inti++){
					objTNotaCredito = (TNotaCredito)objListaFactura.get(inti);
				}
			}			
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.buscarNotaHB:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.buscarNotaHB: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objListaFactura.clear();
    		objListaFactura = null;
        	HibernateUtil.closeSession();
    	}		
    	return objTNotaCredito;
	}	
	
	
	public FacturaElectronicaBean persistirFactura(FacturaElectronicaBean objFacturaBean) throws Exception {		
		iObjSesion = HibernateUtil.getSession();
		iObjLog.debug("Entrando OrdenDatosFacturacionDao.persistirFactura:...  " + objFacturaBean.getkOrdenSucursal() + " Usuario " + objFacturaBean.getTurbine_User());
    	try{            
    		TNotaCredito objNotaCredito = new TNotaCredito();
    			objNotaCredito.setCcliente(Integer.parseInt(objFacturaBean.getCcliente()));
    			objNotaCredito.setCconvenio(Integer.parseInt(Long.toString(objFacturaBean.getCconvenio())));
    			objNotaCredito.setCentidadlegal(1);
    			objNotaCredito.setCestadoregistro(33);
    			objNotaCredito.setCformapago(1);
    			objNotaCredito.setCsucursal(objFacturaBean.getObjSucursalBean().getCsucursal().intValue());
    			objNotaCredito.setCtipoimpuesto(1);
    			objNotaCredito.setDcancelacionfactura(new Date());
    			objNotaCredito.setDregistro(new Date());
	    		iObjLog.debug("Entrando OrdenDatosFacturacionDao.persistirFactura:... kDatoFiscal  " + objFacturaBean.gethDatosFiscal() + " Usuario " + objFacturaBean.getTurbine_User());
	    		objNotaCredito.setKdatofiscal(objFacturaBean.gethDatosFiscal());
	    		objNotaCredito.setMsubtotal(new BigDecimal(objFacturaBean.getMsubtotal()));
	    		objNotaCredito.setMcopago(new BigDecimal(0));
	    		objNotaCredito.setMdescuento(new BigDecimal(objFacturaBean.getMdescuento()));
	    		objNotaCredito.setMiva(new BigDecimal(objFacturaBean.getMiva()));
	    		objNotaCredito.setMtotal(new BigDecimal(objFacturaBean.getMtotal()));
	    		objNotaCredito.setScadenaoriginal("");
	    		objNotaCredito.setSobservacion("");
	    		objNotaCredito.setSsellodigital("");
	    		objNotaCredito.setSserie(objFacturaBean.getSserie() + "");
	    		objNotaCredito.setSsucursal(objFacturaBean.getObjSucursalBean().getSnombresucursal() + "");
	    		objNotaCredito.setSxml(objFacturaBean.getSxml() + "");
	    		objNotaCredito.setSxmlsello("");
	    		objNotaCredito.setUfoliofactura(Integer.parseInt(objFacturaBean.getSfolio()));
	    		objNotaCredito.setUserId(objFacturaBean.getTurbine_User());
	    		objNotaCredito.setUserIdChange(objFacturaBean.getTurbine_User());
	    	iObjSesion.save(objNotaCredito);	
	    	iObjSesion.flush();
	    	objFacturaBean.setKfactura(objNotaCredito.getKnotacredito().intValue());
			return objFacturaBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.persistirFactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally {
        	HibernateUtil.closeSession();
        }
	}
	
	
	
	public String creaNota(String strfacturasElegidas,int cconvenio,String strdescripcionnota,double dmontonotacredito,Integer user_id) throws Exception{
		String strReturn = null;
		NotaCreditoBean objNotaCreditoBean = new NotaCreditoBean();
		
		try{
			strReturn= this.persistirNota(strfacturasElegidas,cconvenio,strdescripcionnota,dmontonotacredito,user_id);
			
				
		}catch(Exception aObjExcepcion){
			iObjLog.error("ERROR OrdenDatosFacturacionDao.actualizarFacturaXML: ", aObjExcepcion);
			throw aObjExcepcion;
		}
		
		return strReturn;
	}
	
	
	
	public String asignarBloqueaFactura(String strfacturasElegidas,int cconvenio,String strdescripcionnota,double dmontonotacredito,Integer user_id,String srtbloque) throws Exception{
		String strReturn = null;
		NotaCreditoBean objNotaCreditoBean = new NotaCreditoBean();
		
		try{
			strReturn= this.persistirBloqueaFactura(strfacturasElegidas,cconvenio,strdescripcionnota,dmontonotacredito,user_id,srtbloque);
			
				
		}catch(Exception aObjExcepcion){
			iObjLog.error("ERROR asignarBloqueaFactura.actualizarFacturaXML: ", aObjExcepcion);
			throw aObjExcepcion;
		}
		
		return strReturn;
	}
	
	
	
	public String persistirNota(String strfacturasElegidas,int cconvenio,String strdescripcionnota,double dmontonotacredito,Integer user_id) throws Exception{
		String strReturn="";
		NotaCreditoBean objNotaCreditoBean = new NotaCreditoBean();
		SucursalDao objSucursalDAO = new SucursalDao();
		DatosFiscalesDao objDatosFiscalesDAO = new DatosFiscalesDao();
		ClientesNewDao objClientes = new ClientesNewDao();
		SucursalDao objSucursalAdionalesDAO = new SucursalDao();
		CConvenio objCconvenio=null;
		TNotaCredito objTNotaCredito;
		Integer knotacredito;
		String [] splitFacturas  = strfacturasElegidas.split(",");
		
		try{
				iObjLog.debug("Entrando NotaDeCreditoDao.persistirNota:...  cconvenio" +cconvenio+" strfacturasElegidas "+strfacturasElegidas + " strdescripcion "+strdescripcionnota);
				objNotaCreditoBean.setObjDatosFiscalesBean(objDatosFiscalesDAO.buscarDatosFiscalesConvenio(new Integer(cconvenio).longValue()));
				objNotaCreditoBean.setCsucursal(new Integer(1004));
				SucursalBean objSucursalTempBean = objSucursalDAO.getSucursal(objNotaCreditoBean.getCsucursal().intValue());
				//Extraer folio
				objSucursalTempBean=objSucursalAdionalesDAO.getDatosFacturarSucursal(objSucursalTempBean,0);
				objNotaCreditoBean.setSsucursal(objSucursalTempBean.getSsucursal());
				objCconvenio=objClientes.getConvenio(cconvenio);
				objNotaCreditoBean.setUfoliofactura(new Integer(objSucursalTempBean.getUfolioactual()));
				objNotaCreditoBean.setCcliente(objCconvenio.getCcliente().getCcliente());
				objNotaCreditoBean.setSdescripcionnota(strdescripcionnota);
				objNotaCreditoBean.setCconvenio(cconvenio);
				objNotaCreditoBean.setCformapago(1);
				objNotaCreditoBean.setCtipoimpuesto(1);
				objNotaCreditoBean.setMiva((dmontonotacredito)-((dmontonotacredito)/1.16));
				objNotaCreditoBean.setMsubtotal((dmontonotacredito)-(objNotaCreditoBean.getMiva()));
				objNotaCreditoBean.setMtotal(dmontonotacredito);
				objNotaCreditoBean.setCentidadlegal(objDatosFiscalesDAO.obtenerEntidadLegal(Integer.parseInt(splitFacturas[0])));
				objNotaCreditoBean.setSfacturas(strfacturasElegidas);
				objNotaCreditoBean.setIuserId(user_id.intValue());
				objNotaCreditoBean.setSserie(objSucursalTempBean.getSserie());
				knotacredito=this.setNotaCredito(objNotaCreditoBean);
				this.setPagoFactura(strfacturasElegidas,knotacredito,user_id);
				//strReturn="Nota creada "+this.llenaIdFactura(objSucursalTempBean.getSserie(),objNotaCreditoBean.getUfoliofactura().toString(), 8);
				objDatosFiscalesDAO.updateNCKfactura(knotacredito.intValue(), Integer.parseInt(splitFacturas[0]));
				strReturn=objNotaCreditoBean.getUfoliofactura().toString();
				
		}catch(Exception aObjExcepcion){
			iObjLog.error("ERROR OrdenDatosFacturacionDao.actualizarFacturaXML: ", aObjExcepcion);
			throw aObjExcepcion;
		}finally{
        	HibernateUtil.closeSession();
		}
		
		return strReturn;
	}
	
	
	public String persistirBloqueaFactura(String strfacturasElegidas,int cconvenio,String strdescripcionnota,double dmontonotacredito,Integer user_id, String strbloque) throws Exception{
		String strReturn="";
		NotaCreditoBean objNotaCreditoBean = new NotaCreditoBean();
		SucursalDao objSucursalDAO = new SucursalDao();
		DatosFiscalesDao objDatosFiscalesDAO = new DatosFiscalesDao();
		ClientesNewDao objClientes = new ClientesNewDao();
		SucursalDao objSucursalAdionalesDAO = new SucursalDao();
		CConvenio objCconvenio=null;
		TNotaCredito objTNotaCredito;
		Integer knotacredito;
		
		try{
				iObjLog.debug("Entrando NotaDeCreditoDao.persistirNota:...  cconvenio" +cconvenio+" strfacturasElegidas "+strfacturasElegidas + " strdescripcion "+strdescripcionnota+ "--bloque--"+strbloque);
				objNotaCreditoBean.setObjDatosFiscalesBean(objDatosFiscalesDAO.buscarDatosFiscalesConvenio(new Integer(cconvenio).longValue()));
				objNotaCreditoBean.setCsucursal(new Integer(1004));
				SucursalBean objSucursalTempBean = objSucursalDAO.getSucursal(objNotaCreditoBean.getCsucursal().intValue());
				//Extraer folio
				objSucursalTempBean=objSucursalAdionalesDAO.getDatosFacturarSucursal(objSucursalTempBean,0);
				objNotaCreditoBean.setSsucursal(objSucursalTempBean.getSsucursal());
				objCconvenio=objClientes.getConvenio(cconvenio);
				objNotaCreditoBean.setUfoliofactura(new Integer(objSucursalTempBean.getUfolioactual()));
				objNotaCreditoBean.setCcliente(objCconvenio.getCcliente().getCcliente());
				objNotaCreditoBean.setSdescripcionnota(strdescripcionnota);
				objNotaCreditoBean.setCconvenio(cconvenio);
				objNotaCreditoBean.setCformapago(1);
				objNotaCreditoBean.setCtipoimpuesto(1);
				objNotaCreditoBean.setMiva((dmontonotacredito)-((dmontonotacredito)/1.16));
				objNotaCreditoBean.setMsubtotal((dmontonotacredito)-(objNotaCreditoBean.getMiva()));
				objNotaCreditoBean.setMtotal(dmontonotacredito);
				objNotaCreditoBean.setCentidadlegal(1);
				objNotaCreditoBean.setSfacturas(strfacturasElegidas);
				objNotaCreditoBean.setIuserId(user_id.intValue());
				objNotaCreditoBean.setSserie(objSucursalTempBean.getSserie());
				objNotaCreditoBean.setStrbloque(strbloque);
				knotacredito=this.setNotaCredito(objNotaCreditoBean);
				this.setBloqueFactura(strfacturasElegidas,knotacredito,user_id,strbloque,cconvenio);
				strReturn="Se asignaron los bloques  "+this.llenaIdFactura(objSucursalTempBean.getSserie(),objNotaCreditoBean.getUfoliofactura().toString(), 8);
			
		}catch(Exception aObjExcepcion){
			iObjLog.error("ERROR OrdenDatosFacturacionDao.actualizarFacturaXML: ", aObjExcepcion);
			throw aObjExcepcion;
		}finally{
        	HibernateUtil.closeSession();
		}
		
		return strReturn;
	}
	
	
	public Integer setNotaCredito(NotaCreditoBean objNotaCredito) throws Exception {
		
		TNotaCredito objTNotaCredito = new TNotaCredito();
		Integer knotacredito;
		iObjSesion = HibernateUtil.getSession();
        
        
		try {						
			iObjLog.debug("Entrando NotaDeCreditoDao.setNotaCredito:...  " +objNotaCredito.getObjDatosFiscalesBean().getkDatosFiscales());
			HibernateUtil.beginTrans();
			objTNotaCredito.setKdatofiscal(objNotaCredito.getObjDatosFiscalesBean().getkDatosFiscales());
            objTNotaCredito.setSsucursal(objNotaCredito.getSsucursal());
            objTNotaCredito.setUfoliofactura(objNotaCredito.getUfoliofactura().intValue());
            objTNotaCredito.setCcliente(objNotaCredito.getCcliente().intValue());
            objTNotaCredito.setCsucursal(objNotaCredito.getCsucursal().intValue());
            objTNotaCredito.setCformapago(objNotaCredito.getCformapago());
            objTNotaCredito.setMsubtotal(new BigDecimal(objNotaCredito.getMsubtotal()));
            objTNotaCredito.setMdescuento(new BigDecimal(0));
            objTNotaCredito.setMcopago(new BigDecimal(0));
            objTNotaCredito.setMiva(new BigDecimal(objNotaCredito.getMiva()));
            objTNotaCredito.setMtotal(new BigDecimal(objNotaCredito.getMtotal()));
            objTNotaCredito.setCtipoimpuesto(objNotaCredito.getCtipoimpuesto());
            objTNotaCredito.setCconvenio(objNotaCredito.getCconvenio());
            objTNotaCredito.setScadenaoriginal("");
            objTNotaCredito.setSsellodigital("");
            objTNotaCredito.setCentidadlegal(objNotaCredito.getCentidadlegal());
            objTNotaCredito.setDregistro(new Date());
            objTNotaCredito.setCestadoregistro(33);
            objTNotaCredito.setDcancelacionfactura(null);
            objTNotaCredito.setUserIdChange(objNotaCredito.getIuserId());
            objTNotaCredito.setUserId(objNotaCredito.getIuserId());
            objTNotaCredito.setSobservacion("");
            objTNotaCredito.setSxml("");
            objTNotaCredito.setSxmlsello("");
            objTNotaCredito.setSserie(objNotaCredito.getSserie());
            iObjSesion.save(objTNotaCredito);
            iObjSesion.flush();            	
//            HibernateUtil.commitTrans();
            knotacredito=objTNotaCredito.getKnotacredito();
			iObjLog.debug("Saliendo NotaDeCreditoDao.setNotaCredito:Saliendo...  ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.setPago:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	//HibernateUtil.closeSession();
		}
		return knotacredito;
	}
	
public void setPagoFactura(String strfacturasElegidas,Integer knotacredito,Integer User_id) throws Exception {
	String[] arrayDatos = strfacturasElegidas.split(";");
	String strFacturas ="'";
	String[] arrayDato;
	String kfactura;
	String kfacturaiva;
	int kpagofactura;
		try {						
			iObjLog.debug("Entrando NotaDeCreditoDao.setPagoFactura:...  " +strfacturasElegidas);
			for (int i = 0; i < arrayDatos.length; i++) {
				   if(!arrayDatos[i].equals("")) {
					   strFacturas =arrayDatos[i];
					   arrayDato=strFacturas.split(",");
					   kfactura=arrayDato[0];
					   kfacturaiva=arrayDato[1];
					   //Buscar pagos e insertar pagos
					   this.persistirPagoFactura(kfactura,kfacturaiva,knotacredito,User_id);
				   }
			}
			       	
//            HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo NotaDeCreditoDao.setNotaCredito:Saliendo...  ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.setPago:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	//HibernateUtil.closeSession();
		}		
	}


public void setBloqueFactura(String strfacturasElegidas,Integer knotacredito,Integer User_id,String srtBloque, int cConvenio) throws Exception {
	String[] arrayDatos = strfacturasElegidas.split(";");
	String strFacturas ="'";
	String[] arrayDato;
	String kfactura;
	String kfacturaiva;
	int kpagofactura;
		try {						
			iObjLog.debug("Entrando Asiganr Bloque .setPagoFactura:...  " +strfacturasElegidas);
			for (int i = 0; i < arrayDatos.length; i++) {
				   if(!arrayDatos[i].equals("")) {
					   strFacturas =arrayDatos[i];
					   arrayDato=strFacturas.split(",");
					   kfactura=arrayDato[0];
					   kfacturaiva=arrayDato[1];
					   //Buscar pagos e insertar pagos
					   this.persistirAsignacionBloque(kfactura,kfacturaiva,knotacredito,User_id,srtBloque,cConvenio);
				   }
			}
			       	
//            HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo NotaDeCreditoDao.setNotaCredito:Saliendo...  ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PagosDao.setPago:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	//HibernateUtil.closeSession();
		}		
	}



	
	public void persistirPagoFactura(String kfactura,String kfacturaiva,Integer knotacredito,Integer User_id) throws  Exception{
		   String strSQL="";
		   Query objQuery = null;
		   String strQuery = "";
		   List objListaPagosFactura = new ArrayList();
		   TPagoFactura objTPagoFactura = new TPagoFactura();
		   TFactura objTFactura = new TFactura() ;
		  try {   
			  		
			  iObjLog.debug("Entrando NotaDeCreditoDao.buscarPagoFactura:...kfactura " + kfactura+" kfacturaiva "+kfacturaiva+" knotacredito"+knotacredito+" User_id"+User_id+"\n");  
				   strQuery =  "select tpf " +					
							   " from TPagoFactura tpf " +					
							   " where tpf.kpagofactura = (select max(pf.kpagofactura) from TPagoFactura pf where pf.tfactura.kfactura="+kfactura+" and pf.cestadoregistro=52 )";		
						        		
				   iObjLog.debug("Consulta NotaDeCreditoDao.buscarPagoFactura:..." + strQuery);	        	
				   HibernateUtil.beginTrans();
				   objQuery = iObjSesion.createQuery(strQuery);
				   objListaPagosFactura = objQuery.list();
				   iObjLog.debug("DatosLista NotasdeCreditoDao.persistirPagoFactura:..." + objListaPagosFactura.size());
				   if (objListaPagosFactura.isEmpty() == false) {
					iObjLog.debug("Actualizando NotaDeCreditoDao.persistirPagoFactura:..." + strQuery);
						for (int inti=0;inti<objListaPagosFactura.size();inti++) {
							objTPagoFactura = (TPagoFactura)objListaPagosFactura.get(inti);  
							strSQL ="INSERT INTO T_PAGO_FACTURA VALUES(t_pago_factura_sequence.NEXTVAL,"+kfactura+","+objTPagoFactura.getMtotalfactura()+","+objTPagoFactura.getMpago().toString()+","+kfacturaiva+","+objTPagoFactura.getMsaldo().subtract(new BigDecimal(kfacturaiva))+",1,"+User_id+",52,sysdate,sysdate,1,"+knotacredito+");";
						}
					}else{
						objTFactura=this.getFactura(new Integer(kfactura).intValue());
						strSQL ="INSERT INTO T_PAGO_FACTURA VALUES(t_pago_factura_sequence.NEXTVAL,"+kfactura+","+objTFactura.getMtotal()+",0.0,"+kfacturaiva+","+objTFactura.getMtotal().subtract(new BigDecimal(kfacturaiva))+",1,"+User_id+",52,sysdate,sysdate,1,"+knotacredito+");";
						iObjLog.debug("strSQL:..." + strSQL);
					}
				   if(!strSQL.equals("")){
					   iObjLog.debug("Consulta NotasdeCreditoDao.para insertar:..." + strSQL);
					   this.ejecutarConsulta(strSQL);
				   }
		   } catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR NotasdeCreditoDao.persistirPagoFactura: ", aObjExcepcion);
				throw aObjExcepcion;
	       } finally{
	    	   objListaPagosFactura.clear();
	    	   objListaPagosFactura = null;
	    	   strQuery = null;
	    	   //HibernateUtil.closeSession();
			}		
	  	}
	
	
	
	
	public void persistirAsignacionBloque(String kfactura,String kfacturaiva,Integer knotacredito,Integer User_id, String strbloque, int cConvenio) throws  Exception{
		   String strSQL="";
		   Query objQuery = null;
		   String strQuery = "";
		   List objListaPagosFactura = new ArrayList();
		   TPagoFactura objTPagoFactura = new TPagoFactura();
		   TFactura objTFactura = new TFactura() ;
		  try {   
			  		
			  iObjLog.debug("Entrando NotaDeCreditoDao.persistirAsignacionBloque:...kfactura " + kfactura+" cConvenio "+cConvenio+" kfacturaiva "+kfacturaiva+" strbloque"+strbloque+" knotacredito"+knotacredito+" User_id"+User_id+"\n");  
				   strQuery =  "select tpf " +					
							   " from TPagoFactura tpf " +					
							   " where tpf.kpagofactura = (select max(pf.kpagofactura) from TPagoFactura pf where pf.tfactura.kfactura="+kfactura+" and pf.cestadoregistro=52 )";		
						        		
				   iObjLog.debug("Consulta NotaDeCreditoDao.buscarPagoFactura:..." + strQuery);	        	
				   HibernateUtil.beginTrans();
				   objQuery = iObjSesion.createQuery(strQuery);
				   objListaPagosFactura = objQuery.list();
				   iObjLog.debug("DatosLista NotasdeCreditoDao.persistirPagoFactura:..." + objListaPagosFactura.size());
				   if (objListaPagosFactura.isEmpty() == false) {
					iObjLog.debug("Actualizando NotaDeCreditoDao.persistirPagoFactura:..." + strQuery);
						for (int inti=0;inti<objListaPagosFactura.size();inti++) {
							objTPagoFactura = (TPagoFactura)objListaPagosFactura.get(inti);  
							strSQL ="UPDATE   T_ORDEN_SUCURSAL_FAC SET CESTADOREGISTRO = 35 , KFACTURA = "+kfactura+" WHERE CCONVENIO =  "+ cConvenio +" AND  KFACTURA = 0  AND UCONSECUTIVO IN ( 21"+strbloque+"22);";
	 
						}
					}else{
						objTFactura=this.getFactura(new Integer(kfactura).intValue());
						strSQL ="UPDATE   T_ORDEN_SUCURSAL_FAC SET CESTADOREGISTRO = 35 , KFACTURA = "+kfactura+" WHERE CCONVENIO =  "+ cConvenio +" AND  KFACTURA = 0  AND UCONSECUTIVO IN ( 21"+strbloque+"22);";
						iObjLog.debug("strSQL:..." + strSQL);
					}
				   if(!strSQL.equals("")){
					   iObjLog.debug("Consulta NotasdeCreditoDao.para UPDATE:..." + strSQL);
					   this.ejecutarConsulta(strSQL);
				   }
		   } catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR NotasdeCreditoDao.persistirPagoFactura: ", aObjExcepcion);
				throw aObjExcepcion;
	       } finally{
	    	   objListaPagosFactura.clear();
	    	   objListaPagosFactura = null;
	    	   strQuery = null;
	    	   //HibernateUtil.closeSession();
			}		
	  	}
	
	public void ejecutarConsulta(String strSQL) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;	
		iObjSesion = HibernateUtil.getSession();
	    iObjLog.debug("Entrando NotaDeCredito.ejecutarConsulta:....   " + strSQL);
	try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			iObjLog.debug("NotaDeCredito.ejecutarConsulta:Consulta......." + strSQL);
			objStatement.execute(strSQL);
			objStatement.execute("COMMIT;");
		} catch (Exception aObjExcepcion) { 
	    iObjLog.error("NotaDeCredito.ejecutarConsulta:Exception....", aObjExcepcion);
	    throw aObjExcepcion;
		} finally{
			if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
	    	//HibernateUtil.closeSession();
		}		
	    iObjLog.debug("Saliendo NotaDeCredito.guardarDatosAdicionales:....   " + strSQL);
	}
	
	
	public TFactura getFactura(int kfactura) throws Exception {
		iObjLog.debug("Entrando NotaDeCreditoDao.getFactura:" + kfactura);
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		String strReturn="";
		List objListaFacturas = new ArrayList();
		TFactura objTFactura= new TFactura();
		
    	try{
            if (kfactura > 0) {
        		strQuery =  " select Tf"+
        					" from TFactura Tf " +					
							" where Tf.kfactura="+kfactura;
        		
        		objQuery = iObjSesion.createQuery(strQuery);
        		objListaFacturas = objQuery.list();
    			if (objListaFacturas.isEmpty() == false) {
    				objTFactura = (TFactura)objListaFacturas.get(0);
    			}
            }  
            iObjLog.debug("Saliendo NotaDeCreditoDao.getFactura...  " + objTFactura);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR NotaDeCreditoDao.getFactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    			//HibernateUtil.closeSession();
    			objListaFacturas=null;
    			//objTFactura=null;
		}		
    	return objTFactura;
	}	
	
	/*
	 public void actualizarFacturaXML(FacturaElectronicaBean objfilexmlbean) throws Exception {
	
		TNotaCredito objNotaCredito = null;
    	try{
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.actualizarFacturaXML:Entrando...  " + objfilexmlbean.getKfactura());
				objNotaCredito = this.buscarNotaHB(objfilexmlbean);
				this.initConnectionDB();
				objNotaCredito.setSxmlsello(objfilexmlbean.getSxml());
				objNotaCredito.setSsellodigital(objfilexmlbean.getSsellodigital());
				iObjSesion.update(objNotaCredito);
				iObjSesion.flush();
			iObjLog.debug("Entrando OrdenDatosFacturacionDao.actualizarFacturaXML:Saliendo...  ");
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR OrdenDatosFacturacionDao.actualizarFacturaXML: ", aObjExcepcion);
			throw aObjExcepcion;
    	} finally{
    		objNotaCredito = null;
    		HibernateUtil.closeSession();
    	}		
	}		
	*/

}
