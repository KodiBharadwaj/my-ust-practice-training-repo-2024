package com.stackroute.basics.test;

import com.stackorute.basics.PrintingSubArraysApp;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrintingSubArraysTests {

    private static PrintingSubArraysApp printingSubArraysApp;
    private static final String MESSAGE_01 = "Method should return the sorted 2D array of sub arrays with different sizes";
    private static final String MESSAGE_02 = "Method should return 'null' for Input Array with size less than the required";

    @BeforeAll
    public static void setup() {
        printingSubArraysApp = new PrintingSubArraysApp();
    }

    @AfterAll
    public static void teardown() {
        printingSubArraysApp = null;
    }

    @Test
    public void givenValidInputArrayThenMethodShouldReturnSorted2DArrayOfAllSubArrays() {
        /*        testing the method for valid input array with only positive values*/
        int[][] validInputArray = {{1, 2, 3, 4}, {3, 6, 4, 12, 9}};
        int[][][] expected = {
                {{1, 2, 3, 4}, {2, 3, 4}, {3, 4}, {1, 2, 3}, {2, 3}, {4}, {1, 2}, {3}, {2}, {1}},
                {{3, 6, 4, 12, 9}, {6, 4, 12, 9}, {3, 6, 4, 12}, {4, 12, 9}, {6, 4, 12}, {12, 9}, {4, 12}, {3, 6, 4}, {12}, {6, 4}, {3, 6}, {9}, {6}, {4}, {3}}
        };
        int[][][] actual = {
                printingSubArraysApp.generateSubArrays(validInputArray[0]),
                printingSubArraysApp.generateSubArrays(validInputArray[1])
        };
        Assertions.assertArrayEquals(expected[0], actual[0], MESSAGE_01);
        Assertions.assertArrayEquals(expected[1], actual[1], MESSAGE_01);
    }

    @Test
    public void givenValidInputArrayWithNegativeValuesThenMethodShouldReturnSorted2DArrayOfAllSubArrays() {
        /*        testing the method for valid input array with negative values*/
        int[][] validInputArray = {{1, -2, 3, -4}, {3, 6, -4, 12, -9}};
        int[][][] expected = {
                {{3}, {1, -2, 3}, {-2, 3}, {1}, {1, -2}, {3, -4}, {-2}, {1, -2, 3, -4}, {-2, 3, -4}, {-4}},
                {{3, 6, -4, 12}, {6, -4, 12}, {12}, {3, 6}, {-4, 12}, {3, 6, -4, 12, -9}, {6}, {3, 6, -4}, {6, -4, 12, -9}, {3}, {12, -9}, {6, -4}, {-4, 12, -9}, {-4}, {-9}}
        };
        int[][][] actual = {
                printingSubArraysApp.generateSubArrays(validInputArray[0]),
                printingSubArraysApp.generateSubArrays(validInputArray[1])
        };
        Assertions.assertArrayEquals(expected[0], actual[0], MESSAGE_01);
        Assertions.assertArrayEquals(expected[1], actual[1], MESSAGE_01);
    }

    @Test
    public void givenInvalidInputArrayThenMethodShouldReturnNull() {
        /*        testing the method for invalid input array with the size less than 2*/
        int[] inputArrayWithInSufficientSize = {1};
        Assertions.assertNull(printingSubArraysApp.generateSubArrays(inputArrayWithInSufficientSize), MESSAGE_02);
    }
}
