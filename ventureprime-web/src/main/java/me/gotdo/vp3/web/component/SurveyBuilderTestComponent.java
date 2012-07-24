package me.gotdo.vp3.web.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SurveyBuilderTestComponent {
	
	private String name;
	
	private String description;
	
	public SurveyBuilderTestComponent() {
		this.name = "Blahsta";
		this.description = "Chamonification";
	}

}
