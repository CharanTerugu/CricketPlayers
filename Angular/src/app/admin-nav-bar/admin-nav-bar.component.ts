import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-nav-bar',
  templateUrl: './admin-nav-bar.component.html',
  styleUrls: ['./admin-nav-bar.component.css']
})
export class AdminNavBarComponent {

  logout(){
    localStorage.clear();
    console.log("token"+localStorage.getItem('token'))
  }
}
