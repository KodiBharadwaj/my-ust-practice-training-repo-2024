package com.shoppingcart.app.repository;

import com.shoppingcart.app.exception.InvalidQuantityException;
import com.shoppingcart.app.exception.ProductNotFoundException;
import com.shoppingcart.app.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {

    List<Product> list = new ArrayList<>();

    public void addProduct(Product product, int quantity) throws InvalidQuantityException {
        if(quantity <= 0){
            throw new InvalidQuantityException("Invalid quantity number");
        }
        list.add(product);
    }

    public void removeProduct(Product product) throws ProductNotFoundException {
        if(!list.contains(product)){
            throw new ProductNotFoundException("Product not found");
        }
        list.remove(product);
    }

    public void updateProductQuantity(Product product, int quantity) throws ProductNotFoundException, InvalidQuantityException {

        if(quantity <= 0){
            throw new InvalidQuantityException("Invalid quantity number");
        }
        if(!list.contains(product)){
            throw new ProductNotFoundException("Product not found");
        }
//        for(var it: list){
//            if(it == product){
//                it.setQuantity(quantity);
//            }
//        }
        list.stream().filter(i->i==product).forEach(i->i.setQuantity(quantity));
    }

    public double calculateTotalPrice() {
//        double totalPrice = 0;
//        for(var it: list){
//            totalPrice += (it.getPrice() * it.getQuantity());
//        }
//
//        return totalPrice;
        return list.stream().mapToDouble(i->i.getPrice()*i.getQuantity()).sum();

    }

    public List<Product> filterProductsByCategory(String category) {
        return list.stream().filter(i->i.getCategory().equals(category)).toList();
    }

    public List<Product> filterProductsByPriceRange(double minPrice, double maxPrice) {

        return list.stream().filter(i->i.getPrice() > minPrice && i.getPrice() < maxPrice).toList();
    }

    // Output Format:
    //Product1 2 10.0
    //Product2 3 20.0
    public void displayCartItems() {
        for(var it: list){
            System.out.print(it.getName() + " " + it.getQuantity() + " " + it.getPrice() + "\n");
        }
    }

    public Optional<Product> findMostExpensiveProduct() {
        return list.stream().reduce((a,b)->{
            if(b.getPrice() > a.getPrice()){
                a = b;
            }
            return a;
        });
    }

    public List<Product> sortProductsByName() {
        return list.stream().sorted((a,b)->a.getName().compareTo(b.getName())).toList();
    }

    public double calculateDiscountedTotal(double discountPercentage) {
//        double totalPrice = 0;
//        for(var it: list){
//            totalPrice += (it.getPrice() * it.getQuantity());
//        }
//        totalPrice = totalPrice - (discountPercentage*totalPrice)/(double)100;
//        return totalPrice;

        double totalPrice = list.stream().mapToDouble(i->i.getPrice()*i.getQuantity()).sum();
        totalPrice = totalPrice - (discountPercentage*totalPrice)/(double)100;
        return totalPrice;
    }

    public List<Product> getProducts() {
        return list;
    }
}
