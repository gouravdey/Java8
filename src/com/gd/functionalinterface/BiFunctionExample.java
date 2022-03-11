package com.gd.functionalinterface;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    static List<Student> studentList = StudentDatabase.getAllStudents();

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> listPredicateMapBiFunction = (studentList, studentPredicate) -> {
        Map<String, Double> studentGradeMap = new HashMap<>();

        studentList.forEach(student -> {
            if (studentPredicate.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });

        return studentGradeMap;
    };

    public static void main(String[] args) {
        System.out.println(listPredicateMapBiFunction.apply(studentList, PredicateExample.studentWithHighGradePredicate));
    }
}
