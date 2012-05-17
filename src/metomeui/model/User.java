package metomeui.model;

import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//@Entity
//@Table(name = "Users")
public class User {

//	@NotEmpty
//	@Size(min = 8, max = 20)
//	@NotBlank(applyIf = "password is not blank") 
//	@Expression(value = "confirmPassword = password", applyIf = "password is not blank") 
//	private String confirmPassword;
//
//	@Id
//	@GeneratedValue
//	@Column(name = "user_id")
//	private Integer userId;

	@NotEmpty
	//@Size(min = 6, max = 20)
	@Column(name = "user_name", nullable = false, length = 20)
	private String userName;

	@NotEmpty
	//@Size(min = 8, max = 20)
	@Column(name = "password", nullable = false, length = 20)
	private String password;

//	@NotEmpty
//	@Size(min = 2, max = 20)
//	@Column(name = "first_name", nullable = false, length = 20)
//	private String firstName;
//
//	@NotEmpty
//	@Size(min = 2, max = 20)
//	@Column(name = "last_name", nullable = false, length = 20)
//	private String lastName;
//
////	@NotEmpty
//	@Size(min = 1, max = 20)
//	@Column(name = "middle_name", nullable = true, length = 20)
//	private String middleName;
//
//	@NotEmpty
//	@Size(min = 5, max = 20)
//	@Column(name = "role", nullable = false, length = 20)
//	private String role;
//
//	@NotEmpty
//	@Email
//	@Column(name = "email_address", nullable = false, length = 40)
//	private String email;
//
//	@NotEmpty
//	@Column(name = "telephone", nullable = false, length = 20)
//	private String telephone;

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

	public void clearFields() {
		this.userName = "";
		this.password = "";

	}
}
