package me.gotdo.vp3.web.model;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class VPUser extends DocumentBase<VPUser>  {

    private String credentials;
    
    @Indexed
    private boolean active;
    
    @Indexed
    private List<String> roles;
    
    public String firstName;
    
    public String lastName;
    
    public String nickName;

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
	
	public List<String> getRoles() {
		return roles;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


	@Override
	public DocumentBase<VPUser> upgradeTo(long newVersion) {
		// TODO Auto-generated method stub
		return null;
	} 
}