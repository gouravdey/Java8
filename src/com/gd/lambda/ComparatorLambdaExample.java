package com.gd.lambda;

import java.util.Comparator;

public class ComparatorLambdaExample {

    public static void main(String[] args) {

        /**
         * Legacy Style Example
         */
        Comparator<Integer> comparatorLegacy = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 -> o1 == o2; 1 -> o1 > o2; -1 -> o1 < o2
            }
        };

        System.out.println("comparatorLegacy1: " + comparatorLegacy.compare(5, 10));
        System.out.println("comparatorLegacy2: " + comparatorLegacy.compare(10, 10));
        System.out.println("comparatorLegacy3: " + comparatorLegacy.compare(10, 5));

        /**
         * Modern Style Example
         */
        Comparator<Integer> comparatorModern = (a, b) -> a.compareTo(b);

        System.out.println("comparatorModern1: " + comparatorModern.compare(5, 10));
        System.out.println("comparatorModern2: " + comparatorModern.compare(10, 10));
        System.out.println("comparatorModern3: " + comparatorModern.compare(10, 5));

    }
}
