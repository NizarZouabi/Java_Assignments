package com.assignment.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.assignment.loginandregistration.models.LoginUser;
import com.assignment.loginandregistration.models.User;
import com.assignment.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> userEmail = userRepository.findByEmail(newUser.getEmail());
		
		if(userEmail.isPresent()) {
			result.rejectValue("email", "Exist", "this Email is already used.");
			return null;
		}
		if(!newUser.getPassword().equals(newUser.getConfirmPass())) {
			result.rejectValue("confirmPass", "Matches", "The Password confirmation must match Password!");
			return null;
		}
		if (result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepository.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> userEmail = userRepository.findByEmail(newLogin.getEmail());
		if(!userEmail.isPresent()) {
			result.rejectValue("email", "NotExist", "Email doesn't exist.");
			return null;
		}
		
		User existingUser = userEmail.get();
			
		if (!BCrypt.checkpw(newLogin.getPassword(), existingUser.getPassword()) && newLogin.getPassword() != null) {
			result.rejectValue("password", "Matches", "Invalid Password!");
			return null;
		}
		if(result.hasErrors()) {
			return null;
		}
		
		return existingUser;
	}
}
