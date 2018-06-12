package mx.com.web2lab.backend.hbm;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase encargada de administrar las sesiones para el uso de hibernate
 *  
 *
 */
public class HibernateUtil{
	/** Log de la aplicacion */
	private static Log log = LogFactory.getLog(HibernateUtil.class);
	/** Variable estatica de clase para la sesion */
	private static final SessionFactory sessionFactory;
	/** Variable estatica de clase para la sesion */
	public static final ThreadLocal session = new ThreadLocal();
    /** variable estatica de clase para la transaccion en la BD */
	public static final ThreadLocal transaction = new ThreadLocal();
	
	/** Se crea el session Factory con la configuracion hibernate.cfg.xml*/
	static{
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable e) {
			log.error("Ocurrió un Error creando el SessionFactory:", e);
			throw new RuntimeException("Ocurrió un Error creando el SessionFactory: " + e.getMessage(), e);
		}
	}
	
	/**
    * Obtiene la sesion actual de este thread y en caso de no tenerla,
    * se crea una nueva.
    * @return Session. Sesion actual del thread.
    */
	public static synchronized Session getSession(){
		Session s = (Session) session.get();
		try{
			if(s == null){
				s = sessionFactory.openSession();
				session.set(s);
				log.debug("Se abre una sesion de hibernate --> " + s);
			}
		} catch(HibernateException e){
			log.error("getSession:ERROR", e);
			throw new RuntimeException("Ocurrió un error al obtener la sesion: " + e.getMessage(), e);
		}
		return s;
	}
 
    /**
    * Cierra la sesion actual del thread.
    */
	public static void closeSession(){
		try{
			Session s = (Session) session.get();
			session.set(null);
			log.debug("Se cierra la sesion de hibernate --> " + s);
			if(s != null && s.isOpen())s.close();
		} catch(HibernateException e){
			log.error("closeSession:ERROR", e);
			throw new RuntimeException("Ocurrió un error al cerrar la sesion: " + e.getMessage(), e);
		}
	}

	
    /**
    * Proporciona una Conexion.
    */
	public static java.sql.Connection conexionSession(){
		try{
			Session s = (Session) session.get();
			return s.connection();
		} catch(HibernateException e){
			log.error("conexionSession:ERROR", e);
			throw new RuntimeException("Ocurrió un error al dar la conexion de la sesion: " + e.getMessage(), e);
		}
	}	
	
	/** 
	 * comienza una transaccion en la BD para la sesion actual
	 */
	public static void beginTrans(){
		Transaction tx = (Transaction) transaction.get();
		try{
			if(tx==null){
				tx = getSession().beginTransaction();
				transaction.set(tx);
				log.debug("Se inicia una transaccion en la BD --> " + tx);
			}
		} catch(HibernateException e) {
			log.error("beginTrans:ERROR", e);
			throw new RuntimeException("Ocurrió un error al iniciar la transaccion en la BD: " + e.getMessage(), e);
		}
	}
	
	/**
	 * realiza un commit en la BD para la sesion actual 
	 *
	 */
	public static void commitTrans() {
		Transaction tx = (Transaction) transaction.get();
		try {
			if(tx != null){
				log.debug("commitTrans --> tx.wasCommitted() = " + tx.wasCommitted() + 
						" | tx.wasRolledBack() = " + tx.wasRolledBack());
			}
			if ( tx != null && 
					!tx.wasCommitted() && 
					!tx.wasRolledBack() )
				log.debug("Se mando un COMMIT a la BD --> " + tx);
//				tx.commit();
			transaction.set(null);
		} catch (Exception e) {
			log.error("commitTrans:ERROR", e);
			rollbackTrans();
			throw new RuntimeException("Ocurrió un error al realizar el commit en la BD: " + e.getMessage(), e);
		}
	}
	
	/**
	 * realiza un rollback en la BD para la sesion actual 
	 *
	 */
	public static void rollbackTrans() {
		Transaction tx = (Transaction) transaction.get();
		try {
			transaction.set(null);
			if(tx != null){
				log.debug("rollbackTrans --> tx.wasCommitted() = " + tx.wasCommitted() + 
						" | tx.wasRolledBack() = " + tx.wasRolledBack());
			}
			if ( tx != null && !tx.wasCommitted()
					&& !tx.wasRolledBack() ) {
				log.debug("Se mando un ROLLBACK a la BD --> " + tx);
				tx.rollback();
			}
		} catch (HibernateException e) {
			log.error("rollbackTrans:ERROR", e);
			throw new RuntimeException("Ocurrió un error al realizar el rollback en la BD: " + e.getMessage(), e);
		} /*finally {
			closeSession();
		}*/
	}


}
