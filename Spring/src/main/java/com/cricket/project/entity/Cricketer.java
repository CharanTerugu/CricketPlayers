package com.cricket.project.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="cricketer")
public class Cricketer {
	@GeneratedValue
	@Id
	int id;
	String name;
	String category;
	String country;
	int age;
	double bidPrice;
	String mailId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JsonIgnoreProperties
	Teams teams;
	
	
	public Cricketer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cricketer(int id, String name, String category, String country, int age, double bidPrice, String mailId,
			Teams teams) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.country = country;
		this.age = age;
		this.bidPrice = bidPrice;
		this.mailId = mailId;
		this.teams = teams;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Teams getTeams() {
		return teams;
	}
	public void setTeams(Teams teams) {
		this.teams = teams;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	

}
