package metomeui.validator;

import metomeui.dao.UssdMenuDao;
import metomeui.dao.UssdMenuDaoImplementation;
import metomeui.model.UssdPredefInputItem;
import metomeui.service.UssdMenuService;
import metomeui.service.UssdMenuServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("ussdPredefInputItemValidator")
public class UssdPredefInputItemValidator implements Validator {

	@Autowired
	UssdMenuService ussdMenuService = new UssdMenuServiceImplementation();
	@Autowired
	UssdMenuDao ussdMenuDao = new UssdMenuDaoImplementation();

	@Override
	public boolean supports(Class<?> clazz) {
		return UssdPredefInputItem.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors, Long predefInputId) {

		UssdPredefInputItem ussdPredefInputItem = (UssdPredefInputItem) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"predefInputItemName", "predefInputItemName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"predefInputItemCode", "predefInputItemCode.required");

		if (ussdPredefInputItem.getPredefInputItemCode().length() > 10) {
			errors.rejectValue("predefInputItemCode",
					"predefInputItemCode.lengthLimit");
		}

		if (null == ussdPredefInputItem.getPredefInputItemOrder()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"predefInputItemOrder", "predefInputItemOrder.required");
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
	}

	@Override
	public void validate(Object target, Errors errors) {
		validate(target, errors, null);

	}
}
