import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersService } from "../users.service";
import { Observable } from "rxjs";
import { HttpClientModule } from "@angular/common/http";
import { MatTableModule } from "@angular/material/table";
import { MatCardModule } from "@angular/material/card";

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [CommonModule, HttpClientModule, MatTableModule, MatCardModule],
  providers: [UsersService],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent implements OnInit{

  users: Observable<any>;
  userList: any;
  displayedColumns: string[] = ['id', 'email', 'username', 'first', 'last'];

  constructor(usersService: UsersService) {
    this.users = usersService.getUsers();
  }
  ngOnInit(): void {
   this.users.subscribe(result => {
     this.userList = result;
     console.log(this.userList);
   }, error => {
     console.log(`the error ${error}`);
   });
  }
}
