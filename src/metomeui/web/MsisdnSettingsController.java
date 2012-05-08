package metomeui.web;

import java.util.Map;

import javax.validation.Valid;

import metomeui.model.MsisdnSettings;
import metomeui.model.PasswordSettings;
import metomeui.validator.MsisdnSettingsValidator;
import metomeui.validator.PasswordSettingsValidator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auimsisdnsettings.html")
public class MsisdnSettingsController {
	
	private static Logger logger = Logger
			.getLogger(MsisdnSettingsController.class);

	@Autowired
    private MsisdnSettingsValidator msisdnSettingsValidator;

    public void setMsisdnSettingsValidator(
    		MsisdnSettingsValidator msisdnSettingsValidator) {
            this.msisdnSettingsValidator = msisdnSettingsValidator;
    }

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, MsisdnSettings> model) {
		MsisdnSettings msisdnSettings = new MsisdnSettings();
		model.put("msisdnSettings", msisdnSettings);
		return "auimsisdnsettings";
	}

	@RequestMapping(method = RequestMethod.POST)
		public String processForm(@Valid MsisdnSettings msisdnSettings, BindingResult results, Map<String, MsisdnSettings> model) {
				msisdnSettingsValidator.validate(msisdnSettings, results);
			//passwordSettings = (PasswordSettings) model.get("passwordSettings");
			if (results.hasErrors()) {
				return "auimsisdnsettings";
			}
		
				model.put("msisdnSettings", msisdnSettings);
				logger.info("Successful Login!! Now onto landing Page!!");
				return "loginsuccess";
		}


}
