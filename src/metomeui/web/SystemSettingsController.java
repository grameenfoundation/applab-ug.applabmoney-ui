package metomeui.web;

import java.util.List;
import java.util.Map;

import metomeui.dao.UssdMenuDao;
import metomeui.dao.UssdMenuDaoImplementation;
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
import metomeui.model.UssdTransactionKeyword;
import metomeui.service.SystemSettingsService;
import metomeui.service.SystemSettingsServiceImplementation;
import metomeui.service.UssdMenuService;
import metomeui.service.UssdMenuServiceImplementation;
import metomeui.validator.SystemSettingsValidator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemSettingsController {

	private static Logger logger = Logger
			.getLogger(SystemSettingsController.class);

	@Autowired
	private SystemSettingsValidator systemSettingsValidator;
	@Autowired
	SystemSettingsService systemSettingsService = new SystemSettingsServiceImplementation();
	@Autowired
	UssdMenuService ussdMenuService = new UssdMenuServiceImplementation();
	UssdMenuDao ussdMenuDao = new UssdMenuDaoImplementation();

	@RequestMapping("/auilanding")
	public String showAuiLanding(Map<String, Object> map) {
		return "auilanding";
	}
	
	@RequestMapping("/listusers")
	public String listUser(Map<String, Object> map) {
		map.put("user", new User());
		map.put("userList", systemSettingsService.listUsers());
		return "listusers";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String addUserLink(Map<String, Object> map) {
		map.put("user", new User());
		return "adduser";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result) {
		systemSettingsService.addUser(user);
		return "redirect:/listusers.html";
	}

	@RequestMapping(value = "/edituser/{userId}", method = RequestMethod.GET)
	public String editUserLink(@PathVariable Long userId,
			Map<String, Object> map) {
		User existingUser = systemSettingsService.getExistingUser(userId);

		map.put("user", existingUser);
		return "edituser";
	}

	@RequestMapping(value = "/edituser/{userId}", method = RequestMethod.POST)
	public String postChangesToUser(@PathVariable Long userId,
			@ModelAttribute("user") User user, BindingResult result) {

		// Assign id
		user.setUserId(userId);
		systemSettingsService.editExistingUser(user);
		return "redirect:/listusers.html";
	}

	@RequestMapping("/removeuser/{userId}")
	public String deleteUser(@PathVariable("userId") Long userId) {
		systemSettingsService.deleteExistingUser(userId);
		logger.info("Returning hello view");
		return "redirect:/listusers.html";
	}

	@RequestMapping("/listmessages")
	public String listMessages(Map<String, Object> map) {
		map.put("message", new Message());
		map.put("messagesList", systemSettingsService.listMessages());
		return "listmessages";
	}

	/**
	 * Retrieves "Add New Message" page
	 */
	@RequestMapping(value = "/addmessage", method = RequestMethod.GET)
	public ModelAndView addMessageLink(
			@ModelAttribute("Message") Message message) {
		return new ModelAndView("addmessage", "message", new Message());
	}

	/**
	 * Add New Message
	 */
	@RequestMapping(value = "/addmessage", method = RequestMethod.POST)
	public String addMessage(@ModelAttribute("message") Message message,
			BindingResult result, Map<String, Object> map) {

		systemSettingsValidator.validate(message, result);
		if (result.hasErrors()) {
			return "addmessage";
		}

		if (message != null) {
			Language language = (Language) systemSettingsService
					.getExistingLanguage(message.getLanguage().getLanguageId());
			language.getMessages().add(message);
			message.setLanguage(language);

			systemSettingsService.addMessage(message);
		}

		map.put("message", new Message());
		map.put("messagesList", systemSettingsService.listMessages());
		return "redirect:/listmessages.html";
	}

	@RequestMapping(value = "/editmessage/{messageId}", method = RequestMethod.GET)
	public String editMessageLink(@PathVariable Long messageId,
			Map<String, Object> map) {
		Message existingMessage = systemSettingsService
				.getExistingMessage(messageId);

		map.put("message", existingMessage);
		return "editmessage";
	}

	@RequestMapping(value = "/editmessage/{messageId}", method = RequestMethod.POST)
	public String CommitChangesToMessage(@PathVariable Long messageId,
			@ModelAttribute("message") Message message, BindingResult result) {

		systemSettingsValidator.validate(message, result);
		if (result.hasErrors()) {
			return "editmessage";
		}

		Language language = (Language) systemSettingsService
				.getExistingLanguage(message.getLanguage().getLanguageId());
		language.getMessages().add(message);
		message.setLanguage(language);

		// Assign id
		message.setMessageId(messageId);

		systemSettingsService.editExistingMessage(message);
		return "redirect:/listmessages.html";
	}

	@RequestMapping("/removemessage/{messageId}")
	public String deleteMessage(@PathVariable("messageId") Long messageId) {
		systemSettingsService.deleteExistingMessage(messageId);
		return "redirect:/listmessages.html";
	}

	@RequestMapping("/listmemogroups")
	public String listMemoGroups(Map<String, Object> map) {
		map.put("memoGroup", new MemoGroup());
		map.put("memoGroupsList", systemSettingsService.listMemoGroups());
		return "listmemogroups";
	}

	@RequestMapping(value = "/addmemogroup", method = RequestMethod.GET)
	public String addMemoGroupLink(Map<String, Object> map) {
		map.put("memoGroup", new MemoGroup());
		return "addmemogroup";
	}

	@RequestMapping(value = "/addmemogroup", method = RequestMethod.POST)
	public String addMemoGroup(
			@ModelAttribute("memoGroup") MemoGroup memoGroup,
			BindingResult result) {

		systemSettingsValidator.validate(memoGroup, result);
		if (result.hasErrors()) {
			return "addmemogroup";
		}

		if ((memoGroup.getEnabledFlag() == null)
				|| (memoGroup.getEnabledFlag() != 1)) {
			memoGroup.setEnabledFlag(0);
		}

		systemSettingsService.addMemoGroup(memoGroup);
		populateMemoGroupList();
		return "redirect:/listmemogroups.html";
	}

	@RequestMapping(value = "/editmemogroup/{memoGroupId}", method = RequestMethod.GET)
	public String editMemoGroupLink(@PathVariable Long memoGroupId,
			Map<String, Object> map) {
		MemoGroup existingMemoGroup = systemSettingsService
				.getExistingMemoGroup(memoGroupId);

		map.put("memoGroup", existingMemoGroup);
		return "editmemogroup";
	}

	@RequestMapping(value = "/editmemogroup/{memoGroupId}", method = RequestMethod.POST)
	public String postChangesToMemoGroup(@PathVariable Long memoGroupId,
			@ModelAttribute("memoGroup") MemoGroup memoGroup,
			BindingResult result, Map<String, Object> map) {

		systemSettingsValidator.validate(memoGroup, result);
		if (result.hasErrors()) {
			return "addeditmemogroup";
		}

		// Assign id
		memoGroup.setMemoGroupId(memoGroupId);

		systemSettingsService.editExistingMemoGroup(memoGroup);
		return "redirect:/listmemogroups.html";
	}

	@RequestMapping("/removememogroup/{memoGroupId}")
	public String deleteMemoGroup(@PathVariable("memoGroupId") Long memoGroupId) {
		systemSettingsService.deleteExistingMemoGroup(memoGroupId);
		return "redirect:/listmemogroups.html";
	}

	@RequestMapping(value = "/activatememogroup/{memoGroupId}")
	public String activateMemoGroup(@PathVariable Long memoGroupId,
			@ModelAttribute("memoGroup") MemoGroup memoGroup,
			Map<String, Object> map) {
		Integer onSwitch = 1;

		// Assign id
		memoGroup.setMemoGroupId(memoGroupId);
		systemSettingsService.activateOrDeactivateExistingMemoGroup(
				memoGroupId, onSwitch);
		return "redirect:/listmemogroups.html";
	}

	@RequestMapping(value = "/deactivatememogroup/{memoGroupId}")
	public String deactivateMemoGroup(@PathVariable Long memoGroupId,
			@ModelAttribute("memoGroup") MemoGroup memoGroup,
			Map<String, Object> map) {

		Integer offSwitch = 0;

		// Assign id
		memoGroup.setMemoGroupId(memoGroupId);
		systemSettingsService.activateOrDeactivateExistingMemoGroup(
				memoGroupId, offSwitch);
		return "redirect:/listmemogroups.html";
	}

	@RequestMapping("/listlanguages")
	public String listLanguages(Map<String, Object> map) {
		map.put("language", new Language());
		map.put("languagesList", systemSettingsService.listLanguages());
		return "listlanguages";
	}

	@RequestMapping(value = "/addlanguage", method = RequestMethod.GET)
	public String addLanguageLink(Map<String, Object> map) {
		map.put("language", new Language());
		return "addlanguage";
	}

	@RequestMapping(value = "/addlanguage", method = RequestMethod.POST)
	public String addLanguage(@ModelAttribute("language") Language language,
			BindingResult result) {

		systemSettingsValidator.validate(language, result);
		if (result.hasErrors()) {
			return "addlanguage";
		}

		if ((language.getIsDefault() == null) || (language.getIsDefault() != 1)) {
			language.setIsDefault(0);
		}

		systemSettingsService.addLanguage(language);
		return "redirect:/listlanguages.html";
	}

	@RequestMapping(value = "/editlanguage/{languageId}", method = RequestMethod.GET)
	public String editLanguageLink(@PathVariable Long languageId,
			Map<String, Object> map) {
		Language existingLanguage = systemSettingsService
				.getExistingLanguage(languageId);

		map.put("language", existingLanguage);
		return "editlanguage";
	}

	@RequestMapping(value = "/editlanguage/{languageId}", method = RequestMethod.POST)
	public String postChangesToLanguage(@PathVariable Long languageId,
			@ModelAttribute("language") Language language, BindingResult result) {

		systemSettingsValidator.validate(language, result, languageId);
		if (result.hasErrors()) {
			return "editlanguage";
		}

		// Assign id
		language.setLanguageId(languageId);
		systemSettingsService.editExistingLanguage(language);
		return "redirect:/listlanguages.html";
	}

	@RequestMapping(value = "/defaultlanguage/{languageId}")
	public String defaultLanguage(@PathVariable Long languageId,
			@ModelAttribute("language") Language language,
			Map<String, Object> map) {
		Integer onSwitch = 1;

		// Assign id
		language.setLanguageId(languageId);
		systemSettingsService.setDefaultLanguage(languageId, onSwitch);
		return "redirect:/listlanguages.html";
	}

	@RequestMapping(value = "/undefaultlanguage/{languageId}")
	public String deactivateLanguage(@PathVariable Long languageId,
			@ModelAttribute("language") Language language,
			Map<String, Object> map) {

		Integer offSwitch = 0;

		// Assign id
		language.setLanguageId(languageId);
		systemSettingsService.setDefaultLanguage(languageId, offSwitch);
		return "redirect:/listlanguages.html";
	}

	@RequestMapping("/removelanguage/{languageId}")
	public String deleteLanguage(@PathVariable("languageId") Long languageId) {
		systemSettingsService.deleteExistingLanguage(languageId);
		return "redirect:/listlanguages.html";
	}

	@RequestMapping("/listaccounttypes")
	public String listNDCPToP(Map<String, Object> map) {
		map.put("accountType", new AccountType());
		map.put("accountTypesList", systemSettingsService.listAccountTypes());
		return "listaccounttypes";
	}

	@RequestMapping(value = "/addaccounttype", method = RequestMethod.GET)
	public String addAccountTypeLink(Map<String, Object> map) {
		map.put("accountType", new AccountType());
		return "addaccounttype";
	}

	@RequestMapping(value = "/addaccounttype", method = RequestMethod.POST)
	public String addAccountType(
			@ModelAttribute("accountType") AccountType accountType,
			BindingResult result) {

		systemSettingsValidator.validate(accountType, result);
		if (result.hasErrors()) {
			return "addaccounttype";
		}

		if ((accountType.getEnabledFlag() == null)
				|| (accountType.getEnabledFlag() != 1)) {
			accountType.setEnabledFlag(0);
		}

		systemSettingsService.addAccountType(accountType);
		return "redirect:/listaccounttypes.html";
	}

	@RequestMapping(value = "/editaccounttype/{accountTypeId}", method = RequestMethod.GET)
	public String editAccountTypeLink(@PathVariable Long accountTypeId,
			Map<String, Object> map) {
		AccountType existingAccountType = systemSettingsService
				.getExistingAccountType(accountTypeId);

		map.put("accountType", existingAccountType);
		return "editaccounttype";
	}

	@RequestMapping(value = "/editaccounttype/{accountTypeId}", method = RequestMethod.POST)
	public String postChangesToAccountType(@PathVariable Long accountTypeId,
			@ModelAttribute("accountType") AccountType accountType,
			BindingResult result) {

		systemSettingsValidator.validate(accountType, result);
		if (result.hasErrors()) {
			return "editaccounttype";
		}

		// Assign id
		accountType.setAccountTypeId(accountTypeId);
		systemSettingsService.editExistingAccountType(accountType);
		return "redirect:/listaccounttypes.html";
	}

	@RequestMapping("/removeaccounttype/{accountTypeId}")
	public String deleteAccountType(
			@PathVariable("accountTypeId") Long accountTypeId) {
		systemSettingsService.deleteExistingAccountType(accountTypeId);
		return "redirect:/listaccounttypes.html";
	}

	@RequestMapping(value = "/activateaccounttype/{accountTypeId}")
	public String activateAccountType(@PathVariable Long accountTypeId,
			@ModelAttribute("accountType") AccountType accountType,
			Map<String, Object> map) {
		Integer onSwitch = 1;

		// Assign id
		accountType.setAccountTypeId(accountTypeId);
		systemSettingsService.activateOrDeactivateExistingAccountType(
				accountTypeId, onSwitch);
		return "redirect:/listaccounttypes.html";
	}

	@RequestMapping(value = "/deactivateaccounttype/{accountTypeId}")
	public String deactivateAccountType(@PathVariable Long accountTypeId,
			@ModelAttribute("accountType") AccountType accountType,
			Map<String, Object> map) {

		Integer offSwitch = 0;

		// Assign id
		accountType.setAccountTypeId(accountTypeId);
		systemSettingsService.activateOrDeactivateExistingAccountType(
				accountTypeId, offSwitch);
		return "redirect:/listaccounttypes.html";
	}

	@RequestMapping("/listmobilendc")
	public String listAccountTypes(Map<String, Object> map) {

		map.put("NDCPToPList", systemSettingsService.listNDCPToP());
		map.put("NDCOffnetList", systemSettingsService.listNDCOffnet());
		return "listmobilendc";
	}

	@RequestMapping(value = "/addndcptop", method = RequestMethod.GET)
	public String addNdcListPToPLink(Map<String, Object> map) {
		map.put("ndcListPToP", new NdcListPToP());
		return "addndcptop";
	}

	@RequestMapping(value = "/addndcptop", method = RequestMethod.POST)
	public String addNdcListPToP(
			@ModelAttribute("ndcListPToP") NdcListPToP ndcListPToP,
			BindingResult result) {

		systemSettingsValidator.validate(ndcListPToP, result);
		if (result.hasErrors()) {
			return "addndcptop";
		}

		if ((ndcListPToP.getEnabledFlag() == null)
				|| (ndcListPToP.getEnabledFlag() != 1)) {
			ndcListPToP.setEnabledFlag(0);
		}

		systemSettingsService.addNdcListPToP(ndcListPToP);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping(value = "/editndcptop/{ndcListId}", method = RequestMethod.GET)
	public String editNdcListPToPLink(@PathVariable Long ndcListId,
			Map<String, Object> map) {
		NdcListPToP existingNdcListPToP = systemSettingsService
				.getExistingNdcListPToP(ndcListId);

		map.put("ndcListPToP", existingNdcListPToP);
		return "editndcptop";
	}

	@RequestMapping(value = "/editndcptop/{ndcListId}", method = RequestMethod.POST)
	public String postChangesToNdcListPToP(@PathVariable Long ndcListPToPId,
			@ModelAttribute("ndcListPToP") NdcListPToP ndcListPToP,
			BindingResult result) {

		systemSettingsValidator.validate(ndcListPToP, result);
		if (result.hasErrors()) {
			return "editndcptop";
		}

		// Assign id
		ndcListPToP.setNdcListId(ndcListPToPId);
		systemSettingsService.editExistingNdcListPToP(ndcListPToP);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping("/removendcptop/{ndcListId}")
	public String deleteNdcListPToP(@PathVariable("ndcListId") Long ndcListId) {
		systemSettingsService.deleteExistingNdcListPToP(ndcListId);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping(value = "/activatendcptop/{ndcListId}")
	public String activateNdcListPToP(@PathVariable Long ndcListId,
			@ModelAttribute("ndcListPToP") NdcListPToP ndcListPToP,
			Map<String, Object> map) {
		Integer onSwitch = 1;

		// Assign id
		ndcListPToP.setNdcListId(ndcListId);
		systemSettingsService.activateOrDeactivateExistingNdcListPToP(
				ndcListId, onSwitch);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping(value = "/deactivatendcptop/{ndcListId}")
	public String deactivateNdcListPToP(@PathVariable Long ndcListId,
			@ModelAttribute("ndcListPToP") NdcListPToP ndcListPToP,
			Map<String, Object> map) {

		Integer offSwitch = 0;

		// Assign id
		ndcListPToP.setNdcListId(ndcListId);
		systemSettingsService.activateOrDeactivateExistingNdcListPToP(
				ndcListId, offSwitch);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping(value = "/addndcoffnet", method = RequestMethod.GET)
	public String addNdcListOffnetLink(Map<String, Object> map) {
		map.put("ndcListOffnet", new NdcListOffnet());
		return "addndcoffnet";
	}

	@RequestMapping(value = "/addndcoffnet", method = RequestMethod.POST)
	public String addNdcListOffnet(
			@ModelAttribute("ndcListOffnet") NdcListOffnet ndcListOffnet,
			BindingResult result) {

		systemSettingsValidator.validate(ndcListOffnet, result);
		if (result.hasErrors()) {
			return "addndcoffnet";
		}

		if ((ndcListOffnet.getEnabledFlag() == null)
				|| (ndcListOffnet.getEnabledFlag() != 1)) {
			ndcListOffnet.setEnabledFlag(0);
		}

		systemSettingsService.addNdcListOffnet(ndcListOffnet);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping(value = "/editndcoffnet/{ndcListId}", method = RequestMethod.GET)
	public String editNdcListOffnetLink(@PathVariable Long ndcListId,
			Map<String, Object> map) {
		NdcListOffnet existingNdcListOffnet = systemSettingsService
				.getExistingNdcListOffnet(ndcListId);

		map.put("ndcListOffnet", existingNdcListOffnet);
		return "editndcoffnet";
	}

	@RequestMapping(value = "/editndcoffnet/{ndcListId}", method = RequestMethod.POST)
	public String postChangesToNdcListOffnet(@PathVariable Long ndcListId,
			@ModelAttribute("ndcListOffnet") NdcListOffnet ndcListOffnet,
			BindingResult result) {

		systemSettingsValidator.validate(ndcListOffnet, result);
		if (result.hasErrors()) {
			return "editndcoffnet";
		}

		// Assign id
		ndcListOffnet.setNdcListId(ndcListId);
		systemSettingsService.editExistingNdcListOffnet(ndcListOffnet);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping("/removendcoffnet/{ndcListId}")
	public String deleteNdcListOffnet(@PathVariable("ndcListId") Long ndcListId) {
		systemSettingsService.deleteExistingNdcListOffnet(ndcListId);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping(value = "/activatendcoffnet/{ndcListId}")
	public String activateNdcListPToP(@PathVariable Long ndcListId,
			@ModelAttribute("ndcListOffnet") NdcListOffnet ndcListOffnet,
			Map<String, Object> map) {
		Integer onSwitch = 1;

		// Assign id
		ndcListOffnet.setNdcListId(ndcListId);
		systemSettingsService.activateOrDeactivateExistingNdcListOffnet(
				ndcListId, onSwitch);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping(value = "/deactivatendcoffnet/{ndcListId}")
	public String deactivateNdcListOffnet(@PathVariable Long ndcListId,
			@ModelAttribute("ndcListOffnet") NdcListOffnet ndcListOffnet,
			Map<String, Object> map) {

		Integer offSwitch = 0;

		// Assign id
		ndcListOffnet.setNdcListId(ndcListId);
		systemSettingsService.activateOrDeactivateExistingNdcListOffnet(
				ndcListId, offSwitch);
		return "redirect:/listmobilendc.html";
	}

	@RequestMapping("/viewamlbarringsettings")
	public String listAmlBarringSettings(Map<String, Object> map) {
		map.put("amlBarring", new AmlBarring());
		map.put("amlBarringSettingsList",
				systemSettingsService.listAmlBarringSettings());
		return "viewamlbarringsettings";
	}

	@RequestMapping(value = "/addamlbarring", method = RequestMethod.GET)
	public String addAmlBarringLink(Map<String, Object> map) {
		map.put("amlBarring", new AmlBarring());
		return "addamlbarring";
	}

	@RequestMapping(value = "/addamlbarring", method = RequestMethod.POST)
	public String addAmlBarring(
			@ModelAttribute("amlBarring") AmlBarring amlBarring,
			BindingResult result) {
		systemSettingsService.addAmlBarringSetting(amlBarring);
		return "redirect:/viewamlbarringsettings.html";
	}

	@RequestMapping(value = "/editamlbarring/{barringId}", method = RequestMethod.GET)
	public String editAmlBarringLink(@PathVariable Long barringId,
			Map<String, Object> map) {
		AmlBarring existingAmlBarring = systemSettingsService
				.getExistingAmlBarring(barringId);

		map.put("amlBarring", existingAmlBarring);
		return "editamlbarring";
	}

	@RequestMapping(value = "/editamlbarring/{barringId}", method = RequestMethod.POST)
	public String postChangesToAmlBarring(@PathVariable Long barringId,
			@ModelAttribute("amlBarring") AmlBarring amlBarring,
			BindingResult result) {

		systemSettingsValidator.validate(amlBarring, result);
		if (result.hasErrors()) {
			return "editamlbarring";
		}

		// Assign id
		amlBarring.setBarringId(barringId);
		systemSettingsService.editExistingAmlBarring(amlBarring);
		return "redirect:/viewamlbarringsettings.html";
	}

	@RequestMapping("/removeamlbarring/{barringId}")
	public String deleteAmlBarring(@PathVariable("barringId") Long barringId) {
		systemSettingsService.deleteExistingAmlBarring(barringId);
		return "redirect:/viewamlbarringsettings.html";
	}

	@RequestMapping("/listglobalkeywordcharges")
	public String listGlobalKeywordCharges(Map<String, Object> map) {
		map.put("globalKeywordCharge", new GlobalKeywordCharge());
		map.put("globalKeywordChargeList",
				systemSettingsService.listGlobalKeywordCharges());
		return "listglobalkeywordcharges";
	}

	@RequestMapping(value = "/addglobalkeywordcharge", method = RequestMethod.GET)
	public String addGlobalKeywordChargeLink(Map<String, Object> map) {
		map.put("globalKeywordCharge", new GlobalKeywordCharge());
		return "addglobalkeywordcharge";
	}

	@RequestMapping(value = "/addglobalkeywordcharge", method = RequestMethod.POST)
	public String addGlobalKeywordCharge(
			@ModelAttribute("globalKeywordCharge") GlobalKeywordCharge globalKeywordCharge,
			BindingResult result) {

		systemSettingsValidator.validate(globalKeywordCharge, result);
		if (result.hasErrors()) {
			return "addglobalkeywordcharge";
		}

		UssdTransactionKeyword chargeKeyword = new UssdTransactionKeyword();
		if ((globalKeywordCharge.getTransactionKeyword().getKeywordId() == null)
				|| (globalKeywordCharge.getTransactionKeyword().getKeywordId() == 0)) {
			chargeKeyword = ussdMenuService
					.getExistingTransactionKeyword((long) 0);
		} else {
			chargeKeyword = ussdMenuService
					.getExistingTransactionKeyword(globalKeywordCharge
							.getTransactionKeyword().getKeywordId());
		}
		if (chargeKeyword != null) {
			globalKeywordCharge.setTransactionKeyword(chargeKeyword);
		}
		systemSettingsService.addGlobalKeywordCharge(globalKeywordCharge);
		return "redirect:/listglobalkeywordcharges.html";
	}

	@RequestMapping(value = "/editglobalkeywordcharge/{chargeId}", method = RequestMethod.GET)
	public String editGlobalKeywordChargeLink(@PathVariable Long chargeId,
			Map<String, Object> map) {
		GlobalKeywordCharge existingGlobalKeywordCharge = systemSettingsService
				.getExistingGlobalKeywordCharge(chargeId);

		map.put("globalKeywordCharge", existingGlobalKeywordCharge);
		return "editglobalkeywordcharge";
	}

	@RequestMapping(value = "/editglobalkeywordcharge/{chargeId}", method = RequestMethod.POST)
	public String postChangesToGlobalKeywordCharge(
			@PathVariable Long chargeId,
			@ModelAttribute("globalKeywordCharge") GlobalKeywordCharge globalKeywordCharge,
			BindingResult result) {

		systemSettingsValidator.validate(globalKeywordCharge, result);
		if (result.hasErrors()) {
			return "editglobalkeywordcharge";
		}

		// Assign id
		globalKeywordCharge.setChargeId(chargeId);
		systemSettingsService
				.editExistingGlobalKeywordCharge(globalKeywordCharge);
		return "redirect:/listglobalkeywordcharges.html";
	}

	@RequestMapping("/removeglobalkeywordcharge/{chargeId}")
	public String deleteGlobalKeywordCharge(
			@PathVariable("chargeId") Long chargeId) {
		systemSettingsService.deleteExistingGlobalKeywordCharge(chargeId);
		return "redirect:/listglobalkeywordcharges.html";
	}

	@RequestMapping("/viewsystemconfiguration")
	public String viewSystemConfiguration(Map<String, Object> map) {

		SystemConfiguration existingSystemConfiguration = systemSettingsService
				.getSystemConfiguration();
		if (null != existingSystemConfiguration) {
			map.put("systemConfiguration", existingSystemConfiguration);
			return "viewsystemconfiguration";
		} else {
			map.put("systemConfiguration", new SystemConfiguration());
			return "redirect:/addsystemconfiguration.html";
		}
	}

	@RequestMapping(value = "/addsystemconfiguration", method = RequestMethod.GET)
	public String addSystemConfigurationLink(Map<String, Object> map) {
		map.put("systemConfiguration", new SystemConfiguration());
		return "addsystemconfiguration";
	}

	@RequestMapping(value = "/addsystemconfiguration", method = RequestMethod.POST)
	public String addSystemConfiguration(
			@ModelAttribute("systemConfiguration") SystemConfiguration systemConfiguration,
			BindingResult result) {

		systemSettingsService.addSystemConfiguration(systemConfiguration);
		return "redirect:/auilanding.html";
	}

	/*
	 * @RequestMapping(value = "/viewsystemconfiguration", method =
	 * RequestMethod.GET) public String
	 * editSystemConfigurationLink(@PathVariable Long configId, Map<String,
	 * Object> map) { SystemConfiguration existingSystemConfiguration =
	 * systemSettingsService .getExistingSystemConfiguration();
	 * 
	 * map.put("systemConfiguration", existingSystemConfiguration); return
	 * "viewsystemconfiguration"; }
	 */

	@RequestMapping(value = "/viewsystemconfiguration", method = RequestMethod.POST)
	public String postChangesToSystemConfiguration(
			// @PathVariable Long configId,
			@ModelAttribute("systemConfiguration") SystemConfiguration systemConfiguration,
			BindingResult result) {

		systemSettingsValidator.validate(systemConfiguration, result);
		if (result.hasErrors()) {
			return "viewsystemconfiguration";
		}
		systemConfiguration.setConfigId((long) 1);
		systemSettingsService
				.editExistingSystemConfiguration(systemConfiguration);
		return "redirect:/auilanding.html";
	}

	// Create model attributes for linking across models
	@ModelAttribute("globalKeywordChargeList")
	public List<GlobalKeywordCharge> populateGlobalKeywordChargeList() {
		return systemSettingsService.listGlobalKeywordCharges();
	}

	@ModelAttribute("memoGroupsList")
	public List<MemoGroup> populateMemoGroupList() {
		return systemSettingsService.listMemoGroups();
	}

	@ModelAttribute("amlBarringSettingsList")
	public List<AmlBarring> populateAmlBarringSettingsList() {
		return systemSettingsService.listAmlBarringSettings();
	}

	@ModelAttribute("transactionKeywordsList")
	public List<UssdTransactionKeyword> populateTransactionKeywordsList() {
		return ussdMenuService.listTransactionKeywords();
	}

	@ModelAttribute("accountTypesList")
	public List<AccountType> populateAccountTypesList() {
		return systemSettingsService.listAccountTypes();
	}

	@ModelAttribute("messagesList")
	public List<Message> populateMessageList() {
		return systemSettingsService.listMessages();
	}

	@ModelAttribute("languagesList")
	public List<Language> populateLanguageList() {
		return systemSettingsService.listLanguages();
	}

	@ModelAttribute("NDCPToPList")
	public List<NdcListPToP> populateNDCPToPList() {
		return systemSettingsService.listNDCPToP();
	}

	@ModelAttribute("NDCOffnetList")
	public List<NdcListOffnet> populateNDCOffnetList() {
		return systemSettingsService.listNDCOffnet();
	}

	@ModelAttribute("usersList")
	public List<User> populateUserList() {
		return systemSettingsService.listUsers();
	}
}