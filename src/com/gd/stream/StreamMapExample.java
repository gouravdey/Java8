package com.gd.stream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {

    public static void main(String[] args) {
        System.out.println(nameList());
        System.out.println(nameSet());
    }

    private static List<String> nameList() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private static Set<String> nameSet() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }
}
