package applabmoneyaui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYSTEM_CONFIG")
public class SystemConfiguration {

	@Id
	@GeneratedValue
	@Column(name = "CONFIG_ID")
	private Long configId;

	@Column(name = "MIN_PASSWORD", nullable = true, length = 11)
	private Integer minPasswordLength;

	@Column(name = "MAX_PASSWORD", nullable = true, length = 11)
	private Integer maxPasswordLength;

	@Column(name = "INVALID_PASSWORD_LOCK", nullable = true, length = 11)
	private Integer invalidPasswordLock;

	@Column(name = "FAILED_TRANSFER_LOCK", nullable = true, length = 11)
	private Integer failedTransferLock;

	@Column(name = "AUTO_CREATE_TEMP_SUB", nullable = true, length = 11)
	private Integer autoCreateTempSub;

	@Column(name = "TEMP_RESTRICTION", nullable = true, length = 11)
	private Integer tempRestrictionSettings;

	@Column(name = "OPERATION", nullable = true, length = 50)
	private String operation;

	@Column(name = "SMS_SENDER_NUMBER", nullable = true, length = 50)
	private String smsSenderNumber;

	@Column(name = "SMS_MSG_SUB_DISPLAY_FMT", nullable = true, length = 11)
	private Integer smsMessageSubscriberFormat;

	@Column(name = "SUB_DISPLAY_MAX_CHARS", nullable = true, length = 11)
	private Integer subscriberMaxDisplayCharacters;

	@Column(name = "CHARGE_COLLECT_IMMEDIATE", nullable = true, length = 11)
	private Integer chargeCollectSetting;

	@Column(name = "NOTIFY_ON_DELAYED_TRANS", nullable = true, length = 11)
	private Integer notifyOnDelayTransaction;

	@Column(name = "NOTIFY_DELAY_MSG_ID", nullable = true, length = 11)
	private Integer notifyOnDelayMessageID;

	@Column(name = "NOTIFY_DELAY_SECONDS", nullable = true, length = 11)
	private Integer notifyOnDelaySeconds;

	@Column(name = "MAINTENANCE_MODE_FLG", nullable = true, length = 11)
	private Integer maintenanceModeFlag;

	@Column(name = "MAINTENANCE_MODE_MSG_ID", nullable = true, length = 11)
	private Integer maintenanceModeMessageID;

	@Column(name = "COUNTRY_CODE", nullable = true, length = 5)
	private String countryCode;

	@Column(name = "COUNTRY_DOMAIN", nullable = true, length = 10)
	private String countryDomain;

	@Column(name = "CURRENCY_CODE", nullable = true, length = 10)
	private String currencyCode;

	@Column(name = "CURRENCY_ISO_NUMBER", nullable = true, length = 11)
	private Integer currencyISONumber;

	@Column(name = "MOBILE_LENGTH", nullable = true, length = 11)
	private Integer msisdnLength;

	@Column(name = "MSISDN_LEAD_ZERO_REQUIRED", nullable = true, length = 11)
	private Integer msisdnLeadZeroRequired;

	public SystemConfiguration() {

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

	public Integer getInvalidPasswordLock() {
		return invalidPasswordLock;
	}

	public void setInvalidPasswordLock(Integer invalidPasswordLock) {
		this.invalidPasswordLock = invalidPasswordLock;
	}

	public Integer getFailedTransferLock() {
		return failedTransferLock;
	}

	public void setFailedTransferLock(Integer failedTransferLock) {
		this.failedTransferLock = failedTransferLock;
	}

	public Integer getAutoCreateTempSub() {
		return autoCreateTempSub;
	}

	public void setAutoCreateTempSub(Integer autoCreateTempSub) {
		this.autoCreateTempSub = autoCreateTempSub;
	}

	public Integer getTempRestrictionSettings() {
		return tempRestrictionSettings;
	}

	public void setTempRestrictionSettings(Integer tempRestrictionSettings) {
		this.tempRestrictionSettings = tempRestrictionSettings;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSmsSenderNumber() {
		return smsSenderNumber;
	}

	public void setSmsSenderNumber(String smsSenderNumber) {
		this.smsSenderNumber = smsSenderNumber;
	}

	public Integer getSmsMessageSubscriberFormat() {
		return smsMessageSubscriberFormat;
	}

	public void setSmsMessageSubscriberFormat(Integer smsMessageSubscriberFormat) {
		this.smsMessageSubscriberFormat = smsMessageSubscriberFormat;
	}

	public Integer getSubscriberMaxDisplayCharacters() {
		return subscriberMaxDisplayCharacters;
	}

	public void setSubscriberMaxDisplayCharacters(
			Integer subscriberMaxDisplayCharacters) {
		this.subscriberMaxDisplayCharacters = subscriberMaxDisplayCharacters;
	}

	public Integer getChargeCollectSetting() {
		return chargeCollectSetting;
	}

	public void setChargeCollectSetting(Integer chargeCollectSetting) {
		this.chargeCollectSetting = chargeCollectSetting;
	}

	public Integer getNotifyOnDelayTransaction() {
		return notifyOnDelayTransaction;
	}

	public void setNotifyOnDelayTransaction(Integer notifyOnDelayTransaction) {
		this.notifyOnDelayTransaction = notifyOnDelayTransaction;
	}

	public Integer getNotifyOnDelayMessageID() {
		return notifyOnDelayMessageID;
	}

	public void setNotifyOnDelayMessageID(Integer notifyOnDelayMessageID) {
		this.notifyOnDelayMessageID = notifyOnDelayMessageID;
	}

	public Integer getNotifyOnDelaySeconds() {
		return notifyOnDelaySeconds;
	}

	public void setNotifyOnDelaySeconds(Integer notifyOnDelaySeconds) {
		this.notifyOnDelaySeconds = notifyOnDelaySeconds;
	}

	public Integer getMaintenanceModeFlag() {
		return maintenanceModeFlag;
	}

	public void setMaintenanceModeFlag(Integer maintenanceModeFlag) {
		this.maintenanceModeFlag = maintenanceModeFlag;
	}

	public Integer getMaintenanceModeMessageID() {
		return maintenanceModeMessageID;
	}

	public void setMaintenanceModeMessageID(Integer maintenanceModeMessageID) {
		this.maintenanceModeMessageID = maintenanceModeMessageID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
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

	public Integer getCurrencyISONumber() {
		return currencyISONumber;
	}

	public void setCurrencyISONumber(Integer currencyISONumber) {
		this.currencyISONumber = currencyISONumber;
	}

	public Integer getMsisdnLength() {
		return msisdnLength;
	}

	public void setMsisdnLength(Integer msisdnLength) {
		this.msisdnLength = msisdnLength;
	}

	public Integer getMsisdnLeadZeroRequired() {
		return msisdnLeadZeroRequired;
	}

	public void setMsisdnLeadZeroRequired(Integer msisdnLeadZeroRequired) {
		this.msisdnLeadZeroRequired = msisdnLeadZeroRequired;
	}

	public Long getConfigId() {
		return configId;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	}
}
