package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;
import com.revature.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User registerUser(User user) {
		return userRepo.save(user);
	}
	
	
	@Transactional(readOnly=true)
	public User loginUser(User user) {
		return userRepo.checkCredentials(user.getUsername(), user.getPassword());
	}


	public User getByID(int id) {
		return userRepo.getById(id);
	}


	public User getByUsername(String username) {
		return userRepo.getByUsername(username);
	}

}