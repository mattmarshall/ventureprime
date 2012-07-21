package me.gotdo.vp3.service;

import java.util.ArrayList;
import java.util.Collection;

import me.gotdo.vp3.web.model.VPUser;
import me.gotdo.vp3.web.repository.VPUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;

@Service("mongoUserDetailService")
public class MongoUserDetailService implements UserDetailsService {

	@Autowired
	private VPUserRepository userRepository;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		VPUser vpUser = userRepository.findOne(username);

		// User not found
		if (vpUser == null) {
			return null;
		}
		
		// Get the list of authorities
		Collection<? extends GrantedAuthority> authorities = getAuthorities(vpUser);
		
		// Finally return the Spring MVC User
		return new User(vpUser.getId(),
						vpUser.getCredentials(),
						vpUser.isActive(),
						true, true, true, authorities);
	}
	
	protected Collection<? extends GrantedAuthority> getAuthorities(VPUser user) {
		
		Collection<GrantedAuthorityImpl> authorities = Sets.newHashSet();
		
		// Add default role
		GrantedAuthorityImpl defaultRole = new GrantedAuthorityImpl("ROLE_USER");
		authorities.add(defaultRole);
		
		// Add roles from VPUser
		if (user.getRoles() == null) {
			user.setRoles(new ArrayList<String>());
		}
		
		for (String role : user.getRoles()) {
			authorities.add(new GrantedAuthorityImpl(role));
		}
		
		return authorities;
	}
}