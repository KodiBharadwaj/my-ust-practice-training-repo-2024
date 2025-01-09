package com.stackroute.basics;

import java.util.Scanner;
import java.util.StringJoiner;

public class StringFinder {
    //Create Scanner object as instance variable

    public static void main(String[] args) {
        StringFinder stringFinder = new StringFinder();
        stringFinder.getInput();

    }

    public void getInput() {
        Scanner s = new Scanner(System.in);
        String searchString = s.nextLine();
        String firstString = s.nextLine();
        String secondString = s.nextLine();
        int val = findString(searchString, firstString, secondString);
        displayResult(val);
    }

    public void displayResult(int result) {
        //displays the result
        if(result == -1) System.out.println("Empty string or null");
        if(result == 1) System.out.println("Found as expected");
        if(result == 0) System.out.println("Not found");
    }

    public int findString(String searchString, String firstString, String secondString) {

        if(searchString == null || firstString == null || secondString == null || searchString.isEmpty() || firstString.isEmpty() || secondString.isEmpty() || searchString == "" || firstString == "" || secondString == ""){
            return -1;
        }

        int index1 = searchString.indexOf(firstString);
        if (index1 == -1) {
            return 0;
        }

        int index2 = index1 + firstString.length();
        if (index2 >= searchString.length()) {
            return 0;
        }
        if(searchString.contains(firstString)){
            String outputString = searchString.substring(index2 + 1);
            if(outputString.contains(secondString)) return 1;
        }

        return 0;
    }

}
