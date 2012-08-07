package metomeui.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdTransactionKeyword;
import metomeui.service.UssdMenuService;
import metomeui.service.UssdMenuServiceImplementation;
import metomeui.validator.UssdMenuValidator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UssdMenuController {

	private static Logger logger = Logger.getLogger(UssdMenuController.class);

	@Autowired
	UssdMenuService ussdMenuService = new UssdMenuServiceImplementation();

	@Autowired
	private UssdMenuValidator ussdMenuValidator;

	private static List<UssdPredefInputItem> predefInputItemsList = new ArrayList<UssdPredefInputItem>();
	private static Set<UssdPredefInputItem> predefInputItemsSet = new HashSet<UssdPredefInputItem>();

	private static List<UssdKeywordStep> keywordStepsList = new ArrayList<UssdKeywordStep>();
	private static Set<UssdKeywordStep> keywordStepsSet = new HashSet<UssdKeywordStep>();

	@RequestMapping("/hello")
	public String printWelcome(ModelMap model) {

		logger.info("Returning hello view");
		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);
		model.addAttribute("now", now);
		return "hello";
	}

	/**
	 * Predefined inputs and input items mapping functions
	 * 
	 * Function lists configured Predefined Inputs"
	 */
	@RequestMapping(value = "/listussdpredefinputs", method = RequestMethod.GET)
	public String getPredefInputList(Map<String, Object> map) {
		predefInputItemsList.clear();
		map.put("predefInput", new UssdPredefInput());
		map.put("predefInputList", ussdMenuService.listPredefInputs());
		return "listussdpredefinputs";
	}

	/**
	 * Retrieves "Add New Predefined Input" page
	 */
	@RequestMapping(value = "/addussdpredefinput", method = RequestMethod.GET)
	public ModelAndView getPredefInput(
			@ModelAttribute("ussdPredefInput") UssdPredefInput predefInput) {
		if (null != predefInputItemsList) {
			logger.info("PredefItemsList is not Null");
			predefInput.setPredefInputItems(predefInputItemsList);
		} else {
			logger.info("PredefItemsList is Null");
		}
		return new ModelAndView("addussdpredefinput", "ussdPredefInput",
				predefInput);
	}

	/**
	 * Retrieves "Add New Predefined Input Item" page
	 */
	@RequestMapping(value = "/addnewussdpredefinputitem", method = RequestMethod.GET)
	public String addPredefInputItemLink(Map<String, Object> map) {
		map.put("ussdPredefInputItem", new UssdPredefInputItem());
		return "addnewussdpredefinputitem";
	}

	/**
	 * Add New Predefined Input Item to Predefined Input
	 */
	@RequestMapping(value = "/addussdpredefinputitem", method = RequestMethod.POST)
	public String addPredefInputItem(
			@ModelAttribute("ussdPredefInputItem") UssdPredefInputItem predefInputItem,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(predefInputItem, result);
		if (result.hasErrors()) {
			return "addnewussdpredefinputitem";
		} else {
			UssdPredefInput predefInput = new UssdPredefInput();
			if (predefInputItemsSet.add(predefInputItem) == true) {
				if (predefInputItem != null) {
					try {
						logger.info("add item to predefInputItemsList");
						predefInputItemsList.add(predefInputItem);
						predefInput.setPredefInputItems(predefInputItemsList);
					} catch (Exception e) {
						e.printStackTrace();
						return "redirect:/listussdpredefinputs.html";
					}
				}
			}
			map.put("ussdPredefInput", predefInput);
			return "addussdpredefinput";
		}
	}

	/**
	 * Add New Predefined Input
	 */
	@SuppressWarnings({ "unused" })
	@RequestMapping(value = "/addussdpredefinput", method = RequestMethod.POST)
	public String addPredefinedInput(
			@ModelAttribute("ussdPredefInput") UssdPredefInput predefInput,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(predefInput, result);
		if (result.hasErrors()) {
			return "addussdpredefinput";
		} else {
			if (predefInput != null) {
				List<UssdPredefInputItem> ussdPredefInputItems = predefInput
						.getPredefInputItems();

				/** for each of the predefinputitems, add the predefinput id */
				if (null != predefInputItemsList
						&& predefInputItemsList.size() > 0) {
					predefInput.setPredefInputItems(predefInputItemsList);

					for (UssdPredefInputItem predefInputItem : predefInputItemsList) {

						predefInputItem.setPredefInput(predefInput);
						if (predefInputItem.getPredefInputItemEnabledFlag() == null) {
							predefInputItem.setPredefInputItemEnabledFlag(0);
						}
					}
				}
			}
			ussdMenuService.addPredefInput(predefInput);
			if (!predefInputItemsList.isEmpty()) {
				predefInputItemsList.clear();
			}
			map.put("ussdPredefInput", new UssdPredefInput());
			map.put("predefInputList", ussdMenuService.listPredefInputs());
			return "listussdpredefinputs";
		}
	}

	/**
	 * Retrieves the "Edit Existing Predefined Input" page
	 */
	@RequestMapping(value = "/editussdpredefinput/{predefInputId}", method = RequestMethod.GET)
	public String retrieveEditPredefInputPage(@PathVariable Long predefInputId,
			Map<String, Object> map) {

		UssdPredefInput existingUssdPredefInput = ussdMenuService
				.getExistingPredefInput(predefInputId);
		predefInputItemsList = ussdMenuService
				.listPredefInputItemsByPredefInputId(predefInputId);
		if (predefInputItemsList != null) {
			existingUssdPredefInput.setPredefInputItems(predefInputItemsList);
		}
		map.put("predefInputItemsList", predefInputItemsList);
		map.put("ussdPredefInput", existingUssdPredefInput);
		return "editussdpredefinput";
	}

	/**
	 * Retrieves the "Edit Existing Predefined Input item" page
	 */
	@RequestMapping(value = "/editussdpredefinputitem/{inputItemId}", method = RequestMethod.GET)
	public String retrieveEditPredefInputItemPage(
			@PathVariable Long inputItemId, Map<String, Object> map) {
		UssdPredefInputItem existingUssdPredefInputItem = ussdMenuService
				.getExistingPredefInputItem(inputItemId);

		map.put("ussdPredefInputItem", existingUssdPredefInputItem);
		return "editussdpredefinputitem";
	}

	/**
	 * Retrieves the "Edit Existing Predef Input" page after editing an input
	 * item
	 */
	@RequestMapping(value = "/editussdpredefinputitem/{inputItemId}", method = RequestMethod.POST)
	public String addEditedPredefInputItem(
			@PathVariable Long inputItemId,
			@ModelAttribute("ussdPredefInputItem") UssdPredefInputItem predefInputItem,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(predefInputItem, result);
		if (result.hasErrors()) {
			return "redirect:/editussdpredefinput/" + inputItemId + ".html";
		} else {
			predefInputItem.setInputItemId(inputItemId);

			if (predefInputItem.getPredefInputItemEnabledFlag() == null) {
				predefInputItem.setPredefInputItemEnabledFlag(0);
			}
			ussdMenuService.editPredefInputItem(predefInputItem);
			predefInputItemsList = ussdMenuService
					.listPredefInputItemsByPredefInputId(predefInputItem
							.getPredefInput().getPredefInputId());
			UssdPredefInput existingPredefInput = ussdMenuService
					.getExistingPredefInput(predefInputItem.getPredefInput()
							.getPredefInputId());
			map.put("predefInputItemsList", predefInputItemsList);
			map.put("ussdPredefInput", existingPredefInput);
			return "editussdpredefinput";
		}
	}

	/**
	 * Retrieves the "Add Predefined Input Item to Existing Input" Page
	 */
	@RequestMapping(value = "/editaddnewussdpredefinputitem/{predefInputId}", method = RequestMethod.GET)
	public String addPredefInputItemOnEditLink(
			@PathVariable Long predefInputId, Map<String, Object> map) {
		map.put("ussdPredefInputItem", new UssdPredefInputItem());
		map.put("predefInputId", predefInputId);
		return "editaddnewussdpredefinputitem";
	}

	/**
	 * Retrieves the "Edit Existing Predef Input" page after adding a new input
	 * item
	 */
	@RequestMapping(value = "/editaddnewussdpredefinputitem/{predefInputId}", method = RequestMethod.POST)
	public String addNewPredefInputItemOnEdit(
			@PathVariable Long predefInputId,
			@ModelAttribute("ussdPredefInputItem") UssdPredefInputItem predefInputItem,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(predefInputItem, result, predefInputId);
		if (result.hasErrors()) {
			map.put("predefInputId", predefInputId);
			return "editussdpredefinput";
		} else {
			UssdPredefInput existingPredefInput = ussdMenuService
					.getExistingPredefInput(predefInputId);
			predefInputItem.setPredefInput(existingPredefInput);
			ussdMenuService.addPredefInputItem(predefInputItem);
			predefInputItemsList = ussdMenuService
					.listPredefInputItemsByPredefInputId(predefInputId);
			if (predefInputItemsList != null) {
				existingPredefInput.setPredefInputItems(predefInputItemsList);
			}

			map.put("predefInputItemsList", predefInputItemsList);
			map.put("ussdPredefInput", existingPredefInput);
			return "editussdpredefinput";
		}
	}

	/**
	 * Commit changes to an existing predefined input
	 */
	@RequestMapping(value = "/editussdpredefinput/{predefInputId}", method = RequestMethod.POST)
	public String postChangesToPredefinedInput(
			@PathVariable Long predefInputId,
			@ModelAttribute("ussdPredefInput") UssdPredefInput predefInput,
			BindingResult result) {
		ussdMenuValidator.validate(predefInput, result);
		if (result.hasErrors()) {
			return "editussdpredefinput";
		}

		// Assign id
		predefInput.setPredefInputId(predefInputId);

		predefInputItemsList = predefInput.getPredefInputItems();
		if (predefInputItemsList != null && predefInputItemsList.size() > 0) {
			for (UssdPredefInputItem predefInputItem : predefInputItemsList) {
				predefInputItem.setPredefInput(predefInput);
				if (predefInputItem.getPredefInputItemEnabledFlag() != 1) {
					predefInputItem.setPredefInputItemEnabledFlag(0);
				} else {
					predefInputItem.setPredefInputItemEnabledFlag(1);
				}
			}
			predefInput.setPredefInputItems(predefInputItemsList);
		}

		if (!(predefInputItemsList.isEmpty())) {
			predefInputItemsList.clear();
		}
		// Delegate to service
		ussdMenuService.editPredefInput(predefInput);
		return "redirect:/listussdpredefinputs.html";
	}

	@RequestMapping(value = "/activatepredefinputitem/{predefInputItemId}")
	public String activatePredefInputItem(@PathVariable Long predefInputItemId,
			@ModelAttribute("ussdPredefInput") UssdPredefInput predefInput,
			Map<String, Object> map) {

		UssdPredefInputItem predefInputItem = ussdMenuService
				.getExistingPredefInputItem(predefInputItemId);
		Long predefInputId = predefInputItem.getPredefInput()
				.getPredefInputId();

		// Assign id
		predefInput.setPredefInputId(predefInputItemId);
		ussdMenuService.activateExistingPredefInputItem(predefInputItemId);

		map.put("predefInputId", predefInputId);

		return "redirect:/editussdpredefinput/" + predefInputId + ".html";
	}

	@RequestMapping(value = "/deactivatepredefinputitem/{predefInputItemId}")
	public String deactivatePredefInputItem(
			@PathVariable Long predefInputItemId,
			@ModelAttribute("ussdPredefInput") UssdPredefInput predefInput,
			Map<String, Object> map) {

		UssdPredefInputItem predefInputItem = ussdMenuService
				.getExistingPredefInputItem(predefInputItemId);

		Long predefInputId = predefInputItem.getPredefInput()
				.getPredefInputId();

		// Assign id
		predefInput.setPredefInputId(predefInputItemId);
		ussdMenuService.deactivateExistingPredefInputItem(predefInputItemId);

		map.put("predefInputId", predefInputId);
		return "redirect:/editussdpredefinput/" + predefInputId + ".html";
	}

	/**
	 * Delete an existing predefined input
	 */
	@RequestMapping(value = "/removepredefinput/{predefInputId}", method = RequestMethod.GET)
	public String deletePredefInput(@PathVariable Long predefInputId,
			Map<String, Object> map) {

		ussdMenuService.deleteExistingPredefInput(predefInputId);
		map.put("ussdPredefInput", new UssdPredefInput());
		map.put("ussdPredefInputList", ussdMenuService.listPredefInputs());
		return "redirect:/listussdpredefinputs.html";
	}

	/**
	 * Delete an existing predefined input item
	 */
	@RequestMapping(value = "/removepredefinputitem/{inputItemId}", method = RequestMethod.GET)
	public String deletePredefInputItem(@PathVariable Long inputItemId,
			Map<String, Object> map) {

		UssdPredefInputItem predefInputItem = ussdMenuService
				.getExistingPredefInputItem(inputItemId);
		UssdPredefInput predefInput = predefInputItem.getPredefInput();

		predefInput.getPredefInputItems().remove(predefInputItem);
		Long predefInputId = predefInputItem.getPredefInput()
				.getPredefInputId();

		ussdMenuService.deleteExistingPredefInputItem(inputItemId);
		map.put("ussdPredefInput", predefInput);
		map.put("ussdPredefInputItemsList", predefInput.getPredefInputItems());
		return "redirect:/editussdpredefinput/" + predefInputId + ".html";
	}

	/**
	 * Ussd Transaction Keywords mapping functions
	 * 
	 * Function lists configured Ussd Transaction Keywords"
	 */
	@RequestMapping(value = "/listussdtransactionkeywords", method = RequestMethod.GET)
	public String listTransactionKeywords(Map<String, Object> map) {
		keywordStepsList.clear();
		map.put("ussdTransactionKeyword", new UssdTransactionKeyword());
		map.put("ussdTransactionKeywordList",
				ussdMenuService.listTransactionKeywords());
		return "listussdtransactionkeywords";
	}

	/**
	 * Retrieves "Add New Transaction Keyword" page
	 */
	@RequestMapping(value = "/addussdtransactionkeyword", method = RequestMethod.GET)
	public ModelAndView getTransactionKeyword(
			@ModelAttribute("ussdTransactionKeyword") UssdTransactionKeyword transactionKeyword) {
		return new ModelAndView("addussdtransactionkeyword",
				"ussdTransactionKeyword", new UssdTransactionKeyword());
	}

	/**
	 * Retrieves "Add New Keyword Step" page
	 */
	@RequestMapping(value = "/addnewussdkeywordstep", method = RequestMethod.GET)
	public String addKeywordStepLink(Map<String, Object> map) {
		map.put("ussdKeywordStep", new UssdKeywordStep());
		return "addnewussdkeywordstep";
	}

	/**
	 * Add New Keyword Step to transaction Keyword
	 */
	@RequestMapping(value = "/addussdkeywordstep", method = RequestMethod.POST)
	public String addKeywordStep(
			@ModelAttribute("ussdKeywordStep") UssdKeywordStep keywordStep,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(keywordStep, result);
		if (result.hasErrors()) {
			return "addnewussdkeywordstep";
		} else {
			UssdTransactionKeyword transactionKeyword = new UssdTransactionKeyword();
			if (keywordStepsSet.add(keywordStep) == true) {
				if (keywordStep != null) {
					try {
						keywordStepsList.add(keywordStep);
						transactionKeyword.setKeywordSteps(keywordStepsList);
					} catch (Exception e) {
						e.printStackTrace();
						return "redirect:/listussdtransactionkeywords.html";
					}
				}
			}
			map.put("ussdTransactionKeyword", transactionKeyword);
			return "addussdtransactionkeyword";
		}
	}

	@RequestMapping(value = "/addussdtransactionkeyword", method = RequestMethod.POST)
	public String addUssdTransactionKeyword(
			@ModelAttribute("ussdTransactionKeyword") UssdTransactionKeyword transactionKeyword,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(transactionKeyword, result);
		if (result.hasErrors()) {
			return "addussdtransactionkeyword";
		}

		if (transactionKeyword != null) {

			if (null != keywordStepsList && keywordStepsList.size() > 0) {

				for (UssdKeywordStep keywordStep : keywordStepsList) {
					keywordStep.setTransactionKeyword(transactionKeyword);
					if (keywordStep.getHasPredefInputFlag() != 1) {
						keywordStep.setHasPredefInputFlag(0);
						keywordStep.setPredefInput(null);
					}
					if (keywordStep.getIsFirstStepFlag() != 1) {
						keywordStep.setIsFirstStepFlag(0);
					}
					if (keywordStep.getIsLastStepFlag() != 1) {
						keywordStep.setIsLastStepFlag(0);
					}
					if (keywordStep.getUseFixedValueFlag() != 1) {
						keywordStep.setUseFixedValueFlag(0);
					}
				}
			}
			transactionKeyword.setKeywordSteps(keywordStepsList);
			ussdMenuService.addTransactionKeyword(transactionKeyword);
		}
		if (!keywordStepsList.isEmpty()) {
			keywordStepsList.clear();
		}
		map.put("ussdTransactionKeyword", new UssdTransactionKeyword());
		map.put("ussdTransactionKeywordList",
				ussdMenuService.listTransactionKeywords());

		return "listussdtransactionkeywords";
	}

	/**
	 * Retrieves the "Edit Existing Transaction Keyword" page
	 */
	@RequestMapping(value = "/editussdtransactionkeyword/{keywordId}", method = RequestMethod.GET)
	public String retrieveExistingTransactionKeyword(
			@PathVariable long keywordId, Map<String, Object> map) {

		UssdTransactionKeyword existingTransactionKeyword = ussdMenuService
				.getExistingTransactionKeyword(keywordId);

		map.put("ussdTransactionKeyword", existingTransactionKeyword);
		return "editussdtransactionkeyword";
	}

	/**
	 * Retrieves the "Add Keyword Step to Existing Transaction Keyword" Page
	 */
	@RequestMapping(value = "/editaddnewussdkeywordstep/{keywordId}", method = RequestMethod.GET)
	public String addKeywordStepOnEditLink(@PathVariable long keywordId,
			Map<String, Object> map) {
		map.put("ussdKeywordStep", new UssdKeywordStep());
		map.put("keywordId", keywordId);
		return "editaddnewussdkeywordstep";
	}

	/**
	 * Retrieves the "Edit Existing Keyword Step" page
	 */
	@RequestMapping(value = "/editussdkeywordstep/{keywordStepId}", method = RequestMethod.GET)
	public String retrieveEditKeywordStepPage(@PathVariable Long keywordStepId,
			Map<String, Object> map) {
		UssdKeywordStep existingKeywordStep = ussdMenuService
				.getExistingKeywordStep(keywordStepId);

		map.put("ussdKeywordStep", existingKeywordStep);
		return "editussdkeywordstep";
	}

	/**
	 * Retrieves the "Edit Existing Transaction Keyword" page after editing a
	 * keyword step
	 */
	@RequestMapping(value = "/editussdkeywordstep/{keywordStepId}", method = RequestMethod.POST)
	public String addEditedKeywordStep(@PathVariable Long keywordStepId,
			@ModelAttribute("ussdKeywordStep") UssdKeywordStep keywordStep,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(keywordStep, result);
		if (result.hasErrors()) {
			return "redirect:/editussdkeywordstep/" + keywordStepId + ".html";
		} else {
			keywordStep.setKeywordStepId(keywordStepId);

			if (keywordStep.getIsFirstStepFlag() == null) {
				keywordStep.setIsFirstStepFlag(0);
			}
			if (keywordStep.getIsLastStepFlag() == null) {
				keywordStep.setIsLastStepFlag(0);
			}
			if (keywordStep.getHasPredefInputFlag() == null) {
				keywordStep.setHasPredefInputFlag(0);
			}
			if (keywordStep.getUseFixedValueFlag() == null) {
				keywordStep.setUseFixedValueFlag(0);
			}
			UssdPredefInput predefInput = ussdMenuService
					.getExistingPredefInput(keywordStep.getPredefInput()
							.getPredefInputId());
			keywordStep.setPredefInput(predefInput);
			ussdMenuService.editExistingKeywordStep(keywordStep);
			keywordStepsList = ussdMenuService
					.listKeywordStepByKeywordId(keywordStep
							.getTransactionKeyword().getKeywordId());
			UssdTransactionKeyword existingTransactionKeyword = ussdMenuService
					.getExistingTransactionKeyword(keywordStep
							.getTransactionKeyword().getKeywordId());
			map.put("keywordStepsList", keywordStepsList);
			map.put("ussdTransactionKeyword", existingTransactionKeyword);
			return "editussdtransactionkeyword";
		}
	}

	/**
	 * Retrieves the "Edit Existing Transaction Keyword" page after adding a new
	 * step
	 * 
	 */
	@RequestMapping(value = "/editaddnewussdkeywordstep/{keywordId}", method = RequestMethod.POST)
	public String addNewKeywordStepOnEdit(@PathVariable Long keywordId,
			@ModelAttribute("ussdKeywordStep") UssdKeywordStep keywordStep,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(keywordStep, result);
		if (result.hasErrors()) {
			return "editaddnewussdkeywordstep";
		}

		keywordStepsList = ussdMenuService
				.listKeywordStepByKeywordId(keywordId);
		List<UssdKeywordStep> keywordsLinkedToPredefInput = new ArrayList<UssdKeywordStep>();
		UssdPredefInput linkedPredefInput = new UssdPredefInput();
		if (keywordStep.getPredefInput().getPredefInputId() != 0) {
			linkedPredefInput = ussdMenuService
					.getExistingPredefInput(keywordStep.getPredefInput()
							.getPredefInputId());
			if (linkedPredefInput != null) {
				keywordsLinkedToPredefInput = ussdMenuService
						.getKeywordsLinkedToThisPredefInput(keywordStep
								.getPredefInput().getPredefInputId());
				if (keywordsLinkedToPredefInput.isEmpty()) {
					keywordsLinkedToPredefInput = new ArrayList<UssdKeywordStep>();
				}
				keywordStep.setPredefInput(linkedPredefInput);
			}
		}

		UssdTransactionKeyword existingTransactionKeyword = ussdMenuService
				.getExistingTransactionKeyword(keywordId);
		keywordStep.setTransactionKeyword(existingTransactionKeyword);

		if ((keywordStep.getHasPredefInputFlag() == null)
				|| (keywordStep.getHasPredefInputFlag() != 1)) {
			keywordStep.setHasPredefInputFlag(0);
			keywordStep.setPredefInput(null);
		} else if (keywordStep.getHasPredefInputFlag() == 1) {
			keywordStep.setHasPredefInputFlag(1);
		} else if ((keywordStep.getIsFirstStepFlag() == null)
				|| (keywordStep.getIsFirstStepFlag() != 1)) {
			keywordStep.setIsFirstStepFlag(0);
		} else if (keywordStep.getIsFirstStepFlag() == 1) {
			keywordStep.setIsFirstStepFlag(1);
		} else if ((keywordStep.getIsLastStepFlag() == null)
				|| (keywordStep.getIsLastStepFlag() != 1)) {
			keywordStep.setIsLastStepFlag(0);
		} else if (keywordStep.getIsLastStepFlag() == 1) {
			keywordStep.setIsLastStepFlag(1);
		} else if ((keywordStep.getUseFixedValueFlag() == null)
				|| (keywordStep.getUseFixedValueFlag() != 1)) {
			keywordStep.setUseFixedValueFlag(0);
			keywordStep.setFixedValue(null);
		} else if (keywordStep.getUseFixedValueFlag() == 1) {
			keywordStep.setUseFixedValueFlag(1);
		}

		if (null == keywordStepsList) {
			keywordStepsList = new ArrayList<UssdKeywordStep>();
		}

		if (keywordStepsList != null) {
			keywordStepsList.add(keywordStep);

			if (linkedPredefInput != null) {
				for (UssdKeywordStep linkedKeywordStep : keywordStepsList) {
					if (null != (linkedKeywordStep.getPredefInput())) {
						keywordsLinkedToPredefInput.add(linkedKeywordStep);
					}
				}
				if (null != keywordsLinkedToPredefInput) {
					if (null != linkedPredefInput) {
						linkedPredefInput
								.setKeywordSteps(keywordsLinkedToPredefInput);
					}
				}
			}
			existingTransactionKeyword.setKeywordSteps(keywordStepsList);
		}
		map.put("ussdTransactionKeyword", existingTransactionKeyword);
		map.put("keywordId", keywordId);
		return "editussdtransactionkeyword";
	}

	/**
	 * Commit changes to an existing transaction keyword
	 */
	@RequestMapping(value = "/editussdtransactionkeyword/{keywordId}", method = RequestMethod.POST)
	public String postChangesToTransactionKeyword(
			@PathVariable Long keywordId,
			@ModelAttribute("ussdTransactionKeyword") UssdTransactionKeyword transactionKeyword,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(transactionKeyword, result);
		if (result.hasErrors()) {
			return "editussdtransactionkeyword";
		}

		// Assign id
		transactionKeyword.setKeywordId(keywordId);

		keywordStepsList = transactionKeyword.getKeywordSteps();
		if (keywordStepsList != null && keywordStepsList.size() > 0) {
			for (UssdKeywordStep keywordStep : keywordStepsList) {
				keywordStep.setTransactionKeyword(transactionKeyword);
				if ((keywordStep.getHasPredefInputFlag() != 1)
						|| (keywordStep.getHasPredefInputFlag() == null)) {
					keywordStep.setHasPredefInputFlag(0);
					UssdPredefInput predefInput = new UssdPredefInput();
					keywordStep.setPredefInput(predefInput);
				} else if (keywordStep.getHasPredefInputFlag() == 1) {
					keywordStep.setHasPredefInputFlag(1);
				} else if ((keywordStep.getIsFirstStepFlag() == null)
						|| (keywordStep.getIsFirstStepFlag() != 1)) {
					keywordStep.setIsFirstStepFlag(0);
				} else if (keywordStep.getIsFirstStepFlag() == 1) {
					keywordStep.setIsFirstStepFlag(1);
				} else if ((keywordStep.getIsLastStepFlag() == null)
						|| (keywordStep.getIsLastStepFlag() != 1)) {
					keywordStep.setIsLastStepFlag(0);
				} else if (keywordStep.getIsLastStepFlag() == 1) {
					keywordStep.setIsLastStepFlag(1);
				} else if ((keywordStep.getUseFixedValueFlag() == null)
						|| (keywordStep.getUseFixedValueFlag() != 1)) {
					keywordStep.setUseFixedValueFlag(0);
					keywordStep.setFixedValue(null);
				} else if (keywordStep.getUseFixedValueFlag() == 1) {
					keywordStep.setUseFixedValueFlag(1);
				}
			}
			transactionKeyword.setKeywordSteps(keywordStepsList);
		}
		ussdMenuService.editExistingTransactionKeyword(transactionKeyword);
		if (!(keywordStepsList.isEmpty())) {
			keywordStepsList.clear();
		}
		map.put("ussdTransactionKeyword", new UssdTransactionKeyword());
		return "redirect:/listussdtransactionkeywords.html";
	}

	@RequestMapping(value = "/activatekeyword/{keywordId}")
	public String activateTransactionKeyword(
			@PathVariable Long keywordId,
			@ModelAttribute("ussdTransactionKeyword") UssdTransactionKeyword transactionKeyword,
			Map<String, Object> map) {

		// Assign id
		transactionKeyword.setKeywordId(keywordId);
		ussdMenuService.activateExistingKeyword(keywordId);

		map.put("ussdTransactionKeyword", new UssdTransactionKeyword());
		map.put("ussdTransactionKeywordList",
				ussdMenuService.listTransactionKeywords());
		return "redirect:/listussdtransactionkeywords.html";
	}

	@RequestMapping(value = "/deactivatekeyword/{keywordId}")
	public String deactivateTransactionKeyword(
			@PathVariable Long keywordId,
			@ModelAttribute("ussdTransactionKeyword") UssdTransactionKeyword transactionKeyword,
			Map<String, Object> map) {

		// Assign id
		transactionKeyword.setKeywordId(keywordId);
		ussdMenuService.deactivateExistingKeyword(keywordId);
		map.put("ussdTransactionKeyword", new UssdTransactionKeyword());
		map.put("ussdTransactionKeywordList",
				ussdMenuService.listTransactionKeywords());
		return "redirect:/listussdtransactionkeywords.html";
	}

	@RequestMapping("/removekeyword/{keywordId}")
	public String deleteUssdTransactionKeyword(
			@PathVariable("keywordId") Long keywordId, Map<String, Object> map) {
		ussdMenuService.deleteTransactionKeyword(keywordId);
		map.put("ussdTransactionKeyword", new UssdTransactionKeyword());
		map.put("ussdTransactionKeywordList",
				ussdMenuService.listTransactionKeywords());
		return "redirect:/listussdtransactionkeywords.html";
	}

	/**
	 * Delete an existing keyword step
	 */
	@RequestMapping(value = "/removekeywordstep/{keywordStepId}", method = RequestMethod.GET)
	public String deleteUssdKeywordStep(
			@PathVariable("keywordStepId") Long keywordStepId,
			Map<String, Object> map) {

		UssdKeywordStep keywordStep = ussdMenuService
				.getExistingKeywordStep(keywordStepId);
		UssdTransactionKeyword transactionKeyword = keywordStep
				.getTransactionKeyword();

		UssdPredefInput predefInput = keywordStep.getPredefInput();
		if (predefInput != null) {
			predefInput.getKeywordSteps().remove(keywordStep);
		}
		transactionKeyword.getKeywordSteps().remove(keywordStep);

		Long transactionKeywordId = keywordStep.getTransactionKeyword()
				.getKeywordId();

		// Delegate to service
		ussdMenuService.deleteExistingKeywordStep(keywordStepId);
		map.put("ussdTransactionKeyword", transactionKeyword);
		map.put("ussdKeywordStepsList", transactionKeyword.getKeywordSteps());
		return "redirect:/editussdtransactionkeyword/" + transactionKeywordId
				+ ".html";
	}

	/**
	 * Ussd Menu Items mapping functions Function lists configured Ussd Menu
	 * Items"
	 */
	@RequestMapping("/listussdmenuitems")
	public String listMenuItems(Map<String, Object> map) {
		map.put("ussdMenuItem", new UssdMenuItem());
		map.put("ussdMenuItemsList", ussdMenuService.listMenuItems());
		map.put("ussdTransactionKeywordsList",
				ussdMenuService.listTransactionKeywords());
		return "listussdmenuitems";
	}

	@RequestMapping(value = "/addussdmenuitem", method = RequestMethod.GET)
	public String addUssdMenuItemLink(Map<String, Object> map) {
		map.put("ussdMenuItem", new UssdMenuItem());
		return "addussdmenuitem";
	}

	@RequestMapping(value = "/addussdmenuitem", method = RequestMethod.POST)
	public String addUssdMenuItem(
			@ModelAttribute("ussdMenuItem") UssdMenuItem menuItem,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(menuItem, result);
		if (result.hasErrors()) {
			return "addussdmenuitem";
		}

		List<UssdMenuItem> childMenuItemsList = new ArrayList<UssdMenuItem>();
		Set<UssdMenuItem> childMenuItemsSet = new HashSet<UssdMenuItem>();
		UssdTransactionKeyword menuItemKeyword = new UssdTransactionKeyword();
		if ((menuItem.getMenuItemKeyword().getKeywordId() == null)
				|| (menuItem.getMenuItemKeyword().getKeywordId() == 0)) {
			menuItemKeyword = ussdMenuService
					.getExistingTransactionKeyword((long) 0);
		} else {
			menuItemKeyword = ussdMenuService
					.getExistingTransactionKeyword(menuItem
							.getMenuItemKeyword().getKeywordId());
		}
		if (menuItemKeyword != null) {
			menuItemKeyword.getMenuItems().add(menuItem);
			menuItem.setMenuItemKeyword(menuItemKeyword);
		}

		/** Get all this menu's child menu Items */
		UssdMenuItem rootMenuItem = ussdMenuService
				.getExistingMenuItem(menuItem.getRootMenuItem().getMenuItemId());
		childMenuItemsList = ussdMenuService
				.getChildMenuItemsForParentMenuItem(rootMenuItem);

		if (childMenuItemsSet.add(menuItem) == true) {
			childMenuItemsList.add(menuItem);
		}

		rootMenuItem.setMenuItems(childMenuItemsList);
		menuItem.setRootMenuItem(rootMenuItem);

		if ((menuItem.getMenuItemEnabledFlag() == null)
				|| (menuItem.getMenuItemEnabledFlag() != 1)) {
			menuItem.setMenuItemEnabledFlag(0);
		}

		ussdMenuService.addMenuItem(menuItem);
		if (!childMenuItemsList.isEmpty()) {
			childMenuItemsList.clear();
		}
		return "redirect:/listussdmenuitems.html";
	}

	/**
	 * Retrieves the "Edit Existing Menu Item" page
	 */
	@RequestMapping(value = "/editussdmenuitem/{menuItemId}", method = RequestMethod.GET)
	public String retrieveExistingMenuItem(@PathVariable Long menuItemId,
			Map<String, Object> map) {

		UssdMenuItem existingMenuItem = ussdMenuService
				.getExistingMenuItem(menuItemId);

		map.put("ussdMenuItem", existingMenuItem);
		return "editussdmenuitem";
	}

	/**
	 * Commit changes to an existing Menu Item
	 */
	@RequestMapping(value = "/editussdmenuitem/{menuItemId}", method = RequestMethod.POST)
	public String postChangesToMenuItem(@PathVariable Long menuItemId,
			@ModelAttribute("ussdMenuItem") UssdMenuItem menuItem,
			BindingResult result, Map<String, Object> map) {

		ussdMenuValidator.validate(menuItem, result, menuItemId);
		if (result.hasErrors()) {
			map.put("menuItemId", menuItemId);
			return "editussdmenuitem";
		}

		// Assign id
		menuItem.setMenuItemId(menuItemId);

		List<UssdMenuItem> childMenuItemsList = new ArrayList<UssdMenuItem>();
		Set<UssdMenuItem> childMenuItemsSet = new HashSet<UssdMenuItem>();

		UssdTransactionKeyword menuItemKeyword = new UssdTransactionKeyword();

		if ((menuItem.getMenuItemKeyword().getKeywordId() == null)
				|| (menuItem.getMenuItemKeyword().getKeywordId() == 0)) {
			menuItemKeyword = ussdMenuService
					.getExistingTransactionKeyword((long) 0);
		} else {
			menuItemKeyword = ussdMenuService
					.getExistingTransactionKeyword(menuItem
							.getMenuItemKeyword().getKeywordId());
		}

		menuItemKeyword.getMenuItems().add(menuItem);
		menuItem.setMenuItemKeyword(menuItemKeyword);

		/** Get all this menu's child menu Items */
		UssdMenuItem rootMenuItem = ussdMenuService
				.getExistingMenuItem(menuItem.getRootMenuItem().getMenuItemId());
		childMenuItemsList = ussdMenuService
				.getChildMenuItemsForParentMenuItem(rootMenuItem);

		if (rootMenuItem == menuItem) {
			if (childMenuItemsSet.add(menuItem) == true) {
				childMenuItemsList.add(menuItem);
			}
			rootMenuItem.setMenuItems(childMenuItemsList);
			menuItem.setRootMenuItem(rootMenuItem);
		}

		if ((menuItem.getMenuItemEnabledFlag() == null)
				|| (menuItem.getMenuItemEnabledFlag() != 1)) {
			menuItem.setMenuItemEnabledFlag(0);
		}
		ussdMenuService.editExistingMenuItem(menuItem);
		return "redirect:/listussdmenuitems.html";
	}

	@RequestMapping(value = "/activatemenuitem/{menuItemId}")
	public String activateMenuItem(@PathVariable Long menuItemId,
			@ModelAttribute("ussdMenuItem") UssdMenuItem menuItem,
			Map<String, Object> map) {

		// Assign id
		menuItem.setMenuItemId(menuItemId);
		ussdMenuService.activateExistingMenuItem(menuItemId);

		map.put("ussdMenuItem", new UssdMenuItem());
		map.put("ussdMenuItemsList", ussdMenuService.listMenuItems());
		map.put("ussdTransactionKeywordsList",
				ussdMenuService.listTransactionKeywords());
		return "redirect:/listussdmenuitems.html";
	}

	@RequestMapping(value = "/deactivatemenuitem/{menuItemId}")
	public String deactivateMenuItem(@PathVariable Long menuItemId,
			@ModelAttribute("ussdMenuItem") UssdMenuItem menuItem,
			Map<String, Object> map) {

		// Assign id
		menuItem.setMenuItemId(menuItemId);
		ussdMenuService.deactivateExistingMenuItem(menuItemId);
		map.put("ussdMenuItem", new UssdMenuItem());
		map.put("ussdMenuItemsList", ussdMenuService.listMenuItems());
		map.put("ussdTransactionKeywordsList",
				ussdMenuService.listTransactionKeywords());
		return "redirect:/listussdmenuitems.html";
	}

	@RequestMapping("/removemenuitem/{menuItemId}")
	public String deleteUssdMenuItem(
			@PathVariable("menuItemId") Long menuItemId, Map<String, Object> map) {

		ussdMenuService.deleteMenuItem(menuItemId);

		map.put("ussdMenuItem", new UssdMenuItem());
		map.put("ussdMenuItemsList", ussdMenuService.listMenuItems());
		map.put("ussdTransactionKeywordsList",
				ussdMenuService.listTransactionKeywords());
		return "redirect:/listussdmenuitems.html";
	}

	/**
	 * Create model attributes for linking across models
	 */
	@ModelAttribute("predefInputList")
	public List<UssdPredefInput> populatePredefInputList() {
		return ussdMenuService.listPredefInputs();
	}

	@ModelAttribute("transactionKeywordList")
	public List<UssdTransactionKeyword> populateTransactionKeywordsList() {
		return ussdMenuService.listTransactionKeywords();
	}

	@ModelAttribute("keywordStepList")
	public List<UssdKeywordStep> populateKeywordStepsList() {
		return ussdMenuService.listKeywordSteps();
	}

	@ModelAttribute("menuItemList")
	public List<UssdMenuItem> populateMenuItemList() {
		return ussdMenuService.listMenuItems();
	}
}