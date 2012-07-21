package me.gotdo.vp3.web.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class Test extends DocumentBase<Test> {
	
	@DBRef
	private Company company;
	
	@Indexed
	private String testName;
	
	@Indexed
	private int testLevel;

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

	public int getTestLevel() {
		return testLevel;
	}

	public void setTestLevel(int testLevel) {
		this.testLevel = testLevel;
	}

	@Override
	public DocumentBase<Test> upgradeTo(long newVersion) {
		return this;
	}

}
