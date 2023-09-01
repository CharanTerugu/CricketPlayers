import { Component } from '@angular/core';
import { playerTeam } from '../all-players/playerteam';
import { team } from '../create-team/team';
import { PlayerService } from '../player.service';
import { TeamsService } from '../teams.service';

@Component({
  selector: 'app-admin-all-players',
  templateUrl: './admin-all-players.component.html',
  styleUrls: ['./admin-all-players.component.css']
})
export class AdminAllPlayersComponent {

  player:playerTeam[]={} as playerTeam[];
  team:team[];
  msg:String;
id:number;
constructor(private service:PlayerService,private teamService:TeamsService){


this.service.getAllPlayers().subscribe((data)=>{
  this.player=data;
  console.log(this.player)
},(error)=>alert(error));

  
}
  
}
