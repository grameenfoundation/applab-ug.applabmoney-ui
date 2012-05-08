package anathatest.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import anathatest.model.PasswordSettings;

@Component("passwordSettingsValidator")
public class PasswordSettingsValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PasswordSettings.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		PasswordSettings passwordSettings = (PasswordSettings) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"name.required");
		if (passwordSettings.getPrecedence() == 0){
			errors.rejectValue("precedence", "precedence.required");
		}
		if (passwordSettings.getEnforcePasswordComplexityRequirements() == true) {
			if (passwordSettings.getEnforceMinPasswordLength() == true) {
				if (passwordSettings.getMinPasswordLength().intValue() == 0){
					errors.rejectValue("minPasswordLength", "minPasswordLength.required");
				}
			}
			if (passwordSettings.getEnforceMaxPasswordLength() == true) {
				if (passwordSettings.getMaxPasswordLength().intValue() == 0){
					errors.rejectValue("maxPasswordLength", "maxPasswordLength.required");
				}
			}
			if (passwordSettings.getEnforceMaxPasswordAge() == true) {
				if (passwordSettings.getMaxPasswordAge().intValue() == 0){
					errors.rejectValue("maxPasswordAge", "maxPasswordAge.required");
				} 
			}
			if (passwordSettings.getEnforceMinPasswordAge() == true) {
				if (passwordSettings.getMinPasswordAge().intValue() == 0){
					errors.rejectValue("minPasswordAge", "minPasswordAge.required");
				} 
			}
		}
		if (passwordSettings.getEnforceLockoutPolicy() == true) {
			if (passwordSettings.getMinPasswordLength().intValue() == 0){
				errors.rejectValue("failedLoginResetCount", "failedLoginResetCount.required");
			} 
			if (passwordSettings.getMinPasswordLength().intValue() == 0){
				errors.rejectValue("maxFailedLoginCount", "maxFailedLoginCount.required");
			} 
		}
		if (passwordSettings.getAccountTimedUnlock() == true) {
			if (passwordSettings.getAccountLockDuration().intValue() == 0){
				errors.rejectValue("accountLockDuration", "accountLockDuration.required");
			} 
		}
	}
}
