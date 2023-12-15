package com.cricket.project.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.Exception.UserAlreadyReported;
import com.cricket.project.Exception.UserNotFound;
import com.cricket.project.entity.User;


@Component
public interface UserService {

	
	void signup(User user,int teamId) throws UserAlreadyReported, TeamNotFound;
	void buyTeam(String userName,int teamId) throws UserAlreadyReported, TeamNotFound;
	Optional<User> getDetailsByUserName(String userName);
}
