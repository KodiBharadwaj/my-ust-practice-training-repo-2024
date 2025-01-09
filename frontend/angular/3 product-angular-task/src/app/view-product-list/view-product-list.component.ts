import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Product } from '../model/Product';
import { ProductCardComponent } from '../product-card/product-card.component';

@Component({
  selector: 'app-view-product-list',
  standalone: true,
  imports: [ProductCardComponent, CommonModule],
  templateUrl: './view-product-list.component.html',
  styleUrl: './view-product-list.component.css'
})
export class ViewProductListComponent {
  @Input('productList')
  productList:Array<Product> = [];
}
