import { Component } from '@angular/core';
import { player } from './player';
import { PlayerService } from '../player.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-players',
  templateUrl: './add-players.component.html',
  styleUrls: ['./add-players.component.css']
})
export class AddPlayersComponent {

  player:player={} as player;
  id:number;
  msg:String;
constructor(private service:PlayerService,private activated:ActivatedRoute)
{
  this.activated.params.subscribe(paramsId => {
    this.id = paramsId['id'];
    console.log(this.id);
});
}
  onSubmit()
  {
    this.service.addPlayer(this.id,this.player).subscribe((date)=>{
      alert("Player Added Successfully")
    },(error)=>{
      
      console.log(error.error)
      this.msg=(error.error.text)?error.error.text:error.error;
      
      alert(this.msg);
    })
  }
}
