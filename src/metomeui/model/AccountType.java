package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ACCOUNT_TYPES")
public class AccountType {

	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_TYPE_ID")
	private long accountTypeId;

	@NotEmpty
	@Column(name = "ACCOUNT_TYPE_CODE", nullable = false, length = 20)
	private String accountTypeCode;

	@NotEmpty
	@Column(name = "ACCOUNT_TYPE_NAME", nullable = false, length = 50)
	private String accountTypeName;

	@NotEmpty
	@Column(name = "ACCOUNT_TYPE_BITMAP", nullable = false, length = 11)
	private Integer accountTypeBitMap;

	@Column(name = "MAX_BOOK_BALANCE", nullable = false)
	private Double accountMaximumBookBalance;

	@Column(name = "ENABLED_FLG", nullable = false, length = 11)
	private Integer enabledFlag;

	public AccountType() {

	}

	public long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountTypeCode() {
		return accountTypeCode;
	}

	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public Integer getAccountTypeBitMap() {
		return accountTypeBitMap;
	}

	public void setAccountTypeBitMap(Integer accountTypeBitMap) {
		this.accountTypeBitMap = accountTypeBitMap;
	}

	public Double getAccountMaximumBookBalance() {
		return accountMaximumBookBalance;
	}

	public void setAccountMaximumBookBalance(Double accountMaximumBookBalance) {
		this.accountMaximumBookBalance = accountMaximumBookBalance;
	}

	public Integer getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Integer enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
}
