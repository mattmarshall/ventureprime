package me.gotdo.vp3.service;

import java.util.ArrayList;
import java.util.List;

import me.gotdo.vp3.web.model.VPUser;
import me.gotdo.vp3.web.repository.VPUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VPUserService {

	@Autowired
	private VPUserRepository userRepository;
	
	public Iterable<String> getRoleTypes() {
		ArrayList<String> roles = new ArrayList<String>();
		roles.add("vpuser");
		roles.add("venture");
		roles.add("primer");
		return roles;
	}
	
	public void grantUserRole(VPUser user, String role) {
		if (!user.getRoles().contains(role)) {
			List<String> roles = user.getRoles();
			
			// Defensive n shit
			if (roles == null) {
				roles = new ArrayList<String>();
			}
			
			roles.add(role);
			user.setRoles(roles);
			userRepository.save(user);
		}
	}
	
	public boolean userInRole(VPUser user, String role) {
		return user.getRoles().contains(role);
	}
	
	public VPUser registerPrimer(String userName) {
		VPUser user = new VPUser();
		user.setId(userName);
		user.setActive(true);
		grantUserRole(user, "primer");
		return user;
	}

}