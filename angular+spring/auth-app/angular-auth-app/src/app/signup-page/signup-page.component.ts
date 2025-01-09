import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthApiService } from '../auth-api.service';
import { UserSignupCredentials } from '../model/UserSignupCredentials';

@Component({
  selector: 'app-signup-page',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './signup-page.component.html',
  styleUrl: './signup-page.component.css'
})
export class SignupPageComponent {
  
  constructor(private authApiService: AuthApiService, private router:Router) {}

  signupFunction(userSignupCredentials:UserSignupCredentials){
    console.log(userSignupCredentials);
    this.authApiService.registerUser(userSignupCredentials)
    .subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/login']);
      }
    )
  }
}
