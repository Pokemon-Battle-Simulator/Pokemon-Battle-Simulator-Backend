package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pokemon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name="team_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teamId;
	
	@Column(name="poke_id")
	private int pokeId;

	public Pokemon(int teamId, int pokeId) {
		super();
		this.teamId = teamId;
		this.pokeId = pokeId;
	}
	
}