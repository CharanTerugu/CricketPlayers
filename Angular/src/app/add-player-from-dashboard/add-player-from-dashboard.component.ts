import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../player.service';
import { player } from '../add-players/player';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-player-from-dashboard',
  templateUrl: './add-player-from-dashboard.component.html',
  styleUrls: ['./add-player-from-dashboard.component.css']
})
export class AddPlayerFromDashboardComponent implements OnInit {

player:player={} as player;

msg:string;
constructor(private service:PlayerService){

}
ngOnInit() {

  
}
  onSubmit()
  {
    this.service.addcrickter(this.player).subscribe((date)=>{
      alert("Player Added Successfully")
    },(error)=>{
      
      console.log(error.error)
      this.msg=(error.error.text)?error.error.text:error.error;
    })
  }
}
