import { Component } from '@angular/core';
import { user } from './User';
import { NgModel } from '@angular/forms';
import { TeamsService } from '../teams.service';
import { TeamDto } from '../teams/TeamDto';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-create-logins',
  templateUrl: './create-logins.component.html',
  styleUrls: ['./create-logins.component.css']
})
export class CreateLoginsComponent {


  user:user={} as user
  fordemo:TeamDto[]={} as TeamDto[];
  selected:number;
  constructor(private tservice:TeamsService,private service:LoginService)
  {
    

    this.tservice.getAvailableTeams().subscribe((data)=>{
    this.fordemo=data
    console.log(this.fordemo)
  }

  
  )
  }
  onDropdownChange(event:any){
 
  for(let i=0;i<this.fordemo.length;i++){
    if(this.fordemo[i].teamName===event.target.value){
      this.selected= this.fordemo[i].id;
    }
  }
  console.log(this.selected)
  
  }

  onSubmit(){

    console.log(typeof this.selected)
    this.service.createUser(this.selected,this.user).subscribe((data)=>{
          console.log(data);
          alert("user created successfully")
    },(error)=>{console.log(error)})
  }
}
