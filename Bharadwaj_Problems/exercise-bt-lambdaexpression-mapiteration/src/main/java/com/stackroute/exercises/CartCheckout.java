package com.stackroute.exercises;


import java.math.BigDecimal;
import java.util.Map;

public class CartCheckout {

    //write here logic to add a Map values include tax using lambda expression
    public String billGenerator(Map<String, BigDecimal> cart, Double taxPercent) {

        if (taxPercent == null) {
            return "The taxPercent cannot be null";
        }
        if(cart == null){
            return "The cart Map cannot be null";
        }
        if (cart.isEmpty()) {
            return "The cart Map is empty";
        }


        if (taxPercent < 0) {
            return "The taxPercent cannot be negative";
        }

        for(String str : cart.keySet()){
            if(str == null || str.trim().length() == 0) return "The cart Map has null or empty or blank space as a value";
        }

        for (BigDecimal value : cart.values()) {
            if (cart.containsKey(null) || cart.containsValue(null)) {
                return "The cart Map has null or empty or blank space as a value";
            }
        }

        double value = 0;
        for(String i: cart.keySet()){
            value += cart.get(i).doubleValue();
        }

        value = value + (taxPercent*value)/(double)100;

        String str="";
        str = str + value;
        return str;
    }
}
