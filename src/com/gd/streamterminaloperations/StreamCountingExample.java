package com.gd.streamterminaloperations;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamCountingExample {

    public static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("counting: " + counting());
    }

    private static Long counting() {
        return studentList.stream()
                .filter(student -> student.getGpa() >= 3.9)
                .collect(Collectors.counting());
    }
}
