package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Team;

@Repository
public interface TeamsRepository extends JpaRepository<Team, Integer> {

}
