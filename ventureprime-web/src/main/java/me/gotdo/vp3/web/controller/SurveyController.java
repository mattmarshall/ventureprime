package me.gotdo.vp3.web.controller;

import me.gotdo.vp3.web.repository.SurveyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepo;
	
	@RequestMapping(value="/survey", method = RequestMethod.GET)
	public String showAllSurveys(ModelMap model) {
 
		return "surveys";
 
	}

}
