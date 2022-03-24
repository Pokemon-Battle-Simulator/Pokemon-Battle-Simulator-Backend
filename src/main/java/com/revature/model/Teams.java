package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="team_id")
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@OneToOne(mappedBy = "teams")
	@Column(name="user_id")
	private int UserId;

	public Teams(String name, int userId) {
		super();
		this.name = name;
		UserId = userId;
	}
	
	
}
