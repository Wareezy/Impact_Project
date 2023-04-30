package Implementation;

import Interface.NumberRangeSummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {
    /*This is a method declaration.
    The @Override annotation indicates that this method is intended to override a method from a superclass or interface.
    The method is named collect, and it takes a single parameter of type String named input.
    The return type of the method is Collection<Integer>, which means that it will return a collection of integers.*/
    @Override
    public Collection<Integer> collect(String input) {





        /*This line declares a new ArrayList of integers and assigns it to the variable numbers.
        The ArrayList is a type of List, which means that it is an ordered collection that can contain duplicate elements.*/
        List<Integer> numbers = new ArrayList<>();




/*This line splits the input string into an array of substrings using a comma as the delimiter.
         The resulting array is assigned to the variable tokens.*/
        String[] tokens = input.split(",");




/*This line begins a for loop that iterates over each element in the tokens array.
        The loop variable token is declared as a String and takes on the value of each element in the array in turn.*/
        for (String token : tokens) {



/*This block of code attempts to parse each token as an integer using the parseInt method of the Integer class.
If the parse is successful, the resulting integer is added to the numbers list using the add method.
If the parse fails due to an invalid format, the NumberFormatException is caught and the invalid token is ignored.*/
            try {
                int number = Integer.parseInt(token.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                // Ignore invalid tokens
            }
        }


        /*This line ends the for loop and returns the numbers list as the result of the collect method.*/
        return numbers;
    }



    //This is an annotation that indicates that the following method overrides a method in a superclass or interface.
    @Override



    /*This is a method signature that declares a public method named
    summarizeCollection, which takes a single argument of type Collection<Integer> and returns a String.*/
    public String summarizeCollection(Collection<Integer> input) {



        /*This line creates a new ArrayList called sortedNumbers and initializes it with the elements of the input Collection.
                 The ArrayList is used instead of the original Collection to allow for sorting of the elements
               */
        List<Integer> sortedNumbers = new ArrayList<>(input);/*





        /*This line sorts the elements in the sortedNumbers list in ascending order using the Collections.sort() method.*/
        Collections.sort(sortedNumbers);


        // Group the numbers into ranges
        /*This line creates a new ArrayList called ranges that will hold the ranges of numbers.*/
        List<String> ranges = new ArrayList<>();

        /*This line sets the rangeStart variable to the first number in the sorted list.*/
        int rangeStart = sortedNumbers.get(0);

        /*This line sets the prevNumber variable to rangeStart.*/
        int prevNumber = rangeStart;

        /*This line starts a loop that iterates through each number in the sorted list, except for the first number.*/
        for (int i = 1; i < sortedNumbers.size(); i++) {


            /* This line gets the current number in the sorted list.*/
            int number = sortedNumbers.get(i);


            /* This line checks if the current number is not one greater than the previous number.
             If it isn't, that means we've reached the end of a range.*/
            if (number != prevNumber + 1) {


              /*This line checks if the range consists of a single number.
               If it does, we add that number to the ranges list.*/
                if (rangeStart == prevNumber) {


                    /*This line adds the range start to the ranges list as a String.*/
                    ranges.add(Integer.toString(rangeStart));


                  /*This line is the alternative to the if statement in line 7.
                  If the range consists of more than one number, we add a string representing the range to the ranges list.*/
                } else {

                 /*This line adds a string representing the range to the ranges list.
                  The string includes the range start, a dash, and the previous number.*/
                    ranges.add(rangeStart + "-" + prevNumber);
                }

                /*This line sets the new range start to the current number.*/
                rangeStart = number;
            }

            /*This line updates the prevNumber variable to the current number.*/
            prevNumber = number;
        }
        // Handle the last range

        /* This line checks if the last range consists of a single number.
        If it does, we add that number to the ranges list.*/
        if (rangeStart == prevNumber) {


            /*This line adds the last range start to the ranges list as a String.*/
            ranges.add(Integer.toString(rangeStart));

          /*This line is the alternative to the if statement in line 15.
           If the last range consists of more than one number, we add a string representing the range to the ranges list.*/
        } else {


            /*This line adds a string representing the last range to the ranges list.
            The string includes the last range start, a dash, and the last number.*/
            ranges.add(rangeStart + "-" + prevNumber);
        }

        // Join the ranges into a comma-delimited string

        /*This line returns a comma-delimited String that summarizes the ranges in the ranges list*/
        return String.join(",", ranges);
    }

}
