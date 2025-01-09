package com.stackroute.basics;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class NumberValidation {

    public void inputValidator() {
        Scanner s = new Scanner(System.in);
        BigInteger value;
        String str;
        if(s.hasNextBigInteger()){
            value=s.nextBigInteger();
            str=numberValidator(value);
            System.out.println(str);
        }else{
            System.out.println("Give proper whole number which is not zero");
        }

    }

    //write logic to find even/odd and return string
    public String numberValidator(BigInteger number) {
        if(Objects.equals(number, BigInteger.ZERO)) return "Give proper whole number which is not zero";

        if(number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return "even";
        else return "odd";
    }
}
