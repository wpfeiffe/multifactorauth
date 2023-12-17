import { Injectable } from '@angular/core';
import { ResourceBaseService } from "../http/resource.base.service";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UsersService extends ResourceBaseService{

  constructor(httpClient: HttpClient) {
    super(httpClient, '', '/api/users');
  }

  getUsers(): Observable<any>  {
    return this.httpClient.get(`${this.url}${this.endpoint}`);
  }

  getUsersByUsername(username: string): Observable<any>  {
    return this.httpClient.get(`${this.url}${this.endpoint}?username=${username}`);
  }

}
