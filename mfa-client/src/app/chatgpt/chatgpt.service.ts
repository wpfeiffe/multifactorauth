import { Injectable } from '@angular/core';
import { ResourceBaseService } from "../http/resource.base.service";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Completion } from "./completion";

@Injectable({
  providedIn: 'root'
})
export class ChatgptService  extends ResourceBaseService{

  constructor(httpClient: HttpClient) {
    super(httpClient, '', '/api/chatgpt');
  }

  getCompletion(prompt: string): Observable<Completion> {
    return this.httpClient.get<Completion>(this.endpoint + `?prompt=${prompt}`);
  }

}
