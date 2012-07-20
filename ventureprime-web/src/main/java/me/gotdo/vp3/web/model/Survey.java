package me.gotdo.vp3.web.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Survey extends DocumentBase<Survey> {
	
	@Indexed
	private String creatorId;
	
	@Indexed
	private String friendlyName;
	
	private String description;
	
	private Map<String, String> questionsAndAnswers;
	
	public Survey() {
		this.questionsAndAnswers = new HashMap<String, String>();
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
	
	public Map<String, String> getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}

	public void setQuestionsAndAnswers(Map<String, String> questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}
	
	public Survey addQuestionAndAnswer(String question, String answer) {
	    this.questionsAndAnswers.put(question, answer);
	    return this;
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
