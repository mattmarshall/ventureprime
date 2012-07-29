package me.gotdo.vp3.web.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testLevel")
public class TestLevel extends DocumentBase<TestLevel> {
	
	private static final String DEFAULT_FRIENDLY_NAME = "UNTITLED TEST LEVEL";
	
	@Indexed
	private String friendlyName;
	
	private String description;
	
	@Indexed
	private double price;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		if (friendlyName == null) {
			return DEFAULT_FRIENDLY_NAME;
		}
		return friendlyName;
	}

	@Override
	public DocumentBase<TestLevel> upgradeTo(long newVersion) {
		return this;
	}
}
