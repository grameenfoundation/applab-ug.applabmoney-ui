package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "GLOBAL_AML_BARRING")
public class AmlBarring {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BARRING_ID")
	private Long barringId;
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_TYPE_ID", nullable = true)
	private AccountType accountType;

	@ManyToOne
	@JoinColumn(name = "KEYWORD_ID", nullable = false)
	private UssdTransactionKeyword transactionKeyword;

	@Column(name = "ALLOW_SEND", nullable = true)
	private Integer allowSend;

	@Column(name = "ALLOW_RECEIVE", nullable = true)
	private Integer allowReceive;

	public AmlBarring() {

	}

	public Integer getAllowReceive() {
		return allowReceive;
	}

	public void setAllowReceive(Integer allowReceive) {
		this.allowReceive = allowReceive;
	}

	public Integer getAllowSend() {
		return allowSend;
	}

	public void setAllowSend(Integer allowSend) {
		this.allowSend = allowSend;
	}

	public Long getBarringId() {
		return barringId;
	}

	public void setBarringId(Long barringId) {
		this.barringId = barringId;
	}

	public UssdTransactionKeyword getTransactionKeyword() {
		return transactionKeyword;
	}

	public void setTransactionKeyword(UssdTransactionKeyword transactionKeyword) {
		this.transactionKeyword = transactionKeyword;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}