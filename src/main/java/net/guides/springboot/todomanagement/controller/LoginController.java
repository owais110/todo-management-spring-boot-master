package net.guides.springboot.todomanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		
		return 	modelAndView;
	}
}