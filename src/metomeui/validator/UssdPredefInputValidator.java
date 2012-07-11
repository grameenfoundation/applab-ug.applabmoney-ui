package metomeui.validator;

import metomeui.model.UssdPredefInput;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("ussdPredefInputValidator")
public class UssdPredefInputValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UssdPredefInput.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors, Long menuId) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "predefInputName",
				"predefInputName.required");
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		validate(target, errors, null);

	}
}
