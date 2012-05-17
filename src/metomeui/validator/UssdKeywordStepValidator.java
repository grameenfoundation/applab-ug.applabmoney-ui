package metomeui.validator;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("ussdKeywordStepValidator")
public class UssdKeywordStepValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UssdKeywordStep.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UssdKeywordStep ussdKeywordStep = (UssdKeywordStep) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stepMenuName",
				"stepMenuName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stepMenuNumber",
				"stepMenuNumber.required");
		if (ussdKeywordStep.getUseFixedValueFlag() == 1) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fixedValue",
					"fixedValue.required");
		}
		if (ussdKeywordStep.getHasPredefInputFlag() == 1) {
			if (ussdKeywordStep.getPredefInputId().equalsIgnoreCase(null)) {
				errors.rejectValue("predefInputId", "predefInputId.required");
			}
		}
		
		if (ussdKeywordStep.getIsFirstStepFlag().equals(1)) {
			if (ussdKeywordStep.getIsLastStepFlag().equals(1)) {
				errors.reject("stepPosition.required");
			}
		}

		// if (ussdMenuItem.getMenuItemName().equalsIgnoreCase(null)) {
		// errors.rejectValue("menuItemName", "menuItemName.wrongformat");
		// }
		// if (ussdMenuItem.getMenuItemOrder().(null)) {
		// errors.rejectValue("menuItemName", "menuItemName.wrongformat");
		// }
	}
}
