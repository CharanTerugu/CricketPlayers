package com.cricket.project.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cricket.project.Dto.TeamDto;
import com.cricket.project.Dto.TeamPlayerDto;
import com.cricket.project.Exception.NotEnoughAmount;
import com.cricket.project.Exception.PlayerAlreadyExsists;
import com.cricket.project.Exception.PlayerNotFound;
import com.cricket.project.Exception.TeamNotFound;
import com.cricket.project.entity.Cricketer;
import com.cricket.project.entity.Teams;
import com.cricket.project.entity.User;
import com.cricket.project.mail.MailSenderService;
import com.cricket.project.repositories.CricketerRepository;
import com.cricket.project.service.CricketService;
import com.cricket.project.service.TeamsService;
import com.cricket.project.service.UserService;

import jakarta.mail.MessagingException;
@Component
public class CricketServiceImpl implements CricketService {
	
	@Autowired
	CricketerRepository repo;
@Autowired
TeamsService ts;
@Autowired
MailSenderService service;
@Autowired 
UserService userService;
	@Override
	public void addDetails(int id,Cricketer data) throws TeamNotFound, PlayerAlreadyExsists, NotEnoughAmount {
		// TODO Auto-generated method stub
		
		Cricketer c=repo.getByName(data.getName());
		 Double d=repo.getTotalSpends(id);
		if(d==null)
		{
		d=0.0;
		}
		
		if(c!=null)
		{
			throw new PlayerAlreadyExsists("Player Already Added to another team");
		}
		
		else if(d+data.getBidPrice()<=ts.getBudget(id))
		{
			
		Teams team =ts.findById(id);
		data.setTeams(team);
		
		repo.save(data);
		}
		else
		{
			throw new NotEnoughAmount("cant buy a Player,insufficent amount");
		}
	}

	@Override
	public List<TeamPlayerDto> displayAll() {
		// TODO Auto-generated method stub
		
		List<Cricketer> players=repo.findAll();
		List<TeamPlayerDto> tpd=new ArrayList<>();
		for(int i=0;i<players.size();i++)
		{
			TeamPlayerDto t=new TeamPlayerDto();
			if(players.get(i).getTeams()!=null)
			{
			t.setTeamName(players.get(i).getTeams().getTeamName());
			t.setTid(players.get(i).getTeams().getId());
			t.setBudget(players.get(i).getTeams().getBudget());
			}
			
			t.setAge(players.get(i).getAge());
			t.setBidPrice(players.get(i).getBidPrice());
			t.setCategory(players.get(i).getCategory());
			t.setCountry(players.get(i).getCountry());
			t.setName(players.get(i).getName());
			t.setPid(players.get(i).getId());
			tpd.add(t);
		}
		
		return tpd;
	}

	@Override
	public void update(int id, Cricketer crickter) throws NotEnoughAmount {
		// TODO Auto-generated method stub
		Cricketer cr=repo.getById(id);
		double d=crickter.getBidPrice()-cr.getBidPrice();
		cr.setAge(crickter.getAge());
		cr.setCategory(crickter.getCategory());
		cr.setCountry(crickter.getCountry());
		cr.setName(crickter.getName());
		
		if(repo.getTotalSpends(cr.getTeams().getId())+d<=ts.getBudget(cr.getTeams().getId()))
		{
			cr.setBidPrice(crickter.getBidPrice());
		}
		else
		{
			throw new NotEnoughAmount("not enough money in purse");
		}
		repo.save(cr);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Cricketer c=repo.getById(id);
		c.setTeams(null);
	
		repo.save(c);
	}

	@Override
	public List<Cricketer> getPlayersByTeamName(String teamName) {
		// TODO Auto-generated method stub
		int id=ts.getId(teamName);
		return repo.getPlayers(id);
	}

	@Override
	public String getTeamDetails(String name) throws TeamNotFound, PlayerNotFound {
		// TODO Auto-generated method stub
		if(repo.getByName(name)==null)
		{
			throw new PlayerNotFound("player Not Found");
		}
		Cricketer player=repo.getByName(name);
		Teams team=ts.findById(player.getTeams().getId());
		return team.getTeamName();
	}

	@Override
	public List<Cricketer> PlayersByTeamid(int id) {
		// TODO Auto-generated method stub
		return repo.getPlayers(id);
	}

	@Override
	public Cricketer getPlayer(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<Cricketer> getUnAssignedPlayers() {
		// TODO Auto-generated method stub
		return repo.getUnAssigned();
	}

	@Override
	public void addPlayer(Cricketer player) throws PlayerAlreadyExsists {
		// TODO Auto-generated method stub
		if(repo.getByName(player.getName())!=null)
		{
			throw new PlayerAlreadyExsists("player already Exsist");
		}
				
		repo.save(player);
	}

	@Override
	public void addPlayerToTeam(int tid, int pid) throws TeamNotFound,MessagingException, NotEnoughAmount {
		// TODO Auto-generated method stub
		Cricketer player=repo.getById(pid);
		Teams team=ts.findById(tid);
		double totalAmountSpent=repo.getTotalSpends(tid);
		
		if(totalAmountSpent+player.getBidPrice()<=team.getBudget())
		{
			
		player.setTeams(team);
		repo.save(player);
		}
		else
		{
			throw new NotEnoughAmount("cant buy a Player,insufficent amount");
		}
		
//		player.setTeams(team);
//		
//		String to=player.getMailId();
//		
//		repo.save(player);
	//	service.sendsimpleEmail(to, player.getName()+"your sold to "+player.getTeams().getTeamName(), "Bid Successfull");
		
		
	}

	@Override
	public void deletePlayer(int id) {
		// TODO Auto-generated method stub
		Cricketer c=repo.getById(id);
		c.setTeams(null);
		repo.deleteById(c.getId());
	}

	@Override
	public List<Cricketer> getMyPlayers(String userName) throws TeamNotFound {
		// TODO Auto-generated method stub
		TeamDto team=ts.getMyTeam(userName);
	return repo.getPlayers(team.getId());
		
	}

	

	
	

}
