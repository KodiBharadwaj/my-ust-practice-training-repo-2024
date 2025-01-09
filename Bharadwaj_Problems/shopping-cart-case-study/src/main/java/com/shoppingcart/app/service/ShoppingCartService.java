package com.shoppingcart.app.service;

import com.shoppingcart.app.exception.InvalidProductException;
import com.shoppingcart.app.exception.InvalidQuantityException;
import com.shoppingcart.app.exception.ProductNotFoundException;
import com.shoppingcart.app.model.Product;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    public void addProduct(Product product, int quantity) throws InvalidQuantityException, InvalidProductException;
    public void removeProduct(Product product) throws ProductNotFoundException;

    public void updateProductQuantity(Product product, int quantity) throws ProductNotFoundException, InvalidQuantityException;
    public double calculateTotalPrice() ;

    public List<Product> filterProductsByCategory(String category) ;

    public List<Product> filterProductsByPriceRange(double minPrice, double maxPrice) ;
    public void displayCartItems() ;
    public Product findMostExpensiveProduct() ;

    public List<Product> sortProductsByName() ;
    public double calculateDiscountedTotal(double discountPercentage);
    public List<Product> getProducts();
}
