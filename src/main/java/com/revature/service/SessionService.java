package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Pokemon;
import com.revature.model.Session;
import com.revature.repository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepo;
	
	public List<Session> findAllSessions() {
		
		return sessionRepo.findAll();
	}
	
}
