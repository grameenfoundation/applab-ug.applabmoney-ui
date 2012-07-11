package metomeui.validator;

import metomeui.model.MsisdnSettings;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

@Component("msisdnSettingsValidator")
public class MsisdnSettingsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MsisdnSettings.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		MsisdnSettings msisdnSettings = (MsisdnSettings) target;
		if (msisdnSettings.getMsisdnLength() == 0) {
			errors.rejectValue("msisdnLength", "msisdnLength.required");
		}
		if (msisdnSettings.getCurrencyCode().equalsIgnoreCase("None")) {
			errors.rejectValue("currencyCode", "currencyCode.required");
		}
	}
}
