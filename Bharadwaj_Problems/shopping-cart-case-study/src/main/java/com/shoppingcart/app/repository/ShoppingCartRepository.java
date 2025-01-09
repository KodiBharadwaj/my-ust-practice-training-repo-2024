package com.shoppingcart.app.repository;

import com.shoppingcart.app.exception.InvalidQuantityException;
import com.shoppingcart.app.exception.ProductNotFoundException;
import com.shoppingcart.app.model.Product;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository {
    public void addProduct(Product product, int quantity) throws InvalidQuantityException;
    public void removeProduct(Product product) throws ProductNotFoundException;

    public void updateProductQuantity(Product product, int quantity) throws ProductNotFoundException, InvalidQuantityException;
    public double calculateTotalPrice() ;

    public List<Product> filterProductsByCategory(String category) ;

    public List<Product> filterProductsByPriceRange(double minPrice, double maxPrice) ;
    public void displayCartItems() ;
    public Optional<Product> findMostExpensiveProduct() ;

    public List<Product> sortProductsByName() ;
    public double calculateDiscountedTotal(double discountPercentage);
    public List<Product> getProducts();
}
