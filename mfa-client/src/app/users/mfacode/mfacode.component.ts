import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { AuthService } from "../auth.service";
import { MfaRequest } from "./mfa-request";
import { HttpClientModule } from "@angular/common/http";
import { Router } from "@angular/router";

@Component({
  selector: 'app-mfacode',
  standalone: true,
  imports: [CommonModule, FormsModule, MatButtonModule, MatCardModule, MatFormFieldModule, MatInputModule, HttpClientModule],
  templateUrl: './mfacode.component.html',
  styleUrl: './mfacode.component.css'
})
export class MfacodeComponent implements OnInit{

  constructor(public authService: AuthService, public router: Router) {
  }

  mfaCode = "";

  validateMfaCode() {
    let mfaToken = this.authService.getMfaToken();
    let mfaRequest = new MfaRequest(this.mfaCode, mfaToken);
    console.log(mfaRequest);
    this.authService.verifyMfacode(mfaRequest).subscribe({
        next: (result) => {
          this.router.navigate(['/', 'users']);
        }, error: (error) => {
          console.log(error);
        }, complete: () => {
        console.log("mfa complete");
        }
      }
    );
  }

  ngOnInit(): void {
  }
}
