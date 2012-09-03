package applabmoneyaui.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import applabmoneyaui.model.AccountType;
import applabmoneyaui.model.AmlBarring;
import applabmoneyaui.model.GlobalKeywordCharge;
import applabmoneyaui.model.Language;
import applabmoneyaui.model.MemoGroup;
import applabmoneyaui.model.Message;
import applabmoneyaui.model.NdcListOffnet;
import applabmoneyaui.model.NdcListPToP;
import applabmoneyaui.model.SystemConfiguration;
import applabmoneyaui.model.User;
import applabmoneyaui.service.SystemSettingsService;
import applabmoneyaui.service.SystemSettingsServiceImplementation;

@Component("systemSettingsValidator")
public class SystemSettingsValidator implements Validator {

	@Autowired
	SystemSettingsService systemSettingsService = new SystemSettingsServiceImplementation();

	@Override
	public boolean supports(Class<?> clazz) {
		return Message.class.isAssignableFrom(clazz)
				|| Language.class.isAssignableFrom(clazz)
				|| AccountType.class.isAssignableFrom(clazz)
				|| AmlBarring.class.isAssignableFrom(clazz)
				|| GlobalKeywordCharge.class.isAssignableFrom(clazz)
				|| MemoGroup.class.isAssignableFrom(clazz)
				|| NdcListOffnet.class.isAssignableFrom(clazz)
				|| NdcListPToP.class.isAssignableFrom(clazz)
				|| SystemConfiguration.class.isAssignableFrom(clazz)
				|| User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors, Long id) {
		if (target instanceof Message) {
			Message message = (Message) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageCode",
					"messageCode.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageText",
					"messageText.required");

			if (message.getLanguage() != null) {
				if (message.getMessageCode() != null) {
					if (systemSettingsService
							.checkIfLanguageMessageCodeComboExists(
									message.getLanguage(),
									message.getMessageCode())) {
						errors.rejectValue("messageCode",
								"messageCode.languageMessageComboDuplicate");
					}
				}

			}
		} else if (target instanceof Language) {
			Language language = (Language) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "languageName",
					"languageName.required");
			if ((language.getLanguageName() != null)
					|| (language.getLanguageName() != "")) {
				if ((systemSettingsService.checkIfDuplicateLanguageName(
						language.getLanguageName(), language.getLanguageId())) == true) {
					errors.rejectValue("predefInputItemName",
							"predefInputItemName.duplicate");
				}
			}
		} else if (target instanceof MemoGroup) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memoGroupName",
					"memoGroupName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memoGroupCode",
					"memoGroupCode.required");
		} else if (target instanceof NdcListOffnet) {
			NdcListOffnet ndcListOffnet = (NdcListOffnet) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ndc",
					"ndc.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"networkOperator", "networkOperator.required");
			if (systemSettingsService.checkIfDuplicateNdc(ndcListOffnet
					.getNdc())) {
				errors.rejectValue("ndc", "ndc.duplicate");
			}
		} else if (target instanceof NdcListPToP) {
			NdcListPToP ndcListPToP = (NdcListPToP) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ndc",
					"ndc.required");
			if (systemSettingsService.checkIfDuplicateNdc(ndcListPToP.getNdc())) {
				errors.rejectValue("ndc", "ndc.duplicate");
			}
		} else if (target instanceof AmlBarring) {
			AmlBarring amlBarring = (AmlBarring) target;
			if ((amlBarring.getAccountType() != null)
					&& (amlBarring.getTransactionKeyword() != null)) {
				if (systemSettingsService.checkIfAccTypeKeywordCodeComboExist(
						amlBarring.getAccountType(),
						amlBarring.getTransactionKeyword())) {
					errors.rejectValue("accountType",
							"accountType.AccTypeKeywordComboDuplicate");
				}
			}
		} else if (target instanceof AccountType) {
			AccountType accountType = (AccountType) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"accountTypeCode", "accountTypeCode.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"accountTypeName", "accountTypeName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"accountMaximumBookBalance",
					"accountMaximumBookBalance.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"accountTypeBitMap", "accountTypeBitMap.required");
			if ((accountType.getAccountTypeBitMap() != null)
					|| (accountType.getAccountTypeBitMap().toString().trim() != "")) {
				if (systemSettingsService.checkIfDuplicateBitMap(accountType
						.getAccountTypeBitMap())) {
					errors.rejectValue("accountTypeBitMap",
							"accountTypeBitMap.duplicate");
				}
			}

		} else if (target instanceof GlobalKeywordCharge) {
			GlobalKeywordCharge globalKeywordCharge = (GlobalKeywordCharge) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "chargePercent",
					"chargePercent.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "chargeFixed",
					"chargeFixed.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lowRange",
					"lowRange.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "highRange",
					"highRange.required");
			if (globalKeywordCharge.getLowRange() >= globalKeywordCharge
					.getHighRange()) {
				errors.rejectValue("lowRange", "lowRange.invalid");
			}
			if (globalKeywordCharge.getHighRange() <= globalKeywordCharge
					.getLowRange()) {

				errors.rejectValue("highRange", "highRange.invalid");
			}
		} else if (target instanceof SystemConfiguration) {
			SystemConfiguration systemConfiguration = (SystemConfiguration) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "operation",
					"operation.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"smsSenderNumber", "smsSenderNumber.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"currencyISONumber", "currencyISONumber.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryDomain",
					"countryDomain.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode",
					"countryCode.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"subscriberMaxDisplayCharacters",
					"subscriberMaxDisplayCharacters.required");
			ValidationUtils
					.rejectIfEmptyOrWhitespace(errors,
							"notifyOnDelayMessageID",
							"notifyOnDelayMessageID.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"maintenanceModeMessageID",
					"maintenanceModeMessageID.required");

			if ((systemConfiguration.getSubscriberMaxDisplayCharacters() != null)
					|| (systemConfiguration.getSubscriberMaxDisplayCharacters()
							.toString().trim() != "")) {
				if (systemConfiguration.getSubscriberMaxDisplayCharacters() > 30) {
					errors.rejectValue("subscriberMaxDisplayCharacters",
							"subscriberMaxDisplayCharacters.overMax");
				}
				if (systemConfiguration.getSubscriberMaxDisplayCharacters() < 15) {
					errors.rejectValue("subscriberMaxDisplayCharacters",
							"subscriberMaxDisplayCharacters.underMin");
				}
			}
			if (systemConfiguration.getNotifyOnDelayTransaction() == null) {
				if ((systemConfiguration.getNotifyOnDelayMessageID() != null)
						|| (systemConfiguration.getNotifyOnDelayMessageID()
								.toString().trim() != "")) {
					errors.rejectValue("notifyOnDelayMessageID",
							"notifyOnDelayMessageID.required");
				}
				if ((systemConfiguration.getNotifyOnDelayTransaction() == null)
						|| (systemConfiguration.getNotifyOnDelaySeconds()
								.toString().trim() != "")) {
					errors.rejectValue("notifyOnDelaySeconds",
							"notifyOnDelaySeconds.required");
				}

			}
		}
	}

	@Override
	public void validate(Object target, Errors errors) {
		validate(target, errors, null);
	}
}
