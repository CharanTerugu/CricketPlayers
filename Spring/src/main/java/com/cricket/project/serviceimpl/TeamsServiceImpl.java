package com.cricket.project.serviceimpl;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cricket.project.Dto.TeamDto;
import com.cricket.project.Dto.TeamDtoConverter;
import com.cricket.project.Exception.TeamAlreadyExsist;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.entity.Cricketer;
import com.cricket.project.entity.Teams;
import com.cricket.project.repositories.CricketerRepository;
import com.cricket.project.repositories.TeamsRepository;
import com.cricket.project.service.CricketService;
import com.cricket.project.service.TeamsService;

import ch.qos.logback.core.pattern.Converter;
@Component
public class TeamsServiceImpl implements TeamsService{

	
	@Autowired
	TeamsRepository repo;
	@Autowired
CricketerRepository crepo;
	
	@Override
	public TeamDto find(int id) throws TeamNotFound {
		// TODO Auto-generated method stub
		if(repo.findById(id).isEmpty())
		{
			throw new TeamNotFound("Team Not Found");
		}
		TeamDtoConverter coverter=new TeamDtoConverter();
		
		return coverter.convertToTeamDto(repo.getById(id));
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
	public List<TeamDto> getTeams() {
		// TODO Auto-generated method stub
		
		List<Teams> team=repo.findAll();
		
		TeamDtoConverter converter=new TeamDtoConverter();
//		List<TeamDto> teamDto=team.stream().map(a->{
//			TeamDto dto=new TeamDto();
//			dto.setId(a.getId());
//			dto.setTeamName(a.getTeamName());
//			dto.setBudget(a.getBudget());
//			return dto;
//			
//		} ).collect(Collectors.toList());
//		

		return converter.convertToTeamDto(team);
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

	@Override
	public Teams getTeamByUserId(int userId) {
		// TODO Auto-generated method stub
		return repo.getTeamByUserId(userId);
	}

	@Override
	public void assignTeamToUser(Teams team) {
		// TODO Auto-generated method stub
		repo.save(team);
	}

	@Override
	public TeamDto getMyTeam(String userName) throws TeamNotFound {
		// TODO Auto-generated method stub
		TeamDtoConverter converter=new TeamDtoConverter();
		if(repo.getTeamByUserName(userName)==null) {
			throw new TeamNotFound("No Team Found For this User");
		}
		else
		return converter.convertToTeamDto( repo.getTeamByUserName(userName));
	}

	@Override
	public Teams findById(int id) throws TeamNotFound {
		// TODO Auto-generated method stub
		if(repo.findById(id).isEmpty())
		{
			throw new TeamNotFound("Team Not Found");
		}
		
		
		return repo.getById(id);
	}

	@Override
	public List<TeamDto> getAvailableTeams() {
		// TODO Auto-generated method stub
		
		TeamDtoConverter teams=new TeamDtoConverter();
		
		return teams.convertToTeamDto(repo.getUnAssignedTeams())  ;
	}
	
	
	
	

}
