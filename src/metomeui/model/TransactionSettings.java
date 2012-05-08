package metomeui.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TransactionSettings {
	
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

	public void clearFields() {
		
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

	public Integer getNotifyOnDelaySeconds() {
		return notifyOnDelaySeconds;
	}

	public void setNotifyOnDelaySeconds(Integer notifyOnDelaySeconds) {
		this.notifyOnDelaySeconds = notifyOnDelaySeconds;
	}

	public Integer getAllowedOperations() {
		return allowedOperations;
	}

	public void setAllowedOperations(Integer allowedOperations) {
		this.allowedOperations = allowedOperations;
	}

}
