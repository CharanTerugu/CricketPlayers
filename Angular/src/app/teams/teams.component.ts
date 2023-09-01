import { Component, OnInit } from '@angular/core';
import { TeamsService } from '../teams.service';
import { team } from '../create-team/team';
import { Router } from '@angular/router';


@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

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

  delete(id:number)
  {
    this.service.deleteTeam(id).subscribe(()=>
    {
      alert("Deleted SuccessFully")
      this.router.navigate(['/showteam'])
    },(error)=>{
      this.msg=error.error.text;
      alert(this.msg);
    }
    );
  }
}
