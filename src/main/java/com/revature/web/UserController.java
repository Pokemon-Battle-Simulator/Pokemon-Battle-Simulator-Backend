package com.revature.web;
import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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
import com.revature.util.JwtTokenManager;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenManager tokenManager;
	

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		return ResponseEntity.ok(userService.registerUser(user));
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user, HttpServletResponse response){
		user = userService.authenticate(user);
		
		if(user != null) {
			
			//Generate a token.
			String token = tokenManager.issueToken(user); // xxxxx.yyyyyy.zzzzzzz
			
			// append to the response (in the header) the generated token (the stamp that the bouncer gives you)
			response.addHeader("portal-token", token);
			response.addHeader("Access-Control-Expose-Headers", "portal-token");
			response.setStatus(200); // successful connection
			
			// return the user;
			return user;
		}else {
			
			//401 code: The request could not be completed because user is not valid.
			response.setStatus(401);
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable int id){
		return ResponseEntity.ok(userService.getById(id));
	}

	
	@GetMapping("/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable String username){
		return ResponseEntity.ok(userService.getByUsername(username));
	}


}