import { Component, OnInit } from '@angular/core';
import { player } from '../add-players/player';
import { PlayerService } from '../player.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-player',
  templateUrl: './update-player.component.html',
  styleUrls: ['./update-player.component.css']
})
export class UpdatePlayerComponent implements OnInit {


play:player={} as player;
msg:string;
id:number;
constructor(private service:PlayerService,private activated:ActivatedRoute,private router:Router){

  this.activated.params.subscribe(paramsId => {
    this.id = paramsId['id'];
    console.log(this.id);
  }
  )
}
ngOnInit(){
this.service.getPlayer(this.id).subscribe((data)=>{
  this.play=data;
  console.log(this.play)
})

}

  onSubmit(){
        this.service.update(this.id,this.play).subscribe(()=>{
        console.log(this.play)
        this.router.navigate(['/showteam'])},
        (error)=>{
          this.msg =error.error
        }
        );
  }
}
