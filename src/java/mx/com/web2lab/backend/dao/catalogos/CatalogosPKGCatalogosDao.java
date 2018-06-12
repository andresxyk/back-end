package mx.com.web2lab.backend.dao.catalogos;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import mx.com.web2lab.backend.beans.tools.CatalogosBean;
import mx.com.web2lab.backend.util.beans.comercializacion.CatalogoDistinctBean;
import net.sf.hibernate.Query;
import net.sf.hibernate.exception.NestableRuntimeException;
import net.sf.hibernate.exception.NestableException;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Dao para manejar las consultas correspondientes al modulo de catalogos.
 * 
 */
public class CatalogosPKGCatalogosDao
{
	
    /** log de la aplicacion */
    private static Log iObjLog = LogFactory.getLog(CatalogosPKGCatalogosDao.class);

    private Session iObjSession;

    /**
     * Constructor
     * 
     * @param aObjSession. Sesion de Hibernate
     */
    public CatalogosPKGCatalogosDao(Session aObjSession) {
        iObjSession = aObjSession;
    }
	    
    /**
     * Metodo que obtiene TODOS los elementos de algun Catalogo
     * @return List.
     * @throws Exception
     */
    public List obtenAll(String strCatalogo,int cMarca) throws Exception
    {
    	List lstReturn = null;
    	boolean bolCatalogoBaseDatos = false;
        try
        {

            iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo);
            if(cMarca == 691){
	            iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll select ec.cconvenio from E" + strCatalogo + " ec where ec.cestadoregistro = 22 and ec.cconvenio.ctipoconvenio.ctipoconvenio = 22 order by ec.cconvenio.s" + strCatalogo.toLowerCase());
	    		lstReturn = iObjSession.createQuery("select ec.cconvenio from E" + strCatalogo + " ec where ec.cestadoregistro = 22 and ec.cconvenio.ctipoconvenio.ctipoconvenio = 22 order by ec.cconvenio.s" + strCatalogo.toLowerCase()).list();       		            	
	            iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 3");
            } else {    
				if (CatalogosBean.catalogoshashMap.containsKey(strCatalogo.trim())) {
					lstReturn = (List)CatalogosBean.catalogoshashMap.get(strCatalogo.trim());
		            iObjLog.debug("Consulta a CatalogosPKGCatalogosDao.obtenAll...Se encontro el Catalogo  " + strCatalogo +  ", contiene " + lstReturn.size() + " elementos");   
		            bolCatalogoBaseDatos = false;
				} else if (CatalogosBean.catalogoshashMap.containsKey((strCatalogo.trim() + cMarca))) {
					lstReturn = (List)CatalogosBean.catalogoshashMap.get((strCatalogo.trim() + cMarca));
		            iObjLog.debug("Consulta a CatalogosPKGCatalogosDao.obtenAll...Se encontro el Catalogo  " + (strCatalogo.trim() + cMarca) +  ", contiene " + lstReturn.size() + " elementos");   
		            bolCatalogoBaseDatos = false;					
				} else {
					bolCatalogoBaseDatos = true;
		        	if(cMarca == 0){
		        		lstReturn = iObjSession.createQuery("from C" + strCatalogo + " cc order by 1").list();       		
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 1");
		        	} else if(cMarca == 99){
		        		lstReturn = iObjSession.createQuery("from T" + strCatalogo + " cc order by 1").list();       		
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 2");
		        	} else if(cMarca == 100){
		        		lstReturn = iObjSession.createQuery("from C" + strCatalogo + " cc order by cc.s" + strCatalogo.toLowerCase()).list();       		            	
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 3");
		        	} else if(cMarca == 500){
		        		lstReturn = iObjSession.createQuery("from TCorteCaja cc where cc.csucursal in (" + strCatalogo + ") order by cc.kcortecaja ").list();       		            	
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 4");
		        	} else if(cMarca == 600){
		        		lstReturn = iObjSession.createQuery("select ec.cconvenio from E" + strCatalogo + " ec where ec.cestadoregistro = 22 order by ec.cconvenio.s" + strCatalogo.toLowerCase()).list();       		            	
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 3");
		        	} else if(cMarca == 6001){
		        		lstReturn = iObjSession.createQuery("select ec.cconvenio from EConvenio ec where ec.cestadoregistro = 22 and ec.cmarca.cmarca = 1 order by ec.cconvenio.sconvenio").list();       		            	
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll select ec.cconvenio from EConvenio ec where ec.cestadoregistro = 22 and ec.cmarca.cmarca = 1  order by ec.cconvenio.s");
		        	} else if(cMarca == 6002){
		        		lstReturn = iObjSession.createQuery("select ec.cconvenio from EConvenio ec where ec.cestadoregistro = 22 and ec.cmarca.cmarca = 2  order by ec.cconvenio.sconvenio").list();       		            	
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll select ec.cconvenio from EConvenio ec where ec.cestadoregistro = 22 and ec.cmarca.cmarca = 2  order by ec.cconvenio.s");
		        	} else if(cMarca == 601){
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll select ec.cconvenio from EConvenio ec where ec.cestadoregistro = 22 and ec.cconvenio.ctipoconvenio.ctipoconvenio = 22 order by ec.cconvenio.sconvenio");
	        			lstReturn = iObjSession.createQuery("select ec.cconvenio from EConvenio ec where ec.cestadoregistro = 22 and ec.cconvenio.ctipoconvenio.ctipoconvenio = 22 order by ec.cconvenio.sconvenio").list();       		            
		        		iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 3");
		        	} else if(cMarca >= 602 && cMarca <= 620){
		        		int cTipoConvenio = Integer.parseInt(strCatalogo.substring(0,1));
		        		if (cTipoConvenio == 1) {
		        			lstReturn = iObjSession.createQuery("select ec.cconvenio from EConvenio ec where ec.cestadoregistro = 22 and ec.cconvenio.ccliente.ctipocliente.ctipocliente = " + (cMarca - 602) + " and ec.cconvenio.ctipoconvenio.ctipoconvenio = 22 order by ec.cconvenio.sconvenio").list();       		            
		        		} else {
		        			lstReturn = iObjSession.createQuery("select ec.cconvenio from EConvenio ec where ec.cestadoregistro = 22 and ec.cconvenio.ccliente.ctipocliente.ctipocliente = " + (cMarca - 602) + " and ec.cconvenio.ctipoconvenio.ctipoconvenio <> 22 order by ec.cconvenio.sconvenio").list();       		            
		        		}
		        		strCatalogo = (strCatalogo + cMarca);
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 3");
		        	}  else if(cMarca == 621){
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll from CDatoAdicional as cd inner join  cd.cconvenio as convenio order by convenio.cconvenio.sconvenio");
	        			lstReturn = iObjSession.createQuery("select distinct cc from CConvenio cc, CDatoAdicional cda where cc.cconvenio = cda.cconvenio order by cc.sconvenio").list();       		            
		        		iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 3");
		        	} else if(cMarca == 999){
		        		lstReturn = iObjSession.createQuery("from C" + strCatalogo + " cc order by 1").list();       		
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 1");
		        	} else {
		        		lstReturn = iObjSession.createQuery("from C" + strCatalogo + " cc where cc.c" + strCatalogo.toLowerCase() + " > 0 and cc.cmarca = " + cMarca + " order by 1").list();        		
		                iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo + " 5");
		        	}
		            iObjLog.debug("Consulta a CatalogosPKGCatalogosDao.obtenAll...Se realizo la comnsulta del Catalogo  " + strCatalogo +  ", contiene " + lstReturn.size() + " elementos");   
				}            
	        	if (lstReturn != null && bolCatalogoBaseDatos == true && cMarca != 999) {
		            iObjLog.debug("Consulta a CatalogosPKGCatalogosDao.obtenAll...Se realizo la comnsulta del Catalogo No existieron Registros ");   
	        		if (lstReturn.size() > 0) {
	        			if (CatalogosBean.catalogoshashMap.containsKey(strCatalogo.trim())) {
	//        				List lstCatalogoLoad = (List)CatalogosBean.catalogoshashMap.get(strCatalogo.trim());
	//        	            iObjLog.debug("Si se encontro el Catalogo  " + strCatalogo +  " ya cargado, contiene " + lstCatalogoLoad.size());        				
	        			} else {
	            			CatalogosBean.catalogoshashMap.put(strCatalogo.trim(), lstReturn);        				
	        			}
	        		}
	        	}
            }
        	return lstReturn;
        } catch (NestableException ioexp) {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): HibertIO", ioexp);
            return null;        	        	
        } catch (NestableRuntimeException exp) {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): Hibert", exp);
            return null;        	
        }
        catch (Exception aObjExcepcion)
        {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): " + "from C" +  strCatalogo, aObjExcepcion);
           return null;
        }
    }

    
    /**
     * Metodo que obtiene TODOS los elementos de algun Catalogo
     * @return List.
     * @throws Exception
     */
    public List obtenAllArtificial(String strCatalogo,int cMarca) throws Exception
    {
        try
        {

            iObjLog.debug("Entrando a CatalogosPKGCatalogosDao.obtenAll" + strCatalogo);
        	if(cMarca == 0){
            	return iObjSession.createQuery("from C" + strCatalogo + " cc where cc.k" + strCatalogo.toLowerCase() + " > 0 order by 1").list();
       		
        	} else {
        		if(strCatalogo.equals("ClienteComercial")) {
        			return iObjSession.createQuery("from C" + strCatalogo + " cc where cc.k" + strCatalogo.toLowerCase() + " > 0 and cc.cestado in (139) and cc.cmarca = " + cMarca + " order by cc.srazonsocial").list();        			
        		} else if (strCatalogo.equals("ConvenioComercial")) {
        			return iObjSession.createQuery("from D" + strCatalogo + " cc where (cc.pcoaseguro > 0 or cc.mcoaseguro > 0) and cc.cestado in (180) and cc.kconvenio > 0 and cc.cclientecomercial.cmarca = " + cMarca + " order by cc.cconvenio").list();
        		} else {
        			return iObjSession.createQuery("from C" + strCatalogo + " cc where cc.k" + strCatalogo.toLowerCase() + " > 0 and cc.cmarca = " + cMarca + " order by 1").list();
        		}
        	}
        } catch (NestableException ioexp) {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): HibertIO", ioexp);
            return null;        	        	
        } catch (NestableRuntimeException exp) {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): Hibert", exp);
            return null;        	
        }
        catch (Exception aObjExcepcion)
        {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): " + "from C" +  strCatalogo, aObjExcepcion);
           return null;
        }
    }
    
    
    /**
     * Metodo que obtiene TODOS los elementos de algun Catalogo en base 
     * a un campo distinct
     * @return List.
     * @throws Exception
     */
    public List obtenAllField(String strCatalogo,String strField) throws Exception
    {	List lstReturn = new ArrayList();
        try
        {
            iObjLog.debug("Entrando a obtenAll "+ "select distinct codpost." + strField + ",codpost." + strField + ",codpost.casentamiento from C" + strCatalogo + " codpost where codpost.bregistrosepo = true order by casentamiento ");
    		List lstObject	= iObjSession.createQuery("select distinct codpost." + strField + ",codpost." + strField + ",codpost.casentamiento from C" + strCatalogo + " codpost where codpost.bregistrosepo = true order by casentamiento ").list();
        	Iterator iteraField = lstObject.iterator();        		
        	int inti = 1;
        	while(iteraField.hasNext()) {
				Object[] row = (Object[])iteraField.next();
				CatalogoDistinctBean objDistinct = new CatalogoDistinctBean();
				objDistinct.setKdistinct(Integer.parseInt((String)row[2]));
				objDistinct.setSdistinct((String)row[0]);
				lstReturn.add(objDistinct);
				inti++;
        	}        	
        	return lstReturn;
        } catch (NestableException ioexp) {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): HibertIO", ioexp);
        	return null;
        } catch (NestableRuntimeException exp) {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): Hibert", exp);
        	return null;
        }
        catch (Exception aObjExcepcion)
        {
        	iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): " + "from C" +  strCatalogo, aObjExcepcion);
        	return null;
        }
    }
    
    /**
     * Metodo que obtiene TODOS los elementos de algun Catalogo en base 
     * a un campo distinct
     * @return List.
     * @throws Exception
     */
    public List obtenAllFieldWhere(String strCatalogo,String strField,String strFieldWhere,String intFieldWhere) throws Exception
    {	List lstReturn = new ArrayList();
        try
        {
            iObjLog.debug("Entrando a obtenAll ");
        	StringBuffer  bufferQuery = new StringBuffer("select distinct codpost." + strField + "," +
        														"codpost." + strField + " " +
        												 "from C" + strCatalogo + " codpost " +
        												 "where 1=1 ");        	
        	bufferQuery.append(" and TRIM(UPPER(codpost.s" + strFieldWhere + ")) like UPPER(:strFieldWhere) order by 1");        	
        	Query objQuery = iObjSession.createQuery(bufferQuery.toString());        	
        	objQuery.setString("strFieldWhere", "%" + intFieldWhere);
        	List lstObject = objQuery.list();
        	Iterator iteraField = lstObject.iterator();        		
        	while(iteraField.hasNext()) {
				Object[] row = (Object[])iteraField.next();
				CatalogoDistinctBean objDistinct = new CatalogoDistinctBean();
				objDistinct.setSdistinct((String)row[0]);
				lstReturn.add(objDistinct);
        	}        	
        	return lstReturn;
        } catch (NestableException ioexp) {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): HibertIO", ioexp);
        	return null;
        } catch (NestableRuntimeException exp) {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): Hibert", exp);
        	return null;
        }
        catch (Exception aObjExcepcion)
        {
        	iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenAll(): " + "from C" +  strCatalogo, aObjExcepcion);
        	return null;
        }
    }
        
    
    /**
     * Metodo que obtiene las  tarjetas
     * @return List.
     * @throws Exception
     */
    public List obtenTarjetas() throws Exception
    {
        try
        {
        	return iObjSession.createQuery("from CTipoTarjeta").list();
        }
        catch (Exception aObjExcepcion)
        {
            iObjLog.error(">>>>rtc<<<< ERROR CatalogosPKGCatalogosDao.obtenTarjetas(): ", aObjExcepcion);
           return null;
        }
    }    
}
