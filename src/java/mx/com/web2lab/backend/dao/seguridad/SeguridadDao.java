package mx.com.web2lab.backend.dao.seguridad;

import java.sql.CallableStatement;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.com.web2lab.backend.hbm.om.sistema.TurbineSistema;
import mx.com.web2lab.backend.hbm.om.sistema.TurbineCalendar;
import mx.com.web2lab.backend.util.cacheestatus.CachesUsuarios;
import mx.com.web2lab.backend.dao.sistema.CatalogosPKGSistemaDao;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class SeguridadDao{
	
	/** Log de la aplicaci&oacute;n */
	private static Log iObjLog = LogFactory.getLog(SeguridadDao.class);
	
	/** Sesion de Hibernate <code>objSesion</code> */
	private Session iObjSesion = null;
	
	/**
	 * Constructor
	 */
	public SeguridadDao(Session aObjSesion) {
		iObjSesion = aObjSesion;		
	}
	
	public boolean insertaGrupo(String strGrupo)throws Exception{
		boolean inserto = false;
		TurbineSistema objSistema = null;		
		try{
			objSistema = this.getGrupoSistema(strGrupo,false);
			//Se verifica si existe el grupo
			if(objSistema != null){
				//El grupo ya existe y no se insertara
				iObjLog.debug("No se insertara el grupo sistema");				
			}else{
				//El grupo se insertara
				objSistema = new TurbineSistema();
				objSistema.setSsistema(strGrupo);
				iObjSesion.save(objSistema);
				iObjSesion.flush();
				iObjLog.debug("Se insertara el grupo sistema");
				inserto = true;
			}
			return inserto;
		}catch (Exception aError){
			iObjLog.error("SeguridadDao:insertaGrupo:Error:",aError);
			throw aError;
		}			
	}
	
	/**
	 * Metodo utilizado para actualizar la descripcion del grupo dado 
	 * @param strGrupoAnt
	 * @param strGrupoNuevo
	 * @return
	 * @throws Exception
	 */
	public boolean actualizaGrupo(String strGrupoAnt, String strGrupoNuevo)throws Exception{
		boolean actualizo = false;
		TurbineSistema objSistema = null;
		TurbineSistema objSistemaNuevo = null;
		try{
			objSistema = this.getGrupoSistema(strGrupoAnt,false);
			//Se verifica si existe el grupo
			if(objSistema != null){
				//El grupo ya existe y se actualizara
				objSistemaNuevo = this.getGrupoSistema(strGrupoNuevo,false);
				if(objSistemaNuevo != null){
					//El grupo no se actualizara porque ya existe				
					iObjLog.debug("No se actualizara el grupo sistema");
				}else{
					objSistema.setSsistema(strGrupoNuevo);
					iObjSesion.update(objSistema);
					iObjSesion.flush();
					iObjLog.debug("Se actualizara el grupo sistema");
					actualizo = true;
				}				
			}else{
				//El grupo no se actualizara				
				iObjLog.debug("No se actualizara el grupo sistema");				
			}
			return actualizo;
		}catch (Exception aError){
			iObjLog.error("SeguridadDao:actualizaGrupo:Error:",aError);
			throw aError;
		}			
	}
	
	/**
	 * Metodo utilizado para eliminar un grupo 
	 * @param strGrupo
	 * @return
	 * @throws Exception
	 */
	public boolean eliminaGrupo(String strGrupo)throws Exception{
		boolean elimino = false;
		TurbineSistema objSistema = null;		
		try{
			objSistema = this.getGrupoSistema(strGrupo,true);
			//Se verifica si existe el grupo
			if(objSistema != null){
				//El grupo ya existe y se verifica que no tenga relaciones
				if(objSistema.getTurbineGrupoDepartamentos() != null ){
					//No se puede eliminar el grupo porque tiene relaciones con otras tablas
					iObjLog.debug("No se puede eliminar el grupo sistema");
				}else{
					iObjSesion.delete(objSistema);
					iObjSesion.flush();
					iObjLog.debug("Se elimino el grupo sistema");
					elimino = true;
				}				
			}
			return elimino;
		} catch (Exception aError){
			iObjLog.error("SeguridadDao:eliminaGrupo:Error:",aError);
			throw aError;
		}		
	}
	
	/**
	 * Metodo que obtiene el Objeto TurbineSistema dado el grupo 
	 * @param strGrupo
	 * @param bolHijos
	 * @return
	 * @throws Exception
	 */
	private TurbineSistema getGrupoSistema(String strGrupo, boolean bolHijos)
	throws Exception{
		Query objQuery = null;
		TurbineSistema objSistema = null;
		List objListGpos = null;
		String lStrQuery = " select ts from TurbineSistema ts "			
			+" where ts.ssistema = '"+strGrupo+"' ";
		String strQueryAux = " select count(*) from TurbineGrupoDepartamento tgd "
			+" where tgd.turbineSistema.csistema = :csistema ";
		Iterator objItera = null;
		try{
			objQuery = iObjSesion.createQuery(lStrQuery);
			objListGpos = objQuery.list();
			if(objListGpos != null && objListGpos.size() > 0){
				objSistema = (TurbineSistema)objListGpos.get(0);
				objSistema.setTurbineGrupoDepartamentos(null);
				if(bolHijos){
					Integer intNumHijos = new Integer(0);
					objQuery = iObjSesion.createQuery(strQueryAux);
					objQuery.setParameter("csistema",objSistema.getCsistema(),Hibernate.INTEGER);
					objItera = objQuery.iterate();
					if(objItera != null){
						while(objItera.hasNext()){
							Object objAux = (Object) objItera.next();            
							iObjLog.debug("<<<<<RESULTCOUNTSISTEMA:|"+objAux+"|");
							intNumHijos = (Integer)objAux;             
						}
					}
					if(intNumHijos.intValue() > 0){
						Set st = new HashSet();
						objSistema.setTurbineGrupoDepartamentos(st);						
					}																								
				}																
			}
			iObjLog.debug("TurbineSistemarecuperado:|"+objSistema+"|");
			return objSistema;
		}catch (Exception aError){
			iObjLog.error("SeguridadDao:getGrupoSistema:Error:",aError);
			throw aError;
		}		
	}
	
	public void ModificaUsuario(TurbineCalendar objTurbinemod) throws Exception
	{	
    	iObjLog.debug("Entrando SeguridadDao.ModificaUsuario");
		TurbineCalendar objDatos = null;
		Integer objNextKorden = new CatalogosPKGSistemaDao(iObjSesion).getSequenceNextIdCalendar();
		CallableStatement proc = null;
		try {
			objDatos = new TurbineCalendar();			
			objDatos.setKcalendar(objNextKorden.longValue());
			objDatos.setGroupId(objTurbinemod.getGroupId());
			objDatos.setRoleId(objTurbinemod.getRoleId());
			objDatos.setGroupIdNew(objTurbinemod.getGroupIdNew());
			objDatos.setRoleIdNew(objTurbinemod.getRoleIdNew());
			objDatos.setDfirst(objTurbinemod.getDfirst());
			objDatos.setDlast(objTurbinemod.getDlast());
			objDatos.setCusuariomodi(objTurbinemod.getCusuariomodi());
			objDatos.setDmodificacion(new Date());
			objDatos.setCestado(119);
			objDatos.setUserId(objTurbinemod.getUserId());
			iObjSesion.save(objDatos);
			iObjSesion.flush();		    
			iObjLog.debug("Se ejecuta el SP_CAMBIA_GRUPO_ROLE_INICIO SeguridadDao.ModificaUsuario");
			//proc = (CallableStatement)iObjSesion.connection().prepareCall("call SP_CAMBIA_GRUPO_ROLE_INICIO()");
			//proc.execute();
	    	iObjLog.debug("Salida SeguridadDao.ModificaUsuario");
		} catch (Exception aError)
		{
			iObjLog.error("SeguridadDao:ModificaUsuario:Error: ",aError);
			throw aError;
		}			
	}
	
	public void ModificaRol(TurbineCalendar objTurbinemod) throws Exception
	{	
    	iObjLog.debug("Entrando SeguridadDao.ModificaRol");
		TurbineCalendar objDatos = null;
		Integer objNextKorden = new CatalogosPKGSistemaDao(iObjSesion).getSequenceNextIdCalendar();
		CallableStatement proc = null;
		try {
			objDatos = new TurbineCalendar();			
			objDatos.setKcalendar(objNextKorden.longValue());
			objDatos.setGroupId(objTurbinemod.getGroupId());
			objDatos.setRoleId(objTurbinemod.getRoleId());
			objDatos.setGroupIdNew(objTurbinemod.getGroupIdNew());
			objDatos.setRoleIdNew(objTurbinemod.getRoleIdNew());
			objDatos.setDfirst(objTurbinemod.getDfirst());
			objDatos.setDlast(objTurbinemod.getDlast());
			objDatos.setCusuariomodi(objTurbinemod.getCusuariomodi());
			objDatos.setDmodificacion(new Date());
			objDatos.setCestado(119);
			objDatos.setUserId(objTurbinemod.getUserId());
			iObjSesion.save(objDatos);
			iObjSesion.flush();		   
			
			iObjLog.debug("Se ejecuta el SP_CAMBIA_GRUPO_ROLE_INICIO SeguridadDao.ModificaUsuario");
			//proc = (CallableStatement)iObjSesion.connection().prepareCall("call SP_CAMBIA_GRUPO_ROLE_INICIO()");
			//proc.execute();
			
	    	iObjLog.debug("Salida SeguridadDao.ModificaRol");
		} catch (Exception aError)
		{
			iObjLog.error("SeguridadDao:ModificaRol:Error: ",aError);
			throw aError;
		}			
	}
	
	 /**
	 * Este metodo valida si el usuario tiene autorizaci&oacute;n
	 * de acuerdo a su rol.
	 * @param String proceso que desea validar
	 * @return boolean true si pertenece al rol
	 * false de lo contrario
	 * @throws Exception
* @ejb.interface-method
	 */
    public boolean getAutoriza(String StrProceso,List objRoles)throws Exception{
    	boolean regresa = false;
    	String rol,usuariorol;
    	
    	iObjLog.debug("Entrando getAutorizaDAO****");
    	
    	
    	try{
    		Map objCacheRoles = CachesUsuarios.getCacheRoles(StrProceso,iObjSesion);
    		Iterator iobjcache = objCacheRoles.entrySet().iterator();//roles del Mapa
    		Iterator iobjroles = objRoles.iterator();//roles actuales del usuario   		
    		iObjLog.debug("mapa----"+objCacheRoles.size());
    		iObjLog.debug("roles lista--"+ objRoles.size());
    		iObjLog.debug("Mapa----"+ objCacheRoles);
    		iObjLog.debug("Roles----"+ objRoles);   		 
    				usuariorol=iobjroles.next().toString();
		             iObjLog.debug("usuario rol"+usuariorol);
	    		     while (iobjcache.hasNext()){
	    		    	 Map.Entry iroles= (Map.Entry) iobjcache.next();
	    		    	 rol= iroles.getKey().toString();
	    		    	 iObjLog.debug("rol "+rol+ " usuariorol "+usuariorol);
	    		    	 if(usuariorol.equals(rol))
	    		    		 {regresa=true;
	    		    		  break;
	    		    		 }	    		    	 	    		    	 
	    		     }
    		iObjLog.debug("regresa "+regresa);
    		
			return regresa;
		}catch(Exception aError){
			iObjLog.error("error en el getAutoriza",aError);
			throw aError;
		}
					
    }
	
}