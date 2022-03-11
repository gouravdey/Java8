package com.gd.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsVsStreams {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Jim");
        names.add("Adam");
        names.add("Jenny");

        System.out.println(names);

        names.remove(0);

        System.out.println(names);

//        Collections can be traversed multiple times
        for (int i = 0; i < 3; i++) {
            for (String name : names) {
                System.out.println(name);
            }
        }

//        Streams can be traversed only once.
        Stream<String> nameString = names.stream();
        nameString.forEach(System.out::println);
        nameString.forEach(System.out::println);

    }
}
