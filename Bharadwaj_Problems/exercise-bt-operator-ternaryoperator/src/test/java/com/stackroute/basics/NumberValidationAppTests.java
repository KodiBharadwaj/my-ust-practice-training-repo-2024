package com.stackroute.basics;

import com.stackroute.basics.NumberValidation;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberValidationAppTests {
    private ByteArrayOutputStream outStream;
    private NumberValidation numberValidation;

    @BeforeEach
    public void setUp() {
        numberValidation = new NumberValidation();
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @AfterEach
    public void tearDown() {
        numberValidation = null;
        outStream = null;
    }

    @Test
    public void givenSystemInputDecimalThenReturnAErrorString() {
        System.setIn(new ByteArrayInputStream("2.5".getBytes()));
        numberValidation.inputValidator();
        assertEquals("Give proper whole number which is not zero", outStream.toString().trim().replaceAll(".*\n", ""), "Write a condition to check whether the input is Decimal or Zero");
    }

    @Test
    public void givenSystemInputZeroThenReturnAErrorString() {
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        numberValidation.inputValidator();
        assertEquals("Give proper whole number which is not zero", outStream.toString().trim().replaceAll(".*\n", ""), "Write a condition to check whether the input is Decimal or Zero");
    }

    @Test
    public void givenSystemInputIntegerThenReturnAString() {
        System.setIn(new ByteArrayInputStream("420".getBytes()));
        numberValidation.inputValidator();
        assertEquals("even", outStream.toString().trim().replaceAll(".*\n", ""), "Check the logic of your method numberValidator");
    }

    @Test
    public void givenSystemInputNegativeIntegerThenReturnAString() {
        System.setIn(new ByteArrayInputStream("-423".getBytes()));
        numberValidation.inputValidator();
        assertEquals("odd", outStream.toString().trim().replaceAll(".*\n", ""), "Check the logic of your method numberValidator");
    }
}
