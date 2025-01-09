package com.stackroute.lambdaexpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductSorter {
    private List<Product> allProducts = new ArrayList<>();
    public List<Product> getProductList(){
        return allProducts;
    }

    public List<Product> sortProductByNameLength(){
        List<Product> list1 = getProductList();
        //Collections.sort(list1);
        list1.sort((a,b)->{
            if(a.getName().length()==b.getName().length()){
                return a.getName().compareTo(b.getName());
            }
            return a.getName().length()- b.getName().length();
        });
        return list1;
    }

    public List<Product> sortProductByName(){
        List<Product> list2 = getProductList();
        if(list2.size() == 0) return Collections.emptyList();

        list2.sort((a,b)->a.getName().compareTo(b.getName()));
        return list2;
    }

    public List<Product> sortProductByPriceDescending(){
        List<Product> list3 = getProductList();
        list3.sort((a,b)-> (int) (b.getPrice()-a.getPrice()));
        return list3;
    }

    public List<Product> sortProductByCategoryAscendingAndByPriceDescending(){
        List<Product> list3 = getProductList();
        list3.sort((a,b)->{
            if(a.getCategory() == b.getCategory()){
                return (int) (b.getPrice() - a.getPrice());
            }
            return a.getCategory().compareTo(b.getCategory());
        });
        return list3;
    }
}
