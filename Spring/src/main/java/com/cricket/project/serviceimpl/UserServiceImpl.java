package com.cricket.project.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cricket.project.Exception.TeamAlreadyExsist;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.Exception.UserAlreadyReported;
import com.cricket.project.Exception.UserNotFound;
import com.cricket.project.entity.Teams;
import com.cricket.project.entity.User;
import com.cricket.project.repositories.UserRepository;
import com.cricket.project.service.TeamsService;
import com.cricket.project.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository repo;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	TeamsService teamService;
	
	@Override
	public void signup(User user,int teamId) throws UserAlreadyReported, TeamNotFound {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(repo.findByName(user.getUserName()).isPresent()) {
			throw new UserAlreadyReported("The username already exsists ");
		}
		else {
			repo.save(user);
	 buyTeam(user.getUserName(), teamId);
		
			
			
		}
	}

	@Override
	public void buyTeam(String userName, int teamId) throws UserAlreadyReported, TeamNotFound {
		// TODO Auto-generated method stub
		Optional<User> user=repo.findByName(userName);
		
		
		if(teamService.getTeamByUserId(user.get().getUserId())==null) {
			
			Teams team=teamService.findById(teamId);
			team.setUser(user.get());
			teamService.assignTeamToUser(team);
			
		}
		else
		{
			throw new UserAlreadyReported("user already brought a team ");
		}
		
	}

	@Override
	public Optional<User> getDetailsByUserName(String userName) {
		// TODO Auto-generated method stub
		return repo.findByName(userName);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}


}
