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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user1 = new User();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user2_id")
	private User user2 = new User();
	
	@Column(name="user1_status")
	private sessionStatus user1Status = sessionStatus.EMPTY;
	
	@Column(name="user2_status")
	private sessionStatus user2Status = sessionStatus.EMPTY;
	
	@Column(name="user1_move")
	private int user1Move = 0;
	
	@Column(name="user2_move")
	private int user2Move = 0;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user1_poke")
	private Pokemon user1Poke = new Pokemon();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user2_poke")
	private Pokemon user2Poke = new Pokemon();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user1_team")
	private Teams user1Team = new Teams();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user2_team")
	private Teams user2Team = new Teams();

	public Session(boolean active, User user1, User user2, sessionStatus user1Status, sessionStatus user2Status,
			int user1Move, int user2Move, Pokemon user1Poke, Pokemon user2Poke, Teams user1Team, Teams user2Team) {
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
		this.user1Team = user1Team;
		this.user2Team = user2Team;
	}

	// used when first creating the new session
	public Session(boolean active, User user1, sessionStatus user1Status, int user1Move, Pokemon user1Poke,
			Teams user1Team) {
		super();
		this.active = active;
		this.user1 = user1;
		this.user1Status = user1Status;
		this.user1Move = user1Move;
		this.user1Poke = user1Poke;
		this.user1Team = user1Team;
	}
}