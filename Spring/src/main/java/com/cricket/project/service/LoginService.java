package com.cricket.project.service;

import org.springframework.stereotype.Component;

import com.cricket.project.Exception.UserNotFound;
import com.cricket.project.entity.Login;

@Component
public interface LoginService {

	
	Boolean login(Login user) throws UserNotFound;
}
