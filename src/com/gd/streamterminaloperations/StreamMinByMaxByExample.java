package com.gd.streamterminaloperations;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMinByMaxByExample {

    public static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("minBy: " + minBy());
        System.out.println("maxBy: " + maxBy());
    }

    public static Optional<Student> minBy() {
        return studentList.stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> maxBy() {
        return studentList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }
}
