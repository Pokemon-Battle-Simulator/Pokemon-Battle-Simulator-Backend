package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name="session")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") 
public class Session {
	
	public enum sessionStatus{
		EMPTY, 
		CONNECTED, 
		CHOOSING, 
		READY, 
		NO_POKEMON, 
		DISCONNECTED;
	}
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private boolean active;
	
	@Column(name="user1_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private int user1Id;
	
	@Column(name="user2_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user2_id")
	private int user2Id;
	
	@Column(name="user1_status")
	private sessionStatus user1Status;
	
	@Column(name="user2_status")
	private sessionStatus user2Status;
	
	@Column(name="user1_move")
	private int user1Move;
	
	@Column(name="user2_move")
	private int user2Move;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user1_poke")
	private int user1Poke;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user2_poke")
	private int user2Poke;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user1_team")
	private int user1Team;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user2_team")
	private int user2Team;

	public Session(boolean active, int user1Id, int user2Id, sessionStatus user1Status, sessionStatus user2Status,
			int user1Move, int user2Move, int user1Poke, int user2Poke, int user1Team, int user2Team) {
		super();
		this.active = active;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.user1Status = user1Status;
		this.user2Status = user2Status;
		this.user1Move = user1Move;
		this.user2Move = user2Move;
		this.user1Poke = user1Poke;
		this.user2Poke = user2Poke;
		this.user1Team = user1Team;
		this.user2Team = user2Team;
	}
	
	
}
