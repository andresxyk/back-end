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
import mx.com.web2lab.backend.dao.tools.CEstadoRegistroDao;
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


public class BusquedaFacturaDao {

	private static Log iObjLog = LogFactory.getLog(BusquedaFacturaDao.class);
	    
	private Session iObjSesion = null;
	
	private Formatos objFormatos = new Formatos();
	
	public BusquedaFacturaDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public String getBusquedaFactura(String strfoliosFacturas) throws Exception {
		iObjLog.debug("Entrando BusquedaFActuraDao.getBusquedaFactura:" + strfoliosFacturas);
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		String strReturn="";
		
		List objListaFacturas = new ArrayList();
		List objFacturasEncontradas = new ArrayList();
		TFactura objTFactura = new TFactura();
		
		
		try{
	            if (strfoliosFacturas.length()>0) { 		   
				    strQuery =" select Tf"+
			        		  " from TFactura Tf " +					
							  " where Tf.ufoliofactura in("+strfoliosFacturas+") and Tf.csucursal>36 and Tf.csucursal not in(100)";    					
				    HibernateUtil.beginTrans();
				    objQuery = iObjSesion.createQuery(strQuery);
				    objListaFacturas = objQuery.list();
				    if (objListaFacturas.isEmpty() == false) {
				        for (int inti=0;inti<objListaFacturas.size();inti++){
				        	objTFactura = (TFactura)objListaFacturas.get(inti);
				        	iObjLog.debug("Factura encontrada " + objTFactura.getKfactura());
				        	objFacturasEncontradas.add(objTFactura);
				        }
				    }
				    iObjLog.debug("Factura encontradas " + objFacturasEncontradas.size());
				    strReturn=this.pintarFacturas(objFacturasEncontradas);
	            }    		
            iObjLog.debug("Saliendo BusquedaFacturaDao.getBusquedaFactura...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR BusquedaFacturaDao.getBusquedaFactura...: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    			HibernateUtil.closeSession();
    			objListaFacturas=null;
    			objTFactura=null;
    			
		}		
	}

	/*
	public String getBusquedaFacturaAjuste(String strfoliosFacturas) throws Exception {
		 iObjLog.debug("Entrando BusquedaFacturaDao.getBusquedaFacturaAjuste:" + strfoliosFacturas);
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			String strReturn = "";
			String strcta = "";
			String strTipoCuenta = "";
			String strIva = "";
			String strMetodoPago ="";
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
	    	try{
	            HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
	            if (strfoliosFacturas.length() > 0) {
	        		strQuery =  "select tf.msubtotal,tf.miva,tf.mtotal,ccdf.cconvenio,ccdf.sdigitoscuenta,ccdf.stipopago " +					
								" from t_factura tf,c_convenio_dato_fiscal ccdf,t_dato_fiscal tdf " +	
								" where tf.cconvenio=ccdf.cconvenio " +
								" and tdf.kdatofiscal=ccdf.kdatofiscal " +
								" and tf.ufoliofactura=" +  strfoliosFacturas +" and tf.csucursal=1003 and cestadoregistro=33 and scadenaoriginal=' ' ";
	            }
	            
				
	            iObjLog.debug("SQL: " + strQuery);
	            
	            if (strQuery != "") {
	            	objRst = objStmt.executeQuery(strQuery);
	            	while (objRst.next()) {
	            		
	            		strcta = objRst.getString("sdigitoscuenta");
						strReturn = "<table border='0' align='center' style='width: 883px' class='tabla'>" +
									"<input type='hidden' id='hdenMsubtotal' value='"+ objRst.getString("msubtotal") +"' >" +
									"<input type='hidden' id='hdenMiva'   value='"+ objRst.getString("miva") +"' >" +
									"<input type='hidden' id='hdenMtotal' value='"+ objRst.getString("mtotal") +"' >" +
						
									"	<tr >		"+
									"  		<th colspan='4'>"+
									"     		<b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>Datos de la Factura</b>"+
									"  		</th>	"+
									"	</tr>		"+
									"	<tr>		"+ 
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			Subtotal:" + 
									"		</td>" + 
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			$<input type=\"text\" id=\"txtmSubtotal\" name=\"txtmSubtotal\"  onKeyPress=\"numero();\" onBlur=\"validaMonto(this.name);\" size=\"15\" style=\"width:100px;\" value='" + objRst.getString("msubtotal") +"'>" +   
									"		</td>" +
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			No. de Cuenta:" + 
									"		</td>" +
									"		<td> " +
									"			<input type=\"text\" id=\"txtNoCuenta\"  onKeyPress=\"numero();\" size=\"15\" style=\"width:100px;\" value='" + objRst.getString("sdigitoscuenta") +"'>" +  
									"		</td>" +
									" </tr> 	" +
									"  <tr> 					" +
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			Iva:		" + 
									"		</td>				" + 
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			$<input type=\"text\" id=\"txtmIva\" name=\"txtmIva\"  onKeyPress=\"numero();\" onBlur=\"validaMonto(this.name);\" size=\"15\" style=\"width:100px;\" value='" + objRst.getString("miva") +"'>" + 
									"		</td>				" ;
									
									if(strcta.length()>2) {
									  strMetodoPago = "		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
													  "			Método Pago:" + 
													  "		</td>" +
													  "		<td>" +
												  	  "			<input type=\"text\" id=\"txtTipoPago\"  onKeyPress=\"mayuscula();\" size=\"25\" style=\"width:220px;\" value='" + objRst.getString("stipopago") +"'>" +  
												  	  "		</td>" ;
									} else {
									  strMetodoPago = "		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
											   		  "			Método de pago:" + 
											   		  "		</td>" +
											   		  "		<td>" +
											   		  "			<input type=\"text\" id=\"txtTipoPago\"  onKeyPress=\"mayuscula();\" size=\"25\" style=\"width:220px;\" value='" + "99" +"'>" +  
											   		  "		</td>";
									}
									strMetodoPago +=  "   </tr>";
									iObjLog.debug("strMetodoPago: " + strMetodoPago);
									strReturn += strMetodoPago +			  
											 			"  <tr> 					" +
											 			"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
											 			"			Total:			" + 
											 			"		</td>				" + 
											 			"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
														"			$<input type=\"text\" id=\"txtmTotal\" name=\"txtmTotal\"  onKeyPress=\"numero();\" onBlur=\"validaMonto(this.name);\" size=\"15\" style=\"width:100px;\" value='" + objRst.getString("mtotal") +"'>" +  
														"		</td>				" +
														"		<td>				" +
														" 		    &nbsp;			" +
														"		</td>				" +
														"		<td>				" +
														" 		    &nbsp;			" +
														"		</td>				" +
														"  </tr>					" +
														"  <tr> 					" +
														"  </tr> 					" +
														"</table>                   " +
														"<table border='0' align='center' style='width: 883px' class='tabla'>" +
														"  <tr> 					" +
											 			"   	<td valign=\"middle\">Tipo de Factura " +
											 			" 			<select id=\"selTipoFactura\" style=\"width:150px\" align=\"up\" onChange=\"tipoFactura(this.value);\"> " +
											 			"				<option value=\"0\">Seleccionar</option>     " +
											 			"				<option value=\"1\">Detalle Global</option>  " +
											 			"				<option value=\"2\">Detalle por Examenes</option> " +
											 			"			</select>       " +
											 			"		</td> " +
											 			"	 	<td> " +
											 			"			<label id=\"labelfactura\" style=\"width:125px;display:none\"> " +
											 			"				Descripción Factura										   " +
											 			"			</label>													   " +
											 			"			<input type=\"text\" id=\"txtDescripcion\"  onKeyPress=\"mayuscula();\" size=\"30\" style=\"width:300px;display:none\" value=\"ESTUDIOS REALIZADOS SEGUN RELACION ADJUNTA\"> " +
											 			"			<input type=\"button\" id=\"idCrearPdfXml\" name=\"idCrearPdfXml\" value=\"Generar PDF y XML\" onClick=\"generacionPdfXml();\" class=\"boton\"> "+
											 			"		</td> " +
											 			"		<td>" +
											 			"			<input type=\"button\" name=\"LimpiaFac\" value=\"Limpia\" onClick=\"limpiaFactura();\" class=\"boton\"> " +
											 			"		</td> " +
											 			"		<td>				" +
														" 		    &nbsp;			" +
														"		</td>				" +
											 			" 	</tr>                   " +
											 			"</table> "; 
									            		
	            	}
	            }
				iObjLog.debug("Saliendo BusquedaFacturaDao.getBusquedaFacturaAjuste...  " + strReturn);
				return strReturn;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR BusquedaFacturaDao.getBusquedaFacturaAjuste: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	HibernateUtil.closeSession();
			}		
		}

	**/
	//MODIFICACION BY 02/09/2013
	public String getBusquedaFacturaAjuste(String strfoliosFacturas) throws Exception {
		 iObjLog.debug("Entrando BusquedaFacturaDao.getBusquedaFacturaAjuste:" + strfoliosFacturas);
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			String strReturn = "";
			String strcta = "";
			String strTipoCuenta = "";
			String strIva = "";
			String strMetodoPago ="";
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
	    	try{
	            HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
	            if (strfoliosFacturas.length() > 0) {
	        		strQuery =  "select tf.msubtotal,tf.miva,tf.mtotal,ccdf.cconvenio,ccdf.sdigitoscuenta,ccdf.stipopago,cc.cmarca " +					
								" from t_factura tf,c_convenio_dato_fiscal ccdf,t_dato_fiscal tdf,c_cliente cc " +	
								" where tf.cconvenio=ccdf.cconvenio " +
								" and tdf.kdatofiscal=ccdf.kdatofiscal " +
								" and cc.ccliente=tf.ccliente " +
								" and tf.ufoliofactura=" +  strfoliosFacturas +" and tf.csucursal=1003 and tf.cestadoregistro=33 and scadenaoriginal=' ' ";
	            }
	            
				
	            iObjLog.debug("SQL: " + strQuery);
	            
	            if (strQuery != "") {
	            	objRst = objStmt.executeQuery(strQuery);
	            	while (objRst.next()) {
	            		
	            		strcta = objRst.getString("sdigitoscuenta");
						strReturn = "<table border='0' align='center' style='width: 883px' class='tabla'>" +
									"<input type='hidden' id='hdenMsubtotal' value='"+ objRst.getString("msubtotal") +"' >" +
									"<input type='hidden' id='hdenMiva'   value='"+ objRst.getString("miva") +"' >" +
									"<input type='hidden' id='hdenMtotal' value='"+ objRst.getString("mtotal") +"' >" +
									"<input type='hidden' id='cMarca' value='"+ objRst.getInt("cmarca") +"' >" +
						
									"	<tr >		"+
									"  		<th colspan='4'>"+
									"     		<b style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal'>Datos de la Factura</b>"+
									"  		</th>	"+
									"	</tr>		"+
									"	<tr>		"+ 
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			Subtotal:" + 
									"		</td>" + 
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			$<input type=\"text\" id=\"txtmSubtotal\" name=\"txtmSubtotal\"  onKeyPress=\"montos();\" onBlur=\"validaMonto(this.name);\" size=\"15\" style=\"width:100px;\" value='" + objRst.getString("msubtotal") +"'>" +   
									"		</td>" +
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			No. de Cuenta:" + 
									"		</td>" +
									"		<td> " +
									"			<input type=\"text\" id=\"txtNoCuenta\"  onKeyPress=\"numero();\" size=\"15\" style=\"width:100px;\" value='" + objRst.getString("sdigitoscuenta") +"'>" +  
									"		</td>" +
									" </tr> 	" +
									"  <tr> 					" +
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			Iva:		" + 
									"		</td>				" + 
									"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
									"			$<input type=\"text\" id=\"txtmIva\" name=\"txtmIva\"  onKeyPress=\"montos();\" onBlur=\"validaMonto(this.name);\" size=\"15\" style=\"width:100px;\" value='" + objRst.getString("miva") +"'>" + 
									"		</td>				" ;
									
									if(strcta.length()>2) {
									  strMetodoPago = "		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
													  "			Método Pago:" + 
													  "		</td>" +
													  "		<td>" +
												  	  "			<input type=\"text\" id=\"txtTipoPago\"  onKeyPress=\"mayuscula();\" size=\"25\" style=\"width:220px;\" value='" + objRst.getString("stipopago") +"'>" +  
												  	  "		</td>" ;
									} else {
									  strMetodoPago = "		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
											   		  "			Método de pago:" + 
											   		  "		</td>" +
											   		  "		<td>" +
											   		  "			<input type=\"text\" id=\"txtTipoPago\"  onKeyPress=\"mayuscula();\" size=\"25\" style=\"width:220px;\" value='" + "99" +"'>" +  
											   		  "		</td>";
									}
									  strMetodoPago = "		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
											   		  "			Método de pago:" + 
											   		  "		</td>" +
											   		  "		<td>" +
											   		  "			<input type=\"text\" id=\"txtTipoPago\"  onKeyPress=\"mayuscula();\" size=\"25\" style=\"width:220px;\" value='" + "99" +"'>" +  
											   		  "		</td>";
									strMetodoPago +=  "   </tr>";
									iObjLog.debug("strMetodoPago: " + strMetodoPago);
									strReturn += strMetodoPago +			  
											 			"  <tr> 					" +
											 			"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
											 			"			Total:			" + 
											 			"		</td>				" + 
											 			"		<td style=\"font-weight:  bold; font-size: x-small; color: black; font-style: normal; font-variant: normal\">" +
														"			$<input type=\"text\" id=\"txtmTotal\" name=\"txtmTotal\"  onKeyPress=\"montos();\" onBlur=\"validaMonto(this.name);\" size=\"15\" style=\"width:100px;\" value='" + objRst.getString("mtotal") +"'>" +  
														"		</td>				" +
														"		<td>				" +
														" 		    &nbsp;			" +
														"		</td>				" +
														"		<td>				" +
														" 		    &nbsp;			" +
														"		</td>				" +
														"  </tr>					" +
														"  <tr> 					" +
														"  </tr> 					" +
														"</table>                   " +
														"<table border='0' align='center' style='width: 883px' class='tabla'>" +
														"  <tr> 					" +
											 			"   	<td valign=\"middle\">Tipo de Factura " +
											 			" 			<select id=\"selTipoFactura\" style=\"width:150px\" align=\"up\" onChange=\"tipoFactura(this.value);\"> " +
											 			"				<option value=\"0\">Seleccionar</option>     " +
											 			"				<option value=\"1\">Detalle Global</option>  " +
											 			"				<option value=\"2\">Detalle por Examenes</option> " +
											 			"				<option value=\"3\">Detalle Global/ESTUDIOS</option> " +
											 			"				<option value=\"4\">Detalle por Examanes/ADENDA</option> " +
											 			"			</select>       " +
											 			"		</td> " +
											 			"	 	<td> " +
											 			"			<label id=\"labelfactura\" style=\"width:125px;display:none\"> " +
											 			"				Descripción Factura										   " +
											 			"			</label>													   " +
											 			"			<input type=\"text\" id=\"txtDescripcion\"  onKeyPress=\"mayuscula();\" size=\"30\" style=\"width:300px;display:none\" value=\"ESTUDIOS REALIZADOS SEGUN RELACION ADJUNTA\"> " +
											 			"			<label id=\"labelordencompra\" style=\"width:125px;display:none\"> " +
											 			"				Orden Compra										   " +
											 			"			</label>													   " +
											 			"			<input type=\"text\" id=\"txtOrdenCompra\"  onKeyPress=\"numero();\" size=\"30\" style=\"width:100px;display:none\" value=\"0\"> " +
											 			"			<input type=\"button\" id=\"idCrearPdfXml\" name=\"idCrearPdfXml\" value=\"Generar PDF y XML\" onClick=\"generacionPdfXml();\" class=\"boton\"> "+
											 			"		</td> " +
											 			"		<td>" +
											 			"			<input type=\"button\" name=\"LimpiaFac\" value=\"Limpia\" onClick=\"limpiaFactura();\" class=\"boton\"> " +
											 			"		</td> " +
											 			"		<td>				" +
														" 		    &nbsp;			" +
														"		</td>				" +
											 			" 	</tr>                   " +
											 			"</table> "; 
									            		
	            	}
	            }
				iObjLog.debug("Saliendo BusquedaFacturaDao.getBusquedaFacturaAjuste...  " + strReturn);
				return strReturn;
			} catch (Exception aObjExcepcion) { 
				iObjLog.error("ERROR BusquedaFacturaDao.getBusquedaFacturaAjuste: ", aObjExcepcion);
				throw aObjExcepcion;
	        } finally{
	    		objRst = null;
	    		objStmt = null;
	        	HibernateUtil.closeSession();
			}		
		}
	/**
     * Versión 25 de Marzo 2013 
     BY Tomar en cuenta el registro
     */
	public String pintarFacturas(List objListaFacturas){
		String strReturn="";
		String strEstadoFactura="PAGADA";
		TFactura objTFactura = new TFactura();
		CEstadoRegistroDao objCestadoRegistro = new CEstadoRegistroDao();
		
		iObjLog.debug("Entrando BusquedaFacturaDao.pintarFacturas...  " + objListaFacturas.size());
		
		strReturn="<table border='0' align='center' style='width: 883px' class='tabla'>" + 
				  "<tr>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Factura" + 
					"	</font></b>" +
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Monto Factura IVA" + 
					"	</font></b>" +
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha Factura" + 
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Estado de la Factura" + 
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Archivos" + 
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Soporte Factura" + 
					"</th>" + 
				" </tr>" ;
		for(int i = 0; i < objListaFacturas.size() ; i++) {
			objTFactura  = (TFactura) objListaFacturas.get(i);
			try {
				
				if(objTFactura.getCestadoregistro()==33){
					strEstadoFactura="EMITIDA";
				}else if(objTFactura.getCestadoregistro()==34){
					strEstadoFactura="CANCELADA";
				}
								
				strReturn+=	"<tr>"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + this.llenaIdFactura(objTFactura.getSserie(),new Integer(objTFactura.getUfoliofactura()).toString(),8)+
								"	</font>" +
								"</td>"+
								"<td align=\"center\">" + 
								"	<font color='black'>$" + objFormatos.formateaNumero(objTFactura.getMtotal())+
								"	</font>" +
								"</td >"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + objFormatos.getFechaCompleta(objTFactura.getDregistro())+
								"	</font>" +
								"</td >"+
								"<td align=\"center\">" + 
								"	<font color='black'>" + objCestadoRegistro.getSEstadoRegistro(objTFactura.getCestadoregistro())+
								"	</font>" +
								"</td >"+
								"<td align='center' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'> " + 
								"	<a href=\"javascript:visualizarFactura('http://192.237.150.66:9085/FacturasElectronicas_Olab/PDF/FacturacionElectronica_" + this.llenaIdFactura(objTFactura.getSserie(),new Integer(objTFactura.getUfoliofactura()).toString(),8) + ".pdf');\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  
		    		            "		<img alt='Factura - PDF' id=\"imgPDF\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoPdf.png' />" +
								"	</a>" +
								"	<a href=\"javascript:visualizarFactura('http://192.237.150.66:9085/FacturasElectronicas_Olab/XML/FacturacionElectronica_" + this.llenaIdFactura(objTFactura.getSserie(),new Integer(objTFactura.getUfoliofactura()).toString(),8) + ".xml');\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  
		    		            "		<img alt='Factura - XML' id=\"imgXML\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoXml.png' />" +
								"	</a>" +
								"</td>" +								
								"<td align=\"center\">" + 
								"	<input type='button' id='idSoporteFactura' name='idSoporteFactura' value='Soporte' onClick='javascript:generacionPrevioFactura("+objTFactura.getKfactura()+");' class='boton'>"+
								"</td>"+
							"</tr>";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
			try {
				strReturn+=	"</table>";
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return strReturn;
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
	 
	 
	
	static String llenaIdFactura(String strNemonico,String intFactura,int MaxLength) {
		String strReturn = "";
		int intTotal = (strNemonico.length() + intFactura.length());
		for(int i = intTotal;i <= MaxLength;i++) {
			strReturn += "0";
		}		
		return strNemonico + strReturn+intFactura;
	}
	
			
	public String getSoporteFactura(String strkfactura) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strSQL = "";		
		String strReturn = "";
		boolean bTipoFacturacion=false;
		String strSpFuncion="";
		NotaDeCreditoDao objNotaDao = new NotaDeCreditoDao();
		TFactura objFactura = new TFactura();
    	try{
    		iObjLog.debug("Entrando BusquedaFacturaDao.getSoporteFactura:Entrando...  " + strkfactura);
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            objFactura = objNotaDao.getFactura(new Integer(strkfactura).intValue());
            
            if((!strkfactura.equals("0")) && (strkfactura.length()>0)) {	
					strSpFuncion="facturacion.func_olab_sp_soporte_factura("+strkfactura+");";	
			}	
				strSQL = "Select * from "+strSpFuncion;						
				iObjLog.debug("Entrando BusquedaFacturaDao.getSoporteFactura:Consulta...  " + strSQL);
				objRst = objStmt.executeQuery(strSQL);
				int inti = 1;
				if(objRst != null) {
					while(objRst.next()) {
							strReturn +="<tr>" +
										"<td align=\"center\">" + inti 															+ "</td>" +
										"<td align=\"center\">" + objRst.getString("consecutivo") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("noconvenio") 						+ "</td>" +
										"<td align=\"center\">" + objRst.getString("nombrepaciente") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("codigoestudio")	 								+ "</td>" +
										"<td align=\"center\">" + objRst.getString("nombreestudio") 									+ "</td>" +
										"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("totalfactura"))		+ "</td>" +
										"<td align=\"center\">" + objFormatos.getFechaCompleta(objRst.getDate("fechaorden")) 	+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sclasificacioncomercial") 					+ "</td>" +
										"<td align=\"center\">" + objRst.getString("ufoliofactura") 							+ "</td>" +
										"</tr>";	 
							inti++;
					}		
					objRst.close();
			}
			strReturn+= "<tr>"+
						"<td align=\"center\">" + 
						"	<font color='black'>Archivos" +
						"	</font>" +
						"</td >"+
						"<td align='center' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'> " + 
						"<a href=\"http://192.237.150.66:9085/FacturasElectronicas_Olab/PDF/FacturacionElectronica_" + this.llenaIdFactura(objFactura.getSserie(),new Integer(objFactura.getUfoliofactura()).toString(),8) + ".pdf\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  
			            "		<img alt='Factura - PDF' id=\"imgPDF\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoPdf.png' />" +
						"	</a>" +
						"	<a href=\"http://192.237.150.66:9085/FacturasElectronicas_Olab/XML/FacturacionElectronica_" + this.llenaIdFactura(objFactura.getSserie(),new Integer(objFactura.getUfoliofactura()).toString(),8) + ".xml\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  
			            "		<img alt='Factura - XML' id=\"imgXML\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoXml.png' />" +
						"	</a>" +
						"</td>" +								
						"</tr>";
			iObjLog.debug("Saliendo BusquedaFacturaDao.getSoporteFactura:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getSoporteFactura: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return strReturn;
   	}
	
}
