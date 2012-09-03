package applabmoneyaui.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import applabmoneyaui.model.Message;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "LANGUAGES")
public class Language {

	@Id
	@GeneratedValue
	@Column(name = "LANGUAGE_ID")
	private Long languageId;
	
	@NotEmpty
	@Column(name = "LANGUAGE_NAME", nullable= false, length= 20, unique=true, columnDefinition = "varchar(20) default null")
	private String languageName;
	
	@Column(name = "IS_DEFAULT", nullable=false, length= 11)
	private Integer isDefault;
	
	@OneToMany(targetEntity = Message.class, mappedBy = "language", fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGUAGE_ID", insertable = false, updatable = false, nullable = true)
	private List<Message> messages;
	
	public Language(){
		
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
