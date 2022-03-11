package com.gd.functionalinterface;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    static List<Student> studentList = StudentDatabase.getAllStudents();

    static BiConsumer<String, List<String>> studentNameAndActivitiesBiConsumer = (name, activities) -> System.out.println(name + " => " + activities);

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a: " + a + ", b: " + b);
        };
        biConsumer.accept("Gourav", "Dey");

        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("Multiplication: " + a * b);
        };

        BiConsumer<Integer, Integer> divide = (a, b) -> {
            System.out.println("Division: " + a / b);
        };
//        multiply.accept(10, 5);
//        divide.accept(10, 5);
        multiply.andThen(divide).accept(10, 5);
        System.out.println();

        studentNameAndActivities();
    }

    public static void studentNameAndActivities() {
        studentList.forEach((student) -> studentNameAndActivitiesBiConsumer.accept(student.getName(), student.getActivities()));
    }
}
