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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name="pokemon")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") 
public class Pokemon {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Team team;
	
	@Column(name="poke_id")
	private int pokeId;
	
	@Column(name="move1")
	private String move1;
	
	@Column(name="move2")
	private String move2;
	
	@Column(name="move3")
	private String move3;
	
	@Column(name="move4")
	private String move4;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Session session;

	public Pokemon(int pokeId, String move1, String move2, String move3, String move4) {
		super();
		this.pokeId = pokeId;
		this.move1 = move1;
		this.move2 = move2;
		this.move3 = move3;
		this.move4 = move4;
	}
}