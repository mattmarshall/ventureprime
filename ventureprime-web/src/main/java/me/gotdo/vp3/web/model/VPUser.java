package me.gotdo.vp3.web.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class VPUser extends DocumentBase<VPUser>  {

    private String credentials;
    
    @Indexed
    private Boolean active;

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String newCredentials) {
		this.credentials = newCredentials;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


	@Override
	public DocumentBase<VPUser> upgradeTo(long newVersion) {
		// TODO Auto-generated method stub
		return null;
	} 
}