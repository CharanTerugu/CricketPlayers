import { Component } from '@angular/core';
import { team } from '../create-team/team';
import { TeamsService } from '../teams.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-teams-user',
  templateUrl: './view-teams-user.component.html',
  styleUrls: ['./view-teams-user.component.css']
})
export class ViewTeamsUserComponent {

  
  demo:team[]={} as team[];
  msg:String;
  constructor(private service:TeamsService,private router:Router)
  {

  }
  ngOnInit()
  {
 this.service.getTeams().subscribe((data)=>{
  this.demo=data;
  console.log(this.demo);
 });
  }
}
