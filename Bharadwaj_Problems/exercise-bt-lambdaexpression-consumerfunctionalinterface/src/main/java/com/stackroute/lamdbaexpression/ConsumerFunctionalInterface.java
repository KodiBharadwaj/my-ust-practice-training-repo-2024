package com.stackroute.lamdbaexpression;

import java.math.BigInteger;
import java.util.List;

public class ConsumerFunctionalInterface {
    //write logic to find the square of each number in a given list of numbers
    public List<BigInteger> findSquare(List<BigInteger> list) {
        if(list.isEmpty()) return list;
//        for(int i=0; i<list.size(); i++){
//            list.set(i,(list.get(i).multiply(list.get(i))));
//        }

        return list.stream()
                .map(i->(i.multiply(i))).toList();

    }
}
