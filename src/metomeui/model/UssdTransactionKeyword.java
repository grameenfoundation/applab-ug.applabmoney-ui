package metomeui.model;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "transaction_keywords")
public class UssdTransactionKeyword {

	@Id
	@GeneratedValue
	@Column(name = "KEYWORD_ID")
	private Integer keywordId;

	@NotEmpty
	@Size(min = 6, max = 100)
	@Column(name = "KEYWORD_NAME", nullable = false, length = 100)
	private String keywordName;

	@NotEmpty
	@Size(min = 3, max = 10)
	@Column(name = "KEYWORD_CODE", nullable = false, length = 10)
	private String keywordCode;

	@Size(min = 2, max = 100)
	@Column(name = "KEYWORD_DESC", nullable = true, length = 100)
	private String keywordDescription;

	@Size(min = 1, max = 11)
	@Column(name = "STEPS_COUNT", nullable = true, length = 11)
	private Integer keywordStepsCount;

	@Column(name = "ENABLED_FLG", nullable = true)
	private Integer keywordEnabledFlag;

	public UssdTransactionKeyword() {

	}

	public Integer getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Integer keywordId) {
		this.keywordId = keywordId;
	}

	public String getKeywordName() {
		return keywordName;
	}

	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

	public String getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(String keywordCode) {
		this.keywordCode = keywordCode;
	}

	public String getKeywordDescription() {
		return keywordDescription;
	}

	public void setKeywordDescription(String keywordDescription) {
		this.keywordDescription = keywordDescription;
	}

	public Integer getKeywordStepsCount() {
		return keywordStepsCount;
	}

	public void setKeywordStepsCount(Integer keywordStepsCount) {
		this.keywordStepsCount = keywordStepsCount;
	}

	public Integer getKeywordEnabledFlag() {
		return keywordEnabledFlag;
	}

	public void setKeywordEnabledFlag(Integer keywordEnabledFlag) {
		this.keywordEnabledFlag = keywordEnabledFlag;
	}
}
