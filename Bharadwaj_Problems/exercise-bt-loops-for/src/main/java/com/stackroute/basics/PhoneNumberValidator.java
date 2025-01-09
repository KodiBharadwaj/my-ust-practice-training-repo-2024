package com.stackroute.basics;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneNumberValidator {
    //Create Scanner object as instance variable
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneNumberValidator object = new PhoneNumberValidator();
        String input = object.getInput();
        boolean result = object.validatePhoneNumber(input);
        object.displayResult(result);
    }

    public String getInput() {
        String str = sc.nextLine();
        return str;
    }

    public void displayResult(boolean result) {
       if(result == true){
           System.out.println("Valid");
       }
       else{
           System.out.println("Invalid or empty string");
       }
    }

    public boolean validatePhoneNumber(String s) {

        if(s == null) return false;

        int numCount = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                numCount++;
            }
            else if(ch != '-'){
                return false;
            }

        }
        if(numCount == 10) return true;
        else return false;
    }
}
