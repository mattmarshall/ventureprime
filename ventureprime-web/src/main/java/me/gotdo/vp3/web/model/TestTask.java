package me.gotdo.vp3.web.model;

import java.io.Serializable;

public class TestTask implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	
	private String description;
	
	public TestTask() {
		title = "";
		description = "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
