package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ndc_list_p2p")
@SecondaryTable(name = "ndc_list_offnet")
public class NdcList {

	@Id
	@GeneratedValue
	@Column(name = "ndc_list_id")
	private Integer ndcListId;
	
	@NotEmpty
	@Column(name = "ndc", nullable = false, length = 11, unique = true)
	private Integer ndc;
	
	@Column(table="ndc_list_offnet", name = "networkOperator", nullable = false, length = 50)
	private String networkOperator;
	
	@NotEmpty
	@Column(name = "enabled_flg", nullable = false, length = 11)
	private Integer enabledFlag;
	
	public NdcList(){
		
	}

	public Integer getNdcListId() {
		return ndcListId;
	}

	public void setNdcListId(Integer ndcListId) {
		this.ndcListId = ndcListId;
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
