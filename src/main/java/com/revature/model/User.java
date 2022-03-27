package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Column
	public String username;
	
	@Column
	public String email;
	
	@Column
	public String password;
	
	@Column(name="first_name")
	public String firstName;
	
	@Column(name="last_name")
	public String lastName;
	
	@Column
	public String favoritePokemon;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
	private List<Teams> teams;
	
	//For logging in a user
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	//For registering a user.
	public User(String username, String email, String password, String firstName, String lastName, String favoritePokemon, List<Teams> teams) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favoritePokemon = favoritePokemon;
		this.teams = teams;
	}
	
	
}
