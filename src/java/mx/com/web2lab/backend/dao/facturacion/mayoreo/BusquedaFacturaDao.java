package mx.com.web2lab.backend.dao.facturacion.mayoreo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenBean;
import mx.com.web2lab.backend.beans.ap.OrdenExamenBean;
import mx.com.web2lab.backend.beans.ap.PagoPacienteBean;
import mx.com.web2lab.backend.beans.facturacion.NotaCreditoBean;
import mx.com.web2lab.backend.beans.facturacion.NotaCreditoFacturaBean;
import mx.com.web2lab.backend.beans.facturacion.TFacturaBean;
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
	
	public int getMarca(int cconvenio) throws Exception{
		iObjLog.debug("Entrando BusquedaFActuraDao.getMarca:" + cconvenio);
		int marca = 0;
		iObjSesion = HibernateUtil.getSession();
		String strQuery = "";
		
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		
		try{
			HibernateUtil.beginTrans();
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
			strQuery = "select cmarca from e_convenio where cconvenio = "+cconvenio;
			
			objRst = objStmt.executeQuery(strQuery);
			while (objRst.next()) {
				marca=objRst.getInt("cmarca");
			}
               		
	        iObjLog.debug("Saliendo BusquedaFacturaDao.getMarca...  " + marca);
			return marca;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR BusquedaFacturaDao.getMarca...: ", aObjExcepcion);
			throw aObjExcepcion;
	    } finally{
				HibernateUtil.closeSession();	
				objRst = null;
	    		objStmt = null;
		}	
		
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
							  " where Tf.ufoliofactura in("+strfoliosFacturas+") and Tf.csucursal>36 and Tf.csucursal not in(100,1016)";    					
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
	
	public String getBusquedaComplemento(String strfoliosFacturas) throws Exception {
		iObjLog.debug("Entrando BusquedaFActuraDao.getBusquedaComplemento:" + strfoliosFacturas);
		iObjSesion = HibernateUtil.getSession();
		String strQuery = "";
		TFacturaBean tFacturaBean = new TFacturaBean();
		String strReturn="";
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		
		try{
			if (strfoliosFacturas.length()>0) {
				HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
				strQuery = "select ufoliofactura, centidadlegal, dregistro, cestadoregistro from t_factura  where ufoliofactura in ("+strfoliosFacturas+") and csucursal = 1016";
				
				objRst = objStmt.executeQuery(strQuery);
				while (objRst.next()) {
					tFacturaBean.setUfoliofactura(new Integer(objRst.getInt("ufoliofactura")));
					tFacturaBean.setCentidadlegal(new Integer(objRst.getInt("centidadlegal")));
					tFacturaBean.setDregistro(objRst.getDate("dregistro"));
					tFacturaBean.setCestadoregistro(new Integer(objRst.getInt("cestadoregistro")));
				}
	               		
				strReturn=this.pintarComplementos(tFacturaBean);
			}
			iObjLog.debug("Saliendo BusquedaFacturaDao.getBusquedaComplemento...  " + strfoliosFacturas);
	        return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR BusquedaFacturaDao.getBusquedaComplemento...: ", aObjExcepcion);
			throw aObjExcepcion;
	    } finally{
				HibernateUtil.closeSession();
				objRst = null;
	    		objStmt = null;
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
	
	/*
	 * tipoFactura: 
	 * 1 - facturas
	 * 2 - Nota de credito
	 * 3 - Complemento de pago
	 */	
	public String getBusquedaFacturasSustitucion(String folio, int idMarca, int tipoFactura) throws Exception{
		
		String strReturn = "";
		iObjLog.debug("Entrando BusquedaFacturaDao.getBusquedaFacturasSustitucion:" + folio);
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		int csucursal = 0;
		String strQuery = "";
		switch (idMarca) {
		case 1:
			csucursal = 1003;
			break;
		case 4:
			csucursal = 1012;
			break;
		case 5:
			csucursal = 1013;
			break;
		case 7:
			csucursal = 1014;
			break;
		case 8:
			csucursal = 1015;
			break;
		case 9:
			csucursal = 1007;
			break;
			
		default:
			break;
		}	
		
		if(tipoFactura == 1){			
			
			strQuery =  "select tf.kfactura, tf.sserie, tf.ufoliofactura,tfc.factura_id, tf.dregistro, tf.dcancelacionfactura from t_factura tf "+
					"inner join t_factura_cancelada tfc on tfc.kfactura = tf.kfactura "+
					"where tf.csucursal in ("+csucursal+") and tf.cconvenio in (select cconvenio from t_factura where ufoliofactura = "+folio+" and csucursal = "+csucursal+") "+ 
					"and (dregistro between (sysdate-365) and (sysdate)) and tf.ctipocomprobantecfdi <> -1 order by tf.dregistro desc";
			
		}else if(tipoFactura == 2){
			strQuery = "select tnc.knotacredito as kfactura, tnc.sserie, tnc.ufoliofactura,tfc.factura_id, tnc.dregistro, tnc.dcancelacionfactura from t_nota_credito tnc "+
					"inner join t_factura_cancelada tfc on tfc.kfactura = tnc.knotacredito "+ 
					"where tnc.csucursal in (1004) and tnc.cconvenio in (select cconvenio from t_nota_credito where ufoliofactura = "+folio+" and csucursal = 1004) "+ 
					"and (dregistro between (sysdate-365) and (sysdate)) and tnc.ctipocomprobantecfdi <> -1 order by tnc.dregistro desc";
		}else if(tipoFactura == 3){
			strQuery =  "select tf.kfactura, tf.sserie, tf.ufoliofactura,tfc.factura_id, tf.dregistro, tf.dcancelacionfactura from t_factura tf "+
						"inner join t_factura_cancelada tfc on tfc.kfactura = tf.kfactura "+ 
						"where tf.kfactura in ( "+
						"select kfactura from t_pago_complemento where kpagocomplemento in (select kpagocomplemento from t_pago_factura where kfactura in ( "+
						"select kfactura from t_factura where ufoliofactura = "+folio+" and csucursal = "+csucursal+") and cestadoregistro = 53) "+
						"and kpagocomplementopadre is NULL and kfactura is not null and ncomplementogenerado = 1 "+
						"UNION ALL "+
						"select kfactura from t_pago_complemento where kpagocomplemento in ( "+
						"select kpagocomplementopadre from t_pago_complemento where kpagocomplemento in (select kpagocomplemento from t_pago_factura where kfactura in ( "+
						"select kfactura from t_factura where ufoliofactura = "+folio+" and csucursal = "+csucursal+") and cestadoregistro = 53) "+
						"and kpagocomplementopadre is not NULL and ncomplementogenerado = 0 ) and ncomplementogenerado = 1 and kfactura is not null "+
						") and tf.ctipocomprobantecfdi <> -1";
		}else if (tipoFactura == 4){
			strQuery =  "select tf.kfactura, tf.sserie, tf.ufoliofactura,tfc.factura_id, tf.dregistro, tf.dcancelacionfactura from t_factura tf "+
					"inner join t_factura_cancelada tfc on tfc.kfactura = tf.kfactura "+ 
					"where tf.kfactura in ( "+
					"select kfactura from t_pago_complemento where kpagocomplemento in (select kpagocomplemento from t_pago_factura where kfactura in ( "+
					folio+") and cestadoregistro = 53) "+
					"and kpagocomplementopadre is NULL and kfactura is not null and ncomplementogenerado = 1 "+
					"UNION ALL "+
					"select kfactura from t_pago_complemento where kpagocomplemento in ( "+
					"select kpagocomplementopadre from t_pago_complemento where kpagocomplemento in (select kpagocomplemento from t_pago_factura where kfactura in ( "+
					folio+") and cestadoregistro = 53) "+
					"and kpagocomplementopadre is not NULL and ncomplementogenerado = 0 ) and ncomplementogenerado = 1 and kfactura is not null "+
					") and tf.ctipocomprobantecfdi <> -1";
		}
		
		iObjLog.debug("Entrando BusquedaFacturaDao.getBusquedaFacturasSustitucion: " + strQuery);
		
		try {
			HibernateUtil.beginTrans();
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            if (strQuery != "") {
            	objRst = objStmt.executeQuery(strQuery);
            	strReturn="<table border='0' align='center' style='width: 883px' class='tabla'>" + 
        				  "<tr>" + 
	        					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
	        					"	<b><font color='black'>Folio Factura" + 
	        					"	</font></b>" +
	        					"</th>" + 
	        					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
	        					"	<b><font color='black'>Folio Fiscal (UUID)" + 
	        					"</th>" + 
	        					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
	        					"	<b><font color='black'>Fecha de Cancelacion" + 
	        					"</th>" +
        					" </tr>" ;
            	
            	
            	while (objRst.next()) {
            		strReturn+=	"<tr>"+
            				"<td align=\"center\">" + 
	            				"<a onclick=\"javascript:agregarDatosSustitucion("+objRst.getString("ufoliofactura")+","+objRst.getString("kfactura")+",'"+objRst.getString("factura_id")+"');\" style=\"FONT-SIZE: x-small; FONT-VARIANT: normal; FONT-WEIGHT: normal; COLOR: black; FONT-STYLE: normal\" href=\"javascript:doNothing()\" align=\"bottom\">"+
	            				this.llenaIdFactura(objRst.getString("sserie"),objRst.getString("ufoliofactura"),8)+
	            				"</a>" +
            				"</td>"+
            				"<td align=\"center\">" + 
            				"	<font color='black'>" + objRst.getString("factura_id")+
            				"	</font>" +
            				"</td >"+
            				"<td align=\"center\">" + 
            				"	<font color='black'>" + objRst.getString("dcancelacionfactura")+
            				"	</font>" +
            				"</td >"+
            			"</tr>";
            	}
            	strReturn+=	"</table>";
            }
			
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR BusquedaFacturaDao.getBusquedaFacturaAjuste: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}
		
		return strReturn;
	}
	
	
	
	//MODIFICACION BY 02/09/2013
	public String getBusquedaFacturaAjuste(String strfoliosFacturas, Integer idMarca) throws Exception {
		 iObjLog.debug("Entrando BusquedaFacturaDao.getBusquedaFacturaAjuste:" + strfoliosFacturas);
			iObjSesion = HibernateUtil.getSession();
			String strQuery = "";
			String strReturn = "";
			String strcta = "";
			String strTipoCuenta = "";
			String strIva = "";
			String strMetodoPago ="";
			String strRazonSocial="";
			int csucursal = 0;
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
	    	try{
	            HibernateUtil.beginTrans();
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
	            if (strfoliosFacturas.length() > 0) {
	            	if (idMarca.equals(new Integer(1))) {
	            		csucursal = 1003;
	            	} else if (idMarca.equals(new Integer(4))) {
	            		csucursal = 1012;
	            	} else if (idMarca.equals(new Integer(5))) {
	            		csucursal = 1013;
	            	} else if (idMarca.equals(new Integer(7))) {
	            		csucursal = 1014;
	            	} else if (idMarca.equals(new Integer(8))) {
	            		csucursal = 1015;
	            	} else if (idMarca.equals(new Integer(15))){
	            		csucursal = 1017;
	            	}
	            	
	            	
	        		strQuery =  "select tf.msubtotal,tf.miva,tf.mtotal,ccdf.cconvenio,ccdf.sdigitoscuenta,ccdf.stipopago,cc.cmarca " +					
								" from t_factura tf,c_convenio_dato_fiscal ccdf,t_dato_fiscal tdf,c_cliente cc " +	
								" where tf.cconvenio=ccdf.cconvenio " +
								" and tdf.kdatofiscal=ccdf.kdatofiscal " +
								" and cc.ccliente=tf.ccliente " +
								" and tf.ufoliofactura=" +  strfoliosFacturas +" and tf.csucursal=" + csucursal + " and tf.cestadoregistro=33 and scadenaoriginal=' ' ";
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
//									"<input type='hidden' id='cMarca' value='"+ objRst.getInt("cmarca") +"' >" +
									"<input type='hidden' id='cMarca' value='"+ idMarca +"' >" +
									"<input type='hidden' id='hdenkfacturaSustitucion' value=''>" +
									"<input type='hidden' id='hdenUuidSustitucion' value=''>" +
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
														"			<input type=\"checkbox\" id=\"chkSustitucion\" onClick=\"showFormSustitucion();\" >Sustitución" +
//														" 		    &nbsp;			" +
														"		</td>				" +
														"		<td>				" +
														" 		    <div id='divchkDescuento' style=\"display:none\" ><input type=\"checkbox\" id=\"chkDescuento\" onClick=\"showFormDescuento();\"  >Descuento </div>" +
														" 		    <div id='divchkRetencion' ><input type=\"checkbox\" id=\"chkRetencion\" >Retencion de IVA</div>" +
														"		</td>				" +
														"  </tr>					" +
														"  <tr> 					" +
											 			"		<td>				" +
											 			"			&nbsp;			" + 
											 			"		</td>				" + 
											 			"		<td>				" +
														"			&nbsp;			" +  
														"		</td>				" +
														"		<td>				" +
														"		<label id=\"labelFolioInterno\" style=\"display:none\">" +
														"			Folio de la factura a sustituir:	" +
														"		</label>			" +
														"		</td>				" +
														"		<td>				" +
														" 		    <input type=\"text\" id=\"txtUfoliofacturaSustitucion\" size=\"15\" style=\"width:100px;display:none\" disabled>" +
														"			<a id='popupBuscar' style=\"display:none\" href='javascript:doNothing()' onclick=\"javascript:showSubModalSustitucion();\">"+
														"				<img alt='Buscar Sustitucion' id='imgBuscar' border='0' src=\"/web2labportal/images/icoBuscar.png\" width=\"25\" height=\"23\" />"+
														"			</a>"+
														"		</td>				" +
														"  </tr>					" +
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
											 			"  <tr> 					" +
											 			"		<td>				" +
											 			"			&nbsp;			" + 
											 			"		</td>				" + 
											 			"		<td>				" +
														"			&nbsp;			" +  
														"		</td>				" +
														"		<td>				" +
														"		<label id=\"labelDescuentosFac\" style=\"display:none\">" +
														"			Descuentos:	" +
														"		</label>			" +
														"		</td>				" +
														"		<td>				" +
														" 		    <input type=\"text\" id=\"txtDescuentosFac\" size=\"15\" style=\"width:400px;display:none\">" +
														"		</td>				" +
														"  </tr>					" +
														"  <tr> 					" +
											 			"		<td>				" +
											 			"			&nbsp;			" + 
											 			"		</td>				" + 
											 			"		<td>				" +
														"			&nbsp;			" +  
														"		</td>				" +
														"		<td>				" +
														"		<label id=\"labelNotaDescuentosFac\" style=\"display:none\">" +
														"			Nota Descuento:	" +
														"		</label>			" +
														"		</td>				" +
														"		<td>				" +
														" 		    <textarea  id=\"txtNotaDescuentosFac\" rows=\"4\" cols=\"50\" style=\"display:none\">" +
														"		</td>				" +
														"  </tr>					" +
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
	
	public String pintarComplementos(TFacturaBean bean) throws Exception{
		String strReturn="";
		String strEstadoFactura="";
		strReturn="<table border='0' align='center' style='width: 883px' class='tabla'>" + 
				  "<tr>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Complemento de Pago" + 
					"	</font></b>" +
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Fecha Complemento" + 
					"</th>" + 
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Estado del Complemento" + 
					"</th>" +
					"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
					"	<b><font color='black'>Archivos" + 
					"</th>" + 
				" </tr>" ;
		
		String pathPDF = "";
		String pathXML = "";
		if(bean.getCestadoregistro().intValue()==33){
			strEstadoFactura="EMITIDA";
		}else if(bean.getCestadoregistro().intValue()==34){
			strEstadoFactura="CANCELADA";
		}

		switch (bean.getCentidadlegal().intValue()) {
		case 1: pathPDF = "FacturasElectronicas_Olab/XMLTMP/PDF";
				pathXML = "FacturasElectronicas_Olab/XML";
			break;
		case 5: pathPDF = "FacturasElectronicas_Azteca/XMLTMP/PDF";
				pathXML = "FacturasElectronicas_Azteca/XML";
			break;
		case 6: pathPDF = "FacturasElectronicas_Swisslab/XMLTMP/PDF";
				pathXML = "FacturasElectronicas_Swisslab/XML";
			break;
		case 16: pathPDF = "FacturasElectronicas_Swisslab/XMLTMP/PDF";
		pathXML = "FacturasElectronicas_Swisslab/XML";
		break;
		case 7: 
				pathPDF = "FacturasElectronicas_Jenner/Prado/XMLTMP/PDF";
				pathXML = "FacturasElectronicas_Jenner/Prado/XML";
			break;
		case 8: 			
				pathPDF = "FacturasElectronicas_Jenner/Lean/XMLTMP/PDF";
				pathXML = "FacturasElectronicas_Jenner/Lean/XML";			
		break;
		default:
			break;
		}
		strReturn+=	"<tr>"+
				"<td align=\"center\">" + 
				"	<font color='black'>" + this.llenaIdFactura("ACC",new Integer(bean.getUfoliofactura().intValue()).toString(),8)+
				"	</font>" +
				"</td>"+
				"<td align=\"center\">" + 
				"	<font color='black'>" + objFormatos.getFechaCompleta(bean.getDregistro())+
				"	</font>" +
				"</td >"+
				"<td align=\"center\">" + 
				"	<font color='black'>" + strEstadoFactura+
				"	</font>" + 
				"</td >"+
				"<td align='center' style='font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'> " + 

				"	<a href=\"javascript:visualizarFactura('http://10.3.0.8:9085/"+pathPDF+"/FacturacionElectronica_" + this.llenaIdFactura("ACC",new Integer(bean.getUfoliofactura().intValue()).toString(),8) + ".pdf');\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  

	            "		<img alt='Factura - PDF' id=\"imgPDF\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoPdf.png' />" +
				"	</a>" +

				"	<a href=\"javascript:visualizarFactura('http://10.3.0.8:9085/"+pathXML+"/FacturacionElectronica_" + this.llenaIdFactura("ACC",new Integer(bean.getUfoliofactura().intValue()).toString(),8) + ".xml');\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  

	            "		<img alt='Factura - XML' id=\"imgXML\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoXml.png' />" +
				"	</a>" +
				"</td>" +
			"</tr>";
		
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
	
	
	/**
     * Versión 25 de Marzo 2013 
     BY Tomar en cuenta el registro
	 * @throws Exception 
     */
	public String pintarFacturas(List objListaFacturas) throws Exception{
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
			String [] arrPrado = {"117","118","126","127","128","129","130","132","134","138","139","140","141","142","143","196","198","199","200","1014"};
			List listPrado = Arrays.asList(arrPrado);
			String [] arrLean = {"115","116","119","120","121","122","123","124","125","131","133","135","136","137","177","146","197","1015"};
			List listLean = Arrays.asList(arrLean);
			String pathPDF = "";
			String pathXML = "";
			

			switch (getMarca(objTFactura.getCconvenio())) {
			case 1: pathPDF = "FacturasElectronicas_Olab/XMLTMP/PDF";
						pathXML = "FacturasElectronicas_Olab/XML";
				break;
			case 4: pathPDF = "FacturasElectronicas_Azteca/XMLTMP/PDF";
						pathXML = "FacturasElectronicas_Azteca/XML";
				break;
			case 5: pathPDF = "FacturasElectronicas_Swisslab/XMLTMP/PDF";
						pathXML = "FacturasElectronicas_Swisslab/XML";
				break;
			case 15: pathPDF = "FacturasElectronicas_Swisslab/XMLTMP/PDF";
			pathXML = "FacturasElectronicas_Swisslab/XML";
			break;
			case 7: 
					if(listPrado.contains(String.valueOf(objTFactura.getCsucursal()))){
						pathPDF = "FacturasElectronicas_Jenner/Prado/XMLTMP/PDF";
						pathXML = "FacturasElectronicas_Jenner/Prado/XML";
					}else if(listLean.contains(String.valueOf(objTFactura.getCsucursal()))){
						pathPDF = "FacturasElectronicas_Jenner/Lean/XMLTMP/PDF";
						pathXML = "FacturasElectronicas_Jenner/Lean/XML";
					}
				break;
			default:
				break;
			}
			
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

								"	<a href=\"javascript:visualizarFactura('http://10.3.0.8:9085/"+pathPDF+"/FacturacionElectronica_" + this.llenaIdFactura(objTFactura.getSserie(),new Integer(objTFactura.getUfoliofactura()).toString(),8) + ".pdf');\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  

		    		            "		<img alt='Factura - PDF' id=\"imgPDF\" width=\"19\" height=\"19\" border='0' src='/web2labportal/images/icoPdf.png' />" +
								"	</a>" +

								"	<a href=\"javascript:visualizarFactura('http://10.3.0.8:9085/"+pathXML+"/FacturacionElectronica_" + this.llenaIdFactura(objTFactura.getSserie(),new Integer(objTFactura.getUfoliofactura()).toString(),8) + ".xml');\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  

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
						"<a href=\"http://192.237.150.66:9085/FacturasElectronicas_Olab/XMLTMP/PDF/FacturacionElectronica_" + this.llenaIdFactura(objFactura.getSserie(),new Integer(objFactura.getUfoliofactura()).toString(),8) + ".pdf\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'>"  +  
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
