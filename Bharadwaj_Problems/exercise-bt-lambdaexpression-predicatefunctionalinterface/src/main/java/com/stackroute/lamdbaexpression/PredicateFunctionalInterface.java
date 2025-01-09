package com.stackroute.lamdbaexpression;

import java.util.ArrayList;
import java.util.List;

public class PredicateFunctionalInterface {
    //write logic to find the values that starts with letter I in the given list
    public List<String> findPattern(List<String> list) {


        List<String> pattern = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).charAt(0) == 'I' && !pattern.contains(list.get(i))){
                pattern.add(list.get(i));
            }
        }
        return pattern;
    }
}
