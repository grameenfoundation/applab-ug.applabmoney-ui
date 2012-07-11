package metomeui.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import metomeui.model.AccountType;
import metomeui.model.Language;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.MsisdnSettings;
import metomeui.model.User;
import metomeui.service.SystemSettingsService;
import metomeui.service.SystemSettingsServiceImplementation;
import metomeui.validator.MsisdnSettingsValidator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SystemConfigurationsController {

	private static Logger logger = Logger
			.getLogger(SystemConfigurationsController.class);

	@Autowired
	private MsisdnSettingsValidator msisdnSettingsValidator;
	@Autowired
	SystemSettingsService systemSettingsService = new SystemSettingsServiceImplementation();

	public void setMsisdnSettingsValidator(
			MsisdnSettingsValidator msisdnSettingsValidator) {
		this.msisdnSettingsValidator = msisdnSettingsValidator;
	}

	@RequestMapping("/users")
	public String listUser(Map<String, Object> map) {
		map.put("user", new User());
		map.put("userList", systemSettingsService.listUsers());
		return "users";
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
		return "redirect:/users.html";
	}
	
	@RequestMapping(value = "/edituser/{userId}", method = RequestMethod.GET)
	public String editUserLink(@PathVariable long userId,
			Map<String, Object> map) {
		User existingUser = systemSettingsService
				.getExistingUser(userId);

		map.put("user", existingUser);
		return "edituser";
	}

	@RequestMapping(value = "/edituser/{userId}", method = RequestMethod.POST)
	public String postChangesToMessage(@PathVariable long userId,
			@ModelAttribute("user") User user, BindingResult result) {
		// Assign id
		user.setUserId(userId);
		systemSettingsService.editExistingUser(user);
		return "redirect:/users.html";
	}

	@RequestMapping("/removeUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		systemSettingsService.removeUser(userId);
		logger.info("Returning hello view");
		return "redirect:/users.html";
	}

	@RequestMapping("/listmessages")
	public String listMessages(Map<String, Object> map) {
		map.put("message", new Message());
		map.put("messagesList", systemSettingsService.listMessages());
		return "listmessages";
	}

	@RequestMapping(value = "/addmessage", method = RequestMethod.GET)
	public String addMessageLink(Map<String, Object> map) {
		map.put("message", new Message());
		return "addmessage";
	}

	@RequestMapping(value = "/addmessage", method = RequestMethod.POST)
	public String addMessage(@ModelAttribute("message") Message message,
			BindingResult result) {

		systemSettingsService.addMessage(message);
		return "redirect:/listmessages.html";
	}

	@RequestMapping(value = "/editmessage/{messageId}", method = RequestMethod.GET)
	public String editMessageLink(@PathVariable long messageId,
			Map<String, Object> map) {
		Message existingMessage = systemSettingsService
				.getExistingMessage(messageId);

		map.put("message", existingMessage);
		return "editmessage";
	}

	@RequestMapping(value = "/editmessage/{messageId}", method = RequestMethod.POST)
	public String postChangesToMessage(@PathVariable long messageId,
			@ModelAttribute("message") Message message, BindingResult result) {
		// Assign id
		message.setMessageId(messageId);
		systemSettingsService.editExistingMessage(message);
		return "redirect:/listmessages.html";
	}
	
	@RequestMapping("/removemessage/{messageId}")
	public String deleteMessage(@PathVariable("messageId") Integer messageId) {
		systemSettingsService.removeMessage(messageId);
		return "redirect:/messages.html";
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
		return "addlanguages";
	}

	@RequestMapping(value = "/addlanguage", method = RequestMethod.POST)
	public String addLanguage(@ModelAttribute("language") Language language,
			BindingResult result) {

		/*
		 * systemSettingsService.validate(language, result); if
		 * (result.hasErrors()) { return "addlanguages"; }
		 */

		systemSettingsService.addLanguage(language);
		return "redirect:/listlanguages.html";
	}

	@RequestMapping(value = "/editlanguage/{languageId}", method = RequestMethod.GET)
	public String editLanguageLink(@PathVariable long languageId,
			Map<String, Object> map) {
		Language existingLanguage = systemSettingsService
				.getExistingLanguage(languageId);

		map.put("language", existingLanguage);
		return "editlanguage";
	}

	
	@RequestMapping(value = "/editlanguage/{languageId}", method = RequestMethod.POST)
	public String postChangesToLanguage(@PathVariable long languageId,
			@ModelAttribute("language") Language language, BindingResult result) {
		// Assign id
		language.setLanguageId(languageId);
		systemSettingsService.editExistingLanguage(language);
		return "redirect:/listlanguages.html";
	}
	
	@RequestMapping("/removelanguage/{languageId}")
	public String deleteLanguage(@PathVariable("languageId") Integer languageId) {
		systemSettingsService.removeLanguage(languageId);
		return "redirect:/languages.html";
	}

	@RequestMapping("/listaccounttypes")
	public String listAccountTypes(Map<String, Object> map) {
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

		/*
		 * systemSettingsService.validate(accountType, result); if
		 * (result.hasErrors()) { return "addaccounttypes"; }
		 */

		systemSettingsService.addAccountType(accountType);
		return "redirect:/listaccounttype.html";
	}

	@RequestMapping(value = "/editaccounttype/{accountTypeId}", method = RequestMethod.GET)
	public String editAccountTypeLink(@PathVariable long accountTypeId,
			Map<String, Object> map) {
		AccountType existingAccountType = systemSettingsService
				.getExistingAccountType(accountTypeId);

		map.put("accountType", existingAccountType);
		return "editaccounttype";
	}

	@RequestMapping(value = "/editaccounttype/{accountTypeId}", method = RequestMethod.POST)
	public String postChangesToAccountType(@PathVariable long accountTypeId,
			@ModelAttribute("accountType") AccountType accountType,
			BindingResult result) {
		// Assign id
		accountType.setAccountTypeId(accountTypeId);
		systemSettingsService.editExistingAccountType(accountType);
		return "redirect:/listaccounttypes.html";
	}

	@RequestMapping("/removeaccounttype/{accountTypeId}")
	public String deleteAccountType(
			@PathVariable("accountTypeId") Integer accountTypeId) {
		systemSettingsService.removeLanguage(accountTypeId);
		return "redirect:/listaccounttypes.html";
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

		/*
		 * systemSettingsService.validate(language, result); if
		 * (result.hasErrors()) { return "addlanguages"; }
		 */

		systemSettingsService.addMemoGroup(memoGroup);
		return "redirect:/listmemogroup.html";
	}

	@RequestMapping(value = "/editmemogroup/{memogroupId}", method = RequestMethod.GET)
	public String editMemoGroupLink(@PathVariable long memoGroupId,
			Map<String, Object> map) {
		MemoGroup existingMemoGroup = systemSettingsService
				.getExistingMemoGroup(memoGroupId);

		map.put("memogroup", existingMemoGroup);
		return "editmemogroup";
	}

	@RequestMapping(value = "/editmemogroup/{memogroupId}", method = RequestMethod.POST)
	public String postChangesToMemoGroup(@PathVariable long memoGroupId,
			@ModelAttribute("memogroup") MemoGroup memoGroup, BindingResult result) {
		// Assign id
		memoGroup.setMemoGroupId(memoGroupId);
		systemSettingsService.editExistingMemoGroup(memoGroup);
		return "redirect:/listmemogroups.html";
	}
	
	@RequestMapping("/removememogroup/{memoGroupId}")
	public String deleteMemoGroup(
			@PathVariable("memoGroupId") Integer memoGroupId) {
		systemSettingsService.removeMemoGroup(memoGroupId);
		return "redirect:/listmemogroups.html";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, MsisdnSettings> model) {
		MsisdnSettings msisdnSettings = new MsisdnSettings();
		model.put("msisdnSettings", msisdnSettings);
		return "auimsisdnsettings";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid MsisdnSettings msisdnSettings,
			BindingResult results, Map<String, MsisdnSettings> model) {
		msisdnSettingsValidator.validate(msisdnSettings, results);
		// passwordSettings = (PasswordSettings) model.get("passwordSettings");
		if (results.hasErrors()) {
			return "auimsisdnsettings";
		}

		model.put("msisdnSettings", msisdnSettings);
		logger.info("Successful Login!! Now onto landing Page!!");
		return "loginsuccess";
	}

	
	
	/*// Create model attributes for linking across models
	@ModelAttribute("accountTypesList")
	public List<AccountType> populateAccountTypesList() {
		return systemSettingsService.listAccountTypes();
	}

	@ModelAttribute("memoGroupsList")
	public List<MemoGroup> populateMemoGroupList() {
		return systemSettingsService.listMemoGroups();
	}

	@ModelAttribute("messagesList")
	public List<Message> populateMessageList() {
		return systemSettingsService.listMessages();
	}

	@ModelAttribute("languagesList")
	public List<Language> populateLanguageList() {
		return systemSettingsService.listLanguages();
	}*/

	@ModelAttribute("usersList")
	public List<User> populateUserList() {
		return systemSettingsService.listUsers();
	}
}
