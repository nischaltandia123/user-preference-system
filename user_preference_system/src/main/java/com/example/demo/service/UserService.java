package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired

	private UserRepository userRepository;
	private User user;
	public UserNotFoundException exceptionsException;

	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	public User getUserByEmail(String email) {
		Optional<User> a = userRepository.findById(email);

		if (a.isPresent()) {
			return userRepository.findById(email).orElse(null);
		} else {
			throw new UserNotFoundException("User with email " + email + "doesn't exist");
		}
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User deleteUserByEmail(String email) {
		Optional<User> a = userRepository.findById(email);

		if (a.isPresent()) {
			userRepository.deleteById(email);
			return user;
		} else {
			throw new UserNotFoundException("User with email " + email + "not found");
		}
	}
}