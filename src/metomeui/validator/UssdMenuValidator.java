package metomeui.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import metomeui.dao.UssdMenuDao;
import metomeui.dao.UssdMenuDaoImplementation;
import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdTransactionKeyword;
import metomeui.service.UssdMenuService;
import metomeui.service.UssdMenuServiceImplementation;

@Component("ussdMenuValidator")
public class UssdMenuValidator implements Validator {

	@Autowired
	UssdMenuService ussdMenuService = new UssdMenuServiceImplementation();
	@Autowired
	UssdMenuDao ussdMenuDao = new UssdMenuDaoImplementation();

	@Override
	public boolean supports(Class<?> clazz) {
		return UssdMenuItem.class.isAssignableFrom(clazz)
				|| UssdPredefInput.class.isAssignableFrom(clazz)
				|| UssdPredefInputItem.class.isAssignableFrom(clazz)
				|| UssdTransactionKeyword.class.isAssignableFrom(clazz)
				|| UssdKeywordStep.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors, Long id) {
		if (target instanceof UssdMenuItem) {
			UssdMenuItem ussdMenuItem = (UssdMenuItem) target;
			Long menuItemId = id;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuItemName",
					"menuItemName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuItemOrder",
					"menuItemOrder.required");

			if (menuItemId != null) {
				if ((ussdMenuItem.getMenuItemName() != null)
						|| (ussdMenuItem.getMenuItemName() != "")) {
					if ((ussdMenuService.checkIfDuplicateMenuName(
							ussdMenuItem.getMenuItemName(), menuItemId)) == true) {
						errors.rejectValue("menuItemName",
								"menuItemName.duplicate");
					}
				}
			}
		} else if (target instanceof UssdPredefInputItem) {
			UssdPredefInputItem ussdPredefInputItem = (UssdPredefInputItem) target;
			Long predefInputId = id;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"predefInputItemName", "predefInputItemName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"predefInputItemCode", "predefInputItemCode.required");

			if (ussdPredefInputItem.getPredefInputItemCode().length() > 10) {
				errors.rejectValue("predefInputItemCode",
						"predefInputItemCode.lengthLimit");
			}
			if (null == ussdPredefInputItem.getPredefInputItemOrder()) {
				ValidationUtils
						.rejectIfEmptyOrWhitespace(errors,
								"predefInputItemOrder",
								"predefInputItemOrder.required");
			}
			if (predefInputId != null) {
				if ((ussdPredefInputItem.getPredefInputItemName() != null)
						|| (ussdPredefInputItem.getPredefInputItemName() != "")) {
					if ((ussdMenuService.checkIfDuplicateInputItemName(
							ussdPredefInputItem.getPredefInputItemName(),
							predefInputId)) == true) {
						errors.rejectValue("predefInputItemName",
								"predefInputItemName.duplicate");
					}
				}
				if ((ussdPredefInputItem.getPredefInputItemCode() != null)
						|| (ussdPredefInputItem.getPredefInputItemCode() != "")) {
					if ((ussdMenuService.checkIfDuplicateInputItemCode(
							ussdPredefInputItem.getPredefInputItemCode(),
							predefInputId)) == true) {
						errors.rejectValue("predefInputItemCode",
								"predefInputItemCode.duplicate");
					}
				}
				if ((ussdPredefInputItem.getPredefInputItemOrder() != null)
						|| (ussdPredefInputItem.getPredefInputItemOrder()
								.toString() != "")) {
					if ((ussdMenuService.checkIfDuplicateInputItemOrder(
							ussdPredefInputItem.getPredefInputItemOrder(),
							predefInputId)) == true) {
						errors.rejectValue("predefInputItemOrder",
								"predefInputItemOrder.duplicate");
					}
				}
			}
			if (ussdPredefInputItem.getPredefInputItemEnabledFlag() == null) {
				ussdPredefInputItem.setPredefInputItemEnabledFlag(0);
			}
		} else if (target instanceof UssdPredefInput) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"predefInputName", "predefInputName.required");
		} else if (target instanceof UssdTransactionKeyword) {
			UssdTransactionKeyword ussdTransactionKeyword = (UssdTransactionKeyword) target;

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "keywordName",
					"keywordName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "keywordCode",
					"keywordCode.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"keywordStepsCount", "keywordStepsCount.required");
			if (ussdTransactionKeyword.getKeywordEnabledFlag() == null) {
				ussdTransactionKeyword.setKeywordEnabledFlag(0);
			}
			if (ussdTransactionKeyword.getKeywordCode().length() > 10) {
				errors.rejectValue("keywordName", "keywordCode.lengthLimit");
			}
		} else if (target instanceof UssdKeywordStep) {
			UssdKeywordStep ussdKeywordStep = (UssdKeywordStep) target;
			Long keywordId = id;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stepMenuName",
					"stepMenuName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stepMenuNumber",
					"stepMenuNumber.required");

			if (keywordId != null) {
				if ((ussdKeywordStep.getStepMenuName() != null)
						|| (ussdKeywordStep.getStepMenuName() != "")) {
					if ((ussdMenuService.checkIfDuplicateStepMenuName(
							ussdKeywordStep.getStepMenuName(), keywordId)) == true) {
						errors.rejectValue("stepMenuName",
								"stepMenuName.duplicate");
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
	}

	@Override
	public void validate(Object target, Errors errors) {
		validate(target, errors, null);
	}
}
