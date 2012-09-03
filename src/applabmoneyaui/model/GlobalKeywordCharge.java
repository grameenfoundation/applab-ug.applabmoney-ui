package applabmoneyaui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import applabmoneyaui.model.UssdTransactionKeyword;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "GLOBAL_KEYWORD_CHARGES")
public class GlobalKeywordCharge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHARGE_ID")
	private Long chargeId;

	@ManyToOne
	@JoinColumn(name = "KEYWORD_ID", nullable = false)
	private UssdTransactionKeyword transactionKeyword;

	@Transient
	private Integer chargeMode;
	
	@NotEmpty
	@Column(name = "LOW_RANGE", nullable = false, precision = 2)
	private Double lowRange;

	@NotEmpty
	@Column(name = "HIGH_RANGE", nullable = false, precision = 2)
	private Double highRange;

	@NotEmpty
	@Column(name = "CHARGE_FIXED", nullable = false, precision = 2)
	private Double chargeFixed;

	@NotEmpty
	@Column(name = "CHARGE_PERCENT", nullable = false, precision = 2)
	private Double chargePercent;

	public GlobalKeywordCharge() {

	}

	public GlobalKeywordCharge(UssdTransactionKeyword transactionKeyword,
			Double lowRange, Double highRange, Double chargeFixed,
			Double chargePercent) {
		this.transactionKeyword = transactionKeyword;
		this.lowRange = lowRange;
		this.highRange = highRange;
		this.chargeFixed = chargeFixed;
		this.chargePercent = chargePercent;
	}

	public Long getChargeId() {
		return chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}

	public UssdTransactionKeyword getTransactionKeyword() {
		return transactionKeyword;
	}

	public void setTransactionKeyword(UssdTransactionKeyword transactionKeyword) {
		this.transactionKeyword = transactionKeyword;
	}

	public Double getLowRange() {
		return lowRange;
	}

	public void setLowRange(Double lowRange) {
		this.lowRange = lowRange;
	}

	public Double getHighRange() {
		return highRange;
	}

	public void setHighRange(Double highRange) {
		this.highRange = highRange;
	}

	public Double getChargeFixed() {
		return chargeFixed;
	}

	public void setChargeFixed(Double chargeFixed) {
		this.chargeFixed = chargeFixed;
	}

	public Double getChargePercent() {
		return chargePercent;
	}

	public void setChargePercent(Double chargePercent) {
		this.chargePercent = chargePercent;
	}

	public Integer getChargeMode() {
		return chargeMode;
	}

	public void setChargeMode(Integer chargeMode) {
		this.chargeMode = chargeMode;
	}

}
