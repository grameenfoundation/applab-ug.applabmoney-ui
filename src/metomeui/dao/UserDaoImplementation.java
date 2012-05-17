package metomeui.dao;

import java.util.List;

import javax.transaction.Transaction;

import metomeui.model.User;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This is the implementation class of ArticleDao interface.
 * 
 * @Repository("articleDao") declares that the annotated class is a "DAO".
 * @Autowired is being used to make the SessionFactory instance available
 *            automatically by spring. Now, define the methods declared in
 *            ArticleDao interface using hibernate.
 */

@Repository("userDao")
public class UserDaoImplementation implements UserDao {

	@Autowired
	private static SessionFactory sessionFactory;

	// To save the new user details
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	// To get list of all users
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		return (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
	}

	@Override
	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class,
				id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	private static void updateUser(User user) {
		Transaction tx = null;

		// try {
		// tx =
		// (Transaction)sessionFactory.getCurrentSession().beginTransaction().update(user);
		// tx.commit();
		// } catch (RuntimeException e) {
		// if (null != tx) {
		// try {
		// // Second try catch as the rollback could fail as well
		// tx.rollback();
		// } catch (HibernateException e1) {
		//
		// }
		// // throw again the first exception
		// throw e;
		// }
		// }
		// }
	}
}