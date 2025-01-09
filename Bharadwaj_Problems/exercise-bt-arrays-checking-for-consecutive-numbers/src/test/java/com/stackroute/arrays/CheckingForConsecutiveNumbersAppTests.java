package com.stackroute.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingForConsecutiveNumbersAppTests {

    private ByteArrayOutputStream outStream;
    private static final String CONSECUTIVE_MESSAGE = "Given numbers are Consecutive";
    private static final String NON_CONSECUTIVE_MESSAGE = "Given numbers are not Consecutive";
    private static final String INPUT_VALIDATION_MESSAGE = "Check the logic of your method inputValidator";

    @BeforeEach
    public void setUp() {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @AfterEach
    public void tearDown() {
        outStream = null;
    }

    @Test
    public void givenSystemInputOfConsecutiveThenReturnResult() {
        String input = "2,4,6,3,1,0,5,7";
        ByteArrayInputStream myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);
        CheckingForConsecutiveNumbersApp.main(null);
        assertEquals(CONSECUTIVE_MESSAGE, outStream.toString().trim().replaceAll(".*\n", ""), INPUT_VALIDATION_MESSAGE);
    }

    @Test
    public void givenSystemInputOfNegativeConsecutiveThenReturnResult() {
        String input = "-2,-4,-6,-3,-1,0,-5,-7";
        ByteArrayInputStream myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);
        CheckingForConsecutiveNumbersApp.main(null);
        assertEquals(CONSECUTIVE_MESSAGE, outStream.toString().trim().replaceAll(".*\n", ""), INPUT_VALIDATION_MESSAGE);
    }

    @Test
    public void givenSystemInputOfNonConsecutiveStringThenReturnErrorString() {
        String input = "3,10,8,4,6,5,8,9";
        ByteArrayInputStream myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);
        CheckingForConsecutiveNumbersApp.main(null);
        assertEquals(NON_CONSECUTIVE_MESSAGE, outStream.toString().trim().replaceAll(".*\n", ""), INPUT_VALIDATION_MESSAGE);
    }

    @Test
    public void givenSystemInputOfNegativeNonConsecutiveStringThenReturnErrorString() {
        String input = "-3,-10,-8,-4,-6,-5,-8,-9";
        ByteArrayInputStream myInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(myInputStream);
        CheckingForConsecutiveNumbersApp.main(null);
        assertEquals(NON_CONSECUTIVE_MESSAGE, outStream.toString().trim().replaceAll(".*\n", ""), INPUT_VALIDATION_MESSAGE);
    }

}
