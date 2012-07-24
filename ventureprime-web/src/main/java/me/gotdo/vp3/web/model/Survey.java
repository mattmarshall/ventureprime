package me.gotdo.vp3.web.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="survey")
public class Survey extends DocumentBase<Survey> {
	
	@Indexed
	private String creatorId;
	
	@Indexed
	private String friendlyName;
	
	private String description;
	
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
	
	public List<SurveyQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<SurveyQuestion> questions) {
		this.questions = questions;
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
