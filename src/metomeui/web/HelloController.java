package metomeui.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;

import metomeui.web.HelloController;

import java.util.Date;

//@Controller
////@RequestMapping annotation tells Spring that this Controller should process all requests beginning with /hello in the URL path e.g. hello.html
//@RequestMapping("/hello")
public class HelloController {
//
//	private static Logger logger = Logger.getLogger(HelloController.class);
//		 
//	@RequestMapping(method = RequestMethod.GET)
//	public String printWelcome(ModelMap model) {
//	 
//		logger.info("Returning hello view");
//		String now = (new Date()).toString();
//		logger.info("Returning hello view with " + now);
//			model.addAttribute("now", now);
//			return "hello";
//	 
//		}
//
}