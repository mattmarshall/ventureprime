package me.gotdo.vp3.web.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="surveys")
public class Survey {
	
	@Id
	private String id;
	
	@Indexed
	private String creatorId;
	
	@Indexed
	private String friendlyName;
	
	private String description;
	
	private Map<String, String> questionsAndAnswers;
	
	public Survey() {
		this.questionsAndAnswers = new HashMap<String, String>();
	}

	public String getId() {
		return id;
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
}
