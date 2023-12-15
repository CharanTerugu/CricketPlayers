package com.cricket.project.Dto;

import java.util.ArrayList;
import java.util.List;

import com.cricket.project.entity.Teams;

public class TeamDtoConverter {
	
	
	public TeamDto convertToTeamDto(Teams team)
	{
		return new TeamDto(team.getId(), team.getTeamName(), team.getBudget());
	}
	
	public List<TeamDto> convertToTeamDto(List<Teams> teams){
		
		List<TeamDto> list=new ArrayList<TeamDto>();
		
		for(int i=0;i<teams.size();i++) {
			list.add(new TeamDto(teams.get(i).getId(), teams.get(i).getTeamName(), teams.get(i).getBudget()));
		}
		return list;
	}

}
