package metomeui.validator;

import metomeui.dao.UssdMenuDao;
import metomeui.dao.UssdMenuDaoImplementation;
import metomeui.model.UssdMenuItem;
import metomeui.service.UssdMenuService;
import metomeui.service.UssdMenuServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("ussdMenuItemValidator")
public class UssdMenuItemValidator implements Validator {

	@Autowired
	UssdMenuService ussdMenuService = new UssdMenuServiceImplementation();
	@Autowired
	UssdMenuDao ussdMenuDao = new UssdMenuDaoImplementation();

	@Override
	public boolean supports(Class<?> clazz) {
		return UssdMenuItem.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors, Long menuItemId) {

		UssdMenuItem ussdMenuItem = (UssdMenuItem) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuItemName",
				"menuItemName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuItemOrder",
				"menuItemOrder.required");

		if (menuItemId != null) {
			if ((ussdMenuItem.getMenuItemName() != null)
					|| (ussdMenuItem.getMenuItemName() != "")) {
				if ((ussdMenuService.checkIfDuplicateMenuName(
						ussdMenuItem.getMenuItemName(), menuItemId)) == true) {
					errors.rejectValue("menuItemName", "menuItemName.duplicate");
				}
			}
		}
	}

	@Override
	public void validate(Object target, Errors errors) {
		validate(target, errors, null);
	}
}
