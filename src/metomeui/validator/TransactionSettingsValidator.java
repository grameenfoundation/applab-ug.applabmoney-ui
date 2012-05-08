package metomeui.validator;

import metomeui.model.TransactionSettings;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("transactionSettingsValidator")
public class TransactionSettingsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TransactionSettings.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		TransactionSettings transactionSettings = (TransactionSettings) target;
		if (transactionSettings.getNotifyOnDelayTrans() == true) {
			ValidationUtils
					.rejectIfEmptyOrWhitespace(errors,
							"notifyOnDelayMessageID",
							"notifyOnDelayMessageID.required");
			if (transactionSettings.getNotifyOnDelaySeconds().intValue() == 0) {
				errors.rejectValue("notifyOnDelaySeconds",
						"notifyOnDelaySeconds.required");
			}
		}
		if (transactionSettings.getMaintenanceMode() == true) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"maintenanceModeMessageID",
					"maintenanceModeMessageID.required");
		}
		
		if (transactionSettings.getSmsSubscriptionFormat().equalsIgnoreCase(
				"None")) {
			errors.rejectValue("smsSubscriptionFormat",
					"smsSubscriptionFormat.required");
		}
		if (transactionSettings.getAllowedOperations().intValue() == 0) {
			errors.rejectValue("allowedOperations",
					"allowedOperations.required");
		}

	}
}
