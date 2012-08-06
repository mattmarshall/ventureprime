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
import me.gotdo.vp3.web.model.survey.MultipleChoiceQuestion;
import me.gotdo.vp3.web.repository.TestLevelRepository;
import me.gotdo.vp3.web.repository.VPUserRepository;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/v/builder")
@SessionAttributes("test")
public class BuilderController {
	
	@Autowired
	private TestLevelRepository testLevelRepo;
	
	@Autowired
	private VPUserRepository userRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public String handleGet() {
		return "venture-test-builder-home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String handlePost(ModelMap model, @RequestParam("test-name") String testName) {
		Test test = new Test();
		test.setTestName(testName);
		model.put("test", test);
		return "redirect:/v/builder/step/1";
	}
	
	/*
	 * Step 1
	 */	
	@RequestMapping(value = "/step/1", method = RequestMethod.GET)
	public String showTestLevels(ModelMap model) {
		model.put("testLevels", testLevelRepo.findAll());
		return "builder/select-test-level";
	}
	
	@RequestMapping(value = "/step/1", method = RequestMethod.POST)
	public String submitTestLevel(final HttpServletRequest request,
			final @RequestParam("testLevel") String testLevelId,
			final Principal principal) throws Exception {
		
		Test test = (Test)request.getSession().getAttribute("test");
		if (test == null) {
			return "redirect:/v/builder";
		}
		
		// Get the selected test level
		if (testLevelId == null) {
			throw new Exception("Test level id not specified");
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
	public String showTaskCreator(final HttpServletRequest request) {
		
		Test test = (Test)request.getSession().getAttribute("test");
		if (test == null) {
			return "redirect:/v/builder";
		}
		
		
		return "builder/create-test-tasks";
	}
	
	@RequestMapping(value = "/step/2", method = RequestMethod.POST)
	public String submitTestTasks(HttpServletRequest request) throws Exception {
		
		Test test = (Test)request.getSession().getAttribute("test");
		if (test == null) {
			return "redirect:/v/builder";
		}
		
		// Check for POST data
		Map<String, String[]> map = request.getParameterMap();
		if (!(map.containsKey("task-title[]") && map.containsKey("task-description[]"))) {
			throw new Exception("POST data was not submitted");
		}
		
		String[] titles = map.get("task-title[]");
		String[] descriptions = map.get("task-description[]");
		
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
	public String buildStep(final HttpServletRequest request) {
		
		Test test = (Test)request.getSession().getAttribute("test");
		if (test == null) {
			return "redirect:/v/builder";
		}
		
		
		return "builder/create-test-survey";
	}

	@RequestMapping(value = "/step/3", method = RequestMethod.POST)
	public String submitSurvey(final HttpServletRequest request) throws Exception {
		
		Test test = (Test)request.getSession().getAttribute("test");
		if (test == null) {
			return "redirect:/v/builder";
		}
		
		// Check for POST data
		Map<String, String[]> map = request.getParameterMap();
		if (!(map.containsKey("question-type[]") && map.containsKey("question-data[]") && map.containsKey("question-description[]"))) {
			throw new Exception("POST data was not submitted");
		}
		
		// Get submitted data
		String[] types = map.get("question-type[]");
		String[] descriptions = map.get("question-description[]");
		String[] data = map.get("question-data[]");
		
		// Ugly hackery validation (will suffice for now
		if ((types == null) || (descriptions == null) || (data == null) || (types.length != descriptions.length) || (types.length != data.length)) {
			throw new Exception("Arrays are null or not the same length");
		}
		
		// Create the survey question
		if (test.getSurveys() == null) {
			throw new Exception("Surveys list is null");
		} else if (test.getSurveys().size() != 1) {
			throw new Exception("Surveys list is improper size");
		}
		
		// Get the survey
		Survey survey = test.getSurveys().get(0);
		if (survey == null) {
			throw new Exception("Survey is null!");
		}
		
		// JSON object mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// Add questions to it
		List<SurveyQuestion> questions = new ArrayList<SurveyQuestion>();
		for (int i = 0; i < types.length; i++) {
			String type = types[i];
			if (!type.equals("multiple-choice")) {
				throw new Exception("Only multiple choice supported");
			}
			
			// Multiple choice question
			MultipleChoiceQuestion question = new MultipleChoiceQuestion();
			question.setPosition(i);
			question.setTitle(descriptions[i]);
			
			// Read choices from JSON
			List<String> choices = mapper.readValue(data[i], new TypeReference<List<String>>(){});
			question.setChoices(choices);
			
			// Add question to list
			questions.add(question);
		}
		
		// Set questions in survey
		survey.setQuestions(questions);
		
		return "redirect:../step/3";
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
