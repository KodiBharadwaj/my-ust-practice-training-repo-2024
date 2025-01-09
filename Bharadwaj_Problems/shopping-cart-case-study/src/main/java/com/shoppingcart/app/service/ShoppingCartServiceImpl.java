package com.shoppingcart.app.service;

import com.shoppingcart.app.exception.InvalidProductException;
import com.shoppingcart.app.exception.InvalidQuantityException;
import com.shoppingcart.app.exception.ProductNotFoundException;
import com.shoppingcart.app.model.Product;
import com.shoppingcart.app.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    // Validate the following conditions and throw appropriate exceptions if the conditions are not met:

    // 1. Product :
    //    - Product id should be greater than 0
    //    - Product name should not be null or empty and should contain alphanumeric characters only
    //    - Product category should not be null or empty and should contain alphabets only
    //    - Product price should be greater than 0
    //    - Product quantity should be greater than 0
    // 2. Quantity :
    //    - Quantity should be greater than 0

    //ShoppingCartRepository shoppingcartrepository = new ShoppingCartRepositoryImpl();

    public void addProduct(Product product, int quantity) throws InvalidQuantityException, InvalidProductException {
        if(quantity <= 0){
            throw new InvalidQuantityException("Quantity should be greater than 0");
        }
        if(product.getId() <= 0 || product.getName() == null || product.getName().trim().isEmpty()
                || product.getCategory() == null || product.getCategory().trim().isEmpty()
                || product.getPrice() <= 0|| product.getQuantity() <= 0
                || !product.getName().matches("[a-zA-Z0-9]+")
                || !product.getCategory().matches("[a-zA-Z0-9]+")){

            throw new InvalidProductException("Invalid product details");
        }

        shoppingCartRepository.addProduct(product,quantity);
    }

    public void removeProduct(Product product) throws ProductNotFoundException {
        shoppingCartRepository.removeProduct(product);
    }

    public void updateProductQuantity(Product product, int quantity) throws ProductNotFoundException, InvalidQuantityException {
        if(quantity <= 0){
            throw new InvalidQuantityException("Invalid quantity number");
        }
        shoppingCartRepository.updateProductQuantity(product, quantity);
    }

    public double calculateTotalPrice() {
        return shoppingCartRepository.calculateTotalPrice();
    }

    public List<Product> filterProductsByCategory(String category) {
        return shoppingCartRepository.filterProductsByCategory(category);
    }

    public List<Product> filterProductsByPriceRange(double minPrice, double maxPrice) {

        return shoppingCartRepository.filterProductsByPriceRange(minPrice, maxPrice);
    }

    public void displayCartItems() {
        shoppingCartRepository.displayCartItems();
    }

    public Product findMostExpensiveProduct() {

        return shoppingCartRepository.findMostExpensiveProduct()
                .orElseThrow(() -> new RuntimeException("No product found"));
    }

    public List<Product> sortProductsByName() {

        return shoppingCartRepository.sortProductsByName();
    }

    public double calculateDiscountedTotal(double discountPercentage) {
        return shoppingCartRepository.calculateDiscountedTotal(discountPercentage);
    }

    public List<Product> getProducts() {
        return shoppingCartRepository.getProducts();
    }
}
