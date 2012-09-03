package applabmoneyaui.web;

import java.util.Map;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import applabmoneyaui.model.Login;
import applabmoneyaui.model.User;
import applabmoneyaui.service.SystemSettingsService;
import applabmoneyaui.service.SystemSettingsServiceImplementation;

@Controller
@RequestMapping("/uilogin")
public class UserLoginController {

	SystemSettingsService systemSettingsService = new SystemSettingsServiceImplementation();

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, Login> model) {
		Login userLoginForm = new Login();
		model.put("login", userLoginForm);
		return "uilogin";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Login login, BindingResult result,
			Map<String, Login> model) throws Exception {
		if (result.hasErrors()) {
			return "uilogin";
		}
		login = (Login) model.get("login");

		// if (authenticate(login)) {
		// model.put("login", login);
		if ((login.userName.equalsIgnoreCase("admin"))
				&& (login.password.equalsIgnoreCase("adminpass"))) {
			return "redirect:/auilanding.html";
		} else {
			result.reject("notmatch.login", "invalid login!! Please try again");
			login.clearFields();
			return "uilogin";
		}
	}

	public boolean authenticate(Login login) throws Exception {

		boolean exist = false;
		try {
			User user = systemSettingsService.getUserByLogin(login.userName,
					login.password);
			if (user == null) {
				exist = false;
			} else {
				exist = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return exist;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Map<String, Login> model) {
		Login userLoginForm = new Login();
		model.put("login", userLoginForm);
		return "uilogin";
	}
}