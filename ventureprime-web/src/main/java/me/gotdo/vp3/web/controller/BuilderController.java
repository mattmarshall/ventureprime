package me.gotdo.vp3.web.controller;

import me.gotdo.vp3.web.component.SurveyBuilderTestComponent;
import me.gotdo.vp3.web.model.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
@RequestMapping("/v/builder")
public class BuilderController {
	
	@Autowired
	private SurveyBuilderTestComponent component;
	
	@RequestMapping(method = RequestMethod.GET)
	public String handleGet() {
		return "venture-test-builder-home";
	}
	
	@RequestMapping(value = "/step/{step}", method = RequestMethod.GET)
	public String buildStep(ModelMap map, @PathVariable int step) {
		map.addAttribute("nextStep", step + 1);
		return "builder/step-" + step;
	}
	
}
