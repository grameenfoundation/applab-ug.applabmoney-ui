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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import applabmoneyaui.model.UssdMenuItem;
import applabmoneyaui.model.UssdTransactionKeyword;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USSD_MENU_ITEMS")
public class UssdMenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MENU_ITEM_ID")
	private Long menuItemId;

	@OneToMany(targetEntity = UssdMenuItem.class, mappedBy = "rootMenuItem", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PARENT_MENU_ID", insertable = false, updatable = false, nullable = true)
	private List<UssdMenuItem> menuItems;

	@ManyToOne
	@JoinColumn(name = "PARENT_MENU_ID", nullable = true)
	private UssdMenuItem rootMenuItem;

	@ManyToOne
	@JoinColumn(name = "KEYWORD_ID", nullable = true)
	private UssdTransactionKeyword menuItemKeyword;

	@NotEmpty
	@Column(name = "MENU_ITEM_ORDER", nullable = true, length = 11)
	private Integer menuItemOrder;

	@NotEmpty
	@Column(name = "MENU_ITEM_NAME", nullable = true, length = 100)
	private String menuItemName;

	@Column(name = "ENABLED_FLG", nullable = true)
	private Integer menuItemEnabledFlag;

	public UssdMenuItem() {

	}

	public UssdMenuItem(String menuItemName, Integer menuItemOrder,
			Integer menuItemEnabledFlag) {
		this.menuItemName = menuItemName;
		this.menuItemOrder = menuItemOrder;
		this.menuItemKeyword = new UssdTransactionKeyword();
		this.rootMenuItem = new UssdMenuItem();
		this.menuItems = new ArrayList<UssdMenuItem>();
	}

	public Long getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Long menuItemId) {
		this.menuItemId = menuItemId;
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

	public Integer getMenuItemEnabledFlag() {
		return menuItemEnabledFlag;
	}

	public void setMenuItemEnabledFlag(Integer menuItemEnabledFlag) {
		this.menuItemEnabledFlag = menuItemEnabledFlag;
	}

	public UssdMenuItem getRootMenuItem() {
		return rootMenuItem;
	}

	public void setRootMenuItem(UssdMenuItem rootMenuItem) {
		this.rootMenuItem = rootMenuItem;
	}

	public UssdTransactionKeyword getMenuItemKeyword() {
		return menuItemKeyword;
	}

	public void setMenuItemKeyword(UssdTransactionKeyword menuItemKeyword) {
		this.menuItemKeyword = menuItemKeyword;
	}

	public List<UssdMenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<UssdMenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}
