package mx.com.web2lab.backend.dao.sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mx.com.web2lab.backend.hbm.om.catalogos.CMotivo;
import mx.com.web2lab.backend.hbm.om.catalogos.CTipoMotivo;
import mx.com.web2lab.backend.hbm.om.sistema.SEntidad;
import mx.com.web2lab.backend.hbm.om.sistema.SEstado;
import mx.com.web2lab.backend.hbm.om.sistema.SGenero;
import mx.com.web2lab.backend.hbm.om.sistema.SSeveridad;
import mx.com.web2lab.backend.hbm.om.sistema.STipoCliente;
import mx.com.web2lab.backend.hbm.om.sistema.STipoLaboratorio;
import mx.com.web2lab.backend.hbm.om.sistema.STipoSecuencia;
import mx.com.web2lab.backend.hbm.om.sistema.STipoViaje;
import mx.com.web2lab.backend.hbm.om.sistema.SProceso;
import mx.com.web2lab.backend.util.beans.sistema.UsuarioBean;
import mx.com.web2lab.backend.util.cacheestatus.CachesEstatus;
import mx.com.web2lab.backend.util.cachesecuencia.CachesSecuencias;
import mx.com.web2lab.backend.util.catalogos.ValoresCatalogo;
import mx.com.web2lab.backend.util.exceptions.CatalogosException;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * Proveera los catalogos del paquete sistema
 */
public class CatalogosPKGSistemaDao {

    /** log de la aplicacion */
    private static Log iObjLog = LogFactory.getLog(CatalogosPKGSistemaDao.class);

    /** Sesion de Hibernate <code>iObjSesion</code> */
    private Session iObjSesion = null;

    /**
     * Constructor
     */
    public CatalogosPKGSistemaDao(Session aObjSession) {
        iObjSesion = aObjSession;
    }

    /**
     * Metodo que Obtiene el catalogo de Entidades del sistema
     * 
     * @return se regresa la lista de entidades con sus estados
     * @throws Exception
     */
    public List getSEntidadesConSEstados() 
    throws CatalogosException {
        List objSEntidades = null;
        try {
            String strQuery = "from SEntidad sEntidad";
            objSEntidades = iObjSesion.find(strQuery);

            //Se inicializan los estados de cada entidad
            Iterator objIt = objSEntidades.iterator();
            while (objIt.hasNext()) {
                SEntidad objAux = (SEntidad) objIt.next();
                Hibernate.initialize(objAux.getSestados());
            }
            iObjLog.debug("DatosObtenidosDeEntidadesEstados=" + objSEntidades.toString());
            return objSEntidades;
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getSEntidadesConSEstados", e);
            throw new CatalogosException("Error en getSEntidadesConSEstados:", e);
        }
    }
    
    /**
     * Metodo que Obtiene el catalogo de Entidades del sistema
     * 
     * @return se regresa la lista de entidades con sus estados
     * @throws Exception
     */
    public List getSProcesosConSRoles() 
    throws CatalogosException {
        List objSProcesos = null;
        try {
            String strQuery = "from SProceso sProceso";
            objSProcesos = iObjSesion.find(strQuery);

            //Se inicializan los estados de cada entidad
            Iterator objIt = objSProcesos.iterator();
            while (objIt.hasNext()) {
                SProceso objAux = (SProceso) objIt.next();
                Hibernate.initialize(objAux.getSrolejecucion());
            }
            iObjLog.debug("DatosObtenidosDeEntidadesEstados=" + objSProcesos.toString());
            return objSProcesos;
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getSProcesosConSRoles", e);
            throw new CatalogosException("Error en getSProcesosConSRoles:", e);
        }
    }
    
    /**
     * Metodo que Obtiene el catalogo de secuencias del sistema 
     * 
     * @return se regresa la lista de tipos de secuencia (STipoSecuencia) completa, 
     * con sus colecciones de SSecuencia inicializados
     * @throws Exception
     */
    public List getSecuencias() throws Exception{
    	iObjLog.debug("_____>>>>>> entrando a getSecuencias");
        List objSecuencias = null;
        try {
            //String strQuery = "select stipo from STipoSecuencia stipo inner join fetch stipo.ssecuencias ";
            String strQuery = "from STipoSecuencia ";
            objSecuencias = iObjSesion.find(strQuery);
            Iterator objIter = objSecuencias.iterator();
            if (objIter.hasNext()){
            	STipoSecuencia objTipoSec = (STipoSecuencia)objIter.next();
            	Hibernate.initialize(objTipoSec.getSsecuencias());
            }
        } catch (Exception aError) {
            iObjLog.error("_____>>>>>> ErrorAlHacerelQuery:getSecuencias" + aError);
            throw aError;
        }
//        iObjLog.debug("_____>>>>>> DatosObtenidosDeSecuencias=" + objSecuencias);
        return objSecuencias;
    }
    
    /**
     * Obtiene un UsuarioBean con base en su ID
     * 
     * @param aLongIdUsuario
     *            Ide del Usuario a buscar
     * @return UsuarioBean encontrado
     */
    public UsuarioBean getUsuarioBean(long aLongIdUsuario)
            throws CatalogosException, SQLException,
            Exception {
        PreparedStatement objStatement = null;
        Connection objCon = null;
        try {
            String strQuery = "select u.first_name, u.last_name, u.email "
                    + "from turbine_user u where u.user_id = ? ";
            objCon = iObjSesion.connection();
            objStatement = objCon.prepareStatement(strQuery);
            //estableciendo parametros
            objStatement.setLong(1, aLongIdUsuario);
            //ejecutando consulta
            iObjLog.debug("BuscandoUsuarioConElsiguienteQuery=" + strQuery
                    + aLongIdUsuario);
            ResultSet objRs = objStatement.executeQuery();
            //se genera el UsuarioBean
            if (objRs == null) { 
            //no existe el usuario solicitado
            return null; }
            //nos ubicamos en el registro 1
            objRs.next();
            UsuarioBean objUser = new UsuarioBean();
            objUser.setIStrObjNombre(objRs.getString("first_name"));
            objUser.setIStrObjApellido(objRs.getString("last_name"));
            objUser.setIStrObjEmail(objRs.getString("email"));
            iObjLog.debug("DatosObtenidosDelUsuario="
                    + objUser.getIStrObjNombre());
            return objUser;
        } catch (Exception aException) {
            iObjLog.error("ERROR AL HACER QUERY: getSEntidadesConSEstados", aException);
            throw aException;
        } finally {
            if (objStatement != null) {
                objStatement.close();
            }
        }
    }

    /**
     * Metodo que Obtiene el catalogo de Estados correspondientes a una entidad
     * del sistema
     * 
     * @return se regresa la lista de entidades con sus estados
     * @throws Exception
     */
    public List getEstadosEntidad(String aStrEntidad)
            throws CatalogosException {
        List objSEntidades = null;
        // Query SQL para la busqueda de Cargas
        Query objQuery = null;
        try {
            String strQuery = "from SEstado estado "
                    + "where lower(estado.sentidad.sentidad) = lower(:entidad) "
					+ "order by estado.sestado ";

            objQuery = iObjSesion.createQuery(strQuery);
            // Se establecen los parametros de la busqueda
            objQuery.setParameter("entidad", aStrEntidad);
            objSEntidades = objQuery.list();
            iObjLog.debug("DatosObtenidosDeEntidadesEstados="
                    + objSEntidades.toString());
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getSEntidadesConSEstados", e);
            throw new CatalogosException("Error en getSEntidadesConSEstados:",
                    e);
        }
        return objSEntidades;
    }
    
    /**
     * Este método esta encargado de obtener la descripcion de la entidad de la
     * carga en base a los parametros enviados.
     * 
     * @param aStrEntidad
     *            Entidad
     * @param aStrEstado
     *            Id del estado
     * @return Descripcion del estado de entidad 
     * @throws CatalogosException
     */
    public String getDescripcionEstado(String aStrEntidad, String aStrEstado)
            throws CatalogosException {
        iObjLog.debug("getDescripcionEstado:ENTRANDO |entidad=" + aStrEntidad+", estado="+ aStrEstado);
        String sDescEstado = ""; 
        try {
        	StringBuffer sQuery = new StringBuffer("from SEstado ses ");
        	sQuery.append("where lower(ses.sentidad.sentidad) = lower(:sentidad) ");
        	sQuery.append("and ses.cestado = :cestado");
        	SEstado sestado = (SEstado)iObjSesion.createQuery(sQuery.toString())
        		.setParameter("sentidad",aStrEntidad)
        		.setParameter("cestado",new Integer(aStrEstado))
        		.uniqueResult();
//        	SEstado sestado = (SEstado)iObjSesion.createCriteria(SEstado.class)
//        		.add(Expression.eqProperty("sentidad.sentidad", aStrEntidad))
//        		.add(Expression.eq("cestado",new Integer(aStrEstado)))
//        		.uniqueResult();
            if(sestado !=null){
            	sDescEstado = sestado.getSestado();
            }
        } catch (Exception e) {
            iObjLog.error("getDescripcionEstado:ERROR", e);
            throw new CatalogosException("Error en getSEntidadesConSEstados:", e);
        }
        return sDescEstado;
    }

    /**
     * Metodo que Obtiene el catalogo de las Escalas
     * 
     * @return List Lista de las escalas
     * @throws Exception
     */
    public List getCEscalas() throws CatalogosException {
        iObjLog.debug("<<<<<<getCEscalas");
        List objEscalas = null;
        // Query SQL para la busqueda de Cargas
        Query objQuery = null;
        try {
            String strQuery = "from CEscala escala ";
            objQuery = iObjSesion.createQuery(strQuery);
            objEscalas = objQuery.list();
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getCEscalas", e);
            throw new CatalogosException("Error en getCEscalas:", e);
        }
        iObjLog.debug("RETORNANDOCESCALAS|" + objEscalas + "|");
        return objEscalas;
    }
    
    /**
     * Metodo que Obtiene el tipo de cliente en base al nombre.
     * 
     * @return STipoCliente. Tipo de cliente
     * @throws Exception
     */
    public STipoCliente getTipoClienteNombre(String aStrNomCliente) 
    throws CatalogosException {
        iObjLog.debug("<<<<<<getTipoClienteNombre");
        List objTipoClientes = null;
        // Query SQL para la busqueda de Cargas
        Query objQuery = null;
        STipoCliente objTipoCliente = null;
        try {
            String strQuery = 
            "from STipoCliente tc "+
			"where tc.stipocliente = :tipocliente";
            objQuery = iObjSesion.createQuery(strQuery);
            objQuery.setParameter("tipocliente", aStrNomCliente);
            objTipoClientes = objQuery.list();
            if( objTipoClientes != null && objTipoClientes.size() > 0 ) {
            	objTipoCliente = (STipoCliente) objTipoClientes.get(0);
            }
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getTipoClienteNombre", e);
            throw new CatalogosException("Error en getTipoClienteNombre:", e);
        }
        return objTipoCliente;
    }
    
    /**
     * Este metodo esta encargado de obtener los
     * motivos de cancelacion de la entidad
     * CEstado de TOrdenSucursal
     * @return List Motivos de cancelacion
     * @throws CatalogosException
     */
    public List getMotivosCancelacion(String aStrEntidad)
            throws CatalogosException {
    	iObjLog.debug("ENTRANDOA:getMotivosCancelacionDAO");
        List objMotivos = null;        
        Query objQuery = null;
        try {
        	objMotivos = new ArrayList();
            String strQuery = " from CMotivo Cmot "            	
            	+" where Cmot.ctipomotivo.stipomotivo = :stipomotivo ";                    					
            objQuery = iObjSesion.createQuery(strQuery);
            objQuery.setParameter("stipomotivo", aStrEntidad, Hibernate.STRING);
            objMotivos = objQuery.list();
            
            iObjLog.debug("DatosObtenidosDeMotivos=" + objMotivos.toString());
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getMotivosCancelacion", e);
            throw new CatalogosException("Error en getMotivosCancelacion:", e);
        }
        return objMotivos;
    }    

    /**
     * Este metodo esta encargado de obtener los motivos de incidencia de 
     * la entidad CMotivo para la incidencia indicada, esta incidencia 
     * debe corresponder a la descricion de la entidad SIncidencia
     * @param aStrSIncidencia    
     * @return List Lista con objetos CMotivo 
     * @throws CatalogosException
     */
    public List getMotivosIncidencia(String aStrSIncidencia)
            throws CatalogosException {
    	iObjLog.debug("ENTRANDOA:getMotivosIncidencia");
        List objMotivos = null;        
        Query objQuery = null;
        try {
        	objMotivos = new ArrayList();
            String strQuery = " from CMotivo Cmot "            	
            	+" where Cmot.sincidencia.sincidencia = :sincidencia order by Cmot.cmotivo";                    					
            objQuery = iObjSesion.createQuery(strQuery);
            objQuery.setParameter("sincidencia", aStrSIncidencia, Hibernate.STRING);
            objMotivos = objQuery.list();
            iObjLog.debug("DatosObtenidosDeMotivos=" + objMotivos.toString());
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getMotivosIncidencia", e);
            throw new CatalogosException("Error en getMotivosIncidencia:", e);
        }
        return objMotivos;
    }   
    
    /**
     * Método para obtener un objeto CMotivo a partir del
     * id pasado como parámetro 
     * @param aObjCmotivo id del motivo que se busca 
     * @return CMotivo 
     * @throws Exception
     */
    public CMotivo getCMotivo(Integer aObjCmotivo)
    throws Exception{
    	return (CMotivo)iObjSesion.get(CMotivo.class, aObjCmotivo);
    }
    	
    /**
     * Método para obtener un objeto SEstado a partir del
     * id pasado como parámetro 
     * @param aObjCmotivo id del estado que se busca 
     * @return SEstado 
     * @throws Exception
     */
    public SEstado getSEstado(Integer aObjSEstado)
    throws Exception{
    	return (SEstado)iObjSesion.get(SEstado.class, aObjSEstado);
    }
    
    /**
     * Método para obtener un objeto SSeveridad a partir del
     * id pasado como parámetro 
     * @param aObjCmotivo id de la SSeveridad que se busca 
     * @return SSeveridad 
     * @throws Exception
     */
    public SSeveridad getSSeveridad(Integer aObjSSeveridad)
    throws Exception{
    	return (SSeveridad)iObjSesion.get(SSeveridad.class, aObjSSeveridad);
    }

    /**
     * Metodo que Obtiene el Genero(objeto SGenero) en base al
     * mnemonico(N,F,M,G):
     * 		N - No proporcionado.
     * 		F - Femenino.
     * 		M - Masculino.
     * 		G - Generico.
     * 
     * @return Se regresa el objeto SGenero.
     * @throws Exception
     */
    public SGenero getGeneroPorMnemonico(String aStrMnemonico)
            throws CatalogosException {
        List objGeneros   = null;
        SGenero objGenero = null;
        // Query SQL para la busqueda de Cargas
        Query objQuery = null;
        try {
            String strQuery = "from SGenero genero "
                    + "where genero.smnemonico = :mnemonico ";					

            objQuery = iObjSesion.createQuery(strQuery);
            // Se establecen los parametros de la busqueda
            objQuery.setParameter("mnemonico", aStrMnemonico.trim());
            objGeneros = objQuery.list();
            if( objGeneros != null && objGeneros.size() > 0 ) {
            	iObjLog.debug("Numero de Generos obtenidos con el Mnemonico "+
            		aStrMnemonico +" = "+ objGeneros.size());
            	objGenero = (SGenero)objGeneros.get(0);
            } else {
            	iObjLog.debug("NO se encontro un Genero con el Mnemonico "+
                		aStrMnemonico);
            }
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getGeneroPorMnemonico", e);
            throw new CatalogosException("Error en getGeneroPorMnemonico:",
                    e);
        }
        return objGenero;
    }        
    
    /**
     * Metodo que Obtiene el catalogo de Entidades del sistema
     * @return se regresa la lista de entidades con sus estados
     * @throws Exception
     */
    public List getSMotivosConSEstados() 
    throws CatalogosException {
        List objSMotivos = null;
        try {
            String strQuery = "from CTipoMotivo cTipo";
            objSMotivos = iObjSesion.find(strQuery);

            //Se inicializan los estados de cada entidad
            Iterator objIt = objSMotivos.iterator();
            while (objIt.hasNext()) {
                CTipoMotivo objAux = (CTipoMotivo) objIt.next();
                Hibernate.initialize(objAux.getCmotivos());
            }
            iObjLog.debug("DatosObtenidosDeMotivosconEstados="
                    + objSMotivos.toString());
            return objSMotivos;
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getSMotivosConSEstados", e);
            throw new CatalogosException("Error en getSMotivosConSEstados:", e);
        }
    }
       
    /**
     * Metodo que Obtiene el Listado de los Generos(objetos SGenero) 
     * registrados en la base de datos:
     * 		N - No proporcionado.
     * 		F - Femenino.
     * 		M - Masculino.
     * 		G - Generico.
     * 
     * @return Listado de Generos(objetos SGenero).
     * @throws Exception
     */
    public List getSGeneros()
    throws CatalogosException {
    	// Listado de objetos SGenero
    	List objGeneros   = null;
        // Query SQL para la busqueda de Cargas
        Query objQuery = null;
        try {
            String strQuery = "from SGenero";                    
            objQuery = iObjSesion.createQuery(strQuery);
            objGeneros = objQuery.list();
        } catch (Exception e) {
            iObjLog.error("ERROR AL HACER QUERY: getSGeneros", e);
            throw new CatalogosException("Error en getSGeneros:", e);
        }
        return objGeneros;
    }  
    
    /**
     * Este método se encarga de buscar el siguiente id del SEQUENCE que corresponda 
     * al tipo de secuencia determinado por el tipo de secuencia (arg1 - aStrTipoSecuencia) 
     * y unidad (arg2 - aStrNombreUnidad)
     * @param aStrTipoSecuencia
     * @param aStrNombreUnidad
     * @return Integer 
     * @throws Exception
     */
    public Integer getSequenceNextId(String aStrTipoSecuencia, Integer aObjCUnidad)
    throws Exception{
    	iObjLog.debug("getSequenceNextId:OBteniendo: Tipo_Secuencia | Unidad: " + aStrTipoSecuencia + " | " + aObjCUnidad);
        Integer objRet = null;
        Statement objSta = null;
        ResultSet objRs = null;
    	try{
    		Map objCacheSecuencias = CachesSecuencias.getCacheSecuencias(aStrTipoSecuencia, iObjSesion);
            String strSecuencia = ((String) objCacheSecuencias.get(aObjCUnidad));
        	iObjLog.debug("_____>>>>> Se encontró la secuencia: " + strSecuencia);
	        Connection objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
	        objRs = objSta.executeQuery("select " + strSecuencia + ".nextVal sig from dual");
        	iObjLog.debug("_____>>>>> Query para encontrar secuencia: select " + strSecuencia + ".nextVal sig from dual");
	        while(objRs.next()){
	        	iObjLog.debug("_____>>>>> Id encontrado " + objRs.toString());
	        	objRet = new Integer(objRs.getString("sig"));
	        	iObjLog.debug("_____>>>>> Id encontrado " + objRet);
	        }
    	} catch(Exception aError){
        	iObjLog.error("_____>>>>> ERROR AL HACER QUERY: getSequenceNextId" + aError.toString());
        	throw aError;
        } finally{
            if(objRs != null)objRs.close();
            if(objSta !=  null)objSta.close();
        }
        iObjLog.debug("getSequenceNextId:REGRESA:");
    	return objRet;
    }
                
    /**
     * Metodo que realiza una busqueda de un registro en la tabla STIPOVIAJE
     * en base al campo STIPOVIAJE.
     * 
     * @param aStrTipoViaje. 
     * 		Descripcion del tipo de viaje a buscar.
     * @return
     * 		Objeto STipoViaje que coincida con la descripcion que 
     * 		se recibe como parametro.
     * 
     * @throws CatalogosException
     */
    public STipoViaje getSTipoViajePorNombre(String aStrTipoViaje)
    throws CatalogosException {
		List objTiposViajes   = null;
		STipoViaje objSTipoViaje = null;
		Query objQuery = null;
		try {
		    String strQuery = "from STipoViaje tipoviaje "
		            + "where tipoviaje.stipoviaje = :stipoviaje ";					
		    objQuery = iObjSesion.createQuery(strQuery);
		    // Se establecen los parametros de la busqueda
		    objQuery.setParameter("stipoviaje", aStrTipoViaje.trim());
		    objTiposViajes = objQuery.list();
		    if( objTiposViajes != null && objTiposViajes.size() > 0 ) {
		    	objSTipoViaje = (STipoViaje)objTiposViajes.get(0);
		    } else {
		    	iObjLog.debug("NO se encontro un STipoViaje con la descripcion: "+
		    			aStrTipoViaje);
		    }
		} catch (Exception e) {
		    iObjLog.error("ERROR AL HACER QUERY: getSTipoViajePorNombre", e);
		    throw new CatalogosException("Error en getSTipoViajePorNombre:", e);
		}
		return objSTipoViaje;
	}            
    
    /**
     * Metodo que realiza una busqueda de un registro en la tabla STIPOVIAJE
     * en base al campo STIPOVIAJE.
     * 
     * @param aStrTipoViaje. 
     * 		Descripcion del tipo de viaje a buscar.
     * @return
     * 		Objeto STipoViaje que coincida con la descripcion que 
     * 		se recibe como parametro.
     * 
     * @throws CatalogosException
     */
    public STipoLaboratorio getSTipoLaboratorio(String aStrTipoLaboratorio)
    throws CatalogosException {
		STipoLaboratorio objSTipoLaboratorio = null;
		Query objQuery = null;
		try {
		    String strQuery = "from STipoLaboratorio tipolab " +
		            " where tipolab.stipolaboratorio = :stipolab ";					
		
		    objQuery = iObjSesion.createQuery(strQuery);
		    objQuery.setString("stipolab", aStrTipoLaboratorio);
		    objSTipoLaboratorio = (STipoLaboratorio)objQuery.uniqueResult();
		} catch( Exception aObjExcepcion ) {
		    iObjLog.error("ERROR AL HACER QUERY: getSTipoViajePorNombre", aObjExcepcion);
		    throw new CatalogosException("Error en getSTipoLaboratorio:", aObjExcepcion);
		}
		return objSTipoLaboratorio;
	}
    
    
    /**
     * Este método se encarga de buscar el siguiente id 
     * @return Integer 
     * @throws Exception
     */
    public Integer getSequenceNextIdCalendar()
    throws Exception{
    	iObjLog.debug("Ejecutando getSequenceNextIdCalendar...");
        Integer objRet = null;
        Statement objSta = null;
        ResultSet objRs = null;
    	try{
	        Connection objCon = iObjSesion.connection();
	        objSta = objCon.createStatement();
	        objRs = objSta.executeQuery("select TURBINE_CALENDAR_SEQUENCE.nextVal sig from dual");
        	iObjLog.debug("select TURBINE_CALENDAR_SEQUENCE.nextVal sig from dual");
	        while(objRs.next()){
	        	iObjLog.debug("_____>>>>> Id encontrado " + objRs.toString());
	        	objRet = new Integer(objRs.getString("sig"));
	        	iObjLog.debug("_____>>>>> Id encontrado " + objRet);
	        }
    	} catch (Exception aError){
        	iObjLog.error("ERROR EN QUERY: getSequenceNextIdCalendar" + aError.toString());
        	throw aError;
        } finally {
            if(objRs != null)objRs.close();
            if(objSta !=  null)objSta.close();
        }
    	return objRet;
    }    
}
