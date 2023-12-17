import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from "@angular/router";
import { ActivitiesService } from "../activities/activities.service";
import { MatCardModule } from "@angular/material/card";
import { MatTableModule } from "@angular/material/table";
import { Observable } from "rxjs";
import { Activity } from "../activities/activities";
import { MatIconModule } from "@angular/material/icon";

@Component({
  selector: 'app-activities-parks',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatTableModule, RouterLink, MatIconModule],
  templateUrl: './activities-parks.component.html',
  styleUrl: './activities-parks.component.css'
})
export class ActivitiesParksComponent implements OnInit {

  activityId = '';
  activityParks: any = null;
  displayedColumns: string[] = ['designation', 'fullName', 'name', 'parkCode', 'states', 'url'];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private activitiesService: ActivitiesService) {
    this.route.params.subscribe(params => {
      this.activityId = params['id'];
    });
  }

  ngOnInit(): void {
    if (this.activityId) {
      this.activitiesService.getActivityByParks(this.activityId).subscribe({
        next: (result) => {
          this.activityParks = result;
          console.log(result);

        },
        error: (error) => {
          console.error(error);
        },
        complete: () => {
          console.log('getActivityByParks is complete');
        }
      });
    }
  }
}
