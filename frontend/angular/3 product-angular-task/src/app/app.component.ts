import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AddProductComponent,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'product-angular-task';
}
