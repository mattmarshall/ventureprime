package me.gotdo.vp3.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import me.gotdo.vp3.web.model.Survey;
import me.gotdo.vp3.web.model.SurveyQuestion;
import me.gotdo.vp3.web.model.Test;
import me.gotdo.vp3.web.model.TestTask;
import me.gotdo.vp3.web.model.VPUser;
import me.gotdo.vp3.web.repository.TestLevelRepository;
import me.gotdo.vp3.web.repository.TestRepository;
import me.gotdo.vp3.web.repository.VPUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/v/builder")
@SessionAttributes("test")
public class BuilderController {
	
	@Autowired
	private TestLevelRepository testLevelRepo;
	
	@Autowired
	private VPUserRepository userRepo;
	
	@Autowired
	private TestRepository testRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public String handleGet() {
		return "venture-test-builder-home";
	}
	
	/*
	 * Step 1
	 */	
	@RequestMapping(value = "/step/1", method = RequestMethod.GET)
	public String showTestLevels(ModelMap model) {
		model.put("test", new Test());
		model.put("testLevels", testLevelRepo.findAll());
		return "builder/select-test-level";
	}
	
	@RequestMapping(value = "/step/1", method = RequestMethod.POST)
	public String submitTestLevel(@ModelAttribute("test") Test test, final HttpServletRequest request, final Principal principal) throws Exception {
		
		// Get the selected test level
		String testLevelId = request.getParameter("testLevel");
		if (testLevelId == null) {
			throw new Exception();
		}
		
		if (principal == null) {
			throw new Exception("User is null, probably needs to login, will fix later");
		}
		
		VPUser user = userRepo.findOne(principal.getName());
		
		// Use the test builder to set the test level
		test.setCreator(user);
		test.setTestLevelId(testLevelId);
		
		return "redirect:../step/2";
	}
	
	/*
	 * Step 2
	 */
	@RequestMapping(value = "/step/2", method = RequestMethod.GET)
	public String showTaskCreator(@ModelAttribute("test") Test test) {
		return "builder/create-test-tasks";
	}
	
	@RequestMapping(value = "/step/2", method = RequestMethod.POST)
	public String submitTestTasks(@ModelAttribute("test") Test test, HttpServletRequest request) throws Exception {
		
		// Check for POST data
		Map<String, String[]> map = request.getParameterMap();
		if (!(map.containsKey("taskTitle") && map.containsKey("taskDescription"))) {
			throw new Exception("POST data was not submitted");
		}
		
		String[] titles = map.get("taskTitle");
		String[] descriptions = map.get("taskDescription");
		
		// Ugly hackery validation (will suffice for now
		if ((titles == null) || (descriptions == null) || (titles.length != descriptions.length)) {
			throw new Exception("Arrays are null or not the same length");
		}
		
		List<TestTask> tasks = new ArrayList<TestTask>();
		for (int i = 0; i < titles.length; i++) {
			TestTask task = new TestTask();
			task.setTitle(titles[i]);
			task.setDescription(descriptions[i]);
			tasks.add(task);
		}
		
		// Set it in the test builder
		test.setTasks(tasks);
		
		// For now we'll create one default survey
		List<Survey> surveys = new ArrayList<Survey>();
		Survey survey = new Survey();
		survey.setTest(test);
		surveys.add(survey);
		test.setSurveys(surveys);
		
		return "redirect:../step/3";
	}
	
	/*
	 * Step 3
	 */
	
	@RequestMapping(value = "/step/3", method = RequestMethod.GET)
	public String buildStep(@ModelAttribute("test") Test test) {
		return "builder/create-test-survey";
	}
	
	@RequestMapping(value = "/survey/question", method = RequestMethod.POST)
	public @ResponseBody SurveyQuestion addQuestion(@ModelAttribute("test") Test test,
			@RequestBody SurveyQuestion question) {
		return question;
	}
	
	/*
	
	@RequestMapping(value = "/step/2/addTask", method = RequestMethod.POST,)
	public @ResponseBody TestTask addTask(@RequestBody TestTask task)
	{
		TestTask newTask = new TestTask();
		newTask.setTitle("My Title");
		return newTask;
	}
	
	@RequestMapping(value = "/step/2/addTaskTest", method = RequestMethod.GET)
	public @ResponseBody TestTask addTaskTest()
	{
		TestTask newTask = new TestTask();
		newTask.setTitle("My Title");
		return newTask;
	}
	
	
	@RequestMapping(value = "/step/{step}", method = RequestMethod.GET)
	public String buildStep(ModelMap map, @PathVariable int step) {
		map.addAttribute("nextStep", step + 1);
		return "builder/step-" + step;
	}
	*/
}
