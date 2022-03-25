package com.revature.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teams {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;	
	
	@OneToMany(mappedBy="team", cascade = CascadeType.ALL)
	private List<Pokemon> pokemon;

	public Teams(String name, User user, List<Pokemon> pokemon) {
		super();
		this.name = name;
		this.user = user;
		this.pokemon = pokemon;
	}
	
	
}
