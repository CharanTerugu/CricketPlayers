package com.cricket.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="login")
public class Login {
	
	@Id
	@GeneratedValue
	String name;
	String password;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
