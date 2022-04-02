package com.revature.web;

import java.util.Optional;
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
	public ResponseEntity<Session> findById(@PathVariable int id) {
		return ResponseEntity.ok(sessionService.getById(id));
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<Set<Session>> getAllSessions() {
		return ResponseEntity.ok(sessionService.getAll());
	}
	
	@PostMapping("/update")
	public ResponseEntity<Session> updateUserInfoSession(@Valid @RequestBody Session session) {
		return ResponseEntity.ok(sessionService.update(session));

	}
	
	@PostMapping("/update/{user_id}")
	public ResponseEntity<Session> updateUserInfoSessionByUserId(@Valid @RequestBody Session session, @PathVariable int user_id){
		if (user_id == session.getUser1().id) {
			return ResponseEntity.ok(sessionService.updateUser1(session, session.getId(), session.getUser1(), session.getUser1Move(),session.getUser1Status()));
		}else if (user_id == session.getUser2().id) {
			return ResponseEntity.ok(sessionService.updateUser2(session, session.getId(), session.getUser2(), session.getUser2Move(),session.getUser2Status()));
		}
		return null;
	}
	

}