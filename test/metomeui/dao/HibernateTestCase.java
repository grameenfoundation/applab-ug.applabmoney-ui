package metomeui.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert.*;

public class HibernateTestCase {
	protected Logger log = Logger.getLogger(HibernateTestCase.class);
	private Session session;
	private static SessionFactory sessionFactory;

	static {
		// H2 database works only if Bla.id has one of the following
		// annotations:
		// @GeneratedValue(strategy = GenerationType.SEQUENCE) or
		// GenerationType.TABLE
		/*HibernateUtil.setConfiguration(HibernateUtil
				.getConfiguration()
				.setProperty("hibernate.connection.driver_class",
						"com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url",
						"jdbc:mysql://localhost/applabmoney")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "root123")
				.setProperty("hibernate.dialect",
						"org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.show_sql", "true"));
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();*/
		
		
		/*assertFalse(HibernateUtil.getConfiguration()
				.getProperty("hibernate.connection.driver_class")
				.equals("com.mysql.jdbc.Driver"));*/
		// We only need to create the schema for in-memory databases and for
		// newly created databases!
		boolean freshDatabase = true;
		/*if (freshDatabase) {
			session.beginTransaction();
			String CREATE_SCHEMA = "create schema MY_SCHEMA";
			session.createSQLQuery(CREATE_SCHEMA).executeUpdate();
			session.getTransaction().commit();
			session = sessionFactory.getCurrentSession();
		}

		session.beginTransaction();
		HibernateUtil.recreateSchema();

		if (session.isOpen()) {
			session.close();
		}*/
	}

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().rollback();
		if (session.isOpen()) {
			session.close();
		}
	}

	public Session getSession() {
		return session;
	}

	public void commitAndCreateNewSession() {
		session.getTransaction().commit();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}
}
