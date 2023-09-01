import { HttpClient, HttpErrorResponse, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { team } from './create-team/team';
import { Observable,catchError,pipe,throwError } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class TeamsService {

  baseUrl="http://localhost:8080"
  constructor(private http:HttpClient) { }

  addTeam(team:team):Observable<Object>{
   return this.http.post(`${this.baseUrl}/team`,team,).pipe(catchError(this.handleError));
  }
  getTeams():Observable<team[]>{
    return this.http.get<team[]>(`${this.baseUrl}/allTeams`);
  }

  getTeam(id:number):Observable<team>{
    return this.http.get<team>(`${this.baseUrl}/teams/${id}`)
  }

  updateTeam(id:number,team:team):Observable<Object>
  {
    return this.http.put(`${this.baseUrl}/Team/${id}`,team).pipe(catchError(this.handleError));
  }

  deleteTeam(id:number):Observable<Object>
  {
    return this.http.delete(`${this.baseUrl}/Team/${id}`).pipe(catchError(this.handleError))
  }

  private handleError(error: HttpErrorResponse) {

    
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } 
    else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(error);
      
    }
    // Return an observable with a user-facing error message.
  
    return throwError(error);
  }
}
