package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Session add(Session session) {
		return sessionRepo.save(session);
	}
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void remove(int id) {
		sessionRepo.deleteById(id);
	}
	
}