package com.shoppingcart.app.repository;

import com.shoppingcart.app.exception.InvalidQuantityException;
import com.shoppingcart.app.exception.ProductNotFoundException;
import com.shoppingcart.app.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartRepositoryImplTest {


    private ShoppingCartRepositoryImpl shoppingCartRepository;
    private Product product1;
    private Product product2;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        shoppingCartRepository = new ShoppingCartRepositoryImpl();
        product1 = new Product(1, "Product1", "Category1", 10.0, 2);
        product2 = new Product(2, "Product2", "Category2", 20.0, 3);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void displayCartItems() throws InvalidQuantityException {
        shoppingCartRepository.addProduct(product1, 2);
        shoppingCartRepository.addProduct(product2, 3);
        shoppingCartRepository.displayCartItems();
        assertEquals("Product1 2 10.0\nProduct2 3 20.0", outContent.toString().trim());
    }


@Test
void addProductWithValidQuantity() throws InvalidQuantityException {
    shoppingCartRepository.addProduct(product1, 5);
    Assertions.assertArrayEquals(new Product[]{product1}, shoppingCartRepository.getProducts().toArray());
}

@Test
void addProductWithInvalidQuantity() {
    assertThrows(InvalidQuantityException.class, () -> shoppingCartRepository.addProduct(product1, -1));
}

@Test
void removeExistingProduct() throws ProductNotFoundException, InvalidQuantityException {
    shoppingCartRepository.addProduct(product1, 5);
    shoppingCartRepository.removeProduct(product1);
    assertTrue(shoppingCartRepository.getProducts().isEmpty());
}

@Test
void removeNonExistingProduct() {
    assertThrows(ProductNotFoundException.class, () -> shoppingCartRepository.removeProduct(product1));
}

@Test
void updateProductQuantityWithValidQuantity() throws ProductNotFoundException, InvalidQuantityException {
    shoppingCartRepository.addProduct(product1, 5);
    shoppingCartRepository.updateProductQuantity(product1, 10);
    assertEquals(10, shoppingCartRepository.getProducts().get(0).getQuantity());
}

@Test
void updateProductQuantityWithInvalidQuantity() {
    assertThrows(InvalidQuantityException.class, () -> shoppingCartRepository.updateProductQuantity(product1, -1));
}

@Test
void updateQuantityOfNonExistingProduct() {
    assertThrows(ProductNotFoundException.class, () -> shoppingCartRepository.updateProductQuantity(product1, 5));
}

@Test
void calculateTotalPrice() throws InvalidQuantityException {
    shoppingCartRepository.addProduct(product1, 2);
    shoppingCartRepository.addProduct(product2, 3);
    double totalPrice = shoppingCartRepository.calculateTotalPrice();
    assertEquals(80.0, totalPrice);
}

@Test
void filterProductsByCategory() throws InvalidQuantityException {
    shoppingCartRepository.addProduct(product1, 2);
    shoppingCartRepository.addProduct(product2, 3);
    List<Product> filteredProducts = shoppingCartRepository.filterProductsByCategory("Category1");
    assertEquals(1, filteredProducts.size());
    assertEquals("Product1", filteredProducts.get(0).getName());
}

@Test
void filterProductsByPriceRange() throws InvalidQuantityException {
    shoppingCartRepository.addProduct(product1, 2);
    shoppingCartRepository.addProduct(product2, 3);
    List<Product> filteredProducts = shoppingCartRepository.filterProductsByPriceRange(5.0, 15.0);
    assertEquals(1, filteredProducts.size());
    assertEquals("Product1", filteredProducts.get(0).getName());
}

@Test
void findMostExpensiveProduct() throws InvalidQuantityException {
    shoppingCartRepository.addProduct(product1, 2);
    shoppingCartRepository.addProduct(product2, 3);
    Optional<Product> mostExpensiveProduct = shoppingCartRepository.findMostExpensiveProduct();
    assertTrue(mostExpensiveProduct.isPresent());
    assertEquals("Product2", mostExpensiveProduct.get().getName());
}

@Test
void sortProductsByName() throws InvalidQuantityException {
    shoppingCartRepository.addProduct(product2, 3);
    shoppingCartRepository.addProduct(product1, 2);
    List<Product> sortedProducts = shoppingCartRepository.sortProductsByName();
    assertEquals(2, sortedProducts.size());
    assertEquals("Product1", sortedProducts.get(0).getName());
    assertEquals("Product2", sortedProducts.get(1).getName());
}

@Test
void calculateDiscountedTotal() throws InvalidQuantityException {
    shoppingCartRepository.addProduct(product1, 2);
    shoppingCartRepository.addProduct(product2, 3);
    double discountedTotal = shoppingCartRepository.calculateDiscountedTotal(10.0);
    assertEquals(72.0, discountedTotal);
}



}

