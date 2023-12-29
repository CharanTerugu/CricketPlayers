import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { login } from '../logincomponent/login';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { admin } from './admin';
import jwtDecode from 'jwt-decode';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {


  form:FormGroup;
  msg:String;
  admin:login;
  submitted=false
  
  constructor(private formbuilder:FormBuilder,private router:Router,private service:LoginService)
  {

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
  onSubmit()
  {
  
    this.submitted=true;
    const name=this.form.controls['name'].value;
    const password=this.form.controls['password'].value;
  console.log(name+""+password)
  this.admin=new login(name,password);
  
   
    if(this.form.invalid)
    {
      return ;
    }
    this.service.admin(this.admin).subscribe(
      (res:any)=>{
        localStorage.setItem('token',res)
        this.service.logged=true;
        console.log(res)
      // alert("login Success")
      const result= jwtDecode(localStorage.getItem('token'))
   const userRoles=(result as any).roles;
   console.log(userRoles);
   if(userRoles[0].authority=="ROLE_ADMIN"){
    this.router.navigate(['/adminDashboard']);
  }
  else{
    alert("dont have authority")
    this.router.navigate(['/'])
  }
     
    },(error)=>{
      console.log(error.error)
      this.msg=error.error;
      alert(this.msg)}

    );
    
    

   
    
  
   
   

  }
}
