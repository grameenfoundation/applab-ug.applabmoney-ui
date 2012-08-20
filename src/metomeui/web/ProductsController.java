package metomeui.web;

import java.util.Map;

import metomeui.model.MeToMeGoalType;
import metomeui.model.MeToMeRewardType;
import metomeui.model.ZimbaConfiguration;
import metomeui.service.ProductsService;
import metomeui.service.ProductsServiceImplementation;
import metomeui.validator.ProductsValidator;

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
public class ProductsController {

	private static Logger logger = Logger.getLogger(ProductsController.class);

	@Autowired
	private ProductsValidator productsValidator;
	@Autowired
	ProductsService productsService = new ProductsServiceImplementation();

	@RequestMapping("/viewmetomesetup")
	public String viewMeToMeSetup(Map<String, Object> map) {
		map.put("meToMeGoalType", new MeToMeGoalType());
		map.put("meToMeGoalTypesList", productsService.listMeToMeGoalTypes());
		map.put("meToMeRewardType", new MeToMeRewardType());
		map.put("meToMeRewardTypesList",
				productsService.listMeToMeRewardTypes());
		return "viewmetomesetup";
	}

	/**
	 * Retrieves "Add New Me2Me Goal Type" page
	 */
	@RequestMapping(value = "/addmetomegoaltype", method = RequestMethod.GET)
	public ModelAndView addMeToMeGoalTypeLink(
			@ModelAttribute("meToMeGoalType") MeToMeGoalType meToMeGoalType) {
		return new ModelAndView("addmetomegoaltype", "meToMeGoalType",
				new MeToMeGoalType());
	}

	/**
	 * Add New Me2Me Goal Type
	 */
	@RequestMapping(value = "/addmetomegoaltype", method = RequestMethod.POST)
	public String addMeToMeGoalType(
			@ModelAttribute("meToMeGoalType") MeToMeGoalType meToMeGoalType,
			BindingResult result, Map<String, Object> map) {

		/*
		 * productsValidator.validate(meToMeGoalType, result); if
		 * (result.hasErrors()) { return "addmetomegoaltype"; }
		 */

		if (meToMeGoalType != null) {
			productsService.addMeToMeGoalType(meToMeGoalType);
		}

		map.put("meToMeGoalType", new MeToMeGoalType());
		map.put("meToMeGoalTypesList", productsService.listMeToMeGoalTypes());
		return "redirect:/viewmetomesetup.html";
	}

	@RequestMapping(value = "/editmetomegoaltype/{goalTypeId}", method = RequestMethod.GET)
	public String editMeToMeGoalTypeLink(@PathVariable Long goalTypeId,
			Map<String, Object> map) {
		MeToMeGoalType existingMeToMeGoalType = productsService
				.getExistingMeToMeGoalType(goalTypeId);

		map.put("meToMeGoalType", existingMeToMeGoalType);
		return "editmetomegoaltype";
	}

	@RequestMapping(value = "/editmetomegoaltype/{goalTypeId}", method = RequestMethod.POST)
	public String CommitChangesToMeToMeGoalType(@PathVariable Long goalTypeId,
			@ModelAttribute("meToMeGoalType") MeToMeGoalType meToMeGoalType,
			BindingResult result, Map<String, Object> map) {

		productsValidator.validate(meToMeGoalType, result);
		if (result.hasErrors()) {
			return "editmetomegoaltype";
		}

		// Assign id
		meToMeGoalType.setGoalTypeId(goalTypeId);

		productsService.editExistingMeToMeGoalType(meToMeGoalType);
		map.put("meToMeGoalTypesList", productsService.listMeToMeGoalTypes());
		return "redirect:/viewmetomesetup.html";
	}

	@RequestMapping("/removemetomegoaltype/{goalTypeId}")
	public String deleteMeToMeGoalType(
			@PathVariable("goalTypeId") Long goalTypeId, Map<String, Object> map) {
		productsService.deleteExistingMeToMeGoalType(goalTypeId);
		map.put("meToMeGoalTypesList", productsService.listMeToMeGoalTypes());
		return "redirect:/viewmetomesetup.html";
	}

	/**
	 * Retrieves "Add New Me2Me Reward Type" page
	 */
	@RequestMapping(value = "/addmetomerewardtype", method = RequestMethod.GET)
	public ModelAndView addMeToMeRewardTypeLink(
			@ModelAttribute("meToMeRewardType") MeToMeRewardType meToMeRewardType) {
		return new ModelAndView("addmetomerewardtype", "meToMeRewardType",
				new MeToMeRewardType());
	}

	/**
	 * Add New Me2Me Goal Type
	 */
	@SuppressWarnings("null")
	@RequestMapping(value = "/addmetomerewardtype", method = RequestMethod.POST)
	public String addMeToMeRewardType(
			@ModelAttribute("meToMeRewardType") MeToMeRewardType meToMeRewardType,
			BindingResult result, Map<String, Object> map) {

		productsValidator.validate(meToMeRewardType, result);
		if (result.hasErrors()) {
			return "addmetomerewardtype";
		}

		if (meToMeRewardType.getCashRewardFlag() == null) {
			meToMeRewardType.setCashRewardFlag(0);
		}

		productsService.addMeToMeRewardType(meToMeRewardType);

		map.put("meToMeRewardType", new MeToMeRewardType());
		map.put("meToMeRewardTypesList",
				productsService.listMeToMeRewardTypes());
		return "redirect:/viewmetomesetup.html";
	}

	@RequestMapping(value = "/editmetomerewardtype/{rewardTypeId}", method = RequestMethod.GET)
	public String editMeToMeRewardTypeLink(@PathVariable Long rewardTypeId,
			Map<String, Object> map) {
		MeToMeRewardType existingMeToMeRewardType = productsService
				.getExistingMeToMeRewardType(rewardTypeId);

		map.put("meToMeRewardType", existingMeToMeRewardType);
		return "editmetomerewardtype";
	}

	@RequestMapping(value = "/editmetomerewardtype/{rewardTypeId}", method = RequestMethod.POST)
	public String CommitChangesToMeToMeRewardType(
			@PathVariable Long rewardTypeId,
			@ModelAttribute("meToMeRewardType") MeToMeRewardType meToMeRewardType,
			BindingResult result) {

		productsValidator.validate(meToMeRewardType, result);
		if (result.hasErrors()) {
			return "editmetomerewardtype";
		}

		// Assign id
		meToMeRewardType.setRewardTypeId(rewardTypeId);

		if (meToMeRewardType.getCashRewardFlag() == null) {
			meToMeRewardType.setCashRewardFlag(0);

		}

		productsService.editExistingMeToMeRewardType(meToMeRewardType);
		return "redirect:/viewmetomesetup.html";
	}

	@RequestMapping("/removemetomerewardtype/{rewardTypeId}")
	public String deleteMeToMeRewardType(
			@PathVariable("rewardTypeId") Long rewardTypeId) {
		productsService.deleteExistingMeToMeRewardType(rewardTypeId);
		return "redirect:/viewmetomesetup.html";
	}

	@RequestMapping("/viewzimbaconfiguration")
	public String viewZimbaConfiguration(Map<String, Object> map) {

		ZimbaConfiguration existingZimbaConfiguration = productsService
				.getZimbaConfiguration();
		if (null != existingZimbaConfiguration) {
			map.put("zimbaConfiguration", existingZimbaConfiguration);
			return "viewzimbaconfiguration";
		} else {
			map.put("zimbaConfiguration", new ZimbaConfiguration());
			return "redirect:/addzimbaconfiguration.html";
		}
	}

	@RequestMapping(value = "/addzimbaconfiguration", method = RequestMethod.GET)
	public String addZimbaConfigurationLink(Map<String, Object> map) {
		map.put("zimbaConfiguration", new ZimbaConfiguration());
		return "addzimbaconfiguration";
	}

	@RequestMapping(value = "/addzimbaconfiguration", method = RequestMethod.POST)
	public String addZimbaConfiguration(
			@ModelAttribute("zimbaConfiguration") ZimbaConfiguration zimbaConfiguration,
			BindingResult result) {
		productsValidator.validate(zimbaConfiguration, result);
		if (result.hasErrors()) {
			return "addzimbaconfiguration";
		}

		productsService.addZimbaConfiguration(zimbaConfiguration);
		return "redirect:/auilanding.html";
	}

	@RequestMapping(value = "/viewzimbaconfiguration", method = RequestMethod.POST)
	public String postChangesToZimbaConfiguration(
			@ModelAttribute("zimbaConfiguration") ZimbaConfiguration zimbaConfiguration,
			BindingResult result) {

		productsValidator.validate(zimbaConfiguration, result);
		if (result.hasErrors()) {
			return "viewzimbaconfiguration";
		}

		zimbaConfiguration.setConfigId((long) 1);
		productsService.editExistingZimbaConfiguration(zimbaConfiguration);
		return "redirect:/auilanding.html";
	}

}