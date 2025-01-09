package com.stackroute.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.stackroute.basics.NumberValidation;
import org.junit.jupiter.api.*;

import java.math.BigInteger;

public class NumberValidationTests {
    private NumberValidation numberValidation;

    @BeforeEach
    public void setUp() {
        numberValidation = new NumberValidation();
    }

    @AfterEach
    public void tearDown() {
        numberValidation = null;
    }

    @Test
    public void givenLargeEvenBigIntegerThenReturnAString() {
        assertEquals("even", numberValidation.numberValidator(new BigInteger("2222222222")), "Check the logic of your method numberValidator and don't type cast to int the value is above range of int");
    }

    @Test
    public void givenOddNegativeBigIntegerThenReturnAString() {
        assertEquals("odd", numberValidation.numberValidator(new BigInteger("-4533")), "Check the logic of your method numberValidator");
    }

    @Test
    public void givenEvenBigIntegerThenReturnAString() {
        assertEquals("even", numberValidation.numberValidator(new BigInteger("340")), "Check the logic of your method numberValidator");
    }
}
