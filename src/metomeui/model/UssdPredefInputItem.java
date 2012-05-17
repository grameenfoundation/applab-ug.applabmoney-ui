package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "predef_input_items")
public class UssdPredefInputItem {

	@Id
	@GeneratedValue
	@Column(name = "INPUT_ITEM_ID")
	private Integer inputItemId;
	
	@Column(name = "PREDEF_INPUT_ID")
	private Integer predefInputId;

	@NotEmpty
	@Size(min = 6, max = 100)
	@Column(name = "INPUT_ITEM_NAME", nullable = false, length = 100)
	private String predefInputItemName;

	@NotEmpty
	@Size(min = 6, max = 100)
	@Column(name = "INPUT_ITEM_CODE", nullable = false, length = 100)
	private String predefInputItemCode;

	@NotEmpty
	@Size(min = 1, max = 11)
	@Column(name = "INPUT_ITEM_ORDER", nullable = false, length = 11)
	private Integer predefInputItemOrder;
	
	@Column(name = "ENABLED_FLG", nullable = false)
	private Integer predefInputItemEnabledFlag;

	public UssdPredefInputItem() {

	}

	
	public Integer getInputItemId() {
		return inputItemId;
	}

	public void setInputItemId(Integer inputItemId) {
		this.inputItemId = inputItemId;
	}

	public Integer getPredefInputId() {
		return predefInputId;
	}

	public void setPredefInputId(Integer predefInputId) {
		this.predefInputId = predefInputId;
	}

	public String getPredefInputItemCode() {
		return predefInputItemCode;
	}

	public void setPredefInputItemCode(String predefInputItemCode) {
		this.predefInputItemCode = predefInputItemCode;
	}

	public Integer getPredefInputItemOrder() {
		return predefInputItemOrder;
	}

	public void setPredefInputItemOrder(Integer predefInputItemOrder) {
		this.predefInputItemOrder = predefInputItemOrder;
	}

	public Integer getPredefInputItemEnabledFlag() {
		return predefInputItemEnabledFlag;
	}

	public void setPredefInputItemEnabledFlag(Integer predefInputItemEnabledFlag) {
		this.predefInputItemEnabledFlag = predefInputItemEnabledFlag;
	}

	public String getPredefInputItemName() {
		return predefInputItemName;
	}

	public void setPredefInputItemName(String predefInputItemName) {
		this.predefInputItemName = predefInputItemName;
	}

	
}
