package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") 
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@NotBlank
	private String username;
	
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank
	private String favoritePokemon;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Team team;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Session session;
	
	//For logging in a user
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	//For registering a user.
	public User(String firstName, String lastName, String email, String username, String password, String favoritePokemon) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favoritePokemon = favoritePokemon;
	}
	
	
}
