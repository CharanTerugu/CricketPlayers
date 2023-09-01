import { HttpClient ,HttpErrorResponse,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { login } from './logincomponent/login';
import { Observable,catchError , throwError} from 'rxjs';
import { admin } from './adminlogin/admin';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

baseurl="http://localhost:8080"
  constructor(private httpclient:HttpClient) { }


  login(user:login):Observable<any>
  {
    return this.httpclient.post(`${this.baseurl}/login`,user).pipe(catchError(this.handleError));
  }
 
 admin(admin:admin):Observable<object>
 {
  return this.httpclient.post(`${this.baseurl}/adminLogin`,admin).pipe(catchError(this.handleError));
 }
   

  private handleError(error: HttpErrorResponse) {

    
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } 
    else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(error.error);
      
    }
    // Return an observable with a user-facing error message.
    console.log(error)
    return throwError(error);
  }
}
