package metomeui.validator;

import metomeui.model.UssdMenuItem;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("ussdMenuItemValidator")
public class UssdMenuItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UssdMenuItem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UssdMenuItem ussdMenuItem = (UssdMenuItem) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuItemName",
				"menuItemName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuItemOrder",
				"menuItemOrder.required");
		if (ussdMenuItem.getMenuItemParentId() == 0) {
			errors.rejectValue("menuItemParentId", "menuItemParentId.required");
		}
		if (ussdMenuItem.getMenuItemKeywordId() == 0) {
			errors.rejectValue("menuItemKeywordId", "menuItemKeywordId.required");
		}
//		if (ussdMenuItem.getMenuItemName().equalsIgnoreCase(null)) {
//			errors.rejectValue("menuItemName", "menuItemName.wrongformat");
//		}
//		if (ussdMenuItem.getMenuItemOrder().(null)) {
//			errors.rejectValue("menuItemName", "menuItemName.wrongformat");
//		}
	}
}
