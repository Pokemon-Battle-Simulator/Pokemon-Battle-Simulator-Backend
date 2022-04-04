package com.revature.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Integer> { 

	User findByUsername(String username);
		
}