package metomeui.dao;

import java.util.List;
import java.text.MessageFormat;

import metomeui.model.AccountType;
import metomeui.model.ContactForm;
import metomeui.model.Customer;
import metomeui.model.Language;
import metomeui.model.Login;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Repository("systemSettingsDao") declares that the annotated class is a
 *                                  "DAO".
 * @Autowired is being used to make the SessionFactory instance available
 *            automatically by spring.
 */

@Repository("systemSettingsDao")
@Transactional
public class SystemSettingsDaoImplementation implements SystemSettingsDao {

	private static Logger logger = Logger
			.getLogger(SystemSettingsDaoImplementation.class);

	private SessionFactory sessionFactory;

	private Session currentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	/**
	 * User Management functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		currentSession().beginTransaction();
		return (List<User>) currentSession().createCriteria(User.class).list();
	}

	public void addUser(User user) {
		try {
			currentSession().beginTransaction();
			logger.debug("Saving predefInputItem");
			currentSession().saveOrUpdate(user);
			currentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}
	}

	public User getUserByName(String userName, String password) {
		currentSession().beginTransaction();
		return (User) currentSession()
				.createQuery(
						"from User user "
								+ "where user.userName = :username and user.password = :password")
				.setParameter("username", userName)
				.setParameter("password", password).setMaxResults(1)
				.uniqueResult();
	}

	public User getUserLoginByName(String userName, String password) {
		currentSession().beginTransaction();
		return (User) currentSession()
				.createQuery(
						"from User user "
								+ "where user.userName = :username and user.password = :password")
				.setParameter("username", userName)
				.setParameter("password", password).uniqueResult();
	}

	public void removeUser(Integer userId) {
		currentSession().beginTransaction();
		User user = (User) currentSession().load(User.class, userId);
		if (null != user) {
			currentSession().delete(user);
		}
	}

	/**
	 * Message Management functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Message> listMessages() {
		return (List<Message>) sessionFactory.getCurrentSession()
				.createCriteria(Message.class).list();
	}

	public void addMessage(Message message) {
		sessionFactory.getCurrentSession().saveOrUpdate(message);
	}

	public void removeMessage(Integer messageId) {
		Message message = (Message) sessionFactory.getCurrentSession().load(
				Message.class, messageId);
		if (null != message) {
			sessionFactory.getCurrentSession().delete(message);
		}
	}

	/**
	 * AccountTypes Management functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<AccountType> listAccountTypes() {
		return (List<AccountType>) sessionFactory.getCurrentSession()
				.createCriteria(AccountType.class).list();
	}

	public void addAccountType(AccountType accountType) {
		sessionFactory.getCurrentSession().saveOrUpdate(accountType);
	}

	/**
	 * Language Management functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Language> listLanguages() {
		return (List<Language>) sessionFactory.getCurrentSession()
				.createCriteria(Language.class).list();
	}

	public void removeLanguage(Integer languageId) {
		Language language = (Language) sessionFactory.getCurrentSession().load(
				Language.class, languageId);
		if (null != language) {
			sessionFactory.getCurrentSession().delete(language);
		}
	}

	public void addLanguage(Language language) {
		sessionFactory.getCurrentSession().saveOrUpdate(language);
	}

	/**
	 * MemoGroup Management functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<MemoGroup> listMemoGroups() {
		return (List<MemoGroup>) sessionFactory.getCurrentSession()
				.createCriteria(MemoGroup.class).list();
	}

	public void addMemoGroup(MemoGroup memoGroup) {
		sessionFactory.getCurrentSession().saveOrUpdate(memoGroup);
	}

	public void removeMemoGroup(Integer memoGroupId) {
		MemoGroup memoGroup = (MemoGroup) sessionFactory.getCurrentSession()
				.load(MemoGroup.class, memoGroupId);
		if (null != memoGroup) {
			sessionFactory.getCurrentSession().delete(memoGroup);
		}
	}

	/**
	 * System Config functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<SystemConfiguration> listSystemConfiguration() {
		return (List<SystemConfiguration>) sessionFactory.getCurrentSession()
				.createCriteria(SystemConfiguration.class).list();
	}

	public void addSystemConfiguration(SystemConfiguration systemConfiguration) {
		sessionFactory.getCurrentSession().saveOrUpdate(systemConfiguration);
	}

	public void removeSystemConfiguration(Integer systemConfigurationId) {
		SystemConfiguration systemConfiguration = (SystemConfiguration) sessionFactory
				.getCurrentSession().load(SystemConfiguration.class,
						systemConfigurationId);
		if (null != systemConfiguration) {
			sessionFactory.getCurrentSession().delete(systemConfiguration);
		}
	}

	@Override
	public List<Object> listObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addObject(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObject(Integer objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAccountType(long accountTypeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editExistingUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getExistingUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language getExistingLanguage(long languageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editExistingLanguage(Language language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message getExistingMessage(long messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editExistingMemoGroup(MemoGroup memoGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemoGroup getExistingMemoGroup(long memoGroupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editExistingMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountType getExistingAccountType(long accountTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editExistingAccountType(AccountType accountType) {
		// TODO Auto-generated method stub
		
	}

}
