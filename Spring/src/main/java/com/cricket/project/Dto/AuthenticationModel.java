package com.cricket.project.Dto;
public class AuthenticationModel {

	
	
	String userName;
	String password;
	public AuthenticationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthenticationModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
