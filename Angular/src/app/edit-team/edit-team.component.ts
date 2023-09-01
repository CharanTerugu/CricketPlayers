import { Component, OnInit } from '@angular/core';
import { team } from '../create-team/team';
import { TeamsService } from '../teams.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-team',
  templateUrl: './edit-team.component.html',
  styleUrls: ['./edit-team.component.css']
})
export class EditTeamComponent implements OnInit{
  

  team:team={} as team;
  id:number;
  msg:string;
constructor(private service:TeamsService,private activated:ActivatedRoute,private router:Router)
{
  this.activated.params.subscribe(paramsId => {
    this.id = paramsId['id'];
    console.log(this.id);
});

}
ngOnInit(){
   
  this.service.getTeam(this.id).subscribe(data=>{
    this.team=data;
  })
}

  onSubmit()
  {
       this.service.updateTeam(this.id,this.team).subscribe(()=>{
        alert("updated SuccessFully")
this.router.navigate(['/showteam'])
       },
       (error)=>{
        this.msg=error.error.text
        console.log(error);
        alert(this.msg)

       }
        )
  }
}
