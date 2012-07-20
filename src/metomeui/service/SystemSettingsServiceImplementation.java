package metomeui.service;

import java.util.List;

import metomeui.dao.SystemSettingsDao;
import metomeui.dao.SystemSettingsDaoImplementation;
import metomeui.model.AccountType;
import metomeui.model.Language;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.NdcListOffnet;
import metomeui.model.NdcListPToP;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("chargeSetupService")
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
	public void deleteExistingUser(Long id) {
		systemSettingsDao.removeUser(id);
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

	@Override
	public void setDefaultLanguage(Long languageId, Integer offSwitch) {
		systemSettingsDao.setDefaultLanguage(languageId, offSwitch);

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
	public List<SystemConfiguration> listSystemConfiguration() {
		return systemSettingsDao.listSystemConfiguration();
	}

	@Transactional
	public void deleteExistingSystemConfiguration(Long systemConfigurationId) {
		systemSettingsDao.removeSystemConfiguration(systemConfigurationId);
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

}
