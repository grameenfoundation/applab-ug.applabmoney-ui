package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ZIMBA_CONFIG")
public class ZimbaConfiguration {

	@Id
	@GeneratedValue
	@Column(name = "CONFIG_ID")
	private Long configId;

	@Column(name = "MIN_NT_SIZE", nullable = true, length = 11)
	private Integer networkSize;

	@NotEmpty
	@Column(name = "MIN_INTEREST_RATE", nullable = false, precision = 2)
	private Double minInterestRate;

	@NotEmpty
	@Column(name = "MAX_INTEREST_RATE", nullable = false, precision = 2)
	private Double maxInterestRate;

	@NotEmpty
	@Column(name = "MIN_LOAN_AMOUNT", nullable = false, precision = 2)
	private Double minLoanAmount;

	@NotEmpty
	@Column(name = "MAX_LOAN_AMOUNT", nullable = false, precision = 2)
	private Double maxLoanAmount;

	@NotEmpty
	@Column(name = "MAX_REPAY_PERIOD", nullable = false)
	private Integer maxRepayPeriod;

	@NotEmpty
	@Column(name = "PERIOD_TO_DEFAULTING", nullable = false)
	private Integer periodToDefaulting;

	@NotEmpty
	@Column(name = "BORROW_EXPIRY_DAYS", nullable = false)
	private Integer activeBorrowPeriod;

	public ZimbaConfiguration() {

	}

	public Long getConfigId() {
		return configId;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	public Integer getNetworkSize() {
		return networkSize;
	}

	public void setNetworkSize(Integer networkSize) {
		this.networkSize = networkSize;
	}

	public Double getMinInterestRate() {
		return minInterestRate;
	}

	public void setMinInterestRate(Double minInterestRate) {
		this.minInterestRate = minInterestRate;
	}

	public Double getMaxInterestRate() {
		return maxInterestRate;
	}

	public void setMaxInterestRate(Double maxInterestRate) {
		this.maxInterestRate = maxInterestRate;
	}

	public Double getMinLoanAmount() {
		return minLoanAmount;
	}

	public void setMinLoanAmount(Double minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}

	public Double getMaxLoanAmount() {
		return maxLoanAmount;
	}

	public void setMaxLoanAmount(Double maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}

	public Integer getMaxRepayPeriod() {
		return maxRepayPeriod;
	}

	public void setMaxRepayPeriod(Integer maxRepayPeriod) {
		this.maxRepayPeriod = maxRepayPeriod;
	}

	public Integer getPeriodToDefaulting() {
		return periodToDefaulting;
	}

	public void setPeriodToDefaulting(Integer periodToDefaulting) {
		this.periodToDefaulting = periodToDefaulting;
	}

	public Integer getActiveBorrowPeriod() {
		return activeBorrowPeriod;
	}

	public void setActiveBorrowPeriod(Integer activeBorrowPeriod) {
		this.activeBorrowPeriod = activeBorrowPeriod;
	}

}
