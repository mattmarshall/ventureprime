package me.gotdo.vp3.web.component;

import me.gotdo.vp3.web.model.Test;
import me.gotdo.vp3.web.model.TestLevel;
import me.gotdo.vp3.web.repository.TestLevelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class TestBuilder {
	
	private Test test;
	
	@Autowired
	private TestLevelRepository testLevelRepo;
	
	@Autowired
	private SurveyBuilder surveyBuilder;
	
	public TestBuilder() {
		this.test = new Test();
	}
	
	public Test getTest() {
		return test;
	}
	
	public SurveyBuilder getSurveyBuilder() {
		return surveyBuilder;
	}
	
	public Iterable<TestLevel> getTestLevels() {
		return testLevelRepo.findAll();
	}

}
