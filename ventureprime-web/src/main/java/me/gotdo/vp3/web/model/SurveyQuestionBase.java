package me.gotdo.vp3.web.model;

public abstract class SurveyQuestionBase implements SurveyQuestion {
	
	private String title;
	
	private int position;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
