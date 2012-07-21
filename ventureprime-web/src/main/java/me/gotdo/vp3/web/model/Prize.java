package me.gotdo.vp3.web.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prize")
public class Prize extends DocumentBase<Prize> {
	
	@Indexed
	private String name;
	
	@Indexed
	private int points;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public DocumentBase<Prize> upgradeTo(long newVersion) {
		return this;
	}

}
