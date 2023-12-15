import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {JwtModule} from '@auth0/angular-jwt'
import { LogincomponentComponent } from './logincomponent/logincomponent.component';
import { CreateTeamComponent } from './create-team/create-team.component';
import { RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TeamsComponent } from './teams/teams.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http'
import { LoginService } from './login.service';
import { TeamsService } from './teams.service';
import { EditTeamComponent } from './edit-team/edit-team.component';
import { AddPlayersComponent } from './add-players/add-players.component';
import { PlayerService } from './player.service';
import { ViewPlayersComponent } from './view-players/view-players.component';
import { UpdatePlayerComponent } from './update-player/update-player.component';
import { AddPlayerFromDashboardComponent } from './add-player-from-dashboard/add-player-from-dashboard.component';
import { UnsoldPlayersComponent } from './unsold-players/unsold-players.component';
import { AllPlayersComponent } from './all-players/all-players.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { ViewTeamsUserComponent } from './view-teams-user/view-teams-user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { AdminNavBarComponent } from './admin-nav-bar/admin-nav-bar.component';
import { AdminAllPlayersComponent } from './admin-all-players/admin-all-players.component';
import { AuthInterceptor } from './auth.interceptor';
import { PlayersComponent } from './players/players.component';
import { CreateLoginsComponent } from './create-logins/create-logins.component';
@NgModule({
  declarations: [
    AppComponent,
    LogincomponentComponent,
    CreateTeamComponent,
    DashboardComponent,
    TeamsComponent,
    EditTeamComponent,
    AddPlayersComponent,
    ViewPlayersComponent,
    UpdatePlayerComponent,
    AddPlayerFromDashboardComponent,
    UnsoldPlayersComponent,
    AllPlayersComponent,
    AdminloginComponent,
    AdmindashboardComponent,
    ViewTeamsUserComponent,
    NavbarComponent,
    AdminNavBarComponent,
    AdminAllPlayersComponent,
    PlayersComponent,
    CreateLoginsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule ,
    RouterModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    JwtModule.forRoot({
      config:{
        tokenGetter:()=>{
          return localStorage.getItem('token')
        },
      },
    })
    
  ],
  providers: [LoginService,TeamsService,PlayerService, {provide:HTTP_INTERCEPTORS, useClass:AuthInterceptor,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
