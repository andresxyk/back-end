package mx.com.web2lab.backend.dao.comer;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.comer.MedicoBean;
import mx.com.web2lab.backend.dao.ap.ToolsDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal;
import mx.com.web2lab.backend.hbm.om.ap.CDireccionMedico;
import mx.com.web2lab.backend.hbm.om.ap.CEspecialidad;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CMarca;
import mx.com.web2lab.backend.hbm.om.ap.CReferenciaDireccion;
import mx.com.web2lab.backend.hbm.om.ap.CSexo;
import mx.com.web2lab.backend.hbm.om.ap.CZonaMedico;
import mx.com.web2lab.backend.hbm.om.ap.medico.CMedico;
import mx.com.web2lab.backend.util.formatos.Formatos;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import net.sf.hibernate.JDBCException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MedicosDao {

	private static Log iObjLog = LogFactory.getLog(MedicosDao.class);
	    
	private Session iObjSesion = null;
	
	public MedicosDao(){
		iObjSesion = HibernateUtil.getSession();
	}
	
	public List buscarMedicos(MedicoBean objMedico) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List objListaMedicos = new ArrayList();
			List objListaReturn = new ArrayList();			
			List objListaDirecciones = null;
			Query objQuery = null;
			Query objQuery2 = null;
			String strQuery = "";
			String strQueryFiltro = "";
			MedicoBean objMedicoBeanReturn = null;
			CMedico objMedicoReturn = null;
			CDireccionMedico objDireccion = null;
	    	try{
				iObjLog.debug("Entrando MedicosDao.buscarMedicos:Entrando...  " );
	            HibernateUtil.beginTrans();
					strQuery = "select bPF " +					
							" from CMedico bPF " +					
							" where bPF.snombre=bPF.snombre and bPF.cclave != 1 and bPF.cclave != 99 and bPF.cmarca = 14 ";
					if (objMedico.getCzona() > 0 ) {
						iObjLog.debug("Entrando PacientesDao.buscarMedicos:Entrando...Zona  " +  objMedico.getCzona());
						strQueryFiltro += " AND bPF.czonamedico.czona = " + objMedico.getCzona() + " ";
					} else if (objMedico.getCespecialidad() > 0 ) {
						iObjLog.debug("Entrando PacientesDao.buscarMedicos:Entrando...Especialidad  " +  objMedico.getCespecialidad());
						strQueryFiltro += " AND bPF.cespecialidad.cespecialidad = " + objMedico.getCespecialidad() + " ";	
					} else {										
						if (objMedico.getCmedico().intValue() > 0 ) {
							iObjLog.debug("Entrando PacientesDao.buscarMedicos:Entrando...Codigo  " +  objMedico.getCmedico().intValue());
							strQueryFiltro += " AND bPF.cclave = " + objMedico.getCmedico().intValue() + " ";
						}					
						if (objMedico.getKmedico() > 0 ) {
							iObjLog.debug("Entrando PacientesDao.buscarMedicos:Entrando...Codigo  " +  objMedico.getCmedico().intValue());
							strQueryFiltro += " AND bPF.cmedico = " + objMedico.getKmedico() + " ";
						}					
						if (objMedico.getSnombre().trim().toString().length() > 0 ) {
							iObjLog.debug("Entrando PacientesDao.buscarMedicos:Entrando...Nombre  1" +  objMedico.getSnombre() + "2");
							strQueryFiltro += " AND bPF.snombre like ('" + objMedico.getSnombre() + "%') ";
						}
						if (objMedico.getSappaterno().trim().toString().length() > 0) {
							iObjLog.debug("Entrando PacientesDao.buscarMedicos:Entrando...Apellido Paterno  1" +  objMedico.getSappaterno() + "2");
							strQueryFiltro += " AND bPF.sapellidopaterno like ('" + objMedico.getSappaterno() + "%') ";
						}
						if (objMedico.getSapmaterno().trim().toString().length() > 0) {
							iObjLog.debug("Entrando PacientesDao.buscarMedicos:Entrando...Apellido Materno  1" +  objMedico.getSapmaterno() + "2");
							strQueryFiltro += " AND bPF.sapellidomaterno like ('" + objMedico.getSapmaterno() + "%') ";
						}
					}
					if (strQueryFiltro != "") {
						if (objMedico.getSorderby() != "") {
							strQuery = strQuery + strQueryFiltro + " ORDER BY " + objMedico.getSorderby();
						} else {
							strQuery = strQuery + strQueryFiltro + " ORDER BY sapellidopaterno,sapellidomaterno,snombre";							
						}
						iObjLog.debug("Entrando MedicosDao.buscarMedicos:Consulta...  " + strQuery);
						objQuery = iObjSesion.createQuery(strQuery);
						objListaMedicos = objQuery.list();
						if (objListaMedicos.isEmpty() == false) {
							for(int inti=0;inti<objListaMedicos.size();inti++){
								objMedicoReturn = (CMedico)objListaMedicos.get(inti);						
								objMedicoBeanReturn = new MedicoBean();
								objMedicoBeanReturn.setKmedico(objMedicoReturn.getCmedico().intValue());
								objMedicoBeanReturn.setCmedico(new Long(objMedicoReturn.getCclave()));
								objMedicoBeanReturn.setSnombre(objMedicoReturn.getSnombre());
								objMedicoBeanReturn.setSapmaterno(objMedicoReturn.getSapellidomaterno());
								objMedicoBeanReturn.setSappaterno(objMedicoReturn.getSapellidopaterno());
								objMedicoBeanReturn.setScorreoelectro(objMedicoReturn.getSemail() + "");
								objMedicoBeanReturn.setUsexo(objMedicoReturn.getCsexo().getCsexo().intValue());
								objMedicoBeanReturn.setCzona(objMedicoReturn.getCzonamedico().getCzona().intValue());
								objMedicoBeanReturn.setCespecialidad(objMedicoReturn.getCespecialidad().getCespecialidad().intValue());
								objMedicoBeanReturn.setSespecialidad(objMedicoReturn.getCespecialidad().getSespecialidad());
								objMedicoBeanReturn.setDnacimiento(objMedicoReturn.getDnacimiento());
								objMedicoBeanReturn.setCformapagomedico(objMedicoReturn.getCformapagomedico());
								objMedicoBeanReturn.setScurp(objMedicoReturn.getScurp());
								objMedicoBeanReturn.setShorariovisita(objMedicoReturn.getShorariovisita());
								objMedicoBeanReturn.setUcategoriamedico(objMedicoReturn.getUcategoriamedico());
								objMedicoBeanReturn.setUestadomedico(objMedicoReturn.getCestadoregistro().getCestadoregistro().intValue());
								objMedicoBeanReturn.setSestadomedico(objMedicoReturn.getCestadoregistro().getSestadoregistro());
								objMedicoBeanReturn.setSrfc(objMedicoReturn.getSrfc());
								objMedicoBeanReturn.setSusuarioweb(objMedicoReturn.getSusuarioweb());
								objMedicoBeanReturn.setBsustentable(objMedicoReturn.isBsustentable());
								System.out.println("Splittt::"+objMedicoReturn.getSmarcasventa());
								String [] splitMarcas = objMedicoReturn.getSmarcasventa().split(",");
								for (int i = 0; i < splitMarcas.length; i++) {
									System.out.println("for:::"+splitMarcas[i]);
									if(splitMarcas[i].equals("1")){
										objMedicoBeanReturn.setMarcaolab(true);
									}
									if(splitMarcas[i].equals("4")){
										objMedicoBeanReturn.setMarcaazteca(true);
									}
									if(splitMarcas[i].equals("5")){
										objMedicoBeanReturn.setMarcaswisslab(true);
									}
									if(splitMarcas[i].equals("7")){
										objMedicoBeanReturn.setMarcajenner(true);
									}
									if(splitMarcas[i].equals("15")){
										objMedicoBeanReturn.setMarcaliacsa(true);
									}
									if(splitMarcas[i].equals("19")){
										objMedicoBeanReturn.setMarcafamilylabsnorte(true);
									}
									if(splitMarcas[i].equals("20")){
										objMedicoBeanReturn.setMarcaexakta(true);
									}
									if(splitMarcas[i].equals("21")){
										objMedicoBeanReturn.setMarcaasesoressur(true);
									}
									if(splitMarcas[i].equals("16")){
										objMedicoBeanReturn.setMarcamoreira(true);
									}
									if(splitMarcas[i].equals("22")){
										objMedicoBeanReturn.setMarcapolab(true);
									}
									if(splitMarcas[i].equals("25")){
										objMedicoBeanReturn.setMarcabiomedicareferencia(true);
									}
									if(splitMarcas[i].equals("26")){
										objMedicoBeanReturn.setMarcapromedic(true);
									}
								}								
								
								iObjLog.debug("Consulta MedicosDao.buscarMedicos:Operacion...  " + objMedico.getUtipooperacion() );
								if (objMedicoReturn.getCclave() > 0 && objMedicoReturn.getBregistrado() == true && objMedico.getUtipooperacion() == 1 && objListaMedicos.size() < 15) {
									strQuery = "select cDM " +					
											   " from CDireccionMedico cDM " +					
											   " where cDM.cmedico= " + objMedicoReturn.getCmedico().intValue();
									objQuery2 = iObjSesion.createQuery(strQuery);
									objListaDirecciones = objQuery2.list();  
									
									if(objListaDirecciones.size()>0){
										
										objDireccion = (CDireccionMedico)objListaDirecciones.get(0);
										
										objMedicoBeanReturn.setSdireccion(objDireccion.getSdireccion());
										objMedicoBeanReturn.setStelefono(objDireccion.getStelefono());																
										objMedicoBeanReturn.setScolonia(objDireccion.getCcodigopostal().getScolonia());
										objMedicoBeanReturn.setSdelegmuni(objDireccion.getCcodigopostal().getSdelegacionmunicipio());
										objMedicoBeanReturn.setSciudad(objDireccion.getCcodigopostal().getSestado());
										objMedicoBeanReturn.setScodigopostal(objDireccion.getCcodigopostal().getCpostal());
										objMedicoBeanReturn.setKcodigopostal(objDireccion.getCcodigopostal().getCcodigopostal().intValue());
										
										objMedicoBeanReturn.setTipoDireccion(objDireccion.getCreferenciadireccion().getSreferenciadireccion());
										objMedicoBeanReturn.setCtipoDireccion(objDireccion.getCreferenciadireccion().getCreferenciadireccion().intValue());
										objMedicoBeanReturn.setSreferenciadireccion(objDireccion.getCreferenciadireccion().getSreferenciadireccion());
										objMedicoBeanReturn.setCreferenciadireccion(objDireccion.getCreferenciadireccion().getCreferenciadireccion().intValue());
										objMedicoBeanReturn.setCestadoregistro(objDireccion.getCestadoregistro().getCestadoregistro().intValue());
									}else{
										objMedicoBeanReturn.setSdireccion("");
										objMedicoBeanReturn.setStelefono("");																
										objMedicoBeanReturn.setScolonia("");
										objMedicoBeanReturn.setSdelegmuni("");
										objMedicoBeanReturn.setSciudad("");
										objMedicoBeanReturn.setScodigopostal("");
										objMedicoBeanReturn.setKcodigopostal(0);
										
										objMedicoBeanReturn.setTipoDireccion("");
										objMedicoBeanReturn.setCtipoDireccion(0);
										objMedicoBeanReturn.setSreferenciadireccion("");
										objMedicoBeanReturn.setCreferenciadireccion(0);
										objMedicoBeanReturn.setCestadoregistro(3);
									}
									
									
									
									
									objMedicoBeanReturn.setSgriddirecciones(this.getGridDireccionesMedico(objListaDirecciones,objMedicoReturn.getCestadoregistro().getCestadoregistro().intValue(),objMedicoReturn.getCestadoregistro().getSestadoregistro()));
									objMedicoBeanReturn.setSgridtelefonos(this.getGridTelefonosMedico(objListaDirecciones));
//									if (objListaDirecciones.size() > 0) {
									iObjLog.debug("Consulta MedicosDao.buscarMedicos:Operacion...Numero de Direcciones..." + objListaDirecciones.size() );
//									objMedicoBeanReturn.setSgriddirecciones(this.getGridDireccionesMedico(objListaDirecciones));
//										objDireccion = (CDireccionMedico)objListaDirecciones.get(0);			
//										objMedicoBeanReturn.setSdireccion(objDireccion.getSdireccion());
//										objMedicoBeanReturn.setStelefono(objDireccion.getStelefono());							
//										objMedicoBeanReturn.setCasentamiento(Integer.parseInt(objDireccion.getCcodigopostal().getCasentamiento()) - 1);
//										iObjLog.debug("Consulta MedicosDao.buscarMedicos:Consulta...Colonia....." + objDireccion.getCcodigopostal().getScolonia().trim());
//										if ((objDireccion.getCcodigopostal().getScolonia().trim().toString() == "NINGUNO") || objDireccion.getCcodigopostal().getScolonia().trim().toString().equals("NINGUNO")) {
//											objMedicoBeanReturn.setScolonia("");
//											objMedicoBeanReturn.setSdelegmuni("");
//											objMedicoBeanReturn.setSciudad("");
//											objMedicoBeanReturn.setScodigopostal("");
//											objMedicoBeanReturn.setKcodigopostal(0);
//										} else {									
//											objMedicoBeanReturn.setScolonia(objDireccion.getCcodigopostal().getScolonia());
//											objMedicoBeanReturn.setSdelegmuni(objDireccion.getCcodigopostal().getSdelegacionmunicipio());
//											objMedicoBeanReturn.setSciudad(objDireccion.getCcodigopostal().getSestado());
//											objMedicoBeanReturn.setScodigopostal(objDireccion.getCcodigopostal().getCpostal());
//											objMedicoBeanReturn.setKcodigopostal(objDireccion.getCcodigopostal().getCcodigopostal().intValue());
//										}								
//									} else {
//										objMedicoBeanReturn.setScolonia("");
//										objMedicoBeanReturn.setSdelegmuni("");
//										objMedicoBeanReturn.setSciudad("");
//										objMedicoBeanReturn.setScodigopostal("");
//										objMedicoBeanReturn.setKcodigopostal(0);
//									}
									objDireccion = null;
									objListaDirecciones.clear();
									objListaDirecciones = null;
									objQuery2 = null;
								} else {
									objMedicoBeanReturn.setSdireccion("");
									objMedicoBeanReturn.setStelefono("");																
									objMedicoBeanReturn.setScolonia("");
									objMedicoBeanReturn.setSdelegmuni("");
									objMedicoBeanReturn.setSciudad("");
									objMedicoBeanReturn.setScodigopostal("");
									objMedicoBeanReturn.setKcodigopostal(0);									
								}
								objListaReturn.add(objMedicoBeanReturn);
								objMedicoBeanReturn = null;
								objMedicoReturn = null;
							}
						}
					}
					iObjLog.debug("Entrando MedicosDao.buscarMedicos:Resultado...  " + objListaReturn.size());
//				HibernateUtil.commitTrans();	 				
			iObjLog.debug("Saliendo MedicosDao.buscarMedicos:Saliendo...  ");
			return objListaReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosDao.buscarMedicos:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		
	
	
	private String getGridDireccionesMedico(List lstDireccionesMedico,int cEstadoRegistro, String sEstadoRegistro) {
		String strEstadoRegistro = "";
		switch (cEstadoRegistro) {
			case 24:
				strEstadoRegistro = "icoPalomaBien";
				break;
			case 25:
				strEstadoRegistro = "icoTacheMal";
				break;
			case 26:
				strEstadoRegistro = "icoFallecido";
				break;
		}		
		String strReturn = 	"<table border='0'  align='center' style='width: 100%'>																												\n" +
							"    <tr>																																							\n" +	
							"        <td>																																						\n" +	
							"			<a href=\"javascript:mantenimientoDirecciones();\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'> 	\n" +  
	    		            "				<img alt='Nueva Direccion' id=\"imgPDF\" width=\"30\" height=\"30\" border='0' src='/web2labportal/images/icoDomicilio.png' />						\n" +
							"			</a>																																					\n" + 													
							"			<a href=\"javascript:mantenimientoTelefonos();\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'> 		\n" +  
	    		            "				<img alt='Nuevos Telefono' id=\"imgPDF\" width=\"30\" height=\"30\" border='0' src='/web2labportal/images/icoTelefono.png' />						\n" +
							"			</a>																																					\n" + 													
							"			<a href=\"javascript:mantenimientoEstadoRegistro();\"  align='bottom' style='font-weight: normal; font-size: x-small;  font-style: normal; font-variant: normal;'> 	\n" +  
	    		            "				<img alt='Estado Registro " + sEstadoRegistro + "' id=\"imgPDF\" width=\"30\" height=\"30\" border='0' src='/web2labportal/images/cestadoregistro/" + strEstadoRegistro + ".png' />		\n" +
							"			</a>																																					\n" + 													
							"	    </td>																																						\n" +
							"        <td>																																						\n" +
							"	    </td>																																						\n" +
							"        <td>																																						\n" +
							"	    </td>																																						\n" +
							"        <td>																																						\n" +
							"	    </td>																																						\n" +
							"        <td>																																						\n" +
							"	    </td>																																						\n" +
							"    </tr>   																																						\n" +
							"</table>   																																						\n" +
							"<table border='1'  align='center' style='width: 100%'>																												\n" +
							"    <tr> 																																							\n" +
							"        <th  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
							"        	<b><font color='black'>Calle																															\n" +
							"        	</font></b>																																				\n" +
							"        </th> 																																						\n" +
							"        <th  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
							"        	<b><font color='black'>Colonia 																															\n" +
							"        	</font></b>																																				\n" +
							"        </th> 																																						\n" +
							"        <th  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
							"        	<b><font color='black'>Delegaci&oacute;n o Municipio																									\n" +
							"        </th> 																																						\n" +
							"        <th  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
							"        	<b><font color='black'>Estado																															\n" +
							"        </th> 																																						\n" +
							"        <th  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
							"        	<b><font color='black'>C&oacute;digo Postal 																											\n" +
							"        </th>																																						\n" +
							"        <th  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
							"        	<b><font color='black'>Tipo de Direcci&oacute;n 																										\n" +
							"        </th>																																						\n" +
							"    </tr>																																							\n";
		    CDireccionMedico objDireccion = null;
			for (int inti=0;inti<lstDireccionesMedico.size();inti++) {
				objDireccion = (CDireccionMedico)lstDireccionesMedico.get(inti);	
				strReturn = strReturn +  	"    <tr> 																																						    \n" +
											"        <td  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
											"        	<b><font color='black'>" + objDireccion.getSdireccion()  + "																															\n" +
											"        	</font></b>																																				\n" +
											"        </td> 																																						\n" +
											"        <td  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
											"        	<b><font color='black'>" + objDireccion.getCcodigopostal().getScolonia() + " 																															\n" +
											"        	</font></b>																																				\n" +
											"        </td> 																																						\n" +
											"        <td  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
											"        	<b><font color='black'>" + objDireccion.getCcodigopostal().getSdelegacionmunicipio() + "																									\n" +
											"        </td> 																																						\n" +
											"        <td  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
											"        	<b><font color='black'>" + objDireccion.getCcodigopostal().getSestado() + "																															\n" +
											"        </td> 																																						\n" +
											"        <td  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
											"        	<b><font color='black'>" + objDireccion.getCcodigopostal().getCpostal() + " 																											\n" +
											"        </td>																																						\n" +
											"        <td  style='width: 16.5%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>								\n" +
											"        	<b><font color='black'>" + objDireccion.getCreferenciadireccion().getSreferenciadireccion() + " 																										\n" +
											"        </td>																																						\n" +
											"    </tr>																																							\n";
		    }			
			iObjLog.debug("Consulta MedicosDao.getGridDireccionesMedico:Operacion...String de Direcciones..." + strReturn );			
			return strReturn + "</table>";		
	}

	private String getGridTelefonosMedico(List lstDireccionesMedico) {		
		String strReturn = 	"	<table border='1' align='center' style='width: 100%'> 																											\n" +
							"        <tr> 																																						\n" +
							"            <th  style='width: 50%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>							\n" +
							"            	<b><font color='black'>Telefono																														\n" +
							"            	</font></b>																																			\n" +
							"            </th> 																																					\n" +
							"            <th  style='width: 50%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>							\n" +
							"            	<b><font color='black'>Tipo de Telefono 																											\n" +
							"            </th>																																					\n" +
							"        </tr>																																						\n" ;
		    CDireccionMedico objDireccion = null;
			for (int inti=0;inti<lstDireccionesMedico.size();inti++) {
				objDireccion = (CDireccionMedico)lstDireccionesMedico.get(inti);	
				strReturn = strReturn + "        <tr> 																																						\n" +
										"            <td  style='width: 50%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>							\n" +
										"            	<b><font color='black'>" + objDireccion.getStelefono() + "																														\n" +
										"            	</font></b>																																			\n" +
										"            </td> 																																					\n" +
										"            <td  style='width: 50%; font-weight: normal; font-size: xx-small; color: black; font-style: normal; font-variant: normal;'>							\n" +
										"            	<b><font color='black'>" + objDireccion.getCreferenciadireccion().getSreferenciadireccion() + " 																											\n" +
										"            </td>																																					\n" +
										"        </tr>																																						\n";
		    }
			iObjLog.debug("Consulta MedicosDao.getGridTelefonosMedico:Operacion...String de Direcciones..." + strReturn );			
			return strReturn + "</table>";		
	}
		
	
	
	public MedicoBean setMedicoAlta(MedicoBean objMedicoBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		List lstMedicos = new ArrayList();
		CMedico objMedicoHB = new CMedico();		
		List objListaDirecciones = new ArrayList();
		CDireccionMedico objDireccion =  null;
		Query objQuery2 = null;		
		try {			
            HibernateUtil.beginTrans();
            
            boolean existeMedico = false;
            
        	if (objMedicoBean.getCmedico().intValue()> 0) {		
//        		String keymedico = objMedicoBean.getKmedico() +"";
    			iObjLog.debug("Consulta MedicosDao.setMedicoAlta:...Por clave  " + objMedicoBean.getCmedico().intValue());
        		strQuery =  "select cM " +					
							" from CMedico cM " +					
							" where cM.cmarca = 14 and cM.cclave = "+objMedicoBean.getCmedico().intValue();
				objQuery = iObjSesion.createQuery(strQuery);
//				objQuery.setParameter("cmedicoparam",Long.parseLong(keymedico));
				lstMedicos = objQuery.list();
				if(lstMedicos != null) {
					if (lstMedicos.size() > 0) {
						existeMedico = true;
//						objMedicoHB = (CMedico)lstMedicos.get(0);
					}
				}			
        	}
        	
        	
        	
        	
//        	else {
//    			iObjLog.debug("Consulta MedicosDao.setMedicoActualizacion:...Por nombre o appellidopaterno o appellidomaterno " + objMedicoBean.getSnombre().trim() + " " + objMedicoBean.getSappaterno().trim() + " " + objMedicoBean.getSapmaterno().trim());
//        		strQuery =  "select cM " +					
//        					" from CMedico cM " +					
//							" where cM.cmarca = 14 AND cM.snombre like ('" + objMedicoBean.getSnombre().trim() + "') " +
//							" AND cM.sapellidopaterno like ('" + objMedicoBean.getSappaterno().trim() + "') " +
//        					" AND cM.sapellidomaterno like ('" + objMedicoBean.getSapmaterno().trim() + "') ";
//				objQuery = iObjSesion.createQuery(strQuery);
//				lstMedicos = objQuery.list();
//				if(lstMedicos != null) {
//					if (lstMedicos.size() > 0) {
//						objMedicoHB = (CMedico)lstMedicos.get(0);
//					}
//				}			        		
//        	} 
        	
        	
        	if(!existeMedico){
        		
        		objMedicoHB.setBsustentable(objMedicoBean.isBsustentable());
	        	objMedicoHB.setSmarcasventa(objMedicoBean.getSmarcasventa());
	        	objMedicoHB.setSusuarioweb(objMedicoBean.getSusuarioweb());
	//        	if (objMedicoBean.getKmedico() == 0) {
	        		objMedicoHB.setUser_id(objMedicoBean.getUserid());        		
	//        	}else{
	//        		objMedicoHB.setUser_id_change(objMedicoBean.getUserid());        		
	//        	}
	        	objMedicoHB.setSnombre(objMedicoBean.getSnombre().trim() + "");
	        	objMedicoHB.setSapellidopaterno(objMedicoBean.getSappaterno().trim() + "");
	        	objMedicoHB.setSapellidomaterno(objMedicoBean.getSapmaterno().trim() + "");
	        	objMedicoHB.setSrfc(objMedicoBean.getSrfc().trim() + "");
	        	objMedicoHB.setSemail(objMedicoBean.getScorreoelectro().trim() + "");      		
	        	objMedicoHB.setCclave(objMedicoBean.getCmedico().intValue());
	        		CEspecialidad objEspecialidad =  new CEspecialidad();
	        		objEspecialidad.setCespecialidad(new Integer(objMedicoBean.getCespecialidad()));
	        	objMedicoHB.setCespecialidad(objEspecialidad);
	        		CMarca objMarca = new CMarca();
	        		objMarca.setCmarca(new Integer(14));
	        	objMedicoHB.setCmarca(objMarca);
	        		CSexo objSexo = new CSexo();
	        		objSexo.setCsexo(new Integer(objMedicoBean.getUsexo()));
	        	objMedicoHB.setCsexo(objSexo);
	        		CZonaMedico objZonaMedico = new CZonaMedico();
	        		objZonaMedico.setCzona(new Integer(objMedicoBean.getCzona()));
	        	objMedicoHB.setCzonamedico(objZonaMedico);
	        	objMedicoHB.setBregistrado(true);
	        	objMedicoHB.setDnacimiento(new Formatos().getFecha(objMedicoBean.getSnacimiento()));        	
	        	objMedicoHB.setCformapagomedico(objMedicoBean.getCformapagomedico());
	        	objMedicoHB.setShorariovisita(objMedicoBean.getShorariovisita().trim() + " ");        	
	        	objMedicoHB.setScurp(objMedicoBean.getScurp().trim() + " ");
	        	objMedicoHB.setUcategoriamedico(objMedicoBean.getUcategoriamedico());
		        	CEstadoRegistro objEstadoRegistroMedico = new CEstadoRegistro();
		        	objEstadoRegistroMedico.setCestadoregistro(new Integer(objMedicoBean.getUestadomedico()));
	        	objMedicoHB.setCestadoregistro(objEstadoRegistroMedico);
	//         	if (objMedicoBean.getKmedico() == 0) {
	    			iObjLog.debug("Marca MedicosDao.setMedicoAlta Alta Medico");   
	    			ToolsDao objTool = new ToolsDao();
	    			
	    			objMedicoHB.setCclave(objMedicoBean.getCmedico().intValue());
	//    			objMedicoHB.setCclave(objTool.getSequenceNextId("cmedicoclave_sequence", iObjSesion.connection()).intValue());
	    			iObjSesion.save(objMedicoHB);
	    			  
	    			
					objDireccion = new CDireccionMedico();			
						CCodigoPostal objCodigoPostal =  new CCodigoPostal();
						objCodigoPostal.setCcodigopostal(new Integer(objMedicoBean.getKcodigopostal()));
					objDireccion.setCcodigopostal(objCodigoPostal);
					objDireccion.setSdireccion(objMedicoBean.getSdireccion().trim() + "");
						CEstadoRegistro objEstadoRegistro = new CEstadoRegistro();
						objEstadoRegistro.setCestadoregistro(new Integer(objMedicoBean.getCestadoregistro()));
					objDireccion.setCestadoregistro(objEstadoRegistro);
					objDireccion.setCmedico(objMedicoHB);
						CReferenciaDireccion objRefereDirecc = new CReferenciaDireccion();
						objRefereDirecc.setCreferenciadireccion(new Integer(objMedicoBean.getCtipoDireccion()));
					objDireccion.setCreferenciadireccion(objRefereDirecc);
					objDireccion.setStelefono(objMedicoBean.getStelefono().trim() + "");
					objDireccion.setUser_id(new Integer(objMedicoBean.getUserid()));
					objDireccion.setUser_id_change(new Integer(objMedicoBean.getUserid()));
					iObjSesion.save(objDireccion);            		        	        		        		
	//        	} else {
	//    			iObjLog.debug("Marca MedicosDao.setMedicoActualizacion Actualizacion Medico");         		
	//				strQuery = "select cDM " +					
	//				   " from CDireccionMedico cDM " +					
	//				   " where cDM.cmedico= " + objMedicoHB.getCmedico().intValue();
	//				objQuery2 = iObjSesion.createQuery(strQuery);
	//				objListaDirecciones = objQuery2.list(); 
	//				objDireccion = (CDireccionMedico)objListaDirecciones.get(0);			
	//					CCodigoPostal objCodigoPostal =  new CCodigoPostal();
	//					objCodigoPostal.setCcodigopostal(new Integer(objMedicoBean.getKcodigopostal()));
	//					
	//					CReferenciaDireccion cReferenciaDireccion = new CReferenciaDireccion();
	//					cReferenciaDireccion.setCreferenciadireccion(new Integer(objMedicoBean.getCtipoDireccion()));
	//				objDireccion.setCcodigopostal(objCodigoPostal);
	//				objDireccion.setCreferenciadireccion(cReferenciaDireccion);
	//				objDireccion.setSdireccion(objMedicoBean.getSdireccion().trim() + "");
	//				objDireccion.setStelefono(objMedicoBean.getStelefono().trim() + "");
	//				objDireccion.setUser_id(new Integer(objMedicoBean.getUserid()));
	//				objDireccion.setUser_id_change(new Integer(objMedicoBean.getUserid()));
	//				
	//				iObjSesion.update(objDireccion);            		        	        		
	//        		iObjSesion.update(objMedicoHB);            		        		
	//        	}
	    		iObjSesion.flush();            	
	//            HibernateUtil.commitTrans();	
    		
	    		objMedicoBean.setCmedico(new Long(objMedicoHB.getCclave()));
	    		objMedicoBean.setKmedico(objMedicoHB.getCmedico().intValue());
			}else{
				objMedicoBean.setUtipooperacion(3);
			}
		
    		
			iObjLog.debug("Saliendo MedicosDao.setMedicoAlta " + objMedicoBean.toString());
			return objMedicoBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosDao.setMedicoAlta: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}
	
	
	
	
	
	
	
	public MedicoBean setMedicoActualizacion(MedicoBean objMedicoBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		List lstMedicos = new ArrayList();
		CMedico objMedicoHB = new CMedico();		
		List objListaDirecciones = new ArrayList();
		CDireccionMedico objDireccion =  null;
		Query objQuery2 = null;		
		try {			
            HibernateUtil.beginTrans();
        	if (objMedicoBean.getKmedico()> 0) {		
//        		String keymedico = objMedicoBean.getKmedico() +"";
    			iObjLog.debug("Consulta MedicosDao.setMedicoActualizacion:...Por Numero Cliente  " + objMedicoBean.getKmedico());
        		strQuery =  "select cM " +					
							" from CMedico cM " +					
							" where cM.cmarca = 14 and cM.cmedico = "+objMedicoBean.getKmedico();
				objQuery = iObjSesion.createQuery(strQuery);
//				objQuery.setParameter("cmedicoparam",Long.parseLong(keymedico));
				lstMedicos = objQuery.list();
				if(lstMedicos != null) {
					if (lstMedicos.size() > 0) {
						objMedicoHB = (CMedico)lstMedicos.get(0);
					}
				}			
        	}
//        	else {
//    			iObjLog.debug("Consulta MedicosDao.setMedicoActualizacion:...Por nombre o appellidopaterno o appellidomaterno " + objMedicoBean.getSnombre().trim() + " " + objMedicoBean.getSappaterno().trim() + " " + objMedicoBean.getSapmaterno().trim());
//        		strQuery =  "select cM " +					
//        					" from CMedico cM " +					
//							" where cM.cmarca = 14 AND cM.snombre like ('" + objMedicoBean.getSnombre().trim() + "') " +
//							" AND cM.sapellidopaterno like ('" + objMedicoBean.getSappaterno().trim() + "') " +
//        					" AND cM.sapellidomaterno like ('" + objMedicoBean.getSapmaterno().trim() + "') ";
//				objQuery = iObjSesion.createQuery(strQuery);
//				lstMedicos = objQuery.list();
//				if(lstMedicos != null) {
//					if (lstMedicos.size() > 0) {
//						objMedicoHB = (CMedico)lstMedicos.get(0);
//					}
//				}			        		
//        	}        
        	objMedicoHB.setBsustentable(objMedicoBean.isBsustentable());
        	objMedicoHB.setSmarcasventa(objMedicoBean.getSmarcasventa());
        	objMedicoHB.setSusuarioweb(objMedicoBean.getSusuarioweb());
        	if (objMedicoBean.getKmedico() == 0) {
        		objMedicoHB.setUser_id(objMedicoBean.getUserid());        		
        	}else{
        		objMedicoHB.setUser_id_change(objMedicoBean.getUserid());        		
        	}
        	objMedicoHB.setSnombre(objMedicoBean.getSnombre().trim() + "");
        	objMedicoHB.setSapellidopaterno(objMedicoBean.getSappaterno().trim() + "");
        	objMedicoHB.setSapellidomaterno(objMedicoBean.getSapmaterno().trim() + "");
        	objMedicoHB.setSrfc(objMedicoBean.getSrfc().trim() + "");
        	objMedicoHB.setSemail(objMedicoBean.getScorreoelectro().trim() + "");      		
        	objMedicoHB.setCclave(objMedicoBean.getCmedico().intValue());
        		CEspecialidad objEspecialidad =  new CEspecialidad();
        		objEspecialidad.setCespecialidad(new Integer(objMedicoBean.getCespecialidad()));
        	objMedicoHB.setCespecialidad(objEspecialidad);
        		CMarca objMarca = new CMarca();
        		objMarca.setCmarca(new Integer(14));
        	objMedicoHB.setCmarca(objMarca);
        		CSexo objSexo = new CSexo();
        		objSexo.setCsexo(new Integer(objMedicoBean.getUsexo()));
        	objMedicoHB.setCsexo(objSexo);
        		CZonaMedico objZonaMedico = new CZonaMedico();
        		objZonaMedico.setCzona(new Integer(objMedicoBean.getCzona()));
        	objMedicoHB.setCzonamedico(objZonaMedico);
        	objMedicoHB.setBregistrado(true);
        	objMedicoHB.setDnacimiento(new Formatos().getFecha(objMedicoBean.getSnacimiento()));        	
        	objMedicoHB.setCformapagomedico(objMedicoBean.getCformapagomedico());
        	objMedicoHB.setShorariovisita(objMedicoBean.getShorariovisita().trim() + " ");        	
        	objMedicoHB.setScurp(objMedicoBean.getScurp().trim() + " ");
        	objMedicoHB.setUcategoriamedico(objMedicoBean.getUcategoriamedico());
	        	CEstadoRegistro objEstadoRegistroMedico = new CEstadoRegistro();
	        	objEstadoRegistroMedico.setCestadoregistro(new Integer(objMedicoBean.getUestadomedico()));
        	objMedicoHB.setCestadoregistro(objEstadoRegistroMedico);
         	if (objMedicoBean.getKmedico() == 0) {
    			iObjLog.debug("Marca MedicosDao.setMedicoActualizacion Alta Medico");   
    			ToolsDao objTool = new ToolsDao();
    			
    			objMedicoHB.setCclave(objMedicoBean.getCmedico().intValue());
//    			objMedicoHB.setCclave(objTool.getSequenceNextId("cmedicoclave_sequence", iObjSesion.connection()).intValue());
    			Integer id =  (Integer) iObjSesion.save(objMedicoHB);
    			iObjLog.debug("id:"+id);   
    			
				objDireccion = new CDireccionMedico();			
					CCodigoPostal objCodigoPostal =  new CCodigoPostal();
					objCodigoPostal.setCcodigopostal(new Integer(objMedicoBean.getKcodigopostal()));
				objDireccion.setCcodigopostal(objCodigoPostal);
				objDireccion.setSdireccion(objMedicoBean.getSdireccion().trim() + "");
					CEstadoRegistro objEstadoRegistro = new CEstadoRegistro();
					objEstadoRegistro.setCestadoregistro(new Integer(11));
				objDireccion.setCestadoregistro(objEstadoRegistro);
				objDireccion.setCmedico(objMedicoHB);
					CReferenciaDireccion objRefereDirecc = new CReferenciaDireccion();
					objRefereDirecc.setCreferenciadireccion(new Integer(objMedicoBean.getCtipoDireccion()));
				objDireccion.setCreferenciadireccion(objRefereDirecc);
				objDireccion.setStelefono(objMedicoBean.getStelefono().trim() + "");
				objDireccion.setUser_id(new Integer(objMedicoBean.getUserid()));
				objDireccion.setUser_id_change(new Integer(objMedicoBean.getUserid()));
				iObjSesion.save(objDireccion);            		        	        		        		
        	} else {
    			iObjLog.debug("Marca MedicosDao.setMedicoActualizacion Actualizacion Medico");         		
				strQuery = "select cDM " +					
				   " from CDireccionMedico cDM " +					
				   " where cDM.cmedico= " + objMedicoHB.getCmedico().intValue();
				objQuery2 = iObjSesion.createQuery(strQuery);
				objListaDirecciones = objQuery2.list(); 
				
				if(objListaDirecciones.size()>0){
					
					objDireccion = (CDireccionMedico)objListaDirecciones.get(0);			
					CCodigoPostal objCodigoPostal =  new CCodigoPostal();
					objCodigoPostal.setCcodigopostal(new Integer(objMedicoBean.getKcodigopostal()));
					
					CReferenciaDireccion cReferenciaDireccion = new CReferenciaDireccion();
					cReferenciaDireccion.setCreferenciadireccion(new Integer(objMedicoBean.getCtipoDireccion()));
					objDireccion.setCcodigopostal(objCodigoPostal);
					objDireccion.setCreferenciadireccion(cReferenciaDireccion);
					objDireccion.setSdireccion(objMedicoBean.getSdireccion().trim() + "");
					objDireccion.setStelefono(objMedicoBean.getStelefono().trim() + "");
					CEstadoRegistro cestadoRegistro = new CEstadoRegistro();
					cestadoRegistro.setCestadoregistro(new Integer(objMedicoBean.getCestadoregistro()));
					objDireccion.setCestadoregistro(cestadoRegistro);
					objDireccion.setUser_id(new Integer(objMedicoBean.getUserid()));
					objDireccion.setUser_id_change(new Integer(objMedicoBean.getUserid()));
					
					iObjSesion.update(objDireccion);            		        	        		
					iObjSesion.update(objMedicoHB);            		        		
				}else{
					objDireccion = new CDireccionMedico();			
					CCodigoPostal objCodigoPostal =  new CCodigoPostal();
					objCodigoPostal.setCcodigopostal(new Integer(objMedicoBean.getKcodigopostal()));
					objDireccion.setCcodigopostal(objCodigoPostal);
					objDireccion.setSdireccion(objMedicoBean.getSdireccion().trim() + "");
						CEstadoRegistro objEstadoRegistro = new CEstadoRegistro();
						objEstadoRegistro.setCestadoregistro(new Integer(objMedicoBean.getCestadoregistro()));
					objDireccion.setCestadoregistro(objEstadoRegistro);
					objDireccion.setCmedico(objMedicoHB);
						CReferenciaDireccion objRefereDirecc = new CReferenciaDireccion();
						objRefereDirecc.setCreferenciadireccion(new Integer(objMedicoBean.getCtipoDireccion()));
					objDireccion.setCreferenciadireccion(objRefereDirecc);
					objDireccion.setStelefono(objMedicoBean.getStelefono().trim() + "");
					
					
					objDireccion.setUser_id(new Integer(objMedicoBean.getUserid()));
					objDireccion.setUser_id_change(new Integer(objMedicoBean.getUserid()));
					iObjSesion.save(objDireccion);   
				}
				
        	}
    		iObjSesion.flush();            	
//            HibernateUtil.commitTrans();	 
    		objMedicoBean.setCmedico(new Long(objMedicoHB.getCclave()));
    		objMedicoBean.setKmedico(objMedicoHB.getCmedico().intValue());
			iObjLog.debug("Saliendo MedicosDao.setMedicoActualizacion " + objMedicoBean.toString());
			return objMedicoBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosDao.setMedicoActualizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}

	public MedicoBean setMedicoDireccionActualizacion(MedicoBean objMedicoBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		List lstMedicos = new ArrayList();
		CMedico objMedicoHB = new CMedico();		
		List objListaDirecciones = new ArrayList();
		CDireccionMedico objDireccion =  null;
		Query objQuery2 = null;		
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta MedicosDao.setMedicoActualizacion:...Por Numero Cliente  " + objMedicoBean.getCmedico());
    		strQuery =  "select cM " +					
						" from CMedico cM " +					
						" where cM.cclave = :cmedicoparam";
			objQuery = iObjSesion.createQuery(strQuery);
			objQuery.setParameter("cmedicoparam",objMedicoBean.getCmedico());
			lstMedicos = objQuery.list();
			if(lstMedicos != null) {
				if (lstMedicos.size() > 0) {
					objMedicoHB = (CMedico)lstMedicos.get(0);
				}
			}			
         	if (objMedicoBean.getCmedico().intValue() == 0) {
    			iObjLog.debug("Marca MedicosDao.setMedicoActualizacion Alta Medico");   
    			ToolsDao objTool = new ToolsDao();
    			objMedicoHB.setCclave(objTool.getSequenceNextId("cmedicoclave_sequence", iObjSesion.connection()).intValue());
         		iObjSesion.save(objMedicoHB);
				objDireccion = new CDireccionMedico();			
					CCodigoPostal objCodigoPostal =  new CCodigoPostal();
					objCodigoPostal.setCcodigopostal(new Integer(objMedicoBean.getKcodigopostal()));
				objDireccion.setCcodigopostal(objCodigoPostal);
				objDireccion.setSdireccion(objMedicoBean.getSdireccion().trim() + "");
					CEstadoRegistro objEstadoRegistro = new CEstadoRegistro();
					objEstadoRegistro.setCestadoregistro(new Integer(11));
				objDireccion.setCestadoregistro(objEstadoRegistro);
				objDireccion.setCmedico(objMedicoHB);
					CReferenciaDireccion objRefereDirecc = new CReferenciaDireccion();
					objRefereDirecc.setCreferenciadireccion(new Integer(1));
				objDireccion.setCreferenciadireccion(objRefereDirecc);
				objDireccion.setStelefono(objMedicoBean.getStelefono().trim() + "");
				iObjSesion.save(objDireccion);            		        	        		        		
        	} else {
    			iObjLog.debug("Marca MedicosDao.setMedicoActualizacion Actualizacion Medico");         		
				strQuery = "select cDM " +					
				   " from CDireccionMedico cDM " +					
				   " where cDM.cmedico= " + objMedicoHB.getCmedico().intValue();
				objQuery2 = iObjSesion.createQuery(strQuery);
				objListaDirecciones = objQuery2.list(); 
				objDireccion = (CDireccionMedico)objListaDirecciones.get(0);			
					CCodigoPostal objCodigoPostal =  new CCodigoPostal();
					objCodigoPostal.setCcodigopostal(new Integer(objMedicoBean.getKcodigopostal()));
				objDireccion.setCcodigopostal(objCodigoPostal);
				objDireccion.setSdireccion(objMedicoBean.getSdireccion().trim() + "");
				objDireccion.setStelefono(objMedicoBean.getStelefono().trim() + "");
				iObjSesion.update(objDireccion);            		        	        		
        		iObjSesion.update(objMedicoHB);            		        		
        	}
    		iObjSesion.flush();            	
			iObjLog.debug("Saliendo MedicosDao.setMedicoActualizacion " + objMedicoBean.toString());
			return objMedicoBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosDao.setMedicoActualizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}
	
	
	public void setMedicoActualizacionCorreoElectronico(int CMedico, String strCorreoElectronico) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		Query objQuery = null;
		String strQuery = "";
		List lstMedicos = new ArrayList();
		CMedico objMedicoHB = new CMedico();		
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta MedicosDao.setMedicoActualizacionCorreoElectronico:...Por Numero Cliente  " + CMedico + " Correo Electronico " + strCorreoElectronico);
    		strQuery =  "select cM " +					
						" from CMedico cM " +					
						" where cM.cmedico = :cmedicoparam";
			objQuery = iObjSesion.createQuery(strQuery);
			objQuery.setParameter("cmedicoparam",new Integer(CMedico));
			lstMedicos = objQuery.list();
			if(lstMedicos != null) {
				if (lstMedicos.size() > 0) {
					objMedicoHB = (CMedico)lstMedicos.get(0);
				}
			}			
        	objMedicoHB.setSemail(strCorreoElectronico.trim() + "");      		
    		iObjSesion.update(objMedicoHB);            		        		
    		iObjSesion.flush();            	
			iObjLog.debug("Saliendo MedicosDao.setMedicoActualizacion Cliente  " + CMedico + " Correo Electronico " + strCorreoElectronico);
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosDao.setMedicoActualizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}
	
	
	public MedicoBean setMedicoAltaBasico(MedicoBean objMedicoBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		CMedico objMedicoHB = new CMedico();		
		Query objQuery = null;
		String strQuery = "";
		List lstMedicos = new ArrayList();
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta MedicosDao.setMedicoActualizacion:...Por nombre o appellidopaterno o appellidomaterno " + objMedicoBean.getSnombre().trim() + " " + objMedicoBean.getSappaterno().trim() + " " + objMedicoBean.getSapmaterno().trim());
    		strQuery =  "select cM " +					
    					" from CMedico cM " +					
						" where cM.snombre = ('" + objMedicoBean.getSnombre().trim() + "') " +
						" AND cM.sapellidopaterno = ('" + objMedicoBean.getSappaterno().trim() + "') " +
    					" AND cM.sapellidomaterno = ('" + objMedicoBean.getSapmaterno().trim() + "') ";
			objQuery = iObjSesion.createQuery(strQuery);
			lstMedicos = objQuery.list();
			if(lstMedicos != null) {
				if (lstMedicos.size() > 0) {
					objMedicoHB = (CMedico)lstMedicos.get(0);
				}
			}			        		
            if (objMedicoHB.getCmedico() == null) {
	        	objMedicoHB.setSnombre(objMedicoBean.getSnombre().trim() + "");
	        	objMedicoHB.setSapellidopaterno(objMedicoBean.getSappaterno().trim() + "");
	        	objMedicoHB.setSapellidomaterno(objMedicoBean.getSapmaterno().trim() + "");
	        	objMedicoHB.setSrfc(objMedicoBean.getSrfc().trim());
	        	objMedicoHB.setSemail(objMedicoBean.getScorreoelectro().trim());      		
	        	objMedicoHB.setCclave(objMedicoBean.getCmedico().intValue());
	        		CEspecialidad objEspecialidad =  new CEspecialidad();
	        		objEspecialidad.setCespecialidad(new Integer(objMedicoBean.getCespecialidad()));
	        	objMedicoHB.setCespecialidad(objEspecialidad);
	        		CMarca objMarca = new CMarca();
	        		objMarca.setCmarca(new Integer(1));
	        	objMedicoHB.setCmarca(objMarca);
	//        	objMedicoHB.setCmedico(new Integer(objMedicoBean.getCmedico().intValue()));
	        		CSexo objSexo = new CSexo();
	        		objSexo.setCsexo(new Integer(objMedicoBean.getUsexo()));
	        	objMedicoHB.setCsexo(objSexo);
	        		CZonaMedico objZonaMedico = new CZonaMedico();
	        		objZonaMedico.setCzona(new Integer(objMedicoBean.getCzona()));
	        	objMedicoHB.setCzonamedico(objZonaMedico);
	        	objMedicoHB.setBregistrado(false);
	        	CEstadoRegistro objEstadoRegistroMedico = new CEstadoRegistro();
	        		objEstadoRegistroMedico.setCestadoregistro(new Integer(objMedicoBean.getUestadomedico()));
	        	objMedicoHB.setCestadoregistro(objEstadoRegistroMedico);        	
	        	objMedicoHB.setDnacimiento(new Date());        	
				iObjLog.debug("Marca MedicosDao.setMedicoAltaBasico Alta Medico");         		
	     		iObjSesion.save(objMedicoHB);
	    		iObjSesion.flush();            	
            }
//            HibernateUtil.commitTrans();	 
    		objMedicoBean.setCmedico(new Long(objMedicoHB.getCclave()));
    		objMedicoBean.setKmedico(objMedicoHB.getCmedico().intValue());
			iObjLog.debug("Saliendo MedicosDao.setMedicoAltaBasico " + objMedicoBean.toString());
		} catch (JDBCException aObjExcepcionjdbc) {
			objMedicoBean.setSnombre("");
			objMedicoBean.setSappaterno("El medico ya existe, por favor buscalo ...");
			objMedicoBean.setSapmaterno("");
			objMedicoBean.setCmedico(new Long(-1));
			iObjLog.error("ERROR JDBC MedicosDao.setMedicoAltaBasico: ", aObjExcepcionjdbc);
			throw aObjExcepcionjdbc;
		} catch (Exception aObjExcepcion) { 
			objMedicoBean.setSnombre("");
			objMedicoBean.setSappaterno("El medico ya existe, por favor buscalo ...");
			objMedicoBean.setSapmaterno("");
			objMedicoBean.setCmedico(new Long(-1));
			iObjLog.error("ERROR MedicosDao.setMedicoAltaBasico: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
		return objMedicoBean;
	}

	public MedicoBean inactivarMedico(MedicoBean objMedicoBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		CMedico objMedicoHB = new CMedico();		
		try {			
			MedicoBean objMedicoInactivar = (MedicoBean)this.buscarMedicos(objMedicoBean).get(0);
            HibernateUtil.beginTrans();
        	objMedicoHB.setSnombre(objMedicoBean.getSnombre() + "");
        	objMedicoHB.setSapellidopaterno(objMedicoBean.getSappaterno() + "");
        	objMedicoHB.setSapellidomaterno(objMedicoBean.getSapmaterno() + "");
        	objMedicoHB.setSrfc(objMedicoBean.getSrfc());
        	objMedicoHB.setSemail(objMedicoBean.getScorreoelectro());      		
        	objMedicoHB.setCclave(objMedicoBean.getCmedico().intValue());
        		CEspecialidad objEspecialidad =  new CEspecialidad();
        		objEspecialidad.setCespecialidad(new Integer(objMedicoBean.getCespecialidad()));
        	objMedicoHB.setCespecialidad(objEspecialidad);
        		CMarca objMarca = new CMarca();
        		objMarca.setCmarca(new Integer(1));
        	objMedicoHB.setCmarca(objMarca);
//        	objMedicoHB.setCmedico(new Integer(objMedicoBean.getCmedico().intValue()));
        		CSexo objSexo = new CSexo();
        		objSexo.setCsexo(new Integer(objMedicoBean.getUsexo()));
        	objMedicoHB.setCsexo(objSexo);
        		CZonaMedico objZonaMedico = new CZonaMedico();
        		objZonaMedico.setCzona(new Integer(objMedicoBean.getCzona()));
        	objMedicoHB.setCzonamedico(objZonaMedico);
        	objMedicoHB.setBregistrado(false);
        	objMedicoHB.setDnacimiento(new Date());        	
			iObjLog.debug("Marca MedicosDao.setMedicoAltaBasico Alta Medico");         		
     		iObjSesion.save(objMedicoHB);
    		iObjSesion.flush();            	
//            HibernateUtil.commitTrans();	 
    		objMedicoBean.setCmedico(new Long(objMedicoHB.getCclave()));
    		objMedicoBean.setKmedico(objMedicoHB.getCmedico().intValue());
			iObjLog.debug("Saliendo MedicosDao.setMedicoAltaBasico " + objMedicoBean.toString());
			return objMedicoBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosDao.setMedicoAltaBasico: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}

	public String ChangeMedicoOrden(int KOrdenSucursal, int cClaveMedico, int User_id) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		String strSQL = "";
		try {			
			Connection objConnection = iObjSesion.connection();
			Statement stmt = objConnection.createStatement();
			strSQL = "UPDATE T_ORDEN_SUCURSAL SET user_id_change = " + User_id + ",CMEDICO=(SELECT CMEDICO FROM C_MEDICO WHERE CCLAVE = " + cClaveMedico + "),SMEDICO=(SELECT SAPELLIDOPATERNO || ' ' || SAPELLIDOMATERNO || ' ' || SNOMBRE FROM C_MEDICO WHERE CCLAVE = " + cClaveMedico + ") WHERE KORDENSUCURSAL = " + KOrdenSucursal + " AND KCOMISIONMEDICO = 0 " ;
			iObjLog.debug("Consulta MedicosDao.ChangeMedicoOrden " + strSQL);
			stmt.execute(strSQL);			
			iObjLog.debug("Saliendo MedicosDao.ChangeMedicoOrden ");
			return "Exito en la Actualizacion";
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR MedicosDao.ChangeMedicoOrden: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}
	
	
}
