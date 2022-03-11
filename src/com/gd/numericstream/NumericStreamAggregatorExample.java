package com.gd.numericstream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregatorExample {
    public static void main(String[] args) {

        IntStream intStream = IntStream.rangeClosed(1, 50);
        System.out.println("sum-Int");
        System.out.println(intStream.sum());
        System.out.println();

        OptionalInt optionalMaxInt = IntStream.rangeClosed(1, 50).max();
        System.out.println("max-Int");
        System.out.println(optionalMaxInt.isPresent() ? optionalMaxInt.getAsInt() : 0);
        System.out.println();

        OptionalLong optionalMinInt = LongStream.rangeClosed(1, 50).min();
        System.out.println("min-Long");
        System.out.println(optionalMinInt.isPresent() ? optionalMinInt.getAsLong() : 0);
        System.out.println();

        OptionalDouble optionalDouble = IntStream.rangeClosed(1, 50).average();
        System.out.println("min-Double");
        System.out.println(optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0);
        System.out.println();
    }
}
