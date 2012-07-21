package me.gotdo.vp3.web.controller;

import me.gotdo.vp3.web.model.Survey;
import me.gotdo.vp3.web.repository.SurveyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepo;
	
	@ModelAttribute("survey")
	public Survey getSurveyObject() {
		return new Survey();
	}
	
	/**
	 * GET
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String handleRequest() {
		return "survey";
	}
	
	/**
	 * POST
	 * @param survey
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(@ModelAttribute("survey") Survey survey, BindingResult result) {
		
		// Add the survey to the database
		survey = this.surveyRepo.save(survey);
		
		// Add the survey to the model/view
		ModelAndView mv = new ModelAndView();
		mv.addObject("survey", survey);
		mv.setViewName("survey-created");
		return mv;
	}

}
