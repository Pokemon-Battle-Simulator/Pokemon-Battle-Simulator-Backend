package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.model.Teams;
import com.revature.repository.TeamsRepository;

@Service
public class TeamsService {
	
	@Autowired
	private TeamsRepository teamsRepo;
	
public int addTeam(Teams team) {
		
		Teams savedTeam = teamsRepo.save(team);
		return savedTeam.getId();
	}
	
	public List<Teams> findAllTeams() {
		
		return teamsRepo.findAll();
	}
	
	public void deleteTeamById(int id) {
		
		teamsRepo.deleteById(id);
	}

}
