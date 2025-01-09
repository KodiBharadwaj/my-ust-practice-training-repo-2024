package com.stackroute.loops;

import java.math.BigInteger;
import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        new StrongNumber().inputAcceptor();
    }

    //write logic to get inputs from user and send inputs to inputValidator
    public void inputAcceptor() {
        Scanner scanner = new Scanner(System.in);
        int strongNumber = scanner.nextInt();
        inputValidator(strongNumber);
    }

    //write logic to get inputs from user and send inputs to checkStrongNumber
    public void inputValidator(int number) {
        if(number == 0) System.out.println("Give proper input not zero");
        else if(number < 0) System.out.println("Give proper input not negative number");
        else{
            boolean result = checkStrongNumber(number);
            outputPrinter(result);
        }
    }

    //write logic to check Strong number or not and returns true if number is Strong otherwise false
    public BigInteger factorialFunction(int number){
        if(number == 0 || number == 1) return BigInteger.ONE;
        else return BigInteger.valueOf(number).multiply(factorialFunction(number-1));
    }
    public boolean checkStrongNumber(int number) {

        if(number == 0) return false;
        int value = number;
        BigInteger sum = BigInteger.ZERO;
        while(value != 0){
            int lastDigit = value%10;
            sum = sum.add(factorialFunction(lastDigit));
            value/=10;
        }

        if(sum.equals(BigInteger.valueOf(number))) return true;
        else return false;
    }

    //write logic to print the given printStatement
    public void outputPrinter(Object printStatement) {
        boolean output = (boolean) printStatement;
        if(output == true){
            System.out.println("true");
        }
        else System.out.println("false");
    }
}

