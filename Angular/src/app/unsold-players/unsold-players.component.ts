import { Component } from '@angular/core';
import { player } from '../add-players/player';
import { PlayerService } from '../player.service';
import { team } from '../create-team/team';
import { TeamsService } from '../teams.service';


@Component({
  selector: 'app-unsold-players',
  templateUrl: './unsold-players.component.html',
  styleUrls: ['./unsold-players.component.css']
})
export class UnsoldPlayersComponent {


  player:player[]={} as player[];
  fordemo:team[]={} as team[];
  selected:number;
  Selectedplayer:player={} as player;
 msg:string;
 success:string
  constructor(private service:PlayerService,private tservice:TeamsService)
  {
    this.service.getUnsoldPlayers().subscribe((data)=>{
      this.player=data
      console.log(this.player)
    })

    this.tservice.getTeams().subscribe((data)=>{
    this.fordemo=data
    console.log(this.fordemo)
  }
  )
  }

  purchase(pl:player)
  {
    // alert(this.selected)
    // alert(pl.id+""+pl.name+"");
   this.service.assignPlayer(this.selected,pl.id).subscribe(()=>{
this.success="Player Assigned SuccessFully"
   },(error)=>{
    this.msg=error.error;
   })

//this.Selectedplayer=new playerClass(pl.id,pl.name,pl.category,pl.country,pl.age,pl.bidPrice);
// alert(this.Selectedplayer)



 }
  
}
