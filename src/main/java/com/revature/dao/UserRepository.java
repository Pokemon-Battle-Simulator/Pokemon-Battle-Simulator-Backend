package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<Object, Object>{
	
	void save(User user);
	
	void checkCredentials(String username, String password);

}
