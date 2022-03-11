package com.gd.functionalinterface;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionExample {

    static List<Student> studentList = StudentDatabase.getAllStudents();

    static Function<String, String> toUpperCaseFunction = (name) -> name.toUpperCase();
    static Function<String, String> toUpperCaseAndConcatFunction = (name) -> name.toUpperCase().concat(" Dey");

    static Function<List<Student>, Map<String, Double>> StudentListMapFunction = (students) -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if (PredicateExample.studentWithHighGradePGPA.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    };

    public static void main(String[] args) {
        System.out.println(toUpperCaseFunction.apply("Gourav"));
        System.out.println(toUpperCaseFunction.andThen(toUpperCaseAndConcatFunction).apply("Gourav"));
        System.out.println(toUpperCaseFunction.compose(toUpperCaseAndConcatFunction).apply("Gourav"));

        System.out.println(StudentListMapFunction.apply(studentList));
    }
}
