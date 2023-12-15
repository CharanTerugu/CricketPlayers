package com.cricket.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cricket.project.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
//
//	@Query("select u from login u where u.name=?1 and u.password=?2")
//	Boolean findUser(String name,String password);

	@Query("select u from user u where u.userName=?1")
	Optional<User> findByName(String userName);
}
