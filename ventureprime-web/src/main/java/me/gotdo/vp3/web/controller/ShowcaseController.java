package me.gotdo.vp3.web.controller;

import java.util.HashMap;
import java.util.Map;

import me.gotdo.vp3.web.model.survey.DefaultSurveyTask;
import me.gotdo.vp3.web.repository.CompanyRepository;
import me.gotdo.vp3.web.repository.PrizeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShowcaseController {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private PrizeRepository prizeRepo;
	
	@RequestMapping(value = "/the-fame", method = RequestMethod.GET)
	public String primerHallOfFame() {
		return "hall-of-fame";
	}
	
	@RequestMapping(value = "/prizes", method = RequestMethod.GET)
	public String prizes(ModelMap map) {
		map.addAttribute("prizes", prizeRepo.findAll());
		return "prizes";
	}
	
	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public String companies(ModelMap map) {
		map.addAttribute("companies", companyRepo.findAll());
		return "companies";
	}
	
	@RequestMapping(value = "/guide", method = RequestMethod.GET)
	public String guide() {
		return "guide";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
}
