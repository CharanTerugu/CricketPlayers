package com.cricket.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cricket.project.entity.Teams;
@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

	
	@Query("select t from teams t where t.teamName=?1")
	Teams getByTeamName(String teamName);
	@Query("select t.id from teams t where t.teamName=?1")
	int getTeamId(String teamName);
	@Query("select t.budget from teams t where t.id=?1")
	double getBudget(int id);
	
}
