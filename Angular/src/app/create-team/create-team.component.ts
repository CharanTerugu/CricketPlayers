import { Component, OnInit } from '@angular/core';
import { team } from './team';
import { TeamsService } from '../teams.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-team',
  templateUrl: './create-team.component.html',
  styleUrls: ['./create-team.component.css']
})
export class CreateTeamComponent implements OnInit {

  form:FormGroup;
  team:team={} as team;
  msg:String;
  submitted=false;
constructor(private service:TeamsService,private formbuilder:FormBuilder,private router:Router)
{

}
  ngOnInit() {
    this.form=this.formbuilder.group({
      teamName:['',[Validators.required]],
      budget:['',[Validators.required]]
    })
  }
  get f()
  {
    return this.form.controls;
  }
  onSubmit()
  {
    this.submitted=true;
    if(this.form.invalid)
    {
      return ;
    }
    this.service.addTeam(this.team).subscribe(data=>{
         alert("team Added Successfully")
         this.router.navigate(['/showteam'])
    },
    (error)=>{
this.msg=error.error.text
console.log(this.msg)
      console.log(error.error)
      alert(this.msg)
    }
    
    );
  
  }
}
