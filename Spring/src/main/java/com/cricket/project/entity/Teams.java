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
	
	
	
	
	public Teams() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teams(int id, String teamName, List<Cricketer> players,double budget) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.players = players;
		this.budget=budget;
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
	public List<Cricketer> getPlayers() {
		return players;
	}
	public void setPlayers(List<Cricketer> players) {
		this.players = players;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	
	
	
}
