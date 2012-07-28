package me.gotdo.vp3.web.model.survey;

import java.io.Serializable;

public class DefaultSurveyTask implements SurveyTask, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String taskName;
	
	private String taskDetails;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}

}
