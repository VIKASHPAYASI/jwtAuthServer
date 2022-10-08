package com.pp.authserver.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pp.authserver.entities.Authority;
import com.pp.authserver.entities.User;
import com.pp.authserver.repository.UserRegistrationRepository;
import com.pp.authserver.requests.UserRegistrationRequest;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRegistrationRepository userRegRepo;

	@Override
	public User save(UserRegistrationRequest userR) {
		Date date = new Date();
		List<Authority> authorityList = new ArrayList<>();
		authorityList.add(createAuthority("USER", "User role"));
		
		User user = new User();
		user.setAuthorities(authorityList);	
		user.setCreatedAt(date);
		user.setEmail(user.getEmail());
		user.setEnabled(true);
		user.setFirstName(userR.getFirstName());
		user.setLastName(userR.getLastName());	
		user.setPhoneNumber(userR.getPhoneNumber());
		user.setPassword(passwordEncoder.encode(userR.getPassword()));
		user.setUpdatedAt(date);
		user.setUserName(userR.getUserName());

		return userRegRepo.save(user);
	}
	
	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}
