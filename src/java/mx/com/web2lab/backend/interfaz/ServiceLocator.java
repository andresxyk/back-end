/*
 * Created on Mar 10, 2005
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.web2lab.backend.interfaz;

/**
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;

import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import mx.com.web2lab.backend.util.exceptions.ServiceLocatorException;

public class ServiceLocator
{
  private static ServiceLocator me;
  private InitialContext context = null;
    
  private ServiceLocator() 
  throws ServiceLocatorException
  {
    /*try
	{
      context = new InitialContext();
    }
	catch(NamingException ne)
	{
      throw new ServiceLocatorException("ServiceLocator:ServiceLocator() Error: " + ne.toString());
    }*/
  }
  
  // Retorna la instancia del ServiceLocator
  public static synchronized ServiceLocator getInstance() 
  throws ServiceLocatorException
  {
    if (me == null)
	{
    	try
		{
	      me = new ServiceLocator();
	      me.context = new InitialContext();
	    }
		catch(NamingException ne)
		{
	      throw new ServiceLocatorException("ServiceLocator:ServiceLocator() Error: " + ne.toString());
	    }
    }
    return me;
  }
    
  // convierte el string serialized dentro del EJBHandle 
  // y lo manda al EJBObject.
  public static EJBObject getService(String id) 
  throws ServiceLocatorException
  {
    if (id == null)
	{
      throw new ServiceLocatorException("______ Error ServiceLocator / id nulo : ");
    }
    try
	{
      byte[] bytes = new String(id).getBytes();
      InputStream io = new ByteArrayInputStream(bytes);
      ObjectInputStream os = new ObjectInputStream(io);
      javax.ejb.Handle handle = (javax.ejb.Handle)os.readObject();
      return handle.getEJBObject();
    }
	catch(Exception ex)
	{
      throw new ServiceLocatorException("______ Error ServiceLocator / getService(String " + id + ") : " + ex.toString());
    }
  }
    
  // Returns the String that represents the given 
  // EJBObject's handle in serialized format.
  protected static String getId(EJBObject session) 
  throws ServiceLocatorException
  {
    try
	{
      javax.ejb.Handle handle = session.getHandle();
      ByteArrayOutputStream fo = new ByteArrayOutputStream();
      ObjectOutputStream so = new ObjectOutputStream(fo);
      so.writeObject(handle);
      so.reset();
      return new String(fo.toByteArray());
    }
	catch(RemoteException ex)
	{
      throw new ServiceLocatorException("______ Error ServiceLocator / getId(EJBObject " + session.toString() + ") / RemoteException : " , ex);
    }
	catch(IOException ex)
	{
      throw new ServiceLocatorException("______ Error ServiceLocator / getId(EJBObject " + session.toString() + ") /IOException : ", ex);
    }
  }
    
  // Returns the EJBHome object for requested service 
  // name. Throws ServiceLocatorException If Any Error 
  // occurs in lookup
  public EJBHome getHome(String name, Class clazz) 
  throws ServiceLocatorException
  {
    try
	{
      Object objref = context.lookup(name);
      if(objref==null){
      	throw new ServiceLocatorException("Error ServiceLocator / getHome(String " + name + " , Class " + clazz.toString() +") : No se encontr&oacute;");
      }
      EJBHome home = (EJBHome) PortableRemoteObject.narrow(objref, clazz);
      return home;
    }
	catch(NamingException ex)
	{
      throw new ServiceLocatorException("______ Error ServiceLocator / getHome(String " + name + " , Class " + clazz.toString() +") : ", ex);
    }
  }
  
  /*
  * Metodo que previene la clonaci&oacute;n de este singleton. 
  * @see java.lang.Object#clone()
  */
  public Object clone()	throws CloneNotSupportedException   {
    throw new CloneNotSupportedException(); 
    // Falla si una clase desea clonar el singleton.
  }
}
