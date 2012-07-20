package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "NDC_LIST_OFFNET")
public class NdcListOffnet {

	@Id
	@GeneratedValue
	@Column(name = "NDC_LIST_ID")
	private Long ndcListId;
	
	@NotEmpty
	@Column(name = "NDC", nullable = false, length = 11, unique = true)
	private Integer ndc;
	
	@Column(name = "NETWORK_OPERATOR", nullable = true, length = 50)
	private String networkOperator;
	
	@NotEmpty
	@Column(name = "ENABLED_FLG", nullable = false, length = 11)
	private Integer enabledFlag;
	
	public NdcListOffnet(){
		
	}

	public Long getNdcListId() {
		return ndcListId;
	}

	public void setNdcListId(Long ndcListOffnetId) {
		this.ndcListId = ndcListOffnetId;
	}

	public Integer getNdc() {
		return ndc;
	}

	public void setNdc(Integer ndc) {
		this.ndc = ndc;
	}

	public String getNetworkOperator() {
		return networkOperator;
	}

	public void setNetworkOperator(String networkOperator) {
		this.networkOperator = networkOperator;
	}

	public Integer getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Integer enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	
}
