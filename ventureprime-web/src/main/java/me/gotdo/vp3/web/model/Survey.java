package me.gotdo.vp3.web.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="survey")
public class Survey extends DocumentBase<Survey> {
	
	@Indexed
	@DBRef
	private Test test;
	
	@Indexed
	private String friendlyName;
	
	private String description;
	
	private String surveyReason;
	
	private int maxParticipants;
	
	private String eligibleGroup;
	
	private List<SurveyQuestion> questions;
	
	public Survey() {
		this.questions = new ArrayList<SurveyQuestion>();
	}
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSurveyReason() {
		return surveyReason;
	}

	public void setSurveyReason(String surveyReason) {
		this.surveyReason = surveyReason;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public String getEligibleGroup() {
		return eligibleGroup;
	}

	public void setEligibleGroup(String eligibleGroup) {
		this.eligibleGroup = eligibleGroup;
	}

	public List<SurveyQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<SurveyQuestion> questions) {
		this.questions = questions;
	}

	@Override
	public DocumentBase<Survey> upgradeTo(long schemaVersion) {
		return this;
	}
}
