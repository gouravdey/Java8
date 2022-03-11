package com.gd.numericstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

    public static void main(String[] args) {
        System.out.println("Boxing: " + boxingInteger());

        System.out.println("Unboxing: " + unboxingInteger(boxingInteger()));
    }

    public static List<Integer> boxingInteger() {
        return IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int unboxingInteger(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
