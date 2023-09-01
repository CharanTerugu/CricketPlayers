package com.cricket.project.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cricket.project.Dto.TeamPlayerDto;
import com.cricket.project.Exception.NotEnoughAmount;
import com.cricket.project.Exception.PlayerAlreadyExsists;
import com.cricket.project.Exception.PlayerNotFound;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.entity.Cricketer;
import com.cricket.project.entity.Teams;

import jakarta.mail.MessagingException;
@Service
public interface CricketService {
	
	void addDetails(int id,Cricketer data) throws TeamNotFound, PlayerAlreadyExsists, NotEnoughAmount;
	List<TeamPlayerDto> displayAll();
	void update(int id,Cricketer crickter) throws NotEnoughAmount;
	void delete(int id);
	List<Cricketer> getPlayersByTeamName(String  teamName);
    String getTeamDetails(String name) throws TeamNotFound, PlayerNotFound;
    List<Cricketer> PlayersByTeamid(int id);
    Cricketer getPlayer(int id);
    List<Cricketer> getUnAssignedPlayers();
    void addPlayer(Cricketer player) throws PlayerAlreadyExsists;
    void addPlayerToTeam(int tid,int pid) throws TeamNotFound, MessagingException;
  void deletePlayer(int id);
}
