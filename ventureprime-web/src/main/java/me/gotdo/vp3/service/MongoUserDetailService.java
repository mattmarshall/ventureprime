package me.gotdo.vp3.service;

import java.util.Collection;

import me.gotdo.vp3.web.model.VPUser;
import me.gotdo.vp3.web.repository.VPUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.collect.Sets;

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

		Collection<GrantedAuthorityImpl> authorities = Sets.newHashSet(new GrantedAuthorityImpl("ROLE_USER"));
		return new User(vpUser.getId(), vpUser.getCredentials(), vpUser.isActive(), true, true, true, authorities);
	}
}