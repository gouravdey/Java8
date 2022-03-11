package com.gd.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkipExample {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6, 7, 8, 10, 9, 5, 17, 11);

        if (limitInteger(integers).isPresent()) {
            System.out.println(limitInteger(integers).get());
        }

        if (skipInteger(integers).isPresent()) {
            System.out.println(skipInteger(integers).get());
        }
    }

    public static Optional<Integer> limitInteger(List<Integer> integerList) {
        return integerList.stream()
                .limit(3)
                .reduce(Integer::sum);
    }

    public static Optional<Integer> skipInteger(List<Integer> integerList) {
        return integerList.stream()
                .skip(3)
                .reduce(Integer::sum);
    }
}
