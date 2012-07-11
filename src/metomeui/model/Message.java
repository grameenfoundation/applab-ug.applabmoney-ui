package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {


	@Id
	@GeneratedValue
	@Column(name = "message_id")
	private long messageId;
	
	@Column(name = "language_id", nullable= true, length= 11)
	private Integer languageId;
	
	@Column(name = "message_code", nullable=false, length= 11)
	private Integer messageCode;
	
	@Column(name = "message_text", nullable=false, length= 500)
	private String messageText;
	
	@Column(name = "message_desc", nullable=false, length= 500)
	private String messageDesc;
	
	public Message(){
		
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
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

	
	
	/*public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Message Id: " + messageId + ";");
		buffer.append("Language Id: " + languageId + ";");
		buffer.append("Message Code: " + messageCode + ";");
		buffer.append("Message Text: " + messageText + ";");
		buffer.append("Message Description: " + messageDesc);
		return buffer.toString();
	}*/
}
