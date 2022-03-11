package com.gd.parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        System.out.println("sumSequentialStream: " + checkPerformanceResult(ParallelStreamExample::sumSequentialStream, 20));
        System.out.println("sumParallelStream: " + checkPerformanceResult(ParallelStreamExample::sumParallelStream, 20));
    }

    public static Integer sumSequentialStream() {
        return IntStream.rangeClosed(1, 100000)
                .sum();
    }

    public static Integer sumParallelStream() {
        return IntStream.rangeClosed(1, 100000)
                .parallel()
                .sum();
    }

    public static Long checkPerformanceResult(Supplier<Integer> supplier, Integer numberOfTimes) {

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfTimes; i++) {
            supplier.get();
        }
        Long endTime = System.currentTimeMillis();

        return (endTime - startTime);
    }
}
