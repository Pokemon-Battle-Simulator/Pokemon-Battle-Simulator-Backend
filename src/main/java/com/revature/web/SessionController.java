package com.revature.web;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Pokemon;
import com.revature.model.Session;
import com.revature.service.SessionService;

@RestController
@RequestMapping("/sessions")
public class SessionController {
	
	@Autowired
	private SessionService sessionService;
	
	@PostMapping("/add")
	public ResponseEntity<Session> addSession(@Valid @RequestBody Session session){
		return ResponseEntity.ok(sessionService.add(session));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSession(@PathVariable int id){
		sessionService.remove(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> findById(@PathVariable int id) {
		return ResponseEntity.ok(sessionService.getById(id));
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<Set<Pokemon>> getAllSessions() {
		return ResponseEntity.ok(sessionService.getAll());
	}
	
	@PostMapping("/update")
	public ResponseEntity<Session> updateUserInfoSession(@Valid @RequestBody Session session) {
		return ResponseEntity.ok(sessionService.update(session, session.getId()));

	}
	
	

}