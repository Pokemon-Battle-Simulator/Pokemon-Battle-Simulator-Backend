package com.revature.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Pokemon;
import com.revature.model.Session;
import com.revature.model.Session.sessionStatus;
import com.revature.model.User;
import com.revature.repository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepo;
	
	public Set<Session> findAllSessions() {
		
		return (Set<Session>) sessionRepo.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Session add(Session session) {
		return sessionRepo.save(session);
	}
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void remove(int id) {
		sessionRepo.deleteById(id);
	}

	@Transactional(readOnly=true)
	public Session getById(int id) {
		return sessionRepo.getById(id);
	}

	@Transactional(readOnly=true)
	public Set<Session> getAll() {
		return sessionRepo.findAll().stream()
				.collect(Collectors.toSet());
	}

	
	public Session update(@Valid Session session) {
		return sessionRepo.save(session);
	}

	public Session updateUser1(@Valid Session session, int id, User user1, String user1Move, sessionStatus user1SessionStatus) {
		return sessionRepo.updateUser1(session, user1, id, user1Move, user1SessionStatus);
	}

	public Session updateUser2(@Valid Session session, int id, User user2, String user2Move, sessionStatus user2SessionStatus) {
		
		return sessionRepo.updateUser2(session, user2, id, user2Move, user2SessionStatus);
	}
	
}