import { Component, OnInit } from '@angular/core';
import { player } from '../add-players/player';
import { ActivatedRoute } from '@angular/router';
import { PlayerService } from '../player.service';
import { TeamsService } from '../teams.service';
import { team } from '../create-team/team';

@Component({
  selector: 'app-view-players',
  templateUrl: './view-players.component.html',
  styleUrls: ['./view-players.component.css']
})
export class ViewPlayersComponent implements OnInit{

player:player[]={} as player[];

id:number;
constructor(private activated:ActivatedRoute,private service:PlayerService,private teamService:TeamsService){

  this.activated.params.subscribe(paramsId => {
    this.id = paramsId['id'];
    console.log(this.id);
});

this.service.getPlayersByTeamId(this.id).subscribe((data)=>{
  this.player=data;
  console.log(this.player)
},(error)=>alert(error));

}
  ngOnInit(){
   
    
  }

  delete(id1:number)
  {
    this.service.deletePlayer(id1).subscribe(()=>{
      alert("player Deleted")
    })
  }
}
