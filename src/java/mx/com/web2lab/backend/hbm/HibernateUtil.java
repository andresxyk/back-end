package mx.com.web2lab.backend.hbm;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase encargada de administrar las sesiones para el uso de Hibernate.
 */
public class HibernateUtil {
	private static Log log = LogFactory.getLog(HibernateUtil.class);
	private static final SessionFactory sessionFactory;
	public static final ThreadLocal session = new ThreadLocal();
	public static final ThreadLocal transaction = new ThreadLocal();

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			log.error("Ocurri&oacute; un error creando el SessionFactory:", e);
			throw new RuntimeException("Error al crear SessionFactory: " + e.getMessage(), e);
		}
	}

	public static synchronized Session getSession() {
		Session s = (Session) session.get();
		try {
			if (s == null || !s.isOpen()) {
				s = sessionFactory.openSession();
				session.set(s);
				log.debug("Se abre una sesi&oacute;n de Hibernate --> " + s);
			}
		} catch (HibernateException e) {
			log.error("getSession:ERROR", e);
			throw new RuntimeException("Error al obtener la sesi&oacute;n: " + e.getMessage(), e);
		}
		return s;
	}

	public static void closeSession() {
		Session s = (Session) session.get();
		session.set(null);
		try {
			if (s != null && s.isOpen()) {
				log.debug("Se cierra la sesi&oacute;n de Hibernate --> " + s);
				s.close();
			}
		} catch (HibernateException e) {
			log.error("closeSession:ERROR", e);
			throw new RuntimeException("Error al cerrar la sesi&oacute;n: " + e.getMessage(), e);
		}
	}

	public static java.sql.Connection conexionSession() {
		try {
			Session s = (Session) session.get();
			if (s == null || !s.isOpen()) {
				throw new RuntimeException("Sesi&oacute;n no disponible para obtener la conexi&oacute;n.");
			}
			return s.connection();
		} catch (HibernateException e) {
			log.error("conexionSession:ERROR", e);
			throw new RuntimeException("Error al obtener la conexi&oacute;n: " + e.getMessage(), e);
		}
	}

	public static void beginTrans() {
		try {
			Transaction tx = (Transaction) transaction.get();
			if (tx == null) {
				tx = getSession().beginTransaction();
				transaction.set(tx);
				log.debug("Se inicia una transacci&oacute;n --> " + tx);
			}
		} catch (HibernateException e) {
			log.error("beginTrans:ERROR", e);
			throw new RuntimeException("Error al iniciar la transacci&oacute;n: " + e.getMessage(), e);
		}
	}

	public static void commitTrans() {
		Transaction tx = (Transaction) transaction.get();
		transaction.set(null);
		try {
			if (tx != null) {
				log.debug("commitTrans --> tx.wasCommitted() = " + tx.wasCommitted() +
						  " | tx.wasRolledBack() = " + tx.wasRolledBack());

				Session s = (Session) session.get();
				if (!tx.wasCommitted() && !tx.wasRolledBack() && s != null && s.isOpen()) {
					log.debug("Se manda un COMMIT a la BD --> " + tx);
			//		tx.commit();
				} else {
					log.info("No se realiz&oacute; commit: transacci&oacute;n ya cerrada o sesi&oacute;n no abierta.");
				}
			}
		} catch (Exception e) {
			log.error("commitTrans:ERROR", e);
			rollbackTrans();
			throw new RuntimeException("Error al hacer commit: " + e.getMessage(), e);
		}
	}

	public static void rollbackTrans() {
		Transaction tx = (Transaction) transaction.get();
		transaction.set(null);
		try {
			Session s = (Session) session.get();
			if (tx != null) {
				log.debug("rollbackTrans --> tx.wasCommitted() = " + tx.wasCommitted() +
						  " | tx.wasRolledBack() = " + tx.wasRolledBack());

				if (!tx.wasCommitted() && !tx.wasRolledBack()) {
					if (s != null && s.isOpen()) {
						log.debug("Se manda un ROLLBACK a la BD --> " + tx);
						tx.rollback();
					} else {
						log.info("No se pudo hacer rollback: la sesi&oacute;n est&aacute; cerrada.");
					}
				}
			}
		} catch (HibernateException e) {
			log.error("rollbackTrans:ERROR", e);
			throw new RuntimeException("Error al hacer rollback: " + e.getMessage(), e);
		}
	}
}
