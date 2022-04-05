package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private boolean active = true;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy="session")
	@JoinColumn(name="user1_id")
	private User user1;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy="session")
	@JoinColumn(name="user2_id")
	private User user2;
	
	@Column(name="user1_status")
	private sessionStatus user1Status = sessionStatus.EMPTY;
	
	@Column(name="user2_status")
	private sessionStatus user2Status = sessionStatus.EMPTY;
	
	@Column(name="user1_move")
	private String user1Move;
	
	@Column(name="user2_move")
	private String user2Move;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy="session")
	@JoinColumn(name="user1_poke")
	private Pokemon user1Poke;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy="session")
	@JoinColumn(name="user2_poke")
	private Pokemon user2Poke;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy="session")
	@JoinColumn(name="user1_team")
	private Team user1Team;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy="session")
	@JoinColumn(name="user2_team")
	private Team user2Team;

	public Session(boolean active, User user1, User user2, sessionStatus user1Status, sessionStatus user2Status,
			String user1Move, String user2Move, Pokemon user1Poke, Pokemon user2Poke) {
		super();
		this.active = active;
		this.user1 = user1;
		this.user2 = user2;
		this.user1Status = user1Status;
		this.user2Status = user2Status;
		this.user1Move = user1Move;
		this.user2Move = user2Move;
		this.user1Poke = user1Poke;
		this.user2Poke = user2Poke;
	}
}