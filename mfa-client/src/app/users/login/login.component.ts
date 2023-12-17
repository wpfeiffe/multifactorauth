import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from "@angular/material/card";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatButtonModule } from "@angular/material/button";
import { MatInputModule } from "@angular/material/input";
import { AuthService } from "../auth.service";
import { LoginRequest, LoginResponse } from "./login-request";
import { FormsModule } from "@angular/forms";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Router } from "@angular/router";
import { HttpClientModule } from "@angular/common/http";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatFormFieldModule, MatButtonModule, MatInputModule, FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(public authService: AuthService, public snackBar: MatSnackBar, public router: Router) {
  }
  loginRequest = new LoginRequest('','');
  loadError = '';

  login() {
    console.log(this.loginRequest);
    var result = this.authService.loginWithBasicAuth(this.loginRequest);
    result.subscribe((loginResponse) => {
      console.log(loginResponse);
      if (loginResponse.loginSuccess) {
        this.snackBar.open("Login Successful", 'Close');
        this.router.navigate(['/', 'users']);

      } else if (loginResponse.mfaEnabled) {
        this.snackBar.open("MFA Enabled", 'Close');
        this.authService.setMfaToken(loginResponse.mfaToken);
        this.router.navigate(['/', 'mfacode']);

      }
    }, this.handleError);
  }

  handleError = (error: any) => {
    if (error.error) {
      this.loadError = error.error.message;
    } else {
      // Server-side errors
      this.loadError = `Error Code: ${error.status}\nMessage: ${error.message}`;

    }
    this.snackBar.open(this.loadError, 'Close');
  }

}
