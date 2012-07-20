package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "KEYWORD_STEPS")
public class UssdKeywordStep {

	@Id
	@GeneratedValue
	@Column(name = "KEYWORD_STEP_ID")
	private Long keywordStepId;

	@ManyToOne
	@JoinColumn(name = "KEYWORD_ID", nullable = false)
	private UssdTransactionKeyword transactionKeyword;

	@NotEmpty
	@Size(min = 6, max = 100)
	@Column(name = "STEP_MENU_NAME", nullable = false, length = 100)
	private String stepMenuName;

	@NotEmpty
	@Size(min = 1, max = 11)
	@Column(name = "STEP_NUMBER", nullable = false, length = 20)
	private Integer stepMenuNumber;

	@Column(name = "IS_FIRST_STEP", nullable = true, length = 1)
	private Integer isFirstStepFlag;

	@Column(name = "IS_LAST_STEP", nullable = true, length = 1)
	private Integer isLastStepFlag;

	@Size(min = 1, max = 11)
	@Column(name = "USE_FIXED_VALUE", nullable = true, length = 11)
	private Integer useFixedValueFlag;

	@Size(min = 1, max = 50)
	@Column(name = "FIXED_VALUE", nullable = true, length = 50)
	private String fixedValue;

	@Column(name = "HAS_PREDEF_INPUT", nullable = true, length = 11)
	private Integer hasPredefInputFlag;

	@ManyToOne
	@JoinColumn(name = "PREDEF_INPUT_ID", nullable = true)
	private UssdPredefInput predefInput;

	public UssdKeywordStep() {

	}

	public UssdKeywordStep(String stepMenuName, Integer stepMenuNumber,
			Integer isFirstStepFlag, Integer isLastStepFlag,
			Integer useFixedValueFlag, String fixedValue,
			Integer hasPredefInputFlag) {
		this.stepMenuName = stepMenuName;
		this.stepMenuNumber = stepMenuNumber;
		this.isFirstStepFlag = isFirstStepFlag;
		this.isLastStepFlag = isLastStepFlag;
		this.useFixedValueFlag = useFixedValueFlag;
		this.fixedValue = fixedValue;
		this.hasPredefInputFlag = hasPredefInputFlag;
		this.predefInput = new UssdPredefInput();
	}

	public Long getKeywordStepId() {
		return keywordStepId;
	}

	public void setKeywordStepId(Long keywordStepId) {
		this.keywordStepId = keywordStepId;
	}

	public String getStepMenuName() {
		return stepMenuName;
	}

	public void setStepMenuName(String stepMenuName) {
		this.stepMenuName = stepMenuName;
	}

	public Integer getStepMenuNumber() {
		return stepMenuNumber;
	}

	public void setStepMenuNumber(Integer stepMenuNumber) {
		this.stepMenuNumber = stepMenuNumber;
	}

	public Integer getIsFirstStepFlag() {
		return isFirstStepFlag;
	}

	public void setIsFirstStepFlag(Integer isFirstStepFlag) {
		if (isFirstStepFlag == null) {
			isFirstStepFlag = 0;
		}
		this.isFirstStepFlag = isFirstStepFlag;
	}

	public Integer getIsLastStepFlag() {
		return isLastStepFlag;
	}

	public void setIsLastStepFlag(Integer isLastStepFlag) {
		if (isLastStepFlag == null) {
			isLastStepFlag = 0;
		}
		this.isLastStepFlag = isLastStepFlag;
	}

	public Integer getUseFixedValueFlag() {
		return useFixedValueFlag;
	}

	public void setUseFixedValueFlag(Integer useFixedValueFlag) {
		if (useFixedValueFlag == null) {
			useFixedValueFlag = 0;
		}
		this.useFixedValueFlag = useFixedValueFlag;
	}

	public String getFixedValue() {
		return fixedValue;
	}

	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}

	public Integer getHasPredefInputFlag() {
		return hasPredefInputFlag;
	}

	public void setHasPredefInputFlag(Integer hasPredefInputFlag) {
		this.hasPredefInputFlag = hasPredefInputFlag;
	}

	public UssdTransactionKeyword getTransactionKeyword() {
		return transactionKeyword;
	}

	public void setTransactionKeyword(UssdTransactionKeyword transactionKeyword) {
		this.transactionKeyword = transactionKeyword;
	}

	public UssdPredefInput getPredefInput() {
		return predefInput;
	}

	public void setPredefInput(UssdPredefInput predefInput) {
		this.predefInput = predefInput;
	}
}
