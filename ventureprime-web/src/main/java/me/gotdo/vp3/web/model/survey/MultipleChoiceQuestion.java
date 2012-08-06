package me.gotdo.vp3.web.model.survey;

import java.util.ArrayList;
import java.util.List;

import me.gotdo.vp3.web.model.SurveyQuestionBase;

public class MultipleChoiceQuestion extends SurveyQuestionBase {
	
	private List<String> choices;
	
	public MultipleChoiceQuestion() {
		choices = new ArrayList<String>();
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}
}
