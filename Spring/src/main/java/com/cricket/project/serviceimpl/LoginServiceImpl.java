package com.cricket.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.project.Exception.UserNotFound;
import com.cricket.project.entity.Login;
import com.cricket.project.repositories.LoginRepository;
import com.cricket.project.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	LoginRepository repo;
	@Override
	public Boolean login(Login user) throws UserNotFound {
		
		if(repo.findUser(user.getName(), user.getPassword())==null)
		{
			throw new UserNotFound("user not Found");
		}
		
		return true;
	}

}
