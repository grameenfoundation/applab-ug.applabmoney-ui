package metomeui.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SystemConfiguration {
	
	//@NotEmpty
    //@Size(min = 1, max = 50)
	private String name;
	//@NotNull
   	private Integer precedence;
	//@NotNull
	private Integer minPasswordLength;
	@NotNull
	private Integer maxPasswordLength;
	/*private Boolean enforceMaxPasswordLength;
	private Boolean enforceMinPasswordLength;*/
	@NotNull
	private Integer maxPasswordAge;
	@NotNull
	private Integer minPasswordAge;
	/*private Boolean enforceMaxPasswordAge;
	private Boolean enforceMinPasswordAge;*/
	@NotNull
	private Integer maxFailedLoginCount;
	@NotNull
	private Integer failedLoginResetCount;
	private Boolean enforceLockoutPolicy;
	private Boolean enforcePasswordComplexityRequirements;
	private Boolean accountManualUnlock;
	private Boolean accountUnlock;
	private Boolean accountTimedUnlock;
	@NotNull
	private Integer accountLockDuration;
	
	
	private Boolean failedTransferLock;
	private Boolean autoCreateTempSub;
	private String tempRestrictionSettings; 
	private Integer allowedOperations;
	@NotEmpty(message="SMS Sender Name/Number is required")
	private String smsSenderID;
	private String smsSubscriptionFormat;
	private String subscriptionMaxDisplayCharacters;
	private Boolean chargeCollectSetting;
	private Boolean notifyOnDelayTrans;
	private String notifyOnDelayMessageID;
	private Integer notifyOnDelaySeconds;
	private Boolean maintenanceMode;
	private String maintenanceModeMessageID;	
	
	
	@NotNull(message="Country code is required")
	private Integer countryCode;
	@NotEmpty(message="Country Domain is required")
	private String countryDomain;
	@NotEmpty(message="Currency code is required")
	private String currencyCode; 
	@NotEmpty(message="Currency ISO Number is required")
	private String currencyISONumber;
	@NotNull(message="MSISDN Length is required")
	private Integer msisdnLength;
	private Boolean msisdnLeadZero;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrecedence() {
		return precedence;
	}
	public void setPrecedence(Integer precedence) {
		this.precedence = precedence;
	}
	public Integer getMinPasswordLength() {
		return minPasswordLength;
	}
	public void setMinPasswordLength(Integer minPasswordLength) {
		this.minPasswordLength = minPasswordLength;
	}
	public Integer getMaxPasswordLength() {
		return maxPasswordLength;
	}
	public void setMaxPasswordLength(Integer maxPasswordLength) {
		this.maxPasswordLength = maxPasswordLength;
	}
	public Integer getMaxPasswordAge() {
		return maxPasswordAge;
	}
	public void setMaxPasswordAge(Integer maxPasswordAge) {
		this.maxPasswordAge = maxPasswordAge;
	}
	public Integer getMinPasswordAge() {
		return minPasswordAge;
	}
	public void setMinPasswordAge(Integer minPasswordAge) {
		this.minPasswordAge = minPasswordAge;
	}
	public Integer getMaxFailedLoginCount() {
		return maxFailedLoginCount;
	}
	public void setMaxFailedLoginCount(Integer maxFailedLoginCount) {
		this.maxFailedLoginCount = maxFailedLoginCount;
	}
	public Integer getFailedLoginResetCount() {
		return failedLoginResetCount;
	}
	public void setFailedLoginResetCount(Integer failedLoginResetCount) {
		this.failedLoginResetCount = failedLoginResetCount;
	}
	public Boolean getEnforceLockoutPolicy() {
		return enforceLockoutPolicy;
	}
	public void setEnforceLockoutPolicy(Boolean enforceLockoutPolicy) {
		this.enforceLockoutPolicy = enforceLockoutPolicy;
	}
	public Boolean getEnforcePasswordComplexityRequirements() {
		return enforcePasswordComplexityRequirements;
	}
	public void setEnforcePasswordComplexityRequirements(
			Boolean enforcePasswordComplexityRequirements) {
		this.enforcePasswordComplexityRequirements = enforcePasswordComplexityRequirements;
	}
	public Boolean getAccountManualUnlock() {
		return accountManualUnlock;
	}
	public void setAccountManualUnlock(Boolean accountManualUnlock) {
		this.accountManualUnlock = accountManualUnlock;
	}
	public Boolean getAccountUnlock() {
		return accountUnlock;
	}
	public void setAccountUnlock(Boolean accountUnlock) {
		this.accountUnlock = accountUnlock;
	}
	public Boolean getAccountTimedUnlock() {
		return accountTimedUnlock;
	}
	public void setAccountTimedUnlock(Boolean accountTimedUnlock) {
		this.accountTimedUnlock = accountTimedUnlock;
	}
	public Integer getAccountLockDuration() {
		return accountLockDuration;
	}
	public void setAccountLockDuration(Integer accountLockDuration) {
		this.accountLockDuration = accountLockDuration;
	}
	public Boolean getFailedTransferLock() {
		return failedTransferLock;
	}
	public void setFailedTransferLock(Boolean failedTransferLock) {
		this.failedTransferLock = failedTransferLock;
	}
	public Boolean getAutoCreateTempSub() {
		return autoCreateTempSub;
	}
	public void setAutoCreateTempSub(Boolean autoCreateTempSub) {
		this.autoCreateTempSub = autoCreateTempSub;
	}
	public String getTempRestrictionSettings() {
		return tempRestrictionSettings;
	}
	public void setTempRestrictionSettings(String tempRestrictionSettings) {
		this.tempRestrictionSettings = tempRestrictionSettings;
	}
	public Integer getAllowedOperations() {
		return allowedOperations;
	}
	public void setAllowedOperations(Integer allowedOperations) {
		this.allowedOperations = allowedOperations;
	}
	public String getSmsSenderID() {
		return smsSenderID;
	}
	public void setSmsSenderID(String smsSenderID) {
		this.smsSenderID = smsSenderID;
	}
	public String getSmsSubscriptionFormat() {
		return smsSubscriptionFormat;
	}
	public void setSmsSubscriptionFormat(String smsSubscriptionFormat) {
		this.smsSubscriptionFormat = smsSubscriptionFormat;
	}
	public String getSubscriptionMaxDisplayCharacters() {
		return subscriptionMaxDisplayCharacters;
	}
	public void setSubscriptionMaxDisplayCharacters(
			String subscriptionMaxDisplayCharacters) {
		this.subscriptionMaxDisplayCharacters = subscriptionMaxDisplayCharacters;
	}
	public Boolean getChargeCollectSetting() {
		return chargeCollectSetting;
	}
	public void setChargeCollectSetting(Boolean chargeCollectSetting) {
		this.chargeCollectSetting = chargeCollectSetting;
	}
	public Boolean getNotifyOnDelayTrans() {
		return notifyOnDelayTrans;
	}
	public void setNotifyOnDelayTrans(Boolean notifyOnDelayTrans) {
		this.notifyOnDelayTrans = notifyOnDelayTrans;
	}
	public String getNotifyOnDelayMessageID() {
		return notifyOnDelayMessageID;
	}
	public void setNotifyOnDelayMessageID(String notifyOnDelayMessageID) {
		this.notifyOnDelayMessageID = notifyOnDelayMessageID;
	}
	public Integer getNotifyOnDelaySeconds() {
		return notifyOnDelaySeconds;
	}
	public void setNotifyOnDelaySeconds(Integer notifyOnDelaySeconds) {
		this.notifyOnDelaySeconds = notifyOnDelaySeconds;
	}
	public Boolean getMaintenanceMode() {
		return maintenanceMode;
	}
	public void setMaintenanceMode(Boolean maintenanceMode) {
		this.maintenanceMode = maintenanceMode;
	}
	public String getMaintenanceModeMessageID() {
		return maintenanceModeMessageID;
	}
	public void setMaintenanceModeMessageID(String maintenanceModeMessageID) {
		this.maintenanceModeMessageID = maintenanceModeMessageID;
	}
	public Integer getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryDomain() {
		return countryDomain;
	}
	public void setCountryDomain(String countryDomain) {
		this.countryDomain = countryDomain;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyISONumber() {
		return currencyISONumber;
	}
	public void setCurrencyISONumber(String currencyISONumber) {
		this.currencyISONumber = currencyISONumber;
	}
	public Integer getMsisdnLength() {
		return msisdnLength;
	}
	public void setMsisdnLength(Integer msisdnLength) {
		this.msisdnLength = msisdnLength;
	}
	public Boolean getMsisdnLeadZero() {
		return msisdnLeadZero;
	}
	public void setMsisdnLeadZero(Boolean msisdnLeadZero) {
		this.msisdnLeadZero = msisdnLeadZero;
	}


}
