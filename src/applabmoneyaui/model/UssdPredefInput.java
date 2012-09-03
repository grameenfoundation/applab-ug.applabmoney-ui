package applabmoneyaui.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import applabmoneyaui.model.UssdKeywordStep;
import applabmoneyaui.model.UssdPredefInputItem;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PREDEF_INPUTS")
public class UssdPredefInput {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PREDEF_INPUT_ID")
	private Long predefInputId;

	@NotEmpty
	@Size(min = 6, max = 20)
	@Column(name = "PREDEF_INPUT_NAME", nullable = false, length = 20)
	private String predefInputName;

	@NotEmpty
	@Size(min = 8, max = 160)
	@Column(name = "PREDEF_INPUT_DESC", nullable = false, length = 20)
	private String predefInputDescription;

	@OneToMany(targetEntity = UssdPredefInputItem.class, mappedBy = "predefInput", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PREDEF_INPUT_ID", insertable = false, updatable = false, nullable = true)
	private List<UssdPredefInputItem> predefInputItems;

	@OneToMany(targetEntity = UssdKeywordStep.class, mappedBy = "predefInput", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PREDEF_INPUT_ID", insertable = false, updatable = false, nullable = true)
	private List<UssdKeywordStep> keywordSteps;

	public UssdPredefInput() {
		this.predefInputItems = new ArrayList<UssdPredefInputItem>();
		this.keywordSteps = new ArrayList<UssdKeywordStep>();
	}

	public UssdPredefInput(String predefInputName, String predefInputDescription) {
		this.predefInputName = predefInputName;
		this.predefInputDescription = predefInputDescription;
		this.predefInputItems = new ArrayList<UssdPredefInputItem>();
		this.keywordSteps = new ArrayList<UssdKeywordStep>();
	}

	public List<UssdPredefInputItem> getPredefInputItems() {
		return predefInputItems;
	}

	public void setPredefInputItems(List<UssdPredefInputItem> predefInputItems) {
		this.predefInputItems = predefInputItems;
	}

	public Long getPredefInputId() {
		return predefInputId;
	}

	public void setPredefInputId(Long predefInputId) {
		this.predefInputId = predefInputId;
	}

	public String getPredefInputName() {
		return predefInputName;
	}

	public void setPredefInputName(String predefInputName) {
		this.predefInputName = predefInputName;
	}

	public String getPredefInputDescription() {
		return predefInputDescription;
	}

	public void setPredefInputDescription(String predefInputDescription) {
		this.predefInputDescription = predefInputDescription;
	}

	public List<UssdKeywordStep> getKeywordSteps() {
		return keywordSteps;
	}

	public void setKeywordSteps(List<UssdKeywordStep> keywordSteps) {
		this.keywordSteps = keywordSteps;
	}
}