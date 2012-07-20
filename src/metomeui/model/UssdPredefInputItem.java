package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PREDEF_INPUT_ITEMS")
public class UssdPredefInputItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INPUT_ITEM_ID")
	private Long inputItemId;

	@ManyToOne
	@JoinColumn(name = "PREDEF_INPUT_ID", nullable = false)
	private UssdPredefInput predefInput;

	@NotEmpty
	@Size(min = 6, max = 100)
	@Column(name = "INPUT_ITEM_NAME", unique = true, nullable = false, length = 100)
	private String predefInputItemName;

	@NotEmpty
	@Size(min = 6, max = 100)
	@Column(name = "INPUT_ITEM_CODE", unique = true, nullable = false, length = 100)
	private String predefInputItemCode;

	@NotEmpty
	@Size(min = 1, max = 11)
	@Column(name = "INPUT_ITEM_ORDER", nullable = false, length = 11)
	private Integer predefInputItemOrder;

	@Column(name = "ENABLED_FLG", nullable = true)
	private Integer predefInputItemEnabledFlag = 0;

	public UssdPredefInputItem() {
	}

	public UssdPredefInputItem(String predefInputItemCode,
			String predefInputItemName, Integer predefInputItemOrder,
			Integer predefInputItemEnabledFlag) {
		this.predefInputItemCode = predefInputItemCode;
		this.predefInputItemName = predefInputItemName;
		this.predefInputItemOrder = predefInputItemOrder;
		this.predefInputItemEnabledFlag = predefInputItemEnabledFlag;
	}

	public String getPredefInputItemName() {
		return predefInputItemName;
	}

	public void setPredefInputItemName(String predefInputItemName) {
		this.predefInputItemName = predefInputItemName;
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

	public Long getInputItemId() {
		return inputItemId;
	}

	public void setInputItemId(Long inputItemId) {
		this.inputItemId = inputItemId;
	}

	public UssdPredefInput getPredefInput() {
		return predefInput;
	}

	public void setPredefInput(UssdPredefInput predefInput) {
		this.predefInput = predefInput;
	}
}