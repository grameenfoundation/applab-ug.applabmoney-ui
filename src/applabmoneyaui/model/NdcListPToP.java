package applabmoneyaui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "NDC_LIST_P2P")
public class NdcListPToP {

	@Id
	@GeneratedValue
	@Column(name = "NDC_LIST_ID")
	private Long ndcListId;
	
	@NotEmpty
	@Column(name = "NDC", nullable = false, length = 11, unique = true)
	private Integer ndc;
	
	@NotEmpty
	@Column(name = "ENABLED_FLG", nullable = false, length = 11)
	private Integer enabledFlag;
	
	public NdcListPToP(){
		
	}

	public Long getNdcListId() {
		return ndcListId;
	}

	public void setNdcListId(Long ndcListId) {
		this.ndcListId = ndcListId;
	}

	public Integer getNdc() {
		return ndc;
	}

	public void setNdc(Integer ndc) {
		this.ndc = ndc;
	}

	public Integer getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Integer enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	
}
