package metomeui.model;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "predef_inputs")
public class UssdPredefInput {

	@Id
	@GeneratedValue
	@Column(name = "PREDEF_INPUT_ID")
	private Integer predefInputId;

	@NotEmpty
	@Size(min = 6, max = 20)
	@Column(name = "PREDEF_INPUT_NAME", nullable = false, length = 20)
	private String predefInputName;

	@NotEmpty
	@Size(min = 8, max = 160)
	@Column(name = "PREDEF_INPUT_DESC", nullable = false, length = 20)
	private String predefInputDescription;
	
	public UssdPredefInput() {

	}

	public Integer getPredefInputId() {
		return predefInputId;
	}

	public void setPredefInputId(Integer predefInputId) {
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

	
}
