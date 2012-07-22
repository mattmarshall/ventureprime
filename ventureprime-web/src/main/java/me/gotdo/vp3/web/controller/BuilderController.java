package me.gotdo.vp3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/v/builder")
public class BuilderController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String handleGet() {
		return "builder-home";
	}
	
}
