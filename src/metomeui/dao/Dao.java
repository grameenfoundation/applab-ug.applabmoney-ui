package metomeui.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dao {
	protected Dao() {
	}

	public static Session getSession() {
		Session session = (Session) Dao.session.get();
		if (session == null) {
			session = sessionFactory.openSession();
			Dao.session.set(session);
		}
		return session;
	}

	protected void begin() {
		getSession().beginTransaction();
	}

	protected void commit() {
		getSession().getTransaction().commit();
	}

	protected void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot rollback", e);
		}
		try {
			getSession().close();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot close", e);
		}
		Dao.session.set(null);
	}

	public static void close() {
		getSession().close();
		Dao.session.set(null);
	}

	private static final Logger log = Logger.getAnonymousLogger();
	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	private static final SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();
}