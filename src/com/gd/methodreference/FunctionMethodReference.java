package com.gd.methodreference;

import java.util.function.Function;

public class FunctionMethodReference {

    static Function<String, String> toUpperCaseLambda = (str) -> str.toUpperCase();
    static Function<String, String> toUpperCaseMethodReference = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(toUpperCaseLambda.apply("Gourav"));
        System.out.println(toUpperCaseMethodReference.apply("Gourav"));
    }
}
