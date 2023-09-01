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
    component:DashboardComponent
  },
  {
     path:'showteam',
     component:TeamsComponent
  },
  {
    path:"createteam",
    component:CreateTeamComponent
  }
  ,
  {
    path:'updateTeam/:id',
    component:EditTeamComponent
  }
  ,
  {
    path:'addPlayer/:id',
    component:AddPlayersComponent
  }
  ,
  {
    path:'viewPlayers/:id',
    component:ViewPlayersComponent
  },
  {
    path:'updatePlayer/:id',
    component:UpdatePlayerComponent
  },
  {
    path:'addPlayer',
    component:AddPlayerFromDashboardComponent
  },

  {
       path:'viewPlayers',
       component:UnsoldPlayersComponent
  },
  {
    path:'allPlayers',
    component:AllPlayersComponent
  },
  {
    path:'admin',
    component:AdminloginComponent
  },
  {
    path:'adminDashboard',
    component:AdmindashboardComponent
  },
  {
    path:'user/Teams',
    component:ViewTeamsUserComponent
  },
  {
    path:'admin/AllPlayers',
    component:AdminAllPlayersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
