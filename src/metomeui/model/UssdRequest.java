package metomeui.model;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ussd_requests")
public class UssdRequest {

	@Id
	@GeneratedValue
	@Column(name = "REQUEST_ID")
	private Integer requestId;

	@NotEmpty
	@Size(min = 6, max = 20)
	@Column(name = "REQUEST_TIMESTAMP", nullable = true, length = 11)
	private String requestTimestamp;
	

	@NotEmpty
	@Size(min = 1, max = 11)
	@Column(name = "TRANSACTION_ID", nullable = false, length = 11)
	private String transactionId;

	@NotEmpty
	@Size(min = 1, max = 20)
	@Column(name = "SOURCE_MSISDN", nullable = false, length = 11)
	private String sourceMsisdn;
	
	@NotEmpty
	@Size(min = 1, max = 5000)
	@Column(name = "REQUEST_THREAD", nullable = false, length = 5000)
	private String requestThread;
	
	@NotEmpty
	@Size(min = 1, max = 11)
	@Column(name = "IS_COMPLETED", nullable = false, length = 11)
	private Integer isCompleted;
	
	@Column(name = "FINAL_TRANS_KEYWORD", nullable = true, length = 500)
	private String finalTransKeyword;

	public UssdRequest() {
		
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public String getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(String requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSourceMsisdn() {
		return sourceMsisdn;
	}

	public void setSourceMsisdn(String sourceMsisdn) {
		this.sourceMsisdn = sourceMsisdn;
	}

	public String getRequestThread() {
		return requestThread;
	}

	public void setRequestThread(String requestThread) {
		this.requestThread = requestThread;
	}

	public Integer getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Integer isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getFinalTransKeyword() {
		return finalTransKeyword;
	}

	public void setFinalTransKeyword(String finalTransKeyword) {
		this.finalTransKeyword = finalTransKeyword;
	}
	
}
