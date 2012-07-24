package me.gotdo.vp3.web.model;

import java.util.ArrayList;
import java.util.List;

import me.gotdo.vp3.web.model.survey.SurveyTask;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="survey")
public class Survey extends DocumentBase<Survey> {
	
	@Indexed
	private String creatorId;
	
	@Indexed
	private String friendlyName;
	
	private String description;
	
	private String surveyReason;
	
	private int maxParticipants;
	
	private String eligibleGroup;
	
	private int testLevel;
	
	private List<SurveyTask> tasks;
	
	private List<SurveyQuestion> questions;
	
	public Survey() {
		this.questions = new ArrayList<SurveyQuestion>();
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
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

	public int getTestLevel() {
		return testLevel;
	}

	public void setTestLevel(int testLevel) {
		this.testLevel = testLevel;
	}

	public List<SurveyQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<SurveyQuestion> questions) {
		this.questions = questions;
	}

	public List<SurveyTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<SurveyTask> tasks) {
		this.tasks = tasks;
	}

	@Override
	public DocumentBase<Survey> upgradeTo(long schemaVersion) {
		if (schemaVersion <= 0) {
			DocumentMeta newMeta = new DocumentMeta(100, 100);
			this.setMetadata(newMeta);
		}
		return this;
	}
}
