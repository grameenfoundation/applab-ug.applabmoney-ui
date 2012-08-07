package metomeui.model;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USERS")
public class User {

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

	@NotEmpty
	@Size(min = 2, max = 20)
	@Column(name = "FIRST_NAME", nullable = false, length = 20)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 20)
	@Column(name = "LAST_NAME", nullable = false, length = 20)
	private String lastName;

	@Size(min = 1, max = 20)
	@Column(name = "MIDDLE_NAME", nullable = true, length = 20)
	private String middleName;

	@NotEmpty
	@Size(min = 5, max = 20)
	@Column(name = "ROLE", nullable = false, length = 20)
	private String role;

	@NotEmpty
	@Email
	@Column(name = "EMAIL_ADDRESS", nullable = false, length = 40)
	private String email;

	@NotEmpty
	@Column(name = "TELEPHONE", nullable = false, length = 20)
	private String telephone;

	public User() {

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
