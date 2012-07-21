package me.gotdo.vp3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowcaseController {
	
	@RequestMapping(value = "/the-fame", method = RequestMethod.GET)
	public String primerHallOfFame() {
		return "hall-of-fame";
	}
	
	@RequestMapping(value = "/prizes", method = RequestMethod.GET)
	public String prizes() {
		return "prizes";
	}
	
	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public String companies() {
		return "companies";
	}
	
	@RequestMapping(value = "/guide", method = RequestMethod.GET)
	public String guide() {
		return "guide";
	}

}
