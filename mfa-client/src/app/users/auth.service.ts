import { Injectable, signal } from '@angular/core';
import { ResourceBaseService } from "../http/resource.base.service";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { LoginRequest, LoginResponse } from "./login/login-request";
import { Observable } from "rxjs";
import { MfaRequest } from "./mfacode/mfa-request";
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService extends ResourceBaseService {

  constructor(httpClient: HttpClient, private router: Router) {
    super(httpClient, '', '/api/auth')
  }

  mfaToken = signal("");

  public setMfaToken(token: string) {
    this.mfaToken.set(token);
  }

  public getMfaToken() {
    return this.mfaToken();
  }

  public login(loginRequest: LoginRequest): Observable<LoginResponse> {
    return this.httpClient
      .post<LoginResponse>(`${this.url}${this.endpoint}/login`, loginRequest);
  }

  public loginWithBasicAuth(loginRequest: LoginRequest): Observable<LoginResponse> {
    const headers = new HttpHeaders({
         Authorization : 'Basic ' + btoa(loginRequest.username + ':' + loginRequest.password)
       });
    return this.httpClient
      .post<LoginResponse>(`${this.url}${this.endpoint}/login`, loginRequest, {headers: headers});

  }

  public logout() {
    this.httpClient.post('logout', {}).subscribe({
      complete: () => {
        this.router.navigateByUrl('/login');
      }
    });
  }

  public verifyMfacode(mfaRequest: MfaRequest): Observable<LoginResponse> {
    return this.httpClient
      .post<LoginResponse>(`${this.url}${this.endpoint}/verify`, mfaRequest);
  }
}
