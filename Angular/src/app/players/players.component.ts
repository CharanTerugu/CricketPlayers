import { Component } from '@angular/core';
import { PlayerService } from '../player.service';
import { TeamsService } from '../teams.service';
import { playerTeam } from '../all-players/playerteam';
import { team } from '../create-team/team';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent {
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
