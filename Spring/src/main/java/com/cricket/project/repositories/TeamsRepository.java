package com.cricket.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cricket.project.Dto.TeamDto;
import com.cricket.project.entity.Teams;
@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

	
	@Query("select t from teams t where t.teamName=?1")
	Teams getByTeamName(String teamName);
	@Query("select t.id from teams t where t.teamName=?1")
	int getTeamId(String teamName);
	@Query("select t.budget from teams t where t.id=?1")
	double getBudget(int id);
	@Query("select t from teams t where t.user.userId=?1")
	Teams getTeamByUserId(int userId);
	@Query("select t from teams t where t.user.userName=?1")
	Teams getTeamByUserName(String userName);
	@Query("select t from teams t where t.user.userId is null")
	List<Teams> getUnAssignedTeams();
	
}
