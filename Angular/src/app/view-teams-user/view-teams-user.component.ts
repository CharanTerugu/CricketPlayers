import { Component } from '@angular/core';
import { team } from '../create-team/team';
import { TeamsService } from '../teams.service';
import { Router } from '@angular/router';
import { TeamDto } from '../teams/TeamDto';

@Component({
  selector: 'app-view-teams-user',
  templateUrl: './view-teams-user.component.html',
  styleUrls: ['./view-teams-user.component.css']
})
export class ViewTeamsUserComponent {

  

  demo:TeamDto;
  msg:String;
  constructor(private service:TeamsService,private router:Router)
  {

  }
  ngOnInit()
  {
      this.service.getMyTeam().subscribe((data)=>{
        this.demo=data;
        console.log(this.demo)
      })
      
  }
}
