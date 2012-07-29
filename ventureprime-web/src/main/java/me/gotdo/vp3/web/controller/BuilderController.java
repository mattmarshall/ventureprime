package me.gotdo.vp3.web.controller;

import javax.servlet.http.HttpServletRequest;

import me.gotdo.vp3.web.component.TestBuilder;

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
	private TestBuilder testBuilder;
	
	@RequestMapping(method = RequestMethod.GET)
	public String handleGet() {
		return "venture-test-builder-home";
	}
	
	/*
	 * Step 1
	 */	
	@RequestMapping(value = "/step/1", method = RequestMethod.GET)
	public String showTestLevels(ModelMap map) {
		map.addAttribute("testLevels", testBuilder.getTestLevels());
		return "builder/select-test-level";
	}
	
	@RequestMapping(value = "/step/1", method = RequestMethod.POST)
	public String submitTestLevel(HttpServletRequest request) throws Exception {
		
		// Get the selected test level
		String testLevelId = request.getParameter("testLevel");
		if (testLevelId == null) {
			throw new Exception();
		}
		
		// Use the test builder to set the test level
		testBuilder.setTestLevelId(testLevelId);
		
		return "redirect:../step/2";
	}
	
	
	@RequestMapping(value = "/step/{step}", method = RequestMethod.GET)
	public String buildStep(ModelMap map, @PathVariable int step) {
		map.addAttribute("nextStep", step + 1);
		return "builder/step-" + step;
	}
}
