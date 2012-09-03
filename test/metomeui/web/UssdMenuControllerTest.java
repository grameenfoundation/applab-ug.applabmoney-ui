package metomeui.web;

import static org.junit.Assert.*;

import java.util.Map;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import applabmoneyaui.model.UssdPredefInput;
import applabmoneyaui.service.UssdMenuService;
import applabmoneyaui.web.UssdMenuController;

public class UssdMenuControllerTest {
	private UssdMenuController controller;
	UssdMenuService service;

	@Before
	public void setup() {
		controller = new UssdMenuController();
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		// controller.ussdMenuService = new FakeUssdMenuService();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldShowHomePageWithLinks() {
		ModelMap model = new ModelMap();
		assertEquals("hello", controller.printWelcome(model));
	}

	@Test
	public void testHelloController() {
		UssdMenuController c = new UssdMenuController();
		Map<String, Object> model = null;
		model.put("ussdPredefInput", new UssdPredefInput());
		model.put("ussdPredefInputList", service.listPredefInputs());
		//String mav = c.listUssdPredefInputs(model);
		//assertNull(((Object) c).listPredefInputs(model));
		// assertEquals("/book/searchForm.jsp", mav.getViewName());
		//assertEquals("listUssdPredefInputs", mav);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldShowUssdMenuItemSetupPage() {
		// UssdKeywordStep ussdKeywordStep = null;
		// assertEquals("redirect:/ussdkeywordsteps.html",
		// controller.addUssdKeywordStep(ussdKeywordStep, null));
	}
	// List rants = (List<Rant>) model.get("rantList");
	//
	// assertNotNull(rants);
	// assertEquals(3, rants.size());
	// assertEquals("Rant 1", rants.get(0).getRantText());
	// assertEquals("Rant 2", rants.get(1).getRantText());
	// assertEquals("Rant 3", rants.get(2).getRantText());
	// }
	// }
	//
	//
	//
	//
	// @Mock UssdMenuService ussdMenuService;
	//
	//
	//
	// @Test
	// public void testHandleRequestView() throws Exception {
	// UssdMenuController controller = new UssdMenuController();
	// ModelAndView modelAndView = controller.handleRequest(null, null);
	// assertEquals("hello", modelAndView.getViewName());
	// assertNotNull(modelAndView.getModel());
	// String nowValue = (String) modelAndView.getModel().get("now");
	// assertNotNull(nowValue);
	// }
}