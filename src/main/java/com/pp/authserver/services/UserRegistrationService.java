package com.pp.authserver.services;

import com.pp.authserver.entities.User;
import com.pp.authserver.requests.UserRegistrationRequest;

public interface UserRegistrationService {

	User save(UserRegistrationRequest userRegistrationRequest);
	
	

}
