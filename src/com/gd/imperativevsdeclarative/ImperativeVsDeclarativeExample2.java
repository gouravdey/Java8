package com.gd.imperativevsdeclarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeVsDeclarativeExample2 {

    /**
     * Remove duplicates from a list of integers
     */

    public static void main(String[] args) {

        List<Integer> inputList = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9, 10);

        /**
         * Imperative Style Example
         */
        List<Integer> outputListImperative = new ArrayList<>();

        for (Integer i : inputList) {
            if (!outputListImperative.contains(i)) {
                outputListImperative.add(i);
            }
        }

        System.out.println("outputListImperative: " + outputListImperative);

        /**
         * Declarative Style Example
         */
        List<Integer> outputListDeclarative = inputList.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("outputListDeclarative: " + outputListDeclarative);
    }
}
