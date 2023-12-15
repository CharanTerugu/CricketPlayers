import { Injectable } from '@angular/core';


import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
 
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { LoginService } from './login.service';
import { jwtDecode } from 'jwt-decode';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private logservice:LoginService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  
    const token = localStorage.getItem('token');

 
    // if (token) {

    //   const clonedReq = req.clone({
 
    //     headers: req.headers.set('Authorization', 'Bearer ' + token)
 
    //   });
 
    //   return next.handle(clonedReq);
 
    // } else {
 
    //   return next.handle(req);
 
    // }

    // return next.handle(req).pipe(
    //   catchError((error:HttpErrorResponse)=>{
    //     if(error.status==401 && error.error.message==='Token expired'){
    //     this.logservice.logout();
    //     }
    //     return throwError(error);

    //   })
    // );

    if(token){
      const isTokenExpired=this.isTokenExpired(token);
      if(isTokenExpired){
        this.logservice.logout();
        return throwError('JWT token has Expired');
      }
      else{
        console.log("not expired")
        const clonedReq = req.clone({
 
              headers: req.headers.set('Authorization', 'Bearer ' + token)
       
            });
       
            return next.handle(clonedReq);
       
          } }
          else {
       
            return next.handle(req);
       
          }
      }

 isTokenExpired(token: string):boolean{
  try{
    const decodedToken:any= jwtDecode(token);
    const expirationTime=decodedToken.exp*1000;
    console.log(expirationTime)
    return expirationTime<Date.now();
  }
  catch(error){
    return true;
  }
}
    }
 
  
