package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "languages")
public class Language {

	@Id
	@GeneratedValue
	@Column(name = "language_id")
	private long languageId;
	
	@NotEmpty
	@Column(name = "language_name", nullable= false, length= 20, unique=true, columnDefinition = "varchar(20) default null")
	private String languageName;
	
	@Column(name = "is_default", nullable=false, length= 11, columnDefinition = "int(11) default '0'")
	private Integer isDefault=0;
	
	public Language(){
		
	}

	public long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(long languageId) {
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
}
