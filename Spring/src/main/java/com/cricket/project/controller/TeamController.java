package com.cricket.project.controller;



import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.project.Exception.TeamAlreadyExsist;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.entity.Teams;
import com.cricket.project.service.TeamsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {
	@Autowired
	TeamsService ts;
	
	
	@GetMapping("/teams/{id}")
	ResponseEntity<?> getDetails(@PathVariable int id)
	{
		Teams team=new Teams();
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
	
	@GetMapping("teams/name/{name}")
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
	@PostMapping("/team")
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

	@GetMapping("/allTeams")
	List<Teams> getAll()
	{
		
		return ts.getTeams();
	}
	
	@PutMapping("/Team/{id}")
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
	
	@DeleteMapping("/Team/{id}")
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
}
