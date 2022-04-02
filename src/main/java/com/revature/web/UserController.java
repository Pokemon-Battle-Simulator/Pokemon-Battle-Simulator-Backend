
  
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

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		return ResponseEntity.ok(userService.registerUser(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody User user){
		return ResponseEntity.ok(userService.loginUser(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable int id){
		return ResponseEntity.ok(userService.getByID(id));
	}

	
	@GetMapping("/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable String username){
		return ResponseEntity.ok(userService.getByUsername(username));
	}


}