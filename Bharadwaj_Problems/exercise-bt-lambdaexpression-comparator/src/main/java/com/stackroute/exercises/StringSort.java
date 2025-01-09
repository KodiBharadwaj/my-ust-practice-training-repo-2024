package com.stackroute.exercises;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringSort {

    //write here logic to sort a string List
    public String stringSorter(List<String> stringList, String sortingOrder) {

        if(sortingOrder == null || sortingOrder.trim().length() == 0 || stringList == null || stringList.isEmpty()){
            return "Given stringList or sortingOrder is empty, null or blank space";
        }

        if(stringList.size() == 1 && stringList.get(0).trim().length()!=0){
            return "The list contains only one value";
        }

        for(String s: stringList){
            if(s.isEmpty() || s.trim().length() == 0) return "The list contains an empty or blank space value";
        }




        String str;
        if(sortingOrder ==  "asc" || sortingOrder ==  "ASC"){
            str = stringList.stream().sorted().collect(Collectors.joining(", "));
        }
        else if(sortingOrder == "desc" || sortingOrder ==  "DESC"){
            str = stringList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(", "));
        }
        else{
            return "No sorting order present for given string '" + sortingOrder + "' , 'asc' for ascending order sort and 'desc' for descending order sort";
        }

        str = "[" + str + "]";
        return str;

    }
}
