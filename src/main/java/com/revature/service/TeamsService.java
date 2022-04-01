package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Team;
import com.revature.repository.TeamsRepository;

@Service
public class TeamsService {
	
	@Autowired
	private TeamsRepository teamsRepo;
	
public int addTeam(Team team) {
		
		Team savedTeam = teamsRepo.save(team);
		return savedTeam.getId();
	}
	
	public List<Team> findAllTeams() {
		
		return teamsRepo.findAll();
	}
	
	public void deleteTeamById(int id) {
		
		teamsRepo.deleteById(id);
	}

}
