package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USERS")
public class Login {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long userId;

	@NotEmpty
	@Column(name = "USER_NAME", nullable = false, length = 20)
	public String userName;

	@NotEmpty
	@Column(name = "PASSWORD", nullable = false, length = 20)
	public String password;

	public Login() {

	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void clearFields() {
		this.userName = "";
		this.password = "";
	}
}