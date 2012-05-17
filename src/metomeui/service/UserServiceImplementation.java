package metomeui.service;

/**
 * This is the implementation class of ArticleService Interface. 
 * It defines all the methods declared in ArticleService interface. 
 * These methods uses Dao classes to interact with the database.
 * @Service("articleService") annotation is used to declare it as service bean 
 * and its name articleService will be used to auto wire its instance in controller class.
 * @Transactional annotation is used to declare the method transactional. 
 * You can also use this at the class level to declare all methods transactional.
 */
import java.util.List;

import metomeui.model.User;
import metomeui.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserDao userDao;

	public UserServiceImplementation() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Transactional
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	@Transactional
	public void removeUser(Integer id) {
		userDao.removeUser(id);
	}

}