package com.gd.stream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamComparatorExample {

    static List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("sortStudentsByName");
        sortStudentsByName().forEach(System.out::println);
        System.out.println();
        System.out.println("sortStudentsByGPA");
        sortStudentsByGPA().forEach(System.out::println);
        System.out.println();
        System.out.println("sortStudentsByGPADescending");
        sortStudentsByGPADescending().forEach(System.out::println);
        System.out.println();
    }

    public static List<Student> sortStudentsByName() {
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGPA() {
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGPADescending() {
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
}
