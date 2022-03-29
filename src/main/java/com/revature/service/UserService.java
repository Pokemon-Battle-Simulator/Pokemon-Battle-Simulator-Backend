package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.UserRepository;
import com.revature.model.User;

public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	//Whenever this method is invoked, we want to begin a new transaction (Unit of work against the DB)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User registerUser(User user) {
		return userRepo.save(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User loginUser(User user) {
		return userRepo.checkCredentials(user.username, user.password);
	}

}
