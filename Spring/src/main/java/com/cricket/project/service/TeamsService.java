package com.cricket.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cricket.project.Dto.TeamDto;
import com.cricket.project.Exception.TeamAlreadyExsist;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.entity.Cricketer;
import com.cricket.project.entity.Teams;

@Service
public interface TeamsService {

	Teams findById(int id) throws TeamNotFound;
	TeamDto find(int id) throws TeamNotFound;
	Teams find(String name) throws TeamNotFound;
	void insert(Teams team) throws TeamAlreadyExsist;
	int getId(String teamName);
	double getBudget(int id);
   List<TeamDto> getTeams();
   void updateTeam(int id,Teams team);
   void deleteTeam(int id);
   Teams getTeamByUserId(int userId);
   void assignTeamToUser(Teams team);
   TeamDto getMyTeam(String userName) throws TeamNotFound;
   List<TeamDto> getAvailableTeams();
}
