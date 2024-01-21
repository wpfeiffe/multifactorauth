import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from "@angular/material/card";
import { MatTableModule } from "@angular/material/table";
import { ActivitiesService } from "./activities.service";
import { Activity } from "./activities";
import { Observable } from "rxjs";
import { RouterLink } from "@angular/router";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";

@Component({
  selector: 'app-activities',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatTableModule, RouterLink, MatProgressSpinnerModule],
  templateUrl: './activities.component.html',
  styleUrl: './activities.component.css',
  providers: [ActivitiesService]
})
export class ActivitiesComponent implements OnInit {

  constructor(private activityService: ActivitiesService) {
    this.activity$ = activityService.getActivities();
  }

  activity$: Observable<Activity>;
  activity: Activity = new Activity("","", "", []);
  displayedColumns: string[] = ['id', 'name'];
  dataAvailable = false;
  showError = false;
  errorText = '';


  ngOnInit(): void {
    this.activity$.subscribe({
        next: (result) => {
          this.activity = result;
          console.log(this.activity);
          this.dataAvailable = true;
          this.showError = false;
        },
        error: (error) => {
          this.showError = true;
          this.dataAvailable = false;
          this.errorText = error;
          console.log(`the error ${error}`);
        },
        complete: () => {
          console.log('Activity call complete');
        }
      });
  }

}
