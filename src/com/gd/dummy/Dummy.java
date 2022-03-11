package com.gd.dummy;

import java.util.function.*;

public class Dummy {
    public static void main(String[] args) {
        Function<String, String> addSomeString = (name) -> name.toUpperCase().concat(" Dey");
        System.out.println(addSomeString.apply("Gourav"));

        Predicate<String> nameStartsWith = (name) -> name.startsWith("G");
        System.out.println(nameStartsWith.test("Gourav"));
        System.out.println(nameStartsWith.test("Sourav"));

        BiPredicate<Integer, Integer> compareNums = Integer::equals;
        System.out.println(compareNums.test(10, 6));

        Supplier<Integer> supplier = () -> 500;
        System.out.println(supplier.get());

        Consumer<Integer> consumer = (num) -> {
            int num2 = num * 100;
            System.out.println(num2);
        };
        consumer.accept(6);
    }
}
