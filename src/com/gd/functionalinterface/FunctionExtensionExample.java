package com.gd.functionalinterface;


import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class FunctionExtensionExample {

    static UnaryOperator<String> stringUnaryOperator = (str) -> str.concat(" Dey");
    static BinaryOperator<Integer> multiplyIntegerBinaryOperator = (num1, num2) -> num1 * num2;

    static Comparator<Integer> integerComparator = (num1, num2) -> num1.compareTo(num2);
    static BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(integerComparator);
    static BinaryOperator<Integer> minBy = BinaryOperator.minBy(integerComparator);

    public static void main(String[] args) {
        System.out.println(stringUnaryOperator.apply("Gourav"));
        System.out.println(multiplyIntegerBinaryOperator.apply(10, 5));
        System.out.println("maxBy: " + maxBy.apply(10, 20));
        System.out.println("minBy: " + minBy.apply(10, 20));
    }

}
