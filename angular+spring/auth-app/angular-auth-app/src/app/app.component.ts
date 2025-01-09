import { Component } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { LoginPageComponent } from "./login-page/login-page.component";
import { UserPageComponent } from "./user-page/user-page.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginPageComponent, UserPageComponent,RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-auth-app';

  constructor(private router:Router){}

  logout(){
    sessionStorage.removeItem('ust.auth');
    this.router.navigate(['']);
  }
}
