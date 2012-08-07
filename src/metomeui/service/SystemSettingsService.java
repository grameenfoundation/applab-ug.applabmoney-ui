package metomeui.service;

import java.util.List;

import metomeui.model.AccountType;
import metomeui.model.AmlBarring;
import metomeui.model.GlobalKeywordCharge;
import metomeui.model.Language;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.NdcListOffnet;
import metomeui.model.NdcListPToP;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;

public interface SystemSettingsService {

	/**
	 * AccountTypes Management functions
	 * 
	 */
	public List<AccountType> listAccountTypes();

	public void addAccountType(AccountType accountType);

	public void deleteExistingAccountType(Long accountTypeId);

	public AccountType getExistingAccountType(Long accountTypeId);

	public void editExistingAccountType(AccountType accountType);

	public void activateOrDeactivateExistingAccountType(Long accountTypeId,
			Integer offSwitch);

	/**
	 * User Management functions
	 * 
	 */
	public List<User> listUsers();

	public void addUser(User user);

	public void deleteExistingUser(Long userId);

	public User getUserByLogin(String username, String password);
	
	public User getExistingUser(Long userId);
	
	public void editExistingUser(User user);

	/**
	 * Message Management functions
	 * 
	 */
	public List<Message> listMessages();

	public void addMessage(Message message);

	public void editExistingMessage(Message message);

	public void deleteExistingMessage(Long messageId);

	public Message getExistingMessage(Long messageId);

	/**
	 * Language Management functions
	 * 
	 */
	public List<Language> listLanguages();

	public void addLanguage(Language language);

	public void deleteExistingLanguage(Long languageId);

	public Language getExistingLanguage(Long languageId);

	public void editExistingLanguage(Language language);

	public void setDefaultLanguage(Long languageId, Integer offSwitch);
	
	public boolean checkIfDuplicateLanguageName(String languageName,
			Long languageId);

	/**
	 * MemoGroup Management functions
	 * 
	 */
	public List<MemoGroup> listMemoGroups();

	public void addMemoGroup(MemoGroup memoGroup);

	public void deleteExistingMemoGroup(Long memoGroupId);

	public MemoGroup getExistingMemoGroup(Long memoGroupId);

	public void editExistingMemoGroup(MemoGroup memoGroup);

	public void activateOrDeactivateExistingMemoGroup(Long memoGroupId,
			Integer onOffSwitch);

	/**
	 * System Config functions
	 * 
	 */
	public SystemConfiguration getSystemConfiguration();

	public void addSystemConfiguration(SystemConfiguration sysConfiguration);
	
	public SystemConfiguration getExistingSystemConfiguration();

	public void editExistingSystemConfiguration(
			SystemConfiguration systemConfiguration);

	public void deleteExistingSystemConfiguration(Long SystemConfigurationId);

	/**
	 * NDC  functions
	 * 
	 */
	public List<NdcListPToP> listNDCPToP();

	public List<NdcListOffnet> listNDCOffnet();

	public void editExistingNdcListPToP(NdcListPToP ndcListPToP);

	public void addNdcListPToP(NdcListPToP ndcListPToP);

	public NdcListPToP getExistingNdcListPToP(Long ndcListPToPId);

	public void deleteExistingNdcListPToP(Long ndcListId);

	public void activateOrDeactivateExistingNdcListPToP(Long ndcListId,
			Integer onSwitch);

	public void addNdcListOffnet(NdcListOffnet ndcListOffnet);

	public NdcListOffnet getExistingNdcListOffnet(Long ndcListId);

	public void editExistingNdcListOffnet(NdcListOffnet ndcListOffnet);

	public void deleteExistingNdcListOffnet(Long ndcListId);

	public void activateOrDeactivateExistingNdcListOffnet(Long ndcListId,
			Integer onSwitch);
	
	/**
	 * AML Settings functions
	 * 
	 */
	public List<AmlBarring> listAmlBarringSettings();

	public void addAmlBarringSetting(AmlBarring amlBarring);

	public void editExistingAmlBarring(AmlBarring amlBarring);

	public void deleteExistingAmlBarring(Long barringId);

	public AmlBarring getExistingAmlBarring(Long barringId);

	
	/**
	 * GlobalKeywordCharge Settings functions
	 * 
	 */
	public void addGlobalKeywordCharge(
			GlobalKeywordCharge globalKeywordCharge);

	public List<GlobalKeywordCharge> listGlobalKeywordCharges();
	
	public void editExistingGlobalKeywordCharge(GlobalKeywordCharge globalKeywordCharge);

	public void deleteExistingGlobalKeywordCharge(Long chargeId);

	public GlobalKeywordCharge getExistingGlobalKeywordCharge(Long chargeId);
}
