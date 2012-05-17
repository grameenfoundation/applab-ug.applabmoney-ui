package metomeui.model;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "keyword_steps")
public class UssdKeywordStep {

	@Id
	@GeneratedValue
	@Column(name = "KEYWORD_STEP_ID")
	private Integer keywordStepId;

	@Id
	@Column(name = "KEYWORD_ID")
	private Integer keywordId;

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

	@NotEmpty
	@Size(min = 1, max = 50)
	@Column(name = "FIXED_VALUE", nullable = true, length = 50)
	private String fixedValue;

	@NotEmpty
	@Column(name = "HAS_PREDEF_INPUT", nullable = true, length = 11)
	private Integer hasPredefInputFlag;

	@NotEmpty
	@Size(min = 1, max = 50)
	@Column(name = "PREDEF_INPUT_ID", nullable = true, length = 50)
	private String predefInputId;

	public UssdKeywordStep() {

	}

	public Integer getKeywordStepId() {
		return keywordStepId;
	}

	public void setKeywordStepId(Integer keywordStepId) {
		this.keywordStepId = keywordStepId;
	}

	public Integer getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Integer keywordId) {
		this.keywordId = keywordId;
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
		this.isFirstStepFlag = isFirstStepFlag;
	}

	public Integer getIsLastStepFlag() {
		return isLastStepFlag;
	}

	public void setIsLastStepFlag(Integer isLastStepFlag) {
		this.isLastStepFlag = isLastStepFlag;
	}

	public Integer getUseFixedValueFlag() {
		return useFixedValueFlag;
	}

	public void setUseFixedValueFlag(Integer useFixedValueFlag) {
		this.useFixedValueFlag = useFixedValueFlag;
	}

	public String getFixedValue() {
		return fixedValue;
	}

	public void setFixedValueFlag(String fixedValue) {
		this.fixedValue = fixedValue;
	}

	public String getPredefInputId() {
		return predefInputId;
	}

	public void setPredefInputId(String predefInputId) {
		this.predefInputId = predefInputId;
	}

	public Integer getHasPredefInputFlag() {
		return hasPredefInputFlag;
	}

	public void setHasPredefInputFlag(Integer hasPredefInputFlag) {
		this.hasPredefInputFlag = hasPredefInputFlag;
	}
}
