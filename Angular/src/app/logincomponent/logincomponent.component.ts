import { Component, OnInit } from '@angular/core';
import {FormGroup, Validators,FormBuilder} from '@angular/forms'
import { Router } from '@angular/router';
import { login } from './login';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-logincomponent',
  templateUrl: './logincomponent.component.html',
  styleUrls: ['./logincomponent.component.css']
})
export class LogincomponentComponent implements OnInit{

  form:FormGroup;
  msg:String;
  user:login;
  submitted=false
  
  constructor(private formbuilder:FormBuilder,private router:Router,private service:LoginService)
  {

  }
  ngOnInit()
  {
    this.form=this.formbuilder.group({
      
       userName:['',[Validators.required,Validators.minLength(4)]],
      Password:['',[Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{5,12}$")]]
    })
    
  }
  get f()
  {
    return this.form.controls;
  }
  onSubmit()
  {
  
    this.submitted=true;
    const name=this.form.controls['userName'].value;
    const Password=this.form.controls['Password'].value;
  console.log(name+""+Password)
  this.user=new login(name,Password);
  
   
    if(this.form.invalid)
    {
      return ;
    }

    this.service.login(this.user).subscribe(
      (res:any)=>{
       localStorage.setItem('token',res)
      console.log(localStorage.getItem('token'))
      console.log(res);
      this.router.navigate(['/dashboard']);
    },(error)=>{
      console.log(error.error)
      this.msg=error.error;
      alert(this.msg)}

    );
    
  
   
   

  }
}
