package com.cricket.project.serviceimpl;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cricket.project.Exception.TeamAlreadyExsist;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.entity.Cricketer;
import com.cricket.project.entity.Teams;
import com.cricket.project.repositories.CricketerRepository;
import com.cricket.project.repositories.TeamsRepository;
import com.cricket.project.service.CricketService;
import com.cricket.project.service.TeamsService;
@Component
public class TeamsServiceImpl implements TeamsService{

	
	@Autowired
	TeamsRepository repo;
	@Autowired
CricketerRepository crepo;
	
	@Override
	public Teams find(int id) throws TeamNotFound {
		// TODO Auto-generated method stub
		if(repo.findById(id).isEmpty())
		{
			throw new TeamNotFound("Team Not Found");
		}
		return repo.getById(id);
	}

	@Override
	public Teams find(String name) throws TeamNotFound {
		// TODO Auto-generated method stub
		if(repo.getByTeamName(name)==null)
		{
			throw new TeamNotFound("Team not found");
		}
		return repo.getByTeamName(name);
	}

	@Override
	public void insert(Teams team) throws TeamAlreadyExsist {
		// TODO Auto-generated method stub
	
		if(repo.getByTeamName(team.getTeamName())==null)
		{
		repo.save(team);
		}
		else
			throw new TeamAlreadyExsist("Team already present");
	}

	@Override
	public int getId(String teamName) {
		// TODO Auto-generated method stub
		return repo.getTeamId(teamName);
	}

	@Override
	public double getBudget(int id) {
		// TODO Auto-generated method stub
		return repo.getBudget(id);
	}

	@Override
	public List<Teams> getTeams() {
		// TODO Auto-generated method stub
		
		List<Teams> team=repo.findAll();
		return repo.findAll();
	}

	@Override
	public void updateTeam(int id, Teams team) {
		// TODO Auto-generated method stub
		
		Teams t=repo.getById(id);
		t.setTeamName(team.getTeamName());
		t.setBudget(team.getBudget());
		repo.save(t);
	}

	@Override
	public void deleteTeam(int id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);
		
	}

}
