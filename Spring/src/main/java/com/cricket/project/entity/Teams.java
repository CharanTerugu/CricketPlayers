package com.cricket.project.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "teams")
public class Teams {

	@Id
	@GeneratedValue
	int id;
	String teamName;
	double budget;
	@OneToMany(mappedBy = "teams",cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnoreProperties
	List<Cricketer> players=new ArrayList<>();
	
	@OneToOne
	User user;
	
	
	public Teams() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Teams(int id, String teamName, double budget, List<Cricketer> players, User user) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.budget = budget;
		this.players = players;
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public double getBudget() {
		return budget;
	}


	public void setBudget(double budget) {
		this.budget = budget;
	}


	public List<Cricketer> getPlayers() {
		return players;
	}


	public void setPlayers(List<Cricketer> players) {
		this.players = players;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
