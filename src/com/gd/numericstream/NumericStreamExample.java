package com.gd.numericstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamExample {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(sumOfNumbers(integers));
        System.out.println(sumOfNumbersIntStream());
    }

    public static Integer sumOfNumbers(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (x, y) -> x + y);
    }

    public static Integer sumOfNumbersIntStream() {
        return IntStream.rangeClosed(1, 6)
                .sum();
    }


}
