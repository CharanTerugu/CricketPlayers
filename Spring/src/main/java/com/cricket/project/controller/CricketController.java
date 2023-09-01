package com.cricket.project.controller;

import java.util.List;

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

import com.cricket.project.Dto.TeamPlayerDto;
import com.cricket.project.Exception.NotEnoughAmount;
import com.cricket.project.Exception.PlayerAlreadyExsists;
import com.cricket.project.Exception.PlayerNotFound;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.entity.Cricketer;

import com.cricket.project.service.CricketService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CricketController {

	@Autowired
	CricketService crs;
	 @PostMapping("/cricketer/{id}")
	 ResponseEntity<?> add(@PathVariable int id,@RequestBody Cricketer data) 
	 {
		 try
		 {
		   crs.addDetails(id,data);
		 }
		 catch(TeamNotFound t)
		 {
			 return new ResponseEntity<>(t.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		 }
		 catch(PlayerAlreadyExsists p)
		 {
			 return new ResponseEntity<>(p.getMessage(),HttpStatus.ALREADY_REPORTED);
		 }
		 catch(NotEnoughAmount amount)
		 {
			 return new ResponseEntity<>(amount.getMessage(),HttpStatus.BAD_REQUEST);
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		 return new  ResponseEntity<>(HttpStatus.OK);
		 
	 }
	 
	 @GetMapping("/AllCricketers")
	 List<TeamPlayerDto> showAll()
	 {
		 return crs.displayAll();
	 }
	 @PutMapping("/edit/{id}")
	 ResponseEntity<?> edit(@PathVariable int id,@RequestBody Cricketer cricketer)
	 {
		 try
		 {
		 crs.update(id, cricketer);
		 }
		 catch (NotEnoughAmount e) {
			// TODO: handle exception
			 return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
	 }
	 @DeleteMapping("/delete/{id}")
	 void remove(@PathVariable int id)
	 {
		 crs.delete(id);
	 }
	 @DeleteMapping("/deletePlayer/{id}")
	 void delete(@PathVariable int id)
	 {
		 crs.deletePlayer(id);
	 }
	 @GetMapping("/Players/{name}")
	 List<Cricketer> getPLayers(@PathVariable String name)
	 {
		
		 return crs.getPlayersByTeamName(name);
	 }
	 @GetMapping("/Player/TeamDetails/{name}")
	 ResponseEntity<String> getTeamName(@PathVariable String name)
	 {
		 try {
			 return new ResponseEntity<>(crs.getTeamDetails(name),HttpStatus.FOUND);
		 }
		 catch (TeamNotFound e) {
			// TODO: handle exception
			 return new ResponseEntity<String>("TeamNotFound",HttpStatus.NOT_FOUND);
		}
		 catch(PlayerNotFound p)
		 {
			 return new ResponseEntity<String>("Player NotFound",HttpStatus.NOT_FOUND);
		 }
		 catch(Exception e)
		 {
			 
		 }
		 return new ResponseEntity<String>("Exception occured",HttpStatus.NOT_FOUND);
	 }
	 
	 @GetMapping("/players/{id}")
	 List<Cricketer> getPlayers(@PathVariable int id)
	 {
		 
		 return crs.PlayersByTeamid(id);
	 }
	 @GetMapping("/player/{id}")
	 Cricketer getPlayer(@PathVariable int id)
	 {
		 return crs.getPlayer(id);
	 }
	 
	 @GetMapping("/unAssignedPlayers")
	 List<Cricketer> getAll(){
		 return crs.getUnAssignedPlayers();
	 }
	 
	 
	 @PostMapping("/addPlayer")
	 ResponseEntity<?> addPlayer(@RequestBody Cricketer player)
	 {
		 
		 try {
			 crs.addPlayer(player);
		 }
		 catch (PlayerAlreadyExsists e) {
			// TODO: handle exception
			 return new ResponseEntity<>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
		}
		 catch (Exception e) {
			// TODO: handle exception
		}
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
	 }
	 
	 @PostMapping("/assignPlayer/{tid}")
	 ResponseEntity<?> addPlayerToTeam(@PathVariable int tid,@RequestBody int pid)
	 {
		 try 
		 {
			 crs.addPlayerToTeam(tid, pid);
		 }
		 catch (TeamNotFound e) {
			// TODO: handle exception
			 return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println(e);
			 return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
		 
	 }
}
