package anathatest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class PasswordSettings {

	//@NotEmpty
    //@Size(min = 1, max = 50)
	private String name;
	//@NotNull
   	private Integer precedence;
	//@NotNull
	private Integer minPasswordLength;
	@NotNull
	private Integer maxPasswordLength;
	private Boolean enforceMaxPasswordLength;
	private Boolean enforceMinPasswordLength;
	@NotNull
	private Integer maxPasswordAge;
	@NotNull
	private Integer minPasswordAge;
	private Boolean enforceMaxPasswordAge;
	private Boolean enforceMinPasswordAge;
	@NotNull
	private Integer maxFailedLoginCount;
	@NotNull
	private Integer failedLoginResetCount;
	private Boolean enforceLockoutPolicy;
	private Boolean enforcePasswordComplexityRequirements;
	private Boolean accountManualUnlock;
	private Void accountUnlock;
	private Boolean accountTimedUnlock;
	@NotNull
	private Integer accountLockDuration;
	
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
	public Boolean getEnforceMaxPasswordLength() {
		return enforceMaxPasswordLength;
	}
	public void setEnforceMaxPasswordLength(Boolean enforceMaxPasswordLength) {
		this.enforceMaxPasswordLength = enforceMaxPasswordLength;
	}
	public Boolean getEnforceMinPasswordLength() {
		return enforceMinPasswordLength;
	}
	public void setEnforceMinPasswordLength(Boolean enforceMinPasswordLength) {
		this.enforceMinPasswordLength = enforceMinPasswordLength;
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
	public Boolean getEnforceMaxPasswordAge() {
		return enforceMaxPasswordAge;
	}
	public void setEnforceMaxPasswordAge(Boolean enforceMaxPasswordAge) {
		this.enforceMaxPasswordAge = enforceMaxPasswordAge;
	}
	public Boolean getEnforceMinPasswordAge() {
		return enforceMinPasswordAge;
	}
	public void setEnforceMinPasswordAge(Boolean enforceMinPasswordAge) {
		this.enforceMinPasswordAge = enforceMinPasswordAge;
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
	public Boolean getAccountManualUnlock() {
		return accountManualUnlock;
	}
	public void setAccountManualUnlock(Boolean accountManualUnlock) {
		this.accountManualUnlock = accountManualUnlock;
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
	public Boolean getEnforcePasswordComplexityRequirements() {
		return enforcePasswordComplexityRequirements;
	}
	public void setEnforcePasswordComplexityRequirements(
			Boolean enforcePasswordComplexityRequirements) {
		this.enforcePasswordComplexityRequirements = enforcePasswordComplexityRequirements;
	}
	public void clearFields() {
	this.name = "";
		this.precedence = 0;
	}
	public Void getAccountUnlock() {
		return accountUnlock;
	}
	public void setAccountUnlock(Void accountUnlock) {
		this.accountUnlock = accountUnlock;
	}
	
}
