package com.gd.imperativevsdeclarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample1 {

    /**
     * Find sum of 100 numbers from 0 to 100
     */

    public static void main(String[] args) {

        /**
         * Imperative Style Example
         */
        int sumImperative = 0;
        for (int i = 0; i <= 100; i++) {
            sumImperative += i;
        }
        System.out.println("sumImperative: " + sumImperative);

        /**
         * Declarative Style Example
         */
        int sumDeclarative = IntStream.rangeClosed(0, 100)
//                .parallel()
                .sum();
        System.out.println("sumDeclarative: " + sumDeclarative);
    }

}
