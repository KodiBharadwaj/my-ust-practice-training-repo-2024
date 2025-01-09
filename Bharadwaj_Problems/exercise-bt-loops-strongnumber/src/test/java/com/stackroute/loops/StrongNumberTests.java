package com.stackroute.loops;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.*;


public class StrongNumberTests {
    private StrongNumber strongNumber;

    private static final String MESSAGE = "Check the logic of your method checkStrongNumber";
    private static final String PROPER_ZERO_MESSAGE = "Give proper input not zero";
    @BeforeEach
    public void setUp() {
        strongNumber = new StrongNumber();
    }

    @AfterEach
    public void tearDown() {
        strongNumber = null;
    }

    @Test
    public void givenPositiveIntegerThenReturnTrue() {

        assertEquals(true, strongNumber.checkStrongNumber(1), MESSAGE);
        assertEquals(true, strongNumber.checkStrongNumber(145), MESSAGE);
        assertEquals(true, strongNumber.checkStrongNumber(2), MESSAGE);
        assertEquals(true, strongNumber.checkStrongNumber(40585), MESSAGE);
    }

    @Test
    public void givenZeroThenReturnFalse() {
        assertEquals(false, strongNumber.checkStrongNumber(0), MESSAGE);
    }

    @Test
    public void givenPositiveIntegerNotStrongNumberThenReturnFalse() {
        assertEquals(false, strongNumber.checkStrongNumber(24), MESSAGE);
        assertEquals(false, strongNumber.checkStrongNumber(154), MESSAGE);
    }

}

