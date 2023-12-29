import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { login } from './logincomponent/login';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGaurdServiceService implements CanActivate {

  constructor(private authService:LoginService,private router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean{
     if(this.authService.logged){
      return true;
     }
this.router.navigate(['/login']);
     return false;
  }
}
