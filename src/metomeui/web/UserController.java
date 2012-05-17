package metomeui.web;

import java.util.Map;

import metomeui.model.User;
import metomeui.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	private static Logger logger = Logger.getLogger(HelloController.class);
	
	@Autowired
	private UserService userService;
	

	@RequestMapping("/users")
	public String listUser(Map<String, Object> map) {
		map.put("user", new User());
		map.put("userList", userService.listUsers());
		return "users";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result) {
		userService.addUser(user);
		return "redirect:/users.html";
	}

	@RequestMapping("/removeUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		userService.removeUser(userId);
		logger.info("Returning hello view");
		return "redirect:/users.html";
	}
}