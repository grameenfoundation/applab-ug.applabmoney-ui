package applabmoneyaui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import applabmoneyaui.model.Language;

@Entity
@Table(name = "MESSAGES")
public class Message {


	@Id
	@GeneratedValue
	@Column(name = "MESSAGE_ID")
	private Long messageId;
	
	@Column(name = "MESSAGE_CODE", nullable=false, length= 11)
	private Integer messageCode;
	
	@Column(name = "MESSAGE_TEXT", nullable=false, length= 500)
	private String messageText;
	
	@Column(name = "MESSAGE_DESC", nullable=false, length= 500)
	private String messageDesc;
	
	@ManyToOne
	@JoinColumn(name = "LANGUAGE_ID", nullable = true)
	private Language language;
	
	public Message(){
		
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Integer getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(Integer messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getMessageDesc() {
		return messageDesc;
	}

	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
