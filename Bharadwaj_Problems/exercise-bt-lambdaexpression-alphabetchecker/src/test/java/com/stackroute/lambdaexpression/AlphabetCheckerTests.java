package com.stackroute.lambdaexpression;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlphabetCheckerTests {
    private AlphabetChecker alphabetChecker;

    private static final String MESSAGE = "Check the logic of your method checkAlphabets";
    private static final String CORRECT_MESSAGE = "Given list contains only alphabet strings";
    private static final String INCORRECT_MESSAGE = "Given list contains non alphabet strings";
    private static final String PROPER_MESSAGE = "Give proper input not empty list";

    @BeforeEach
    public void setUp() {
        alphabetChecker = new AlphabetChecker();
    }

    @AfterEach
    public void tearDown() {
        alphabetChecker = null;
    }

    @Test
    public void givenInputWithAlphabetCharactersStringsThenReturnResult() {
        List<String> inputList = Arrays.asList("Java", "Programming", "Coding", "World");
        assertEquals(CORRECT_MESSAGE, alphabetChecker.checkAlphabets(inputList), MESSAGE);
    }

    @Test
    public void givenInputWithDigitCharactersThenReturnResult() {
        List<String> inputList = Arrays.asList("Java", "1", "Coding");
        assertEquals(INCORRECT_MESSAGE, alphabetChecker.checkAlphabets(inputList), MESSAGE);
    }

    @Test
    public void givenInputWithWhiteSpaceStringsThenReturnResult() {
        List<String> inputList = Arrays.asList("Java Programming", "World");
        assertEquals(INCORRECT_MESSAGE, alphabetChecker.checkAlphabets(inputList), MESSAGE);
    }

    @Test
    public void givenInputWithSpecialCharactersThenReturnResult() {
        List<String> inputList = Arrays.asList("Java*$", "Code!!!");
        assertEquals(INCORRECT_MESSAGE, alphabetChecker.checkAlphabets(inputList), MESSAGE);
    }

    @Test
    public void givenInputWithEmptyListThenReturnErrorString() {
        List<String> inputList = Arrays.asList();
        assertEquals(PROPER_MESSAGE, alphabetChecker.checkAlphabets(inputList), MESSAGE);
    }

    @Test
    public void givenInputStringThenReturnNotNull() {
        List<String> inputList = Arrays.asList("Welocome!!", "-4", "Hello");
        assertNotNull(alphabetChecker.checkAlphabets(inputList), MESSAGE);
    }
}
