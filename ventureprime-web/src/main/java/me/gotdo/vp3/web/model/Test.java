package me.gotdo.vp3.web.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class Test extends DocumentBase<Test> {
	
	@DBRef
	private Company company;
	
	@Indexed
	private String testName;
	
	@DBRef
	private TestLevel testLevel;
	
	@Indexed
	private TestStatus testStatus;
	
	private List<TestTask> tasks;
	
	@DBRef
	private List<Survey> surveys;
	
	public Test() {
		tasks = new ArrayList<TestTask>();
		surveys = new ArrayList<Survey>();
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public TestLevel getTestLevel() {
		return testLevel;
	}

	public void setTestLevel(TestLevel testLevel) {
		this.testLevel = testLevel;
	}
	
	public TestStatus getTestStatus() {
		return testStatus;
	}
	
	public void setTestStatus(TestStatus testStatus) {
		this.testStatus = testStatus;
	}
	
	public List<TestTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<TestTask> tasks) {
		this.tasks = tasks;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}
	
	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	@Override
	public DocumentBase<Test> upgradeTo(long newVersion) {
		return this;
	}

}
