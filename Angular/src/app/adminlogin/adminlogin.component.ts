import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { login } from '../logincomponent/login';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { admin } from './admin';

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
        console.log(res)
      // alert("login Success")
      this.router.navigate(['/adminDashboard']);
    },(error)=>{
      console.log(error.error)
      this.msg=error.error;
      alert(this.msg)}

    );
    
    

   
    
  
   
   

  }
}
