package metomeui.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ACCOUNT_TYPES")
public class AccountType {

	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_TYPE_ID")
	private Long accountTypeId;

	@NotEmpty
	@Column(name = "ACCOUNT_TYPE_CODE", nullable = false, length = 20)
	private String accountTypeCode;

	@NotEmpty
	@Column(name = "ACCOUNT_TYPE_NAME", nullable = false, length = 50)
	private String accountTypeName;

	@NotEmpty
	@Column(name = "ACCOUNT_TYPE_BITMAP", nullable = false, length = 11)
	private Integer accountTypeBitMap;

	@NotEmpty
	@Column(name = "SYS_ACCOUNT_TYPE_FLG", nullable = true, length = 11)
	private Integer sysAccountTypeFlag;

	@Column(name = "MAX_BOOK_BALANCE", nullable = false)
	private Double accountMaximumBookBalance;

	@Column(name = "ENABLED_FLG", nullable = false, length = 11)
	private Integer enabledFlag;
	
	@OneToMany(targetEntity = AmlBarring.class, mappedBy = "accountType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_TYPE_ID", insertable = false, updatable = false, nullable = true)
	private List<AmlBarring> accountTypeAmlBarring;

	public AccountType() {

	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
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

	public Integer getSysAccountTypeFlag() {
		return sysAccountTypeFlag;
	}

	public void setSysAccountTypeFlag(Integer sysAccountTypeFlag) {
		this.sysAccountTypeFlag = sysAccountTypeFlag;
	}
}
