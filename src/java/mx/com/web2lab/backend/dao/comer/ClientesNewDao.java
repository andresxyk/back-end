package mx.com.web2lab.backend.dao.comer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.OrdenExamenBean;
import mx.com.web2lab.backend.beans.comer.ClienteBean;
import mx.com.web2lab.backend.beans.comer.ConvenioBean;
import mx.com.web2lab.backend.beans.comer.ExamenConvenioBean;
import mx.com.web2lab.backend.beans.comer.MetricasClieConBean;
import mx.com.web2lab.backend.dao.ap.GeneracionPasswordDao;
import mx.com.web2lab.backend.dao.catalogos.CatalogosPKGCatalogosDao;
import mx.com.web2lab.backend.dao.facturacion.mayoreo.FacturacionMayoreoDao;
import mx.com.web2lab.backend.dao.mail.MailDao;
import mx.com.web2lab.backend.dao.tools.AdministracionFOP_PDF;
import mx.com.web2lab.backend.dao.tools.ReporteEstadoCuentaCxC;
import mx.com.web2lab.backend.hbm.ConfiguracionProperties;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.CClasificacionComercial;
import mx.com.web2lab.backend.hbm.om.ap.CCliente;
import mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal;
import mx.com.web2lab.backend.hbm.om.ap.CConvenio;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CListaCorporativa;
import mx.com.web2lab.backend.hbm.om.ap.CMarca;
import mx.com.web2lab.backend.hbm.om.ap.CTipoCliente;
import mx.com.web2lab.backend.hbm.om.ap.CTipoConvenio;
import mx.com.web2lab.backend.hbm.om.ap.CTipoPagoFactura;
import mx.com.web2lab.backend.hbm.om.ap.CTipoPersona;
import mx.com.web2lab.backend.hbm.om.ap.CVigencia;
import mx.com.web2lab.backend.hbm.om.ap.EConvenio;
import mx.com.web2lab.backend.hbm.om.ap.EConvenioClasificacion;
import mx.com.web2lab.backend.hbm.om.ap.EConvenioDetalle;
import mx.com.web2lab.backend.hbm.om.ap.EConvenioPerfil;
import mx.com.web2lab.backend.hbm.om.ap.TFactura;
import mx.com.web2lab.backend.hbm.om.lis.CExamen;
import mx.com.web2lab.backend.util.catalogo.ListaExamenUtil;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import mx.com.web2lab.backend.util.formatos.Formatos;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.collection.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClientesNewDao {

	private static Log iObjLog = LogFactory.getLog(ClientesNewDao.class);
	    
	private Session iObjSesion = null;
	
	public ClientesNewDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	
	public MetricasClieConBean estatusClientesConvenios() throws Exception {
		iObjSesion = HibernateUtil.getSession();
		String strQuery = "";
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objrst  = null;
		MetricasClieConBean objMetricas = new MetricasClieConBean();
		try {			
			iObjLog.debug("Entrando ClientesDao.estatusClientesConvenios  " + objMetricas.toString());
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		strQuery =  "select count(*) monto " +					
    					" from C_Cliente CC  " +					
    					" where CC.cestadoregistro = 10";
			objrst = objStmt.executeQuery(strQuery);
			while (objrst.next()) {
				objMetricas.setIntClientesActivos(objrst.getInt("monto"));				
			}
			objrst.close();
    		strQuery =  "select count(*) monto " +					
						" from C_Cliente CC  " +					
						" where CC.cestadoregistro = 9";
			objrst = objStmt.executeQuery(strQuery);
			while (objrst.next()) {
				objMetricas.setIntClientesNOActivos(objrst.getInt("monto"));
			}
			objrst.close();
			strQuery =  "select count(*) monto " +					
						" from E_Convenio EC  " +					
						" where EC.cestadoregistro = 22";
			objrst = objStmt.executeQuery(strQuery);
			while (objrst.next()) {
				objMetricas.setIntConveniosActivos(objrst.getInt("monto"));
			}
			objrst.close();
			strQuery =  "select count(*) monto " +					
						" from E_Convenio EC  " +					
						" where EC.cestadoregistro = 23";
			objrst = objStmt.executeQuery(strQuery);
			while (objrst.next()) {
				objMetricas.setIntConveniosNOActivos(objrst.getInt("monto"));
			}
			objrst.close();			
			strQuery =  "SELECT COUNT(CC.*) monto " +
						" FROM C_CLIENTE CC LEFT JOIN C_CONVENIO CCO ON CC.CCLIENTE=CCO.CCLIENTE " +
						" WHERE CCO.CCLIENTE IS NULL ";
			objrst = objStmt.executeQuery(strQuery);
			while (objrst.next()) {
				objMetricas.setIntClientesSinConvenio(objrst.getInt("monto"));
			}
			objrst.close();			
			strQuery =  "SELECT COUNT(DISTINCT CC.CCLIENTE)	monto										" +
						"	FROM C_CLIENTE CC INNER JOIN C_CONVENIO CCO ON CC.CCLIENTE=CCO.CCLIENTE		" +
						"	INNER JOIN E_CONVENIO EC ON CCO.CCONVENIO=EC.CCONVENIO						" +
						"	INNER JOIN C_ESTADO_REGISTRO CER ON EC.CESTADOREGISTRO=CER.CESTADOREGISTRO	" +
						"	WHERE CC.CCLIENTE NOT IN (													" +
						"	SELECT CC.CCLIENTE															" +
						"	FROM C_CLIENTE CC INNER JOIN C_CONVENIO CCO ON CC.CCLIENTE=CCO.CCLIENTE		" +
						"	INNER JOIN E_CONVENIO EC ON CCO.CCONVENIO=EC.CCONVENIO						" +
						"	INNER JOIN C_ESTADO_REGISTRO CER ON EC.CESTADOREGISTRO=CER.CESTADOREGISTRO	" +
						"	WHERE CER.CESTADOREGISTRO = 22)";					
			objrst = objStmt.executeQuery(strQuery);
			while (objrst.next()) {
				objMetricas.setIntClientesSinConvenioActivos(objrst.getInt("monto"));
			}
			objrst.close();			
			iObjLog.debug("Saliendo ClientesDao.estatusClientesConvenios  " + objMetricas.toString());
			return objMetricas;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.estatusClientesConvenios: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objrst  = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}	

	public String showEstadistica(int uTipoControl) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		String strHTML = "";
		String strQuery = "";
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objrst  = null;
		try {			
			iObjLog.debug("Entrando ClientesDao.showEstadistica");
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		switch (uTipoControl) {
    			case 1: {
		    		strQuery =  "select CC.ccliente numero,CC.srazonsocial nombre	" +					
		    					" from C_Cliente CC  								" +					
		    					" where CC.cestadoregistro = 10						" +
		    					"order by nombre									";
					break;
    			}
    			case 2: {
		    		strQuery =  "select CC.ccliente numero,CC.srazonsocial nombre	" +					
								" from C_Cliente CC  								" +					
								" where CC.cestadoregistro = 9						" +
		    					"order by nombre									";
					break;
    			}
    			case 3: {
					strQuery =  "select CC.CConvenio numero,CC.SConvenio nombre									" +					
								" from E_Convenio EC INNER JOIN C_Convenio CC on EC.CConvenio = CC.CConvenio	" +					
								" where EC.cestadoregistro = 22													" +
								"order by nombre																";
					break;
    			}
    			case 4: {
					strQuery =  "select CC.CConvenio numero,CC.SConvenio nombre									" +					
								" from E_Convenio EC INNER JOIN C_Convenio CC on EC.CConvenio = CC.CConvenio	" +					
								" where EC.cestadoregistro = 23													" +
								"order by nombre																";
					break;
    			}
    			case 5: {
					strQuery =  "select CC.ccliente numero,CC.srazonsocial nombre								" +
								" from C_Cliente CC LEFT JOIN C_Convenio CCO ON CC.CCliente=CCO.CCliente 		" +
								" where CCO.CCliente is null 													" +
								"order by nombre																";
					break;
    			}
    			case 6: {    			
					strQuery =  "SELECT DISTINCT CC.CCLIENTE as numero,CC.srazonsocial nombre					" +
								"	FROM C_CLIENTE CC INNER JOIN C_CONVENIO CCO ON CC.CCLIENTE=CCO.CCLIENTE		" +
								"	INNER JOIN E_CONVENIO EC ON CCO.CCONVENIO=EC.CCONVENIO						" +
								"	INNER JOIN C_ESTADO_REGISTRO CER ON EC.CESTADOREGISTRO=CER.CESTADOREGISTRO	" +
								"	WHERE CC.CCLIENTE NOT IN (													" +
								"	SELECT CC.CCLIENTE															" +
								"	FROM C_CLIENTE CC INNER JOIN C_CONVENIO CCO ON CC.CCLIENTE=CCO.CCLIENTE		" +
								"	INNER JOIN E_CONVENIO EC ON CCO.CCONVENIO=EC.CCONVENIO						" +
								"	INNER JOIN C_ESTADO_REGISTRO CER ON EC.CESTADOREGISTRO=CER.CESTADOREGISTRO	" +
								"	WHERE CER.CESTADOREGISTRO = 22)												" +					
								"order by nombre																";
					break;
    			}
    		}
			iObjLog.debug("Consulta ClientesDao.showEstadistica \n " + strQuery + "\n");
			objrst = objStmt.executeQuery(strQuery);
			strHTML = ("<table border='0' align='center' style='width: 100%' class='tabla'>" +
						"<tr>" + 
							"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
							"	<b><font color='black'>#" + 
							"	</font></b>" +
							"</th>" + 
							"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
							"	<b><font color='black'>Clave" + 
							"	</font></b>" +
							"</th>" + 
							"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
							"	<b><font color='black'>Nombre" + 
							"	</font></b>" +
							"</th>" + 
						"</tr>");			    
			int y = 0;
			while (objrst.next()) {
				y++;
				strHTML  =  strHTML + ("<tr>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												y + 
											"</a></td>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												objrst.getInt("numero") + 
											"</a></td>" + 
											"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												objrst.getString("nombre") +
											"</a></td>" + 
									   "</tr>");
			}
			strHTML = strHTML + "</table>";
			objrst.close();			
			iObjLog.debug("Saliendo ClientesDao.showEstadistica \n " + strHTML + "\n");
			return strHTML;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.showEstadistica: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objrst  = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}	
	
	
	public ClienteBean setClienteActualizacion(ClienteBean objClienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		List lstClientes = new ArrayList();
		CCliente objClienteHB = new CCliente();; 
		try {			
            HibernateUtil.beginTrans();
        	if (objClienteBean.getCcliente() > 0) {			
    			iObjLog.debug("Consulta ClientesDao.setClienteActualizacion:...Por Numero Cliente  " + objClienteBean.getCcliente());
        		strQuery =  "select bPF " +					
							" from CCliente bPF " +					
							" where bPF.cmarca=" +  objClienteBean.getCmarca() + " and bPF.ccliente = :cclienteparam";
				objQuery = iObjSesion.createQuery(strQuery);
				objQuery.setParameter("cclienteparam",new Integer(objClienteBean.getCcliente()));
				lstClientes = objQuery.list();
				if(lstClientes != null) {
					if (lstClientes.size() > 0) {
						objClienteHB = (CCliente)lstClientes.get(0);
					}
				}			
        	} else {
    			iObjLog.debug("Consulta ClientesDao.setClienteActualizacion:...Por srazonsocial o rfc " + objClienteBean.getSrazonsocial().trim() + " " + objClienteBean.getSrfc().trim());
				strQuery =  "select bPF " +					
							" from CCliente bPF " +					
							" where bPF.cmarca=" +  objClienteBean.getCmarca() + " and bPF.srazonsocial like ('" + objClienteBean.getSrazonsocial().trim() + "%') " +
							" AND bPF.srfc like ('" + objClienteBean.getSrfc().trim() + "%') ";
				objQuery = iObjSesion.createQuery(strQuery);
				lstClientes = objQuery.list();
				if(lstClientes != null) {
					if (lstClientes.size() > 0) {
						objClienteHB = (CCliente)lstClientes.get(0);
					}
				}			        		
        	}        	
        	CCodigoPostal objCP = new CCodigoPostal();
	        	objCP.setCcodigopostal(new Integer(objClienteBean.getCcodigopostal()));
				iObjLog.debug("Consulta ClientesDao.setClienteActualizacion.....Beans CodigoPostal.." + objClienteBean.getCcodigopostal());        	
	        	objClienteHB.setCcodigopostal(objCP);
        	CEstadoRegistro objEstadoRegistro = new CEstadoRegistro();
	        	objEstadoRegistro.setCestadoregistro(new Integer(10));
	        	objClienteHB.setCestadoregistro(objEstadoRegistro);
				iObjLog.debug("Consulta ClientesDao.setClienteActualizacion.....Beans Tipo Cliente.." + objClienteBean.getCtipocliente());
        	objClienteHB.setCtipocliente(new CTipoCliente(new Integer(objClienteBean.getCtipocliente()),"",null));
        	objClienteHB.setCgirocliente(objClienteBean.getCgirocliente());        	
			iObjLog.debug("Consulta ClientesDao.setClienteActualizacion.....Beans Tipo Persona.." + objClienteBean.getCtipopersona());
        	objClienteHB.setCtipopersona(new CTipoPersona(new Integer(objClienteBean.getCtipopersona()),"",null));
        	objClienteHB.setSdireccion(objClienteBean.getSdireccion());
        	objClienteHB.setSobservaciones(objClienteBean.getSobservaciones());
        	objClienteHB.setSrazonsocial(objClienteBean.getSrazonsocial());
        	objClienteHB.setSrfc(objClienteBean.getSrfc());
        	objClienteHB.setSmnemonico(objClienteBean.getSmnemonico());
        	objClienteHB.setUserid(new BigDecimal(4333));
        	objClienteHB.setCmarca(objClienteBean.getCmarca());
			iObjLog.debug("Consulta ClientesDao.setClienteActualizacion.....Beans creados");
        	if (objClienteBean.getCcliente() == 0) {
            	objClienteHB.setDregistro(new Date());
            	objClienteHB.setCzonaventa(0);
        		iObjSesion.save(objClienteHB);
        	} else {
        		iObjSesion.update(objClienteHB);            		
        	}
    		iObjSesion.flush();            	
//            HibernateUtil.commitTrans();	 
			objClienteBean.setCcliente(objClienteHB.getCcliente().intValue());
			iObjLog.debug("Saliendo ClientesDao.setClienteActualizacion  " + objClienteBean.toString());
			return objClienteBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.setClienteActualizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	

	public String altaPorcentajeClasificacionConvenio(int uConvenio,int uClasificacion, double pDescuento) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		EConvenioClasificacion objConvenioClasificacion = new EConvenioClasificacion();
		CConvenio objConvenio = new CConvenio();
		CClasificacionComercial objClasificacionComercial = new CClasificacionComercial();
		String strReturn = "";
		try {			
            HibernateUtil.beginTrans();
//            objConvenioClasificacion.setKconvenioclasificaion(kconvenioclasificaion)
            	objClasificacionComercial.setCclasificacioncomercial(new Integer(uClasificacion));
            objConvenioClasificacion.setCclasificacioncomercial(objClasificacionComercial);            
            	objConvenio.setCconvenio(new Integer(uConvenio));
            objConvenioClasificacion.setCconvenio(objConvenio);            	
            objConvenioClasificacion.setPdescuento(new BigDecimal(pDescuento));
        		iObjSesion.save(objConvenioClasificacion);
    		iObjSesion.flush();            	
//            HibernateUtil.commitTrans();	 
    		strReturn = "Actualizacion Exitosa";
			iObjLog.debug("Saliendo ClientesDao.setClienteActualizacion  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.setClienteActualizacion: ", aObjExcepcion);
			strReturn = aObjExcepcion.getMessage();
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	public String altaPorcentajeExamenConvenio(int uConvenio,int uExamen, double mFacturar) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		EConvenioDetalle objConvenioExamen = new EConvenioDetalle();
		CConvenio objConvenio = new CConvenio();
		CExamen objExamen = new CExamen();
		String strReturn = "";
		try {			
            HibernateUtil.beginTrans();
            objExamen.setCexamen(new Integer(uExamen));
            objConvenioExamen.setCexamen(objExamen);
            	objConvenio.setCconvenio(new Integer(uConvenio));
            objConvenioExamen.setCconvenio(objConvenio);            	
            objConvenioExamen.setPdescuento(new BigDecimal(0));
            objConvenioExamen.setMpreciofacturarsiniva(new BigDecimal(mFacturar));
            objConvenioExamen.setMpreciofacturarconiva(new BigDecimal(0));
            objConvenioExamen.setCtipodescuento(new Integer(0));
            objConvenioExamen.setCestadoregistro(49);
        		iObjSesion.save(objConvenioExamen);
    		iObjSesion.flush();            	
    		strReturn = "Actualizacion Exitosa";
			iObjLog.debug("Saliendo ClientesDao.altaPorcentajeExamenConvenio  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.altaPorcentajeExamenConvenio: ", aObjExcepcion);
			strReturn = aObjExcepcion.getMessage();
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	

	public String actualizarPorcentajeExamenConvenio(int kConvenioDetalle,int uConvenio,int uExamen, double mFacturar) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		EConvenioDetalle objConvenioExamen = new EConvenioDetalle();
		CConvenio objConvenio = new CConvenio();
		CExamen objExamen = new CExamen();
		String strReturn = "";
		try {			
            HibernateUtil.beginTrans();
            objConvenioExamen.setKconveniodetalle(new Integer(kConvenioDetalle));
            objExamen.setCexamen(new Integer(uExamen));
            objConvenioExamen.setCexamen(objExamen);
            	objConvenio.setCconvenio(new Integer(uConvenio));
            objConvenioExamen.setCconvenio(objConvenio);            	
            objConvenioExamen.setPdescuento(new BigDecimal(0));
            objConvenioExamen.setMpreciofacturarconiva(new BigDecimal(0));
            objConvenioExamen.setMpreciofacturarsiniva(new BigDecimal(mFacturar));
            objConvenioExamen.setCtipodescuento(new Integer(0));
        		iObjSesion.update(objConvenioExamen);
    		iObjSesion.flush();            	
    		strReturn = "Actualizacion Exitosa";
			iObjLog.debug("Saliendo ClientesDao.actualizarPorcentajeExamenConvenio  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.actualizarPorcentajeExamenConvenio: ", aObjExcepcion);
			strReturn = aObjExcepcion.getMessage();
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	


	public String eliminarExamenConvenio(int kConvenioDetalle,int uConvenio,int uExamen, double mFacturar) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		EConvenioDetalle objConvenioExamen = new EConvenioDetalle();
		CConvenio objConvenio = new CConvenio();
		CExamen objExamen = new CExamen();
		String strReturn = "";
		try {			
            HibernateUtil.beginTrans();
            objConvenioExamen.setKconveniodetalle(new Integer(kConvenioDetalle));
            objExamen.setCexamen(new Integer(uExamen));
            objConvenioExamen.setCexamen(objExamen);
            	objConvenio.setCconvenio(new Integer(uConvenio));
            objConvenioExamen.setCconvenio(objConvenio);            	
            objConvenioExamen.setPdescuento(new BigDecimal(0));
            objConvenioExamen.setMpreciofacturarconiva(new BigDecimal(0));
            objConvenioExamen.setMpreciofacturarsiniva(new BigDecimal(mFacturar));
            objConvenioExamen.setCtipodescuento(new Integer(0));
            objConvenioExamen.setCestadoregistro(50);
            iObjSesion.delete(objConvenioExamen);
    		iObjSesion.flush();            	
    		strReturn = "Examen eliminado del Convenio";
			iObjLog.debug("Saliendo ClientesDao.eliminarExamenConvenio  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.eliminarExamenConvenio: ", aObjExcepcion);
			strReturn = aObjExcepcion.getMessage();
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	

	
	public String actualizarPorcentajeClasificacionConvenio(int kClasificacion,int uConvenio,int uClasificacion, double pDescuento) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		EConvenioClasificacion objConvenioClasificacion = new EConvenioClasificacion();
		CConvenio objConvenio = new CConvenio();
		CClasificacionComercial objClasificacionComercial = new CClasificacionComercial();
		String strReturn = "";
		try {			
            HibernateUtil.beginTrans();
            objConvenioClasificacion.setKconvenioclasificaion(new Integer(kClasificacion));
            	objClasificacionComercial.setCclasificacioncomercial(new Integer(uClasificacion));
            objConvenioClasificacion.setCclasificacioncomercial(objClasificacionComercial);            
            	objConvenio.setCconvenio(new Integer(uConvenio));
            objConvenioClasificacion.setCconvenio(objConvenio);            	
            objConvenioClasificacion.setPdescuento(new BigDecimal(pDescuento));
        		iObjSesion.update(objConvenioClasificacion);
    		iObjSesion.flush();            	
    		strReturn = "Actualizacion Exitosa";
			iObjLog.debug("Saliendo ClientesDao.borrarPorcentajeClasificacionConvenio  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.borrarPorcentajeClasificacionConvenio: ", aObjExcepcion);
			strReturn = aObjExcepcion.getMessage();
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	
	public ConvenioBean setConvenioActualizacion(ConvenioBean objConvenioBean) throws Exception {
		iObjLog.debug("Entrando ClientesDao.setConvenioActualizacion  " + objConvenioBean.toString());
		iObjSesion = HibernateUtil.getSession();
		/******** CConvenio *******/
		CConvenio objConvenioHB = new CConvenio(); 
		EConvenio objEConvenioHB = new EConvenio();
		CCliente objClienteHB = new CCliente();
		CTipoConvenio objTipoConvenio =  new CTipoConvenio();
		/******** EConvenio *******/
		Query objQuery = null;
		String strQuery = "";
		boolean bolConvenioUpdate = false;
		List lstConvenios = new ArrayList();
		CEstadoRegistro objEstadoRegistro = new CEstadoRegistro();
		objEstadoRegistro.setCestadoregistro(objConvenioBean.getUestadoconvenio());
		CListaCorporativa objListaCorporativa = new CListaCorporativa();
		objListaCorporativa.setClistacorporativa(new Integer(1));
		CVigencia objVigencia = new CVigencia();
		objVigencia.setCvigencia(new Integer(1));
		boolean bolActualizacionCorreoElectronico = false;
		try {			
            HibernateUtil.beginTrans();                        
            if (objConvenioBean.getCconvenio().intValue() > 0) {
        		strQuery =  "select bPF " +					
							" from EConvenio bPF " +					
							" where bPF.cconvenio.cconvenio = " +  objConvenioBean.getCconvenio().intValue();
    			objQuery = iObjSesion.createQuery(strQuery);
    			lstConvenios = objQuery.list();
            }
			if(lstConvenios != null) {
				if (lstConvenios.size()> 0) {
//					objConvenioHB = (EConvenio)lstConvenios.get(0);
					objEConvenioHB = (EConvenio)lstConvenios.get(0);
					objConvenioHB = objEConvenioHB.getCconvenio();
					iObjLog.debug("Consulta ClientesDao.setConvenioActualizacion Convenio encontrado " + objConvenioHB.getCconvenio().intValue());					
//					Iterator objIteraEConvenio = objConvenioHB.getEconvenios().iterator();
//					while (objIteraEConvenio.hasNext()) {
//						objEConvenioHB = (EConvenio)objIteraEConvenio.next();									
//					}						
					bolConvenioUpdate = true;
				}					
			}                        
            objTipoConvenio.setCtipoconvenio(new Integer(objConvenioBean.getCtipoconvenio()));
            objConvenioHB.setCtipoconvenio(objTipoConvenio);
            objConvenioHB.setSconvenio(objConvenioBean.getSconvenio());            
            if (bolConvenioUpdate) {
                objConvenioHB.setUseridchange(new BigDecimal(objConvenioBean.getCuser()));
                if (objConvenioBean.getScorreoelectronico().trim().length() > 4 && (objConvenioBean.getScorreoelectronico().trim() != objConvenioHB.getScorreoelectronico().trim() || !objConvenioBean.getScorreoelectronico().trim().equals(objConvenioHB.getScorreoelectronico().trim()))) {                
	                GeneracionPasswordDao objGeneracionPasswordDao = new GeneracionPasswordDao();
	        		objConvenioHB.setSpassword(objGeneracionPasswordDao.getPassword());
	        		objConvenioHB.setSpasswordconsulta(objGeneracionPasswordDao.getPassword());
	        		objConvenioHB.setScorreoelectronico(objConvenioBean.getScorreoelectronico());
	        		objConvenioHB.setSpassword(objConvenioHB.getCconvenio().intValue() + "" + objConvenioBean.getScorreoelectronico().toUpperCase().substring(0, 2));
	        		objConvenioHB.setSpasswordconsulta(objConvenioHB.getCconvenio().intValue() + "" + objConvenioBean.getScorreoelectronico().toUpperCase().substring(0, 2));
	    			objGeneracionPasswordDao = null;
	    			bolActualizacionCorreoElectronico = true;
                }
            	iObjSesion.update(objConvenioHB);            	
    			if ((objConvenioBean.getScorreoelectronico().trim().length() > 4) && (bolActualizacionCorreoElectronico)) {
            		MailDao objMailDao = new MailDao();
            		objMailDao.sendEmailECEEmpresaGDA2016("Bienvenido al Expediente Clínico Electrónico de Laboratorio Olab", objConvenioHB);
            		objMailDao = null;
            	}        		
            } else {
            	objClienteHB.setCcliente(new Integer(objConvenioBean.getCcliente()));
                objConvenioHB.setCcliente(objClienteHB);
                objConvenioHB.setDregistro(new Date());
                objConvenioHB.setUserid(new BigDecimal(objConvenioBean.getCuser()));
                objConvenioHB.setUseridchange(new BigDecimal(objConvenioBean.getCuser()));                
                if (objConvenioBean.getScorreoelectronico().trim().length() > 4) {                
	                GeneracionPasswordDao objGeneracionPasswordDao = new GeneracionPasswordDao();
	        		objConvenioHB.setSpassword(objGeneracionPasswordDao.getPassword());
	        		objConvenioHB.setSpasswordconsulta(objGeneracionPasswordDao.getPassword());
	        		objConvenioHB.setScorreoelectronico(objConvenioBean.getScorreoelectronico());
	        		objConvenioHB.setSpassword(objConvenioHB.getCconvenio().intValue() + "" + objConvenioBean.getScorreoelectronico().toUpperCase().substring(0, 2));
	        		objConvenioHB.setSpasswordconsulta(objConvenioHB.getCconvenio().intValue() + "" + objConvenioBean.getScorreoelectronico().toUpperCase().substring(0, 2));
	    			objGeneracionPasswordDao = null;
                } else {
	        		objConvenioHB.setSpassword(" ");
	        		objConvenioHB.setSpasswordconsulta(" ");
	        		objConvenioHB.setScorreoelectronico(" ");
                }
//                objConvenioHB.setCzonaventa(0);
            	iObjSesion.save(objConvenioHB);
    			if (objConvenioBean.getScorreoelectronico().trim().length() > 4) {
            		MailDao objMailDao = new MailDao();
            		objMailDao.sendEmailECEEmpresaGDA2016("Bienvenido al Expediente Clínico Electrónico de Laboratorio Olab", objConvenioHB);
            		objMailDao = null;
            	}        		
            }
    		objConvenioBean.setCconvenio(objConvenioHB.getCconvenio());        		    		
            if (bolConvenioUpdate) {
        		objEConvenioHB.setCestadoregistro(objEstadoRegistro);
//        		if (objConvenioBean.getDinicio() != null) {
//        			objEConvenioHB.setDinicio(objConvenioBean.getDinicio());
//        		} else {
//        			objEConvenioHB.setDinicio(new Date());
//        		}
//        		if (objConvenioBean.getDtermino() != null) {
//        			objEConvenioHB.setDtermino(objConvenioBean.getDtermino());
//        		} else {
//        			objEConvenioHB.setDtermino(new Date());
//        		}
            	iObjSesion.update(objEConvenioHB);            	
            } else {
        		objEConvenioHB.setCconvenio(objConvenioHB);
        		objEConvenioHB.setCestadoregistro(objEstadoRegistro);
        		objEConvenioHB.setClistacorporativa(objListaCorporativa);
        		objEConvenioHB.setCvigencia(objVigencia);
        		objEConvenioHB.setDinicio(objConvenioBean.getDinicio());
        		objEConvenioHB.setDtermino(objConvenioBean.getDtermino());
        			CMarca objCMarca = new CMarca();
        			objCMarca.setCmarca(new Integer(1));
        		objEConvenioHB.setCmarca(objCMarca);
        		iObjSesion.save(objEConvenioHB);
            }
    		iObjLog.debug("Consulta ClientesDao.setConvenioActualizacion.....Beans creados");
    		iObjSesion.flush();            	
    		objConvenioBean.setUestadoconvenio(objEConvenioHB.getCestadoregistro().getCestadoregistro());
    		objConvenioBean.setSestadoconvenio(objEConvenioHB.getCestadoregistro().getSestadoregistro());    		
			iObjLog.debug("Saliendo ClientesDao.setConvenioActualizacion  " + objConvenioBean.toString());
			return objConvenioBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.setConvenioActualizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	

	public String setConvenioActualizacionECEEmpresa(ConvenioBean objConvenioBean) throws Exception {
		iObjLog.debug("Entrando ClientesDao.setConvenioActualizacionECEEmpresa  " + objConvenioBean.toString());
		iObjSesion = HibernateUtil.getSession();
		/******** CConvenio *******/
		CConvenio objConvenioHB = new CConvenio(); 
		Query objQuery = null;
		String strQuery = "";
		boolean bolConvenioUpdate = false;
		List lstConvenios = new ArrayList();
		try {			
            HibernateUtil.beginTrans();                        
            if (objConvenioBean.getCconvenio().intValue() > 0) {
        		strQuery =  "select bPF " +					
							" from CConvenio bPF " +					
							" where bPF.cconvenio = " +  objConvenioBean.getCconvenio().intValue();
    			objQuery = iObjSesion.createQuery(strQuery);
    			lstConvenios = objQuery.list();
            }
			if(lstConvenios != null) {
				if (lstConvenios.size()> 0) {
					objConvenioHB = (CConvenio)lstConvenios.get(0);
					iObjLog.debug("Consulta ClientesDao.setConvenioActualizacionECEEmpresa Convenio encontrado " + objConvenioHB.getCconvenio().intValue());					
					bolConvenioUpdate = true;
				}					
			}                        
            if (bolConvenioUpdate) {
                objConvenioHB.setUseridchange(new BigDecimal(objConvenioBean.getCuser()));
                if (objConvenioBean.getScorreoelectronico().trim().length() > 4 && (objConvenioBean.getScorreoelectronico().trim() != objConvenioHB.getScorreoelectronico().trim() || !(objConvenioBean.getScorreoelectronico().trim().equals(objConvenioHB.getScorreoelectronico().trim())))) {                
	                GeneracionPasswordDao objGeneracionPasswordDao = new GeneracionPasswordDao();
	        		objConvenioHB.setSpassword(objGeneracionPasswordDao.getPassword());
	        		objConvenioHB.setSpasswordconsulta(objGeneracionPasswordDao.getPassword());
	        		objConvenioHB.setScorreoelectronico(objConvenioBean.getScorreoelectronico());
	        		objConvenioHB.setSpassword(objConvenioHB.getCconvenio().intValue() + "" + objConvenioBean.getScorreoelectronico().toUpperCase().substring(0, 2));
	        		objConvenioHB.setSpasswordconsulta(objConvenioHB.getCconvenio().intValue() + "" + objConvenioBean.getScorreoelectronico().toUpperCase().substring(0, 2));
	    			objGeneracionPasswordDao = null;
	            	iObjSesion.update(objConvenioHB);            	
	        		iObjSesion.flush();            	
	        		MailDao objMailDao = new MailDao();
	        		objMailDao.sendEmailECEEmpresaGDA2016("Bienvenido al Expediente Clínico Electrónico de Laboratorio Olab", objConvenioHB);
	        		objMailDao = null;
	        		strQuery = "Éxito en el envió del correo electrónico";
                } else {
	        		strQuery = "No fue posible el envió del correo electrónico";                	
                }
            } else {
        		strQuery = "No fue posible el envió del correo electrónico";                	
            }
			iObjLog.debug("Saliendo ClientesDao.setConvenioActualizacionECEEmpresa  " + objConvenioBean.toString());
			return strQuery;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.setConvenioActualizacionECEEmpresa: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objConvenioHB = null; 
    		objQuery = null;
    		lstConvenios = null;
        	HibernateUtil.closeSession();
		}		
	}	
	
	public List buscarCliente(ClienteBean objClienteParamBean) throws Exception {
		iObjLog.debug("Entrando ClientesDao.buscarCliente:" + objClienteParamBean.toString());
			iObjSesion = HibernateUtil.getSession();
			List lstClientes = new ArrayList();
			List lstClientesReturn = new ArrayList();
			CCliente objClienteHB = new CCliente();; 
			ClienteBean objClienteBean = null;
			Query objQuery = null;
			String strQuery = "";
			boolean bolBuscarFacturas = false;
	    	try{
	            HibernateUtil.beginTrans();
	            if (objClienteParamBean.getCcliente() > 0) {
	        		strQuery =  "select bPF " +					
								" from CCliente bPF " +					
								" where bPF.ccliente = " +  objClienteParamBean.getCcliente();
	        		bolBuscarFacturas = true;
	            } else if ((objClienteParamBean.getSrfc().trim().length() > 0) || (objClienteParamBean.getSrazonsocial().trim().length() > 0) || (objClienteParamBean.getSmnemonico().trim().length() > 0)) {
	        		strQuery =  "select bPF " +					
								" from CCliente bPF " +					
								" where bPF.srfc=bPF.srfc ";	   	        		
					if (objClienteParamBean.getSrazonsocial().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarCliente:Entrando...Razon Social  " +  objClienteParamBean.getSrazonsocial().trim());
						strQuery += " AND bPF.srazonsocial like ('%" + objClienteParamBean.getSrazonsocial().trim() + "%') ";
					}
					if (objClienteParamBean.getSrfc().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarCliente:Entrando...RFC  " +  objClienteParamBean.getSrfc().trim());
						strQuery += " AND bPF.srfc like ('" + objClienteParamBean.getSrfc().trim() + "%') ";
					}
					if (objClienteParamBean.getSmnemonico().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarCliente:Entrando...MNEMONICO  " +  objClienteParamBean.getSmnemonico().trim());
						strQuery += " AND bPF.smnemonico like ('%" + objClienteParamBean.getSmnemonico().trim() + "%') ";
					}
	            }
	            if (strQuery != "") {
					iObjLog.debug("Consulta ClientesDao.buscarCliente:" + strQuery);
					objQuery = iObjSesion.createQuery(strQuery);
					lstClientes = objQuery.list();
					int intFacturas = 0;
					if(lstClientes != null) {
						for(int inti=0;inti<lstClientes.size();inti++) {
							intFacturas = 0;
							objClienteHB = (CCliente)lstClientes.get(inti);
							objClienteBean = new ClienteBean();
							objClienteBean.setCcliente(objClienteHB.getCcliente().intValue());
							objClienteBean.setCcodigopostal(objClienteHB.getCcodigopostal().getCcodigopostal().intValue());
							objClienteBean.setCestadoregistro(objClienteHB.getCestadoregistro().getCestadoregistro().intValue());
							objClienteBean.setSestadoregistro(objClienteHB.getCestadoregistro().getSestadoregistro());
							objClienteBean.setCtipocliente(objClienteHB.getCtipocliente().getCtipocliente().intValue());
							objClienteBean.setCgirocliente(objClienteHB.getCgirocliente());
							objClienteBean.setCtipopersona(objClienteHB.getCtipopersona().getCtipopersona().intValue());
							objClienteBean.setSdireccion(objClienteHB.getSdireccion());
							objClienteBean.setSobservaciones(objClienteHB.getSobservaciones());
							objClienteBean.setSrazonsocial(objClienteHB.getSrazonsocial());
							objClienteBean.setSrfc(objClienteHB.getSrfc());
							objClienteBean.setSmnemonico("" + objClienteHB.getSmnemonico());
							objClienteBean.setCcodigopostal(objClienteHB.getCcodigopostal().getCcodigopostal().intValue());
							objClienteBean.setScodigopostal(objClienteHB.getCcodigopostal().getCpostal());
							objClienteBean.setScolonia(objClienteHB.getCcodigopostal().getScolonia());
							objClienteBean.setSdelegacionmunicipio(objClienteHB.getCcodigopostal().getSdelegacionmunicipio());
							objClienteBean.setSestado(objClienteHB.getCcodigopostal().getSestado());						
							Set objMapaConvenios = (Set) objClienteHB.getCconvenios();
							Iterator iteConvenios = objMapaConvenios.iterator();
							CConvenio objConvenio = null;
							while (iteConvenios.hasNext()) {
								objConvenio = (CConvenio)iteConvenios.next();
								if (objClienteParamBean.getCtipocliente() == 69) {
									if (objConvenio.getCtipoconvenio().getCtipoconvenio().intValue() == 22) {
										ConvenioBean objConvenioBean = new ConvenioBean();
										objConvenioBean.setCcliente(objClienteBean.getCcliente());
										objConvenioBean.setCconvenio(objConvenio.getCconvenio());
		//								objConvenioBean.setClistacorporativa(clistacorporativa)
										objConvenioBean.setCtipoconvenio(objConvenio.getCtipoconvenio().getCtipoconvenio().intValue());
		//								objConvenioBean.setCvigencia(cvigencia)
		//								objConvenioBean.setDregistro(dregistro)
										objConvenioBean.setKconvenio(objConvenio.getCconvenio());
		//								objConvenioBean.setScliente(scliente)
										objConvenioBean.setSconvenio(objConvenio.getSconvenio());
		//								objConvenioBean.setSInicioVigencia(inicioVigencia)
		//								objConvenioBean.setSTerminoVigencia(terminoVigencia)
										objConvenioBean.setStipoconvenio(objConvenio.getCtipoconvenio().getCdescripciontipoconvenio());
										Iterator objIteraEConvenio = objConvenio.getEconvenios().iterator();
										while (objIteraEConvenio.hasNext()) {
											EConvenio objEConvenio = (EConvenio)objIteraEConvenio.next();									
											objConvenioBean.setSestadoconvenio(objEConvenio.getCestadoregistro().getSestadoregistro());
											objConvenioBean.setUestadoconvenio(objEConvenio.getCestadoregistro().getCestadoregistro());
											iObjLog.debug("Consulta ClientesDao.buscarCliente...kConvenio " + objEConvenio.getKconvenio());
											objConvenioBean.setSiniciovigencia(new Formatos().getFechaNumeros(objEConvenio.getDinicio()));
											objConvenioBean.setSterminovigencia(new Formatos().getFechaNumeros(objEConvenio.getDtermino()));
											objConvenioBean.setStrvencimiento(getDiasVigentes(objEConvenio.getDinicio(),objEConvenio.getDtermino()));
										}						
										iObjLog.debug("Consulta ClientesDao.buscarCliente:OMRR" + bolBuscarFacturas);
//										if (bolBuscarFacturas) {									
//											FacturacionMayoreoDao objFacturacionMayoreoDao = new FacturacionMayoreoDao();									
//											objConvenioBean = objFacturacionMayoreoDao.getFacturasConvenioCxC(objConvenioBean);									
//											intFacturas = (intFacturas + objConvenioBean.getLstFacturas().size());
//											objClienteBean.setStrFacturasGrid(objClienteBean.getStrFacturasGrid() + objConvenioBean.getStrFacturasGrid());
//											objFacturacionMayoreoDao = null;
//										}
										objClienteBean.getLstConvenios().add(objConvenioBean);
									}
								} else {
									ConvenioBean objConvenioBean = new ConvenioBean();
									objConvenioBean.setCcliente(objClienteBean.getCcliente());
									objConvenioBean.setCconvenio(objConvenio.getCconvenio());
	//								objConvenioBean.setClistacorporativa(clistacorporativa)
									objConvenioBean.setCtipoconvenio(objConvenio.getCtipoconvenio().getCtipoconvenio().intValue());
	//								objConvenioBean.setCvigencia(cvigencia)
	//								objConvenioBean.setDregistro(dregistro)
									objConvenioBean.setKconvenio(objConvenio.getCconvenio());
	//								objConvenioBean.setScliente(scliente)
									objConvenioBean.setSconvenio(objConvenio.getSconvenio());
	//								objConvenioBean.setSInicioVigencia(inicioVigencia)
	//								objConvenioBean.setSTerminoVigencia(terminoVigencia)
									objConvenioBean.setStipoconvenio(objConvenio.getCtipoconvenio().getCdescripciontipoconvenio());
									Iterator objIteraEConvenio = objConvenio.getEconvenios().iterator();
									while (objIteraEConvenio.hasNext()) {
										EConvenio objEConvenio = (EConvenio)objIteraEConvenio.next();									
										objConvenioBean.setSestadoconvenio(objEConvenio.getCestadoregistro().getSestadoregistro());
										objConvenioBean.setUestadoconvenio(objEConvenio.getCestadoregistro().getCestadoregistro());
										iObjLog.debug("Consulta ClientesDao.buscarCliente...kConvenio" + objEConvenio.getKconvenio());
										if (objEConvenio.getDinicio() != null) {
											objConvenioBean.setSiniciovigencia(new Formatos().getFechaNumeros(objEConvenio.getDinicio()));
										} else {
											objConvenioBean.setSiniciovigencia("");
										}
										if (objEConvenio.getDtermino() != null) {
											objConvenioBean.setSterminovigencia(new Formatos().getFechaNumeros(objEConvenio.getDtermino()));
										} else {
											objConvenioBean.setSterminovigencia("");
										}
										if (objEConvenio.getDinicio() != null && objEConvenio.getDtermino() != null) {
											objConvenioBean.setStrvencimiento(getDiasVigentes(objEConvenio.getDinicio(),objEConvenio.getDtermino()));
										} else {
											objConvenioBean.setStrvencimiento("");
										}
									}						
									iObjLog.debug("Consulta ClientesDao.buscarCliente:OMRR" + bolBuscarFacturas);
//									if (bolBuscarFacturas) {									
//										FacturacionMayoreoDao objFacturacionMayoreoDao = new FacturacionMayoreoDao();									
//										objConvenioBean = objFacturacionMayoreoDao.getFacturasConvenio(objConvenioBean);									
//										intFacturas = (intFacturas + objConvenioBean.getLstFacturas().size());
//										objClienteBean.setStrFacturasGrid(objClienteBean.getStrFacturasGrid() + objConvenioBean.getStrFacturasGrid());
//										objFacturacionMayoreoDao = null;
//									}
									objClienteBean.getLstConvenios().add(objConvenioBean);
								}
							}
							objClienteBean.sortLstConvenios();							
							objClienteBean.setStrConvenioGrid(this.showConvenios(objClienteBean.getLstConvenios()));
							if (bolBuscarFacturas) {
								objClienteBean.setStrFacturasGrid(this.showHeaderConvenioFacturas(intFacturas,"") + objClienteBean.getStrFacturasGrid() + this.showFooterConvenioFacturas());
							}
							iObjLog.debug("Saliendo ClientesDao.ConveniosGrid...  " + objClienteBean.getStrConvenioGrid());
							lstClientesReturn.add(objClienteBean);
						}
					}			
		            //HibernateUtil.commitTrans();	 				
	            }
			iObjLog.debug("Saliendo ClientesDao.buscarCliente...  " + lstClientesReturn.size());
			return lstClientesReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.buscarCliente: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		

	
	public List buscarClienteCxC(ClienteBean objClienteParamBean, boolean bolCrearReportes) throws Exception {
		iObjLog.debug("Entrando ClientesDao.buscarClienteCxC:" + objClienteParamBean.toString());
			iObjSesion = HibernateUtil.getSession();
			List lstClientes = new ArrayList();
			List lstClientesReturn = new ArrayList();
			CCliente objClienteHB = new CCliente();; 
			ClienteBean objClienteBean = null;
			Query objQuery = null;
			String strQuery = "";
			boolean bolBuscarFacturas = false;
	    	try{
	            HibernateUtil.beginTrans();
	            if (objClienteParamBean.getCcliente() > 0) {
	        		strQuery =  "select bPF " +					
								" from CCliente bPF " +					
								" where bPF.ccliente = " +  objClienteParamBean.getCcliente();
	        		bolBuscarFacturas = true;
	            } else if ((objClienteParamBean.getSrfc().trim().length() > 0) || (objClienteParamBean.getSrazonsocial().trim().length() > 0) || (objClienteParamBean.getSmnemonico().trim().length() > 0)) {
	        		strQuery =  "select bPF " +					
								" from CCliente bPF " +					
								" where bPF.srfc=bPF.srfc ";	   	        		
					if (objClienteParamBean.getSrazonsocial().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarClienteCxC:Entrando...Razon Social  " +  objClienteParamBean.getSrazonsocial().trim());
						strQuery += " AND bPF.srazonsocial like ('%" + objClienteParamBean.getSrazonsocial().trim() + "%') ";
					}
					if (objClienteParamBean.getSrfc().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarCliente:Entrando...RFC  " +  objClienteParamBean.getSrfc().trim());
						strQuery += " AND bPF.srfc like ('" + objClienteParamBean.getSrfc().trim() + "%') ";
					}
					if (objClienteParamBean.getSmnemonico().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarClienteCxC:Entrando...MNEMONICO  " +  objClienteParamBean.getSmnemonico().trim());
						strQuery += " AND bPF.smnemonico like ('%" + objClienteParamBean.getSmnemonico().trim() + "%') ";
					}
	            } else if (objClienteParamBean.getSobservaciones().trim().length() > 10) {
	        		strQuery =  "select bPF " +					
								" from CCliente bPF " +					
								" where bPF.ccliente in (" +  objClienteParamBean.getSobservaciones().trim() + ")";
	        		bolBuscarFacturas = true;
	            }
	            if (strQuery != "") {
					iObjLog.debug("Consulta ClientesDao.buscarClienteCxC:" + strQuery);
					objQuery = iObjSesion.createQuery(strQuery);
					lstClientes = objQuery.list();
					int intFacturas = 0;
					if(lstClientes != null) {
						for(int inti=0;inti<lstClientes.size();inti++) {
							intFacturas = 0;
							objClienteHB = (CCliente)lstClientes.get(inti);
							objClienteBean = new ClienteBean();
							objClienteBean.setCcliente(objClienteHB.getCcliente().intValue());
							objClienteBean.setCmarca(objClienteHB.getCmarca());
							objClienteBean.setCcodigopostal(objClienteHB.getCcodigopostal().getCcodigopostal().intValue());
							objClienteBean.setCestadoregistro(objClienteHB.getCestadoregistro().getCestadoregistro().intValue());
							objClienteBean.setSestadoregistro(objClienteHB.getCestadoregistro().getSestadoregistro());
							objClienteBean.setCtipocliente(objClienteHB.getCtipocliente().getCtipocliente().intValue());
							objClienteBean.setCgirocliente(objClienteHB.getCgirocliente());
							objClienteBean.setCtipopersona(objClienteHB.getCtipopersona().getCtipopersona().intValue());
							objClienteBean.setSdireccion(objClienteHB.getSdireccion());
							objClienteBean.setSobservaciones(objClienteHB.getSobservaciones());
							objClienteBean.setSrazonsocial(objClienteHB.getSrazonsocial());
							objClienteBean.setSrfc(objClienteHB.getSrfc());
							objClienteBean.setSmnemonico("" + objClienteHB.getSmnemonico());
							objClienteBean.setCcodigopostal(objClienteHB.getCcodigopostal().getCcodigopostal().intValue());
							objClienteBean.setScodigopostal(objClienteHB.getCcodigopostal().getCpostal());
							objClienteBean.setScolonia(objClienteHB.getCcodigopostal().getScolonia());
							objClienteBean.setSdelegacionmunicipio(objClienteHB.getCcodigopostal().getSdelegacionmunicipio());
							objClienteBean.setSestado(objClienteHB.getCcodigopostal().getSestado());						
							Set objMapaConvenios = (Set) objClienteHB.getCconvenios();
							Iterator iteConvenios = objMapaConvenios.iterator();
							CConvenio objConvenio = null;
							List lstFacturasCliente = new ArrayList();
							while (iteConvenios.hasNext()) {
								objConvenio = (CConvenio)iteConvenios.next();
								if (objConvenio.getCtipoconvenio().getCtipoconvenio().intValue() == 22) {
									ConvenioBean objConvenioBean = new ConvenioBean();
									objConvenioBean.setCcliente(objClienteBean.getCcliente());
									objConvenioBean.setCmarca(objClienteBean.getCmarca());
									objConvenioBean.setScliente(objClienteHB.getSrazonsocial());
									objConvenioBean.setSrfc(objClienteHB.getSrfc());
									objConvenioBean.setSdireccion(objClienteHB.getSdireccion() + " " + objClienteHB.getCcodigopostal().getScolonia() + " " + objClienteHB.getCcodigopostal().getSdelegacionmunicipio() + " " + objClienteHB.getCcodigopostal().getSestado());
									objConvenioBean.setCconvenio(objConvenio.getCconvenio());
									objConvenioBean.setCtipoconvenio(objConvenio.getCtipoconvenio().getCtipoconvenio().intValue());
									objConvenioBean.setKconvenio(objConvenio.getCconvenio());
									objConvenioBean.setSconvenio(objConvenio.getSconvenio());
									objConvenioBean.setStipoconvenio(objConvenio.getCtipoconvenio().getCdescripciontipoconvenio());
									Iterator objIteraEConvenio = objConvenio.getEconvenios().iterator();
									while (objIteraEConvenio.hasNext()) {
										EConvenio objEConvenio = (EConvenio)objIteraEConvenio.next();									
										objConvenioBean.setSestadoconvenio(objEConvenio.getCestadoregistro().getSestadoregistro());
										objConvenioBean.setUestadoconvenio(objEConvenio.getCestadoregistro().getCestadoregistro());
										iObjLog.debug("Consulta ClientesDao.buscarCliente...kConvenio " + objEConvenio.getKconvenio());
										objConvenioBean.setSiniciovigencia(new Formatos().getFechaNumeros(objEConvenio.getDinicio()));
										objConvenioBean.setSterminovigencia(new Formatos().getFechaNumeros(objEConvenio.getDtermino()));
										objConvenioBean.setStrvencimiento(getDiasVigentes(objEConvenio.getDinicio(),objEConvenio.getDtermino()));
									}						
									iObjLog.debug("Consulta ClientesDao.buscarCliente:OMRR" + bolBuscarFacturas);
									if (bolBuscarFacturas) {									
										FacturacionMayoreoDao objFacturacionMayoreoDao = new FacturacionMayoreoDao();
										objConvenioBean = objFacturacionMayoreoDao.getFacturasConvenioCxC(objConvenioBean,objClienteParamBean.isBreadonly());									
										if (objConvenioBean.getLstFacturas().size() > 0) {
											intFacturas = (intFacturas + objConvenioBean.getLstFacturas().size());
											objClienteBean.setStrFacturasGrid(objClienteBean.getStrFacturasGrid() + objConvenioBean.getStrFacturasGrid());
										}					
										
										objFacturacionMayoreoDao = null;
									}
									if (objConvenioBean.getLstFacturas().size() > 0) {
										objClienteBean.add(objConvenioBean);
									}
								}
							}							
							objClienteBean.sortLstConvenios();		
							String strPathFOP = "";
							iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  " + bolBuscarFacturas + " Facturas Cliente " + objClienteBean.getLstFacturasCxC().size());
							
							FacturacionMayoreoDao objFacturacionMayoreoDao = new FacturacionMayoreoDao();																		
							objClienteBean.setDblOrdenesNoFacturadas(objFacturacionMayoreoDao.getMontoNOFacturadoCliente(objClienteBean.getCcliente() + ""));		
							objFacturacionMayoreoDao = null;									

							if (bolBuscarFacturas) {									
								if (objClienteBean.getLstFacturasCxC().size() > 0) {
									ReporteEstadoCuentaCxC objReporteEstadoCuentaCxC = new ReporteEstadoCuentaCxC(objClienteBean.getDblOrdenesNoFacturadas(),objClienteBean.getLstFacturasCxC());
									objReporteEstadoCuentaCxC.setCcliente(objClienteBean.getCcliente());
									objReporteEstadoCuentaCxC.setScliente(objClienteBean.getSrazonsocial());
									objReporteEstadoCuentaCxC.setSrfc(objClienteBean.getSrfc());
									objReporteEstadoCuentaCxC.setSdireccion(objClienteHB.getSdireccion() + " " + objClienteHB.getCcodigopostal().getScolonia() + " " + objClienteHB.getCcodigopostal().getSdelegacionmunicipio() + " " + objClienteHB.getCcodigopostal().getSestado());
									objReporteEstadoCuentaCxC.setCconvenio(new Integer(0));
									objReporteEstadoCuentaCxC.setSconvenio("ESTADO DE CUENTA CONCENTRADO");
									objReporteEstadoCuentaCxC.LoadTotales();
									iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  Analisis " + objReporteEstadoCuentaCxC.getLstRowReporteCxC90().size());
									if (objReporteEstadoCuentaCxC.getLstRowReporteCxC90().size() > 0) {
										AdministracionFOP_PDF objAdministracionFOP_PDF = new AdministracionFOP_PDF();
										if (bolCrearReportes) {
											strPathFOP = objAdministracionFOP_PDF.createDocument(objReporteEstadoCuentaCxC.generaFile(), "ReporteCxC_TodosConvenios_Cliente_" + objClienteBean.getCcliente(),objClienteBean.getCmarca());
										} else {
											objClienteBean.setSreport_pages_cxc(objReporteEstadoCuentaCxC.generaPagesforClient());
										}
										objAdministracionFOP_PDF = null;
									}
									objReporteEstadoCuentaCxC = null;
								}					
							}							
							objClienteBean.setStrConvenioGrid(this.showConvenios(objClienteBean.getLstConvenios()));
							if (bolBuscarFacturas) {
								iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  Ruta " + strPathFOP);
								objClienteBean.setStrFacturasGrid(this.showHeaderConvenioFacturas(intFacturas,strPathFOP) + objClienteBean.getStrFacturasGrid() + this.showFooterConvenioFacturas());
							}
							iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  " + objClienteBean.getStrConvenioGrid());
							lstClientesReturn.add(objClienteBean);
						}
					}			
	            }
			iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  " + lstClientesReturn.size());
			return lstClientesReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.buscarClienteCxC: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		
	
	/**
     * Versión 25 de Marzo 2013 
     BY
     */
	
	public List buscarClienteVentas(ClienteBean objClienteParamBean, boolean bolCrearReportes) throws Exception {
		iObjLog.debug("Entrando ClientesDao.buscarClienteCxC:" + objClienteParamBean.toString());
			iObjSesion = HibernateUtil.getSession();
			List lstClientes = new ArrayList();
			List lstClientesReturn = new ArrayList();
			CCliente objClienteHB = new CCliente();; 
			ClienteBean objClienteBean = null;
			Query objQuery = null;
			String strQuery = "";
			boolean bolBuscarFacturas = false;
	    	try{
	            HibernateUtil.beginTrans();
	            if (objClienteParamBean.getCcliente() > 0) {
	        		strQuery =  "select bPF " +					
								" from CCliente bPF " +					
								" where bPF.ccliente = " +  objClienteParamBean.getCcliente();
	        		bolBuscarFacturas = true;
	            } else if ((objClienteParamBean.getSrfc().trim().length() > 0) || (objClienteParamBean.getSrazonsocial().trim().length() > 0) || (objClienteParamBean.getSmnemonico().trim().length() > 0)) {
	        		strQuery =  "select bPF " +					
								" from CCliente bPF " +					
								" where bPF.srfc=bPF.srfc ";	   	        		
					if (objClienteParamBean.getSrazonsocial().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarClienteCxC:Entrando...Razon Social  " +  objClienteParamBean.getSrazonsocial().trim());
						strQuery += " AND bPF.srazonsocial like ('%" + objClienteParamBean.getSrazonsocial().trim() + "%') ";
					}
					if (objClienteParamBean.getSrfc().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarCliente:Entrando...RFC  " +  objClienteParamBean.getSrfc().trim());
						strQuery += " AND bPF.srfc like ('" + objClienteParamBean.getSrfc().trim() + "%') ";
					}
					if (objClienteParamBean.getSmnemonico().trim().length() > 0) {
						iObjLog.debug("Entrando ClientesDao.buscarClienteCxC:Entrando...MNEMONICO  " +  objClienteParamBean.getSmnemonico().trim());
						strQuery += " AND bPF.smnemonico like ('%" + objClienteParamBean.getSmnemonico().trim() + "%') ";
					}
	            } else if (objClienteParamBean.getSobservaciones().trim().length() > 10) {
	        		strQuery =  "select bPF " +					
								" from CCliente bPF " +					
								" where bPF.ccliente in (" +  objClienteParamBean.getSobservaciones().trim() + ")";
	        		bolBuscarFacturas = true;
	            }
	            if (strQuery != "") {
					iObjLog.debug("Consulta ClientesDao.buscarClienteCxC:" + strQuery);
					objQuery = iObjSesion.createQuery(strQuery);
					lstClientes = objQuery.list();
					int intFacturas = 0;
					if(lstClientes != null) {
						for(int inti=0;inti<lstClientes.size();inti++) {
							intFacturas = 0;
							objClienteHB = (CCliente)lstClientes.get(inti);
							objClienteBean = new ClienteBean();
							objClienteBean.setCcliente(objClienteHB.getCcliente().intValue());
							objClienteBean.setCmarca(objClienteHB.getCmarca());
							objClienteBean.setCcodigopostal(objClienteHB.getCcodigopostal().getCcodigopostal().intValue());
							objClienteBean.setCestadoregistro(objClienteHB.getCestadoregistro().getCestadoregistro().intValue());
							objClienteBean.setSestadoregistro(objClienteHB.getCestadoregistro().getSestadoregistro());
							objClienteBean.setCtipocliente(objClienteHB.getCtipocliente().getCtipocliente().intValue());
							objClienteBean.setCgirocliente(objClienteHB.getCgirocliente());
							objClienteBean.setCtipopersona(objClienteHB.getCtipopersona().getCtipopersona().intValue());
							objClienteBean.setSdireccion(objClienteHB.getSdireccion());
							objClienteBean.setSobservaciones(objClienteHB.getSobservaciones());
							objClienteBean.setSrazonsocial(objClienteHB.getSrazonsocial());
							objClienteBean.setSrfc(objClienteHB.getSrfc());
							objClienteBean.setSmnemonico("" + objClienteHB.getSmnemonico());
							objClienteBean.setCcodigopostal(objClienteHB.getCcodigopostal().getCcodigopostal().intValue());
							objClienteBean.setScodigopostal(objClienteHB.getCcodigopostal().getCpostal());
							objClienteBean.setScolonia(objClienteHB.getCcodigopostal().getScolonia());
							objClienteBean.setSdelegacionmunicipio(objClienteHB.getCcodigopostal().getSdelegacionmunicipio());
							objClienteBean.setSestado(objClienteHB.getCcodigopostal().getSestado());						
							Set objMapaConvenios = (Set) objClienteHB.getCconvenios();
							Iterator iteConvenios = objMapaConvenios.iterator();
							CConvenio objConvenio = null;
							List lstFacturasCliente = new ArrayList();
							while (iteConvenios.hasNext()) {
								objConvenio = (CConvenio)iteConvenios.next();
								if (objConvenio.getCtipoconvenio().getCtipoconvenio().intValue() == 22) {
									ConvenioBean objConvenioBean = new ConvenioBean();
									objConvenioBean.setCcliente(objClienteBean.getCcliente());
									objConvenioBean.setCmarca(objClienteBean.getCmarca());
									objConvenioBean.setScliente(objClienteHB.getSrazonsocial());
									objConvenioBean.setSrfc(objClienteHB.getSrfc());
									objConvenioBean.setSdireccion(objClienteHB.getSdireccion() + " " + objClienteHB.getCcodigopostal().getScolonia() + " " + objClienteHB.getCcodigopostal().getSdelegacionmunicipio() + " " + objClienteHB.getCcodigopostal().getSestado());
									objConvenioBean.setCconvenio(objConvenio.getCconvenio());
									objConvenioBean.setCtipoconvenio(objConvenio.getCtipoconvenio().getCtipoconvenio().intValue());
									objConvenioBean.setKconvenio(objConvenio.getCconvenio());
									objConvenioBean.setSconvenio(objConvenio.getSconvenio());
									objConvenioBean.setStipoconvenio(objConvenio.getCtipoconvenio().getCdescripciontipoconvenio());
									Iterator objIteraEConvenio = objConvenio.getEconvenios().iterator();
									while (objIteraEConvenio.hasNext()) {
										EConvenio objEConvenio = (EConvenio)objIteraEConvenio.next();									
										objConvenioBean.setSestadoconvenio(objEConvenio.getCestadoregistro().getSestadoregistro());
										objConvenioBean.setUestadoconvenio(objEConvenio.getCestadoregistro().getCestadoregistro());
										iObjLog.debug("Consulta ClientesDao.buscarCliente...kConvenio " + objEConvenio.getKconvenio());
										objConvenioBean.setSiniciovigencia(new Formatos().getFechaNumeros(objEConvenio.getDinicio()));
										objConvenioBean.setSterminovigencia(new Formatos().getFechaNumeros(objEConvenio.getDtermino()));
										objConvenioBean.setStrvencimiento(getDiasVigentes(objEConvenio.getDinicio(),objEConvenio.getDtermino()));
									}						
									iObjLog.debug("Consulta ClientesDao.buscarCliente:OMRR" + bolBuscarFacturas);
									if (bolBuscarFacturas) {									
										FacturacionMayoreoDao objFacturacionMayoreoDao = new FacturacionMayoreoDao();
										objConvenioBean = objFacturacionMayoreoDao.getFacturasConvenioVentas(objConvenioBean,objClienteParamBean.isBreadonly());									
										if (objConvenioBean.getLstFacturas().size() > 0) {
											intFacturas = (intFacturas + objConvenioBean.getLstFacturas().size());
											objClienteBean.setStrFacturasGrid(objClienteBean.getStrFacturasGrid() + objConvenioBean.getStrFacturasGrid());
										}					
										
										objFacturacionMayoreoDao = null;
									}
									if (objConvenioBean.getLstFacturas().size() > 0) {
										objClienteBean.add(objConvenioBean);
									}
								}
							}							
							objClienteBean.sortLstConvenios();		
							String strPathFOP = "";
							iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  " + bolBuscarFacturas + " Facturas Cliente " + objClienteBean.getLstFacturasCxC().size());
							
							FacturacionMayoreoDao objFacturacionMayoreoDao = new FacturacionMayoreoDao();																		
							objClienteBean.setDblOrdenesNoFacturadas(objFacturacionMayoreoDao.getMontoNOFacturadoCliente(objClienteBean.getCcliente() + ""));		
							objFacturacionMayoreoDao = null;									

							if (bolBuscarFacturas) {									
								if (objClienteBean.getLstFacturasCxC().size() > 0) {
									ReporteEstadoCuentaCxC objReporteEstadoCuentaCxC = new ReporteEstadoCuentaCxC(objClienteBean.getDblOrdenesNoFacturadas(),objClienteBean.getLstFacturasCxC());
									objReporteEstadoCuentaCxC.setCcliente(objClienteBean.getCcliente());
									objReporteEstadoCuentaCxC.setScliente(objClienteBean.getSrazonsocial());
									objReporteEstadoCuentaCxC.setSrfc(objClienteBean.getSrfc());
									objReporteEstadoCuentaCxC.setSdireccion(objClienteHB.getSdireccion() + " " + objClienteHB.getCcodigopostal().getScolonia() + " " + objClienteHB.getCcodigopostal().getSdelegacionmunicipio() + " " + objClienteHB.getCcodigopostal().getSestado());
									objReporteEstadoCuentaCxC.setCconvenio(new Integer(0));
									objReporteEstadoCuentaCxC.setSconvenio("ESTADO DE CUENTA CONCENTRADO");
									objReporteEstadoCuentaCxC.LoadTotales();
									iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  Analisis " + objReporteEstadoCuentaCxC.getLstRowReporteCxC90().size());
									if (objReporteEstadoCuentaCxC.getLstRowReporteCxC90().size() > 0) {
										AdministracionFOP_PDF objAdministracionFOP_PDF = new AdministracionFOP_PDF();
										if (bolCrearReportes) {
											strPathFOP = objAdministracionFOP_PDF.createDocument(objReporteEstadoCuentaCxC.generaFile(), "ReporteCxC_TodosConvenios_Cliente_" + objClienteBean.getCcliente(),objClienteBean.getCmarca());
										} else {
											objClienteBean.setSreport_pages_cxc(objReporteEstadoCuentaCxC.generaPagesforClient());
										}
										objAdministracionFOP_PDF = null;
									}
									objReporteEstadoCuentaCxC = null;
								}					
							}							
							objClienteBean.setStrConvenioGrid(this.showConvenios(objClienteBean.getLstConvenios()));
							if (bolBuscarFacturas) {
								iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  Ruta " + strPathFOP);
								objClienteBean.setStrFacturasGrid(this.showHeaderConvenioFacturas(intFacturas,strPathFOP) + objClienteBean.getStrFacturasGrid() + this.showFooterConvenioFacturas());
							}
							iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  " + objClienteBean.getStrConvenioGrid());
							lstClientesReturn.add(objClienteBean);
						}
					}			
	            }
			iObjLog.debug("Saliendo ClientesDao.buscarClienteCxC...  " + lstClientesReturn.size());
			return lstClientesReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.buscarClienteCxC: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}
	
	private String getProductosCotizadosConvenio(Iterator objInteratorExamenes,Iterator objInteratorPerfiles,Iterator objInteratorClasificacion, int Convenio) {
		iObjLog.debug("Entrando ClientesDao.getProductosCotizadosConvenio:........ Convenio " + Convenio);
		String strProductosConvenios = "";
		EConvenioDetalle objConvenioDetalle = null;
		EConvenioPerfil objConvenioPerfil = null;
		EConvenioClasificacion objConvenioClasificacion = null;
		OrdenExamenBean objExamenBean = new OrdenExamenBean();
		List lstExamenesClasificacion = null;
		ListaExamenUtil objUtilExamen = new ListaExamenUtil();
		OrdenExamenBean objOrdenExamenBean = null;
		ConvenioBean objConvenioBean = new ConvenioBean();		
		try {
			objConvenioBean.setCconvenio(new Integer(Convenio));
			int intCListaPrecio =  this.ListaPreciosConvenio(objConvenioBean);
			
			while (objInteratorExamenes.hasNext()) {
				objConvenioDetalle = (EConvenioDetalle)objInteratorExamenes.next();
//				iObjLog.debug("Contiene ClientesDao.getProductosCotizadosConvenio: x Examen " + objConvenioDetalle.getCexamen().getCexamen().intValue() + " Convenio " + Convenio);
				if (strProductosConvenios == "") {
					strProductosConvenios += objConvenioDetalle.getCexamen().getCexamen().intValue();								
				} else {
					strProductosConvenios += "," + objConvenioDetalle.getCexamen().getCexamen().intValue();								
				}
				objConvenioDetalle = null;
			}
			objInteratorExamenes = null;
			while (objInteratorClasificacion.hasNext()) {
				objConvenioClasificacion = (EConvenioClasificacion)objInteratorClasificacion.next();
//				iObjLog.debug("Contiene ClientesDao.getProductosCotizadosConvenio: x Clasificacion " + objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue()  + " Convenio " + Convenio);
				objExamenBean.setCclasificacioncomercial(objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue());
				objExamenBean.setSexamen("");
				objExamenBean.setStipocomercial("");
				lstExamenesClasificacion = objUtilExamen.getExamenes(objExamenBean, 100,intCListaPrecio,Convenio);
				if (lstExamenesClasificacion != null) {
					if (lstExamenesClasificacion.size() > 0) {
						for (int inti = 0;inti< lstExamenesClasificacion.size();inti++) {
							objOrdenExamenBean = (OrdenExamenBean)lstExamenesClasificacion.get(inti);
//							iObjLog.debug("Contiene ClientesDao.getProductosCotizadosConvenio: x Clasificacion Examen " + objOrdenExamenBean.getCexamen() + " Clasificacion " + objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue()  + " Convenio " + Convenio);
							if (strProductosConvenios == "") {
								strProductosConvenios += objOrdenExamenBean.getCexamen();								
							} else {
								strProductosConvenios += "," + objOrdenExamenBean.getCexamen();								
							}
						}
					}
				}				
				objConvenioClasificacion = null;
			}
			objInteratorClasificacion = null;
			
			
			while (objInteratorPerfiles.hasNext()) {
				objConvenioPerfil = (EConvenioPerfil)objInteratorPerfiles.next();
//				iObjLog.debug("Contiene ClientesDao.getProductosCotizadosConvenio: x Perfil " + objConvenioPerfil.getCperfil().getCperfil().intValue() + " Convenio " + Convenio);
				if (strProductosConvenios == "") {
					strProductosConvenios += objConvenioPerfil.getCperfil().getCperfil().intValue();								
				} else {
					strProductosConvenios += "," + objConvenioPerfil.getCperfil().getCperfil().intValue();								
				}
				objConvenioPerfil = null;
			}
			objInteratorPerfiles = null;		
		} catch (Exception exp) {
			
		}
		return strProductosConvenios;
	}

	public String[] buscarExamenesPerfilesConvenio(int intConvenio) throws Exception {
		iObjLog.debug("Entrando ClientesDao.buscarExamenesConvenio:");
		iObjSesion = HibernateUtil.getSession();
		List lstConvenios = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		EConvenio objInstanciaConvenio = null;
		EConvenioDetalle objConvenioDetalle = null;
		EConvenioPerfil objConvenioPerfil = null;
		Iterator objIterator = null;
		Iterator objIteratorPerfil = null;
		String strReturn[] = new String [4];
		List lstExamenesConvenio = new ArrayList();
		List lstPerfilesConvenio = new ArrayList();
		ExamenConvenioBean objExamenBean = null;
		try{
            HibernateUtil.beginTrans();
    		strQuery =  "select bPF " +					
						" from EConvenio bPF " +					
						" where bPF.cconvenio.cconvenio = " +  intConvenio + " and bPF.cestadoregistro = 22 ";
            objQuery = iObjSesion.createQuery(strQuery);
			lstConvenios = objQuery.list();
			if(lstConvenios != null) {
				strReturn[0] = "";
				strReturn[1] = "";
				strReturn[2] = "";
				strReturn[3] = "";
				for(int inti=0;inti<lstConvenios.size();inti++) {
					objInstanciaConvenio = (EConvenio)lstConvenios.get(inti);
					objIterator = objInstanciaConvenio.getCconvenio().getEconveniodetalles().iterator();
					while (objIterator.hasNext()) {
						objConvenioDetalle = (EConvenioDetalle)objIterator.next();
						objExamenBean = new ExamenConvenioBean(); 
						objExamenBean.setCexamen(objConvenioDetalle.getCexamen().getCexamen().intValue());
						objExamenBean.setSexamen(objConvenioDetalle.getCexamen().getSexamen());
						lstExamenesConvenio.add(objExamenBean);
					}					
					Collections.sort(lstExamenesConvenio);					
					for (int inty=0;inty<lstExamenesConvenio.size();inty++) {
						objExamenBean = (ExamenConvenioBean)lstExamenesConvenio.get(inty);
						if (strReturn[0].trim() == "") {
							strReturn[0] +=  objExamenBean.getSexamen().trim() ;						
							strReturn[1] +=  objExamenBean.getCexamen() ;						
						} else {
							strReturn[0] += "&" + objExamenBean.getSexamen().trim();						
							strReturn[1] += "&" + objExamenBean.getCexamen();						
						}
					}
					objIteratorPerfil = objInstanciaConvenio.getCconvenio().getEconvenioperfils().iterator();
					while (objIteratorPerfil.hasNext()) {
						objConvenioPerfil = (EConvenioPerfil)objIteratorPerfil.next();
						objExamenBean = new ExamenConvenioBean(); 
						objExamenBean.setCexamen(objConvenioPerfil.getCperfil().getCperfil().intValue());
						objExamenBean.setSexamen(objConvenioPerfil.getCperfil().getSperfil());
						lstPerfilesConvenio.add(objExamenBean);
					}					
					Collections.sort(lstPerfilesConvenio);					
					for (int inty=0;inty<lstPerfilesConvenio.size();inty++) {
						objExamenBean = (ExamenConvenioBean)lstPerfilesConvenio.get(inty);
						if (strReturn[2].trim() == "") {
							strReturn[2] +=  objExamenBean.getSexamen().trim() ;						
							strReturn[3] +=  objExamenBean.getCexamen() ;						
						} else {
							strReturn[2] += "&" + objExamenBean.getSexamen().trim();						
							strReturn[3] += "&" + objExamenBean.getCexamen();						
						}
					}
				}			
			}
			iObjLog.debug("Saliendo ClientesDao.buscarConvenio...Nombre Examen  " + strReturn[0]);
			iObjLog.debug("Saliendo ClientesDao.buscarConvenio...Codigo Examen  " + strReturn[1]);
			iObjLog.debug("Saliendo ClientesDao.buscarConvenio...Nombre Perfil  " + strReturn[2]);
			iObjLog.debug("Saliendo ClientesDao.buscarConvenio...Codigo Perfil  " + strReturn[3]);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.buscarConvenio: ", aObjExcepcion);
        	HibernateUtil.closeSession();
			throw aObjExcepcion;
        } finally{
    		lstConvenios = null;
    		objQuery = null;
    		strQuery = "";
    		objInstanciaConvenio = null;
    		objConvenioDetalle = null;
    		objIterator = null;
    		objIteratorPerfil = null;
    		lstExamenesConvenio = null;
    		lstPerfilesConvenio = null;
    		objExamenBean = null;
        	HibernateUtil.closeSession();			
		}		
	}		
	
	public List buscarConvenio(ConvenioBean objConvenioParamBean,String strExamenes) throws Exception {
		iObjLog.debug("Entrando ClientesDao.buscarConvenio:" + objConvenioParamBean.toString());
		iObjSesion = HibernateUtil.getSession();
		List lstConvenios = new ArrayList();
		List lstConveniosReturn = new ArrayList();
		ListaExamenUtil objCotizarExamenes = new ListaExamenUtil();
		CConvenio objConvenioHB = null; 
		ConvenioBean objConvenioBean = null;
		Query objQuery = null;
		String strQuery = "";
		long logFirst = 0;
		long logSecond = 0;
    	try{
            HibernateUtil.beginTrans();
            if (objConvenioParamBean.getCconvenio().intValue() > 0) {
        		strQuery =  "select bPF " +					
							" from CConvenio bPF " +					
							" where bPF.cconvenio = " +  objConvenioParamBean.getCconvenio().intValue();
            } else if (objConvenioParamBean.getSconvenio().trim().length() > 0) {
        		strQuery =  "select bPF " +					
							" from CConvenio bPF " +					
							" where bPF.sconvenio like ('%" + objConvenioParamBean.getSconvenio().trim().toString() + "%') ";	   	        		
            }
    		iObjLog.debug("Consulta ClientesDao.buscarConvenio: " + strQuery);
            objQuery = iObjSesion.createQuery(strQuery);
			lstConvenios = objQuery.list();
			if(lstConvenios != null) {
				String strProductosConvenios = "";
				for(int inti=0;inti<lstConvenios.size();inti++) {
					objConvenioHB = (CConvenio)lstConvenios.get(inti);
					Iterator objIteraEConvenio = objConvenioHB.getEconvenios().iterator();
					objConvenioBean = new ConvenioBean();								
						objConvenioBean.setCcliente(objConvenioHB.getCcliente().getCcliente().intValue());
						objConvenioBean.setCconvenio(objConvenioHB.getCconvenio());						
						objConvenioBean.setScorreoelectronico(objConvenioHB.getScorreoelectronico() + "");
						objConvenioBean.setSpassword(objConvenioHB.getSpassword() + "");
						objConvenioBean.setSpasswordconsulta(objConvenioHB.getSpasswordconsulta() + "");
						if (strExamenes == "") {
							logFirst = System.currentTimeMillis();
							iObjLog.debug("Entrando ClientesDao.buscarConvenio: Clasificacion 1 " + logFirst);
							strProductosConvenios = this.getProductosCotizadosConvenio(((Set) objConvenioHB.getEconveniodetalles()).iterator(), ((Set) objConvenioHB.getEconvenioperfils()).iterator(), ((Set) objConvenioHB.getEconvenioclasificacions()).iterator(),objConvenioHB.getCconvenio().intValue());
							logSecond = System.currentTimeMillis();
							iObjLog.debug("Entrando ClientesDao.buscarConvenio: Clasificacion 2 " + logSecond);							
							iObjLog.debug("Entrando ClientesDao.buscarConvenio: Clasificacion 3 " + (logFirst - logSecond));							
						} else {
							strProductosConvenios = strExamenes;
						}						
						objConvenioBean.setKconvenio(objConvenioHB.getCconvenio());
						objConvenioBean.setSconvenio(objConvenioHB.getSconvenio());
						while (objIteraEConvenio.hasNext()) {
							EConvenio objEConvenio = (EConvenio)objIteraEConvenio.next();
							objConvenioBean.setSestadoconvenio(objEConvenio.getCestadoregistro().getSestadoregistro());
							objConvenioBean.setUestadoconvenio(objEConvenio.getCestadoregistro().getCestadoregistro());
							if (objEConvenio.getDinicio() != null) {
								objConvenioBean.setSiniciovigencia(new Formatos().getFechaNumeros(objEConvenio.getDinicio()));
							} else {
								objConvenioBean.setSiniciovigencia("");
							}
							if (objEConvenio.getDtermino() != null) {
								objConvenioBean.setSterminovigencia(new Formatos().getFechaNumeros(objEConvenio.getDtermino()));
							} else {
								objConvenioBean.setSterminovigencia("");
							}
							if (objEConvenio.getDinicio() != null && objEConvenio.getDtermino() != null) {
								objConvenioBean.setStrvencimiento(getDiasVigentes(objEConvenio.getDinicio(),objEConvenio.getDtermino()));
							} else {
								objConvenioBean.setStrvencimiento("");
							}
//							objConvenioBean.setSiniciovigencia(new Formatos().getFechaNumeros(objEConvenio.getDinicio()));
//							objConvenioBean.setSterminovigencia(new Formatos().getFechaNumeros(objEConvenio.getDtermino()));
						}						
						objConvenioBean.setCtipoconvenio(objConvenioHB.getCtipoconvenio().getCtipoconvenio().intValue());
						objConvenioBean.setStipoconvenio(objConvenioHB.getCtipoconvenio().getCdescripciontipoconvenio());					
						String strClasificacionComercial = "";
						if (objConvenioHB.getEconvenioclasificacions() != null) {
							if (((Set) objConvenioHB.getEconvenioclasificacions()).size() > 0 ) {
								logFirst = System.currentTimeMillis();
								iObjLog.debug("Entrando ClientesDao.buscarConvenio: Clasificacion 1.1 " + logFirst);
								strClasificacionComercial = this.showConveniosClasificacion(((Set) objConvenioHB.getEconvenioclasificacions()).iterator());
								logSecond = System.currentTimeMillis();
								iObjLog.debug("Entrando ClientesDao.buscarConvenio: Clasificacion 2.1 " + logSecond);							
								iObjLog.debug("Entrando ClientesDao.buscarConvenio: Clasificacion 3.1 " + (logFirst - logSecond));							
								objConvenioBean.setCtipodescuento(0);
							} else {
								objConvenioBean.setCtipodescuento(1);							
							}
						} else {
							objConvenioBean.setCtipodescuento(1);														
						}
//						objConvenioBean.setStrDetalleExamenes(strClasificacionComercial + this.showConveniosExamenes(objCotizarExamenes.cotizarProductosConvenio(strProductosConvenios,999, objConvenioBean.getCconvenio().intValue()),objConvenioBean.getCtipoconvenio()));
						objConvenioBean.setStrvencimiento("");
						objConvenioBean.setStrDetalleExamenes(strClasificacionComercial + this.showConveniosExamenes(objCotizarExamenes.cotizarProductosConvenio(strProductosConvenios,999, objConvenioBean.getCconvenio().intValue()),objConvenioBean.getCtipoconvenio()));						
						lstConveniosReturn.add(objConvenioBean);
			        	objConvenioHB = null;
			        	objConvenioBean = null;
				}
				lstConvenios.clear();
				lstConvenios = null;
				strQuery = null;
			}
			iObjLog.debug("Saliendo ClientesDao.buscarConvenio...  ");
			return lstConveniosReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.buscarConvenio: ", aObjExcepcion);
        	HibernateUtil.closeSession();
			throw aObjExcepcion;
        } finally{
        	objConvenioHB = null;
        	objConvenioBean = null;
        	HibernateUtil.closeSession();			
		}		
	}		

	public List buscarConvenioNombreExamen(ConvenioBean objConvenioParamBean,String strExamenes) throws Exception {
		iObjLog.debug("Entrando ClientesDao.buscarConvenioNombreExamen:" + objConvenioParamBean.toString());
		iObjSesion = HibernateUtil.getSession();
		List lstConvenios = new ArrayList();
		List lstConveniosReturn = new ArrayList();
		ListaExamenUtil objCotizarExamenes = new ListaExamenUtil();
		CConvenio objConvenioHB = null; 
		ConvenioBean objConvenioBean = null;
		Query objQuery = null;
		String strQuery = "";
    	try{
            HibernateUtil.beginTrans();
            if (objConvenioParamBean.getCconvenio().intValue() > 0) {
        		strQuery =  "select bPF " +					
							" from CConvenio bPF " +					
							" where bPF.cconvenio = " +  objConvenioParamBean.getCconvenio().intValue();
            } else if (objConvenioParamBean.getSconvenio().trim().length() > 0) {
        		strQuery =  "select bPF " +					
							" from CConvenio bPF " +					
							" where bPF.sconvenio like ('%" + objConvenioParamBean.getSconvenio().trim().toString() + "%') ";	   	        		
            }
            objQuery = iObjSesion.createQuery(strQuery);
			lstConvenios = objQuery.list();
			if(lstConvenios != null) {
				String strProductosConvenios = "";
				for(int inti=0;inti<lstConvenios.size();inti++) {
					objConvenioHB = (CConvenio)lstConvenios.get(inti);
					objConvenioBean = new ConvenioBean();								
						objConvenioBean.setCcliente(objConvenioHB.getCcliente().getCcliente().intValue());
						objConvenioBean.setCconvenio(objConvenioHB.getCconvenio());						
						if (strExamenes == "") {
							iObjLog.debug("Entrando ClientesDao.buscarConvenioNombreExamen: Clasificacion " + objConvenioHB.getEconvenioclasificacions().size());
							strProductosConvenios = this.getProductosCotizadosConvenio(((Set) objConvenioHB.getEconveniodetalles()).iterator(), ((Set) objConvenioHB.getEconvenioperfils()).iterator(), ((Set) objConvenioHB.getEconvenioclasificacions()).iterator(),objConvenioHB.getCconvenio().intValue());
						} else {
							strProductosConvenios = strExamenes;
						}						
			        	HibernateUtil.closeSession();			
//								objConvenioBean.setClistacorporativa(clistacorporativa)
//								objConvenioBean.setCvigencia(cvigencia)
//								objConvenioBean.setDregistro(dregistro)
						objConvenioBean.setKconvenio(objConvenioHB.getCconvenio());
//								objConvenioBean.setScliente(scliente)
						objConvenioBean.setSconvenio(objConvenioHB.getSconvenio());
//								objConvenioBean.setSInicioVigencia(inicioVigencia)
//								objConvenioBean.setSTerminoVigencia(terminoVigencia)
						objConvenioBean.setCtipoconvenio(objConvenioHB.getCtipoconvenio().getCtipoconvenio().intValue());
						objConvenioBean.setStipoconvenio(objConvenioHB.getCtipoconvenio().getCdescripciontipoconvenio());						
						objConvenioBean.setStrDetalleExamenes(this.showConveniosExamenes(objCotizarExamenes.cotizarNombreProductosConvenio(strProductosConvenios,1, objConvenioBean.getCconvenio().intValue()),objConvenioBean.getCtipoconvenio()));						
						objConvenioBean.setCtipodescuento(1);
						lstConveniosReturn.add(objConvenioBean);
			        	objConvenioHB = null;
			        	objConvenioBean = null;
				}
				lstConvenios.clear();
				lstConvenios = null;
				strQuery = null;
			}
			iObjLog.debug("Saliendo ClientesDao.buscarConvenio...  ");
			return lstConveniosReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.buscarConvenio: ", aObjExcepcion);
        	HibernateUtil.closeSession();
			throw aObjExcepcion;
        } finally{
        	objConvenioHB = null;
        	objConvenioBean = null;
		}		
	}		

	
	public List buscarConvenioAdministrador(ConvenioBean objConvenioParamBean,String strExamenes) throws Exception {
		iObjLog.debug("Entrando ClientesDao.buscarConvenioAdministrador:" + objConvenioParamBean.toString() + " : " + strExamenes);
		iObjSesion = HibernateUtil.getSession();
		List lstConvenios = new ArrayList();
		List lstConveniosReturn = new ArrayList();
		ListaExamenUtil objCotizarExamenes = new ListaExamenUtil();
		CConvenio objConvenioHB = null; 
		ConvenioBean objConvenioBean = null;
		Query objQuery = null;
		String strQuery = "";
    	try{
            HibernateUtil.beginTrans();
            if (objConvenioParamBean.getCconvenio().intValue() > 0) {
        		strQuery =  "select bPF " +					
							" from CConvenio bPF " +					
							" where bPF.cconvenio = " +  objConvenioParamBean.getCconvenio().intValue();
            } else if (objConvenioParamBean.getSconvenio().trim().length() > 0) {
        		strQuery =  "select bPF " +					
							" from CConvenio bPF " +					
							" where bPF.sconvenio like ('%" + objConvenioParamBean.getSconvenio().trim().toString() + "%') ";	   	        		
            }
            if (strQuery != "") {
	            objQuery = iObjSesion.createQuery(strQuery);
				lstConvenios = objQuery.list();
				if(lstConvenios != null) {
					String strProductosConvenios = "";
					for(int inti=0;inti<lstConvenios.size();inti++) {
						objConvenioHB = (CConvenio)lstConvenios.get(inti);
						objConvenioBean = new ConvenioBean();								
							objConvenioBean.setCcliente(objConvenioHB.getCcliente().getCcliente().intValue());
							objConvenioBean.setCconvenio(objConvenioHB.getCconvenio());						
							if (strExamenes == "") {
								iObjLog.debug("Entrando ClientesDao.buscarConvenioNombreExamen: Clasificacion " + objConvenioHB.getEconvenioclasificacions().size());
								strProductosConvenios = this.getProductosCotizadosConvenio(((Set) objConvenioHB.getEconveniodetalles()).iterator(), ((Set) objConvenioHB.getEconvenioperfils()).iterator(), ((Set) objConvenioHB.getEconvenioclasificacions()).iterator(),objConvenioHB.getCconvenio().intValue());
							} else {
								strProductosConvenios = strExamenes;
							}						
				        	HibernateUtil.closeSession();			
							objConvenioBean.setKconvenio(objConvenioHB.getCconvenio());
							objConvenioBean.setSconvenio(objConvenioHB.getSconvenio());
							objConvenioBean.setCtipoconvenio(objConvenioHB.getCtipoconvenio().getCtipoconvenio().intValue());
							objConvenioBean.setStipoconvenio(objConvenioHB.getCtipoconvenio().getCdescripciontipoconvenio());												
							List lstExamenes  = objCotizarExamenes.cotizarProductosConvenioAdministrador(strProductosConvenios,objConvenioBean.getCconvenio().intValue());						
							iObjLog.debug("Saliendo ClientesDao.buscarConvenio...Listado de Examenes  " + ((List)lstExamenes.get(0)).size());
							objConvenioBean.setStrDetalleExamenes(this.showConveniosExamenes(((List)lstExamenes.get(0)),((List)lstExamenes.get(1)),objConvenioBean.getCtipoconvenio()));						
							objConvenioBean.setCtipodescuento(1);
							lstConveniosReturn.add(objConvenioBean);
				        	objConvenioHB = null;
				        	objConvenioBean = null;
					}
					lstConvenios.clear();
					lstConvenios = null;
					strQuery = null;
				}
            }
			iObjLog.debug("Saliendo ClientesDao.buscarConvenio...  ");
			return lstConveniosReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.buscarConvenio: ", aObjExcepcion);
        	HibernateUtil.closeSession();
			throw aObjExcepcion;
        } finally{
        	objConvenioHB = null;
        	objConvenioBean = null;
		}		
	}		
	
	
	public String buscarConvenios(ConvenioBean objConvenioParamBean) throws Exception {
		iObjLog.debug("Entrando ClientesDao.buscarConvenios:" + objConvenioParamBean.toString());
		iObjSesion = HibernateUtil.getSession();
		List lstConvenios = new ArrayList();
		List lstConveniosReturn = new ArrayList();
		CConvenio objConvenioHB = null; 
		EConvenio objConvenioEHB = null;
		ConvenioBean objConvenioBean = null;
		Query objQuery = null;
		String strQuery = "";
		String strReturn = "";
    	try{
            HibernateUtil.beginTrans();
            if (objConvenioParamBean.getCconvenio().intValue() > 0) {
        		strQuery =  "select bPF " +					
							" from EConvenio bPF " +					
							" where bPF.cconvenio.cconvenio = " +  objConvenioParamBean.getCconvenio().intValue();
            } else if (objConvenioParamBean.getSconvenio().trim().length() > 0) {
        		strQuery =  "select bPF " +					
							" from EConvenio bPF " +					
							" where bPF.cconvenio.sconvenio like ('%" + objConvenioParamBean.getSconvenio().trim().toString() + "%') ";	   	        		
            } else if (objConvenioParamBean.getCcliente() > 0) {
        		strQuery =  "select bPF " +					
							" from EConvenio bPF " +					
							" where bPF.cconvenio.ccliente.ccliente = " +  objConvenioParamBean.getCcliente();
            }
            strQuery += " order by bPF.cestadoregistro.cestadoregistro,bPF.cconvenio.sconvenio ";
			objQuery = iObjSesion.createQuery(strQuery);
			lstConvenios = objQuery.list();
			if(lstConvenios != null) {
				for(int inti=0;inti<lstConvenios.size();inti++) {
					objConvenioEHB = ((EConvenio)lstConvenios.get(inti));
					objConvenioHB = objConvenioEHB.getCconvenio();
					objConvenioBean = new ConvenioBean();								
						objConvenioBean.setCcliente(objConvenioHB.getCcliente().getCcliente().intValue());
						objConvenioBean.setCconvenio(objConvenioHB.getCconvenio());
						objConvenioBean.setCtipoconvenio(objConvenioHB.getCtipoconvenio().getCtipoconvenio().intValue());
						objConvenioBean.setKconvenio(objConvenioHB.getCconvenio());
						objConvenioBean.setSconvenio(objConvenioHB.getSconvenio());						
						if (objConvenioBean.getDinicio() != null) {
							objConvenioBean.setSiniciovigencia(new Formatos().getFechaNumeros(objConvenioBean.getDinicio()));
						} else {
							objConvenioBean.setSiniciovigencia("");
						}
						if (objConvenioBean.getDtermino() != null) {
							objConvenioBean.setSterminovigencia(new Formatos().getFechaNumeros(objConvenioBean.getDtermino()));
						} else {
							objConvenioBean.setSterminovigencia("");
						}
						if (objConvenioBean.getDinicio() != null && objConvenioBean.getDtermino() != null) {
							objConvenioBean.setStrvencimiento(getDiasVigentes(objConvenioBean.getDinicio(),objConvenioBean.getDtermino()));
						} else {
							objConvenioBean.setStrvencimiento("");
						}
//						objConvenioBean.setSiniciovigencia(new Formatos().getFechaNumeros(objConvenioEHB.getDinicio()));
//						objConvenioBean.setSterminovigencia(new Formatos().getFechaNumeros(objConvenioEHB.getDtermino()));
//						objConvenioBean.setStrvencimiento(getDiasVigentes(objConvenioEHB.getDinicio(),objConvenioEHB.getDtermino()));
						objConvenioBean.setStipoconvenio(objConvenioHB.getCtipoconvenio().getCdescripciontipoconvenio());
						objConvenioBean.setSestadoconvenio(((EConvenio)lstConvenios.get(inti)).getCestadoregistro().getSestadoregistro());
						lstConveniosReturn.add(objConvenioBean);
			        	objConvenioHB = null;
			        	objConvenioBean = null;
				}
				lstConvenios.clear();
				lstConvenios = null;
				strQuery = null;
				strReturn = this.showConvenios(lstConveniosReturn);
				lstConveniosReturn.clear();
				lstConveniosReturn = null;
			}
			iObjLog.debug("Saliendo ClientesDao.buscarConvenios...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.buscarConvenios: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	objConvenioHB = null;
        	objConvenioBean = null;
        	HibernateUtil.closeSession();
		}		
	}		

	public String getNombreConvenio(ConvenioBean objConvenioParamBean) throws Exception {
		iObjLog.debug("Entrando ClientesDao.getNombreConvenio:" + objConvenioParamBean.toString());
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
            if (objConvenioParamBean.getCconvenio().intValue() > 0) {
        		strQuery =  "select cc.* " +					
							" from  C_Convenio cc " +					
							" where cc.cconvenio = " +  objConvenioParamBean.getCconvenio().intValue();
            } else if (objConvenioParamBean.getSconvenio().trim().length() > 0) {
        		strQuery =  "select cc.* " +					
							" from C_Convenio cc " +					
							" where cc.sconvenio like ('%" + objConvenioParamBean.getSconvenio().trim().toString() + "%') ";	   	        		
            }
            if (strQuery != "") {
            	objRst = objStmt.executeQuery(strQuery);
            	while (objRst.next()) {
					strReturn =  objRst.getString("sconvenio");            		
            	}
            }
			iObjLog.debug("Saliendo ClientesDao.getNombreConvenio...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.getNombreConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}		
	
	private String showConvenios(List lstConvenios) throws Exception
	{		
		ConvenioBean objConvenio = new ConvenioBean();
		String strReturn = "";		
		String strJavaScript = "";
		iObjLog.debug("Entrando a ClientesDao.showConvenios:Entrando... ");
		try {
			if (lstConvenios != null) {
				if (lstConvenios.size() > 10) {
					strJavaScript = "style='visibility:hidden;display:none;'";
				}
			}
			 strReturn = ("<table border='0' align='center' style='width: 100%' class='tabla'>" + 
							"<tr>" + 
								"<td align='center' onClick='javascript:ocultarConvenios();' style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href='javascript:ocultarConvenios();' onClick='javascript:ocultarConvenios();' align='bottom' style='font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;'>Total de Convenios " + lstConvenios.size() +
									"</a>" + 
								"</td>" + 
							"</tr>"	+					 
						 "</table>" +	
						  "<div id='gridGridClienteConvenios' " + strJavaScript + ">" +                
						 "<table border='0' align='center' style='width: 100%' class='tabla'>" +
							"<tr>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>#" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Clave" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Nombre del Convenio" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Tipo Convenio" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Estado" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Expiracion" + 
								"</th>" +
							"</tr>");			    
			 if (lstConvenios != null) {
				int y = 0; 
				for (int i = 0; i < lstConvenios.size() ; i++)
				{
					if (y >= 50) {
						break;
					}
					objConvenio = (ConvenioBean)lstConvenios.get(i);						
					y = i + 1;
					strReturn += ("<tr>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											y + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objConvenio.getCconvenio().intValue() + 
										"</a></td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objConvenio.getSconvenio() +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objConvenio.getStipoconvenio() +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:convenioAceptado(" + objConvenio.getCconvenio().intValue() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objConvenio.getSestadoconvenio() +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()'  align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objConvenio.getStrvencimiento()+
										"</a></td>" + 
									 "</tr>");
				}
			}
			strReturn += ("<tr>");
			strReturn += ("		<td>");
			strReturn += ("			<input type='button' id='idNuevoConvenio' value='Nuevo Convenio' onClick='crearNuevoConvenio();' class='boton'>");
			strReturn += ("		</td>");
			strReturn += ("</tr>");
			strReturn += ("</table></div>");
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("ClientesDao.consultaMedicosGrid:Exception....", aObjException);
    	    throw aObjException;
		} 
	}	

	private String showHeaderConvenioFacturas(int lstFacturas, String strEstadoCuentaCliente) throws Exception
	{		
		String strReturn = "";		
		String strJavaScript = "";
		iObjLog.debug("Entrando a ClientesDao.showHeaderConvenioFacturas:Entrando... ");
		try {
			if (lstFacturas > 10) {
				strJavaScript = "style='visibility:hidden;display:none;'";
			}
			if (strEstadoCuentaCliente.trim().length() > 0) {
				 strReturn = ("<table border='0' align='center' style='width: 100%' class='tabla'>" + 
							"<tr>" + 
								"<td align='center' onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios');\" style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios');\" onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios');\" align='bottom' style='font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;'>Total de Facturas " + lstFacturas +
									"</a>" + 
								"</td>" + 
								"<td align='left' style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:abrirVentana('" + strEstadoCuentaCliente + "','SaldoCxC');\" align=\"bottom\" style=\"font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;\">Estado Cuenta Global  "  +  
									"</a>" + 
								"</td>" + 
							"</tr>"	+					 
						 "</table>" +	
						  "<div id='gridGridFacturasConvenios' " + strJavaScript + ">" +                
						 "<table border='0' align='center' style='width: 100%' class='tabla'>");
			} else {				
				 strReturn = ("<table border='0' align='center' style='width: 100%' class='tabla'>" + 
							"<tr>" + 
								"<td align='center' onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios');\" style='font-weight: bold; font-size: medium; color: black; font-style: normal; font-variant: normal;'> " + 
									"<a href=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios');\" onClick=\"javascript:ocultarGridFacturas('gridGridFacturasConvenios');\" align='bottom' style='font-weight: bold; color: black; font-size: medium; font-style: normal; font-variant: normal;'>Total de Facturas " + lstFacturas +
									"</a>" + 
								"</td>" + 
							"</tr>"	+					 
						 "</table>" +	
						  "<div id='gridGridFacturasConvenios' " + strJavaScript + ">" +                
						 "<table border='0' align='center' style='width: 100%' class='tabla'>");
			}
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("ClientesDao.showHeaderConvenioFacturas:Exception....", aObjException);
    	    throw aObjException;
		} 
	}	

	private String showFooterConvenioFacturas() throws Exception
	{		
		iObjLog.debug("Entrando a ClientesDao.showFooterConvenioFacturas:Entrando... ");
		String strFormaPago = "";
		CatalogosPKGCatalogosDao objCatalogosPKGCatalogosDao = new CatalogosPKGCatalogosDao(iObjSesion);
		List retorno = objCatalogosPKGCatalogosDao.obtenAll("TipoPagoFactura",0);
		for( int inti = 0;inti < retorno.size(); inti++) {
        	CTipoPagoFactura objCTipoPagoFactura = (CTipoPagoFactura)retorno.get(inti);
        	strFormaPago  += "<option value='" + objCTipoPagoFactura.getCtipopago() + "'>" + objCTipoPagoFactura.getStipopago() + "</option>";
        }
		
		try {
			String strcomple="<div id='gridPagoGlobal'>" +                							
					"<table border='0' align='center' style='width: 100%' class='tabla'>" +	
					"<tr>"+
						"<td>"+
							"<br><br><br>"+
						"</td>"+
					"</tr>"+
					"<tr>"+
						"<td>"+
					  		"<b>Monto global a pagar:</b>"+ 				
					  	"</td>"+
					  	"<td>"+
					  		"<input type='text' id='txtMontoAPagarTotal' style='background:#E6E6FA' size='6' value='0'>"+ 				
					  	"</td>"+					  		
					"</tr>"+
					"<tr>"+
					  "<td>"+
					  	"<b>Fecha Deposito:</b>"+ 				
					  "</td>"+
					  "<td>"+
						  "<input type='text' id='txtFechaDepositoGlobal' size='12' value='' style='background:#E6E6FA' onKeyup='javascript:agregaDiag(this);' onChange='javascript:this.value=validaFormatoFecha(this.value);validafechafrm(document.frmAdminClientes.txtFechaDepositoGlobal);' onFocus='javascript:validafechafrm(document.frmAdminClientes.txtFechaDepositoGlobal);'/>"+		
						  "<a href='javascript:doNothing()' onclick='javascript:setDateField(document.frmAdminClientes.txtFechaDepositoGlobal); top.newWin =  ventanaNormal('$content.getURI('javascript/calendar.html')','cal','WIDTH=230,HEIGHT=230')>"+
						  	"<img alt='Seleccione una fecha' id='imgFechaDeposito' border='0' src='/web2labportal/images/icono_calend.gif' />"+						  
						  "</a>"+	
					  "</td>"+			
				  "</tr>"+
					  
					"<tr>"+
						"<td>"+
							  "<b>Hora Deposito:</b>"+ 				
						"</td>"+
						"<td>"+
							  	"<select id='selhora' style='background:#E6E6FA'></select>"+
								"<b>:</b>"+
								"<select id='selminutos' style='background:#E6E6FA'></select>"+
								"<b>:</b>"+
								"<select id='selsegundos' style='background:#E6E6FA'></select>"+
						"</td>"+			
					"</tr>"+
				  
				  "<tr>"+
					  "<td>"+
						  "<b>Institucion Deposito:</b>"+ 				
					  "</td>"+
					  "<td>"+
						  "<select id='selTipoPago' style='background:#E6E6FA' >"+	strFormaPago +						  
						  "</select>"+	
					  "</td>"+			
				  "</tr>"+
					  
					"<tr>"+
					"<td>"+
						"<b>Forma de Pago:</b>"+
					"</td>"+
					"<td>"+
						"<select id='selFormaPago' style='width: 120px' style='background:#E6E6FA' align='up'>"+
									"<option value='0'>Seleccionar</option>"+
								    "<option value='1'>01 - Efectivo</option>"+
								    "<option value='2'>02 - Cheque nominativo</option>"+
								   	"<option value='3'>03 - Transferencia electrónica de fondos</option>"+
								   	"<option value='4'>04 - Tarjeta de crédito</option>"+
								   	"<option value='5'>05 - Monedero electrónico</option>"+ 
								   	"<option value='6'>06 - Dinero electrónico</option>"+
								    "<option value='8'>08 - Vales de despensa</option>"+
								   	"<option value='12'>12 - Dación en pago</option>"+
								   	"<option value='13'>13 - Pago por subrogación</option>"+
								   	"<option value='14'>14 - Pago por consignación</option>"+ 
								   	"<option value='15'>15 - Condonación</option>"+
								    "<option value='17'>17 - Compensación</option>"+
								   	"<option value='23'>23 - Novación</option>"+
								   	"<option value='24'>24 - Confusión</option>"+
								   	"<option value='25'>25 - Remisión de deuda</option>"+
								   	"<option value='26'>26 - Prescripción o caducidad</option>"+
								   	"<option value='27'>27 - A satisfacción del acreedor</option>"+
								   	"<option value='28'>28 - Tarjeta de débito</option>"+
								   	"<option value='29'>29 - Tarjeta de servicios</option>"+
								   	"<option value='30'>30 - Aplicación de anticipos</option>"+
								   	"<option value='31'>31 - Intermediario pagos</option>"+
								   	"<option value='99'>99 - Por definir</option>"+
					     "</select>"+
					"</td>"+
					"</tr>"+
					
					"<tr>"+
						"<td>"+
						"</td>"+
						"<td>"+
							"<input type='checkbox' id='chkCrearComplento' onClick='showCheckSustitucion();'>Crear Complemento de Pago"+
						"</td>"+
					"</tr>"+
					"<tr>"+
						"<td>"+
						"</td>"+
						"<td>"+
							"<input type='checkbox' id='chkAgregarOpcionales' onClick='showCamposOpcionales();'>Agregar campos opcionales"+
						"</td>"+
					"</tr>"+
					"<tr>"+
						"<td colspan='2'>"+
							"<div id='divCamposOpcionales' style='display:none'>"+
								"<table border='0' align='center' style='width: 100%' class='tabla'>" +
									"<tr>"+
										"<td>"+
									  		"<b>Rfc del Banco:</b>"+ 				
									  	"</td>"+
									  	"<td>"+
									  		"<input type='text' id='txtRfcBanco' style='background:#E6E6FA' size='30'>"+ 				
									  	"</td>"+					  		
									"</tr>"+
									"<tr>"+
										"<td>"+
									  		"<b>Nombre del Banco:</b>"+ 				
									  	"</td>"+
									  	"<td>"+
									  		"<input type='text' id='txtNombreBanco' style='background:#E6E6FA' size='50'>"+ 				
									  	"</td>"+					  		
									"</tr>"+
									"<tr>"+
										"<td>"+
									  		"<b>Numero de Cuenta/Clabe:</b>"+ 				
									  	"</td>"+
									  	"<td>"+
									  		"<input type='text' id='txtNumCuentaClabe' style='background:#E6E6FA' size='50'>"+ 				
									  	"</td>"+					  		
									"</tr>"+
									"<tr>"+
										"<td>"+
									  		"<b>Numero de Operacion:</b>"+ 				
									  	"</td>"+
									  	"<td>"+
									  		"<input type='text' id='txtNumOperacion' style='background:#E6E6FA' size='50'>"+ 				
									  	"</td>"+					  		
									"</tr>"+
								"</table>" +
							"</div>"+
						"</td>"+
					"</tr>"+
					"<tr>"+
						"<td>"+
						"</td>"+
						"<td>"+
							"<div id='divCheckSustitucion' style='display:none'>"+
								"<input type='checkbox' id='chkAgregarSustitucion' onClick='showCamposSustitucion();'>Sustitucion"+
							"</div>	"+
						"</td>"+
					"</tr>"+
					"<tr>"+
						"<td>"+
							"<input type='hidden' id='hdenkfacturaSustitucion' value=''>"+
							"<input type='hidden' id='hdenUuidSustitucion' value=''>"+
						"</td>"+
						"<td>"+
							"<div id='divCamposSustitucion' style='display:none'>"+
								"<b>Folio interno:</b>"+
								"<input type='text' id='txtUfoliofacturaSustitucion' style='background:#E6E6FA' size='15' disabled>"+
								"<a id='popupBuscar' href='javascript:doNothing()' onclick=\"showSubModalSustitucion();\">"+
									"<img alt='Buscar Sustitucion' id='imgBuscar' border='0' src=\"/web2labportal/images/icoBuscar.png\" width=\"25\" height=\"23\" />"+  
								"</a>"+
							"</div>"+
						"</td>"+
					"</tr>"+
					
				  "<tr>"+
					  "<td>"+
					  "</td>"+
					  "<td>"+
						  "<input type=\"button\" value=\"Registrar Pago\" name=\"Registrar Pago\" class=\"boton\" onclick=\"pagosFacturas();\">"+
					  "</td>"+			
				  "</tr>"+
				"</table>" +	
			"</div>";
			
			
			return  ("</table>"+strcomple+"</div>");
		}catch (Exception aObjException){
    	    iObjLog.error("ClientesDao.showFooterConvenioFacturas:Exception....", aObjException);
    	    throw aObjException;
		} 
	}	
		
	
	private void insertTemporalReporte(List lstConveniosExamenes) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		String strQuery = "";
		Connection objConn = null;
		Statement objStmt = null;
		OrdenExamenBean objExamenConvenioBean = null;
		try {			
			iObjLog.debug("Entrando ClientesDao.insertTemporalReporte  ");
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
			 if (lstConveniosExamenes != null) {
					objStmt.execute("DELETE FROM t_reporte_examen_convenio");
					objStmt.execute("COMMIT;");
					for (int i = 0; i < lstConveniosExamenes.size() ; i++)
					{
						objExamenConvenioBean = (OrdenExamenBean)lstConveniosExamenes.get(i);						
						objStmt.addBatch("insert into t_reporte_examen_convenio values(" + i+1 + "," + 
																						    objExamenConvenioBean.getCexamen() + ",'" + 
																						    objExamenConvenioBean.getSexamen() + "'," +
																						    objExamenConvenioBean.getCperfil() + ",'" + 
																						    objExamenConvenioBean.getSperfil() + "'," +
																						    this.redodedoDouble((objExamenConvenioBean.getMsubtotal() / 1.16)) + "," + 
																						    this.redodedoDouble((objExamenConvenioBean.getMdescuentopromocion() / 1.16)) + "," + 
																						    this.redodedoDouble((objExamenConvenioBean.getMdescuentoempresa() / 1.16)) + "," + 
																						    objExamenConvenioBean.getPdescuentoempresa() + "," +
																						    this.redodedoDouble((objExamenConvenioBean.getMdescuentomedico() / 1.16)) + "," + 
																						    this.redodedoDouble((objExamenConvenioBean.getMfacturaempresa() / 1.16)) + "," + 
																						    this.redodedoDouble((objExamenConvenioBean.getMpagopaciente() / 1.16)) + "," + 
																						    this.redodedoDouble((objExamenConvenioBean.getMtotal() - (objExamenConvenioBean.getMpagopaciente() / 1.16))) + "," + 
																						    objExamenConvenioBean.getMtotal() + "," + 
																						    objExamenConvenioBean.getCclasificacioncomercial() + ",'" + 
																						    objExamenConvenioBean.getSclasificacioncomercial() + "'," + 
																						    objExamenConvenioBean.getCconvenio() + ",'')");						
					}
					objStmt.executeBatch();
					objStmt.execute("COMMIT;");
			 }
			iObjLog.debug("Saliendo ClientesDao.insertTemporalReporte  ");
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.insertTemporalReporte: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}
	
    private double redodedoDouble(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }	
	
	private String showConveniosExamenes(List lstConveniosExamenes,List lstExamenesFueraConvenio,int cTipoConvenio) throws Exception
	{		
		this.insertTemporalReporte(lstConveniosExamenes);
		OrdenExamenBean objExamenConvenioBean = new OrdenExamenBean();
		String strReturn = "";		
		String strContadorHelp = "";
		String strHeader = "";
		int intConvenio = 0;
		iObjLog.debug("Entrando a ClientesDao.showConveniosExamenes:Entrando... " + lstConveniosExamenes.size());
		try {
			 if (lstConveniosExamenes != null) {
				 intConvenio = lstConveniosExamenes.size();
			 }					 
			 if (cTipoConvenio == 21) {
				 // 21;"COPAGO"
				 strHeader = ("<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ Descuento" + 
							  "</th>" + 
							  "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>% Descuento" + 
							  "</th>" + 
							  "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Facturar" + 
							  "</th>" + 
							  "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Pago Paciente" + 
							  "</th>" + 
							  "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total" + 
							  "</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Funciones" + 
								"</th>" + 
							 "</tr>");			    
			 } else if (cTipoConvenio == 22) {
				 // 22;"CREDITO TOTAL"
				 strHeader = ("<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ IVA " + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Facturar s/IVA" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Facturar c/IVA" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Funciones" + 
								"</th>" + 
							 "</tr>");			    
			 } else if (cTipoConvenio == 23) {
				 // 23;"PAGO DE CONTADO CON DESCUENTO"
				 strHeader = ("<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
							    "	<b><font color='black'>% Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Pago Paciente" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Funciones" + 
								"</th>" + 
							 "</tr>");			    
			 } else if (cTipoConvenio == 24) {
				 // 24;"PROMOCION"
				 strHeader = ("<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>% Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Pago Paciente" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Funciones" + 
								"</th>" + 
							 "</tr>");			    
			 }
			 strReturn = ("<table border='0' cellspacing='2' cellpadding='3' width='100%' class='tabla'>" + 
					 		"<tr>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total de Examenes " + intConvenio + strContadorHelp +
								"	</font></b>" +
								"</th>"  + 
							"</tr>" +
						 "</table>" +	
						 "<table border='0' cellspacing='2' cellpadding='3' width='100%' class='tabla'>" +
							"<tr>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Clave Examen" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Nombre del Examen" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ LISTA c/IVA" + 
								"</th>" + strHeader); 			 
			 if (lstConveniosExamenes != null) {
				int y = 0; 
				for (int i = 0; i < lstConveniosExamenes.size() ; i++) {
					objExamenConvenioBean = (OrdenExamenBean)lstConveniosExamenes.get(i);						
					y = i + 1;
					if (intConvenio > 50){
						break;
					}
					if (objExamenConvenioBean.getPdescuentoempresa() == 0.0) { 
						strReturn += 	"<tr>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'>" + 
												objExamenConvenioBean.getCexamen() + 
											"</a></td>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'>" + 
												objExamenConvenioBean.getSexamen() + 
											"</a></td>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'>" + 
												"$ " + this.redodedoDouble2(objExamenConvenioBean.getMsubtotal()) +
											"</a></td>" +
											"<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'>" + 
												"INGRESAR" +   
											 "</a></td>" + 
											 "<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'>" + 
											 	"INGRESAR" +   
											 "</a></td>" + 
											 "<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'>" + 
											 	"INGRESAR" +   
											 "</a></td>" + 
											 "<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'>" + 
											 	"INGRESAR" +   
											 "</a></td>" + 
											 "<td align='center' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: red; font-style: normal; font-variant: normal;'>" + 
											 	"INGRESAR" +   
											 "</a></td>" + 
										 "</tr>";
					} else {
							strReturn += 	("<tr>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												objExamenConvenioBean.getCexamen() + 
											"</a></td>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												objExamenConvenioBean.getSexamen() + 
											"</a></td>" + 
											"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												"$ " + this.redodedoDouble2(objExamenConvenioBean.getMsubtotal()) +
											"</a></td>");
							 double dblMonosinIVACobro = 0.0;
							 if (cTipoConvenio == 21) {
								 // 21;"COPAGO"
								dblMonosinIVACobro = this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente());
								strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												 	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) +
											 "</a></td>" + 
											 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												 	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMfacturaempresa()) +
											 "</a></td>" + 
											 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												 	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
											 "</a></td>" + 
											 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												 	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
											 "</a></td>";
							 } else if (cTipoConvenio == 22) {
								 // 22;"CREDITO TOTAL"
								 dblMonosinIVACobro = this.redodedoDouble2(( objExamenConvenioBean.getMfacturaempresa() - objExamenConvenioBean.getMiva()));
								 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
								 				 	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) + 
								 			  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
							 				 		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMiva()) + 
											  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  		"$ " +this.redodedoDouble2(( objExamenConvenioBean.getMfacturaempresa() - objExamenConvenioBean.getMiva())) +
											  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMfacturaempresa()) +
											  "</a></td>"; 
							 } else if (cTipoConvenio == 23) {
								 // 23;"PAGO DE CONTADO CON DESCUENTO"
								 dblMonosinIVACobro = this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente());
								 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
								 					"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) + 
								 			  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  		this.redodedoDouble2(objExamenConvenioBean.getPdescuentoempresa()) + "%" +
											  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
											  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
											  "</a></td>"; 
							 } else if (cTipoConvenio == 24) {
								 // 24;"PROMOCION"
								 dblMonosinIVACobro = this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente());
								 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												  	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentopromocion()) + 
											  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  		this.redodedoDouble2(objExamenConvenioBean.getPdescuentopromocion()) + "%" +
											  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
											  "</a></td>" + 
											  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
											  "</a></td>"; 
							 }					
							 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											  	"<input type=\"checkbox\" id=\"optEliminarConvenio" + objExamenConvenioBean.getCexamen() + "\" onClick=\"eliminarExamenConvenio(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + "," + dblMonosinIVACobro + ");\"><b>Eliminar</b>" + 
										  "</a></td>" + 
										  "</tr>";													
					}
				}				
			}
			strReturn += ("</table>");
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("ClientesDao.consultaMedicosGrid:Exception....", aObjException);
    	    throw aObjException;
		} 
	}	
	

	private String showConveniosExamenes(List lstConveniosExamenes,int cTipoConvenio) throws Exception
	{		
		this.insertTemporalReporte(lstConveniosExamenes);
		OrdenExamenBean objExamenConvenioBean = new OrdenExamenBean();
		String strReturn = "";		
		String strContadorHelp = "";
		String strHeader = "";
		int intConvenio = 0;
		iObjLog.debug("Entrando a ClientesDao.showConveniosExamenes:Entrando... " + lstConveniosExamenes.size());
		try {
			 if (lstConveniosExamenes != null) {
				 intConvenio = lstConveniosExamenes.size();
			 }					 
			 if (cTipoConvenio == 21) {
				 // 21;"COPAGO"
				 strHeader = ("<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ Descuento" + 
							  "</th>" + 
							  "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>% Descuento" + 
							  "</th>" + 
							  "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Facturar" + 
							  "</th>" + 
							  "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Pago Paciente" + 
							  "</th>" + 
							  "<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total" + 
							  "</th>" + 
							 "</tr>");			    
			 } else if (cTipoConvenio == 22) {
				 // 22;"CREDITO TOTAL"
				 strHeader = ("<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ IVA " + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Facturar s/IVA" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Facturar c/IVA" + 
								"</th>" + 
							 "</tr>");			    
			 } else if (cTipoConvenio == 23) {
				 // 23;"PAGO DE CONTADO CON DESCUENTO"
				 strHeader = ("<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
							    "	<b><font color='black'>% Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Pago Paciente" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total" + 
								"</th>" + 
							 "</tr>");			    
			 } else if (cTipoConvenio == 24) {
				 // 24;"PROMOCION"
				 strHeader = ("<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>$ Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>% Descuento" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Pago Paciente" + 
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total" + 
								"</th>" + 
							 "</tr>");			    
			 }
			 strReturn = ("<table border='0' cellspacing='2' cellpadding='3' width='100%' class='tabla'>" + 
					 		"<tr>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Total de Examenes " + intConvenio + strContadorHelp +
								"	</font></b>" +
								"</th>"  + 
							"</tr>" +
						 "</table>" +	
						 "<table border='0' cellspacing='2' cellpadding='3' width='100%' class='tabla'>" +
							"<tr>" + 
//								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
//								"	<b><font color='black'>#" + 
//								"	</font></b>" +
//								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Clave Examen" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>Nombre del Examen" + 
								"	</font></b>" +
								"</th>" + 
								"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
								"	<b><font color='black'>SubTotal" + 
								"</th>" + strHeader); 			 
			 if (lstConveniosExamenes != null) {
				int y = 0; 
				for (int i = 0; i < lstConveniosExamenes.size() ; i++)
				{
					objExamenConvenioBean = (OrdenExamenBean)lstConveniosExamenes.get(i);						
					y = i + 1;
					if (intConvenio > 50){
						break;
					}
					if (objExamenConvenioBean.getPdescuentoempresa() == 0.0) { 
						strReturn += ("<tr>" + 
								"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
									objExamenConvenioBean.getCexamen() + 
								"</a></td>" + 
								"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
									objExamenConvenioBean.getSexamen() + 
								"</a></td>" + 
								"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
									"$ " + this.redodedoDouble2(objExamenConvenioBean.getMsubtotal()) +
								"</a></td>");
					} else {
						strReturn += ("<tr>" + 
								"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
									objExamenConvenioBean.getCexamen() + 
								"</a></td>" + 
								"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
									objExamenConvenioBean.getSexamen() + 
								"</a></td>" + 
								"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
									"$ " + this.redodedoDouble2(objExamenConvenioBean.getMsubtotal()) +
								"</a></td>");
					}					
										 if (cTipoConvenio == 21) {
											 // 21;"COPAGO"
											if (objExamenConvenioBean.getPdescuentoempresa() == 0.0) { 
												strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																 "$ " +  this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) +
															 "</a></td>" + 
															 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
															 this.redodedoDouble2(objExamenConvenioBean.getPdescuentoempresa()) + "%" +
															 "</a></td>" + 
															 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																 "$ " +this.redodedoDouble2(objExamenConvenioBean.getMfacturaempresa()) +
															 "</a></td>" + 
															 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																 "$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
															 "</a></td>" + 
															 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																 "$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
															 "</a></td>" + 
															 "</tr>";
												
											} else {
												strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																 "$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) +
															 "</a></td>" + 
															 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																 "$ " +this.redodedoDouble2(objExamenConvenioBean.getMfacturaempresa()) +
															 "</a></td>" + 
															 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																 "$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
															 "</a></td>" + 
															 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																 "$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
															 "</a></td>" + 
															 "</tr>";
											}
										 } else if (cTipoConvenio == 22) {
											 // 22;"CREDITO TOTAL"
												if (objExamenConvenioBean.getPdescuentoempresa() == 0.0) { 
													 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
													 				 	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) + 
													 			  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												 				 		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMiva()) + 
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(( objExamenConvenioBean.getMfacturaempresa() - objExamenConvenioBean.getMiva())) +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMfacturaempresa()) +
																  "</a></td>" + 
																  "</tr>";
												} else {
													 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
													 				 	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) + 
													 			  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
												 				 		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMiva()) + 
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(( objExamenConvenioBean.getMfacturaempresa() - objExamenConvenioBean.getMiva())) +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMfacturaempresa()) +
																  "</a></td>" + 
																  "</tr>";
												}
										 } else if (cTipoConvenio == 23) {
											 // 23;"PAGO DE CONTADO CON DESCUENTO"
												if (objExamenConvenioBean.getPdescuentoempresa() == 0.0) { 
													 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
													 				"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) + 
													 			  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  this.redodedoDouble2(objExamenConvenioBean.getPdescuentoempresa()) + "%" +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
																  "</a></td>" + 
																  "</tr>";
												} else {
													 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
													 				"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentoempresa()) + 
													 			  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  this.redodedoDouble2(objExamenConvenioBean.getPdescuentoempresa()) + "%" +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
																  "</a></td>" + 
																  "</tr>";													
												}
										 } else if (cTipoConvenio == 24) {
											 // 24;"PROMOCION"
												if (objExamenConvenioBean.getPdescuentoempresa() == 0.0) { 
													 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																	  	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentopromocion()) + 
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  this.redodedoDouble2(objExamenConvenioBean.getPdescuentopromocion()) + "%" +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:altaExamen(" + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
																  "</a></td>" + 
																  "</tr>";
												} else {
													 strReturn += "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																	  	"$ " +this.redodedoDouble2(objExamenConvenioBean.getMdescuentopromocion()) + 
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  this.redodedoDouble2(objExamenConvenioBean.getPdescuentopromocion()) + "%" +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMpagopaciente()) +
																  "</a></td>" + 
																  "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarExamen(" + objExamenConvenioBean.getKconveniodetalle() + "," + objExamenConvenioBean.getCexamen() + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
																  		"$ " +this.redodedoDouble2(objExamenConvenioBean.getMtotal()) +
																  "</a></td>" + 
																  "</tr>";													
												}
										 }					
				}
			}
//			strReturn += ("<tr>");
//			strReturn += ("		<td>");
//			strReturn += ("			<input type='button' id='idNuevoConvenio' value='Nuevo Convenio' onClick='crearNuevoConvenio();' class='boton'>");
//			strReturn += ("		</td>");
//			strReturn += ("</tr>");
			strReturn += ("</table>");
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("ClientesDao.consultaMedicosGrid:Exception....", aObjException);
    	    throw aObjException;
		} 
	}	
	
	
	
	private String showConveniosClasificacion(Iterator objInteratorClasificacion) throws Exception
	{		
		EConvenioClasificacion objConvenioClasificacion = null;
		String strReturn = "";		
		iObjLog.debug("Entrando a ClientesDao.showConveniosExamenes:Entrando... ");
		try {
			strReturn =("<table border='0' cellspacing='2' cellpadding='3' width='100%' class='tabla'>" +
						"<tr>" + 
						"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
						"	<b><font color='black'>Clave Clasificacion" + 
						"	</font></b>" +
						"</th>" + 
						"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
						"	<b><font color='black'>Nombre Clasificacion" + 
						"	</font></b>" +
						"</th>" + 
						"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
						"	<b><font color='black'>% Descuento" + 
						"</th>"); 
			while (objInteratorClasificacion.hasNext()) {
					objConvenioClasificacion = (EConvenioClasificacion)objInteratorClasificacion.next();
					strReturn += ("<tr>" + 					
									 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarClasificacion(" + objConvenioClasificacion.getKconvenioclasificaion().intValue() + "," + objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue() + ");'  align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
										 	objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue() +
									 "</a></td>" + 
									 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarClasificacion(" + objConvenioClasificacion.getKconvenioclasificaion().intValue() + "," + objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue() + ");'  align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
									 		objConvenioClasificacion.getCclasificacioncomercial().getSclasificacioncomercial() +
									 "</a></td>" + 
									 "<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:actualizarClasificacion(" + objConvenioClasificacion.getKconvenioclasificaion().intValue() + "," + objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue() + ");'  align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
									 		objConvenioClasificacion.getPdescuento().doubleValue() + " %" +
									 "</a></td>" + 
								 "</tr>");
					objConvenioClasificacion = null;
			}
			objInteratorClasificacion = null;
			strReturn += ("</table>");
			return strReturn; 
		}catch (Exception aObjException){
    	    iObjLog.error("ClientesDao.consultaMedicosGrid:Exception....", aObjException);
    	    throw aObjException;
		} 
	}	
	
	public int ListaPreciosConvenio(ConvenioBean objConvenioBean) throws Exception {
		iObjLog.debug("Entrando ClientesDao.ListaPreciosConvenio(ConvenioBean objConvenioBean):Convenio Numero...." + objConvenioBean.getCconvenio());
		iObjSesion = HibernateUtil.getSession();
		List lstConvenios = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		EConvenio objInstanciaConvenio = new EConvenio();
    	try{
            HibernateUtil.beginTrans();
            strQuery =  "select eC " +					
						" from EConvenio eC " +					
						" where eC.cconvenio.cconvenio = " +  objConvenioBean.getCconvenio().intValue();	            
			objQuery = iObjSesion.createQuery(strQuery);
			lstConvenios = objQuery.list();
			if(lstConvenios != null) {
				for(int inti=0;inti<lstConvenios.size();inti++) {
					objInstanciaConvenio = (EConvenio)lstConvenios.get(inti);
				}			
			}
			return objInstanciaConvenio.getClistacorporativa().getClistacorporativa().intValue();
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.ListaPreciosConvenio(ConvenioBean objConvenioBean): ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	lstConvenios.clear();
        	lstConvenios = null;    
        	objQuery = null;
        	objInstanciaConvenio = null;
        	HibernateUtil.closeSession();
		}		
	}
	    		
	public List cotizarConvenio(ConvenioBean objConvenioBean,List OrdenExamenesBeans,boolean bolGrid) throws Exception {
		iObjLog.debug("Entrando ClientesDao.cotizarConvenio(ConvenioBean objConvenioBean,List OrdenExamenesBeans):Convenio Numero...." + objConvenioBean.getCconvenio());
			iObjSesion = HibernateUtil.getSession();
			List lstConvenios = new ArrayList();
			Query objQuery = null;
			String strQuery = "";
			CConvenio objInstanciaConvenio = new CConvenio();
			EConvenio objInstanciaEConvenio = new EConvenio();
			EConvenioDetalle objConvenioDetalle = null;
			EConvenioPerfil objConvenioPerfil = null;
			EConvenioClasificacion objConvenioClasificacion = null;
			List lstExamenReturn = new ArrayList();
			boolean bolConvenioCreditoTotal = false;
			boolean bolConvenioPromocion = false;
			int intExamenesDentroConvenio = 0;
			double dblMontoFacturar = 0.0;			
			double dblCopago = 0.0;
	    	try{
	            HibernateUtil.beginTrans();
        		strQuery =  "select bPF " +					
							" from EConvenio bPF " +					
							" where bPF.cconvenio.cconvenio = " +  objConvenioBean.getCconvenio().intValue();
	            if (strQuery != "") {
	        		iObjLog.debug("Entrando ClientesDao.cotizarConvenio(ConvenioBean objConvenioBean,List OrdenExamenesBeans): Consulta...." + strQuery);
					objQuery = iObjSesion.createQuery(strQuery);
					lstConvenios = objQuery.list();
					if(lstConvenios != null) {
						for(int inti=0;inti<lstConvenios.size();inti++) {
							objInstanciaEConvenio = (EConvenio)lstConvenios.get(inti);
			        		iObjLog.debug("Entrando ClientesDao.cotizarConvenio(ConvenioBean objConvenioBean,List OrdenExamenesBeans): Consulta....Si Existe EConvenio" + objInstanciaEConvenio.getKconvenio());
							objInstanciaConvenio = objInstanciaEConvenio.getCconvenio();
						}
						objConvenioBean.setKconvenio(objInstanciaConvenio.getCconvenio());
						objConvenioBean.setCcliente(objInstanciaConvenio.getCcliente().getCcliente().intValue());
						objConvenioBean.setScliente(objInstanciaConvenio.getCcliente().getSrazonsocial());
						objConvenioBean.setCconvenio(objInstanciaConvenio.getCconvenio());
						objConvenioBean.setSconvenio(objInstanciaConvenio.getSconvenio());
//						objConvenioBean.setClistacorporativa(objInstanciaConvenio.getClistacorporativa().getClistacorporativa().intValue());
						objConvenioBean.setCtipoconvenio(objInstanciaConvenio.getCtipoconvenio().getCtipoconvenio().intValue());
//						objConvenioBean.setCvigencia(objInstanciaConvenio.getCvigencia().getCvigencia().intValue());	
						if (objConvenioBean.getCtipoconvenio() == 22) {
							bolConvenioCreditoTotal = true;
						} else if (objConvenioBean.getCtipoconvenio() == 24) {
							bolConvenioPromocion = true;
						}
						Set objMapaExamenes = (Set) objInstanciaConvenio.getEconveniodetalles();
						Set objMapaClasificacion = (Set) objInstanciaConvenio.getEconvenioclasificacions();
						Set objMapaPerfiles = (Set) objInstanciaConvenio.getEconvenioperfils();
						iObjLog.debug("Consulta ClientesDao.buscarConvenio:... el convenio " + objInstanciaConvenio.getCconvenio() + " mapa tiene examenes " + objMapaExamenes.size());
						iObjLog.debug("Consulta ClientesDao.buscarConvenio:... el convenio " + objInstanciaConvenio.getCconvenio() + " mapa tiene perfiles " + objMapaPerfiles.size());
						iObjLog.debug("Consulta ClientesDao.buscarConvenio:... el convenio " + objInstanciaConvenio.getCconvenio() + " mapa tiene clasificacion " + objMapaClasificacion.size());
						for(int inti=0;inti<OrdenExamenesBeans.size();inti++) {
							OrdenExamenBean objExamenBean = new OrdenExamenBean();
							objExamenBean = (OrdenExamenBean)OrdenExamenesBeans.get(inti);
							if (objConvenioBean.getCtipoconvenio() == 24 && objExamenBean.isBolListaPublico() == false) {
								// No se debe cotizar para Publico este examen
							} else {							
								/********************************************** Inicio E_Convenio_Detalle ********************************/
								Iterator objInteratorExamenes = objMapaExamenes.iterator();	
								while (objInteratorExamenes.hasNext()) {
									objConvenioDetalle = (EConvenioDetalle)objInteratorExamenes.next();
	//								iObjLog.debug("Consulta ClientesDao.buscarConvenio:... Examen " + objConvenioDetalle.getCexamen().getCexamen().intValue() + " Convenio " + objConvenioDetalle.getCconvenio().getCconvenio().intValue());								
									if ((objConvenioDetalle.getCexamen().getCexamen().intValue() == objExamenBean.getCexamen()) && 
										(objConvenioDetalle.getCconvenio().getCconvenio().intValue() == objConvenioBean.getCconvenio().intValue()) && (objExamenBean.getCperfil() == -1 ) &&
										(objConvenioDetalle.getCestadoregistro() != 50)) {
										iObjLog.debug("Consulta ClientesDao.buscarConvenio:... Examen encontre " + objConvenioDetalle.getCexamen().getCexamen().intValue() + " Convenio " + objConvenioDetalle.getCconvenio().getCconvenio().intValue() +
												" Precio del Detalle " + objConvenioDetalle.getMpreciofacturarconiva().doubleValue());																	
	//									objExamenBean.setMsubtotal(new BigDecimal(dblPrecioPerfil));
										objExamenBean.setCconvenio(objConvenioDetalle.getCconvenio().getCconvenio().intValue());
										if (objConvenioBean.getCtipoconvenio() == 21) {
											/*****************COPAGO*******************/
											iObjLog.debug("Consulta ClientesDao.cotizarConvenio:... Copago " + objInstanciaEConvenio.getMcopago() + " " + objInstanciaEConvenio.getPcopago() + " " + objInstanciaEConvenio.isBcopagopaciente() + " " + objInstanciaConvenio.getCconvenio());								
											objExamenBean.setKconveniodetalle(objConvenioDetalle.getKconveniodetalle());
											objExamenBean.setMdescuentomedico(0.0);
											objExamenBean.setMdescuentopromocion(0.0);
											objExamenBean.setPdescuentomedico(0.0);
											objExamenBean.setPdescuentopromocion(0.0);
											if (objInstanciaEConvenio.isBcopagopaciente()) {
												/*****************COPAGO APLICAR AL PACIENTE*******************/
													if (objInstanciaEConvenio.getPcopago().doubleValue() > 0) {
														/*****************COPAGO POR PORCENTAJE OK*******************/												
														objExamenBean.setMfacturaempresa(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() *  (1-(objInstanciaEConvenio.getPcopago().doubleValue() /100.0))));
														objExamenBean.setPdescuentoempresa(objConvenioDetalle.getPdescuento().doubleValue());
														objExamenBean.setMiva(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() - objConvenioDetalle.getMpreciofacturarsiniva().doubleValue());
														objExamenBean.setMpagopaciente(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() *  (objInstanciaEConvenio.getPcopago().doubleValue() /100.0))); 
														objExamenBean.setMtotal(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue()));							
													} else {
														/*****************COPAGO POR MONTO *******************/
														intExamenesDentroConvenio++;
														objExamenBean.setMfacturaempresa(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue()));
														objExamenBean.setPdescuentoempresa(objConvenioDetalle.getPdescuento().doubleValue());
														objExamenBean.setMiva(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() - objConvenioDetalle.getMpreciofacturarsiniva().doubleValue());
														objExamenBean.setMpagopaciente(objInstanciaEConvenio.getMcopago().doubleValue()); 
														objExamenBean.setMtotal(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue()));							
														dblMontoFacturar = (dblMontoFacturar + this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue()));
														dblCopago = (objInstanciaEConvenio.getMcopago().doubleValue());
													}
											} else {
												/*****************COPAGO APLICAR A LA EMPRESA*******************/
													if (objInstanciaEConvenio.getPcopago().doubleValue() > 0) {
														/*****************COPAGO POR PORCENTAJE OK*******************/												
														objExamenBean.setMfacturaempresa(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() *  (objInstanciaEConvenio.getPcopago().doubleValue() /100.0)));
														objExamenBean.setPdescuentoempresa(objConvenioDetalle.getPdescuento().doubleValue());
														objExamenBean.setMiva(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() - objConvenioDetalle.getMpreciofacturarsiniva().doubleValue());
														objExamenBean.setMpagopaciente(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() *  (1-(objInstanciaEConvenio.getPcopago().doubleValue() /100.0)))); 
														objExamenBean.setMtotal(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue()));							
													} else {
														/*****************COPAGO POR MONTO *******************/
														objExamenBean.setMfacturaempresa(0.0);
														objExamenBean.setPdescuentoempresa(objConvenioDetalle.getPdescuento().doubleValue());
														objExamenBean.setMiva(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() - objConvenioDetalle.getMpreciofacturarsiniva().doubleValue());
														objExamenBean.setMpagopaciente(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue())); 
														objExamenBean.setMtotal(this.redodedoDouble(objConvenioDetalle.getMpreciofacturarconiva().doubleValue()));							
													}
											}
										} else if (objConvenioBean.getCtipoconvenio() == 22) {
											/*****************CREDITO TOTAL*******************/
											objExamenBean.setKconveniodetalle(objConvenioDetalle.getKconveniodetalle());
											objExamenBean.setMdescuentoempresa(objExamenBean.getMsubtotal() - objConvenioDetalle.getMpreciofacturarconiva().doubleValue());
											objExamenBean.setMdescuentomedico(0.0);
											objExamenBean.setMdescuentopromocion(0.0);
											objExamenBean.setMfacturaempresa(objConvenioDetalle.getMpreciofacturarconiva().doubleValue());
											objExamenBean.setPdescuentoempresa(objConvenioDetalle.getPdescuento().doubleValue());
											objExamenBean.setPdescuentomedico(0.0);
											objExamenBean.setPdescuentopromocion(0.0);
											objExamenBean.setMiva(objConvenioDetalle.getMpreciofacturarconiva().doubleValue() - objConvenioDetalle.getMpreciofacturarsiniva().doubleValue());
											objExamenBean.setMpagopaciente(0.0);
											objExamenBean.setMtotal(objExamenBean.getMfacturaempresa());							
											iObjLog.debug("Consulta ClientesDao.buscarConvenio:... ExamenBean encontre " + objExamenBean.getCexamen() + " Convenio " + objExamenBean.getCconvenio() +
													" Precio del Detalle " + objExamenBean.getMfacturaempresa());																		
										} else if ((objConvenioBean.getCtipoconvenio() == 23) || (objConvenioBean.getCtipoconvenio() == 24)) {
											/*****************PAGO DE CONTADO CONVENIO Y PROMOCION*******************/
	//										iObjLog.debug("Consulta ClientesDao.buscarConvenio:... Examen Codigo OMRR " + objExamenBean.getCexamen() + " Boolean " + objExamenBean.isBolListaPublico() );																		
	//										if ((objExamenBean.isBolListaPublico() == true && (objConvenioBean.getCtipoconvenio() == 24)) || (objConvenioBean.getCtipoconvenio() == 23)) {  
													double valor = ((objExamenBean.getMsubtotal() * objConvenioDetalle.getPdescuento().doubleValue())/100);
													int numero = (int)(valor * 100); 
													valor = numero/100; 
													objExamenBean.setKconveniodetalle(objConvenioDetalle.getKconveniodetalle());
													objExamenBean.setMdescuentomedico(0.0);
													objExamenBean.setMfacturaempresa(0.0);
													switch (objConvenioBean.getCtipoconvenio()) {
														case 23: {
															objExamenBean.setMdescuentoempresa(valor);
															objExamenBean.setMdescuentopromocion(0.0);
															
															objExamenBean.setPdescuentoempresa(objConvenioDetalle.getPdescuento().doubleValue());
															objExamenBean.setPdescuentomedico(0.0);
															objExamenBean.setPdescuentopromocion(0.0);
															break;
														}
														case 24: {
															objExamenBean.setMdescuentoempresa(0.0);
															objExamenBean.setMdescuentopromocion(valor);
			
															objExamenBean.setPdescuentoempresa(0.0);
															objExamenBean.setPdescuentomedico(0.0);
															objExamenBean.setPdescuentopromocion(objConvenioDetalle.getPdescuento().doubleValue());
															break;
														}
													}
													double valorTotal = (objExamenBean.getMsubtotal() - (objExamenBean.getMdescuentoempresa() + objExamenBean.getMdescuentopromocion()));
													int numeroTotal = (int)(valorTotal * 100); 
													valorTotal = numeroTotal/100; 
			//										valorTotal = numeroTotal/100.0; Si quiero 2 decimales
													objExamenBean.setMpagopaciente(valorTotal);
													objExamenBean.setMtotal(objExamenBean.getMpagopaciente());							
													objExamenBean.setMiva(objExamenBean.getMpagopaciente() - (objExamenBean.getMpagopaciente() / 1.16));										
													if (objExamenBean.getCconvenio() == 0) {
														objExamenBean.setMdescuentoempresa(0.0);
														objExamenBean.setMdescuentopromocion(0.0);
														objExamenBean.setMsubtotal(objExamenBean.getMpagopaciente());
													}										
	//										} else {
	//											bolConvenioPromocion = false;
	//										}
										}
										break;
									}								
								}
								objInteratorExamenes = null;
								/********************************************** Fin E_Convenio_Detalle ********************************/
	
								/********************************************** Inicio E_Convenio_Clasificacion ********************************/
								Iterator objInteratorClasificacion = objMapaClasificacion.iterator();	
								while (objInteratorClasificacion.hasNext()) {
									objConvenioClasificacion = (EConvenioClasificacion)objInteratorClasificacion.next();
	//								iObjLog.debug("Consulta ClientesDao.buscarConvenio:... Examen " + objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue() + 
	//										" Examen " + objExamenBean.getCexamen() + " Clasificacion " + objExamenBean.getCclasificacioncomercial());								
									if ((objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue()  == objExamenBean.getCclasificacioncomercial()) && 
										(objConvenioClasificacion.getCconvenio().getCconvenio().intValue() == objConvenioBean.getCconvenio().intValue()) && (objExamenBean.getCperfil() == -1 )) {
										iObjLog.debug("Consulta ClientesDao.buscarConvenio:... Examen " + objConvenioClasificacion.getCclasificacioncomercial().getCclasificacioncomercial().intValue() + 
										" Examen " + objExamenBean.getCexamen() + " Clasificacion " + objExamenBean.getCclasificacioncomercial());								
	//									objExamenBean.setMsubtotal(new BigDecimal(dblPrecioPerfil));
										objExamenBean.setCconvenio(objConvenioClasificacion.getCconvenio().getCconvenio().intValue());
										if (objConvenioBean.getCtipoconvenio() == 21) {
											/*****************COPAGO*******************/
	//										objExamenBean.setMfacturaempresa(0.0);
	//										objExamenBean.setMiva(new BigDecimal(dblPrecioPerfil - (dblPrecioPerfil / 1.16)));
	//										objExamenBean.setMpagopaciente(new BigDecimal(dblPrecioPerfil));
	//										objExamenBean.setMtotal(new BigDecimal(dblPrecioPerfil));							
										} else if (objConvenioBean.getCtipoconvenio() == 22) {
											/*****************CREDITO TOTAL*******************/
											double valor = ((objExamenBean.getMsubtotal() * objConvenioClasificacion.getPdescuento().doubleValue())/100);
											int numero = (int)(valor * 100.0); 
											valor = numero/100.0; 										
											objExamenBean.setMdescuentoempresa(valor);
											objExamenBean.setMdescuentomedico(0.0);
											objExamenBean.setMdescuentopromocion(0.0);
											objExamenBean.setMfacturaempresa((objExamenBean.getMsubtotal() - objExamenBean.getMdescuentoempresa()));
											objExamenBean.setPdescuentoempresa(objConvenioClasificacion.getPdescuento().doubleValue());
											objExamenBean.setPdescuentomedico(0.0);
											objExamenBean.setPdescuentopromocion(0.0);
											objExamenBean.setMiva(0.0);
											objExamenBean.setMpagopaciente(0.0);
											objExamenBean.setMtotal(objExamenBean.getMfacturaempresa());							
										} else if ((objConvenioBean.getCtipoconvenio() == 23) || (objConvenioBean.getCtipoconvenio() == 24)) {
											/*****************PAGO DE CONTADO CONVENIO Y PROMOCION*******************/
	//										iObjLog.debug("Consulta ClientesDao.buscarConvenio:... Examen Codigo OMRR " + objExamenBean.getCexamen() + " Boolean " + objExamenBean.isBolListaPublico() );																		
	//										if ((objExamenBean.isBolListaPublico() == true && (objConvenioBean.getCtipoconvenio() == 24)) || (objConvenioBean.getCtipoconvenio() == 23)) {  
													double valor = ((objExamenBean.getMsubtotal() * objConvenioClasificacion.getPdescuento().doubleValue())/100);
													int numero = (int)(valor * 100); 
													valor = numero/100; 
													objExamenBean.setMdescuentomedico(0.0);
													objExamenBean.setMfacturaempresa(0.0);
													switch (objConvenioBean.getCtipoconvenio()) {
														case 23: {
															objExamenBean.setMdescuentoempresa(valor);
															objExamenBean.setMdescuentopromocion(0.0);
															
															objExamenBean.setPdescuentoempresa(objConvenioClasificacion.getPdescuento().doubleValue());
															objExamenBean.setPdescuentomedico(0.0);
															objExamenBean.setPdescuentopromocion(0.0);
															break;
														}
														case 24: {
															objExamenBean.setMdescuentoempresa(0.0);
															objExamenBean.setMdescuentopromocion(valor);
															objExamenBean.setPdescuentoempresa(0.0);
															objExamenBean.setPdescuentomedico(0.0);
															objExamenBean.setPdescuentopromocion(objConvenioClasificacion.getPdescuento().doubleValue());
															break;
														}
													}
													double valorTotal = (objExamenBean.getMsubtotal() - (objExamenBean.getMdescuentoempresa() + objExamenBean.getMdescuentopromocion()));
													int numeroTotal = (int)(valorTotal * 100); 
													valorTotal = numeroTotal/100; 
			//										valorTotal = numeroTotal/100.0; Si quiero 2 decimales
													objExamenBean.setMpagopaciente(valorTotal);
													objExamenBean.setMtotal(objExamenBean.getMpagopaciente());							
													objExamenBean.setMiva((objExamenBean.getMpagopaciente() - (objExamenBean.getMpagopaciente() / 1.16)));										
													if (objExamenBean.getCconvenio() == 0) {
														objExamenBean.setMdescuentoempresa(0.0);
														objExamenBean.setMdescuentopromocion(0.0);
														objExamenBean.setMsubtotal(objExamenBean.getMpagopaciente());
													}		
	//										} else {
	//											bolConvenioPromocion = false;											
	//										}
										}
										break;
									}								
								}
								objInteratorClasificacion = null;
								/********************************************** Fin E_Convenio_Clasificacion ********************************/
								if (objExamenBean.getCperfil() > -1) {
									Iterator objInteratorPerfiles = objMapaPerfiles.iterator();	
									while (objInteratorPerfiles.hasNext()) {
										objConvenioPerfil = (EConvenioPerfil)objInteratorPerfiles.next();
	//									iObjLog.debug("Consulta ClientesDao.buscarConvenio:...I Perfil " + objConvenioPerfil.getCperfil().getCperfil().intValue() + " Nombre " + objConvenioPerfil.getCperfil().getSperfil() + " Convenio " + objConvenioDetalle.getCconvenio().getCconvenio().intValue());								
										if ((objConvenioPerfil.getCperfil().getCperfil().intValue() == objExamenBean.getCperfil()) && 
											(objConvenioPerfil.getCconvenio().getCconvenio().intValue() == objConvenioBean.getCconvenio().intValue()) && (objExamenBean.getCperfil() > -1 )) {
	//										iObjLog.debug("Consulta ClientesDao.buscarConvenio:...II Perfil " + objConvenioPerfil.getCperfil().getCperfil().intValue() + " Nombre " + objConvenioPerfil.getCperfil().getSperfil() + " Convenio " + objConvenioDetalle.getCconvenio().getCconvenio().intValue());								
		//									objExamenBean.setMsubtotal(new BigDecimal(dblPrecioPerfil));
											objExamenBean.setCconvenio(objConvenioPerfil.getCconvenio().getCconvenio().intValue());
											if (objConvenioBean.getCtipoconvenio() == 22) {
												/*****************CREDITO TOTAL*******************/
												objExamenBean.setMdescuentoempresa(0.0);
												objExamenBean.setMdescuentomedico(0.0);
												objExamenBean.setMdescuentopromocion(0.0);
												objExamenBean.setMfacturaempresa((objExamenBean.getMsubtotal() - objExamenBean.getMdescuentoempresa()));
												objExamenBean.setMiva(0.0);
												objExamenBean.setMpagopaciente(0.0);
												objExamenBean.setMtotal(objExamenBean.getMfacturaempresa());																		
											}
											objExamenBean.setPdescuentoempresa(0.0);
											objExamenBean.setPdescuentomedico(0.0);
											objExamenBean.setPdescuentopromocion(0.0);																					
											break;
										}								
									}
									objInteratorPerfiles = null;
								}							
								/* Unicamente se anexan los examenes que cumplen con el convenio o promocion */
	//							if ((!((objExamenBean.getCconvenio() == 0) && (bolConvenioCreditoTotal == true))) && (!((objConvenioBean.getCtipoconvenio() == 23 || objConvenioBean.getCtipoconvenio() == 24) && (bolConvenioPromocion == false)))) {
								if (!((objExamenBean.getCconvenio() == 0) && (bolConvenioCreditoTotal == true))) {
									if (((objConvenioBean.getCtipoconvenio() == 24 || objConvenioBean.getCtipoconvenio() == 21)) && (objExamenBean.getCperfil() > -1) && (objExamenBean.getSperfil().startsWith("PAQUETE"))) {									
										iObjLog.debug("El nombre del Perfil es  " + (objExamenBean.getSperfil().trim().toUpperCase()) + " " + (objExamenBean.getSperfil().trim().toUpperCase().compareTo("PAQUETE")));
									} else {
										iObjLog.debug("El codigo del Perfil es  " + (objExamenBean.getCperfil()) + " " + (objExamenBean.getSperfil().trim().toUpperCase().compareTo("PAQUETE")));
										iObjLog.debug("El nombre del Perfil es  " + (objExamenBean.getSperfil().trim().toUpperCase()) + " " + (objExamenBean.getSperfil().trim().toUpperCase().compareTo("PAQUETE")));
										lstExamenReturn.add(objExamenBean);								
									}
								}
								objExamenBean = null;
							}
						}
						if (objConvenioBean.getCtipoconvenio() == 21) {
							if (objInstanciaEConvenio.isBcopagopaciente()) {
								if (objInstanciaEConvenio.isBcopagopaciente()) {
									if (objInstanciaEConvenio.getMcopago().doubleValue() > 0.0) {							
										if (dblMontoFacturar >= dblCopago) {
											OrdenExamenBean objExamenCopagoBean = null;
											for(int inty=0;inty<lstExamenReturn.size();inty++) {
												objExamenCopagoBean = (OrdenExamenBean)lstExamenReturn.get(inty);
												if (objExamenCopagoBean.getMpagopaciente() > 0) {
													objExamenCopagoBean.setMpagopaciente(this.redodedoDouble(objExamenCopagoBean.getMpagopaciente() / intExamenesDentroConvenio));
													objExamenCopagoBean.setMfacturaempresa(this.redodedoDouble(objExamenCopagoBean.getMfacturaempresa() - objExamenCopagoBean.getMpagopaciente()));
												}											
											}
										}
									}
								}
							}
						}						
					}			
	            }
			iObjLog.debug("Saliendo ClientesDao.cotizarConvenio(ConvenioBean objConvenioBean,List OrdenExamenesBeans)...  " + lstConvenios.size());
			return lstExamenReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.cotizarConvenio(ConvenioBean objConvenioBean,List OrdenExamenesBeans): ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	lstConvenios.clear();
        	lstConvenios = null;
    
        	objQuery = null;
        	objInstanciaConvenio = null;
        	HibernateUtil.closeSession();
		}		
	}			
	
	public String getDiasVigentes(Date dIniciaVigenciaConvenio,Date dVigenciaConvenio) throws Exception 
	{
		long idiasvigentes;
		java.util.Date dHoy = new Date();
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; 
		try{			
			idiasvigentes = ((dIniciaVigenciaConvenio.getTime() - dHoy.getTime())/ MILLSECS_PER_DAY);
			if (idiasvigentes < 1) {			
				idiasvigentes = ((dVigenciaConvenio.getTime() - dHoy.getTime())/ MILLSECS_PER_DAY);
				if (idiasvigentes<0) {
					return " EXPIRADO " + idiasvigentes;				
				} else {
					return " DIAS " + idiasvigentes;
				}
			} else {
				idiasvigentes = ((dHoy.getTime() - dIniciaVigenciaConvenio.getTime())/ MILLSECS_PER_DAY);
				return " FALTAN " + idiasvigentes;				
			}
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ClientesDao.borrarPorcentajeClasificacionConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
		} 	
	}
	
	public CConvenio getConvenio(int cconvenio) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		String strQuery = "";
		CConvenio objConvenio=null;
		List lstConvenio = new ArrayList();
		Query objQuery = null;
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta DatosFacturaDao.getConvenio:");
			if (cconvenio > 0) {
        		strQuery =  "select cc " +					
							" from  CConvenio cc " +					
							" where cc.cconvenio = " +  cconvenio;
            }
			objQuery = iObjSesion.createQuery(strQuery);
			lstConvenio = objQuery.list();
			if(lstConvenio != null) {
				if (lstConvenio.size() > 0) {
					objConvenio = (CConvenio)lstConvenio.get(0);
				}
			}
			
			iObjLog.debug("Saliendo CleintesNewDao.getConvenio  " + objConvenio.toString());
			return objConvenio;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DatosFacturaDao.getConvenio: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
    private double redodedoDouble2(double nD) {
		return Math.round(nD*Math.pow(10,2))/Math.pow(10,2);      	
    }
	
}

