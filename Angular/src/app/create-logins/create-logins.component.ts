import { Component } from '@angular/core';
import { user } from './User';
import { FormBuilder, FormGroup, NgModel, Validators } from '@angular/forms';
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
  form:FormGroup;
  submitted=false;
  constructor(private tservice:TeamsService,private service:LoginService,private formbuilder:FormBuilder)
  {
    

    this.tservice.getAvailableTeams().subscribe((data)=>{
    this.fordemo=data
    console.log(this.fordemo)
  }

  
  )
  }
  ngOnInit()
  {
    this.form=this.formbuilder.group({
      name:['',[Validators.required,Validators.minLength(5)]],
      password:['',[Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{5,12}$")]]
    })
    
  }
  get f()
  {
    return this.form.controls;
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
