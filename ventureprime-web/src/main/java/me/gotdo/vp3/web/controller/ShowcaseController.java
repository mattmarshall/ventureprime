package me.gotdo.vp3.web.controller;

import me.gotdo.vp3.web.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowcaseController {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@RequestMapping(value = "/the-fame", method = RequestMethod.GET)
	public String primerHallOfFame() {
		return "hall-of-fame";
	}
	
	@RequestMapping(value = "/prizes", method = RequestMethod.GET)
	public String prizes() {
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

}
