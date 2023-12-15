package com.cricket.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.project.Dto.AuthenticationModel;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.Exception.UserAlreadyReported;
import com.cricket.project.Exception.UserNotFound;

import com.cricket.project.entity.User;
import com.cricket.project.service.UserService;
import com.cricket.project.serviceimpl.JwtService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService us;
	
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authmanager;
	
	@PostMapping("/admin/user/{teamId}")
	ResponseEntity<?> signup(@RequestBody User user,@PathVariable int teamId){
		
		try {
			 us.signup(user,teamId);
			 return new ResponseEntity("Account created successfully", HttpStatus.CREATED);
			 
		}
		catch(UserAlreadyReported e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.ALREADY_REPORTED);
		} catch (TeamNotFound e) {
			// TODO Auto-generated catch block
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/any/user/authenticate")
	  ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthenticationModel auth)  {
			
			Authentication authentication ;
			try
			{
	      authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword()));
	     String token= jwtService.generateToken(auth.getUserName(),authentication.getAuthorities());
	   
	     return new ResponseEntity(token,HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity("Invalid credentials ",HttpStatus.UNAUTHORIZED);
			}
	  }
	
	@PostMapping("any/user/logout")
	void logout(HttpServletRequest request) throws ServletException
	{
		try {
			
			request.logout();
			
			
			
		}
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println(e.getMessage());
		}
		jwtService.generateToken(null, null);
	}

	@PostMapping("/user/team/{teamId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	ResponseEntity<?> buyTeam(@PathVariable int teamId,HttpServletRequest request ){
		String userName=request.getUserPrincipal().getName();
		try {
			us.buyTeam(userName, teamId);
			return new ResponseEntity<>("Succesfully purchased team",HttpStatus.OK);
		}
		catch (UserAlreadyReported e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	}
	
}
