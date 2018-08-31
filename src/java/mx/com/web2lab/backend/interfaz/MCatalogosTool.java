/*
 * Created on Mar 16, 2005
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.web2lab.backend.interfaz;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;

import mx.com.web2lab.backend.fachadasejb.Catalogos;
import mx.com.web2lab.backend.fachadasejb.CatalogosHome;
import mx.com.web2lab.backend.hbm.om.catalogos.CMotivo;
import mx.com.web2lab.backend.hbm.om.sistema.SConfiguracion;
import mx.com.web2lab.backend.hbm.om.sistema.SEstado;
import mx.com.web2lab.backend.hbm.om.sistema.SSeveridad;
import mx.com.web2lab.backend.hbm.om.sistema.STipoCliente;
import mx.com.web2lab.backend.util.beans.sucesos.AccionSeguimientoBean;
import mx.com.web2lab.backend.util.beans.sucesos.SucesoBean;
import mx.com.web2lab.backend.util.exceptions.CatalogosException;
import mx.com.web2lab.backend.util.exceptions.ServiceLocatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MCatalogosTool
{
	/** Log de la aplicacion */
    private Log iLog = LogFactory.getLog(MCatalogosTool.class);
	
	//referencia remota para el patron Session Facade
	  private Catalogos iObjMCatalogosTool;

	  //Class para Session Facade objeto Home
	  private static final Class homeClazz = CatalogosHome.class;

	  // Default Constructor. Looks up home and connects
	  // to session by creating a new one
	  public MCatalogosTool() throws ServiceLocatorException
	  {
	    try
		{
	    	CatalogosHome objHome = (CatalogosHome)ServiceLocator.getInstance().getHome("Catalogos", homeClazz);
	    	iObjMCatalogosTool = objHome.create();
	    }
		catch(ServiceLocatorException ex) 
		{
	      // Translate Service Locator exception into
	      // application exception
	      throw new ServiceLocatorException("MCatalogosTool ",ex);
	    }
		catch(CreateException ex) 
		{
	      // Translate the Session create exception into
	      // application exception
	      throw new ServiceLocatorException("CreateException ",ex);
		}
		catch (RemoteException ex)
		{
			throw new ServiceLocatorException("RemoteException ",ex);
		}
	  }

	  // Constructor that accepts an ID (Handle id) and 
	  // reconnects to the prior session bean instead
	  // of creating a new one
	  public MCatalogosTool(String id) 
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
	      retorno = ServiceLocator.getId(iObjMCatalogosTool);
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
	  	iObjMCatalogosTool = (Catalogos)ServiceLocator.getService(id);
	  }
    
    
    /**
     * obtiene las Los bancos
     * 
     * @throws CatalogosException
     * @ejb.interface-method
     */
    public List obtenAll(String sCatalogo,int cMarca) throws Exception
	{
    	iLog.debug("Entrando obtenerAll....");
        try
		{
        	return iObjMCatalogosTool.obtenAll(sCatalogo,cMarca);
        }
        catch (Exception aException)
		{
        	iLog.error(">>>>rtc<<<< ERROR MFachadaCatalogosEJB.obtenAll() ", aException);
            throw aException;
        }
    }

    /**
     * obtiene las Los bancos
     * 
     * @throws CatalogosException
     * @ejb.interface-method
     */
    public List obtenAllArtificial(String sCatalogo,int cMarca) throws Exception
	{
        try
		{
        	return iObjMCatalogosTool.obtenAllArtificial(sCatalogo,cMarca);
        }
        catch (Exception aException)
		{
        	iLog.error(">>>>rtc<<<< Error MFachadaCatalogosEJB.obtenBancos() : ", aException);
            throw aException;
        }
    }
    
    /**
     * obtiene las Los bancos
     * 
     * @throws CatalogosException
     * @ejb.interface-method
     */
    public List obtenAllField(String sCatalogo,String strField) throws Exception
	{
        try
		{
        	return iObjMCatalogosTool.obtenAllField(sCatalogo,strField);
        }
        catch (Exception aException)
		{
        	iLog.error(">>>>rtc<<<< Error MFachadaCatalogosEJB.obtenBancos() : ", aException);
            throw aException;
        }
    }    

    /**
     * obtiene las Los bancos
     * 
     * @throws CatalogosException
     * @ejb.interface-method
     */
    public List obtenAllFieldWhere(String sCatalogo,String strField,String strFieldWhere,String intFieldWhere) throws Exception
	{
        try
		{
        	return iObjMCatalogosTool.obtenAllFieldWhere(sCatalogo,strField,strFieldWhere,intFieldWhere);
        }
        catch (Exception aException)
		{
        	iLog.error(">>>>rtc<<<< Error MFachadaCatalogosEJB.obtenBancos() : ", aException);
            throw aException;
        }
    }        
}
