package com.cricket.project.serviceimpl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cricket.project.Dto.UserDetailsImpl;
import com.cricket.project.entity.User;
import com.cricket.project.repositories.UserRepository;





@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user=repo.findByName(userName);
		return user.map(UserDetailsImpl::new).orElseThrow(()->new UsernameNotFoundException("User not found "));
	
	}
}