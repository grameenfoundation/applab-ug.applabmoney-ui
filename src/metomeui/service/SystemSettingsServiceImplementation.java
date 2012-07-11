package metomeui.service;

import java.util.List;

import metomeui.dao.SystemSettingsDao;
import metomeui.dao.SystemSettingsDaoImplementation;
import metomeui.model.AccountType;
import metomeui.model.ContactForm;
import metomeui.model.Language;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;
import metomeui.model.UssdPredefInputItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("chargeSetupService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SystemSettingsServiceImplementation implements SystemSettingsService {

	@Autowired
	private SystemSettingsDao systemSettingsDao = new SystemSettingsDaoImplementation();
	
	public SystemSettingsServiceImplementation() {
		
	}

	/**
	 * AccountTypes Management functions
	 *
	 */
	@Transactional
	public List<AccountType> listAccountTypes() {
		return systemSettingsDao.listAccountTypes();
	}

	@Transactional
	public void removeAccountType(long accountTypeId) {
		systemSettingsDao.removeAccountType(accountTypeId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAccountType(AccountType accountType) {
		systemSettingsDao.addAccountType(accountType);
	}
	
	@Transactional
	public AccountType getExistingAccountType(long accountTypeId) {
		return systemSettingsDao.getExistingAccountType(accountTypeId);
	}
	
	@Transactional
	public void editExistingAccountType(AccountType accountType) {
		systemSettingsDao.editExistingAccountType(accountType);
	}
	
	/**
	 * User Management functions
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(User user) {
		systemSettingsDao.addUser(user);
	}

	@Transactional
	public List<User> listUsers() {
		return systemSettingsDao.listUsers();
	}

	@Transactional
	public void removeUser(long id) {
		systemSettingsDao.removeUser(id);
	}
	
	@Transactional
	public User getUserByName(String userName, String password) {
		return systemSettingsDao.getUserByName(userName, password);
	}
	
	@Transactional
	public User getExistingUser(long userId) {
		return systemSettingsDao.getExistingUser(userId);
	}
	
	@Transactional
	public void editExistingUser(User user) {
		systemSettingsDao.editExistingUser(user);
	}
	
	/**
	 * Language Management functions
	 *
	 */
	@Transactional
	public List<Language> listLanguages() {
		return systemSettingsDao.listLanguages();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addLanguage(Language language) {
		systemSettingsDao.addLanguage(language);
	}

	@Transactional
	public void removeLanguage(Integer languageId) {
		systemSettingsDao.removeLanguage(languageId);
	}
	
	@Transactional
	public Language getExistingLanguage(long languageId) {
		return systemSettingsDao.getExistingLanguage(languageId);
	}
	
	@Transactional
	public void editExistingLanguage(Language language) {
		systemSettingsDao.editExistingLanguage(language);
	}
	
	
	/**
	 * Message Management functions
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addMessage(Message message) {
		systemSettingsDao.addMessage(message);
	}

	@Transactional
	public List<Message> listMessages() {
		return systemSettingsDao.listMessages();
	}

	@Transactional
	public void removeMessage(Integer messageId) {
		systemSettingsDao.removeMessage(messageId);
	}
	
	@Transactional
	public Message getExistingMessage(long messageId) {
		return systemSettingsDao.getExistingMessage(messageId);
	}
	
	@Transactional
	public void editExistingMessage(Message message) {
		systemSettingsDao.editExistingMessage(message);
	}
	
	
	/**
	 * MemoGroup Management functions
	 *
	 */
	@Transactional
	public List<MemoGroup> listMemoGroups() {
		return systemSettingsDao.listMemoGroups();
	}

	@Transactional
	public void removeMemoGroup(Integer memoGroupId) {
		systemSettingsDao.removeMemoGroup(memoGroupId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addMemoGroup(MemoGroup memoGroup) {
		systemSettingsDao.addMemoGroup(memoGroup);
	}
	
	@Transactional
	public MemoGroup getExistingMemoGroup(long memoGroupId) {
		return systemSettingsDao.getExistingMemoGroup(memoGroupId);
	}
	
	@Transactional
	public void editExistingMemoGroup(MemoGroup memoGroup) {
		systemSettingsDao.editExistingMemoGroup(memoGroup);
	}
	
	/**
	 * System Configuration functions
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSystemConfiguration(SystemConfiguration systemConfiguration) {
		systemSettingsDao.addSystemConfiguration(systemConfiguration);
	}

	@Transactional
	public List<SystemConfiguration> listSystemConfiguration() {
		return systemSettingsDao.listSystemConfiguration();
	}

	@Transactional
	public void removeSystemConfiguration(Integer systemConfigurationId) {
		systemSettingsDao.removeSystemConfiguration(systemConfigurationId);
	}	
	
	/**
	 * Object Management functions
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addItem(Object object) {
		systemSettingsDao.addObject(object);
	}

	@Transactional
	public List<Object> listObject() {
		return systemSettingsDao.listObject();
	}

	@Transactional
	public void removeObject(Integer id) {
		systemSettingsDao.removeObject(id);
	}

	@Override
	public void removeAccountType(Integer accountTypeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addContact(UssdPredefInputItem contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addContact(ContactForm contactForm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContact(ContactForm contactForm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContact(UssdPredefInputItem contact) {
		// TODO Auto-generated method stub
		
	}
}
