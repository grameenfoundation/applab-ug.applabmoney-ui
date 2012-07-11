package metomeui.web;

import org.hibernate.SessionFactory;
import org.junit.Test;

import junit.framework.Assert;
import metomeui.dao.LoginDao;
import metomeui.dao.LoginDaoImplementation;
import metomeui.dao.SystemSettingsDao;
import metomeui.dao.SystemSettingsDaoImplementation;
import metomeui.model.Login;
import metomeui.model.User;

public class UserControllerTest {

	@Test
	public void testUserAuthentication() throws Exception {
		SessionFactory sessionFactory = null;
		UserLoginController userLoginController = new UserLoginController();
		SystemSettingsDao userDao = new SystemSettingsDaoImplementation();
		
		//LoginDao loginDao = new LoginDaoImplementation(sessionFactory);
		User user = new User();
		Login login = new Login();
		user.setUserName("test");
		user.setPassword("pass");

		//Assert.assertEquals(
				//loginDao.checkIfUserExists(user.getUserName(),
					//	user.getPassword()), true);
		
		

		// ModelAndView modelAndView = userLoginController.handleRequest(null,
		// null);
		// assertEquals("uilogin", modelAndView.getViewName());
		// assertNotNull(modelAndView.getModel());
		// String nowValue = (String) modelAndView.getModel().get("now");
		// assertNotNull(nowValue);
		// }
		//
		// return userService.checkIfUserExists(userName, password);

	}
}
