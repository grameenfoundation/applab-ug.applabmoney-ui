package metomeui.model;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ussd_menu_items")
public class UssdMenuItem {

	@Id
	@GeneratedValue
	@Column(name = "MENU_ITEM_ID")
	private Integer menuItemId;

	@NotEmpty
	@Size(min = 6, max = 20)
	@Column(name = "PARENT_MENU_ID", nullable = true, length = 11)
	private Integer menuItemParentId;

	@NotEmpty
	@Size(min = 1, max = 11)
	@Column(name = "KEYWORD_ID", nullable = true, length = 11)
	private Integer menuItemKeywordId;

	@NotEmpty
	@Size(min = 1, max = 11)
	@Column(name = "MENU_ITEM_ORDER", nullable = true, length = 11)
	private Integer menuItemOrder;
	
	@NotEmpty
	@Size(min = 8, max = 20)
	@Column(name = "MENU_ITEM_NAME", nullable = true, length = 100)
	private String menuItemName;
	
	@Column(name = "ENABLED_FLG", nullable = true)
	private Integer menuItemEnabledFlag;
	
	public UssdMenuItem(){
		
	}

	public Integer getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Integer menuItemId) {
		this.menuItemId = menuItemId;
	}

	public Integer getMenuItemKeywordId() {
		return menuItemKeywordId;
	}

	public void setMenuItemKeywordId(Integer menuItemKeywordId) {
		this.menuItemKeywordId = menuItemKeywordId;
	}

	public Integer getMenuItemOrder() {
		return menuItemOrder;
	}

	public void setMenuItemOrder(Integer menuItemOrder) {
		this.menuItemOrder = menuItemOrder;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public Integer getMenuItemParentId() {
		return menuItemParentId;
	}

	public void setMenuItemParentId(Integer menuItemParentId) {
		this.menuItemParentId = menuItemParentId;
	}

	public Integer getMenuItemEnabledFlag() {
		return menuItemEnabledFlag;
	}

	public void setMenuItemEnabledFlag(Integer menuItemEnabledFlag) {
		this.menuItemEnabledFlag = menuItemEnabledFlag;
	}

	
}
