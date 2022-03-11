package com.gd.stream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {

    private static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        filterFemaleStudents().forEach(System.out::println);
    }

    private static List<Student> filterFemaleStudents() {
        return studentList.stream()
                .filter(student -> student.getGender().equals("female"))
//                .filter(student -> student.getGpa() > 3.9)
                .collect(Collectors.toList());
    }
}
