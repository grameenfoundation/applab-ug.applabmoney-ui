package metomeui.web;

import java.util.List;
import java.util.Map;

import metomeui.model.AccountType;
import metomeui.model.Customer;
import metomeui.model.UssdPredefInput;
import metomeui.service.SystemSettingsService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ChargeSetupController {

/*
	@Autowired
	private SystemSettingsService chargeSetupService;
	
	@RequestMapping("/accounttypes")
	public String listAccountType(Map<String, Object> map) {
		map.put("accountTypes", new AccountType());
		map.put("accountTypesList", chargeSetupService.listAccountTypes());
		return "accounttypes";
	}
	
	@RequestMapping(value = "/addaccounttypes", method = RequestMethod.GET)
	public String addAccountType(Map<String, Object> map) {
		map.put("accounttype", new AccountType());
		return "addaccounttypes";
	}

	@RequestMapping(value = "/addaccounttypes", method = RequestMethod.POST)
	public String addAccountType(@ModelAttribute("accountType") AccountType accountType,
			BindingResult result) {
		chargeSetupService.addAccountType(accountType);
		return "redirect:/accounttypes.html";
	}

	@RequestMapping("/removeaccounttype/{accountTypeId}")
	public String deleteAccountType(@PathVariable("accountTypeId") Integer accountTypeId) {
		chargeSetupService.removeAccountType(accountTypeId);
		logger.info("Returning hello view");
		return "redirect:/accounttypes.html";
	}

	// Create model attributes for linking across models
	@ModelAttribute("accountTypeList")
	public List<AccountType> populateAccountTypeList() {
		return chargeSetupService.listAccountTypes();*/
	//}

}
