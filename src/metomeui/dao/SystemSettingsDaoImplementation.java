package metomeui.dao;

import java.util.List;

import metomeui.model.AccountType;
import metomeui.model.Language;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.NdcListOffnet;
import metomeui.model.NdcListPToP;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;

import org.apache.log4j.Logger;
import org.hibernate.classic.Session;
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

	private Session currentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	/**
	 * User Management functions
	 */
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		currentSession().beginTransaction();
		return (List<User>) currentSession().createCriteria(User.class).list();
	}

	public void addUser(User user) {
		try {
			currentSession().beginTransaction();
			logger.debug("Saving user");
			currentSession().save(user);
			currentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}
	}

	public User getUserByLogin(String userName, String password) {
		currentSession().beginTransaction();
		return (User) currentSession()
				.createQuery(
						"from User user "
								+ "where user.userName = :username and user.password = :password")
				.setParameter("username", userName)
				.setParameter("password", password).setMaxResults(1)
				.uniqueResult();
	}

	@Override
	public User getExistingUser(Long userId) {
		currentSession().beginTransaction();
		User existingUser = (User) currentSession().load(User.class, userId);
		return existingUser;
	}

	@Override
	public void editExistingUser(User user) {
		currentSession().beginTransaction();
		User existingUser = (User) currentSession().load(User.class,
				user.getUserId());
		if (null != existingUser) {
			existingUser.setUserName(user.getUserName());
			existingUser.setPassword(user.getPassword());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setMiddleName(user.getMiddleName());
			existingUser.setRole(user.getRole());
			existingUser.setTelephone(user.getTelephone());
			existingUser.setEmail(user.getEmail());
		}

		try {
			currentSession().update(existingUser);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public void removeUser(Long userId) {
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
		currentSession().beginTransaction();
		return (List<Message>) currentSession().createCriteria(Message.class)
				.list();
	}

	public void addMessage(Message message) {
		try {
			currentSession().beginTransaction();
			currentSession().save(message);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public void removeMessage(Long messageId) {
		try {
			currentSession().beginTransaction();
			Message message = (Message) currentSession().load(Message.class,
					messageId);
			if (null != message) {
				currentSession().delete(message);
				currentSession().getTransaction().commit();
			}
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public Message getExistingMessage(Long messageId) {
		currentSession().beginTransaction();
		Message existingMessage = (Message) currentSession().load(
				Message.class, messageId);
		return existingMessage;
	}

	public void editExistingMessage(Message message) {
		currentSession().beginTransaction();
		Message existingMessage = (Message) currentSession().load(
				Message.class, message.getMessageId());
		if (null != existingMessage) {
			existingMessage.setMessageCode(message.getMessageCode());
			existingMessage.setMessageDesc(message.getMessageDesc());
			existingMessage.setMessageText(message.getMessageText());
			existingMessage.setLanguage(message.getLanguage());
		}

		try {
			currentSession().update(existingMessage);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	/**
	 * MemoGroup Management functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<MemoGroup> listMemoGroups() {
		currentSession().beginTransaction();
		return (List<MemoGroup>) currentSession().createCriteria(
				MemoGroup.class).list();
	}

	public void addMemoGroup(MemoGroup memoGroup) {
		try {
			currentSession().beginTransaction();
			currentSession().save(memoGroup);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void deleteExistingMemoGroup(Long memoGroupId) {
		currentSession().beginTransaction();
		MemoGroup memoGroup = (MemoGroup) currentSession().load(
				MemoGroup.class, memoGroupId);
		try {
			currentSession().delete(memoGroup);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void editExistingMemoGroup(MemoGroup memoGroup) {
		currentSession().beginTransaction();
		MemoGroup existingMemoGroup = (MemoGroup) currentSession().load(
				MemoGroup.class, memoGroup.getMemoGroupId());
		if (null != existingMemoGroup) {
			existingMemoGroup.setMemoGroupCode(memoGroup.getMemoGroupCode());
			existingMemoGroup.setMemoGroupDescription(memoGroup
					.getMemoGroupDescription());
			existingMemoGroup.setMemoGroupName(memoGroup.getMemoGroupName());
		}

		try {
			currentSession().update(existingMemoGroup);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public MemoGroup getExistingMemoGroup(Long memoGroupId) {
		currentSession().beginTransaction();
		MemoGroup existingMemoGroup = (MemoGroup) currentSession().load(
				MemoGroup.class, memoGroupId);
		return existingMemoGroup;
	}

	@Override
	public void activateOrDeactivateExistingMemoGroup(Long memoGroupId,
			Integer onOffSwitch) {
		currentSession().beginTransaction();
		MemoGroup existingMemoGroup = (MemoGroup) currentSession().load(
				MemoGroup.class, memoGroupId);
		existingMemoGroup.setEnabledFlag(onOffSwitch);
		try {
			currentSession().update(existingMemoGroup);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}

	}

	/**
	 * AccountTypes Management functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<AccountType> listAccountTypes() {
		return (List<AccountType>) currentSession().createCriteria(
				AccountType.class).list();
	}

	public void addAccountType(AccountType accountType) {
		try {
			currentSession().beginTransaction();
			currentSession().save(accountType);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void editExistingAccountType(AccountType accountType) {
		currentSession().beginTransaction();
		AccountType existingAccountType = (AccountType) currentSession().load(
				AccountType.class, accountType.getAccountTypeId());

		if (null != existingAccountType) {
			existingAccountType.setAccountTypeName((accountType
					.getAccountTypeName()));
			existingAccountType.setAccountTypeCode((accountType
					.getAccountTypeCode()));
			existingAccountType.setAccountMaximumBookBalance(accountType
					.getAccountMaximumBookBalance());
			existingAccountType.setAccountTypeBitMap(accountType
					.getAccountTypeBitMap());
			try {
				currentSession().update(existingAccountType);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	public AccountType getExistingAccountType(Long accountTypeId) {
		currentSession().beginTransaction();
		AccountType existingAccountType = (AccountType) currentSession().load(
				AccountType.class, accountTypeId);
		return existingAccountType;
	}

	public void deleteExistingAccountType(Long accountTypeId) {
		currentSession().beginTransaction();
		AccountType accountType = (AccountType) currentSession().load(
				AccountType.class, accountTypeId);

		if (null != accountType) {
			try {
				currentSession().delete(accountType);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	@Override
	public void activateOrDeactivateExistingAccountType(Long accountTypeId,
			Integer onOffSwitch) {

		currentSession().beginTransaction();
		AccountType existingAccountType = (AccountType) currentSession().load(
				AccountType.class, accountTypeId);
		existingAccountType.setEnabledFlag(onOffSwitch);
		try {
			currentSession().update(existingAccountType);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}

	}

	/**
	 * Language Management functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Language> listLanguages() {
		return (List<Language>) currentSession().createCriteria(Language.class)
				.list();
	}

	public void deleteExistingLanguage(Long languageId) {
		currentSession().beginTransaction();
		Language language = (Language) currentSession().load(Language.class,
				languageId);

		if (null != language) {
			try {
				currentSession().delete(language);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	public void editExistingLanguage(Language language) {
		currentSession().beginTransaction();
		Language existingLanguage = (Language) currentSession().load(
				Language.class, language.getLanguageId());
		if (null != existingLanguage) {
			existingLanguage.setLanguageName((language.getLanguageName()));
		}

		try {
			currentSession().update(existingLanguage);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public Language getExistingLanguage(Long languageId) {
		currentSession().beginTransaction();
		Language existingLanguage = (Language) currentSession().load(
				Language.class, languageId);
		return existingLanguage;
	}

	@Override
	public void setDefaultLanguage(Long languageId, Integer defaultSwitch) {
		if ((defaultSwitch == 1) && (null == checkForExistingDefaultLanguage())
				|| (defaultSwitch == 0)) {
			currentSession().beginTransaction();
			Language existingLanguage = (Language) currentSession().load(
					Language.class, languageId);
			existingLanguage.setIsDefault(defaultSwitch);
			try {
				currentSession().update(existingLanguage);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	public Language checkForExistingDefaultLanguage() {
		currentSession().beginTransaction();

		return (Language) currentSession()
				.createQuery(
						"from Language language "
								+ "where language.isDefault = :isDefault")
				.setParameter("isDefault", 1).setMaxResults(1).uniqueResult();
	}

	public void addLanguage(Language language) {
		try {
			currentSession().beginTransaction();
			currentSession().save(language);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	/**
	 * System Config functions
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<SystemConfiguration> listSystemConfiguration() {
		return (List<SystemConfiguration>) currentSession().createCriteria(
				SystemConfiguration.class).list();
	}

	public void addSystemConfiguration(SystemConfiguration systemConfiguration) {
		currentSession().saveOrUpdate(systemConfiguration);
	}

	public void removeSystemConfiguration(Long systemConfigurationId) {
		SystemConfiguration systemConfiguration = (SystemConfiguration) currentSession()
				.load(SystemConfiguration.class, systemConfigurationId);
		if (null != systemConfiguration) {
			currentSession().delete(systemConfiguration);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NdcListPToP> listNDCPToP() {
		return (List<NdcListPToP>) currentSession().createCriteria(
				NdcListPToP.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NdcListOffnet> listNDCOffnet() {
		return (List<NdcListOffnet>) currentSession().createCriteria(
				NdcListOffnet.class).list();
	}

	@Override
	public void addNdcListPToP(NdcListPToP ndcListPToP) {
		try {
			currentSession().beginTransaction();
			currentSession().save(ndcListPToP);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void editExistingNdcListPToP(NdcListPToP ndcListPToP) {
		currentSession().beginTransaction();
		NdcListPToP existingNdcListPToP = (NdcListPToP) currentSession().load(
				NdcListPToP.class, ndcListPToP.getNdcListId());
		if (null != existingNdcListPToP) {
			existingNdcListPToP.setNdc(ndcListPToP.getNdc());
		}

		try {
			currentSession().update(existingNdcListPToP);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public NdcListPToP getExistingNdcListPToP(Long ndcListId) {
		currentSession().beginTransaction();
		NdcListPToP ndcListPToP = (NdcListPToP) currentSession().load(
				NdcListPToP.class, ndcListId);
		return ndcListPToP;
	}

	@Override
	public void deleteExistingNdcListPToP(Long ndcListId) {
		currentSession().beginTransaction();
		NdcListPToP ndcListPToP = (NdcListPToP) currentSession().load(
				NdcListPToP.class, ndcListId);

		if (null != ndcListPToP) {
			try {
				currentSession().delete(ndcListPToP);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}

	}

	@Override
	public void activateOrDeactivateExistingNdcListPToP(Long ndcListId,
			Integer onOffSwitch) {
		currentSession().beginTransaction();
		NdcListPToP existingNdcListPToP = (NdcListPToP) currentSession().load(
				NdcListPToP.class, ndcListId);
		existingNdcListPToP.setEnabledFlag(onOffSwitch);
		try {
			currentSession().update(existingNdcListPToP);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void addNdcListOffnet(NdcListOffnet ndcListOffnet) {
		try {
			currentSession().beginTransaction();
			currentSession().save(ndcListOffnet);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public NdcListOffnet getExistingNdcListOffnet(Long ndcListId) {
		currentSession().beginTransaction();
		NdcListOffnet ndcListOffnet = (NdcListOffnet) currentSession().load(
				NdcListOffnet.class, ndcListId);
		return ndcListOffnet;
	}

	@Override
	public void editExistingNdcListOffnet(NdcListOffnet ndcListOffnet) {
		currentSession().beginTransaction();
		NdcListOffnet existingNdcListOffnet = (NdcListOffnet) currentSession()
				.load(NdcListOffnet.class, ndcListOffnet.getNdcListId());
		if (null != existingNdcListOffnet) {
			existingNdcListOffnet.setNdc(ndcListOffnet.getNdc());
			existingNdcListOffnet.setNetworkOperator(ndcListOffnet
					.getNetworkOperator());
			try {
				currentSession().update(existingNdcListOffnet);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteExistingNdcListOffnet(Long ndcListId) {
		NdcListOffnet ndcListOffnet = (NdcListOffnet) currentSession().load(
				NdcListOffnet.class, ndcListId);
		if (null != ndcListOffnet) {
			currentSession().delete(ndcListOffnet);
		}
	}

	@Override
	public void activateOrDeactivateExistingNdcListOffnet(Long ndcListId,
			Integer onOffSwitch) {
		currentSession().beginTransaction();
		NdcListOffnet existingNdcListOffnet = (NdcListOffnet) currentSession()
				.load(NdcListOffnet.class, ndcListId);
		existingNdcListOffnet.setEnabledFlag(onOffSwitch);
		try {
			currentSession().update(existingNdcListOffnet);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

}
