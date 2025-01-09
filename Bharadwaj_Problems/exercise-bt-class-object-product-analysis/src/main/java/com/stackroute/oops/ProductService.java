package com.stackroute.oops;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/*
    Class for Analyzing the products present in ProductRepository
 */
public class ProductService {

    /*
        Returns the name of the product given the productCode
     */

    public String findProductNameByCode(int productCode) {

        Product[] products = ProductRepository.getProducts();

        String str = Arrays.stream(products).filter(i->i.getProductCode() == productCode).map(i->i.getName()).findFirst().orElse(null);
        return str;
    }

    /*
        Returns the Product with maximum price in a given category
     */
    public Product findMaxPriceProductInCategory(String category) {
        Product[] products = ProductRepository.getProducts();
        return Arrays.stream(products).filter(i->i.getCategory() == category)
                .reduce((a,b)->{
                    if(b.getPrice() > a.getPrice()){
                        a = b;
                    }
                    return a;
                }).orElse(null);

    }

    /*
        Returns a array of products for a given category
     */
    public Product[] getProductsByCategory(String category) {
        Product[] products = ProductRepository.getProducts();

        Product[] product = Arrays.stream(products).filter(i-> Objects.equals(i.getCategory(), category)).toArray(Product[]::new);

        if(product.length == 0) return null;
        return product;
    }
}
