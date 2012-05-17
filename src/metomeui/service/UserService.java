package metomeui.service;
/**
 * This is the interface which declares methods which will be used in controller class.
 */
import java.util.List;

import metomeui.model.User;

public interface UserService {

	public void addUser(User user);

	public List<User> listUsers();
	
	public void removeUser(Integer id);
}