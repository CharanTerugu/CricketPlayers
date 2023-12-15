package com.cricket.project.Dto;

import java.util.ArrayList;
import java.util.List;

import com.cricket.project.entity.Cricketer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class TeamDto {

	
	int id;
	String teamName;
	double budget;
	public TeamDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeamDto(int id, String teamName, double budget) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.budget = budget;
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
	
	
}
