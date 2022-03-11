package com.gd.numericstream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangeExample {

    public static void main(String[] args) {

        IntStream intStreamRange = IntStream.range(1, 50);
        IntStream intStreamRangeClosed = IntStream.rangeClosed(1, 50);

        System.out.println(intStreamRange.count());
        System.out.println(intStreamRangeClosed.count());

        System.out.println("intStreamRange:");
        IntStream.range(1, 50).forEach(value -> System.out.print(value + ", "));
        System.out.println();

        System.out.println("intStreamRangeClosed:");
        IntStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ", "));
        System.out.println();

        System.out.println("longStreamRange:");
        LongStream.range(1, 50).forEach(value -> System.out.print(value + ", "));
        System.out.println();

        System.out.println("longStreamRangeClosed:");
        LongStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ", "));
        System.out.println();

        System.out.println("doubleStreamRange:");
        IntStream.range(1, 50).asDoubleStream().forEach(value -> System.out.print(value + ", "));
        System.out.println();

        System.out.println("doubleStreamRangeClosed:");
        IntStream.rangeClosed(1, 50).asDoubleStream().forEach(value -> System.out.print(value + ", "));
        System.out.println();
    }
}
