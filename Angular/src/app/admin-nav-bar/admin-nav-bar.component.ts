import { Component } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-admin-nav-bar',
  templateUrl: './admin-nav-bar.component.html',
  styleUrls: ['./admin-nav-bar.component.css']
})
export class AdminNavBarComponent {
constructor(private service:LoginService){

}
  logout(){
    this.service.logout();
  }
}
