package mx.com.web2lab.backend.fachadasejb;

import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import mx.com.web2lab.backend.dao.catalogos.CatalogosPKGCatalogosDao;
import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.util.exceptions.CatalogosException;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @ejb.bean name="Catalogos" type="Stateless"
 * jndi-name="Catalogos" display-name="Fachada para Catalogos"
 * view-type="both" transaction-type="Container"
 */
public class CatalogosEJB implements SessionBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3330463642039935182L;

	/* Log de la aplicacion */
    private Log iObjLog = LogFactory.getLog(CatalogosEJB.class);

    /* contexto del EJB */
    protected SessionContext objCtx;

    /**
     * Constructor
     */
    public CatalogosEJB() {

    }
    
    /**
     * @throws CatalogosException
     *@ejb.interface-method
     */
    public List obtenAll(String sCatalogo,int cMarca) throws CatalogosException
	{
    	List retorno = null;
        try
        {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTrans();
            CatalogosPKGCatalogosDao objCatalogosPKGCatalogosDao = new CatalogosPKGCatalogosDao(session);
            retorno = objCatalogosPKGCatalogosDao.obtenAll(sCatalogo,cMarca);
            HibernateUtil.commitTrans();
        }
        catch (Exception aException)
        {
        	HibernateUtil.rollbackTrans();
            throw new CatalogosException(">>>>rtc<<<< ERROR CatalogosEJB.obtenAll() ", aException);
        }
        finally
        {
        	HibernateUtil.closeSession();
        } 
        return retorno;
    }

    /**
     * @throws CatalogosException
     *@ejb.interface-method
     */
    public List obtenAllArtificial(String sCatalogo,int cMarca) throws CatalogosException
	{
    	List retorno = null;
        try
        {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTrans();
            CatalogosPKGCatalogosDao objCatalogosPKGCatalogosDao = new CatalogosPKGCatalogosDao(session);
            retorno = objCatalogosPKGCatalogosDao.obtenAllArtificial(sCatalogo,cMarca);
            HibernateUtil.commitTrans();
        }
        catch (Exception aException)
        {
        	HibernateUtil.rollbackTrans();
            throw new CatalogosException(">>>>rtc<<<< ERROR CatalogosEJB.obtenAll() ", aException);
        }
        finally
        {
        	HibernateUtil.closeSession();
        } 
        return retorno;
    }
    
    
    /**
     * @throws CatalogosException
     *@ejb.interface-method
     */
    public List obtenAllField(String sCatalogo,String strField) throws CatalogosException
	{
    	List retorno = null;
        try
        {        	
            iObjLog.debug("Entrando a EJBobtenAllField " + sCatalogo);
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTrans();
            CatalogosPKGCatalogosDao objCatalogosPKGCatalogosDao = new CatalogosPKGCatalogosDao(session);
            retorno = objCatalogosPKGCatalogosDao.obtenAllField(sCatalogo,strField);
            HibernateUtil.commitTrans();
        }
        catch (Exception aException)
        {
        	HibernateUtil.rollbackTrans();
            throw new CatalogosException(">>>>rtc<<<< ERROR CatalogosEJB.obtenAll() ", aException);
        }
        finally
        {
        	HibernateUtil.closeSession();
        } 
        return retorno;
    }    
    
    /**
     * @throws CatalogosException
     *@ejb.interface-method
     */
    public List obtenAllFieldWhere(String sCatalogo,String strField,String strFieldWhere,String intFieldWhere) throws CatalogosException
	{
    	List retorno = null;
        try
        {        	
            iObjLog.debug("Entrando a EJBobtenAllField " + sCatalogo);
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTrans();
            CatalogosPKGCatalogosDao objCatalogosPKGCatalogosDao = new CatalogosPKGCatalogosDao(session);
            retorno = objCatalogosPKGCatalogosDao.obtenAllFieldWhere(sCatalogo,strField,strFieldWhere,intFieldWhere);
            HibernateUtil.commitTrans();
        }
        catch (Exception aException)
        {
        	HibernateUtil.rollbackTrans();
            throw new CatalogosException(">>>>rtc<<<< ERROR CatalogosEJB.obtenAll() ", aException);
        }
        finally
        {
        	HibernateUtil.closeSession();
        } 
        return retorno;
    }    
        
    
    public void setSessionContext(SessionContext context)
    {
    	iObjLog.info("estableciendo context CatalogosBean:");
        objCtx = context;
    }

    public void ejbActivate() {
    	iObjLog.info("Activate CatalogosBean:");
    }

    public void ejbPassivate() {
    	iObjLog.info("Passivate CatalogosBean:");
    }

    public void ejbRemove() {
    	iObjLog.info("Remove CatalogosBean:");
    }

    /**
     * 
     * @ejb.interface-method
     *
     */
    public void ejbStore() {
    	iObjLog.info("Store CatalogosBean:");
    }
    
    /**
     * 
     * @ejb.interface-method
     *
     */
    public void ejbLoad() {
    	iObjLog.info("Load CatalogosBean:");
    }

    /**
     * 
     * @throws CreateException
     * @ejb.interface-method
     */
    public void ejbCreate() throws CreateException {
    	iObjLog.info("Create CatalogosBean:");
    }
    
    

}
