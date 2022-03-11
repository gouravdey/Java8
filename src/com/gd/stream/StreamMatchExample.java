package com.gd.stream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;

public class StreamMatchExample {

    private static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {

        System.out.println(studentAllMatch(3.9));
        System.out.println(studentAllMatch(1.0));
        System.out.println();

        System.out.println(studentAnyMatch(3.6));
        System.out.println(studentAnyMatch(4.8));
        System.out.println();

        System.out.println(studentNoneMatch(3.6));
        System.out.println(studentNoneMatch(4.8));
        System.out.println();
    }

    public static boolean studentAllMatch(Double filterGPA) {
        return studentList.stream()
                .allMatch(student -> student.getGpa() >= filterGPA);
    }

    public static boolean studentAnyMatch(Double filterGPA) {
        return studentList.stream()
                .anyMatch(student -> student.getGpa() >= filterGPA);
    }

    public static boolean studentNoneMatch(Double filterGPA) {
        return studentList.stream()
                .noneMatch(student -> student.getGpa() >= filterGPA);
    }
}
