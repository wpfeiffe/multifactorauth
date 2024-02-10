import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { ChatgptService } from "./chatgpt.service";

@Component({
  selector: 'app-chatgpt',
  standalone: true,
    imports: [
        FormsModule,
        MatButtonModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule
    ],
  templateUrl: './chatgpt.component.html',
  styleUrl: './chatgpt.component.css'
})
export class ChatgptComponent {

  constructor(private chatgptService: ChatgptService) {
  }

  theprompt = '';
  completion = '';

  sendPrompt() {
    this.chatgptService.getCompletion(this.theprompt).subscribe({
            next: (result) => {
              this.completion = result.completion;
            },
            error: (error) => {
            },
            complete: () => {
            }
          });
    console.log("prompt");
  }
}
