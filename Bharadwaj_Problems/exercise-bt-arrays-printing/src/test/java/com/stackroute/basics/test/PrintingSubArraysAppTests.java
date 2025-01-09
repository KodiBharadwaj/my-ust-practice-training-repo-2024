package com.stackroute.basics.test;

import com.stackorute.basics.PrintingSubArraysApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintingSubArraysAppTests {
    private ByteArrayOutputStream myOutStream;
    private static final String MESSAGE_01 = "App Should display all the sub arrays, one in each line with values separated by space, in the sorted order";
    private static final String MESSAGE_02 = "App Should display 'Insufficient Array Elements' for the Input Array of less than size 2 ";

    @BeforeEach
    public void setUp() {
        myOutStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOutStream));
    }

    @Test
    public void givenUserEntersValidInputArrayThenAppShouldPrintAllTheSubArrays() {
        /*        testing the app for valid input array with only positive values*/
        String input = "4 1 2 3 4";
        String output = "1 2 3 4 2 3 4 3 4 1 2 3 2 3 4 1 2 3 2 1";
        ByteArrayInputStream myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);
        PrintingSubArraysApp.main(null);
        String actual = myOutStream.toString().trim().replaceAll("\\s+", " ");
        Assertions.assertEquals(output.replaceAll("\\s+", " "), actual, MESSAGE_01);
    }

    @Test
    public void givenUserEntersValidInputArrayWithNegativeValuesThenAppShouldPrintAllTheSubArrays() {
        /*        testing the app for valid input array with negative values*/
        String input = "5 3 6 -4 12 -9";
        String output = "3 6 -4 12 6 -4 12 12 3 6 -4 12 3 6 -4 12 -9 6 3 6 -4 6 -4 12 -9 3 12 -9 6 -4 -4 12 -9 -4 -9";
        ByteArrayInputStream myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);
        PrintingSubArraysApp.main(null);
        String actual = myOutStream.toString().trim().replaceAll("\\s+", " ");
        Assertions.assertEquals(output.replaceAll("\\s+", " "), actual, MESSAGE_01);
    }

    @Test
    public void givenUserEntersInvalidInputArrayThenAppShouldPrintInsufficientArrayElements() {
        /*        testing the app for invalid input array with the size less than 2*/
        String input = "1 23";
        String output = "Insufficient Array Elements";
        ByteArrayInputStream myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);
        PrintingSubArraysApp.main(null);
        String actual = myOutStream.toString().trim().replaceAll("\\s+", " ");
        Assertions.assertEquals(output.replaceAll("\\s+", " "), actual, MESSAGE_02);
    }
}
