package metomeui.validator;

import metomeui.dao.UssdMenuDao;
import metomeui.dao.UssdMenuDaoImplementation;
import metomeui.model.UssdKeywordStep;
import metomeui.service.UssdMenuService;
import metomeui.service.UssdMenuServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("ussdKeywordStepValidator")
public class UssdKeywordStepValidator implements Validator {

	@Autowired
	UssdMenuService ussdMenuService = new UssdMenuServiceImplementation();
	@Autowired
	UssdMenuDao ussdMenuDao = new UssdMenuDaoImplementation();

	@Override
	public boolean supports(Class<?> clazz) {
		return UssdKeywordStep.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors, Long keywordId) {

		UssdKeywordStep ussdKeywordStep = (UssdKeywordStep) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stepMenuName",
				"stepMenuName.required");

		if (keywordId != null) {
			if ((ussdKeywordStep.getStepMenuName() != null)
					|| (ussdKeywordStep.getStepMenuName() != "")) {
				if ((ussdMenuService.checkIfDuplicateStepMenuName(
						ussdKeywordStep.getStepMenuName(), keywordId)) == true) {
					errors.rejectValue("stepMenuName", "stepMenuName.duplicate");
				}
			}

			if (null == ussdKeywordStep.getStepMenuNumber()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,
						"stepMenuNumber", "stepMenuNumber.required");
			} else if ((null != ussdKeywordStep.getStepMenuNumber())
					|| (ussdKeywordStep.getStepMenuNumber().toString() != "")) {
				if ((ussdMenuDao.checkIfDuplicateStepMenuNumber(
						ussdKeywordStep.getStepMenuNumber(), keywordId)) == true) {
					errors.rejectValue("stepMenuNumber",
							"stepMenuNumber.duplicate");
				}	
				/**
				 * TODO: Add code to check if the user input is a number
				 *  
				 */
			}
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
		}

		if (ussdKeywordStep.getUseFixedValueFlag() == 1) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fixedValue",
					"fixedValue.required");
		}

		if ((ussdKeywordStep.getIsFirstStepFlag() == 1)
				&& (ussdKeywordStep.getIsLastStepFlag() == 1)) {
			errors.reject("stepPosition.required");
		}
	}

	@Override
	public void validate(Object target, Errors errors) {
		validate(target, errors, null);

	}
}
