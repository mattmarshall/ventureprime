package me.gotdo.vp3.web.controller;

import javax.servlet.http.HttpServletRequest;

import me.gotdo.vp3.web.component.TestBuilder;

import me.gotdo.vp3.web.model.TestTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	/*
	 * Step 2
	 */
	@RequestMapping(value = "/step/2", method = RequestMethod.GET)
	public ModelAndView showTaskCreator() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("testTasks", testBuilder.getTest().getTasks());
		mv.setViewName("builder/create-test-tasks");
		return mv;
	}
	
	@RequestMapping(value = "/step/2/addTask", method = RequestMethod.POST, headers="Accept=*/*")
	public @ResponseBody TestTask addTask(@RequestBody TestTask task)
	{
		TestTask newTask = new TestTask();
		newTask.setTitle("My Title");
		return newTask;
	}
	
	@RequestMapping(value = "/step/2/addTaskTest", method = RequestMethod.GET, headers="Accept=*/*")
	public @ResponseBody TestTask addTaskTest()
	{
		TestTask newTask = new TestTask();
		newTask.setTitle("My Title");
		return newTask;
	}
	
	@RequestMapping(value = "/step/2", method = RequestMethod.POST)
	public ModelAndView submitTestTasks(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../step/3");
		return mv;
	}
	
	
	@RequestMapping(value = "/step/{step}", method = RequestMethod.GET)
	public String buildStep(ModelMap map, @PathVariable int step) {
		map.addAttribute("nextStep", step + 1);
		return "builder/step-" + step;
	}
}
