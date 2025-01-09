package com.stackroute.lambdaexpression;

import java.util.List;

public class AlphabetChecker {
    //write logic to find whether given string contains only alphabets or not
    public String checkAlphabets(List<String> inputList) {
        if(inputList.isEmpty()){
            return "Give proper input not empty list";
        }
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(String s: inputList){
            for(int i=0; i<s.length(); i++){
                if(!str.contains(String.valueOf(s.charAt(i)))){
                    return "Given list contains non alphabet strings";
                }
            }
        }
        return "Given list contains only alphabet strings";
    }
}
