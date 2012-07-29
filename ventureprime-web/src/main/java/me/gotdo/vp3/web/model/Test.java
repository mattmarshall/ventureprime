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
	
	@DBRef
	private VPUser creator;
	
	@Indexed
	private String testName;
	
	@Indexed
	private String testLevelId;
	
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

	public String getTestLevelId() {
		return testLevelId;
	}

	public void setTestLevelId(String testLevelId) {
		this.testLevelId = testLevelId;
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

	public VPUser getCreator() {
		return creator;
	}

	public void setCreator(VPUser creator) {
		this.creator = creator;
	}

}
