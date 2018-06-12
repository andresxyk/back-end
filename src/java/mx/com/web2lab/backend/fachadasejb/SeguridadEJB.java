package mx.com.web2lab.backend.fachadasejb;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.List;
import mx.com.web2lab.backend.hbm.om.sistema.TurbineCalendar;
import mx.com.web2lab.backend.dao.seguridad.SeguridadDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @ejb.bean name="Seguridad" type="Stateless"
 * jndi-name="Seguridad" display-name="Fachada para Seguridad"
 * view-type="both" transaction-type="Container"
 */
public class SeguridadEJB implements SessionBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5200361351145496986L;

	/** Log de la aplicacion */
    private Log iObjLog = LogFactory.getLog(SeguridadEJB.class);

    /** contexto del EJB */
    protected SessionContext objCtx;

    /** constructor default */
    public SeguridadEJB()
    {
    }
    
    /**
	 * Este metodo esta encargado de insertar un nuevo
	 * grupo del sistema.
	 * @param String nombre del grupo
	 * @return boolean true si lo inserto correctamente
	 * false de lo contrario
	 * @throws Exception
* @ejb.interface-method
	 */
    public boolean insertaGrupo(String aStrGrupo)throws Exception{
    	boolean inserto = false;
    	try{
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTrans();
			SeguridadDao objSeguridad = new SeguridadDao(session);
			inserto =  objSeguridad.insertaGrupo(aStrGrupo);
			HibernateUtil.commitTrans();
			iObjLog.debug("<<<<<insertaGrupoEJB:|"+inserto+"|");
			return inserto;
		}catch(Exception aError){
			HibernateUtil.rollbackTrans();
			iObjLog.error("error en el SeguridadEJB.insertaGrupo ",aError);
			throw aError;
		}
		finally{
			HibernateUtil.closeSession();
		}				
    }
    
    /**
	 * Este metodo esta encargado de actualiza un
	 * grupo del sistema.
	 * @param String nombre del grupo
	 * @return boolean true si lo actualizo correctamente
	 * false de lo contrario
	 * @throws Exception
* @ejb.interface-method
	 */
    public boolean actualizaGrupo(String aStrGrupoAnt,String aStrGrupoNuevo)throws Exception{
    	boolean inserto = false;
    	try{
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTrans();
			SeguridadDao objSeguridad = new SeguridadDao(session);
			inserto =  objSeguridad.actualizaGrupo(aStrGrupoAnt,aStrGrupoNuevo);
			HibernateUtil.commitTrans();
			iObjLog.debug("<<<<<insertaGrupoEJB:|"+inserto+"|");
			return inserto;
		}catch(Exception aError){
			HibernateUtil.rollbackTrans();
			iObjLog.error("error en el SeguridadEJB.insertaGrupo ",aError);
			throw aError;
		}
		finally{
			HibernateUtil.closeSession();
		}				
    }
    
    /**
	 * Este metodo esta encargado de eliminar un
	 * grupo del sistema.
	 * @param String nombre del grupo
	 * @return boolean true si lo elimino correctamente
	 * false de lo contrario
	 * @throws Exception
* @ejb.interface-method
	 */
    public boolean eliminaGrupo(String aStrGrupo)throws Exception{
    	boolean inserto = false;
    	try{
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTrans();
			SeguridadDao objSeguridad = new SeguridadDao(session);
			inserto =  objSeguridad.eliminaGrupo(aStrGrupo);
			HibernateUtil.commitTrans();
			iObjLog.debug("<<<<<insertaGrupoEJB:|"+inserto+"|");
			return inserto;
		}catch(Exception aError){
			HibernateUtil.rollbackTrans();
			iObjLog.error("error en el SeguridadEJB.insertaGrupo ",aError);
			throw aError;
		}
		finally{
			HibernateUtil.closeSession();
		}				
    }
    
//  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbActivate()
	 */
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbPassivate()
	 */
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbRemove()
	 */
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
	 */
	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub

	}
	
	/**
     * 
     * @ejb.interface-method
     *
     */
    public void ejbStore() {
        iObjLog.info("Store SeguridadEJB:");
    }

    /**
     * 
     * @ejb.interface-method
     *
     */
    public void ejbLoad() {
        iObjLog.info("Load SeguridadEJB:");
    }

    /**
     * 
     * @throws CreateException
     * @ejb.interface-method
     */
    public void ejbCreate() throws CreateException {
        iObjLog.info("Create SeguridadEJB:");
    }
    
    /**
	 * Este metodo esta encargado de insertar un nuevo
	 * grupo del sistema.
	 * @param objTrubinemod
	 * @return boolean true si lo inserto correctamente
	 * false de lo contrario
	 * @throws Exception
* @ejb.interface-method 
	 */
    public void ModificaUsuario(TurbineCalendar objTurbinemod)throws Exception
    {
    	try{
        	iObjLog.debug("Entrando SeguridadEJB.ModificaUsuario");
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTrans();
			SeguridadDao objSeguridad = new SeguridadDao(session);
			objSeguridad.ModificaUsuario(objTurbinemod);
			HibernateUtil.commitTrans();
        	iObjLog.debug("Saliendo SeguridadEJB.ModificaUsuario");			
		} catch(Exception aError){
			HibernateUtil.rollbackTrans();
			iObjLog.error("Error en el SeguridadEJB.ModificaUsuario ",aError);
			throw aError;
		}
		finally{
			HibernateUtil.closeSession();
		}				
    }
	
    /**
	 * Este metodo esta encargado de insertar un nuevo
	 * rol del sistema.
	 * @param objTrubinemod
	 * @return boolean true si lo inserto correctamente
	 * false de lo contrario
	 * @throws Exception
* @ejb.interface-method 
	 */
    public void ModificaRol(TurbineCalendar objTurbinemod)throws Exception
    {
    	try{
        	iObjLog.debug("Entrando SeguridadEJB.ModificaRol");
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTrans();
			SeguridadDao objSeguridad = new SeguridadDao(session);
			objSeguridad.ModificaRol(objTurbinemod);
			HibernateUtil.commitTrans();
        	iObjLog.debug("Saliendo SeguridadEJB.ModificaRol");			
		} catch(Exception aError){
			HibernateUtil.rollbackTrans();
			iObjLog.error("Error en el SeguridadEJB.ModificaRol ",aError);
			throw aError;
		}
		finally{
			HibernateUtil.closeSession();
		}				
    }
   
    /**
	 * Este metodo esta encargado de actualiza un
	 * grupo del sistema.
	 * @param String nombre del grupo
	 * @return boolean true si lo actualizo correctamente
	 * false de lo contrario
	 * @throws Exception
* @ejb.interface-method
	 */
    public boolean getAutoriza(String StrProceso,List objRoles)throws Exception{
    	boolean regresa = false;
    	iObjLog.debug("Entrando getAutorizaEJB");
    	try{
    		
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTrans();
			SeguridadDao objSeguridad = new SeguridadDao(session);
			regresa =  objSeguridad.getAutoriza(StrProceso,objRoles);
			HibernateUtil.commitTrans();
	
			return regresa;
		}catch(Exception aError){
			//HibernateUtil.rollbackTrans();
			iObjLog.error("error en el getAutoriza.insertaGrupo ",aError);
			throw aError;
		}
		finally{
			HibernateUtil.closeSession();
		}				
    }
    
    
}