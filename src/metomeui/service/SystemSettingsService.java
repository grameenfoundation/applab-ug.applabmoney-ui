package metomeui.service;

import java.util.List;

import metomeui.model.AccountType;
import metomeui.model.ContactForm;
import metomeui.model.Language;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;
import metomeui.model.UssdPredefInputItem;

public interface SystemSettingsService {

	/**
	 * AccountTypes Management functions
	 *
	 */
	public List<AccountType> listAccountTypes();

	public void addAccountType(AccountType accountType);
	
	public void removeAccountType(Integer accountTypeId);
	
	
	/**
	 * User Management functions
	 *
	 */
	public List<User> listUsers();
	
	public void addUser(User user);
	
	public void removeUser(Integer userId);
	
	public User getUserByName(String username, String password);
	
	
	/**
	 * Message Management functions
	 *
	 */
	public List<Message> listMessages();

	public void addMessage(Message message);
	
	public void removeMessage(Integer messageId);
	
	/**
	 * Language Management functions
	 *
	 */
	public List<Language> listLanguages();
	
	public void addLanguage(Language language);

	public void removeLanguage(Integer languageId);
	
	/**
	 * MemoGroup Management functions
	 *
	 */
	public List<MemoGroup> listMemoGroups();

	public void addMemoGroup(MemoGroup memoGroup);
	
	public void removeMemoGroup(Integer memoGroupId);
	
	/**
	 * System Config functions
	 *
	 */
	public List<SystemConfiguration> listSystemConfiguration();

	public void addSystemConfiguration(SystemConfiguration sysConfiguration);
	
	public void removeSystemConfiguration(Integer SystemConfigurationId);
	
	public void addContact(UssdPredefInputItem contact);
	
	public void addContact(ContactForm contactForm);

	public void updateContact(ContactForm contactForm);

	public void updateContact(UssdPredefInputItem contact);

	public User getExistingUser(long userId);

	public void editExistingUser(User user);

	public void editExistingMessage(Message message);
	
	public Message getExistingMessage(long messageId);

	public Language getExistingLanguage(long languageId);

	public void editExistingLanguage(Language language);

	public AccountType getExistingAccountType(long messageId);

	public void editExistingAccountType(AccountType accountType);

	public MemoGroup getExistingMemoGroup(long memoGroupId);

	public void editExistingMemoGroup(MemoGroup memoGroup);

	

	
}
