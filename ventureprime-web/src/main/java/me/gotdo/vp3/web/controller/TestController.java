package me.gotdo.vp3.web.controller;

import java.util.ArrayList;
import java.util.List;

import me.gotdo.vp3.web.model.Test;
import me.gotdo.vp3.web.model.TestTask;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("test")
@RequestMapping("/v/test")
public class TestController {
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, headers="Accept=*/*")
	public @ResponseBody Test getTest(@PathVariable("id") String id) {
		return new Test();
	}
	
	@RequestMapping(value="/{id}/tasks", method=RequestMethod.GET, headers="Accept=*/*")
	public @ResponseBody List<TestTask> getTestTasks(@PathVariable("id") String id) {
		List<TestTask> tasks = new ArrayList<TestTask>();
		return tasks;
	}
}
