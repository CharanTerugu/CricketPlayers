package com.cricket.project.Dto;

public class TeamPlayerDto {

	int pid;
	int tid;
    String name;
	String category;
	String country;
	int age;
	double bidPrice;
	String teamName;
	double budget;
	
	
	public TeamPlayerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TeamPlayerDto(int pid, int tid, String name, String category, String country, int age, double bidPrice,
			String teamName, double budget) {
		super();
		this.pid = pid;
		this.tid = tid;
		this.name = name;
		this.category = category;
		this.country = country;
		this.age = age;
		this.bidPrice = bidPrice;
		this.teamName = teamName;
		this.budget = budget;
	}


	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
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
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
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
