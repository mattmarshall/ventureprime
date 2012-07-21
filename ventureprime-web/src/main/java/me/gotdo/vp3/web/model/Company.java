package me.gotdo.vp3.web.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "company")
public class Company extends DocumentBase<Company> {
	
	@Indexed
	private String name;

	@Override
	public DocumentBase<Company> upgradeTo(long newVersion) {
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
