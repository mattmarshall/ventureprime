package me.gotdo.vp3.web.controller;

import java.security.Principal;
import java.util.List;

import me.gotdo.vp3.web.model.VPUser;
import me.gotdo.vp3.web.repository.VPUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private VPUserRepository userRepository;
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public ModelAndView printWelcome(Principal principal ) throws Exception {
		
		// Get Spring principal name
		String name = principal.getName();
		
		// Create the ModelView object
		ModelAndView mv = new ModelAndView();
		
		// Get linked VPUser
		VPUser user = userRepository.findOne(name);
		if (user != null) {
			mv.addObject("user", user);
			if (user.getRoles() != null) {
				List<String> roles = user.getRoles();
				if (roles.contains("venture")) {
					mv.setViewName("home-venture");
				} else if (roles.contains("primer")) {
					mv.setViewName("home-primer");
				} else {
					throw new Exception("Bad user, no roles");
				}
			} else {
				throw new Exception("Bad user, roles are null");
			}
		} else throw new Exception("Unable to find user in database");
		
		return mv;
	}
 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login";
 
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String getSignup(ModelMap model) {
		
		return "signup-get";
		
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String submitSignup(ModelMap model) {
		
		return "signup-post";
		
	}
	
}