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
	@Query("UPDATE Session set user1Move = ?4, user1Status = ?5 WHERE id = ?3")
	Session updateUser1(@Valid Session session, User user1, @Param("id") int id,  @Param("user1Move") int user1Move, @Param("user1SessionStatus") sessionStatus user1SessionStatus);

	@Modifying
	@Query("UPDATE Session set user2Move = ?4, user2Status = ?5 WHERE id = ?3")
	Session updateUser2(@Valid Session session, User user2, @Param("id") int id, @Param("user2Move") int user2Move, @Param("user2SessionStatus") sessionStatus user2SessionStatus);

}