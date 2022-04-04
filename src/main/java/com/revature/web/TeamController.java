package com.revature.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Pokemon;
import com.revature.model.Team;
import com.revature.service.PokemonService;
import com.revature.service.TeamsService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamsService teamService;
	
	@PostMapping("/add")
	public ResponseEntity<Team> addTeam(@Valid @RequestBody Team team) {
		return ResponseEntity.ok(teamService.add(team));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Team> getTeam(@PathVariable int id) {
		return ResponseEntity.ok(teamService.getById(id));
	}

}