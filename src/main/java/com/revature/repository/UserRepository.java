package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("FROM User WHERE username=%:username AND password=%:password")
	User checkCredentials(String username, String password);

}