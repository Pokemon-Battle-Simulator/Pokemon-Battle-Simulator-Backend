package com.revature.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("FROM User WHERE username = :username and password = :password")
	User checkCredentials(@Param ("username")String username, @Param ("password") String password);

	@Query("FROM User WHERE username = :username")
	User getByUsername(@Param ("username") String username); 

	
}
