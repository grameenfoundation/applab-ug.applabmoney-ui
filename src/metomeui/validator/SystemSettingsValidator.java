package metomeui.validator;

import metomeui.model.AccountType;
import metomeui.model.Language;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.NdcListOffnet;
import metomeui.model.NdcListPToP;

import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

@Component("systemSettingsValidator")
public class SystemSettingsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Message.class.isAssignableFrom(clazz)
				|| Language.class.isAssignableFrom(clazz)
				|| AccountType.class.isAssignableFrom(clazz)
				|| MemoGroup.class.isAssignableFrom(clazz)
				|| NdcListOffnet.class.isAssignableFrom(clazz)
				|| NdcListPToP.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof Message) {
			Message message = (Message) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageCode",
					"messageCode.required");
		} else if (target instanceof Language) {
			Language language = (Language) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "languageName",
					"languageName.required");
		} else if (target instanceof MemoGroup) {
			MemoGroup memoGroup = (MemoGroup) target;
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
		} else if (target instanceof NdcListPToP) {
			NdcListPToP ndcListPToP = (NdcListPToP) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ndc",
					"ndc.required");
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
		}
	}

}
