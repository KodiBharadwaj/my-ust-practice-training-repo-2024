import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Product } from '../model/Product';

@Component({
  selector: 'app-product-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-card.component.html',
  styleUrl: './product-card.component.css'
})
export class ProductCardComponent {
  @Input('product')
  product?:Product;
}
