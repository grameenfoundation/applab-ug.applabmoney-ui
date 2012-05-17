package metomeui.web;

import java.util.Map;

import javax.validation.Valid;

import metomeui.model.TransactionSettings;
import metomeui.validator.TransactionSettingsValidator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auitransactionsettings.html")
public class TransactionSettingsController {

	private static Logger logger = Logger
			.getLogger(TransactionSettingsController.class);

	@Autowired
	private TransactionSettingsValidator transactionSettingsValidator;

	public void setMsisdnSettingsValidator(
			TransactionSettingsValidator transactionSettingsValidator) {
		this.transactionSettingsValidator = transactionSettingsValidator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, TransactionSettings> model) {
		TransactionSettings transactionSettings = new TransactionSettings();
		model.put("transactionSettings", transactionSettings);
		return "auitransactionsettings";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid TransactionSettings transactionSettings,
			BindingResult results, Map<String, TransactionSettings> model) {
		transactionSettingsValidator.validate(transactionSettings, results);
		if (results.hasErrors()) {
			return "auitransactionsettings";
		}

		model.put("transactionSettings", transactionSettings);
		logger.info("Successful Login!! Now onto landing Page!!");
		return "loginsuccess";
	}

}
