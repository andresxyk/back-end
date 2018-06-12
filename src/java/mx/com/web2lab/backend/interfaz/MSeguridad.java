package mx.com.web2lab.backend.interfaz;

import java.rmi.RemoteException;

import javax.ejb.CreateException;

import mx.com.web2lab.backend.fachadasejb.Seguridad;
import mx.com.web2lab.backend.fachadasejb.SeguridadHome;
import mx.com.web2lab.backend.util.exceptions.ServiceLocatorException;
import mx.com.web2lab.backend.hbm.om.sistema.TurbineCalendar;

import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MSeguridad{
	
	/** Log de la aplicacion */
    private Log iLog = LogFactory.getLog(MSeguridad.class);
    
    //referencia remota para el patron Session Facade
    private Seguridad iObjMSeguridad;
    
	//Class para Session Facade objeto Home
	private static final Class homeClazz = SeguridadHome.class;
	
//	 Default Constructor. Looks up home and connects
	  // to session by creating a new one
	  public MSeguridad() throws ServiceLocatorException
	  {
	    try
		{
	    	SeguridadHome objHome = (SeguridadHome)ServiceLocator.getInstance().getHome("Seguridad", homeClazz);
	    	iObjMSeguridad = objHome.create();
	    }
		catch(ServiceLocatorException ex) 
		{
	      // Translate Service Locator exception into
	      // application exception
	      throw new ServiceLocatorException("");
	    }
		catch(CreateException ex) 
		{
	      // Translate the Session create exception into
	      // application exception
	      throw new ServiceLocatorException("");
		}
		catch (RemoteException e)
		{
			throw new ServiceLocatorException("");
		}
	  }

	  // Constructor that accepts an ID (Handle id) and 
	  // reconnects to the prior session bean instead
	  // of creating a new one
	  public MSeguridad(String id) 
	  throws ServiceLocatorException 
	  {
	    super();
	    reconnect(id);
	  }

	  // Returns a String ID the client can use at a
	  // later time to reconnect to the session bean
	  public String getID()
	  {
	  	String retorno = null;
	    try
		{
	      retorno = ServiceLocator.getId(iObjMSeguridad);
	    }
	    catch (Exception e)
		{
	    	e.printStackTrace();
	    }
	    return retorno;
	 }

	  // method to reconnect using String ID
	  public void reconnect(String id) 
	  throws ServiceLocatorException
	  {
	  	iObjMSeguridad = (Seguridad)ServiceLocator.getService(id);
	  }
	  
	  public boolean insertaGrupo(String aStrGrupo)
	  throws Exception{	  	
		  	try{
		  		return iObjMSeguridad.insertaGrupo(aStrGrupo);
			}catch(Exception ex){
		  		iLog.error("_______ Error RDMSeguridad / insertaGrupo(String aStrGrupo)", ex);
		  		throw ex;
		  	}	  	
	  }
	  
	  public boolean actualizaGrupo(String aStrGrupoAnt, String StrGrupoNuevo)
	  throws Exception{	 
		  	try{
		  		return iObjMSeguridad.actualizaGrupo(aStrGrupoAnt,StrGrupoNuevo);
			}catch(Exception ex){
		  		iLog.error("_______ Error RDMSeguridad / actualizaGrupo(String aStrGrupo)", ex);
		  		throw ex;
		  	}		  	
	  }
	  
	  public boolean eliminaGrupo(String aStrGrupo)
	  throws Exception{	 
		  	try{
		  		return iObjMSeguridad.eliminaGrupo(aStrGrupo);
			}catch(Exception ex){
		  		iLog.error("_______ Error RDMSeguridad / eliminaGrupo(String aStrGrupo)", ex);
		  		throw ex;
		  	}		  	
	  }
	  
	  public void ModificaUsuario(TurbineCalendar objTurbinemod)
	  throws Exception{	  	
		  	try{
		  		iObjMSeguridad.ModificaUsuario(objTurbinemod);
			}catch(Exception ex){
		  		iLog.error("_______ Error ModificaUsuario / ModificaUsuario(TurbineCalendar objTurbinemod)", ex);
		  		throw ex;
		  	}	  	
	  }
	  public void ModificaRol(TurbineCalendar objTurbinemod)
	  throws Exception{	  	
		  	try{
		  		iObjMSeguridad.ModificaRol(objTurbinemod);
			}catch(Exception ex){
		  		iLog.error("_______ Error ModificaRol / ModificaRol(TurbineCalendar objTurbinemod)", ex);
		  		throw ex;
		  	}	  	
	  }
	  
	  public boolean getAutoriza(String StrProceso,List objRoles)
	  throws Exception{	 
		  	try{
		  		return iObjMSeguridad.getAutoriza(StrProceso,objRoles);
			}catch(Exception ex){
		  		iLog.error("_______ Error RDMSeguridad / actualizaGrupo(String aStrGrupo)", ex);
		  		throw ex;
		  	}		  	
	  }
	  
	  
}