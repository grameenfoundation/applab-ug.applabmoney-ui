package metomeui.dao;

import java.util.List;

import metomeui.model.AccountType;
import metomeui.model.ContactForm;
import metomeui.model.Login;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;
import metomeui.model.Language;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;

public interface SystemSettingsDao {

	/**
	 * User Management functions
	 */
	public List<User> listUsers();

	public void addUser(User user);

	public void removeUser(long id);

	public User getUserByName(String userName, String password);

	public void editExistingUser(User user);

	public User getExistingUser(long userId);

	/**
	 * Global Management functions
	 */
	public List<Object> listObject();

	public void addObject(Object object);

	public void removeObject(Integer objectId);

	/**
	 * AccountTypes Management functions
	 */
	public List<AccountType> listAccountTypes();

	public void addAccountType(AccountType accountType);

	public void removeAccountType(long accountTypeId);

	/**
	 * Message Management functions
	 */
	public List<Message> listMessages();

	public void removeMessage(Integer messageId);

	public void addMessage(Message message);

	/**
	 * Language Management functions
	 * 
	 */
	public List<Language> listLanguages();

	public void removeLanguage(Integer languageId);

	public void addLanguage(Language language);

	/**
	 * MemoGroup Management functions
	 */
	public List<MemoGroup> listMemoGroups();

	public void addMemoGroup(MemoGroup memoGroup);

	public void removeMemoGroup(Integer memoGroupId);

	/**
	 * System Config functions
	 */
	public List<SystemConfiguration> listSystemConfiguration();

	public void removeSystemConfiguration(Integer SystemConfigurationId);

	public void addSystemConfiguration(SystemConfiguration sysConfiguration);

	public Language getExistingLanguage(long languageId);

	public void editExistingLanguage(Language language);

	public Message getExistingMessage(long messageId);

	public void editExistingMemoGroup(MemoGroup memoGroup);

	public MemoGroup getExistingMemoGroup(long memoGroupId);

	public void editExistingMessage(Message message);

	public AccountType getExistingAccountType(long accountTypeId);

	public void editExistingAccountType(AccountType accountType);
}
