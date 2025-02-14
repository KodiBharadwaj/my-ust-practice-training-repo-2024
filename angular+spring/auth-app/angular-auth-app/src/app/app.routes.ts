import { Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignupPageComponent } from './signup-page/signup-page.component';
import { UserPageComponent } from './user-page/user-page.component';

export const routes: Routes = [
    {path: 'login', component: LoginPageComponent},
    {path:'user', component: UserPageComponent},
    {path: '', component: LoginPageComponent},
    {path:'signup', component: SignupPageComponent}
];
