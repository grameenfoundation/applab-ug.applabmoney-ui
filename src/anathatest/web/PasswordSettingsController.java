package anathatest.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import anathatest.model.PasswordSettings;
import anathatest.validator.PasswordSettingsValidator;

@Controller
@RequestMapping("/auilanding.html")
public class PasswordSettingsController {

	private static Logger logger = Logger
			.getLogger(PasswordSettingsController.class);

	@Autowired
    private PasswordSettingsValidator passwordSettingsValidator;

    public void setPasswordSettingsValidator(
    		PasswordSettingsValidator passwordSettingsValidator) {
            this.passwordSettingsValidator = passwordSettingsValidator;
    }

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, PasswordSettings> model) {
		PasswordSettings passwordSettings = new PasswordSettings();
		model.put("passwordSettings", passwordSettings);
		return "auilanding";
	}

	@RequestMapping(method = RequestMethod.POST)
		public String processForm(@Valid PasswordSettings passwordSettings, BindingResult results, Map<String, PasswordSettings> model) {
				passwordSettingsValidator.validate(passwordSettings, results);
			//passwordSettings = (PasswordSettings) model.get("passwordSettings");
			if (results.hasErrors()) {
				return "auilanding";
			}
		
				model.put("passwordSettings", passwordSettings);
				logger.info("Successful Login!! Now onto landing Page!!");
				return "loginsuccess";
		}
	
	@ModelAttribute("precedenceList")
	public Map<Integer, Integer> populatePrecedenceList() {

		// Data referencing for prefernce list box
		Map<Integer, Integer> precedence = new LinkedHashMap<Integer, Integer>();
		precedence.put(0, 0);
		precedence.put(1, 1);
		precedence.put(2, 2);
		precedence.put(3, 3);

		return precedence;
	}

	@ModelAttribute("minPasswordLengthList")
	public Map<Integer, Integer> populateMinPasswordLengthList() {

		Map<Integer, Integer> minPasswordLength = new LinkedHashMap<Integer, Integer>();
		minPasswordLength.put(6, 6);
		minPasswordLength.put(7, 7);
		minPasswordLength.put(8, 8);
		minPasswordLength.put(9, 9);

		return minPasswordLength;
	}

	@ModelAttribute("maxPasswordLengthList")
	public Map<Integer, Integer> populateMaxPasswordLengthList() {

		Map<Integer, Integer> maxPasswordLength = new LinkedHashMap<Integer, Integer>();
		maxPasswordLength.put(9, 9);
		maxPasswordLength.put(10, 10);
		maxPasswordLength.put(11, 11);
		maxPasswordLength.put(12, 12);

		return maxPasswordLength;
	}

	@ModelAttribute("minPasswordAgeList")
	public Map<Integer, Integer> populateMinPasswordAgeList() {

		// Data referencing for prefernce list box
		Map<Integer, Integer> minPasswordAge = new LinkedHashMap<Integer, Integer>();
		minPasswordAge.put(1, 1);
		minPasswordAge.put(5, 5);
		minPasswordAge.put(10, 10);
		minPasswordAge.put(30, 30);

		return minPasswordAge;
	}

	@ModelAttribute("maxPasswordAgeList")
	public Map<Integer, Integer> populateMaxPasswordAgeList() {

		Map<Integer, Integer> maxPasswordAge = new LinkedHashMap<Integer, Integer>();
		maxPasswordAge.put(1, 1);
		maxPasswordAge.put(5, 5);
		maxPasswordAge.put(10, 10);
		maxPasswordAge.put(30, 30);

		return maxPasswordAge;
	}

	@ModelAttribute("resetFailedLogonTimerList")
	public Map<Integer, Integer> populateResetFailedLogonTimerList() {

		Map<Integer, Integer> resetFailedLogonTimer = new LinkedHashMap<Integer, Integer>();
		resetFailedLogonTimer.put(30, 30);
		resetFailedLogonTimer.put(60, 60);
		resetFailedLogonTimer.put(90, 90);
		resetFailedLogonTimer.put(120, 120);

		return resetFailedLogonTimer;
	}

	@ModelAttribute("loginAttemptCountList")
	public Map<Integer, Integer> populateLoginAttemptCountList() {

		Map<Integer, Integer> loginAttemptCount = new LinkedHashMap<Integer, Integer>();
		loginAttemptCount.put(0, 0);
		loginAttemptCount.put(1, 1);
		loginAttemptCount.put(2, 2);
		loginAttemptCount.put(3, 3);

		return loginAttemptCount;
	}

	@ModelAttribute("accountLockDurationList")
	public Map<Integer, Integer> populateAccountLockDurationList() {

		Map<Integer, Integer> accountLockDuration = new LinkedHashMap<Integer, Integer>();
		accountLockDuration.put(0, 0);
		accountLockDuration.put(1, 1);
		accountLockDuration.put(2, 2);
		accountLockDuration.put(3, 3);

		return accountLockDuration;
	}

}
