import { Injectable } from '@angular/core';
import { ResourceBaseService } from "../../http/resource.base.service";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Activity } from "./activities";

@Injectable({
  providedIn: 'root'
})
export class ActivitiesService  extends ResourceBaseService{

  constructor(httpClient: HttpClient) {
    super(httpClient, '', '/api/nps/activities');
  }

  getActivities(): Observable<Activity> {
    return this.httpClient.get<Activity>(this.endpoint);
  }

  getActivityByParks(id: string): Observable<any> {
    return this.httpClient.get<any>(`${this.endpoint}/${id}/parks`);
  }

}
