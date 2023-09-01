package com.cricket.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cricket.project.entity.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	@Query("select u from login u where u.name=?1 and u.password=?2")
	Boolean findUser(String name,String password);
}
