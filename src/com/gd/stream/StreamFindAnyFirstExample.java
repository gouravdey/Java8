package com.gd.stream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.Optional;

public class StreamFindAnyFirstExample {

    private static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {

        if (findAnyStudent().isPresent()) {
            System.out.println(findAnyStudent().get());
        }

        if (findFirstStudent().isPresent()) {
            System.out.println(findFirstStudent().get());
        }
    }

    public static Optional<Student> findAnyStudent() {
        return studentList.stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();
    }

    public static Optional<Student> findFirstStudent() {
        return studentList.stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }
}
