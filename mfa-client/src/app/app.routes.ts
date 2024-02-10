import { Routes } from '@angular/router';
import { UsersComponent } from "./users/users/users.component";
import { LoginComponent } from "./users/login/login.component";
import { MfacodeComponent } from "./users/mfacode/mfacode.component";
import { ActivitiesComponent } from "./nps/activities/activities.component";
import { ActivitiesParksComponent } from "./nps/activities-parks/activities-parks.component";
import { ChatgptComponent } from "./chatgpt/chatgpt.component";

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'

  },
  {
    path: 'users',
    component: UsersComponent,

  },
  {
    path: 'chatgpt',
    component: ChatgptComponent,
  },
  {
    path: 'login',
    component: LoginComponent,

  },
  {
    path: 'mfacode',
    component: MfacodeComponent,
  },
  {
    path: 'activities',
    component: ActivitiesComponent
  },
  {
    path: 'act-parks/:id',
    component: ActivitiesParksComponent
  }
];
