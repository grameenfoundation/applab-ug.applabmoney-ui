package anathatest.model;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotEmpty
    @Size(min = 1, max = 50)
    private String userName;
    @NotEmpty
    @Size(min = 1, max = 20)
	private String password;

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
