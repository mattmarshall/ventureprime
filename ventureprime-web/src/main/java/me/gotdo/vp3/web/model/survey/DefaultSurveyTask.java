package me.gotdo.vp3.web.model.survey;

public class DefaultSurveyTask implements SurveyTask {
	
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
