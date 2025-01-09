package com.shoppingcart.app.service;

import com.shoppingcart.app.exception.InvalidProductException;
import com.shoppingcart.app.exception.InvalidQuantityException;
import com.shoppingcart.app.exception.ProductNotFoundException;
import com.shoppingcart.app.model.Product;
import com.shoppingcart.app.repository.ShoppingCartRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceImplTest {

    @InjectMocks
    private ShoppingCartServiceImpl shoppingCartService;

    @Mock
    private ShoppingCartRepositoryImpl shoppingCartRepository;

    @Test
    void addProductWithValidQuantity() throws InvalidQuantityException {

        // Given
        Product product = new Product(1, "Product1", "Category1", 10.0, 2);

        // When
        Mockito.doNothing().when(shoppingCartRepository).addProduct(product, 5);

        // Then
        assertDoesNotThrow(() -> shoppingCartService.addProduct(product, 5));

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).addProduct(product, 5);

    }


    @Test
    void addProductWithInvalidQuantity() throws InvalidQuantityException {

        // Given
        Product product = new Product(1, "Product1", "Category1", 10.0, 2);

        // Then
        assertThrows(InvalidQuantityException.class, () -> shoppingCartService.addProduct(product, -1));

    }

    @Test
    void addProductWithInvalidProductId() throws InvalidProductException, InvalidQuantityException {
        // Given
        Product product = new Product(0, "Product1", "Category1", 10.0, 2);


        // Then
        assertThrows(InvalidProductException.class, () -> shoppingCartService.addProduct(product, 5));

    }

    @Test
    void addProductWithInvalidProductName() throws InvalidQuantityException {
        // Given
        Product product = new Product(1, "", "Category1", 10.0, 2);
        Product product1 = new Product(1, "abc 123$", "Category1", 10.0, 2);

        // Then
        assertThrows(InvalidProductException.class, () -> shoppingCartService.addProduct(product, 5));
        assertThrows(InvalidProductException.class, () -> shoppingCartService.addProduct(product1, 5));

    }

    @Test
    void addProductWithInvalidProductCategory() throws InvalidQuantityException {
        // Given
        Product product = new Product(1, "Product1", "", 10.0, 2);
        Product product1 = new Product(1, "Product1", "123 $@", 10.0, 2);

        // Then
        assertThrows(InvalidProductException.class, () -> shoppingCartService.addProduct(product, 5));
        assertThrows(InvalidProductException.class, () -> shoppingCartService.addProduct(product1, 5));

    }

    @Test
    void addProductWithInvalidProductPrice() throws InvalidQuantityException {
        // Given
        Product product = new Product(1, "Product1", "Category1", 0.0, 2);

        // Then
        assertThrows(InvalidProductException.class, () -> shoppingCartService.addProduct(product, 5));

    }

    @Test
    void addProductWithInvalidProductQuantity() throws InvalidQuantityException {
        // Given
        Product product = new Product(1, "Product1", "Category1", 10.0, 0);

        // Then
        assertThrows(InvalidProductException.class, () -> shoppingCartService.addProduct(product, 5));

    }


    @Test
    void removeExistingProduct() throws ProductNotFoundException {

        // Given
        Product product = new Product(1, "Product1", "Category1", 10.0, 2);

        // When
        Mockito.doNothing().when(shoppingCartRepository).removeProduct(product);

        // Then
        assertDoesNotThrow(() -> shoppingCartService.removeProduct(product));

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).removeProduct(product);

    }



    @Test
    void removeNonExistingProduct() throws ProductNotFoundException {

        // Given
        Product product = new Product(1, "Product1", "Category1", 10.0, 2);

        // When
        Mockito.doThrow(ProductNotFoundException.class).when(shoppingCartRepository).removeProduct(product);

        // Then
        assertThrows(ProductNotFoundException.class, () -> shoppingCartService.removeProduct(product));

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).removeProduct(product);

    }



    @Test
    void updateProductQuantityWithValidQuantity() throws ProductNotFoundException, InvalidQuantityException {

        // Given
        Product product = new Product(1, "Product1", "Category1", 10.0, 2);

        // When
        Mockito.doNothing().when(shoppingCartRepository).updateProductQuantity(product, 5);

        // Then
        assertDoesNotThrow(() -> shoppingCartService.updateProductQuantity(product, 5));

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).updateProductQuantity(product, 5);

    }



    @Test
    void updateProductQuantityWithInvalidQuantity() throws ProductNotFoundException, InvalidQuantityException {

        // Given
        Product product = new Product(1, "Product1", "Category1", 10.0, 2);

        // Then
        assertThrows(InvalidQuantityException.class, () -> shoppingCartService.updateProductQuantity(product, -1));

    }


    @Test
    void updateQuantityOfNonExistingProduct() throws InvalidQuantityException, ProductNotFoundException {

        // Given
        Product product = new Product(1, "Product1", "Category1", 10.0, 2);

        // When
        Mockito.doThrow(ProductNotFoundException.class).when(shoppingCartRepository).updateProductQuantity(product, 5);

        // Then
        assertThrows(ProductNotFoundException.class, () -> shoppingCartService.updateProductQuantity(product, 5));

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).updateProductQuantity(product, 5);

    }


    @Test
    void calculateTotalPrice() {

        // Given
        Product product1 = new Product(1, "Product1", "Category1", 10.0, 2);
        Product product2 = new Product(2, "Product2", "Category2", 20.0, 3);

        // When
        Mockito.when(shoppingCartRepository.calculateTotalPrice()).thenReturn(80.0);

        // Then
        assertEquals(80.0, shoppingCartService.calculateTotalPrice());

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).calculateTotalPrice();

    }


    @Test
    void filterProductsByCategory() {

        // Given
        Product product1 = new Product(1, "Product1", "Category1", 10.0, 2);
        Product product2 = new Product(2, "Product2", "Category2", 20.0, 3);

        // When
        Mockito.when(shoppingCartRepository.filterProductsByCategory("Category1")).thenReturn(List.of(product1));

        // Then
        assertEquals(1, shoppingCartService.filterProductsByCategory("Category1").size());

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).filterProductsByCategory("Category1");

    }



    @Test
    void filterProductsByPriceRange() {

        // Given
        Product product1 = new Product(1, "Product1", "Category1", 10.0, 2);
        Product product2 = new Product(2, "Product2", "Category2", 20.0, 3);

        // When
        Mockito.when(shoppingCartRepository.filterProductsByPriceRange(5.0, 15.0)).thenReturn(List.of(product1));

        // Then
        assertEquals(1, shoppingCartService.filterProductsByPriceRange(5.0, 15.0).size());

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).filterProductsByPriceRange(5.0, 15.0);

    }


    @Test
    void findMostExpensiveProduct() {

        // Given
        Product product1 = new Product(1, "Product1", "Category1", 10.0, 2);
        Product product2 = new Product(2, "Product2", "Category2", 20.0, 3);

        // When
        Mockito.when(shoppingCartRepository.findMostExpensiveProduct()).thenReturn(Optional.of(product2));

        // Then
        assertEquals("Product2", shoppingCartService.findMostExpensiveProduct().getName());

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).findMostExpensiveProduct();

    }


    @Test
    void sortProductsByName() {

        // Given
        Product product1 = new Product(1, "Product1", "Category1", 10.0, 2);
        Product product2 = new Product(2, "Product2", "Category2", 20.0, 3);

        // When
        Mockito.when(shoppingCartRepository.sortProductsByName()).thenReturn(List.of(product1, product2));

        // Then
        assertEquals("Product1", shoppingCartService.sortProductsByName().get(0).getName());
        assertEquals("Product2", shoppingCartService.sortProductsByName().get(1).getName());

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(2)).sortProductsByName();

    }


    @Test
    void calculateDiscountedTotal() {

        // Given
        Product product1 = new Product(1, "Product1", "Category1", 10.0, 2);
        Product product2 = new Product(2, "Product2", "Category2", 20.0, 3);

        // When
        Mockito.when(shoppingCartRepository.calculateDiscountedTotal(10.0)).thenReturn(72.0);

        // Then
        assertEquals(72.0, shoppingCartService.calculateDiscountedTotal(10.0));

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).calculateDiscountedTotal(10.0);

    }


    @Test
    void getProducts() {

        // Given
        Product product1 = new Product(1, "Product1", "Category1", 10.0, 2);
        Product product2 = new Product(2, "Product2", "Category2", 20.0, 3);

        // When
        Mockito.when(shoppingCartRepository.getProducts()).thenReturn(List.of(product1, product2));

        // Then
        assertEquals(2, shoppingCartService.getProducts().size());

        // Verify
        Mockito.verify(shoppingCartRepository, Mockito.times(1)).getProducts();

    }


}
