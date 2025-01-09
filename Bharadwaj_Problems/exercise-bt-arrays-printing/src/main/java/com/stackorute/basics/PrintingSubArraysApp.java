package com.stackorute.basics;


import java.util.*;

public class PrintingSubArraysApp {
    public static void main(String[] args) {
        /*
      calls the method that will read the array size and the array elements from the user
      calls the  method with the input array that will generate all the sub arrays of the input array, if valid, and
      return the result as a 2D array with sub arrays of different sizes. Returns null for the invalid input array.
      calls the method that will either prints all the sub arrays or prints 'Insufficient Array elements' for null.
      */
        PrintingSubArraysApp printSubArrays = new PrintingSubArraysApp();
        int[] arr = printSubArrays.getInput();
        int[][] twoDimeArray = printSubArrays.generateSubArrays(arr);
        printSubArrays.displayResult(twoDimeArray);

    }

    public int[][] generateSubArrays(int[] input) {
        /*
        takes the input array,if valid, generate all sub arrays and store it in a 2D array(array of integer arrays each having different length which represents a subArray)
        calculates subArraySum of each sub array and store the sumsOfAllSubArrays in a array
        returns null for invalid input array
        sorts the sub arrays stored in the 2D array according to their subArraySum, where the sub array with the maximum subArraySum will be first and
        the sub array with the least subArraySum will be at the last position
        returns the sorted 2D array
        */

        /*return null or sorted 2D array of sub arrays of different sizes*/

        Map<Integer, List<Integer>> map = new TreeMap<>();
        int size = input.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int sum = 0;
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    sum += input[i];
                    list.add(input[i]);
                }
                map.put(sum, list);
            }
        }

        List<List<Integer>> twoDimensionalList = new ArrayList<>();
        for (int i : map.keySet()) {
            twoDimensionalList.add(map.get(i));
        }

        int[][] result = new int[twoDimensionalList.size()][];

        for (int i = 0; i < twoDimensionalList.size(); i++) {
            List<Integer> subList = twoDimensionalList.get(i);
            result[i] = new int[subList.size()];

            for (int j = 0; j < subList.size(); j++) {
                result[i][j] = subList.get(j);
            }
        }

        return result;
    }

    public int[] getInput() {
        /*
        reads the input array size and the input array elements from the user
        returns the input array
        */

        /*return inputArray;*/
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public void displayResult(int[][] subArrays) {
        /*
        prints all the sub arrays in the 2D array
        prints each sub array in separate line with each values separated by space
        prints 'Insufficient Array elements' when the argument is null
        */

        for(int i=0; i<subArrays.length; i++){
            for(int j=0; j<subArrays[i].length; j++){
                System.out.print(subArrays[i][j]+" ");
            }
            System.out.println();
        }
    }
}