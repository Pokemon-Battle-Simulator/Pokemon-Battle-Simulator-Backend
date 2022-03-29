package com.revature.web;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*", allowedHeaders="*") 
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//http://loclhost:5000/register
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		
		return ResponseEntity.ok(userService.registerUser(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody User user){
		return ResponseEntity.ok(userService.loginUser(user));

	}

}
