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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") 
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
	public User(String username, String email, String password, String firstName, String lastName, String favoritePokemon) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favoritePokemon = favoritePokemon;
	}
	
	
}
