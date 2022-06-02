package mx.com.web2lab.backend.dao.facturacion.mayoreo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.com.web2lab.backend.beans.facturacion.Definitivo;
import mx.com.web2lab.backend.beans.facturacion.FacturacionBean;
import mx.com.web2lab.backend.beans.facturacion.TdatoAdicionalBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.ap.CDatoAdicional;
import mx.com.web2lab.backend.hbm.om.ap.TDatoAdicional;
import mx.com.web2lab.backend.util.Formatos;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

public class FacturacionPrevioDao {

	private static Log iObjLog = LogFactory.getLog(FacturacionPrevioDao.class);
	
	private Session iObjSesion = null;
	
	private Formatos objFormatos = new Formatos();

	public FacturacionPrevioDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	    
	public String getSerieB(String fecha1,String fecha2) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strSQL = "";		
		String strReturn = "";
		boolean bTipoFacturacion=false;
		String strSpFuncion="";
		
    	try{
    		iObjLog.debug("Entrando FacturacionMayoreoDao.getSerieB:Entrando...  " + fecha1 +" "+fecha2);
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            
            
            //"select * from t_factura where csucursal = 1007 and dregistro between to_date('"+fecha1+" 00:00:00','dd-mm-yyyy hh24:mi:ss') and to_date('"+fecha2+" 23:59:59', 'dd-mm-yyyy hh24:mi:ss');"; 

				strSQL = "select * from t_factura where csucursal = 1007 and dregistro between to_date('"+fecha1+" 00:00:00','dd-mm-yyyy hh24:mi:ss') and to_date('"+fecha2+" 23:59:59', 'dd-mm-yyyy hh24:mi:ss');";						
				iObjLog.debug("Entrando FacturacionMayoreoDao.getSerieB:Consulta...  " + strSQL);
				objRst = objStmt.executeQuery(strSQL);
				int inti = 1;
				if(objRst != null) {
					while(objRst.next()) {
						
						 strReturn +="<tr>" +
									"<td align=\"center\">" + inti 															+ "</td>" +
									"<td align=\"center\">" + objRst.getInt("ufoliofactura") 							    + "</td>" +
									"<td align=\"center\">" + objRst.getInt("kfactura") 									+ "</td>" +
									"<td align=\"center\">" + objRst.getString("ssucursal") 							    + "</td>" +
									"<td align=\"center\">" + objRst.getDouble("msubtotal")	 								+ "</td>" +
									"<td align=\"center\">" + objRst.getDouble("miva")	 							     	+ "</td>" +
									"<td align=\"center\">" + objRst.getDouble("mtotal") 									+ "</td>" +
									"<td align=\"center\">" + objRst.getDate("dregistro") 									+ "</td>" +									
									"</tr>";
				inti++;
					}				
					objRst.close();
				}
			 
			iObjLog.debug("Saliendo FacturacionMayoreoDao.getSerieB:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getSerieB: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return strReturn;
   	}
	
	
	public String getConvenioActivosInactivos() throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strSQL = "";		
		String strReturn = "";
		boolean bTipoFacturacion=false;
		String strSpFuncion="";
		
    	try{
    		iObjLog.debug("Entrando FacturacionMayoreoDao.getConvenioActivosInactivos:Entrando...  ");
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            
            
            //"select * from t_factura where csucursal = 1007 and dregistro between to_date('"+fecha1+" 00:00:00','dd-mm-yyyy hh24:mi:ss') and to_date('"+fecha2+" 23:59:59', 'dd-mm-yyyy hh24:mi:ss');"; 

				strSQL = "select tb1.cconvenio, tb2.sconvenio, tb1.clistacorporativa,decode (tb1.cestadoregistro, 22, 'Activo',23,'Inactivo'),tb3.ccliente, tb3.srazonsocial, tb3.srfc, tb3.sdireccion "+
						"from e_convenio as tb1 inner join c_convenio as tb2 on tb1.cconvenio=tb2.cconvenio inner join c_cliente as tb3 on tb2.ccliente=tb3.ccliente;";						
				iObjLog.debug("Entrando FacturacionMayoreoDao.getConvenioActivosInactivos:Consulta...  " + strSQL);
				objRst = objStmt.executeQuery(strSQL);
				int inti = 1;
				if(objRst != null) {
					while(objRst.next()) {
						
						 strReturn +="<tr>" +
									"<td align=\"center\">" + inti 															+ "</td>" +
									"<td align=\"center\">" + objRst.getInt("cconvenio") 							    + "</td>" +
									"<td align=\"center\">" + objRst.getString("sconvenio") 									+ "</td>" +
									"<td align=\"center\">" + objRst.getInt("clistacorporativa") 							    + "</td>" +
									"<td align=\"center\">" + objRst.getString("decode")	 								+ "</td>" +
									"<td align=\"center\">" + objRst.getInt("ccliente")	 							     	+ "</td>" +
									"<td align=\"center\">" + objRst.getString("srazonsocial") 									+ "</td>" +
									"<td align=\"center\">" + objRst.getString("srfc") 									+ "</td>" +		
									"<td align=\"center\">" + objRst.getString("sdireccion") 									+ "</td>" +
									"</tr>";
				inti++;
					}				
					objRst.close();
				}
			 
			iObjLog.debug("Saliendo FacturacionMayoreoDao.getConvenioActivosInactivos:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getConvenioActivosInactivos: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return strReturn;
   	}
	
	
	public String getReporteDetalleExamen(String convenio) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strSQL = "";		
		String strReturn = "";
		boolean bTipoFacturacion=false;
		String strSpFuncion="";
		
    	try{
    		iObjLog.debug("Entrando FacturacionMayoreoDao.getReporteDetalleExamen:Entrando...  ");
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            
            
            //"select * from t_factura where csucursal = 1007 and dregistro between to_date('"+fecha1+" 00:00:00','dd-mm-yyyy hh24:mi:ss') and to_date('"+fecha2+" 23:59:59', 'dd-mm-yyyy hh24:mi:ss');"; 

				strSQL = "select tb1.cconvenio, tb1.cexamen, tb3.sexamen, tb1.pdescuento, tb1.mpreciofacturarsiniva, tb1.mpreciofacturarconiva, tb2.sdescripcionlista "+
						"from e_convenio_detalle as tb1 inner join c_lista_corporativa as tb2 on tb1.clistacorporativa=tb2.clistacorporativa inner join "
						+ "c_examen as tb3 on tb1.cexamen=tb3.cexamen where tb1.cconvenio="+convenio+";";						
				iObjLog.debug("Entrando FacturacionMayoreoDao.getReporteDetalleExamen:Consulta...  " + strSQL);
				objRst = objStmt.executeQuery(strSQL);
				int inti = 1;
				if(objRst != null) {
					while(objRst.next()) {
						
						 strReturn +="<tr>" +
									"<td align=\"center\">" + inti 															+ "</td>" +
									"<td align=\"center\">" + objRst.getInt("cconvenio") 							        + "</td>" +
									"<td align=\"center\">" + objRst.getInt("cexamen") 									    + "</td>" +
									"<td align=\"center\">" + objRst.getString("sexamen") 							        + "</td>" +
									"<td align=\"center\">" + objRst.getDouble("pdescuento")	 							+ "</td>" +
									"<td align=\"center\">" + objRst.getDouble("mpreciofacturarsiniva")	 			    	+ "</td>" +
									"<td align=\"center\">" + objRst.getDouble("mpreciofacturarconiva") 					+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdescripcionlista") 						+ "</td>" +		
									"</tr>";
				inti++;
					}				
					objRst.close();
				}
			 
			iObjLog.debug("Saliendo FacturacionMayoreoDao.getReporteDetalleExamen:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getReporteDetalleExamen: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return strReturn;
   	}
	
	public void eliminarListaPreciosActualSistema(int cconvenio, String tabla) throws Exception{

		Connection objConn 	   = null;
		Statement objStatement = null;
		String strSQL = "";		
    	try{
			iObjLog.debug("Entrando FacturacionPrevioDao.eliminarListaPreciosActualSistema:Entrando...  cConvenio: " +cconvenio +"   tabla: "+tabla);
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();	
			strSQL = "DELETE FROM "+tabla+" where cconvenio = " + cconvenio;
			iObjLog.debug("Entrando PacientesMayoreoDao.guardarPacienteMetro:Consulta...  " + strSQL);
			objStatement.execute(strSQL);			
			strSQL = "";
			iObjLog.debug("Resultado FacturacionPrevioDao.eliminarListaPreciosActualSistema:Consulta...  cConvenio: " +cconvenio +"   tabla: "+tabla);		
    	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionPrevioDao.eliminarListaPreciosActualSistema: ", aObjExcepcion);
			throw aObjExcepcion;
		} finally{
			if (objStatement != null) {
				objStatement.close();
				objStatement = null;
				
			}
			objConn.close();
		}		
	
	}
	
	public String obtenerRfc(String convenio) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strSQL = "";		
		String strReturn = "";
		try{
    		iObjLog.debug("Entrando FacturacionPrevioDao.obtenerRfc:Entrando...  ");
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            
				strSQL = "SELECT kdatofiscal,srazonsocial,sdireccion FROM t_dato_fiscal WHERE srfc='"+convenio+"';";						
				iObjLog.debug("Entrando FacturacionPrevioDao.obtenerRfc:Consulta...  " + strSQL);
				objRst = objStmt.executeQuery(strSQL);
				int inti = 1;
				if(objRst != null) {
					while(objRst.next()) {						
						 strReturn+=objRst.getInt("kdatofiscal")+"@ razon social: "+objRst.getString("srazonsocial")
							+" direccion: "+objRst.getString("sdireccion")+"|";
						 inti++;
					}				
					objRst.close();
				}
				
				if(!strReturn.equals("")){
					strReturn=strReturn.substring(0,strReturn.length()-1);
				}else{
					strReturn="-1";
				}
				
				
			iObjLog.debug("Saliendo FacturacionPrevioDao.obtenerRfc:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionPrevioDao.obtenerRfc: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}	
		return strReturn;
	}
	
	
	public String getReporteDetallePerfilPaquetes(String convenio) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strSQL = "";		
		String strReturn = "";
		boolean bTipoFacturacion=false;
		String strSpFuncion="";
		
    	try{
    		iObjLog.debug("Entrando FacturacionMayoreoDao.getReporteDetalleExamen:Entrando...  ");
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            
            
            //"select * from t_factura where csucursal = 1007 and dregistro between to_date('"+fecha1+" 00:00:00','dd-mm-yyyy hh24:mi:ss') and to_date('"+fecha2+" 23:59:59', 'dd-mm-yyyy hh24:mi:ss');"; 

				strSQL = "select tb1.cconvenio, tb1.cperfil, tb2.sperfil, tb1.mpreciofacturarsiniva, tb1.mpreciofacturarconiva "
						+ "from e_convenio_perfil as tb1 inner join c_perfil as tb2 on tb1.cperfil= tb2.cperfil where cconvenio="+convenio+";";						
				iObjLog.debug("Entrando FacturacionMayoreoDao.getReporteDetalleExamen:Consulta...  " + strSQL);
				objRst = objStmt.executeQuery(strSQL);
				int inti = 1;
				if(objRst != null) {
					while(objRst.next()) {
						
						 strReturn +="<tr>" +
									"<td align=\"center\">" + inti 															+ "</td>" +
									"<td align=\"center\">" + objRst.getInt("cconvenio") 							        + "</td>" +
									"<td align=\"center\">" + objRst.getInt("cperfil") 									    + "</td>" +
									"<td align=\"center\">" + objRst.getString("sperfil") 							        + "</td>" +
									"<td align=\"center\">" + objRst.getDouble("mpreciofacturarsiniva")	 					+ "</td>" +
									"<td align=\"center\">" + objRst.getDouble("mpreciofacturarconiva")	 			    	+ "</td>" +									
									"</tr>";
				inti++;
					}				
					objRst.close();
				}
			 
			iObjLog.debug("Saliendo FacturacionMayoreoDao.getReporteDetalleExamen:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getReporteDetalleExamen: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return strReturn;
   	}
	
	
	
	public FacturacionBean getFacturaById(int kfactura) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strSQL = "";		
		String strReturn = "";
		boolean bTipoFacturacion=false;
		String strSpFuncion="";
		FacturacionBean dto = new FacturacionBean();
    	try{
    		iObjLog.debug("Entrando FacturacionMayoreoDao.getFacturaById:Entrando...  ");
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            
			strSQL = "select tf.msubtotal,tf.miva,tf.mtotal,ccdf.cconvenio,ccdf.sdigitoscuenta,ccdf.stipopago,cc.cmarca, tf.centidadlegal, tf.ufoliofactura " +					
						" from t_factura tf,c_convenio_dato_fiscal ccdf,t_dato_fiscal tdf,c_cliente cc " +	
						" where tf.cconvenio=ccdf.cconvenio " +
						" and tdf.kdatofiscal=ccdf.kdatofiscal " +
						" and cc.ccliente=tf.ccliente " +
						" and tf.kfactura=" +  kfactura ;						
				iObjLog.debug("Entrando FacturacionMayoreoDao.getFacturaById:Consulta...  " + strSQL);
				objRst = objStmt.executeQuery(strSQL);
				int inti = 1;
				if(objRst != null) {
					while(objRst.next()) {
						dto.setMtotal(objRst.getDouble("mtotal"));
						dto.setMsubtotal(objRst.getDouble("msubtotal"));
						dto.setMiva(objRst.getDouble("miva"));
						dto.setCconvenio(objRst.getInt("cconvenio"));
						dto.setCmarca(objRst.getInt("cmarca"));
						dto.setCentidadlegal(objRst.getInt("centidadlegal"));
						dto.setUfoliofactura(objRst.getInt("ufoliofactura"));
				inti++;
					}				
					objRst.close();
				}
			 
			iObjLog.debug("Saliendo FacturacionMayoreoDao.getFacturaById:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getFacturaById: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return dto;
   	}
	
	
	
	
    public Definitivo getPrevioFacturacion(String cConvenio,String uUserId,String strBloque, String nTipoPrevio, String nTipoFacturacion,String monto,String razon) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		java.sql.Connection objConn = null;
		java.sql.ResultSet objRst = null;
		java.sql.Statement objStmt = null;
		String strSQL = "";		
		String strReturn = "";
		Definitivo definitivo = new Definitivo();
		int kfactura = 0;
		boolean bTipoFacturacion=false;
		String strSpFuncion="";
    	try{
    		iObjLog.debug("Entrando FacturacionMayoreoDao.generarPrevio:Entrando...  " + cConvenio +" "+strBloque+" "+nTipoPrevio+" "+nTipoFacturacion);
            HibernateUtil.beginTrans();	            
            objConn = iObjSesion.connection();
            objStmt = objConn.createStatement();
            
            if((!cConvenio.equals("0")) && (strBloque.length()>0) && (!nTipoPrevio.equals("0"))) {
				if(nTipoFacturacion.equals("1")) {
					bTipoFacturacion=true;
				} 
				if(monto.equals("0")) {
					monto="-1";
				} 
				if(nTipoPrevio.equals("1")){	
					strSpFuncion="facturacion.func_olab_sp_return_detalle_fac("+cConvenio+","+getBloque(strBloque)+uUserId+","+bTipoFacturacion+","+monto+","+razon+");";	
				} else if(nTipoPrevio.equals("2")) {
					strSpFuncion="facturacion.func_olab_sp_return_group_fac("+cConvenio+","+getBloque(strBloque)+uUserId+","+bTipoFacturacion+","+monto+","+razon+");";	
				} else if(nTipoPrevio.equals("3")) {
					strSpFuncion="facturacion.func_olab_sp_return_group_exa_fac("+cConvenio+","+getBloque(strBloque)+uUserId+","+bTipoFacturacion+","+monto+","+razon+");";
				}	
				strSQL = "Select * from "+strSpFuncion;						
				iObjLog.debug("Entrando FacturacionMayoreoDao.generarPrevio:Consulta...  " + strSQL);
				objRst = objStmt.executeQuery(strSQL);
				int inti = 1;
				if(objRst != null) {
					while(objRst.next()) {
						if(nTipoPrevio.equals("1")) {
							strReturn +="<tr>" +
										"<td align=\"center\">" + inti 															+ "</td>" +
										"<td align=\"center\">" + objRst.getString("ufoliofactura") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("kfactura") 									+ "</td>" +
										"<td align=\"center\">" + objRst.getString("kordensucursal") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("kordensucursalfac") 						+ "</td>" +
										"<td align=\"center\">" + objRst.getString("kpaciente") 								+ "</td>" +
										"<td align=\"center\">" + objRst.getString("cconvenio") 								+ "</td>" +
										"<td align=\"center\">" + objRst.getString("snobrepaciente") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("cexamen")	 								+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sexamen") 									+ "</td>" +
										"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("msubtotal"))		+ "</td>" +
										"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("miva"))	 		+ "</td>" +
										"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("mtotal")) 		+ "</td>" +
										"<td align=\"center\">" + objRst.getString("uconsecutivo") 								+ "</td>" +
										"<td align=\"center\">" + objFormatos.getFechaCompleta(objRst.getDate("dregistro")) 	+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sclasificacioncomercial") 					+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional1") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional2") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional3") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional4") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional5") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional6") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional7") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional8") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional9") 							+ "</td>" +
										"<td align=\"center\">" + objRst.getString("sdatoadicional10") 							+ "</td>" +
										"</tr>";
							kfactura = objRst.getInt("kfactura");
					   } else if(nTipoPrevio.equals("2")) {
						   strReturn +="<tr>" +
									"<td align=\"center\">" + inti 															+ "</td>" +
									"<td align=\"center\">" + objRst.getString("ufoliofactura") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("kfactura") 									+ "</td>" +
									"<td align=\"center\">" + objRst.getString("kordensucursal") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("kordensucursalfac") 						+ "</td>" +
									"<td align=\"center\">" + objRst.getString("cconvenio") 								+ "</td>" +
									"<td align=\"center\">" + objRst.getString("snobrepaciente") 							+ "</td>" +
									"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("msubtotal"))		+ "</td>" +
									"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("miva"))	 		+ "</td>" +
									"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("mtotal")) 		+ "</td>" +
									"<td align=\"center\">" + objRst.getString("uconsecutivo") 								+ "</td>" +
									"<td align=\"center\">" + objFormatos.getFechaCompleta(objRst.getDate("dregistro")) 	+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional1") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional2") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional3") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional4") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional5") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional6") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional7") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional8") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional9") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sdatoadicional10") 							+ "</td>" +
									"</tr>";
						   kfactura = objRst.getInt("kfactura");
					   } else if(nTipoPrevio.equals("3")) {
						   strReturn +="<tr>" +
									"<td align=\"center\">" + inti 															+ "</td>" +
									"<td align=\"center\">" + objRst.getString("ufoliofactura") 							+ "</td>" +
									"<td align=\"center\">" + objRst.getString("kfactura") 									+ "</td>" +
									"<td align=\"center\">" + objRst.getString("cconvenio") 								+ "</td>" +
									"<td align=\"center\">" + objRst.getString("cexamen")	 								+ "</td>" +
									"<td align=\"center\">" + objRst.getString("cantidad")	 								+ "</td>" +
									"<td align=\"center\">" + objRst.getString("sexamen") 									+ "</td>" +
									"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("msubtotal"))		+ "</td>" +
									"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("miva"))	 		+ "</td>" +
									"<td align=\"center\">" + objFormatos.formateaNumero(objRst.getString("mtotal")) 		+ "</td>" +
									"<td align=\"center\">" + objRst.getString("uconsecutivo") 								+ "</td>" +
									"</tr>";
						   kfactura = objRst.getInt("kfactura");
					   }
					 
				inti++;
					}				
					objRst.close();
				}
			} 
            definitivo.setReporte(strReturn);
            definitivo.setKfactura(kfactura);
			iObjLog.debug("Saliendo FacturacionMayoreoDao.getPrevioFacturacion:Saliendo...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionMayoreoDao.getPrevioFacturacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return definitivo;
   	}
    
   public String getBloque(String strBloque){
	   iObjLog.debug("Entrando FacturacionMayoreoDao.getBloque:...  " + strBloque);
	   String strFormatoBloques ="'";
	   String[] arrayBloques = strBloque.split(",");
	    
	   for (int i = 0; i < arrayBloques.length; i++) {
		   if(!arrayBloques[i].equals("")) {
			   strFormatoBloques +=arrayBloques[i]+",";
		   }
	    iObjLog.debug("strFormatoBloques " + strFormatoBloques);
	   }
	   strFormatoBloques=(strFormatoBloques.substring(0, strFormatoBloques.length()-1))+"',";
	   iObjLog.debug("Saliendo FacturacionMayoreoDao.getBloque:...  " + strFormatoBloques);
	return strFormatoBloques;
	   
   }
   
   
  private CDatoAdicional getCdatoAdicional(int intdatoadicional) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaDatosAdicionales = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		CDatoAdicional objCDatoAdicional = null;
  	try{
			iObjLog.debug("Entrando FacturacionPrevioDao.getTdatoAdicional:Entrando...  " + intdatoadicional);
			HibernateUtil.beginTrans();
				strQuery = "select cDA 										\n" +					
						   "from CDatoAdicional cDA 								\n" +	
						   "where cDA.cdatoadicional="+intdatoadicional+ "\n";
			
			iObjLog.debug("Entrando FacturacionPrevioDao.getTDatoAdicional:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaDatosAdicionales = objQuery.list();
			iObjLog.debug("Resultado FacturacionPrevioDao.getTdatoAdicional:Consulta...  " + objListaDatosAdicionales.size());			
			if (objListaDatosAdicionales.isEmpty() == false) {
				objCDatoAdicional = (CDatoAdicional)objListaDatosAdicionales.get(0);				
				return objCDatoAdicional;
			} else {
				return null;
			}				
  	} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionPrevioDao.getTdatoAdicional(int intdatoadicional):: ", aObjExcepcion);
			throw aObjExcepcion;
  	} finally{
  		HibernateUtil.closeSession();
  		objCDatoAdicional = null;
  	}		
	}
  
  public String persistirDatoAdicional(String strDatosAdicionales,int cconvenio) throws  Exception{
	   iObjSesion = HibernateUtil.getSession();
	   TDatoAdicional objTDatoAdicional = new TDatoAdicional();
	  
	   String strmensaje="";
	   String strDatoAdicional ="'";
	   String[] arrayDatos = strDatosAdicionales.split(";");
	   String[] arrayDato;
	   String cdatoadicional;
	   String sdatoadicional;
	   String strSQL="";
	   int kordensucursal = 0;
	   int kpaciente = 0;
	   Query objQuery = null;
	   String strQuery = "";
	   List objListaDatos = new ArrayList();
	   TdatoAdicionalBean objTDatoAdicionalBean = new TdatoAdicionalBean();
	  try {   
		  		
			   iObjLog.debug("Entrando FacturacionPrevioDao.setDatoAdicional:..." + strDatosAdicionales+"\n");  
			   for (int i = 0; i < arrayDatos.length; i++) {
				   if(!arrayDatos[i].equals("")) {
					   strDatoAdicional =arrayDatos[i];
					   arrayDato=strDatoAdicional.split(",");
					   cdatoadicional=arrayDato[0];
					   sdatoadicional=arrayDato[1];
					   if(i==0){   
							if(cdatoadicional.equals("00")){
								kordensucursal=new Integer(sdatoadicional).intValue();
								kpaciente=0;
							 }else if(cdatoadicional.equals("01")){
								kordensucursal=0;
								kpaciente=new Integer(sdatoadicional).intValue();;
							 }
						}else if(i>0){
							 iObjLog.debug("Insertando:..." + sdatoadicional+"\n");
					          if (kpaciente>0) {	
					        	  iObjLog.debug("Entrando FacturacionPrevioDao.setkpaciente:..." + strDatosAdicionales+"\n");
					        		strQuery =  "select tda " +					
												" from TDatoAdicional tda " +					
												" where tda.kpaciente = "+kpaciente;
					        		
					        		if(!(buscarOrdenuPaciente(new Integer(kordensucursal).intValue(),new Integer(kpaciente).intValue(),cconvenio))){
					        			strmensaje="Por favor valide el id del paciente ya que no existe ese id registrado";
					        			break;
					        		}
					    			iObjLog.debug("Consulta FacturacionPrevioDao.persistirDatoAdicional:..." + strQuery);
					    			
					        	}else if(kordensucursal>0){
					        		iObjLog.debug("Entrando FacturacionPrevioDao.setkordensucursal:..." + strDatosAdicionales+"\n");
					        		strQuery ="select tda " +					
											" from TDatoAdicional tda " +					
											" where tda.kordensucursal = "+kordensucursal;
					        		if(!(buscarOrdenuPaciente(new Integer(kordensucursal).intValue(),new Integer(kpaciente).intValue(),cconvenio))){
					        			strmensaje="Por favor valide el consecutivo ya que puede no existir,o el convenio es diferente";
					        			break;
					        		}
					    			iObjLog.debug("Consulta FacturacionPrevioDao.persistirDatoAdicional:..." + strQuery);
					        	}
					          	HibernateUtil.beginTrans();
					          	objQuery = iObjSesion.createQuery(strQuery);
								objListaDatos = objQuery.list();
								if(objListaDatos != null) {
									if (objListaDatos.size() > 0) {
											//UPDATE
											strmensaje="Existente";
									}else{
										objTDatoAdicionalBean.setKordensucursal(new Integer(kordensucursal));
										objTDatoAdicionalBean.setKfactura(new Integer(0));
										objTDatoAdicionalBean.setCdatoadicional(new Integer(cdatoadicional));
										objTDatoAdicionalBean.setSvalor(sdatoadicional);
										objTDatoAdicionalBean.setKpaciente(new Integer(kpaciente));
										strSQL +="INSERT INTO T_DATO_ADICIONAL VALUES (t_dato_adicional_sequence.NEXTVAL," + objTDatoAdicionalBean.getKordensucursal() + ",0," + objTDatoAdicionalBean.getCdatoadicional() + ",'" + objTDatoAdicionalBean.getSvalor() + "',"+objTDatoAdicionalBean.getKpaciente()+");";
									}				
					        	}	
						}  	 	  
				   }
			    
			   }
			   if(!strSQL.equals("")){
				   iObjLog.debug("Consulta FacturacionPrevioDao.para insertar:..." + strSQL);
				   this.ejecutarConsulta(strSQL);
			   }
	   } catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionPrevioDao.persistirDatoAdicional: ", aObjExcepcion);
			throw aObjExcepcion;
       } finally{
    	   objListaDatos.clear();
    	   objListaDatos = null;
    	   strQuery = null;
    	   HibernateUtil.closeSession();
		}		
     return strmensaje;
  	}
  
  
  public String actualizaDatoAdicional(String strDatosAdicionales,int cconvenio) throws  Exception{
	   iObjSesion = HibernateUtil.getSession();
	   TDatoAdicional objTDatoAdicional = new TDatoAdicional();
	  
	   String strmensaje="";
	   String strDatoAdicional ="'";
	   String[] arrayDatos = strDatosAdicionales.split(";");
	   String[] arrayDato;
	   String cdatoadicional;
	   String sdatoadicional;
	   String strSQL="";
	   int kordensucursal = 0;
	   int kpaciente = 0;
	   Query objQuery = null;
	   String strQuery = "";
	   List objListaDatos = new ArrayList();
	   TdatoAdicionalBean objTDatoAdicionalBean = new TdatoAdicionalBean();
	  try {   
		  		
			   iObjLog.debug("Entrando FacturacionPrevioDao.actualizaDatoAdicional:..." + strDatosAdicionales+"\n");  
			   for (int i = 0; i < arrayDatos.length; i++) {
				   if(!arrayDatos[i].equals("")) {
					   strDatoAdicional =arrayDatos[i];
					   arrayDato=strDatoAdicional.split(",");
					   cdatoadicional=arrayDato[0];
					   sdatoadicional=arrayDato[1];
					   if(i==0){   
							if(cdatoadicional.equals("00")){
								kordensucursal=new Integer(sdatoadicional).intValue();
								kpaciente=0;
							 }else if(cdatoadicional.equals("01")){
								kordensucursal=0;
								kpaciente=new Integer(sdatoadicional).intValue();;
							 }
						}else if(i>0){
							 iObjLog.debug("Actualizando:..." + sdatoadicional+"\n");
					          if (kpaciente>0) {	
					        	  iObjLog.debug("Entrando FacturacionPrevioDao.setkpaciente:..." + strDatosAdicionales+"\n");
					        		strQuery =  "select tda " +					
												" from TDatoAdicional tda " +					
												" where tda.kpaciente = "+kpaciente;
					        		
					        		if(!(buscarOrdenuPaciente(new Integer(kordensucursal).intValue(),new Integer(kpaciente).intValue(),cconvenio))){
					        			strmensaje="Por favor valide el id del paciente ya que no existe ese id registrado";
					        			break;
					        		}
					    			iObjLog.debug("Consulta FacturacionPrevioDao.actualizaDatoAdicional:..." + strQuery);
					    			
					        	}else if(kordensucursal>0){
					        		iObjLog.debug("Entrando FacturacionPrevioDao.setkordensucursal:..." + strDatosAdicionales+"\n");
					        		strQuery ="select tda " +					
											" from TDatoAdicional tda " +					
											" where tda.kordensucursal = "+kordensucursal;
					        		if(!(buscarOrdenuPaciente(new Integer(kordensucursal).intValue(),new Integer(kpaciente).intValue(),cconvenio))){
					        			strmensaje="Por favor valide el consecutivo ya que puede no existir,o el convenio es diferente";
					        			break;
					        		}
					    			iObjLog.debug("Consulta FacturacionPrevioDao.persistirDatoAdicional:..." + strQuery);
					        	}
					          	HibernateUtil.beginTrans();
					          	objQuery = iObjSesion.createQuery(strQuery);
								objListaDatos = objQuery.list();
								if(objListaDatos != null) {
									if (objListaDatos.size() > 0) {
										if(kordensucursal>0){
											objTDatoAdicionalBean.setKordensucursal(new Integer(kordensucursal));
											objTDatoAdicionalBean.setKfactura(new Integer(0));
											objTDatoAdicionalBean.setCdatoadicional(new Integer(cdatoadicional));
											objTDatoAdicionalBean.setSvalor(sdatoadicional);
											objTDatoAdicionalBean.setKpaciente(new Integer(kpaciente));
											strSQL +="UPDATE T_DATO_ADICIONAL SET SVALOR='"+objTDatoAdicionalBean.getSvalor()+"' WHERE CDATOADICIONAL="+objTDatoAdicionalBean.getCdatoadicional()+" AND KORDENSUCURSAL="+ objTDatoAdicionalBean.getKordensucursal()+" AND KFACTURA=0;";
										}else{
											objTDatoAdicionalBean.setKordensucursal(new Integer(kordensucursal));
											objTDatoAdicionalBean.setKfactura(new Integer(0));
											objTDatoAdicionalBean.setCdatoadicional(new Integer(cdatoadicional));
											objTDatoAdicionalBean.setSvalor(sdatoadicional);
											objTDatoAdicionalBean.setKpaciente(new Integer(kpaciente));
											strSQL +="UPDATE T_DATO_ADICIONAL SET SVALOR='"+objTDatoAdicionalBean.getSvalor()+"' WHERE CDATOADICIONAL="+objTDatoAdicionalBean.getCdatoadicional()+" AND KPACIENTE="+ objTDatoAdicionalBean.getKpaciente()+" AND KFACTURA=0;";
										}
									}else{
										strmensaje="No existen datos para actualizar";
									}				
					        	}	
						}  	 	  
				   }
			    
			   }
			   if(!strSQL.equals("")){
				   iObjLog.debug("Consulta FacturacionPrevioDao.para actualizar:..." + strSQL);
				   this.ejecutarConsulta(strSQL);
			   }
	   } catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR FacturacionPrevioDao.actualizaDatoAdicional: ", aObjExcepcion);
			throw aObjExcepcion;
      } finally{
   	   objListaDatos.clear();
   	   objListaDatos = null;
   	   strQuery = null;
   	   HibernateUtil.closeSession();
		}		
    return strmensaje;
 	}
  
  public void ejecutarConsulta(String strSQL) throws Exception {
		Connection objConn 	   = null;
		Statement objStatement = null;	
		iObjSesion = HibernateUtil.getSession();
	    iObjLog.debug("Entrando FacturaPrevioDao.ejecutarConsulta:....   " + strSQL);
	try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			iObjLog.debug("FacturaPrevioDao.ejecutarConsulta:Consulta......." + strSQL);
			objStatement.execute(strSQL);
			objStatement.execute("COMMIT;");
		} catch (Exception aObjExcepcion) { 
	    iObjLog.error("FacturaPrevioDao.ejecutarConsulta:Exception....", aObjExcepcion);
	    throw aObjExcepcion;
		} finally{
			if (objStatement != null) {
				objStatement.close();
				objStatement = null;
			}
	    	//HibernateUtil.closeSession();
		}		
	    iObjLog.debug("Saliendo FacturaPrevioDao.guardarDatosAdicionales:....   " + strSQL);
	}
  
  public boolean buscarOrdenuPaciente(int kordensucursal,int kpaciente,int cconvenio) throws Exception {
	  boolean bexiste=false;
	  Connection objConn 	   = null;
		Statement objStatement = null;
		ResultSet rst = null;
		String strSQL = "";	
		String strbusqueda="";
		iObjSesion = HibernateUtil.getSession();
	    iObjLog.debug("Entrando buscarOrdenuPaciente.buscarOrdenuPaciente:....   " + kordensucursal);
  	try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			
			if(kordensucursal>0){
				strSQL = "SELECT DECODE(MAX(KORDENSUCURSAL),NULL,'0'," +
						"               MAX(KORDENSUCURSAL),MAX(KORDENSUCURSAL))	dato	\n" +
						 "FROM T_ORDEN_SUCURSAL_FAC 		\n" +
						 "WHERE KORDENSUCURSAL=" + kordensucursal +" \n"+
						 "AND CCONVENIO="+cconvenio +" AND CESTADOREGISTRO=37";
				
			}else{
				strSQL = "SELECT KPACIENTE	dato	\n" +
						 "FROM T_PACIENTE 		\n" +
						 "WHERE KPACIENTE=" + kpaciente;
			}

			iObjLog.debug("FacturacionPrevioDao.buscarOrdenuPaciente:Consulta......." + strSQL);
			rst = objStatement.executeQuery(strSQL);
			strSQL = "";
			if(rst != null) {
				while(rst.next()){
					String strdato=rst.getString("dato");
					if(!strdato.equals("0")){
						bexiste=true;
					}
				}
				rst.close();
			}		
		} catch (Exception aObjExcepcion) { 
  	    iObjLog.error("DatosOrdenDao.buscarOrdenuPaciente:Exception....", aObjExcepcion);
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
	    	//HibernateUtil.closeSession();
		}		
	    iObjLog.debug("Saliendo FacturacionPrevioDao.buscarOrdenuPaciente:....   " + bexiste);	      
	 return bexiste;
	  	  
  }
  
  public String setRecalculo(int cconvenio,String strbloques) throws Exception {
	  Connection objConn = null;
	  Statement objStatement = null;
	  ResultSet rst = null;
	  String strSQL = "";
	  String strMensaje="";
	  boolean bactualizacion=false;
		
		iObjSesion = HibernateUtil.getSession();
	    iObjLog.debug("Entrando DatosOrdenDao.setRecalculo:....   " + cconvenio);
  	try{
			objConn = iObjSesion.connection();				
			objStatement = objConn.createStatement();
			
			strSQL = "SELECT kordensucursalfac \n" +
					 "FROM T_ORDEN_SUCURSAL_FAC 		\n" +
					 "WHERE UCONSECUTIVO IN(" + strbloques +") \n"+
					 "AND CCONVENIO="+cconvenio +" AND CESTADOREGISTRO=37;";
			iObjLog.debug("Entrando DatosOrdenDao.setRecalculo:strSQL....   " + strSQL);
			rst = objStatement.executeQuery(strSQL);
			strSQL = "";
			if(rst != null) {
				while(rst.next()){
					if((cconvenio==363)||(cconvenio==364)){
						strSQL	="begin 																									\n" +   
								  "olab_proc_recalculo_ord_fac_2012.proc_recalcula_orden_2012 (" + rst.getString("kordensucursalfac") + ");	\n" +
								  "end;																										\n";
						this.ejecutarConsulta(strSQL);
						bactualizacion=true;
					}else{
						strSQL  ="begin 																									\n" +   
								  "olab_proc_recalculo_ord_fac.proc_recalcula_orden (" + rst.getString("kordensucursalfac") + ");			\n" +
								  "end;																										\n";
						this.ejecutarConsulta(strSQL);
						bactualizacion=true;
					}
				}
			}
			if(bactualizacion){
				this.ejecutarConsulta(strSQL);
				strMensaje="Se realizo el recalculo del convenio"+cconvenio+" y Bloques"+strbloques;
			}else{
				strMensaje="Favor de verificar las ordenes que esta recalculando";
			}
			iObjLog.debug("FacturacionPrevioDao.setRecalculo:Consulta......." + strSQL);
					
		} catch (Exception aObjExcepcion) { 
  	    iObjLog.error("DatosOrdenDao.setRecalculo:Exception....", aObjExcepcion);
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
	    iObjLog.debug("Saliendo FacturacionPrevioDao.setRecalculo:....   " + strMensaje);	      
	 return strMensaje;
	  	  
  }

  
}
