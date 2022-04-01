package com.revature.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Session;
import com.revature.service.SessionService;

@RestController
@RequestMapping("/sessions")
public class SessionController {
	
	@Autowired
	private SessionService sessionService;
	
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*") 
	@PostMapping("/add")
	public ResponseEntity<Session> addSession(@Valid @RequestBody Session session){
		return ResponseEntity.ok(sessionService.add(session));
	}
	
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*") 
	@DeleteMapping("/delete/{id}")
	public void deleteSession(@PathVariable int id){
		sessionService.remove(id);
	}
	

}
