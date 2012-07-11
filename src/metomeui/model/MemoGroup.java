package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "memo_groups")
public class MemoGroup {
	
	@Id
	@GeneratedValue
	@Column(name = "memo_group_id")
	private long memoGroupId;

	@NotEmpty
	@Column(name = "memo_group_code", nullable = false, length = 20)
	private String memoGroupCode;

	@NotEmpty
	@Column(name = "memo_group_name", nullable = false, length = 50)
	private String memoGroupName;

	@NotEmpty
	@Column(name = "memo_group_desc", nullable = false, length = 11)
	private String memoGroupDescription;
	
	public MemoGroup(){
		
	}

	public long getMemoGroupId() {
		return memoGroupId;
	}

	public void setMemoGroupId(long memoGroupId) {
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

	@Column(name = "enabled_flg", nullable = false, length = 11)
	private Integer enabledFlag;

}
