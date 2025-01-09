package com.stackroute.arrays;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingForConsecutiveNumbersTests {

    private CheckingForConsecutiveNumbersApp checkingForConsecutiveNumbersApp;
    private static final String MESSAGE = "Check the logic of your method checkForConsecutive";

    @BeforeEach
    public void setUp() {
        checkingForConsecutiveNumbersApp = new CheckingForConsecutiveNumbersApp();
    }

    @AfterEach
    public void tearDown() {
        checkingForConsecutiveNumbersApp = null;
    }

    @Test
    public void givenInputStringOfConsecutiveNumbersThenReturnResult() {
        String input = "4,5,3,2,0,1,6,9,8,7";
        assertEquals(true, checkingForConsecutiveNumbersApp.checkForConsecutive(input), MESSAGE);

    }

    @Test
    public void givenInputStringOfNonConsecutiveNumbersThenReturnResult() {
        String input = "4,5,3,2,0,1,11,6,9,8,7";
        assertEquals(false, checkingForConsecutiveNumbersApp.checkForConsecutive(input), MESSAGE);

    }

    @Test
    public void givenInputStringOfNegativeConsecutiveNumbersThenReturnResult() {
        String input = "-4,-5,-3,-2,-1,-6,-9,-8,-7";
        assertEquals(true, checkingForConsecutiveNumbersApp.checkForConsecutive(input), MESSAGE);

    }

    @Test
    public void givenInputStringOfNegativeNonConsecutiveNumbersThenReturnResult() {
        String input = "-4,-5,-3,-2,0,-1,-11,-7";
        assertEquals(false, checkingForConsecutiveNumbersApp.checkForConsecutive(input), MESSAGE);

    }
}