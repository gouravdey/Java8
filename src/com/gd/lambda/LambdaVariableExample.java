package com.gd.lambda;

import java.util.function.Consumer;

public class LambdaVariableExample {

    static int instanceValue = 5;

    public static void main(String[] args) {
        int localValue = 4;
        Consumer<Integer> consumer1 = (i) -> {
            i++;
            System.out.println(localValue + i);
        };
        consumer1.accept(10);

        Consumer<Integer> consumer2 = (i) -> {
            instanceValue++;
            i++;
            System.out.println(instanceValue + i);
        };
        consumer2.accept(10);
    }
}
