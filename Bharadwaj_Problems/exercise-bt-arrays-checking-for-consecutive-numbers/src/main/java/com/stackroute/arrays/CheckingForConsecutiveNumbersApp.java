package com.stackroute.arrays;

import java.nio.file.StandardWatchEventKinds;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CheckingForConsecutiveNumbersApp {
    public static void main(String[] args) {
        CheckingForConsecutiveNumbersApp checkingForConsecutiveNumbersApp = new CheckingForConsecutiveNumbersApp();
        checkingForConsecutiveNumbersApp.readInput();
    }

    //write logic to get inputs from user and send inputs to inputValidator
    public void readInput() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        inputValidator(str);
    }

    //write logic to send inputs to checkStrongNumber
    public void inputValidator(String input) {
        boolean bool = checkForConsecutive(input);
        displayResult(bool);
    }

    //write logic to check given numbers are consecutive or not and returns true if numbers are consecutive otherwise false
    public boolean checkForConsecutive(String input) {
        String[] splitString = input.split(",");
        int[] arr = new int[splitString.length];

        for (int i = 0; i < splitString.length; i++) {
            arr[i] = Integer.parseInt(splitString[i].trim());
        }
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i]-1) != arr[i - 1]) {
                return false;
            }
        }

        return true;
    }
    //write logic to print the given printStatement
    public void displayResult(Object printStatement) {
        boolean value = (boolean) printStatement;
        if(value == true){
            System.out.println("Given numbers are Consecutive");
        }
        else System.out.println("Given numbers are not Consecutive");
    }
}
