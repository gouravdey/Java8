package com.gd.streamterminaloperations;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupingByExample {

    public static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("groupStudentsByGender: " + groupStudentsByGender());
        System.out.println();
        System.out.println("customizedGroupStudentsByGPA: " + customizedGroupStudentsByGPA());
        System.out.println();
        System.out.println("twoLevelGrouping1: " + twoLevelGrouping1());
        System.out.println();
        System.out.println("twoLevelGrouping2: " + twoLevelGrouping2());
        System.out.println();
        System.out.println("threeArgumentGroupBy: " + threeArgumentGroupBy());
        System.out.println();
        System.out.println("calculateTopGpa: " + calculateTopGpa());
        System.out.println();
        System.out.println("calculateTopGpaWithoutOptional: " + calculateTopGpaWithoutOptional());
        System.out.println();
        System.out.println("calculateLeastGpaWithoutOptional: " + calculateLeastGpaWithoutOptional());
        System.out.println();
    }

    public static Map<String, List<Student>> groupStudentsByGender() {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }

    public static Map<String, List<Student>> customizedGroupStudentsByGPA() {
        return studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.9 ? "OUTSTANDING" : "AVERAGE"));
    }

    public static Map<Integer, Map<String, List<Student>>> twoLevelGrouping1() {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.groupingBy(student -> student.getGpa() >= 3.9 ? "OUTSTANDING" : "AVERAGE")));
    }

    public static Map<String, Integer> twoLevelGrouping2() {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.summingInt(Student::getNoteBooks)));
    }

    public static LinkedHashMap<Integer, Set<Student>> threeArgumentGroupBy() {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        LinkedHashMap::new,
                        Collectors.toSet()));
    }

    public static Map<Integer, Optional<Student>> calculateTopGpa() {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))));
    }

    public static Map<Integer, Student> calculateTopGpaWithoutOptional() {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)
                ));
    }

    public static Map<Integer, Student> calculateLeastGpaWithoutOptional() {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional::get)
                ));
    }
}
