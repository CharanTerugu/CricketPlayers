package com.cricket.project.controller;



import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.project.Dto.TeamDto;
import com.cricket.project.Exception.TeamAlreadyExsist;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.entity.Teams;
import com.cricket.project.service.TeamsService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {
	@Autowired
	TeamsService ts;
	
	
	@GetMapping("/common/teams/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	ResponseEntity<?> getDetails(@PathVariable int id )
	{
		TeamDto team=new TeamDto();
		try 
		{
			team=ts.find(id);
			return new ResponseEntity<>(team,HttpStatus.ACCEPTED);
		}
		catch(TeamNotFound e)
		{
			System.out.println("Exception catched");
		}
		catch(Exception e)
		{
			
		}
		return new ResponseEntity<>("No Team Found",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("common/teams/name/{name}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	ResponseEntity<?> getTeam(@PathVariable String name)
	{
		try
		{
			Teams team=ts.find(name);
			return new ResponseEntity<>(team,HttpStatus.FOUND);
		}
		catch(TeamNotFound e)
		{
			System.out.println("Expection catched");
		}
		catch(Exception e)
		{
			
		}
		return new ResponseEntity<>("Team Not Found",HttpStatus.NOT_FOUND);
	}
	@PostMapping("/admin/team")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ResponseEntity<?> addTeam(@RequestBody Teams team)
	{
		try
		{
		ts.insert(team);
		}
		catch (TeamAlreadyExsist e) {
			// TODO: handle exception
			return new ResponseEntity<>("team already present",HttpStatus.ALREADY_REPORTED);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping("common/allTeams")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	List<TeamDto> getAll()
	{
		
		return ts.getTeams();
	}
	
	@PutMapping("admin/Team/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ResponseEntity<?> update(@PathVariable int id,@RequestBody Teams team)
	{
		try {
		ts.updateTeam(id, team);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.NOT_ACCEPTABLE);
		}
		return  new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("admin/Team/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ResponseEntity<?> delete(@PathVariable int id)
	{
		try {
			ts.deleteTeam(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.BAD_GATEWAY);
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/myteam")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	ResponseEntity<TeamDto> myTeam(HttpServletRequest request){
		try {
		TeamDto team=ts.getMyTeam(request.getUserPrincipal().getName());
		return new ResponseEntity<>(team,HttpStatus.OK);
		}
		catch (TeamNotFound e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("admin/available/teams")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	List<TeamDto> getAvailableTeams()
	{
		
		return ts.getAvailableTeams();
	}
}
