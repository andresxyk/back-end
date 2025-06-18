package mx.com.web2lab.backend.dao.ap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.PacienteBean;
import mx.com.web2lab.backend.dao.ap.mayoreo.PacientesMayoreoDao;
import mx.com.web2lab.backend.dao.mail.MailDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal;
import mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro;
import mx.com.web2lab.backend.hbm.om.ap.CMarca;
import mx.com.web2lab.backend.hbm.om.ap.TPaciente;
import mx.com.web2lab.backend.util.formatos.FormateaFecha;
import mx.com.web2lab.backend.util.formatos.Formatos;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PacientesDao {

	private static Log iObjLog = LogFactory.getLog(PacientesDao.class);
	    
	private Session iObjSesion = null;
	
	public PacientesDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public PacienteBean setPacienteActualizacion(PacienteBean objPacienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		TPaciente objPaciente = new TPaciente();
		List objListaPacientes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		try {			
            HibernateUtil.beginTrans();
        	if (objPacienteBean.getKpacientefundacion().intValue() > 0) {			
    			iObjLog.debug("Consulta PacientesDao.setPacienteActualizacion:...Por Numero Paciente  " + objPacienteBean.getKpacientefundacion().intValue());
        		strQuery =  "select bPF " +					
							" from TPaciente bPF " +					
							" where bPF.kpaciente = :kpaciente and bPF.cmarca.cmarca = :cmarca ";
				objQuery = iObjSesion.createQuery(strQuery);
				objQuery.setParameter("kpaciente", objPacienteBean.getKpacientefundacion());
				objQuery.setParameter("cmarca", new Integer(objPacienteBean.getCmarca()));
				objListaPacientes = objQuery.list();
				if(objListaPacientes != null) {
					if (objListaPacientes.size() > 0) {
						objPaciente = (TPaciente)objListaPacientes.get(0);
					}
				}			
        	} else {
    			iObjLog.debug("Consulta PacientesDao.setPacienteActualizacion:...Por Nombre Paciente  " + objPacienteBean.getSnombre().trim() + " " + objPacienteBean.getSappaterno().trim() + " " + objPacienteBean.getSapmaterno().trim() + " Fecha Nacimiento " + objPacienteBean.getSnacimiento());
        		FormateaFecha objFormateoFecha = new FormateaFecha();
				strQuery =  "select bPF " +					
							" from TPaciente bPF " +					
							" where bPF.snombre = bPF.snombre " +
							" AND bPF.cmarca.cmarca = " + objPacienteBean.getCmarca() +
							" AND bPF.snombre like ('" + objPacienteBean.getSnombre().trim() + "') " +
							" AND bPF.sapellidopaterno like ('" + objPacienteBean.getSappaterno().trim() + "') " +
							" AND bPF.sapellidomaterno like ('" + objPacienteBean.getSapmaterno().trim() + "') " +
							" AND (bPF.dnacimiento between to_date('" + objFormateoFecha.getFechaddmm4y(objPacienteBean.getDnacimiento()) + " 00:00:00', 'dd-mm-yyyy hh24:mi:ss') AND to_date('" + objFormateoFecha.getFechaddmm4y(objPacienteBean.getDnacimiento()) + " 23:59:59', 'dd-mm-yyyy hh24:mi:ss')) ";				
				objFormateoFecha = null;
				objQuery = iObjSesion.createQuery(strQuery);
				objListaPacientes = objQuery.list();
				if(objListaPacientes != null) {
					if (objListaPacientes.size() > 0) {
						objPaciente = (TPaciente)objListaPacientes.get(0);
						objPacienteBean.setKpacientefundacion(objPaciente.getKpaciente());
					}
				}			        		
        	}
			objPaciente.setSnombre(objPacienteBean.getSnombre().trim());
			objPaciente.setSapellidopaterno(objPacienteBean.getSappaterno().trim());
			objPaciente.setSapellidomaterno(objPacienteBean.getSapmaterno().trim());
			objPaciente.setUtipopaciente(objPacienteBean.getUtipopaciente());
			if (objPacienteBean.getCsexo() == 1) {
				objPaciente.setBsexo(1);				
			} else {
				objPaciente.setBsexo(0);								
			}
			objPaciente.setDnacimiento(objPacienteBean.getDnacimiento());
			objPaciente.setKpaciente(new Integer(objPacienteBean.getKpacientefundacion().intValue()));	
			objPaciente.setScorreoelectronico(objPacienteBean.getScorreoelectronico() + "");
				CCodigoPostal objCP = new CCodigoPostal();
				objCP.setCcodigopostal(new Integer(objPacienteBean.getCcodigopostal()));
			objPaciente.setCcodigopostal(objCP);
				CMarca objMarca = new CMarca();
				objMarca.setCmarca(new Integer(objPacienteBean.getCmarca()));
			objPaciente.setCmarca(objMarca);
				CEstadoRegistro objER = new CEstadoRegistro();
				objER.setCestadoregistro(new Integer(12));
			objPaciente.setCestadoregistro(objER);	
			objPaciente.setSdireccion(objPacienteBean.getSdireccion().trim() + "");
			objPaciente.setStelefono(objPacienteBean.getStelefono().trim() + "");		
			objPaciente.setScelular(objPacienteBean.getScelular().trim() + "");					
        	if (objPaciente.getKpaciente().intValue() == 0) {
    			objPaciente.setDregistro(new Date());
    			objPaciente.setUserid(new BigDecimal(objPacienteBean.getCusuario()));				
    			objPaciente.setUseridchange(new BigDecimal(objPacienteBean.getCusuario()));	
    			objPaciente.setUvisitaece(0);
    			objPaciente.setUopcionenviocorreo(objPacienteBean.getUopcionenviocorreo());			    			
    			if (objPaciente.getUopcionenviocorreo() >= 99) {
            		GeneracionPasswordDao objGeneracionPasswordDao = new GeneracionPasswordDao();
        			objPaciente.setSpassword(objGeneracionPasswordDao.getPassword());
        			objPaciente.setSpasswordenvio(objGeneracionPasswordDao.getPassword());
        			objGeneracionPasswordDao = null;
//            		MailDao objMailDao = new MailDao();
//            		objMailDao.sendEmailECE("Bienvenido a tu Expediente Cl&iacute;nico Electr&oacute;nico de Laboratorio Olab", objPaciente);
//            		objMailDao = null;
            	} else {
        			objPaciente.setSpassword(" ");
        			objPaciente.setSpasswordenvio(" ");
            	}
        		iObjSesion.save(objPaciente);
        		iObjSesion.flush();            	
    			if ((objPaciente.getUopcionenviocorreo() >= 99) && (objPaciente.getUopcionenviocorreo() < 199)) {
//            		MailDao objMailDao = new MailDao();
//            		objMailDao.sendEmailECEPaciente("Bienvenido a tu Expediente Cl&iacute;nico Electr&oacute;nico de Laboratorio Olab", objPaciente);
//            		objMailDao = null;
            	}        		
    			objPacienteBean.setKpacientefundacion(objPaciente.getKpaciente());
        		if (objPacienteBean.getSvalorexpediente().trim().length() > 0) {
        			PacientesMayoreoDao objPacienteMayoreoDao = new PacientesMayoreoDao();	
        			objPacienteMayoreoDao.guardarPacienteMetro(objPacienteBean,iObjSesion);
        			objPacienteMayoreoDao = null;
        		}
        	} else {
    			objPaciente.setUseridchange(new BigDecimal(objPacienteBean.getCusuario()));				
    			if ((objPacienteBean.getUopcionenviocorreo() >= 99) && ((objPaciente.getUopcionenviocorreo() < 99) || (objPaciente.getUopcionenviocorreo() > 199))) {
            		GeneracionPasswordDao objGeneracionPasswordDao = new GeneracionPasswordDao();
            		String strTitulo = "";
            		if (objPaciente.getSpassword().trim().toString() == "" || objPaciente.getSpassword().trim().toString().equals("")) {
            			objPaciente.setSpassword(objGeneracionPasswordDao.getPassword());
            		} else {
            			objPaciente.setSpassword(objPaciente.getSpassword());
            		}
        			strTitulo = "Actualizacion a tu Expediente Clinico Electronico de Laboratorio Olab";
        			objPaciente.setSpasswordenvio(objGeneracionPasswordDao.getPassword());
        			objGeneracionPasswordDao = null;
            		MailDao objMailDao = new MailDao();
            		objMailDao.sendEmailECEPaciente(strTitulo, objPaciente);
            		objMailDao = null;
        			objPaciente.setUopcionenviocorreo(objPacienteBean.getUopcionenviocorreo());			            		
            	} else {
        			objPaciente.setUopcionenviocorreo(objPacienteBean.getUopcionenviocorreo());			            		           		
            	}
        		iObjSesion.update(objPaciente);            		
        		iObjSesion.flush();            	
        		if (objPacienteBean.getSvalorexpediente().trim().length() > 0) {
        			PacientesMayoreoDao objPacienteMayoreoDao = new PacientesMayoreoDao();	
        			objPacienteMayoreoDao.guardarPacienteMetro(objPacienteBean,iObjSesion);
        			objPacienteMayoreoDao = null;
        		}
        	}
            objPacienteBean.setKpacientefundacion(objPaciente.getKpaciente());
			iObjLog.debug("Saliendo PacientesDao.setPacienteActualizacion:Saliendo...  " + objPaciente.toString());
			return objPacienteBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.setPacienteActualizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	

	public String ressetPasswordECE(PacienteBean objPacienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		TPaciente objPaciente = new TPaciente();
		List objListaPacientes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
		String strReturn = "";
		GeneracionPasswordDao objGeneracionPasswordDao = new GeneracionPasswordDao();
		MailDao objMailDao = new MailDao();
		try {			
            HibernateUtil.beginTrans();
			iObjLog.debug("Consulta PacientesDao.ressetPasswordECE:...Por Numero Paciente  " + objPacienteBean.getKpacientefundacion().intValue());
    		strQuery =  "select bPF " +					
						" from TPaciente bPF " +					
						" where bPF.kpaciente = :kpaciente";
			objQuery = iObjSesion.createQuery(strQuery);
			objQuery.setParameter("kpaciente", objPacienteBean.getKpacientefundacion());
			objListaPacientes = objQuery.list();
			if(objListaPacientes != null) {
				if (objListaPacientes.size() > 0) {
					objPaciente = (TPaciente)objListaPacientes.get(0);
				}
			}			
			objPaciente.setUseridchange(new BigDecimal(objPacienteBean.getCusuario()));				
			objPaciente.setSpassword(objGeneracionPasswordDao.getPassword());
			objPaciente.setSpasswordenvio(objGeneracionPasswordDao.getPassword());            			
    		iObjSesion.update(objPaciente);            		
    		iObjSesion.flush();            	    			
    		String strTitulo = "Recuperacion Password de tu Expediente Clinico Electronico de Laboratorio Olab";
        	objMailDao.sendEmailECEPaciente(strTitulo, objPaciente);
			iObjLog.debug("Saliendo PacientesDao.ressetPasswordECE:Saliendo...  " + objPaciente.toString());
			strReturn = "Exito en el reseteo del Password";
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.ressetPasswordECE: ", aObjExcepcion);
			strReturn = "ERROR PacientesDao.ressetPasswordECE";
			throw aObjExcepcion;
        } finally{
        	objMailDao = null;
			objGeneracionPasswordDao = null;
			objListaPacientes = null;
			objPaciente = null;
			objPacienteBean = null;
        	HibernateUtil.closeSession();
		}		
		return strReturn;
	}	
	
	
	public PacienteBean buscarPaciente(PacienteBean objPacienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List objListaPacientes = new ArrayList();
			Query objQuery = null;
			String strQuery = "";
	    	try{
	            HibernateUtil.beginTrans();
				iObjLog.debug("Entrando PacientesDao.buscarPaciente:kPaciente..." + objPacienteBean.getKpacientefundacion() + ".....Marca " + objPacienteBean.getCmarca());
//					strQuery = "select bPF " +					
//							" from TPaciente bPF " +					
//							" where bPF.kpaciente = :kpaciente and bPF.cmarca.cmarca = :cmarca ";
					strQuery = "select bPF " +					
							" from TPaciente bPF " +					
							" where bPF.kpaciente = :kpaciente ";
					objQuery = iObjSesion.createQuery(strQuery);
					objQuery.setParameter("kpaciente", objPacienteBean.getKpacientefundacion());
//					objQuery.setParameter("cmarca", new Integer(objPacienteBean.getCmarca()));
					objListaPacientes = objQuery.list();
//	            HibernateUtil.commitTrans();	 				
				if(objListaPacientes != null) {
					TPaciente objPaciente = (TPaciente)objListaPacientes.get(0);
					objPacienteBean.setSnombre(objPaciente.getSnombre());
					objPacienteBean.setSappaterno(objPaciente.getSapellidopaterno());
					if (objPaciente.getSapellidomaterno() == null) {
						objPacienteBean.setSapmaterno(" ");												
					} else {
						objPacienteBean.setSapmaterno(objPaciente.getSapellidomaterno() + " ");						
					}
					objPacienteBean.setBregistroactivo(true);	
					if (objPaciente.isBsexo() == 1) {
						objPacienteBean.setCsexo(1);						
					} else {
						objPacienteBean.setCsexo(0);						
					}
					objPacienteBean.setCusuario(objPaciente.getUserid().intValue());				
					objPacienteBean.setDnacimiento(objPaciente.getDnacimiento());
					objPacienteBean.setDregistro(objPaciente.getDregistro());
					objPacienteBean.setKpacientefundacion(objPaciente.getKpaciente());	
					objPacienteBean.setCcodigopostal(objPaciente.getCcodigopostal().getCcodigopostal().intValue());
					objPacienteBean.setScodigopostal(objPaciente.getCcodigopostal().getCpostal());
					objPacienteBean.setUtipopaciente(objPaciente.getUtipopaciente());
					objPacienteBean.setScolonia(objPaciente.getCcodigopostal().getScolonia());
					objPacienteBean.setSdelegmuni(objPaciente.getCcodigopostal().getSdelegacionmunicipio());
					objPacienteBean.setSdireccion(objPaciente.getSdireccion());
					objPacienteBean.setSciudad(objPaciente.getCcodigopostal().getSestado());
					objPacienteBean.setScorreoelectronico(objPaciente.getScorreoelectronico());
					objPacienteBean.setStelefono(objPaciente.getStelefono());	
					objPacienteBean.setScelular(objPaciente.getScelular());						
					objPacienteBean.setSnacimiento(new Formatos().getFecha(objPaciente.getDnacimiento()));		
					objPacienteBean.setUopcionenviocorreo(objPaciente.getUopcionenviocorreo());
					objPacienteBean.setSpasswordexpediente(objPaciente.getSpassword());
//					if (objPacienteBean.getSvalorexpediente().trim() != "") {
						PacientesMayoreoDao objPacienteMayoreoDAO = new PacientesMayoreoDao();
						objPacienteBean = objPacienteMayoreoDAO.buscarPacienteMetro(objPacienteBean);
						objPacienteMayoreoDAO = null;
//					}
				}			
			iObjLog.debug("Saliendo PacientesDao.buscarPaciente:Saliendo...  " + objPacienteBean.toString());
			return objPacienteBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.buscarPaciente: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		

	public void enviarCorreoBienvenidaECEPaciente(PacienteBean objPacienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List objListaPacientes = new ArrayList();
			Query objQuery = null;
			String strQuery = "";
	    	try{
	            HibernateUtil.beginTrans();
				iObjLog.debug("Entrando PacientesDao.enviarCorreoBienvenidaECEPaciente:kPaciente..." + objPacienteBean.getKpacientefundacion() + ".....Marca " + objPacienteBean.getCmarca());
					strQuery = "select bPF " +					
							" from TPaciente bPF " +					
							" where bPF.kpaciente = :kpaciente ";
					objQuery = iObjSesion.createQuery(strQuery);
					objQuery.setParameter("kpaciente", objPacienteBean.getKpacientefundacion());
					objListaPacientes = objQuery.list();
				if(objListaPacientes != null) {
					TPaciente objPaciente = (TPaciente)objListaPacientes.get(0);
            		MailDao objMailDao = new MailDao();
            		objMailDao.sendEmailECEPaciente("Bienvenido a tu Expediente Cl&iacute;nico Electr&oacute;nico de Laboratorio Olab", objPaciente);
            		objMailDao = null;
				}			
			iObjLog.debug("Saliendo PacientesDao.enviarCorreoBienvenidaECEPaciente:Saliendo...  " + objPacienteBean.toString());
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.enviarCorreoBienvenidaECEPaciente: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		
	
	public PacienteBean actualizaVisitaPaciente(PacienteBean objPacienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List objListaPacientes = new ArrayList();
			Query objQuery = null;
			String strQuery = "";
	    	try{
	            HibernateUtil.beginTrans();
					strQuery = "select bPF " +					
							" from TPaciente bPF " +					
							" where bPF.kpaciente = :kpaciente ";
					objQuery = iObjSesion.createQuery(strQuery);
					objQuery.setParameter("kpaciente", objPacienteBean.getKpacientefundacion());
					objListaPacientes = objQuery.list();
				if(objListaPacientes != null) {
					TPaciente objPaciente = (TPaciente)objListaPacientes.get(0);
					objPaciente.setUvisitaece(objPaciente.getUvisitaece() + 1);
	        		iObjSesion.update(objPaciente);            		
	        		iObjSesion.flush();            	
				}			
			iObjLog.debug("Saliendo PacientesDao.buscarPaciente:Saliendo...  " + objPacienteBean.toString());
			return objPacienteBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.buscarPaciente: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		
	
	public List buscarPacientes(PacienteBean objPacienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List lstReturn = new ArrayList();
			java.sql.Connection objConn = null;
			java.sql.ResultSet objRst = null;
			java.sql.Statement objStmt = null;
			String strQuery = "";
	    	try{
				iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...  " + objPacienteBean.toString());
//	            HibernateUtil.beginTrans();	            
	            objConn = iObjSesion.connection();
	            objStmt = objConn.createStatement();
	            
	            	if (objPacienteBean.getCconvenio() > 0) {
 						strQuery = "select bPF.* 				" +					
								   " from T_Paciente bPF 		" +
								   "      inner join T_Orden_Sucursal tOS on bPF.kpaciente=tOS.kpaciente  " +					
								   " where bPF.snombre=bPF.snombre and tOS.cconvenio = " + objPacienteBean.getCconvenio() + " AND bPF.cmarca = " + objPacienteBean.getCmarca() + " ";
	            	} else if ((objPacienteBean.getCsexo() > 0) && (objPacienteBean.getScorreoelectronico() != null)) {				
	 						strQuery =  "select bPF.* " +					
										" from T_Paciente bPF " +
									    "      inner join T_Orden_Sucursal tOS on bPF.kpaciente=tOS.kpaciente  " +					
										" where bPF.snombre=bPF.snombre and tOS.csucursal = " + objPacienteBean.getCsexo() + " AND bPF.cmarca = " + objPacienteBean.getCmarca() + " ";
	            	} else {
	            		if (objPacienteBean.getCmarca() > 1) {
	            			if (objPacienteBean.getCsucursal() > 9000) {
		 						strQuery =  "select bPF.* " +					
											" from T_Paciente bPF " +
										    "      inner join T_Orden_Sucursal tOS on bPF.kpaciente=tOS.kpaciente  " +					
											" where bPF.snombre=bPF.snombre AND bPF.cmarca = " + objPacienteBean.getCmarca() + " ";
	            			} else {
		 						strQuery =  "select bPF.* " +					
											" from T_Paciente bPF " +
										    "      inner join T_Orden_Sucursal tOS on bPF.kpaciente=tOS.kpaciente  " +					
											" where bPF.snombre=bPF.snombre and tOS.csucursal = " + objPacienteBean.getCsucursal() + " AND bPF.cmarca = " + objPacienteBean.getCmarca() + " ";
	            			}
	            		} else {
							strQuery = "select bPF.* " +					
									   " from T_Paciente bPF " +					
									   " where bPF.snombre=bPF.snombre AND bPF.cmarca = " + objPacienteBean.getCmarca() + " ";
	            		}
	            	}
	            	
					if (objPacienteBean.getSnombre().trim().toString().length() > 0 ) {
						iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...Nombre  1" +  objPacienteBean.getSnombre() + "2");
						strQuery += " AND bPF.snombre like ('" + objPacienteBean.getSnombre() + "%') ";
					}
					if (objPacienteBean.getSappaterno().trim().toString().length() > 0) {
						iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...Apellido Paterno  1" +  objPacienteBean.getSappaterno() + "2");
						strQuery += " AND bPF.sapellidopaterno like ('" + objPacienteBean.getSappaterno() + "%') ";
					}
					if (objPacienteBean.getSapmaterno().trim().toString().length() > 0) {
						iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...Apellido Materno  1" +  objPacienteBean.getSapmaterno() + "2");
						strQuery += " AND bPF.sapellidomaterno like ('" + objPacienteBean.getSapmaterno() + "%') ";
					}
					if (objPacienteBean.getScorreoelectronico() != null) {
						if (objPacienteBean.getScorreoelectronico().trim().toString().length() > 0) {
							iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...Correo Electronico  1" +  objPacienteBean.getScorreoelectronico() + "2");
							strQuery += " AND (bPF.scorreoelectronico like ('%@%.com') \n" + 
										" OR bPF.scorreoelectronico like ('%@%.com') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.mx') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.gob') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.uk') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.edu') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.es')) ";							 
						}
					}					
					strQuery = strQuery + " order by bPF.kpaciente ";
					iObjLog.debug("Entrando PacientesDao.buscarPacientes:Consulta...  " + strQuery);
					objRst = objStmt.executeQuery(strQuery);
					int kPaciente = 0;					
					while (objRst.next()) {
						if ((kPaciente == 0) || (kPaciente != objRst.getInt("kpaciente"))) {
							objPacienteBean = new PacienteBean();
							objPacienteBean.setSnombre(objRst.getString("snombre"));
							objPacienteBean.setSappaterno(objRst.getString("sapellidopaterno"));
							if (objRst.getString("sapellidomaterno") == null) {
								objPacienteBean.setSapmaterno(" ");									
							} else {
								objPacienteBean.setSapmaterno(objRst.getString("sapellidomaterno") +  " ");									
							}
							objPacienteBean.setKpacientefundacion(new Integer(objRst.getInt("kpaciente")));
							if (objRst.getDate("dnacimiento") != null) {
								objPacienteBean.setSnacimiento(new Formatos().getFechaNumeros(objRst.getDate("dnacimiento")));					
							}
							objPacienteBean.setScorreoelectronico(objRst.getString("scorreoelectronico") + "");
							lstReturn.add(objPacienteBean);
						}
						kPaciente = objRst.getInt("kpaciente");
					}
			iObjLog.debug("Saliendo PacientesDao.buscarPacientes:Saliendo...  " + objPacienteBean.toString());
			return lstReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.buscarPacientes:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
			objRst = null;
			objStmt = null;
        	HibernateUtil.closeSession();
		}		
   	}			
	

	public List buscarPacientes2(PacienteBean objPacienteBean, String strTypeBuscar) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List objListaPacientes = new ArrayList();
			List lstReturn = new ArrayList();
			Query objQuery = null;
			String strQuery = "";
	    	try{
				iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...  " + objPacienteBean.toString());
	            HibernateUtil.beginTrans();
	            	if (objPacienteBean.getCconvenio() > 0) {
 						strQuery = "select bPF " +					
								" from TPaciente bPF " +
								"      inner join bPF.tordensucursals tOS " +					
								" where bPF.snombre=bPF.snombre and tOS.cconvenio = " + objPacienteBean.getCconvenio();
	            	} else if ((objPacienteBean.getCsexo() > 0) && (objPacienteBean.getScorreoelectronico() != null)) {				
	 						strQuery =  "select bPF " +					
										" from TPaciente bPF " +
										"      inner join bPF.tordensucursals tOS " +					
										" where bPF.snombre=bPF.snombre and tOS.csucursalbycsucursal.csucursal = " + objPacienteBean.getCsexo() + " ";
	            	} else {
						strQuery = "select bPF " +					
								" from TPaciente bPF " +					
								" where bPF.snombre=bPF.snombre ";
	            	}
					if (objPacienteBean.getSnombre().trim().toString().length() > 0 ) {
						iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...Nombre  1" +  objPacienteBean.getSnombre() + "2");
						strQuery += " AND bPF.snombre like ('" + objPacienteBean.getSnombre() + "%') ";
					}
					if (objPacienteBean.getSappaterno().trim().toString().length() > 0) {
						iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...Apellido Paterno  1" +  objPacienteBean.getSappaterno() + "2");
						strQuery += " AND bPF.sapellidopaterno like ('" + objPacienteBean.getSappaterno() + "%') ";
					}
					if (objPacienteBean.getSapmaterno().trim().toString().length() > 0) {
						iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...Apellido Materno  1" +  objPacienteBean.getSapmaterno() + "2");
						strQuery += " AND bPF.sapellidomaterno like ('" + objPacienteBean.getSapmaterno() + "%') ";
					}
					if (objPacienteBean.getScorreoelectronico() != null) {
						if (objPacienteBean.getScorreoelectronico().trim().toString().length() > 0) {
							iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...Correo Electronico  1" +  objPacienteBean.getScorreoelectronico() + "2");
							strQuery += " AND (bPF.scorreoelectronico like ('%@%.com') \n" + 
										" OR bPF.scorreoelectronico like ('%@%.com') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.mx') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.gob') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.uk') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.edu') 											\n" +
										" OR bPF.scorreoelectronico like ('%@%.es')) ";							 
						}
					}
					strQuery = strQuery + " order by bPF.kpaciente ";
					iObjLog.debug("Entrando PacientesDao.buscarPacientes:Consulta...  " + strQuery);
					objQuery = iObjSesion.createQuery(strQuery);
					objListaPacientes = objQuery.list();
					iObjLog.debug("Entrando PacientesDao.buscarPacientes:Resultado...  " + objListaPacientes.size());
					int kPaciente = 0;					
					 if (objListaPacientes != null) {
							for (int i = 0; i < objListaPacientes.size() ; i++)
							{
								TPaciente objPaciente = (TPaciente)objListaPacientes.get(i);
								if ((kPaciente == 0) || (kPaciente != objPaciente.getKpaciente().intValue())) {
									objPacienteBean = new PacienteBean();
									objPacienteBean.setSnombre(objPaciente.getSnombre());
									objPacienteBean.setSappaterno(objPaciente.getSapellidopaterno());
									if (objPaciente.getSapellidomaterno() == null) {
										objPacienteBean.setSapmaterno(" ");									
									} else {
										objPacienteBean.setSapmaterno(objPaciente.getSapellidomaterno() +  " ");									
									}
									objPacienteBean.setKpacientefundacion(objPaciente.getKpaciente());
									if (objPaciente.getDnacimiento() != null) {
										objPacienteBean.setSnacimiento(new Formatos().getFechaNumeros(objPaciente.getDnacimiento()));					
									}
									objPacienteBean.setScorreoelectronico(objPaciente.getScorreoelectronico() + "");
									lstReturn.add(objPacienteBean);
								}
								kPaciente = objPaciente.getKpaciente().intValue();
							}
						}
//				HibernateUtil.commitTrans();	 				
			iObjLog.debug("Saliendo PacientesDao.buscarPacientes:Saliendo...  " + objPacienteBean.toString());
			return lstReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.buscarPacientes:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
   	}			
}
