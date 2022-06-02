package mx.com.web2lab.backend.dao.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.com.web2lab.backend.beans.comer.ConvenioBean;
import mx.com.web2lab.backend.beans.comer.MedicoBean;
import mx.com.web2lab.backend.beans.facturacion.BuscarOrdenesViajeBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.util.Formatos;
import mx.com.web2lab.backend.util.ToolArchivosSO;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;

import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConsultaOrdenesDao {

	private static Log iObjLog = LogFactory.getLog(ConsultaOrdenesDao.class);
	    
	private Session iObjSesion = null;

    private Formatos formatos = new Formatos();                                    

	public ConsultaOrdenesDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public String buscarOrdenesConvenios(ConvenioBean objConvenioParamBean,String strFechaIni,String strFechaFin) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesConvenios:" + objConvenioParamBean.toString());
		String strReturn = "";
    	try{
    		strReturn =  "		and tos.cconvenio = " + objConvenioParamBean.getCconvenio().intValue() + "				";
    		strReturn = this.buscarOrdenes(strReturn, strFechaIni, strFechaFin,"order by spaciente");
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesConvenios: ", aObjExcepcion);
			throw aObjExcepcion;
        }		
	}

	public BuscarOrdenesViajeBean buscarOrdenesViaje(BuscarOrdenesViajeBean objBuscarOrdenesViajeBean) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesViaje:");
		String strReturn = "";
    	try{
    		objBuscarOrdenesViajeBean.setStrorderby("order by cc.cconvenio,tos.kordensucursal");
    		objBuscarOrdenesViajeBean = this.buscarOrdenesViajeCreate(objBuscarOrdenesViajeBean);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        }		
		return objBuscarOrdenesViajeBean;
	}

	public BuscarOrdenesViajeBean buscarOrdenesViajeNewIndividual(BuscarOrdenesViajeBean objBuscarOrdenesViajeBean) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesViaje:");
		String strReturn = "";
    	try{
    		objBuscarOrdenesViajeBean.setStrorderby("order by cc.cconvenio,tos.kordensucursal");
    		objBuscarOrdenesViajeBean = this.buscarOrdenesViajeCreateNewIndividual(objBuscarOrdenesViajeBean);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        }		
		return objBuscarOrdenesViajeBean;
	}
	public BuscarOrdenesViajeBean buscarOrdenesViajeNewPaciente(BuscarOrdenesViajeBean objBuscarOrdenesViajeBean,int kpaciente) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesViaje:");
		String strReturn = "";
    	try{
    		objBuscarOrdenesViajeBean.setStrorderby("order by cc.cconvenio,tos.kordensucursal");
    		objBuscarOrdenesViajeBean = this.buscarOrdenesViajeCreateNewPaciente(objBuscarOrdenesViajeBean,kpaciente);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        }		
		return objBuscarOrdenesViajeBean;
	}


	
	public String buscarOrdenesConvenioPaciente(ConvenioBean objConvenioParamBean,String strFechaIni,String strFechaFin, int kPaciente) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesConvenios:" + objConvenioParamBean.toString());
		String strReturn = "";
    	try{
    		strReturn =  "		and tos.cconvenio = " + objConvenioParamBean.getCconvenio().intValue() + "	and tos.kpaciente = " + kPaciente + "			";
    		strReturn = this.buscarOrdenes(strReturn, strFechaIni, strFechaFin,"order by indexkadmision,csucursal,dcaptura");
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesConvenios: ", aObjExcepcion);
			throw aObjExcepcion;
        }		
	}

	public String buscarOrdenesConvenioECE(ConvenioBean objConvenioParamBean,String strFechaIni,String strFechaFin, int kPaciente) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesConvenios:" + objConvenioParamBean.toString());
		String strReturn = "";
    	try{
    		if (kPaciente > 0) {
        		strReturn =  "		and tos.cconvenio = " + objConvenioParamBean.getCconvenio().intValue() + "	and tos.kpaciente = " + kPaciente + "			";
    		} else {
        		strReturn =  "		and tos.cconvenio = " + objConvenioParamBean.getCconvenio().intValue() + " ";
    		}
    		strReturn = this.buscarOrdenesConvenioECE(objConvenioParamBean.getCconvenio().intValue(),strReturn, strFechaIni, strFechaFin,"order by indexkadmision,csucursal,dcaptura",true,true);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesConvenios: ", aObjExcepcion);
			throw aObjExcepcion;
        }		
	}
	
	public String buscarOrdenesSucursalECE(int cSucursal,String strFechaIni,String strFechaFin, int kPaciente, boolean bolFechaRegistro) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesSucursalECE:" + cSucursal);
		String strReturn = "";
    	try{
    		strReturn =  "	and tos.csucursal = " + cSucursal + " ";
    		strReturn = this.buscarOrdenesConvenioECE(0,strReturn, strFechaIni, strFechaFin,"order by indexkadmision,csucursal,dcaptura",false,bolFechaRegistro);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesSucursalECE: ", aObjExcepcion);
			throw aObjExcepcion;
        }		
	}

	
	public String buscarOrdenesMedicos(MedicoBean objMedicoParamBean,String strFechaIni,String strFechaFin) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesMedicos:" + objMedicoParamBean.toString());
		String strReturn = "";
    	try{
    		strReturn =  "		and tos.cmedico = " + objMedicoParamBean.getCmedico() + "				";
    		strReturn = this.buscarOrdenes(strReturn, strFechaIni, strFechaFin,"order by indexkadmision,csucursal,dcaptura");
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesMedicos: ", aObjExcepcion);
			throw aObjExcepcion;
        }		
	}

	private String buscarOrdenesConvenioECE(int cConvenio, String strWhere,String strFechaIni,String strFechaFin, String strOrderBy, boolean bolOnlyConvenio, boolean bolFechaRegistro) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenes:" + strWhere);
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		String strReturn = "";
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		String strFechaRegistro = "";
    		if (bolFechaRegistro) {
    			strFechaRegistro = "tos.dregistro";
    		} else {
    			strFechaRegistro = "tos.dresultadoentrega";
    		}
    		strQuery =  "select   distinct tos.kordensucursal  indexkadmision,											" +
    					"       tp.kpaciente kpaciente,																	" +		
    					"		tp.sapellidopaterno ||' '|| tp.sapellidomaterno|| ' ' || tp.snombre spaciente,			" +
						"		tos.dregistro dcaptura, 																" +
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 	" +
						"		tos.csucursal csucursal,tos.uorden orden,    											" +
						"		tos.ssucursal ssucursal, 																" +
						"		cc.cconvenio cconvenio, 																" +
						"		cc.sconvenio sconvenio, 																" +
						"		cm.cclave cmedico,	    																" +
						"		tos.smedico smedico, 																	" +
						"		cer.sestadoregistro sestadoregistro, 													" +
						"       get_saldo_new(tos.kordensucursal) adeuda                                                " +
						"from   t_orden_sucursal tos inner join t_paciente tp on tos.kpaciente= tp.kpaciente			" +
						"		inner join c_convenio cc on cc.cconvenio= tos.cconvenio									" +						
						"		inner join c_estado_registro cer on cer.cestadoregistro=tos.cestadoregistro				" +		
						"		inner join c_medico cm on cm.cmedico=tos.cmedico										" +		
						"where  (" + strFechaRegistro + " 																" +
						"		between to_date('" + formatos.getFechaBD(strFechaIni,"I") + "', 'dd-mm-yyyy hh24:mi:ss')" +
						"		and to_date('" + formatos.getFechaBD(strFechaFin,"F") + "', 'dd-mm-yyyy hh24:mi:ss'))	" +	
						strWhere + " " + strOrderBy;
			iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenes...  " + strQuery);
    		objRst = objStmt.executeQuery(strQuery);
    		int y = 0;
    		String strOrden = "";
			ToolArchivosSO objArchivoResultadoExtra = new ToolArchivosSO();    		
			String strColorDiagnostico = "green";													
			String strFuncionJavaScriptVisualizaResultado = "";
    		if (objRst != null) {    			
    			strQuery  = "";
    			String strImprimeResultados = "";
    			while(objRst.next()) {
					y = y + 1;
//					x = objRst.getInt("indexkadmision");
					strOrden = objRst.getString("korden");
					if (bolOnlyConvenio) {
						cConvenio = cConvenio;
						strFuncionJavaScriptVisualizaResultado = "visualizarResultado";
					} else {
						cConvenio = objRst.getInt("cconvenio");
						strFuncionJavaScriptVisualizaResultado = "visualizarResultadoSinImagenes";
					}
					if (objRst.getDouble("adeuda") < 1) {
						strImprimeResultados = "		<a href=\"javascript:visualizarResultadoSinImagenes(" + objRst.getInt("indexkadmision") + ",'wed67');\"  align='bottom' style='font-weight: normal; font-size: x-small; color: " + strColorDiagnostico + "; font-style: normal; font-variant: normal;'><img alt='Resultados Laboratorio' id='idResultadoLaboratorio' width='30' height='30' border='0' src='/web2labportal/images/icoResultadoLaboratorio.png' /> "  +  
											   "		</a>" + objArchivoResultadoExtra.getPathRetultadoInBody(strOrden, strColorDiagnostico) + " " + 
												                objArchivoResultadoExtra.getPathRetultadoConclusiones(strOrden, strColorDiagnostico) + " " + 
												                objArchivoResultadoExtra.getPathRetultadoToxi(strOrden, strColorDiagnostico) +  " " +
															    objArchivoResultadoExtra.getPathRetultadoElectro(strOrden, strColorDiagnostico) + " " + 
															    objArchivoResultadoExtra.getPathRetultadoLumbar(strOrden, strColorDiagnostico) + " " + 
															    objArchivoResultadoExtra.getPathRetultadoTorax(strOrden, strColorDiagnostico);
;
					} else {
						strImprimeResultados = "NO ESTA PAGADO";
					}
					
					strQuery += ("<tr>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											strImprimeResultados +										
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:showECEPaciente(" + objRst.getInt("kpaciente") + "," + cConvenio + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getInt("kpaciente") + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											strOrden + 
										"</td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											objRst.getString("spaciente") +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											formatos.getFechaNumeros(objRst.getDate("dcaptura")) +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											objRst.getString("cconvenio") + "-" + objRst.getString("sconvenio") +
										"</td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											objRst.getString("cmedico") + "-" + objRst.getString("smedico") +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											objRst.getString("sestadoregistro") +
										"</td>" + 
									 "</tr>");
    				
    			}
    			strReturn = this.LoadHeaderECE(y,"");
    			strReturn = (strReturn + strQuery + "</table>");
    		}
			iObjLog.debug("Saliendo ConsultaOrdenesDao.buscarOrdenes...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenes: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}			
	
	
	
	private String buscarOrdenes(String strWhere,String strFechaIni,String strFechaFin, String strOrderBy) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenes:" + strWhere);
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		String strReturn = "";
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		strQuery =  "select   distinct tos.kordensucursal  indexkadmision,											" +
    					"		tp.sapellidopaterno ||' '|| tp.sapellidomaterno|| ' ' || tp.snombre spaciente,			" +
						"		tos.dregistro dcaptura, 																" +
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden, 	" +
						"		tos.csucursal csucursal,tos.uorden orden,    											" +
						"		tos.ssucursal ssucursal, 																" +
						"		cc.cconvenio cconvenio, 																" +
						"		cc.sconvenio sconvenio, 																" +
						"		cm.cclave cmedico,	    																" +
						"		tos.smedico smedico, 																	" +
						"		cer.sestadoregistro sestadoregistro 													" +
						"from   t_orden_sucursal tos inner join t_paciente tp on tos.kpaciente= tp.kpaciente			" +
						"		inner join c_convenio cc on cc.cconvenio= tos.cconvenio									" +						
						"		inner join c_estado_registro cer on cer.cestadoregistro=tos.cestadoregistro				" +		
						"		inner join c_medico cm on cm.cmedico=tos.cmedico										" +		
						"where  (tos.dregistro 																			" +
						"		between to_date('" + formatos.getFechaBD(strFechaIni,"I") + "', 'dd-mm-yyyy hh24:mi:ss')" +
						"		and to_date('" + formatos.getFechaBD(strFechaFin,"F") + "', 'dd-mm-yyyy hh24:mi:ss'))	" +	
						strWhere + " " + strOrderBy;
			iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenes...  " + strQuery);
    		objRst = objStmt.executeQuery(strQuery);
    		int y = 0;
    		int x = 0;
    		String strOrden = "";
    		if (objRst != null) {    			
    			strQuery  = "";
    			while(objRst.next()) {
					y = y + 1;
					x = objRst.getInt("indexkadmision");
					strOrden = objRst.getString("korden");
					strQuery += ("<tr>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											y + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											x + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											strOrden + 
										"</a></td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("spaciente") +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											formatos.getFechaNumeros(objRst.getDate("dcaptura")) +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("cconvenio") + "-" + objRst.getString("sconvenio") +
										"</a></td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("cmedico") + "-" + objRst.getString("smedico") +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("sestadoregistro") +
										"</a></td>" + 
									 "</tr>");
    				
    			}
//    			++
    			strReturn = this.LoadHeader(y,"");
    			strReturn = (strReturn + strQuery + "</table>");
    		}
			iObjLog.debug("Saliendo ConsultaOrdenesDao.buscarOrdenes...  " + strReturn);
			return strReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenes: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}			

	public String  actualizarOrdenEstadoRegistro(int kOrdenSucursal, int cValor, int intType) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.actualizarOrdenEstadoRegistro: ");
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		String strQuery = "";
		String strReturn = "";
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
    		if (intType == 1) {
				strQuery =  "UPDATE t_orden_sucursal_fac 														\n" +
							"SET drecibido=sysdate,																\n" +
							"	cestadoregistro=" + cValor + "													\n" +
							"WHERE  kfactura in (-1,0) 				and 										\n" +
							"		kordensucursalfac= (SELECT get_max_t_orden_suc_fac ("+ kOrdenSucursal +"))  \n"; 
    		} else {
				strQuery =  "UPDATE t_orden_sucursal_fac 															\n" +
							"SET 	  drecibido=sysdate,															\n" +
							"      uconsecutivo=" + cValor + " 														\n" +
							"WHERE  kfactura in (-1,0) 										and 					\n" +
							"		kordensucursalfac= (SELECT get_max_t_orden_suc_fac ("+ kOrdenSucursal +"))  	\n"; 
			}
			iObjLog.debug("UPDATE ConsultaOrdenesDao.actualizarOrdenEstadoRegistro:  " + strQuery);
			objStmt.execute(strQuery);    			
			objStmt.execute("commit;");    			
			strReturn =  "Exito en la Actualizacion";
			iObjLog.debug("Saliendo ConsultaOrdenesDao.actualizarOrdenEstadoRegistro...  " + strReturn);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.actualizarOrdenEstadoRegistro: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
		return strReturn;
	}			
	
/**	Version anterior al cambio se dividio en dos buscarOrdenesViajeCreateNewIndividual y buscarOrdenesViajeCreate(donde en este si se modifico el código del original)
	private BuscarOrdenesViajeBean buscarOrdenesViajeCreate(BuscarOrdenesViajeBean objBuscarOrdenesViajeBean) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesViaje:  " + 
					  " kviaje " + objBuscarOrdenesViajeBean.getKviaje()								+
					  " kAdmision " + objBuscarOrdenesViajeBean.getKadmision()							+ 
					  " uFolioFacturaEmpresas " + objBuscarOrdenesViajeBean.getUfoliofacturaempresas() 	+
					  " intCEstadoRegistro " + objBuscarOrdenesViajeBean.getIntcestadoregistro()       	+
					  " intBloque " + objBuscarOrdenesViajeBean.getIntbloque()                         	+
					  " strOrderBy " + objBuscarOrdenesViajeBean.getStrorderby());
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		String strReturn = " 1=1 ";
		String strHeaderTool = "";
		String strIncidenciasOrden = "";
		String strIncidenciasViaje = "";
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
			if (objBuscarOrdenesViajeBean.getIntcestadoregistro() > 1) {
        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 													\n" +
								"SET drecibido=sysdate,															\n" +
								"	cestadoregistro=" + objBuscarOrdenesViajeBean.getIntcestadoregistro() + "	\n" +
								"WHERE cestadoregistro not in (39) and 											\n" +
								"		kordensucursalfac in (													\n" +
								"	SELECT kordensucursalfac													\n" +
								"	FROM T_ORDEN_SUCURSAL_FAC													\n" +
								"	WHERE kviajefac=" + objBuscarOrdenesViajeBean.getKviaje() + ")";
        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 													\n" +
								"SET drecibido=sysdate,															\n" +
								"	cestadoregistro=" + objBuscarOrdenesViajeBean.getIntcestadoregistro() + "	\n" +
								"WHERE  cestadoregistro not in (39) and											\n" +
								"		kfactura in (-1,0) 				and 									\n" +
								"		kordensucursalfac= (SELECT get_max_t_orden_suc_fac ("+ objBuscarOrdenesViajeBean.getKadmision() +"))  	\n"; 
        		}
				iObjLog.debug("UPDATE ConsultaOrdenesDao.buscarOrdenesViaje:  " + strQuery);
				objStmt.execute(strQuery);    			
				objStmt.execute("commit;");    			
			} else if (objBuscarOrdenesViajeBean.getIntbloque() > 1) {
        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 											\n" +
								"SET       drecibido=sysdate,											\n" +
								"       uconsecutivo=" + objBuscarOrdenesViajeBean.getIntbloque() +    "\n" +
								"WHERE cestadoregistro not in (39) and									\n" +
								"		kordensucursalfac in (											\n" +
								"	SELECT kordensucursalfac											\n" +
								"	FROM T_ORDEN_SUCURSAL_FAC											\n" +
								"	WHERE kviajefac=" + objBuscarOrdenesViajeBean.getKviaje() + ")";
        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 											\n" +
								"SET 	  drecibido=sysdate,											\n" +
								"      uconsecutivo=" + objBuscarOrdenesViajeBean.getIntbloque() +    " \n" +
								"WHERE  cestadoregistro not in (39) and									\n" +
								"		kfactura in (-1,0) 			and 								\n" +
								"		kordensucursalfac= (SELECT get_max_t_orden_suc_fac ("+ objBuscarOrdenesViajeBean.getKadmision() +"))  	\n"; 
        		}
				iObjLog.debug("UPDATE ConsultaOrdenesDao.buscarOrdenesViaje:  " + strQuery);
				objStmt.execute(strQuery);    			
				objStmt.execute("commit;");    			
			}
			
    		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {    		
	    		strQuery =  "SELECT cincidenciafacturacion,sincidenciafacturacion,bincidenciaorden	\n" +
							"FROM c_incidencia_facturacion											\n" +
							"WHERE uproceso=1														\n" +
							"ORDER BY BINCIDENCIAORDEN DESC,CINCIDENCIAFACTURACION					\n";
				iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenesViaje...  " + strQuery);
				objRst = objStmt.executeQuery(strQuery);
				while (objRst.next()) {
					if (objRst.getBoolean("bincidenciaorden")) {
						strIncidenciasOrden += "<option value='" + objRst.getString("cincidenciafacturacion") + "'>" + objRst.getString("sincidenciafacturacion") + "</option>"; 
					} else {
						strIncidenciasViaje += "<option value='" + objRst.getString("cincidenciafacturacion") + "'>" + objRst.getString("sincidenciafacturacion") + "</option>"; 
					}
				}
				objRst.close();
    		} else {
    			strIncidenciasOrden = "";
    			strIncidenciasViaje = "";
    		}
    		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
    			strReturn = strReturn + " AND tosf.kviajefac=" + objBuscarOrdenesViajeBean.getKviaje();
    		}
    		if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
    			strReturn = strReturn + " AND tosf.kordensucursal=" + objBuscarOrdenesViajeBean.getKadmision();
    		}
    		if (objBuscarOrdenesViajeBean.getUfoliofacturaempresas() > 0) {
    			strReturn = strReturn + " AND tosf.kfactura in (  															\n" +
										"    			SELECT kfactura													\n" +
										"    			FROM T_FACTURA													\n" +	
										"    			WHERE ufoliofactura IN (" + objBuscarOrdenesViajeBean.getUfoliofacturaempresas() + ") and 		\n" +
										"					  trim(ssucursal) in ('EMPRESAS'))							\n";
    		}
    		if (objBuscarOrdenesViajeBean.getCsucursal() > 0) {
    			strReturn = strReturn + " AND tosf.csucursal=" + objBuscarOrdenesViajeBean.getCsucursal() + " and 													\n"+
			    						"	(tosf.dregistro between to_date('" + objBuscarOrdenesViajeBean.getStrfechainicial() + "', 'dd-mm-yyyy hh24:mi:ss') 	\n"+
										"						and to_date('" + objBuscarOrdenesViajeBean.getStrfechafinal() + "', 'dd-mm-yyyy hh24:mi:ss')) 	\n";
    			if (objBuscarOrdenesViajeBean.getCestadoregistroconsulta() > 0) {
    				strReturn = strReturn + " and tosf.cestadoregistro in (" + objBuscarOrdenesViajeBean.getCestadoregistroconsulta() + ")	";
    			}
    		}
    		if (objBuscarOrdenesViajeBean.getCconvenio() > 0) {
    			strReturn = strReturn + " AND tosf.cconvenio=" + objBuscarOrdenesViajeBean.getCconvenio() + " and " +
			    						"	(tosf.dregistro between to_date('" + objBuscarOrdenesViajeBean.getStrfechainicial() + "', 'dd-mm-yyyy hh24:mi:ss') 	\n"+
			    						"				and to_date('" + objBuscarOrdenesViajeBean.getStrfechafinal() + "', 'dd-mm-yyyy hh24:mi:ss')) 			\n";
    			if (objBuscarOrdenesViajeBean.getCestadoregistroconsulta() > 0) {
    				strReturn = strReturn + " and tosf.cestadoregistro in (" + objBuscarOrdenesViajeBean.getCestadoregistroconsulta() + ")	";
    			}
    		}
    		strQuery =  "select   distinct tos.kordensucursal  indexkadmision,											\n" +
    					"		tp.sapellidopaterno ||' '|| tp.sapellidomaterno|| ' ' || tp.snombre spaciente,			\n" +
						"		tos.dregistro dcaptura, 																\n" +
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden,	\n" +
						"		tos.csucursal csucursal,																\n" +
						"		tos.uorden orden,    																	\n" +
						"		tos.ssucursal ssucursal, 																\n" +
						"		csc.snombresucursal, 																	\n" +
						"		cc.cconvenio cconvenio, 																\n" +
						"		cc.sconvenio sconvenio, 																\n" +
						"		cm.cclave cmedico,	    																\n" +
						"		tos.smedico smedico, 																	\n" +
						"		cer.cestadoregistro cestadoregistro, 													\n" +
						"		cer.sestadoregistro sestadoregistro, 													\n" +
						"		cerf.cestadoregistro cestadoregistrof, 													\n" +
						"		cerf.sestadoregistro sestadoregistrof, 													\n" +
						"		tosf.kviajefac,						 													\n" +
						"		tf.ufoliofactura,						 												\n" +
						"		tosf.uconsecutivo,						 												\n" +
						"		tosf.dcierre						 													\n" +
						"from   t_orden_sucursal tos inner join t_paciente tp on tos.kpaciente= tp.kpaciente			\n" +
						"		inner join c_convenio cc on cc.cconvenio= tos.cconvenio									\n" +					
						"		inner join c_estado_registro cer on cer.cestadoregistro=tos.cestadoregistro				\n" +	
						"		inner join c_medico cm on cm.cmedico=tos.cmedico										\n" +
						"		inner join c_sucursal csc on csc.csucursal=tos.csucursal								\n" +
						"		inner join t_orden_sucursal_fac tosf on tos.kordensucursal=tosf.kordensucursal 			\n" +
//						"											and tosf.kfactura in (-1,0) 						\n" +
						"					and tosf.kordensucursalfac=get_max_t_orden_suc_fac (tos.kordensucursal) 	\n" +
						"					and tos.kordensucursal in (SELECT kordensucursal                            \n" +       
					    "                            				   FROM t_orden_sucursal_fac tosf                   \n" +
					    "                            				   WHERE " + strReturn + "							\n" +											 			
					    "                                              )    											\n" +
    					"		inner join c_estado_registro cerf on cerf.cestadoregistro=tosf.cestadoregistro			\n" +		
    					"		inner join t_factura tf on tf.kfactura=tosf.kfactura						 			\n";
    		strQuery = strQuery + objBuscarOrdenesViajeBean.getStrorderby();
			iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenesViaje...  " + strQuery);
    		objRst = objStmt.executeQuery(strQuery);
    		FormateaFecha objFormato = new FormateaFecha();
    		int y = 0;
    		int x = 0;
    		String strOrden = "";
    		String sEstadoOrden = "";
    		String sGrupoOrden = "";
    		if (objRst != null) {    			
    			strQuery  = "";
    			while(objRst.next()) {
    				sGrupoOrden = "<select id=\"selGrupo" + objRst.getInt("indexkadmision") + "\" style=\"width: 80px\" onChange='CambiarGrupoFacturacion(" + objRst.getInt("indexkadmision") + ",this);'>";
    				for(int inti=0;inti<21;inti++) {    					
    					if ((objRst.getInt("uconsecutivo") == inti) && (inti == 0)) {
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\" selected>Seleccionar</option>";    						
    					} else if (objRst.getInt("uconsecutivo") == inti) {
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\" selected>" + inti + "</option>";    						
    					} else if (objRst.getInt("cestadoregistrof") != 35 && objRst.getInt("cestadoregistrof") != 39 ){
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\">" + inti + "</option>";    						
    					}
    				}
					sGrupoOrden = sGrupoOrden + "</select>";    						
    				switch (objRst.getInt("cestadoregistrof")) {
	    				case 27:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"27\" selected>ABIERTO</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 28:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\" selected>CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 35:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"35\" selected>FACTURADA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 36:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\" selected>RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 37:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\" selected>LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 38:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\" selected>RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 39:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"39\" selected>CANCELADA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 48:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\" selected>NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 54:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"54\" selected>CAPTURA_PUEBLA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 56:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"56\" selected>INTERPRETADA_PUEBLA</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 57:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"37\">LISTAFACTURAR</option>				\n" +
						    				"			<option value=\"38\">RETENIDA</option>					\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>				\n" +
						    				"			<option value=\"57\" selected>FACTURAR_PUEBLA</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				default:    	
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value='0' selected>Indeterminado</option> "	+
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"		</select>	";						    					    					
    				}					
					y = y + 1;
					x = objRst.getInt("indexkadmision");
					strOrden = objRst.getString("korden");
					strQuery += ("<tr>" + 
//										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//											y + 
//										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											x + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											strOrden + 
										"</a></td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("spaciente") +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											formatos.getFechaNumeros(objRst.getDate("dcaptura")) +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("cconvenio") + "-" + objRst.getString("sconvenio") +
										"</a></td>" + 
//										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//											objRst.getString("sestadoregistro") +
//										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											sEstadoOrden +
										"</td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("ufoliofactura") +
										"</a></td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											sGrupoOrden +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
					    				"		<select name='cboIncidenciaOrdenViaje' onChange='levantarIncidenciaOrden(" + objRst.getString("orden") + ",this);' style='width:120px'> " +
					    				"			<option value='0' selected>Sin Incidencia</option> "	+ strIncidenciasOrden +
					    				"		</select>	"	+						    				
										"</a></td>" + 
									 "</tr>");    				
	        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
	        			strHeaderTool = "del Viaje " + objBuscarOrdenesViajeBean.getKviaje() + ", Fecha de envio: " + objFormato.getFechaddmm4y(objRst.getDate("dcierre"));
	            		strHeaderTool +=  "		<select name='cboIncidenciaViaje' onChange='levantarIncidenciaViaje(" + objBuscarOrdenesViajeBean.getKviaje() + ");'  style='width:180px'> " +
	    								  "			<option value='0' selected>Sin Incidencia</option> "	+ strIncidenciasViaje +
	    								  "		</select>	";
	        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
	        			strHeaderTool = "de la Admision " + objBuscarOrdenesViajeBean.getKadmision() + " , esta se encuentra en el Viaje " + objRst.getInt("kviajefac") ;
	        		} else if (objBuscarOrdenesViajeBean.getCsucursal() > 0) {
	        			strHeaderTool = " , de la sucursal " + objRst.getInt("csucursal") + " - " + objRst.getString("snombresucursal");
	        		}
    			}
    			strReturn = this.LoadHeader(y,strHeaderTool + "  <input type=\"checkbox\" id=\"radActualizaBloque\" onClick='javascript:activarBatch();'> ACTUALIZA BLOQUE?  <input type='button' id='idActualizarBatch' value='Actualizar TODAS' onClick='javascript:actualizarBatch();' class='boton' disabled='disabled'> <input type='hidden' id='idAccionesEjecutar' value=''> <input type='hidden' id='idBloquesEjecutar' value=''>");
    			strReturn = (strReturn + strQuery + "</table>");
    		}
			iObjLog.debug("Saliendo ConsultaOrdenesDao.buscarOrdenesViaje...  " + strReturn);
			objBuscarOrdenesViajeBean.setSordeneshtml(strReturn);
			return objBuscarOrdenesViajeBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}			
	**/
	private BuscarOrdenesViajeBean buscarOrdenesViajeCreateNewIndividual(BuscarOrdenesViajeBean objBuscarOrdenesViajeBean) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesViaje:  " + 
					  " kviaje " + objBuscarOrdenesViajeBean.getKviaje()								+
					  " kAdmision " + objBuscarOrdenesViajeBean.getKadmision()							+ 
					  " uFolioFacturaEmpresas " + objBuscarOrdenesViajeBean.getUfoliofacturaempresas() 	+
					  " intCEstadoRegistro " + objBuscarOrdenesViajeBean.getIntcestadoregistro()       	+
					  " intBloque " + objBuscarOrdenesViajeBean.getIntbloque()                         	+
					  " strOrderBy " + objBuscarOrdenesViajeBean.getStrorderby());
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		String strReturn = " 1=1 ";
		String strHeaderTool = "";
		String strIncidenciasOrden = "";
		String strIncidenciasViaje = "";
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
			if (objBuscarOrdenesViajeBean.getIntcestadoregistro() > 1) {
        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 													\n" +
								"SET drecibido=sysdate,															\n" +
								"	cestadoregistro=" + objBuscarOrdenesViajeBean.getIntcestadoregistro() + "	\n" +
								"WHERE cestadoregistro not in (35,39,56) and 											\n" +
								"		kordensucursalfac in (													\n" +
								"	SELECT kordensucursalfac													\n" +
								"	FROM T_ORDEN_SUCURSAL_FAC													\n" +
								"	WHERE kviajefac=" + objBuscarOrdenesViajeBean.getKviaje() + ")";
        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 													\n" +
								"SET drecibido=sysdate,															\n" +
								"	cestadoregistro=" + objBuscarOrdenesViajeBean.getIntcestadoregistro() + "	\n" +
								"WHERE  cestadoregistro not in (35,39,56) and											\n" +
								"		kfactura in (-1,0) 				and 									\n" +
								"		kordensucursalfac= (SELECT get_max_t_orden_suc_fac ("+ objBuscarOrdenesViajeBean.getKadmision() +"))  	\n"; 
        		}
				iObjLog.debug("UPDATE ConsultaOrdenesDao.buscarOrdenesViaje:  " + strQuery);
				objStmt.execute(strQuery);    			
				objStmt.execute("commit;");    			
			} else if (objBuscarOrdenesViajeBean.getIntbloque() > 1) {
        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 											\n" +
								"SET       drecibido=sysdate,											\n" +
								"       uconsecutivo=" + objBuscarOrdenesViajeBean.getIntbloque() +    "\n" +
								"WHERE cestadoregistro not in (35,39,56) and									\n" +
								"		kordensucursalfac in (											\n" +
								"	SELECT kordensucursalfac											\n" +
								"	FROM T_ORDEN_SUCURSAL_FAC											\n" +
								"	WHERE kviajefac=" + objBuscarOrdenesViajeBean.getKviaje() + ")";
        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 											\n" +
								"SET 	  drecibido=sysdate,											\n" +
								"      uconsecutivo=" + objBuscarOrdenesViajeBean.getIntbloque() +    " \n" +
								"WHERE  cestadoregistro not in (35,39,56) and									\n" +
								"		kfactura in (-1,0) 			and 								\n" +
								"		kordensucursalfac= (SELECT get_max_t_orden_suc_fac ("+ objBuscarOrdenesViajeBean.getKadmision() +"))  	\n"; 
        		}
				iObjLog.debug("UPDATE ConsultaOrdenesDao.buscarOrdenesViaje:  " + strQuery);
				objStmt.execute(strQuery);    			
				objStmt.execute("commit;");    			
			}
			
    		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {    		
	    		strQuery =  "SELECT cincidenciafacturacion,sincidenciafacturacion,bincidenciaorden	\n" +
							"FROM c_incidencia_facturacion											\n" +
							"WHERE uproceso=1														\n" +
							"ORDER BY BINCIDENCIAORDEN DESC,CINCIDENCIAFACTURACION					\n";
				iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenesViaje...  " + strQuery);
				objRst = objStmt.executeQuery(strQuery);
				while (objRst.next()) {
					if (objRst.getBoolean("bincidenciaorden")) {
						strIncidenciasOrden += "<option value='" + objRst.getString("cincidenciafacturacion") + "'>" + objRst.getString("sincidenciafacturacion") + "</option>"; 
					} else {
						strIncidenciasViaje += "<option value='" + objRst.getString("cincidenciafacturacion") + "'>" + objRst.getString("sincidenciafacturacion") + "</option>"; 
					}
				}
				objRst.close();
    		} else {
    			strIncidenciasOrden = "";
    			strIncidenciasViaje = "";
    		}
    		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
    			strReturn = strReturn + " AND tosf.kviajefac=" + objBuscarOrdenesViajeBean.getKviaje();
    		}
    		if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
    			strReturn = strReturn + " AND tosf.kordensucursal=" + objBuscarOrdenesViajeBean.getKadmision();
    		}
    		if (objBuscarOrdenesViajeBean.getUfoliofacturaempresas() > 0) {
    			strReturn = strReturn + " AND tosf.kfactura in (  															\n" +
										"    			SELECT kfactura													\n" +
										"    			FROM T_FACTURA													\n" +	
										"    			WHERE ufoliofactura IN (" + objBuscarOrdenesViajeBean.getUfoliofacturaempresas() + ") and 		\n" +
										"					  trim(ssucursal) in ('EMPRESAS'))							\n";
    		}
    		if (objBuscarOrdenesViajeBean.getCsucursal() > 0) {
    			strReturn = strReturn + " AND tosf.csucursal=" + objBuscarOrdenesViajeBean.getCsucursal() + " and 													\n"+
			    						"	(tosf.dregistro between to_date('" + objBuscarOrdenesViajeBean.getStrfechainicial() + "', 'dd-mm-yyyy hh24:mi:ss') 	\n"+
										"						and to_date('" + objBuscarOrdenesViajeBean.getStrfechafinal() + "', 'dd-mm-yyyy hh24:mi:ss')) 	\n";
    			if (objBuscarOrdenesViajeBean.getCestadoregistroconsulta() > 0) {
    				strReturn = strReturn + " and tosf.cestadoregistro in (" + objBuscarOrdenesViajeBean.getCestadoregistroconsulta() + ")	";
    			}
    		}
    		if (objBuscarOrdenesViajeBean.getCconvenio() > 0) {
    			strReturn = strReturn + " AND tosf.cconvenio=" + objBuscarOrdenesViajeBean.getCconvenio() + " and " +
			    						"	(tosf.dregistro between to_date('" + objBuscarOrdenesViajeBean.getStrfechainicial() + "', 'dd-mm-yyyy hh24:mi:ss') 	\n"+
			    						"				and to_date('" + objBuscarOrdenesViajeBean.getStrfechafinal() + "', 'dd-mm-yyyy hh24:mi:ss')) 			\n";
    			if (objBuscarOrdenesViajeBean.getCestadoregistroconsulta() > 0) {
    				strReturn = strReturn + " AND tosf.cestadoregistro in (" + objBuscarOrdenesViajeBean.getCestadoregistroconsulta() + ")	";
    			}
    		}
    		if (strReturn.trim().length() < 6) {
    			strReturn = strReturn +  " AND tos.kordensucursal in (1234)";
    		}
    		strQuery =  "select   distinct tos.kordensucursal  indexkadmision,											\n" +
    					"		tp.sapellidopaterno ||' '|| tp.sapellidomaterno|| ' ' || tp.snombre spaciente,			\n" +
						"		tos.dregistro dcaptura, 																\n" +
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden,	\n" +
						"		tos.csucursal csucursal,																\n" +
						"		tos.uorden orden,    																	\n" +
						"		tos.ssucursal ssucursal, 																\n" +
						"		csc.snombresucursal, 																	\n" +
						"		cc.cconvenio cconvenio, 																\n" +
						"		cc.sconvenio sconvenio, 																\n" +
						"		cm.cclave cmedico,	    																\n" +
						"		tos.smedico smedico, 																	\n" +
						"		cer.cestadoregistro cestadoregistro, 													\n" +
						"		cer.sestadoregistro sestadoregistro, 													\n" +
						"		cerf.cestadoregistro cestadoregistrof, 													\n" +
						"		cerf.sestadoregistro sestadoregistrof, 													\n" +
						"		tosf.kviajefac,						 													\n" +
						"		tf.ufoliofactura,						 												\n" +
						"		tosf.uconsecutivo,						 												\n" +
						"		tosf.dcierre						 													\n" +
						"from   t_orden_sucursal tos inner join t_paciente tp on tos.kpaciente= tp.kpaciente			\n" +
						"		inner join c_convenio cc on cc.cconvenio= tos.cconvenio									\n" +					
						"		inner join c_estado_registro cer on cer.cestadoregistro=tos.cestadoregistro				\n" +	
						"		inner join c_medico cm on cm.cmedico=tos.cmedico										\n" +
						"		inner join c_sucursal csc on csc.csucursal=tos.csucursal								\n" +
						"		inner join t_orden_sucursal_fac tosf on tos.kordensucursal=tosf.kordensucursal 			\n" +
//						"											and tosf.kfactura in (-1,0) 						\n" +
						"					and tosf.kordensucursalfac= (SELECT get_max_t_orden_suc_fac (tos.kordensucursal)) 	\n" +
//						"					and tos.kordensucursal in (SELECT kordensucursal                            \n" +       
//					    "                            				   FROM t_orden_sucursal_fac tosf                   \n" +
//					    "                            				   WHERE " + strReturn + "							\n" +											 			
//					    "                                              )    											\n" +
    					"		inner join c_estado_registro cerf on cerf.cestadoregistro=tosf.cestadoregistro			\n" +		
    					"		inner join t_factura tf on tf.kfactura=tosf.kfactura and " + strReturn + "					\n";
    		strQuery = strQuery + objBuscarOrdenesViajeBean.getStrorderby();
			iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenesViaje...  " + strQuery);
    		objRst = objStmt.executeQuery(strQuery);
    		FormateaFecha objFormato = new FormateaFecha();
    		int y = 0;
    		int x = 0;
    		String strOrden = "";
    		String sEstadoOrden = "";
    		String sGrupoOrden = "";
    		if (objRst != null) {    			
    			strQuery  = "";
    			while(objRst.next()) {
    				sGrupoOrden = "<select id=\"selGrupo" + objRst.getInt("indexkadmision") + "\" style=\"width: 80px\" onChange='CambiarGrupoFacturacion(" + objRst.getInt("indexkadmision") + ",this);'>";
    				for(int inti=0;inti<21;inti++) {    					
    					if ((objRst.getInt("uconsecutivo") == inti) && (inti == 0)) {
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\" selected>Seleccionar</option>";    						
    					} else if (objRst.getInt("uconsecutivo") == inti) {
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\" selected>" + inti + "</option>";    						
    					} else if (objRst.getInt("cestadoregistrof") != 35 && objRst.getInt("cestadoregistrof") != 39 ){
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\">" + inti + "</option>";    						
    					}
    				}
					sGrupoOrden = sGrupoOrden + "</select>";    						
    				switch (objRst.getInt("cestadoregistrof")) {
	    				case 27:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"27\" selected>ABIERTO</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 28:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\" selected>CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 35:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"35\" selected>FACTURADA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 36:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\" selected>RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 37:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\" selected>LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 38:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\" selected>RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 39:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"39\" selected>CANCELADA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 48:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\" selected>NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 54:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"54\" selected>CAPTURA_PUEBLA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 56:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"56\" selected>INTERPRETADA_PUEBLA</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 57:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"37\">LISTAFACTURAR</option>				\n" +
						    				"			<option value=\"38\">RETENIDA</option>					\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>				\n" +
						    				"			<option value=\"57\" selected>FACTURAR_PUEBLA</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				default:    	
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value='0' selected>Indeterminado</option> "	+
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"		</select>	";						    					    					
    				}					
					y = y + 1;
					x = objRst.getInt("indexkadmision");
					strOrden = objRst.getString("korden");
					strQuery += ("<tr>" + 
//										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//											y + 
//										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											x + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											strOrden + 
										"</a></td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("spaciente") +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											formatos.getFechaNumeros(objRst.getDate("dcaptura")) +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("cconvenio") + "-" + objRst.getString("sconvenio") +
										"</a></td>" + 
//										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//											objRst.getString("sestadoregistro") +
//										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											sEstadoOrden +
										"</td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("ufoliofactura") +
										"</a></td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											sGrupoOrden +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
					    				"		<select name='cboIncidenciaOrdenViaje' onChange='levantarIncidenciaOrden(" + objRst.getString("orden") + ",this);' style='width:120px'> " +
					    				"			<option value='0' selected>Sin Incidencia</option> "	+ strIncidenciasOrden +
					    				"		</select>	"	+						    				
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
					    				"	<input type=\"button\" onclick=\"return repOrdenFactura('/web2labportal/servlet/template/web2lab,ap,RepRedirect.vm/action/reportes.ReporteAction','Factura',"+x+")\" value=\"Recibo\" name=\"recibo\" class=\"boton\" style=\"width:120px\">" +						    				
										"</td>" +
									 "</tr>");    				
	        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
	        			strHeaderTool = "del Viaje " + objBuscarOrdenesViajeBean.getKviaje() + ", Fecha de envio: " + objFormato.getFechaddmm4y(objRst.getDate("dcierre"));
	            		strHeaderTool +=  "		<select name='cboIncidenciaViaje' onChange='levantarIncidenciaViaje(" + objBuscarOrdenesViajeBean.getKviaje() + ");'  style='width:180px'> " +
	    								  "			<option value='0' selected>Sin Incidencia</option> "	+ strIncidenciasViaje +
	    								  "		</select>	";
	        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
	        			strHeaderTool = "de la Admision " + objBuscarOrdenesViajeBean.getKadmision() + " , esta se encuentra en el Viaje " + objRst.getInt("kviajefac") ;
	        		} else if (objBuscarOrdenesViajeBean.getCsucursal() > 0) {
	        			strHeaderTool = " , de la sucursal " + objRst.getInt("csucursal") + " - " + objRst.getString("snombresucursal");
	        		}
    			}
    			strReturn = this.LoadHeader(y,strHeaderTool + "  <input type=\"checkbox\" id=\"radActualizaBloque\" onClick='javascript:activarBatch();'> ACTUALIZA BLOQUE?  <input type='button' id='idActualizarBatch' value='Actualizar TODAS' onClick='javascript:actualizarBatch();' class='boton' disabled='disabled'> <input type='hidden' id='idAccionesEjecutar' value=''> <input type='hidden' id='idBloquesEjecutar' value=''>");
    			strReturn = (strReturn + strQuery + "</table>");
    		}
			iObjLog.debug("Saliendo ConsultaOrdenesDao.buscarOrdenesViaje...  " + strReturn);
			objBuscarOrdenesViajeBean.setSordeneshtml(strReturn);
			return objBuscarOrdenesViajeBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}
	private BuscarOrdenesViajeBean buscarOrdenesViajeCreate(BuscarOrdenesViajeBean objBuscarOrdenesViajeBean) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesViaje:  " + 
					  " kviaje " + objBuscarOrdenesViajeBean.getKviaje()								+
					  " kAdmision " + objBuscarOrdenesViajeBean.getKadmision()							+ 
					  " uFolioFacturaEmpresas " + objBuscarOrdenesViajeBean.getUfoliofacturaempresas() 	+
					  " intCEstadoRegistro " + objBuscarOrdenesViajeBean.getIntcestadoregistro()       	+
					  " intBloque " + objBuscarOrdenesViajeBean.getIntbloque()                         	+
					  " strOrderBy " + objBuscarOrdenesViajeBean.getStrorderby());
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		String strReturn = " 1=1 ";
		String strHeaderTool = "";
		String strIncidenciasOrden = "";
		String strIncidenciasViaje = "";
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
			if ((objBuscarOrdenesViajeBean.getIntcestadoregistro() > 1) && (objBuscarOrdenesViajeBean.getIntbloque() > 1)) {
        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 													\n" +
								"SET drecibido=sysdate,															\n" +
								"	cestadoregistro=" + objBuscarOrdenesViajeBean.getIntcestadoregistro() + ",	\n" +
								"   uconsecutivo=" + objBuscarOrdenesViajeBean.getIntbloque() +    "\n" +
								"WHERE kordensucursalfac in (													\n" +
								"	SELECT kordensucursalfac													\n" +
								"	FROM T_ORDEN_SUCURSAL_FAC													\n" +
								"	WHERE kviajefac=" + objBuscarOrdenesViajeBean.getKviaje() + ")              \n" +
								"		and cestadoregistro not in (35,39,56)	"; 
        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
					strQuery =  "UPDATE t_orden_sucursal_fac 													\n" +
								"SET drecibido=sysdate,															\n" +
								"	cestadoregistro=" + objBuscarOrdenesViajeBean.getIntcestadoregistro() + ",	\n" +
								"   uconsecutivo=" + objBuscarOrdenesViajeBean.getIntbloque() +    "\n" +
								"WHERE  kfactura in (-1,0) 				and 									\n" +
								"		kordensucursalfac= (SELECT get_max_t_orden_suc_fac ("+ objBuscarOrdenesViajeBean.getKadmision() +"))  	\n" +
								"		and cestadoregistro not in (35,39,56)	"; 
        		}
				iObjLog.debug("UPDATE ConsultaOrdenesDao.buscarOrdenesViaje:  " + strQuery);
				objStmt.execute(strQuery);    			
				objStmt.execute("commit;");    			
			} 
    		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {    		
	    		strQuery =  "SELECT cincidenciafacturacion,sincidenciafacturacion,bincidenciaorden	\n" +
							"FROM c_incidencia_facturacion											\n" +
							"WHERE uproceso=1														\n" +
							"ORDER BY BINCIDENCIAORDEN DESC,CINCIDENCIAFACTURACION					\n";
				iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenesViaje...  " + strQuery);
				objRst = objStmt.executeQuery(strQuery);
				while (objRst.next()) {
					if (objRst.getBoolean("bincidenciaorden")) {
						strIncidenciasOrden += "<option value='" + objRst.getString("cincidenciafacturacion") + "'>" + objRst.getString("sincidenciafacturacion") + "</option>"; 
					} else {
						strIncidenciasViaje += "<option value='" + objRst.getString("cincidenciafacturacion") + "'>" + objRst.getString("sincidenciafacturacion") + "</option>"; 
					}
				}
				objRst.close();
    		} else {
    			strIncidenciasOrden = "";
    			strIncidenciasViaje = "";
    		}
    		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
    			strReturn = strReturn + " AND tosf.kviajefac=" + objBuscarOrdenesViajeBean.getKviaje();
    		}
    		if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
    			strReturn = strReturn + " AND tosf.kordensucursal=" + objBuscarOrdenesViajeBean.getKadmision();
    		}
    		if (objBuscarOrdenesViajeBean.getUfoliofacturaempresas() > 0) {
    			strReturn = strReturn + " AND tosf.kfactura in (  															\n" +
										"    			SELECT kfactura													\n" +
										"    			FROM T_FACTURA													\n" +	
										"    			WHERE ufoliofactura IN (" + objBuscarOrdenesViajeBean.getUfoliofacturaempresas() + ") and 		\n" +
										"					  trim(ssucursal) in ('EMPRESAS'))							\n";
    		}
    		if (objBuscarOrdenesViajeBean.getCsucursal() > 0) {
    			strReturn = strReturn + " AND tosf.csucursal=" + objBuscarOrdenesViajeBean.getCsucursal() + " and 													\n"+
			    						"	(tosf.dregistro between to_date('" + objBuscarOrdenesViajeBean.getStrfechainicial() + "', 'dd-mm-yyyy hh24:mi:ss') 	\n"+
										"						and to_date('" + objBuscarOrdenesViajeBean.getStrfechafinal() + "', 'dd-mm-yyyy hh24:mi:ss')) 	\n";
    			if (objBuscarOrdenesViajeBean.getCestadoregistroconsulta() > 0) {
    				strReturn = strReturn + " and tosf.cestadoregistro in (" + objBuscarOrdenesViajeBean.getCestadoregistroconsulta() + ")	";
    			}
    		}
    		if (objBuscarOrdenesViajeBean.getCconvenio() > 0) {
    			strReturn = strReturn + " AND tosf.cconvenio=" + objBuscarOrdenesViajeBean.getCconvenio() + " and " +
			    						"	(tosf.dregistro between to_date('" + objBuscarOrdenesViajeBean.getStrfechainicial() + "', 'dd-mm-yyyy hh24:mi:ss') 	\n"+
			    						"				and to_date('" + objBuscarOrdenesViajeBean.getStrfechafinal() + "', 'dd-mm-yyyy hh24:mi:ss')) 			\n";
    			if (objBuscarOrdenesViajeBean.getCestadoregistroconsulta() > 0) {
    				strReturn = strReturn + " and tosf.cestadoregistro in (" + objBuscarOrdenesViajeBean.getCestadoregistroconsulta() + ")	";
    			}
    		}
    		if (strReturn.trim().length() < 6) {
    			strReturn = strReturn +  " AND tos.kordensucursal in (1234)";
    		}    		
    		strQuery =  "select   distinct tos.kordensucursal  indexkadmision,											\n" +
    					"		tp.sapellidopaterno ||' '|| tp.sapellidomaterno|| ' ' || tp.snombre spaciente,			\n" +
						"		tos.dregistro dcaptura, 																\n" +
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden,	\n" +
						"		tos.csucursal csucursal,																\n" +
						"		tos.uorden orden,    																	\n" +
						"		tos.ssucursal ssucursal, 																\n" +
						"		csc.snombresucursal, 																	\n" +
						"		cc.cconvenio cconvenio, 																\n" +
						"		cc.sconvenio sconvenio, 																\n" +
						"		cm.cclave cmedico,	    																\n" +
						"		tos.smedico smedico, 																	\n" +
						"		cer.cestadoregistro cestadoregistro, 													\n" +
						"		cer.sestadoregistro sestadoregistro, 													\n" +
						"		cerf.cestadoregistro cestadoregistrof, 													\n" +
						"		cerf.sestadoregistro sestadoregistrof, 													\n" +
						"		tosf.kviajefac,						 													\n" +
						"		tf.ufoliofactura,						 												\n" +
						"		tosf.uconsecutivo,						 												\n" +
						"		tosf.dcierre						 													\n" +
						"from   t_orden_sucursal tos inner join t_paciente tp on tos.kpaciente= tp.kpaciente			\n" +
						"		inner join c_convenio cc on cc.cconvenio= tos.cconvenio									\n" +					
						"		inner join c_estado_registro cer on cer.cestadoregistro=tos.cestadoregistro				\n" +	
						"		inner join c_medico cm on cm.cmedico=tos.cmedico										\n" +
						"		inner join c_sucursal csc on csc.csucursal=tos.csucursal								\n" +
						"		inner join t_orden_sucursal_fac tosf on tos.kordensucursal=tosf.kordensucursal 			\n" +
//						"											and tosf.kfactura in (-1,0) 						\n" +
						"					and tosf.kordensucursalfac= (SELECT get_max_t_orden_suc_fac (tos.kordensucursal)) 	\n" +
//						"					and tos.kordensucursal in (SELECT kordensucursal                            \n" +       
//					    "                            				   FROM t_orden_sucursal_fac tosf                   \n" +
//					    "                            				   WHERE " + strReturn + "							\n" +											 			
//					    "                                              )    											\n" +
    					"		inner join c_estado_registro cerf on cerf.cestadoregistro=tosf.cestadoregistro			\n" +		
    					"		inner join t_factura tf on tf.kfactura=tosf.kfactura and " + strReturn + "					\n";
    		strQuery = strQuery + objBuscarOrdenesViajeBean.getStrorderby();
			iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenesViaje...  " + strQuery);
    		objRst = objStmt.executeQuery(strQuery);
    		FormateaFecha objFormato = new FormateaFecha();
    		int y = 0;
    		int x = 0;
    		String strOrden = "";
    		String sEstadoOrden = "";
    		String sGrupoOrden = "";
    		if (objRst != null) {    			
    			strQuery  = "";
    			while(objRst.next()) {
    				sGrupoOrden = "<select id=\"selGrupo" + objRst.getInt("indexkadmision") + "\" style=\"width: 80px\" onChange='CambiarGrupoFacturacion(" + objRst.getInt("indexkadmision") + ",this);'>";
    				for(int inti=0;inti<21;inti++) {    					
    					if ((objRst.getInt("uconsecutivo") == inti) && (inti == 0)) {
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\" selected>Seleccionar</option>";    						
    					} else if (objRst.getInt("uconsecutivo") == inti) {
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\" selected>" + inti + "</option>";    						
    					} else if (objRst.getInt("cestadoregistrof") != 35 && objRst.getInt("cestadoregistrof") != 39 ){
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\">" + inti + "</option>";    						
    					}
    				}
					sGrupoOrden = sGrupoOrden + "</select>";    						
    				switch (objRst.getInt("cestadoregistrof")) {
	    				case 27:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"27\" selected>ABIERTO</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 28:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\" selected>CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 35:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"35\" selected>FACTURADA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 36:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\" selected>RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 37:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\" selected>LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 38:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\" selected>RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 39:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"39\" selected>CANCELADA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 48:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\" selected>NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 54:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"54\" selected>CAPTURA_PUEBLA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 56:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"56\" selected>INTERPRETADA_PUEBLA</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 57:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"37\">LISTAFACTURAR</option>				\n" +
						    				"			<option value=\"38\">RETENIDA</option>					\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>				\n" +
						    				"			<option value=\"57\" selected>FACTURAR_PUEBLA</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				default:    	
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value='0' selected>Indeterminado</option> "	+
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"		</select>	";						    					    					
    				}					
					y = y + 1;
					x = objRst.getInt("indexkadmision");
					strOrden = objRst.getString("korden");
					strQuery += ("<tr>" + 
//										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//											y + 
//										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											x + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											strOrden + 
										"</a></td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("spaciente") +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											formatos.getFechaNumeros(objRst.getDate("dcaptura")) +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("cconvenio") + "-" + objRst.getString("sconvenio") +
										"</a></td>" + 
//										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//											objRst.getString("sestadoregistro") +
//										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											sEstadoOrden +
										"</td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("ufoliofactura") +
										"</a></td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											sGrupoOrden +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
					    				"		<select name='cboIncidenciaOrdenViaje' onChange='levantarIncidenciaOrden(" + objRst.getString("orden") + ",this);' style='width:120px'> " +
					    				"			<option value='0' selected>Sin Incidencia</option> "	+ strIncidenciasOrden +
					    				"		</select>	"	+						    				
										"</a></td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
					    				"	<input type=\"button\" onclick=\"return repOrdenFactura('/web2labportal/servlet/template/web2lab,ap,RepRedirect.vm/action/reportes.ReporteAction','Factura',"+x+")\" value=\"Recibo\" name=\"recibo\" class=\"boton\" style=\"width:120px\">" +						    				
										"</td>" + 
									 "</tr>");    				
	        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
	        			strHeaderTool = "del Viaje " + objBuscarOrdenesViajeBean.getKviaje() + ", Fecha de envio: " + objFormato.getFechaddmm4y(objRst.getDate("dcierre"));
	            		strHeaderTool +=  "		<select name='cboIncidenciaViaje' onChange='levantarIncidenciaViaje(" + objBuscarOrdenesViajeBean.getKviaje() + ");'  style='width:180px'> " +
	    								  "			<option value='0' selected>Sin Incidencia</option> "	+ strIncidenciasViaje +
	    								  "		</select>	";
	        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
	        			strHeaderTool = "de la Admision " + objBuscarOrdenesViajeBean.getKadmision() + " , esta se encuentra en el Viaje " + objRst.getInt("kviajefac") ;
	        		} else if (objBuscarOrdenesViajeBean.getCsucursal() > 0) {
	        			strHeaderTool = " , de la sucursal " + objRst.getInt("csucursal") + " - " + objRst.getString("snombresucursal");
	        		}
    			}
    			strReturn = this.LoadHeader(y,strHeaderTool + "  <input type=\"checkbox\" id=\"radActualizaBloque\" onClick='javascript:activarBatch();'> ACTUALIZA BLOQUE?  <input type='button' id='idActualizarBatch' value='Actualizar TODAS' onClick='javascript:actualizarBatch();' class='boton' disabled='disabled'> <input type='hidden' id='idAccionesEjecutar' value=''> <input type='hidden' id='idBloquesEjecutar' value=''>");
    			strReturn = (strReturn + strQuery + "</table>");
    		}
			iObjLog.debug("Saliendo ConsultaOrdenesDao.buscarOrdenesViaje...  " + strReturn);
			objBuscarOrdenesViajeBean.setSordeneshtml(strReturn);
			return objBuscarOrdenesViajeBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}

	
	private String LoadHeader(int intOrdenes, String strHeaderOptional) {
		return ("<table border='0' align='center' width='100%' class='tabla'>" + 
		 		"<tr>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Total de Ordenes " + intOrdenes + " " + strHeaderOptional +
				"	</font></b>" +
				"</th>"  + 
			"</tr>" +
		 "</table>" +	
		 "<table border='0' align='center' width='100%'  class='tabla'>" +
			"<tr>" + 
//				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
//				"	<b><font color='black'>#" + 
//				"	</font></b>" +
//				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Conse." + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Orden" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Paciente" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Fecha Captura" + 
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Convenio o Promocion" + 
				"	</font></b>" +
				"</th>" + 
//				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
//				"	<b><font color='black'>Edo. Suc" + 
//				"	</font></b>" +
//				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Edo. Fac" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'># Fac." + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Bloque" + 
				"	</font></b>" +
				"</th>" +
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Incidencia" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Recibo" + 
				"	</font></b>" +
				"</th>" + 
			"</tr>");			    
	}
	
	
	private String LoadHeaderECE(int intOrdenes, String strHeaderOptional) {
		return ("<table border='0' align='center' width='100%' class='tabla'>" + 
		 		"<tr>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Total de Ordenes " + intOrdenes + " " + strHeaderOptional +
				"	</font></b>" +
				"</th>"  + 
			"</tr>" +
		 "</table>" +	
		 "<table border='0' align='center' width='100%'  class='tabla'>" +
			"<tr>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>#" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>ECE" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Orden" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Paciente" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Fecha Captura" + 
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Convenio" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Dr(a)" + 
				"	</font></b>" +
				"</th>" + 
				"<th nowrap style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" +
				"	<b><font color='black'>Estado" + 
				"	</font></b>" +
				"</th>" + 
			"</tr>");			    
	}
	
	
	private BuscarOrdenesViajeBean buscarOrdenesViajeCreateNewPaciente(BuscarOrdenesViajeBean objBuscarOrdenesViajeBean, int kpaciente) throws Exception {
		iObjLog.debug("Entrando ConsultaOrdenesDao.buscarOrdenesViaje:  " + 
					  " kviaje " + objBuscarOrdenesViajeBean.getKviaje()								+
					  " kAdmision " + objBuscarOrdenesViajeBean.getKadmision()							+ 
					  " uFolioFacturaEmpresas " + objBuscarOrdenesViajeBean.getUfoliofacturaempresas() 	+
					  " intCEstadoRegistro " + objBuscarOrdenesViajeBean.getIntcestadoregistro()       	+
					  " intBloque " + objBuscarOrdenesViajeBean.getIntbloque()                         	+
					  " strOrderBy " + objBuscarOrdenesViajeBean.getStrorderby() +
					  " kpaciente"+ kpaciente);
					  
		iObjSesion = HibernateUtil.getSession();
		Connection objConn = null;
		Statement objStmt = null;
		ResultSet objRst  = null;
		String strQuery = "";
		String strReturn = " 1=1 ";
		String strHeaderTool = "";
		String strIncidenciasOrden = "";
		String strIncidenciasViaje = "";
    	try{
    		objConn = iObjSesion.connection();
    		objStmt = objConn.createStatement();
			if ((objBuscarOrdenesViajeBean.getIntcestadoregistro() > 1) && (objBuscarOrdenesViajeBean.getIntbloque() > 1)) {
					strQuery =  "UPDATE t_orden_sucursal_fac 													\n" +
								"SET drecibido=sysdate,															\n" +
								"	cestadoregistro=" + objBuscarOrdenesViajeBean.getIntcestadoregistro() + ",	\n" +
								"   uconsecutivo=" + objBuscarOrdenesViajeBean.getIntbloque() +    "\n" +
								"WHERE  kfactura in (-1,0) 				and 									\n" +
								"		kordensucursalfac= (SELECT get_max_t_orden_suc_fac ("+ objBuscarOrdenesViajeBean.getKadmision() +"))  	\n"; 
				iObjLog.debug("UPDATE ConsultaOrdenesDao.buscarOrdenesViaje:  " + strQuery);
				objStmt.execute(strQuery);    			
				objStmt.execute("commit;");    			
			} 
    		
    			strIncidenciasOrden = "";
    			strIncidenciasViaje = "";
    			if (objBuscarOrdenesViajeBean.getCestadoregistroconsulta() > 0) {
    				strReturn = strReturn + " and tosf.cestadoregistro in (" + objBuscarOrdenesViajeBean.getCestadoregistroconsulta() + ")	";
    			}
    		if (strReturn.trim().length() < 6) {
    			strReturn = strReturn +  " AND tos.kordensucursal in (1234)";
    		}
    		strQuery =  "select   distinct tos.kordensucursal  indexkadmision,											\n" +
    					"		tp.sapellidopaterno ||' '|| tp.sapellidomaterno|| ' ' || tp.snombre spaciente,			\n" +
						"		tos.dregistro dcaptura, 																\n" +
						"		(nvl(trim(tos.ssucursal),'') || trim(to_char(nvl(tos.uorden,0),'00000000'))) korden,	\n" +
						"		tos.csucursal csucursal,																\n" +
						"		tos.uorden orden,    																	\n" +
						"		tos.ssucursal ssucursal, 																\n" +
						"		csc.snombresucursal, 																	\n" +
						"		cc.cconvenio cconvenio, 																\n" +
						"		cc.sconvenio sconvenio, 																\n" +
						"		cm.cclave cmedico,	    																\n" +
						"		tos.smedico smedico, 																	\n" +
						"		cer.cestadoregistro cestadoregistro, 													\n" +
						"		cer.sestadoregistro sestadoregistro, 													\n" +
						"		cerf.cestadoregistro cestadoregistrof, 													\n" +
						"		cerf.sestadoregistro sestadoregistrof, 													\n" +
						"		tosf.kviajefac,						 													\n" +
						"		tf.ufoliofactura,						 												\n" +
						"		tosf.uconsecutivo,						 												\n" +
						"		tosf.dcierre						 													\n" +
						"from   t_orden_sucursal tos inner join t_paciente tp on tos.kpaciente= tp.kpaciente			\n" +
						"		inner join c_convenio cc on cc.cconvenio= tos.cconvenio									\n" +					
						"		inner join c_estado_registro cer on cer.cestadoregistro=tos.cestadoregistro				\n" +	
						"		inner join c_medico cm on cm.cmedico=tos.cmedico										\n" +
						"		inner join c_sucursal csc on csc.csucursal=tos.csucursal								\n" +
						"		inner join t_orden_sucursal_fac tosf on tos.kordensucursal=tosf.kordensucursal 			\n" +
//						"											and tosf.kfactura in (-1,0) 						\n" +
						"					and tosf.kordensucursalfac= (SELECT get_max_t_orden_suc_fac (tos.kordensucursal)) 	\n" +
//						"					and tos.kordensucursal in (SELECT kordensucursal                            \n" +       
//					    "                            				   FROM t_orden_sucursal_fac tosf                   \n" +
//					    "                            				   WHERE " + strReturn + "							\n" +											 			
//					    "                                              )    											\n" +
    					"		inner join c_estado_registro cerf on cerf.cestadoregistro=tosf.cestadoregistro			\n" +		
    					"		inner join t_factura tf on tf.kfactura=tosf.kfactura						 			\n"+
    					"		and tp.kpaciente="+kpaciente+" and " + strReturn + "										";
    		strQuery = strQuery + objBuscarOrdenesViajeBean.getStrorderby();
			iObjLog.debug("Consulta ConsultaOrdenesDao.buscarOrdenesViaje...  " + strQuery);
    		objRst = objStmt.executeQuery(strQuery);
    		FormateaFecha objFormato = new FormateaFecha();
    		int y = 0;
    		int x = 0;
    		String strOrden = "";
    		String sEstadoOrden = "";
    		String sGrupoOrden = "";
    		if (objRst != null) {    			
    			strQuery  = "";
    			while(objRst.next()) {
    				sGrupoOrden = "<select id=\"selGrupo" + objRst.getInt("indexkadmision") + "\" style=\"width: 80px\" onChange='CambiarGrupoFacturacion(" + objRst.getInt("indexkadmision") + ",this);'>";
    				for(int inti=0;inti<21;inti++) {    					
    					if ((objRst.getInt("uconsecutivo") == inti) && (inti == 0)) {
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\" selected>Seleccionar</option>";    						
    					} else if (objRst.getInt("uconsecutivo") == inti) {
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\" selected>" + inti + "</option>";    						
    					} else if (objRst.getInt("cestadoregistrof") != 35 && objRst.getInt("cestadoregistrof") != 39 ){
    						sGrupoOrden = sGrupoOrden + "<option value=\"" + inti + "\">" + inti + "</option>";    						
    					}
    				}
					sGrupoOrden = sGrupoOrden + "</select>";    						
    				switch (objRst.getInt("cestadoregistrof")) {
	    				case 27:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"27\" selected>ABIERTO</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 28:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\" selected>CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 35:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"35\" selected>FACTURADA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 36:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\" selected>RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 37:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\" selected>LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 38:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\" selected>RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 39:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"39\" selected>CANCELADA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 48:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\" selected>NO FACTURABLE</option>	\n" +
						    				"			<option value=\"57\">RECLAMADAS</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 54:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"54\" selected>CAPTURA_PUEBLA</option>		\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 56:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"56\" selected>INTERPRETADA_PUEBLA</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				case 57:
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value=\"37\">LISTAFACTURAR</option>				\n" +
						    				"			<option value=\"38\">RETENIDA</option>					\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>				\n" +
						    				"			<option value=\"57\" selected>FACTURAR_PUEBLA</option>	\n" +
						    				"		</select>	";						    					    					
	    					break;
	    				default:    	
	        				sEstadoOrden = 	"		<select id='cboEstadoOrdenViaje" + objRst.getInt("indexkadmision") + "' name='cboEstadoOrdenViaje' onChange='CambiarEstadoOrden(" + objRst.getInt("indexkadmision") + ",this);' style='width:120px'> " +
						    				"			<option value='0' selected>Indeterminado</option> "	+
						    				"			<option value=\"28\">CERRADO</option>		\n" +
						    				"			<option value=\"36\">RECIBIDA</option>		\n" +
						    				"			<option value=\"37\">LISTAFACTURAR</option>	\n" +
						    				"			<option value=\"38\">RETENIDA</option>		\n" +
						    				"			<option value=\"48\">NO FACTURABLE</option>	\n" +
						    				"		</select>	";						    					    					
    				}					
					y = y + 1;
					x = objRst.getInt("indexkadmision");
					strOrden = objRst.getString("korden");
					strQuery += ("<tr>" + 
//										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//											y + 
//										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											x + 
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											strOrden + 
										"</a></td>" + 
										"<td align='left' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("spaciente") +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											formatos.getFechaNumeros(objRst.getDate("dcaptura")) +
										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("cconvenio") + "-" + objRst.getString("sconvenio") +
										"</a></td>" + 
//										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
//											objRst.getString("sestadoregistro") +
//										"</a></td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> " + 
											sEstadoOrden +
										"</td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'> <a href='javascript:doNothing()' onClick='javascript:ordenAceptada(" + x + "," + objRst.getString("orden") + ");' align='bottom' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											objRst.getString("ufoliofactura") +
										"</a></td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
											sGrupoOrden +
										"</td>" + 
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
					    				"		<select name='cboIncidenciaOrdenViaje' onChange='levantarIncidenciaOrden(" + objRst.getString("orden") + ",this);' style='width:120px'> " +
					    				"			<option value='0' selected>Sin Incidencia</option> "	+ strIncidenciasOrden +
					    				"		</select>	"	+						    				
										"</a></td>" +
										"<td align='center' style='font-weight: normal; font-size: x-small; color: black; font-style: normal; font-variant: normal;'>" + 
					    				"	<input type=\"button\" onclick=\"return repOrdenFactura('/web2labportal/servlet/template/web2lab,ap,RepRedirect.vm/action/reportes.ReporteAction','Factura',"+x+")\" value=\"Recibo\" name=\"recibo\" class=\"boton\" style=\"width:120px\">" +						    				
										"</td>" + 
									 "</tr>");    				
	        		if (objBuscarOrdenesViajeBean.getKviaje() > 0) {
	        			strHeaderTool = "del Viaje " + objBuscarOrdenesViajeBean.getKviaje() + ", Fecha de envio: " + objFormato.getFechaddmm4y(objRst.getDate("dcierre"));
	            		strHeaderTool +=  "		<select name='cboIncidenciaViaje' onChange='levantarIncidenciaViaje(" + objBuscarOrdenesViajeBean.getKviaje() + ");'  style='width:180px'> " +
	    								  "			<option value='0' selected>Sin Incidencia</option> "	+ strIncidenciasViaje +
	    								  "		</select>	";
	        		} else if (objBuscarOrdenesViajeBean.getKadmision() > 0) {
	        			strHeaderTool = "de la Admision " + objBuscarOrdenesViajeBean.getKadmision() + " , esta se encuentra en el Viaje " + objRst.getInt("kviajefac") ;
	        		} else if (objBuscarOrdenesViajeBean.getCsucursal() > 0) {
	        			strHeaderTool = " , de la sucursal " + objRst.getInt("csucursal") + " - " + objRst.getString("snombresucursal");
	        		}
    			}
    			strReturn = this.LoadHeader(y,strHeaderTool + "  <input type=\"checkbox\" id=\"radActualizaBloque\" onClick='javascript:activarBatch();'> ACTUALIZA BLOQUE?  <input type='button' id='idActualizarBatch' value='Actualizar TODAS' onClick='javascript:actualizarBatch();' class='boton' disabled='disabled'> <input type='hidden' id='idAccionesEjecutar' value=''> <input type='hidden' id='idBloquesEjecutar' value=''>");
    			strReturn = (strReturn + strQuery + "</table>");
    		}
			iObjLog.debug("Saliendo ConsultaOrdenesDao.buscarOrdenesViaje...  " + strReturn);
			objBuscarOrdenesViajeBean.setSordeneshtml(strReturn);
			return objBuscarOrdenesViajeBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR ConsultaOrdenesDao.buscarOrdenesViaje: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
    		objRst  = null;
    		objStmt = null;
        	HibernateUtil.closeSession();
		}		
	}

	
}
