package anathatest.model;

import java.io.Serializable;

public class Messages implements Serializable {

	private int messageId;
	private int languageId;
	private int messageCode;
	private String messageText;
	private String messageDesc;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(int messageCode) {
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
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Message Id: " + messageId + ";");
		buffer.append("Language Id: " + languageId + ";");
		buffer.append("Message Code: " + messageCode + ";");
		buffer.append("Message Text: " + messageText + ";");
		buffer.append("Message Description: " + messageDesc);
		return buffer.toString();
	}
}
