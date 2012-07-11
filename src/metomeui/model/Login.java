package metomeui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Login {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer userId;

	@NotEmpty
	@Column(name = "user_name", nullable = false, length = 20)
	public String userName;

	@NotEmpty
	@Column(name = "password", nullable = false, length = 20)
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

	public void clearFields() {
		this.userName = "";
		this.password = "";

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
