package com.gd.stream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFlatMapExample {

    public static void main(String[] args) {
        System.out.println("getListOfStudentActivities");
        System.out.println(getListOfStudentActivities());
        System.out.println();
        System.out.println("getSetOfStudentActivities");
        System.out.println(getSetOfStudentActivities());
        System.out.println();
        System.out.println("getCountOfStudentActivities");
        System.out.println(getCountOfStudentActivities());
        System.out.println();
        System.out.println("getSortedListOfStudentActivities");
        System.out.println(getSortedListOfStudentActivities());
    }

    public static List<String> getListOfStudentActivities() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Set<String> getSetOfStudentActivities() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }

    public static Long getCountOfStudentActivities() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static List<String> getSortedListOfStudentActivities() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
