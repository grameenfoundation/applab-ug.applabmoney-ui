package applabmoneyaui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ME2ME_GOAL_TYPES")
public class MeToMeGoalType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GOAL_TYPE_ID")
	private Long goalTypeId;

	@Column(name = "GOAL_TYPE_CODE", nullable = true, length = 20)
	private String goalTypeCode;

	@Column(name = "GOAL_TYPE_NAME", nullable = true, length = 30)
	private String goalTypeName;

	@Column(name = "GOAL_TYPE_DESC", nullable = false, length = 50)
	private String goalTypeDescription;

	public MeToMeGoalType() {

	}

	public MeToMeGoalType(String goalTypeCode, String goalTypeName,
			String goalTypeDescription) {

		this.goalTypeCode = goalTypeCode;
		this.goalTypeName = goalTypeName;
		this.goalTypeDescription = goalTypeDescription;
	}

	public Long getGoalTypeId() {
		return goalTypeId;
	}

	public void setGoalTypeId(Long goalTypeId) {
		this.goalTypeId = goalTypeId;
	}

	public String getGoalTypeCode() {
		return goalTypeCode;
	}

	public void setGoalTypeCode(String goalTypeCode) {
		this.goalTypeCode = goalTypeCode;
	}

	public String getGoalTypeName() {
		return goalTypeName;
	}

	public void setGoalTypeName(String goalTypeName) {
		this.goalTypeName = goalTypeName;
	}

	public String getGoalTypeDescription() {
		return goalTypeDescription;
	}

	public void setGoalTypeDescription(String goalTypeDescription) {
		this.goalTypeDescription = goalTypeDescription;
	}
}
