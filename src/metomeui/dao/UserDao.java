package metomeui.dao;

import java.util.List;

import metomeui.model.User;

public interface UserDao {
	// To Save the article detail
	public void addUser(User user);

	// To get list of all articles
	public List<User> listUsers();
	
	//Delet a user
	public void removeUser(Integer id);
}
