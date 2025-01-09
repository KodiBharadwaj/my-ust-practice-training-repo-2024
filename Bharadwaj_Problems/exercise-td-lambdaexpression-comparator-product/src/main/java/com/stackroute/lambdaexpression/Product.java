package com.stackroute.lambdaexpression;

public class Product  {
    private int id;
    private String category;
    private String name;
    private double price;

    public Product(int id, String category, String name, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", category='" + category +
                "', name='" + name +
                "', price=" + price;
    }

    //    @Override
//    public int compareTo(Product o) {
//        if(this.getName().length() == o.getName().length()){
//            return this.getName().compareTo(o.getName());
//        }
//        return this.getName().length()-o.getName().length();
//    }
}
