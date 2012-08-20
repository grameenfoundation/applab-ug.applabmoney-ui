package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "GLOBAL_RECEIVE_LIMITS")
public class GlobalReceiveLimit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECEIVE_LIMIT_ID")
	private Long receiveLimitId;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_TYPE_ID", nullable = false)
	private AccountType accountType;

	@ManyToOne
	@JoinColumn(name = "KEYWORD_ID", nullable = false)
	private UssdTransactionKeyword transactionKeyword;

	@NotEmpty
	@Column(name = "MIN_TRANS_AMOUNT", precision = 2)
	private Double minTransactionAmount;

	@NotEmpty
	@Column(name = "MAX_TRANS_AMOUNT", precision = 2)
	private Double maxTransactionAmount;

	@NotEmpty
	@Column(name = "MAX_AMOUNT_DAY", precision = 2)
	private Double maxAmountDay;

	@NotEmpty
	@Column(name = "MAX_TRANS_DAY", precision = 2)
	private Integer maxTransDay;

	@NotEmpty
	@Column(name = "MAX_AMOUNT_MONTH", precision = 2)
	private Double maxAmountMonth;

	@NotEmpty
	@Column(name = "MAX_TRANS_MONTH", precision = 2)
	private Integer maxTransMonth;

	public GlobalReceiveLimit() {

	}

	public Long getReceiveLimitId() {
		return receiveLimitId;
	}

	public void setReceiveLimitId(Long receiveLimitId) {
		this.receiveLimitId = receiveLimitId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public UssdTransactionKeyword getTransactionKeyword() {
		return transactionKeyword;
	}

	public void setTransactionKeyword(UssdTransactionKeyword transactionKeyword) {
		this.transactionKeyword = transactionKeyword;
	}

	public Double getMinTransactionAmount() {
		return minTransactionAmount;
	}

	public void setMinTransactionAmount(Double minTransactionAmount) {
		this.minTransactionAmount = minTransactionAmount;
	}

	public Double getMaxTransactionAmount() {
		return maxTransactionAmount;
	}

	public void setMaxTransactionAmount(Double maxTransactionAmount) {
		this.maxTransactionAmount = maxTransactionAmount;
	}

	public Double getMaxAmountDay() {
		return maxAmountDay;
	}

	public void setMaxAmountDay(Double maxAmountDay) {
		this.maxAmountDay = maxAmountDay;
	}

	public Integer getMaxTransDay() {
		return maxTransDay;
	}

	public void setMaxTransDay(Integer maxTransDay) {
		this.maxTransDay = maxTransDay;
	}

	public Double getMaxAmountMonth() {
		return maxAmountMonth;
	}

	public void setMaxAmountMonth(Double maxAmountMonth) {
		this.maxAmountMonth = maxAmountMonth;
	}

	public Integer getMaxTransMonth() {
		return maxTransMonth;
	}

	public void setMaxTransMonth(Integer maxTransMonth) {
		this.maxTransMonth = maxTransMonth;
	}
}
