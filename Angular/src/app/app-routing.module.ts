import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateTeamComponent } from './create-team/create-team.component';
import { LogincomponentComponent } from './logincomponent/logincomponent.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TeamsComponent } from './teams/teams.component';
import { EditTeamComponent } from './edit-team/edit-team.component';
import { AddPlayersComponent } from './add-players/add-players.component';
import { ViewPlayersComponent } from './view-players/view-players.component';
import { UpdatePlayerComponent } from './update-player/update-player.component';
import { AddPlayerFromDashboardComponent } from './add-player-from-dashboard/add-player-from-dashboard.component';
import { UnsoldPlayersComponent } from './unsold-players/unsold-players.component';
import { AllPlayersComponent } from './all-players/all-players.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { ViewTeamsUserComponent } from './view-teams-user/view-teams-user.component';
import { AdminAllPlayersComponent } from './admin-all-players/admin-all-players.component';
import { PlayersComponent } from './players/players.component';
import { CreateLoginsComponent } from './create-logins/create-logins.component';
import { RouteGaurdServiceService } from './route-gaurd-service.service';

const routes: Routes = [
  {
  path:'',
  component:LogincomponentComponent
  },
  {
    path:'login',
    component:LogincomponentComponent
  },
  {
    path:'dashboard',
    component:DashboardComponent,
    canActivate:[RouteGaurdServiceService]
  },
  {
     path:'showteam',
     component:TeamsComponent,
     canActivate:[RouteGaurdServiceService]
  },
  {
    path:"createteam",
    component:CreateTeamComponent,
    canActivate:[RouteGaurdServiceService]
  }
  ,
  {
    path:'updateTeam/:id',
    component:EditTeamComponent,
    canActivate:[RouteGaurdServiceService]
  }
  ,
  {
    path:'addPlayer/:id',
    component:AddPlayersComponent,
    canActivate:[RouteGaurdServiceService]
  }
  ,
  {
    path:'viewPlayers/:id',
    component:ViewPlayersComponent,
    canActivate:[RouteGaurdServiceService]
  },
  {
    path:'updatePlayer/:id',
    component:UpdatePlayerComponent,
    canActivate:[RouteGaurdServiceService]
  },
  {
    path:'addPlayer',
    component:AddPlayerFromDashboardComponent,
    canActivate:[RouteGaurdServiceService]
  },

  {
       path:'viewPlayers',
       component:UnsoldPlayersComponent,
       canActivate:[RouteGaurdServiceService]
  },
  {
    path:'allPlayers',
    component:AllPlayersComponent,
    canActivate:[RouteGaurdServiceService]
  },
  {
    path:'admin',
    component:AdminloginComponent,
    
  },
  {
    path:'adminDashboard',
    component:AdmindashboardComponent,
    canActivate:[RouteGaurdServiceService]
  },
  {
    path:'user/Teams',
    component:ViewTeamsUserComponent,
    canActivate:[RouteGaurdServiceService]
  },
  {
    path:'admin/AllPlayers',
    component:AdminAllPlayersComponent,
    canActivate:[RouteGaurdServiceService]
  },
  {
    path:'user/players',
    component:PlayersComponent,
    canActivate:[RouteGaurdServiceService]
  },
  {
    path:'user/register',
    component:CreateLoginsComponent,
    canActivate:[RouteGaurdServiceService]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
