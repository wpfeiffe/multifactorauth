import { Routes } from '@angular/router';
import { UsersComponent } from "./users/users/users.component";
import { LoginComponent } from "./users/login/login.component";
import { MfacodeComponent } from "./users/mfacode/mfacode.component";

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'users',
    pathMatch: 'full'

  },
  {
    path: 'users',
    component: UsersComponent,

  },
  {
    path: 'login',
    component: LoginComponent,

  },
  {
    path: 'mfacode',
    component: MfacodeComponent,
  }
];
