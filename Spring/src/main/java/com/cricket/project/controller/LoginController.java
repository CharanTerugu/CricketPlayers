package com.cricket.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.project.Exception.UserNotFound;
import com.cricket.project.entity.Login;
import com.cricket.project.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	LoginService ls;
	
	@PostMapping("/login")
	ResponseEntity<?> login(@RequestBody Login user)
	{
	 
     try
     {
    	 ls.login(user);
     }
     catch (UserNotFound e) {
		// TODO: handle exception
		 return new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND); 
	}
     catch (Exception e) {
		// TODO: handle exception
	}
     
	 return new ResponseEntity<>(HttpStatus.ACCEPTED);
	 
	}
	
	
}
