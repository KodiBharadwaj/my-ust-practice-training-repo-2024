package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FileOperationUsingStreamsTests {

    private static final String MESSAGE_ONE = "Given the file name should return the word count without duplicates";
    private static final String MESSAGE_TWO = "Given the file name should return list of words without duplicates";
    private static final String MESSAGE_THREE = "Given file name should return list of words in uppercase excluding the first line";
    private static final String MESSAGE_FOUR = "Given file name should return the string where each word is separated by colon";
    private static final String MESSAGE_FIVE = "Given file name should return the string where eah line is separated by comma";
    private static final String MESSAGE_SIX = "Given file name should return maximum of the integer value available";
    private static final String MESSAGE_SEVEN = "Given file name should return sum of the integer values available";
    private static final String MESSAGE_EIGHT = "Given Invalid file name or extension should return zero word count";
    private static final String MESSAGE_NINE = "Given Invalid file name should return empty list or empty set";
    private static final String MESSAGE_TEN = "Given Invalid file name should return empty optional";
    private static final String MESSAGE_ELEVEN = "Given Invalid file name should return null string value";
    private static final String MESSAGE_TWELVE = "Given file with no integers should return empty optional";

    private FileOperationsUsingStreams fileOPerationsUsingStreams;

    @BeforeEach
    public void setUp() {
        fileOPerationsUsingStreams = new FileOperationsUsingStreams();
    }

    @AfterEach
    public void tearDown() {
        fileOPerationsUsingStreams = null;
    }

    @Test
    public void givenExistingFileNameThenReturnWordCountWithoutDuplicates() throws IOException {
        assertEquals(18, fileOPerationsUsingStreams.getUniqueWordCount("sample.txt"), MESSAGE_ONE);
    }

    @Test
    public void givenNonExistingFileNameThenReturnZeroWordCount() throws IOException {
        assertEquals(0, fileOPerationsUsingStreams.getUniqueWordCount("sample1.txt"), MESSAGE_EIGHT);
        assertEquals(0, fileOPerationsUsingStreams.getUniqueWordCount(""), MESSAGE_EIGHT);
        assertEquals(0, fileOPerationsUsingStreams.getUniqueWordCount("  "), MESSAGE_EIGHT);
    }

    @Test
    public void givenFileNameWithInvalidExtensionThenReturnZeroWordCount() throws IOException {
        assertEquals(0, fileOPerationsUsingStreams.getUniqueWordCount("sample.csv"), MESSAGE_EIGHT);
    }

    @Test
    public void givenExistingFileNameThenReturnWordsWithoutDuplicates() throws IOException {
        Set<String> words = fileOPerationsUsingStreams.getWordListWithoutDuplicates("sample.txt");
        assertThat(MESSAGE_TWO, words.size(), is(18));
    }

    @Test
    public void givenNonExistingFileNameThenReturnEmptySet() throws IOException {
        Set<String> words = fileOPerationsUsingStreams.getWordListWithoutDuplicates("sample1.txt");
        assertThat(MESSAGE_NINE, words.size(), is(0));
        words = fileOPerationsUsingStreams.getWordListWithoutDuplicates("  ");
        assertThat(MESSAGE_NINE, words.size(), is(0));
        words = fileOPerationsUsingStreams.getWordListWithoutDuplicates("");
        assertThat(MESSAGE_NINE, words.size(), is(0));
    }

    @Test
    public void givenExistingFileNameThenReturnWordListInUppercaseExcludingFirstLine() throws IOException {
        List<String> wordList = fileOPerationsUsingStreams.getWordListInUppercaseExcludingFirstLine("sample.txt");
        assertThat(MESSAGE_THREE, wordList.size(), is(19));
    }

    @Test
    public void givenNonExistingFileNameThenReturnEmptyList() throws IOException {
        List<String> words = fileOPerationsUsingStreams.getWordListInUppercaseExcludingFirstLine("sample1.txt");
        assertThat(MESSAGE_NINE, words.size(), is(0));
        words = fileOPerationsUsingStreams.getWordListInUppercaseExcludingFirstLine("  ");
        assertThat(MESSAGE_NINE, words.size(), is(0));
        words = fileOPerationsUsingStreams.getWordListInUppercaseExcludingFirstLine("");
        assertThat(MESSAGE_NINE, words.size(), is(0));
    }

    @Test
    public void givenExistingFileNameThenReturnEachWordSeparatedByColon() throws IOException {
        String actual = fileOPerationsUsingStreams.getEachWordsSeparatedByColon("sample.txt");
        String expected = "Test:file:for:counting:words:5:Each:line:contains:many:words:5:Distinct:Words:are:counted:4:Each:line:are:scanned:for:extracting:words:7";
        assertEquals(expected, actual, MESSAGE_FOUR);
    }

    @Test
    public void givenNonExistingFileNameThenReturnNullStringValue() throws IOException {
        assertNull(fileOPerationsUsingStreams.getEachWordsSeparatedByColon("sample1.txt"), MESSAGE_ELEVEN);
        assertNull(fileOPerationsUsingStreams.getEachWordsSeparatedByColon("  "), MESSAGE_ELEVEN);
        assertNull(fileOPerationsUsingStreams.getEachWordsSeparatedByColon(""), MESSAGE_ELEVEN);
    }

    @Test
    public void givenExistingFileNameThenReturnEachLineSeparatedByComma() throws IOException {
        String actual = fileOPerationsUsingStreams.getEachLineSeparatedByComma("sample.txt");
        String expected = "Test file for counting words 5,Each line contains many words 5,Distinct Words are counted 4,Each line are scanned for extracting words 7";
        assertEquals(expected, actual, MESSAGE_FIVE);
    }

    @Test
    public void givenNonExistingFileNameThenReturnNullStringResult() throws IOException {
        assertNull(fileOPerationsUsingStreams.getEachLineSeparatedByComma("sample1.txt"), MESSAGE_ELEVEN);
        assertNull(fileOPerationsUsingStreams.getEachLineSeparatedByComma("  "), MESSAGE_ELEVEN);
        assertNull(fileOPerationsUsingStreams.getEachLineSeparatedByComma(""), MESSAGE_ELEVEN);
    }

    @Test
    public void givenExistingFileNameThenReturnMaxOfIntegers() throws IOException {
        assertEquals(7, fileOPerationsUsingStreams.getMaxOfIntegers("sample.txt").get(), MESSAGE_SIX);
    }

    @Test
    public void givenExistingFileNameWhenIntegersAreAbsentThenReturnEmptyOptional() throws IOException {
        assertThat(MESSAGE_TWELVE, fileOPerationsUsingStreams.getMaxOfIntegers("data.txt"), is(Optional.empty()));
    }

    @Test
    public void givenNonExistingFileNameThenReturnEmptyOptional() throws IOException {
        assertThat(MESSAGE_TEN, fileOPerationsUsingStreams.getMaxOfIntegers("sample1.txt"), is(Optional.empty()));
        assertThat(MESSAGE_TEN, fileOPerationsUsingStreams.getMaxOfIntegers("  "), is(Optional.empty()));
        assertThat(MESSAGE_TEN, fileOPerationsUsingStreams.getMaxOfIntegers(""), is(Optional.empty()));
    }

    @Test
    public void givenExistingFileNameThenReturnSumOfIntegers() throws IOException {
        assertEquals(21, fileOPerationsUsingStreams.getSumOfIntegers("sample.txt").get(), MESSAGE_SEVEN);
    }

    @Test
    public void givenExistingFileNameWhenIntegersAreAbsentThenReturnEmptyOptionalResult() throws IOException {
        assertThat(MESSAGE_TWELVE, fileOPerationsUsingStreams.getSumOfIntegers("data.txt"), is(Optional.empty()));
    }

    @Test
    public void givenNonExistingFileNameThenReturnEmptyOptionalResult() throws IOException {
        assertThat(MESSAGE_TEN, fileOPerationsUsingStreams.getSumOfIntegers("sample1.txt"), is(Optional.empty()));
        assertThat(MESSAGE_TEN, fileOPerationsUsingStreams.getSumOfIntegers("  "), is(Optional.empty()));
        assertThat(MESSAGE_TEN, fileOPerationsUsingStreams.getSumOfIntegers(""), is(Optional.empty()));
    }

}
