package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "MEMO_GROUPS")
public class MemoGroup {

	@Id
	@GeneratedValue
	@Column(name = "MEMO_GROUP_ID")
	private Long memoGroupId;

	@NotEmpty
	@Column(name = "MEMO_GROUP_CODE", nullable = false, length = 20)
	private String memoGroupCode;

	@NotEmpty
	@Column(name = "MEMO_GROUP_NAME", nullable = false, length = 50)
	private String memoGroupName;

	@NotEmpty
	@Column(name = "MEMO_GROUP_DESC", nullable = false, length = 11)
	private String memoGroupDescription;

	@Column(name = "ENABLED_FLG", nullable = false, length = 11)
	private Integer enabledFlag;

	public MemoGroup() {

	}

	public Long getMemoGroupId() {
		return memoGroupId;
	}

	public void setMemoGroupId(Long memoGroupId) {
		this.memoGroupId = memoGroupId;
	}

	public String getMemoGroupCode() {
		return memoGroupCode;
	}

	public void setMemoGroupCode(String memoGroupCode) {
		this.memoGroupCode = memoGroupCode;
	}

	public String getMemoGroupName() {
		return memoGroupName;
	}

	public void setMemoGroupName(String memoGroupName) {
		this.memoGroupName = memoGroupName;
	}

	public String getMemoGroupDescription() {
		return memoGroupDescription;
	}

	public void setMemoGroupDescription(String memoGroupDescription) {
		this.memoGroupDescription = memoGroupDescription;
	}

	public Integer getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Integer enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
}
