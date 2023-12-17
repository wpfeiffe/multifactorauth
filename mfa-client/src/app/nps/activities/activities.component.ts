import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from "@angular/material/card";
import { MatTableModule } from "@angular/material/table";
import { ActivitiesService } from "./activities.service";
import { Activity } from "./activities";
import { Observable } from "rxjs";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-activities',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatTableModule, RouterLink],
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


  ngOnInit(): void {
    this.activity$.subscribe()

    this.activity$.subscribe(result => {
      this.activity = result;
      console.log(this.activity);
    }, error => {
      console.log(`the error ${error}`);
    });
  }

}
