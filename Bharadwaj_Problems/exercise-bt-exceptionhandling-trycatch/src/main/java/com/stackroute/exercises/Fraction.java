package com.stackroute.exercises;


import static java.lang.String.valueOf;

public class Fraction {
    //Write logic to calculate the fraction and return as a String
    public String fractionCalculator(int firstNumber, int secondNumber) {
        String str = "";

            try{
                int value = firstNumber/secondNumber;
                str = str + value;
            }catch(ArithmeticException e){
                return e.toString();
            }


        return str;
    }
}
