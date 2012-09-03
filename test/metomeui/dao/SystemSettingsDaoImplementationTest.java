package metomeui.dao;

import static org.junit.Assert.*;

import java.text.MessageFormat;

import junit.framework.Assert;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import applabmoneyaui.dao.Constants;
import applabmoneyaui.dao.HibernateUtil;
import applabmoneyaui.dao.SystemSettingsDaoImplementation;
import applabmoneyaui.dao.UssdMenuDao;
import applabmoneyaui.dao.UssdMenuDaoImplementation;
import applabmoneyaui.model.Login;
import applabmoneyaui.model.User;
import applabmoneyaui.model.UssdMenuItem;
import applabmoneyaui.model.UssdPredefInput;
import applabmoneyaui.model.UssdPredefInputItem;

public class SystemSettingsDaoImplementationTest {

	private SystemSettingsDaoImplementation systemSettingsDao = new SystemSettingsDaoImplementation();
	private UssdMenuDao ussdMenuDao = new UssdMenuDaoImplementation();
	
	private HibernateUtil hibernateUtil = new HibernateUtil();

	private Session currentSession() {
		return hibernateUtil.getSessionFactory().getCurrentSession();
	}

	@Test
	public void testAddMenuItem() throws Exception {
		ussdMenuDao = new UssdMenuDaoImplementation();
		UssdMenuItem ussdMenuItem = new UssdMenuItem("afdhj", 2, null);
		currentSession().beginTransaction();
		currentSession().save(ussdMenuItem);
		currentSession().getTransaction().commit();
		//assertNotNull(session.save(ussdMenuItem));
		//ussdMenuDao.addMenuItem(ussdMenuItem);
		//assertEquals(true, ussdMenuDao.isSuccess());
		//UssdMenuItem ussdMenuItem1 = new UssdMenuItem();
		//ussdMenuItem1.setMenuItemName("afdhj");
		//String name = ussdMenuItem.getMenuItemName();
		
		
		
		//assertEquals(ussdMenuItem.getMenuItemName(), "afdhj");
		//ussdMenuItem.setRootMenuItem(null);
		//assertNull(ussdMenuItem.getRootMenuItem());

		
		//org.junit.Assert.assertTrue("true", ussdMenuDao.addMenuItem(ussdMenuItem));
	}

	@Test
	public void testSaveRecord() throws Exception {
		currentSession().beginTransaction();

		User user = new User();
		user.setUserName("afdhj");
		user.setPassword("vHJABS");
		user.setFirstName("Trror");
		user.setLastName("asfdh");
		user.setMiddleName("saghgd");
		user.setRole("fadgf");
		user.setEmail("dfs@hgfshasf.com");
		user.setTelephone("safdgh");

		String userName = "afdhj";
		String password = "vHJABS";

		currentSession().saveOrUpdate(user);
		//systemSettingsDao.addUser(user);

	//	org.junit.Assert.assertSame(session.saveOrUpdate(user), systemSettingsDao.addUser(user));

	}

	public void testUserFunctions() throws Exception {

		String userName = "testuname";
		String password = "testpass";

		User user = new User();
		user.setUserName("testuname");
		user.setPassword("testpass");
		user.setFirstName("Trror");
		user.setLastName("asfdh");
		user.setMiddleName("saghgd");
		user.setRole("fadgf");
		user.setEmail("dfs@hgfshasf.com");
		user.setTelephone("safdgh");
		//systemSettingsDao.addUser(user);

		currentSession().beginTransaction();
		User user1 = new User();
		user1 = (User) currentSession()
				.createQuery(
						"from User user "
								+ "where user.userName = :username and user.password = :password")
				.setParameter("username", userName)
				.setParameter("password", password).setMaxResults(1)
				.uniqueResult();

		User user2 = systemSettingsDao.getUserByLogin(userName, password);

		assertEquals(user1, user2);

		Login login1 = new Login();
		login1.setUserName("testuname");
		login1.setPassword("testpass");
		User user3 = systemSettingsDao.getUserByLogin(userName, password);

		assertEquals(user1, user3);

		systemSettingsDao.removeExistingUser(user.getUserId());
		user1 = (User) currentSession()
				.createQuery("from User user " + "where user.userId = :userid")
				.setParameter("userid", user.getUserId()).setMaxResults(1)
				.uniqueResult();

		// assertNull(user1);
	}

	@Test
	public void testPredefInputSave() throws Exception {

		UssdPredefInput predefInput = new UssdPredefInput();
		predefInput.setPredefInputName("Sales");
		predefInput.setPredefInputDescription("Test");
		ussdMenuDao.addPredefInput(predefInput);

		UssdPredefInputItem predefInputItem = new UssdPredefInputItem("Nina",
				"Mayers", 4, 0);
		UssdPredefInputItem predefInputItem2 = new UssdPredefInputItem("Tony",
				"Almeida", 6, 1);

		predefInputItem.setPredefInput(predefInput);
		predefInputItem2.setPredefInput(predefInput);
	}

	@Test
	public void testCheckIfUserExists() throws Exception {
		// UserDaoImplementation userDaoImplementation = new
		String SELECT_STATEMENT = MessageFormat
				.format("SELECT count(user) FROM {0} AS user WHERE user.userName = :{1} AND user.password != :{2}",
						User.class.getName(), Constants.NAME_PROP_NAME,
						Constants.PASS_PROP_PASS);
		//SessionFactory sessionFactory = null;
		//Session session = sessionFactory.getCurrentSession();
		currentSession().beginTransaction();
		Query query = currentSession().createQuery(SELECT_STATEMENT);
		query.setString(Constants.NAME_PROP_NAME, "afdhj");
		query.setString(Constants.PASS_PROP_PASS, "vHJABS");
		query.setMaxResults(1);
		long count = (Long) query.uniqueResult();
		assertEquals(count, 0);

	}
}