package applabmoneyaui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import applabmoneyaui.dao.SystemSettingsDao;
import applabmoneyaui.dao.SystemSettingsDaoImplementation;

import applabmoneyaui.model.AccountType;
import applabmoneyaui.model.AmlBarring;
import applabmoneyaui.model.GlobalKeywordCharge;
import applabmoneyaui.model.GlobalReceiveLimit;
import applabmoneyaui.model.GlobalSendLimit;
import applabmoneyaui.model.Language;
import applabmoneyaui.model.MemoGroup;
import applabmoneyaui.model.Message;
import applabmoneyaui.model.NdcListOffnet;
import applabmoneyaui.model.NdcListPToP;
import applabmoneyaui.model.SystemConfiguration;
import applabmoneyaui.model.User;
import applabmoneyaui.model.UssdTransactionKeyword;

@Service("systemSettingsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SystemSettingsServiceImplementation implements
		SystemSettingsService {

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
	public void deleteExistingAccountType(Long accountTypeId) {
		systemSettingsDao.deleteExistingAccountType(accountTypeId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAccountType(AccountType accountType) {
		systemSettingsDao.addAccountType(accountType);
	}

	@Transactional
	public AccountType getExistingAccountType(Long accountTypeId) {
		return systemSettingsDao.getExistingAccountType(accountTypeId);
	}

	@Transactional
	public void editExistingAccountType(AccountType accountType) {
		systemSettingsDao.editExistingAccountType(accountType);
	}

	@Transactional
	public void activateOrDeactivateExistingAccountType(Long accountTypeId,
			Integer offSwitch) {
		systemSettingsDao.activateOrDeactivateExistingAccountType(
				accountTypeId, offSwitch);
	}
	
	@Transactional
	public boolean checkIfDuplicateBitMap(Integer accountTypeBitMap) {
		return systemSettingsDao.checkIfDuplicateBitMap(accountTypeBitMap);
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
	public void deleteExistingUser(Long userId) {
		systemSettingsDao.removeExistingUser(userId);
	}

	@Transactional
	public User getUserByLogin(String userName, String password) {
		return systemSettingsDao.getUserByLogin(userName, password);
	}

	@Transactional
	public void editExistingUser(User user) {
		systemSettingsDao.editExistingUser(user);
	}

	@Transactional
	public User getExistingUser(Long userId) {
		return systemSettingsDao.getExistingUser(userId);
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
	public void deleteExistingLanguage(Long languageId) {
		systemSettingsDao.deleteExistingLanguage(languageId);
	}

	@Transactional
	public Language getExistingLanguage(Long languageId) {
		return systemSettingsDao.getExistingLanguage(languageId);
	}

	@Transactional
	public void editExistingLanguage(Language language) {
		systemSettingsDao.editExistingLanguage(language);
	}

	@Transactional
	public void setDefaultLanguage(Long languageId, Integer offSwitch) {
		systemSettingsDao.setDefaultLanguage(languageId, offSwitch);
	}

	@Transactional
	public boolean checkIfLanguageMessageCodeComboExists(Language language,
			Integer messageCode) {
		return systemSettingsDao.checkIfLanguageMessageCodeComboExists(
				language, messageCode);
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
	public void deleteExistingMessage(Long messageId) {
		systemSettingsDao.removeMessage(messageId);
	}

	@Transactional
	public Message getExistingMessage(Long messageId) {
		return systemSettingsDao.getExistingMessage(messageId);
	}

	@Transactional
	public void editExistingMessage(Message message) {
		systemSettingsDao.editExistingMessage(message);
	}

	@Transactional
	public boolean checkIfDuplicateLanguageName(String languageName,
			Long languageId) {
		return systemSettingsDao.checkIfDuplicateLanguageName(languageId,
				languageName);
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
	public void deleteExistingMemoGroup(Long memoGroupId) {
		systemSettingsDao.deleteExistingMemoGroup(memoGroupId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addMemoGroup(MemoGroup memoGroup) {
		systemSettingsDao.addMemoGroup(memoGroup);
	}

	@Transactional
	public MemoGroup getExistingMemoGroup(Long memoGroupId) {
		return systemSettingsDao.getExistingMemoGroup(memoGroupId);
	}

	@Transactional
	public void editExistingMemoGroup(MemoGroup memoGroup) {
		systemSettingsDao.editExistingMemoGroup(memoGroup);
	}

	@Transactional
	public void activateOrDeactivateExistingMemoGroup(Long memoGroupId,
			Integer onOffSwitch) {
		systemSettingsDao.activateOrDeactivateExistingMemoGroup(memoGroupId,
				onOffSwitch);

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
	public SystemConfiguration getSystemConfiguration() {
		return systemSettingsDao.getSystemConfiguration();
	}

	@Transactional
	public void deleteExistingSystemConfiguration(Long systemConfigurationId) {
		systemSettingsDao.removeSystemConfiguration(systemConfigurationId);
	}

	@Transactional
	public SystemConfiguration getExistingSystemConfiguration() {
		return systemSettingsDao.getSystemConfiguration();
	}

	@Transactional
	public void editExistingSystemConfiguration(
			SystemConfiguration systemConfiguration) {
		systemSettingsDao.editSystemConfiguration(systemConfiguration);

	}

	/**
	 * NDC List functions
	 * 
	 */
	@Transactional
	public List<NdcListPToP> listNDCPToP() {
		return systemSettingsDao.listNDCPToP();
	}

	@Transactional
	public List<NdcListOffnet> listNDCOffnet() {
		return systemSettingsDao.listNDCOffnet();
	}

	@Transactional
	public void addNdcListPToP(NdcListPToP ndcListPToP) {
		systemSettingsDao.addNdcListPToP(ndcListPToP);
	}

	@Transactional
	public NdcListPToP getExistingNdcListPToP(Long ndcListId) {
		return systemSettingsDao.getExistingNdcListPToP(ndcListId);
	}

	@Transactional
	public void editExistingNdcListPToP(NdcListPToP ndcListPToP) {
		systemSettingsDao.editExistingNdcListPToP(ndcListPToP);
	}

	@Transactional
	public void deleteExistingNdcListPToP(Long ndcListId) {
		systemSettingsDao.deleteExistingNdcListPToP(ndcListId);
	}

	@Transactional
	public void activateOrDeactivateExistingNdcListPToP(Long ndcListId,
			Integer onSwitch) {
		systemSettingsDao.activateOrDeactivateExistingNdcListPToP(ndcListId,
				onSwitch);

	}

	@Transactional
	public void addNdcListOffnet(NdcListOffnet ndcListOffnet) {
		systemSettingsDao.addNdcListOffnet(ndcListOffnet);

	}

	@Transactional
	public NdcListOffnet getExistingNdcListOffnet(Long ndcListId) {
		return systemSettingsDao.getExistingNdcListOffnet(ndcListId);
	}

	@Transactional
	public void editExistingNdcListOffnet(NdcListOffnet ndcListOffnet) {
		systemSettingsDao.editExistingNdcListOffnet(ndcListOffnet);
	}

	@Transactional
	public void deleteExistingNdcListOffnet(Long ndcListId) {
		systemSettingsDao.deleteExistingNdcListOffnet(ndcListId);
	}

	@Transactional
	public void activateOrDeactivateExistingNdcListOffnet(Long ndcListId,
			Integer onSwitch) {
		systemSettingsDao.activateOrDeactivateExistingNdcListOffnet(ndcListId,
				onSwitch);
	}

	@Transactional
	public boolean checkIfDuplicateNdc(Integer ndc) {
		return systemSettingsDao.checkIfDuplicateNdc(ndc);
	}

	/**
	 * AML Barring functions
	 * 
	 */
	@Transactional
	public List<AmlBarring> listAmlBarringSettings() {
		return systemSettingsDao.listAmlBarringSettings();
	}

	@Transactional
	public void addAmlBarringSetting(AmlBarring amlBarring) {
		systemSettingsDao.addAmlBarringSetting(amlBarring);
	}

	@Transactional
	public void editExistingAmlBarring(AmlBarring amlBarring) {
		systemSettingsDao.editExistingAmlBarring(amlBarring);
	}

	@Transactional
	public void deleteExistingAmlBarring(Long barringId) {
		systemSettingsDao.deleteExistingAmlBarring(barringId);
	}

	@Transactional
	public AmlBarring getExistingAmlBarring(Long barringId) {
		return systemSettingsDao.getExistingAmlBarring(barringId);
	}

	@Transactional
	public boolean checkIfAccTypeKeywordCodeComboExist(AccountType accountType,
			UssdTransactionKeyword transactionKeyword) {
		return systemSettingsDao.checkIfAccTypeKeywordCodeComboExist(
				accountType, transactionKeyword);
	}

	/**
	 * GlobalKeywordCharge functions
	 * 
	 */
	@Transactional
	public List<GlobalKeywordCharge> listGlobalKeywordCharges() {
		return systemSettingsDao.listGlobalKeywordCharges();
	}

	@Transactional
	public void addGlobalKeywordCharge(GlobalKeywordCharge globalKeywordCharge) {
		systemSettingsDao.addGlobalKeywordCharge(globalKeywordCharge);
	}

	@Transactional
	public void editExistingGlobalKeywordCharge(
			GlobalKeywordCharge globalKeywordCharge) {
		systemSettingsDao.editExistingGlobalKeywordCharge(globalKeywordCharge);
	}

	@Transactional
	public void deleteExistingGlobalKeywordCharge(Long chargeId) {
		systemSettingsDao.deleteExistingGlobalKeywordCharge(chargeId);
	}

	@Transactional
	public GlobalKeywordCharge getExistingGlobalKeywordCharge(Long chargeId) {
		return systemSettingsDao.getExistingGlobalKeywordCharge(chargeId);
	}

	/**
	 * GlobalSendLimit functions
	 * 
	 */
	@Transactional
	public List<GlobalSendLimit> listGlobalSendLimits() {
		return systemSettingsDao.listGlobalSendLimits();
	}

	@Transactional
	public void deleteExistingGlobalSendLimit(Long sendLimitId) {
		systemSettingsDao.deleteExistingGlobalSendLimit(sendLimitId);
	}

	@Transactional
	public void editExistingGlobalSendLimit(GlobalSendLimit globalSendLimit) {
		systemSettingsDao.editExistingGlobalSendLimit(globalSendLimit);		
	}

	@Transactional
	public GlobalSendLimit getExistingGlobalSendLimit(Long sendLimitId) {
		return systemSettingsDao.getExistingGlobalSendLimit(sendLimitId);
	}

	@Transactional
	public void addGlobalSendLimit(GlobalSendLimit globalSendLimit) {
		systemSettingsDao.addGlobalSendLimit(globalSendLimit);
	}
	
	/**
	 * GlobalReceiveLimit functions
	 * 
	 */
	@Transactional
	public List<GlobalReceiveLimit> listGlobalReceiveLimits() {
		return systemSettingsDao.listGlobalReceiveLimits();
	}

	@Transactional
	public void deleteExistingGlobalReceiveLimit(Long receiveLimitId) {
		systemSettingsDao.deleteExistingGlobalReceiveLimit(receiveLimitId);
	}

	@Transactional
	public void editExistingGlobalReceiveLimit(
			GlobalReceiveLimit globalReceiveLimit) {
		systemSettingsDao.editExistingGlobalReceiveLimit(globalReceiveLimit);
	}

	@Transactional
	public GlobalReceiveLimit getExistingGlobalReceiveLimit(Long receiveLimitId) {
		return systemSettingsDao.getExistingGlobalReceiveLimit(receiveLimitId);
	}

	@Transactional
	public void addGlobalReceiveLimit(GlobalReceiveLimit globalReceiveLimit) {
		systemSettingsDao.addGlobalReceiveLimit(globalReceiveLimit);
	}
}
