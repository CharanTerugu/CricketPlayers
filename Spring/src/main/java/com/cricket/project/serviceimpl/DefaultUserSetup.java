package com.cricket.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cricket.project.entity.User;
import com.cricket.project.repositories.UserRepository;

import jakarta.transaction.Transactional;
@Component
public class DefaultUserSetup  implements ApplicationRunner{
	
	@Autowired
	private UserServiceImpl userservice;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		if(userservice.getDetailsByUserName("Admin").isEmpty()) {
			User intialUser= new User();
			intialUser.setAge(30);
			intialUser.setEmail("admin@gmail.com");
			intialUser.setUserName("Admin");
			intialUser.setPassword(passwordEncoder.encode("Ad@123"));
			intialUser.setRoles("ROLE_ADMIN");
			
			userservice.saveUser(intialUser);
		}
		
	}

}
