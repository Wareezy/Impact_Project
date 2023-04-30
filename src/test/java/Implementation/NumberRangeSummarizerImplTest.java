package Implementation;

import Interface.NumberRangeSummarizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerImplTest {
    /*This line creates a new instance of the NumberRangeSummarizerImpl class and assigns it to the summarizer variable.*/
    private NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();


  /*The purpose of this test case is to ensure that the
   collect method of the NumberRangeSummarizer interface correctly converts a comma-delimited String of integers into a collection of Integer objects.
   If the test case passes, it means that the method is working as expected for this input.*/
    @Test
    void testCollect() {

        /* This line creates a String variable called input that contains a comma-delimited list of integers*/
        String input = "1, 2, 3, 4, 5";

       /*This line creates a Collection of Integer objects called expected that contains the integers in the input String.*/
        Collection<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        /*This line calls the collect method of the summarizer object and passes in the input String.
         The resulting collection of Integer objects is assigned to the actual variable.*/
        Collection<Integer> actual = summarizer.collect(input);

        /* This line verifies that the expected collection is equal to the actual collection.
        If they are not equal, the test case will fail.*/
        assertEquals(expected, actual);
    }

    @Test
    void testSummarizeCollection() {

        /*This line creates a List of Integer objects called input that contains a mixture of consecutive and non-consecutive integers.*/
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 8, 9, 10, 11, 15);


        /* This line creates a String variable called expected that contains the expected output of the summarizeCollection method for the input collection*/
        String expected = "1-5,8-11,15";

        /*This line calls the summarizeCollection method of the summarizer object and passes in the input collection.
        The resulting string representation of the ranges of consecutive numbers is assigned to the actual variable.*/
        String actual = summarizer.summarizeCollection(input);

        /*This line verifies that the expected string is equal to the actual string.
        If they are not equal, the test case will fail.*/
        assertEquals(expected, actual);
    }

    @Test
    void testSummarizeCollectionWithSingleNumber() {

        /*This line creates a List of Integer objects called input that contains a single integer*/
        List<Integer> input = Arrays.asList(1);

       /* This line creates a String variable called expected that contains the expected output of the summarizeCollection method for the input collection.*/
        String expected = "1";

        /*This line calls the summarizeCollection method of the summarizer object and passes in the input collection.
        The resulting string representation of the ranges of consecutive numbers is assigned to the actual variable*/
        String actual = summarizer.summarizeCollection(input);

        /*This line verifies that the expected string is equal to the actual string.
        If they are not equal, the test case will fail.*/
        assertEquals(expected, actual);
    }

    @Test
    void testSummarizeCollectionWithDuplicateNumbers() {

        /*This line creates a List of Integer objects called input that contains several duplicate integers.*/
        List<Integer> input = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);

/*This line creates a String variable called expected that contains the expected output of the summarizeCollection method for the input collection.*/
        String expected = "1-5";

        /*This line calls the summarizeCollection method of the summarizer object and passes in the input collection. The resulting string representation of the ranges of consecutive numbers is assigned to the actual variable*/
        String actual = summarizer.summarizeCollection(input);

        /*This line verifies that the expected string is equal to the actual string.
         If they are not equal, the test case will fail.*/
        assertEquals(expected, actual);
    }




}