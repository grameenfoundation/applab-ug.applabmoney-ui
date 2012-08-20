package metomeui.validator;

import metomeui.model.AccountType;
import metomeui.model.AmlBarring;
import metomeui.model.GlobalKeywordCharge;
import metomeui.model.Language;
import metomeui.model.MeToMeGoalType;
import metomeui.model.MeToMeRewardType;
import metomeui.model.MemoGroup;
import metomeui.model.Message;
import metomeui.model.NdcListOffnet;
import metomeui.model.NdcListPToP;
import metomeui.model.SystemConfiguration;
import metomeui.model.User;
import metomeui.model.ZimbaConfiguration;
import metomeui.service.ProductsService;
import metomeui.service.ProductsServiceImplementation;
import metomeui.service.SystemSettingsService;
import metomeui.service.SystemSettingsServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

@Component("productsValidator")
public class ProductsValidator implements Validator {

	@Autowired
	ProductsService productsService = new ProductsServiceImplementation();

	@Override
	public boolean supports(Class<?> clazz) {
		return MeToMeGoalType.class.isAssignableFrom(clazz)
				|| MeToMeRewardType.class.isAssignableFrom(clazz)
				|| ZimbaConfiguration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors, Long id) {
		if (target instanceof MeToMeGoalType) {
			MeToMeGoalType meToMeGoalType = (MeToMeGoalType) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "goalTypeName",
					"goalTypeName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "goalTypeCode",
					"goalTypeCode.required");

			if (meToMeGoalType.getGoalTypeName() != null) {

				if (productsService
						.checkIfDuplicateMeToMeGoalTypeName(meToMeGoalType
								.getGoalTypeName())) {
					errors.rejectValue("goalTypeName",
							"goalTypeName.goalTypeNameDuplicate");
				}
			}

			if (meToMeGoalType.getGoalTypeCode() != null) {
				if (productsService
						.checkIfDuplicateMeToMeGoalTypeCode(meToMeGoalType
								.getGoalTypeCode())) {
					errors.rejectValue("goalTypeCode",
							"goalTypeCode.goalTypeCodeDuplicate");
				}
			}

		}

		if (target instanceof MeToMeRewardType) {
			MeToMeRewardType meToMeRewardType = (MeToMeRewardType) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rewardTypeName",
					"rewardTypeName.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rewardTypeCode",
					"rewardTypeCode.required");

			if (meToMeRewardType.getRewardTypeName() != null) {

				if (productsService
						.checkIfDuplicateMeToMeRewardTypeName(meToMeRewardType
								.getRewardTypeName())) {
					errors.rejectValue("rewardTypeName",
							"rewardTypeName.rewardTypeNameDuplicate");
				}
			}

			if (meToMeRewardType.getRewardTypeCode() != null) {
				if (productsService
						.checkIfDuplicateMeToMeRewardTypeCode(meToMeRewardType
								.getRewardTypeCode())) {
					errors.rejectValue("rewardTypeCode",
							"rewardTypeCode.rewardTypeCodeDuplicate");
				}
			}

		}

		if (target instanceof ZimbaConfiguration) {
			ZimbaConfiguration zimbaConfiguration = (ZimbaConfiguration) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"minInterestRate", "minInterestRate.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"maxInterestRate", "maxInterestRate.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "minLoanAmount",
					"minLoanAmount.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxLoanAmount",
					"maxLoanAmount.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxRepayPeriod",
					"maxRepayPeriod.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"periodToDefaulting", "periodToDefaulting.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"activeBorrowPeriod", "activeBorrowPeriod.required");
			if ((null != zimbaConfiguration.getMaxInterestRate())
					&& (zimbaConfiguration.getMaxInterestRate().toString()
							.trim() != "")) {
				if ((null != zimbaConfiguration.getMinInterestRate())
						&& (zimbaConfiguration.getMinInterestRate().toString()
								.trim() != "")) {
					if (zimbaConfiguration.getMaxInterestRate() <= zimbaConfiguration
							.getMinInterestRate()) {
						errors.rejectValue("maxInterestRate",
								"maxInterestRate.maxInterestRateLessThanOrEqualToMin");
					}
				}
			}
			if ((null != zimbaConfiguration.getMaxInterestRate())
					&& (zimbaConfiguration.getMaxInterestRate().toString()
							.trim() != "")) {
				if ((null != zimbaConfiguration.getMinInterestRate())
						&& (zimbaConfiguration.getMinInterestRate().toString()
								.trim() != "")) {
					if (zimbaConfiguration.getMaxLoanAmount() <= zimbaConfiguration
							.getMinLoanAmount()) {
						errors.rejectValue("maxLoanAmount",
								"maxLoanAmount.maxLoanAmountMoreThanOrEqualToMin");
					}
				}
			}
		}
	}

	@Override
	public void validate(Object target, Errors errors) {
		validate(target, errors, null);
	}
}
