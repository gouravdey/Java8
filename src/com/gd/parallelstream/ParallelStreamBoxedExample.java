package com.gd.parallelstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamBoxedExample {

    public static void main(String[] args) {
        List<Integer> collect = IntStream.rangeClosed(1, 10000)
                .boxed()
                .collect(Collectors.toList());

        parallelSum(collect);
        sequentialSum(collect);

    }

    public static int sequentialSum(List<Integer> integers) {
        Long startTime = System.currentTimeMillis();
        int sum = integers.stream()
                .reduce(0, (x, y) -> x + y);
        Long endTime = System.currentTimeMillis();
        System.out.println("sequentialSum duration: " + (endTime - startTime));
        return sum;
    }

    public static int parallelSum(List<Integer> integers) {
        Long startTime = System.currentTimeMillis();
        int sum = integers.stream()
                .reduce(0, (x, y) -> x + y);
        Long endTime = System.currentTimeMillis();
        System.out.println("parallelSum duration: " + (endTime - startTime));
        return sum;
    }
}
