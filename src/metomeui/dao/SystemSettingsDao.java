package metomeui.dao;

import java.util.List;

import metomeui.model.AccountType;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.NdcListOffnet;
import metomeui.model.NdcListPToP;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;
import metomeui.model.Language;

public interface SystemSettingsDao {

	/**
	 * User Management functions
	 */
	public List<User> listUsers();

	public void addUser(User user);

	public void removeUser(Long id);

	public User getUserByLogin(String userName, String password);

	public User getExistingUser(Long userId);

	public void editExistingUser(User user);

	/**
	 * AccountTypes Management functions
	 */
	public List<AccountType> listAccountTypes();

	public void addAccountType(AccountType accountType);

	public void deleteExistingAccountType(Long accountTypeId);

	public AccountType getExistingAccountType(Long accountTypeId);

	public void editExistingAccountType(AccountType accountType);

	public void activateOrDeactivateExistingAccountType(Long accountTypeId,
			Integer offSwitch);

	/**
	 * Message Management functions
	 */
	public List<Message> listMessages();

	public void removeMessage(Long messageId);

	public void addMessage(Message message);

	public Message getExistingMessage(Long messageId);

	public void editExistingMessage(Message message);

	/**
	 * Language Management functions
	 * 
	 */
	public List<Language> listLanguages();

	public void deleteExistingLanguage(Long languageId);

	public void addLanguage(Language language);

	public Language getExistingLanguage(Long languageId);

	public void editExistingLanguage(Language language);

	public void setDefaultLanguage(Long languageId, Integer onOffSwitch);

	/**
	 * MemoGroup Management functions
	 */
	public List<MemoGroup> listMemoGroups();

	public void addMemoGroup(MemoGroup memoGroup);

	public void deleteExistingMemoGroup(Long memoGroupId);

	public void editExistingMemoGroup(MemoGroup memoGroup);

	public MemoGroup getExistingMemoGroup(Long memoGroupId);

	public void activateOrDeactivateExistingMemoGroup(Long memoGroupId,
			Integer onOffSwitch);

	/**
	 * System Config functions
	 */
	public List<SystemConfiguration> listSystemConfiguration();

	public void removeSystemConfiguration(Long SystemConfigurationId);

	public void addSystemConfiguration(SystemConfiguration sysConfiguration);

	/**
	 * NDC List functions
	 */
	public List<NdcListPToP> listNDCPToP();

	public List<NdcListOffnet> listNDCOffnet();

	public void editExistingNdcListPToP(NdcListPToP ndcListPToP);

	public void addNdcListPToP(NdcListPToP ndcListPToP);

	public NdcListPToP getExistingNdcListPToP(Long ndcListId);

	public void deleteExistingNdcListPToP(Long ndcListId);

	public void activateOrDeactivateExistingNdcListPToP(Long ndcListId,
			Integer onSwitch);

	public void addNdcListOffnet(NdcListOffnet ndcListOffnet);

	public NdcListOffnet getExistingNdcListOffnet(Long ndcListId);

	public void editExistingNdcListOffnet(NdcListOffnet ndcListOffnet);

	public void deleteExistingNdcListOffnet(Long ndcListId);

	public void activateOrDeactivateExistingNdcListOffnet(Long ndcListId,
			Integer onSwitch);
}