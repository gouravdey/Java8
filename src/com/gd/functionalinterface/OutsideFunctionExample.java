package com.gd.functionalinterface;

public class OutsideFunctionExample {

    public static void main(String[] args) {
        System.out.println(performConcat("Hello"));
    }

    public static String performConcat(String str) {
        return FunctionExample.toUpperCaseAndConcatFunction.apply(str);
    }
}
