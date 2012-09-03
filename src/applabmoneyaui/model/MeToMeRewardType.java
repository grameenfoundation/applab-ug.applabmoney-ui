package applabmoneyaui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ME2ME_REWARD_TYPES")
public class MeToMeRewardType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REWARD_TYPE_ID")
	private Long rewardTypeId;

	@Column(name = "REWARD_TYPE_CODE", nullable = true, length = 20)
	private String rewardTypeCode;

	@Column(name = "REWARD_TYPE_NAME", nullable = true, length = 30)
	private String rewardTypeName;

	@Column(name = "REWARD_TYPE_DESC", nullable = false, length = 50)
	private String rewardTypeDescription;

	@Column(name = "IS_CASH_REWARD", nullable = true, length = 11)
	private Integer cashRewardFlag;

	public MeToMeRewardType() {

	}

	public MeToMeRewardType(String rewardTypeCode, String rewardTypeName,
			String rewardTypeDescription, Integer cashRewardFlag) {
		this.rewardTypeCode = rewardTypeCode;
		this.rewardTypeName = rewardTypeName;
		this.rewardTypeDescription = rewardTypeDescription;
	}

	public Long getRewardTypeId() {
		return rewardTypeId;
	}

	public void setRewardTypeId(Long rewardTypeId) {
		this.rewardTypeId = rewardTypeId;
	}

	public String getRewardTypeCode() {
		return rewardTypeCode;
	}

	public void setRewardTypeCode(String rewardTypeCode) {
		this.rewardTypeCode = rewardTypeCode;
	}

	public String getRewardTypeName() {
		return rewardTypeName;
	}

	public void setRewardTypeName(String rewardTypeName) {
		this.rewardTypeName = rewardTypeName;
	}

	public String getRewardTypeDescription() {
		return rewardTypeDescription;
	}

	public void setRewardTypeDescription(String rewardTypeDescription) {
		this.rewardTypeDescription = rewardTypeDescription;
	}

	public Integer getCashRewardFlag() {
		return cashRewardFlag;
	}

	public void setCashRewardFlag(Integer cashRewardFlag) {
		this.cashRewardFlag = cashRewardFlag;
	}
}
