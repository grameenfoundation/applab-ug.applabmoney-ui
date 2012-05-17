package metomeui.validator;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.web.HelloController;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("ussdKeywordStepValidator")
public class UssdKeywordStepValidator implements Validator {

	private static Logger logger = Logger
			.getLogger(UssdKeywordStepValidator.class);

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

		if (!(ussdKeywordStep.getStepMenuNumber() == null)) {
			if (UssdMenuValidator.check(ussdKeywordStep
					.getStepMenuNumber().toString())) {
				errors.rejectValue("stepMenuNumber",
						"stepMenuNumber.wrongformat");
			}
		}

		if (ussdKeywordStep.getKeywordId() == 0) {
			errors.rejectValue("keywordId", "keywordId.required");
		}

		if (ussdKeywordStep.getUseFixedValueFlag() == null) {
			ussdKeywordStep.setUseFixedValueFlag(0);
		}

		if (ussdKeywordStep.getIsFirstStepFlag() == null) {
			ussdKeywordStep.setIsFirstStepFlag(0);
		}

		if (ussdKeywordStep.getIsLastStepFlag() == null) {
			ussdKeywordStep.setIsLastStepFlag(0);
		}

		if (ussdKeywordStep.getHasPredefInputFlag() == null) {
			ussdKeywordStep.setHasPredefInputFlag(0);
			ussdKeywordStep.setPredefInputId(null);
		}

		if (ussdKeywordStep.getUseFixedValueFlag() == 1) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fixedValue",
					"fixedValue.required");
		}
		if (ussdKeywordStep.getHasPredefInputFlag() == 1) {
			if (ussdKeywordStep.getPredefInputId().equalsIgnoreCase(null)) {
				errors.rejectValue("predefInputId", "predefInputId.required");
			}
		}

		if ((ussdKeywordStep.getIsFirstStepFlag() == 1)
				&& (ussdKeywordStep.getIsLastStepFlag() == 1)) {
			errors.reject("stepPosition.required");
		}
	}
}
