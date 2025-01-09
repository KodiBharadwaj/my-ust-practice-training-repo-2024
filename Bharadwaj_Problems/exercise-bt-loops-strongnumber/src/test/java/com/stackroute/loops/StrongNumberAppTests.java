package com.stackroute.loops;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class    StrongNumberAppTests {
    private ByteArrayOutputStream outStream;

    private static final String MESSAGE = "Check the logic of your method checkStrongNumber";

    private static final String INPUT_VALIDATION_MESSAGE = "Check the logic of your method inputValidator";
    private static final String PROPER_NEGATIVE_MESSAGE = "Give proper input not negative number";
    private static final String PROPER_ZERO_MESSAGE = "Give proper input not zero";


    private static final String FALSE_MESSAGE = "false";

    private static final String TRUE_MESSAGE = "true";

    @BeforeEach
    public void setUp() {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @AfterEach
    public  void tearDown() {
        outStream = null;
    }

    @Test
    public void givenSystemInputNegativeThenReturnErrorString() {
        System.setIn(new ByteArrayInputStream("-20".getBytes()));
        StrongNumber.main(null);
        assertEquals(PROPER_NEGATIVE_MESSAGE, outStream.toString().trim().replaceAll(".*\n", ""), INPUT_VALIDATION_MESSAGE);

    }

    @Test
    public void givenSystemInputZeroThenReturnErrorString() {
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        StrongNumber.main(null);
        assertEquals(PROPER_ZERO_MESSAGE, outStream.toString().trim().replaceAll(".*\n", ""), INPUT_VALIDATION_MESSAGE);

    }

    @Test
    public void givenSystemInputIntegerThenReturnFalse() {
        System.setIn(new ByteArrayInputStream("424".getBytes()));
        StrongNumber.main(null);
        assertEquals(FALSE_MESSAGE, outStream.toString().trim().replaceAll(".*\n", ""), MESSAGE);
    }

    @Test
    public void givenSystemInputStrongNumberThenReturnTrue() {
        System.setIn(new ByteArrayInputStream("145".getBytes()));
        StrongNumber.main(null);
        assertEquals(TRUE_MESSAGE, outStream.toString().trim().replaceAll(".*\n", ""), MESSAGE);
    }

}