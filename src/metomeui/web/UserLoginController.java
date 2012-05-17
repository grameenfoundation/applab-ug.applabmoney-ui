package metomeui.web;

import metomeui.model.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import metomeui.web.UserLoginController;

import java.util.Map;
import javax.validation.Valid;


@Controller
@RequestMapping("/uilogin")
public class UserLoginController {

	private static Logger logger = Logger.getLogger(UserLoginController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, User> model) {
		User userLoginForm = new User();
		model.put("user", userLoginForm);
		return "uilogin";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid User user, BindingResult result,
			Map<String, User> model) {
		String userName = "Admin";
		String password = "adminpass";
		if (result.hasErrors()) {
			return "uilogin";
		}
		user = (User) model.get("user");
		if (!user.getUserName().equals(userName)
				|| !user.getPassword().equals(password)) {
			//errors.rejectValue("login", "notmatch.login");
			result.reject("notmatch.login", "invalid login!! Please try again");
			//errors.reject("notmatch.login", "inavlid login");
			user.clearFields();
			return "uilogin";
		} else {
			model.put("user", user);
			logger.info("Successful Login!! Now onto landing Page!!");
			return "redirect:/ussdmenuitems.html";
		}

	}

}
