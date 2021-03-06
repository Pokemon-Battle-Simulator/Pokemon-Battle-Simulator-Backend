package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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
	public User authenticate(User user) {
		
		User userInDb = userRepo.findByUsername(user.getUsername());
		
		if(user.getPassword().equals(userInDb.getPassword())) {
			return userInDb;
		}
		
		return null;
		
	}
	
	@Transactional(readOnly=true)
	public User getById(int id) {
		return userRepo.getById(id);
	}
	
	@Transactional(readOnly=true)
	public User getByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}