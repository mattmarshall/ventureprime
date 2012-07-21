package me.gotdo.vp3.web.controller;

import java.util.ArrayList;
import java.util.List;

import me.gotdo.vp3.web.model.VPUser;
import me.gotdo.vp3.web.repository.VPUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private VPUserRepository vpUserRepo;
	
	private final List<String> roles;
	
	public RegistrationController() {
		roles = new ArrayList<String>();
		roles.add("venture");
		roles.add("primer");
	}
	
	@ModelAttribute("user")
	public VPUser getSurveyObject() {
		return new VPUser();
	}
	
	/**
	 * GET
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String handleRequest(ModelMap map) {
		map.addAttribute("roles", roles);
		return "user";
	}
	
	/**
	 * POST
	 * @param survey
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("user") VPUser user, BindingResult result) {
		
		// Add the survey to the database
		user = this.vpUserRepo.save(user);
		
		// Add the survey to the model/view
		ModelAndView mv = new ModelAndView();
		mv.addObject("survey", user);
		mv.setViewName("user-created");
		return mv;
	}

}
