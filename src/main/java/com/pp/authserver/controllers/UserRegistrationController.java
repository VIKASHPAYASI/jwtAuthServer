package com.pp.authserver.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pp.authserver.entities.User;
import com.pp.authserver.requests.UserRegistrationRequest;
import com.pp.authserver.services.UserRegistrationService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@PostMapping("/reg")
	public ResponseEntity<?> register(@RequestBody UserRegistrationRequest userRegistrationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
		User response = userRegistrationService.save(userRegistrationRequest);
		return ResponseEntity.ok(response);
	}

}
