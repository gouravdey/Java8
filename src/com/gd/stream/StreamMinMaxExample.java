package com.gd.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 10, 9, 5, 17, 11);
        List<Integer> emptyList = new ArrayList<>();

        System.out.println(findMaxValueIncorrect(integerList));
        System.out.println(findMaxValueIncorrect(emptyList));

        if (findMaxValueOptional(integerList).isPresent()) {
            System.out.println(findMaxValueOptional(integerList).get());
        }
        if (findMaxValueOptional(emptyList).isPresent()) {
            System.out.println(findMaxValueOptional(emptyList).get());
        }

        System.out.println(findMinValueIncorrect(integerList));
        System.out.println(findMinValueIncorrect(emptyList));

        if (findMinValueOptional(integerList).isPresent()) {
            System.out.println(findMinValueOptional(integerList).get());
        }
        if (findMinValueOptional(emptyList).isPresent()) {
            System.out.println(findMinValueOptional(emptyList).get());
        }
    }

    public static Integer findMaxValueIncorrect(List<Integer> integers) {
        return integers.stream()
                .reduce(0, (i, j) -> (i > j) ? i : j);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integers) {
        return integers.stream()
                .reduce((i, j) -> (i > j) ? i : j);
    }

    public static Integer findMinValueIncorrect(List<Integer> integers) {
        return integers.stream()
                .reduce(Integer.MAX_VALUE, (i, j) -> (i < j) ? i : j);
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integers) {
        return integers.stream()
                .reduce((i, j) -> (i < j) ? i : j);
    }
}
