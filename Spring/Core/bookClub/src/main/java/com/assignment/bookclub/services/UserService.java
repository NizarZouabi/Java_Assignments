package com.assignment.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.assignment.bookclub.models.LoginUser;
import com.assignment.bookclub.models.User;
import com.assignment.bookclub.repositories.UserRepository;

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
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User findUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User existingUser = user.get();
			return existingUser;
		} else {
			return null;
		}
	}
}
