package metomeui.validator;

import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInputItem;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("ussdPredefInputItemValidator")
public class UssdPredefInputItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UssdPredefInputItem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UssdPredefInputItem ussdPredefInputItem = (UssdPredefInputItem) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"predefInputItemName", "predefInputItemName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"predefInputItemCode", "predefInputItemCode.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"predefInputItemOrder", "predefInputItemOrder.required");
		if (ussdPredefInputItem.getPredefInputId() == 0) {
			errors.rejectValue("predefInputId", "predefInputId.required");
		}	
	}
}
