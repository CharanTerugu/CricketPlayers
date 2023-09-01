import { Component } from '@angular/core';
import { player } from '../add-players/player';
import { PlayerService } from '../player.service';
import { TeamsService } from '../teams.service';
import { team } from '../create-team/team';
import { playerTeam } from './playerteam';

@Component({
  selector: 'app-all-players',
  templateUrl: './all-players.component.html',
  styleUrls: ['./all-players.component.css']
})
export class AllPlayersComponent {

  player:playerTeam[]={} as playerTeam[];
  team:team[];
  msg:String;
id:number;
constructor(private service:PlayerService,private teamService:TeamsService){


this.service.getAllPlayers().subscribe((data)=>{
  this.player=data;
  console.log(this.player)
},(error)=>alert(error));
// this.teamService.getTeams().subscribe((data)=>{
  
//   console.log(data);
//   this.team=data;
//   console.log("players"+this.team[0].players[0])
//   })

  
}
  ngOnInit(){
   
    
  }
Delete(id:number)
{
 this.service.delete(id).subscribe(()=>{
  this.msg="Player Released SuccessFully"

 },
 (error)=>{
  this.msg="Please try After Some time"
 }
 )
}
  
}
