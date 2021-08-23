package com.cognizant.truyum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.UserRepository;

public class UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	
	public void signup(User user) throws UserAlreadyExistsException {
		Optional<User> signedUser = userRepository.findByName(user.getName());
		if(signedUser.isPresent()) {
			throw new UserAlreadyExistsException("User Already Exists");
		} else {
			userRepository.save(user);
		}
	}
}
