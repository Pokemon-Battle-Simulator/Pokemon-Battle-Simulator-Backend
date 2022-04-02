package com.revature.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.Session;
import com.revature.model.Session.sessionStatus;
import com.revature.model.User;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer>{

	@Modifying
	@Query("UPDATE session set user1_move = :user1Move, user1_status = :user1SessionStatus WHERE id = :id")
	Session updateUser1(@Valid Session session, @Param("id") int id, User user1, @Param("user1Move") int user1Move, @Param("user1SessionStatus") sessionStatus user1SessionStatus);

	@Modifying
	@Query("UPDATE session set user2_move = :user2Move, user2_status = :user2SessionStatus WHERE id = :id")
	Session updateUser2(@Valid Session session, @Param("id") int id, User user2, @Param("user2Move") int user2Move, @Param("user2SessionStatus") sessionStatus user2SessionStatus);

}