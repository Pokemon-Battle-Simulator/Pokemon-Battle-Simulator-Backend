package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Teams;
import com.revature.repository.TeamsRepository;

@Service
public class TeamsService {
	
	@Autowired
	private TeamsRepository teamsRepo;
	
	public List<Teams> findAllTeams() {
		
		return teamsRepo.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Teams add(Teams team) {
		return teamsRepo.save(team);
	}
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void remove(int id) {
		teamsRepo.deleteById(id);
	}
}
