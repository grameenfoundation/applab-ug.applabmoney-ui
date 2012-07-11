package metomeui.dao;

import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import metomeui.model.User;
import metomeui.web.UserLoginController;

public class UserDao {
	private static Logger logger = Logger.getLogger(UserDao.class);

	/*
	 * @SuppressWarnings("rawtypes") // private static final ThreadLocal session
	 * = new ThreadLocal(); private static final SessionFactory sessionFactory =
	 * new AnnotationConfiguration() .configure().buildSessionFactory(); static
	 * Session session = sessionFactory.getCurrentSession();
	 * 
	 * 
	 * 
	 * @SuppressWarnings("unchecked") public static Session getSession() {
	 * Session session = (Session) UserDao.session.get(); if (session == null) {
	 * session = sessionFactory.openSession(); UserDao.session.set(session); }
	 * return session; }
	 * 
	 * protected void begin() { getSession().beginTransaction(); }
	 * 
	 * protected void commit() { getSession().getTransaction().commit(); }
	 * 
	 * @SuppressWarnings("unchecked") protected void rollback() { try {
	 * getSession().getTransaction().rollback(); } catch (HibernateException e)
	 * { logger.warn("Cannot rollback", e); } try { getSession().close(); }
	 * catch (HibernateException e) { logger.warn("Cannot close", e); }
	 * UserDao.session.set(null); }
	 * 
	 * @SuppressWarnings("unchecked") public static void close() {
	 * getSession().close(); UserDao.session.set(null); }
	 */

	public UserDao() {
	}

	public boolean checkIfUserExists(String userName, String password) {
		boolean exist = false;
		logger.info("getting sessions!!!!!!!!!!!!!!!");
		/** Getting the Session Factory and session */
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session sess = session.getCurrentSession();
		/** Starting the Transaction */
		Transaction tx = sess.beginTransaction();

		Query q = sess.createQuery("from User where name = :username and password = :password");
		q.setString("username", userName);
		q.setString("password", password);
		User user = (User) q.uniqueResult();
		/** Committing the changes */
		tx.commit();
		if (user != null) {
			exist = true;
			logger.info("User exists");
		} else {
			exist = false;
		}
		
		/** Closing Session */
		session.close();
		return exist;
	}

	@SuppressWarnings("unused")
	public boolean checkIfUserExists2(String userName, String password)
			throws Exception {
		boolean exist = false;
		logger.info("getting sessions!!!!!!!!!!!!!!!");
		Session session = null;
		//Session session = getSession();

		if (session != null) {
			try {
				//begin();
				Query q = session
						.createQuery("from User where name = :username and password = :password");
				q.setString("username", userName);
				q.setString("password", password);
				User user = (User) q.uniqueResult();
				//commit();
				if (user != null) {
					exist = true;
				} else {
					exist = false;
				}
			} catch (HibernateException e) {
				//rollback();
				throw new Exception("Could not get user " + userName, e);
			}
		} else {
			logger.info("Seession nara exists!!!!!!!!!!!!!!!");
		}

		return exist;
	}
}
