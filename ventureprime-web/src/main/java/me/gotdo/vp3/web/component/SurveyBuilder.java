package me.gotdo.vp3.web.component;

import me.gotdo.vp3.web.model.Survey;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SurveyBuilder {
	
	private Survey survey;
	
	public SurveyBuilder() {
		this.survey = new Survey();
	}
	
	public Survey getSurvey() {
		return survey;
	}

}
