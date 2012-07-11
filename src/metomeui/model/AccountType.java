package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "account_types")
public class AccountType {

	@Id
	@GeneratedValue
	@Column(name = "account_type_id")
	private long accountTypeId;

	@NotEmpty
	@Column(name = "account_type_code", nullable = false, length = 20)
	private String accountTypeCode;

	@NotEmpty
	@Column(name = "account_type_name", nullable = false, length = 50)
	private String accountTypeName;

	@NotEmpty
	@Column(name = "account_type_bitmap", nullable = false, length = 11)
	private Integer accountTypeBitMap;

	@Column(name = "sys_account_type_flg", nullable = true, length = 11)
	private Integer sysAccountTypeFlag;

	@Column(name = "max_book_balance", nullable = false)
	private Double accountMaximumBookBalance;

	@Column(name = "enabled_flg", nullable = false, length = 11)
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

	public Integer getSysAccountTypeFlag() {
		return sysAccountTypeFlag;
	}

	public void setSysAccountTypeFlag(Integer sysAccountTypeFlag) {
		this.sysAccountTypeFlag = sysAccountTypeFlag;
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
