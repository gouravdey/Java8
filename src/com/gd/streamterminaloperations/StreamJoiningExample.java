package com.gd.streamterminaloperations;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamJoiningExample {

    public static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("joining1: " + joining1());
        System.out.println("joining2: " + joining2());
        System.out.println("joining3: " + joining3());
    }

    public static String joining1() {
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }

    public static String joining2() {
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
    }

    public static String joining3() {
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "(", ")"));
    }
}
