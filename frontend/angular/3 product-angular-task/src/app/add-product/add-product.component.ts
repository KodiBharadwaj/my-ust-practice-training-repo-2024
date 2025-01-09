import { Component } from '@angular/core';
import { Product } from '../model/Product';
import { ViewProductListComponent } from '../view-product-list/view-product-list.component';

@Component({
  selector: 'app-add-product',
  standalone: true,
  imports: [ViewProductListComponent],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css'
})
export class AddProductComponent {
  productList:Array<Product> = [{
    id: 1,
    name:"Laptop",
    price:50000
  },
  {
    id: 2,
    name: "Phone",
    price : 10000
  }];

  addProduct(id:string, name:string, price:string){
    if (!id.trim() || !name.trim() || !price.trim()) {
      confirm("Fields should not be empty!");
      return; // If we don't put return , it also executes next if condition
    }

    if(isNaN(parseInt(price))){
      confirm("Price should be in numbers")
      return;
    }

    for(let product of this.productList){
      if(parseInt(id) == product.id){
        confirm("Id already exists! Please use another one");
        return;
      }
    }
    
    let product = new Product(parseInt(id), name, parseInt(price));
    this.productList.push(product);
    //this.productList.forEach(product => console.log(product));

    let id1 = document.getElementById('id') as HTMLInputElement;
    let name1 = document.getElementById('name') as HTMLInputElement;
    let price1 = document.getElementById('price') as HTMLInputElement;

    id1.value = '';
    name1.value = '';
    price1.value = '';
  }

  // deleteProduct(id:number){
  //   confirm('Are you sure you want to delete this task?');
  //   const index = this.productList.findIndex(product => product.id == id);
  //   if(index !== -1){
  //     this.productList.splice(index, 1);
  //   }
  // }

  totalRevenue(){
    let value = 0;
    
    for(let product of this.productList){
      value += product.price;
    }

    return value;
  }
}
