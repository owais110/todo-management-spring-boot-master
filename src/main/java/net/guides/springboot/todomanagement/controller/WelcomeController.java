package net.guides.springboot.todomanagement.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView showWelcomePage(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		model.put("name", getLoggedinUserName());
		return 	modelAndView;
	}

	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	
	
}
