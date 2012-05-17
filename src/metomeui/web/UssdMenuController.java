package metomeui.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdRequest;
import metomeui.model.UssdTransactionKeyword;
import metomeui.service.UssdMenuService;
import metomeui.validator.UssdKeywordStepValidator;
import metomeui.validator.UssdMenuItemValidator;
import metomeui.validator.UssdPredefInputItemValidator;
import metomeui.validator.UssdPredefInputValidator;
import metomeui.validator.UssdTransactionKeywordValidator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping("/users")
public class UssdMenuController {

	private static Logger logger = Logger.getLogger(UssdMenuController.class);

	@Autowired
	private UssdMenuService ussdMenuService;
	@Autowired
	private UssdMenuItemValidator ussdMenuItemValidator;
	@Autowired
	private UssdTransactionKeywordValidator ussdTransactionKeywordValidator;
	@Autowired
	private UssdPredefInputValidator ussdPredefInputValidator;
	@Autowired
	private UssdPredefInputItemValidator ussdPredefInputItemValidator;
	@Autowired
	private UssdKeywordStepValidator ussdKeywordStepValidator;

	@RequestMapping("/hello")
	public String printWelcome(ModelMap model) {

		logger.info("Returning hello view");
		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);
		model.addAttribute("now", now);
		return "hello";

	}

	@RequestMapping("/ussdpredefinputitems")
	public String listUssdPredefInputItems(Map<String, Object> map) {
		map.put("ussdPredefInputItem", new UssdPredefInputItem());
		map.put("ussdPredefInputItemList",
				ussdMenuService.listUssdPredefInputItems());
		return "ussdpredefinputitems";
	}

	@RequestMapping(value = "/addussdpredefinputitems", method = RequestMethod.GET)
	public String addUssdPredefInputItemsLink(Map<String, Object> map) {
		map.put("ussdPredefInputItem", new UssdPredefInputItem());
		return "addussdpredefinputitems";
	}
	
	@RequestMapping(value = "/addpredefinputitems", method = RequestMethod.POST)
	public String addUssdPredefInputItems(
			@ModelAttribute("ussdPredefInputItem") UssdPredefInputItem ussdPredefInputItem,
			BindingResult result) {

		ussdPredefInputItemValidator.validate(ussdPredefInputItem, result);
		if (result.hasErrors()) {
			return "addussdpredefinputitems";
		}

		ussdMenuService.addUssdPredefInputItem(ussdPredefInputItem);
		return "redirect:/ussdpredefinputitems.html";
	}

	@RequestMapping("/removepredefinputitem/{inputItemId}")
	public String deleteUssdPredefInputItem(
			@PathVariable("inputItemId") Integer inputItemId) {
		ussdMenuService.removeUssdPredefInputItem(inputItemId);
		return "redirect:/ussdpredefinputitems.html";
	}

	@RequestMapping("/ussdpredefinputs")
	public String listUssdPredefInputs(Map<String, Object> map) {
		map.put("ussdPredefInput", new UssdPredefInput());
		map.put("ussdPredefInputList", ussdMenuService.listUssdPredefInputs());
		return "ussdpredefinputs";
	}

	@RequestMapping("/retreivepredefinputs/?id={predefInputId}")
	public String retrieveSinglePredefInputEntry(
			@PathVariable("predefInputId") Integer predefInputId) {
		ussdMenuService.retrieveSinglePredefInputEntry(predefInputId);
		return "singlepredefinput";
	}

	@RequestMapping("/editpredefinput/{predefInputId}")
	public String getEditPredefInputEntry(
			@PathVariable("predefInputId") Integer predefInputId, Model model) {
		logger.debug("Received request to show edit page");

		// Retrieve existing entry and add to model
		model.addAttribute("ussdPredefInput", predefInputId);

		// This will resolve to /WEB-INF/jsp/editpagepredefinputs.jsp
		return "editussdpredefinputs";
	}

	@RequestMapping(value = "/editpredefinput/{predefInputId}", method = RequestMethod.POST)
	public String saveEditPredefInputEntry(
			@ModelAttribute("ussdPredefInput") UssdPredefInput ussdPredefInput,
			@PathVariable("predefInputId") Integer predefInputId,
			BindingResult result) {
		logger.debug("Received request to update predefined input");
		ussdMenuService.updatePredefInput(ussdPredefInput, predefInputId);
		return "editedussdpredefinputs";
	}

	@RequestMapping(value = "/addussdpredefinputs", method = RequestMethod.GET)
	public String addUssdPredefInputsLink(Map<String, Object> map) {
		map.put("ussdPredefInput", new UssdPredefInput());
		return "addussdpredefinputs";
	}
	
	@RequestMapping(value = "/addpredefinputs", method = RequestMethod.POST)
	public String addUssdPredefInput(
			@ModelAttribute("ussdPredefInput") UssdPredefInput ussdPredefInput,
			BindingResult result) {

		ussdPredefInputValidator.validate(ussdPredefInput, result);
		if (result.hasErrors()) {
			return "addussdpredefinputs";
		}

		ussdMenuService.addUssdPredefInput(ussdPredefInput);
		return "redirect:/ussdpredefinputs.html";
	}

	@RequestMapping("/removepredefinput/{predefInputId}")
	public String deleteUssdPredefInput(
			@PathVariable("predefInputId") Integer predefInputId) {
		ussdMenuService.removeUssdPredefInput(predefInputId);
		return "redirect:/ussdpredefinputs.html";
	}

	@RequestMapping("/ussdtransactionkeywords")
	public String listUssdTransactionKeywords(Map<String, Object> map) {
		map.put("ussdTransactionKeyword", new UssdTransactionKeyword());
		map.put("ussdTransactionKeywordList",
				ussdMenuService.listUssdTransactionKeywords());
		return "ussdtransactionkeywords";
	}

	@RequestMapping(value = "/addussdtransactionkeywords", method = RequestMethod.GET)
	public String addUssdTransactionKeywordsLink(Map<String, Object> map) {
		map.put("ussdTransactionKeyword", new UssdTransactionKeyword());
		return "addussdtransactionkeywords";
	}
	
	@RequestMapping(value = "/addtransactionkeywords", method = RequestMethod.POST)
	public String addUssdTransactionKeyword(
			@ModelAttribute("ussdTransactionKeyword") UssdTransactionKeyword ussdTransactionKeyword,
			BindingResult result) {

		ussdTransactionKeywordValidator
				.validate(ussdTransactionKeyword, result);
		if (result.hasErrors()) {
			return "addussdtransactionkeywords";
		}

		ussdMenuService.addUssdTransactionKeyword(ussdTransactionKeyword);
		return "redirect:/ussdtransactionkeywords.html";
	}

	@RequestMapping("/removekeyword/{keywordId}")
	public String deleteUssdTransactionKeyword(
			@PathVariable("keywordId") Integer keywordId) {
		ussdMenuService.removeUssdTransactionKeyword(keywordId);
		return "redirect:/ussdtransactionkeywords.html";
	}

	@RequestMapping("/ussdkeywordsteps")
	public String listUssdKeywordSteps(Map<String, Object> map) {
		map.put("ussdKeywordStep", new UssdKeywordStep());
		map.put("ussdKeywordStepList", ussdMenuService.listUssdKeywordSteps());
		return "ussdkeywordsteps";
	}

	@RequestMapping(value = "/addussdkeywordsteps", method = RequestMethod.GET)
	public String addUssdKeywordStepsLink(Map<String, Object> map) {
		map.put("ussdKeywordStep", new UssdKeywordStep());
		return "addussdkeywordsteps";
	}
	
	@RequestMapping(value = "/addkeywordsteps", method = RequestMethod.POST)
	public String addUssdKeywordStep(
			@ModelAttribute("ussdKeywordStep") UssdKeywordStep ussdKeywordStep,
			BindingResult result) {

		ussdKeywordStepValidator.validate(ussdKeywordStep, result);
		if (result.hasErrors()) {
			return "addussdkeywordsteps";
		}

		ussdMenuService.addUssdKeywordStep(ussdKeywordStep);
		return "redirect:/ussdkeywordsteps.html";
	}

	@RequestMapping("/removekeywordstep/{keywordStepId}")
	public String deleteUssdKeywordStep(
			@PathVariable("keywordStepId") Integer keywordStepId) {
		ussdMenuService.removeUssdKeywordStep(keywordStepId);
		return "redirect:/ussdkeywordsteps.html";
	}

	@RequestMapping("/ussdmenuitems")
	public String listUssdMenuItems(Map<String, Object> map) {
		map.put("ussdMenuItem", new UssdMenuItem());
		map.put("ussdMenuItemsList", ussdMenuService.listUssdMenuItems());
		return "ussdmenuitems";
	}

	@RequestMapping(value = "/addussdmenuitems", method = RequestMethod.GET)
	public String addUssdMenuItemLink(Map<String, Object> map) {
		map.put("ussdMenuItem", new UssdMenuItem());
		return "addussdmenuitems";
	}

	@RequestMapping(value = "/addmenuitems", method = RequestMethod.POST)
	public String addUssdMenuItem(
			@ModelAttribute("ussdMenuItem") UssdMenuItem ussdMenuItem,
			BindingResult result) {

		ussdMenuItemValidator.validate(ussdMenuItem, result);
		if (result.hasErrors()) {
			return "addussdmenuitems";
		}

		ussdMenuService.addUssdMenuItem(ussdMenuItem);
		return "redirect:/ussdmenuitems.html";
	}

	@RequestMapping("/removemenuitem/{menuItemId}")
	public String deleteUssdMenuItem(
			@PathVariable("menuItemId") Integer menuItemId) {
		ussdMenuService.removeUssdMenuItem(menuItemId);
		return "redirect:/ussdmenuitems.html";
	}

	@RequestMapping("/ussdrequests")
	public String listUssdRequests(Map<String, Object> map) {
		map.put("ussdRequest", new UssdRequest());
		map.put("ussdRequestsList",
				ussdMenuService.listUssdRequests());
		return "ussdrequests";
	}
	
	// Create model attributes for linking across models
	@ModelAttribute("predefInputList")
	public List<UssdPredefInput> populatePredefInputIdAndNameList() {
		return ussdMenuService.listUssdPredefInputs();
	}

	@ModelAttribute("transactionKeywordList")
	public List<UssdTransactionKeyword> populateKeywordIdAndNameList() {
		return ussdMenuService.listUssdTransactionKeywords();
	}

	@ModelAttribute("menuItemList")
	public List<UssdMenuItem> populateMenuItemIdAndNameList() {
		return ussdMenuService.listUssdMenuItems();
	}
}